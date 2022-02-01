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
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.d.c;
import com.tencent.mm.plugin.sns.ad.g.j;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.pluginsdk.model.app.ap;
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
  extends r
{
  private static a QOC;
  private static Runnable QOH;
  private String PVG;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b QOD;
  private String QOE;
  private boolean QOF;
  private b QOG;
  private String adExtInfo;
  private int enterScene;
  private String pId;
  private String qTb;
  private String rzx;
  private String uxInfo;
  
  static
  {
    AppMethodBeat.i(307212);
    QOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(307250);
        l.aBU();
        AppMethodBeat.o(307250);
      }
    };
    AppMethodBeat.o(307212);
  }
  
  /* Error */
  public l(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b paramb, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokespecial 56	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/r:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/r;Landroid/view/ViewGroup;)V
    //   7: ldc 57
    //   9: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: aload_2
    //   14: putfield 59	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:QOD	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/b;
    //   17: ldc 61
    //   19: astore_3
    //   20: aload_3
    //   21: astore_1
    //   22: aload_2
    //   23: ifnull +34 -> 57
    //   26: aload_2
    //   27: getfield 67	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/b:QJh	Landroid/content/Intent;
    //   30: ifnull +13 -> 43
    //   33: aload_2
    //   34: getfield 67	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/b:QJh	Landroid/content/Intent;
    //   37: ldc 69
    //   39: invokevirtual 75	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: astore_1
    //   45: aload_3
    //   46: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +8 -> 57
    //   52: aload_2
    //   53: getfield 84	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/b:bJH	Ljava/lang/String;
    //   56: astore_1
    //   57: aload_0
    //   58: aload_1
    //   59: putfield 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:QOE	Ljava/lang/String;
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:QOE	Ljava/lang/String;
    //   67: invokestatic 90	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:aZw	(Ljava/lang/String;)Z
    //   70: putfield 92	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:QOF	Z
    //   73: aload_0
    //   74: invokespecial 96	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjb	()I
    //   77: iconst_3
    //   78: if_icmpne +131 -> 209
    //   81: aload_0
    //   82: iconst_4
    //   83: iconst_1
    //   84: ldc 61
    //   86: invokespecial 100	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:Q	(IILjava/lang/String;)V
    //   89: aload_0
    //   90: iconst_1
    //   91: iconst_0
    //   92: ldc 61
    //   94: invokespecial 100	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:Q	(IILjava/lang/String;)V
    //   97: aload_0
    //   98: aload_0
    //   99: invokevirtual 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   102: getfield 108	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:uxInfo	Ljava/lang/String;
    //   105: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   108: putfield 114	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:uxInfo	Ljava/lang/String;
    //   111: aload_0
    //   112: aload_0
    //   113: invokevirtual 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   116: getfield 116	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:adExtInfo	Ljava/lang/String;
    //   119: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   122: putfield 117	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:adExtInfo	Ljava/lang/String;
    //   125: aload_0
    //   126: aload_0
    //   127: invokevirtual 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   130: getfield 120	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:aid	Ljava/lang/String;
    //   133: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   136: putfield 122	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:PVG	Ljava/lang/String;
    //   139: aload_0
    //   140: aload_0
    //   141: invokevirtual 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   144: getfield 124	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:pId	Ljava/lang/String;
    //   147: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 125	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:pId	Ljava/lang/String;
    //   153: aload_0
    //   154: aload_0
    //   155: invokevirtual 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   158: getfield 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:source	I
    //   161: putfield 130	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:enterScene	I
    //   164: aload_0
    //   165: aload_0
    //   166: invokevirtual 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   169: getfield 132	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:qTb	Ljava/lang/String;
    //   172: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   175: putfield 133	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:qTb	Ljava/lang/String;
    //   178: aload_0
    //   179: aload_0
    //   180: invokevirtual 104	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
    //   183: getfield 135	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai:rzx	Ljava/lang/String;
    //   186: invokestatic 113	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 136	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:rzx	Ljava/lang/String;
    //   192: aload_0
    //   193: new 13	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$b
    //   196: dup
    //   197: invokespecial 137	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$b:<init>	()V
    //   200: putfield 139	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:QOG	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$b;
    //   203: ldc 57
    //   205: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: return
    //   209: aload_0
    //   210: iconst_4
    //   211: iconst_0
    //   212: ldc 61
    //   214: invokespecial 100	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:Q	(IILjava/lang/String;)V
    //   217: goto -128 -> 89
    //   220: astore_1
    //   221: ldc 141
    //   223: aload_1
    //   224: invokevirtual 147	java/lang/Throwable:toString	()Ljava/lang/String;
    //   227: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: ldc 57
    //   232: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	l
    //   0	236	1	paramContext	Context
    //   0	236	2	paramb	com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b
    //   0	236	3	paramViewGroup	android.view.ViewGroup
    // Exception table:
    //   from	to	target	type
    //   97	203	220	finally
  }
  
  private void Q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(307135);
    try
    {
      a(hjn(), paramInt1, String.valueOf(paramInt2), paramString);
      AppMethodBeat.o(307135);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramString.toString());
      AppMethodBeat.o(307135);
    }
  }
  
  static void a(ai paramai, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(307160);
    try
    {
      String str1 = Util.nullAsNil(paramai.getSnsId());
      String str2 = com.tencent.mm.plugin.sns.data.k.aXd(paramai.uxInfo);
      paramai = Util.nullAsNil(paramai.adExtInfo);
      h.OAn.b(19790, new Object[] { str1, str2, paramai, Integer.valueOf(paramInt), paramString1, paramString2 });
      Log.d("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 snsId=" + str1 + ", uxInfo=" + str2 + ", adExtInfo =" + paramai + ", actType =" + paramInt + ", actValue = " + paramString1 + ", extInfo = " + paramString2);
      AppMethodBeat.o(307160);
      return;
    }
    catch (Exception paramai)
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "report19790 exp:" + paramai.toString());
      AppMethodBeat.o(307160);
    }
  }
  
  private void aWr(String paramString)
  {
    AppMethodBeat.i(307115);
    if (this.QPn != null)
    {
      this.QPn.setText(paramString);
      com.tencent.mm.plugin.sns.ad.d.k.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV, this.QPn);
    }
    AppMethodBeat.o(307115);
  }
  
  private static boolean aZw(String paramString)
  {
    AppMethodBeat.i(307107);
    try
    {
      boolean bool = AdLandingPagesProxy.getInstance().isPkgInstalled(paramString);
      AppMethodBeat.o(307107);
      return bool;
    }
    finally
    {
      Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "isApkInstalled occur something wrong!");
      AppMethodBeat.o(307107);
    }
    return false;
  }
  
  private int hjb()
  {
    AppMethodBeat.i(307120);
    try
    {
      int i = IntentUtil.getIntExtra(this.QOD.QJh, "market_priority", 1);
      AppMethodBeat.o(307120);
      return i;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "getMarketPriority has something wrong");
      AppMethodBeat.o(307120);
    }
    return 0;
  }
  
  private static void hjc()
  {
    try
    {
      AppMethodBeat.i(307147);
      try
      {
        if (QOC == null)
        {
          QOC = new a((byte)0);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
          localIntentFilter.addDataScheme("package");
          MMApplicationContext.getContext().registerReceiver(QOC, localIntentFilter);
          Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver register");
        }
        AppMethodBeat.o(307147);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "register broadcast receiver failed");
          AppMethodBeat.o(307147);
        }
      }
      return;
    }
    finally {}
  }
  
  private static void hjd()
  {
    try
    {
      AppMethodBeat.i(307152);
      try
      {
        if (QOC != null)
        {
          MMApplicationContext.getContext().unregisterReceiver(QOC);
          QOC = null;
          Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "the broadcast receiver unregister");
        }
        AppMethodBeat.o(307152);
      }
      finally
      {
        for (;;)
        {
          localObject1 = finally;
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "unregister broadcast receiver failed");
          AppMethodBeat.o(307152);
        }
      }
      return;
    }
    finally {}
  }
  
  private static String mv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307129);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(307129);
      return paramString2;
    }
    if (paramString1.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?"))
    {
      AppMethodBeat.o(307129);
      return paramString1;
    }
    AppMethodBeat.o(307129);
    return paramString2;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(307230);
    super.Gs();
    AppMethodBeat.o(307230);
  }
  
  protected final void hac()
  {
    AppMethodBeat.i(307222);
    String str1;
    Object localObject4;
    if (this.QOF)
    {
      Context localContext = this.context;
      try
      {
        localObject3 = Util.nullAs(this.QOE, "");
        str1 = Util.nullAs(this.QOD.PLD, "");
        localObject4 = Util.nullAs(this.QOD.QIQ, "");
        String str2 = Util.nullAs(this.QOD.appid, "");
        ai localai = hjn();
        j localj = new j(this.rzx, this.enterScene, this.PVG, this.qTb, this.pId);
        m.a(localContext, str2, (String)localObject3, (String)localObject4, str1, localai.uxInfo, localai.adExtInfo, localai.getSnsId(), 1, 2, localj);
      }
      finally
      {
        AppMethodBeat.o(307222);
        return;
      }
    }
    Intent localIntent = this.QOD.QJh;
    Object localObject3 = this.context;
    try
    {
      if (!(localObject3 instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      str1 = Util.nullAs(IntentUtil.getStringExtra(localIntent, "market_app_name"), "");
      localObject4 = new com.tencent.mm.plugin.sns.data.b(this.uxInfo, this.rzx, this.enterScene, this.adExtInfo, this.PVG, this.qTb, this.pId);
      c.a((com.tencent.mm.plugin.sns.data.b)localObject4, 3);
      ar.a((Context)localObject3, localIntent.getPackage(), "", localIntent, str1, new ap()
      {
        public final void onLaunchApp(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(307246);
          if (paramAnonymousBoolean1)
          {
            l.a(l.this, 0, "");
            l.a(l.this).QoS = System.currentTimeMillis();
            if (l.hje() != null) {
              l.hje().QOL.put(l.b(l.this), l.a(l.this));
            }
            c.b(this.QnO, 3);
            com.tencent.mm.plugin.sns.ad.d.b.lK(l.b(l.this), l.c(l.this).PLD);
            AppMethodBeat.o(307246);
            return;
          }
          l.a(l.this, 2, "");
          AppMethodBeat.o(307246);
        }
      }, 2);
      AppMethodBeat.o(307222);
      return;
    }
    finally
    {
      Q(2, 1, "");
      AppMethodBeat.o(307222);
    }
  }
  
  protected final void had()
  {
    AppMethodBeat.i(307247);
    for (;;)
    {
      try
      {
        super.had();
        Object localObject1 = new HashMap();
        ((Map)localObject1).put("fontNormalColor", mv(this.QOD.QJa, "#FFFFFF"));
        ((Map)localObject1).put("fontDisableColor", mv(this.QOD.QJb, "#4CFFFFFF"));
        ((Map)localObject1).put("fontPressedColor", mv(this.QOD.QJc, "#99FFFFFF"));
        ((Map)localObject1).put("NormalColor", mv(this.QOD.QIU, "#1AAD19"));
        ((Map)localObject1).put("PressedColor", mv(this.QOD.QIW, "#179B16"));
        ((Map)localObject1).put("DisableColor", mv(this.QOD.QIV, "#661AAD19"));
        ((Map)localObject1).put("borderNormalColor", mv(this.QOD.QIX, "#179E16"));
        ((Map)localObject1).put("borderPressedColor", mv(this.QOD.QIZ, "#158E14"));
        ((Map)localObject1).put("borderDisableColor", mv(this.QOD.QIY, "#00179E16"));
        int j = Color.parseColor((String)((Map)localObject1).get("fontNormalColor"));
        int k = Color.parseColor((String)((Map)localObject1).get("fontDisableColor"));
        int m = Color.parseColor((String)((Map)localObject1).get("fontPressedColor"));
        int n = Color.parseColor((String)((Map)localObject1).get("NormalColor"));
        int i1 = Color.parseColor((String)((Map)localObject1).get("PressedColor"));
        int i2 = Color.parseColor((String)((Map)localObject1).get("DisableColor"));
        int i3 = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJS;
        int i4 = Color.parseColor((String)((Map)localObject1).get("borderNormalColor"));
        int i5 = Color.parseColor((String)((Map)localObject1).get("borderPressedColor"));
        int i6 = Color.parseColor((String)((Map)localObject1).get("borderDisableColor"));
        int i = this.context.getResources().getDimensionPixelSize(b.d.ButtonCornerSize);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).dwJ > 0.0F)
        {
          i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).dwJ;
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setShape(0);
          ((GradientDrawable)localObject1).setCornerRadius(i);
          ((GradientDrawable)localObject1).setColor(i2);
          ((GradientDrawable)localObject1).setStroke(i3, i6);
          Object localObject3 = new GradientDrawable();
          ((GradientDrawable)localObject3).setShape(0);
          ((GradientDrawable)localObject3).setCornerRadius(i);
          ((GradientDrawable)localObject3).setColor(i1);
          ((GradientDrawable)localObject3).setStroke(i3, i5);
          GradientDrawable localGradientDrawable = new GradientDrawable();
          localGradientDrawable.setShape(0);
          localGradientDrawable.setCornerRadius(i);
          localGradientDrawable.setColor(n);
          localGradientDrawable.setStroke(i3, i4);
          StateListDrawable localStateListDrawable = new StateListDrawable();
          localStateListDrawable.addState(new int[] { -16842910 }, (Drawable)localObject1);
          localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject3);
          localStateListDrawable.addState(new int[] { 16842910 }, localGradientDrawable);
          this.QPn.setBackground(localStateListDrawable);
          localObject1 = new int[] { -16842910 };
          localObject3 = new int[] { 16842910 };
          this.QPn.setTextColor(new ColorStateList(new int[][] { localObject1, { 16842919 }, localObject3 }, new int[] { k, m, j }));
          if (this.QOD.fontSize > 0.0F) {
            this.QPn.setTextSize(0, this.QOD.fontSize);
          }
          if (this.QOF)
          {
            if (Util.isNullOrNil(this.QOD.QJi))
            {
              i = b.j.sns_ad_download_apk_open;
              if (this.QPn != null)
              {
                this.QPn.setText(i);
                com.tencent.mm.plugin.sns.ad.d.k.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV, this.QPn);
              }
              AppMethodBeat.o(307247);
              return;
            }
            aWr(this.QOD.QJi);
          }
          AppMethodBeat.o(307247);
          return;
        }
      }
      finally
      {
        Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "fill item data occur something wrong!");
        AppMethodBeat.o(307247);
        return;
      }
    }
  }
  
  public final void hao()
  {
    AppMethodBeat.i(307254);
    super.hao();
    try
    {
      Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillAppear is called");
      MMHandlerThread.removeRunnable(QOH);
      hjc();
      a locala;
      if (QOC != null)
      {
        locala = QOC;
        if (TextUtils.isEmpty(this.QOE))
        {
          Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "the btn comp is null or target apk pkg is empty");
          AppMethodBeat.o(307254);
          return;
        }
      }
      AppMethodBeat.o(307254);
    }
    finally
    {
      try
      {
        locala.hjf();
        locala.d(this);
        AppMethodBeat.o(307254);
        return;
      }
      finally
      {
        Log.w("MicroMsg.AdLandingPageAppMarketBtnComp", "add market btn has some error");
      }
      localObject1 = finally;
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "processor registerPkgReceiver error");
      AppMethodBeat.o(307254);
      return;
    }
  }
  
  public final void has()
  {
    AppMethodBeat.i(307259);
    super.has();
    try
    {
      Log.i("MicroMsg.AdLandingPageAppMarketBtnComp", "viewWillDestroy is called");
      MMHandlerThread.removeRunnable(QOH);
      MMHandlerThread.postToMainThreadDelayed(QOH, 300000L);
      AppMethodBeat.o(307259);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "remove mProcessorForUnregisterPkgReceiver error");
      AppMethodBeat.o(307259);
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    final List<WeakReference<l>> QOJ;
    final Map<String, ai> QOK;
    final Map<String, l.b> QOL;
    
    private a()
    {
      AppMethodBeat.i(307050);
      this.QOJ = new LinkedList();
      this.QOK = new ConcurrentHashMap();
      this.QOL = new ConcurrentHashMap();
      AppMethodBeat.o(307050);
    }
    
    private static String bw(Intent paramIntent)
    {
      AppMethodBeat.i(307056);
      try
      {
        paramIntent = paramIntent.getData().getSchemeSpecificPart();
        return paramIntent;
      }
      finally
      {
        AppMethodBeat.o(307056);
      }
      return "";
    }
    
    private void g(String paramString1, boolean paramBoolean, String paramString2)
    {
      for (;;)
      {
        Object localObject;
        try
        {
          AppMethodBeat.i(307053);
          Iterator localIterator = this.QOJ.iterator();
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
          if (Util.isNullOrNil(l.c((l)localObject).QJi))
          {
            l.a((l)localObject, paramString2);
            continue;
          }
          l.a((l)localObject, l.c((l)localObject).QJi);
        }
        finally {}
        continue;
        label130:
        l.a((l)localObject, l.c((l)localObject).title);
      }
      AppMethodBeat.o(307053);
    }
    
    /* Error */
    final void d(l paraml)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 123
      //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: getfield 31	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:QOJ	Ljava/util/List;
      //   11: invokeinterface 70 1 0
      //   16: astore_2
      //   17: aload_2
      //   18: invokeinterface 76 1 0
      //   23: ifeq +34 -> 57
      //   26: aload_2
      //   27: invokeinterface 80 1 0
      //   32: checkcast 82	java/lang/ref/WeakReference
      //   35: invokevirtual 85	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   38: aload_1
      //   39: if_acmpne -22 -> 17
      //   42: ldc 125
      //   44: ldc 127
      //   46: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   49: ldc 123
      //   51: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_0
      //   55: monitorexit
      //   56: return
      //   57: new 82	java/lang/ref/WeakReference
      //   60: dup
      //   61: aload_1
      //   62: invokespecial 135	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
      //   65: astore_2
      //   66: aload_0
      //   67: getfield 31	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:QOJ	Ljava/util/List;
      //   70: aload_2
      //   71: invokeinterface 138 2 0
      //   76: pop
      //   77: aload_0
      //   78: getfield 36	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l$a:QOK	Ljava/util/Map;
      //   81: aload_1
      //   82: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l;)Ljava/lang/String;
      //   85: aload_1
      //   86: invokevirtual 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/l:hjn	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ai;
      //   89: invokeinterface 148 3 0
      //   94: pop
      //   95: ldc 123
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
    
    final void hjf()
    {
      try
      {
        AppMethodBeat.i(307063);
        Iterator localIterator = this.QOJ.iterator();
        while (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            localIterator.remove();
          }
        }
        AppMethodBeat.o(307063);
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(307068);
      String str;
      if (paramIntent != null)
      {
        try
        {
          str = paramIntent.getAction();
          if (!"android.intent.action.PACKAGE_ADDED".equals(str)) {
            break label188;
          }
          paramIntent = bw(paramIntent);
          if (!TextUtils.isEmpty(paramIntent))
          {
            g(paramIntent, true, paramContext.getString(b.j.sns_ad_download_apk_open));
            try
            {
              paramContext = (ai)this.QOK.get(paramIntent);
              if (paramContext != null)
              {
                l.a(paramContext, 3, "0", "");
                paramContext = new com.tencent.mm.plugin.sns.data.b(paramContext.uxInfo, paramContext.rzx, paramContext.source, paramContext.adExtInfo, paramContext.aid, paramContext.qTb, paramContext.pId);
                if (!Util.isNullOrNil(paramIntent))
                {
                  paramIntent = (l.b)this.QOL.get(paramIntent);
                  if (paramIntent != null) {
                    paramContext.Qmp = ((int)(System.currentTimeMillis() - paramIntent.QoS));
                  }
                  c.c(paramContext, 3);
                }
              }
              AppMethodBeat.o(307068);
              return;
            }
            finally {}
          }
          AppMethodBeat.o(307068);
          return;
        }
        finally
        {
          Log.e("MicroMsg.AdLandingPageAppMarketBtnComp", "there is a exception in receiver");
        }
      }
      else
      {
        AppMethodBeat.o(307068);
        return;
      }
      label188:
      if ("android.intent.action.PACKAGE_REMOVED".equals(str))
      {
        paramContext = bw(paramIntent);
        if (!TextUtils.isEmpty(paramContext)) {
          g(paramContext, false, "");
        }
      }
      AppMethodBeat.o(307068);
    }
  }
  
  static final class b
  {
    public long QoS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l
 * JD-Core Version:    0.7.0.1
 */