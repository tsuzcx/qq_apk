package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebView;

public final class b
  extends RelativeLayout
{
  private boolean WFA;
  private Runnable WFB;
  private int WFC;
  private n WFz;
  private WebView WvQ;
  private boolean mDisabled;
  private GestureDetector mQj;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(295930);
    this.mDisabled = true;
    this.WFB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(295909);
        if ((!b.a(b.this)) || (b.b(b.this)))
        {
          AppMethodBeat.o(295909);
          return;
        }
        int i = b.c(b.this).getWebScrollY();
        if (b.d(b.this) != i)
        {
          b.a(b.this, i);
          b.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(295924);
              b.e(b.this);
              AppMethodBeat.o(295924);
            }
          });
          h.ahAA.p(b.f(b.this), 100L);
        }
        AppMethodBeat.o(295909);
      }
    };
    this.mQj = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(295912);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(295912);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(295910);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(295910);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(295903);
        if (!b.b(b.this))
        {
          b.g(b.this);
          b.a(b.this, b.c(b.this).getWebScrollY());
          b.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(295973);
              b.e(b.this);
              AppMethodBeat.o(295973);
            }
          });
          h.ahAA.p(b.f(b.this), 100L);
        }
        AppMethodBeat.o(295903);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(295908);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(295908);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(295907);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(295907);
        return bool;
      }
    }, null);
    AppMethodBeat.o(295930);
  }
  
  private void itY()
  {
    AppMethodBeat.i(295931);
    int i = this.WvQ.getWebScrollY();
    if (i < 300) {
      this.WFz.iuG();
    }
    for (;;)
    {
      Log.i("MicroMsg.ImmersivePageView", "setActionBarAlpha, scrollY : %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(295931);
      return;
      if (i > 450)
      {
        this.WFz.setAlpha(1.0F);
      }
      else
      {
        float f = (i - 300) / 150.0F;
        this.WFz.setAlpha(f);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(295949);
    this.WFA = false;
    if (this.mDisabled)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(295949);
      return bool;
    }
    GestureDetector localGestureDetector = this.mQj;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int i = paramMotionEvent.getAction();
    if ((i == 2) || (i == 1)) {
      itY();
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(295949);
    return bool;
  }
  
  public final void setActionBar(n paramn)
  {
    this.WFz = paramn;
  }
  
  public final void setDisable(boolean paramBoolean)
  {
    this.mDisabled = paramBoolean;
  }
  
  public final void setWebView(WebView paramWebView)
  {
    this.WvQ = paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b
 * JD-Core Version:    0.7.0.1
 */