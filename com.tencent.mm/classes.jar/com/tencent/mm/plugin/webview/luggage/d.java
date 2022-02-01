package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import com.tencent.mm.ui.n.a;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import java.util.LinkedList;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

public final class d
  implements f
{
  private g ISU;
  private Intent mIntent;
  
  public d(g paramg)
  {
    AppMethodBeat.i(78201);
    this.mIntent = new Intent();
    this.ISU = paramg;
    this.mIntent.putExtras(paramg.mParams);
    AppMethodBeat.o(78201);
  }
  
  private boolean gbx()
  {
    AppMethodBeat.i(78211);
    Log.i("MicroMsg.LuggageFloatBallPageAdapter", "useActivityEnv: " + this.ISU.ctg.Lx().size());
    if (this.ISU.ctg.Lx().size() <= 1)
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
    if ((this.ISU.mContentView == null) || (!(this.ISU.mContentView instanceof me.imid.swipebacklayout.lib.SwipeBackLayout)))
    {
      AppMethodBeat.o(78209);
      return;
    }
    if (!gbx()) {
      ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.ISU.mContentView).a(new SwipeBackLayout.a()
      {
        public final void LN() {}
        
        public final int bS(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78196);
          if (parama != null)
          {
            int i = parama.jJ(paramAnonymousBoolean);
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
            parama.aY(paramAnonymousFloat);
          }
          AppMethodBeat.o(78194);
        }
        
        public final void n(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78195);
          if (parama != null) {
            parama.n(paramAnonymousMotionEvent);
          }
          AppMethodBeat.o(78195);
        }
      });
    }
    if ((gbx()) && (((MMActivity)getActivity()).getSwipeBackLayout() != null)) {
      ((MMActivity)getActivity()).getSwipeBackLayout().setSwipeBackListener(new SwipeBackLayout.b()
      {
        public final void RF(int paramAnonymousInt) {}
        
        public final int bS(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78199);
          if (parama != null)
          {
            int i = parama.jJ(paramAnonymousBoolean);
            AppMethodBeat.o(78199);
            return i;
          }
          AppMethodBeat.o(78199);
          return 1;
        }
        
        public final void bw(float paramAnonymousFloat)
        {
          AppMethodBeat.i(78197);
          if (parama != null) {
            parama.aY(paramAnonymousFloat);
          }
          AppMethodBeat.o(78197);
        }
        
        public final int eqE()
        {
          return 0;
        }
        
        public final boolean eqF()
        {
          return true;
        }
        
        public final boolean eqH()
        {
          return false;
        }
        
        public final boolean j(MotionEvent paramAnonymousMotionEvent)
        {
          return false;
        }
        
        public final void n(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(78198);
          if (parama != null) {
            parama.n(paramAnonymousMotionEvent);
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
    if (gbx())
    {
      b.a(getActivity(), new b.b()
      {
        public final void ei(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(78200);
          paramb.ei(paramAnonymousBoolean);
          AppMethodBeat.o(78200);
        }
      });
      AppMethodBeat.o(78210);
      return;
    }
    paramb.ei(true);
    AppMethodBeat.o(78210);
  }
  
  public final boolean aGg()
  {
    return this.ISU.mContentView != null;
  }
  
  public final boolean bCI()
  {
    return true;
  }
  
  public final ViewGroup chG()
  {
    AppMethodBeat.i(78203);
    if (gbx())
    {
      localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      AppMethodBeat.o(78203);
      return localViewGroup;
    }
    ViewGroup localViewGroup = (ViewGroup)this.ISU.mContentView.getParent();
    AppMethodBeat.o(78203);
    return localViewGroup;
  }
  
  public final int chH()
  {
    AppMethodBeat.i(78207);
    if (gbx())
    {
      AppMethodBeat.o(78207);
      return -1;
    }
    AppMethodBeat.o(78207);
    return 0;
  }
  
  public final Activity getActivity()
  {
    return (Activity)this.ISU.mContext;
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
    if (gbx())
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
    View localView = ((me.imid.swipebacklayout.lib.SwipeBackLayout)this.ISU.mContentView).getTargetView();
    AppMethodBeat.o(78204);
    return localView;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(78202);
    if (!Util.isNullOrNil(this.ISU.getTitle())) {
      this.mIntent.putExtra("title", this.ISU.getTitle());
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
  
  public final void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(78208);
    Activity localActivity;
    if (!this.ISU.ctg.Ly().bR(false))
    {
      localActivity = (Activity)this.ISU.mContext;
      if (!paramBoolean) {
        break label73;
      }
      localActivity.getIntent().putExtra("MMActivity.OverrideExitAnimation", 2130772124);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d
 * JD-Core Version:    0.7.0.1
 */