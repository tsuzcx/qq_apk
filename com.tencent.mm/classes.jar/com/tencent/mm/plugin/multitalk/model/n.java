package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.multitalk.c.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.co;
import com.tencent.pb.talkroom.sdk.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class n
  implements com.tencent.mm.am.h
{
  public d LnJ;
  private l LnK;
  public boolean LnL;
  private com.tencent.pb.talkroom.sdk.c LnM;
  private com.tencent.pb.talkroom.sdk.b LnN;
  private int LnO;
  private com.tencent.mm.plugin.voip.model.b LnP;
  private MTimerHandler LnQ;
  public volatile HashMap<String, Integer> LnR;
  private c.a hwR;
  private com.tencent.mm.audio.b.c wTG;
  
  public n()
  {
    AppMethodBeat.i(114437);
    this.LnO = 0;
    this.hwR = new c.a()
    {
      public final void ds(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(114435);
        Log.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        ac.ggS();
        p.fwi();
        AppMethodBeat.o(114435);
      }
      
      public final void u(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114434);
        if (paramAnonymousInt <= 0)
        {
          Log.e("MicroMsg.MT.MultiTalkEngine", "pcm data len <= 0");
          AppMethodBeat.o(114434);
          return;
        }
        if (n.f(n.this) != null)
        {
          n.f(n.this).aj(paramAnonymousArrayOfByte, paramAnonymousInt);
          if (n.g(n.aa(paramAnonymousArrayOfByte, paramAnonymousInt / 2), paramAnonymousInt / 2) > 50.0D)
          {
            n.a(n.this, false);
            n.g(n.this);
            AppMethodBeat.o(114434);
            return;
          }
          n.h(n.this);
          if (n.i(n.this) >= 30) {
            n.a(n.this, true);
          }
        }
        AppMethodBeat.o(114434);
      }
    };
    this.LnP = new com.tencent.mm.plugin.voip.model.b()
    {
      public final int PlayDevDataCallBack(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114436);
        if (n.j(n.this) != null) {}
        for (paramAnonymousInt = n.j(n.this).ai(paramAnonymousArrayOfByte, paramAnonymousInt);; paramAnonymousInt = 0)
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
    this.LnR = new HashMap();
    Log.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = MMApplicationContext.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.keg();
    com.tencent.wecall.talkroom.model.e.oK(localContext);
    this.LnJ = locale;
    this.LnJ.jRu();
    this.LnK = new l();
    int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().mCE.get(1));
    this.LnJ.a(ac.ggS(), new com.tencent.pb.talkroom.sdk.e()
    {
      public final boolean O(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(114420);
        n.N(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(114420);
        return false;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.b paramAnonymousb)
      {
        AppMethodBeat.i(114426);
        n.a(n.this, paramAnonymousb);
        paramAnonymousInt1 = n.c(n.this).a(n.b(n.this), paramAnonymousInt1, paramAnonymousInt2);
        n.this.gfs();
        Log.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(a.cTU()), Boolean.valueOf(ac.ggS().snA) });
        if ((a.cTU() != ac.ggS().snA) && (ac.ggS().dro()) && (ac.ggS().LoD != null))
        {
          ac.ggS();
          if (!com.tencent.mm.plugin.multitalk.b.b.cTT()) {
            ac.ggS().LoD.yJ(ac.ggS().snA);
          }
        }
        AppMethodBeat.o(114426);
        return paramAnonymousInt1;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.c paramAnonymousc)
      {
        AppMethodBeat.i(114427);
        n.a(n.this, paramAnonymousc);
        n.a(n.this, new com.tencent.mm.audio.b.c(paramAnonymousInt1, 1, 7));
        n.d(n.this).ok(paramAnonymousInt2);
        n.d(n.this).ep(true);
        n.d(n.this).aGP();
        n.d(n.this).hwn = -19;
        n.d(n.this).O(1, false);
        n.d(n.this).eo(true);
        n.d(n.this).hwy = n.e(n.this);
        if (n.d(n.this).aGR())
        {
          AppMethodBeat.o(114427);
          return 1;
        }
        AppMethodBeat.o(114427);
        return -1;
      }
      
      public final int aOK()
      {
        AppMethodBeat.i(114423);
        int i = m.aOK();
        AppMethodBeat.o(114423);
        return i;
      }
      
      public final boolean e(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(114421);
        Log.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramAnonymousInt1 + " cmdid " + paramAnonymousInt2);
        paramAnonymousArrayOfByte = new x(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        com.tencent.mm.kernel.h.aZW().a(paramAnonymousArrayOfByte, 0);
        AppMethodBeat.o(114421);
        return false;
      }
      
      public final int gfA()
      {
        AppMethodBeat.i(114431);
        Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (n.d(n.this) != null)
        {
          int i = n.d(n.this).aGV();
          AppMethodBeat.o(114431);
          return i;
        }
        AppMethodBeat.o(114431);
        return -2;
      }
      
      public final int gfB()
      {
        AppMethodBeat.i(114432);
        Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (n.d(n.this) != null)
        {
          int i = n.d(n.this).hwc;
          AppMethodBeat.o(114432);
          return i;
        }
        AppMethodBeat.o(114432);
        return 0;
      }
      
      public final int gfC()
      {
        AppMethodBeat.i(114433);
        Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if ((n.c(n.this) != null) && (ac.ggS().LoD != null))
        {
          int i = ac.ggS().LoD.gdY();
          AppMethodBeat.o(114433);
          return i;
        }
        AppMethodBeat.o(114433);
        return 0;
      }
      
      public final boolean gfu()
      {
        AppMethodBeat.i(114422);
        Log.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(m.aOK())));
        n.class.getClassLoader();
        com.tencent.mm.compatible.util.k.DA("voipMain");
        AppMethodBeat.o(114422);
        return true;
      }
      
      public final int gfv()
      {
        AppMethodBeat.i(284825);
        int i = 2;
        if (k.aNb("video/avc")) {
          i = 10;
        }
        Log.i("MicroMsg.MT.MultiTalkEngine", "CodecList[%d]", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(284825);
        return i;
      }
      
      public final int gfw()
      {
        AppMethodBeat.i(114424);
        String str = com.tencent.mm.kernel.h.baE().bao().jcN();
        af.Ds(str);
        Log.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(str)));
        n.a(n.this);
        AppMethodBeat.o(114424);
        return 0;
      }
      
      public final boolean gfx()
      {
        AppMethodBeat.i(114428);
        Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        l locall = n.c(n.this);
        synchronized (locall.wTX)
        {
          Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(locall.isStart), Integer.valueOf(locall.hashCode()) });
          if (locall.isStart)
          {
            com.tencent.mm.plugin.voip.model.c localc = locall.wTy;
            if (localc != null)
            {
              locall.wTZ.lYS = SystemClock.elapsedRealtime();
              localc.hVF();
              Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + locall.wTZ.aPY());
              localc.hVC();
              locall.isStart = false;
              locall.wTy = null;
            }
            if (ac.ggS().LoD != null) {
              ac.ggS().LoD.ged();
            }
          }
          n.this.gft();
          AppMethodBeat.o(114428);
          return true;
        }
      }
      
      public final boolean gfy()
      {
        AppMethodBeat.i(114429);
        Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try
        {
          if (n.d(n.this) != null)
          {
            n.d(n.this).hwy = null;
            n.d(n.this).aGH();
          }
          n.a(n.this, null);
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
      
      public final int gfz()
      {
        AppMethodBeat.i(114430);
        Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        int j = 0;
        int i = j;
        if (n.c(n.this) != null)
        {
          i = j;
          if (ac.ggS().LoD != null) {
            i = ac.ggS().LoD.gdZ();
          }
        }
        float f = a.getStreamMaxVolume(i);
        i = (int)(a.getStreamVolume(i) / f * 100.0F);
        AppMethodBeat.o(114430);
        return i;
      }
      
      public final boolean yT(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(114425);
        Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ac.ggS().LoD != null) {
          ac.ggS().LoD.yJ(paramAnonymousBoolean);
        }
        AppMethodBeat.o(114425);
        return true;
      }
    });
    this.LnJ.em(i, z.bAM());
    com.tencent.mm.kernel.h.aZW().a(1918, this);
    com.tencent.mm.kernel.h.aZW().a(1919, this);
    com.tencent.mm.kernel.h.aZW().a(1927, this);
    com.tencent.mm.kernel.h.aZW().a(1928, this);
    com.tencent.mm.kernel.h.aZW().a(1929, this);
    com.tencent.mm.kernel.h.aZW().a(1931, this);
    com.tencent.mm.kernel.h.aZW().a(1932, this);
    com.tencent.mm.kernel.h.aZW().a(1933, this);
    com.tencent.mm.kernel.h.aZW().a(1935, this);
    com.tencent.mm.kernel.h.aZW().a(1937, this);
    com.tencent.mm.kernel.h.aZW().a(1938, this);
    com.tencent.mm.kernel.h.aZW().a(1939, this);
    AppMethodBeat.o(114437);
  }
  
  public final List<String> gfq()
  {
    AppMethodBeat.i(284896);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.LnR.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((String)((Map.Entry)localIterator.next()).getKey());
    }
    AppMethodBeat.o(284896);
    return localArrayList;
  }
  
  public final ArrayList<String> gfr()
  {
    AppMethodBeat.i(284902);
    ArrayList localArrayList = new ArrayList(3);
    Object localObject = new ArrayList(this.LnR.entrySet());
    Collections.sort((List)localObject, new Comparator() {});
    if (!((List)localObject).isEmpty())
    {
      localArrayList.add((String)((Map.Entry)((List)localObject).get(0)).getKey());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localArrayList.size() >= 3) {
          break;
        }
        if (((ac.ggS().Loj != null) && (ac.ggS().Loj.contains(localEntry.getKey()))) || ((ac.ggS().ggc().Lpv != null) && (ac.ggS().ggc().Lpv.contains(localEntry.getKey())))) {
          localArrayList.add((String)localEntry.getKey());
        }
      }
    }
    AppMethodBeat.o(284902);
    return null;
    AppMethodBeat.o(284902);
    return localArrayList;
  }
  
  public final void gfs()
  {
    AppMethodBeat.i(284909);
    if (this.LnQ != null)
    {
      this.LnQ.stopTimer();
      this.LnQ.quitSafely();
      this.LnQ.removeCallbacksAndMessages(null);
    }
    this.LnQ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(284815);
        n.k(n.this);
        AppMethodBeat.o(284815);
        return true;
      }
    }, true);
    this.LnQ.startTimer(33L);
    AppMethodBeat.o(284909);
  }
  
  public final void gft()
  {
    AppMethodBeat.i(284916);
    if (this.LnQ != null)
    {
      this.LnQ.stopTimer();
      this.LnQ.quitSafely();
      this.LnQ.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(284916);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(114438);
    paramString = (x)paramp;
    Log.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.LnJ.d(paramInt2, paramString.crl, paramString.mCmdId, paramString.ifP);
    AppMethodBeat.o(114438);
  }
  
  public final void yQ(boolean paramBoolean)
  {
    AppMethodBeat.i(114439);
    byte[] arrayOfByte = new byte[1];
    int i;
    boolean bool;
    o localo;
    if (paramBoolean)
    {
      i = 1;
      arrayOfByte[0] = ((byte)i);
      bool = ac.ggS().gfV();
      Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label137;
      }
      localo = o.Ljn;
      o.e(425, arrayOfByte, 1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (bool)
        {
          if (a.cTQ())
          {
            localo = o.Ljn;
            o.e(441, arrayOfByte, 1);
          }
          if (!a.cTX()) {
            break label280;
          }
          localo = o.Ljn;
          o.e(442, arrayOfByte, 1);
          AppMethodBeat.o(114439);
          return;
          i = 0;
          break;
          label137:
          this.LnJ.setAppCmd(425, arrayOfByte, 1);
          continue;
        }
        if (a.cTQ()) {
          this.LnJ.setAppCmd(441, arrayOfByte, 1);
        }
        if (!a.cTX()) {
          break label280;
        }
        this.LnJ.setAppCmd(442, arrayOfByte, 1);
        AppMethodBeat.o(114439);
        return;
      }
    }
    if (bool)
    {
      localo = o.Ljn;
      o.e(441, arrayOfByte, 1);
      localo = o.Ljn;
      o.e(442, arrayOfByte, 1);
      AppMethodBeat.o(114439);
      return;
    }
    this.LnJ.setAppCmd(441, arrayOfByte, 1);
    this.LnJ.setAppCmd(442, arrayOfByte, 1);
    label280:
    AppMethodBeat.o(114439);
  }
  
  public final void yR(boolean paramBoolean)
  {
    AppMethodBeat.i(284928);
    byte[] arrayOfByte = new byte[1];
    boolean bool = ac.ggS().gfV();
    Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "qipengfeng, setEngineSpeakerOn, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    o localo;
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      if (bool)
      {
        localo = o.Ljn;
        o.e(401, arrayOfByte, 1);
        AppMethodBeat.o(284928);
        return;
      }
      this.LnJ.setAppCmd(401, arrayOfByte, 1);
      AppMethodBeat.o(284928);
      return;
    }
    arrayOfByte[0] = 0;
    if (bool)
    {
      localo = o.Ljn;
      o.e(402, arrayOfByte, 1);
      AppMethodBeat.o(284928);
      return;
    }
    this.LnJ.setAppCmd(402, arrayOfByte, 1);
    AppMethodBeat.o(284928);
  }
  
  public final void yS(boolean paramBoolean)
  {
    AppMethodBeat.i(284933);
    byte[] arrayOfByte = new byte[1];
    boolean bool = ac.ggS().gfV();
    Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "setEngineMicOn, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    o localo;
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      if (bool)
      {
        localo = o.Ljn;
        o.e(413, arrayOfByte, 1);
        AppMethodBeat.o(284933);
        return;
      }
      this.LnJ.setAppCmd(413, arrayOfByte, 1);
      AppMethodBeat.o(284933);
      return;
    }
    arrayOfByte[0] = 0;
    if (bool)
    {
      localo = o.Ljn;
      o.e(412, arrayOfByte, 1);
      AppMethodBeat.o(284933);
      return;
    }
    this.LnJ.setAppCmd(412, arrayOfByte, 1);
    AppMethodBeat.o(284933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.n
 * JD-Core Version:    0.7.0.1
 */