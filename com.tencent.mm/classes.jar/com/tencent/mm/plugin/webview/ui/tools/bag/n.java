package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  implements h
{
  private int fzn = 0;
  private final g rrt;
  private final f rru;
  private h.a rsF;
  private d rsG;
  private c rsH;
  private String rsI;
  private String rsJ;
  private final e rsK;
  private boolean rsL;
  private boolean rsM;
  private String rsN;
  
  public n(g paramg)
  {
    this.rrt = paramg;
    if (this.rrt.getIntent().getExtras() != null) {
      this.fzn = this.rrt.getIntent().getIntExtra("minimize_secene", this.fzn);
    }
    this.rru = new n.1(this);
    this.rsK = new n.2(this);
    this.rsL = this.rrt.getIntent().getBooleanExtra("from_bag", false);
    this.rsN = this.rrt.getIntent().getStringExtra("from_bag_id");
    this.rsJ = this.rrt.getIntent().getStringExtra("from_bag_icon");
    if (cbo())
    {
      if (!this.rsL)
      {
        y.i("MicroMsg.WebViewUIBagHelper", "not from bag, can swipe to bag");
        this.rsG = new d(this.rrt, this.rru);
        return;
      }
      this.rsH = new c(this.rrt, this.rru);
      return;
    }
    y.i("MicroMsg.WebViewUIBagHelper", "not support swipeback");
  }
  
  private void CM(int paramInt)
  {
    y.v("MicroMsg.WebViewUIBagHelper", "kvReport op:%d", new Object[] { Integer.valueOf(paramInt) });
    if (this.rsF == null)
    {
      y.w("MicroMsg.WebViewUIBagHelper", "kvReport mIPCDelegate null");
      return;
    }
    cfg();
    String str1 = this.rsI;
    String str2 = this.rsN;
    this.rsF.u(new Object[] { str1, Integer.valueOf(paramInt), Integer.valueOf(0), str2 });
  }
  
  private Bundle CN(int paramInt)
  {
    return t(paramInt, new Bundle());
  }
  
  private boolean cbo()
  {
    return this.rrt.cbo();
  }
  
  private void cfg()
  {
    if (bk.bl(this.rsI)) {
      this.rsI = this.rrt.getUrl();
    }
  }
  
  private Bundle t(int paramInt, Bundle paramBundle)
  {
    y.i("MicroMsg.WebViewUIBagHelper", "Tools doBagLogic : %d, hashcode:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()) });
    if (this.rsF == null)
    {
      y.w("MicroMsg.WebViewUIBagHelper", "doBagLogic mIPCDelegate null");
      return null;
    }
    paramBundle.putInt("key_action", paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return this.rsF.L(paramBundle);
      this.rsM = true;
      cfg();
      paramBundle.putString("key_url", this.rsI);
      paramBundle.putString("key_bag_icon", this.rsJ);
      paramBundle.putInt("key_scene", this.fzn);
      paramBundle.putBundle("key_extras", k.af(this.rrt.getIntent()));
      paramBundle.putBoolean("key_from_bag", this.rsL);
      continue;
      paramBundle.putBoolean("key_in_webviewui_from_bag", true);
      continue;
      paramBundle.putBoolean("key_in_webviewui_from_bag", false);
      continue;
      paramBundle.putString("key_bag_id", this.rsN);
      continue;
      this.rsM = false;
    }
  }
  
  public final boolean CL(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = ceZ();
    y.i("MicroMsg.WebViewUIBagHelper", "onWebViewClose hasBag:%b", new Object[] { Boolean.valueOf(bool2) });
    if (bool2)
    {
      CM(paramInt);
      Point localPoint = (Point)CN(8).getParcelable("key_current_bag_pos");
      i.a(this.rrt, localPoint, this.rsK);
      bool1 = true;
    }
    return bool1;
  }
  
  public final void TC(String paramString)
  {
    this.rsJ = paramString;
  }
  
  public final void TD(String paramString)
  {
    y.i("MicroMsg.WebViewUIBagHelper", "updateUrl url:%s", new Object[] { paramString });
    this.rsI = paramString;
  }
  
  public final void a(h.a parama)
  {
    y.i("MicroMsg.WebViewUIBagHelper", "onIPCReady");
    this.rsF = parama;
    if (!this.rsL) {
      if ((cbo()) && (this.rsG != null)) {
        this.rsG.start();
      }
    }
    do
    {
      return;
      CN(5);
    } while ((!cbo()) || (this.rsH == null));
    parama = this.rsH;
    parama.rrt.a(new c.1(parama));
  }
  
  public final void ceY()
  {
    y.i("MicroMsg.WebViewUIBagHelper", "onWebViewUIDestroy");
    CN(6);
    if (this.rsG != null)
    {
      d locald = this.rsG;
      ai.d(new d.2(locald));
      locald.rrt.a(null);
      locald.rrt = null;
    }
    if (this.rsL) {
      CN(3);
    }
  }
  
  public final boolean ceZ()
  {
    y.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage fromBag:%b，isTransformBag:%b, hashcode:%d", new Object[] { Boolean.valueOf(this.rsL), Boolean.valueOf(this.rsM), Integer.valueOf(hashCode()) });
    if (this.rsM) {}
    boolean bool;
    do
    {
      return true;
      if (!this.rsL) {
        return false;
      }
      Bundle localBundle = CN(7);
      if (localBundle == null) {
        return false;
      }
      bool = localBundle.getBoolean("key_has_bag");
      y.i("MicroMsg.WebViewUIBagHelper", "hasBagOfCurrentPage  hasBag:%b", new Object[] { Boolean.valueOf(bool) });
    } while ((bool) && (this.rsL));
    return false;
  }
  
  public final void lo(boolean paramBoolean)
  {
    y.i("MicroMsg.WebViewUIBagHelper", "onMenuMinimizeSelected cancelCurrentBag:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      CN(4);
      if (this.rsH != null) {
        this.rsH.rrt.a(null);
      }
      CM(18);
      com.tencent.mm.ui.widget.snackbar.b.h(this.rrt.getActivity(), this.rrt.getActivity().getString(R.l.readerapp_cancel_minimize_done));
      if (cbo())
      {
        this.rsG = new d(this.rrt, this.rru);
        this.rsG.start();
      }
      return;
    }
    CM(16);
    Object localObject = CN(8);
    if (localObject == null) {}
    for (localObject = new Point(b.rrm, b.rrm);; localObject = (Point)((Bundle)localObject).getParcelable("key_current_bag_pos"))
    {
      i.a(this.rrt, (Point)localObject, this.rsK);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n
 * JD-Core Version:    0.7.0.1
 */