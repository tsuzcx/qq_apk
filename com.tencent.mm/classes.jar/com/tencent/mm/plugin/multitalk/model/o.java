package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.cl;
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

public class o
  implements i
{
  private com.tencent.pb.talkroom.sdk.b FrA;
  private int FrB;
  private com.tencent.mm.plugin.voip.model.b FrC;
  private MTimerHandler FrD;
  public volatile HashMap<String, Integer> FrE;
  public d Frw;
  private l Frx;
  private boolean Fry;
  private com.tencent.pb.talkroom.sdk.c Frz;
  private c.a fsC;
  private com.tencent.mm.audio.b.c tQq;
  
  public o()
  {
    AppMethodBeat.i(114437);
    this.FrB = 0;
    this.fsC = new c.a()
    {
      public final void cC(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(114435);
        Log.i("MicroMsg.MT.MultiTalkEngine", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        ad.eYc();
        q.eXH();
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
          o.f(o.this).ai(paramAnonymousArrayOfByte, paramAnonymousInt);
          if (o.f(o.ab(paramAnonymousArrayOfByte, paramAnonymousInt / 2), paramAnonymousInt / 2) > 50.0D)
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
    this.FrC = new com.tencent.mm.plugin.voip.model.b()
    {
      public final int R(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
      {
        AppMethodBeat.i(114436);
        if (o.j(o.this) != null) {}
        for (paramAnonymousInt = o.j(o.this).ah(paramAnonymousArrayOfByte, paramAnonymousInt);; paramAnonymousInt = 0)
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
    this.FrE = new HashMap();
    Log.i("MicroMsg.MT.MultiTalkEngine", "init multiTalk engine");
    Context localContext = MMApplicationContext.getContext();
    com.tencent.wecall.talkroom.model.e locale = com.tencent.wecall.talkroom.model.e.iuL();
    com.tencent.wecall.talkroom.model.e.mu(localContext);
    this.Frw = locale;
    this.Frw.ild();
    this.Frx = new l();
    int i = Util.nullAsNil((Integer)h.aHG().kcw.get(1));
    this.Frw.a(ad.eYc(), new com.tencent.pb.talkroom.sdk.e()
    {
      public final boolean K(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(114420);
        o.J(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(114420);
        return false;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.b paramAnonymousb)
      {
        AppMethodBeat.i(114426);
        o.a(o.this, paramAnonymousb);
        paramAnonymousInt1 = o.c(o.this).a(o.b(o.this), paramAnonymousInt1, paramAnonymousInt2);
        o.this.eWz();
        Log.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(a.crl()), Boolean.valueOf(ad.eYc().pih) });
        if ((a.crl() != ad.eYc().pih) && (ad.eYc().cNL()) && (ad.eYc().Fsp != null)) {
          ad.eYc().Fsp.uw(ad.eYc().pih);
        }
        AppMethodBeat.o(114426);
        return paramAnonymousInt1;
      }
      
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.pb.talkroom.sdk.c paramAnonymousc)
      {
        AppMethodBeat.i(114427);
        o.a(o.this, paramAnonymousc);
        o.a(o.this, new com.tencent.mm.audio.b.c(paramAnonymousInt1, 1, 7));
        o.d(o.this).kD(paramAnonymousInt2);
        o.d(o.this).dD(true);
        o.d(o.this).aeR();
        o.d(o.this).frZ = -19;
        o.d(o.this).z(1, false);
        o.d(o.this).dC(true);
        o.d(o.this).fsk = o.e(o.this);
        if (o.d(o.this).aeU())
        {
          AppMethodBeat.o(114427);
          return 1;
        }
        AppMethodBeat.o(114427);
        return -1;
      }
      
      public final int aus()
      {
        AppMethodBeat.i(114423);
        int i = m.aus();
        AppMethodBeat.o(114423);
        return i;
      }
      
      public final boolean d(int paramAnonymousInt1, int paramAnonymousInt2, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(114421);
        Log.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramAnonymousInt1 + " cmdid " + paramAnonymousInt2);
        paramAnonymousArrayOfByte = new y(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousArrayOfByte);
        h.aGY().a(paramAnonymousArrayOfByte, 0);
        AppMethodBeat.o(114421);
        return false;
      }
      
      public final boolean eWB()
      {
        AppMethodBeat.i(114422);
        Log.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(m.aus())));
        o.class.getClassLoader();
        j.KW("voipMain");
        AppMethodBeat.o(114422);
        return true;
      }
      
      public final int eWC()
      {
        AppMethodBeat.i(196790);
        int i = 2;
        if (k.aQg("video/avc")) {
          i = 10;
        }
        Log.i("MicroMsg.MT.MultiTalkEngine", "CodecList[%d]", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(196790);
        return i;
      }
      
      public final int eWD()
      {
        AppMethodBeat.i(114424);
        String str = h.aHG().aHq().hAK();
        af.KN(str);
        Log.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(str)));
        o.a(o.this);
        AppMethodBeat.o(114424);
        return 0;
      }
      
      public final boolean eWE()
      {
        AppMethodBeat.i(114428);
        Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        l locall = o.c(o.this);
        synchronized (locall.tQH)
        {
          Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(locall.isStart), Integer.valueOf(locall.hashCode()) });
          if (locall.isStart)
          {
            com.tencent.mm.plugin.voip.model.c localc = locall.tQh;
            if (localc != null)
            {
              locall.tQJ.jvB = SystemClock.elapsedRealtime();
              localc.gxD();
              Log.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + locall.tQJ.avE());
              localc.gxA();
              locall.isStart = false;
              locall.tQh = null;
            }
            if (ad.eYc().Fsp != null) {
              ad.eYc().Fsp.eVm();
            }
          }
          o.this.eWA();
          AppMethodBeat.o(114428);
          return true;
        }
      }
      
      public final boolean eWF()
      {
        AppMethodBeat.i(114429);
        Log.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try
        {
          if (o.d(o.this) != null)
          {
            o.d(o.this).fsk = null;
            o.d(o.this).aeJ();
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
      
      public final int eWG()
      {
        int j = 0;
        AppMethodBeat.i(114430);
        Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        int i = j;
        if (o.c(o.this) != null)
        {
          i = j;
          if (ad.eYc().Fsp != null)
          {
            com.tencent.mm.plugin.voip.model.c localc = ad.eYc().Fsp.Fmm;
            i = j;
            if (localc != null) {
              i = localc.gxF();
            }
          }
        }
        float f = a.getStreamMaxVolume(i);
        i = (int)(a.getStreamVolume(i) / f * 100.0F);
        AppMethodBeat.o(114430);
        return i;
      }
      
      public final int eWH()
      {
        AppMethodBeat.i(114431);
        Log.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (o.d(o.this) != null)
        {
          int i = o.d(o.this).aeX();
          AppMethodBeat.o(114431);
          return i;
        }
        AppMethodBeat.o(114431);
        return -2;
      }
      
      public final int eWI()
      {
        AppMethodBeat.i(114432);
        Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (o.d(o.this) != null)
        {
          int i = o.d(o.this).frO;
          AppMethodBeat.o(114432);
          return i;
        }
        AppMethodBeat.o(114432);
        return 0;
      }
      
      public final int eWJ()
      {
        AppMethodBeat.i(114433);
        Log.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if ((o.c(o.this) != null) && (ad.eYc().Fsp != null))
        {
          int i = ad.eYc().Fsp.eVj();
          AppMethodBeat.o(114433);
          return i;
        }
        AppMethodBeat.o(114433);
        return 0;
      }
      
      public final boolean uE(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(114425);
        Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (ad.eYc().Fsp != null) {
          ad.eYc().Fsp.uw(paramAnonymousBoolean);
        }
        AppMethodBeat.o(114425);
        return true;
      }
    });
    this.Frw.ds(i, z.bcZ());
    h.aGY().a(1918, this);
    h.aGY().a(1919, this);
    h.aGY().a(1927, this);
    h.aGY().a(1928, this);
    h.aGY().a(1929, this);
    h.aGY().a(1931, this);
    h.aGY().a(1932, this);
    h.aGY().a(1933, this);
    h.aGY().a(1935, this);
    h.aGY().a(1937, this);
    h.aGY().a(1938, this);
    h.aGY().a(1939, this);
    AppMethodBeat.o(114437);
  }
  
  public final boolean eVn()
  {
    return this.Fry;
  }
  
  public final void eWA()
  {
    AppMethodBeat.i(196577);
    if (this.FrD != null)
    {
      this.FrD.stopTimer();
      this.FrD.quitSafely();
      this.FrD.removeCallbacksAndMessages(null);
    }
    AppMethodBeat.o(196577);
  }
  
  public final d eWv()
  {
    return this.Frw;
  }
  
  public final List<String> eWw()
  {
    AppMethodBeat.i(196568);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.FrE.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getKey());
    }
    AppMethodBeat.o(196568);
    return localArrayList;
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(196569);
    this.FrE = new HashMap();
    AppMethodBeat.o(196569);
  }
  
  public final ArrayList<String> eWy()
  {
    AppMethodBeat.i(196572);
    ArrayList localArrayList = new ArrayList(3);
    Object localObject = new ArrayList(this.FrE.entrySet());
    Collections.sort((List)localObject, new Comparator() {});
    if (!((List)localObject).isEmpty())
    {
      localArrayList.add(((Map.Entry)((List)localObject).get(0)).getKey());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localArrayList.size() >= 3) {
          break;
        }
        if (((ad.eYc().FrW != null) && (ad.eYc().FrW.contains(localEntry.getKey()))) || ((ad.eYc().eXm().Ftb != null) && (ad.eYc().eXm().Ftb.contains(localEntry.getKey())))) {
          localArrayList.add(localEntry.getKey());
        }
      }
    }
    AppMethodBeat.o(196572);
    return null;
    AppMethodBeat.o(196572);
    return localArrayList;
  }
  
  public final void eWz()
  {
    AppMethodBeat.i(196574);
    if (this.FrD != null)
    {
      this.FrD.stopTimer();
      this.FrD.quitSafely();
      this.FrD.removeCallbacksAndMessages(null);
    }
    this.FrD = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(200464);
        o.k(o.this);
        AppMethodBeat.o(200464);
        return true;
      }
    }, true);
    this.FrD.startTimer(33L);
    AppMethodBeat.o(196574);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(114438);
    paramString = (y)paramq;
    Log.i("MicroMsg.MT.MultiTalkEngine", "onSceneEnd errtype " + paramInt1 + " errCode " + paramInt2 + " cmdid " + paramString.mCmdId);
    this.Frw.d(paramInt2, paramString.vda, paramString.mCmdId, paramString.fZH);
    AppMethodBeat.o(114438);
  }
  
  public final void uB(boolean paramBoolean)
  {
    AppMethodBeat.i(114439);
    byte[] arrayOfByte = new byte[1];
    int i;
    boolean bool;
    com.tencent.mm.plugin.multitalk.b.o localo;
    if (paramBoolean)
    {
      i = 1;
      arrayOfByte[0] = ((byte)i);
      bool = ad.eYc().eXg();
      Log.printInfoStack("MicroMsg.MT.MultiTalkEngine", "setEngineHeadsetPlugged, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if (!bool) {
        break label137;
      }
      localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
      com.tencent.mm.plugin.multitalk.b.o.f(425, arrayOfByte, 1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (bool)
        {
          if (a.crh())
          {
            localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
            com.tencent.mm.plugin.multitalk.b.o.f(441, arrayOfByte, 1);
          }
          if (!a.cro()) {
            break label280;
          }
          localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
          com.tencent.mm.plugin.multitalk.b.o.f(442, arrayOfByte, 1);
          AppMethodBeat.o(114439);
          return;
          i = 0;
          break;
          label137:
          this.Frw.setAppCmd(425, arrayOfByte, 1);
          continue;
        }
        if (a.crh()) {
          this.Frw.setAppCmd(441, arrayOfByte, 1);
        }
        if (!a.cro()) {
          break label280;
        }
        this.Frw.setAppCmd(442, arrayOfByte, 1);
        AppMethodBeat.o(114439);
        return;
      }
    }
    if (bool)
    {
      localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
      com.tencent.mm.plugin.multitalk.b.o.f(441, arrayOfByte, 1);
      localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
      com.tencent.mm.plugin.multitalk.b.o.f(442, arrayOfByte, 1);
      AppMethodBeat.o(114439);
      return;
    }
    this.Frw.setAppCmd(441, arrayOfByte, 1);
    this.Frw.setAppCmd(442, arrayOfByte, 1);
    label280:
    AppMethodBeat.o(114439);
  }
  
  public final void uC(boolean paramBoolean)
  {
    AppMethodBeat.i(196595);
    byte[] arrayOfByte = new byte[1];
    boolean bool = ad.eYc().eXg();
    Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "qipengfeng, setEngineSpeakerOn, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    com.tencent.mm.plugin.multitalk.b.o localo;
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      if (bool)
      {
        localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
        com.tencent.mm.plugin.multitalk.b.o.f(401, arrayOfByte, 1);
        AppMethodBeat.o(196595);
        return;
      }
      this.Frw.setAppCmd(401, arrayOfByte, 1);
      AppMethodBeat.o(196595);
      return;
    }
    arrayOfByte[0] = 0;
    if (bool)
    {
      localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
      com.tencent.mm.plugin.multitalk.b.o.f(402, arrayOfByte, 1);
      AppMethodBeat.o(196595);
      return;
    }
    this.Frw.setAppCmd(402, arrayOfByte, 1);
    AppMethodBeat.o(196595);
  }
  
  public final void uD(boolean paramBoolean)
  {
    AppMethodBeat.i(196598);
    byte[] arrayOfByte = new byte[1];
    boolean bool = ad.eYc().eXg();
    Log.printDebugStack("MicroMsg.MT.MultiTalkEngine", "setEngineMicOn, %s, isILinkMode, %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    com.tencent.mm.plugin.multitalk.b.o localo;
    if (paramBoolean)
    {
      arrayOfByte[0] = 1;
      if (bool)
      {
        localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
        com.tencent.mm.plugin.multitalk.b.o.f(413, arrayOfByte, 1);
        AppMethodBeat.o(196598);
        return;
      }
      this.Frw.setAppCmd(413, arrayOfByte, 1);
      AppMethodBeat.o(196598);
      return;
    }
    arrayOfByte[0] = 0;
    if (bool)
    {
      localo = com.tencent.mm.plugin.multitalk.b.o.Fne;
      com.tencent.mm.plugin.multitalk.b.o.f(412, arrayOfByte, 1);
      AppMethodBeat.o(196598);
      return;
    }
    this.Frw.setAppCmd(412, arrayOfByte, 1);
    AppMethodBeat.o(196598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.o
 * JD-Core Version:    0.7.0.1
 */