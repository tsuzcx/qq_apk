package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.vfs.o;
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
    ak.getContext().registerReceiver(this, localIntentFilter, "com.tencent.mm.wear.message", null);
    AppMethodBeat.o(30007);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(30008);
    ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eO(com.tencent.mm.plugin.boots.a.b.nZE, 1170);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new a((byte)0);
        paramIntent.DOF = i;
        paramIntent.inP = paramContext.getInt("key_funid");
        paramIntent.dmM = paramContext.getInt("key_sessionid");
        paramIntent.DOG = paramContext.getByteArray("key_data");
        paramContext = a.eOg().WD(paramIntent.inP);
        if (paramContext != null) {}
        for (boolean bool = paramContext.WC(paramIntent.inP); bool; bool = false)
        {
          ar.f(paramIntent);
          AppMethodBeat.o(30008);
          return;
        }
        com.tencent.mm.sdk.g.b.c(paramIntent, "WearHttpMessageTask_" + paramIntent.inP);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.DOF = i;
        paramIntent.inP = paramContext.getInt("key_funid");
        paramIntent.dmM = paramContext.getInt("key_sessionid");
        paramIntent.DOG = paramContext.getByteArray("key_data");
        a.eOe().a(paramIntent);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 3) {
        a.eOe().a(new c((byte)0));
      }
    }
    AppMethodBeat.o(30008);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int DOF;
    public byte[] DOG;
    public int dmM;
    public int inP;
    
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30003);
      ae.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
      com.tencent.mm.plugin.wear.model.e.a locala = a.eOg().WD(this.inP);
      if (locala != null) {
        locala.c(this.DOF, this.dmM, this.inP, this.DOG);
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
      String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.DOF), Integer.valueOf(this.inP), Integer.valueOf(this.dmM) });
      AppMethodBeat.o(30004);
      return str;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int DOF;
    public byte[] DOG;
    public int dmM;
    public int inP;
    
    private b() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30005);
      switch (this.inP)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30005);
        return;
        p localp = a.eOd().DOu;
        int i = this.dmM;
        Object localObject = this.DOG;
        if (localp.kft.contains(Integer.valueOf(i))) {
          continue;
        }
        efm localefm = new efm();
        try
        {
          localefm.parseFrom((byte[])localObject);
          label82:
          if (localp.DPm == i)
          {
            if (localefm.Ijq)
            {
              ae.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              AppMethodBeat.o(30005);
              return;
            }
            if (localefm.Ijp)
            {
              localp.a(i, localefm);
              if (localp.DPk != null)
              {
                localp.DPk.Rx();
                localp.DPk = null;
                ae.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.DPj != null)
              {
                localp.DPj.stop();
                localp.DPj = null;
                ae.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.DPi != null)
              {
                localp.DPi.iyX = true;
                if (!localp.dPh) {
                  bc.ajj().a(localp.DPi, 0);
                }
                localp.DPi = null;
                ae.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              }
              AppMethodBeat.o(30005);
              return;
            }
            localp.a(i, localefm);
            AppMethodBeat.o(30005);
            return;
          }
          localp.reset();
          localp.DPm = i;
          ae.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.DPm) });
          o.deleteFile(p.DPh);
          if (localp.DPk == null)
          {
            localp.DPk = new com.tencent.mm.audio.e.d();
            localp.DPk.gI(p.DPh);
          }
          if (localp.DPj == null)
          {
            localp.DPj = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
            if (localp.DPj.fYh() != 0)
            {
              localp.DPn = -2;
              AppMethodBeat.o(30005);
              return;
            }
          }
          localObject = localefm.HGP;
          if (localp.DPi == null) {
            ar.f(new p.1(localp, (String)localObject));
          }
          localp.a(i, localefm);
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
      if (a.eOd().eOo() != null) {
        a.eOd().eOo().eOq();
      }
      AppMethodBeat.o(30006);
    }
    
    public final String getName()
    {
      return "RefreshConnectTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic
 * JD-Core Version:    0.7.0.1
 */