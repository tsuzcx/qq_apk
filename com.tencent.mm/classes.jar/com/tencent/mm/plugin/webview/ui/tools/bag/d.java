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
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.al.a;
import java.util.LinkedList;

public enum d
{
  WebViewBag EfA;
  private a EfB;
  public boolean EfC;
  public d.a EfD;
  private LinkedList<Object> EfE;
  long yVn;
  
  static
  {
    AppMethodBeat.i(80462);
    Efz = new d("INSTANCE");
    EfF = new d[] { Efz };
    AppMethodBeat.o(80462);
  }
  
  private d()
  {
    AppMethodBeat.i(80449);
    this.yVn = -1L;
    this.EfD = new d.a();
    this.EfE = new LinkedList();
    AppMethodBeat.o(80449);
  }
  
  private void XB(int paramInt)
  {
    AppMethodBeat.i(80456);
    ad.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.report.service.g.yhR.f(11576, new Object[] { this.EfD.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.EfD.hVU), this.EfD.id });
    AppMethodBeat.o(80456);
  }
  
  private void eTE()
  {
    AppMethodBeat.i(80455);
    ad.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.EfD.hVU) });
    if (this.EfA == null)
    {
      AppMethodBeat.o(80455);
      return;
    }
    if (eTF())
    {
      this.EfA.p(60000, 100, this.EfD.hVU + 2000L);
      AppMethodBeat.o(80455);
      return;
    }
    this.EfA.p(3600000, 30000, this.EfD.hVU + 3600000L);
    AppMethodBeat.o(80455);
  }
  
  private static boolean eTF()
  {
    AppMethodBeat.i(80457);
    boolean bool = "1".equals((String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDR, "0"));
    AppMethodBeat.o(80457);
    return bool;
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(80454);
    if ((!paramBoolean) || (bt.isNullOrNil(this.EfD.id)))
    {
      XB(23);
      this.EfD.id = com.tencent.mm.sdk.platformtools.ai.ee(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.EfD.url }));
    }
    this.EfD.url = paramString1;
    this.EfD.dDH = paramString2;
    this.EfD.scene = paramInt;
    this.EfD.hVU = bt.flT();
    this.EfD.EfL = c.aR(paramBundle);
    this.EfD.save();
    AppMethodBeat.o(80454);
  }
  
  public final void bM(float paramFloat)
  {
    AppMethodBeat.i(80453);
    if (this.EfA == null)
    {
      AppMethodBeat.o(80453);
      return;
    }
    this.EfA.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.EfA.setVisibility(8);
      AppMethodBeat.o(80453);
      return;
    }
    this.EfA.setVisibility(0);
    AppMethodBeat.o(80453);
  }
  
  /* Error */
  public final void eTB()
  {
    // Byte code:
    //   0: ldc_w 359
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 77
    //   8: ldc_w 361
    //   11: iconst_1
    //   12: anewarray 81	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 67	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfD	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   21: getfield 103	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 140	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: invokevirtual 364	com/tencent/mm/plugin/webview/ui/tools/bag/d:eTD	()V
    //   32: aload_0
    //   33: getfield 67	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfD	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   36: astore_1
    //   37: aload_1
    //   38: aconst_null
    //   39: putfield 120	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:id	Ljava/lang/String;
    //   42: aload_1
    //   43: aconst_null
    //   44: putfield 103	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   47: aload_1
    //   48: aconst_null
    //   49: putfield 183	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:dDH	Ljava/lang/String;
    //   52: aload_1
    //   53: lconst_0
    //   54: putfield 112	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:hVU	J
    //   57: aload_1
    //   58: iconst_0
    //   59: putfield 341	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:scene	I
    //   62: aload_1
    //   63: new 366	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 367	org/json/JSONObject:<init>	()V
    //   70: putfield 160	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:EfL	Lorg/json/JSONObject;
    //   73: aload_1
    //   74: invokevirtual 232	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:save	()V
    //   77: ldc 77
    //   79: ldc_w 369
    //   82: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfA	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   89: ifnull +118 -> 207
    //   92: invokestatic 211	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   95: ldc_w 371
    //   98: invokevirtual 377	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 379	android/view/WindowManager
    //   104: astore_1
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfA	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   110: invokeinterface 383 2 0
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfA	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   120: aload_0
    //   121: getfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfB	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   124: ifnull +36 -> 160
    //   127: aload_0
    //   128: getfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfB	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   131: astore_1
    //   132: invokestatic 211	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   135: ldc_w 371
    //   138: invokevirtual 377	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   141: checkcast 379	android/view/WindowManager
    //   144: astore_2
    //   145: aload_2
    //   146: aload_1
    //   147: getfield 389	com/tencent/mm/plugin/webview/ui/tools/bag/a:EeT	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a$a;
    //   150: invokeinterface 383 2 0
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfB	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   160: aload_0
    //   161: getfield 72	com/tencent/mm/plugin/webview/ui/tools/bag/d:EfE	Ljava/util/LinkedList;
    //   164: invokevirtual 393	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   167: astore_1
    //   168: aload_1
    //   169: invokeinterface 398 1 0
    //   174: ifeq +65 -> 239
    //   177: aload_1
    //   178: invokeinterface 401 1 0
    //   183: pop
    //   184: goto -16 -> 168
    //   187: astore_1
    //   188: ldc 77
    //   190: ldc_w 403
    //   193: iconst_1
    //   194: anewarray 81	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_1
    //   200: aastore
    //   201: invokestatic 406	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -89 -> 115
    //   207: ldc 77
    //   209: ldc_w 408
    //   212: invokestatic 410	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -95 -> 120
    //   218: astore_1
    //   219: ldc_w 412
    //   222: ldc_w 414
    //   225: iconst_1
    //   226: anewarray 81	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_1
    //   232: aastore
    //   233: invokestatic 406	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto -81 -> 155
    //   239: ldc_w 359
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
  
  final void eTC()
  {
    AppMethodBeat.i(80451);
    ad.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.EfD.url });
    if (!com.tencent.mm.compatible.d.b.ca(aj.getContext()))
    {
      ad.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
      AppMethodBeat.o(80451);
      return;
    }
    if (bt.isNullOrNil(this.EfD.url))
    {
      eTB();
      AppMethodBeat.o(80451);
      return;
    }
    boolean bool;
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (this.EfA == null)
    {
      bool = true;
      if (this.EfA == null)
      {
        this.EfB = new a(new a.b()
        {
          public final void eTA()
          {
            AppMethodBeat.i(80441);
            d.a(d.this, 17);
            Point localPoint = null;
            if (d.b(d.this) != null) {
              localPoint = d.b(d.this).getLastTouchDownViewPos();
            }
            d.this.eTB();
            if (localPoint != null)
            {
              d.c(d.this).EfK = localPoint.x;
              d.c(d.this).EfJ = localPoint.y;
              d.c(d.this).save();
            }
            AppMethodBeat.o(80441);
          }
        });
        this.EfA = new WebViewBag(aj.getContext(), null);
        this.EfA.setListener(new WebViewBag.a()
        {
          public final void jd(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80442);
            d.a(d.this, 19);
            d.c(d.this).EfK = paramAnonymousInt1;
            d.c(d.this).EfJ = paramAnonymousInt2;
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
              locala.EeW.x = f1;
              locala.EeW.y = f2;
            }
            for (;;)
            {
              locala.EeV = false;
              locala.EeX = false;
              break;
              boolean bool;
              label177:
              Object localObject1;
              Object localObject2;
              if (locala.EeV)
              {
                bool = true;
                if (!bool) {
                  break;
                }
                if (!locala.mIsShowing)
                {
                  b.ek(aj.getContext());
                  locala.mIsShowing = true;
                  locala.mScreenWidth = com.tencent.mm.cc.a.ip(aj.getContext());
                  locala.mScreenHeight = com.tencent.mm.cc.a.iq(aj.getContext());
                  if (locala.mScreenWidth <= locala.mScreenHeight) {
                    break label481;
                  }
                  bool = true;
                  locala.EeY = bool;
                  ad.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.EeY) });
                  localObject1 = locala.EeT;
                  ((a.a)localObject1).setVisibility(0);
                  localObject2 = new TranslateAnimation(b.Efh, 0.0F, b.Efh, 0.0F);
                  ((TranslateAnimation)localObject2).setFillAfter(true);
                  ((TranslateAnimation)localObject2).setDuration(200L);
                  ((a.a)localObject1).qll.startAnimation((Animation)localObject2);
                  ((a.a)localObject1).mContentView.startAnimation((Animation)localObject2);
                }
                bool = locala.EeX;
                if (!locala.EeY) {
                  break label487;
                }
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX() - b.nIw;
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY();
                label316:
                if (f1 * f1 + f2 * f2 >= a.EeS) {
                  break label519;
                }
              }
              label519:
              for (locala.EeX = true; locala.EeX != bool; locala.EeX = false)
              {
                paramAnonymousMotionEvent = locala.EeT;
                if (!locala.EeX) {
                  break label528;
                }
                paramAnonymousMotionEvent.aj(1.0F, b.Efi);
                if (paramAnonymousMotionEvent.mUw != null) {
                  paramAnonymousMotionEvent.mUw.vibrate(10L);
                }
                AppMethodBeat.o(80443);
                return;
                float f3 = locala.EeW.x;
                float f4 = locala.EeW.x;
                float f5 = locala.EeW.y;
                if ((f1 - f4) * (f1 - f3) + (f2 - locala.EeW.y) * (f2 - f5) - 900.0F > 0.0F) {}
                for (bool = true;; bool = false)
                {
                  locala.EeV = bool;
                  bool = locala.EeV;
                  break;
                }
                label481:
                bool = false;
                break label177;
                label487:
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX();
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY() - b.nIw;
                break label316;
              }
              label528:
              paramAnonymousMotionEvent.aj(b.Efi, 1.0F);
              AppMethodBeat.o(80443);
              return;
              if (locala.EeX)
              {
                locala.EeU.eTA();
              }
              else if (locala.mIsShowing)
              {
                locala.mIsShowing = false;
                paramAnonymousMotionEvent = locala.EeT;
                localObject1 = new TranslateAnimation(0.0F, b.Efh, 0.0F, b.Efh);
                localObject2 = new AlphaAnimation(1.0F, 0.0F);
                AnimationSet localAnimationSet = new AnimationSet(true);
                localAnimationSet.addAnimation((Animation)localObject2);
                localAnimationSet.addAnimation((Animation)localObject1);
                localAnimationSet.setDuration(300L);
                localAnimationSet.setAnimationListener(new a.a.1(paramAnonymousMotionEvent));
                paramAnonymousMotionEvent.qll.startAnimation(localAnimationSet);
                paramAnonymousMotionEvent.mContentView.startAnimation(localAnimationSet);
              }
            }
          }
        });
        this.EfA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80444);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            d.a(d.this, d.c(d.this).url, d.c(d.this).scene);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/bag/WebViewBagMgr$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(80444);
          }
        });
      }
      bM(1.0F);
      this.EfA.setTouchEnable(true);
      this.EfA.setIcon(this.EfD.dDH);
      eTE();
      ad.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.EfD.id });
      if (!bool) {
        break label388;
      }
      ad.i("MicroMsg.WebViewBagMgr", "attachBag");
      localWindowManager = (WindowManager)aj.getContext().getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (!com.tencent.mm.compatible.util.d.ly(26)) {
        break label354;
      }
    }
    label354:
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.packageName = aj.getContext().getPackageName();
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.width = b.Efb;
      localLayoutParams.height = b.Efb;
      localLayoutParams.x = this.EfD.EfK;
      localLayoutParams.y = this.EfD.EfJ;
      try
      {
        localWindowManager.addView(this.EfA, localLayoutParams);
        eTE();
        AppMethodBeat.o(80451);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WebViewBagMgr", "add failed %s", new Object[] { localException });
        AppMethodBeat.o(80451);
        return;
      }
      bool = false;
      break;
    }
    label388:
    if (this.EfA.getVisibility() != 0)
    {
      this.EfA.setVisibility(0);
      AppMethodBeat.o(80451);
      return;
    }
    ad.i("MicroMsg.WebViewBagMgr", "already showed");
    AppMethodBeat.o(80451);
  }
  
  public final void eTD()
  {
    AppMethodBeat.i(80452);
    if (this.EfA == null)
    {
      AppMethodBeat.o(80452);
      return;
    }
    this.EfA.setVisibility(8);
    AppMethodBeat.o(80452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d
 * JD-Core Version:    0.7.0.1
 */