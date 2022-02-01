package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.cd;
import com.tencent.pb.talkroom.sdk.d;

public class m
  implements f
{
  private c.a diC;
  private com.tencent.mm.audio.b.c pcI;
  public d wqE;
  private l wqF;
  private com.tencent.pb.talkroom.sdk.c wqG;
  private com.tencent.pb.talkroom.sdk.b wqH;
  private com.tencent.mm.plugin.voip.model.b wqI;
  
  public m()
  {
    AppMethodBeat.i(114437);
    this.diC = new c.a()
    {
      public final void ch(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(114435);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        z.dtK();
        o.dtu();
        AppMethodBeat.o(114435);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114434);
        if (paramAnonymousInt <= 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
          AppMethodBeat.o(114434);
          return;
        }
        if (m.f(m.this) != null) {
          m.f(m.this).af(paramAnonymousArrayOfByte, paramAnonymousInt);
        }
        AppMethodBeat.o(114434);
      }
    };
    this.wqI = new com.tencent.mm.plugin.voip.model.b()
    {
      public final int O(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114436);
        if (m.g(m.this) != null) {}
        for (paramAnonymousInt = m.g(m.this).ae(paramAnonymousArrayOfByte, paramAnonymousInt);; paramAnonymousInt = 0)
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = ak.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.gea();
    com.tencent.wecall.talkroom.model.e.lx(localContext);
    this.wqE = locale;
    this.wqE.fXN();
    this.wqF = new l();
    int i = bu.o((Integer)g.ajR().gDO.get(1));
    this.wqE.a(z.dtK(), new com.tencent.pb.talkroom.sdk.e()
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Boolean.valueOf(z.dtK().leL) });
        if ((com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn() != z.dtK().leL) && (z.dtK().cbt()) && (z.dtK().wrl != null)) {
          z.dtK().wrl.oK(z.dtK().leL);
        }
        AppMethodBeat.o(114426);
        return paramAnonymousInt1;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.c paramAnonymousc)
      {
        AppMethodBeat.i(114427);
        m.a(m.this, paramAnonymousc);
        m.a(m.this, new com.tencent.mm.audio.b.c(paramAnonymousInt1, 1, 7));
        m.d(m.this).hQ(paramAnonymousInt2);
        m.d(m.this).cv(true);
        m.d(m.this).PM();
        m.d(m.this).dhY = -19;
        m.d(m.this).t(1, false);
        m.d(m.this).cu(true);
        m.d(m.this).dij = m.e(m.this);
        if (m.d(m.this).PO())
        {
          AppMethodBeat.o(114427);
          return 1;
        }
        AppMethodBeat.o(114427);
        return -1;
      }
      
      public final int aao()
      {
        AppMethodBeat.i(114423);
        int i = com.tencent.mm.compatible.deviceinfo.m.aao();
        AppMethodBeat.o(114423);
        return i;
      }
      
      public final boolean d(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(114421);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramAnonymousInt1 + " cmdid " + paramAnonymousInt2);
        paramAnonymousArrayOfByte = new v(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        g.ajj().a(paramAnonymousArrayOfByte, 0);
        AppMethodBeat.o(114421);
        return false;
      }
      
      public final int dsA()
      {
        AppMethodBeat.i(114431);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (m.d(m.this) != null)
        {
          int i = m.d(m.this).PR();
          AppMethodBeat.o(114431);
          return i;
        }
        AppMethodBeat.o(114431);
        return -2;
      }
      
      public final int dsB()
      {
        AppMethodBeat.i(114432);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (m.d(m.this) != null)
        {
          int i = m.d(m.this).dhN;
          AppMethodBeat.o(114432);
          return i;
        }
        AppMethodBeat.o(114432);
        return 0;
      }
      
      public final int dsC()
      {
        AppMethodBeat.i(114433);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if ((m.c(m.this) != null) && (z.dtK().wrl != null))
        {
          com.tencent.mm.plugin.voip.model.c localc = z.dtK().wrl.wlY;
          if (localc != null)
          {
            int i = localc.eyB();
            AppMethodBeat.o(114433);
            return i;
          }
          AppMethodBeat.o(114433);
          return 0;
        }
        AppMethodBeat.o(114433);
        return 0;
      }
      
      public final boolean dsu()
      {
        AppMethodBeat.i(114422);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(com.tencent.mm.compatible.deviceinfo.m.aao())));
        m.class.getClassLoader();
        j.vN("voipMain");
        AppMethodBeat.o(114422);
        return true;
      }
      
      public final int dsv()
      {
        AppMethodBeat.i(190759);
        int i = 2;
        if (k.asz("video/avc")) {
          i = 10;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "CodecList[%d]", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(190759);
        return i;
      }
      
      public final int dsw()
      {
        AppMethodBeat.i(114424);
        String str = g.ajR().ajB().fwI();
        com.tencent.mm.compatible.deviceinfo.ae.vE(str);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(str)));
        m.a(m.this);
        AppMethodBeat.o(114424);
        return 0;
      }
      
      public final boolean dsx()
      {
        AppMethodBeat.i(114428);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        l locall = m.c(m.this);
        synchronized (locall.pcY)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(locall.isStart), Integer.valueOf(locall.hashCode()) });
          if (locall.isStart)
          {
            com.tencent.mm.plugin.voip.model.c localc = locall.pcA;
            if (localc != null)
            {
              locall.pda.gfF = SystemClock.elapsedRealtime();
              localc.eyA();
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + locall.pda.abs());
              localc.eyx();
              locall.isStart = false;
              locall.pcA = null;
            }
            if (z.dtK().wrl != null) {
              z.dtK().wrl.drG();
            }
          }
          AppMethodBeat.o(114428);
          return true;
        }
      }
      
      public final boolean dsy()
      {
        AppMethodBeat.i(114429);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try
        {
          if (m.d(m.this) != null)
          {
            m.d(m.this).dij = null;
            m.d(m.this).PF();
          }
          m.a(m.this, null);
          AppMethodBeat.o(114429);
          return true;
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(localException)));
          AppMethodBeat.o(114429);
        }
        return false;
      }
      
      public final int dsz()
      {
        int j = 0;
        AppMethodBeat.i(114430);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        int i = j;
        if (m.c(m.this) != null)
        {
          i = j;
          if (z.dtK().wrl != null)
          {
            com.tencent.mm.plugin.voip.model.c localc = z.dtK().wrl.wlY;
            i = j;
            if (localc != null) {
              i = localc.aNQ();
            }
          }
        }
        float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
        i = (int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F);
        AppMethodBeat.o(114430);
        return i;
      }
      
      public final boolean oT(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(114425);
        com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (z.dtK().wrl != null) {
          z.dtK().wrl.oK(paramAnonymousBoolean);
        }
        AppMethodBeat.o(114425);
        return true;
      }
    });
    this.wqE.cW(i, com.tencent.mm.model.v.aAC());
    g.ajj().a(1918, this);
    g.ajj().a(1919, this);
    g.ajj().a(1927, this);
    g.ajj().a(1928, this);
    g.ajj().a(1929, this);
    g.ajj().a(1931, this);
    g.ajj().a(1932, this);
    g.ajj().a(1933, this);
    g.ajj().a(1935, this);
    g.ajj().a(1937, this);
    g.ajj().a(1938, this);
    g.ajj().a(1939, this);
    AppMethodBeat.o(114437);
  }
  
  public final d dst()
  {
    return this.wqE;
  }
  
  public final void oQ(boolean paramBoolean)
  {
    AppMethodBeat.i(114439);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      this.wqE.setAppCmd(425, arrayOfByte, 1);
      if (!paramBoolean) {
        break;
      }
      if (com.tencent.mm.plugin.audio.c.a.bHt()) {
        this.wqE.setAppCmd(441, arrayOfByte, 1);
      }
      if (!com.tencent.mm.plugin.audio.c.a.bHz()) {
        break label143;
      }
      this.wqE.setAppCmd(442, arrayOfByte, 1);
      AppMethodBeat.o(114439);
      return;
    }
    this.wqE.setAppCmd(441, arrayOfByte, 1);
    this.wqE.setAppCmd(442, arrayOfByte, 1);
    label143:
    AppMethodBeat.o(114439);
  }
  
  public final void oR(boolean paramBoolean)
  {
    AppMethodBeat.i(190760);
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.MT.MultiTalkEngine", "setEngineSpeakerOn, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      this.wqE.setAppCmd(401, arrayOfByte, 1);
      AppMethodBeat.o(190760);
      return;
    }
    arrayOfByte[0] = 0;
    this.wqE.setAppCmd(402, arrayOfByte, 1);
    AppMethodBeat.o(190760);
  }
  
  public final void oS(boolean paramBoolean)
  {
    AppMethodBeat.i(190761);
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.MT.MultiTalkEngine", "setEngineMicOn, %s", new Object[] { Boolean.valueOf(paramBoolean) });
    byte[] arrayOfByte = new byte[1];
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      this.wqE.setAppCmd(413, arrayOfByte, 1);
      AppMethodBeat.o(190761);
      return;
    }
    arrayOfByte[0] = 0;
    this.wqE.setAppCmd(412, arrayOfByte, 1);
    AppMethodBeat.o(190761);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(114438);
    paramString = (v)paramn;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.wqE.d(paramInt2, paramString.qgy, paramString.mCmdId, paramString.dNz);
    AppMethodBeat.o(114438);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m
 * JD-Core Version:    0.7.0.1
 */