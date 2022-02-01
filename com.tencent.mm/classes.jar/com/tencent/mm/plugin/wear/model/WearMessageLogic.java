package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.LinkedList;

public class WearMessageLogic
  extends BroadcastReceiver
{
  public WearMessageLogic()
  {
    AppMethodBeat.i(30007);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.wear.message");
    aj.getContext().registerReceiver(this, localIntentFilter, "com.tencent.mm.wear.message", null);
    AppMethodBeat.o(30007);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(30008);
    ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eG(com.tencent.mm.plugin.boots.a.b.mQS, 1170);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new a((byte)0);
        paramIntent.AEm = i;
        paramIntent.hrg = paramContext.getInt("key_funid");
        paramIntent.dcS = paramContext.getInt("key_sessionid");
        paramIntent.AEn = paramContext.getByteArray("key_data");
        paramContext = a.egY().RU(paramIntent.hrg);
        if (paramContext != null) {}
        for (boolean bool = paramContext.RT(paramIntent.hrg); bool; bool = false)
        {
          aq.f(paramIntent);
          AppMethodBeat.o(30008);
          return;
        }
        com.tencent.mm.sdk.g.b.c(paramIntent, "WearHttpMessageTask_" + paramIntent.hrg);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.AEm = i;
        paramIntent.hrg = paramContext.getInt("key_funid");
        paramIntent.dcS = paramContext.getInt("key_sessionid");
        paramIntent.AEn = paramContext.getByteArray("key_data");
        a.egW().a(paramIntent);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 3) {
        a.egW().a(new c((byte)0));
      }
    }
    AppMethodBeat.o(30008);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int AEm;
    public byte[] AEn;
    public int dcS;
    public int hrg;
    
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30003);
      ad.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
      com.tencent.mm.plugin.wear.model.e.a locala = a.egY().RU(this.hrg);
      if (locala != null) {
        locala.c(this.AEm, this.dcS, this.hrg, this.AEn);
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
      String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.AEm), Integer.valueOf(this.hrg), Integer.valueOf(this.dcS) });
      AppMethodBeat.o(30004);
      return str;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int AEm;
    public byte[] AEn;
    public int dcS;
    public int hrg;
    
    private b() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30005);
      switch (this.hrg)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30005);
        return;
        p localp = a.egV().AEb;
        int i = this.dcS;
        Object localObject = this.AEn;
        if (localp.jhB.contains(Integer.valueOf(i))) {
          continue;
        }
        dse localdse = new dse();
        try
        {
          localdse.parseFrom((byte[])localObject);
          label82:
          if (localp.AEU == i)
          {
            if (localdse.EGR)
            {
              ad.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              AppMethodBeat.o(30005);
              return;
            }
            if (localdse.EGQ)
            {
              localp.a(i, localdse);
              if (localp.AES != null)
              {
                localp.AES.PQ();
                localp.AES = null;
                ad.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.AER != null)
              {
                localp.AER.stop();
                localp.AER = null;
                ad.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.AEQ != null)
              {
                localp.AEQ.hCh = true;
                if (!localp.dDS) {
                  az.aeS().a(localp.AEQ, 0);
                }
                localp.AEQ = null;
                ad.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              }
              AppMethodBeat.o(30005);
              return;
            }
            localp.a(i, localdse);
            AppMethodBeat.o(30005);
            return;
          }
          localp.reset();
          localp.AEU = i;
          ad.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.AEU) });
          i.deleteFile(p.AEP);
          if (localp.AES == null)
          {
            localp.AES = new com.tencent.mm.audio.e.d();
            localp.AES.fR(p.AEP);
          }
          if (localp.AER == null)
          {
            localp.AER = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
            if (localp.AER.fma() != 0)
            {
              localp.AEV = -2;
              AppMethodBeat.o(30005);
              return;
            }
          }
          localObject = localdse.Egc;
          if (localp.AEQ == null) {
            aq.f(new p.1(localp, (String)localObject));
          }
          localp.a(i, localdse);
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
      if (a.egV().ehg() != null) {
        a.egV().ehg().ehi();
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