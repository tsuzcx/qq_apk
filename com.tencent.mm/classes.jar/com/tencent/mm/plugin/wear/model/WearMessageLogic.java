package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.1;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.protocal.protobuf.ezu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.LinkedList;

public class WearMessageLogic
  extends BroadcastReceiver
{
  private static final String IxU;
  
  static
  {
    AppMethodBeat.i(232127);
    IxU = WeChatPermissions.PERMISSION_WEAR_MESSAGE();
    AppMethodBeat.o(232127);
  }
  
  public WearMessageLogic()
  {
    AppMethodBeat.i(30007);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.wear.message");
    MMApplicationContext.getContext().registerReceiver(this, localIntentFilter, IxU, null);
    AppMethodBeat.o(30007);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(30008);
    ((com.tencent.mm.plugin.boots.a.c)g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(com.tencent.mm.plugin.boots.a.b.pkC, 1170);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new a((byte)0);
        paramIntent.IxV = i;
        paramIntent.jiX = paramContext.getInt("key_funid");
        paramIntent.dEb = paramContext.getInt("key_sessionid");
        paramIntent.IxW = paramContext.getByteArray("key_data");
        paramContext = a.fVP().afj(paramIntent.jiX);
        if (paramContext != null) {}
        for (boolean bool = paramContext.afi(paramIntent.jiX); bool; bool = false)
        {
          MMHandlerThread.postToMainThread(paramIntent);
          AppMethodBeat.o(30008);
          return;
        }
        ThreadPool.post(paramIntent, "WearHttpMessageTask_" + paramIntent.jiX);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 2)
      {
        paramIntent = new b((byte)0);
        paramIntent.IxV = i;
        paramIntent.jiX = paramContext.getInt("key_funid");
        paramIntent.dEb = paramContext.getInt("key_sessionid");
        paramIntent.IxW = paramContext.getByteArray("key_data");
        a.fVN().a(paramIntent);
        AppMethodBeat.o(30008);
        return;
      }
      if (i == 3) {
        a.fVN().a(new c((byte)0));
      }
    }
    AppMethodBeat.o(30008);
  }
  
  final class a
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int IxV;
    public byte[] IxW;
    public int dEb;
    public int jiX;
    
    private a() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30003);
      Log.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[] { toString() });
      com.tencent.mm.plugin.wear.model.e.a locala = a.fVP().afj(this.jiX);
      if (locala != null) {
        locala.c(this.IxV, this.dEb, this.jiX, this.IxW);
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
      String str = String.format("connectType=%d funId=%d sessionId=%d", new Object[] { Integer.valueOf(this.IxV), Integer.valueOf(this.jiX), Integer.valueOf(this.dEb) });
      AppMethodBeat.o(30004);
      return str;
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.wear.model.f.d
  {
    public int IxV;
    public byte[] IxW;
    public int dEb;
    public int jiX;
    
    private b() {}
    
    public final void execute()
    {
      AppMethodBeat.i(30005);
      switch (this.jiX)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(30005);
        return;
        p localp = a.fVM().IxJ;
        int i = this.dEb;
        Object localObject = this.IxW;
        if (localp.ljc.contains(Integer.valueOf(i))) {
          continue;
        }
        ezu localezu = new ezu();
        try
        {
          localezu.parseFrom((byte[])localObject);
          label82:
          if (localp.IyC == i)
          {
            if (localezu.NvU)
            {
              Log.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[] { Integer.valueOf(i) });
              localp.reset();
              AppMethodBeat.o(30005);
              return;
            }
            if (localezu.NvT)
            {
              localp.a(i, localezu);
              if (localp.IyA != null)
              {
                localp.IyA.abP();
                localp.IyA = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
              }
              if (localp.Iyz != null)
              {
                localp.Iyz.stop();
                localp.Iyz = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
              }
              if (localp.Iyy != null)
              {
                localp.Iyy.jul = true;
                if (!localp.ehd) {
                  bg.azz().a(localp.Iyy, 0);
                }
                localp.Iyy = null;
                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
              }
              AppMethodBeat.o(30005);
              return;
            }
            localp.a(i, localezu);
            AppMethodBeat.o(30005);
            return;
          }
          localp.reset();
          localp.IyC = i;
          Log.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[] { Integer.valueOf(localp.IyC) });
          s.deleteFile(p.Iyx);
          if (localp.IyA == null)
          {
            localp.IyA = new com.tencent.mm.audio.e.d();
            localp.IyA.hz(p.Iyx);
          }
          if (localp.Iyz == null)
          {
            localp.Iyz = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
            if (localp.Iyz.hkt() != 0)
            {
              localp.IyD = -2;
              AppMethodBeat.o(30005);
              return;
            }
          }
          localObject = localezu.MRZ;
          if (localp.Iyy == null) {
            MMHandlerThread.postToMainThread(new p.1(localp, (String)localObject));
          }
          localp.a(i, localezu);
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
      if (a.fVM().fVX() != null) {
        a.fVM().fVX().fVZ();
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