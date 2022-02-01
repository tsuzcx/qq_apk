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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public enum d
{
  long JqZ;
  WebViewBag Xas;
  private a Xat;
  public boolean Xau;
  public a Xav;
  private LinkedList<Object> Xaw;
  
  static
  {
    AppMethodBeat.i(80462);
    Xar = new d("INSTANCE");
    Xax = new d[] { Xar };
    AppMethodBeat.o(80462);
  }
  
  private d()
  {
    AppMethodBeat.i(80449);
    this.JqZ = -1L;
    this.Xav = new a();
    this.Xaw = new LinkedList();
    AppMethodBeat.o(80449);
  }
  
  private void auA(int paramInt)
  {
    AppMethodBeat.i(80456);
    Log.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.h.OAn.b(11576, new Object[] { this.Xav.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.Xav.oCF), this.Xav.id });
    AppMethodBeat.o(80456);
  }
  
  private void izF()
  {
    AppMethodBeat.i(80455);
    Log.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.Xav.oCF) });
    if (this.Xas == null)
    {
      AppMethodBeat.o(80455);
      return;
    }
    if (izG())
    {
      this.Xas.y(60000, 100, this.Xav.oCF + 2000L);
      AppMethodBeat.o(80455);
      return;
    }
    this.Xas.y(3600000, 30000, this.Xav.oCF + 3600000L);
    AppMethodBeat.o(80455);
  }
  
  private static boolean izG()
  {
    AppMethodBeat.i(80457);
    boolean bool = "1".equals((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWN, "0"));
    AppMethodBeat.o(80457);
    return bool;
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(80454);
    if ((!paramBoolean) || (Util.isNullOrNil(this.Xav.id)))
    {
      auA(23);
      this.Xav.id = MD5Util.getMD5String(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.Xav.url }));
    }
    this.Xav.url = paramString1;
    this.Xav.icon = paramString2;
    this.Xav.scene = paramInt;
    this.Xav.oCF = Util.nowMilliSecond();
    this.Xav.XaD = c.bH(paramBundle);
    this.Xav.sz();
    AppMethodBeat.o(80454);
  }
  
  public final void dE(float paramFloat)
  {
    AppMethodBeat.i(80453);
    if (this.Xas == null)
    {
      AppMethodBeat.o(80453);
      return;
    }
    this.Xas.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.Xas.setVisibility(8);
      AppMethodBeat.o(80453);
      return;
    }
    this.Xas.setVisibility(0);
    AppMethodBeat.o(80453);
  }
  
  /* Error */
  public final void izC()
  {
    // Byte code:
    //   0: ldc_w 358
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 88
    //   8: ldc_w 360
    //   11: iconst_1
    //   12: anewarray 92	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xav	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   21: getfield 243	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: invokevirtual 363	com/tencent/mm/plugin/webview/ui/tools/bag/d:izE	()V
    //   32: aload_0
    //   33: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xav	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
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
    //   54: putfield 205	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:oCF	J
    //   57: aload_1
    //   58: iconst_0
    //   59: putfield 340	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:scene	I
    //   62: aload_1
    //   63: new 365	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 366	org/json/JSONObject:<init>	()V
    //   70: putfield 129	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:XaD	Lorg/json/JSONObject;
    //   73: aload_1
    //   74: invokevirtual 208	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:sz	()V
    //   77: ldc 88
    //   79: ldc_w 368
    //   82: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xas	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   89: ifnull +118 -> 207
    //   92: invokestatic 184	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   95: ldc_w 370
    //   98: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 378	android/view/WindowManager
    //   104: astore_1
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xas	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   110: invokeinterface 382 2 0
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xas	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   120: aload_0
    //   121: getfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xat	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   124: ifnull +36 -> 160
    //   127: aload_0
    //   128: getfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xat	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   131: astore_1
    //   132: invokestatic 184	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   135: ldc_w 370
    //   138: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   141: checkcast 378	android/view/WindowManager
    //   144: astore_2
    //   145: aload_2
    //   146: aload_1
    //   147: getfield 388	com/tencent/mm/plugin/webview/ui/tools/bag/a:WZL	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a$a;
    //   150: invokeinterface 382 2 0
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xat	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   160: aload_0
    //   161: getfield 73	com/tencent/mm/plugin/webview/ui/tools/bag/d:Xaw	Ljava/util/LinkedList;
    //   164: invokevirtual 392	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   167: astore_1
    //   168: aload_1
    //   169: invokeinterface 397 1 0
    //   174: ifeq +65 -> 239
    //   177: aload_1
    //   178: invokeinterface 400 1 0
    //   183: pop
    //   184: goto -16 -> 168
    //   187: astore_1
    //   188: ldc 88
    //   190: ldc_w 402
    //   193: iconst_1
    //   194: anewarray 92	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_1
    //   200: aastore
    //   201: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -89 -> 115
    //   207: ldc 88
    //   209: ldc_w 407
    //   212: invokestatic 409	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -95 -> 120
    //   218: astore_1
    //   219: ldc_w 411
    //   222: ldc_w 413
    //   225: iconst_1
    //   226: anewarray 92	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_1
    //   232: aastore
    //   233: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto -81 -> 155
    //   239: ldc_w 358
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
  
  final void izD()
  {
    AppMethodBeat.i(80451);
    Log.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.Xav.url });
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      Log.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
      AppMethodBeat.o(80451);
      return;
    }
    if (Util.isNullOrNil(this.Xav.url))
    {
      izC();
      AppMethodBeat.o(80451);
      return;
    }
    boolean bool;
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (this.Xas == null)
    {
      bool = true;
      if (this.Xas == null)
      {
        this.Xat = new a(new a.b()
        {
          public final void izB()
          {
            AppMethodBeat.i(80441);
            d.a(d.this, 17);
            Point localPoint = null;
            if (d.b(d.this) != null) {
              localPoint = d.b(d.this).getLastTouchDownViewPos();
            }
            d.this.izC();
            if (localPoint != null)
            {
              d.c(d.this).XaC = localPoint.x;
              d.c(d.this).XaB = localPoint.y;
              d.c(d.this).sz();
            }
            AppMethodBeat.o(80441);
          }
        });
        this.Xas = new WebViewBag(MMApplicationContext.getContext(), null);
        this.Xas.setListener(new WebViewBag.a()
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
              locala.WZO.x = f1;
              locala.WZO.y = f2;
            }
            for (;;)
            {
              locala.WZN = false;
              locala.WZP = false;
              break;
              boolean bool;
              label177:
              Object localObject1;
              Object localObject2;
              if (locala.WZN)
              {
                bool = true;
                if (!bool) {
                  break;
                }
                if (!locala.WZQ)
                {
                  b.fE(MMApplicationContext.getContext());
                  locala.WZQ = true;
                  locala.mScreenWidth = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
                  locala.mScreenHeight = com.tencent.mm.cd.a.mt(MMApplicationContext.getContext());
                  if (locala.mScreenWidth <= locala.mScreenHeight) {
                    break label481;
                  }
                  bool = true;
                  locala.LCZ = bool;
                  Log.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.LCZ) });
                  localObject1 = locala.WZL;
                  ((a.a)localObject1).setVisibility(0);
                  localObject2 = new TranslateAnimation(b.WZZ, 0.0F, b.WZZ, 0.0F);
                  ((TranslateAnimation)localObject2).setFillAfter(true);
                  ((TranslateAnimation)localObject2).setDuration(200L);
                  ((a.a)localObject1).yBc.startAnimation((Animation)localObject2);
                  ((a.a)localObject1).mContentView.startAnimation((Animation)localObject2);
                }
                bool = locala.WZP;
                if (!locala.LCZ) {
                  break label487;
                }
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX() - b.vmn;
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY();
                label316:
                if (f1 * f1 + f2 * f2 >= a.WZK) {
                  break label519;
                }
              }
              label519:
              for (locala.WZP = true; locala.WZP != bool; locala.WZP = false)
              {
                paramAnonymousMotionEvent = locala.WZL;
                if (!locala.WZP) {
                  break label528;
                }
                paramAnonymousMotionEvent.bb(1.0F, b.Xaa);
                if (paramAnonymousMotionEvent.cqQ != null) {
                  paramAnonymousMotionEvent.cqQ.vibrate(10L);
                }
                AppMethodBeat.o(80443);
                return;
                float f3 = locala.WZO.x;
                float f4 = locala.WZO.x;
                float f5 = locala.WZO.y;
                if ((f1 - f4) * (f1 - f3) + (f2 - locala.WZO.y) * (f2 - f5) - 900.0F > 0.0F) {}
                for (bool = true;; bool = false)
                {
                  locala.WZN = bool;
                  bool = locala.WZN;
                  break;
                }
                label481:
                bool = false;
                break label177;
                label487:
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX();
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY() - b.vmn;
                break label316;
              }
              label528:
              paramAnonymousMotionEvent.bb(b.Xaa, 1.0F);
              AppMethodBeat.o(80443);
              return;
              if (locala.WZP)
              {
                locala.WZM.izB();
              }
              else if (locala.WZQ)
              {
                locala.WZQ = false;
                paramAnonymousMotionEvent = locala.WZL;
                localObject1 = new TranslateAnimation(0.0F, b.WZZ, 0.0F, b.WZZ);
                localObject2 = new AlphaAnimation(1.0F, 0.0F);
                AnimationSet localAnimationSet = new AnimationSet(true);
                localAnimationSet.addAnimation((Animation)localObject2);
                localAnimationSet.addAnimation((Animation)localObject1);
                localAnimationSet.setDuration(300L);
                localAnimationSet.setAnimationListener(new a.a.1(paramAnonymousMotionEvent));
                paramAnonymousMotionEvent.yBc.startAnimation(localAnimationSet);
                paramAnonymousMotionEvent.mContentView.startAnimation(localAnimationSet);
              }
            }
          }
          
          public final void nr(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80442);
            d.a(d.this, 19);
            d.c(d.this).XaC = paramAnonymousInt1;
            d.c(d.this).XaB = paramAnonymousInt2;
            d.c(d.this).sz();
            AppMethodBeat.o(80442);
          }
        });
        this.Xas.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80444);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            d.a(d.this, d.c(d.this).url, d.c(d.this).scene);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80444);
          }
        });
      }
      dE(1.0F);
      this.Xas.setTouchEnable(true);
      this.Xas.setIcon(this.Xav.icon);
      izF();
      Log.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.Xav.id });
      if (!bool) {
        break label388;
      }
      Log.i("MicroMsg.WebViewBagMgr", "attachBag");
      localWindowManager = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (!com.tencent.mm.compatible.util.d.rb(26)) {
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
      localLayoutParams.width = b.WZT;
      localLayoutParams.height = b.WZT;
      localLayoutParams.x = this.Xav.XaC;
      localLayoutParams.y = this.Xav.XaB;
      try
      {
        localWindowManager.addView(this.Xas, localLayoutParams);
        izF();
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
    if (this.Xas.getVisibility() != 0)
    {
      this.Xas.setVisibility(0);
      AppMethodBeat.o(80451);
      return;
    }
    Log.i("MicroMsg.WebViewBagMgr", "already showed");
    AppMethodBeat.o(80451);
  }
  
  public final void izE()
  {
    AppMethodBeat.i(80452);
    if (this.Xas == null)
    {
      AppMethodBeat.o(80452);
      return;
    }
    this.Xas.setVisibility(8);
    AppMethodBeat.o(80452);
  }
  
  public static final class a
  {
    public int XaB;
    public int XaC;
    JSONObject XaD;
    String icon;
    public String id;
    long oCF;
    int scene;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(80445);
      com.tencent.mm.kernel.h.baF();
      Object localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWM, null);
      Log.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
      if (Util.isNullOrNil((String)localObject))
      {
        this.id = null;
        this.url = null;
        this.icon = null;
        this.XaC = (com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()) - b.WZT - b.WZU);
        this.XaB = (b.WZS + MMApplicationContext.getContext().getResources().getDimensionPixelSize(c.d.webview_bag_init_top_margin));
        this.XaD = new JSONObject();
        Log.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.XaC), Integer.valueOf(this.XaB) });
        AppMethodBeat.o(80445);
        return;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        this.url = ((JSONObject)localObject).getString("url");
        this.id = ((JSONObject)localObject).optString("id", MD5Util.getMD5String(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
        this.icon = ((JSONObject)localObject).getString("icon");
        this.XaB = ((JSONObject)localObject).getInt("pos_y");
        this.XaC = ((JSONObject)localObject).getInt("pos_x");
        this.oCF = ((JSONObject)localObject).getLong("last_active_time");
        this.XaD = ((JSONObject)localObject).getJSONObject("extras");
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
    
    final void sz()
    {
      AppMethodBeat.i(80446);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("id", Util.nullAsNil(this.id));
        ((JSONObject)localObject).put("url", Util.nullAsNil(this.url));
        ((JSONObject)localObject).put("icon", Util.nullAsNil(this.icon));
        ((JSONObject)localObject).put("pos_y", this.XaB);
        ((JSONObject)localObject).put("pos_x", this.XaC);
        ((JSONObject)localObject).put("last_active_time", this.oCF);
        ((JSONObject)localObject).put("extras", this.XaD);
        ((JSONObject)localObject).put("scene", this.scene);
        localObject = ((JSONObject)localObject).toString();
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acWM, localObject);
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