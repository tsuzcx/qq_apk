package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.protocal.protobuf.ggz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.LinkedList;

public class WearMessageLogic
  extends BroadcastReceiver
{
  private static final String WiM;
  
  static
  {
    AppMethodBeat.i(261887);
    WiM = WeChatPermissions.PERMISSION_WEAR_MESSAGE();
    AppMethodBeat.o(261887);
  }
  
  public WearMessageLogic()
  {
    AppMethodBeat.i(30007);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.wear.message");
    MMApplicationContext.getContext().registerReceiver(this, localIntentFilter, WiM, null);
    AppMethodBeat.o(30007);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(30008);
    ((com.tencent.mm.plugin.boots.a.c)h.ax(com.tencent.mm.plugin.boots.a.c.class)).gs(com.tencent.mm.plugin.boots.a.b.vyK, 1170);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      a.inN();
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new a((byte)0);
        paramIntent.WiN = i;
        paramIntent.oSc = paramContext.getInt("key_funid");
        paramIntent.hBm = paramContext.getInt("key_sessionid");
        paramIntent.WiO = paramContext.getByteArray("key_data");
        paramContext = a.inL().asO(paramIntent.oSc);
        if (paramContext != null) {}
        for (boolean bool = paramContext.asN(paramIntent.oSc); bool; bool = false)
        {
          MMHandlerThread.postToMainThread(paramIntent);
          AppMethodBeat.o(30008);
          return;
        }
        ThreadPool.post(paramIntent, "WearHttpMessageTask_" + paramIntent.oSc);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.WiN = i;
        paramIntent.oSc = paramContext.getInt("key_funid");
        paramIntent.hBm = paramContext.getInt("key_sessionid");
        paramIntent.WiO = paramContext.getByteArray("key_data");
        a.inJ().a(paramIntent);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 3) {
        a.inJ().a(new c((byte)0));
      }
    }
    AppMethodBeat.o(30008);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int WiN;
    public byte[] WiO;
    public int hBm;
    public int oSc;
    
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30003);
      Log.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
      com.tencent.mm.plugin.wear.model.e.a locala = a.inL().asO(this.oSc);
      if (locala != null) {
        locala.c(this.WiN, this.hBm, this.oSc, this.WiO);
      }
      AppMethodBeat.o(30003);
    }
    
    public final String getName()
    {
      return "HttpMessageTask";
    }
    
    public final String toString()
    {
      AppMethodBeat.i(30004);
      String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.WiN), Integer.valueOf(this.oSc), Integer.valueOf(this.hBm) });
      AppMethodBeat.o(30004);
      return str;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int WiN;
    public byte[] WiO;
    public int hBm;
    public int oSc;
    
    private b() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30005);
      switch (this.oSc)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30005);
        return;
        p localp = a.inI().WiB;
        int i = this.hBm;
        Object localObject = this.WiO;
        if (localp.reE.contains(Integer.valueOf(i))) {
          continue;
        }
        ggz localggz = new ggz();
        try
        {
          localggz.parseFrom((byte[])localObject);
          label82:
          if (localp.Wjs == i)
          {
            if (localggz.acdn)
            {
              Log.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              AppMethodBeat.o(30005);
              return;
            }
            if (localggz.acdm)
            {
              localp.a(i, localggz);
              if (localp.Wjq != null)
              {
                localp.Wjq.aIz();
                localp.Wjq = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.Wjp != null)
              {
                localp.Wjp.stop();
                localp.Wjp = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.Wjo != null)
              {
                localp.Wjo.pdm = true;
                if (!localp.ihD) {
                  bh.aZW().a(localp.Wjo, 0);
                }
                localp.Wjo = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              }
              AppMethodBeat.o(30005);
              return;
            }
            localp.a(i, localggz);
            AppMethodBeat.o(30005);
            return;
          }
          localp.reset();
          localp.Wjs = i;
          Log.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.Wjs) });
          y.deleteFile(p.Wjn);
          if (localp.Wjq == null)
          {
            localp.Wjq = new com.tencent.mm.audio.e.d();
            localp.Wjq.jO(p.Wjn);
          }
          if (localp.Wjp == null)
          {
            localp.Wjp = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
            if (localp.Wjp.jXc() != 0)
            {
              localp.Wjt = -2;
              AppMethodBeat.o(30005);
              return;
            }
          }
          localObject = localggz.abvu;
          if (localp.Wjo == null) {
            MMHandlerThread.postToMainThread(new p.1(localp, (String)localObject));
          }
          localp.a(i, localggz);
        }
        catch (IOException localIOException)
        {
          break label82;
        }
      }
    }
    
    public final String getName()
    {
      return "LongConnectTask";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    private c() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30006);
      if (a.inI().inV() != null) {
        a.inI().inV().inW();
      }
      AppMethodBeat.o(30006);
    }
    
    public final String getName()
    {
      return "RefreshConnectTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic
 * JD-Core Version:    0.7.0.1
 */