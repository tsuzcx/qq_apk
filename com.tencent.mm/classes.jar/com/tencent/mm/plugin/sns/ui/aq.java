package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ny;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public final class aq
{
  HashMap<String, Integer> RhF;
  com.tencent.mm.plugin.a.j RhG;
  a RhH;
  int RhI;
  private int RhJ;
  long RhK;
  private long RhL;
  private long RhM;
  private int RhN;
  private b RhO;
  private final Object RhP;
  final String TAG;
  private boolean clear;
  private int createTime;
  private String hES;
  private dmz ibT;
  long lxf;
  private int oYA;
  boolean oYB;
  boolean oYC;
  String oYq;
  String oYr;
  int oYs;
  int oYt;
  int oYv;
  int oYw;
  boolean oYy;
  int oYz;
  int progress;
  int total;
  
  public aq(a parama)
  {
    AppMethodBeat.i(98119);
    this.TAG = ("MicroMsg.OnlineVideoViewHelper[" + hashCode() + ']');
    this.oYs = 0;
    this.oYt = 0;
    this.RhF = null;
    this.oYz = 0;
    this.oYB = false;
    this.oYC = false;
    this.RhJ = 0;
    this.clear = false;
    this.RhP = new Object();
    this.RhH = parama;
    this.RhG = new com.tencent.mm.plugin.a.j();
    this.RhF = new HashMap();
    this.RhO = new b((byte)0);
    this.RhO.oYJ = i.aRC().getInt("SnsVideoPreloadSec", 5);
    this.RhO.oYK = i.aRC().getInt("SnsVideoDownloadSec", 1);
    this.RhO.RhR = i.aRC().getInt("SnsVideoFullDownloadPercent", 101);
    Log.i(this.TAG, "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[] { Integer.valueOf(this.RhO.oYJ), Integer.valueOf(this.RhO.oYK), Integer.valueOf(this.RhO.RhR) });
    reset();
    this.clear = false;
    AppMethodBeat.o(98119);
  }
  
  private static void Eb(boolean paramBoolean)
  {
    AppMethodBeat.i(98137);
    if (paramBoolean)
    {
      h.OAn.idkeyStat(354L, 201L, 1L, false);
      AppMethodBeat.o(98137);
      return;
    }
    h.OAn.idkeyStat(354L, 202L, 1L, false);
    AppMethodBeat.o(98137);
  }
  
  private void alO(int paramInt)
  {
    AppMethodBeat.i(308435);
    synchronized (this.RhP)
    {
      if (this.RhH != null) {
        this.RhH.alJ(paramInt * 1000);
      }
      AppMethodBeat.o(308435);
      return;
    }
  }
  
  private boolean hmU()
  {
    AppMethodBeat.i(98126);
    synchronized (this.RhP)
    {
      if (this.RhH != null)
      {
        boolean bool = this.RhH.hmF();
        AppMethodBeat.o(98126);
        return bool;
      }
      AppMethodBeat.o(98126);
      return true;
    }
  }
  
  private void hmW()
  {
    AppMethodBeat.i(98133);
    this.oYy = true;
    if (this.oYz <= 0)
    {
      if (this.oYw == -1)
      {
        this.oYt = 1;
        AppMethodBeat.o(98133);
        return;
      }
      this.oYt = 2;
      AppMethodBeat.o(98133);
      return;
    }
    Log.i(this.TAG, "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[] { this.oYq, Integer.valueOf(this.RhJ), Integer.valueOf(this.oYt) });
    this.RhM = Util.nowMilliSecond();
    if ((this.oYt != 2) && (this.oYt != 4))
    {
      this.oYA += this.RhO.oYJ;
      this.oYA = Math.min(this.oYA, 60);
      this.RhJ += 1;
      this.oYt = 4;
    }
    this.RhH.bNT();
    AppMethodBeat.o(98133);
  }
  
  private void hmX()
  {
    boolean bool = false;
    AppMethodBeat.i(98134);
    if (this.oYy)
    {
      if ((this.RhJ == 0) && (this.RhL == 0L)) {
        hmY();
      }
      for (;;)
      {
        Log.i(this.TAG, "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[] { Integer.valueOf(this.RhJ), Integer.valueOf(this.RhN), this.oYq });
        this.oYt = 3;
        if (this.oYw == -1) {
          break;
        }
        alN(this.oYw);
        this.oYw = -1;
        this.oYy = false;
        AppMethodBeat.o(98134);
        return;
        if (this.RhM > 0L) {
          this.RhN = ((int)(this.RhN + Util.milliSecondsToNow(this.RhM)));
        }
      }
      if (hmU()) {}
      for (;;)
      {
        this.oYy = bool;
        AppMethodBeat.o(98134);
        return;
        bool = true;
      }
    }
    if (this.oYt != 3)
    {
      Log.i(this.TAG, "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.oYt) });
      if (!hmU()) {
        break label215;
      }
    }
    label215:
    for (int i = 3;; i = this.oYt)
    {
      this.oYt = i;
      AppMethodBeat.o(98134);
      return;
    }
  }
  
  private Object[] hmZ()
  {
    AppMethodBeat.i(98136);
    Object[] arrayOfObject = new Object[14];
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    String str4 = "";
    long l = 0L;
    String str3 = "";
    String str2 = "";
    String str1 = "";
    for (;;)
    {
      synchronized (this.RhP)
      {
        if (this.RhH == null) {
          break label464;
        }
        n = this.RhH.getPlayVideoDuration();
        m = this.RhH.getUiStayTime();
        k = this.RhH.getPlayErrorCode();
        j = this.RhH.getRptStruct().scene;
        str4 = this.RhH.getRptStruct().sessionId;
        l = this.RhH.getRptStruct().RgS;
        str3 = this.RhH.getRptStruct().hQX;
        str2 = this.RhH.getRptStruct().hQU;
        str1 = this.RhH.getRptStruct().filePath;
        i = this.RhH.getPlayVideoDurationByResume();
        arrayOfObject[0] = Integer.valueOf(n);
        if (this.RhL <= 0L) {
          this.RhL = Util.nowMilliSecond();
        }
        int i1 = (int)(this.RhL - this.lxf);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[1] = Integer.valueOf(n);
        if (this.RhK <= 0L) {
          this.RhK = Util.nowMilliSecond();
        }
        i1 = (int)(this.RhK - this.lxf);
        n = i1;
        if (i1 <= 0) {
          n = 0;
        }
        arrayOfObject[2] = Integer.valueOf(n);
        arrayOfObject[3] = Integer.valueOf(this.RhJ);
        if (this.RhJ > 0)
        {
          if (this.RhN == 0) {
            this.RhN = ((int)(this.RhN + Util.milliSecondsToNow(this.RhM)));
          }
          arrayOfObject[4] = Integer.valueOf(this.RhN / this.RhJ);
          arrayOfObject[5] = Integer.valueOf(m);
          arrayOfObject[6] = Integer.valueOf(k);
          arrayOfObject[7] = Integer.valueOf(j);
          arrayOfObject[8] = str4;
          arrayOfObject[9] = Long.valueOf(l);
          arrayOfObject[10] = str3;
          arrayOfObject[11] = str2;
          arrayOfObject[12] = str1;
          arrayOfObject[13] = Integer.valueOf(i);
          AppMethodBeat.o(98136);
          return arrayOfObject;
        }
      }
      arrayOfObject[4] = Integer.valueOf(0);
      continue;
      label464:
      int i = 0;
    }
  }
  
  private static void hna()
  {
    AppMethodBeat.i(98138);
    h.OAn.idkeyStat(354L, 203L, 1L, false);
    AppMethodBeat.o(98138);
  }
  
  private void hnb()
  {
    AppMethodBeat.i(98139);
    Object[] arrayOfObject = hmZ();
    long l1 = 0L;
    Object localObject1 = new PInt();
    new PInt().value = 0;
    ((PInt)localObject1).value = 0;
    int i4 = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
    int j = 0;
    localObject1 = "";
    String str1 = "";
    Object localObject2 = "";
    int i2;
    int i3;
    int k;
    int m;
    int n;
    int i1;
    String str2;
    int i;
    if (arrayOfObject != null)
    {
      i2 = ((Integer)arrayOfObject[1]).intValue();
      i3 = ((Integer)arrayOfObject[2]).intValue();
      k = ((Integer)arrayOfObject[3]).intValue();
      m = ((Integer)arrayOfObject[4]).intValue();
      n = ((Integer)arrayOfObject[5]).intValue();
      i1 = ((Integer)arrayOfObject[6]).intValue();
      j = ((Integer)arrayOfObject[7]).intValue();
      str2 = (String)arrayOfObject[8];
      i = ((Long)arrayOfObject[9]).intValue();
      localObject1 = (String)arrayOfObject[10];
      str1 = (String)arrayOfObject[11];
      localObject2 = (String)arrayOfObject[12];
      l1 = ((Integer)arrayOfObject[13]).intValue() * 1000;
    }
    for (;;)
    {
      long l2 = y.bEl((String)localObject2);
      localObject2 = new ny();
      ((ny)localObject2).iVU = i4;
      ((ny)localObject2).irv = 0L;
      ((ny)localObject2).irw = 0L;
      ((ny)localObject2).iYT = l2;
      ((ny)localObject2).vW((String)localObject1);
      ((ny)localObject2).vV(str1);
      ((ny)localObject2).iXC = l1;
      ((ny)localObject2).iYV = i2;
      ((ny)localObject2).iYW = i3;
      ((ny)localObject2).iYX = k;
      ((ny)localObject2).iRV = m;
      ((ny)localObject2).iZq = n;
      ((ny)localObject2).iZr = i1;
      ((ny)localObject2).jgO = j;
      ((ny)localObject2).vX(str2);
      ((ny)localObject2).jgQ = i;
      ((ny)localObject2).bMH();
      AppMethodBeat.o(98139);
      return;
      i = 0;
      str2 = "";
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      i2 = 0;
      i3 = 0;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(98121);
    this.oYq = "";
    this.oYw = -1;
    this.oYz = 0;
    this.oYv = 0;
    this.RhJ = 0;
    this.oYt = 0;
    this.oYs = 0;
    this.oYy = false;
    this.oYB = false;
    this.oYC = false;
    this.RhF.clear();
    this.ibT = null;
    this.createTime = 0;
    this.hES = null;
    if (this.RhO != null) {
      this.oYA = this.RhO.oYJ;
    }
    this.RhK = 0L;
    this.lxf = 0L;
    this.RhN = 0;
    this.RhM = 0L;
    this.RhL = 0L;
    AppMethodBeat.o(98121);
  }
  
  private boolean xb(int paramInt)
  {
    boolean bool3 = false;
    bool1 = false;
    AppMethodBeat.i(98130);
    if (this.oYs == 3)
    {
      AppMethodBeat.o(98130);
      return true;
    }
    if ((this.oYz - paramInt <= 1) && (this.oYz < this.oYv))
    {
      AppMethodBeat.o(98130);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    bool2 = bool3;
    try
    {
      if (this.RhG.a(paramInt, paramInt + 1, localPInt1, localPInt2))
      {
        bool2 = bool3;
        bool3 = v.bOi().isVideoDataAvailable(this.oYq, localPInt1.value, localPInt2.value);
        bool1 = bool3;
        if (!bool3)
        {
          bool2 = bool3;
          this.oYz = paramInt;
          bool1 = bool3;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "check video data error: " + localException.toString());
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(98130);
    return bool1;
  }
  
  final void Ea(boolean paramBoolean)
  {
    AppMethodBeat.i(98128);
    synchronized (this.RhP)
    {
      if (this.RhH != null) {
        this.RhH.di(this.oYr, paramBoolean);
      }
      AppMethodBeat.o(98128);
      return;
    }
  }
  
  final boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(98129);
    paramPInt1.value = Math.max(paramInt, this.oYz);
    if (this.oYt == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.oYA;
    }
    if (this.oYt == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.oYA + 8);
    }
    if ((this.oYt == 3) || (this.oYt == 4))
    {
      paramPInt1.value = this.oYz;
      paramPInt2.value = (this.oYA + paramInt + 1 + this.RhO.oYK);
    }
    if (paramPInt2.value >= this.oYv + 1) {
      paramPInt2.value = (this.oYv + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.RhO.oYK;
      AppMethodBeat.o(98129);
      return false;
    }
    Log.i(this.TAG, "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.oYt), Integer.valueOf(this.oYz), Integer.valueOf(this.oYA) });
    AppMethodBeat.o(98129);
    return true;
  }
  
  public final boolean a(dmz paramdmz, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(98122);
    if (this.clear)
    {
      AppMethodBeat.o(98122);
      return false;
    }
    this.ibT = paramdmz;
    this.createTime = paramInt1;
    this.hES = paramString;
    this.oYr = az.E(paramdmz);
    this.oYq = az.de(paramInt1, paramdmz.Url);
    if ((Util.isNullOrNil(this.oYr)) || (Util.isNullOrNil(this.oYq)))
    {
      AppMethodBeat.o(98122);
      return false;
    }
    Log.i(this.TAG, "start online download video %s isPlayMode %b", new Object[] { this.oYq, Boolean.valueOf(paramBoolean) });
    al.hgz().a(paramdmz, paramInt1, paramString, paramBoolean, true, paramInt2);
    this.oYs = 1;
    this.lxf = Util.nowMilliSecond();
    Eb(paramBoolean);
    AppMethodBeat.o(98122);
    return true;
  }
  
  final void alN(int paramInt)
  {
    AppMethodBeat.i(98127);
    synchronized (this.RhP)
    {
      if (this.RhH != null) {
        this.RhH.bJ(paramInt, true);
      }
      AppMethodBeat.o(98127);
      return;
    }
  }
  
  public final boolean bay(String paramString)
  {
    AppMethodBeat.i(98124);
    boolean bool = Util.isEqual(this.oYq, paramString);
    AppMethodBeat.o(98124);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(98120);
    Log.i(this.TAG, "clear");
    this.clear = true;
    reset();
    synchronized (this.RhP)
    {
      this.RhH = null;
      this.RhG = null;
      AppMethodBeat.o(98120);
      return;
    }
  }
  
  final boolean hmG()
  {
    AppMethodBeat.i(308459);
    synchronized (this.RhP)
    {
      if (this.RhH != null)
      {
        boolean bool = this.RhH.hmG();
        Log.i(this.TAG, "isPlayAllowed: %s", new Object[] { Boolean.toString(bool) });
        bool = this.RhH.hmG();
        AppMethodBeat.o(308459);
        return bool;
      }
      AppMethodBeat.o(308459);
      return false;
    }
  }
  
  public final boolean hmT()
  {
    AppMethodBeat.i(98123);
    boolean bool;
    if (!Util.isNullOrNil(this.oYq)) {
      if (this.oYs == 3)
      {
        bool = true;
        Log.i(this.TAG, "stop online download video %s isFinish %b percent %d", new Object[] { this.oYq, Boolean.valueOf(bool), Integer.valueOf(this.RhI) });
        al.hgz().p(this.oYq, hmZ());
        if ((this.RhI >= this.RhO.RhR) && (!bool)) {
          al.hgz().a(this.ibT, this.createTime, this.hES, false, false, 36);
        }
        hna();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(98123);
      return true;
      bool = false;
      break;
      hnb();
    }
  }
  
  final void hmV()
  {
    AppMethodBeat.i(98132);
    Log.i(this.TAG, "play offline video %s ", new Object[] { this.oYq });
    hmY();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98118);
        if ((aq.this.hmG()) && (aq.this.RhH != null)) {
          aq.this.Ea(false);
        }
        AppMethodBeat.o(98118);
      }
    });
    AppMethodBeat.o(98132);
  }
  
  final void hmY()
  {
    AppMethodBeat.i(98135);
    if (this.RhL == 0L) {
      this.RhL = Util.nowMilliSecond();
    }
    AppMethodBeat.o(98135);
  }
  
  final boolean p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(308472);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.RhG.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        localPInt2.value += 81920;
        bool = v.bOi().isVideoDataAvailable(this.oYq, localPInt1.value, localPInt2.value);
        if (bool) {
          break label382;
        }
        if (!this.RhF.containsKey(this.oYq + 0 + "_-1"))
        {
          String str = this.oYq + localPInt1.value + "_" + localPInt2.value;
          Log.i(this.TAG, "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.oYC), Boolean.valueOf(paramBoolean) });
          if ((this.RhF.containsKey(str)) || ((this.oYC) && (!paramBoolean))) {
            break label361;
          }
          this.oYC = true;
          this.RhF.put(str, Integer.valueOf(paramInt2));
          v.bOi();
          paramInt1 = com.tencent.mm.modelcdntran.j.v(this.oYq, localPInt1.value, localPInt2.value);
          if (paramInt1 != 0)
          {
            this.oYC = false;
            this.RhF.remove(str);
            Log.i(this.TAG, "requestVideoData not success %s", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        AppMethodBeat.o(308472);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "check video data error: " + localException.toString());
        boolean bool = false;
        continue;
        label361:
        Log.i(this.TAG, "already request video : ".concat(String.valueOf(localException)));
        continue;
        label382:
        Log.i(this.TAG, "already had video data.");
      }
    }
  }
  
  public final boolean xa(int paramInt)
  {
    AppMethodBeat.i(98125);
    if (this.clear)
    {
      AppMethodBeat.o(98125);
      return false;
    }
    if (this.oYw != -1) {}
    for (int i = this.oYw;; i = paramInt)
    {
      boolean bool3 = true;
      boolean bool2 = true;
      Log.i(this.TAG, "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.oYz), Integer.valueOf(this.oYv), Integer.valueOf(this.oYt), Integer.valueOf(this.oYs), this.oYq, Long.valueOf(this.RhL - this.lxf), Boolean.valueOf(this.oYB) });
      if (this.RhH == null)
      {
        Log.i(this.TAG, "ui is null, checkTimer false");
        AppMethodBeat.o(98125);
        return false;
      }
      boolean bool1;
      switch (this.oYs)
      {
      default: 
        Log.w(this.TAG, "check time default.");
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(98125);
        return bool1;
        if (!xb(i))
        {
          hmW();
          bool1 = false;
        }
        for (;;)
        {
          alO(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label405;
          }
          if (!p(localPInt1.value, localPInt2.value, false)) {
            break;
          }
          this.oYz = Math.max(this.oYz, localPInt2.value);
          bool1 = true;
          break;
          hmY();
          if (this.oYB)
          {
            alO(i);
            bool1 = bool3;
            if (hmG())
            {
              hmX();
              bool1 = bool3;
            }
          }
          else
          {
            Log.i(this.TAG, "prepare cdnMediaId [%s]", new Object[] { this.oYq });
            if (this.oYt == 5) {
              this.oYt = 1;
            }
            bool1 = bool3;
            if (hmG())
            {
              Ea(true);
              this.oYB = true;
              bool1 = bool3;
            }
          }
        }
        label405:
        Log.d(this.TAG, "can not calc download.");
        v.bOi();
        com.tencent.mm.modelcdntran.j.v(this.oYq, 0, -1);
        continue;
        hmY();
        if (this.oYB)
        {
          if (this.oYy)
          {
            if (this.oYw == -1) {
              break label494;
            }
            alN(this.oYw);
            this.oYw = -1;
            bool1 = false;
          }
          for (;;)
          {
            this.oYy = bool1;
            this.oYt = 3;
            alO(i);
            bool1 = bool2;
            break;
            label494:
            if (hmU()) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
        }
        if (this.oYt == 5) {
          this.oYt = 1;
        }
        bool1 = bool2;
        if (hmG())
        {
          Ea(false);
          this.oYB = true;
          bool1 = bool2;
          continue;
          Log.w(this.TAG, "download error.");
          bool1 = bool2;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void alJ(int paramInt);
    
    public abstract void bJ(int paramInt, boolean paramBoolean);
    
    public abstract void bNT();
    
    public abstract void di(String paramString, boolean paramBoolean);
    
    public abstract int getPlayErrorCode();
    
    public abstract int getPlayVideoDuration();
    
    public abstract int getPlayVideoDurationByResume();
    
    public abstract aq.c getRptStruct();
    
    public abstract int getUiStayTime();
    
    public abstract boolean hmF();
    
    public abstract boolean hmG();
  }
  
  static final class b
  {
    int RhR;
    int oYJ;
    int oYK;
  }
  
  public static class c
  {
    public long RgS = 0L;
    public String filePath = "";
    public String hQU = "";
    public String hQX = "";
    public int scene = 0;
    public String sessionId = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aq
 * JD-Core Version:    0.7.0.1
 */