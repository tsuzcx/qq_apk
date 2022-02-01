package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

public final class d
  implements f
{
  private g DOl;
  private Intent mIntent;
  
  public d(g paramg)
  {
    AppMethodBeat.i(78201);
    this.mIntent = new Intent();
    this.DOl = paramg;
    this.mIntent.putExtras(paramg.mParams);
    AppMethodBeat.o(78201);
  }
  
  private boolean eOZ()
  {
    AppMethodBeat.i(78211);
    ad.i("MicroMsg.LuggageFloatBallPageAdapter", "useActivityEnv: " + this.DOl.chm.Cd().size());
    if (this.DOl.chm.Cd().size() <= 1)
    {
      AppMethodBeat.o(78211);
      return true;
    }
    AppMethodBeat.o(78211);
    return false;
  }
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(78209);
    if (parama == null)
    {
      AppMethodBeat.o(78209);
      return;
    }
    if ((this.DOl.mContentView == null) || (!(this.DOl.mContentView instanceof me.imid.swipebacklayout.lib.SwipeBackLayout)))
    {
      AppMethodBeat.o(78209);
      return;
    }
    if (!eOZ()) {
      ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.DOl.mContentView).a(new SwipeBackLayout.a()
      {
        public final void Cs() {}
        
        public final int bq(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78196);
          if (parama != null)
          {
            int i = parama.iL(paramAnonymousBoolean);
            AppMethodBeat.o(78196);
            return i;
          }
          AppMethodBeat.o(78196);
          return 1;
        }
        
        public final void i(int paramAnonymousInt, float paramAnonymousFloat)
        {
          AppMethodBeat.i(78194);
          if (parama != null) {
            parama.aR(paramAnonymousFloat);
          }
          AppMethodBeat.o(78194);
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78195);
          if (parama != null) {
            parama.k(paramAnonymousMotionEvent);
          }
          AppMethodBeat.o(78195);
        }
      });
    }
    if ((eOZ()) && (((MMActivity)getActivity()).getSwipeBackLayout() != null)) {
      ((MMActivity)getActivity()).getSwipeBackLayout().setSwipeBackListener(new SwipeBackLayout.b()
      {
        public final void aQ(float paramAnonymousFloat)
        {
          AppMethodBeat.i(78197);
          if (parama != null) {
            parama.aR(paramAnonymousFloat);
          }
          AppMethodBeat.o(78197);
        }
        
        public final int bq(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78199);
          if (parama != null)
          {
            int i = parama.iL(paramAnonymousBoolean);
            AppMethodBeat.o(78199);
            return i;
          }
          AppMethodBeat.o(78199);
          return 1;
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78198);
          if (parama != null) {
            parama.k(paramAnonymousMotionEvent);
          }
          AppMethodBeat.o(78198);
        }
      });
    }
    AppMethodBeat.o(78209);
  }
  
  public final void a(final f.b paramb)
  {
    AppMethodBeat.i(78210);
    if (eOZ())
    {
      b.a(getActivity(), new b.a()
      {
        public final void iK(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78200);
          paramb.iK(paramAnonymousBoolean);
          AppMethodBeat.o(78200);
        }
      });
      AppMethodBeat.o(78210);
      return;
    }
    paramb.iK(true);
    AppMethodBeat.o(78210);
  }
  
  public final ViewGroup bJP()
  {
    AppMethodBeat.i(78203);
    if (eOZ())
    {
      localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      AppMethodBeat.o(78203);
      return localViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)this.DOl.mContentView.getParent();
    AppMethodBeat.o(78203);
    return localViewGroup;
  }
  
  public final int bJQ()
  {
    AppMethodBeat.i(78207);
    if (eOZ())
    {
      AppMethodBeat.o(78207);
      return -1;
    }
    AppMethodBeat.o(78207);
    return 0;
  }
  
  public final boolean bgM()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    return this.DOl.mContentView != null;
  }
  
  public final Activity getActivity()
  {
    return (Activity)this.DOl.mContext;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(78206);
    Bitmap localBitmap = com.tencent.mm.sdk.platformtools.g.gb(getContentView());
    AppMethodBeat.o(78206);
    return localBitmap;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(78204);
    if (eOZ())
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
    View localView = ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.DOl.mContentView).getTargetView();
    AppMethodBeat.o(78204);
    return localView;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(78202);
    if (!bt.isNullOrNil(this.DOl.getTitle())) {
      this.mIntent.putExtra("title", this.DOl.getTitle());
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
  
  public final void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(78208);
    Activity localActivity;
    if (!this.DOl.chm.Ce().bp(false))
    {
      localActivity = (Activity)this.DOl.mContext;
      if (!paramBoolean) {
        break label73;
      }
      localActivity.getIntent().putExtra("MMActivity.OverrideExitAnimation", 2130772100);
      localActivity.getIntent().putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
    }
    for (;;)
    {
      localActivity.finish();
      AppMethodBeat.o(78208);
      return;
      label73:
      localActivity.getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
      localActivity.getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d
 * JD-Core Version:    0.7.0.1
 */