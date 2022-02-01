package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;

public final class b
  extends RelativeLayout
{
  private WebView DFI;
  private m DOe;
  private boolean DOf;
  private Runnable DOg;
  private int DOh;
  private GestureDetector lsn;
  private boolean mcS;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(207832);
    this.mcS = true;
    this.DOg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207825);
        if ((!b.a(b.this)) || (b.b(b.this)))
        {
          AppMethodBeat.o(207825);
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
              AppMethodBeat.i(207824);
              b.e(b.this);
              AppMethodBeat.o(207824);
            }
          });
          h.LTJ.r(b.f(b.this), 100L);
        }
        AppMethodBeat.o(207825);
      }
    };
    this.lsn = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207831);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(207831);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207830);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(207830);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(207827);
        if (!b.b(b.this))
        {
          b.g(b.this);
          b.a(b.this, b.c(b.this).getWebScrollY());
          b.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207826);
              b.e(b.this);
              AppMethodBeat.o(207826);
            }
          });
          h.LTJ.r(b.f(b.this), 100L);
        }
        AppMethodBeat.o(207827);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207829);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(207829);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(207828);
        return bool;
      }
    }, null);
    AppMethodBeat.o(207832);
  }
  
  private void eOY()
  {
    AppMethodBeat.i(207834);
    int i = this.DFI.getWebScrollY();
    if (i < 300) {
      this.DOe.ePA();
    }
    for (;;)
    {
      ad.i("MicroMsg.ImmersivePageView", "setActionBarAlpha, scrollY : %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(207834);
      return;
      if (i > 450)
      {
        this.DOe.setAlpha(1.0F);
      }
      else
      {
        float f = (i - 300) / 150.0F;
        this.DOe.setAlpha(f);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207833);
    this.DOf = false;
    if (this.mcS)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(207833);
      return bool;
    }
    GestureDetector localGestureDetector = this.lsn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int i = paramMotionEvent.getAction();
    if ((i == 2) || (i == 1)) {
      eOY();
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(207833);
    return bool;
  }
  
  public final void setActionBar(m paramm)
  {
    this.DOe = paramm;
  }
  
  public final void setDisable(boolean paramBoolean)
  {
    this.mcS = paramBoolean;
  }
  
  public final void setWebView(WebView paramWebView)
  {
    this.DFI = paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b
 * JD-Core Version:    0.7.0.1
 */