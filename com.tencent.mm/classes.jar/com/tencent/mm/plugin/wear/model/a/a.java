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
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class a
  implements b
{
  private GoogleApiClient uHy;
  
  public a()
  {
    AppMethodBeat.i(26356);
    this.uHy = new GoogleApiClient.Builder(ah.getContext()).addApi(Wearable.API).build();
    AppMethodBeat.o(26356);
  }
  
  public final b.a B(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26361);
    Object localObject = cYI();
    b.a locala = new b.a();
    Iterator localIterator = ((HashSet)localObject).iterator();
    String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (!cYH().isConnected())
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
      AppMethodBeat.o(26361);
      return localObject;
      localObject = new b.a();
      Status localStatus = ((MessageApi.SendMessageResult)Wearable.MessageApi.sendMessage(cYH(), str, paramString, paramArrayOfByte).await(2L, TimeUnit.SECONDS)).getStatus();
      if (!localStatus.isSuccess())
      {
        ((b.a)localObject).code = 131072;
        ((b.a)localObject).errMsg = localStatus.getStatusMessage();
        ab.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(localStatus.getStatusCode()), localStatus.getStatusMessage() });
      }
      if (paramArrayOfByte == null) {}
      for (int i = 0;; i = paramArrayOfByte.length)
      {
        ab.d("MicroMsg.Wear.GlobalConnection", "send Message %s %s %d", new Object[] { str, paramString, Integer.valueOf(i) });
        break label70;
        label220:
        break;
      }
      localObject = locala;
    }
  }
  
  public final b.a C(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26363);
    if (!cYH().isConnected())
    {
      paramString = new b.a((byte)0);
      AppMethodBeat.o(26363);
      return paramString;
    }
    paramString = PutDataMapRequest.create(paramString);
    paramString.getDataMap().putLong("key_timestamp", System.currentTimeMillis());
    paramString.getDataMap().putAsset("key_data", Asset.createFromBytes(paramArrayOfByte));
    paramString = paramString.asPutDataRequest();
    Wearable.DataApi.putDataItem(cYH(), paramString);
    ab.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", new Object[] { paramString.getUri().getPath(), Integer.valueOf(paramString.getData().length) });
    paramString = new b.a();
    AppMethodBeat.o(26363);
    return paramString;
  }
  
  public final byte[] a(Asset paramAsset)
  {
    AppMethodBeat.i(26360);
    paramAsset = (DataApi.GetFdForAssetResult)Wearable.DataApi.getFdForAsset(cYH(), paramAsset).await();
    Status localStatus = paramAsset.getStatus();
    if (!localStatus.isSuccess())
    {
      ab.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(localStatus.getStatusCode()), localStatus.getStatusMessage() });
      AppMethodBeat.o(26360);
      return null;
    }
    paramAsset = e.m(paramAsset.getInputStream());
    AppMethodBeat.o(26360);
    return paramAsset;
  }
  
  public final void cYG()
  {
    AppMethodBeat.i(26358);
    this.uHy.disconnect();
    cYH();
    AppMethodBeat.o(26358);
  }
  
  public final GoogleApiClient cYH()
  {
    AppMethodBeat.i(26359);
    if (!this.uHy.isConnected())
    {
      ab.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
      localObject = this.uHy.blockingConnect(30L, TimeUnit.SECONDS);
      if (!((ConnectionResult)localObject).isSuccess()) {
        ab.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", new Object[] { Integer.valueOf(((ConnectionResult)localObject).getErrorCode()) });
      }
    }
    Object localObject = this.uHy;
    AppMethodBeat.o(26359);
    return localObject;
  }
  
  public final HashSet<String> cYI()
  {
    AppMethodBeat.i(26362);
    HashSet localHashSet = new HashSet();
    Object localObject = (NodeApi.GetConnectedNodesResult)Wearable.NodeApi.getConnectedNodes(cYH()).await();
    if (localObject != null)
    {
      localObject = ((NodeApi.GetConnectedNodesResult)localObject).getNodes().iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add(((Node)((Iterator)localObject).next()).getId());
      }
    }
    AppMethodBeat.o(26362);
    return localHashSet;
  }
  
  public final boolean cYJ()
  {
    AppMethodBeat.i(26365);
    if (!cYH().isConnected())
    {
      AppMethodBeat.o(26365);
      return false;
    }
    if (cYI().size() == 0)
    {
      AppMethodBeat.o(26365);
      return false;
    }
    AppMethodBeat.o(26365);
    return true;
  }
  
  public final void cYK()
  {
    AppMethodBeat.i(26367);
    DataItemBuffer localDataItemBuffer = (DataItemBuffer)Wearable.DataApi.getDataItems(cYH()).await();
    Iterator localIterator = localDataItemBuffer.iterator();
    while (localIterator.hasNext())
    {
      DataItem localDataItem = (DataItem)localIterator.next();
      String str = localDataItem.getUri().toString();
      if (str.startsWith("/wechat"))
      {
        ab.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[] { str });
        Wearable.DataApi.deleteDataItems(cYH(), localDataItem.getUri());
      }
    }
    localDataItemBuffer.release();
    AppMethodBeat.o(26367);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(26366);
    this.uHy.disconnect();
    AppMethodBeat.o(26366);
  }
  
  public final boolean isAvailable()
  {
    AppMethodBeat.i(26357);
    if ((h.OW()) || (h.OV()))
    {
      AppMethodBeat.o(26357);
      return true;
    }
    AppMethodBeat.o(26357);
    return false;
  }
  
  public final boolean j(Uri paramUri)
  {
    AppMethodBeat.i(26364);
    Wearable.DataApi.deleteDataItems(cYH(), paramUri);
    ab.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[] { paramUri });
    AppMethodBeat.o(26364);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.a
 * JD-Core Version:    0.7.0.1
 */