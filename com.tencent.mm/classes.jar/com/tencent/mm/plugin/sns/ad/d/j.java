package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.m;
import com.tencent.mm.plugin.sns.ad.adxml.o;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.b;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.ADXml.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class j
{
  private static HashSet<String> PNV;
  
  static
  {
    AppMethodBeat.i(310093);
    PNV = new HashSet();
    AppMethodBeat.o(310093);
  }
  
  private static a a(aa paramaa)
  {
    AppMethodBeat.i(310027);
    if ((paramaa instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l))
    {
      paramaa = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l)paramaa;
      if ((paramaa != null) && (!TextUtils.isEmpty(paramaa.username)))
      {
        paramaa = new a(paramaa.username, paramaa.icO, paramaa.PLo);
        AppMethodBeat.o(310027);
        return paramaa;
      }
    }
    AppMethodBeat.o(310027);
    return null;
  }
  
  public static void a(aa paramaa, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(310016);
    Object localObject;
    try
    {
      if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.als(paramaa.type))
      {
        localObject = paramaa.haE();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            a((aa)((Iterator)localObject).next(), paramArrayList);
          }
        }
        localObject = null;
      }
    }
    finally
    {
      Log.e("AdWeAppPreloader", "parseComponentWeAppInfo exp=" + paramaa.toString());
      AppMethodBeat.o(310016);
      return;
    }
    for (;;)
    {
      if ((localObject != null) && (!paramArrayList.contains(localObject))) {
        paramArrayList.add(localObject);
      }
      Log.d("AdWeAppPreloader", "parseComponentWeAppInfo, type=" + paramaa.type + ", subType=" + paramaa.subType + ", size=" + paramArrayList.size());
      AppMethodBeat.o(310016);
      return;
      if ((paramaa instanceof ae)) {
        localObject = a(((ae)paramaa).QLh);
      } else if ((paramaa instanceof f)) {
        localObject = a(((f)paramaa).PRW);
      } else {
        localObject = a(paramaa);
      }
    }
  }
  
  /* Error */
  private static void b(List<a> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: invokeinterface 164 1 0
    //   15: ifeq +16 -> 31
    //   18: ldc 91
    //   20: ldc 166
    //   22: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc 162
    //   27: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: new 117	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 170	java/util/ArrayList:<init>	()V
    //   38: astore 6
    //   40: aload_0
    //   41: invokeinterface 77 1 0
    //   46: astore 7
    //   48: aload 7
    //   50: invokeinterface 83 1 0
    //   55: ifeq +57 -> 112
    //   58: aload 7
    //   60: invokeinterface 87 1 0
    //   65: checkcast 6	com/tencent/mm/plugin/sns/ad/d/j$a
    //   68: astore 8
    //   70: aload 8
    //   72: getfield 173	com/tencent/mm/plugin/sns/ad/d/j$a:PNZ	Ljava/lang/String;
    //   75: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne -30 -> 48
    //   81: aload 6
    //   83: aload 8
    //   85: getfield 173	com/tencent/mm/plugin/sns/ad/d/j$a:PNZ	Ljava/lang/String;
    //   88: invokeinterface 174 2 0
    //   93: ifne -45 -> 48
    //   96: aload 6
    //   98: aload 8
    //   100: getfield 173	com/tencent/mm/plugin/sns/ad/d/j$a:PNZ	Ljava/lang/String;
    //   103: invokeinterface 175 2 0
    //   108: pop
    //   109: goto -61 -> 48
    //   112: ldc 91
    //   114: new 93	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 177
    //   120: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: iload_1
    //   124: invokevirtual 180	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   127: ldc 182
    //   129: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_2
    //   133: invokevirtual 180	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   136: ldc 184
    //   138: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_3
    //   142: invokevirtual 180	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: ldc 186
    //   147: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 6
    //   152: invokestatic 190	com/tencent/mm/plugin/sns/ad/d/j:ku	(Ljava/util/List;)Ljava/lang/String;
    //   155: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iload_3
    //   165: ifeq +50 -> 215
    //   168: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   171: lstore 4
    //   173: ldc 200
    //   175: invokestatic 206	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   178: checkcast 200	com/tencent/mm/plugin/appbrand/service/g
    //   181: getstatic 212	com/tencent/mm/plugin/appbrand/service/ab:tTR	Lcom/tencent/mm/plugin/appbrand/service/ab;
    //   184: invokeinterface 215 2 0
    //   189: ldc 91
    //   191: new 93	java/lang/StringBuilder
    //   194: dup
    //   195: ldc 217
    //   197: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   203: lload 4
    //   205: lsub
    //   206: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   209: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: iload_2
    //   216: ifeq +50 -> 266
    //   219: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   222: lstore 4
    //   224: ldc 200
    //   226: invokestatic 206	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   229: checkcast 200	com/tencent/mm/plugin/appbrand/service/g
    //   232: getstatic 212	com/tencent/mm/plugin/appbrand/service/ab:tTR	Lcom/tencent/mm/plugin/appbrand/service/ab;
    //   235: invokeinterface 223 2 0
    //   240: ldc 91
    //   242: new 93	java/lang/StringBuilder
    //   245: dup
    //   246: ldc 225
    //   248: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   254: lload 4
    //   256: lsub
    //   257: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   269: lstore 4
    //   271: ldc 227
    //   273: invokestatic 206	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   276: checkcast 227	com/tencent/mm/plugin/appbrand/service/k
    //   279: aload 6
    //   281: invokeinterface 231 2 0
    //   286: ldc 91
    //   288: new 93	java/lang/StringBuilder
    //   291: dup
    //   292: ldc 233
    //   294: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   297: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   300: lload 4
    //   302: lsub
    //   303: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   306: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: iload_1
    //   313: ifeq +76 -> 389
    //   316: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   319: lstore 4
    //   321: aload_0
    //   322: invokeinterface 77 1 0
    //   327: astore_0
    //   328: aload_0
    //   329: invokeinterface 83 1 0
    //   334: ifeq +151 -> 485
    //   337: aload_0
    //   338: invokeinterface 87 1 0
    //   343: checkcast 6	com/tencent/mm/plugin/sns/ad/d/j$a
    //   346: astore 6
    //   348: aload 6
    //   350: getfield 173	com/tencent/mm/plugin/sns/ad/d/j$a:PNZ	Ljava/lang/String;
    //   353: aload 6
    //   355: getfield 236	com/tencent/mm/plugin/sns/ad/d/j$a:POa	Ljava/lang/String;
    //   358: invokestatic 239	com/tencent/mm/plugin/sns/ad/d/j:lL	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: goto -33 -> 328
    //   364: astore_0
    //   365: ldc 91
    //   367: new 93	java/lang/StringBuilder
    //   370: dup
    //   371: ldc 241
    //   373: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload_0
    //   377: invokevirtual 104	java/lang/Throwable:toString	()Ljava/lang/String;
    //   380: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: ldc 162
    //   391: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: return
    //   395: astore 7
    //   397: ldc 91
    //   399: new 93	java/lang/StringBuilder
    //   402: dup
    //   403: ldc 243
    //   405: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   408: aload 7
    //   410: invokevirtual 104	java/lang/Throwable:toString	()Ljava/lang/String;
    //   413: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: goto -207 -> 215
    //   425: astore 7
    //   427: ldc 91
    //   429: new 93	java/lang/StringBuilder
    //   432: dup
    //   433: ldc 245
    //   435: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   438: aload 7
    //   440: invokevirtual 104	java/lang/Throwable:toString	()Ljava/lang/String;
    //   443: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: goto -186 -> 266
    //   455: astore 6
    //   457: ldc 91
    //   459: new 93	java/lang/StringBuilder
    //   462: dup
    //   463: ldc 247
    //   465: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   468: aload 6
    //   470: invokevirtual 104	java/lang/Throwable:toString	()Ljava/lang/String;
    //   473: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -170 -> 312
    //   485: ldc 91
    //   487: new 93	java/lang/StringBuilder
    //   490: dup
    //   491: ldc 249
    //   493: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   499: lload 4
    //   501: lsub
    //   502: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   505: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: ldc 162
    //   513: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	paramList	List<a>
    //   0	517	1	paramBoolean1	boolean
    //   0	517	2	paramBoolean2	boolean
    //   0	517	3	paramBoolean3	boolean
    //   171	329	4	l	long
    //   38	316	6	localObject1	Object
    //   455	14	6	localObject2	Object
    //   46	13	7	localIterator	Iterator
    //   395	14	7	localObject3	Object
    //   425	14	7	localObject4	Object
    //   68	31	8	locala	a
    // Exception table:
    //   from	to	target	type
    //   316	328	364	finally
    //   328	361	364	finally
    //   485	511	364	finally
    //   168	215	395	finally
    //   219	266	425	finally
    //   266	312	455	finally
  }
  
  public static void g(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309953);
    com.tencent.threadpool.h.ahAA.bm(new j.1(paramSnsInfo));
    AppMethodBeat.o(309953);
  }
  
  private static boolean h(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(309981);
    if (paramSnsInfo == null)
    {
      Log.e("AdWeAppPreloader", "doPreloadWeAppEnvForTimeLine, snsInfo==null");
      AppMethodBeat.o(309981);
      return false;
    }
    try
    {
      localArrayList = new ArrayList();
      localObject1 = paramSnsInfo.getAdInfo();
      localObject2 = paramSnsInfo.getAdXml();
      paramSnsInfo = t.uA(paramSnsInfo.field_snsId);
      if ((localObject2 == null) || (!((ADXml)localObject2).preloadWeAppPkg)) {
        break label1262;
      }
      bool5 = true;
    }
    finally
    {
      for (;;)
      {
        ArrayList localArrayList;
        Object localObject1;
        Object localObject2;
        boolean bool6;
        boolean bool3;
        boolean bool7;
        boolean bool4;
        Object localObject3;
        int i;
        Object localObject4;
        Log.e("AdWeAppPreloader", "doPreloadWeAppEnvForTimeLine, exp=" + paramSnsInfo.toString());
        continue;
        break label1302;
        boolean bool1 = bool4;
        boolean bool2 = bool3;
        continue;
        boolean bool5 = false;
        continue;
        bool2 = true;
        bool1 = bool3;
        continue;
        bool2 = true;
        continue;
        bool1 = true;
        bool2 = bool3;
        continue;
        bool1 = true;
        continue;
        bool1 = true;
        bool2 = bool3;
        continue;
        continue;
        bool1 = true;
      }
    }
    Log.i("AdWeAppPreloader", "doPreloadWeAppEnvForTimeLine, snsId=".concat(String.valueOf(paramSnsInfo)));
    bool6 = false;
    bool3 = false;
    bool7 = false;
    bool4 = false;
    bool2 = bool7;
    bool1 = bool6;
    if (localObject1 != null)
    {
      bool2 = bool7;
      bool1 = bool6;
      if (((ADInfo)localObject1).actionExtWeApp != null)
      {
        paramSnsInfo = ((ADInfo)localObject1).actionExtWeApp.appUserName;
        bool2 = bool7;
        bool1 = bool6;
        if (!TextUtils.isEmpty(paramSnsInfo))
        {
          localObject3 = ((ADInfo)localObject1).actionExtWeApp.hzy;
          i = ((ADInfo)localObject1).actionExtWeApp.PLo;
          localObject3 = new a(paramSnsInfo, (String)localObject3, i);
          bool2 = bool7;
          bool1 = bool6;
          if (!localArrayList.contains(localObject3))
          {
            localArrayList.add(localObject3);
            if (i != 2) {
              break label1268;
            }
            bool1 = true;
            bool2 = bool4;
            Log.i("AdWeAppPreloader", "adInfo.actionExtWeApp, userName=" + paramSnsInfo + ", weAppType=" + i);
          }
        }
      }
    }
    bool4 = bool2;
    bool3 = bool1;
    if (localObject2 != null)
    {
      bool4 = bool2;
      bool3 = bool1;
      if (((ADXml)localObject2).adCardActionBtnInfo != null)
      {
        bool4 = bool2;
        bool3 = bool1;
        if (((ADXml)localObject2).adCardActionBtnInfo.clickActionInfo != null)
        {
          paramSnsInfo = ((ADXml)localObject2).adCardActionBtnInfo.clickActionInfo.xVm;
          bool4 = bool2;
          bool3 = bool1;
          if (!TextUtils.isEmpty(paramSnsInfo))
          {
            localObject3 = ((ADXml)localObject2).adCardActionBtnInfo.clickActionInfo.nUS;
            i = ((ADXml)localObject2).adCardActionBtnInfo.clickActionInfo.PLo;
            localObject3 = new a(paramSnsInfo, (String)localObject3, i);
            bool4 = bool2;
            bool3 = bool1;
            if (!localArrayList.contains(localObject3))
            {
              localArrayList.add(localObject3);
              if (i != 2) {
                break label1276;
              }
              bool1 = true;
              Log.i("AdWeAppPreloader", "actionBtnWeApp, userName=" + paramSnsInfo + ", weAppType=" + i);
              bool3 = bool1;
              bool4 = bool2;
            }
          }
        }
      }
    }
    bool1 = bool4;
    bool2 = bool3;
    if (localObject2 != null)
    {
      bool1 = bool4;
      bool2 = bool3;
      if (((ADXml)localObject2).weAppInfo != null)
      {
        paramSnsInfo = ((ADXml)localObject2).weAppInfo.appUserName;
        bool1 = bool4;
        bool2 = bool3;
        if (!TextUtils.isEmpty(paramSnsInfo))
        {
          localObject3 = ((ADXml)localObject2).weAppInfo.hzy;
          i = ((ADXml)localObject2).weAppInfo.PLo;
          localObject3 = new a(paramSnsInfo, (String)localObject3, i);
          bool1 = bool4;
          bool2 = bool3;
          if (!localArrayList.contains(localObject3))
          {
            localArrayList.add(localObject3);
            if (i != 2) {
              break label1281;
            }
            bool2 = true;
            bool1 = bool4;
            Log.i("AdWeAppPreloader", "headWeApp, userName=" + paramSnsInfo + ", weAppType=" + i);
          }
        }
      }
    }
    bool3 = bool1;
    bool4 = bool2;
    if (localObject2 != null)
    {
      bool3 = bool1;
      bool4 = bool2;
      if (((ADXml)localObject2).adSliderFullCardInfo != null)
      {
        bool3 = bool1;
        bool4 = bool2;
        if (((ADXml)localObject2).adSliderFullCardInfo.PMG != null)
        {
          paramSnsInfo = ((ADXml)localObject2).adSliderFullCardInfo.PMG;
          bool3 = bool1;
          bool4 = bool2;
          if (!d.isEmpty(paramSnsInfo))
          {
            paramSnsInfo = paramSnsInfo.iterator();
            do
            {
              bool3 = bool1;
              bool4 = bool2;
              if (!paramSnsInfo.hasNext()) {
                break;
              }
              localObject2 = (com.tencent.mm.plugin.sns.ad.adxml.l)paramSnsInfo.next();
            } while (localObject2 == null);
            bool4 = bool1;
            bool3 = bool2;
            if (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).clickActionInfo != null)
            {
              localObject3 = ((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).clickActionInfo.xVm;
              bool4 = bool1;
              bool3 = bool2;
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject4 = ((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).clickActionInfo.nUS;
                i = ((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).clickActionInfo.PLo;
                localObject4 = new a((String)localObject3, (String)localObject4, i);
                bool4 = bool1;
                bool3 = bool2;
                if (!localArrayList.contains(localObject4))
                {
                  localArrayList.add(localObject4);
                  if (i != 2) {
                    break label1289;
                  }
                  bool2 = true;
                  Log.i("AdWeAppPreloader", "adSliderFullCardWeApp, weAppUserName = " + (String)localObject3 + ", weAppType = " + i);
                  bool3 = bool2;
                  bool4 = bool1;
                }
              }
            }
            if ((((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY == null) || (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj == null)) {
              break label1253;
            }
            localObject3 = ((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj.xVm;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label1253;
            }
            localObject4 = ((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj.nUS;
            i = ((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj.PLo;
            localObject2 = new a((String)localObject3, (String)localObject4, i);
            if (localArrayList.contains(localObject2)) {
              break label1253;
            }
            localArrayList.add(localObject2);
            if (i != 2) {
              break label1294;
            }
            bool2 = true;
            bool1 = bool4;
            Log.i("AdWeAppPreloader", "adSliderFullCardBtnWeApp, btnWeAppUserName = " + (String)localObject3 + ", btnWeAppType = " + i);
            break label1259;
          }
        }
      }
    }
    bool6 = bool3;
    bool7 = bool4;
    if (localObject1 != null)
    {
      bool6 = bool3;
      bool7 = bool4;
      if (!d.isEmpty(((ADInfo)localObject1).adClickActionInfoList))
      {
        paramSnsInfo = ((ADInfo)localObject1).adClickActionInfoList.iterator();
        bool2 = bool4;
        bool1 = bool3;
        bool6 = bool1;
        bool7 = bool2;
        if (paramSnsInfo.hasNext())
        {
          localObject2 = (AdClickActionInfo)paramSnsInfo.next();
          if (localObject2 == null) {
            break label1250;
          }
          localObject1 = ((AdClickActionInfo)localObject2).xVm;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1250;
          }
          localObject3 = ((AdClickActionInfo)localObject2).nUS;
          i = ((AdClickActionInfo)localObject2).PLo;
          localObject2 = new a((String)localObject1, (String)localObject3, i);
          if (localArrayList.contains(localObject2)) {
            break label1250;
          }
          localArrayList.add(localObject2);
          if (i != 2) {
            break label1305;
          }
          bool2 = true;
          Log.i("AdWeAppPreloader", "clickActionInfoList from adInfo, userName=" + (String)localObject1 + ", weAppType=" + i);
          break label1302;
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      b(localArrayList, bool5, bool7, bool6);
      AppMethodBeat.o(309981);
      return true;
    }
    Log.i("AdWeAppPreloader", "doPreloadWeAppEnvForTimeLine, preloadWeAppPkg=" + bool5 + ", no weAppUserName");
    AppMethodBeat.o(309981);
    return false;
  }
  
  public static void i(ArrayList<a> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(309987);
    com.tencent.threadpool.h.ahAA.bm(new j.2(paramArrayList, paramBoolean));
    AppMethodBeat.o(309987);
  }
  
  private static boolean j(ArrayList<a> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(310001);
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(310001);
      return false;
    }
    Iterator localIterator = paramArrayList.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (TextUtils.isEmpty(locala.PNZ)) {
        break label141;
      }
      if (locala.PLo == 2) {
        bool2 = true;
      } else {
        bool1 = true;
      }
    }
    label141:
    for (;;)
    {
      break;
      if ((bool2) || (bool1)) {
        b(paramArrayList, paramBoolean, bool2, bool1);
      }
      for (;;)
      {
        AppMethodBeat.o(310001);
        return true;
        Log.i("AdWeAppPreloader", "doPreloadWeAppEnvForNativeLandingPage, preloadWeAppPkg=" + paramBoolean + ", no weAppUserName");
      }
    }
  }
  
  private static String ku(List<String> paramList)
  {
    AppMethodBeat.i(310068);
    if (paramList.size() > 0)
    {
      paramList = org.apache.commons.c.i.b(paramList, ",");
      AppMethodBeat.o(310068);
      return paramList;
    }
    AppMethodBeat.o(310068);
    return "";
  }
  
  private static void lL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310059);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(310059);
      return;
    }
    String str = paramString1 + "_" + paramString2;
    synchronized (PNV)
    {
      if (PNV.contains(str))
      {
        Log.w("AdWeAppPreloader", "doPreloadWeAppPkg, already preloaded, key=".concat(String.valueOf(str)));
        AppMethodBeat.o(310059);
        return;
      }
      PNV.add(str);
      Log.i("AdWeAppPreloader", "doPreloadWeAppPkg, key=".concat(String.valueOf(str)));
      ((y)com.tencent.mm.kernel.h.ax(y.class)).y(paramString1, paramString2, 5);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 45);
      AppMethodBeat.o(310059);
      return;
    }
  }
  
  public static final class a
  {
    public int PLo;
    public String PNZ;
    public String POa;
    
    public a(String paramString1, String paramString2, int paramInt)
    {
      this.PNZ = paramString1;
      this.POa = paramString2;
      this.PLo = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(310069);
      if (this == paramObject)
      {
        AppMethodBeat.o(310069);
        return true;
      }
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.PLo == paramObject.PLo) && (org.apache.commons.c.i.qA(this.PNZ, paramObject.PNZ)) && (org.apache.commons.c.i.qA(this.POa, paramObject.POa)))
        {
          AppMethodBeat.o(310069);
          return true;
        }
      }
      AppMethodBeat.o(310069);
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(310074);
      String str = this.PNZ + "|" + this.PLo + "|" + this.POa;
      AppMethodBeat.o(310074);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.j
 * JD-Core Version:    0.7.0.1
 */