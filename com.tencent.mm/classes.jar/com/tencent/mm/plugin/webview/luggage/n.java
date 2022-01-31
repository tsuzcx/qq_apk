package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.luggage.e.h;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import java.util.LinkedList;

public final class n
  implements com.tencent.mm.plugin.webview.ui.tools.bag.g
{
  private Intent intent = new Intent();
  private e rcp;
  
  public n(e parame)
  {
    this.rcp = parame;
    this.intent.putExtras(this.rcp.biV);
  }
  
  private boolean cbp()
  {
    y.i("MicroMsg.LuggageWebBagAdapter", "useActivityEnv: " + this.rcp.bil.getPageStack().size());
    return this.rcp.bil.getPageStack().size() <= 1;
  }
  
  public final void a(g.a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        return;
      } while ((this.rcp.QR == null) || (!(this.rcp.QR instanceof me.imid.swipebacklayout.lib.SwipeBackLayout)));
      if (!cbp()) {
        ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.rcp.QR).a(new n.1(this, parama));
      }
    } while ((!cbp()) || (((MMActivity)getActivity()).getSwipeBackLayout() == null));
    ((MMActivity)getActivity()).getSwipeBackLayout().setSwipeBackListener(new n.2(this, parama));
  }
  
  public final void a(g.b paramb)
  {
    if (cbp())
    {
      b.a(getActivity(), new n.3(this, paramb));
      return;
    }
    paramb.ld(true);
  }
  
  public final ViewGroup cbn()
  {
    if (cbp()) {
      return (ViewGroup)getActivity().getWindow().getDecorView();
    }
    return (ViewGroup)this.rcp.QR.getParent();
  }
  
  public final boolean cbo()
  {
    return this.rcp.QR != null;
  }
  
  public final Activity getActivity()
  {
    return (Activity)this.rcp.mContext;
  }
  
  public final View getContentView()
  {
    if (cbp())
    {
      if (((MMActivity)getActivity()).getSwipeBackLayout() != null) {
        return ((MMActivity)getActivity()).getSwipeBackLayout().getTargetContentView();
      }
      return null;
    }
    return ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.rcp.QR).getTargetView();
  }
  
  public final Intent getIntent()
  {
    if (!bk.bl(this.rcp.rbE.getTitle())) {
      this.intent.putExtra("title", this.rcp.rbE.getTitle());
    }
    return this.intent;
  }
  
  public final String getUrl()
  {
    return this.rcp.getUrl();
  }
  
  public final void jW(boolean paramBoolean)
  {
    if (!this.rcp.bil.qj().aJ(false)) {
      ((Activity)this.rcp.mContext).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n
 * JD-Core Version:    0.7.0.1
 */