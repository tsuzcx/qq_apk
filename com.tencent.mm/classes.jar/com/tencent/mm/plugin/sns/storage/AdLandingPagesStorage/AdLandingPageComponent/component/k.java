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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.ad;
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

public final class k
  extends p
{
  private static a zDC;
  private static Runnable zDG;
  private b zDD;
  private String zDE;
  private boolean zDF;
  
  static
  {
    AppMethodBeat.i(197965);
    zDG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197943);
        k.access$200();
        AppMethodBeat.o(197943);
      }
    };
    AppMethodBeat.o(197965);
  }
  
  public k(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(197950);
    this.zDD = paramb;
    paramViewGroup = "";
    paramContext = paramViewGroup;
    if (paramb != null)
    {
      if (paramb.zyu != null) {
        paramViewGroup = paramb.zyu.getStringExtra("target_app_id");
      }
      paramContext = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        paramContext = paramb.Lw;
      }
    }
    this.zDE = paramContext;
    this.zDF = azM(this.zDE);
    if (dWO() == 3) {
      I(4, 1, "");
    }
    for (;;)
    {
      I(1, 0, "");
      AppMethodBeat.o(197950);
      return;
      I(4, 0, "");
    }
  }
  
  private void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(197959);
    try
    {
      a(dWZ(), paramInt1, String.valueOf(paramInt2), paramString);
      AppMethodBeat.o(197959);
      return;
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramString.toString());
      AppMethodBeat.o(197959);
    }
  }
  
  static void a(ae paramae, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197962);
    try
    {
      String str1 = bt.nullAsNil(paramae.getSnsId());
      String str2 = h.axM(paramae.dFy);
      paramae = bt.nullAsNil(paramae.zeg);
      g.yhR.f(19790, new Object[] { str1, str2, paramae, Integer.valueOf(paramInt), paramString1, paramString2 });
      ad.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + str1 + ", uxInfo=" + str2 + ", adExtInfo =" + paramae + ", actType =" + paramInt + ", actValue = " + paramString1 + ", extInfo = " + paramString2);
      AppMethodBeat.o(197962);
      return;
    }
    catch (Exception paramae)
    {
      ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramae.toString());
      AppMethodBeat.o(197962);
    }
  }
  
  private static boolean azM(String paramString)
  {
    AppMethodBeat.i(197954);
    try
    {
      boolean bool = AdLandingPagesProxy.getInstance().isPkgInstalled(paramString);
      AppMethodBeat.o(197954);
      return bool;
    }
    catch (Throwable paramString)
    {
      ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
      AppMethodBeat.o(197954);
    }
    return false;
  }
  
  private int dWO()
  {
    AppMethodBeat.i(197955);
    try
    {
      int i = y.getIntExtra(this.zDD.zyu, "market_priority", 1);
      AppMethodBeat.o(197955);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
      AppMethodBeat.o(197955);
    }
    return 0;
  }
  
  private static void dWP()
  {
    try
    {
      AppMethodBeat.i(197960);
      try
      {
        if (zDC == null)
        {
          zDC = new a((byte)0);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
          localIntentFilter.addDataScheme("package");
          aj.getContext().registerReceiver(zDC, localIntentFilter);
          ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
        }
        AppMethodBeat.o(197960);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
          AppMethodBeat.o(197960);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void dWQ()
  {
    try
    {
      AppMethodBeat.i(197961);
      try
      {
        if (zDC != null)
        {
          aj.getContext().unregisterReceiver(zDC);
          zDC = null;
          ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
        }
        AppMethodBeat.o(197961);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
          AppMethodBeat.o(197961);
        }
      }
      return;
    }
    finally {}
  }
  
  private static String jz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197958);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(197958);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(197958);
      return paramString1;
    }
    AppMethodBeat.o(197958);
    return paramString2;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(197952);
    super.dRk();
    AppMethodBeat.o(197952);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(197953);
    try
    {
      super.dRl();
      Object localObject = new HashMap();
      ((Map)localObject).put("fontNormalColor", jz(this.zDD.zyn, "#FFFFFF"));
      ((Map)localObject).put("fontDisableColor", jz(this.zDD.zyo, "#4CFFFFFF"));
      ((Map)localObject).put("fontPressedColor", jz(this.zDD.zyp, "#99FFFFFF"));
      ((Map)localObject).put("NormalColor", jz(this.zDD.zyh, "#1AAD19"));
      ((Map)localObject).put("PressedColor", jz(this.zDD.zyj, "#179B16"));
      ((Map)localObject).put("DisableColor", jz(this.zDD.zyi, "#661AAD19"));
      ((Map)localObject).put("borderNormalColor", jz(this.zDD.zyk, "#179E16"));
      ((Map)localObject).put("borderPressedColor", jz(this.zDD.zym, "#158E14"));
      ((Map)localObject).put("borderDisableColor", jz(this.zDD.zyl, "#00179E16"));
      int j = Color.parseColor((String)((Map)localObject).get("fontNormalColor"));
      int k = Color.parseColor((String)((Map)localObject).get("fontDisableColor"));
      int m = Color.parseColor((String)((Map)localObject).get("fontPressedColor"));
      int n = Color.parseColor((String)((Map)localObject).get("NormalColor"));
      int i1 = Color.parseColor((String)((Map)localObject).get("PressedColor"));
      int i2 = Color.parseColor((String)((Map)localObject).get("DisableColor"));
      int i3 = (int)dXf().zyW;
      int i4 = Color.parseColor((String)((Map)localObject).get("borderNormalColor"));
      int i5 = Color.parseColor((String)((Map)localObject).get("borderPressedColor"));
      int i6 = Color.parseColor((String)((Map)localObject).get("borderDisableColor"));
      int i = this.context.getResources().getDimensionPixelSize(2131165207);
      if (dXf().tm > 0.0F) {
        i = (int)dXf().tm;
      }
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadius(i);
      ((GradientDrawable)localObject).setColor(i2);
      ((GradientDrawable)localObject).setStroke(i3, i6);
      GradientDrawable localGradientDrawable1 = new GradientDrawable();
      localGradientDrawable1.setShape(0);
      localGradientDrawable1.setCornerRadius(i);
      localGradientDrawable1.setColor(i1);
      localGradientDrawable1.setStroke(i3, i5);
      GradientDrawable localGradientDrawable2 = new GradientDrawable();
      localGradientDrawable2.setShape(0);
      localGradientDrawable2.setCornerRadius(i);
      localGradientDrawable2.setColor(n);
      localGradientDrawable2.setStroke(i3, i4);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject);
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable1);
      localStateListDrawable.addState(new int[] { 16842910 }, localGradientDrawable2);
      this.zEd.setBackground(localStateListDrawable);
      localObject = new int[] { -16842910 };
      this.zEd.setTextColor(new ColorStateList(new int[][] { localObject, { 16842919 }, { 16842910 } }, new int[] { k, m, j }));
      if (this.zDD.fontSize > 0.0F) {
        this.zEd.setTextSize(0, this.zDD.fontSize);
      }
      if ((this.zDF) && (this.zEd != null)) {
        this.zEd.setText(2131763753);
      }
      AppMethodBeat.o(197953);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
      AppMethodBeat.o(197953);
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(197956);
    super.dRm();
    try
    {
      ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
      aq.aA(zDG);
      dWP();
      a locala;
      if (zDC != null)
      {
        locala = zDC;
        if (TextUtils.isEmpty(this.zDE))
        {
          ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
          AppMethodBeat.o(197956);
          return;
        }
      }
      AppMethodBeat.o(197956);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        locala.dWR();
        locala.c(this);
        AppMethodBeat.o(197956);
        return;
      }
      catch (Throwable localThrowable2)
      {
        ad.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
      }
      localThrowable1 = localThrowable1;
      ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
      AppMethodBeat.o(197956);
      return;
    }
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(197957);
    super.dRo();
    try
    {
      ad.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
      aq.aA(zDG);
      aq.o(zDG, 300000L);
      AppMethodBeat.o(197957);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
      AppMethodBeat.o(197957);
    }
  }
  
  protected final void dWN()
  {
    AppMethodBeat.i(197951);
    String str1;
    if (this.zDF)
    {
      Context localContext = this.context;
      try
      {
        localObject = bt.bI(this.zDE, "");
        str1 = bt.bI(this.zDD.zve, "");
        String str2 = bt.bI(this.zDD.zyd, "");
        String str3 = bt.bI(this.zDD.duW, "");
        ae localae = dWZ();
        j.a(localContext, str3, (String)localObject, str2, str1, localae.dFy, localae.zeg, localae.getSnsId(), 1, 2);
        AppMethodBeat.o(197951);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AppMethodBeat.o(197951);
        return;
      }
    }
    Intent localIntent = this.zDD.zyu;
    Object localObject = this.context;
    try
    {
      if (!(localObject instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      str1 = bt.bI(y.getStringExtra(localIntent, "market_app_name"), "");
      am.a((Context)localObject, localIntent.getPackage(), "", localIntent, str1, new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(197942);
          if (paramAnonymousBoolean1) {
            j.jg(k.a(k.this), k.b(k.this).zve);
          }
          AppMethodBeat.o(197942);
        }
      }, 2);
      AppMethodBeat.o(197951);
      return;
    }
    catch (Throwable localThrowable2)
    {
      I(2, 1, "");
      AppMethodBeat.o(197951);
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<WeakReference<k>> zDI;
    final Map<String, ae> zDJ;
    
    private a()
    {
      AppMethodBeat.i(197944);
      this.zDI = new LinkedList();
      this.zDJ = new ConcurrentHashMap();
      AppMethodBeat.o(197944);
    }
    
    private static String aL(Intent paramIntent)
    {
      AppMethodBeat.i(197949);
      try
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        AppMethodBeat.o(197949);
        return paramIntent;
      }
      catch (Throwable paramIntent)
      {
        AppMethodBeat.o(197949);
      }
      return "";
    }
    
    private void e(String paramString1, boolean paramBoolean, String paramString2)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(197948);
          Iterator localIterator = this.zDI.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject = (WeakReference)localIterator.next();
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = (k)((WeakReference)localObject).get();
            if (paramString1.equals(k.a((k)localObject)))
            {
              k.a((k)localObject, paramBoolean);
              if (paramBoolean) {
                k.a((k)localObject, paramString2);
              } else {
                k.a((k)localObject, k.b((k)localObject).title);
              }
            }
          }
        }
        finally {}
      }
      AppMethodBeat.o(197948);
    }
    
    /* Error */
    final void c(k paramk)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 111
      //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k$a:zDI	Ljava/util/List;
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
      //   67: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k$a:zDI	Ljava/util/List;
      //   70: aload_2
      //   71: invokeinterface 127 2 0
      //   76: pop
      //   77: aload_0
      //   78: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k$a:zDJ	Ljava/util/Map;
      //   81: aload_1
      //   82: invokestatic 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k;)Ljava/lang/String;
      //   85: aload_1
      //   86: invokevirtual 131	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/k:dWZ	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
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
      //   0	108	1	paramk	k
      //   16	55	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	17	103	finally
      //   17	54	103	finally
      //   57	100	103	finally
    }
    
    final void dWR()
    {
      try
      {
        AppMethodBeat.i(197946);
        Iterator localIterator = this.zDI.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            localIterator.remove();
          }
        }
        AppMethodBeat.o(197946);
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(197947);
      String str;
      if (paramIntent != null)
      {
        try
        {
          str = paramIntent.getAction();
          if (!"android.intent.action.PACKAGE_ADDED".equals(str)) {
            break label108;
          }
          paramIntent = aL(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            e(paramIntent, true, paramContext.getString(2131763753));
            try
            {
              paramContext = (ae)this.zDJ.get(paramIntent);
              if (paramContext != null) {
                k.a(paramContext, 3, "0", "");
              }
              AppMethodBeat.o(197947);
              return;
            }
            catch (Throwable paramContext)
            {
              ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report error?");
            }
          }
          AppMethodBeat.o(197947);
          return;
        }
        catch (Throwable paramContext)
        {
          ad.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
        }
      }
      else
      {
        AppMethodBeat.o(197947);
        return;
      }
      label108:
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        paramContext = aL(paramIntent);
        if (!TextUtils.isEmpty(paramContext)) {
          e(paramContext, false, "");
        }
      }
      AppMethodBeat.o(197947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k
 * JD-Core Version:    0.7.0.1
 */