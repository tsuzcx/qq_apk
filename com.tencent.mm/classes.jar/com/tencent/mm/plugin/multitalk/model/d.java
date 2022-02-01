package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bw;

public class d
  implements com.tencent.mm.ak.g
{
  private c.a cWj;
  private com.tencent.mm.audio.b.c osJ;
  public com.tencent.pb.talkroom.sdk.d uWU;
  private c uWV;
  private com.tencent.pb.talkroom.sdk.c uWW;
  private com.tencent.pb.talkroom.sdk.b uWX;
  private com.tencent.mm.plugin.voip.model.b uWY;
  
  public d()
  {
    AppMethodBeat.i(114437);
    this.cWj = new c.a()
    {
      public final void cf(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(114435);
        ac.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        p.dgx();
        f.dgi();
        AppMethodBeat.o(114435);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114434);
        if (paramAnonymousInt <= 0)
        {
          ac.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
          AppMethodBeat.o(114434);
          return;
        }
        if (d.f(d.this) != null) {
          d.f(d.this).aa(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(114434);
      }
    };
    this.uWY = new com.tencent.mm.plugin.voip.model.b()
    {
      public final int O(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114436);
        if (d.g(d.this) != null) {}
        for (paramAnonymousInt = d.g(d.this).Z(paramAnonymousArrayOfByte, paramAnonymousInt);; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt < 0)
          {
            AppMethodBeat.o(114436);
            return -1;
          }
          AppMethodBeat.o(114436);
          return 0;
        }
      }
    };
    ac.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = ai.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.fIi();
    com.tencent.wecall.talkroom.model.e.le(localContext);
    this.uWU = locale;
    this.uWU.fBY();
    this.uWV = new c();
    int i = bs.m((Integer)com.tencent.mm.kernel.g.agR().ghx.get(1));
    this.uWU.a(p.dgx(), new com.tencent.pb.talkroom.sdk.e()
    {
      public final boolean F(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(114420);
        d.E(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(114420);
        return false;
      }
      
      public final int XE()
      {
        AppMethodBeat.i(114423);
        int i = m.XE();
        AppMethodBeat.o(114423);
        return i;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.b paramAnonymousb)
      {
        AppMethodBeat.i(114426);
        d.a(d.this, paramAnonymousb);
        paramAnonymousInt1 = d.c(d.this).a(d.b(d.this), paramAnonymousInt1, paramAnonymousInt2);
        ac.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Boolean.valueOf(p.dgx().kER) });
        if ((com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn() != p.dgx().kER) && (p.dgx().bVB()) && (p.dgx().uXD != null)) {
          p.dgx().uXD.ol(p.dgx().kER);
        }
        AppMethodBeat.o(114426);
        return paramAnonymousInt1;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.c paramAnonymousc)
      {
        AppMethodBeat.i(114427);
        d.a(d.this, paramAnonymousc);
        d.a(d.this, new com.tencent.mm.audio.b.c(paramAnonymousInt1, 1, 7));
        d.d(d.this).hH(paramAnonymousInt2);
        d.d(d.this).ct(true);
        d.d(d.this).Oe();
        d.d(d.this).cVG = -19;
        d.d(d.this).t(1, false);
        d.d(d.this).cs(true);
        d.d(d.this).cVR = d.e(d.this);
        if (d.d(d.this).Og())
        {
          AppMethodBeat.o(114427);
          return 1;
        }
        AppMethodBeat.o(114427);
        return -1;
      }
      
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(114421);
        ac.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramAnonymousInt1 + " cmdid " + paramAnonymousInt2);
        paramAnonymousArrayOfByte = new o(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        com.tencent.mm.kernel.g.agi().a(paramAnonymousArrayOfByte, 0);
        AppMethodBeat.o(114421);
        return false;
      }
      
      public final int dfA()
      {
        AppMethodBeat.i(114433);
        ac.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if ((d.c(d.this) != null) && (p.dgx().uXD != null))
        {
          com.tencent.mm.plugin.voip.model.c localc = p.dgx().uXD.uWM;
          if (localc != null)
          {
            int i = localc.ehj();
            AppMethodBeat.o(114433);
            return i;
          }
          AppMethodBeat.o(114433);
          return 0;
        }
        AppMethodBeat.o(114433);
        return 0;
      }
      
      public final boolean dft()
      {
        AppMethodBeat.i(114422);
        ac.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(m.XE())));
        d.class.getClassLoader();
        j.sC("voipMain");
        AppMethodBeat.o(114422);
        return true;
      }
      
      public final int dfu()
      {
        AppMethodBeat.i(114424);
        String str = com.tencent.mm.kernel.g.agR().agB().fcA();
        ae.st(str);
        ac.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(str)));
        d.a(d.this);
        AppMethodBeat.o(114424);
        return 0;
      }
      
      public final boolean dfv()
      {
        AppMethodBeat.i(114428);
        ac.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        c localc = d.c(d.this);
        synchronized (localc.osZ)
        {
          ac.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localc.isStart), Integer.valueOf(localc.hashCode()) });
          if (localc.isStart)
          {
            com.tencent.mm.plugin.voip.model.c localc1 = localc.osB;
            if (localc1 != null)
            {
              localc.otb.fJW = SystemClock.elapsedRealtime();
              localc1.ehi();
              ac.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + localc.otb.YH());
              localc1.ehf();
              localc.isStart = false;
              localc.osB = null;
            }
            if (p.dgx().uXD != null) {
              p.dgx().uXD.dfk();
            }
          }
          AppMethodBeat.o(114428);
          return true;
        }
      }
      
      public final boolean dfw()
      {
        AppMethodBeat.i(114429);
        ac.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try
        {
          if (d.d(d.this) != null)
          {
            d.d(d.this).cVR = null;
            d.d(d.this).NX();
          }
          d.a(d.this, null);
          AppMethodBeat.o(114429);
          return true;
        }
        catch (Exception localException)
        {
          ac.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(localException)));
          AppMethodBeat.o(114429);
        }
        return false;
      }
      
      public final int dfx()
      {
        int j = 0;
        AppMethodBeat.i(114430);
        ac.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        int i = j;
        if (d.c(d.this) != null)
        {
          i = j;
          if (p.dgx().uXD != null)
          {
            com.tencent.mm.plugin.voip.model.c localc = p.dgx().uXD.uWM;
            i = j;
            if (localc != null) {
              i = localc.aKj();
            }
          }
        }
        float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
        i = (int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F);
        AppMethodBeat.o(114430);
        return i;
      }
      
      public final int dfy()
      {
        AppMethodBeat.i(114431);
        ac.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (d.d(d.this) != null)
        {
          int i = d.d(d.this).Oj();
          AppMethodBeat.o(114431);
          return i;
        }
        AppMethodBeat.o(114431);
        return -2;
      }
      
      public final int dfz()
      {
        AppMethodBeat.i(114432);
        ac.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (d.d(d.this) != null)
        {
          int i = d.d(d.this).cVv;
          AppMethodBeat.o(114432);
          return i;
        }
        AppMethodBeat.o(114432);
        return 0;
      }
      
      public final boolean oq(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(114425);
        ac.m("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (p.dgx().uXD != null) {
          p.dgx().uXD.ol(paramAnonymousBoolean);
        }
        AppMethodBeat.o(114425);
        return true;
      }
    });
    this.uWU.cO(i, u.axw());
    com.tencent.mm.kernel.g.agi().a(1918, this);
    com.tencent.mm.kernel.g.agi().a(1919, this);
    com.tencent.mm.kernel.g.agi().a(1927, this);
    com.tencent.mm.kernel.g.agi().a(1928, this);
    com.tencent.mm.kernel.g.agi().a(1929, this);
    com.tencent.mm.kernel.g.agi().a(1931, this);
    com.tencent.mm.kernel.g.agi().a(1932, this);
    com.tencent.mm.kernel.g.agi().a(1933, this);
    com.tencent.mm.kernel.g.agi().a(1935, this);
    com.tencent.mm.kernel.g.agi().a(1937, this);
    com.tencent.mm.kernel.g.agi().a(1938, this);
    com.tencent.mm.kernel.g.agi().a(1939, this);
    AppMethodBeat.o(114437);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(114438);
    paramString = (o)paramn;
    ac.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.uWU.d(paramInt2, paramString.pwo, paramString.mCmdId, paramString.dzW);
    AppMethodBeat.o(114438);
  }
  
  public final void op(boolean paramBoolean)
  {
    AppMethodBeat.i(114439);
    ac.m("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.uWU.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.bCs()) {
        this.uWU.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.bCy()) {
        break label143;
      }
      this.uWU.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(114439);
      return;
    }
    this.uWU.setAppCmd(441, arrayOfByte, 1);
    this.uWU.setAppCmd(442, arrayOfByte, 1);
    label143:
    AppMethodBeat.o(114439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.d
 * JD-Core Version:    0.7.0.1
 */