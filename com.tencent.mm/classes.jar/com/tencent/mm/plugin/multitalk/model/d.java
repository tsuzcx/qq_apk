package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.aa;

public class d
  implements com.tencent.mm.al.g
{
  private c.a cYN;
  private com.tencent.mm.audio.b.c nPF;
  public com.tencent.pb.talkroom.sdk.d tOr;
  private c tOs;
  private com.tencent.pb.talkroom.sdk.c tOt;
  private com.tencent.pb.talkroom.sdk.b tOu;
  private com.tencent.mm.plugin.voip.model.b tOv;
  
  public d()
  {
    AppMethodBeat.i(114437);
    this.cYN = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(114435);
        ad.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        p.cSO();
        f.cSz();
        AppMethodBeat.o(114435);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114434);
        if (paramAnonymousInt <= 0)
        {
          ad.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
          AppMethodBeat.o(114434);
          return;
        }
        if (d.f(d.this) != null) {
          d.f(d.this).ab(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(114434);
      }
    };
    this.tOv = new com.tencent.mm.plugin.voip.model.b()
    {
      public final int Q(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114436);
        if (d.g(d.this) != null) {}
        for (paramAnonymousInt = d.g(d.this).aa(paramAnonymousArrayOfByte, paramAnonymousInt);; paramAnonymousInt = 0)
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
    ad.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = aj.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.fpN();
    com.tencent.wecall.talkroom.model.e.kQ(localContext);
    this.tOr = locale;
    this.tOr.flH();
    this.tOs = new c();
    int i = com.tencent.mm.sdk.platformtools.bt.l((Integer)com.tencent.mm.kernel.g.afB().gcR.get(1));
    this.tOr.a(p.cSO(), new com.tencent.pb.talkroom.sdk.e()
    {
      public final boolean F(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(114420);
        d.E(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(114420);
        return false;
      }
      
      public final int WG()
      {
        AppMethodBeat.i(114423);
        int i = m.WG();
        AppMethodBeat.o(114423);
        return i;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.b paramAnonymousb)
      {
        AppMethodBeat.i(114426);
        d.a(d.this, paramAnonymousb);
        paramAnonymousInt1 = d.c(d.this).a(d.b(d.this), paramAnonymousInt1, paramAnonymousInt2);
        ad.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Boolean.valueOf(p.cSO().tOC) });
        if ((com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn() != p.cSO().tOC) && (p.cSO().cSx()) && (p.cSO().tPb != null)) {
          p.cSO().tPb.nr(p.cSO().tOC);
        }
        AppMethodBeat.o(114426);
        return paramAnonymousInt1;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.c paramAnonymousc)
      {
        AppMethodBeat.i(114427);
        d.a(d.this, paramAnonymousc);
        d.a(d.this, new com.tencent.mm.audio.b.c(paramAnonymousInt1, 1, 7));
        d.d(d.this).hX(paramAnonymousInt2);
        d.d(d.this).cs(true);
        d.d(d.this).Oi();
        d.d(d.this).cYk = -19;
        d.d(d.this).t(1, false);
        d.d(d.this).cr(true);
        d.d(d.this).cYv = d.e(d.this);
        if (d.d(d.this).Ok())
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
        ad.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramAnonymousInt1 + " cmdid " + paramAnonymousInt2);
        paramAnonymousArrayOfByte = new o(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        com.tencent.mm.kernel.g.aeS().a(paramAnonymousArrayOfByte, 0);
        AppMethodBeat.o(114421);
        return false;
      }
      
      public final boolean cRJ()
      {
        AppMethodBeat.i(114422);
        ad.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(m.WG())));
        d.class.getClassLoader();
        j.pq("voipMain");
        AppMethodBeat.o(114422);
        return true;
      }
      
      public final int cRK()
      {
        AppMethodBeat.i(114424);
        String str = com.tencent.mm.kernel.g.afB().afl().eMW();
        ae.ph(str);
        ad.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(str)));
        d.a(d.this);
        AppMethodBeat.o(114424);
        return 0;
      }
      
      public final boolean cRL()
      {
        AppMethodBeat.i(114428);
        ad.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        c localc = d.c(d.this);
        synchronized (localc.nPU)
        {
          ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localc.isStart), Integer.valueOf(localc.hashCode()) });
          if (localc.isStart)
          {
            com.tencent.mm.plugin.voip.model.c localc1 = localc.nPx;
            if (localc1 != null)
            {
              localc.nPW.fGp = SystemClock.elapsedRealtime();
              localc1.dRW();
              ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + localc.nPW.XK());
              localc1.dRT();
              localc.isStart = false;
              localc.nPx = null;
            }
            if (p.cSO().tPb != null) {
              p.cSO().tPb.cRA();
            }
          }
          AppMethodBeat.o(114428);
          return true;
        }
      }
      
      public final boolean cRM()
      {
        AppMethodBeat.i(114429);
        ad.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try
        {
          if (d.d(d.this) != null)
          {
            d.d(d.this).cYv = null;
            d.d(d.this).Ob();
          }
          d.a(d.this, null);
          AppMethodBeat.o(114429);
          return true;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(localException)));
          AppMethodBeat.o(114429);
        }
        return false;
      }
      
      public final int cRN()
      {
        int j = 0;
        AppMethodBeat.i(114430);
        ad.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        int i = j;
        if (d.c(d.this) != null)
        {
          i = j;
          if (p.cSO().tPb != null)
          {
            com.tencent.mm.plugin.voip.model.c localc = p.cSO().tPb.tOj;
            i = j;
            if (localc != null) {
              i = localc.aDs();
            }
          }
        }
        float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
        i = (int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F);
        AppMethodBeat.o(114430);
        return i;
      }
      
      public final int cRO()
      {
        AppMethodBeat.i(114431);
        ad.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (d.d(d.this) != null)
        {
          int i = d.d(d.this).On();
          AppMethodBeat.o(114431);
          return i;
        }
        AppMethodBeat.o(114431);
        return -2;
      }
      
      public final int cRP()
      {
        AppMethodBeat.i(114432);
        ad.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (d.d(d.this) != null)
        {
          int i = d.d(d.this).cXZ;
          AppMethodBeat.o(114432);
          return i;
        }
        AppMethodBeat.o(114432);
        return 0;
      }
      
      public final int cRQ()
      {
        AppMethodBeat.i(114433);
        ad.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if ((d.c(d.this) != null) && (p.cSO().tPb != null))
        {
          com.tencent.mm.plugin.voip.model.c localc = p.cSO().tPb.tOj;
          if (localc != null)
          {
            int i = localc.dRX();
            AppMethodBeat.o(114433);
            return i;
          }
          AppMethodBeat.o(114433);
          return 0;
        }
        AppMethodBeat.o(114433);
        return 0;
      }
      
      public final boolean nw(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(114425);
        ad.m("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (p.cSO().tPb != null) {
          p.cSO().tPb.nr(paramAnonymousBoolean);
        }
        AppMethodBeat.o(114425);
        return true;
      }
    });
    this.tOr.cL(i, u.aqG());
    com.tencent.mm.kernel.g.aeS().a(1918, this);
    com.tencent.mm.kernel.g.aeS().a(1919, this);
    com.tencent.mm.kernel.g.aeS().a(1927, this);
    com.tencent.mm.kernel.g.aeS().a(1928, this);
    com.tencent.mm.kernel.g.aeS().a(1929, this);
    com.tencent.mm.kernel.g.aeS().a(1931, this);
    com.tencent.mm.kernel.g.aeS().a(1932, this);
    com.tencent.mm.kernel.g.aeS().a(1933, this);
    com.tencent.mm.kernel.g.aeS().a(1935, this);
    com.tencent.mm.kernel.g.aeS().a(1937, this);
    com.tencent.mm.kernel.g.aeS().a(1938, this);
    com.tencent.mm.kernel.g.aeS().a(1939, this);
    AppMethodBeat.o(114437);
  }
  
  public final void nv(boolean paramBoolean)
  {
    AppMethodBeat.i(114439);
    ad.m("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.tOr.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.bvw()) {
        this.tOr.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.bvC()) {
        break label143;
      }
      this.tOr.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(114439);
      return;
    }
    this.tOr.setAppCmd(441, arrayOfByte, 1);
    this.tOr.setAppCmd(442, arrayOfByte, 1);
    label143:
    AppMethodBeat.o(114439);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(114438);
    paramString = (o)paramn;
    ad.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.tOr.d(paramInt2, paramString.oTd, paramString.mCmdId, paramString.dCi);
    AppMethodBeat.o(114438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.d
 * JD-Core Version:    0.7.0.1
 */