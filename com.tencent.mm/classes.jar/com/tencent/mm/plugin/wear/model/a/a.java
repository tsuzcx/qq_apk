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
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class a
  implements b
{
  private GoogleApiClient qSr = new GoogleApiClient.Builder(ae.getContext()).addApi(Wearable.API).build();
  
  public final byte[] a(Asset paramAsset)
  {
    paramAsset = (DataApi.GetFdForAssetResult)Wearable.DataApi.getFdForAsset(bYU(), paramAsset).await();
    Status localStatus = paramAsset.getStatus();
    if (!localStatus.isSuccess())
    {
      y.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(localStatus.getStatusCode()), localStatus.getStatusMessage() });
      return null;
    }
    return e.k(paramAsset.getInputStream());
  }
  
  public final void bYT()
  {
    this.qSr.disconnect();
    bYU();
  }
  
  public final GoogleApiClient bYU()
  {
    if (!this.qSr.isConnected())
    {
      y.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
      ConnectionResult localConnectionResult = this.qSr.blockingConnect(30L, TimeUnit.SECONDS);
      if (!localConnectionResult.isSuccess()) {
        y.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", new Object[] { Integer.valueOf(localConnectionResult.getErrorCode()) });
      }
    }
    return this.qSr;
  }
  
  public final HashSet<String> bYV()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (NodeApi.GetConnectedNodesResult)Wearable.NodeApi.getConnectedNodes(bYU()).await();
    if (localObject != null)
    {
      localObject = ((NodeApi.GetConnectedNodesResult)localObject).getNodes().iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add(((Node)((Iterator)localObject).next()).getId());
      }
    }
    return localHashSet;
  }
  
  public final boolean bYW()
  {
    if (!bYU().isConnected()) {}
    while (bYV().size() == 0) {
      return false;
    }
    return true;
  }
  
  public final void bYX()
  {
    DataItemBuffer localDataItemBuffer = (DataItemBuffer)Wearable.DataApi.getDataItems(bYU()).await();
    Iterator localIterator = localDataItemBuffer.iterator();
    while (localIterator.hasNext())
    {
      DataItem localDataItem = (DataItem)localIterator.next();
      String str = localDataItem.getUri().toString();
      if (str.startsWith("/wechat"))
      {
        y.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[] { str });
        Wearable.DataApi.deleteDataItems(bYU(), localDataItem.getUri());
      }
    }
    localDataItemBuffer.release();
  }
  
  public final void finish()
  {
    this.qSr.disconnect();
  }
  
  public final boolean h(Uri paramUri)
  {
    Wearable.DataApi.deleteDataItems(bYU(), paramUri);
    y.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", new Object[] { paramUri });
    return true;
  }
  
  public final boolean isAvailable()
  {
    return (h.aHJ()) || (h.aHI());
  }
  
  public final b.a t(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = bYV();
    b.a locala = new b.a();
    Iterator localIterator = ((HashSet)localObject).iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bYU().isConnected())
      {
        localObject = new b.a((byte)0);
        label64:
        if (((b.a)localObject).code != 0) {
          return localObject;
        }
      }
      else
      {
        localObject = new b.a();
        Status localStatus = ((MessageApi.SendMessageResult)Wearable.MessageApi.sendMessage(bYU(), str, paramString, paramArrayOfByte).await(2L, TimeUnit.SECONDS)).getStatus();
        if (!localStatus.isSuccess())
        {
          ((b.a)localObject).code = 131072;
          ((b.a)localObject).aox = localStatus.getStatusMessage();
          y.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", new Object[] { Integer.valueOf(localStatus.getStatusCode()), localStatus.getStatusMessage() });
        }
        if (paramArrayOfByte != null) {
          break label213;
        }
      }
      label213:
      for (int i = 0;; i = paramArrayOfByte.length)
      {
        y.d("MicroMsg.Wear.GlobalConnection", "send Message %s %s %d", new Object[] { str, paramString, Integer.valueOf(i) });
        break label64;
        break;
      }
    }
    return locala;
  }
  
  public final b.a u(String paramString, byte[] paramArrayOfByte)
  {
    if (!bYU().isConnected()) {
      return new b.a((byte)0);
    }
    paramString = PutDataMapRequest.create(paramString);
    paramString.getDataMap().putLong("key_timestamp", System.currentTimeMillis());
    paramString.getDataMap().putAsset("key_data", Asset.createFromBytes(paramArrayOfByte));
    paramString = paramString.asPutDataRequest();
    Wearable.DataApi.putDataItem(bYU(), paramString);
    y.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", new Object[] { paramString.getUri().getPath(), Integer.valueOf(paramString.getData().length) });
    return new b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.a
 * JD-Core Version:    0.7.0.1
 */