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
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends q
{
  private static a zUH;
  private static Runnable zUL;
  private b zUI;
  private String zUJ;
  private boolean zUK;
  
  static
  {
    AppMethodBeat.i(219471);
    zUL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219449);
        l.access$200();
        AppMethodBeat.o(219449);
      }
    };
    AppMethodBeat.o(219471);
  }
  
  public l(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(219456);
    this.zUI = paramb;
    paramViewGroup = "";
    paramContext = paramViewGroup;
    if (paramb != null)
    {
      if (paramb.zPT != null) {
        paramViewGroup = paramb.zPT.getStringExtra("target_app_id");
      }
      paramContext = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        paramContext = paramb.Lw;
      }
    }
    this.zUJ = paramContext;
    this.zUK = aBd(this.zUJ);
    if (eas() == 3) {
      I(4, 1, "");
    }
    for (;;)
    {
      I(1, 0, "");
      AppMethodBeat.o(219456);
      return;
      I(4, 0, "");
    }
  }
  
  private void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(219465);
    try
    {
      a(eaD(), paramInt1, String.valueOf(paramInt2), paramString);
      AppMethodBeat.o(219465);
      return;
    }
    catch (Throwable paramString)
    {
      ae.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramString.toString());
      AppMethodBeat.o(219465);
    }
  }
  
  static void a(af paramaf, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219468);
    try
    {
      String str1 = bu.nullAsNil(paramaf.getSnsId());
      String str2 = i.azd(paramaf.dGD);
      paramaf = bu.nullAsNil(paramaf.zsJ);
      g.yxI.f(19790, new Object[] { str1, str2, paramaf, Integer.valueOf(paramInt), paramString1, paramString2 });
      ae.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + str1 + ", uxInfo=" + str2 + ", adExtInfo =" + paramaf + ", actType =" + paramInt + ", actValue = " + paramString1 + ", extInfo = " + paramString2);
      AppMethodBeat.o(219468);
      return;
    }
    catch (Exception paramaf)
    {
      ae.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramaf.toString());
      AppMethodBeat.o(219468);
    }
  }
  
  private static boolean aBd(String paramString)
  {
    AppMethodBeat.i(219460);
    try
    {
      boolean bool = AdLandingPagesProxy.getInstance().isPkgInstalled(paramString);
      AppMethodBeat.o(219460);
      return bool;
    }
    catch (Throwable paramString)
    {
      ae.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
      AppMethodBeat.o(219460);
    }
    return false;
  }
  
  private int eas()
  {
    AppMethodBeat.i(219461);
    try
    {
      int i = z.getIntExtra(this.zUI.zPT, "market_priority", 1);
      AppMethodBeat.o(219461);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
      AppMethodBeat.o(219461);
    }
    return 0;
  }
  
  private static void eat()
  {
    try
    {
      AppMethodBeat.i(219466);
      try
      {
        if (zUH == null)
        {
          zUH = new a((byte)0);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
          localIntentFilter.addDataScheme("package");
          ak.getContext().registerReceiver(zUH, localIntentFilter);
          ae.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
        }
        AppMethodBeat.o(219466);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
          AppMethodBeat.o(219466);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void eau()
  {
    try
    {
      AppMethodBeat.i(219467);
      try
      {
        if (zUH != null)
        {
          ak.getContext().unregisterReceiver(zUH);
          zUH = null;
          ae.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
        }
        AppMethodBeat.o(219467);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ae.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
          AppMethodBeat.o(219467);
        }
      }
      return;
    }
    finally {}
  }
  
  private static String jG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219464);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(219464);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(219464);
      return paramString1;
    }
    AppMethodBeat.o(219464);
    return paramString2;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(219458);
    super.dUI();
    AppMethodBeat.o(219458);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(219459);
    try
    {
      super.dUJ();
      Object localObject1 = new HashMap();
      ((Map)localObject1).put("fontNormalColor", jG(this.zUI.zPM, "#FFFFFF"));
      ((Map)localObject1).put("fontDisableColor", jG(this.zUI.zPN, "#4CFFFFFF"));
      ((Map)localObject1).put("fontPressedColor", jG(this.zUI.zPO, "#99FFFFFF"));
      ((Map)localObject1).put("NormalColor", jG(this.zUI.zPG, "#1AAD19"));
      ((Map)localObject1).put("PressedColor", jG(this.zUI.zPI, "#179B16"));
      ((Map)localObject1).put("DisableColor", jG(this.zUI.zPH, "#661AAD19"));
      ((Map)localObject1).put("borderNormalColor", jG(this.zUI.zPJ, "#179E16"));
      ((Map)localObject1).put("borderPressedColor", jG(this.zUI.zPL, "#158E14"));
      ((Map)localObject1).put("borderDisableColor", jG(this.zUI.zPK, "#00179E16"));
      int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
      int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
      int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
      int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
      int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
      int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
      int i3 = (int)eaI().zQv;
      int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
      int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
      int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
      int i = this.context.getResources().getDimensionPixelSize(2131165207);
      if (eaI().tm > 0.0F) {
        i = (int)eaI().tm;
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
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setCornerRadius(i);
      localGradientDrawable.setColor(n);
      localGradientDrawable.setStroke(i3, i4);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
      localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject2);
      localStateListDrawable.addState(new int[] { 16842910 }, localGradientDrawable);
      this.zVi.setBackground(localStateListDrawable);
      localObject1 = new int[] { -16842910 };
      localObject2 = new int[] { 16842910 };
      this.zVi.setTextColor(new ColorStateList(new int[][] { localObject1, { 16842919 }, localObject2 }, new int[] { k, m, j }));
      if (this.zUI.fontSize > 0.0F) {
        this.zVi.setTextSize(0, this.zUI.fontSize);
      }
      if ((this.zUK) && (this.zVi != null)) {
        this.zVi.setText(2131763753);
      }
      AppMethodBeat.o(219459);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
      AppMethodBeat.o(219459);
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(219462);
    super.dUK();
    try
    {
      ae.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
      ar.ay(zUL);
      eat();
      a locala;
      if (zUH != null)
      {
        locala = zUH;
        if (TextUtils.isEmpty(this.zUJ))
        {
          ae.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
          AppMethodBeat.o(219462);
          return;
        }
      }
      AppMethodBeat.o(219462);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        locala.eav();
        locala.c(this);
        AppMethodBeat.o(219462);
        return;
      }
      catch (Throwable localThrowable2)
      {
        ae.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
      }
      localThrowable1 = localThrowable1;
      ae.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
      AppMethodBeat.o(219462);
      return;
    }
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(219463);
    super.dUM();
    try
    {
      ae.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
      ar.ay(zUL);
      ar.o(zUL, 300000L);
      AppMethodBeat.o(219463);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
      AppMethodBeat.o(219463);
    }
  }
  
  protected final void ear()
  {
    AppMethodBeat.i(219457);
    String str1;
    if (this.zUK)
    {
      Context localContext = this.context;
      try
      {
        localObject = bu.bI(this.zUJ, "");
        str1 = bu.bI(this.zUI.zMz, "");
        String str2 = bu.bI(this.zUI.zPC, "");
        String str3 = bu.bI(this.zUI.dwb, "");
        af localaf = eaD();
        k.a(localContext, str3, (String)localObject, str2, str1, localaf.dGD, localaf.zsJ, localaf.getSnsId(), 1, 2);
        AppMethodBeat.o(219457);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AppMethodBeat.o(219457);
        return;
      }
    }
    Intent localIntent = this.zUI.zPT;
    Object localObject = this.context;
    try
    {
      if (!(localObject instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      str1 = bu.bI(z.getStringExtra(localIntent, "market_app_name"), "");
      an.a((Context)localObject, localIntent.getPackage(), "", localIntent, str1, new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(219448);
          if (paramAnonymousBoolean1) {
            k.jn(l.a(l.this), l.b(l.this).zMz);
          }
          AppMethodBeat.o(219448);
        }
      }, 2);
      AppMethodBeat.o(219457);
      return;
    }
    catch (Throwable localThrowable2)
    {
      I(2, 1, "");
      AppMethodBeat.o(219457);
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<WeakReference<l>> zUN;
    final Map<String, af> zUO;
    
    private a()
    {
      AppMethodBeat.i(219450);
      this.zUN = new LinkedList();
      this.zUO = new ConcurrentHashMap();
      AppMethodBeat.o(219450);
    }
    
    private static String aM(Intent paramIntent)
    {
      AppMethodBeat.i(219455);
      try
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        AppMethodBeat.o(219455);
        return paramIntent;
      }
      catch (Throwable paramIntent)
      {
        AppMethodBeat.o(219455);
      }
      return "";
    }
    
    private void e(String paramString1, boolean paramBoolean, String paramString2)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(219454);
          Iterator localIterator = this.zUN.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject = (WeakReference)localIterator.next();
          if ((localObject != null) && (((WeakReference)localObject).get() != null))
          {
            localObject = (l)((WeakReference)localObject).get();
            if (paramString1.equals(l.a((l)localObject)))
            {
              l.a((l)localObject, paramBoolean);
              if (paramBoolean) {
                l.a((l)localObject, paramString2);
              } else {
                l.a((l)localObject, l.b((l)localObject).title);
              }
            }
          }
        }
        finally {}
      }
      AppMethodBeat.o(219454);
    }
    
    /* Error */
    final void c(l paraml)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 111
      //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:zUN	Ljava/util/List;
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
      //   46: invokestatic 121	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   67: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:zUN	Ljava/util/List;
      //   70: aload_2
      //   71: invokeinterface 127 2 0
      //   76: pop
      //   77: aload_0
      //   78: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:zUO	Ljava/util/Map;
      //   81: aload_1
      //   82: invokestatic 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l;)Ljava/lang/String;
      //   85: aload_1
      //   86: invokevirtual 131	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:eaD	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/af;
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
      //   0	108	1	paraml	l
      //   16	55	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	17	103	finally
      //   17	54	103	finally
      //   57	100	103	finally
    }
    
    final void eav()
    {
      try
      {
        AppMethodBeat.i(219452);
        Iterator localIterator = this.zUN.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            localIterator.remove();
          }
        }
        AppMethodBeat.o(219452);
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(219453);
      String str;
      if (paramIntent != null)
      {
        try
        {
          str = paramIntent.getAction();
          if (!"android.intent.action.PACKAGE_ADDED".equals(str)) {
            break label108;
          }
          paramIntent = aM(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            e(paramIntent, true, paramContext.getString(2131763753));
            try
            {
              paramContext = (af)this.zUO.get(paramIntent);
              if (paramContext != null) {
                l.a(paramContext, 3, "0", "");
              }
              AppMethodBeat.o(219453);
              return;
            }
            catch (Throwable paramContext)
            {
              ae.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report error?");
            }
          }
          AppMethodBeat.o(219453);
          return;
        }
        catch (Throwable paramContext)
        {
          ae.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
        }
      }
      else
      {
        AppMethodBeat.o(219453);
        return;
      }
      label108:
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        paramContext = aM(paramIntent);
        if (!TextUtils.isEmpty(paramContext)) {
          e(paramContext, false, "");
        }
      }
      AppMethodBeat.o(219453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */