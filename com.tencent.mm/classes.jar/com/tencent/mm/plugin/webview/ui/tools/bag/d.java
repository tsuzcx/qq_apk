package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public enum d
{
  long DxT;
  WebViewBag Qio;
  private a Qip;
  public boolean Qiq;
  public a Qir;
  private LinkedList<Object> Qis;
  
  static
  {
    AppMethodBeat.i(80462);
    Qin = new d("INSTANCE");
    Qit = new d[] { Qin };
    AppMethodBeat.o(80462);
  }
  
  private d()
  {
    AppMethodBeat.i(80449);
    this.DxT = -1L;
    this.Qir = new a();
    this.Qis = new LinkedList();
    AppMethodBeat.o(80449);
  }
  
  private void aoH(int paramInt)
  {
    AppMethodBeat.i(80456);
    Log.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.IzE.a(11576, new Object[] { this.Qir.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.Qir.lKd), this.Qir.id });
    AppMethodBeat.o(80456);
  }
  
  private void gZE()
  {
    AppMethodBeat.i(80455);
    Log.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.Qir.lKd) });
    if (this.Qio == null)
    {
      AppMethodBeat.o(80455);
      return;
    }
    if (gZF())
    {
      this.Qio.v(60000, 100, this.Qir.lKd + 2000L);
      AppMethodBeat.o(80455);
      return;
    }
    this.Qio.v(3600000, 30000, this.Qir.lKd + 3600000L);
    AppMethodBeat.o(80455);
  }
  
  private static boolean gZF()
  {
    AppMethodBeat.i(80457);
    boolean bool = "1".equals((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vve, "0"));
    AppMethodBeat.o(80457);
    return bool;
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(80454);
    if ((!paramBoolean) || (Util.isNullOrNil(this.Qir.id)))
    {
      aoH(23);
      this.Qir.id = MD5Util.getMD5String(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.Qir.url }));
    }
    this.Qir.url = paramString1;
    this.Qir.icon = paramString2;
    this.Qir.scene = paramInt;
    this.Qir.lKd = Util.nowMilliSecond();
    this.Qir.Qiz = c.bc(paramBundle);
    this.Qir.arg();
    AppMethodBeat.o(80454);
  }
  
  public final void cr(float paramFloat)
  {
    AppMethodBeat.i(80453);
    if (this.Qio == null)
    {
      AppMethodBeat.o(80453);
      return;
    }
    this.Qio.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.Qio.setVisibility(8);
      AppMethodBeat.o(80453);
      return;
    }
    this.Qio.setVisibility(0);
    AppMethodBeat.o(80453);
  }
  
  /* Error */
  public final void gZB()
  {
    // Byte code:
    //   0: ldc_w 357
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 88
    //   8: ldc_w 359
    //   11: iconst_1
    //   12: anewarray 92	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qir	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   21: getfield 243	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: invokevirtual 362	com/tencent/mm/plugin/webview/ui/tools/bag/d:gZD	()V
    //   32: aload_0
    //   33: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qir	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   36: astore_1
    //   37: aload_1
    //   38: aconst_null
    //   39: putfield 151	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:id	Ljava/lang/String;
    //   42: aload_1
    //   43: aconst_null
    //   44: putfield 243	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   47: aload_1
    //   48: aconst_null
    //   49: putfield 156	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:icon	Ljava/lang/String;
    //   52: aload_1
    //   53: lconst_0
    //   54: putfield 205	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:lKd	J
    //   57: aload_1
    //   58: iconst_0
    //   59: putfield 339	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:scene	I
    //   62: aload_1
    //   63: new 364	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 365	org/json/JSONObject:<init>	()V
    //   70: putfield 129	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:Qiz	Lorg/json/JSONObject;
    //   73: aload_1
    //   74: invokevirtual 208	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:arg	()V
    //   77: ldc 88
    //   79: ldc_w 367
    //   82: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qio	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   89: ifnull +118 -> 207
    //   92: invokestatic 184	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   95: ldc_w 369
    //   98: invokevirtual 375	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 377	android/view/WindowManager
    //   104: astore_1
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qio	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   110: invokeinterface 381 2 0
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qio	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   120: aload_0
    //   121: getfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qip	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   124: ifnull +36 -> 160
    //   127: aload_0
    //   128: getfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qip	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   131: astore_1
    //   132: invokestatic 184	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   135: ldc_w 369
    //   138: invokevirtual 375	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   141: checkcast 377	android/view/WindowManager
    //   144: astore_2
    //   145: aload_2
    //   146: aload_1
    //   147: getfield 387	com/tencent/mm/plugin/webview/ui/tools/bag/a:QhI	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a$a;
    //   150: invokeinterface 381 2 0
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qip	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   160: aload_0
    //   161: getfield 73	com/tencent/mm/plugin/webview/ui/tools/bag/d:Qis	Ljava/util/LinkedList;
    //   164: invokevirtual 391	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   167: astore_1
    //   168: aload_1
    //   169: invokeinterface 396 1 0
    //   174: ifeq +65 -> 239
    //   177: aload_1
    //   178: invokeinterface 399 1 0
    //   183: pop
    //   184: goto -16 -> 168
    //   187: astore_1
    //   188: ldc 88
    //   190: ldc_w 401
    //   193: iconst_1
    //   194: anewarray 92	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_1
    //   200: aastore
    //   201: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -89 -> 115
    //   207: ldc 88
    //   209: ldc_w 406
    //   212: invokestatic 408	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -95 -> 120
    //   218: astore_1
    //   219: ldc_w 410
    //   222: ldc_w 412
    //   225: iconst_1
    //   226: anewarray 92	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_1
    //   232: aastore
    //   233: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto -81 -> 155
    //   239: ldc_w 357
    //   242: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	d
    //   36	142	1	localObject	Object
    //   187	13	1	localException1	Exception
    //   218	14	1	localException2	Exception
    //   144	2	2	localWindowManager	WindowManager
    // Exception table:
    //   from	to	target	type
    //   105	115	187	java/lang/Exception
    //   145	155	218	java/lang/Exception
  }
  
  final void gZC()
  {
    AppMethodBeat.i(80451);
    Log.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.Qir.url });
    if (!com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext()))
    {
      Log.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
      AppMethodBeat.o(80451);
      return;
    }
    if (Util.isNullOrNil(this.Qir.url))
    {
      gZB();
      AppMethodBeat.o(80451);
      return;
    }
    boolean bool;
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (this.Qio == null)
    {
      bool = true;
      if (this.Qio == null)
      {
        this.Qip = new a(new a.b()
        {
          public final void gZA()
          {
            AppMethodBeat.i(80441);
            d.a(d.this, 17);
            Point localPoint = null;
            if (d.b(d.this) != null) {
              localPoint = d.b(d.this).getLastTouchDownViewPos();
            }
            d.this.gZB();
            if (localPoint != null)
            {
              d.c(d.this).Qiy = localPoint.x;
              d.c(d.this).Qix = localPoint.y;
              d.c(d.this).arg();
            }
            AppMethodBeat.o(80441);
          }
        });
        this.Qio = new WebViewBag(MMApplicationContext.getContext(), null);
        this.Qio.setListener(new WebViewBag.a()
        {
          public final void B(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(80443);
            a locala;
            float f1;
            float f2;
            if (d.d(d.this) != null)
            {
              locala = d.d(d.this);
              f1 = paramAnonymousMotionEvent.getRawX();
              f2 = paramAnonymousMotionEvent.getRawY();
            }
            switch (paramAnonymousMotionEvent.getAction())
            {
            default: 
              AppMethodBeat.o(80443);
              return;
            case 0: 
              locala.QhL.x = f1;
              locala.QhL.y = f2;
            }
            for (;;)
            {
              locala.QhK = false;
              locala.QhM = false;
              break;
              boolean bool;
              label177:
              Object localObject1;
              Object localObject2;
              if (locala.QhK)
              {
                bool = true;
                if (!bool) {
                  break;
                }
                if (!locala.mIsShowing)
                {
                  b.eJ(MMApplicationContext.getContext());
                  locala.mIsShowing = true;
                  locala.mScreenWidth = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
                  locala.mScreenHeight = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext());
                  if (locala.mScreenWidth <= locala.mScreenHeight) {
                    break label481;
                  }
                  bool = true;
                  locala.FHz = bool;
                  Log.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.FHz) });
                  localObject1 = locala.QhI;
                  ((a.a)localObject1).setVisibility(0);
                  localObject2 = new TranslateAnimation(b.QhV, 0.0F, b.QhV, 0.0F);
                  ((TranslateAnimation)localObject2).setFillAfter(true);
                  ((TranslateAnimation)localObject2).setDuration(200L);
                  ((a.a)localObject1).voG.startAnimation((Animation)localObject2);
                  ((a.a)localObject1).mContentView.startAnimation((Animation)localObject2);
                }
                bool = locala.QhM;
                if (!locala.FHz) {
                  break label487;
                }
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX() - b.saV;
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY();
                label316:
                if (f1 * f1 + f2 * f2 >= a.QhH) {
                  break label519;
                }
              }
              label519:
              for (locala.QhM = true; locala.QhM != bool; locala.QhM = false)
              {
                paramAnonymousMotionEvent = locala.QhI;
                if (!locala.QhM) {
                  break label528;
                }
                paramAnonymousMotionEvent.av(1.0F, b.QhW);
                if (paramAnonymousMotionEvent.rqy != null) {
                  paramAnonymousMotionEvent.rqy.vibrate(10L);
                }
                AppMethodBeat.o(80443);
                return;
                float f3 = locala.QhL.x;
                float f4 = locala.QhL.x;
                float f5 = locala.QhL.y;
                if ((f1 - f4) * (f1 - f3) + (f2 - locala.QhL.y) * (f2 - f5) - 900.0F > 0.0F) {}
                for (bool = true;; bool = false)
                {
                  locala.QhK = bool;
                  bool = locala.QhK;
                  break;
                }
                label481:
                bool = false;
                break label177;
                label487:
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX();
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY() - b.saV;
                break label316;
              }
              label528:
              paramAnonymousMotionEvent.av(b.QhW, 1.0F);
              AppMethodBeat.o(80443);
              return;
              if (locala.QhM)
              {
                locala.QhJ.gZA();
              }
              else if (locala.mIsShowing)
              {
                locala.mIsShowing = false;
                paramAnonymousMotionEvent = locala.QhI;
                localObject1 = new TranslateAnimation(0.0F, b.QhV, 0.0F, b.QhV);
                localObject2 = new AlphaAnimation(1.0F, 0.0F);
                AnimationSet localAnimationSet = new AnimationSet(true);
                localAnimationSet.addAnimation((Animation)localObject2);
                localAnimationSet.addAnimation((Animation)localObject1);
                localAnimationSet.setDuration(300L);
                localAnimationSet.setAnimationListener(new a.a.1(paramAnonymousMotionEvent));
                paramAnonymousMotionEvent.voG.startAnimation(localAnimationSet);
                paramAnonymousMotionEvent.mContentView.startAnimation(localAnimationSet);
              }
            }
          }
          
          public final void lH(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80442);
            d.a(d.this, 19);
            d.c(d.this).Qiy = paramAnonymousInt1;
            d.c(d.this).Qix = paramAnonymousInt2;
            d.c(d.this).arg();
            AppMethodBeat.o(80442);
          }
        });
        this.Qio.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80444);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            d.a(d.this, d.c(d.this).url, d.c(d.this).scene);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80444);
          }
        });
      }
      cr(1.0F);
      this.Qio.setTouchEnable(true);
      this.Qio.setIcon(this.Qir.icon);
      gZE();
      Log.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.Qir.id });
      if (!bool) {
        break label388;
      }
      Log.i("MicroMsg.WebViewBagMgr", "attachBag");
      localWindowManager = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (!com.tencent.mm.compatible.util.d.qV(26)) {
        break label354;
      }
    }
    label354:
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.packageName = MMApplicationContext.getContext().getPackageName();
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.width = b.QhP;
      localLayoutParams.height = b.QhP;
      localLayoutParams.x = this.Qir.Qiy;
      localLayoutParams.y = this.Qir.Qix;
      try
      {
        localWindowManager.addView(this.Qio, localLayoutParams);
        gZE();
        AppMethodBeat.o(80451);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebViewBagMgr", "add failed %s", new Object[] { localException });
        AppMethodBeat.o(80451);
        return;
      }
      bool = false;
      break;
    }
    label388:
    if (this.Qio.getVisibility() != 0)
    {
      this.Qio.setVisibility(0);
      AppMethodBeat.o(80451);
      return;
    }
    Log.i("MicroMsg.WebViewBagMgr", "already showed");
    AppMethodBeat.o(80451);
  }
  
  public final void gZD()
  {
    AppMethodBeat.i(80452);
    if (this.Qio == null)
    {
      AppMethodBeat.o(80452);
      return;
    }
    this.Qio.setVisibility(8);
    AppMethodBeat.o(80452);
  }
  
  public static final class a
  {
    public int Qix;
    public int Qiy;
    JSONObject Qiz;
    String icon;
    public String id;
    long lKd;
    int scene;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(80445);
      com.tencent.mm.kernel.h.aHH();
      Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vvd, null);
      Log.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
      if (Util.isNullOrNil((String)localObject))
      {
        this.id = null;
        this.url = null;
        this.icon = null;
        this.Qiy = (com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()) - b.QhP - b.QhQ);
        this.Qix = (b.QhO + MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_init_top_margin));
        this.Qiz = new JSONObject();
        Log.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.Qiy), Integer.valueOf(this.Qix) });
        AppMethodBeat.o(80445);
        return;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        this.url = ((JSONObject)localObject).getString("url");
        this.id = ((JSONObject)localObject).optString("id", MD5Util.getMD5String(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
        this.icon = ((JSONObject)localObject).getString("icon");
        this.Qix = ((JSONObject)localObject).getInt("pos_y");
        this.Qiy = ((JSONObject)localObject).getInt("pos_x");
        this.lKd = ((JSONObject)localObject).getLong("last_active_time");
        this.Qiz = ((JSONObject)localObject).getJSONObject("extras");
        this.scene = ((JSONObject)localObject).optInt("scene", 0);
        AppMethodBeat.o(80445);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
        AppMethodBeat.o(80445);
      }
    }
    
    final void arg()
    {
      AppMethodBeat.i(80446);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("id", Util.nullAsNil(this.id));
        ((JSONObject)localObject).put("url", Util.nullAsNil(this.url));
        ((JSONObject)localObject).put("icon", Util.nullAsNil(this.icon));
        ((JSONObject)localObject).put("pos_y", this.Qix);
        ((JSONObject)localObject).put("pos_x", this.Qiy);
        ((JSONObject)localObject).put("last_active_time", this.lKd);
        ((JSONObject)localObject).put("extras", this.Qiz);
        ((JSONObject)localObject).put("scene", this.scene);
        localObject = ((JSONObject)localObject).toString();
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vvd, localObject);
        AppMethodBeat.o(80446);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
        AppMethodBeat.o(80446);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d
 * JD-Core Version:    0.7.0.1
 */