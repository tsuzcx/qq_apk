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
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
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
    ai.getContext().registerReceiver(this, localIntentFilter, "com.tencent.mm.wear.message", null);
    AppMethodBeat.o(30007);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(30008);
    ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eJ(com.tencent.mm.plugin.boots.a.b.ntc, 1170);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new a((byte)0);
        paramIntent.BWG = i;
        paramIntent.hRI = paramContext.getInt("key_funid");
        paramIntent.daq = paramContext.getInt("key_sessionid");
        paramIntent.BWH = paramContext.getByteArray("key_data");
        paramContext = a.ews().Ue(paramIntent.hRI);
        if (paramContext != null) {}
        for (boolean bool = paramContext.Ud(paramIntent.hRI); bool; bool = false)
        {
          ap.f(paramIntent);
          AppMethodBeat.o(30008);
          return;
        }
        com.tencent.mm.sdk.g.b.c(paramIntent, "WearHttpMessageTask_" + paramIntent.hRI);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.BWG = i;
        paramIntent.hRI = paramContext.getInt("key_funid");
        paramIntent.daq = paramContext.getInt("key_sessionid");
        paramIntent.BWH = paramContext.getByteArray("key_data");
        a.ewq().a(paramIntent);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 3) {
        a.ewq().a(new c((byte)0));
      }
    }
    AppMethodBeat.o(30008);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int BWG;
    public byte[] BWH;
    public int daq;
    public int hRI;
    
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30003);
      ac.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
      com.tencent.mm.plugin.wear.model.e.a locala = a.ews().Ue(this.hRI);
      if (locala != null) {
        locala.c(this.BWG, this.daq, this.hRI, this.BWH);
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
      String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.BWG), Integer.valueOf(this.hRI), Integer.valueOf(this.daq) });
      AppMethodBeat.o(30004);
      return str;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int BWG;
    public byte[] BWH;
    public int daq;
    public int hRI;
    
    private b() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30005);
      switch (this.hRI)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30005);
        return;
        p localp = a.ewp().BWv;
        int i = this.daq;
        Object localObject = this.BWH;
        if (localp.jHQ.contains(Integer.valueOf(i))) {
          continue;
        }
        dxv localdxv = new dxv();
        try
        {
          localdxv.parseFrom((byte[])localObject);
          label82:
          if (localp.BXo == i)
          {
            if (localdxv.Ged)
            {
              ac.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              AppMethodBeat.o(30005);
              return;
            }
            if (localdxv.Gec)
            {
              localp.a(i, localdxv);
              if (localp.BXm != null)
              {
                localp.BXm.PM();
                localp.BXm = null;
                ac.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.BXl != null)
              {
                localp.BXl.stop();
                localp.BXl = null;
                ac.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.BXk != null)
              {
                localp.BXk.icI = true;
                if (!localp.dBE) {
                  az.agi().a(localp.BXk, 0);
                }
                localp.BXk = null;
                ac.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              }
              AppMethodBeat.o(30005);
              return;
            }
            localp.a(i, localdxv);
            AppMethodBeat.o(30005);
            return;
          }
          localp.reset();
          localp.BXo = i;
          ac.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.BXo) });
          i.deleteFile(p.BXj);
          if (localp.BXm == null)
          {
            localp.BXm = new com.tencent.mm.audio.e.d();
            localp.BXm.fH(p.BXj);
          }
          if (localp.BXl == null)
          {
            localp.BXl = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
            if (localp.BXl.fCr() != 0)
            {
              localp.BXp = -2;
              AppMethodBeat.o(30005);
              return;
            }
          }
          localObject = localdxv.FDc;
          if (localp.BXk == null) {
            ap.f(new p.1(localp, (String)localObject));
          }
          localp.a(i, localdxv);
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
      if (a.ewp().ewA() != null) {
        a.ewp().ewA().ewC();
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