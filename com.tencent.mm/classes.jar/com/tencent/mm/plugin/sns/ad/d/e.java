package com.tencent.mm.plugin.sns.ad.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URI;

public final class e
{
  private static boolean rPg = false;
  
  /* Error */
  public static void a(com.tencent.mm.g.e parame, dmz paramdmz)
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +187 -> 193
    //   9: aload_1
    //   10: getfield 25	com/tencent/mm/protocal/protobuf/dmz:isAd	Z
    //   13: ifeq +180 -> 193
    //   16: aload_1
    //   17: getfield 29	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
    //   20: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +170 -> 193
    //   26: aload_1
    //   27: getfield 29	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
    //   30: ldc 37
    //   32: invokevirtual 42	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +164 -> 199
    //   38: bipush 6
    //   40: invokestatic 48	com/tencent/mm/modelcontrol/e:wb	(I)Z
    //   43: istore_2
    //   44: iload_2
    //   45: ifeq +64 -> 109
    //   48: aload_0
    //   49: iconst_2
    //   50: putfield 54	com/tencent/mm/g/e:field_requestVideoFormat	I
    //   53: ldc 56
    //   55: new 58	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 60
    //   61: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: iload_2
    //   65: invokevirtual 68	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   68: ldc 70
    //   70: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 54	com/tencent/mm/g/e:field_requestVideoFormat	I
    //   77: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc 78
    //   82: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: getfield 29	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
    //   89: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: iconst_1
    //   99: iload_2
    //   100: invokestatic 91	com/tencent/mm/plugin/sns/ad/d/e:aS	(ZZ)V
    //   103: ldc 14
    //   105: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: return
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 54	com/tencent/mm/g/e:field_requestVideoFormat	I
    //   114: invokestatic 99	com/tencent/mm/compatible/deviceinfo/q:aPo	()Ljava/lang/String;
    //   117: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   120: astore_3
    //   121: getstatic 107	com/tencent/mm/plugin/sns/data/l:Qns	Ljava/lang/String;
    //   124: aload_3
    //   125: iconst_0
    //   126: iconst_0
    //   127: ldc 109
    //   129: invokestatic 112	com/tencent/mm/plugin/sns/data/l:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   132: goto -79 -> 53
    //   135: astore_3
    //   136: ldc 56
    //   138: new 58	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 114
    //   144: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   151: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: goto -107 -> 53
    //   163: astore_1
    //   164: aload_0
    //   165: iconst_1
    //   166: putfield 54	com/tencent/mm/g/e:field_requestVideoFormat	I
    //   169: ldc 56
    //   171: new 58	java/lang/StringBuilder
    //   174: dup
    //   175: ldc 122
    //   177: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_1
    //   181: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   184: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: ldc 14
    //   195: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: return
    //   199: aload_0
    //   200: iconst_1
    //   201: putfield 54	com/tencent/mm/g/e:field_requestVideoFormat	I
    //   204: ldc 56
    //   206: new 58	java/lang/StringBuilder
    //   209: dup
    //   210: ldc 124
    //   212: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload_1
    //   216: getfield 29	com/tencent/mm/protocal/protobuf/dmz:Url	Ljava/lang/String;
    //   219: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: iconst_0
    //   229: iconst_0
    //   230: invokestatic 91	com/tencent/mm/plugin/sns/ad/d/e:aS	(ZZ)V
    //   233: ldc 14
    //   235: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	parame	com.tencent.mm.g.e
    //   0	239	1	paramdmz	dmz
    //   43	57	2	bool	boolean
    //   120	5	3	str	String
    //   135	13	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   114	132	135	finally
    //   26	44	163	finally
    //   48	53	163	finally
    //   53	108	163	finally
    //   109	114	163	finally
    //   136	160	163	finally
    //   199	233	163	finally
  }
  
  public static void a(ADXml paramADXml, dmz paramdmz, String paramString)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    AppMethodBeat.i(310062);
    long l = System.currentTimeMillis();
    if ((paramADXml == null) || (paramdmz == null) || (!paramdmz.isAd))
    {
      paramString = new StringBuilder("checkAdSupportH265, adXml==null?");
      if (paramADXml == null)
      {
        bool1 = true;
        paramADXml = paramString.append(bool1).append(", media==null?");
        if (paramdmz != null) {
          break label107;
        }
        bool1 = bool3;
        label65:
        paramADXml = paramADXml.append(bool1).append(", isAd=");
        if (paramdmz != null) {
          break label112;
        }
      }
      label107:
      label112:
      for (boolean bool1 = bool2;; bool1 = paramdmz.isAd)
      {
        Log.w("AdH265Helper", bool1);
        AppMethodBeat.o(310062);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label65;
      }
    }
    if (paramADXml.isFullCardAd()) {
      paramADXml = "fullcardAd enable h265";
    }
    for (;;)
    {
      a(paramdmz, true);
      Log.i("AdH265Helper", "checkAdSupportH265, " + paramADXml + ", snsId=" + paramString + ", timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(310062);
      return;
      if (paramADXml.isCardAd()) {
        paramADXml = "cardAd enable h265";
      } else {
        paramADXml = "normalAd enable h265";
      }
    }
  }
  
  public static void a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(310121);
    if (paramw == null)
    {
      AppMethodBeat.o(310121);
      return;
    }
    boolean bool2 = gZI();
    if ((bool2) && (!paramw.QKx)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramw.QKp = cO(paramw.QKp, bool1);
      Log.i("AdH265Helper", "checkAdLandingPageSightForH265, expt=" + bool2 + ", forbidCdn=" + paramw.QKx + ", isPreload=" + paramBoolean + ", ret url=" + paramw.QKp);
      AppMethodBeat.o(310121);
      return;
    }
  }
  
  public static void a(SnsInfo paramSnsInfo, dmz paramdmz)
  {
    AppMethodBeat.i(310046);
    if ((paramSnsInfo != null) && (paramSnsInfo.isAd())) {
      a(paramSnsInfo.getAdXml(), paramdmz, t.uA(paramSnsInfo.field_snsId));
    }
    AppMethodBeat.o(310046);
  }
  
  public static void a(dmz paramdmz, boolean paramBoolean)
  {
    AppMethodBeat.i(310073);
    long l1 = System.currentTimeMillis();
    if (paramdmz == null)
    {
      Log.e("AdH265Helper", "setMediaInfoForH265, media==null");
      AppMethodBeat.o(310073);
      return;
    }
    if (!paramdmz.isAd)
    {
      Log.e("AdH265Helper", "setMediaInfoForH265, !media.isAd");
      AppMethodBeat.o(310073);
      return;
    }
    paramdmz.Url = cO(paramdmz.Url, paramBoolean);
    paramdmz.Id = cP(paramdmz.Id, paramBoolean);
    long l2 = System.currentTimeMillis();
    Log.i("AdH265Helper", "setMediaInfoForH265, media.hash=" + paramdmz.hashCode() + ", enableH265=" + paramBoolean + ", meida.enc=" + paramdmz.aaTw + ", cost=" + (l2 - l1));
    AppMethodBeat.o(310073);
  }
  
  private static void aS(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(310163);
    int i;
    if ((paramBoolean1) && (paramBoolean2)) {
      i = 4;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1579, i);
      Log.i("AdH265Helper", "report, isOnline=false, urlHasFlag=" + paramBoolean1 + ", cdnHasFlag=" + paramBoolean2 + ", key=" + i);
      AppMethodBeat.o(310163);
      return;
      if (!paramBoolean1) {
        i = 5;
      } else {
        i = 6;
      }
    }
  }
  
  private static String aWk(String paramString)
  {
    AppMethodBeat.i(310147);
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        AppMethodBeat.o(310147);
        return paramString;
      }
      bool = paramString.contains("svpuseh265flag");
      if (!bool)
      {
        AppMethodBeat.o(310147);
        return paramString;
      }
      URI localURI = new URI(paramString);
      Object localObject2 = localURI.getQuery();
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (((String)localObject2).contains("svpuseh265flag=0")) {
          localObject1 = ((String)localObject2).replace("&svpuseh265flag=0", "").replace("svpuseh265flag=0", "");
        }
        localObject2 = localObject1;
        if (((String)localObject1).contains("svpuseh265flag=1")) {
          localObject2 = ((String)localObject1).replace("&svpuseh265flag=1", "").replace("svpuseh265flag=1", "");
        }
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("&")) {
          localObject1 = ((String)localObject2).replaceFirst("&", "");
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = null;
      }
      localObject1 = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), (String)localObject2, localURI.getFragment()).toString();
      AppMethodBeat.o(310147);
      return localObject1;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("AdH265Helper", localException, "", new Object[0]);
      AppMethodBeat.o(310147);
    }
    return paramString;
  }
  
  public static boolean anH()
  {
    return rPg;
  }
  
  public static String cO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(310085);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        if (paramString.contains("svpuseh265flag")) {
          continue;
        }
        str1 = ar.n(paramString, new String[] { "svpuseh265flag=1" });
      }
      finally
      {
        String str1;
        Log.e("AdH265Helper", "setMediaUrlForH265, exp=" + localObject.toString());
        String str2 = paramString;
        continue;
      }
      Log.d("AdH265Helper", "setMediaUrlForH265, raw=" + paramString + ", ret=" + str1 + ", enable=" + paramBoolean);
      AppMethodBeat.o(310085);
      return str1;
      str1 = paramString.replace("svpuseh265flag=0", "svpuseh265flag=1");
      continue;
      str1 = aWk(paramString);
      continue;
      Log.e("AdH265Helper", "setMediaUrlForH265, media.Url==null");
      str1 = paramString;
    }
  }
  
  public static String cP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(310096);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        if (paramString.contains("_hvec")) {
          continue;
        }
        str1 = paramString + "_hvec";
      }
      finally
      {
        String str1;
        Log.e("AdH265Helper", "setMediaIdForH265, exp=" + localObject.toString());
        String str2 = paramString;
        continue;
      }
      Log.i("AdH265Helper", "setMediaIdForH265, raw=" + paramString + ", ret=" + str1 + ", enable=" + paramBoolean);
      AppMethodBeat.o(310096);
      return str1;
      if (paramString.contains("_hvec"))
      {
        str1 = paramString.replace("_hvec", "");
        continue;
        Log.e("AdH265Helper", "setMediaIdForH265, mediaId==null");
      }
      else
      {
        str1 = paramString;
      }
    }
  }
  
  public static boolean gZH()
  {
    AppMethodBeat.i(310128);
    try
    {
      if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yHZ, 0) > 0)
      {
        AppMethodBeat.o(310128);
        return true;
      }
      AppMethodBeat.o(310128);
      return false;
    }
    finally
    {
      Log.e("AdH265Helper", "isExptNormAdEnableH265, exp=" + localObject.toString());
      AppMethodBeat.o(310128);
    }
    return false;
  }
  
  private static boolean gZI()
  {
    AppMethodBeat.i(310134);
    try
    {
      if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yIa, 0) > 0)
      {
        AppMethodBeat.o(310134);
        return true;
      }
      AppMethodBeat.o(310134);
      return false;
    }
    finally
    {
      Log.e("AdH265Helper", "isExptLandingPageSightVideoEnableH265, exp=" + localObject.toString());
      AppMethodBeat.o(310134);
    }
    return false;
  }
  
  /* Error */
  public static void h(com.tencent.mm.g.h paramh)
  {
    // Byte code:
    //   0: ldc_w 375
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 380	com/tencent/mm/g/h:aLN	()Z
    //   10: ifeq +185 -> 195
    //   13: aload_0
    //   14: getfield 383	com/tencent/mm/g/h:url	Ljava/lang/String;
    //   17: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +175 -> 195
    //   23: aload_0
    //   24: getfield 383	com/tencent/mm/g/h:url	Ljava/lang/String;
    //   27: ldc 37
    //   29: invokevirtual 42	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +170 -> 202
    //   35: bipush 6
    //   37: invokestatic 48	com/tencent/mm/modelcontrol/e:wb	(I)Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifeq +69 -> 111
    //   45: aload_0
    //   46: iconst_2
    //   47: putfield 384	com/tencent/mm/g/h:field_requestVideoFormat	I
    //   50: ldc 56
    //   52: new 58	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 60
    //   58: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: iload_1
    //   62: invokevirtual 68	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: ldc 70
    //   67: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_0
    //   71: getfield 384	com/tencent/mm/g/h:field_requestVideoFormat	I
    //   74: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 78
    //   79: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 383	com/tencent/mm/g/h:url	Ljava/lang/String;
    //   86: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 387	com/tencent/mm/g/h:lxe	I
    //   99: iconst_1
    //   100: iload_1
    //   101: invokestatic 391	com/tencent/mm/plugin/sns/ad/d/e:p	(IZZ)V
    //   104: ldc_w 375
    //   107: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 384	com/tencent/mm/g/h:field_requestVideoFormat	I
    //   116: invokestatic 99	com/tencent/mm/compatible/deviceinfo/q:aPo	()Ljava/lang/String;
    //   119: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   122: astore_2
    //   123: getstatic 107	com/tencent/mm/plugin/sns/data/l:Qns	Ljava/lang/String;
    //   126: aload_2
    //   127: iconst_0
    //   128: iconst_0
    //   129: ldc 109
    //   131: invokestatic 112	com/tencent/mm/plugin/sns/data/l:a	(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   134: goto -84 -> 50
    //   137: astore_2
    //   138: ldc 56
    //   140: new 58	java/lang/StringBuilder
    //   143: dup
    //   144: ldc 114
    //   146: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload_2
    //   150: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   153: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: goto -112 -> 50
    //   165: astore_2
    //   166: aload_0
    //   167: iconst_1
    //   168: putfield 384	com/tencent/mm/g/h:field_requestVideoFormat	I
    //   171: ldc 56
    //   173: new 58	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 122
    //   179: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_2
    //   183: invokevirtual 117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   186: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 120	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: ldc_w 375
    //   198: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: return
    //   202: aload_0
    //   203: iconst_1
    //   204: putfield 384	com/tencent/mm/g/h:field_requestVideoFormat	I
    //   207: ldc 56
    //   209: new 58	java/lang/StringBuilder
    //   212: dup
    //   213: ldc 124
    //   215: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 383	com/tencent/mm/g/h:url	Ljava/lang/String;
    //   222: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: getfield 387	com/tencent/mm/g/h:lxe	I
    //   235: iconst_0
    //   236: iconst_0
    //   237: invokestatic 391	com/tencent/mm/plugin/sns/ad/d/e:p	(IZZ)V
    //   240: ldc_w 375
    //   243: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramh	com.tencent.mm.g.h
    //   40	61	1	bool	boolean
    //   122	5	2	str	String
    //   137	13	2	localObject1	Object
    //   165	18	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   116	134	137	finally
    //   23	41	165	finally
    //   45	50	165	finally
    //   50	110	165	finally
    //   111	116	165	finally
    //   138	162	165	finally
    //   202	240	165	finally
  }
  
  private static void p(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(310154);
    int i = 0;
    if (paramInt == 1)
    {
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label97;
      }
      i = 13;
    }
    for (;;)
    {
      if (i > 0) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1579, i);
      }
      Log.i("AdH265Helper", "report, videoPlayerType = " + paramInt + ", urlHasFlag = " + paramBoolean1 + ", cdnHasFlag = " + paramBoolean2 + ", key = " + i);
      AppMethodBeat.o(310154);
      return;
      label97:
      if (!paramBoolean1) {
        i = 14;
      } else {
        i = 15;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.e
 * JD-Core Version:    0.7.0.1
 */