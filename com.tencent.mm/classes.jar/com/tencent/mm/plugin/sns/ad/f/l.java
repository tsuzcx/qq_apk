package com.tencent.mm.plugin.sns.ad.f;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.c.a;
import com.tencent.mm.plugin.sns.ad.c.a.c.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l
  implements e
{
  public static Map<String, Integer> JEQ;
  private int APq;
  private int INC;
  public HashMap<String, Long> JEF;
  public HashSet<Long> JEG;
  private Map<String, Long> JEH;
  private Map<String, Integer> JEI;
  private Map<String, c> JEJ;
  public HashSet<Long> JEK;
  public Map<Long, m> JEL;
  public Map<Long, m> JEM;
  public Map<String, d> JEN;
  public Map<String, a> JEO;
  private Map<String, Integer> JEP;
  private int JER;
  private View JES;
  public Map<Long, Integer> JET;
  public Map<Long, Integer> JEU;
  public HashSet<String> JEV;
  private Activity activity;
  public int source;
  
  static
  {
    AppMethodBeat.i(95019);
    JEQ = new HashMap();
    AppMethodBeat.o(95019);
  }
  
  public l(int paramInt)
  {
    AppMethodBeat.i(94996);
    this.JEF = new HashMap();
    this.JEG = new HashSet();
    this.JEH = new HashMap();
    this.JEI = new HashMap();
    this.JEJ = new HashMap();
    this.JEK = new HashSet();
    this.JEL = new HashMap();
    this.JEM = new HashMap();
    this.JEN = new HashMap();
    this.JEO = new HashMap();
    this.source = 0;
    this.JEP = new HashMap();
    this.JER = 0;
    this.APq = 0;
    this.JES = null;
    this.JET = new HashMap();
    this.JEU = new HashMap();
    this.JEV = new HashSet();
    this.INC = -1;
    this.source = paramInt;
    AppMethodBeat.o(94996);
  }
  
  private d aYB(String paramString)
  {
    AppMethodBeat.i(203788);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(203788);
        return null;
      }
      paramString = (d)this.JEN.remove(paramString);
      AppMethodBeat.o(203788);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SnsAdStatistic", "removeAdRemovedListener exp= " + paramString.toString());
      AppMethodBeat.o(203788);
    }
    return null;
  }
  
  private ADInfo h(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95010);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        AppMethodBeat.o(95010);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdInfo();
      AppMethodBeat.o(95010);
      return paramSnsInfo;
    }
    AppMethodBeat.o(95010);
    return null;
  }
  
  private com.tencent.mm.cd.b i(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95011);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSourceInfo();
        AppMethodBeat.o(95011);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdSnsInfo().getTimelineRemindInfoSourceInfo();
      AppMethodBeat.o(95011);
      return paramSnsInfo;
    }
    AppMethodBeat.o(95011);
    return null;
  }
  
  private com.tencent.mm.cd.b j(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95012);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSelfInfo();
        AppMethodBeat.o(95012);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdSnsInfo().getTimelineRemindInfoSelfInfo();
      AppMethodBeat.o(95012);
      return paramSnsInfo;
    }
    AppMethodBeat.o(95012);
    return null;
  }
  
  public final void I(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(94999);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94990);
        if (l.this.Qi(paramLong))
        {
          l locall = l.this;
          long l = paramLong;
          boolean bool = this.JEX;
          m localm;
          if (bool) {
            if (locall.JEM.containsKey(Long.valueOf(l))) {
              localm = (m)locall.JEM.get(Long.valueOf(l));
            }
          }
          for (;;)
          {
            localm.JFm = 1;
            localm.JFu.JGE += 1;
            if (!bool) {
              break;
            }
            locall.JEM.put(Long.valueOf(l), localm);
            AppMethodBeat.o(94990);
            return;
            localm = new m("timeline");
            continue;
            if (locall.JEL.containsKey(Long.valueOf(l))) {
              localm = (m)locall.JEL.get(Long.valueOf(l));
            } else {
              localm = new m("timeline");
            }
          }
          locall.JEL.put(Long.valueOf(l), localm);
        }
        AppMethodBeat.o(94990);
      }
    });
    AppMethodBeat.o(94999);
  }
  
  public final void J(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95003);
    d(paramLong, paramBoolean, false);
    AppMethodBeat.o(95003);
  }
  
  public final void K(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95008);
    m localm;
    if (paramBoolean)
    {
      if (this.JEM.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.JEM.get(Long.valueOf(paramLong));
        localm.aeO(0);
      }
      for (;;)
      {
        this.JEM.put(Long.valueOf(paramLong), localm);
        AppMethodBeat.o(95008);
        return;
        localm = new m("timeline");
      }
    }
    if (this.JEL.containsKey(Long.valueOf(paramLong)))
    {
      localm = (m)this.JEL.get(Long.valueOf(paramLong));
      localm.aeO(0);
    }
    for (;;)
    {
      this.JEL.put(Long.valueOf(paramLong), localm);
      AppMethodBeat.o(95008);
      return;
      localm = new m("timeline");
    }
  }
  
  public final boolean Qi(long paramLong)
  {
    AppMethodBeat.i(94995);
    boolean bool = this.JEG.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(94995);
    return bool;
  }
  
  public final boolean Qj(long paramLong)
  {
    AppMethodBeat.i(95006);
    if (this.JEK.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95006);
      return true;
    }
    AppMethodBeat.o(95006);
    return false;
  }
  
  public final void Qk(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = 0;
    if (this.JET.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.JET.get(Long.valueOf(paramLong))).intValue();
    }
    this.JET.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95017);
  }
  
  public final void Ql(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = 0;
    if (this.JEU.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.JEU.get(Long.valueOf(paramLong))).intValue();
    }
    this.JEU.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95018);
  }
  
  public final void Qm(final long paramLong)
  {
    AppMethodBeat.i(203777);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200096);
        m localm = (m)l.this.JEL.get(Long.valueOf(paramLong));
        if (localm != null) {
          localm.fKU();
        }
        AppMethodBeat.o(200096);
      }
    });
    AppMethodBeat.o(203777);
  }
  
  public final void Qn(final long paramLong)
  {
    AppMethodBeat.i(203781);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(263112);
        m localm = (m)l.this.JEL.get(Long.valueOf(paramLong));
        if ((localm != null) && (!l.a(l.this))) {
          localm.fIT();
        }
        AppMethodBeat.o(263112);
      }
    });
    AppMethodBeat.o(203781);
  }
  
  public final long Qo(long paramLong)
  {
    AppMethodBeat.i(203785);
    try
    {
      m localm = (m)this.JEL.get(Long.valueOf(paramLong));
      if (localm != null)
      {
        paramLong = localm.JFx;
        AppMethodBeat.o(203785);
        return paramLong;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + localThrowable.toString());
      AppMethodBeat.o(203785);
    }
    return 0L;
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.APq = paramInt;
    this.JES = paramView;
    this.activity = paramActivity;
  }
  
  /* Error */
  public final void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 313
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 86	com/tencent/mm/plugin/sns/ad/f/l:JEF	Ljava/util/HashMap;
    //   10: aload_2
    //   11: invokevirtual 314	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   14: ifeq +32 -> 46
    //   17: aload_0
    //   18: getfield 86	com/tencent/mm/plugin/sns/ad/f/l:JEF	Ljava/util/HashMap;
    //   21: aload_2
    //   22: invokevirtual 315	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 248	java/lang/Long
    //   28: invokevirtual 319	java/lang/Long:longValue	()J
    //   31: lstore 11
    //   33: aload_0
    //   34: getfield 91	com/tencent/mm/plugin/sns/ad/f/l:JEG	Ljava/util/HashSet;
    //   37: lload 11
    //   39: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: invokevirtual 321	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   45: pop
    //   46: aconst_null
    //   47: astore 18
    //   49: aconst_null
    //   50: astore 21
    //   52: aload_0
    //   53: getfield 97	com/tencent/mm/plugin/sns/ad/f/l:JEJ	Ljava/util/Map;
    //   56: aload_2
    //   57: invokeinterface 258 2 0
    //   62: checkcast 323	com/tencent/mm/plugin/sns/ad/f/c
    //   65: astore 23
    //   67: aload 18
    //   69: astore 20
    //   71: aload 21
    //   73: astore 19
    //   75: aload 23
    //   77: ifnull +1222 -> 1299
    //   80: aload 18
    //   82: astore 20
    //   84: aload 21
    //   86: astore 19
    //   88: getstatic 329	com/tencent/mm/plugin/sns/model/aj:JXk	Z
    //   91: ifeq +1208 -> 1299
    //   94: aload 23
    //   96: iconst_1
    //   97: putfield 332	com/tencent/mm/plugin/sns/ad/f/c:kSa	Z
    //   100: aload 23
    //   102: invokestatic 337	java/lang/System:currentTimeMillis	()J
    //   105: putfield 340	com/tencent/mm/plugin/sns/ad/f/c:JEj	J
    //   108: aload 23
    //   110: iconst_0
    //   111: putfield 343	com/tencent/mm/plugin/sns/ad/f/c:JEB	I
    //   114: aload_0
    //   115: iconst_0
    //   116: invokevirtual 347	com/tencent/mm/plugin/sns/ad/f/l:yo	(Z)V
    //   119: aload 23
    //   121: getfield 350	com/tencent/mm/plugin/sns/ad/f/c:JEe	I
    //   124: ifge +1091 -> 1215
    //   127: aload 23
    //   129: iconst_2
    //   130: putfield 353	com/tencent/mm/plugin/sns/ad/f/c:JEz	I
    //   133: aload 23
    //   135: getfield 356	com/tencent/mm/plugin/sns/ad/f/c:JEg	I
    //   138: ifge +1086 -> 1224
    //   141: aload 23
    //   143: iconst_2
    //   144: putfield 359	com/tencent/mm/plugin/sns/ad/f/c:JEA	I
    //   147: new 175	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   154: astore 18
    //   156: aload 18
    //   158: new 175	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   165: aload 23
    //   167: getfield 363	com/tencent/mm/plugin/sns/ad/f/c:JEb	J
    //   170: invokestatic 369	com/tencent/mm/plugin/sns/data/t:Qu	(J)Ljava/lang/String;
    //   173: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 371
    //   179: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 18
    //   191: new 175	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   198: aload 23
    //   200: getfield 375	com/tencent/mm/plugin/sns/ad/f/c:jDL	Ljava/lang/String;
    //   203: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 371
    //   209: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 18
    //   221: new 175	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   228: aload 23
    //   230: getfield 353	com/tencent/mm/plugin/sns/ad/f/c:JEz	I
    //   233: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc_w 371
    //   239: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 18
    //   251: new 175	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   258: aload 23
    //   260: getfield 359	com/tencent/mm/plugin/sns/ad/f/c:JEA	I
    //   263: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 371
    //   269: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 18
    //   281: new 175	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   288: aload 23
    //   290: getfield 381	com/tencent/mm/plugin/sns/ad/f/c:JEw	I
    //   293: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: ldc_w 371
    //   299: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 18
    //   311: new 175	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   318: aload 23
    //   320: getfield 384	com/tencent/mm/plugin/sns/ad/f/c:JEx	I
    //   323: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 371
    //   329: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 18
    //   341: new 175	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   348: aload 23
    //   350: getfield 387	com/tencent/mm/plugin/sns/ad/f/c:JEy	I
    //   353: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc_w 371
    //   359: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 18
    //   371: new 175	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   378: aload 23
    //   380: getfield 390	com/tencent/mm/plugin/sns/ad/f/c:JEi	J
    //   383: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: ldc_w 371
    //   389: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 18
    //   401: new 175	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   408: aload 23
    //   410: getfield 340	com/tencent/mm/plugin/sns/ad/f/c:JEj	J
    //   413: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: ldc_w 371
    //   419: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 23
    //   431: getfield 396	com/tencent/mm/plugin/sns/ad/f/c:JEm	J
    //   434: lconst_0
    //   435: lcmp
    //   436: ifle +68 -> 504
    //   439: aload 23
    //   441: getfield 399	com/tencent/mm/plugin/sns/ad/f/c:JEp	J
    //   444: lconst_0
    //   445: lcmp
    //   446: ifne +58 -> 504
    //   449: aload 23
    //   451: invokestatic 337	java/lang/System:currentTimeMillis	()J
    //   454: putfield 399	com/tencent/mm/plugin/sns/ad/f/c:JEp	J
    //   457: ldc_w 401
    //   460: new 175	java/lang/StringBuilder
    //   463: dup
    //   464: ldc_w 403
    //   467: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: aload 23
    //   472: getfield 399	com/tencent/mm/plugin/sns/ad/f/c:JEp	J
    //   475: aload 23
    //   477: getfield 396	com/tencent/mm/plugin/sns/ad/f/c:JEm	J
    //   480: lsub
    //   481: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: ldc_w 405
    //   487: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 23
    //   492: invokevirtual 408	java/lang/Object:hashCode	()I
    //   495: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 18
    //   506: new 175	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   513: aload 23
    //   515: getfield 396	com/tencent/mm/plugin/sns/ad/f/c:JEm	J
    //   518: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   521: ldc_w 371
    //   524: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 18
    //   536: new 175	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   543: aload 23
    //   545: getfield 399	com/tencent/mm/plugin/sns/ad/f/c:JEp	J
    //   548: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   551: ldc_w 371
    //   554: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 23
    //   566: getfield 413	com/tencent/mm/plugin/sns/ad/f/c:JEs	J
    //   569: lconst_0
    //   570: lcmp
    //   571: ifle +68 -> 639
    //   574: aload 23
    //   576: getfield 416	com/tencent/mm/plugin/sns/ad/f/c:JEv	J
    //   579: lconst_0
    //   580: lcmp
    //   581: ifne +58 -> 639
    //   584: aload 23
    //   586: invokestatic 337	java/lang/System:currentTimeMillis	()J
    //   589: putfield 416	com/tencent/mm/plugin/sns/ad/f/c:JEv	J
    //   592: ldc_w 401
    //   595: new 175	java/lang/StringBuilder
    //   598: dup
    //   599: ldc_w 418
    //   602: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   605: aload 23
    //   607: getfield 416	com/tencent/mm/plugin/sns/ad/f/c:JEv	J
    //   610: aload 23
    //   612: getfield 413	com/tencent/mm/plugin/sns/ad/f/c:JEs	J
    //   615: lsub
    //   616: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   619: ldc_w 405
    //   622: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload 23
    //   627: invokevirtual 408	java/lang/Object:hashCode	()I
    //   630: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 18
    //   641: new 175	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   648: aload 23
    //   650: getfield 413	com/tencent/mm/plugin/sns/ad/f/c:JEs	J
    //   653: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   656: ldc_w 371
    //   659: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 18
    //   671: aload 23
    //   673: getfield 416	com/tencent/mm/plugin/sns/ad/f/c:JEv	J
    //   676: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 23
    //   682: getfield 363	com/tencent/mm/plugin/sns/ad/f/c:JEb	J
    //   685: aload 18
    //   687: invokestatic 423	com/tencent/mm/plugin/sns/ad/f/k:a	(JLjava/lang/StringBuilder;)V
    //   690: ldc_w 401
    //   693: new 175	java/lang/StringBuilder
    //   696: dup
    //   697: ldc_w 425
    //   700: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   703: aload 18
    //   705: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: new 427	com/tencent/mm/protocal/protobuf/ca
    //   720: dup
    //   721: invokespecial 428	com/tencent/mm/protocal/protobuf/ca:<init>	()V
    //   724: astore 20
    //   726: aload 20
    //   728: aload 23
    //   730: getfield 413	com/tencent/mm/plugin/sns/ad/f/c:JEs	J
    //   733: putfield 431	com/tencent/mm/protocal/protobuf/ca:RHA	J
    //   736: aload 20
    //   738: aload 23
    //   740: getfield 416	com/tencent/mm/plugin/sns/ad/f/c:JEv	J
    //   743: putfield 434	com/tencent/mm/protocal/protobuf/ca:RHB	J
    //   746: aload 20
    //   748: aload 23
    //   750: getfield 353	com/tencent/mm/plugin/sns/ad/f/c:JEz	I
    //   753: putfield 435	com/tencent/mm/protocal/protobuf/ca:JEz	I
    //   756: aload 20
    //   758: aload 23
    //   760: getfield 359	com/tencent/mm/plugin/sns/ad/f/c:JEA	I
    //   763: putfield 436	com/tencent/mm/protocal/protobuf/ca:JEA	I
    //   766: aload 20
    //   768: aload 23
    //   770: getfield 381	com/tencent/mm/plugin/sns/ad/f/c:JEw	I
    //   773: i2f
    //   774: putfield 440	com/tencent/mm/protocal/protobuf/ca:RHv	F
    //   777: aload 20
    //   779: aload 23
    //   781: getfield 384	com/tencent/mm/plugin/sns/ad/f/c:JEx	I
    //   784: i2f
    //   785: putfield 443	com/tencent/mm/protocal/protobuf/ca:RHw	F
    //   788: aload 20
    //   790: aload 23
    //   792: getfield 387	com/tencent/mm/plugin/sns/ad/f/c:JEy	I
    //   795: i2f
    //   796: putfield 446	com/tencent/mm/protocal/protobuf/ca:RHx	F
    //   799: aload 20
    //   801: aload 23
    //   803: getfield 396	com/tencent/mm/plugin/sns/ad/f/c:JEm	J
    //   806: putfield 449	com/tencent/mm/protocal/protobuf/ca:RHy	J
    //   809: aload 20
    //   811: aload 23
    //   813: getfield 399	com/tencent/mm/plugin/sns/ad/f/c:JEp	J
    //   816: putfield 452	com/tencent/mm/protocal/protobuf/ca:RHz	J
    //   819: aload 20
    //   821: aload 23
    //   823: getfield 390	com/tencent/mm/plugin/sns/ad/f/c:JEi	J
    //   826: putfield 455	com/tencent/mm/protocal/protobuf/ca:startTime	J
    //   829: aload 20
    //   831: aload 23
    //   833: getfield 340	com/tencent/mm/plugin/sns/ad/f/c:JEj	J
    //   836: putfield 458	com/tencent/mm/protocal/protobuf/ca:endTime	J
    //   839: aload 23
    //   841: getfield 462	com/tencent/mm/plugin/sns/ad/f/c:JEd	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   844: ifnull +389 -> 1233
    //   847: aload 23
    //   849: getfield 462	com/tencent/mm/plugin/sns/ad/f/c:JEd	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   852: invokevirtual 467	com/tencent/mm/plugin/sns/storage/ADXml:isRecExpAd	()Z
    //   855: ifeq +378 -> 1233
    //   858: invokestatic 471	com/tencent/mm/plugin/sns/model/aj:fOC	()Lcom/tencent/mm/plugin/sns/ad/f/n;
    //   861: sipush 14648
    //   864: iconst_1
    //   865: anewarray 4	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: aload 18
    //   872: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: aastore
    //   876: invokevirtual 476	com/tencent/mm/plugin/sns/ad/f/n:a	(I[Ljava/lang/Object;)V
    //   879: sipush 730
    //   882: invokestatic 482	com/tencent/mm/modelsns/l:wO	(I)Lcom/tencent/mm/modelsns/l;
    //   885: astore 19
    //   887: aload 19
    //   889: aload 23
    //   891: getfield 363	com/tencent/mm/plugin/sns/ad/f/c:JEb	J
    //   894: invokestatic 369	com/tencent/mm/plugin/sns/data/t:Qu	(J)Ljava/lang/String;
    //   897: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   900: aload 23
    //   902: getfield 375	com/tencent/mm/plugin/sns/ad/f/c:jDL	Ljava/lang/String;
    //   905: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   908: aload 23
    //   910: getfield 353	com/tencent/mm/plugin/sns/ad/f/c:JEz	I
    //   913: invokevirtual 489	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   916: aload 23
    //   918: getfield 359	com/tencent/mm/plugin/sns/ad/f/c:JEA	I
    //   921: invokevirtual 489	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   924: aload 23
    //   926: getfield 381	com/tencent/mm/plugin/sns/ad/f/c:JEw	I
    //   929: invokevirtual 489	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   932: aload 23
    //   934: getfield 384	com/tencent/mm/plugin/sns/ad/f/c:JEx	I
    //   937: invokevirtual 489	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   940: aload 23
    //   942: getfield 387	com/tencent/mm/plugin/sns/ad/f/c:JEy	I
    //   945: invokevirtual 489	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   948: new 175	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   955: aload 23
    //   957: getfield 390	com/tencent/mm/plugin/sns/ad/f/c:JEi	J
    //   960: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   963: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   969: new 175	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   976: aload 23
    //   978: getfield 340	com/tencent/mm/plugin/sns/ad/f/c:JEj	J
    //   981: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   984: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   990: new 175	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   997: aload 23
    //   999: getfield 396	com/tencent/mm/plugin/sns/ad/f/c:JEm	J
    //   1002: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1011: new 175	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   1018: aload 23
    //   1020: getfield 399	com/tencent/mm/plugin/sns/ad/f/c:JEp	J
    //   1023: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1032: new 175	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   1039: aload 23
    //   1041: getfield 413	com/tencent/mm/plugin/sns/ad/f/c:JEs	J
    //   1044: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1053: new 175	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   1060: aload 23
    //   1062: getfield 416	com/tencent/mm/plugin/sns/ad/f/c:JEv	J
    //   1065: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokevirtual 486	com/tencent/mm/modelsns/l:Xf	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1074: pop
    //   1075: aload 19
    //   1077: invokevirtual 492	com/tencent/mm/modelsns/l:bpa	()Z
    //   1080: pop
    //   1081: new 494	com/tencent/mm/f/a/on
    //   1084: dup
    //   1085: invokespecial 495	com/tencent/mm/f/a/on:<init>	()V
    //   1088: astore 19
    //   1090: aload 19
    //   1092: getfield 499	com/tencent/mm/f/a/on:fNp	Lcom/tencent/mm/f/a/on$a;
    //   1095: aload 23
    //   1097: getfield 502	com/tencent/mm/plugin/sns/ad/f/c:position	I
    //   1100: putfield 505	com/tencent/mm/f/a/on$a:position	I
    //   1103: getstatic 511	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1106: aload 19
    //   1108: invokevirtual 515	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   1111: pop
    //   1112: getstatic 520	com/tencent/mm/platformtools/ac:mGt	Z
    //   1115: ifeq +166 -> 1281
    //   1118: new 522	java/util/Random
    //   1121: dup
    //   1122: invokestatic 337	java/lang/System:currentTimeMillis	()J
    //   1125: invokespecial 524	java/util/Random:<init>	(J)V
    //   1128: sipush 2000
    //   1131: invokevirtual 528	java/util/Random:nextInt	(I)I
    //   1134: bipush 10
    //   1136: iadd
    //   1137: istore 7
    //   1139: ldc_w 401
    //   1142: ldc_w 530
    //   1145: iload 7
    //   1147: invokestatic 533	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1150: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1153: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1156: iconst_0
    //   1157: istore 6
    //   1159: iload 6
    //   1161: iload 7
    //   1163: if_icmpge +118 -> 1281
    //   1166: aload 23
    //   1168: getfield 462	com/tencent/mm/plugin/sns/ad/f/c:JEd	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   1171: ifnull +86 -> 1257
    //   1174: aload 23
    //   1176: getfield 462	com/tencent/mm/plugin/sns/ad/f/c:JEd	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   1179: invokevirtual 467	com/tencent/mm/plugin/sns/storage/ADXml:isRecExpAd	()Z
    //   1182: ifeq +75 -> 1257
    //   1185: invokestatic 471	com/tencent/mm/plugin/sns/model/aj:fOC	()Lcom/tencent/mm/plugin/sns/ad/f/n;
    //   1188: sipush 14648
    //   1191: iconst_1
    //   1192: anewarray 4	java/lang/Object
    //   1195: dup
    //   1196: iconst_0
    //   1197: aload 18
    //   1199: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: aastore
    //   1203: invokevirtual 476	com/tencent/mm/plugin/sns/ad/f/n:a	(I[Ljava/lang/Object;)V
    //   1206: iload 6
    //   1208: iconst_1
    //   1209: iadd
    //   1210: istore 6
    //   1212: goto -53 -> 1159
    //   1215: aload 23
    //   1217: iconst_1
    //   1218: putfield 353	com/tencent/mm/plugin/sns/ad/f/c:JEz	I
    //   1221: goto -1088 -> 133
    //   1224: aload 23
    //   1226: iconst_1
    //   1227: putfield 359	com/tencent/mm/plugin/sns/ad/f/c:JEA	I
    //   1230: goto -1083 -> 147
    //   1233: invokestatic 471	com/tencent/mm/plugin/sns/model/aj:fOC	()Lcom/tencent/mm/plugin/sns/ad/f/n;
    //   1236: sipush 12010
    //   1239: iconst_1
    //   1240: anewarray 4	java/lang/Object
    //   1243: dup
    //   1244: iconst_0
    //   1245: aload 18
    //   1247: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: aastore
    //   1251: invokevirtual 476	com/tencent/mm/plugin/sns/ad/f/n:a	(I[Ljava/lang/Object;)V
    //   1254: goto -375 -> 879
    //   1257: invokestatic 471	com/tencent/mm/plugin/sns/model/aj:fOC	()Lcom/tencent/mm/plugin/sns/ad/f/n;
    //   1260: sipush 12010
    //   1263: iconst_1
    //   1264: anewarray 4	java/lang/Object
    //   1267: dup
    //   1268: iconst_0
    //   1269: aload 18
    //   1271: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: aastore
    //   1275: invokevirtual 476	com/tencent/mm/plugin/sns/ad/f/n:a	(I[Ljava/lang/Object;)V
    //   1278: goto -72 -> 1206
    //   1281: aload 23
    //   1283: invokevirtual 537	com/tencent/mm/plugin/sns/ad/f/c:fKP	()Lcom/tencent/mm/protocal/protobuf/cd;
    //   1286: astore 19
    //   1288: aload_0
    //   1289: getfield 97	com/tencent/mm/plugin/sns/ad/f/l:JEJ	Ljava/util/Map;
    //   1292: aload_2
    //   1293: invokeinterface 171 2 0
    //   1298: pop
    //   1299: aload_0
    //   1300: getfield 123	com/tencent/mm/plugin/sns/ad/f/l:JEV	Ljava/util/HashSet;
    //   1303: aload_2
    //   1304: invokevirtual 321	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   1307: pop
    //   1308: iconst_0
    //   1309: istore 9
    //   1311: iconst_0
    //   1312: istore 7
    //   1314: invokestatic 541	com/tencent/mm/plugin/sns/model/aj:fOI	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   1317: aload_2
    //   1318: invokevirtual 547	com/tencent/mm/plugin/sns/storage/n:bbl	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1321: astore 24
    //   1323: aload 24
    //   1325: ifnull +448 -> 1773
    //   1328: iload 7
    //   1330: istore 6
    //   1332: aload_0
    //   1333: getfield 103	com/tencent/mm/plugin/sns/ad/f/l:JEM	Ljava/util/Map;
    //   1336: aload 24
    //   1338: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1341: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1344: invokeinterface 255 2 0
    //   1349: ifeq +384 -> 1733
    //   1352: iload 7
    //   1354: istore 6
    //   1356: aload 24
    //   1358: invokevirtual 554	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1361: getfield 560	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   1364: getfield 565	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   1367: bipush 27
    //   1369: if_icmpne +364 -> 1733
    //   1372: aload 24
    //   1374: getfield 568	com/tencent/mm/plugin/sns/storage/SnsInfo:field_likeFlag	I
    //   1377: iconst_1
    //   1378: if_icmpne +477 -> 1855
    //   1381: iconst_2
    //   1382: istore 6
    //   1384: aload_0
    //   1385: getfield 121	com/tencent/mm/plugin/sns/ad/f/l:JEU	Ljava/util/Map;
    //   1388: aload 24
    //   1390: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1393: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1396: invokeinterface 255 2 0
    //   1401: ifeq +460 -> 1861
    //   1404: aload_0
    //   1405: getfield 121	com/tencent/mm/plugin/sns/ad/f/l:JEU	Ljava/util/Map;
    //   1408: aload 24
    //   1410: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1413: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1416: invokeinterface 258 2 0
    //   1421: checkcast 283	java/lang/Integer
    //   1424: invokevirtual 287	java/lang/Integer:intValue	()I
    //   1427: istore 7
    //   1429: aload_0
    //   1430: getfield 119	com/tencent/mm/plugin/sns/ad/f/l:JET	Ljava/util/Map;
    //   1433: aload 24
    //   1435: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1438: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1441: invokeinterface 255 2 0
    //   1446: ifeq +421 -> 1867
    //   1449: aload_0
    //   1450: getfield 119	com/tencent/mm/plugin/sns/ad/f/l:JET	Ljava/util/Map;
    //   1453: aload 24
    //   1455: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1458: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1461: invokeinterface 258 2 0
    //   1466: checkcast 283	java/lang/Integer
    //   1469: invokevirtual 287	java/lang/Integer:intValue	()I
    //   1472: istore 8
    //   1474: lconst_0
    //   1475: lstore 15
    //   1477: lconst_0
    //   1478: lstore 13
    //   1480: lconst_0
    //   1481: lstore 11
    //   1483: aload_0
    //   1484: getfield 103	com/tencent/mm/plugin/sns/ad/f/l:JEM	Ljava/util/Map;
    //   1487: aload 24
    //   1489: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1492: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1495: invokeinterface 171 2 0
    //   1500: checkcast 260	com/tencent/mm/plugin/sns/ad/f/m
    //   1503: astore 18
    //   1505: aload 18
    //   1507: ifnull +41 -> 1548
    //   1510: aload 18
    //   1512: iconst_0
    //   1513: invokevirtual 263	com/tencent/mm/plugin/sns/ad/f/m:aeO	(I)V
    //   1516: aload 18
    //   1518: invokevirtual 571	com/tencent/mm/plugin/sns/ad/f/m:fKT	()V
    //   1521: aload 18
    //   1523: getfield 574	com/tencent/mm/plugin/sns/ad/f/m:JFs	I
    //   1526: i2l
    //   1527: lstore 15
    //   1529: aload 18
    //   1531: getfield 577	com/tencent/mm/plugin/sns/ad/f/m:JFr	I
    //   1534: i2l
    //   1535: lstore 13
    //   1537: aload 18
    //   1539: getfield 580	com/tencent/mm/plugin/sns/ad/f/m:sTg	J
    //   1542: ldc2_w 581
    //   1545: lmul
    //   1546: lstore 11
    //   1548: new 175	java/lang/StringBuilder
    //   1551: dup
    //   1552: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   1555: aload 24
    //   1557: invokevirtual 554	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1560: getfield 585	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   1563: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1569: astore 21
    //   1571: aload 24
    //   1573: invokevirtual 588	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
    //   1576: astore 22
    //   1578: aload 24
    //   1580: getfield 568	com/tencent/mm/plugin/sns/storage/SnsInfo:field_likeFlag	I
    //   1583: iconst_1
    //   1584: if_icmpne +289 -> 1873
    //   1587: ldc_w 590
    //   1590: astore 18
    //   1592: ldc_w 592
    //   1595: bipush 9
    //   1597: anewarray 4	java/lang/Object
    //   1600: dup
    //   1601: iconst_0
    //   1602: aload 21
    //   1604: aastore
    //   1605: dup
    //   1606: iconst_1
    //   1607: aload 22
    //   1609: aastore
    //   1610: dup
    //   1611: iconst_2
    //   1612: iload 5
    //   1614: invokestatic 533	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1617: aastore
    //   1618: dup
    //   1619: iconst_3
    //   1620: iload 7
    //   1622: invokestatic 533	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1625: aastore
    //   1626: dup
    //   1627: iconst_4
    //   1628: iload 8
    //   1630: invokestatic 533	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1633: aastore
    //   1634: dup
    //   1635: iconst_5
    //   1636: lload 15
    //   1638: invokestatic 594	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1641: aastore
    //   1642: dup
    //   1643: bipush 6
    //   1645: lload 13
    //   1647: invokestatic 594	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1650: aastore
    //   1651: dup
    //   1652: bipush 7
    //   1654: lload 11
    //   1656: invokestatic 594	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1659: aastore
    //   1660: dup
    //   1661: bipush 8
    //   1663: aload 18
    //   1665: aastore
    //   1666: invokestatic 598	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1669: astore 18
    //   1671: getstatic 604	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1674: sipush 15155
    //   1677: aload 18
    //   1679: invokevirtual 608	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   1682: ldc 137
    //   1684: ldc_w 610
    //   1687: iconst_1
    //   1688: anewarray 4	java/lang/Object
    //   1691: dup
    //   1692: iconst_0
    //   1693: aload 18
    //   1695: aastore
    //   1696: invokestatic 613	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1699: aload_0
    //   1700: getfield 99	com/tencent/mm/plugin/sns/ad/f/l:JEK	Ljava/util/HashSet;
    //   1703: aload 24
    //   1705: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1708: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1711: invokevirtual 321	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   1714: pop
    //   1715: aload_0
    //   1716: getfield 99	com/tencent/mm/plugin/sns/ad/f/l:JEK	Ljava/util/HashSet;
    //   1719: aload 24
    //   1721: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1724: lconst_1
    //   1725: ladd
    //   1726: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1729: invokevirtual 321	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   1732: pop
    //   1733: aload_0
    //   1734: getfield 121	com/tencent/mm/plugin/sns/ad/f/l:JEU	Ljava/util/Map;
    //   1737: aload 24
    //   1739: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1742: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1745: invokeinterface 171 2 0
    //   1750: pop
    //   1751: aload_0
    //   1752: getfield 119	com/tencent/mm/plugin/sns/ad/f/l:JET	Ljava/util/Map;
    //   1755: aload 24
    //   1757: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1760: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1763: invokeinterface 171 2 0
    //   1768: pop
    //   1769: iload 6
    //   1771: istore 9
    //   1773: aload_0
    //   1774: getfield 107	com/tencent/mm/plugin/sns/ad/f/l:JEO	Ljava/util/Map;
    //   1777: aload_2
    //   1778: invokeinterface 255 2 0
    //   1783: ifeq +1287 -> 3070
    //   1786: ldc_w 615
    //   1789: astore 21
    //   1791: aload_0
    //   1792: aload 24
    //   1794: invokespecial 617	com/tencent/mm/plugin/sns/ad/f/l:h	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1797: ifnull +14 -> 1811
    //   1800: aload_0
    //   1801: aload 24
    //   1803: invokespecial 617	com/tencent/mm/plugin/sns/ad/f/l:h	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1806: getfield 622	com/tencent/mm/plugin/sns/storage/ADInfo:viewId	Ljava/lang/String;
    //   1809: astore 21
    //   1811: aload_0
    //   1812: getfield 107	com/tencent/mm/plugin/sns/ad/f/l:JEO	Ljava/util/Map;
    //   1815: aload_2
    //   1816: invokeinterface 171 2 0
    //   1821: checkcast 24	com/tencent/mm/plugin/sns/ad/f/l$a
    //   1824: astore 25
    //   1826: aload_0
    //   1827: getfield 93	com/tencent/mm/plugin/sns/ad/f/l:JEH	Ljava/util/Map;
    //   1830: aload_2
    //   1831: invokestatic 627	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1834: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1837: invokeinterface 267 3 0
    //   1842: pop
    //   1843: aload 25
    //   1845: ifnonnull +36 -> 1881
    //   1848: ldc_w 313
    //   1851: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1854: return
    //   1855: iconst_1
    //   1856: istore 6
    //   1858: goto -474 -> 1384
    //   1861: iconst_0
    //   1862: istore 7
    //   1864: goto -435 -> 1429
    //   1867: iconst_0
    //   1868: istore 8
    //   1870: goto -396 -> 1474
    //   1873: ldc_w 629
    //   1876: astore 18
    //   1878: goto -286 -> 1592
    //   1881: aload 25
    //   1883: getfield 632	com/tencent/mm/plugin/sns/ad/f/l$a:JFd	J
    //   1886: invokestatic 635	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1889: lstore 11
    //   1891: aload 25
    //   1893: getfield 638	com/tencent/mm/plugin/sns/ad/f/l$a:JFf	J
    //   1896: lconst_0
    //   1897: lcmp
    //   1898: ifle +22 -> 1920
    //   1901: aload 25
    //   1903: aload 25
    //   1905: getfield 641	com/tencent/mm/plugin/sns/ad/f/l$a:JFi	J
    //   1908: aload 25
    //   1910: getfield 638	com/tencent/mm/plugin/sns/ad/f/l$a:JFf	J
    //   1913: invokestatic 635	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1916: ladd
    //   1917: putfield 641	com/tencent/mm/plugin/sns/ad/f/l$a:JFi	J
    //   1920: new 175	java/lang/StringBuilder
    //   1923: dup
    //   1924: ldc_w 643
    //   1927: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1930: iload_1
    //   1931: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1934: ldc_w 645
    //   1937: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: aload_2
    //   1941: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: ldc_w 645
    //   1947: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: lload 11
    //   1952: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1955: ldc_w 647
    //   1958: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: lload_3
    //   1962: invokestatic 369	com/tencent/mm/plugin/sns/data/t:Qu	(J)Ljava/lang/String;
    //   1965: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: ldc_w 649
    //   1971: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1974: astore 18
    //   1976: aload 24
    //   1978: ifnonnull +33 -> 2011
    //   1981: iconst_1
    //   1982: istore 17
    //   1984: ldc 137
    //   1986: aload 18
    //   1988: iload 17
    //   1990: invokevirtual 652	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1993: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1996: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1999: aload 24
    //   2001: ifnonnull +16 -> 2017
    //   2004: ldc_w 313
    //   2007: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2010: return
    //   2011: iconst_0
    //   2012: istore 17
    //   2014: goto -30 -> 1984
    //   2017: ldc_w 615
    //   2020: astore 18
    //   2022: aload 24
    //   2024: invokevirtual 554	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   2027: astore 22
    //   2029: aload 24
    //   2031: invokevirtual 656	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   2034: astore 26
    //   2036: aload 26
    //   2038: invokevirtual 659	com/tencent/mm/plugin/sns/storage/ADXml:isLinkAd	()Z
    //   2041: ifeq +269 -> 2310
    //   2044: iconst_3
    //   2045: istore 6
    //   2047: ldc_w 615
    //   2050: astore 18
    //   2052: aload_0
    //   2053: aload 24
    //   2055: invokespecial 617	com/tencent/mm/plugin/sns/ad/f/l:h	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   2058: astore 22
    //   2060: aload 22
    //   2062: ifnonnull +960 -> 3022
    //   2065: ldc_w 615
    //   2068: astore 22
    //   2070: new 661	com/tencent/mm/plugin/sns/ad/f/b
    //   2073: dup
    //   2074: invokespecial 662	com/tencent/mm/plugin/sns/ad/f/b:<init>	()V
    //   2077: astore 26
    //   2079: aload 26
    //   2081: iload_1
    //   2082: putfield 665	com/tencent/mm/plugin/sns/ad/f/b:JDQ	I
    //   2085: aload 26
    //   2087: aload 24
    //   2089: putfield 669	com/tencent/mm/plugin/sns/ad/f/b:Jzk	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2092: aload 23
    //   2094: ifnull +938 -> 3032
    //   2097: aload 23
    //   2099: getfield 672	com/tencent/mm/plugin/sns/ad/f/c:jCa	I
    //   2102: istore_1
    //   2103: aload 26
    //   2105: iload_1
    //   2106: putfield 675	com/tencent/mm/plugin/sns/ad/f/b:JDR	I
    //   2109: aload 26
    //   2111: aload 25
    //   2113: getfield 678	com/tencent/mm/plugin/sns/ad/f/l$a:JFj	J
    //   2116: putfield 681	com/tencent/mm/plugin/sns/ad/f/b:JDT	J
    //   2119: aload 26
    //   2121: aload 25
    //   2123: getfield 684	com/tencent/mm/plugin/sns/ad/f/l$a:JFk	J
    //   2126: putfield 687	com/tencent/mm/plugin/sns/ad/f/b:JDS	J
    //   2129: ldc 137
    //   2131: new 175	java/lang/StringBuilder
    //   2134: dup
    //   2135: ldc_w 689
    //   2138: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2141: aload 25
    //   2143: getfield 678	com/tencent/mm/plugin/sns/ad/f/l$a:JFj	J
    //   2146: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2149: ldc_w 691
    //   2152: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: aload_2
    //   2156: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2159: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2162: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2165: ldc 137
    //   2167: new 175	java/lang/StringBuilder
    //   2170: dup
    //   2171: ldc_w 693
    //   2174: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2177: aload 25
    //   2179: getfield 684	com/tencent/mm/plugin/sns/ad/f/l$a:JFk	J
    //   2182: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2185: ldc_w 691
    //   2188: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2191: aload_2
    //   2192: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2195: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2198: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2201: new 695	com/tencent/mm/plugin/sns/ad/f/g
    //   2204: dup
    //   2205: aload 21
    //   2207: iload 5
    //   2209: iconst_2
    //   2210: lload 11
    //   2212: l2i
    //   2213: aload 20
    //   2215: aload 19
    //   2217: iload 6
    //   2219: aload 18
    //   2221: iconst_m1
    //   2222: aload 24
    //   2224: invokevirtual 698	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdRecSrc	()I
    //   2227: aload 25
    //   2229: getfield 641	com/tencent/mm/plugin/sns/ad/f/l$a:JFi	J
    //   2232: l2i
    //   2233: aload 25
    //   2235: getfield 678	com/tencent/mm/plugin/sns/ad/f/l$a:JFj	J
    //   2238: l2i
    //   2239: iload 9
    //   2241: aload_0
    //   2242: aload 24
    //   2244: invokespecial 700	com/tencent/mm/plugin/sns/ad/f/l:i	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/cd/b;
    //   2247: aload_0
    //   2248: aload 24
    //   2250: invokespecial 702	com/tencent/mm/plugin/sns/ad/f/l:j	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/cd/b;
    //   2253: aload 22
    //   2255: aload 26
    //   2257: invokespecial 705	com/tencent/mm/plugin/sns/ad/f/g:<init>	(Ljava/lang/String;IIILcom/tencent/mm/protocal/protobuf/ca;Lcom/tencent/mm/protocal/protobuf/cd;ILjava/lang/String;IIIIILcom/tencent/mm/cd/b;Lcom/tencent/mm/cd/b;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/f/b;)V
    //   2260: astore_2
    //   2261: invokestatic 711	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   2264: pop
    //   2265: invokestatic 715	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   2268: getfield 721	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   2271: aload_2
    //   2272: iconst_0
    //   2273: invokevirtual 726	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   2276: pop
    //   2277: aload 24
    //   2279: invokestatic 730	com/tencent/mm/plugin/sns/data/t:w	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Ljava/lang/String;
    //   2282: astore_2
    //   2283: aload_0
    //   2284: aload_2
    //   2285: invokespecial 732	com/tencent/mm/plugin/sns/ad/f/l:aYB	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/ad/f/d;
    //   2288: astore 18
    //   2290: aload 18
    //   2292: ifnull +11 -> 2303
    //   2295: aload 18
    //   2297: aload_2
    //   2298: invokeinterface 735 2 0
    //   2303: ldc_w 313
    //   2306: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2309: return
    //   2310: aload 24
    //   2312: invokevirtual 738	com/tencent/mm/plugin/sns/storage/SnsInfo:isTurnCardAd	()Z
    //   2315: ifeq +58 -> 2373
    //   2318: bipush 6
    //   2320: istore 6
    //   2322: aload_0
    //   2323: getfield 101	com/tencent/mm/plugin/sns/ad/f/l:JEL	Ljava/util/Map;
    //   2326: aload 25
    //   2328: getfield 739	com/tencent/mm/plugin/sns/ad/f/l$a:JEb	J
    //   2331: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2334: invokeinterface 171 2 0
    //   2339: checkcast 260	com/tencent/mm/plugin/sns/ad/f/m
    //   2342: astore 18
    //   2344: aload 18
    //   2346: ifnull +793 -> 3139
    //   2349: aload 24
    //   2351: invokevirtual 742	com/tencent/mm/plugin/sns/storage/SnsInfo:getLikeFlag	()I
    //   2354: ifne +9 -> 2363
    //   2357: aload 18
    //   2359: iconst_0
    //   2360: invokevirtual 263	com/tencent/mm/plugin/sns/ad/f/m:aeO	(I)V
    //   2363: aload 18
    //   2365: invokevirtual 745	com/tencent/mm/plugin/sns/ad/f/m:fKS	()Ljava/lang/String;
    //   2368: astore 18
    //   2370: goto -318 -> 2052
    //   2373: aload 24
    //   2375: invokevirtual 748	com/tencent/mm/plugin/sns/storage/SnsInfo:isCardAd	()Z
    //   2378: ifne +11 -> 2389
    //   2381: aload 24
    //   2383: invokevirtual 751	com/tencent/mm/plugin/sns/storage/SnsInfo:isFullCardAd	()Z
    //   2386: ifeq +503 -> 2889
    //   2389: aload 22
    //   2391: ifnull +487 -> 2878
    //   2394: aload 22
    //   2396: getfield 560	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   2399: getfield 565	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   2402: bipush 15
    //   2404: if_icmpne +474 -> 2878
    //   2407: aload 22
    //   2409: getfield 754	com/tencent/mm/protocal/protobuf/TimeLineObject:sightFolded	I
    //   2412: iconst_1
    //   2413: if_icmpeq +465 -> 2878
    //   2416: aload_0
    //   2417: getfield 101	com/tencent/mm/plugin/sns/ad/f/l:JEL	Ljava/util/Map;
    //   2420: aload 25
    //   2422: getfield 739	com/tencent/mm/plugin/sns/ad/f/l$a:JEb	J
    //   2425: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2428: invokeinterface 171 2 0
    //   2433: checkcast 260	com/tencent/mm/plugin/sns/ad/f/m
    //   2436: astore 22
    //   2438: aload 22
    //   2440: ifnull +691 -> 3131
    //   2443: aload 22
    //   2445: iconst_0
    //   2446: invokevirtual 263	com/tencent/mm/plugin/sns/ad/f/m:aeO	(I)V
    //   2449: aload 22
    //   2451: invokevirtual 745	com/tencent/mm/plugin/sns/ad/f/m:fKS	()Ljava/lang/String;
    //   2454: astore 18
    //   2456: aload_0
    //   2457: getfield 99	com/tencent/mm/plugin/sns/ad/f/l:JEK	Ljava/util/HashSet;
    //   2460: aload 25
    //   2462: getfield 739	com/tencent/mm/plugin/sns/ad/f/l$a:JEb	J
    //   2465: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2468: invokevirtual 321	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   2471: pop
    //   2472: aload 24
    //   2474: invokevirtual 757	com/tencent/mm/plugin/sns/storage/SnsInfo:isLongPressGestureAd	()Z
    //   2477: ifeq +395 -> 2872
    //   2480: iconst_0
    //   2481: istore 6
    //   2483: iconst_0
    //   2484: istore 7
    //   2486: aload 22
    //   2488: ifnull +335 -> 2823
    //   2491: aload 22
    //   2493: getfield 761	com/tencent/mm/plugin/sns/ad/f/m:JFv	Ljava/util/LinkedList;
    //   2496: ifnull +327 -> 2823
    //   2499: aload 22
    //   2501: getfield 761	com/tencent/mm/plugin/sns/ad/f/m:JFv	Ljava/util/LinkedList;
    //   2504: invokevirtual 766	java/util/LinkedList:size	()I
    //   2507: ifle +316 -> 2823
    //   2510: iload 6
    //   2512: istore 7
    //   2514: aload 22
    //   2516: getfield 761	com/tencent/mm/plugin/sns/ad/f/m:JFv	Ljava/util/LinkedList;
    //   2519: invokevirtual 766	java/util/LinkedList:size	()I
    //   2522: iconst_1
    //   2523: isub
    //   2524: istore 10
    //   2526: iload 6
    //   2528: istore 7
    //   2530: aload 22
    //   2532: getfield 761	com/tencent/mm/plugin/sns/ad/f/m:JFv	Ljava/util/LinkedList;
    //   2535: iload 10
    //   2537: invokevirtual 769	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   2540: checkcast 771	com/tencent/mm/plugin/sns/ad/f/a/b
    //   2543: astore 26
    //   2545: iload 6
    //   2547: istore 7
    //   2549: aload 26
    //   2551: getfield 774	com/tencent/mm/plugin/sns/ad/f/a/b:JGE	I
    //   2554: istore 6
    //   2556: iload 6
    //   2558: istore 7
    //   2560: aload 26
    //   2562: getfield 777	com/tencent/mm/plugin/sns/ad/f/a/b:JGF	I
    //   2565: istore 8
    //   2567: ldc 137
    //   2569: new 175	java/lang/StringBuilder
    //   2572: dup
    //   2573: ldc_w 779
    //   2576: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2579: aload 22
    //   2581: getfield 761	com/tencent/mm/plugin/sns/ad/f/m:JFv	Ljava/util/LinkedList;
    //   2584: invokevirtual 766	java/util/LinkedList:size	()I
    //   2587: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2590: ldc_w 781
    //   2593: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: iload 10
    //   2598: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2601: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2604: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2607: iload 6
    //   2609: istore 7
    //   2611: iload 8
    //   2613: istore 6
    //   2615: aload_0
    //   2616: getfield 109	com/tencent/mm/plugin/sns/ad/f/l:source	I
    //   2619: ifne +218 -> 2837
    //   2622: iconst_1
    //   2623: istore 8
    //   2625: new 783	org/json/JSONObject
    //   2628: dup
    //   2629: invokespecial 784	org/json/JSONObject:<init>	()V
    //   2632: astore 22
    //   2634: aload 22
    //   2636: ldc_w 786
    //   2639: new 175	java/lang/StringBuilder
    //   2642: dup
    //   2643: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   2646: aload 24
    //   2648: getfield 550	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   2651: invokevirtual 393	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2654: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2657: invokevirtual 789	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2660: pop
    //   2661: aload 22
    //   2663: ldc_w 791
    //   2666: aload 24
    //   2668: invokevirtual 204	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   2671: getfield 794	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   2674: invokestatic 797	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2677: invokevirtual 789	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2680: pop
    //   2681: aload 22
    //   2683: ldc_w 799
    //   2686: iload 8
    //   2688: invokevirtual 802	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2691: pop
    //   2692: new 783	org/json/JSONObject
    //   2695: dup
    //   2696: invokespecial 784	org/json/JSONObject:<init>	()V
    //   2699: astore 26
    //   2701: aload 26
    //   2703: ldc_w 804
    //   2706: iload 7
    //   2708: invokevirtual 802	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2711: pop
    //   2712: aload 26
    //   2714: ldc_w 806
    //   2717: iload 6
    //   2719: invokevirtual 802	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2722: pop
    //   2723: aload 22
    //   2725: ldc_w 808
    //   2728: aload 26
    //   2730: invokevirtual 789	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2733: pop
    //   2734: aload 22
    //   2736: invokevirtual 809	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2739: astore 22
    //   2741: ldc_w 811
    //   2744: aload 22
    //   2746: invokestatic 816	com/tencent/mm/plugin/sns/data/m:ks	(Ljava/lang/String;Ljava/lang/String;)V
    //   2749: ldc_w 818
    //   2752: new 175	java/lang/StringBuilder
    //   2755: dup
    //   2756: ldc_w 820
    //   2759: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2762: aload 22
    //   2764: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2767: ldc_w 822
    //   2770: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2773: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2776: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2779: iconst_5
    //   2780: istore 6
    //   2782: goto -730 -> 2052
    //   2785: astore 22
    //   2787: iconst_0
    //   2788: istore 8
    //   2790: ldc 137
    //   2792: new 175	java/lang/StringBuilder
    //   2795: dup
    //   2796: ldc_w 824
    //   2799: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2802: aload 22
    //   2804: invokevirtual 825	java/lang/Exception:toString	()Ljava/lang/String;
    //   2807: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2810: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2813: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2816: iload 8
    //   2818: istore 6
    //   2820: goto -205 -> 2615
    //   2823: ldc 137
    //   2825: ldc_w 827
    //   2828: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2831: iconst_0
    //   2832: istore 6
    //   2834: goto -219 -> 2615
    //   2837: iconst_2
    //   2838: istore 8
    //   2840: goto -215 -> 2625
    //   2843: astore 22
    //   2845: ldc_w 818
    //   2848: new 175	java/lang/StringBuilder
    //   2851: dup
    //   2852: ldc_w 829
    //   2855: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2858: aload 22
    //   2860: invokevirtual 825	java/lang/Exception:toString	()Ljava/lang/String;
    //   2863: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2866: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2869: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2872: iconst_5
    //   2873: istore 6
    //   2875: goto -823 -> 2052
    //   2878: iconst_4
    //   2879: istore 6
    //   2881: ldc_w 615
    //   2884: astore 18
    //   2886: goto -834 -> 2052
    //   2889: aload 24
    //   2891: invokevirtual 832	com/tencent/mm/plugin/sns/storage/SnsInfo:isFinderTopicCardAd	()Z
    //   2894: ifeq +15 -> 2909
    //   2897: bipush 9
    //   2899: istore 6
    //   2901: ldc_w 615
    //   2904: astore 18
    //   2906: goto -854 -> 2052
    //   2909: aload 26
    //   2911: invokevirtual 835	com/tencent/mm/plugin/sns/storage/ADXml:isSlideFullCard	()Z
    //   2914: ifeq +15 -> 2929
    //   2917: bipush 10
    //   2919: istore 6
    //   2921: ldc_w 615
    //   2924: astore 18
    //   2926: goto -874 -> 2052
    //   2929: aload 25
    //   2931: getfield 838	com/tencent/mm/plugin/sns/ad/f/l$a:viewType	I
    //   2934: bipush 9
    //   2936: if_icmpeq +13 -> 2949
    //   2939: aload 25
    //   2941: getfield 838	com/tencent/mm/plugin/sns/ad/f/l$a:viewType	I
    //   2944: bipush 19
    //   2946: if_icmpne +65 -> 3011
    //   2949: iconst_2
    //   2950: istore 6
    //   2952: aload_0
    //   2953: getfield 101	com/tencent/mm/plugin/sns/ad/f/l:JEL	Ljava/util/Map;
    //   2956: aload 25
    //   2958: getfield 739	com/tencent/mm/plugin/sns/ad/f/l$a:JEb	J
    //   2961: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2964: invokeinterface 171 2 0
    //   2969: checkcast 260	com/tencent/mm/plugin/sns/ad/f/m
    //   2972: astore 22
    //   2974: aload 22
    //   2976: ifnull +16 -> 2992
    //   2979: aload 22
    //   2981: iconst_0
    //   2982: invokevirtual 263	com/tencent/mm/plugin/sns/ad/f/m:aeO	(I)V
    //   2985: aload 22
    //   2987: invokevirtual 745	com/tencent/mm/plugin/sns/ad/f/m:fKS	()Ljava/lang/String;
    //   2990: astore 18
    //   2992: aload_0
    //   2993: getfield 99	com/tencent/mm/plugin/sns/ad/f/l:JEK	Ljava/util/HashSet;
    //   2996: aload 25
    //   2998: getfield 739	com/tencent/mm/plugin/sns/ad/f/l$a:JEb	J
    //   3001: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3004: invokevirtual 321	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   3007: pop
    //   3008: goto -956 -> 2052
    //   3011: iconst_1
    //   3012: istore 6
    //   3014: ldc_w 615
    //   3017: astore 18
    //   3019: goto -967 -> 2052
    //   3022: aload 22
    //   3024: getfield 841	com/tencent/mm/plugin/sns/storage/ADInfo:waidPkg	Ljava/lang/String;
    //   3027: astore 22
    //   3029: goto -959 -> 2070
    //   3032: iconst_0
    //   3033: istore_1
    //   3034: goto -931 -> 2103
    //   3037: astore_2
    //   3038: ldc 137
    //   3040: new 175	java/lang/StringBuilder
    //   3043: dup
    //   3044: ldc_w 843
    //   3047: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3050: aload_2
    //   3051: invokevirtual 184	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3054: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3057: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3060: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3063: ldc_w 313
    //   3066: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3069: return
    //   3070: ldc 137
    //   3072: new 175	java/lang/StringBuilder
    //   3075: dup
    //   3076: ldc_w 845
    //   3079: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3082: iload_1
    //   3083: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3086: ldc_w 645
    //   3089: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3092: aload_2
    //   3093: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3096: ldc_w 647
    //   3099: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: lload_3
    //   3103: invokestatic 369	com/tencent/mm/plugin/sns/data/t:Qu	(J)Ljava/lang/String;
    //   3106: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3109: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3112: invokestatic 847	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   3115: ldc_w 313
    //   3118: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3121: return
    //   3122: astore 22
    //   3124: iload 6
    //   3126: istore 7
    //   3128: goto -338 -> 2790
    //   3131: ldc_w 615
    //   3134: astore 18
    //   3136: goto -680 -> 2456
    //   3139: ldc_w 615
    //   3142: astore 18
    //   3144: goto -774 -> 2370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3147	0	this	l
    //   0	3147	1	paramInt1	int
    //   0	3147	2	paramString	String
    //   0	3147	3	paramLong	long
    //   0	3147	5	paramInt2	int
    //   1157	1968	6	i	int
    //   1137	1990	7	j	int
    //   1472	1367	8	k	int
    //   1309	931	9	m	int
    //   2524	73	10	n	int
    //   31	2180	11	l1	long
    //   1478	168	13	l2	long
    //   1475	162	15	l3	long
    //   1982	31	17	bool	boolean
    //   47	3096	18	localObject1	Object
    //   73	2143	19	localObject2	Object
    //   69	2145	20	localObject3	Object
    //   50	2156	21	str	String
    //   1576	1187	22	localObject4	Object
    //   2785	18	22	localException1	java.lang.Exception
    //   2843	16	22	localException2	java.lang.Exception
    //   2972	56	22	localObject5	Object
    //   3122	1	22	localException3	java.lang.Exception
    //   65	2033	23	localc	c
    //   1321	1569	24	localSnsInfo	SnsInfo
    //   1824	1173	25	locala	a
    //   2034	876	26	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2514	2526	2785	java/lang/Exception
    //   2530	2545	2785	java/lang/Exception
    //   2549	2556	2785	java/lang/Exception
    //   2560	2567	2785	java/lang/Exception
    //   2625	2779	2843	java/lang/Exception
    //   2277	2290	3037	java/lang/Throwable
    //   2295	2303	3037	java/lang/Throwable
    //   2567	2607	3122	java/lang/Exception
  }
  
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95013);
    this.JEG.add(Long.valueOf(paramLong));
    this.JEF.put(paramString, Long.valueOf(paramLong));
    if (this.INC == -1) {
      if (this.activity != null) {
        break label114;
      }
    }
    SnsInfo localSnsInfo;
    label114:
    for (int i = -1;; i = ar.kI(this.activity))
    {
      this.INC = i;
      localSnsInfo = aj.fOI().bbl(paramString);
      if (localSnsInfo != null) {
        break;
      }
      Log.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!, snsId=" + com.tencent.mm.plugin.sns.data.t.Qu(paramLong) + ", localId=" + paramString);
      AppMethodBeat.o(95013);
      return;
    }
    Object localObject1 = (c)this.JEJ.get(paramString);
    Object localObject2 = h(localSnsInfo);
    if (localObject2 != null) {}
    for (String str = ((ADInfo)localObject2).viewId;; str = "")
    {
      if ((localObject1 == null) && (paramView != null) && (aj.JXk))
      {
        paramSnsObject = new c((ADInfo)localObject2, paramString, paramLong, paramView, this.APq, this.JES, this.INC, paramInt3, paramSnsObject, paramInt1, localSnsInfo.getAdXml());
        paramSnsObject.JEi = System.currentTimeMillis();
        aj.etE().post(new c.1(paramSnsObject));
        this.JEJ.put(paramString, paramSnsObject);
        paramView = paramSnsObject;
        if (!this.JET.containsKey(Long.valueOf(paramLong)))
        {
          paramView = this.JET;
          if (localSnsInfo.getLikeFlag() != 1) {
            break label623;
          }
          i = 1;
          paramView.put(Long.valueOf(paramLong), Integer.valueOf(i));
        }
      }
      for (paramView = paramSnsObject;; paramView = (View)localObject1)
      {
        if ((paramInt2 == 11) && (localSnsInfo.getTimeLine().ContentObj.Sqr.size() > 1))
        {
          if (this.JEM.containsKey(Long.valueOf(paramLong)))
          {
            paramSnsObject = (m)this.JEM.get(Long.valueOf(paramLong));
            paramSnsObject.JFo = Util.currentTicks();
            this.JEM.put(Long.valueOf(paramLong), paramSnsObject);
          }
        }
        else if (!this.JEV.contains(paramString))
        {
          this.JEV.add(paramString);
          com.tencent.mm.plugin.sns.ad.d.h.g(localSnsInfo);
        }
        for (;;)
        {
          try
          {
            paramSnsObject = localSnsInfo.getAdInfo(this.source);
            localObject1 = an.D(localSnsInfo);
            com.tencent.mm.plugin.sns.ad.timeline.b.e.a(com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId), paramSnsObject, (SnsObject)localObject1);
            paramSnsObject = a.fJL();
            i = this.source;
            try
            {
              localObject1 = paramSnsObject.Jze;
              if (localSnsInfo != null) {
                continue;
              }
              paramSnsObject = null;
              ((com.tencent.mm.plugin.sns.ad.c.a.c)localObject1).b(paramSnsObject);
            }
            catch (Throwable paramSnsObject)
            {
              long l;
              label623:
              TimeLineObject localTimeLineObject;
              continue;
            }
            if (this.JEH.containsKey(paramString))
            {
              l = Util.ticksToNow(((Long)this.JEH.get(paramString)).longValue());
              if (l >= 1200000L) {
                break label1199;
              }
              if (this.JEI.containsKey(paramString))
              {
                i = ((Integer)this.JEI.get(paramString)).intValue();
                if (i < 100) {
                  continue;
                }
                Log.i("MicroMsg.SnsAdStatistic", "passed localid " + paramString + " viewid " + str + " passedTime: " + l);
                AppMethodBeat.o(95013);
                return;
                i = 0;
                break;
                paramSnsObject = new m("timeline");
              }
            }
          }
          catch (Throwable paramSnsObject)
          {
            Log.e("MicroMsg.SnsAdStatistic", paramSnsObject.toString());
            continue;
            paramSnsObject = ((com.tencent.mm.plugin.sns.ad.c.a.c)localObject1).a(new c.b(localSnsInfo, i));
            continue;
            i = 0;
            continue;
            this.JEI.put(paramString, Integer.valueOf(i + 1));
            if (!this.JEO.containsKey(paramString))
            {
              this.JEO.put(paramString, new a(Util.currentTicks(), System.currentTimeMillis(), paramString, paramInt1, str, paramInt2, paramLong, paramInt3));
              Log.i("MicroMsg.SnsAdStatistic", "onAdAdded " + paramInt1 + " " + paramString + "  isExposure: " + paramBoolean + ", snsId=" + com.tencent.mm.plugin.sns.data.t.Qu(paramLong) + ", expoureScene=" + paramInt3);
              if ((paramInt2 != 9) && (paramInt2 != 13) && (!com.tencent.mm.plugin.sns.data.m.afz(paramInt2)) && (paramInt2 != 19)) {
                break label1249;
              }
              if (!this.JEL.containsKey(Long.valueOf(paramLong))) {
                break label1234;
              }
              paramSnsObject = (m)this.JEL.get(Long.valueOf(paramLong));
              paramSnsObject.JFo = Util.currentTicks();
              this.JEL.put(Long.valueOf(paramLong), paramSnsObject);
              if (!this.JEP.containsKey(paramString))
              {
                i = (int)(System.currentTimeMillis() / 1000L);
                this.JEP.put(paramString, Integer.valueOf(i));
                Log.i("MicroMsg.SnsAdStatistic", "exposures item " + paramString + ", snsId=" + com.tencent.mm.plugin.sns.data.t.Qu(paramLong) + ", time=" + i);
              }
              localObject1 = localSnsInfo.getAdXml();
              localTimeLineObject = localSnsInfo.getTimeLine();
              paramSnsObject = null;
              paramString = paramSnsObject;
              if (paramView != null)
              {
                paramString = paramSnsObject;
                if (aj.JXk) {
                  paramString = paramView.fKP();
                }
              }
              paramSnsObject = localSnsInfo.getAdSnsInfo();
              i = 0;
              if (this.source == 0)
              {
                i = paramSnsObject.field_exposureCount + 1;
                paramSnsObject.field_exposureCount = i;
                aj.fOL().update(paramSnsObject, new String[0]);
              }
              if (localObject2 != null) {
                break label1384;
              }
              paramSnsObject = "";
              localObject2 = new b();
              ((b)localObject2).JDQ = paramInt1;
              ((b)localObject2).Jzk = localSnsInfo;
              if (paramView == null) {
                break label1394;
              }
              paramInt1 = paramView.jCa;
              ((b)localObject2).JDR = paramInt1;
              if (!((ADXml)localObject1).isLinkAd()) {
                break label1399;
              }
              paramInt1 = 3;
              paramString = new g(str, paramInt3, paramString, paramInt1, i, localSnsInfo.getAdRecSrc(), i(localSnsInfo), j(localSnsInfo), paramSnsObject, (b)localObject2);
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
            }
            AppMethodBeat.o(95013);
            return;
          }
          label1199:
          this.JEH.put(paramString, Long.valueOf(Util.currentTicks()));
          this.JEI.put(paramString, Integer.valueOf(0));
          continue;
          label1234:
          paramSnsObject = new m("timeline");
          continue;
          label1249:
          if ((paramInt2 == 11) && (localSnsInfo.getTimeLine().ContentObj.Sqr.size() > 0) && (((cvt)localSnsInfo.getTimeLine().ContentObj.Sqr.get(0)).rWu == 6))
          {
            if (this.JEL.containsKey(Long.valueOf(paramLong))) {}
            for (paramSnsObject = (m)this.JEL.get(Long.valueOf(paramLong));; paramSnsObject = new m("timeline"))
            {
              paramSnsObject.JFo = Util.currentTicks();
              paramSnsObject.JFt = true;
              this.JEL.put(Long.valueOf(paramLong), paramSnsObject);
              break;
            }
            label1384:
            paramSnsObject = ((ADInfo)localObject2).waidPkg;
            continue;
            label1394:
            paramInt1 = 0;
            continue;
            label1399:
            if (localSnsInfo.isTurnCardAd()) {
              paramInt1 = 6;
            } else if ((localSnsInfo.isCardAd()) || (localSnsInfo.isFullCardAd()))
            {
              if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj.Sqq == 15) && (localTimeLineObject.sightFolded != 1)) {
                paramInt1 = 5;
              } else {
                paramInt1 = 4;
              }
            }
            else if (localSnsInfo.isFinderTopicCardAd()) {
              paramInt1 = 9;
            } else if (((ADXml)localObject1).isSlideFullCard()) {
              paramInt1 = 10;
            } else if ((paramInt2 == 9) || (paramInt2 == 19)) {
              paramInt1 = 2;
            } else {
              paramInt1 = 1;
            }
          }
        }
      }
    }
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(203787);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        Log.d("MicroMsg.SnsAdStatistic", "the key or listener is null");
        AppMethodBeat.o(203787);
        return;
      }
      this.JEN.put(paramString, paramd);
      AppMethodBeat.o(203787);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.SnsAdStatistic", "addAdRemovedListener exp= " + paramString.toString());
      AppMethodBeat.o(203787);
    }
  }
  
  public final void ay(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95005);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94992);
        if (l.this.Qi(paramLong1))
        {
          l locall = l.this;
          long l = this.JFa;
          if (!locall.JEK.contains(Long.valueOf(l))) {
            locall.JEK.add(Long.valueOf(l));
          }
        }
        AppMethodBeat.o(94992);
      }
    });
    AppMethodBeat.o(95005);
  }
  
  public final void az(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(203782);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244434);
        m localm = (m)l.this.JEL.get(Long.valueOf(paramLong1));
        if (localm != null) {
          localm.JFx = this.JFc;
        }
        AppMethodBeat.o(244434);
      }
    });
    AppMethodBeat.o(203782);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95002);
    m localm;
    if (paramBoolean2) {
      if (this.JEM.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.JEM.get(Long.valueOf(paramLong));
        Log.d("MicroMsg.SnsAdStatistic", "snsId=" + com.tencent.mm.plugin.sns.data.t.Qu(paramLong) + ", duration=" + paramInt);
        if (paramInt > 0) {
          localm.setDuration(paramInt);
        }
        if (!paramBoolean1) {
          break label198;
        }
      }
    }
    label198:
    for (paramInt = 1;; paramInt = 0)
    {
      localm.JFm = paramInt;
      if (!paramBoolean2) {
        break label203;
      }
      this.JEM.put(Long.valueOf(paramLong), localm);
      AppMethodBeat.o(95002);
      return;
      localm = new m("timeline");
      break;
      if (this.JEL.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.JEL.get(Long.valueOf(paramLong));
        break;
      }
      localm = new m("timeline");
      break;
    }
    label203:
    this.JEL.put(Long.valueOf(paramLong), localm);
    AppMethodBeat.o(95002);
  }
  
  public final void c(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(95007);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94993);
        if (l.this.Qi(paramLong1))
        {
          l locall = l.this;
          long l1 = paramLong1;
          long l2 = paramBoolean;
          boolean bool = this.JEX;
          m localm;
          if (bool) {
            if (locall.JEM.containsKey(Long.valueOf(l1))) {
              localm = (m)locall.JEM.get(Long.valueOf(l1));
            }
          }
          for (;;)
          {
            if (localm.JFu.JGJ == 0L) {
              localm.JFu.JGJ = l2;
            }
            if (!bool) {
              break;
            }
            locall.JEM.put(Long.valueOf(l1), localm);
            AppMethodBeat.o(94993);
            return;
            localm = new m("timeline");
            continue;
            if (locall.JEL.containsKey(Long.valueOf(l1))) {
              localm = (m)locall.JEL.get(Long.valueOf(l1));
            } else {
              localm = new m("timeline");
            }
          }
          locall.JEL.put(Long.valueOf(l1), localm);
        }
        AppMethodBeat.o(94993);
      }
    });
    AppMethodBeat.o(95007);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(95016);
    Log.i("MicroMsg.SnsAdStatistic", "clean the adRemove");
    Object localObject1 = new HashSet(this.JEO.keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.JEO.get(localObject2);
      a(((a)localObject2).position, ((a)localObject2).fWJ, ((a)localObject2).JEb, ((a)localObject2).maU);
    }
    localObject1 = new HashMap(this.JEP);
    aj.fwa().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94994);
        Iterator localIterator = this.JFb.keySet().iterator();
        AdSnsInfo localAdSnsInfo;
        SnsInfo localSnsInfo;
        int j;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localAdSnsInfo = aj.fOL().agG(y.bbI(str));
          if (localAdSnsInfo != null)
          {
            localSnsInfo = localAdSnsInfo.convertToSnsInfo();
            localAdSnsInfo.setExposures();
            j = 0;
            i = (int)(System.currentTimeMillis() / 1000L);
            if (!this.JFb.containsKey(str)) {
              break label233;
            }
            i = ((Integer)this.JFb.get(str)).intValue();
            j = 1;
          }
        }
        label233:
        for (;;)
        {
          if (localAdSnsInfo.field_exposureTime <= 0)
          {
            localAdSnsInfo.field_exposureTime = i;
            Log.i("MicroMsg.SnsAdStatistic", "update Ad ExposureTime, snsId=" + com.tencent.mm.plugin.sns.data.t.Qu(localAdSnsInfo.field_snsId) + ", exposuretime=" + i + "， sys.currentTimeMis=" + System.currentTimeMillis() + ", type=" + j);
          }
          if (localSnsInfo != null) {
            localSnsInfo.setExposures();
          }
          aj.fOI().b(localSnsInfo.field_snsId, localSnsInfo);
          aj.fOL().b(localAdSnsInfo.field_snsId, localAdSnsInfo);
          break;
          AppMethodBeat.o(94994);
          return;
        }
      }
    });
    this.JEO.clear();
    this.JEP.clear();
    AppMethodBeat.o(95016);
  }
  
  public final void d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95004);
    m localm;
    if (paramBoolean2) {
      if (this.JEM.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.JEM.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label162;
        }
      }
    }
    label162:
    for (localm.JFu.JGH = 2;; localm.JFu.JGH = 1)
    {
      localm.JFu.JGI = 1;
      if (!paramBoolean2) {
        break label174;
      }
      this.JEM.put(Long.valueOf(paramLong), localm);
      AppMethodBeat.o(95004);
      return;
      localm = new m("timeline");
      break;
      if (this.JEL.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.JEL.get(Long.valueOf(paramLong));
        break;
      }
      localm = new m("timeline");
      break;
    }
    label174:
    this.JEL.put(Long.valueOf(paramLong), localm);
    AppMethodBeat.o(95004);
  }
  
  public final void e(final long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95000);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94991);
        l.this.b(paramLong, this.pmn, this.JEZ, this.JEX);
        AppMethodBeat.o(94991);
      }
    });
    AppMethodBeat.o(95000);
  }
  
  public final void f(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203728);
    b(paramLong, paramInt, paramBoolean, false);
    AppMethodBeat.o(203728);
  }
  
  public final void fKR()
  {
    AppMethodBeat.i(292836);
    yo(false);
    AppMethodBeat.o(292836);
  }
  
  public final long fT(String paramString, int paramInt)
  {
    AppMethodBeat.i(94997);
    c localc = (c)this.JEJ.get(paramString);
    if (localc != null) {}
    for (long l = localc.JEi;; l = 0L)
    {
      Log.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(94997);
      return l;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(95009);
    Iterator localIterator = this.JEO.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.JEO.get(localObject2);
      Log.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).JFi += Util.ticksToNow(((a)localObject1).JFf);
      ((a)localObject1).JFf = 0L;
      localObject2 = (m)this.JEL.get(Long.valueOf(((a)localObject1).JEb));
      if (localObject2 != null) {
        ((m)localObject2).maZ = Util.currentTicks();
      }
      localObject1 = (m)this.JEM.get(Long.valueOf(((a)localObject1).JEb));
      if (localObject1 != null) {
        ((m)localObject1).maZ = Util.currentTicks();
      }
    }
    localIterator = this.JEJ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (aj.JXk))
      {
        ((c)localObject1).yn(false);
        if ((!Util.isNullOrNil(((c)localObject1).fCM)) && (this.JEO.get(((c)localObject1).fCM) != null))
        {
          localObject2 = (a)this.JEO.get(((c)localObject1).fCM);
          long l;
          if (((a)localObject2).JFh > 0L)
          {
            l = Util.ticksToNow(((a)localObject2).JFh);
            ((a)localObject2).JFj += l;
            ((a)localObject2).JFh = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).JFj + ", id=" + ((c)localObject1).fCM);
          }
          if (((a)localObject2).JFl > 0L)
          {
            l = Util.ticksToNow(((a)localObject2).JFl);
            ((a)localObject2).JFk += l;
            ((a)localObject2).JFl = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).JFk + ", id=" + ((c)localObject1).fCM);
          }
        }
      }
    }
    AppMethodBeat.o(95009);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(94998);
    long l = Util.currentTicks();
    Iterator localIterator = this.JEO.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.JEO.get(localObject2);
      Log.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).JFf = l;
      localObject2 = (m)this.JEL.get(Long.valueOf(((a)localObject1).JEb));
      if (localObject2 != null) {
        ((m)localObject2).onResume();
      }
      localObject1 = (m)this.JEM.get(Long.valueOf(((a)localObject1).JEb));
      if (localObject1 != null) {
        ((m)localObject1).onResume();
      }
    }
    localIterator = this.JEJ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (aj.JXk))
      {
        ((c)localObject1).yn(false);
        if ((!Util.isNullOrNil(((c)localObject1).fCM)) && (this.JEO.get(((c)localObject1).fCM) != null))
        {
          localObject2 = (a)this.JEO.get(((c)localObject1).fCM);
          if (((c)localObject1).fKQ())
          {
            ((a)localObject2).JFh = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + ((c)localObject1).fCM);
          }
          else if (((c)localObject1).JEC)
          {
            ((a)localObject2).JFl = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + ((c)localObject1).fCM);
          }
        }
      }
    }
    AppMethodBeat.o(94998);
  }
  
  public final void yo(boolean paramBoolean)
  {
    AppMethodBeat.i(95015);
    Log.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.JEJ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localc != null) && (aj.JXk))
      {
        localc.yn(paramBoolean);
        if ((!Util.isNullOrNil(localc.fCM)) && (this.JEO.get(localc.fCM) != null))
        {
          a locala = (a)this.JEO.get(localc.fCM);
          boolean bool = localc.fKQ();
          if ((bool) && (locala.JFh == 0L))
          {
            locala.JFh = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + localc.fCM);
          }
          long l;
          for (;;)
          {
            bool = localc.JEC;
            if ((!bool) || (locala.JFl != 0L)) {
              break label326;
            }
            locala.JFl = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + localc.fCM);
            break;
            if ((!bool) && (locala.JFh > 0L))
            {
              l = Util.ticksToNow(locala.JFh);
              locala.JFj += l;
              locala.JFh = 0L;
              Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + locala.JFj);
            }
          }
          label326:
          if ((!bool) && (locala.JFl > 0L))
          {
            l = Util.ticksToNow(locala.JFl);
            locala.JFk += l;
            locala.JFl = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + locala.JFk);
          }
        }
      }
    }
    AppMethodBeat.o(95015);
  }
  
  static final class a
  {
    public long JEb;
    public long JFd;
    public long JFe;
    public long JFf;
    public String JFg;
    public long JFh;
    public long JFi;
    public long JFj;
    public long JFk;
    public long JFl;
    public String fWJ;
    public int maU;
    public int position;
    public int viewType;
    
    public a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3, int paramInt3)
    {
      this.JFd = paramLong1;
      this.JFe = paramLong2;
      this.JFf = paramLong1;
      this.fWJ = paramString1;
      this.position = paramInt1;
      this.JFg = paramString2;
      this.JEb = paramLong3;
      this.viewType = paramInt2;
      this.maU = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.l
 * JD-Core Version:    0.7.0.1
 */