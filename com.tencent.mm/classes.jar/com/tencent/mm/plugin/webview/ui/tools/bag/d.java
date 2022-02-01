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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public enum d
{
  WebViewBag BjF;
  private a BjG;
  public boolean BjH;
  public a BjI;
  private LinkedList<Object> BjJ;
  long wvn;
  
  static
  {
    AppMethodBeat.i(80462);
    BjE = new d("INSTANCE");
    BjK = new d[] { BjE };
    AppMethodBeat.o(80462);
  }
  
  private d()
  {
    AppMethodBeat.i(80449);
    this.wvn = -1L;
    this.BjI = new a();
    this.BjJ = new LinkedList();
    AppMethodBeat.o(80449);
  }
  
  private void TD(int paramInt)
  {
    AppMethodBeat.i(80456);
    ad.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    h.vKh.f(11576, new Object[] { this.BjI.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.BjI.hcM), this.BjI.id });
    AppMethodBeat.o(80456);
  }
  
  private void epr()
  {
    AppMethodBeat.i(80455);
    ad.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.BjI.hcM) });
    if (this.BjF == null)
    {
      AppMethodBeat.o(80455);
      return;
    }
    if (eps())
    {
      this.BjF.o(60000, 100, this.BjI.hcM + 2000L);
      AppMethodBeat.o(80455);
      return;
    }
    this.BjF.o(3600000, 30000, this.BjI.hcM + 3600000L);
    AppMethodBeat.o(80455);
  }
  
  private static boolean eps()
  {
    AppMethodBeat.i(80457);
    boolean bool = "1".equals((String)g.afB().afk().get(ae.a.Ftt, "0"));
    AppMethodBeat.o(80457);
    return bool;
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(80454);
    if ((!paramBoolean) || (bt.isNullOrNil(this.BjI.id)))
    {
      TD(23);
      this.BjI.id = ai.du(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.BjI.url }));
    }
    this.BjI.url = paramString1;
    this.BjI.dub = paramString2;
    this.BjI.scene = paramInt;
    this.BjI.hcM = bt.eGO();
    this.BjI.BjQ = c.aH(paramBundle);
    this.BjI.save();
    AppMethodBeat.o(80454);
  }
  
  public final void bz(float paramFloat)
  {
    AppMethodBeat.i(80453);
    if (this.BjF == null)
    {
      AppMethodBeat.o(80453);
      return;
    }
    this.BjF.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.BjF.setVisibility(8);
      AppMethodBeat.o(80453);
      return;
    }
    this.BjF.setVisibility(0);
    AppMethodBeat.o(80453);
  }
  
  /* Error */
  public final void epo()
  {
    // Byte code:
    //   0: ldc_w 358
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 78
    //   8: ldc_w 360
    //   11: iconst_1
    //   12: anewarray 82	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjI	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   21: getfield 104	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 140	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: invokevirtual 363	com/tencent/mm/plugin/webview/ui/tools/bag/d:epq	()V
    //   32: aload_0
    //   33: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjI	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   36: astore_1
    //   37: aload_1
    //   38: aconst_null
    //   39: putfield 121	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:id	Ljava/lang/String;
    //   42: aload_1
    //   43: aconst_null
    //   44: putfield 104	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   47: aload_1
    //   48: aconst_null
    //   49: putfield 183	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:dub	Ljava/lang/String;
    //   52: aload_1
    //   53: lconst_0
    //   54: putfield 113	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:hcM	J
    //   57: aload_1
    //   58: iconst_0
    //   59: putfield 340	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:scene	I
    //   62: aload_1
    //   63: new 365	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 366	org/json/JSONObject:<init>	()V
    //   70: putfield 160	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:BjQ	Lorg/json/JSONObject;
    //   73: aload_1
    //   74: invokevirtual 232	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:save	()V
    //   77: ldc 78
    //   79: ldc_w 368
    //   82: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjF	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   89: ifnull +118 -> 207
    //   92: invokestatic 211	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   95: ldc_w 370
    //   98: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 378	android/view/WindowManager
    //   104: astore_1
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjF	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   110: invokeinterface 382 2 0
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjF	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   120: aload_0
    //   121: getfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjG	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   124: ifnull +36 -> 160
    //   127: aload_0
    //   128: getfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjG	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   131: astore_1
    //   132: invokestatic 211	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   135: ldc_w 370
    //   138: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   141: checkcast 378	android/view/WindowManager
    //   144: astore_2
    //   145: aload_2
    //   146: aload_1
    //   147: getfield 388	com/tencent/mm/plugin/webview/ui/tools/bag/a:BiY	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a$a;
    //   150: invokeinterface 382 2 0
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjG	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   160: aload_0
    //   161: getfield 73	com/tencent/mm/plugin/webview/ui/tools/bag/d:BjJ	Ljava/util/LinkedList;
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
    //   188: ldc 78
    //   190: ldc_w 402
    //   193: iconst_1
    //   194: anewarray 82	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_1
    //   200: aastore
    //   201: invokestatic 405	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -89 -> 115
    //   207: ldc 78
    //   209: ldc_w 407
    //   212: invokestatic 409	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -95 -> 120
    //   218: astore_1
    //   219: ldc_w 411
    //   222: ldc_w 413
    //   225: iconst_1
    //   226: anewarray 82	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_1
    //   232: aastore
    //   233: invokestatic 405	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  final void epp()
  {
    AppMethodBeat.i(80451);
    ad.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.BjI.url });
    if (!com.tencent.mm.compatible.d.b.bZ(aj.getContext()))
    {
      ad.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
      AppMethodBeat.o(80451);
      return;
    }
    if (bt.isNullOrNil(this.BjI.url))
    {
      epo();
      AppMethodBeat.o(80451);
      return;
    }
    boolean bool;
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (this.BjF == null)
    {
      bool = true;
      if (this.BjF == null)
      {
        this.BjG = new a(new a.b()
        {
          public final void epn()
          {
            AppMethodBeat.i(80441);
            d.a(d.this, 17);
            Point localPoint = null;
            if (d.b(d.this) != null) {
              localPoint = d.b(d.this).getLastTouchDownViewPos();
            }
            d.this.epo();
            if (localPoint != null)
            {
              d.c(d.this).BjP = localPoint.x;
              d.c(d.this).BjO = localPoint.y;
              d.c(d.this).save();
            }
            AppMethodBeat.o(80441);
          }
        });
        this.BjF = new WebViewBag(aj.getContext(), null);
        this.BjF.setListener(new WebViewBag.a()
        {
          public final void iD(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80442);
            d.a(d.this, 19);
            d.c(d.this).BjP = paramAnonymousInt1;
            d.c(d.this).BjO = paramAnonymousInt2;
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
              locala.Bjb.x = f1;
              locala.Bjb.y = f2;
            }
            for (;;)
            {
              locala.Bja = false;
              locala.Bjc = false;
              break;
              boolean bool;
              label177:
              Object localObject1;
              Object localObject2;
              if (locala.Bja)
              {
                bool = true;
                if (!bool) {
                  break;
                }
                if (!locala.mIsShowing)
                {
                  b.ec(aj.getContext());
                  locala.mIsShowing = true;
                  locala.mScreenWidth = com.tencent.mm.cd.a.hV(aj.getContext());
                  locala.mScreenHeight = com.tencent.mm.cd.a.hW(aj.getContext());
                  if (locala.mScreenWidth <= locala.mScreenHeight) {
                    break label481;
                  }
                  bool = true;
                  locala.Bjd = bool;
                  ad.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.Bjd) });
                  localObject1 = locala.BiY;
                  ((a.a)localObject1).setVisibility(0);
                  localObject2 = new TranslateAnimation(b.Bjm, 0.0F, b.Bjm, 0.0F);
                  ((TranslateAnimation)localObject2).setFillAfter(true);
                  ((TranslateAnimation)localObject2).setDuration(200L);
                  ((a.a)localObject1).pev.startAnimation((Animation)localObject2);
                  ((a.a)localObject1).mContentView.startAnimation((Animation)localObject2);
                }
                bool = locala.Bjc;
                if (!locala.Bjd) {
                  break label487;
                }
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX() - b.mFV;
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY();
                label316:
                if (f1 * f1 + f2 * f2 >= a.BiX) {
                  break label519;
                }
              }
              label519:
              for (locala.Bjc = true; locala.Bjc != bool; locala.Bjc = false)
              {
                paramAnonymousMotionEvent = locala.BiY;
                if (!locala.Bjc) {
                  break label528;
                }
                paramAnonymousMotionEvent.ab(1.0F, b.Bjn);
                if (paramAnonymousMotionEvent.lRO != null) {
                  paramAnonymousMotionEvent.lRO.vibrate(10L);
                }
                AppMethodBeat.o(80443);
                return;
                float f3 = locala.Bjb.x;
                float f4 = locala.Bjb.x;
                float f5 = locala.Bjb.y;
                if ((f1 - f4) * (f1 - f3) + (f2 - locala.Bjb.y) * (f2 - f5) - 900.0F > 0.0F) {}
                for (bool = true;; bool = false)
                {
                  locala.Bja = bool;
                  bool = locala.Bja;
                  break;
                }
                label481:
                bool = false;
                break label177;
                label487:
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX();
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY() - b.mFV;
                break label316;
              }
              label528:
              paramAnonymousMotionEvent.ab(b.Bjn, 1.0F);
              AppMethodBeat.o(80443);
              return;
              if (locala.Bjc)
              {
                locala.BiZ.epn();
              }
              else if (locala.mIsShowing)
              {
                locala.mIsShowing = false;
                paramAnonymousMotionEvent = locala.BiY;
                localObject1 = new TranslateAnimation(0.0F, b.Bjm, 0.0F, b.Bjm);
                localObject2 = new AlphaAnimation(1.0F, 0.0F);
                AnimationSet localAnimationSet = new AnimationSet(true);
                localAnimationSet.addAnimation((Animation)localObject2);
                localAnimationSet.addAnimation((Animation)localObject1);
                localAnimationSet.setDuration(300L);
                localAnimationSet.setAnimationListener(new a.a.1(paramAnonymousMotionEvent));
                paramAnonymousMotionEvent.pev.startAnimation(localAnimationSet);
                paramAnonymousMotionEvent.mContentView.startAnimation(localAnimationSet);
              }
            }
          }
        });
        this.BjF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80444);
            d.a(d.this, d.c(d.this).url, d.c(d.this).scene);
            AppMethodBeat.o(80444);
          }
        });
      }
      bz(1.0F);
      this.BjF.setTouchEnable(true);
      this.BjF.setIcon(this.BjI.dub);
      epr();
      ad.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.BjI.id });
      if (!bool) {
        break label388;
      }
      ad.i("MicroMsg.WebViewBagMgr", "attachBag");
      localWindowManager = (WindowManager)aj.getContext().getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (!com.tencent.mm.compatible.util.d.lf(26)) {
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
      localLayoutParams.width = b.Bjg;
      localLayoutParams.height = b.Bjg;
      localLayoutParams.x = this.BjI.BjP;
      localLayoutParams.y = this.BjI.BjO;
      try
      {
        localWindowManager.addView(this.BjF, localLayoutParams);
        epr();
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
    if (this.BjF.getVisibility() != 0)
    {
      this.BjF.setVisibility(0);
      AppMethodBeat.o(80451);
      return;
    }
    ad.i("MicroMsg.WebViewBagMgr", "already showed");
    AppMethodBeat.o(80451);
  }
  
  public final void epq()
  {
    AppMethodBeat.i(80452);
    if (this.BjF == null)
    {
      AppMethodBeat.o(80452);
      return;
    }
    this.BjF.setVisibility(8);
    AppMethodBeat.o(80452);
  }
  
  public static final class a
  {
    public int BjO;
    public int BjP;
    JSONObject BjQ;
    String dub;
    long hcM;
    public String id;
    int scene;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(80445);
      g.afC();
      Object localObject = (String)g.afB().afk().get(ae.a.Fts, null);
      ad.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
      if (bt.isNullOrNil((String)localObject))
      {
        this.id = null;
        this.url = null;
        this.dub = null;
        this.BjP = (com.tencent.mm.cd.a.hV(aj.getContext()) - b.Bjg - b.Bjh);
        this.BjO = (b.Bjf + aj.getContext().getResources().getDimensionPixelSize(2131167015));
        this.BjQ = new JSONObject();
        ad.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.BjP), Integer.valueOf(this.BjO) });
        AppMethodBeat.o(80445);
        return;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        this.url = ((JSONObject)localObject).getString("url");
        this.id = ((JSONObject)localObject).optString("id", ai.du(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
        this.dub = ((JSONObject)localObject).getString("icon");
        this.BjO = ((JSONObject)localObject).getInt("pos_y");
        this.BjP = ((JSONObject)localObject).getInt("pos_x");
        this.hcM = ((JSONObject)localObject).getLong("last_active_time");
        this.BjQ = ((JSONObject)localObject).getJSONObject("extras");
        this.scene = ((JSONObject)localObject).optInt("scene", 0);
        AppMethodBeat.o(80445);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
        AppMethodBeat.o(80445);
      }
    }
    
    final void save()
    {
      AppMethodBeat.i(80446);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("id", bt.nullAsNil(this.id));
        ((JSONObject)localObject).put("url", bt.nullAsNil(this.url));
        ((JSONObject)localObject).put("icon", bt.nullAsNil(this.dub));
        ((JSONObject)localObject).put("pos_y", this.BjO);
        ((JSONObject)localObject).put("pos_x", this.BjP);
        ((JSONObject)localObject).put("last_active_time", this.hcM);
        ((JSONObject)localObject).put("extras", this.BjQ);
        ((JSONObject)localObject).put("scene", this.scene);
        localObject = ((JSONObject)localObject).toString();
        g.afC();
        g.afB().afk().set(ae.a.Fts, localObject);
        AppMethodBeat.o(80446);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
        AppMethodBeat.o(80446);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d
 * JD-Core Version:    0.7.0.1
 */