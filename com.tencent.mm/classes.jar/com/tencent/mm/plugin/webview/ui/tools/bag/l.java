package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public enum l
{
  private long oiC = -1L;
  private WebViewBag rst;
  private a rsu;
  boolean rsv;
  public l.a rsw = new l.a();
  public LinkedList<l.b> wuN = new LinkedList();
  
  private l() {}
  
  private void CM(int paramInt)
  {
    y.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    h.nFQ.f(11576, new Object[] { this.rsw.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.rsw.ekr), this.rsw.id });
  }
  
  private void cfd()
  {
    y.i("MicroMsg.WebViewBagMgr", "attachBag");
    WindowManager localWindowManager = (WindowManager)ae.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2002;
    localLayoutParams.format = 1;
    localLayoutParams.packageName = ae.getContext().getPackageName();
    localLayoutParams.flags = 40;
    localLayoutParams.gravity = 51;
    localLayoutParams.width = b.rrl;
    localLayoutParams.height = b.rrl;
    localLayoutParams.x = this.rsw.rsC;
    localLayoutParams.y = this.rsw.rsB;
    try
    {
      localWindowManager.addView(this.rst, localLayoutParams);
      cff();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewBagMgr", "add failed %s", new Object[] { localException });
    }
  }
  
  /* Error */
  private void cfe()
  {
    // Byte code:
    //   0: ldc 64
    //   2: ldc_w 316
    //   5: invokestatic 133	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 215	com/tencent/mm/plugin/webview/ui/tools/bag/l:rst	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   12: ifnull +90 -> 102
    //   15: invokestatic 199	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   18: ldc 250
    //   20: invokevirtual 256	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 258	android/view/WindowManager
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 215	com/tencent/mm/plugin/webview/ui/tools/bag/l:rst	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   32: invokeinterface 320 2 0
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 215	com/tencent/mm/plugin/webview/ui/tools/bag/l:rst	Lcom/tencent/mm/plugin/webview/ui/tools/bag/WebViewBag;
    //   42: aload_0
    //   43: getfield 322	com/tencent/mm/plugin/webview/ui/tools/bag/l:rsu	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   46: ifnull +35 -> 81
    //   49: aload_0
    //   50: getfield 322	com/tencent/mm/plugin/webview/ui/tools/bag/l:rsu	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   53: astore_1
    //   54: invokestatic 199	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   57: ldc 250
    //   59: invokevirtual 256	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 258	android/view/WindowManager
    //   65: astore_2
    //   66: aload_2
    //   67: aload_1
    //   68: getfield 328	com/tencent/mm/plugin/webview/ui/tools/bag/a:rrb	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a$a;
    //   71: invokeinterface 320 2 0
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 322	com/tencent/mm/plugin/webview/ui/tools/bag/l:rsu	Lcom/tencent/mm/plugin/webview/ui/tools/bag/a;
    //   81: return
    //   82: astore_1
    //   83: ldc 64
    //   85: ldc_w 330
    //   88: iconst_1
    //   89: anewarray 68	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: aastore
    //   96: invokestatic 313	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: goto -62 -> 37
    //   102: ldc 64
    //   104: ldc_w 332
    //   107: invokestatic 334	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -68 -> 42
    //   113: astore_1
    //   114: ldc_w 336
    //   117: ldc_w 338
    //   120: iconst_1
    //   121: anewarray 68	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: invokestatic 313	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: goto -55 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	l
    //   26	42	1	localObject	Object
    //   82	13	1	localException1	Exception
    //   113	14	1	localException2	Exception
    //   65	2	2	localWindowManager	WindowManager
    // Exception table:
    //   from	to	target	type
    //   27	37	82	java/lang/Exception
    //   66	76	113	java/lang/Exception
  }
  
  private void cff()
  {
    y.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.rsw.ekr) });
    if (this.rst == null) {
      return;
    }
    if ("1".equals((String)g.DP().Dz().get(ac.a.uzu, "0")))
    {
      this.rst.j(60000, 100, this.rsw.ekr + 2000L);
      return;
    }
    this.rst.j(3600000, 30000, this.rsw.ekr + 3600000L);
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) || (bk.bl(this.rsw.id)))
    {
      CM(23);
      this.rsw.id = ad.bB(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.rsw.url }));
    }
    this.rsw.url = paramString1;
    this.rsw.bVO = paramString2;
    this.rsw.scene = paramInt;
    this.rsw.ekr = bk.UY();
    this.rsw.rsD = k.W(paramBundle);
    this.rsw.save();
  }
  
  public final void aK(float paramFloat)
  {
    if (this.rst == null) {
      return;
    }
    this.rst.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.rst.setVisibility(8);
      return;
    }
    this.rst.setVisibility(0);
  }
  
  public final void ccW()
  {
    if (this.rst == null) {
      return;
    }
    this.rst.setVisibility(8);
  }
  
  public final void cfb()
  {
    y.i("MicroMsg.WebViewBagMgr", "clearBag mCurrentUrl:%s", new Object[] { this.rsw.url });
    ccW();
    Object localObject = this.rsw;
    ((l.a)localObject).id = null;
    ((l.a)localObject).url = null;
    ((l.a)localObject).bVO = null;
    ((l.a)localObject).ekr = 0L;
    ((l.a)localObject).scene = 0;
    ((l.a)localObject).rsD = new JSONObject();
    ((l.a)localObject).save();
    cfe();
    localObject = this.wuN.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((l.b)((Iterator)localObject).next()).cVp();
    }
  }
  
  public final void cfc()
  {
    y.i("MicroMsg.WebViewBagMgr", "removeBag");
    if (this.rst == null) {
      return;
    }
    WebViewBag localWebViewBag = this.rst;
    l.5 local5 = new l.5(this);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setDuration(80L);
    localAnimationSet.restrictDuration(100L);
    localAnimationSet.setAnimationListener(local5);
    localAnimationSet.setFillAfter(true);
    localWebViewBag.iUL.startAnimation(localAnimationSet);
  }
  
  public final void lp(boolean paramBoolean)
  {
    y.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", new Object[] { Boolean.valueOf(this.rsv) });
    if ((!bk.bl(this.rsw.url)) && (!this.rsv))
    {
      if ((this.rst != null) && (this.rst.getVisibility() == 0))
      {
        y.i("MicroMsg.WebViewBagMgr", "already show");
        return;
      }
      lq(paramBoolean);
      y.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
      return;
    }
    ccW();
    y.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
  }
  
  final void lq(boolean paramBoolean)
  {
    y.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.rsw.url });
    if (!com.tencent.mm.compatible.f.b.bg(ae.getContext())) {
      y.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
    }
    label244:
    do
    {
      return;
      if (bk.bl(this.rsw.url))
      {
        cfb();
        return;
      }
      if (this.rst == null) {}
      for (boolean bool = true;; bool = false)
      {
        if (this.rst == null)
        {
          this.rsu = new a(new a.b()
          {
            public final void ceS()
            {
              l.a(l.this, 17);
              Point localPoint = null;
              if (l.b(l.this) != null) {
                localPoint = l.b(l.this).getLastTouchDownViewPos();
              }
              l.this.cfb();
              if (localPoint != null)
              {
                l.c(l.this).rsC = localPoint.x;
                l.c(l.this).rsB = localPoint.y;
                l.c(l.this).save();
              }
            }
          });
          this.rst = new WebViewBag(ae.getContext(), null);
          this.rst.setListener(new l.3(this));
          this.rst.setOnClickListener(new l.4(this));
        }
        aK(1.0F);
        this.rst.setTouchEnable(true);
        this.rst.setIcon(this.rsw.bVO);
        cff();
        y.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.rsw.id });
        if (!bool) {
          break label244;
        }
        if (!paramBoolean) {
          break;
        }
        this.rst.setVisibility(4);
        cfd();
        this.rst.setVisibility(0);
        this.rst.cfa();
        return;
      }
      cfd();
      return;
      if (this.rst.getVisibility() == 0) {
        break;
      }
      this.rst.setVisibility(0);
    } while (!paramBoolean);
    this.rst.cfa();
    return;
    y.i("MicroMsg.WebViewBagMgr", "already showed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l
 * JD-Core Version:    0.7.0.1
 */