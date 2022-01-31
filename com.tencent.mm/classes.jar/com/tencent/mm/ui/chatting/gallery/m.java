package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.m.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class m
{
  String bUi;
  long dmd;
  boolean eFA = false;
  boolean eFB = false;
  int eFr = 0;
  int eFs = 0;
  f eFt;
  int eFu;
  int eFv;
  boolean eFx;
  int eFy = 0;
  private int eFz;
  int fDG;
  String filename;
  HashMap<String, Integer> oRQ = new HashMap();
  int oRS;
  int oRT = 0;
  long oRU;
  long oRV;
  private long oRW;
  private int oRX;
  j vxP;
  a vxQ;
  
  public m(j paramj)
  {
    this.vxP = paramj;
    reset();
    this.eFt = new f();
    this.vxQ = new a((byte)0);
    paramj = g.AA().getValue("AndroidOnlineVideoArgs");
    if (!bk.bl(paramj))
    {
      y.i("MicroMsg.OnlineVideoUIHelper", "online video config : " + paramj);
      paramj = paramj.split(";");
      if ((paramj != null) && (paramj.length >= 4))
      {
        this.vxQ.eFI = bk.getInt(paramj[0], 5);
        this.vxQ.eFJ = bk.getInt(paramj[1], 1);
        this.vxQ.oSa = bk.getInt(paramj[2], 75);
        this.vxQ.vxS = (bk.getInt(paramj[3], 1) * 1048576);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.vxQ.eFI = 5;
        this.vxQ.eFJ = 1;
        this.vxQ.oSa = 75;
        this.vxQ.vxS = 1048576;
      }
      y.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[] { Integer.valueOf(this.vxQ.eFI), Integer.valueOf(this.vxQ.eFJ), Integer.valueOf(this.vxQ.oSa), Integer.valueOf(this.vxQ.vxS) });
      this.eFz = this.vxQ.eFI;
      return;
    }
  }
  
  private boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    paramPInt1.value = Math.max(paramInt, this.eFy);
    if (this.eFs == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.eFz;
    }
    if (this.eFs == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.eFz + 8);
    }
    if ((this.eFs == 3) || (this.eFs == 4))
    {
      paramPInt1.value = this.eFy;
      paramPInt2.value = (this.eFz + paramInt + 2 + this.vxQ.eFJ);
    }
    if (paramPInt2.value >= this.eFu + 1) {
      paramPInt2.value = (this.eFu + 1);
    }
    if (paramPInt2.value <= paramPInt1.value)
    {
      paramPInt1.value += this.vxQ.eFJ;
      return false;
    }
    y.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[] { Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.eFs), Integer.valueOf(this.eFy), Integer.valueOf(this.eFz) });
    return true;
  }
  
  private boolean f(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    boolean bool;
    try
    {
      if (this.eFt.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = o.Ss().isVideoDataAvailable(this.bUi, localPInt1.value, localPInt2.value);
        if (bool) {
          break label325;
        }
        if (!this.oRQ.containsKey(this.bUi + 0 + "_-1"))
        {
          String str = this.bUi + localPInt1.value + "_" + localPInt2.value;
          y.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[] { Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt2.value), Boolean.valueOf(this.eFB), Boolean.valueOf(paramBoolean) });
          if ((this.oRQ.containsKey(str)) || ((this.eFB) && (!paramBoolean))) {
            break label300;
          }
          this.eFB = true;
          o.Ss();
          com.tencent.mm.ak.e.h(this.bUi, localPInt1.value, localPInt2.value);
          this.oRQ.put(str, Integer.valueOf(paramInt2));
        }
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", localException, "", new Object[0]);
        y.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + localException.toString());
        bool = false;
      }
      label300:
      y.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + localException);
      return bool;
    }
    label325:
    y.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
    return bool;
  }
  
  public final boolean Pi(String paramString)
  {
    return bk.isEqual(paramString, this.bUi);
  }
  
  public final boolean at(int paramInt, boolean paramBoolean)
  {
    switch (this.eFr)
    {
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      y.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.eFr), Integer.valueOf(this.eFs) });
      h.nFQ.a(354L, 4L, 1L, false);
      return paramBoolean;
      this.eFs = 2;
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      a(paramInt, localPInt1, localPInt2);
      if (f(localPInt1.value, localPInt2.value, true))
      {
        this.eFv = -1;
        this.eFx = false;
        this.eFy = localPInt2.value;
        this.eFs = 3;
        this.vxP.X(paramInt, paramBoolean);
        break;
      }
      this.eFv = paramInt;
      this.eFx = true;
      this.vxP.Sg();
    }
  }
  
  final void bHV()
  {
    y.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[] { this.filename });
    bHW();
    ai.d(new m.2(this));
  }
  
  final void bHW()
  {
    if (this.oRV == 0L) {
      this.oRV = bk.UY();
    }
  }
  
  public final void cGJ()
  {
    y.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
    int i;
    if (this.eFr == 3)
    {
      i = 1;
      this.eFr = 0;
      if (!bk.bl(this.bUi))
      {
        if (i == 0) {
          break label76;
        }
        cGL();
      }
    }
    for (;;)
    {
      o.Ss().k(this.bUi, cGM());
      h.nFQ.a(354L, 2L, 1L, false);
      return;
      i = 0;
      break;
      label76:
      if (this.oRS >= this.vxQ.oSa)
      {
        y.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[] { Integer.valueOf(this.oRS), Integer.valueOf(this.vxQ.oSa) });
        u.X(this.filename, 2);
        h.nFQ.a(354L, 10L, 1L, false);
      }
    }
  }
  
  public final void cGK()
  {
    String str = this.bUi + 0 + "_-1";
    if (!this.oRQ.containsKey(str))
    {
      y.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[] { this.bUi });
      o.Ss();
      com.tencent.mm.ak.e.h(this.bUi, 0, -1);
      this.oRQ.put(str, Integer.valueOf(0));
      h.nFQ.a(354L, 24L, 1L, false);
      y.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[] { Integer.valueOf(hashCode()), this.filename });
      h.nFQ.f(13836, new Object[] { Integer.valueOf(303), Long.valueOf(bk.UX()), "" });
    }
    this.eFs = 5;
  }
  
  final void cGL()
  {
    o.Sr();
    boolean bool;
    if (r.nN(t.nS(this.filename)))
    {
      y.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[] { this.filename });
      s locals = u.oe(this.filename);
      if (locals == null) {
        break label150;
      }
      locals.videoFormat = 2;
      locals.status = 199;
      locals.eHG = bk.UX();
      locals.eHF = bk.UX();
      locals.dmi = 19;
      locals.bcw = 268438786;
      bool = o.Sr().c(locals);
      y.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + bool + " status: " + locals.status);
    }
    for (;;)
    {
      if (bool) {
        h.nFQ.a(354L, 134L, 1L, false);
      }
      return;
      label150:
      bool = false;
    }
  }
  
  final Object[] cGM()
  {
    Object[] arrayOfObject = new Object[7];
    j localj = this.vxP;
    if (localj.oRJ < 0) {
      localj.oRJ = 0;
    }
    y.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[] { localj.filename, Integer.valueOf(localj.oRJ) });
    arrayOfObject[0] = Integer.valueOf(localj.oRJ);
    if (this.oRV <= 0L) {
      this.oRV = bk.UY();
    }
    int j = (int)(this.oRV - this.dmd);
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[1] = Integer.valueOf(i);
    if (this.oRU <= 0L) {
      this.oRU = bk.UY();
    }
    j = (int)(this.oRU - this.dmd);
    i = j;
    if (j <= 0) {
      i = 0;
    }
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(this.oRT);
    if (this.oRT > 0)
    {
      if (this.oRX == 0) {
        this.oRX = ((int)(this.oRX + bk.co(this.oRW)));
      }
      arrayOfObject[4] = Integer.valueOf(this.oRX / this.oRT);
      localj = this.vxP;
      if ((localj.oRD <= 0L) || (localj.oRC <= 0L)) {
        break label351;
      }
    }
    label351:
    for (i = (int)(localj.oRD - localj.oRC);; i = 0)
    {
      j = i;
      if (i < 0) {
        j = 0;
      }
      y.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[] { Integer.valueOf(localj.hashCode()), localj.filename, Integer.valueOf(j), Long.valueOf(localj.oRD), Long.valueOf(localj.oRC) });
      arrayOfObject[5] = Integer.valueOf(j);
      arrayOfObject[6] = Integer.valueOf(this.vxP.kjS);
      return arrayOfObject;
      arrayOfObject[4] = Integer.valueOf(0);
      break;
    }
  }
  
  public final boolean isStreaming()
  {
    return (!bk.bl(this.bUi)) && ((this.eFr == 1) || (this.eFr == 3));
  }
  
  public final boolean jr(int paramInt)
  {
    boolean bool = false;
    if (this.eFv != -1) {}
    for (int i = this.eFv;; i = paramInt)
    {
      y.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.eFy), Integer.valueOf(this.eFu), Integer.valueOf(this.eFr), Long.valueOf(this.oRV - this.dmd), Boolean.valueOf(this.eFA) });
      switch (this.eFr)
      {
      case 2: 
      default: 
        return true;
      case 1: 
        if (!js(i))
        {
          this.eFx = true;
          if (this.eFy <= 0) {
            if (this.eFv == -1)
            {
              this.eFs = 1;
              bool = false;
            }
          }
        }
        for (;;)
        {
          this.vxP.HF(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label647;
          }
          if (!f(localPInt1.value, localPInt2.value, false)) {
            break label655;
          }
          this.eFy = Math.max(this.eFy, localPInt2.value);
          return true;
          this.eFs = 2;
          break;
          y.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.oRT + " playStatus : " + this.eFs);
          this.oRW = bk.UY();
          if ((this.eFs != 2) && (this.eFs != 4))
          {
            this.eFz += this.vxQ.eFI;
            this.eFz = Math.min(this.eFz, 60);
            this.oRT += 1;
            this.eFs = 4;
          }
          this.vxP.Sg();
          break;
          if ((this.oRT == 0) && (this.oRV == 0L)) {
            bHW();
          }
          if (this.eFA)
          {
            this.vxP.adF(this.filename);
            if (this.eFx) {
              if ((this.oRT == 0) && (this.oRV == 0L))
              {
                bHW();
                label427:
                y.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[] { Integer.valueOf(this.oRT), Integer.valueOf(this.oRX) });
                if (this.eFv == -1) {
                  break label533;
                }
                this.vxP.X(this.eFv, true);
                this.eFv = -1;
                bool = false;
                label486:
                this.eFx = bool;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.eFs = paramInt;
              label533:
              do
              {
                bool = true;
                break;
                if (this.oRW <= 0L) {
                  break label427;
                }
                this.oRX = ((int)(this.oRX + bk.co(this.oRW)));
                break label427;
                if (this.vxP.bHP())
                {
                  bool = false;
                  break label486;
                }
                bool = true;
                break label486;
              } while (this.eFs == 3);
              y.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[] { Integer.valueOf(this.eFs) });
              if (this.vxP.bHP()) {
                paramInt = 3;
              } else {
                paramInt = this.eFs;
              }
            }
          }
          y.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[] { this.filename });
          this.vxP.bg(this.filename, true);
          this.eFA = true;
          bool = true;
        }
        label647:
        y.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
        label655:
        return bool;
      }
      bHW();
      if (this.eFA)
      {
        if (this.eFx)
        {
          if (this.eFv == -1) {
            break label715;
          }
          this.vxP.X(this.eFv, true);
          this.eFv = -1;
        }
        for (;;)
        {
          this.eFx = bool;
          this.vxP.HF(i);
          return true;
          label715:
          if (!this.vxP.bHP()) {
            bool = true;
          }
        }
      }
      this.vxP.bg(this.filename, false);
      this.eFA = true;
      return true;
    }
  }
  
  /* Error */
  public final boolean js(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 46	com/tencent/mm/ui/chatting/gallery/m:eFr	I
    //   6: iconst_3
    //   7: if_icmpne +7 -> 14
    //   10: iconst_1
    //   11: istore_2
    //   12: iload_2
    //   13: ireturn
    //   14: aload_0
    //   15: getfield 50	com/tencent/mm/ui/chatting/gallery/m:eFy	I
    //   18: iload_1
    //   19: isub
    //   20: iconst_2
    //   21: if_icmpgt +14 -> 35
    //   24: aload_0
    //   25: getfield 50	com/tencent/mm/ui/chatting/gallery/m:eFy	I
    //   28: aload_0
    //   29: getfield 172	com/tencent/mm/ui/chatting/gallery/m:eFu	I
    //   32: if_icmplt -20 -> 12
    //   35: new 167	com/tencent/mm/pointers/PInt
    //   38: dup
    //   39: invokespecial 179	com/tencent/mm/pointers/PInt:<init>	()V
    //   42: astore 4
    //   44: new 167	com/tencent/mm/pointers/PInt
    //   47: dup
    //   48: invokespecial 179	com/tencent/mm/pointers/PInt:<init>	()V
    //   51: astore 5
    //   53: aload_0
    //   54: getfield 71	com/tencent/mm/ui/chatting/gallery/m:eFt	Lcom/tencent/mm/plugin/a/f;
    //   57: iload_1
    //   58: iload_1
    //   59: iconst_2
    //   60: iadd
    //   61: aload 4
    //   63: aload 5
    //   65: invokevirtual 182	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   68: ifeq +91 -> 159
    //   71: invokestatic 188	com/tencent/mm/modelvideo/o:Ss	()Lcom/tencent/mm/ak/e;
    //   74: aload_0
    //   75: getfield 190	com/tencent/mm/ui/chatting/gallery/m:bUi	Ljava/lang/String;
    //   78: aload 4
    //   80: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   83: aload 5
    //   85: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   88: invokevirtual 196	com/tencent/mm/ak/e:isVideoDataAvailable	(Ljava/lang/String;II)Z
    //   91: istore_2
    //   92: iload_2
    //   93: istore_3
    //   94: iload_2
    //   95: ifne +10 -> 105
    //   98: aload_0
    //   99: iload_1
    //   100: putfield 50	com/tencent/mm/ui/chatting/gallery/m:eFy	I
    //   103: iload_2
    //   104: istore_3
    //   105: iload_3
    //   106: ireturn
    //   107: astore 4
    //   109: iconst_0
    //   110: istore_2
    //   111: ldc 98
    //   113: aload 4
    //   115: ldc 225
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 229	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: ldc 98
    //   126: new 100	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 231
    //   132: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload 4
    //   137: invokevirtual 232	java/lang/Exception:toString	()Ljava/lang/String;
    //   140: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 235	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iload_2
    //   150: istore_3
    //   151: goto -46 -> 105
    //   154: astore 4
    //   156: goto -45 -> 111
    //   159: iconst_0
    //   160: istore_3
    //   161: goto -56 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	m
    //   0	164	1	paramInt	int
    //   1	149	2	bool1	boolean
    //   93	68	3	bool2	boolean
    //   42	37	4	localPInt1	PInt
    //   107	29	4	localException1	Exception
    //   154	1	4	localException2	Exception
    //   51	33	5	localPInt2	PInt
    // Exception table:
    //   from	to	target	type
    //   53	92	107	java/lang/Exception
    //   98	103	154	java/lang/Exception
  }
  
  public final void reset()
  {
    this.bUi = "";
    this.filename = "";
    this.eFv = -1;
    this.oRS = 0;
    this.fDG = 0;
    this.eFy = 0;
    this.eFu = 0;
    this.oRT = 0;
    this.eFs = 0;
    this.eFr = 0;
    this.eFx = false;
    this.eFA = false;
    this.eFB = false;
    this.oRQ.clear();
    if (this.vxQ != null) {
      this.eFz = this.vxQ.eFI;
    }
    this.oRU = 0L;
    this.dmd = 0L;
    this.oRX = 0;
    this.oRW = 0L;
    this.oRV = 0L;
  }
  
  private static final class a
  {
    int eFI;
    int eFJ;
    int oSa;
    int vxS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m
 * JD-Core Version:    0.7.0.1
 */