package com.tencent.mm.wear.app.service;

import android.net.Uri;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.l;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.o;
import com.google.android.gms.wearable.s;
import com.tencent.mm.b.a.f;
import com.tencent.mm.wear.app.a.c;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataLayerService
  extends WearableListenerService
{
  private static com.tencent.mm.wear.app.e.a n(byte[] paramArrayOfByte)
  {
    com.tencent.mm.wear.app.e.a locala = new com.tencent.mm.wear.app.e.a();
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    locala.ahH = paramArrayOfByte.readInt();
    locala.aeo = paramArrayOfByte.readInt();
    locala.aep = paramArrayOfByte.readInt();
    locala.ahI = paramArrayOfByte.readInt();
    if (locala.ahI > 0)
    {
      locala.aes = new byte[locala.ahI];
      paramArrayOfByte.readFully(locala.aes);
    }
    return locala;
  }
  
  public final void a(Channel paramChannel, int paramInt1, int paramInt2)
  {
    super.a(paramChannel, paramInt1, paramInt2);
  }
  
  public final void a(k paramk)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramk.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((com.google.android.gms.common.data.d)((Iterator)localObject2).next()).freeze());
    }
    paramk.close();
    paramk = ((List)localObject1).iterator();
    for (;;)
    {
      if (paramk.hasNext())
      {
        Object localObject3 = (j)paramk.next();
        if (((j)localObject3).getType() == 1)
        {
          localObject1 = ((j)localObject3).kD().getUri();
          localObject2 = ((Uri)localObject1).getPath();
          if (com.tencent.mm.c.b.a.b.B((String)localObject2))
          {
            localObject3 = o.a(((j)localObject3).kD()).kG().u("key_data");
            if (localObject3 != null) {
              localObject3 = h.mO().mF().a((Asset)localObject3);
            }
            try
            {
              com.tencent.mm.wear.a.c.d.d("MicroMsg.DataLayerService", "receive data path=%s length=%d", new Object[] { localObject2, Integer.valueOf(localObject3.length) });
              localObject2 = new f();
              ((f)localObject2).WQ.WS = n((byte[])localObject3);
              com.tencent.mm.sdk.a.a.YM.a((com.tencent.mm.sdk.a.d)localObject2);
              h.mO().mF().e((Uri)localObject1);
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                com.tencent.mm.wear.a.c.d.b("MicroMsg.DataLayerService", localIOException, "genBaseMsg error", new Object[0]);
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(s params)
  {
    String str = params.getPath();
    if (com.tencent.mm.c.b.a.b.B(str)) {}
    try
    {
      f localf = new f();
      params = params.getData();
      com.tencent.mm.wear.a.c.d.d("MicroMsg.DataLayerService", "receive data path=%s length=%d", new Object[] { str, Integer.valueOf(params.length) });
      localf.WQ.WS = n(params);
      com.tencent.mm.sdk.a.a.YM.a(localf);
      return;
    }
    catch (IOException params)
    {
      com.tencent.mm.wear.a.c.d.b("MicroMsg.DataLayerService", params, "genBaseMsg error", new Object[0]);
    }
  }
  
  public final void kJ()
  {
    if (!h.nb())
    {
      h.E(true);
      com.tencent.mm.wear.a.c.d.c("MicroMsg.DataLayerService", "onPeerConnected try to startLogin", new Object[0]);
    }
  }
  
  public final void kK()
  {
    h.logout();
    com.tencent.mm.sdk.a.a.YM.a(new com.tencent.mm.b.a.b());
  }
  
  public void onCreate()
  {
    super.onCreate();
    com.tencent.mm.wear.a.c.d.d("MicroMsg.DataLayerService", "onCreate", new Object[0]);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.wear.a.c.d.d("MicroMsg.DataLayerService", "onDestroy", new Object[0]);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.DataLayerService
 * JD-Core Version:    0.7.0.1
 */