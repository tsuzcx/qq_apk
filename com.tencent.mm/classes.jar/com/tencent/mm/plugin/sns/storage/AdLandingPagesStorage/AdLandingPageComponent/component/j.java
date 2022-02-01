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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
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
  private static a ymI;
  private static Runnable ymM;
  private b ymJ;
  private String ymK;
  private boolean ymL;
  
  static
  {
    AppMethodBeat.i(200194);
    ymM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200171);
        j.access$100();
        AppMethodBeat.o(200171);
      }
    };
    AppMethodBeat.o(200194);
  }
  
  public j(Context paramContext, b paramb, ViewGroup paramViewGroup)
  {
    super(paramContext, paramb, paramViewGroup);
    AppMethodBeat.i(200178);
    this.ymJ = paramb;
    paramViewGroup = "";
    paramContext = paramViewGroup;
    if (paramb != null)
    {
      if (paramb.yim != null) {
        paramViewGroup = paramb.yim.getStringExtra("target_app_id");
      }
      paramContext = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        paramContext = paramb.JG;
      }
    }
    this.ymK = paramContext;
    this.ymL = auF(this.ymK);
    if (dKw() == 3) {
      G(4, 1, "");
    }
    for (;;)
    {
      G(1, 0, "");
      AppMethodBeat.o(200178);
      return;
      G(4, 0, "");
    }
  }
  
  private void G(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(200187);
    try
    {
      a(dKH(), paramInt1, String.valueOf(paramInt2), paramString);
      AppMethodBeat.o(200187);
      return;
    }
    catch (Throwable paramString)
    {
      ac.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramString.toString());
      AppMethodBeat.o(200187);
    }
  }
  
  static void a(ae paramae, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(200190);
    try
    {
      String str1 = bs.nullAsNil(paramae.getSnsId());
      String str2 = com.tencent.mm.plugin.sns.data.h.asK(paramae.dtx);
      paramae = bs.nullAsNil(paramae.xOm);
      com.tencent.mm.plugin.report.service.h.wUl.f(19790, new Object[] { str1, str2, paramae, Integer.valueOf(paramInt), paramString1, paramString2 });
      ac.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + str1 + ", uxInfo=" + str2 + ", adExtInfo =" + paramae + ", actType =" + paramInt + ", actValue = " + paramString1 + ", extInfo = " + paramString2);
      AppMethodBeat.o(200190);
      return;
    }
    catch (Exception paramae)
    {
      ac.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramae.toString());
      AppMethodBeat.o(200190);
    }
  }
  
  private static boolean auF(String paramString)
  {
    AppMethodBeat.i(200182);
    try
    {
      boolean bool = AdLandingPagesProxy.getInstance().isPkgInstalled(paramString);
      AppMethodBeat.o(200182);
      return bool;
    }
    catch (Throwable paramString)
    {
      ac.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
      AppMethodBeat.o(200182);
    }
    return false;
  }
  
  private int dKw()
  {
    AppMethodBeat.i(200183);
    try
    {
      int i = x.getIntExtra(this.ymJ.yim, "market_priority", 1);
      AppMethodBeat.o(200183);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
      AppMethodBeat.o(200183);
    }
    return 0;
  }
  
  private static void dKx()
  {
    try
    {
      AppMethodBeat.i(200188);
      try
      {
        if (ymI == null)
        {
          ymI = new a((byte)0);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
          localIntentFilter.addDataScheme("package");
          ai.getContext().registerReceiver(ymI, localIntentFilter);
          ac.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
        }
        AppMethodBeat.o(200188);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
          AppMethodBeat.o(200188);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void dKy()
  {
    try
    {
      AppMethodBeat.i(200189);
      try
      {
        if (ymI != null)
        {
          ai.getContext().unregisterReceiver(ymI);
          ymI = null;
          ac.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
        }
        AppMethodBeat.o(200189);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
          AppMethodBeat.o(200189);
        }
      }
      return;
    }
    finally {}
  }
  
  private static String jn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200186);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(200186);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(200186);
      return paramString1;
    }
    AppMethodBeat.o(200186);
    return paramString2;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(200180);
    super.dJW();
    AppMethodBeat.o(200180);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(200185);
    super.dJX();
    try
    {
      ac.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
      ap.aB(ymM);
      ap.n(ymM, 300000L);
      AppMethodBeat.o(200185);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
      AppMethodBeat.o(200185);
    }
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(200184);
    super.dJY();
    try
    {
      ac.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
      ap.aB(ymM);
      dKx();
      a locala;
      if (ymI != null)
      {
        locala = ymI;
        if (TextUtils.isEmpty(this.ymK))
        {
          ac.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
          AppMethodBeat.o(200184);
          return;
        }
      }
      AppMethodBeat.o(200184);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        locala.dKz();
        locala.c(this);
        AppMethodBeat.o(200184);
        return;
      }
      catch (Throwable localThrowable2)
      {
        ac.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
      }
      localThrowable1 = localThrowable1;
      ac.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
      AppMethodBeat.o(200184);
      return;
    }
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(200181);
    try
    {
      super.dKm();
      Object localObject = new HashMap();
      ((Map)localObject).put("fontNormalColor", jn(this.ymJ.yif, "#FFFFFF"));
      ((Map)localObject).put("fontDisableColor", jn(this.ymJ.yig, "#4CFFFFFF"));
      ((Map)localObject).put("fontPressedColor", jn(this.ymJ.yih, "#99FFFFFF"));
      ((Map)localObject).put("NormalColor", jn(this.ymJ.yhZ, "#1AAD19"));
      ((Map)localObject).put("PressedColor", jn(this.ymJ.yib, "#179B16"));
      ((Map)localObject).put("DisableColor", jn(this.ymJ.yia, "#661AAD19"));
      ((Map)localObject).put("borderNormalColor", jn(this.ymJ.yic, "#179E16"));
      ((Map)localObject).put("borderPressedColor", jn(this.ymJ.yie, "#158E14"));
      ((Map)localObject).put("borderDisableColor", jn(this.ymJ.yid, "#00179E16"));
      int j = Color.parseColor((String)((Map)localObject).get("fontNormalColor"));
      int k = Color.parseColor((String)((Map)localObject).get("fontDisableColor"));
      int m = Color.parseColor((String)((Map)localObject).get("fontPressedColor"));
      int n = Color.parseColor((String)((Map)localObject).get("NormalColor"));
      int i1 = Color.parseColor((String)((Map)localObject).get("PressedColor"));
      int i2 = Color.parseColor((String)((Map)localObject).get("DisableColor"));
      int i3 = (int)dKN().yiO;
      int i4 = Color.parseColor((String)((Map)localObject).get("borderNormalColor"));
      int i5 = Color.parseColor((String)((Map)localObject).get("borderPressedColor"));
      int i6 = Color.parseColor((String)((Map)localObject).get("borderDisableColor"));
      int i = this.context.getResources().getDimensionPixelSize(2131165207);
      if (dKN().rs > 0.0F) {
        i = (int)dKN().rs;
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
      this.ynj.setBackground(localStateListDrawable);
      localObject = new int[] { 16842919 };
      this.ynj.setTextColor(new ColorStateList(new int[][] { { -16842910 }, localObject, { 16842910 } }, new int[] { k, m, j }));
      if (this.ymJ.bsJ > 0.0F) {
        this.ynj.setTextSize(0, this.ymJ.bsJ);
      }
      if ((this.ymL) && (this.ynj != null)) {
        this.ynj.setText(2131763753);
      }
      AppMethodBeat.o(200181);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
      AppMethodBeat.o(200181);
    }
  }
  
  protected final void dKv()
  {
    AppMethodBeat.i(200179);
    String str1;
    if (this.ymL)
    {
      Context localContext = this.context;
      try
      {
        localObject = bs.bG(this.ymK, "");
        str1 = bs.bG(this.ymJ.yfc, "");
        String str2 = bs.bG(this.ymJ.yhV, "");
        String str3 = bs.bG(this.ymJ.djj, "");
        ae localae = dKH();
        com.tencent.mm.plugin.sns.data.j.a(localContext, str3, (String)localObject, str2, str1, localae.dtx, localae.xOm, localae.getSnsId(), 1);
        AppMethodBeat.o(200179);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AppMethodBeat.o(200179);
        return;
      }
    }
    Intent localIntent = this.ymJ.yim;
    Object localObject = this.context;
    try
    {
      if (!(localObject instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      str1 = bs.bG(x.getStringExtra(localIntent, "market_app_name"), "");
      al.a((Context)localObject, localIntent.getPackage(), "", localIntent, str1, new am()
      {
        public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(200170);
          if (paramAnonymousBoolean1)
          {
            j.a(j.this, 0, "");
            AppMethodBeat.o(200170);
            return;
          }
          j.a(j.this, 2, "");
          AppMethodBeat.o(200170);
        }
      });
      AppMethodBeat.o(200179);
      return;
    }
    catch (Throwable localThrowable2)
    {
      G(2, 1, "");
      AppMethodBeat.o(200179);
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<WeakReference<j>> ymO;
    final Map<String, ae> ymP;
    
    private a()
    {
      AppMethodBeat.i(200172);
      this.ymO = new LinkedList();
      this.ymP = new ConcurrentHashMap();
      AppMethodBeat.o(200172);
    }
    
    private static String aG(Intent paramIntent)
    {
      AppMethodBeat.i(200177);
      try
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        AppMethodBeat.o(200177);
        return paramIntent;
      }
      catch (Throwable paramIntent)
      {
        AppMethodBeat.o(200177);
      }
      return "";
    }
    
    private void e(String paramString1, boolean paramBoolean, String paramString2)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(200176);
          Iterator localIterator = this.ymO.iterator();
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
      AppMethodBeat.o(200176);
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
      //   8: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j$a:ymO	Ljava/util/List;
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
      //   46: invokestatic 121	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   67: getfield 29	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j$a:ymO	Ljava/util/List;
      //   70: aload_2
      //   71: invokeinterface 127 2 0
      //   76: pop
      //   77: aload_0
      //   78: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j$a:ymP	Ljava/util/Map;
      //   81: aload_1
      //   82: invokestatic 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:a	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j;)Ljava/lang/String;
      //   85: aload_1
      //   86: invokevirtual 131	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/j:dKH	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ae;
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
    
    final void dKz()
    {
      try
      {
        AppMethodBeat.i(200174);
        Iterator localIterator = this.ymO.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            localIterator.remove();
          }
        }
        AppMethodBeat.o(200174);
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(200175);
      String str;
      if (paramIntent != null)
      {
        try
        {
          str = paramIntent.getAction();
          if (!"android.intent.action.PACKAGE_ADDED".equals(str)) {
            break label108;
          }
          paramIntent = aG(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            e(paramIntent, true, paramContext.getString(2131763753));
            try
            {
              paramContext = (ae)this.ymP.get(paramIntent);
              if (paramContext != null) {
                j.a(paramContext, 3, "0", "");
              }
              AppMethodBeat.o(200175);
              return;
            }
            catch (Throwable paramContext)
            {
              ac.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report error?");
            }
          }
          AppMethodBeat.o(200175);
          return;
        }
        catch (Throwable paramContext)
        {
          ac.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
        }
      }
      else
      {
        AppMethodBeat.o(200175);
        return;
      }
      label108:
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        paramContext = aG(paramIntent);
        if (!TextUtils.isEmpty(paramContext)) {
          e(paramContext, false, "");
        }
      }
      AppMethodBeat.o(200175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */