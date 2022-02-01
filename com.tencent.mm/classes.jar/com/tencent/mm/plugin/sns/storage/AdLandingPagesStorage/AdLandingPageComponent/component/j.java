package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class j
  extends o
{
  private static a wZT;
  private static Runnable wZX;
  private b wZU;
  private String wZV;
  private boolean wZW;
  
  static
  {
    AppMethodBeat.i(187394);
    wZX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187371);
        j.access$100();
        AppMethodBeat.o(187371);
      }
    };
    AppMethodBeat.o(187394);
  }
  
  public j(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(187378);
    this.wZU = paramb;
    paramViewGroup = "";
    paramContext = paramViewGroup;
    if (paramb != null)
    {
      if (paramb.wVy != null) {
        paramViewGroup = paramb.wVy.getStringExtra("target_app_id");
      }
      paramContext = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        paramContext = paramb.IK;
      }
    }
    this.wZV = paramContext;
    this.wZW = apv(this.wZV);
    if (dvX() == 3) {
      H(4, 1, "");
    }
    for (;;)
    {
      H(1, 0, "");
      AppMethodBeat.o(187378);
      return;
      H(4, 0, "");
    }
  }
  
  private void H(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(187387);
    try
    {
      a(dwi(), paramInt1, String.valueOf(paramInt2), paramString);
      AppMethodBeat.o(187387);
      return;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramString.toString());
      AppMethodBeat.o(187387);
    }
  }
  
  static void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad paramad, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(187390);
    try
    {
      String str1 = bt.nullAsNil(paramad.getSnsId());
      String str2 = com.tencent.mm.plugin.sns.data.h.any(paramad.dvK);
      paramad = bt.nullAsNil(paramad.wBR);
      com.tencent.mm.plugin.report.service.h.vKh.f(19790, new Object[] { str1, str2, paramad, Integer.valueOf(paramInt), paramString1, paramString2 });
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + str1 + ", uxInfo=" + str2 + ", adExtInfo =" + paramad + ", actType =" + paramInt + ", actValue = " + paramString1 + ", extInfo = " + paramString2);
      AppMethodBeat.o(187390);
      return;
    }
    catch (Exception paramad)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramad.toString());
      AppMethodBeat.o(187390);
    }
  }
  
  private static boolean apv(String paramString)
  {
    AppMethodBeat.i(187382);
    try
    {
      boolean bool = AdLandingPagesProxy.getInstance().isPkgInstalled(paramString);
      AppMethodBeat.o(187382);
      return bool;
    }
    catch (Throwable paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
      AppMethodBeat.o(187382);
    }
    return false;
  }
  
  private int dvX()
  {
    AppMethodBeat.i(187383);
    try
    {
      int i = y.getIntExtra(this.wZU.wVy, "market_priority", 1);
      AppMethodBeat.o(187383);
      return i;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
      AppMethodBeat.o(187383);
    }
    return 0;
  }
  
  private static void dvY()
  {
    try
    {
      AppMethodBeat.i(187388);
      try
      {
        if (wZT == null)
        {
          wZT = new a((byte)0);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
          localIntentFilter.addDataScheme("package");
          aj.getContext().registerReceiver(wZT, localIntentFilter);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
        }
        AppMethodBeat.o(187388);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
          AppMethodBeat.o(187388);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void dvZ()
  {
    try
    {
      AppMethodBeat.i(187389);
      try
      {
        if (wZT != null)
        {
          aj.getContext().unregisterReceiver(wZT);
          wZT = null;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
        }
        AppMethodBeat.o(187389);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
          AppMethodBeat.o(187389);
        }
      }
      return;
    }
    finally {}
  }
  
  private static String iP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187386);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(187386);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(187386);
      return paramString1;
    }
    AppMethodBeat.o(187386);
    return paramString2;
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(187381);
    try
    {
      super.dvN();
      Object localObject1 = new HashMap();
      ((Map)localObject1).put("fontNormalColor", iP(this.wZU.wVr, "#FFFFFF"));
      ((Map)localObject1).put("fontDisableColor", iP(this.wZU.wVs, "#4CFFFFFF"));
      ((Map)localObject1).put("fontPressedColor", iP(this.wZU.wVt, "#99FFFFFF"));
      ((Map)localObject1).put("NormalColor", iP(this.wZU.wVl, "#1AAD19"));
      ((Map)localObject1).put("PressedColor", iP(this.wZU.wVn, "#179B16"));
      ((Map)localObject1).put("DisableColor", iP(this.wZU.wVm, "#661AAD19"));
      ((Map)localObject1).put("borderNormalColor", iP(this.wZU.wVo, "#179E16"));
      ((Map)localObject1).put("borderPressedColor", iP(this.wZU.wVq, "#158E14"));
      ((Map)localObject1).put("borderDisableColor", iP(this.wZU.wVp, "#00179E16"));
      int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
      int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
      int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
      int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
      int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
      int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
      int i3 = (int)dwo().wWa;
      int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
      int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
      int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
      int i = this.context.getResources().getDimensionPixelSize(2131165207);
      if (dwo().qs > 0.0F) {
        i = (int)dwo().qs;
      }
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setShape(0);
      ((GradientDrawable)localObject1).setCornerRadius(i);
      ((GradientDrawable)localObject1).setColor(i2);
      ((GradientDrawable)localObject1).setStroke(i3, i6);
      Object localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setShape(0);
      ((GradientDrawable)localObject2).setCornerRadius(i);
      ((GradientDrawable)localObject2).setColor(i1);
      ((GradientDrawable)localObject2).setStroke(i3, i5);
      Object localObject3 = new GradientDrawable();
      ((GradientDrawable)localObject3).setShape(0);
      ((GradientDrawable)localObject3).setCornerRadius(i);
      ((GradientDrawable)localObject3).setColor(n);
      ((GradientDrawable)localObject3).setStroke(i3, i4);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject3);
      this.xau.setBackground(localStateListDrawable);
      localObject1 = new int[] { -16842910 };
      localObject2 = new int[] { 16842919 };
      localObject3 = new int[] { 16842910 };
      this.xau.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { k, m, j }));
      if (this.wZU.buK > 0.0F) {
        this.xau.setTextSize(0, this.wZU.buK);
      }
      if ((this.wZW) && (this.xau != null)) {
        this.xau.setText(2131763753);
      }
      AppMethodBeat.o(187381);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
      AppMethodBeat.o(187381);
    }
  }
  
  protected final void dvW()
  {
    AppMethodBeat.i(187379);
    if (this.wZW)
    {
      Context localContext1 = this.context;
      try
      {
        al.a(localContext1, this.wZV, this.wZU.wSw, null, this.wZU.wVh, null);
        AppMethodBeat.o(187379);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AppMethodBeat.o(187379);
        return;
      }
    }
    Intent localIntent = this.wZU.wVy;
    Context localContext2 = this.context;
    try
    {
      if (!(localContext2 instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      String str = bt.by(y.getStringExtra(localIntent, "market_app_name"), "");
      al.a(localContext2, localIntent.getPackage(), "", localIntent, str, new am()
      {
        public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(187370);
          if (paramAnonymousBoolean1)
          {
            j.a(j.this, 0, "");
            AppMethodBeat.o(187370);
            return;
          }
          j.a(j.this, 2, "");
          AppMethodBeat.o(187370);
        }
      });
      AppMethodBeat.o(187379);
      return;
    }
    catch (Throwable localThrowable2)
    {
      H(2, 1, "");
      AppMethodBeat.o(187379);
    }
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(187380);
    super.dvx();
    AppMethodBeat.o(187380);
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(187385);
    super.dvy();
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
      aq.az(wZX);
      aq.n(wZX, 300000L);
      AppMethodBeat.o(187385);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
      AppMethodBeat.o(187385);
    }
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(187384);
    super.dvz();
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
      aq.az(wZX);
      dvY();
      a locala;
      if (wZT != null)
      {
        locala = wZT;
        if (TextUtils.isEmpty(this.wZV))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
          AppMethodBeat.o(187384);
          return;
        }
      }
      AppMethodBeat.o(187384);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        locala.dwa();
        locala.c(this);
        AppMethodBeat.o(187384);
        return;
      }
      catch (Throwable localThrowable2)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
      }
      localThrowable1 = localThrowable1;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
      AppMethodBeat.o(187384);
      return;
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<WeakReference<j>> wZZ;
    final Map<String, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad> xaa;
    
    private a()
    {
      AppMethodBeat.i(187372);
      this.wZZ = new LinkedList();
      this.xaa = new ConcurrentHashMap();
      AppMethodBeat.o(187372);
    }
    
    private static String aE(Intent paramIntent)
    {
      AppMethodBeat.i(187377);
      try
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        AppMethodBeat.o(187377);
        return paramIntent;
      }
      catch (Throwable paramIntent)
      {
        AppMethodBeat.o(187377);
      }
      return "";
    }
    
    private void e(String paramString1, boolean paramBoolean, String paramString2)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(187376);
          Iterator localIterator = this.wZZ.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject = (WeakReference)localIterator.next();
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = (j)((WeakReference)localObject).get();
            if (paramString1.equals(j.a((j)localObject)))
            {
              j.a((j)localObject, paramBoolean);
              if (paramBoolean) {
                j.a((j)localObject, paramString2);
              } else {
                j.a((j)localObject, j.b((j)localObject).title);
              }
            }
          }
        }
        finally {}
      }
      AppMethodBeat.o(187376);
    }
    
    /* Error */
    final void c(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 111
      //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j$a:wZZ	Ljava/util/List;
      //   11: invokeinterface 68 1 0
      //   16: astore_2
      //   17: aload_2
      //   18: invokeinterface 74 1 0
      //   23: ifeq +34 -> 57
      //   26: aload_2
      //   27: invokeinterface 78 1 0
      //   32: checkcast 80	java/lang/ref/WeakReference
      //   35: invokevirtual 83	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   38: aload_1
      //   39: if_acmpne -22 -> 17
      //   42: ldc 113
      //   44: ldc 115
      //   46: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   49: ldc 111
      //   51: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_0
      //   55: monitorexit
      //   56: return
      //   57: new 80	java/lang/ref/WeakReference
      //   60: dup
      //   61: aload_1
      //   62: invokespecial 124	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
      //   65: astore_2
      //   66: aload_0
      //   67: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j$a:wZZ	Ljava/util/List;
      //   70: aload_2
      //   71: invokeinterface 127 2 0
      //   76: pop
      //   77: aload_0
      //   78: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j$a:xaa	Ljava/util/Map;
      //   81: aload_1
      //   82: invokestatic 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j;)Ljava/lang/String;
      //   85: aload_1
      //   86: invokevirtual 131	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:dwi	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ad;
      //   89: invokeinterface 137 3 0
      //   94: pop
      //   95: ldc 111
      //   97: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   100: goto -46 -> 54
      //   103: astore_1
      //   104: aload_0
      //   105: monitorexit
      //   106: aload_1
      //   107: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	108	0	this	a
      //   0	108	1	paramj	j
      //   16	55	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	17	103	finally
      //   17	54	103	finally
      //   57	100	103	finally
    }
    
    final void dwa()
    {
      try
      {
        AppMethodBeat.i(187374);
        Iterator localIterator = this.wZZ.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            localIterator.remove();
          }
        }
        AppMethodBeat.o(187374);
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(187375);
      String str;
      if (paramIntent != null)
      {
        try
        {
          str = paramIntent.getAction();
          if (!"android.intent.action.PACKAGE_ADDED".equals(str)) {
            break label108;
          }
          paramIntent = aE(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            e(paramIntent, true, paramContext.getString(2131763753));
            try
            {
              paramContext = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)this.xaa.get(paramIntent);
              if (paramContext != null) {
                j.a(paramContext, 3, "0", "");
              }
              AppMethodBeat.o(187375);
              return;
            }
            catch (Throwable paramContext)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report error?");
            }
          }
          AppMethodBeat.o(187375);
          return;
        }
        catch (Throwable paramContext)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
        }
      }
      else
      {
        AppMethodBeat.o(187375);
        return;
      }
      label108:
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        paramContext = aE(paramIntent);
        if (!TextUtils.isEmpty(paramContext)) {
          e(paramContext, false, "");
        }
      }
      AppMethodBeat.o(187375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */