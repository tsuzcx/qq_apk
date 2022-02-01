package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.cc;
import com.tencent.pb.talkroom.sdk.d;

public class m
  implements f
{
  private c.a dhz;
  private com.tencent.mm.audio.b.c oWf;
  public d wbf;
  private l wbg;
  private com.tencent.pb.talkroom.sdk.c wbh;
  private com.tencent.pb.talkroom.sdk.b wbi;
  private com.tencent.mm.plugin.voip.model.b wbj;
  
  public m()
  {
    AppMethodBeat.i(114437);
    this.dhz = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(114435);
        ad.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        z.dqx();
        o.dqh();
        AppMethodBeat.o(114435);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114434);
        if (paramAnonymousInt <= 0)
        {
          ad.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
          AppMethodBeat.o(114434);
          return;
        }
        if (m.f(m.this) != null) {
          m.f(m.this).ab(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(114434);
      }
    };
    this.wbj = new com.tencent.mm.plugin.voip.model.b()
    {
      public final int O(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114436);
        if (m.g(m.this) != null) {}
        for (paramAnonymousInt = m.g(m.this).aa(paramAnonymousArrayOfByte, paramAnonymousInt);; paramAnonymousInt = 0)
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
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.fZz();
    com.tencent.wecall.talkroom.model.e.lr(localContext);
    this.wbf = locale;
    this.wbf.fTn();
    this.wbg = new l();
    int i = bt.n((Integer)g.ajC().gBh.get(1));
    this.wbf.a(z.dqx(), new com.tencent.pb.talkroom.sdk.e()
    {
      public final boolean E(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(114420);
        m.D(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(114420);
        return false;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.b paramAnonymousb)
      {
        AppMethodBeat.i(114426);
        m.a(m.this, paramAnonymousb);
        paramAnonymousInt1 = m.c(m.this).a(m.b(m.this), paramAnonymousInt1, paramAnonymousInt2);
        ad.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Boolean.valueOf(z.dqx().lbb) });
        if ((com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn() != z.dqx().lbb) && (z.dqx().cae()) && (z.dqx().wbN != null)) {
          z.dqx().wbN.oF(z.dqx().lbb);
        }
        AppMethodBeat.o(114426);
        return paramAnonymousInt1;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.c paramAnonymousc)
      {
        AppMethodBeat.i(114427);
        m.a(m.this, paramAnonymousc);
        m.a(m.this, new com.tencent.mm.audio.b.c(paramAnonymousInt1, 1, 7));
        m.d(m.this).hO(paramAnonymousInt2);
        m.d(m.this).cv(true);
        m.d(m.this).PN();
        m.d(m.this).dgW = -19;
        m.d(m.this).t(1, false);
        m.d(m.this).cu(true);
        m.d(m.this).dhh = m.e(m.this);
        if (m.d(m.this).PP())
        {
          AppMethodBeat.o(114427);
          return 1;
        }
        AppMethodBeat.o(114427);
        return -1;
      }
      
      public final int aaf()
      {
        AppMethodBeat.i(114423);
        int i = com.tencent.mm.compatible.deviceinfo.m.aaf();
        AppMethodBeat.o(114423);
        return i;
      }
      
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(114421);
        ad.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramAnonymousInt1 + " cmdid " + paramAnonymousInt2);
        paramAnonymousArrayOfByte = new v(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        g.aiU().a(paramAnonymousArrayOfByte, 0);
        AppMethodBeat.o(114421);
        return false;
      }
      
      public final boolean dpj()
      {
        AppMethodBeat.i(114422);
        ad.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(com.tencent.mm.compatible.deviceinfo.m.aaf())));
        m.class.getClassLoader();
        j.vr("voipMain");
        AppMethodBeat.o(114422);
        return true;
      }
      
      public final int dpk()
      {
        AppMethodBeat.i(206562);
        int i = 2;
        if (k.arr("video/avc")) {
          i = 10;
        }
        ad.i("MicroMsg.MT.MultiTalkEngine", "CodecList[%d]", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(206562);
        return i;
      }
      
      public final int dpl()
      {
        AppMethodBeat.i(114424);
        String str = g.ajC().ajm().fsH();
        ae.vi(str);
        ad.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(str)));
        m.a(m.this);
        AppMethodBeat.o(114424);
        return 0;
      }
      
      public final boolean dpm()
      {
        AppMethodBeat.i(114428);
        ad.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        l locall = m.c(m.this);
        synchronized (locall.oWv)
        {
          ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(locall.isStart), Integer.valueOf(locall.hashCode()) });
          if (locall.isStart)
          {
            com.tencent.mm.plugin.voip.model.c localc = locall.oVX;
            if (localc != null)
            {
              locall.oWx.gdx = SystemClock.elapsedRealtime();
              localc.euU();
              ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + locall.oWx.abj());
              localc.euR();
              locall.isStart = false;
              locall.oVX = null;
            }
            if (z.dqx().wbN != null) {
              z.dqx().wbN.doI();
            }
          }
          AppMethodBeat.o(114428);
          return true;
        }
      }
      
      public final boolean dpn()
      {
        AppMethodBeat.i(114429);
        ad.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try
        {
          if (m.d(m.this) != null)
          {
            m.d(m.this).dhh = null;
            m.d(m.this).PG();
          }
          m.a(m.this, null);
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
      
      public final int dpo()
      {
        int j = 0;
        AppMethodBeat.i(114430);
        ad.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        int i = j;
        if (m.c(m.this) != null)
        {
          i = j;
          if (z.dqx().wbN != null)
          {
            com.tencent.mm.plugin.voip.model.c localc = z.dqx().wbN.vZU;
            i = j;
            if (localc != null) {
              i = localc.aNs();
            }
          }
        }
        float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
        i = (int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F);
        AppMethodBeat.o(114430);
        return i;
      }
      
      public final int dpp()
      {
        AppMethodBeat.i(114431);
        ad.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (m.d(m.this) != null)
        {
          int i = m.d(m.this).PS();
          AppMethodBeat.o(114431);
          return i;
        }
        AppMethodBeat.o(114431);
        return -2;
      }
      
      public final int dpq()
      {
        AppMethodBeat.i(114432);
        ad.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (m.d(m.this) != null)
        {
          int i = m.d(m.this).dgL;
          AppMethodBeat.o(114432);
          return i;
        }
        AppMethodBeat.o(114432);
        return 0;
      }
      
      public final int dpr()
      {
        AppMethodBeat.i(114433);
        ad.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if ((m.c(m.this) != null) && (z.dqx().wbN != null))
        {
          com.tencent.mm.plugin.voip.model.c localc = z.dqx().wbN.vZU;
          if (localc != null)
          {
            int i = localc.euV();
            AppMethodBeat.o(114433);
            return i;
          }
          AppMethodBeat.o(114433);
          return 0;
        }
        AppMethodBeat.o(114433);
        return 0;
      }
      
      public final boolean oM(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(114425);
        ad.m("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (z.dqx().wbN != null) {
          z.dqx().wbN.oF(paramAnonymousBoolean);
        }
        AppMethodBeat.o(114425);
        return true;
      }
    });
    this.wbf.cW(i, u.aAm());
    g.aiU().a(1918, this);
    g.aiU().a(1919, this);
    g.aiU().a(1927, this);
    g.aiU().a(1928, this);
    g.aiU().a(1929, this);
    g.aiU().a(1931, this);
    g.aiU().a(1932, this);
    g.aiU().a(1933, this);
    g.aiU().a(1935, this);
    g.aiU().a(1937, this);
    g.aiU().a(1938, this);
    g.aiU().a(1939, this);
    AppMethodBeat.o(114437);
  }
  
  public final d dpi()
  {
    return this.wbf;
  }
  
  public final void oJ(boolean paramBoolean)
  {
    AppMethodBeat.i(114439);
    ad.m("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.wbf.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.bGx()) {
        this.wbf.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.bGD()) {
        break label143;
      }
      this.wbf.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(114439);
      return;
    }
    this.wbf.setAppCmd(441, arrayOfByte, 1);
    this.wbf.setAppCmd(442, arrayOfByte, 1);
    label143:
    AppMethodBeat.o(114439);
  }
  
  public final void oK(boolean paramBoolean)
  {
    AppMethodBeat.i(206563);
    ad.l("MicroMsg.MT.MultiTalkEngine", "setEngineSpeakerOn, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      this.wbf.setAppCmd(401, arrayOfByte, 1);
      AppMethodBeat.o(206563);
      return;
    }
    arrayOfByte[0] = 0;
    this.wbf.setAppCmd(402, arrayOfByte, 1);
    AppMethodBeat.o(206563);
  }
  
  public final void oL(boolean paramBoolean)
  {
    AppMethodBeat.i(206564);
    ad.l("MicroMsg.MT.MultiTalkEngine", "setEngineMicOn, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      this.wbf.setAppCmd(413, arrayOfByte, 1);
      AppMethodBeat.o(206564);
      return;
    }
    arrayOfByte[0] = 0;
    this.wbf.setAppCmd(412, arrayOfByte, 1);
    AppMethodBeat.o(206564);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(114438);
    paramString = (v)paramn;
    ad.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.wbf.d(paramInt2, paramString.pZT, paramString.mCmdId, paramString.dMj);
    AppMethodBeat.o(114438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m
 * JD-Core Version:    0.7.0.1
 */