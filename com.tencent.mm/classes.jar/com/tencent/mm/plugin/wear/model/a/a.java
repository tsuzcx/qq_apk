package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class a
  implements b
{
  private GoogleApiClient Wjb;
  
  public a()
  {
    AppMethodBeat.i(30038);
    this.Wjb = new GoogleApiClient.Builder(MMApplicationContext.getContext()).addApi(Wearable.API).build();
    AppMethodBeat.o(30038);
  }
  
  public final b.a E(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30043);
    Object localObject = inY();
    b.a locala = new b.a();
    Iterator localIterator = ((HashSet)localObject).iterator();
    String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!inX().isConnected())
      {
        localObject = new b.a((byte)0);
        label70:
        if (((b.a)localObject).code == 0) {
          break label220;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30043);
      return localObject;
      localObject = new b.a();
      Status localStatus = ((MessageApi.SendMessageResult)Wearable.MessageApi.sendMessage(inX(), str, paramString, paramArrayOfByte).await(2L, TimeUnit.SECONDS)).getStatus();
      if (!localStatus.isSuccess())
      {
        ((b.a)localObject).code = 131072;
        ((b.a)localObject).errMsg = localStatus.getStatusMessage();
        Log.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(localStatus.getStatusCode()), localStatus.getStatusMessage() });
      }
      if (paramArrayOfByte == null) {}
      for (int i = 0;; i = paramArrayOfByte.length)
      {
        Log.d("MicroMsg.Wear.GlobalConnection", "send Message %s %s %d", new Object[] { str, paramString, Integer.valueOf(i) });
        break label70;
        label220:
        break;
      }
      localObject = locala;
    }
  }
  
  public final b.a F(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30045);
    if (!inX().isConnected())
    {
      paramString = new b.a((byte)0);
      AppMethodBeat.o(30045);
      return paramString;
    }
    paramString = PutDataMapRequest.create(paramString);
    paramString.getDataMap().putLong("key_timestamp", System.currentTimeMillis());
    paramString.getDataMap().putAsset("key_data", Asset.createFromBytes(paramArrayOfByte));
    paramString = paramString.asPutDataRequest();
    Wearable.DataApi.putDataItem(inX(), paramString);
    Log.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", new Object[] { paramString.getUri().getPath(), Integer.valueOf(paramString.getData().length) });
    paramString = new b.a();
    AppMethodBeat.o(30045);
    return paramString;
  }
  
  public final byte[] a(Asset paramAsset)
  {
    AppMethodBeat.i(30042);
    paramAsset = (DataApi.GetFdForAssetResult)Wearable.DataApi.getFdForAsset(inX(), paramAsset).await();
    Status localStatus = paramAsset.getStatus();
    if (!localStatus.isSuccess())
    {
      Log.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(localStatus.getStatusCode()), localStatus.getStatusMessage() });
      AppMethodBeat.o(30042);
      return null;
    }
    paramAsset = e.readFromStream(paramAsset.getInputStream());
    AppMethodBeat.o(30042);
    return paramAsset;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(30048);
    this.Wjb.disconnect();
    AppMethodBeat.o(30048);
  }
  
  public final void inW()
  {
    AppMethodBeat.i(30040);
    this.Wjb.disconnect();
    inX();
    AppMethodBeat.o(30040);
  }
  
  public final GoogleApiClient inX()
  {
    AppMethodBeat.i(30041);
    if (!this.Wjb.isConnected())
    {
      Log.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
      localObject = this.Wjb.blockingConnect(30L, TimeUnit.SECONDS);
      if (!((ConnectionResult)localObject).isSuccess()) {
        Log.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", new Object[] { Integer.valueOf(((ConnectionResult)localObject).getErrorCode()) });
      }
    }
    Object localObject = this.Wjb;
    AppMethodBeat.o(30041);
    return localObject;
  }
  
  public final HashSet<String> inY()
  {
    AppMethodBeat.i(30044);
    HashSet localHashSet = new HashSet();
    Object localObject = (NodeApi.GetConnectedNodesResult)Wearable.NodeApi.getConnectedNodes(inX()).await();
    if (localObject != null)
    {
      localObject = ((NodeApi.GetConnectedNodesResult)localObject).getNodes().iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add(((Node)((Iterator)localObject).next()).getId());
      }
    }
    AppMethodBeat.o(30044);
    return localHashSet;
  }
  
  public final boolean inZ()
  {
    AppMethodBeat.i(30047);
    if (!inX().isConnected())
    {
      AppMethodBeat.o(30047);
      return false;
    }
    if (inY().size() == 0)
    {
      AppMethodBeat.o(30047);
      return false;
    }
    AppMethodBeat.o(30047);
    return true;
  }
  
  public final void ioa()
  {
    AppMethodBeat.i(30049);
    DataItemBuffer localDataItemBuffer = (DataItemBuffer)Wearable.DataApi.getDataItems(inX()).await();
    Iterator localIterator = localDataItemBuffer.iterator();
    while (localIterator.hasNext())
    {
      DataItem localDataItem = (DataItem)localIterator.next();
      String str = localDataItem.getUri().toString();
      if (str.startsWith("/wechat"))
      {
        Log.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[] { str });
        Wearable.DataApi.deleteDataItems(inX(), localDataItem.getUri());
      }
    }
    localDataItemBuffer.release();
    AppMethodBeat.o(30049);
  }
  
  public final boolean isAvailable()
  {
    AppMethodBeat.i(30039);
    if ((h.aVc()) || (h.aVb()))
    {
      AppMethodBeat.o(30039);
      return true;
    }
    AppMethodBeat.o(30039);
    return false;
  }
  
  public final boolean n(Uri paramUri)
  {
    AppMethodBeat.i(30046);
    Wearable.DataApi.deleteDataItems(inX(), paramUri);
    Log.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[] { paramUri });
    AppMethodBeat.o(30046);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.a
 * JD-Core Version:    0.7.0.1
 */