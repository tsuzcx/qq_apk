package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.protocal.protobuf.edv;
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
    ((com.tencent.mm.plugin.boots.a.c)g.ab(com.tencent.mm.plugin.boots.a.c.class)).eN(com.tencent.mm.plugin.boots.a.b.nTY, 1170);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new a((byte)0);
        paramIntent.Dxa = i;
        paramIntent.ikW = paramContext.getInt("key_funid");
        paramIntent.dlK = paramContext.getInt("key_sessionid");
        paramIntent.Dxb = paramContext.getByteArray("key_data");
        paramContext = a.eKy().VW(paramIntent.ikW);
        if (paramContext != null) {}
        for (boolean bool = paramContext.VV(paramIntent.ikW); bool; bool = false)
        {
          aq.f(paramIntent);
          AppMethodBeat.o(30008);
          return;
        }
        com.tencent.mm.sdk.g.b.c(paramIntent, "WearHttpMessageTask_" + paramIntent.ikW);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.Dxa = i;
        paramIntent.ikW = paramContext.getInt("key_funid");
        paramIntent.dlK = paramContext.getInt("key_sessionid");
        paramIntent.Dxb = paramContext.getByteArray("key_data");
        a.eKw().a(paramIntent);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 3) {
        a.eKw().a(new c((byte)0));
      }
    }
    AppMethodBeat.o(30008);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int Dxa;
    public byte[] Dxb;
    public int dlK;
    public int ikW;
    
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30003);
      ad.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
      com.tencent.mm.plugin.wear.model.e.a locala = a.eKy().VW(this.ikW);
      if (locala != null) {
        locala.c(this.Dxa, this.dlK, this.ikW, this.Dxb);
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
      String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.Dxa), Integer.valueOf(this.ikW), Integer.valueOf(this.dlK) });
      AppMethodBeat.o(30004);
      return str;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int Dxa;
    public byte[] Dxb;
    public int dlK;
    public int ikW;
    
    private b() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30005);
      switch (this.ikW)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30005);
        return;
        p localp = a.eKv().DwP;
        int i = this.dlK;
        Object localObject = this.Dxb;
        if (localp.kcc.contains(Integer.valueOf(i))) {
          continue;
        }
        edv localedv = new edv();
        try
        {
          localedv.parseFrom((byte[])localObject);
          label82:
          if (localp.DxH == i)
          {
            if (localedv.HPj)
            {
              ad.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              AppMethodBeat.o(30005);
              return;
            }
            if (localedv.HPi)
            {
              localp.a(i, localedv);
              if (localp.DxF != null)
              {
                localp.DxF.Ry();
                localp.DxF = null;
                ad.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.DxE != null)
              {
                localp.DxE.stop();
                localp.DxE = null;
                ad.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.DxD != null)
              {
                localp.DxD.iwe = true;
                if (!localp.dNR) {
                  ba.aiU().a(localp.DxD, 0);
                }
                localp.DxD = null;
                ad.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              }
              AppMethodBeat.o(30005);
              return;
            }
            localp.a(i, localedv);
            AppMethodBeat.o(30005);
            return;
          }
          localp.reset();
          localp.DxH = i;
          ad.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.DxH) });
          i.deleteFile(p.DxC);
          if (localp.DxF == null)
          {
            localp.DxF = new com.tencent.mm.audio.e.d();
            localp.DxF.gC(p.DxC);
          }
          if (localp.DxE == null)
          {
            localp.DxE = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
            if (localp.DxE.fTH() != 0)
            {
              localp.DxI = -2;
              AppMethodBeat.o(30005);
              return;
            }
          }
          localObject = localedv.Hnp;
          if (localp.DxD == null) {
            aq.f(new p.1(localp, (String)localObject));
          }
          localp.a(i, localedv);
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
      if (a.eKv().eKG() != null) {
        a.eKv().eKG().eKI();
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