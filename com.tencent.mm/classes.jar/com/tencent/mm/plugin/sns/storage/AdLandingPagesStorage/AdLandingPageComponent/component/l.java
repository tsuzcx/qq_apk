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
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
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
  private static a EcP;
  private static Runnable EcT;
  private b EcQ;
  private String EcR;
  private boolean EcS;
  
  static
  {
    AppMethodBeat.i(202925);
    EcT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(202903);
        l.access$200();
        AppMethodBeat.o(202903);
      }
    };
    AppMethodBeat.o(202925);
  }
  
  public l(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(202910);
    this.EcQ = paramb;
    paramViewGroup = "";
    paramContext = paramViewGroup;
    if (paramb != null)
    {
      if (paramb.DXR != null) {
        paramViewGroup = paramb.DXR.getStringExtra("target_app_id");
      }
      paramContext = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        paramContext = paramb.LG;
      }
    }
    this.EcR = paramContext;
    this.EcS = aPX(this.EcR);
    if (fdg() == 3) {
      H(4, 1, "");
    }
    for (;;)
    {
      H(1, 0, "");
      AppMethodBeat.o(202910);
      return;
      H(4, 0, "");
    }
  }
  
  private void H(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(202919);
    try
    {
      a(fds(), paramInt1, String.valueOf(paramInt2), paramString);
      AppMethodBeat.o(202919);
      return;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramString.toString());
      AppMethodBeat.o(202919);
    }
  }
  
  static void a(ah paramah, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202922);
    try
    {
      String str1 = Util.nullAsNil(paramah.getSnsId());
      String str2 = i.aNZ(paramah.uxInfo);
      paramah = Util.nullAsNil(paramah.adExtInfo);
      h.CyF.a(19790, new Object[] { str1, str2, paramah, Integer.valueOf(paramInt), paramString1, paramString2 });
      Log.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + str1 + ", uxInfo=" + str2 + ", adExtInfo =" + paramah + ", actType =" + paramInt + ", actValue = " + paramString1 + ", extInfo = " + paramString2);
      AppMethodBeat.o(202922);
      return;
    }
    catch (Exception paramah)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramah.toString());
      AppMethodBeat.o(202922);
    }
  }
  
  private static boolean aPX(String paramString)
  {
    AppMethodBeat.i(202914);
    try
    {
      boolean bool = AdLandingPagesProxy.getInstance().isPkgInstalled(paramString);
      AppMethodBeat.o(202914);
      return bool;
    }
    catch (Throwable paramString)
    {
      Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
      AppMethodBeat.o(202914);
    }
    return false;
  }
  
  private int fdg()
  {
    AppMethodBeat.i(202915);
    try
    {
      int i = IntentUtil.getIntExtra(this.EcQ.DXR, "market_priority", 1);
      AppMethodBeat.o(202915);
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
      AppMethodBeat.o(202915);
    }
    return 0;
  }
  
  private static void fdh()
  {
    try
    {
      AppMethodBeat.i(202920);
      try
      {
        if (EcP == null)
        {
          EcP = new a((byte)0);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
          localIntentFilter.addDataScheme("package");
          MMApplicationContext.getContext().registerReceiver(EcP, localIntentFilter);
          Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
        }
        AppMethodBeat.o(202920);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
          AppMethodBeat.o(202920);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void fdi()
  {
    try
    {
      AppMethodBeat.i(202921);
      try
      {
        if (EcP != null)
        {
          MMApplicationContext.getContext().unregisterReceiver(EcP);
          EcP = null;
          Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
        }
        AppMethodBeat.o(202921);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
          AppMethodBeat.o(202921);
        }
      }
      return;
    }
    finally {}
  }
  
  private static String kt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202918);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(202918);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(202918);
      return paramString1;
    }
    AppMethodBeat.o(202918);
    return paramString2;
  }
  
  protected final void eWS()
  {
    AppMethodBeat.i(202911);
    String str1;
    if (this.EcS)
    {
      Context localContext = this.context;
      try
      {
        localObject = Util.nullAs(this.EcR, "");
        str1 = Util.nullAs(this.EcQ.appPageUrl, "");
        String str2 = Util.nullAs(this.EcQ.DXA, "");
        String str3 = Util.nullAs(this.EcQ.dNI, "");
        ah localah = fds();
        k.a(localContext, str3, (String)localObject, str2, str1, localah.uxInfo, localah.adExtInfo, localah.getSnsId(), 1, 2);
        AppMethodBeat.o(202911);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AppMethodBeat.o(202911);
        return;
      }
    }
    Intent localIntent = this.EcQ.DXR;
    Object localObject = this.context;
    try
    {
      if (!(localObject instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      str1 = Util.nullAs(IntentUtil.getStringExtra(localIntent, "market_app_name"), "");
      ap.a((Context)localObject, localIntent.getPackage(), "", localIntent, str1, new al()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(202902);
          if (paramAnonymousBoolean1) {
            k.jZ(l.a(l.this), l.b(l.this).appPageUrl);
          }
          AppMethodBeat.o(202902);
        }
      }, 2);
      AppMethodBeat.o(202911);
      return;
    }
    catch (Throwable localThrowable2)
    {
      H(2, 1, "");
      AppMethodBeat.o(202911);
    }
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(202913);
    try
    {
      super.eWT();
      Object localObject1 = new HashMap();
      ((Map)localObject1).put("fontNormalColor", kt(this.EcQ.DXK, "#FFFFFF"));
      ((Map)localObject1).put("fontDisableColor", kt(this.EcQ.DXL, "#4CFFFFFF"));
      ((Map)localObject1).put("fontPressedColor", kt(this.EcQ.DXM, "#99FFFFFF"));
      ((Map)localObject1).put("NormalColor", kt(this.EcQ.DXE, "#1AAD19"));
      ((Map)localObject1).put("PressedColor", kt(this.EcQ.DXG, "#179B16"));
      ((Map)localObject1).put("DisableColor", kt(this.EcQ.DXF, "#661AAD19"));
      ((Map)localObject1).put("borderNormalColor", kt(this.EcQ.DXH, "#179E16"));
      ((Map)localObject1).put("borderPressedColor", kt(this.EcQ.DXJ, "#158E14"));
      ((Map)localObject1).put("borderDisableColor", kt(this.EcQ.DXI, "#00179E16"));
      int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
      int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
      int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
      int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
      int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
      int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
      int i3 = (int)fdx().DYu;
      int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
      int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
      int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
      int i = this.context.getResources().getDimensionPixelSize(2131165210);
      if (fdx().tt > 0.0F) {
        i = (int)fdx().tt;
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
      this.Edp.setBackground(localStateListDrawable);
      localObject1 = new int[] { -16842910 };
      localObject2 = new int[] { 16842919 };
      this.Edp.setTextColor(new ColorStateList(new int[][] { localObject1, localObject2, { 16842910 } }, new int[] { k, m, j }));
      if (this.EcQ.fontSize > 0.0F) {
        this.Edp.setTextSize(0, this.EcQ.fontSize);
      }
      if ((this.EcS) && (this.Edp != null))
      {
        this.Edp.setText(2131765951);
        f.a(this.context, fdx(), this.Edp);
      }
      AppMethodBeat.o(202913);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
      AppMethodBeat.o(202913);
    }
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(202916);
    super.eWZ();
    try
    {
      Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
      MMHandlerThread.removeRunnable(EcT);
      fdh();
      a locala;
      if (EcP != null)
      {
        locala = EcP;
        if (TextUtils.isEmpty(this.EcR))
        {
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
          AppMethodBeat.o(202916);
          return;
        }
      }
      AppMethodBeat.o(202916);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        locala.fdj();
        locala.c(this);
        AppMethodBeat.o(202916);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
      }
      localThrowable1 = localThrowable1;
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
      AppMethodBeat.o(202916);
      return;
    }
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(202917);
    super.eXd();
    try
    {
      Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
      MMHandlerThread.removeRunnable(EcT);
      MMHandlerThread.postToMainThreadDelayed(EcT, 300000L);
      AppMethodBeat.o(202917);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
      AppMethodBeat.o(202917);
    }
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(202912);
    super.eXe();
    AppMethodBeat.o(202912);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<WeakReference<l>> EcV;
    final Map<String, ah> EcW;
    
    private a()
    {
      AppMethodBeat.i(202904);
      this.EcV = new LinkedList();
      this.EcW = new ConcurrentHashMap();
      AppMethodBeat.o(202904);
    }
    
    private static String aW(Intent paramIntent)
    {
      AppMethodBeat.i(202909);
      try
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        AppMethodBeat.o(202909);
        return paramIntent;
      }
      catch (Throwable paramIntent)
      {
        AppMethodBeat.o(202909);
      }
      return "";
    }
    
    private void e(String paramString1, boolean paramBoolean, String paramString2)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(202908);
          Iterator localIterator = this.EcV.iterator();
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
      AppMethodBeat.o(202908);
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
      //   8: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:EcV	Ljava/util/List;
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
      //   46: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   67: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:EcV	Ljava/util/List;
      //   70: aload_2
      //   71: invokeinterface 127 2 0
      //   76: pop
      //   77: aload_0
      //   78: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:EcW	Ljava/util/Map;
      //   81: aload_1
      //   82: invokestatic 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l;)Ljava/lang/String;
      //   85: aload_1
      //   86: invokevirtual 131	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:fds	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ah;
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
    
    final void fdj()
    {
      try
      {
        AppMethodBeat.i(202906);
        Iterator localIterator = this.EcV.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            localIterator.remove();
          }
        }
        AppMethodBeat.o(202906);
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(202907);
      String str;
      if (paramIntent != null)
      {
        try
        {
          str = paramIntent.getAction();
          if (!"android.intent.action.PACKAGE_ADDED".equals(str)) {
            break label108;
          }
          paramIntent = aW(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            e(paramIntent, true, paramContext.getString(2131765951));
            try
            {
              paramContext = (ah)this.EcW.get(paramIntent);
              if (paramContext != null) {
                l.a(paramContext, 3, "0", "");
              }
              AppMethodBeat.o(202907);
              return;
            }
            catch (Throwable paramContext)
            {
              Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report error?");
            }
          }
          AppMethodBeat.o(202907);
          return;
        }
        catch (Throwable paramContext)
        {
          Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
        }
      }
      else
      {
        AppMethodBeat.o(202907);
        return;
      }
      label108:
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        paramContext = aW(paramIntent);
        if (!TextUtils.isEmpty(paramContext)) {
          e(paramContext, false, "");
        }
      }
      AppMethodBeat.o(202907);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */