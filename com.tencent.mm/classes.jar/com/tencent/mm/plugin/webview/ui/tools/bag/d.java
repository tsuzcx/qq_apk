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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public enum d
{
  WebViewBag CBT;
  private a CBU;
  public boolean CBV;
  public a CBW;
  private LinkedList<Object> CBX;
  long xGD;
  
  static
  {
    AppMethodBeat.i(80462);
    CBS = new d("INSTANCE");
    CBY = new d[] { CBS };
    AppMethodBeat.o(80462);
  }
  
  private d()
  {
    AppMethodBeat.i(80449);
    this.xGD = -1L;
    this.CBW = new a();
    this.CBX = new LinkedList();
    AppMethodBeat.o(80449);
  }
  
  private void VL(int paramInt)
  {
    AppMethodBeat.i(80456);
    ac.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    h.wUl.f(11576, new Object[] { this.CBW.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.CBW.hDp), this.CBW.id });
    AppMethodBeat.o(80456);
  }
  
  private void eEM()
  {
    AppMethodBeat.i(80455);
    ac.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.CBW.hDp) });
    if (this.CBT == null)
    {
      AppMethodBeat.o(80455);
      return;
    }
    if (eEN())
    {
      this.CBT.o(60000, 100, this.CBW.hDp + 2000L);
      AppMethodBeat.o(80455);
      return;
    }
    this.CBT.o(3600000, 30000, this.CBW.hDp + 3600000L);
    AppMethodBeat.o(80455);
  }
  
  private static boolean eEN()
  {
    AppMethodBeat.i(80457);
    boolean bool = "1".equals((String)g.agR().agA().get(ah.a.GRn, "0"));
    AppMethodBeat.o(80457);
    return bool;
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(80454);
    if ((!paramBoolean) || (bs.isNullOrNil(this.CBW.id)))
    {
      VL(23);
      this.CBW.id = ah.dg(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.CBW.url }));
    }
    this.CBW.url = paramString1;
    this.CBW.drM = paramString2;
    this.CBW.scene = paramInt;
    this.CBW.hDp = bs.eWj();
    this.CBW.CCe = c.aM(paramBundle);
    this.CBW.save();
    AppMethodBeat.o(80454);
  }
  
  public final void bH(float paramFloat)
  {
    AppMethodBeat.i(80453);
    if (this.CBT == null)
    {
      AppMethodBeat.o(80453);
      return;
    }
    this.CBT.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.CBT.setVisibility(8);
      AppMethodBeat.o(80453);
      return;
    }
    this.CBT.setVisibility(0);
    AppMethodBeat.o(80453);
  }
  
  /* Error */
  public final void eEJ()
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
    //   18: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBW	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   21: getfield 104	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   24: aastore
    //   25: invokestatic 140	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: invokevirtual 363	com/tencent/mm/plugin/webview/ui/tools/bag/d:eEL	()V
    //   32: aload_0
    //   33: getfield 68	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBW	Lcom/tencent/mm/plugin/webview/ui/tools/bag/d$a;
    //   36: astore_1
    //   37: aload_1
    //   38: aconst_null
    //   39: putfield 121	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:id	Ljava/lang/String;
    //   42: aload_1
    //   43: aconst_null
    //   44: putfield 104	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:url	Ljava/lang/String;
    //   47: aload_1
    //   48: aconst_null
    //   49: putfield 183	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:drM	Ljava/lang/String;
    //   52: aload_1
    //   53: lconst_0
    //   54: putfield 113	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:hDp	J
    //   57: aload_1
    //   58: iconst_0
    //   59: putfield 340	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:scene	I
    //   62: aload_1
    //   63: new 365	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 366	org/json/JSONObject:<init>	()V
    //   70: putfield 160	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:CCe	Lorg/json/JSONObject;
    //   73: aload_1
    //   74: invokevirtual 232	com/tencent/mm/plugin/webview/ui/tools/bag/d$a:save	()V
    //   77: ldc 78
    //   79: ldc_w 368
    //   82: invokestatic 147	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBT	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   89: ifnull +118 -> 207
    //   92: invokestatic 211	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   95: ldc_w 370
    //   98: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 378	android/view/WindowManager
    //   104: astore_1
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBT	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   110: invokeinterface 382 2 0
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 219	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBT	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   120: aload_0
    //   121: getfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBU	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   124: ifnull +36 -> 160
    //   127: aload_0
    //   128: getfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBU	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   131: astore_1
    //   132: invokestatic 211	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   135: ldc_w 370
    //   138: invokevirtual 376	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   141: checkcast 378	android/view/WindowManager
    //   144: astore_2
    //   145: aload_2
    //   146: aload_1
    //   147: getfield 388	com/tencent/mm/plugin/webview/ui/tools/bag/a:CBl	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a$a;
    //   150: invokeinterface 382 2 0
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 259	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBU	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   160: aload_0
    //   161: getfield 73	com/tencent/mm/plugin/webview/ui/tools/bag/d:CBX	Ljava/util/LinkedList;
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
    //   201: invokestatic 405	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -89 -> 115
    //   207: ldc 78
    //   209: ldc_w 407
    //   212: invokestatic 409	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   233: invokestatic 405	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  final void eEK()
  {
    AppMethodBeat.i(80451);
    ac.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.CBW.url });
    if (!com.tencent.mm.compatible.d.b.cc(ai.getContext()))
    {
      ac.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
      AppMethodBeat.o(80451);
      return;
    }
    if (bs.isNullOrNil(this.CBW.url))
    {
      eEJ();
      AppMethodBeat.o(80451);
      return;
    }
    boolean bool;
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (this.CBT == null)
    {
      bool = true;
      if (this.CBT == null)
      {
        this.CBU = new a(new a.b()
        {
          public final void eEI()
          {
            AppMethodBeat.i(80441);
            d.a(d.this, 17);
            Point localPoint = null;
            if (d.b(d.this) != null) {
              localPoint = d.b(d.this).getLastTouchDownViewPos();
            }
            d.this.eEJ();
            if (localPoint != null)
            {
              d.c(d.this).CCd = localPoint.x;
              d.c(d.this).CCc = localPoint.y;
              d.c(d.this).save();
            }
            AppMethodBeat.o(80441);
          }
        });
        this.CBT = new WebViewBag(ai.getContext(), null);
        this.CBT.setListener(new WebViewBag.a()
        {
          public final void iQ(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(80442);
            d.a(d.this, 19);
            d.c(d.this).CCd = paramAnonymousInt1;
            d.c(d.this).CCc = paramAnonymousInt2;
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
              locala.CBo.x = f1;
              locala.CBo.y = f2;
            }
            for (;;)
            {
              locala.CBn = false;
              locala.CBp = false;
              break;
              boolean bool;
              label177:
              Object localObject1;
              Object localObject2;
              if (locala.CBn)
              {
                bool = true;
                if (!bool) {
                  break;
                }
                if (!locala.mIsShowing)
                {
                  b.ek(ai.getContext());
                  locala.mIsShowing = true;
                  locala.mScreenWidth = com.tencent.mm.cc.a.ig(ai.getContext());
                  locala.mScreenHeight = com.tencent.mm.cc.a.ih(ai.getContext());
                  if (locala.mScreenWidth <= locala.mScreenHeight) {
                    break label481;
                  }
                  bool = true;
                  locala.CBq = bool;
                  ac.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[] { Boolean.valueOf(locala.CBq) });
                  localObject1 = locala.CBl;
                  ((a.a)localObject1).setVisibility(0);
                  localObject2 = new TranslateAnimation(b.CBz, 0.0F, b.CBz, 0.0F);
                  ((TranslateAnimation)localObject2).setFillAfter(true);
                  ((TranslateAnimation)localObject2).setDuration(200L);
                  ((a.a)localObject1).pHG.startAnimation((Animation)localObject2);
                  ((a.a)localObject1).mContentView.startAnimation((Animation)localObject2);
                }
                bool = locala.CBp;
                if (!locala.CBq) {
                  break label487;
                }
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX() - b.nia;
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY();
                label316:
                if (f1 * f1 + f2 * f2 >= a.CBk) {
                  break label519;
                }
              }
              label519:
              for (locala.CBp = true; locala.CBp != bool; locala.CBp = false)
              {
                paramAnonymousMotionEvent = locala.CBl;
                if (!locala.CBp) {
                  break label528;
                }
                paramAnonymousMotionEvent.af(1.0F, b.CBA);
                if (paramAnonymousMotionEvent.mtQ != null) {
                  paramAnonymousMotionEvent.mtQ.vibrate(10L);
                }
                AppMethodBeat.o(80443);
                return;
                float f3 = locala.CBo.x;
                float f4 = locala.CBo.x;
                float f5 = locala.CBo.y;
                if ((f1 - f4) * (f1 - f3) + (f2 - locala.CBo.y) * (f2 - f5) - 900.0F > 0.0F) {}
                for (bool = true;; bool = false)
                {
                  locala.CBn = bool;
                  bool = locala.CBn;
                  break;
                }
                label481:
                bool = false;
                break label177;
                label487:
                f1 = locala.mScreenWidth - paramAnonymousMotionEvent.getRawX();
                f2 = locala.mScreenHeight - paramAnonymousMotionEvent.getRawY() - b.nia;
                break label316;
              }
              label528:
              paramAnonymousMotionEvent.af(b.CBA, 1.0F);
              AppMethodBeat.o(80443);
              return;
              if (locala.CBp)
              {
                locala.CBm.eEI();
              }
              else if (locala.mIsShowing)
              {
                locala.mIsShowing = false;
                paramAnonymousMotionEvent = locala.CBl;
                localObject1 = new TranslateAnimation(0.0F, b.CBz, 0.0F, b.CBz);
                localObject2 = new AlphaAnimation(1.0F, 0.0F);
                AnimationSet localAnimationSet = new AnimationSet(true);
                localAnimationSet.addAnimation((Animation)localObject2);
                localAnimationSet.addAnimation((Animation)localObject1);
                localAnimationSet.setDuration(300L);
                localAnimationSet.setAnimationListener(new a.a.1(paramAnonymousMotionEvent));
                paramAnonymousMotionEvent.pHG.startAnimation(localAnimationSet);
                paramAnonymousMotionEvent.mContentView.startAnimation(localAnimationSet);
              }
            }
          }
        });
        this.CBT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(80444);
            d.a(d.this, d.c(d.this).url, d.c(d.this).scene);
            AppMethodBeat.o(80444);
          }
        });
      }
      bH(1.0F);
      this.CBT.setTouchEnable(true);
      this.CBT.setIcon(this.CBW.drM);
      eEM();
      ac.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.CBW.id });
      if (!bool) {
        break label388;
      }
      ac.i("MicroMsg.WebViewBagMgr", "attachBag");
      localWindowManager = (WindowManager)ai.getContext().getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (!com.tencent.mm.compatible.util.d.kZ(26)) {
        break label354;
      }
    }
    label354:
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.packageName = ai.getContext().getPackageName();
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.width = b.CBt;
      localLayoutParams.height = b.CBt;
      localLayoutParams.x = this.CBW.CCd;
      localLayoutParams.y = this.CBW.CCc;
      try
      {
        localWindowManager.addView(this.CBT, localLayoutParams);
        eEM();
        AppMethodBeat.o(80451);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.WebViewBagMgr", "add failed %s", new Object[] { localException });
        AppMethodBeat.o(80451);
        return;
      }
      bool = false;
      break;
    }
    label388:
    if (this.CBT.getVisibility() != 0)
    {
      this.CBT.setVisibility(0);
      AppMethodBeat.o(80451);
      return;
    }
    ac.i("MicroMsg.WebViewBagMgr", "already showed");
    AppMethodBeat.o(80451);
  }
  
  public final void eEL()
  {
    AppMethodBeat.i(80452);
    if (this.CBT == null)
    {
      AppMethodBeat.o(80452);
      return;
    }
    this.CBT.setVisibility(8);
    AppMethodBeat.o(80452);
  }
  
  public static final class a
  {
    public int CCc;
    public int CCd;
    JSONObject CCe;
    String drM;
    long hDp;
    public String id;
    int scene;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(80445);
      g.agS();
      Object localObject = (String)g.agR().agA().get(ah.a.GRm, null);
      ac.i("MicroMsg.WebViewBagMgr", "BagInfo#load %s", new Object[] { localObject });
      if (bs.isNullOrNil((String)localObject))
      {
        this.id = null;
        this.url = null;
        this.drM = null;
        this.CCd = (com.tencent.mm.cc.a.ig(ai.getContext()) - b.CBt - b.CBu);
        this.CCc = (b.CBs + ai.getContext().getResources().getDimensionPixelSize(2131167015));
        this.CCe = new JSONObject();
        ac.i("MicroMsg.WebViewBagMgr", "BAG_INIT_X:%d BAG_INIT_Y:%d", new Object[] { Integer.valueOf(this.CCd), Integer.valueOf(this.CCc) });
        AppMethodBeat.o(80445);
        return;
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        this.url = ((JSONObject)localObject).getString("url");
        this.id = ((JSONObject)localObject).optString("id", ah.dg(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.url })));
        this.drM = ((JSONObject)localObject).getString("icon");
        this.CCc = ((JSONObject)localObject).getInt("pos_y");
        this.CCd = ((JSONObject)localObject).getInt("pos_x");
        this.hDp = ((JSONObject)localObject).getLong("last_active_time");
        this.CCe = ((JSONObject)localObject).getJSONObject("extras");
        this.scene = ((JSONObject)localObject).optInt("scene", 0);
        AppMethodBeat.o(80445);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.WebViewBagMgr", "BagInfo#load exp:%s", new Object[] { localJSONException });
        AppMethodBeat.o(80445);
      }
    }
    
    final void save()
    {
      AppMethodBeat.i(80446);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("id", bs.nullAsNil(this.id));
        ((JSONObject)localObject).put("url", bs.nullAsNil(this.url));
        ((JSONObject)localObject).put("icon", bs.nullAsNil(this.drM));
        ((JSONObject)localObject).put("pos_y", this.CCc);
        ((JSONObject)localObject).put("pos_x", this.CCd);
        ((JSONObject)localObject).put("last_active_time", this.hDp);
        ((JSONObject)localObject).put("extras", this.CCe);
        ((JSONObject)localObject).put("scene", this.scene);
        localObject = ((JSONObject)localObject).toString();
        g.agS();
        g.agR().agA().set(ah.a.GRm, localObject);
        AppMethodBeat.o(80446);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.WebViewBagMgr", "BagInfo#save exp:%s", new Object[] { localJSONException });
        AppMethodBeat.o(80446);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d
 * JD-Core Version:    0.7.0.1
 */