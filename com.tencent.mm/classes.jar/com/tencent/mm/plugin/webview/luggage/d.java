package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.luggage.d.h;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.a.f.a;
import com.tencent.mm.plugin.ball.a.f.b;
import com.tencent.mm.plugin.webview.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import com.tencent.mm.ui.p.a;
import java.util.LinkedList;

public final class d
  implements f
{
  private g WFG;
  private Intent mIntent;
  
  public d(g paramg)
  {
    AppMethodBeat.i(78201);
    this.mIntent = new Intent();
    this.WFG = paramg;
    this.mIntent.putExtras(paramg.ejT);
    AppMethodBeat.o(78201);
  }
  
  private boolean itZ()
  {
    AppMethodBeat.i(78211);
    Log.i("MicroMsg.LuggageFloatBallPageAdapter", "useActivityEnv: " + this.WFG.eje.aov().size());
    if (this.WFG.eje.aov().size() <= 1)
    {
      AppMethodBeat.o(78211);
      return true;
    }
    AppMethodBeat.o(78211);
    return false;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(78209);
    AppMethodBeat.o(78209);
  }
  
  public final void a(final f.b paramb)
  {
    AppMethodBeat.i(78210);
    if (itZ())
    {
      b.a(getActivity(), new b.b()
      {
        public final void onComplete(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(295905);
          paramb.onComplete(paramAnonymousBoolean);
          AppMethodBeat.o(295905);
        }
      });
      AppMethodBeat.o(78210);
      return;
    }
    paramb.onComplete(true);
    AppMethodBeat.o(78210);
  }
  
  public final boolean bhU()
  {
    return this.WFG.mContentView != null;
  }
  
  public final ViewGroup cXB()
  {
    AppMethodBeat.i(78203);
    if (itZ())
    {
      localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      AppMethodBeat.o(78203);
      return localViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)this.WFG.mContentView.getParent();
    AppMethodBeat.o(78203);
    return localViewGroup;
  }
  
  public final int cXC()
  {
    AppMethodBeat.i(78207);
    if (itZ())
    {
      AppMethodBeat.o(78207);
      return -1;
    }
    AppMethodBeat.o(78207);
    return 0;
  }
  
  public final boolean cor()
  {
    return true;
  }
  
  public final Activity getActivity()
  {
    return (Activity)this.WFG.mContext;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(78206);
    Bitmap localBitmap = a.a(getContentView(), Bitmap.Config.ARGB_8888);
    AppMethodBeat.o(78206);
    return localBitmap;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(78204);
    if (itZ())
    {
      if (((MMActivity)getActivity()).getSwipeBackLayout() != null)
      {
        localView = ((MMActivity)getActivity()).getSwipeBackLayout().getTargetContentView();
        AppMethodBeat.o(78204);
        return localView;
      }
      AppMethodBeat.o(78204);
      return null;
    }
    View localView = ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.WFG.mContentView).getTargetView();
    AppMethodBeat.o(78204);
    return localView;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(78202);
    if (!Util.isNullOrNil(this.WFG.getTitle())) {
      this.mIntent.putExtra("title", this.WFG.getTitle());
    }
    Intent localIntent = this.mIntent;
    AppMethodBeat.o(78202);
    return localIntent;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(78205);
    View localView = getContentView();
    AppMethodBeat.o(78205);
    return localView;
  }
  
  public final void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(78208);
    Activity localActivity;
    if (!this.WFG.eje.aow().cH(false))
    {
      localActivity = (Activity)this.WFG.mContext;
      if (!paramBoolean) {
        break label75;
      }
      localActivity.getIntent().putExtra("MMActivity.OverrideExitAnimation", c.a.pop_out);
      localActivity.getIntent().putExtra("MMActivity.OverrideEnterAnimation", c.a.anim_not_change);
    }
    for (;;)
    {
      localActivity.finish();
      AppMethodBeat.o(78208);
      return;
      label75:
      localActivity.getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
      localActivity.getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d
 * JD-Core Version:    0.7.0.1
 */