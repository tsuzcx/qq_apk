package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;
import java.util.LinkedList;

public final class m
  implements com.tencent.mm.plugin.webview.ui.tools.bag.g
{
  private Intent intent;
  private e uSb;
  
  public m(e parame)
  {
    AppMethodBeat.i(6206);
    this.intent = new Intent();
    this.uSb = parame;
    this.intent.putExtras(this.uSb.bzu);
    AppMethodBeat.o(6206);
  }
  
  private boolean dbt()
  {
    AppMethodBeat.i(6214);
    ab.i("MicroMsg.LuggageWebBagAdapter", "useActivityEnv: " + this.uSb.byJ.um().size());
    if (this.uSb.byJ.um().size() <= 1)
    {
      AppMethodBeat.o(6214);
      return true;
    }
    AppMethodBeat.o(6214);
    return false;
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(6211);
    if (parama == null)
    {
      AppMethodBeat.o(6211);
      return;
    }
    if ((this.uSb.Qz == null) || (!(this.uSb.Qz instanceof me.imid.swipebacklayout.lib.SwipeBackLayout)))
    {
      AppMethodBeat.o(6211);
      return;
    }
    if (!dbt()) {
      ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.uSb.Qz).a(new m.1(this, parama));
    }
    if ((dbt()) && (((MMActivity)getActivity()).getSwipeBackLayout() != null)) {
      ((MMActivity)getActivity()).getSwipeBackLayout().setSwipeBackListener(new m.2(this, parama));
    }
    AppMethodBeat.o(6211);
  }
  
  public final void a(final g.b paramb)
  {
    AppMethodBeat.i(6213);
    if (dbt())
    {
      b.a(getActivity(), new b.a()
      {
        public final void iX(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(6205);
          paramb.iX(paramAnonymousBoolean);
          AppMethodBeat.o(6205);
        }
      });
      AppMethodBeat.o(6213);
      return;
    }
    paramb.iX(true);
    AppMethodBeat.o(6213);
  }
  
  public final ViewGroup bTL()
  {
    AppMethodBeat.i(6209);
    if (dbt())
    {
      localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      AppMethodBeat.o(6209);
      return localViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)this.uSb.Qz.getParent();
    AppMethodBeat.o(6209);
    return localViewGroup;
  }
  
  public final boolean dbs()
  {
    return this.uSb.Qz != null;
  }
  
  public final Activity getActivity()
  {
    return (Activity)this.uSb.mContext;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(6210);
    if (dbt())
    {
      if (((MMActivity)getActivity()).getSwipeBackLayout() != null)
      {
        localView = ((MMActivity)getActivity()).getSwipeBackLayout().getTargetContentView();
        AppMethodBeat.o(6210);
        return localView;
      }
      AppMethodBeat.o(6210);
      return null;
    }
    View localView = ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.uSb.Qz).getTargetView();
    AppMethodBeat.o(6210);
    return localView;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(6207);
    if (!bo.isNullOrNil(this.uSb.getTitle())) {
      this.intent.putExtra("title", this.uSb.getTitle());
    }
    Intent localIntent = this.intent;
    AppMethodBeat.o(6207);
    return localIntent;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(6208);
    String str = this.uSb.getUrl();
    AppMethodBeat.o(6208);
    return str;
  }
  
  public final void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(6212);
    if (!this.uSb.byJ.un().aY(false)) {
      ((Activity)this.uSb.mContext).finish();
    }
    AppMethodBeat.o(6212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.m
 * JD-Core Version:    0.7.0.1
 */