package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public enum l
{
  private long qWP;
  private boolean viA;
  private l.a viB;
  public LinkedList<l.b> viC;
  public WebViewBag viy;
  private a viz;
  
  static
  {
    AppMethodBeat.i(8242);
    vix = new l("INSTANCE");
    viD = new l[] { vix };
    AppMethodBeat.o(8242);
  }
  
  private l()
  {
    AppMethodBeat.i(8220);
    this.qWP = -1L;
    this.viB = new l.a();
    this.viC = new LinkedList();
    AppMethodBeat.o(8220);
  }
  
  private void KF(int paramInt)
  {
    AppMethodBeat.i(8235);
    ab.v("MicroMsg.WebViewBagMgr", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    h.qsU.e(11576, new Object[] { this.viB.url, Integer.valueOf(paramInt), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.viB.fAH), this.viB.id });
    AppMethodBeat.o(8235);
  }
  
  private boolean dfi()
  {
    AppMethodBeat.i(8221);
    if (System.currentTimeMillis() - this.qWP > 500L) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ab.w("MicroMsg.WebViewBagMgr", "click to fast!!!");
      }
      AppMethodBeat.o(8221);
      return bool;
    }
  }
  
  private void dfl()
  {
    AppMethodBeat.i(8232);
    ab.i("MicroMsg.WebViewBagMgr", "attachBag");
    WindowManager localWindowManager = (WindowManager)ah.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.fv(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.packageName = ah.getContext().getPackageName();
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.width = b.vhq;
      localLayoutParams.height = b.vhq;
      localLayoutParams.x = this.viB.viI;
      localLayoutParams.y = this.viB.viH;
      try
      {
        localWindowManager.addView(this.viy, localLayoutParams);
        dfn();
        AppMethodBeat.o(8232);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewBagMgr", "add failed %s", new Object[] { localException });
        AppMethodBeat.o(8232);
      }
    }
  }
  
  private void dfm()
  {
    AppMethodBeat.i(8233);
    ab.i("MicroMsg.WebViewBagMgr", "unAttachBag");
    WindowManager localWindowManager;
    if (this.viy != null) {
      localWindowManager = (WindowManager)ah.getContext().getSystemService("window");
    }
    for (;;)
    {
      try
      {
        localWindowManager.removeView(this.viy);
        this.viy = null;
        if (this.viz != null)
        {
          this.viz.dfa();
          this.viz = null;
        }
        AppMethodBeat.o(8233);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewBagMgr", "remove failed %s", new Object[] { localException });
        continue;
      }
      ab.e("MicroMsg.WebViewBagMgr", "unAttachBag mBag null");
    }
  }
  
  private void dfn()
  {
    AppMethodBeat.i(8234);
    ab.i("MicroMsg.WebViewBagMgr", "setAngryInfo mBagInfo.lastActiveTime:%d", new Object[] { Long.valueOf(this.viB.fAH) });
    if (this.viy == null)
    {
      AppMethodBeat.o(8234);
      return;
    }
    if (dfo())
    {
      this.viy.l(60000, 100, this.viB.fAH + 2000L);
      AppMethodBeat.o(8234);
      return;
    }
    this.viy.l(3600000, 30000, this.viB.fAH + 3600000L);
    AppMethodBeat.o(8234);
  }
  
  private static boolean dfo()
  {
    AppMethodBeat.i(8236);
    boolean bool = "1".equals((String)g.RL().Ru().get(ac.a.yKi, "0"));
    AppMethodBeat.o(8236);
    return bool;
  }
  
  final void a(String paramString1, int paramInt, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(8231);
    if ((!paramBoolean) || (bo.isNullOrNil(this.viB.id)))
    {
      KF(23);
      this.viB.id = ag.cE(String.format("bagId#%d#%s", new Object[] { Long.valueOf(System.currentTimeMillis()), this.viB.url }));
    }
    this.viB.url = paramString1;
    this.viB.cDz = paramString2;
    this.viB.scene = paramInt;
    this.viB.fAH = bo.aoy();
    this.viB.viJ = k.an(paramBundle);
    this.viB.save();
    AppMethodBeat.o(8231);
  }
  
  public final boolean aiG(String paramString)
  {
    AppMethodBeat.i(8224);
    ab.i("MicroMsg.WebViewBagMgr", "hasBagOfThePage targetId:%s currentId:%s", new Object[] { paramString, this.viB.id });
    if ((!bo.isNullOrNil(this.viB.url)) && (bo.nullAsNil(paramString).equals(this.viB.id)))
    {
      AppMethodBeat.o(8224);
      return true;
    }
    AppMethodBeat.o(8224);
    return false;
  }
  
  public final void bn(float paramFloat)
  {
    AppMethodBeat.i(8230);
    if (this.viy == null)
    {
      AppMethodBeat.o(8230);
      return;
    }
    this.viy.setAlpha(paramFloat);
    if (paramFloat == 0.0F)
    {
      this.viy.setVisibility(8);
      AppMethodBeat.o(8230);
      return;
    }
    this.viy.setVisibility(0);
    AppMethodBeat.o(8230);
  }
  
  public final void dcS()
  {
    AppMethodBeat.i(8229);
    if (this.viy == null)
    {
      AppMethodBeat.o(8229);
      return;
    }
    this.viy.setVisibility(8);
    AppMethodBeat.o(8229);
  }
  
  public final void dfj()
  {
    AppMethodBeat.i(8223);
    ab.i("MicroMsg.WebViewBagMgr", "clearBag mCurrentUrl:%s", new Object[] { this.viB.url });
    dcS();
    Object localObject = this.viB;
    ((l.a)localObject).id = null;
    ((l.a)localObject).url = null;
    ((l.a)localObject).cDz = null;
    ((l.a)localObject).fAH = 0L;
    ((l.a)localObject).scene = 0;
    ((l.a)localObject).viJ = new JSONObject();
    ((l.a)localObject).save();
    dfm();
    localObject = this.viC.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((l.b)((Iterator)localObject).next()).dbA();
    }
    AppMethodBeat.o(8223);
  }
  
  public final Point dfk()
  {
    AppMethodBeat.i(8226);
    Point localPoint = new Point(this.viB.viI, this.viB.viH);
    AppMethodBeat.o(8226);
    return localPoint;
  }
  
  public final void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(8222);
    ab.i("MicroMsg.WebViewBagMgr", "checkResumeBag mInWebViewUIFromBag:%b", new Object[] { Boolean.valueOf(this.viA) });
    if ((!bo.isNullOrNil(this.viB.url)) && (!this.viA) && (dfi()))
    {
      if ((this.viy != null) && (this.viy.getVisibility() == 0))
      {
        ab.i("MicroMsg.WebViewBagMgr", "already show");
        this.viy.setTouchEnable(true);
        AppMethodBeat.o(8222);
        return;
      }
      oz(paramBoolean);
      ab.i("MicroMsg.WebViewBagMgr", "checkResumeBag show bag");
      AppMethodBeat.o(8222);
      return;
    }
    dcS();
    ab.i("MicroMsg.WebViewBagMgr", "checkResumeBag hide bag");
    AppMethodBeat.o(8222);
  }
  
  public final void oy(boolean paramBoolean)
  {
    AppMethodBeat.i(8225);
    ab.i("MicroMsg.WebViewBagMgr", "markInWebViewUIFromBag inWebViewUIFromBag:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.viA = paramBoolean;
    AppMethodBeat.o(8225);
  }
  
  final void oz(boolean paramBoolean)
  {
    AppMethodBeat.i(8227);
    ab.i("MicroMsg.WebViewBagMgr", "showBag url:%s", new Object[] { this.viB.url });
    if (!com.tencent.mm.compatible.f.b.bK(ah.getContext()))
    {
      ab.w("MicroMsg.WebViewBagMgr", "showBag: no float window permission");
      AppMethodBeat.o(8227);
      return;
    }
    if (bo.isNullOrNil(this.viB.url))
    {
      dfj();
      AppMethodBeat.o(8227);
      return;
    }
    if (this.viy == null) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.viy == null)
      {
        this.viz = new a(new l.2(this));
        this.viy = new WebViewBag(ah.getContext(), null);
        this.viy.setListener(new l.3(this));
        this.viy.setOnClickListener(new l.4(this));
      }
      bn(1.0F);
      this.viy.setTouchEnable(true);
      this.viy.setIcon(this.viB.cDz);
      dfn();
      ab.i("MicroMsg.WebViewBagMgr", "bag showed needAttach:%b mCurrentBagId:%s", new Object[] { Boolean.valueOf(bool), this.viB.id });
      if (!bool) {
        break label274;
      }
      if (!paramBoolean) {
        break;
      }
      this.viy.setVisibility(4);
      dfl();
      this.viy.setVisibility(0);
      this.viy.dfh();
      AppMethodBeat.o(8227);
      return;
    }
    dfl();
    AppMethodBeat.o(8227);
    return;
    label274:
    if (this.viy.getVisibility() != 0)
    {
      this.viy.setVisibility(0);
      if (paramBoolean)
      {
        this.viy.dfh();
        AppMethodBeat.o(8227);
      }
    }
    else
    {
      ab.i("MicroMsg.WebViewBagMgr", "already showed");
    }
    AppMethodBeat.o(8227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l
 * JD-Core Version:    0.7.0.1
 */