package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;

public enum d
{
  long Dqp;
  WebViewBag JkW;
  private a JkX;
  public boolean JkY;
  public d.a JkZ;
  private LinkedList<Object> Jla;
  
  static
  {
    AppMethodBeat.i(80462);
    JkV = new d("INSTANCE");
    Jlb = new d[] { JkV };
    AppMethodBeat.o(80462);
  }
  
  private d()
  {
    AppMethodBeat.i(80449);
    this.Dqp = -1L;
    this.JkZ = new d.a();
    this.Jla = new LinkedList();
    AppMethodBeat.o(80449);
  }
  
  private void agQ(int paramInt)
  {
    AppMethodBeat.i(80456);
    Log.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    h.CyF.a(11576, new Object[] { this.JkZ.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.JkZ.iTK), this.JkZ.id });
    AppMethodBeat.o(80456);
  }
  
  private void ggr()
  {
    AppMethodBeat.i(80455);
    Log.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.JkZ.iTK) });
    if (this.JkW == null)
    {
      AppMethodBeat.o(80455);
      return;
    }
    if (ggs())
    {
      this.JkW.p(60000, 100, this.JkZ.iTK + 2000L);
      AppMethodBeat.o(80455);
      return;
    }
    this.JkW.p(3600000, 30000, this.JkZ.iTK + 3600000L);
    AppMethodBeat.o(80455);
  }
  
  private static boolean ggs()
  {
    AppMethodBeat.i(80457);
    boolean bool = "1".equals((String)g.aAh().azQ().get(ar.a.OgO, "0"));
    AppMethodBeat.o(80457);
    return bool;
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(80454);
    if ((!paramBoolean) || (Util.isNullOrNil(this.JkZ.id)))
    {
      agQ(23);
      this.JkZ.id = MD5Util.getMD5String(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.JkZ.url }));
    }
    this.JkZ.url = paramString1;
    this.JkZ.icon = paramString2;
    this.JkZ.scene = paramInt;
    this.JkZ.iTK = Util.nowMilliSecond();
    this.JkZ.Jlh = c.be(paramBundle);
    this.JkZ.save();
    AppMethodBeat.o(80454);
  }
  
  public final void ci(float paramFloat)
  {
    AppMethodBeat.i(80453);
    if (this.JkW == null)
    {
      AppMethodBeat.o(80453);
      return;
    }
    this.JkW.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.JkW.setVisibility(8);
      AppMethodBeat.o(80453);
      return;
    }
    this.JkW.setVisibility(0);
    AppMethodBeat.o(80453);
  }
  
  /* Error */
  public final void ggo()
  {
    // Byte code:
    //   0: ldc_w 358
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 88
    //   8: ldc_w 360
    //   11: iconst_1
    //   12: anewarray 92	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 67	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkZ	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   21: getfield 243	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: invokevirtual 363	com/tencent/mm/plugin/webview/ui/tools/bag/d:ggq	()V
    //   32: aload_0
    //   33: getfield 67	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkZ	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
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
    //   54: putfield 205	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:iTK	J
    //   57: aload_1
    //   58: iconst_0
    //   59: putfield 340	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:scene	I
    //   62: aload_1
    //   63: new 365	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 366	org/json/JSONObject:<init>	()V
    //   70: putfield 129	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:Jlh	Lorg/json/JSONObject;
    //   73: aload_1
    //   74: invokevirtual 208	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:save	()V
    //   77: ldc 88
    //   79: ldc_w 368
    //   82: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkW	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   89: ifnull +118 -> 207
    //   92: invokestatic 184	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   95: ldc_w 370
    //   98: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 378	android/view/WindowManager
    //   104: astore_1
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkW	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   110: invokeinterface 382 2 0
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 192	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkW	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   120: aload_0
    //   121: getfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkX	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   124: ifnull +36 -> 160
    //   127: aload_0
    //   128: getfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkX	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   131: astore_1
    //   132: invokestatic 184	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   135: ldc_w 370
    //   138: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   141: checkcast 378	android/view/WindowManager
    //   144: astore_2
    //   145: aload_2
    //   146: aload_1
    //   147: getfield 388	com/tencent/mm/plugin/webview/ui/tools/bag/a:Jkq	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a$a;
    //   150: invokeinterface 382 2 0
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 258	com/tencent/mm/plugin/webview/ui/tools/bag/d:JkX	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   160: aload_0
    //   161: getfield 72	com/tencent/mm/plugin/webview/ui/tools/bag/d:Jla	Ljava/util/LinkedList;
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
    //   242: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  final void ggp()
  {
    AppMethodBeat.i(80451);
    Log.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.JkZ.url });
    if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext()))
    {
      Log.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
      AppMethodBeat.o(80451);
      return;
    }
    if (Util.isNullOrNil(this.JkZ.url))
    {
      ggo();
      AppMethodBeat.o(80451);
      return;
    }
    boolean bool;
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (this.JkW == null)
    {
      bool = true;
      if (this.JkW == null)
      {
        this.JkX = new a(new a.b()
        {
          public final void ggn()
          {
            AppMethodBeat.i(80441);
            d.a(d.this, 17);
            Point localPoint = null;
            if (d.b(d.this) != null) {
              localPoint = d.b(d.this).getLastTouchDownViewPos();
            }
            d.this.ggo();
            if (localPoint != null)
            {
              d.c(d.this).Jlg = localPoint.x;
              d.c(d.this).Jlf = localPoint.y;
              d.c(d.this).save();
            }
            AppMethodBeat.o(80441);
          }
        });
        this.JkW = new WebViewBag(MMApplicationContext.getContext(), null);
        this.JkW.setListener(new WebViewBag.a()
        {
          public final void kp(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80442);
            d.a(d.this, 19);
            d.c(d.this).Jlg = paramAnonymousInt1;
            d.c(d.this).Jlf = paramAnonymousInt2;
            d.c(d.this).save();
            AppMethodBeat.o(80442);
          }
          
          public final void onTouchEvent(MotionEvent paramAnonymousMotionEvent)
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
              locala.Jkt.x = f1;
              locala.Jkt.y = f2;
            }
            for (;;)
            {
              locala.Jks = false;
              locala.Jku = false;
              break;
              boolean bool;
              label177:
              Object localObject1;
              Object localObject2;
              if (locala.Jks)
              {
                bool = true;
                if (!bool) {
                  break;
                }
                if (!locala.mIsShowing)
                {
                  b.eG(MMApplicationContext.getContext());
                  locala.mIsShowing = true;
                  locala.mScreenWidth = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
                  locala.mScreenHeight = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
                  if (locala.mScreenWidth <= locala.mScreenHeight) {
                    break label481;
                  }
                  bool = true;
                  locala.AbM = bool;
                  Log.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.AbM) });
                  localObject1 = locala.Jkq;
                  ((a.a)localObject1).setVisibility(0);
                  localObject2 = new TranslateAnimation(b.JkD, 0.0F, b.JkD, 0.0F);
                  ((TranslateAnimation)localObject2).setFillAfter(true);
                  ((TranslateAnimation)localObject2).setDuration(200L);
                  ((a.a)localObject1).rIY.startAnimation((Animation)localObject2);
                  ((a.a)localObject1).mContentView.startAnimation((Animation)localObject2);
                }
                bool = locala.Jku;
                if (!locala.AbM) {
                  break label487;
                }
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX() - b.oYU;
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY();
                label316:
                if (f1 * f1 + f2 * f2 >= a.Jkp) {
                  break label519;
                }
              }
              label519:
              for (locala.Jku = true; locala.Jku != bool; locala.Jku = false)
              {
                paramAnonymousMotionEvent = locala.Jkq;
                if (!locala.Jku) {
                  break label528;
                }
                paramAnonymousMotionEvent.aq(1.0F, b.JkE);
                if (paramAnonymousMotionEvent.ooM != null) {
                  paramAnonymousMotionEvent.ooM.vibrate(10L);
                }
                AppMethodBeat.o(80443);
                return;
                float f3 = locala.Jkt.x;
                float f4 = locala.Jkt.x;
                float f5 = locala.Jkt.y;
                if ((f1 - f4) * (f1 - f3) + (f2 - locala.Jkt.y) * (f2 - f5) - 900.0F > 0.0F) {}
                for (bool = true;; bool = false)
                {
                  locala.Jks = bool;
                  bool = locala.Jks;
                  break;
                }
                label481:
                bool = false;
                break label177;
                label487:
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX();
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY() - b.oYU;
                break label316;
              }
              label528:
              paramAnonymousMotionEvent.aq(b.JkE, 1.0F);
              AppMethodBeat.o(80443);
              return;
              if (locala.Jku)
              {
                locala.Jkr.ggn();
              }
              else if (locala.mIsShowing)
              {
                locala.mIsShowing = false;
                paramAnonymousMotionEvent = locala.Jkq;
                localObject1 = new TranslateAnimation(0.0F, b.JkD, 0.0F, b.JkD);
                localObject2 = new AlphaAnimation(1.0F, 0.0F);
                AnimationSet localAnimationSet = new AnimationSet(true);
                localAnimationSet.addAnimation((Animation)localObject2);
                localAnimationSet.addAnimation((Animation)localObject1);
                localAnimationSet.setDuration(300L);
                localAnimationSet.setAnimationListener(new a.a.1(paramAnonymousMotionEvent));
                paramAnonymousMotionEvent.rIY.startAnimation(localAnimationSet);
                paramAnonymousMotionEvent.mContentView.startAnimation(localAnimationSet);
              }
            }
          }
        });
        this.JkW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80444);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            d.a(d.this, d.c(d.this).url, d.c(d.this).scene);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80444);
          }
        });
      }
      ci(1.0F);
      this.JkW.setTouchEnable(true);
      this.JkW.setIcon(this.JkZ.icon);
      ggr();
      Log.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.JkZ.id });
      if (!bool) {
        break label388;
      }
      Log.i("MicroMsg.WebViewBagMgr", "attachBag");
      localWindowManager = (WindowManager)MMApplicationContext.getContext().getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (!com.tencent.mm.compatible.util.d.oD(26)) {
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
      localLayoutParams.width = b.Jkx;
      localLayoutParams.height = b.Jkx;
      localLayoutParams.x = this.JkZ.Jlg;
      localLayoutParams.y = this.JkZ.Jlf;
      try
      {
        localWindowManager.addView(this.JkW, localLayoutParams);
        ggr();
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
    if (this.JkW.getVisibility() != 0)
    {
      this.JkW.setVisibility(0);
      AppMethodBeat.o(80451);
      return;
    }
    Log.i("MicroMsg.WebViewBagMgr", "already showed");
    AppMethodBeat.o(80451);
  }
  
  public final void ggq()
  {
    AppMethodBeat.i(80452);
    if (this.JkW == null)
    {
      AppMethodBeat.o(80452);
      return;
    }
    this.JkW.setVisibility(8);
    AppMethodBeat.o(80452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d
 * JD-Core Version:    0.7.0.1
 */