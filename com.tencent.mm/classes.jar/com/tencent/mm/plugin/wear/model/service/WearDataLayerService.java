package com.tencent.mm.plugin.wear.model.service;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.WearableListenerService;
import com.jg.JgClassChecked;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@JgClassChecked(author=100, fComment="checked", lastDate="20141125", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class WearDataLayerService
  extends WearableListenerService
{
  private static Bundle bf(byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    int i = localDataInputStream.readInt();
    localBundle.putInt("key_connecttype", i);
    int j = localDataInputStream.readInt();
    localBundle.putInt("key_sessionid", j);
    int k = localDataInputStream.readInt();
    localBundle.putInt("key_funid", k);
    int m = localDataInputStream.readInt();
    if ((m > 0) && (m < paramArrayOfByte.length))
    {
      paramArrayOfByte = new byte[m];
      localDataInputStream.readFully(paramArrayOfByte);
      localBundle.putByteArray("key_data", paramArrayOfByte);
    }
    while (m < paramArrayOfByte.length)
    {
      y.i("MicroMsg.Wear.WearDataLayerService", "receive data connectType=%d sessionId=%d funId=%d contentLength=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      return localBundle;
    }
    throw new IOException("contentLength too large " + m);
  }
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Wear.WearDataLayerService", "onChannelClosed %s %s %d %d", new Object[] { paramChannel.getPath(), paramChannel.getNodeId(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onChannelOpened(Channel paramChannel)
  {
    String str1 = paramChannel.getPath();
    String str2 = paramChannel.getNodeId();
    Object localObject = g.o(str1.getBytes());
    localObject = new File(e.dzC, (String)localObject);
    y.i("MicroMsg.Wear.WearDataLayerService", "onChannelOpened %s %s %s", new Object[] { str1, str2, ((File)localObject).getAbsolutePath() });
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    if (!((File)localObject).getParentFile().exists()) {
      ((File)localObject).getParentFile().mkdirs();
    }
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          paramChannel.receiveFile(new com.tencent.mm.plugin.wear.model.a.a().bYU(), Uri.fromFile((File)localObject), false);
          return;
        }
        catch (Exception paramChannel)
        {
          y.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", paramChannel, "fuck Xiao Mi", new Object[0]);
        }
        localIOException = localIOException;
        y.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", localIOException, "onChannelOpened", new Object[0]);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.Wear.WearDataLayerService", "onCreate");
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
    y.i("MicroMsg.Wear.WearDataLayerService", "onDataChanged %d %s", new Object[] { Integer.valueOf(paramDataEventBuffer.getCount()), paramDataEventBuffer.getStatus() });
    Iterator localIterator = paramDataEventBuffer.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (DataEvent)localIterator.next();
        if (((DataEvent)localObject).getType() != 1) {
          continue;
        }
        Uri localUri = ((DataEvent)localObject).getDataItem().getUri();
        if (!com.tencent.mm.plugin.wear.a.b.Rm(localUri.getPath())) {
          continue;
        }
        localObject = DataMapItem.fromDataItem(((DataEvent)localObject).getDataItem()).getDataMap().getAsset("key_data");
        if (localObject != null)
        {
          localObject = new com.tencent.mm.plugin.wear.model.a.a().a((Asset)localObject);
          if (localObject == null) {
            return;
          }
        }
        try
        {
          y.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", new Object[] { Integer.valueOf(localObject.length) });
          com.tencent.mm.plugin.wear.model.b.a.K(bf((byte[])localObject));
          new com.tencent.mm.plugin.wear.model.a.a().h(localUri);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", localIOException, "decode data error", new Object[0]);
          }
        }
      }
    }
    paramDataEventBuffer.close();
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.Wear.WearDataLayerService", "onDestroy");
    super.onDestroy();
  }
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    String str = paramChannel.getPath();
    y.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s %s %d %d", new Object[] { str, paramChannel.getNodeId(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramChannel = g.o(str.getBytes());
      paramChannel = new File(e.dzC, paramChannel);
      y.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s, %d", new Object[] { paramChannel.getAbsolutePath(), Long.valueOf(paramChannel.length()) });
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_connecttype", 1);
      localBundle.putInt("key_funid", com.tencent.mm.plugin.wear.a.b.Rn(str));
      localBundle.putInt("key_sessionid", 0);
      localBundle.putByteArray("key_data", paramChannel.getAbsolutePath().getBytes());
      com.tencent.mm.plugin.wear.model.b.a.K(localBundle);
    }
  }
  
  public void onMessageReceived(MessageEvent paramMessageEvent)
  {
    y.i("MicroMsg.Wear.WearDataLayerService", "onMessageReceived %s", new Object[] { paramMessageEvent.getPath() });
    if (com.tencent.mm.plugin.wear.a.b.Rm(paramMessageEvent.getPath())) {}
    try
    {
      paramMessageEvent = paramMessageEvent.getData();
      y.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", new Object[] { Integer.valueOf(paramMessageEvent.length) });
      com.tencent.mm.plugin.wear.model.b.a.K(bf(paramMessageEvent));
      return;
    }
    catch (IOException paramMessageEvent)
    {
      y.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", paramMessageEvent, "decode message error", new Object[0]);
    }
  }
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Wear.WearDataLayerService", "onOutputClosed %s %s %d %d", new Object[] { paramChannel.getPath(), paramChannel.getNodeId(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onPeerConnected(Node paramNode)
  {
    y.i("MicroMsg.Wear.WearDataLayerService", "onPeerConnected %s", new Object[] { paramNode.getId() });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_connecttype", 3);
    localBundle.putInt("key_funid", 1);
    localBundle.putByteArray("key_data", paramNode.getId().getBytes());
    com.tencent.mm.plugin.wear.model.b.a.K(localBundle);
  }
  
  public void onPeerDisconnected(Node paramNode)
  {
    y.i("MicroMsg.Wear.WearDataLayerService", "onPeerDisconnected %s", new Object[] { paramNode.getId() });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_connecttype", 3);
    localBundle.putInt("key_funid", -1);
    localBundle.putByteArray("key_data", paramNode.getId().getBytes());
    com.tencent.mm.plugin.wear.model.b.a.K(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.service.WearDataLayerService
 * JD-Core Version:    0.7.0.1
 */