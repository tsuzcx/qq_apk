package com.tencent.mm.plugin.sns.ad.g;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l
  implements e
{
  public static Map<String, Integer> PVS;
  private int CCP;
  private int DRE;
  public HashMap<String, Long> PVH;
  public HashSet<Long> PVI;
  private Map<String, Long> PVJ;
  private Map<String, Integer> PVK;
  private Map<String, c> PVL;
  public HashSet<Long> PVM;
  public Map<Long, m> PVN;
  public Map<Long, m> PVO;
  public Map<String, d> PVP;
  public Map<String, a> PVQ;
  private Map<String, Integer> PVR;
  private View PVT;
  public Map<Long, Integer> PVU;
  public Map<Long, Integer> PVV;
  public HashSet<String> PVW;
  private Activity activity;
  public int source;
  private int vpn;
  
  static
  {
    AppMethodBeat.i(95019);
    PVS = new HashMap();
    AppMethodBeat.o(95019);
  }
  
  public l(int paramInt)
  {
    AppMethodBeat.i(94996);
    this.PVH = new HashMap();
    this.PVI = new HashSet();
    this.PVJ = new HashMap();
    this.PVK = new HashMap();
    this.PVL = new HashMap();
    this.PVM = new HashSet();
    this.PVN = new HashMap();
    this.PVO = new HashMap();
    this.PVP = new HashMap();
    this.PVQ = new HashMap();
    this.source = 0;
    this.PVR = new HashMap();
    this.DRE = 0;
    this.CCP = 0;
    this.PVT = null;
    this.PVU = new HashMap();
    this.PVV = new HashMap();
    this.PVW = new HashSet();
    this.vpn = -1;
    this.source = paramInt;
    AppMethodBeat.o(94996);
  }
  
  private d aWF(String paramString)
  {
    AppMethodBeat.i(309933);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(309933);
        return null;
      }
      paramString = (d)this.PVP.remove(paramString);
      AppMethodBeat.o(309933);
      return paramString;
    }
    finally
    {
      Log.e("MicroMsg.SnsAdStatistic", "removeAdRemovedListener exp= " + paramString.toString());
      AppMethodBeat.o(309933);
    }
    return null;
  }
  
  private ADInfo j(SnsInfo paramSnsInfo)
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
  
  private com.tencent.mm.bx.b k(SnsInfo paramSnsInfo)
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
  
  private com.tencent.mm.bx.b l(SnsInfo paramSnsInfo)
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
  
  public final void Ds(boolean paramBoolean)
  {
    AppMethodBeat.i(95015);
    Log.i("MicroMsg.SnsAdStatistic", "checkAd %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Iterator localIterator = this.PVL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localc != null) && (al.Qus))
      {
        localc.Dr(paramBoolean);
        if ((!Util.isNullOrNil(localc.hHB)) && (this.PVQ.get(localc.hHB) != null))
        {
          a locala = (a)this.PVQ.get(localc.hHB);
          boolean bool = localc.hbh();
          if ((bool) && (locala.PWi == 0L))
          {
            locala.PWi = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + localc.hHB);
          }
          long l;
          for (;;)
          {
            bool = localc.PVE;
            if ((!bool) || (locala.PWm != 0L)) {
              break label324;
            }
            locala.PWm = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + localc.hHB);
            break;
            if ((!bool) && (locala.PWi > 0L))
            {
              l = Util.ticksToNow(locala.PWi);
              locala.PWk += l;
              locala.PWi = 0L;
              Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + locala.PWk);
            }
          }
          label324:
          if ((!bool) && (locala.PWm > 0L))
          {
            l = Util.ticksToNow(locala.PWm);
            locala.PWl += l;
            locala.PWm = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + locala.PWl);
          }
        }
      }
    }
    AppMethodBeat.o(95015);
  }
  
  public final void S(final long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(94999);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94990);
        if (l.this.up(paramLong))
        {
          l locall = l.this;
          long l = paramLong;
          boolean bool = this.PVY;
          m localm;
          if (bool) {
            if (locall.PVO.containsKey(Long.valueOf(l))) {
              localm = (m)locall.PVO.get(Long.valueOf(l));
            }
          }
          for (;;)
          {
            localm.PWn = 1;
            localm.PWv.PXE += 1;
            if (!bool) {
              break;
            }
            locall.PVO.put(Long.valueOf(l), localm);
            AppMethodBeat.o(94990);
            return;
            localm = new m("timeline");
            continue;
            if (locall.PVN.containsKey(Long.valueOf(l))) {
              localm = (m)locall.PVN.get(Long.valueOf(l));
            } else {
              localm = new m("timeline");
            }
          }
          locall.PVN.put(Long.valueOf(l), localm);
        }
        AppMethodBeat.o(94990);
      }
    });
    AppMethodBeat.o(94999);
  }
  
  public final void T(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95003);
    e(paramLong, paramBoolean, false);
    AppMethodBeat.o(95003);
  }
  
  public final void U(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95008);
    m localm;
    if (paramBoolean)
    {
      if (this.PVO.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.PVO.get(Long.valueOf(paramLong));
        localm.ajw(0);
      }
      for (;;)
      {
        this.PVO.put(Long.valueOf(paramLong), localm);
        AppMethodBeat.o(95008);
        return;
        localm = new m("timeline");
      }
    }
    if (this.PVN.containsKey(Long.valueOf(paramLong)))
    {
      localm = (m)this.PVN.get(Long.valueOf(paramLong));
      localm.ajw(0);
    }
    for (;;)
    {
      this.PVN.put(Long.valueOf(paramLong), localm);
      AppMethodBeat.o(95008);
      return;
      localm = new m("timeline");
    }
  }
  
  public final void a(int paramInt, View paramView, Activity paramActivity)
  {
    this.CCP = paramInt;
    this.PVT = paramView;
    this.activity = paramActivity;
  }
  
  /* Error */
  public final void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 377
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 86	com/tencent/mm/plugin/sns/ad/g/l:PVH	Ljava/util/HashMap;
    //   10: aload_2
    //   11: invokevirtual 378	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   14: ifeq +32 -> 46
    //   17: aload_0
    //   18: getfield 86	com/tencent/mm/plugin/sns/ad/g/l:PVH	Ljava/util/HashMap;
    //   21: aload_2
    //   22: invokevirtual 379	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 353	java/lang/Long
    //   28: invokevirtual 382	java/lang/Long:longValue	()J
    //   31: lstore 11
    //   33: aload_0
    //   34: getfield 91	com/tencent/mm/plugin/sns/ad/g/l:PVI	Ljava/util/HashSet;
    //   37: lload 11
    //   39: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: invokevirtual 384	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   45: pop
    //   46: aconst_null
    //   47: astore 18
    //   49: aconst_null
    //   50: astore 21
    //   52: aload_0
    //   53: getfield 97	com/tencent/mm/plugin/sns/ad/g/l:PVL	Ljava/util/Map;
    //   56: aload_2
    //   57: invokeinterface 289 2 0
    //   62: checkcast 267	com/tencent/mm/plugin/sns/ad/g/c
    //   65: astore 23
    //   67: aload 18
    //   69: astore 20
    //   71: aload 21
    //   73: astore 19
    //   75: aload 23
    //   77: ifnull +1219 -> 1296
    //   80: aload 18
    //   82: astore 20
    //   84: aload 21
    //   86: astore 19
    //   88: getstatic 273	com/tencent/mm/plugin/sns/model/al:Qus	Z
    //   91: ifeq +1205 -> 1296
    //   94: aload 23
    //   96: iconst_1
    //   97: putfield 387	com/tencent/mm/plugin/sns/ad/g/c:nxG	Z
    //   100: aload 23
    //   102: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   105: putfield 395	com/tencent/mm/plugin/sns/ad/g/c:PVl	J
    //   108: aload 23
    //   110: iconst_0
    //   111: putfield 398	com/tencent/mm/plugin/sns/ad/g/c:PVD	I
    //   114: aload_0
    //   115: iconst_0
    //   116: invokevirtual 400	com/tencent/mm/plugin/sns/ad/g/l:Ds	(Z)V
    //   119: aload 23
    //   121: getfield 403	com/tencent/mm/plugin/sns/ad/g/c:PVg	I
    //   124: ifge +1088 -> 1212
    //   127: aload 23
    //   129: iconst_2
    //   130: putfield 406	com/tencent/mm/plugin/sns/ad/g/c:PVB	I
    //   133: aload 23
    //   135: getfield 409	com/tencent/mm/plugin/sns/ad/g/c:PVi	I
    //   138: ifge +1083 -> 1221
    //   141: aload 23
    //   143: iconst_2
    //   144: putfield 412	com/tencent/mm/plugin/sns/ad/g/c:PVC	I
    //   147: new 173	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   154: astore 18
    //   156: aload 18
    //   158: new 173	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   165: aload 23
    //   167: getfield 416	com/tencent/mm/plugin/sns/ad/g/c:PVd	J
    //   170: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   173: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc_w 424
    //   179: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 18
    //   191: new 173	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   198: aload 23
    //   200: getfield 427	com/tencent/mm/plugin/sns/ad/g/c:mdG	Ljava/lang/String;
    //   203: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 424
    //   209: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 18
    //   221: new 173	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   228: aload 23
    //   230: getfield 406	com/tencent/mm/plugin/sns/ad/g/c:PVB	I
    //   233: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc_w 424
    //   239: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 18
    //   251: new 173	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   258: aload 23
    //   260: getfield 412	com/tencent/mm/plugin/sns/ad/g/c:PVC	I
    //   263: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 424
    //   269: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 18
    //   281: new 173	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   288: aload 23
    //   290: getfield 433	com/tencent/mm/plugin/sns/ad/g/c:PVy	I
    //   293: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: ldc_w 424
    //   299: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 18
    //   311: new 173	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   318: aload 23
    //   320: getfield 436	com/tencent/mm/plugin/sns/ad/g/c:PVz	I
    //   323: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 424
    //   329: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 18
    //   341: new 173	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   348: aload 23
    //   350: getfield 439	com/tencent/mm/plugin/sns/ad/g/c:PVA	I
    //   353: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc_w 424
    //   359: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 18
    //   371: new 173	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   378: aload 23
    //   380: getfield 442	com/tencent/mm/plugin/sns/ad/g/c:PVk	J
    //   383: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   386: ldc_w 424
    //   389: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 18
    //   401: new 173	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   408: aload 23
    //   410: getfield 395	com/tencent/mm/plugin/sns/ad/g/c:PVl	J
    //   413: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: ldc_w 424
    //   419: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 23
    //   431: getfield 445	com/tencent/mm/plugin/sns/ad/g/c:PVo	J
    //   434: lconst_0
    //   435: lcmp
    //   436: ifle +68 -> 504
    //   439: aload 23
    //   441: getfield 448	com/tencent/mm/plugin/sns/ad/g/c:PVr	J
    //   444: lconst_0
    //   445: lcmp
    //   446: ifne +58 -> 504
    //   449: aload 23
    //   451: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   454: putfield 448	com/tencent/mm/plugin/sns/ad/g/c:PVr	J
    //   457: ldc_w 450
    //   460: new 173	java/lang/StringBuilder
    //   463: dup
    //   464: ldc_w 452
    //   467: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: aload 23
    //   472: getfield 448	com/tencent/mm/plugin/sns/ad/g/c:PVr	J
    //   475: aload 23
    //   477: getfield 445	com/tencent/mm/plugin/sns/ad/g/c:PVo	J
    //   480: lsub
    //   481: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: ldc_w 454
    //   487: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 23
    //   492: invokevirtual 458	java/lang/Object:hashCode	()I
    //   495: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload 18
    //   506: new 173	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   513: aload 23
    //   515: getfield 445	com/tencent/mm/plugin/sns/ad/g/c:PVo	J
    //   518: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   521: ldc_w 424
    //   524: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 18
    //   536: new 173	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   543: aload 23
    //   545: getfield 448	com/tencent/mm/plugin/sns/ad/g/c:PVr	J
    //   548: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   551: ldc_w 424
    //   554: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 23
    //   566: getfield 461	com/tencent/mm/plugin/sns/ad/g/c:PVu	J
    //   569: lconst_0
    //   570: lcmp
    //   571: ifle +68 -> 639
    //   574: aload 23
    //   576: getfield 464	com/tencent/mm/plugin/sns/ad/g/c:PVx	J
    //   579: lconst_0
    //   580: lcmp
    //   581: ifne +58 -> 639
    //   584: aload 23
    //   586: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   589: putfield 464	com/tencent/mm/plugin/sns/ad/g/c:PVx	J
    //   592: ldc_w 450
    //   595: new 173	java/lang/StringBuilder
    //   598: dup
    //   599: ldc_w 466
    //   602: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   605: aload 23
    //   607: getfield 464	com/tencent/mm/plugin/sns/ad/g/c:PVx	J
    //   610: aload 23
    //   612: getfield 461	com/tencent/mm/plugin/sns/ad/g/c:PVu	J
    //   615: lsub
    //   616: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   619: ldc_w 454
    //   622: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload 23
    //   627: invokevirtual 458	java/lang/Object:hashCode	()I
    //   630: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload 18
    //   641: new 173	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   648: aload 23
    //   650: getfield 461	com/tencent/mm/plugin/sns/ad/g/c:PVu	J
    //   653: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   656: ldc_w 424
    //   659: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 18
    //   671: aload 23
    //   673: getfield 464	com/tencent/mm/plugin/sns/ad/g/c:PVx	J
    //   676: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload 23
    //   682: getfield 416	com/tencent/mm/plugin/sns/ad/g/c:PVd	J
    //   685: aload 18
    //   687: invokestatic 471	com/tencent/mm/plugin/sns/ad/g/k:a	(JLjava/lang/StringBuilder;)V
    //   690: ldc_w 450
    //   693: new 173	java/lang/StringBuilder
    //   696: dup
    //   697: ldc_w 473
    //   700: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   703: aload 18
    //   705: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: new 475	com/tencent/mm/protocal/protobuf/ck
    //   720: dup
    //   721: invokespecial 476	com/tencent/mm/protocal/protobuf/ck:<init>	()V
    //   724: astore 20
    //   726: aload 20
    //   728: aload 23
    //   730: getfield 461	com/tencent/mm/plugin/sns/ad/g/c:PVu	J
    //   733: putfield 479	com/tencent/mm/protocal/protobuf/ck:YED	J
    //   736: aload 20
    //   738: aload 23
    //   740: getfield 464	com/tencent/mm/plugin/sns/ad/g/c:PVx	J
    //   743: putfield 482	com/tencent/mm/protocal/protobuf/ck:YEE	J
    //   746: aload 20
    //   748: aload 23
    //   750: getfield 406	com/tencent/mm/plugin/sns/ad/g/c:PVB	I
    //   753: putfield 483	com/tencent/mm/protocal/protobuf/ck:PVB	I
    //   756: aload 20
    //   758: aload 23
    //   760: getfield 412	com/tencent/mm/plugin/sns/ad/g/c:PVC	I
    //   763: putfield 484	com/tencent/mm/protocal/protobuf/ck:PVC	I
    //   766: aload 20
    //   768: aload 23
    //   770: getfield 433	com/tencent/mm/plugin/sns/ad/g/c:PVy	I
    //   773: i2f
    //   774: putfield 488	com/tencent/mm/protocal/protobuf/ck:YEy	F
    //   777: aload 20
    //   779: aload 23
    //   781: getfield 436	com/tencent/mm/plugin/sns/ad/g/c:PVz	I
    //   784: i2f
    //   785: putfield 491	com/tencent/mm/protocal/protobuf/ck:YEz	F
    //   788: aload 20
    //   790: aload 23
    //   792: getfield 439	com/tencent/mm/plugin/sns/ad/g/c:PVA	I
    //   795: i2f
    //   796: putfield 494	com/tencent/mm/protocal/protobuf/ck:YEA	F
    //   799: aload 20
    //   801: aload 23
    //   803: getfield 445	com/tencent/mm/plugin/sns/ad/g/c:PVo	J
    //   806: putfield 497	com/tencent/mm/protocal/protobuf/ck:YEB	J
    //   809: aload 20
    //   811: aload 23
    //   813: getfield 448	com/tencent/mm/plugin/sns/ad/g/c:PVr	J
    //   816: putfield 500	com/tencent/mm/protocal/protobuf/ck:YEC	J
    //   819: aload 20
    //   821: aload 23
    //   823: getfield 442	com/tencent/mm/plugin/sns/ad/g/c:PVk	J
    //   826: putfield 503	com/tencent/mm/protocal/protobuf/ck:startTime	J
    //   829: aload 20
    //   831: aload 23
    //   833: getfield 395	com/tencent/mm/plugin/sns/ad/g/c:PVl	J
    //   836: putfield 506	com/tencent/mm/protocal/protobuf/ck:endTime	J
    //   839: aload 23
    //   841: getfield 510	com/tencent/mm/plugin/sns/ad/g/c:PVf	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   844: ifnull +386 -> 1230
    //   847: aload 23
    //   849: getfield 510	com/tencent/mm/plugin/sns/ad/g/c:PVf	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   852: invokevirtual 515	com/tencent/mm/plugin/sns/storage/ADXml:isRecExpAd	()Z
    //   855: ifeq +375 -> 1230
    //   858: invokestatic 519	com/tencent/mm/plugin/sns/model/al:hgv	()Lcom/tencent/mm/plugin/sns/ad/g/n;
    //   861: sipush 14648
    //   864: iconst_1
    //   865: anewarray 4	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: aload 18
    //   872: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: aastore
    //   876: invokevirtual 525	com/tencent/mm/plugin/sns/ad/g/n:b	(I[Ljava/lang/Object;)V
    //   879: sipush 730
    //   882: invokestatic 531	com/tencent/mm/modelsns/l:wO	(I)Lcom/tencent/mm/modelsns/l;
    //   885: astore 19
    //   887: aload 19
    //   889: aload 23
    //   891: getfield 416	com/tencent/mm/plugin/sns/ad/g/c:PVd	J
    //   894: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   897: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   900: aload 23
    //   902: getfield 427	com/tencent/mm/plugin/sns/ad/g/c:mdG	Ljava/lang/String;
    //   905: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   908: aload 23
    //   910: getfield 406	com/tencent/mm/plugin/sns/ad/g/c:PVB	I
    //   913: invokevirtual 538	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   916: aload 23
    //   918: getfield 412	com/tencent/mm/plugin/sns/ad/g/c:PVC	I
    //   921: invokevirtual 538	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   924: aload 23
    //   926: getfield 433	com/tencent/mm/plugin/sns/ad/g/c:PVy	I
    //   929: invokevirtual 538	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   932: aload 23
    //   934: getfield 436	com/tencent/mm/plugin/sns/ad/g/c:PVz	I
    //   937: invokevirtual 538	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   940: aload 23
    //   942: getfield 439	com/tencent/mm/plugin/sns/ad/g/c:PVA	I
    //   945: invokevirtual 538	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   948: new 173	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   955: aload 23
    //   957: getfield 442	com/tencent/mm/plugin/sns/ad/g/c:PVk	J
    //   960: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   963: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   969: new 173	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   976: aload 23
    //   978: getfield 395	com/tencent/mm/plugin/sns/ad/g/c:PVl	J
    //   981: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   984: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   990: new 173	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   997: aload 23
    //   999: getfield 445	com/tencent/mm/plugin/sns/ad/g/c:PVo	J
    //   1002: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1011: new 173	java/lang/StringBuilder
    //   1014: dup
    //   1015: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   1018: aload 23
    //   1020: getfield 448	com/tencent/mm/plugin/sns/ad/g/c:PVr	J
    //   1023: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1032: new 173	java/lang/StringBuilder
    //   1035: dup
    //   1036: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   1039: aload 23
    //   1041: getfield 461	com/tencent/mm/plugin/sns/ad/g/c:PVu	J
    //   1044: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1053: new 173	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   1060: aload 23
    //   1062: getfield 464	com/tencent/mm/plugin/sns/ad/g/c:PVx	J
    //   1065: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokevirtual 535	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   1074: pop
    //   1075: aload 19
    //   1077: invokevirtual 541	com/tencent/mm/modelsns/l:bMH	()Z
    //   1080: pop
    //   1081: new 543	com/tencent/mm/autogen/a/px
    //   1084: dup
    //   1085: invokespecial 544	com/tencent/mm/autogen/a/px:<init>	()V
    //   1088: astore 19
    //   1090: aload 19
    //   1092: getfield 548	com/tencent/mm/autogen/a/px:hTc	Lcom/tencent/mm/autogen/a/px$a;
    //   1095: aload 23
    //   1097: getfield 551	com/tencent/mm/plugin/sns/ad/g/c:position	I
    //   1100: putfield 554	com/tencent/mm/autogen/a/px$a:position	I
    //   1103: aload 19
    //   1105: invokevirtual 557	com/tencent/mm/autogen/a/px:publish	()Z
    //   1108: pop
    //   1109: getstatic 562	com/tencent/mm/platformtools/z:pCT	Z
    //   1112: ifeq +166 -> 1278
    //   1115: new 564	java/util/Random
    //   1118: dup
    //   1119: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   1122: invokespecial 567	java/util/Random:<init>	(J)V
    //   1125: sipush 2000
    //   1128: invokevirtual 571	java/util/Random:nextInt	(I)I
    //   1131: bipush 10
    //   1133: iadd
    //   1134: istore 7
    //   1136: ldc_w 450
    //   1139: ldc_w 573
    //   1142: iload 7
    //   1144: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1147: invokevirtual 149	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1150: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1153: iconst_0
    //   1154: istore 6
    //   1156: iload 6
    //   1158: iload 7
    //   1160: if_icmpge +118 -> 1278
    //   1163: aload 23
    //   1165: getfield 510	com/tencent/mm/plugin/sns/ad/g/c:PVf	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   1168: ifnull +86 -> 1254
    //   1171: aload 23
    //   1173: getfield 510	com/tencent/mm/plugin/sns/ad/g/c:PVf	Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   1176: invokevirtual 515	com/tencent/mm/plugin/sns/storage/ADXml:isRecExpAd	()Z
    //   1179: ifeq +75 -> 1254
    //   1182: invokestatic 519	com/tencent/mm/plugin/sns/model/al:hgv	()Lcom/tencent/mm/plugin/sns/ad/g/n;
    //   1185: sipush 14648
    //   1188: iconst_1
    //   1189: anewarray 4	java/lang/Object
    //   1192: dup
    //   1193: iconst_0
    //   1194: aload 18
    //   1196: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1199: aastore
    //   1200: invokevirtual 525	com/tencent/mm/plugin/sns/ad/g/n:b	(I[Ljava/lang/Object;)V
    //   1203: iload 6
    //   1205: iconst_1
    //   1206: iadd
    //   1207: istore 6
    //   1209: goto -53 -> 1156
    //   1212: aload 23
    //   1214: iconst_1
    //   1215: putfield 406	com/tencent/mm/plugin/sns/ad/g/c:PVB	I
    //   1218: goto -1085 -> 133
    //   1221: aload 23
    //   1223: iconst_1
    //   1224: putfield 412	com/tencent/mm/plugin/sns/ad/g/c:PVC	I
    //   1227: goto -1080 -> 147
    //   1230: invokestatic 519	com/tencent/mm/plugin/sns/model/al:hgv	()Lcom/tencent/mm/plugin/sns/ad/g/n;
    //   1233: sipush 12010
    //   1236: iconst_1
    //   1237: anewarray 4	java/lang/Object
    //   1240: dup
    //   1241: iconst_0
    //   1242: aload 18
    //   1244: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1247: aastore
    //   1248: invokevirtual 525	com/tencent/mm/plugin/sns/ad/g/n:b	(I[Ljava/lang/Object;)V
    //   1251: goto -372 -> 879
    //   1254: invokestatic 519	com/tencent/mm/plugin/sns/model/al:hgv	()Lcom/tencent/mm/plugin/sns/ad/g/n;
    //   1257: sipush 12010
    //   1260: iconst_1
    //   1261: anewarray 4	java/lang/Object
    //   1264: dup
    //   1265: iconst_0
    //   1266: aload 18
    //   1268: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: aastore
    //   1272: invokevirtual 525	com/tencent/mm/plugin/sns/ad/g/n:b	(I[Ljava/lang/Object;)V
    //   1275: goto -72 -> 1203
    //   1278: aload 23
    //   1280: invokevirtual 580	com/tencent/mm/plugin/sns/ad/g/c:hbg	()Lcom/tencent/mm/protocal/protobuf/cn;
    //   1283: astore 19
    //   1285: aload_0
    //   1286: getfield 97	com/tencent/mm/plugin/sns/ad/g/l:PVL	Ljava/util/Map;
    //   1289: aload_2
    //   1290: invokeinterface 169 2 0
    //   1295: pop
    //   1296: aload_0
    //   1297: getfield 123	com/tencent/mm/plugin/sns/ad/g/l:PVW	Ljava/util/HashSet;
    //   1300: aload_2
    //   1301: invokevirtual 384	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   1304: pop
    //   1305: iconst_0
    //   1306: istore 9
    //   1308: iconst_0
    //   1309: istore 7
    //   1311: invokestatic 584	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   1314: aload_2
    //   1315: invokevirtual 590	com/tencent/mm/plugin/sns/storage/w:aZL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1318: astore 24
    //   1320: aload 24
    //   1322: ifnull +448 -> 1770
    //   1325: iload 7
    //   1327: istore 6
    //   1329: aload_0
    //   1330: getfield 103	com/tencent/mm/plugin/sns/ad/g/l:PVO	Ljava/util/Map;
    //   1333: aload 24
    //   1335: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1338: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1341: invokeinterface 360 2 0
    //   1346: ifeq +384 -> 1730
    //   1349: iload 7
    //   1351: istore 6
    //   1353: aload 24
    //   1355: invokevirtual 597	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1358: getfield 603	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   1361: getfield 608	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   1364: bipush 27
    //   1366: if_icmpne +364 -> 1730
    //   1369: aload 24
    //   1371: getfield 611	com/tencent/mm/plugin/sns/storage/SnsInfo:field_likeFlag	I
    //   1374: iconst_1
    //   1375: if_icmpne +477 -> 1852
    //   1378: iconst_2
    //   1379: istore 6
    //   1381: aload_0
    //   1382: getfield 121	com/tencent/mm/plugin/sns/ad/g/l:PVV	Ljava/util/Map;
    //   1385: aload 24
    //   1387: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1390: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1393: invokeinterface 360 2 0
    //   1398: ifeq +460 -> 1858
    //   1401: aload_0
    //   1402: getfield 121	com/tencent/mm/plugin/sns/ad/g/l:PVV	Ljava/util/Map;
    //   1405: aload 24
    //   1407: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1410: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1413: invokeinterface 289 2 0
    //   1418: checkcast 613	java/lang/Integer
    //   1421: invokevirtual 616	java/lang/Integer:intValue	()I
    //   1424: istore 7
    //   1426: aload_0
    //   1427: getfield 119	com/tencent/mm/plugin/sns/ad/g/l:PVU	Ljava/util/Map;
    //   1430: aload 24
    //   1432: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1435: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1438: invokeinterface 360 2 0
    //   1443: ifeq +421 -> 1864
    //   1446: aload_0
    //   1447: getfield 119	com/tencent/mm/plugin/sns/ad/g/l:PVU	Ljava/util/Map;
    //   1450: aload 24
    //   1452: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1455: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1458: invokeinterface 289 2 0
    //   1463: checkcast 613	java/lang/Integer
    //   1466: invokevirtual 616	java/lang/Integer:intValue	()I
    //   1469: istore 8
    //   1471: lconst_0
    //   1472: lstore 15
    //   1474: lconst_0
    //   1475: lstore 13
    //   1477: lconst_0
    //   1478: lstore 11
    //   1480: aload_0
    //   1481: getfield 103	com/tencent/mm/plugin/sns/ad/g/l:PVO	Ljava/util/Map;
    //   1484: aload 24
    //   1486: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1489: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1492: invokeinterface 169 2 0
    //   1497: checkcast 362	com/tencent/mm/plugin/sns/ad/g/m
    //   1500: astore 18
    //   1502: aload 18
    //   1504: ifnull +41 -> 1545
    //   1507: aload 18
    //   1509: iconst_0
    //   1510: invokevirtual 365	com/tencent/mm/plugin/sns/ad/g/m:ajw	(I)V
    //   1513: aload 18
    //   1515: invokevirtual 619	com/tencent/mm/plugin/sns/ad/g/m:hbk	()V
    //   1518: aload 18
    //   1520: getfield 622	com/tencent/mm/plugin/sns/ad/g/m:PWt	I
    //   1523: i2l
    //   1524: lstore 15
    //   1526: aload 18
    //   1528: getfield 625	com/tencent/mm/plugin/sns/ad/g/m:PWs	I
    //   1531: i2l
    //   1532: lstore 13
    //   1534: aload 18
    //   1536: getfield 628	com/tencent/mm/plugin/sns/ad/g/m:vYw	J
    //   1539: ldc2_w 629
    //   1542: lmul
    //   1543: lstore 11
    //   1545: new 173	java/lang/StringBuilder
    //   1548: dup
    //   1549: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   1552: aload 24
    //   1554: invokevirtual 597	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1557: getfield 633	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   1560: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: astore 21
    //   1568: aload 24
    //   1570: invokevirtual 636	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
    //   1573: astore 22
    //   1575: aload 24
    //   1577: getfield 611	com/tencent/mm/plugin/sns/storage/SnsInfo:field_likeFlag	I
    //   1580: iconst_1
    //   1581: if_icmpne +289 -> 1870
    //   1584: ldc_w 638
    //   1587: astore 18
    //   1589: ldc_w 640
    //   1592: bipush 9
    //   1594: anewarray 4	java/lang/Object
    //   1597: dup
    //   1598: iconst_0
    //   1599: aload 21
    //   1601: aastore
    //   1602: dup
    //   1603: iconst_1
    //   1604: aload 22
    //   1606: aastore
    //   1607: dup
    //   1608: iconst_2
    //   1609: iload 5
    //   1611: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1614: aastore
    //   1615: dup
    //   1616: iconst_3
    //   1617: iload 7
    //   1619: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1622: aastore
    //   1623: dup
    //   1624: iconst_4
    //   1625: iload 8
    //   1627: invokestatic 576	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1630: aastore
    //   1631: dup
    //   1632: iconst_5
    //   1633: lload 15
    //   1635: invokestatic 642	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1638: aastore
    //   1639: dup
    //   1640: bipush 6
    //   1642: lload 13
    //   1644: invokestatic 642	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1647: aastore
    //   1648: dup
    //   1649: bipush 7
    //   1651: lload 11
    //   1653: invokestatic 642	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1656: aastore
    //   1657: dup
    //   1658: bipush 8
    //   1660: aload 18
    //   1662: aastore
    //   1663: invokestatic 646	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1666: astore 18
    //   1668: getstatic 652	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1671: sipush 15155
    //   1674: aload 18
    //   1676: invokevirtual 656	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   1679: ldc 137
    //   1681: ldc_w 658
    //   1684: iconst_1
    //   1685: anewarray 4	java/lang/Object
    //   1688: dup
    //   1689: iconst_0
    //   1690: aload 18
    //   1692: aastore
    //   1693: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1696: aload_0
    //   1697: getfield 99	com/tencent/mm/plugin/sns/ad/g/l:PVM	Ljava/util/HashSet;
    //   1700: aload 24
    //   1702: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1705: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1708: invokevirtual 384	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   1711: pop
    //   1712: aload_0
    //   1713: getfield 99	com/tencent/mm/plugin/sns/ad/g/l:PVM	Ljava/util/HashSet;
    //   1716: aload 24
    //   1718: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1721: lconst_1
    //   1722: ladd
    //   1723: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1726: invokevirtual 384	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   1729: pop
    //   1730: aload_0
    //   1731: getfield 121	com/tencent/mm/plugin/sns/ad/g/l:PVV	Ljava/util/Map;
    //   1734: aload 24
    //   1736: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1739: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1742: invokeinterface 169 2 0
    //   1747: pop
    //   1748: aload_0
    //   1749: getfield 119	com/tencent/mm/plugin/sns/ad/g/l:PVU	Ljava/util/Map;
    //   1752: aload 24
    //   1754: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1757: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1760: invokeinterface 169 2 0
    //   1765: pop
    //   1766: iload 6
    //   1768: istore 9
    //   1770: aload_0
    //   1771: getfield 107	com/tencent/mm/plugin/sns/ad/g/l:PVQ	Ljava/util/Map;
    //   1774: aload_2
    //   1775: invokeinterface 360 2 0
    //   1780: ifeq +1343 -> 3123
    //   1783: ldc_w 660
    //   1786: astore 21
    //   1788: aload_0
    //   1789: aload 24
    //   1791: invokespecial 662	com/tencent/mm/plugin/sns/ad/g/l:j	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1794: ifnull +14 -> 1808
    //   1797: aload_0
    //   1798: aload 24
    //   1800: invokespecial 662	com/tencent/mm/plugin/sns/ad/g/l:j	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1803: getfield 667	com/tencent/mm/plugin/sns/storage/ADInfo:viewId	Ljava/lang/String;
    //   1806: astore 21
    //   1808: aload_0
    //   1809: getfield 107	com/tencent/mm/plugin/sns/ad/g/l:PVQ	Ljava/util/Map;
    //   1812: aload_2
    //   1813: invokeinterface 169 2 0
    //   1818: checkcast 24	com/tencent/mm/plugin/sns/ad/g/l$a
    //   1821: astore 25
    //   1823: aload_0
    //   1824: getfield 93	com/tencent/mm/plugin/sns/ad/g/l:PVJ	Ljava/util/Map;
    //   1827: aload_2
    //   1828: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1831: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1834: invokeinterface 369 3 0
    //   1839: pop
    //   1840: aload 25
    //   1842: ifnonnull +36 -> 1878
    //   1845: ldc_w 377
    //   1848: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1851: return
    //   1852: iconst_1
    //   1853: istore 6
    //   1855: goto -474 -> 1381
    //   1858: iconst_0
    //   1859: istore 7
    //   1861: goto -435 -> 1426
    //   1864: iconst_0
    //   1865: istore 8
    //   1867: goto -396 -> 1471
    //   1870: ldc_w 669
    //   1873: astore 18
    //   1875: goto -286 -> 1589
    //   1878: aload 25
    //   1880: getfield 672	com/tencent/mm/plugin/sns/ad/g/l$a:PWe	J
    //   1883: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1886: lstore 11
    //   1888: aload 25
    //   1890: getfield 675	com/tencent/mm/plugin/sns/ad/g/l$a:PWg	J
    //   1893: lconst_0
    //   1894: lcmp
    //   1895: ifle +22 -> 1917
    //   1898: aload 25
    //   1900: aload 25
    //   1902: getfield 678	com/tencent/mm/plugin/sns/ad/g/l$a:PWj	J
    //   1905: aload 25
    //   1907: getfield 675	com/tencent/mm/plugin/sns/ad/g/l$a:PWg	J
    //   1910: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1913: ladd
    //   1914: putfield 678	com/tencent/mm/plugin/sns/ad/g/l$a:PWj	J
    //   1917: new 173	java/lang/StringBuilder
    //   1920: dup
    //   1921: ldc_w 680
    //   1924: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1927: iload_1
    //   1928: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1931: ldc_w 682
    //   1934: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1937: aload_2
    //   1938: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: ldc_w 682
    //   1944: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: lload 11
    //   1949: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1952: ldc_w 684
    //   1955: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: lload_3
    //   1959: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   1962: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: ldc_w 686
    //   1968: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: astore 18
    //   1973: aload 24
    //   1975: ifnonnull +33 -> 2008
    //   1978: iconst_1
    //   1979: istore 17
    //   1981: ldc 137
    //   1983: aload 18
    //   1985: iload 17
    //   1987: invokevirtual 689	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1990: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1993: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1996: aload 24
    //   1998: ifnonnull +16 -> 2014
    //   2001: ldc_w 377
    //   2004: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2007: return
    //   2008: iconst_0
    //   2009: istore 17
    //   2011: goto -30 -> 1981
    //   2014: ldc_w 660
    //   2017: astore 18
    //   2019: aload 24
    //   2021: invokevirtual 597	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   2024: astore 22
    //   2026: aload 24
    //   2028: invokevirtual 693	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   2031: astore 26
    //   2033: aload 26
    //   2035: invokevirtual 696	com/tencent/mm/plugin/sns/storage/ADXml:isLinkAd	()Z
    //   2038: ifeq +320 -> 2358
    //   2041: iconst_3
    //   2042: istore 6
    //   2044: ldc_w 660
    //   2047: astore 18
    //   2049: aload_0
    //   2050: aload 24
    //   2052: invokespecial 662	com/tencent/mm/plugin/sns/ad/g/l:j	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   2055: astore 26
    //   2057: aload 26
    //   2059: ifnonnull +1011 -> 3070
    //   2062: ldc_w 660
    //   2065: astore 22
    //   2067: new 698	com/tencent/mm/plugin/sns/ad/g/b
    //   2070: dup
    //   2071: invokespecial 699	com/tencent/mm/plugin/sns/ad/g/b:<init>	()V
    //   2074: astore 27
    //   2076: aload 27
    //   2078: iload_1
    //   2079: putfield 702	com/tencent/mm/plugin/sns/ad/g/b:PUR	I
    //   2082: aload 27
    //   2084: aload 24
    //   2086: putfield 706	com/tencent/mm/plugin/sns/ad/g/b:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   2089: aload 23
    //   2091: ifnull +989 -> 3080
    //   2094: aload 23
    //   2096: getfield 709	com/tencent/mm/plugin/sns/ad/g/c:mbN	I
    //   2099: istore_1
    //   2100: aload 27
    //   2102: iload_1
    //   2103: putfield 712	com/tencent/mm/plugin/sns/ad/g/b:PUS	I
    //   2106: aload 27
    //   2108: aload 25
    //   2110: getfield 320	com/tencent/mm/plugin/sns/ad/g/l$a:PWk	J
    //   2113: putfield 715	com/tencent/mm/plugin/sns/ad/g/b:PUV	J
    //   2116: aload 27
    //   2118: aload 25
    //   2120: getfield 330	com/tencent/mm/plugin/sns/ad/g/l$a:PWl	J
    //   2123: putfield 718	com/tencent/mm/plugin/sns/ad/g/b:PUU	J
    //   2126: aload 26
    //   2128: ifnull +49 -> 2177
    //   2131: aload 26
    //   2133: invokevirtual 721	com/tencent/mm/plugin/sns/storage/ADInfo:isWeapp	()Z
    //   2136: ifeq +41 -> 2177
    //   2139: aload 24
    //   2141: invokevirtual 724	com/tencent/mm/plugin/sns/storage/SnsInfo:isFullCardAd	()Z
    //   2144: ifne +33 -> 2177
    //   2147: aload 24
    //   2149: invokevirtual 727	com/tencent/mm/plugin/sns/storage/SnsInfo:isSlideFullCardAd	()Z
    //   2152: ifne +25 -> 2177
    //   2155: aload 26
    //   2157: getfield 731	com/tencent/mm/plugin/sns/storage/ADInfo:actionExtWeApp	Lcom/tencent/mm/plugin/sns/storage/ADInfo$b;
    //   2160: getfield 736	com/tencent/mm/plugin/sns/storage/ADInfo$b:appUserName	Ljava/lang/String;
    //   2163: invokestatic 741	com/tencent/mm/plugin/sns/ad/d/i:aWm	(Ljava/lang/String;)Z
    //   2166: ifeq +919 -> 3085
    //   2169: iconst_1
    //   2170: istore_1
    //   2171: aload 27
    //   2173: iload_1
    //   2174: putfield 744	com/tencent/mm/plugin/sns/ad/g/b:PUQ	I
    //   2177: ldc 137
    //   2179: new 173	java/lang/StringBuilder
    //   2182: dup
    //   2183: ldc_w 746
    //   2186: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2189: aload 25
    //   2191: getfield 320	com/tencent/mm/plugin/sns/ad/g/l$a:PWk	J
    //   2194: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2197: ldc_w 748
    //   2200: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: aload_2
    //   2204: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2207: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2210: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2213: ldc 137
    //   2215: new 173	java/lang/StringBuilder
    //   2218: dup
    //   2219: ldc_w 750
    //   2222: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2225: aload 25
    //   2227: getfield 330	com/tencent/mm/plugin/sns/ad/g/l$a:PWl	J
    //   2230: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2233: ldc_w 748
    //   2236: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2239: aload_2
    //   2240: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2246: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2249: new 752	com/tencent/mm/plugin/sns/ad/g/g
    //   2252: dup
    //   2253: aload 21
    //   2255: iload 5
    //   2257: iconst_2
    //   2258: lload 11
    //   2260: l2i
    //   2261: aload 20
    //   2263: aload 19
    //   2265: iload 6
    //   2267: aload 18
    //   2269: iconst_m1
    //   2270: aload 24
    //   2272: invokevirtual 755	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdRecSrc	()I
    //   2275: aload 25
    //   2277: getfield 678	com/tencent/mm/plugin/sns/ad/g/l$a:PWj	J
    //   2280: l2i
    //   2281: aload 25
    //   2283: getfield 320	com/tencent/mm/plugin/sns/ad/g/l$a:PWk	J
    //   2286: l2i
    //   2287: iload 9
    //   2289: aload_0
    //   2290: aload 24
    //   2292: invokespecial 757	com/tencent/mm/plugin/sns/ad/g/l:k	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/bx/b;
    //   2295: aload_0
    //   2296: aload 24
    //   2298: invokespecial 759	com/tencent/mm/plugin/sns/ad/g/l:l	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/bx/b;
    //   2301: aload 22
    //   2303: aload 27
    //   2305: invokespecial 762	com/tencent/mm/plugin/sns/ad/g/g:<init>	(Ljava/lang/String;IIILcom/tencent/mm/protocal/protobuf/ck;Lcom/tencent/mm/protocal/protobuf/cn;ILjava/lang/String;IIIIILcom/tencent/mm/bx/b;Lcom/tencent/mm/bx/b;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/g/b;)V
    //   2308: astore_2
    //   2309: invokestatic 768	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   2312: pop
    //   2313: invokestatic 772	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   2316: getfield 778	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   2319: aload_2
    //   2320: iconst_0
    //   2321: invokevirtual 783	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   2324: pop
    //   2325: aload 24
    //   2327: invokestatic 787	com/tencent/mm/plugin/sns/data/t:x	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Ljava/lang/String;
    //   2330: astore_2
    //   2331: aload_0
    //   2332: aload_2
    //   2333: invokespecial 789	com/tencent/mm/plugin/sns/ad/g/l:aWF	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/ad/g/d;
    //   2336: astore 18
    //   2338: aload 18
    //   2340: ifnull +11 -> 2351
    //   2343: aload 18
    //   2345: aload_2
    //   2346: invokeinterface 792 2 0
    //   2351: ldc_w 377
    //   2354: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2357: return
    //   2358: aload 24
    //   2360: invokevirtual 795	com/tencent/mm/plugin/sns/storage/SnsInfo:isTurnCardAd	()Z
    //   2363: ifeq +58 -> 2421
    //   2366: bipush 6
    //   2368: istore 6
    //   2370: aload_0
    //   2371: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   2374: aload 25
    //   2376: getfield 796	com/tencent/mm/plugin/sns/ad/g/l$a:PVd	J
    //   2379: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2382: invokeinterface 169 2 0
    //   2387: checkcast 362	com/tencent/mm/plugin/sns/ad/g/m
    //   2390: astore 18
    //   2392: aload 18
    //   2394: ifnull +798 -> 3192
    //   2397: aload 24
    //   2399: invokevirtual 799	com/tencent/mm/plugin/sns/storage/SnsInfo:getLikeFlag	()I
    //   2402: ifne +9 -> 2411
    //   2405: aload 18
    //   2407: iconst_0
    //   2408: invokevirtual 365	com/tencent/mm/plugin/sns/ad/g/m:ajw	(I)V
    //   2411: aload 18
    //   2413: invokevirtual 802	com/tencent/mm/plugin/sns/ad/g/m:hbj	()Ljava/lang/String;
    //   2416: astore 18
    //   2418: goto -369 -> 2049
    //   2421: aload 24
    //   2423: invokevirtual 805	com/tencent/mm/plugin/sns/storage/SnsInfo:isCardAd	()Z
    //   2426: ifne +11 -> 2437
    //   2429: aload 24
    //   2431: invokevirtual 724	com/tencent/mm/plugin/sns/storage/SnsInfo:isFullCardAd	()Z
    //   2434: ifeq +503 -> 2937
    //   2437: aload 22
    //   2439: ifnull +487 -> 2926
    //   2442: aload 22
    //   2444: getfield 603	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   2447: getfield 608	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   2450: bipush 15
    //   2452: if_icmpne +474 -> 2926
    //   2455: aload 22
    //   2457: getfield 808	com/tencent/mm/protocal/protobuf/TimeLineObject:sightFolded	I
    //   2460: iconst_1
    //   2461: if_icmpeq +465 -> 2926
    //   2464: aload_0
    //   2465: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   2468: aload 25
    //   2470: getfield 796	com/tencent/mm/plugin/sns/ad/g/l$a:PVd	J
    //   2473: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2476: invokeinterface 169 2 0
    //   2481: checkcast 362	com/tencent/mm/plugin/sns/ad/g/m
    //   2484: astore 22
    //   2486: aload 22
    //   2488: ifnull +696 -> 3184
    //   2491: aload 22
    //   2493: iconst_0
    //   2494: invokevirtual 365	com/tencent/mm/plugin/sns/ad/g/m:ajw	(I)V
    //   2497: aload 22
    //   2499: invokevirtual 802	com/tencent/mm/plugin/sns/ad/g/m:hbj	()Ljava/lang/String;
    //   2502: astore 18
    //   2504: aload_0
    //   2505: getfield 99	com/tencent/mm/plugin/sns/ad/g/l:PVM	Ljava/util/HashSet;
    //   2508: aload 25
    //   2510: getfield 796	com/tencent/mm/plugin/sns/ad/g/l$a:PVd	J
    //   2513: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2516: invokevirtual 384	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   2519: pop
    //   2520: aload 24
    //   2522: invokevirtual 811	com/tencent/mm/plugin/sns/storage/SnsInfo:isLongPressGestureAd	()Z
    //   2525: ifeq +395 -> 2920
    //   2528: iconst_0
    //   2529: istore 6
    //   2531: iconst_0
    //   2532: istore 7
    //   2534: aload 22
    //   2536: ifnull +335 -> 2871
    //   2539: aload 22
    //   2541: getfield 815	com/tencent/mm/plugin/sns/ad/g/m:PWw	Ljava/util/LinkedList;
    //   2544: ifnull +327 -> 2871
    //   2547: aload 22
    //   2549: getfield 815	com/tencent/mm/plugin/sns/ad/g/m:PWw	Ljava/util/LinkedList;
    //   2552: invokevirtual 820	java/util/LinkedList:size	()I
    //   2555: ifle +316 -> 2871
    //   2558: iload 6
    //   2560: istore 7
    //   2562: aload 22
    //   2564: getfield 815	com/tencent/mm/plugin/sns/ad/g/m:PWw	Ljava/util/LinkedList;
    //   2567: invokevirtual 820	java/util/LinkedList:size	()I
    //   2570: iconst_1
    //   2571: isub
    //   2572: istore 10
    //   2574: iload 6
    //   2576: istore 7
    //   2578: aload 22
    //   2580: getfield 815	com/tencent/mm/plugin/sns/ad/g/m:PWw	Ljava/util/LinkedList;
    //   2583: iload 10
    //   2585: invokevirtual 823	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   2588: checkcast 825	com/tencent/mm/plugin/sns/ad/g/a/b
    //   2591: astore 26
    //   2593: iload 6
    //   2595: istore 7
    //   2597: aload 26
    //   2599: getfield 828	com/tencent/mm/plugin/sns/ad/g/a/b:PXE	I
    //   2602: istore 6
    //   2604: iload 6
    //   2606: istore 7
    //   2608: aload 26
    //   2610: getfield 831	com/tencent/mm/plugin/sns/ad/g/a/b:PXF	I
    //   2613: istore 8
    //   2615: ldc 137
    //   2617: new 173	java/lang/StringBuilder
    //   2620: dup
    //   2621: ldc_w 833
    //   2624: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2627: aload 22
    //   2629: getfield 815	com/tencent/mm/plugin/sns/ad/g/m:PWw	Ljava/util/LinkedList;
    //   2632: invokevirtual 820	java/util/LinkedList:size	()I
    //   2635: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2638: ldc_w 835
    //   2641: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2644: iload 10
    //   2646: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2649: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2652: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2655: iload 6
    //   2657: istore 7
    //   2659: iload 8
    //   2661: istore 6
    //   2663: aload_0
    //   2664: getfield 109	com/tencent/mm/plugin/sns/ad/g/l:source	I
    //   2667: ifne +218 -> 2885
    //   2670: iconst_1
    //   2671: istore 8
    //   2673: new 837	org/json/JSONObject
    //   2676: dup
    //   2677: invokespecial 838	org/json/JSONObject:<init>	()V
    //   2680: astore 22
    //   2682: aload 22
    //   2684: ldc_w 840
    //   2687: new 173	java/lang/StringBuilder
    //   2690: dup
    //   2691: invokespecial 413	java/lang/StringBuilder:<init>	()V
    //   2694: aload 24
    //   2696: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   2699: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2702: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2705: invokevirtual 843	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2708: pop
    //   2709: aload 22
    //   2711: ldc_w 845
    //   2714: aload 24
    //   2716: invokevirtual 204	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	()Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   2719: getfield 848	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
    //   2722: invokestatic 851	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2725: invokevirtual 843	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2728: pop
    //   2729: aload 22
    //   2731: ldc_w 853
    //   2734: iload 8
    //   2736: invokevirtual 856	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2739: pop
    //   2740: new 837	org/json/JSONObject
    //   2743: dup
    //   2744: invokespecial 838	org/json/JSONObject:<init>	()V
    //   2747: astore 26
    //   2749: aload 26
    //   2751: ldc_w 858
    //   2754: iload 7
    //   2756: invokevirtual 856	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2759: pop
    //   2760: aload 26
    //   2762: ldc_w 860
    //   2765: iload 6
    //   2767: invokevirtual 856	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2770: pop
    //   2771: aload 22
    //   2773: ldc_w 862
    //   2776: aload 26
    //   2778: invokevirtual 843	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2781: pop
    //   2782: aload 22
    //   2784: invokevirtual 863	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2787: astore 22
    //   2789: ldc_w 865
    //   2792: aload 22
    //   2794: invokestatic 870	com/tencent/mm/plugin/sns/data/m:lU	(Ljava/lang/String;Ljava/lang/String;)V
    //   2797: ldc_w 872
    //   2800: new 173	java/lang/StringBuilder
    //   2803: dup
    //   2804: ldc_w 874
    //   2807: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2810: aload 22
    //   2812: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2815: ldc_w 876
    //   2818: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2821: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2824: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2827: iconst_5
    //   2828: istore 6
    //   2830: goto -781 -> 2049
    //   2833: astore 22
    //   2835: iconst_0
    //   2836: istore 8
    //   2838: ldc 137
    //   2840: new 173	java/lang/StringBuilder
    //   2843: dup
    //   2844: ldc_w 878
    //   2847: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2850: aload 22
    //   2852: invokevirtual 879	java/lang/Exception:toString	()Ljava/lang/String;
    //   2855: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2858: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2861: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2864: iload 8
    //   2866: istore 6
    //   2868: goto -205 -> 2663
    //   2871: ldc 137
    //   2873: ldc_w 881
    //   2876: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2879: iconst_0
    //   2880: istore 6
    //   2882: goto -219 -> 2663
    //   2885: iconst_2
    //   2886: istore 8
    //   2888: goto -215 -> 2673
    //   2891: astore 22
    //   2893: ldc_w 872
    //   2896: new 173	java/lang/StringBuilder
    //   2899: dup
    //   2900: ldc_w 883
    //   2903: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2906: aload 22
    //   2908: invokevirtual 879	java/lang/Exception:toString	()Ljava/lang/String;
    //   2911: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2917: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2920: iconst_5
    //   2921: istore 6
    //   2923: goto -874 -> 2049
    //   2926: iconst_4
    //   2927: istore 6
    //   2929: ldc_w 660
    //   2932: astore 18
    //   2934: goto -885 -> 2049
    //   2937: aload 24
    //   2939: invokevirtual 886	com/tencent/mm/plugin/sns/storage/SnsInfo:isFinderTopicCardAd	()Z
    //   2942: ifeq +15 -> 2957
    //   2945: bipush 9
    //   2947: istore 6
    //   2949: ldc_w 660
    //   2952: astore 18
    //   2954: goto -905 -> 2049
    //   2957: aload 26
    //   2959: invokevirtual 889	com/tencent/mm/plugin/sns/storage/ADXml:isSlideFullCard	()Z
    //   2962: ifeq +15 -> 2977
    //   2965: bipush 10
    //   2967: istore 6
    //   2969: ldc_w 660
    //   2972: astore 18
    //   2974: goto -925 -> 2049
    //   2977: aload 25
    //   2979: getfield 892	com/tencent/mm/plugin/sns/ad/g/l$a:viewType	I
    //   2982: bipush 9
    //   2984: if_icmpeq +13 -> 2997
    //   2987: aload 25
    //   2989: getfield 892	com/tencent/mm/plugin/sns/ad/g/l$a:viewType	I
    //   2992: bipush 19
    //   2994: if_icmpne +65 -> 3059
    //   2997: iconst_2
    //   2998: istore 6
    //   3000: aload_0
    //   3001: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   3004: aload 25
    //   3006: getfield 796	com/tencent/mm/plugin/sns/ad/g/l$a:PVd	J
    //   3009: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3012: invokeinterface 169 2 0
    //   3017: checkcast 362	com/tencent/mm/plugin/sns/ad/g/m
    //   3020: astore 22
    //   3022: aload 22
    //   3024: ifnull +16 -> 3040
    //   3027: aload 22
    //   3029: iconst_0
    //   3030: invokevirtual 365	com/tencent/mm/plugin/sns/ad/g/m:ajw	(I)V
    //   3033: aload 22
    //   3035: invokevirtual 802	com/tencent/mm/plugin/sns/ad/g/m:hbj	()Ljava/lang/String;
    //   3038: astore 18
    //   3040: aload_0
    //   3041: getfield 99	com/tencent/mm/plugin/sns/ad/g/l:PVM	Ljava/util/HashSet;
    //   3044: aload 25
    //   3046: getfield 796	com/tencent/mm/plugin/sns/ad/g/l$a:PVd	J
    //   3049: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3052: invokevirtual 384	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   3055: pop
    //   3056: goto -1007 -> 2049
    //   3059: iconst_1
    //   3060: istore 6
    //   3062: ldc_w 660
    //   3065: astore 18
    //   3067: goto -1018 -> 2049
    //   3070: aload 26
    //   3072: getfield 895	com/tencent/mm/plugin/sns/storage/ADInfo:waidPkg	Ljava/lang/String;
    //   3075: astore 22
    //   3077: goto -1010 -> 2067
    //   3080: iconst_0
    //   3081: istore_1
    //   3082: goto -982 -> 2100
    //   3085: iconst_0
    //   3086: istore_1
    //   3087: goto -916 -> 2171
    //   3090: astore_2
    //   3091: ldc 137
    //   3093: new 173	java/lang/StringBuilder
    //   3096: dup
    //   3097: ldc_w 897
    //   3100: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3103: aload_2
    //   3104: invokevirtual 184	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3107: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3113: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3116: ldc_w 377
    //   3119: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3122: return
    //   3123: ldc 137
    //   3125: new 173	java/lang/StringBuilder
    //   3128: dup
    //   3129: ldc_w 899
    //   3132: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3135: iload_1
    //   3136: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3139: ldc_w 682
    //   3142: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: aload_2
    //   3146: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: ldc_w 684
    //   3152: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3155: lload_3
    //   3156: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   3159: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3162: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3165: invokestatic 902	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   3168: ldc_w 377
    //   3171: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3174: return
    //   3175: astore 22
    //   3177: iload 6
    //   3179: istore 7
    //   3181: goto -343 -> 2838
    //   3184: ldc_w 660
    //   3187: astore 18
    //   3189: goto -685 -> 2504
    //   3192: ldc_w 660
    //   3195: astore 18
    //   3197: goto -779 -> 2418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3200	0	this	l
    //   0	3200	1	paramInt1	int
    //   0	3200	2	paramString	String
    //   0	3200	3	paramLong	long
    //   0	3200	5	paramInt2	int
    //   1154	2024	6	i	int
    //   1134	2046	7	j	int
    //   1469	1418	8	k	int
    //   1306	982	9	m	int
    //   2572	73	10	n	int
    //   31	2228	11	l1	long
    //   1475	168	13	l2	long
    //   1472	162	15	l3	long
    //   1979	31	17	bool	boolean
    //   47	3149	18	localObject1	Object
    //   73	2191	19	localObject2	Object
    //   69	2193	20	localObject3	Object
    //   50	2204	21	str	String
    //   1573	1238	22	localObject4	Object
    //   2833	18	22	localException1	java.lang.Exception
    //   2891	16	22	localException2	java.lang.Exception
    //   3020	56	22	localObject5	Object
    //   3175	1	22	localException3	java.lang.Exception
    //   65	2030	23	localc	c
    //   1318	1620	24	localSnsInfo	SnsInfo
    //   1821	1224	25	locala	a
    //   2031	1040	26	localObject6	Object
    //   2074	230	27	localb	b
    // Exception table:
    //   from	to	target	type
    //   2562	2574	2833	java/lang/Exception
    //   2578	2593	2833	java/lang/Exception
    //   2597	2604	2833	java/lang/Exception
    //   2608	2615	2833	java/lang/Exception
    //   2673	2827	2891	java/lang/Exception
    //   2325	2338	3090	finally
    //   2343	2351	3090	finally
    //   2615	2655	3175	java/lang/Exception
  }
  
  /* Error */
  public final void a(int paramInt1, String paramString, boolean paramBoolean, View paramView, long paramLong, com.tencent.mm.protocal.protobuf.SnsObject paramSnsObject, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 904
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 91	com/tencent/mm/plugin/sns/ad/g/l:PVI	Ljava/util/HashSet;
    //   10: lload 5
    //   12: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: invokevirtual 907	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: getfield 86	com/tencent/mm/plugin/sns/ad/g/l:PVH	Ljava/util/HashMap;
    //   23: aload_2
    //   24: lload 5
    //   26: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: invokevirtual 908	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: pop
    //   33: aload_0
    //   34: getfield 125	com/tencent/mm/plugin/sns/ad/g/l:vpn	I
    //   37: iconst_m1
    //   38: if_icmpne +19 -> 57
    //   41: aload_0
    //   42: getfield 129	com/tencent/mm/plugin/sns/ad/g/l:activity	Landroid/app/Activity;
    //   45: ifnonnull +69 -> 114
    //   48: iconst_m1
    //   49: istore 10
    //   51: aload_0
    //   52: iload 10
    //   54: putfield 125	com/tencent/mm/plugin/sns/ad/g/l:vpn	I
    //   57: invokestatic 584	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   60: aload_2
    //   61: invokevirtual 590	com/tencent/mm/plugin/sns/storage/w:aZL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   64: astore 15
    //   66: aload 15
    //   68: ifnonnull +58 -> 126
    //   71: ldc 137
    //   73: new 173	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 910
    //   80: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: lload 5
    //   85: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   88: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 912
    //   94: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 902	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: ldc_w 904
    //   110: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: aload_0
    //   115: getfield 129	com/tencent/mm/plugin/sns/ad/g/l:activity	Landroid/app/Activity;
    //   118: invokestatic 918	com/tencent/mm/ui/aw:mL	(Landroid/content/Context;)I
    //   121: istore 10
    //   123: goto -72 -> 51
    //   126: aload_0
    //   127: getfield 97	com/tencent/mm/plugin/sns/ad/g/l:PVL	Ljava/util/Map;
    //   130: aload_2
    //   131: invokeinterface 289 2 0
    //   136: checkcast 267	com/tencent/mm/plugin/sns/ad/g/c
    //   139: astore 14
    //   141: aload_0
    //   142: aload 15
    //   144: invokespecial 662	com/tencent/mm/plugin/sns/ad/g/l:j	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   147: astore 16
    //   149: aload 16
    //   151: ifnull +1452 -> 1603
    //   154: aload 16
    //   156: getfield 667	com/tencent/mm/plugin/sns/storage/ADInfo:viewId	Ljava/lang/String;
    //   159: astore 13
    //   161: aload 14
    //   163: ifnonnull +1433 -> 1596
    //   166: aload 4
    //   168: ifnull +1428 -> 1596
    //   171: getstatic 273	com/tencent/mm/plugin/sns/model/al:Qus	Z
    //   174: ifeq +1422 -> 1596
    //   177: new 267	com/tencent/mm/plugin/sns/ad/g/c
    //   180: dup
    //   181: aload 16
    //   183: aload_2
    //   184: lload 5
    //   186: aload 4
    //   188: aload_0
    //   189: getfield 115	com/tencent/mm/plugin/sns/ad/g/l:CCP	I
    //   192: aload_0
    //   193: getfield 117	com/tencent/mm/plugin/sns/ad/g/l:PVT	Landroid/view/View;
    //   196: aload_0
    //   197: getfield 125	com/tencent/mm/plugin/sns/ad/g/l:vpn	I
    //   200: iload 9
    //   202: aload 7
    //   204: iload_1
    //   205: aload 15
    //   207: invokevirtual 693	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   210: invokespecial 921	com/tencent/mm/plugin/sns/ad/g/c:<init>	(Lcom/tencent/mm/plugin/sns/storage/ADInfo;Ljava/lang/String;JLandroid/view/View;ILandroid/view/View;IILcom/tencent/mm/protocal/protobuf/SnsObject;ILcom/tencent/mm/plugin/sns/storage/ADXml;)V
    //   213: astore 7
    //   215: aload 7
    //   217: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   220: putfield 442	com/tencent/mm/plugin/sns/ad/g/c:PVk	J
    //   223: invokestatic 925	com/tencent/mm/plugin/sns/model/al:fAG	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   226: new 927	com/tencent/mm/plugin/sns/ad/g/c$1
    //   229: dup
    //   230: aload 7
    //   232: invokespecial 930	com/tencent/mm/plugin/sns/ad/g/c$1:<init>	(Lcom/tencent/mm/plugin/sns/ad/g/c;)V
    //   235: invokevirtual 936	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   238: pop
    //   239: aload_0
    //   240: getfield 97	com/tencent/mm/plugin/sns/ad/g/l:PVL	Ljava/util/Map;
    //   243: aload_2
    //   244: aload 7
    //   246: invokeinterface 369 3 0
    //   251: pop
    //   252: aload 7
    //   254: astore 4
    //   256: aload_0
    //   257: getfield 119	com/tencent/mm/plugin/sns/ad/g/l:PVU	Ljava/util/Map;
    //   260: lload 5
    //   262: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   265: invokeinterface 360 2 0
    //   270: ifne +43 -> 313
    //   273: aload_0
    //   274: getfield 119	com/tencent/mm/plugin/sns/ad/g/l:PVU	Ljava/util/Map;
    //   277: astore 4
    //   279: aload 15
    //   281: invokevirtual 799	com/tencent/mm/plugin/sns/storage/SnsInfo:getLikeFlag	()I
    //   284: iconst_1
    //   285: if_icmpne +355 -> 640
    //   288: iconst_1
    //   289: istore 10
    //   291: aload 4
    //   293: lload 5
    //   295: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   298: iload 10
    //   300: invokestatic 939	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: invokeinterface 369 3 0
    //   308: pop
    //   309: aload 7
    //   311: astore 4
    //   313: iload 8
    //   315: bipush 11
    //   317: if_icmpne +82 -> 399
    //   320: aload 15
    //   322: invokevirtual 597	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   325: getfield 603	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   328: getfield 942	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   331: invokevirtual 820	java/util/LinkedList:size	()I
    //   334: iconst_1
    //   335: if_icmple +64 -> 399
    //   338: aload_0
    //   339: getfield 103	com/tencent/mm/plugin/sns/ad/g/l:PVO	Ljava/util/Map;
    //   342: lload 5
    //   344: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   347: invokeinterface 360 2 0
    //   352: ifeq +294 -> 646
    //   355: aload_0
    //   356: getfield 103	com/tencent/mm/plugin/sns/ad/g/l:PVO	Ljava/util/Map;
    //   359: lload 5
    //   361: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   364: invokeinterface 289 2 0
    //   369: checkcast 362	com/tencent/mm/plugin/sns/ad/g/m
    //   372: astore 7
    //   374: aload 7
    //   376: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   379: putfield 945	com/tencent/mm/plugin/sns/ad/g/m:PWp	J
    //   382: aload_0
    //   383: getfield 103	com/tencent/mm/plugin/sns/ad/g/l:PVO	Ljava/util/Map;
    //   386: lload 5
    //   388: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   391: aload 7
    //   393: invokeinterface 369 3 0
    //   398: pop
    //   399: aload_0
    //   400: getfield 123	com/tencent/mm/plugin/sns/ad/g/l:PVW	Ljava/util/HashSet;
    //   403: aload_2
    //   404: invokevirtual 948	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   407: ifne +101 -> 508
    //   410: aload_0
    //   411: getfield 123	com/tencent/mm/plugin/sns/ad/g/l:PVW	Ljava/util/HashSet;
    //   414: aload_2
    //   415: invokevirtual 907	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   418: pop
    //   419: aload 15
    //   421: invokestatic 954	com/tencent/mm/plugin/sns/ad/d/j:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   424: aload 15
    //   426: aload_0
    //   427: getfield 109	com/tencent/mm/plugin/sns/ad/g/l:source	I
    //   430: invokevirtual 957	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfo	(I)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   433: astore 7
    //   435: aload 15
    //   437: invokestatic 963	com/tencent/mm/plugin/sns/model/ap:E	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   440: astore 14
    //   442: aload 15
    //   444: getfield 593	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   447: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   450: aload 7
    //   452: aload 14
    //   454: invokestatic 968	com/tencent/mm/plugin/sns/ad/timeline/helper/e:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/ADInfo;Lcom/tencent/mm/protocal/protobuf/SnsObject;)V
    //   457: invokestatic 974	com/tencent/mm/plugin/sns/ad/c/a:gZF	()Lcom/tencent/mm/plugin/sns/ad/c/a;
    //   460: astore 7
    //   462: aload_0
    //   463: getfield 109	com/tencent/mm/plugin/sns/ad/g/l:source	I
    //   466: istore 10
    //   468: aload 7
    //   470: getfield 978	com/tencent/mm/plugin/sns/ad/c/a:PNC	Lcom/tencent/mm/plugin/sns/ad/c/a/c;
    //   473: astore 14
    //   475: aload 15
    //   477: ifnonnull +199 -> 676
    //   480: aconst_null
    //   481: astore 7
    //   483: aload 14
    //   485: aload 7
    //   487: invokevirtual 983	com/tencent/mm/plugin/sns/ad/c/a/c:b	(Lcom/tencent/mm/plugin/sns/ad/c/a/c$b;)V
    //   490: aload 15
    //   492: aload_0
    //   493: getfield 109	com/tencent/mm/plugin/sns/ad/g/l:source	I
    //   496: invokestatic 988	com/tencent/mm/plugin/sns/ad/d/o:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
    //   499: aload 15
    //   501: aload_0
    //   502: getfield 109	com/tencent/mm/plugin/sns/ad/g/l:source	I
    //   505: invokestatic 990	com/tencent/mm/plugin/sns/ad/d/o:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
    //   508: aload_0
    //   509: getfield 93	com/tencent/mm/plugin/sns/ad/g/l:PVJ	Ljava/util/Map;
    //   512: aload_2
    //   513: invokeinterface 360 2 0
    //   518: ifeq +203 -> 721
    //   521: aload_0
    //   522: getfield 93	com/tencent/mm/plugin/sns/ad/g/l:PVJ	Ljava/util/Map;
    //   525: aload_2
    //   526: invokeinterface 289 2 0
    //   531: checkcast 353	java/lang/Long
    //   534: invokevirtual 382	java/lang/Long:longValue	()J
    //   537: invokestatic 317	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   540: lstore 11
    //   542: lload 11
    //   544: ldc2_w 991
    //   547: lcmp
    //   548: ifge +719 -> 1267
    //   551: aload_0
    //   552: getfield 95	com/tencent/mm/plugin/sns/ad/g/l:PVK	Ljava/util/Map;
    //   555: aload_2
    //   556: invokeinterface 360 2 0
    //   561: ifeq +136 -> 697
    //   564: aload_0
    //   565: getfield 95	com/tencent/mm/plugin/sns/ad/g/l:PVK	Ljava/util/Map;
    //   568: aload_2
    //   569: invokeinterface 289 2 0
    //   574: checkcast 613	java/lang/Integer
    //   577: invokevirtual 616	java/lang/Integer:intValue	()I
    //   580: istore 10
    //   582: iload 10
    //   584: bipush 100
    //   586: if_icmplt +117 -> 703
    //   589: ldc 137
    //   591: new 173	java/lang/StringBuilder
    //   594: dup
    //   595: ldc_w 994
    //   598: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   601: aload_2
    //   602: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: ldc_w 996
    //   608: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 13
    //   613: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: ldc_w 998
    //   619: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: lload 11
    //   624: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   627: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: ldc_w 904
    //   636: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   639: return
    //   640: iconst_0
    //   641: istore 10
    //   643: goto -352 -> 291
    //   646: new 362	com/tencent/mm/plugin/sns/ad/g/m
    //   649: dup
    //   650: ldc_w 371
    //   653: invokespecial 372	com/tencent/mm/plugin/sns/ad/g/m:<init>	(Ljava/lang/String;)V
    //   656: astore 7
    //   658: goto -284 -> 374
    //   661: astore 7
    //   663: ldc 137
    //   665: aload 7
    //   667: invokevirtual 184	java/lang/Throwable:toString	()Ljava/lang/String;
    //   670: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: goto -216 -> 457
    //   676: aload 14
    //   678: new 1000	com/tencent/mm/plugin/sns/ad/c/a/c$b
    //   681: dup
    //   682: aload 15
    //   684: iload 10
    //   686: invokespecial 1002	com/tencent/mm/plugin/sns/ad/c/a/c$b:<init>	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
    //   689: invokevirtual 1005	com/tencent/mm/plugin/sns/ad/c/a/c:a	(Lcom/tencent/mm/plugin/sns/ad/c/a/c$b;)Lcom/tencent/mm/plugin/sns/ad/c/a/c$b;
    //   692: astore 7
    //   694: goto -211 -> 483
    //   697: iconst_0
    //   698: istore 10
    //   700: goto -118 -> 582
    //   703: aload_0
    //   704: getfield 95	com/tencent/mm/plugin/sns/ad/g/l:PVK	Ljava/util/Map;
    //   707: aload_2
    //   708: iload 10
    //   710: iconst_1
    //   711: iadd
    //   712: invokestatic 939	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   715: invokeinterface 369 3 0
    //   720: pop
    //   721: aload_0
    //   722: getfield 107	com/tencent/mm/plugin/sns/ad/g/l:PVQ	Ljava/util/Map;
    //   725: aload_2
    //   726: invokeinterface 360 2 0
    //   731: ifne +529 -> 1260
    //   734: aload_0
    //   735: getfield 107	com/tencent/mm/plugin/sns/ad/g/l:PVQ	Ljava/util/Map;
    //   738: aload_2
    //   739: new 24	com/tencent/mm/plugin/sns/ad/g/l$a
    //   742: dup
    //   743: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   746: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   749: aload_2
    //   750: iload_1
    //   751: aload 13
    //   753: iload 8
    //   755: lload 5
    //   757: iload 9
    //   759: invokespecial 1008	com/tencent/mm/plugin/sns/ad/g/l$a:<init>	(JJLjava/lang/String;ILjava/lang/String;IJI)V
    //   762: invokeinterface 369 3 0
    //   767: pop
    //   768: ldc 137
    //   770: new 173	java/lang/StringBuilder
    //   773: dup
    //   774: ldc_w 1010
    //   777: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   780: iload_1
    //   781: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: ldc_w 682
    //   787: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload_2
    //   791: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: ldc_w 1012
    //   797: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: iload_3
    //   801: invokevirtual 689	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   804: ldc_w 684
    //   807: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: lload 5
    //   812: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   815: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: ldc_w 1014
    //   821: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: iload 9
    //   826: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   829: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: iload 8
    //   837: bipush 9
    //   839: if_icmpeq +25 -> 864
    //   842: iload 8
    //   844: bipush 13
    //   846: if_icmpeq +18 -> 864
    //   849: iload 8
    //   851: invokestatic 1020	com/tencent/mm/plugin/sns/ui/item/a/a/b:amu	(I)Z
    //   854: ifne +10 -> 864
    //   857: iload 8
    //   859: bipush 19
    //   861: if_icmpne +456 -> 1317
    //   864: aload_0
    //   865: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   868: lload 5
    //   870: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   873: invokeinterface 360 2 0
    //   878: ifeq +424 -> 1302
    //   881: aload_0
    //   882: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   885: lload 5
    //   887: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   890: invokeinterface 289 2 0
    //   895: checkcast 362	com/tencent/mm/plugin/sns/ad/g/m
    //   898: astore 7
    //   900: aload 7
    //   902: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   905: putfield 945	com/tencent/mm/plugin/sns/ad/g/m:PWp	J
    //   908: aload_0
    //   909: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   912: lload 5
    //   914: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   917: aload 7
    //   919: invokeinterface 369 3 0
    //   924: pop
    //   925: aload_0
    //   926: getfield 111	com/tencent/mm/plugin/sns/ad/g/l:PVR	Ljava/util/Map;
    //   929: aload_2
    //   930: invokeinterface 360 2 0
    //   935: ifne +76 -> 1011
    //   938: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   941: ldc2_w 629
    //   944: ldiv
    //   945: l2i
    //   946: istore 10
    //   948: aload_0
    //   949: getfield 111	com/tencent/mm/plugin/sns/ad/g/l:PVR	Ljava/util/Map;
    //   952: aload_2
    //   953: iload 10
    //   955: invokestatic 939	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   958: invokeinterface 369 3 0
    //   963: pop
    //   964: ldc 137
    //   966: new 173	java/lang/StringBuilder
    //   969: dup
    //   970: ldc_w 1022
    //   973: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   976: aload_2
    //   977: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: ldc_w 684
    //   983: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: lload 5
    //   988: invokestatic 422	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
    //   991: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: ldc_w 1024
    //   997: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: iload 10
    //   1002: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: aload 15
    //   1013: invokevirtual 693	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   1016: astore 14
    //   1018: aload 15
    //   1020: invokevirtual 597	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1023: astore 17
    //   1025: aconst_null
    //   1026: astore 7
    //   1028: aload 7
    //   1030: astore_2
    //   1031: aload 4
    //   1033: ifnull +18 -> 1051
    //   1036: aload 7
    //   1038: astore_2
    //   1039: getstatic 273	com/tencent/mm/plugin/sns/model/al:Qus	Z
    //   1042: ifeq +9 -> 1051
    //   1045: aload 4
    //   1047: invokevirtual 580	com/tencent/mm/plugin/sns/ad/g/c:hbg	()Lcom/tencent/mm/protocal/protobuf/cn;
    //   1050: astore_2
    //   1051: aload 15
    //   1053: invokevirtual 211	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdSnsInfo	()Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
    //   1056: astore 7
    //   1058: iconst_0
    //   1059: istore 10
    //   1061: aload_0
    //   1062: getfield 109	com/tencent/mm/plugin/sns/ad/g/l:source	I
    //   1065: ifne +32 -> 1097
    //   1068: aload 7
    //   1070: getfield 1027	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_exposureCount	I
    //   1073: iconst_1
    //   1074: iadd
    //   1075: istore 10
    //   1077: aload 7
    //   1079: iload 10
    //   1081: putfield 1027	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_exposureCount	I
    //   1084: invokestatic 1031	com/tencent/mm/plugin/sns/model/al:hgE	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   1087: aload 7
    //   1089: iconst_0
    //   1090: anewarray 141	java/lang/String
    //   1093: invokevirtual 1037	com/tencent/mm/plugin/sns/storage/f:update	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   1096: pop
    //   1097: aload 16
    //   1099: ifnonnull +353 -> 1452
    //   1102: ldc_w 660
    //   1105: astore 7
    //   1107: new 698	com/tencent/mm/plugin/sns/ad/g/b
    //   1110: dup
    //   1111: invokespecial 699	com/tencent/mm/plugin/sns/ad/g/b:<init>	()V
    //   1114: astore 18
    //   1116: aload 18
    //   1118: iload_1
    //   1119: putfield 702	com/tencent/mm/plugin/sns/ad/g/b:PUR	I
    //   1122: aload 18
    //   1124: aload 15
    //   1126: putfield 706	com/tencent/mm/plugin/sns/ad/g/b:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   1129: aload 4
    //   1131: ifnull +331 -> 1462
    //   1134: aload 4
    //   1136: getfield 709	com/tencent/mm/plugin/sns/ad/g/c:mbN	I
    //   1139: istore_1
    //   1140: aload 18
    //   1142: iload_1
    //   1143: putfield 712	com/tencent/mm/plugin/sns/ad/g/b:PUS	I
    //   1146: aload 16
    //   1148: ifnull +49 -> 1197
    //   1151: aload 16
    //   1153: invokevirtual 721	com/tencent/mm/plugin/sns/storage/ADInfo:isWeapp	()Z
    //   1156: ifeq +41 -> 1197
    //   1159: aload 15
    //   1161: invokevirtual 724	com/tencent/mm/plugin/sns/storage/SnsInfo:isFullCardAd	()Z
    //   1164: ifne +33 -> 1197
    //   1167: aload 15
    //   1169: invokevirtual 727	com/tencent/mm/plugin/sns/storage/SnsInfo:isSlideFullCardAd	()Z
    //   1172: ifne +25 -> 1197
    //   1175: aload 16
    //   1177: getfield 731	com/tencent/mm/plugin/sns/storage/ADInfo:actionExtWeApp	Lcom/tencent/mm/plugin/sns/storage/ADInfo$b;
    //   1180: getfield 736	com/tencent/mm/plugin/sns/storage/ADInfo$b:appUserName	Ljava/lang/String;
    //   1183: invokestatic 741	com/tencent/mm/plugin/sns/ad/d/i:aWm	(Ljava/lang/String;)Z
    //   1186: ifeq +281 -> 1467
    //   1189: iconst_1
    //   1190: istore_1
    //   1191: aload 18
    //   1193: iload_1
    //   1194: putfield 744	com/tencent/mm/plugin/sns/ad/g/b:PUQ	I
    //   1197: aload 14
    //   1199: invokevirtual 696	com/tencent/mm/plugin/sns/storage/ADXml:isLinkAd	()Z
    //   1202: ifeq +270 -> 1472
    //   1205: iconst_3
    //   1206: istore_1
    //   1207: new 752	com/tencent/mm/plugin/sns/ad/g/g
    //   1210: dup
    //   1211: aload 13
    //   1213: iload 9
    //   1215: aload_2
    //   1216: iload_1
    //   1217: iload 10
    //   1219: aload 15
    //   1221: invokevirtual 755	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdRecSrc	()I
    //   1224: aload_0
    //   1225: aload 15
    //   1227: invokespecial 757	com/tencent/mm/plugin/sns/ad/g/l:k	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/bx/b;
    //   1230: aload_0
    //   1231: aload 15
    //   1233: invokespecial 759	com/tencent/mm/plugin/sns/ad/g/l:l	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/bx/b;
    //   1236: aload 7
    //   1238: aload 18
    //   1240: invokespecial 1040	com/tencent/mm/plugin/sns/ad/g/g:<init>	(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/cn;IIILcom/tencent/mm/bx/b;Lcom/tencent/mm/bx/b;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/ad/g/b;)V
    //   1243: astore_2
    //   1244: invokestatic 768	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1247: pop
    //   1248: invokestatic 772	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1251: getfield 778	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1254: aload_2
    //   1255: iconst_0
    //   1256: invokevirtual 783	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   1259: pop
    //   1260: ldc_w 904
    //   1263: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1266: return
    //   1267: aload_0
    //   1268: getfield 93	com/tencent/mm/plugin/sns/ad/g/l:PVJ	Ljava/util/Map;
    //   1271: aload_2
    //   1272: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1275: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1278: invokeinterface 369 3 0
    //   1283: pop
    //   1284: aload_0
    //   1285: getfield 95	com/tencent/mm/plugin/sns/ad/g/l:PVK	Ljava/util/Map;
    //   1288: aload_2
    //   1289: iconst_0
    //   1290: invokestatic 939	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1293: invokeinterface 369 3 0
    //   1298: pop
    //   1299: goto -578 -> 721
    //   1302: new 362	com/tencent/mm/plugin/sns/ad/g/m
    //   1305: dup
    //   1306: ldc_w 371
    //   1309: invokespecial 372	com/tencent/mm/plugin/sns/ad/g/m:<init>	(Ljava/lang/String;)V
    //   1312: astore 7
    //   1314: goto -414 -> 900
    //   1317: iload 8
    //   1319: bipush 11
    //   1321: if_icmpne -396 -> 925
    //   1324: aload 15
    //   1326: invokevirtual 597	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1329: getfield 603	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   1332: getfield 942	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   1335: invokevirtual 820	java/util/LinkedList:size	()I
    //   1338: ifle -413 -> 925
    //   1341: aload 15
    //   1343: invokevirtual 597	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1346: getfield 603	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   1349: getfield 942	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
    //   1352: iconst_0
    //   1353: invokevirtual 823	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   1356: checkcast 1042	com/tencent/mm/protocal/protobuf/dmz
    //   1359: getfield 1045	com/tencent/mm/protocal/protobuf/dmz:vhJ	I
    //   1362: bipush 6
    //   1364: if_icmpne -439 -> 925
    //   1367: aload_0
    //   1368: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   1371: lload 5
    //   1373: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1376: invokeinterface 360 2 0
    //   1381: ifeq +56 -> 1437
    //   1384: aload_0
    //   1385: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   1388: lload 5
    //   1390: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1393: invokeinterface 289 2 0
    //   1398: checkcast 362	com/tencent/mm/plugin/sns/ad/g/m
    //   1401: astore 7
    //   1403: aload 7
    //   1405: invokestatic 300	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1408: putfield 945	com/tencent/mm/plugin/sns/ad/g/m:PWp	J
    //   1411: aload 7
    //   1413: iconst_1
    //   1414: putfield 1048	com/tencent/mm/plugin/sns/ad/g/m:PWu	Z
    //   1417: aload_0
    //   1418: getfield 101	com/tencent/mm/plugin/sns/ad/g/l:PVN	Ljava/util/Map;
    //   1421: lload 5
    //   1423: invokestatic 356	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1426: aload 7
    //   1428: invokeinterface 369 3 0
    //   1433: pop
    //   1434: goto -509 -> 925
    //   1437: new 362	com/tencent/mm/plugin/sns/ad/g/m
    //   1440: dup
    //   1441: ldc_w 371
    //   1444: invokespecial 372	com/tencent/mm/plugin/sns/ad/g/m:<init>	(Ljava/lang/String;)V
    //   1447: astore 7
    //   1449: goto -46 -> 1403
    //   1452: aload 16
    //   1454: getfield 895	com/tencent/mm/plugin/sns/storage/ADInfo:waidPkg	Ljava/lang/String;
    //   1457: astore 7
    //   1459: goto -352 -> 1107
    //   1462: iconst_0
    //   1463: istore_1
    //   1464: goto -324 -> 1140
    //   1467: iconst_0
    //   1468: istore_1
    //   1469: goto -278 -> 1191
    //   1472: aload 15
    //   1474: invokevirtual 795	com/tencent/mm/plugin/sns/storage/SnsInfo:isTurnCardAd	()Z
    //   1477: ifeq +9 -> 1486
    //   1480: bipush 6
    //   1482: istore_1
    //   1483: goto -276 -> 1207
    //   1486: aload 15
    //   1488: invokevirtual 805	com/tencent/mm/plugin/sns/storage/SnsInfo:isCardAd	()Z
    //   1491: ifne +11 -> 1502
    //   1494: aload 15
    //   1496: invokevirtual 724	com/tencent/mm/plugin/sns/storage/SnsInfo:isFullCardAd	()Z
    //   1499: ifeq +40 -> 1539
    //   1502: aload 17
    //   1504: ifnull +30 -> 1534
    //   1507: aload 17
    //   1509: getfield 603	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   1512: getfield 608	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   1515: bipush 15
    //   1517: if_icmpne +17 -> 1534
    //   1520: aload 17
    //   1522: getfield 808	com/tencent/mm/protocal/protobuf/TimeLineObject:sightFolded	I
    //   1525: iconst_1
    //   1526: if_icmpeq +8 -> 1534
    //   1529: iconst_5
    //   1530: istore_1
    //   1531: goto -324 -> 1207
    //   1534: iconst_4
    //   1535: istore_1
    //   1536: goto -329 -> 1207
    //   1539: aload 15
    //   1541: invokevirtual 886	com/tencent/mm/plugin/sns/storage/SnsInfo:isFinderTopicCardAd	()Z
    //   1544: ifeq +9 -> 1553
    //   1547: bipush 9
    //   1549: istore_1
    //   1550: goto -343 -> 1207
    //   1553: aload 14
    //   1555: invokevirtual 889	com/tencent/mm/plugin/sns/storage/ADXml:isSlideFullCard	()Z
    //   1558: ifeq +9 -> 1567
    //   1561: bipush 10
    //   1563: istore_1
    //   1564: goto -357 -> 1207
    //   1567: iload 8
    //   1569: bipush 9
    //   1571: if_icmpeq +10 -> 1581
    //   1574: iload 8
    //   1576: bipush 19
    //   1578: if_icmpne +8 -> 1586
    //   1581: iconst_2
    //   1582: istore_1
    //   1583: goto -376 -> 1207
    //   1586: iconst_1
    //   1587: istore_1
    //   1588: goto -381 -> 1207
    //   1591: astore 7
    //   1593: goto -1103 -> 490
    //   1596: aload 14
    //   1598: astore 4
    //   1600: goto -1287 -> 313
    //   1603: ldc_w 660
    //   1606: astore 13
    //   1608: goto -1447 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1611	0	this	l
    //   0	1611	1	paramInt1	int
    //   0	1611	2	paramString	String
    //   0	1611	3	paramBoolean	boolean
    //   0	1611	4	paramView	View
    //   0	1611	5	paramLong	long
    //   0	1611	7	paramSnsObject	com.tencent.mm.protocal.protobuf.SnsObject
    //   0	1611	8	paramInt2	int
    //   0	1611	9	paramInt3	int
    //   49	1169	10	i	int
    //   540	83	11	l	long
    //   159	1448	13	str	String
    //   139	1458	14	localObject	Object
    //   64	1476	15	localSnsInfo	SnsInfo
    //   147	1306	16	localADInfo	ADInfo
    //   1023	498	17	localTimeLineObject	com.tencent.mm.protocal.protobuf.TimeLineObject
    //   1114	125	18	localb	b
    // Exception table:
    //   from	to	target	type
    //   424	457	661	finally
    //   468	475	1591	finally
    //   483	490	1591	finally
    //   676	694	1591	finally
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(310263);
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        Log.d("MicroMsg.SnsAdStatistic", "the key or listener is null");
        AppMethodBeat.o(310263);
        return;
      }
      this.PVP.put(paramString, paramd);
      AppMethodBeat.o(310263);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SnsAdStatistic", "addAdRemovedListener exp= " + paramString.toString());
      AppMethodBeat.o(310263);
    }
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95002);
    m localm;
    if (paramBoolean2) {
      if (this.PVO.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.PVO.get(Long.valueOf(paramLong));
        Log.d("MicroMsg.SnsAdStatistic", "snsId=" + t.uA(paramLong) + ", duration=" + paramInt);
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
      localm.PWn = paramInt;
      if (!paramBoolean2) {
        break label203;
      }
      this.PVO.put(Long.valueOf(paramLong), localm);
      AppMethodBeat.o(95002);
      return;
      localm = new m("timeline");
      break;
      if (this.PVN.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.PVN.get(Long.valueOf(paramLong));
        break;
      }
      localm = new m("timeline");
      break;
    }
    label203:
    this.PVN.put(Long.valueOf(paramLong), localm);
    AppMethodBeat.o(95002);
  }
  
  public final void bi(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(95005);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94992);
        if (l.this.up(paramLong1))
        {
          l locall = l.this;
          long l = this.PWb;
          if (!locall.PVM.contains(Long.valueOf(l))) {
            locall.PVM.add(Long.valueOf(l));
          }
        }
        AppMethodBeat.o(94992);
      }
    });
    AppMethodBeat.o(95005);
  }
  
  public final void bj(final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(310244);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309889);
        m localm = (m)l.this.PVN.get(Long.valueOf(paramLong1));
        if (localm != null) {
          localm.PWy = this.PWd;
        }
        AppMethodBeat.o(309889);
      }
    });
    AppMethodBeat.o(310244);
  }
  
  public final void c(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    AppMethodBeat.i(95007);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94993);
        if (l.this.up(paramLong1))
        {
          l locall = l.this;
          long l1 = paramLong1;
          long l2 = paramBoolean;
          boolean bool = this.PVY;
          m localm;
          if (bool) {
            if (locall.PVO.containsKey(Long.valueOf(l1))) {
              localm = (m)locall.PVO.get(Long.valueOf(l1));
            }
          }
          for (;;)
          {
            if (localm.PWv.PXJ == 0L) {
              localm.PWv.PXJ = l2;
            }
            if (!bool) {
              break;
            }
            locall.PVO.put(Long.valueOf(l1), localm);
            AppMethodBeat.o(94993);
            return;
            localm = new m("timeline");
            continue;
            if (locall.PVN.containsKey(Long.valueOf(l1))) {
              localm = (m)locall.PVN.get(Long.valueOf(l1));
            } else {
              localm = new m("timeline");
            }
          }
          locall.PVN.put(Long.valueOf(l1), localm);
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
    Object localObject1 = new HashSet(this.PVQ.keySet()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (a)this.PVQ.get(localObject2);
      a(((a)localObject2).position, ((a)localObject2).icI, ((a)localObject2).PVd, ((a)localObject2).oTO);
    }
    localObject1 = new HashMap(this.PVR);
    al.gHI().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94994);
        Iterator localIterator = this.PWc.keySet().iterator();
        AdSnsInfo localAdSnsInfo;
        SnsInfo localSnsInfo;
        int j;
        int i;
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localAdSnsInfo = al.hgE().alz(ai.bap(str));
          if (localAdSnsInfo != null)
          {
            localSnsInfo = localAdSnsInfo.convertToSnsInfo();
            localAdSnsInfo.setExposures();
            j = 0;
            i = (int)(System.currentTimeMillis() / 1000L);
            if (!this.PWc.containsKey(str)) {
              break label233;
            }
            i = ((Integer)this.PWc.get(str)).intValue();
            j = 1;
          }
        }
        label233:
        for (;;)
        {
          if (localAdSnsInfo.field_exposureTime <= 0)
          {
            localAdSnsInfo.field_exposureTime = i;
            Log.i("MicroMsg.SnsAdStatistic", "update Ad ExposureTime, snsId=" + t.uA(localAdSnsInfo.field_snsId) + ", exposuretime=" + i + "， sys.currentTimeMis=" + System.currentTimeMillis() + ", type=" + j);
          }
          if (localSnsInfo != null) {
            localSnsInfo.setExposures();
          }
          al.hgB().b(localSnsInfo.field_snsId, localSnsInfo);
          al.hgE().b(localAdSnsInfo.field_snsId, localAdSnsInfo);
          break;
          AppMethodBeat.o(94994);
          return;
        }
      }
    });
    this.PVQ.clear();
    this.PVR.clear();
    AppMethodBeat.o(95016);
  }
  
  public final void e(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95004);
    m localm;
    if (paramBoolean2) {
      if (this.PVO.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.PVO.get(Long.valueOf(paramLong));
        if (!paramBoolean1) {
          break label162;
        }
      }
    }
    label162:
    for (localm.PWv.PXH = 2;; localm.PWv.PXH = 1)
    {
      localm.PWv.PXI = 1;
      if (!paramBoolean2) {
        break label174;
      }
      this.PVO.put(Long.valueOf(paramLong), localm);
      AppMethodBeat.o(95004);
      return;
      localm = new m("timeline");
      break;
      if (this.PVN.containsKey(Long.valueOf(paramLong)))
      {
        localm = (m)this.PVN.get(Long.valueOf(paramLong));
        break;
      }
      localm = new m("timeline");
      break;
    }
    label174:
    this.PVN.put(Long.valueOf(paramLong), localm);
    AppMethodBeat.o(95004);
  }
  
  public final void f(final long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(95000);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94991);
        l.this.b(paramLong, this.srg, this.PWa, this.PVY);
        AppMethodBeat.o(94991);
      }
    });
    AppMethodBeat.o(95000);
  }
  
  public final void g(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(309998);
    b(paramLong, paramInt, paramBoolean, false);
    AppMethodBeat.o(309998);
  }
  
  public final long gM(String paramString, int paramInt)
  {
    AppMethodBeat.i(94997);
    c localc = (c)this.PVL.get(paramString);
    if (localc != null) {}
    for (long l = localc.PVk;; l = 0L)
    {
      Log.i("MicroMsg.SnsAdStatistic", "getExposureStartTime, localId=" + paramString + ", clkPos=" + paramInt + ", time=" + l);
      AppMethodBeat.o(94997);
      return l;
    }
  }
  
  public final void hbi()
  {
    AppMethodBeat.i(369989);
    Ds(false);
    AppMethodBeat.o(369989);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(95009);
    Iterator localIterator = this.PVQ.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.PVQ.get(localObject2);
      Log.i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).PWj += Util.ticksToNow(((a)localObject1).PWg);
      ((a)localObject1).PWg = 0L;
      localObject2 = (m)this.PVN.get(Long.valueOf(((a)localObject1).PVd));
      if (localObject2 != null) {
        ((m)localObject2).oTT = Util.currentTicks();
      }
      localObject1 = (m)this.PVO.get(Long.valueOf(((a)localObject1).PVd));
      if (localObject1 != null) {
        ((m)localObject1).oTT = Util.currentTicks();
      }
    }
    localIterator = this.PVL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (al.Qus))
      {
        ((c)localObject1).Dr(false);
        if ((!Util.isNullOrNil(((c)localObject1).hHB)) && (this.PVQ.get(((c)localObject1).hHB) != null))
        {
          localObject2 = (a)this.PVQ.get(((c)localObject1).hHB);
          long l;
          if (((a)localObject2).PWi > 0L)
          {
            l = Util.ticksToNow(((a)localObject2).PWi);
            ((a)localObject2).PWk += l;
            ((a)localObject2).PWi = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).PWk + ", id=" + ((c)localObject1).hHB);
          }
          if (((a)localObject2).PWm > 0L)
          {
            l = Util.ticksToNow(((a)localObject2).PWm);
            ((a)localObject2).PWl += l;
            ((a)localObject2).PWm = 0L;
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime end, duration=" + l + ", total=" + ((a)localObject2).PWl + ", id=" + ((c)localObject1).hHB);
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
    Iterator localIterator = this.PVQ.keySet().iterator();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      localObject1 = (a)this.PVQ.get(localObject2);
      Log.i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(localObject2)));
      ((a)localObject1).PWg = l;
      localObject2 = (m)this.PVN.get(Long.valueOf(((a)localObject1).PVd));
      if (localObject2 != null) {
        ((m)localObject2).onResume();
      }
      localObject1 = (m)this.PVO.get(Long.valueOf(((a)localObject1).PVd));
      if (localObject1 != null) {
        ((m)localObject1).onResume();
      }
    }
    localIterator = this.PVL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (c)((Map.Entry)localIterator.next()).getValue();
      if ((localObject1 != null) && (al.Qus))
      {
        ((c)localObject1).Dr(false);
        if ((!Util.isNullOrNil(((c)localObject1).hHB)) && (this.PVQ.get(((c)localObject1).hHB) != null))
        {
          localObject2 = (a)this.PVQ.get(((c)localObject1).hHB);
          if (((c)localObject1).hbh())
          {
            ((a)localObject2).PWi = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedFullVisibleTime begin, id=" + ((c)localObject1).hHB);
          }
          else if (((c)localObject1).PVE)
          {
            ((a)localObject2).PWm = Util.currentTicks();
            Log.d("MicroMsg.SnsAdStatistic", "feedHalfVisibleTime begin, id=" + ((c)localObject1).hHB);
          }
        }
      }
    }
    AppMethodBeat.o(94998);
  }
  
  public final boolean up(long paramLong)
  {
    AppMethodBeat.i(94995);
    boolean bool = this.PVI.contains(Long.valueOf(paramLong));
    AppMethodBeat.o(94995);
    return bool;
  }
  
  public final boolean uq(long paramLong)
  {
    AppMethodBeat.i(95006);
    if (this.PVM.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95006);
      return true;
    }
    AppMethodBeat.o(95006);
    return false;
  }
  
  public final void ur(long paramLong)
  {
    AppMethodBeat.i(95017);
    int i = 0;
    if (this.PVU.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.PVU.get(Long.valueOf(paramLong))).intValue();
    }
    this.PVU.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95017);
  }
  
  public final void us(long paramLong)
  {
    AppMethodBeat.i(95018);
    int i = 0;
    if (this.PVV.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.PVV.get(Long.valueOf(paramLong))).intValue();
    }
    this.PVV.put(Long.valueOf(paramLong), Integer.valueOf(i + 1));
    AppMethodBeat.o(95018);
  }
  
  public final void ut(final long paramLong)
  {
    AppMethodBeat.i(310225);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309890);
        m localm = (m)l.this.PVN.get(Long.valueOf(paramLong));
        if (localm != null) {
          localm.hbl();
        }
        AppMethodBeat.o(309890);
      }
    });
    AppMethodBeat.o(310225);
  }
  
  public final void uu(final long paramLong)
  {
    AppMethodBeat.i(310235);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309891);
        m localm = (m)l.this.PVN.get(Long.valueOf(paramLong));
        if ((localm != null) && (!l.a(l.this))) {
          localm.gYM();
        }
        AppMethodBeat.o(309891);
      }
    });
    AppMethodBeat.o(310235);
  }
  
  public final long uv(long paramLong)
  {
    AppMethodBeat.i(310253);
    try
    {
      m localm = (m)this.PVN.get(Long.valueOf(paramLong));
      if (localm != null)
      {
        paramLong = localm.PWy;
        AppMethodBeat.o(310253);
        return paramLong;
      }
    }
    finally
    {
      Log.e("MicroMsg.SnsAdStatistic", "getCurPlayTime exp=" + localObject.toString());
      AppMethodBeat.o(310253);
    }
    return 0L;
  }
  
  static final class a
  {
    public long PVd;
    public long PWe;
    public long PWf;
    public long PWg;
    public String PWh;
    public long PWi;
    public long PWj;
    public long PWk;
    public long PWl;
    public long PWm;
    public String icI;
    public int oTO;
    public int position;
    public int viewType;
    
    public a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3, int paramInt3)
    {
      this.PWe = paramLong1;
      this.PWf = paramLong2;
      this.PWg = paramLong1;
      this.icI = paramString1;
      this.position = paramInt1;
      this.PWh = paramString2;
      this.PVd = paramLong3;
      this.viewType = paramInt2;
      this.oTO = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.l
 * JD-Core Version:    0.7.0.1
 */