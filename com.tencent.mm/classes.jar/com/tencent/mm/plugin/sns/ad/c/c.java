package com.tencent.mm.plugin.sns.ad.c;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  private static Map<String, Integer> zno;
  
  static
  {
    AppMethodBeat.i(219007);
    zno = new HashMap();
    AppMethodBeat.o(219007);
  }
  
  /* Error */
  private static boolean ayU(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 33
    //   5: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +15 -> 27
    //   15: ldc 33
    //   17: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: istore_1
    //   22: ldc 2
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: getstatic 23	com/tencent/mm/plugin/sns/ad/c/c:zno	Ljava/util/Map;
    //   30: aload_0
    //   31: invokeinterface 45 2 0
    //   36: ifeq +42 -> 78
    //   39: getstatic 23	com/tencent/mm/plugin/sns/ad/c/c:zno	Ljava/util/Map;
    //   42: aload_0
    //   43: invokeinterface 49 2 0
    //   48: checkcast 51	java/lang/Integer
    //   51: invokevirtual 55	java/lang/Integer:intValue	()I
    //   54: iconst_1
    //   55: if_icmpne +13 -> 68
    //   58: ldc 33
    //   60: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: iconst_1
    //   64: istore_1
    //   65: goto -43 -> 22
    //   68: ldc 33
    //   70: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -53 -> 22
    //   78: ldc 33
    //   80: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_0
    //   84: istore_1
    //   85: goto -63 -> 22
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramString	String
    //   21	64	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	20	88	finally
    //   27	63	88	finally
    //   68	73	88	finally
    //   78	83	88	finally
  }
  
  public static void e(String paramString, View paramView)
  {
    AppMethodBeat.i(219003);
    paramView.setTag(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      ae.e("AdWeAppHelper", "refreshWeAppAuthIcon, weAppUserName==null");
      AppMethodBeat.o(219003);
      return;
    }
    if (ayU(paramString)) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      ((o)g.ab(o.class)).a(paramString, new c.1(paramView));
      AppMethodBeat.o(219003);
      return;
      if (paramView.getVisibility() == 0) {
        paramView.setVisibility(4);
      }
    }
  }
  
  public static boolean f(p paramp)
  {
    AppMethodBeat.i(219004);
    ArrayList localArrayList = new ArrayList();
    a locala = paramp.dVi();
    paramp = paramp.dVj();
    if ((locala != null) && (locala.zMn != null) && (!TextUtils.isEmpty(locala.zMn.duJ)))
    {
      localArrayList.add(locala.zMn.duJ);
      ae.i("AdWeAppHelper", "checkPreloadWeAppEnvForTimeLine, has actionExtWeApp");
    }
    if ((paramp != null) && (paramp.zsZ != null) && (!TextUtils.isEmpty(paramp.zsZ.pSx)) && (!localArrayList.contains(paramp.zsZ.pSx)))
    {
      localArrayList.add(paramp.zsZ.pSx);
      ae.i("AdWeAppHelper", "checkPreloadWeAppEnvForTimeLine, has adCardActionBtnInfo");
    }
    if (!localArrayList.isEmpty())
    {
      fP(localArrayList);
      AppMethodBeat.o(219004);
      return true;
    }
    ae.i("AdWeAppHelper", "checkPreloadWeAppEnvForTimeLine, no weapp");
    AppMethodBeat.o(219004);
    return false;
  }
  
  public static boolean fO(List<k> paramList)
  {
    AppMethodBeat.i(219005);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      k localk = (k)paramList.next();
      if ((localk != null) && (!TextUtils.isEmpty(localk.username)) && (!localArrayList.contains(localk.username))) {
        localArrayList.add(localk.username);
      }
    }
    if (!localArrayList.isEmpty())
    {
      fP(localArrayList);
      AppMethodBeat.o(219005);
      return true;
    }
    ae.i("AdWeAppHelper", "checkPreloadWeAppEnvForNativeLandingPage, no weapp btn");
    AppMethodBeat.o(219005);
    return false;
  }
  
  private static void fP(List<String> paramList)
  {
    AppMethodBeat.i(219006);
    try
    {
      l = System.currentTimeMillis();
      ((i)g.ab(i.class)).LC("");
      ae.i("AdWeAppHelper", "preloadWeAppEnv->preloadEnv, timeCost=" + (System.currentTimeMillis() - l));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          long l = System.currentTimeMillis();
          ((i)g.ab(i.class)).aS(paramList);
          ae.i("AdWeAppHelper", "preloadWeAppEnv->batchSyncWxaAttr, list.size=" + paramList.size() + ", timeCost=" + (System.currentTimeMillis() - l));
          AppMethodBeat.o(219006);
          return;
        }
        catch (Exception paramList)
        {
          ae.e("AdWeAppHelper", "preloadWeAppEnv->batchSyncWxaAttr, exp=" + paramList.toString());
          AppMethodBeat.o(219006);
        }
        localException = localException;
        ae.e("AdWeAppHelper", "preloadWeAppEnv->preloadEnv, exp=" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.c
 * JD-Core Version:    0.7.0.1
 */