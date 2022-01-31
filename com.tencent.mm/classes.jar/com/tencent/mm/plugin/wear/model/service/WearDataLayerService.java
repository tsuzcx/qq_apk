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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@JgClassChecked(author=100, fComment="checked", lastDate="20141125", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class WearDataLayerService
  extends WearableListenerService
{
  private static Bundle bG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26434);
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
      ab.i("MicroMsg.Wear.WearDataLayerService", "receive data connectType=%d sessionId=%d funId=%d contentLength=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      AppMethodBeat.o(26434);
      return localBundle;
    }
    paramArrayOfByte = new IOException("contentLength too large ".concat(String.valueOf(m)));
    AppMethodBeat.o(26434);
    throw paramArrayOfByte;
  }
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26441);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onChannelClosed %s %s %d %d", new Object[] { paramChannel.getPath(), paramChannel.getNodeId(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26441);
  }
  
  public void onChannelOpened(Channel paramChannel)
  {
    AppMethodBeat.i(26438);
    String str1 = paramChannel.getPath();
    String str2 = paramChannel.getNodeId();
    Object localObject = g.w(str1.getBytes());
    localObject = new File(e.esI, (String)localObject);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onChannelOpened %s %s %s", new Object[] { str1, str2, ((File)localObject).getAbsolutePath() });
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
          paramChannel.receiveFile(new com.tencent.mm.plugin.wear.model.a.a().cYH(), Uri.fromFile((File)localObject), false);
          AppMethodBeat.o(26438);
          return;
        }
        catch (Exception paramChannel)
        {
          ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", paramChannel, "fuck Xiao Mi", new Object[0]);
          AppMethodBeat.o(26438);
        }
        localIOException = localIOException;
        ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", localIOException, "onChannelOpened", new Object[0]);
      }
    }
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(26431);
    super.onCreate();
    ab.i("MicroMsg.Wear.WearDataLayerService", "onCreate");
    AppMethodBeat.o(26431);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer)
  {
    AppMethodBeat.i(26433);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onDataChanged %d %s", new Object[] { Integer.valueOf(paramDataEventBuffer.getCount()), paramDataEventBuffer.getStatus() });
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
        if (!com.tencent.mm.plugin.wear.a.b.agj(localUri.getPath())) {
          continue;
        }
        localObject = DataMapItem.fromDataItem(((DataEvent)localObject).getDataItem()).getDataMap().getAsset("key_data");
        if (localObject != null)
        {
          localObject = new com.tencent.mm.plugin.wear.model.a.a().a((Asset)localObject);
          if (localObject == null)
          {
            AppMethodBeat.o(26433);
            return;
          }
        }
        try
        {
          ab.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", new Object[] { Integer.valueOf(localObject.length) });
          com.tencent.mm.plugin.wear.model.b.a.ab(bG((byte[])localObject));
          new com.tencent.mm.plugin.wear.model.a.a().j(localUri);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", localIOException, "decode data error", new Object[0]);
          }
        }
      }
    }
    paramDataEventBuffer.close();
    AppMethodBeat.o(26433);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26432);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onDestroy");
    super.onDestroy();
    AppMethodBeat.o(26432);
  }
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26439);
    String str = paramChannel.getPath();
    ab.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s %s %d %d", new Object[] { str, paramChannel.getNodeId(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      paramChannel = g.w(str.getBytes());
      paramChannel = new File(e.esI, paramChannel);
      ab.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s, %d", new Object[] { paramChannel.getAbsolutePath(), Long.valueOf(paramChannel.length()) });
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_connecttype", 1);
      localBundle.putInt("key_funid", com.tencent.mm.plugin.wear.a.b.agk(str));
      localBundle.putInt("key_sessionid", 0);
      localBundle.putByteArray("key_data", paramChannel.getAbsolutePath().getBytes());
      com.tencent.mm.plugin.wear.model.b.a.ab(localBundle);
    }
    AppMethodBeat.o(26439);
  }
  
  public void onMessageReceived(MessageEvent paramMessageEvent)
  {
    AppMethodBeat.i(26435);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onMessageReceived %s", new Object[] { paramMessageEvent.getPath() });
    if (com.tencent.mm.plugin.wear.a.b.agj(paramMessageEvent.getPath())) {
      try
      {
        paramMessageEvent = paramMessageEvent.getData();
        ab.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", new Object[] { Integer.valueOf(paramMessageEvent.length) });
        com.tencent.mm.plugin.wear.model.b.a.ab(bG(paramMessageEvent));
        AppMethodBeat.o(26435);
        return;
      }
      catch (IOException paramMessageEvent)
      {
        ab.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", paramMessageEvent, "decode message error", new Object[0]);
      }
    }
    AppMethodBeat.o(26435);
  }
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26440);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onOutputClosed %s %s %d %d", new Object[] { paramChannel.getPath(), paramChannel.getNodeId(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(26440);
  }
  
  public void onPeerConnected(Node paramNode)
  {
    AppMethodBeat.i(26436);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onPeerConnected %s", new Object[] { paramNode.getId() });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_connecttype", 3);
    localBundle.putInt("key_funid", 1);
    localBundle.putByteArray("key_data", paramNode.getId().getBytes());
    com.tencent.mm.plugin.wear.model.b.a.ab(localBundle);
    AppMethodBeat.o(26436);
  }
  
  public void onPeerDisconnected(Node paramNode)
  {
    AppMethodBeat.i(26437);
    ab.i("MicroMsg.Wear.WearDataLayerService", "onPeerDisconnected %s", new Object[] { paramNode.getId() });
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_connecttype", 3);
    localBundle.putInt("key_funid", -1);
    localBundle.putByteArray("key_data", paramNode.getId().getBytes());
    com.tencent.mm.plugin.wear.model.b.a.ab(localBundle);
    AppMethodBeat.o(26437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.service.WearDataLayerService
 * JD-Core Version:    0.7.0.1
 */