package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.b.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ck;
import com.tencent.pb.talkroom.sdk.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class o
  implements i
{
  private c.a dzN;
  private com.tencent.mm.audio.b.c qrH;
  public d zMd;
  private l zMe;
  private boolean zMf;
  private com.tencent.pb.talkroom.sdk.c zMg;
  private com.tencent.pb.talkroom.sdk.b zMh;
  private int zMi;
  private com.tencent.mm.plugin.voip.model.b zMj;
  private MTimerHandler zMk;
  public volatile HashMap<String, Integer> zMl;
  
  public o()
  {
    AppMethodBeat.i(114437);
    this.zMi = 0;
    this.dzN = new c.a()
    {
      public final void cj(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(114435);
        Log.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        ac.eom();
        q.enR();
        AppMethodBeat.o(114435);
      }
      
      public final void w(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114434);
        if (paramAnonymousInt <= 0)
        {
          Log.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
          AppMethodBeat.o(114434);
          return;
        }
        if (o.f(o.this) != null)
        {
          o.f(o.this).ag(paramAnonymousArrayOfByte, paramAnonymousInt);
          if (o.f(o.aa(paramAnonymousArrayOfByte, paramAnonymousInt / 2), paramAnonymousInt / 2) > 50.0D)
          {
            o.a(o.this, false);
            o.g(o.this);
            AppMethodBeat.o(114434);
            return;
          }
          o.h(o.this);
          if (o.i(o.this) >= 30) {
            o.a(o.this, true);
          }
        }
        AppMethodBeat.o(114434);
      }
    };
    this.zMj = new com.tencent.mm.plugin.voip.model.b()
    {
      public final int Q(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114436);
        if (o.j(o.this) != null) {}
        for (paramAnonymousInt = o.j(o.this).af(paramAnonymousArrayOfByte, paramAnonymousInt);; paramAnonymousInt = 0)
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
    this.zMl = new HashMap();
    Log.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = MMApplicationContext.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.hrb();
    com.tencent.wecall.talkroom.model.e.lw(localContext);
    this.zMd = locale;
    this.zMd.hjt();
    this.zMe = new l();
    int i = Util.nullAsNil((Integer)g.aAh().hqB.get(1));
    this.zMd.a(ac.eom(), new com.tencent.pb.talkroom.sdk.e()
    {
      public final boolean H(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(114420);
        o.G(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(114420);
        return false;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.b paramAnonymousb)
      {
        AppMethodBeat.i(114426);
        o.a(o.this, paramAnonymousb);
        paramAnonymousInt1 = o.c(o.this).a(o.b(o.this), paramAnonymousInt1, paramAnonymousInt2);
        o.this.emK();
        Log.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn()), Boolean.valueOf(ac.eom().mkd) });
        if ((com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn() != ac.eom().mkd) && (ac.eom().czl()) && (ac.eom().zMV != null)) {
          ac.eom().zMV.rs(ac.eom().mkd);
        }
        AppMethodBeat.o(114426);
        return paramAnonymousInt1;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.c paramAnonymousc)
      {
        AppMethodBeat.i(114427);
        o.a(o.this, paramAnonymousc);
        o.a(o.this, new com.tencent.mm.audio.b.c(paramAnonymousInt1, 1, 7));
        o.d(o.this).jk(paramAnonymousInt2);
        o.d(o.this).dd(true);
        o.d(o.this).aag();
        o.d(o.this).dzk = -19;
        o.d(o.this).x(1, false);
        o.d(o.this).dc(true);
        o.d(o.this).dzv = o.e(o.this);
        if (o.d(o.this).aai())
        {
          AppMethodBeat.o(114427);
          return 1;
        }
        AppMethodBeat.o(114427);
        return -1;
      }
      
      public final int aon()
      {
        AppMethodBeat.i(114423);
        int i = m.aon();
        AppMethodBeat.o(114423);
        return i;
      }
      
      public final boolean d(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(114421);
        Log.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramAnonymousInt1 + " cmdid " + paramAnonymousInt2);
        paramAnonymousArrayOfByte = new y(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        g.azz().a(paramAnonymousArrayOfByte, 0);
        AppMethodBeat.o(114421);
        return false;
      }
      
      public final boolean emM()
      {
        AppMethodBeat.i(114422);
        Log.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(m.aon())));
        o.class.getClassLoader();
        j.Ed("voipMain");
        AppMethodBeat.o(114422);
        return true;
      }
      
      public final int emN()
      {
        AppMethodBeat.i(239354);
        int i = 2;
        if (k.aFU("video/avc")) {
          i = 10;
        }
        Log.i("MicroMsg.MT.MultiTalkEngine", "CodecList[%d]", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(239354);
        return i;
      }
      
      public final int emO()
      {
        AppMethodBeat.i(114424);
        String str = g.aAh().azR().gEu();
        ae.DV(str);
        Log.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(str)));
        o.a(o.this);
        AppMethodBeat.o(114424);
        return 0;
      }
      
      public final boolean emP()
      {
        AppMethodBeat.i(114428);
        Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        l locall = o.c(o.this);
        synchronized (locall.qrY)
        {
          Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(locall.isStart), Integer.valueOf(locall.hashCode()) });
          if (locall.isStart)
          {
            com.tencent.mm.plugin.voip.model.c localc = locall.qrz;
            if (localc != null)
            {
              locall.qsa.gLm = SystemClock.elapsedRealtime();
              localc.fFr();
              Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + locall.qsa.apr());
              localc.fFo();
              locall.isStart = false;
              locall.qrz = null;
            }
            if (ac.eom().zMV != null) {
              ac.eom().zMV.elB();
            }
          }
          o.this.emL();
          AppMethodBeat.o(114428);
          return true;
        }
      }
      
      public final boolean emQ()
      {
        AppMethodBeat.i(114429);
        Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try
        {
          if (o.d(o.this) != null)
          {
            o.d(o.this).dzv = null;
            o.d(o.this).ZZ();
          }
          o.a(o.this, null);
          AppMethodBeat.o(114429);
          return true;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(localException)));
          AppMethodBeat.o(114429);
        }
        return false;
      }
      
      public final int emR()
      {
        int j = 0;
        AppMethodBeat.i(114430);
        Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        int i = j;
        if (o.c(o.this) != null)
        {
          i = j;
          if (ac.eom().zMV != null)
          {
            com.tencent.mm.plugin.voip.model.c localc = ac.eom().zMV.zHb;
            i = j;
            if (localc != null) {
              i = localc.bhV();
            }
          }
        }
        float f = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(i);
        i = (int)(com.tencent.mm.plugin.audio.c.a.getStreamVolume(i) / f * 100.0F);
        AppMethodBeat.o(114430);
        return i;
      }
      
      public final int emS()
      {
        AppMethodBeat.i(114431);
        Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (o.d(o.this) != null)
        {
          int i = o.d(o.this).aal();
          AppMethodBeat.o(114431);
          return i;
        }
        AppMethodBeat.o(114431);
        return -2;
      }
      
      public final int emT()
      {
        AppMethodBeat.i(114432);
        Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (o.d(o.this) != null)
        {
          int i = o.d(o.this).dyZ;
          AppMethodBeat.o(114432);
          return i;
        }
        AppMethodBeat.o(114432);
        return 0;
      }
      
      public final int emU()
      {
        AppMethodBeat.i(114433);
        Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if ((o.c(o.this) != null) && (ac.eom().zMV != null))
        {
          com.tencent.mm.plugin.voip.model.c localc = ac.eom().zMV.zHb;
          if (localc != null)
          {
            int i = localc.fFs();
            AppMethodBeat.o(114433);
            return i;
          }
          AppMethodBeat.o(114433);
          return 0;
        }
        AppMethodBeat.o(114433);
        return 0;
      }
      
      public final boolean rB(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(114425);
        Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ac.eom().zMV != null) {
          ac.eom().zMV.rs(paramAnonymousBoolean);
        }
        AppMethodBeat.o(114425);
        return true;
      }
    });
    this.zMd.dr(i, z.aTY());
    g.azz().a(1918, this);
    g.azz().a(1919, this);
    g.azz().a(1927, this);
    g.azz().a(1928, this);
    g.azz().a(1929, this);
    g.azz().a(1931, this);
    g.azz().a(1932, this);
    g.azz().a(1933, this);
    g.azz().a(1935, this);
    g.azz().a(1937, this);
    g.azz().a(1938, this);
    g.azz().a(1939, this);
    AppMethodBeat.o(114437);
  }
  
  public final boolean elC()
  {
    return this.zMf;
  }
  
  public final d emG()
  {
    return this.zMd;
  }
  
  public final List<String> emH()
  {
    AppMethodBeat.i(239356);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zMl.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getKey());
    }
    AppMethodBeat.o(239356);
    return localArrayList;
  }
  
  public final void emI()
  {
    AppMethodBeat.i(239357);
    this.zMl = new HashMap();
    AppMethodBeat.o(239357);
  }
  
  public final String emJ()
  {
    AppMethodBeat.i(239358);
    Iterator localIterator = this.zMl.entrySet().iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((String)localEntry.getKey()).equals(null)) {
        if (localObject == null)
        {
          localObject = localEntry;
        }
        else
        {
          if (((Integer)((Map.Entry)localObject).getValue()).intValue() >= ((Integer)localEntry.getValue()).intValue()) {
            break label127;
          }
          localObject = localEntry;
        }
      }
    }
    label127:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        localObject = (String)((Map.Entry)localObject).getKey();
        AppMethodBeat.o(239358);
        return localObject;
      }
      AppMethodBeat.o(239358);
      return null;
    }
  }
  
  public final void emK()
  {
    AppMethodBeat.i(239359);
    if (this.zMk != null)
    {
      this.zMk.stopTimer();
      this.zMk.quitSafely();
      this.zMk.removeCallbacksAndMessages(null);
    }
    this.zMk = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(239355);
        o.k(o.this);
        AppMethodBeat.o(239355);
        return true;
      }
    }, true);
    this.zMk.startTimer(33L);
    AppMethodBeat.o(239359);
  }
  
  public final void emL()
  {
    AppMethodBeat.i(239360);
    if (this.zMk != null)
    {
      this.zMk.stopTimer();
      this.zMk.quitSafely();
      this.zMk.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(239360);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(114438);
    paramString = (y)paramq;
    Log.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.zMd.d(paramInt2, paramString.rxu, paramString.mCmdId, paramString.efs);
    AppMethodBeat.o(114438);
  }
  
  public final void rA(boolean paramBoolean)
  {
    AppMethodBeat.i(239362);
    byte[] arrayOfByte = new byte[1];
    boolean bool = ac.eom().ens();
    Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "setEngineMicOn, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    p localp;
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      if (bool)
      {
        localp = p.zHS;
        p.f(413, arrayOfByte, 1);
        AppMethodBeat.o(239362);
        return;
      }
      this.zMd.setAppCmd(413, arrayOfByte, 1);
      AppMethodBeat.o(239362);
      return;
    }
    arrayOfByte[0] = 0;
    if (bool)
    {
      localp = p.zHS;
      p.f(412, arrayOfByte, 1);
      AppMethodBeat.o(239362);
      return;
    }
    this.zMd.setAppCmd(412, arrayOfByte, 1);
    AppMethodBeat.o(239362);
  }
  
  public final void ry(boolean paramBoolean)
  {
    AppMethodBeat.i(114439);
    byte[] arrayOfByte = new byte[1];
    int i;
    boolean bool;
    p localp;
    if (paramBoolean)
    {
      i = 1;
      arrayOfByte[0] = ((byte)i);
      bool = ac.eom().ens();
      Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label137;
      }
      localp = p.zHS;
      p.f(425, arrayOfByte, 1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (bool)
        {
          if (com.tencent.mm.plugin.audio.c.a.cdW())
          {
            localp = p.zHS;
            p.f(441, arrayOfByte, 1);
          }
          if (!com.tencent.mm.plugin.audio.c.a.ceb()) {
            break label280;
          }
          localp = p.zHS;
          p.f(442, arrayOfByte, 1);
          AppMethodBeat.o(114439);
          return;
          i = 0;
          break;
          label137:
          this.zMd.setAppCmd(425, arrayOfByte, 1);
          continue;
        }
        if (com.tencent.mm.plugin.audio.c.a.cdW()) {
          this.zMd.setAppCmd(441, arrayOfByte, 1);
        }
        if (!com.tencent.mm.plugin.audio.c.a.ceb()) {
          break label280;
        }
        this.zMd.setAppCmd(442, arrayOfByte, 1);
        AppMethodBeat.o(114439);
        return;
      }
    }
    if (bool)
    {
      localp = p.zHS;
      p.f(441, arrayOfByte, 1);
      localp = p.zHS;
      p.f(442, arrayOfByte, 1);
      AppMethodBeat.o(114439);
      return;
    }
    this.zMd.setAppCmd(441, arrayOfByte, 1);
    this.zMd.setAppCmd(442, arrayOfByte, 1);
    label280:
    AppMethodBeat.o(114439);
  }
  
  public final void rz(boolean paramBoolean)
  {
    AppMethodBeat.i(239361);
    byte[] arrayOfByte = new byte[1];
    boolean bool = ac.eom().ens();
    Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "qipengfeng, setEngineSpeakerOn, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    p localp;
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      if (bool)
      {
        localp = p.zHS;
        p.f(401, arrayOfByte, 1);
        AppMethodBeat.o(239361);
        return;
      }
      this.zMd.setAppCmd(401, arrayOfByte, 1);
      AppMethodBeat.o(239361);
      return;
    }
    arrayOfByte[0] = 0;
    if (bool)
    {
      localp = p.zHS;
      p.f(402, arrayOfByte, 1);
      AppMethodBeat.o(239361);
      return;
    }
    this.zMd.setAppCmd(402, arrayOfByte, 1);
    AppMethodBeat.o(239361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.o
 * JD-Core Version:    0.7.0.1
 */