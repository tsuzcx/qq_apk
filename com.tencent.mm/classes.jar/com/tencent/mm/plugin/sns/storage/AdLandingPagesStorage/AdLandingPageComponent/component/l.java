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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.d.a;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.ad.f.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static a Kqr;
  private static Runnable Kqw;
  private String JEE;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b Kqs;
  private String Kqt;
  private boolean Kqu;
  private b Kqv;
  private String adExtInfo;
  private int enterScene;
  private String nTp;
  private String owd;
  private String pId;
  private String uxInfo;
  
  static
  {
    AppMethodBeat.i(206491);
    Kqw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212626);
        l.access$400();
        AppMethodBeat.o(212626);
      }
    };
    AppMethodBeat.o(206491);
  }
  
  public l(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(206472);
    this.Kqs = paramb;
    paramViewGroup = "";
    paramContext = paramViewGroup;
    if (paramb != null)
    {
      if (paramb.Kla != null) {
        paramViewGroup = paramb.Kla.getStringExtra("target_app_id");
      }
      paramContext = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        paramContext = paramb.abY;
      }
    }
    this.Kqt = paramContext;
    this.Kqu = baV(this.Kqt);
    if (fRd() == 3) {
      I(4, 1, "");
    }
    for (;;)
    {
      I(1, 0, "");
      try
      {
        this.uxInfo = Util.nullAsNil(fRp().uxInfo);
        this.adExtInfo = Util.nullAsNil(fRp().adExtInfo);
        this.JEE = Util.nullAsNil(fRp().aid);
        this.pId = Util.nullAsNil(fRp().pId);
        this.enterScene = fRp().source;
        this.nTp = Util.nullAsNil(fRp().nTp);
        this.owd = Util.nullAsNil(fRp().owd);
        this.Kqv = new b();
        AppMethodBeat.o(206472);
        return;
      }
      catch (Throwable paramContext)
      {
        Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", paramContext.toString());
        AppMethodBeat.o(206472);
      }
      I(4, 0, "");
    }
  }
  
  private void I(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(206484);
    try
    {
      a(fRp(), paramInt1, String.valueOf(paramInt2), paramString);
      AppMethodBeat.o(206484);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramString.toString());
      AppMethodBeat.o(206484);
    }
  }
  
  static void a(ai paramai, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206487);
    try
    {
      String str1 = Util.nullAsNil(paramai.getSnsId());
      String str2 = k.aYR(paramai.uxInfo);
      paramai = Util.nullAsNil(paramai.adExtInfo);
      h.IzE.a(19790, new Object[] { str1, str2, paramai, Integer.valueOf(paramInt), paramString1, paramString2 });
      Log.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + str1 + ", uxInfo=" + str2 + ", adExtInfo =" + paramai + ", actType =" + paramInt + ", actValue = " + paramString1 + ", extInfo = " + paramString2);
      AppMethodBeat.o(206487);
      return;
    }
    catch (Exception paramai)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramai.toString());
      AppMethodBeat.o(206487);
    }
  }
  
  private static boolean baV(String paramString)
  {
    AppMethodBeat.i(206476);
    try
    {
      boolean bool = AdLandingPagesProxy.getInstance().isPkgInstalled(paramString);
      AppMethodBeat.o(206476);
      return bool;
    }
    catch (Throwable paramString)
    {
      Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
      AppMethodBeat.o(206476);
    }
    return false;
  }
  
  private void baW(String paramString)
  {
    AppMethodBeat.i(206478);
    if (this.KqS != null)
    {
      this.KqS.setText(paramString);
      i.a(this.context, (r)this.KqB, this.KqS);
    }
    AppMethodBeat.o(206478);
  }
  
  private int fRd()
  {
    AppMethodBeat.i(206479);
    try
    {
      int i = IntentUtil.getIntExtra(this.Kqs.Kla, "market_priority", 1);
      AppMethodBeat.o(206479);
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
      AppMethodBeat.o(206479);
    }
    return 0;
  }
  
  private static void fRe()
  {
    try
    {
      AppMethodBeat.i(206485);
      try
      {
        if (Kqr == null)
        {
          Kqr = new a((byte)0);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
          localIntentFilter.addDataScheme("package");
          MMApplicationContext.getContext().registerReceiver(Kqr, localIntentFilter);
          Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
        }
        AppMethodBeat.o(206485);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
          AppMethodBeat.o(206485);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void fRf()
  {
    try
    {
      AppMethodBeat.i(206486);
      try
      {
        if (Kqr != null)
        {
          MMApplicationContext.getContext().unregisterReceiver(Kqr);
          Kqr = null;
          Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
        }
        AppMethodBeat.o(206486);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
          AppMethodBeat.o(206486);
        }
      }
      return;
    }
    finally {}
  }
  
  private static String kO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206483);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(206483);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(206483);
      return paramString1;
    }
    AppMethodBeat.o(206483);
    return paramString2;
  }
  
  protected final void fKd()
  {
    AppMethodBeat.i(206473);
    String str1;
    Object localObject2;
    if (this.Kqu)
    {
      Context localContext = this.context;
      try
      {
        localObject1 = Util.nullAs(this.Kqt, "");
        str1 = Util.nullAs(this.Kqs.JxO, "");
        localObject2 = Util.nullAs(this.Kqs.KkJ, "");
        String str2 = Util.nullAs(this.Kqs.appid, "");
        ai localai = fRp();
        j localj = new j(this.owd, this.enterScene, this.JEE, this.nTp, this.pId);
        m.a(localContext, str2, (String)localObject1, (String)localObject2, str1, localai.uxInfo, localai.adExtInfo, localai.getSnsId(), 1, 2, localj);
        AppMethodBeat.o(206473);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AppMethodBeat.o(206473);
        return;
      }
    }
    Intent localIntent = this.Kqs.Kla;
    Object localObject1 = this.context;
    try
    {
      if (!(localObject1 instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      str1 = Util.nullAs(IntentUtil.getStringExtra(localIntent, "market_app_name"), "");
      localObject2 = new com.tencent.mm.plugin.sns.data.b(this.uxInfo, this.owd, this.enterScene, this.adExtInfo, this.JEE, this.nTp, this.pId);
      com.tencent.mm.plugin.sns.ad.d.b.a((com.tencent.mm.plugin.sns.data.b)localObject2, 3);
      ao.a((Context)localObject1, localIntent.getPackage(), "", localIntent, str1, new al()
      {
        public final void y(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(269711);
          if (paramAnonymousBoolean1)
          {
            l.a(l.this).JSg = System.currentTimeMillis();
            if (l.fRg() != null) {
              l.fRg().KqA.put(l.b(l.this), l.a(l.this));
            }
            com.tencent.mm.plugin.sns.ad.d.b.b(this.JRc, 3);
            a.kl(l.b(l.this), l.c(l.this).JxO);
          }
          AppMethodBeat.o(269711);
        }
      }, 2);
      AppMethodBeat.o(206473);
      return;
    }
    catch (Throwable localThrowable2)
    {
      I(2, 1, "");
      AppMethodBeat.o(206473);
    }
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(206475);
    for (;;)
    {
      try
      {
        super.fKe();
        Object localObject = new HashMap();
        ((Map)localObject).put("fontNormalColor", kO(this.Kqs.KkT, "#FFFFFF"));
        ((Map)localObject).put("fontDisableColor", kO(this.Kqs.KkU, "#4CFFFFFF"));
        ((Map)localObject).put("fontPressedColor", kO(this.Kqs.KkV, "#99FFFFFF"));
        ((Map)localObject).put("NormalColor", kO(this.Kqs.KkN, "#1AAD19"));
        ((Map)localObject).put("PressedColor", kO(this.Kqs.KkP, "#179B16"));
        ((Map)localObject).put("DisableColor", kO(this.Kqs.KkO, "#661AAD19"));
        ((Map)localObject).put("borderNormalColor", kO(this.Kqs.KkQ, "#179E16"));
        ((Map)localObject).put("borderPressedColor", kO(this.Kqs.KkS, "#158E14"));
        ((Map)localObject).put("borderDisableColor", kO(this.Kqs.KkR, "#00179E16"));
        int j = Color.parseColor((String)((Map)localObject).get("fontNormalColor"));
        int k = Color.parseColor((String)((Map)localObject).get("fontDisableColor"));
        int m = Color.parseColor((String)((Map)localObject).get("fontPressedColor"));
        int n = Color.parseColor((String)((Map)localObject).get("NormalColor"));
        int i1 = Color.parseColor((String)((Map)localObject).get("PressedColor"));
        int i2 = Color.parseColor((String)((Map)localObject).get("DisableColor"));
        int i3 = (int)((r)this.KqB).KlN;
        int i4 = Color.parseColor((String)((Map)localObject).get("borderNormalColor"));
        int i5 = Color.parseColor((String)((Map)localObject).get("borderPressedColor"));
        int i6 = Color.parseColor((String)((Map)localObject).get("borderDisableColor"));
        int i = this.context.getResources().getDimensionPixelSize(i.d.ButtonCornerSize);
        if (((r)this.KqB).bDI > 0.0F)
        {
          i = (int)((r)this.KqB).bDI;
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
          this.KqS.setBackground(localStateListDrawable);
          localObject = new int[] { 16842919 };
          this.KqS.setTextColor(new ColorStateList(new int[][] { { -16842910 }, localObject, { 16842910 } }, new int[] { k, m, j }));
          if (this.Kqs.fontSize > 0.0F) {
            this.KqS.setTextSize(0, this.Kqs.fontSize);
          }
          if (this.Kqu)
          {
            if (Util.isNullOrNil(this.Kqs.Klb))
            {
              i = i.j.sns_ad_download_apk_open;
              if (this.KqS != null)
              {
                this.KqS.setText(i);
                i.a(this.context, (r)this.KqB, this.KqS);
              }
              AppMethodBeat.o(206475);
              return;
            }
            baW(this.Kqs.Klb);
          }
          AppMethodBeat.o(206475);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
        AppMethodBeat.o(206475);
        return;
      }
    }
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(206481);
    super.fKk();
    try
    {
      Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
      MMHandlerThread.removeRunnable(Kqw);
      fRe();
      a locala;
      if (Kqr != null)
      {
        locala = Kqr;
        if (TextUtils.isEmpty(this.Kqt))
        {
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
          AppMethodBeat.o(206481);
          return;
        }
      }
      AppMethodBeat.o(206481);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        locala.fRh();
        locala.d(this);
        AppMethodBeat.o(206481);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
      }
      localThrowable1 = localThrowable1;
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
      AppMethodBeat.o(206481);
      return;
    }
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(206482);
    super.fKo();
    try
    {
      Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
      MMHandlerThread.removeRunnable(Kqw);
      MMHandlerThread.postToMainThreadDelayed(Kqw, 300000L);
      AppMethodBeat.o(206482);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
      AppMethodBeat.o(206482);
    }
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(206474);
    super.fKp();
    AppMethodBeat.o(206474);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final Map<String, l.b> KqA;
    final List<WeakReference<l>> Kqy;
    final Map<String, ai> Kqz;
    
    private a()
    {
      AppMethodBeat.i(226384);
      this.Kqy = new LinkedList();
      this.Kqz = new ConcurrentHashMap();
      this.KqA = new ConcurrentHashMap();
      AppMethodBeat.o(226384);
    }
    
    private static String aW(Intent paramIntent)
    {
      AppMethodBeat.i(226406);
      try
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        AppMethodBeat.o(226406);
        return paramIntent;
      }
      catch (Throwable paramIntent)
      {
        AppMethodBeat.o(226406);
      }
      return "";
    }
    
    private void d(String paramString1, boolean paramBoolean, String paramString2)
    {
      for (;;)
      {
        Object localObject;
        try
        {
          AppMethodBeat.i(226405);
          Iterator localIterator = this.Kqy.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (WeakReference)localIterator.next();
          if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
            continue;
          }
          localObject = (l)((WeakReference)localObject).get();
          if (!paramString1.equals(l.b((l)localObject))) {
            continue;
          }
          l.a((l)localObject, paramBoolean);
          if (!paramBoolean) {
            break label130;
          }
          if (Util.isNullOrNil(l.c((l)localObject).Klb))
          {
            l.a((l)localObject, paramString2);
            continue;
          }
          l.a((l)localObject, l.c((l)localObject).Klb);
        }
        finally {}
        continue;
        label130:
        l.a((l)localObject, l.c((l)localObject).title);
      }
      AppMethodBeat.o(226405);
    }
    
    /* Error */
    final void d(l paraml)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 124
      //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 31	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:Kqy	Ljava/util/List;
      //   11: invokeinterface 72 1 0
      //   16: astore_2
      //   17: aload_2
      //   18: invokeinterface 78 1 0
      //   23: ifeq +34 -> 57
      //   26: aload_2
      //   27: invokeinterface 82 1 0
      //   32: checkcast 84	java/lang/ref/WeakReference
      //   35: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   38: aload_1
      //   39: if_acmpne -22 -> 17
      //   42: ldc 126
      //   44: ldc 128
      //   46: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   49: ldc 124
      //   51: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_0
      //   55: monitorexit
      //   56: return
      //   57: new 84	java/lang/ref/WeakReference
      //   60: dup
      //   61: aload_1
      //   62: invokespecial 136	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
      //   65: astore_2
      //   66: aload_0
      //   67: getfield 31	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:Kqy	Ljava/util/List;
      //   70: aload_2
      //   71: invokeinterface 139 2 0
      //   76: pop
      //   77: aload_0
      //   78: getfield 36	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:Kqz	Ljava/util/Map;
      //   81: aload_1
      //   82: invokestatic 91	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l;)Ljava/lang/String;
      //   85: aload_1
      //   86: invokevirtual 143	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:fRp	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
      //   89: invokeinterface 149 3 0
      //   94: pop
      //   95: ldc 124
      //   97: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    final void fRh()
    {
      try
      {
        AppMethodBeat.i(226395);
        Iterator localIterator = this.Kqy.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            localIterator.remove();
          }
        }
        AppMethodBeat.o(226395);
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(226403);
      String str;
      if (paramIntent != null)
      {
        try
        {
          str = paramIntent.getAction();
          if (!"android.intent.action.PACKAGE_ADDED".equals(str)) {
            break label188;
          }
          paramIntent = aW(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            d(paramIntent, true, paramContext.getString(i.j.sns_ad_download_apk_open));
            try
            {
              paramContext = (ai)this.Kqz.get(paramIntent);
              if (paramContext != null)
              {
                l.a(paramContext, 3, "0", "");
                paramContext = new com.tencent.mm.plugin.sns.data.b(paramContext.uxInfo, paramContext.owd, paramContext.source, paramContext.adExtInfo, paramContext.aid, paramContext.nTp, paramContext.pId);
                if (!Util.isNullOrNil(paramIntent))
                {
                  paramIntent = (l.b)this.KqA.get(paramIntent);
                  if (paramIntent != null) {
                    paramContext.JPI = ((int)(System.currentTimeMillis() - paramIntent.JSg));
                  }
                  com.tencent.mm.plugin.sns.ad.d.b.c(paramContext, 3);
                }
              }
              AppMethodBeat.o(226403);
              return;
            }
            catch (Throwable paramContext)
            {
              Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report error?");
            }
          }
          AppMethodBeat.o(226403);
          return;
        }
        catch (Throwable paramContext)
        {
          Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
        }
      }
      else
      {
        AppMethodBeat.o(226403);
        return;
      }
      label188:
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        paramContext = aW(paramIntent);
        if (!TextUtils.isEmpty(paramContext)) {
          d(paramContext, false, "");
        }
      }
      AppMethodBeat.o(226403);
    }
  }
  
  static final class b
  {
    public long JSg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */