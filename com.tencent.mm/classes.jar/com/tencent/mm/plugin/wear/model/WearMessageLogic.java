package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.protocal.protobuf.fkl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.LinkedList;

public class WearMessageLogic
  extends BroadcastReceiver
{
  private static final String PrZ;
  
  static
  {
    AppMethodBeat.i(288157);
    PrZ = WeChatPermissions.PERMISSION_WEAR_MESSAGE();
    AppMethodBeat.o(288157);
  }
  
  public WearMessageLogic()
  {
    AppMethodBeat.i(30007);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.wear.message");
    MMApplicationContext.getContext().registerReceiver(this, localIntentFilter, PrZ, null);
    AppMethodBeat.o(30007);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(30008);
    ((com.tencent.mm.plugin.boots.a.c)h.ae(com.tencent.mm.plugin.boots.a.c.class)).fA(com.tencent.mm.plugin.boots.a.b.smL, 1170);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      a.gOy();
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new a((byte)0);
        paramIntent.Psa = i;
        paramIntent.lYT = paramContext.getInt("key_funid");
        paramIntent.fwM = paramContext.getInt("key_sessionid");
        paramIntent.Psb = paramContext.getByteArray("key_data");
        paramContext = a.gOw().amX(paramIntent.lYT);
        if (paramContext != null) {}
        for (boolean bool = paramContext.amW(paramIntent.lYT); bool; bool = false)
        {
          MMHandlerThread.postToMainThread(paramIntent);
          AppMethodBeat.o(30008);
          return;
        }
        ThreadPool.post(paramIntent, "WearHttpMessageTask_" + paramIntent.lYT);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.Psa = i;
        paramIntent.lYT = paramContext.getInt("key_funid");
        paramIntent.fwM = paramContext.getInt("key_sessionid");
        paramIntent.Psb = paramContext.getByteArray("key_data");
        a.gOu().a(paramIntent);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 3) {
        a.gOu().a(new c((byte)0));
      }
    }
    AppMethodBeat.o(30008);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int Psa;
    public byte[] Psb;
    public int fwM;
    public int lYT;
    
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30003);
      Log.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
      com.tencent.mm.plugin.wear.model.e.a locala = a.gOw().amX(this.lYT);
      if (locala != null) {
        locala.c(this.Psa, this.fwM, this.lYT, this.Psb);
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
      String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.Psa), Integer.valueOf(this.lYT), Integer.valueOf(this.fwM) });
      AppMethodBeat.o(30004);
      return str;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int Psa;
    public byte[] Psb;
    public int fwM;
    public int lYT;
    
    private b() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30005);
      switch (this.lYT)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30005);
        return;
        p localp = a.gOt().PrO;
        int i = this.fwM;
        Object localObject = this.Psb;
        if (localp.odL.contains(Integer.valueOf(i))) {
          continue;
        }
        fkl localfkl = new fkl();
        try
        {
          localfkl.parseFrom((byte[])localObject);
          label82:
          if (localp.PsF == i)
          {
            if (localfkl.UJf)
            {
              Log.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              AppMethodBeat.o(30005);
              return;
            }
            if (localfkl.UJe)
            {
              localp.a(i, localfkl);
              if (localp.PsD != null)
              {
                localp.PsD.agC();
                localp.PsD = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.PsC != null)
              {
                localp.PsC.stop();
                localp.PsC = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.PsB != null)
              {
                localp.PsB.mjP = true;
                if (!localp.gbt) {
                  bh.aGY().a(localp.PsB, 0);
                }
                localp.PsB = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              }
              AppMethodBeat.o(30005);
              return;
            }
            localp.a(i, localfkl);
            AppMethodBeat.o(30005);
            return;
          }
          localp.reset();
          localp.PsF = i;
          Log.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.PsF) });
          u.deleteFile(p.PsA);
          if (localp.PsD == null)
          {
            localp.PsD = new com.tencent.mm.audio.e.d();
            localp.PsD.in(p.PsA);
          }
          if (localp.PsC == null)
          {
            localp.PsC = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
            if (localp.PsC.inR() != 0)
            {
              localp.PsG = -2;
              AppMethodBeat.o(30005);
              return;
            }
          }
          localObject = localfkl.Ueg;
          if (localp.PsB == null) {
            MMHandlerThread.postToMainThread(new p.1(localp, (String)localObject));
          }
          localp.a(i, localfkl);
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
      if (a.gOt().gOH() != null) {
        a.gOt().gOH().gOI();
      }
      AppMethodBeat.o(30006);
    }
    
    public final String getName()
    {
      return "RefreshConnectTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic
 * JD-Core Version:    0.7.0.1
 */