package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public final class b
  extends RelativeLayout
{
  private WebView IJw;
  private m ISN;
  private boolean ISO;
  private Runnable ISP;
  private int ISQ;
  private GestureDetector mDJ;
  private boolean mDisabled;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(210868);
    this.mDisabled = true;
    this.ISP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210861);
        if ((!b.a(b.this)) || (b.b(b.this)))
        {
          AppMethodBeat.o(210861);
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
              AppMethodBeat.i(210860);
              b.e(b.this);
              AppMethodBeat.o(210860);
            }
          });
          h.RTc.o(b.f(b.this), 100L);
        }
        AppMethodBeat.o(210861);
      }
    };
    this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210867);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210867);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210866);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210866);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(210863);
        if (!b.b(b.this))
        {
          b.g(b.this);
          b.a(b.this, b.c(b.this).getWebScrollY());
          b.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210862);
              b.e(b.this);
              AppMethodBeat.o(210862);
            }
          });
          h.RTc.o(b.f(b.this), 100L);
        }
        AppMethodBeat.o(210863);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210865);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(210865);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210864);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210864);
        return bool;
      }
    }, null);
    AppMethodBeat.o(210868);
  }
  
  private void gbw()
  {
    AppMethodBeat.i(210870);
    int i = this.IJw.getWebScrollY();
    if (i < 300) {
      this.ISN.gbZ();
    }
    for (;;)
    {
      Log.i("MicroMsg.ImmersivePageView", "setActionBarAlpha, scrollY : %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(210870);
      return;
      if (i > 450)
      {
        this.ISN.setAlpha(1.0F);
      }
      else
      {
        float f = (i - 300) / 150.0F;
        this.ISN.setAlpha(f);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(210869);
    this.ISO = false;
    if (this.mDisabled)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(210869);
      return bool;
    }
    GestureDetector localGestureDetector = this.mDJ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int i = paramMotionEvent.getAction();
    if ((i == 2) || (i == 1)) {
      gbw();
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(210869);
    return bool;
  }
  
  public final void setActionBar(m paramm)
  {
    this.ISN = paramm;
  }
  
  public final void setDisable(boolean paramBoolean)
  {
    this.mDisabled = paramBoolean;
  }
  
  public final void setWebView(WebView paramWebView)
  {
    this.IJw = paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b
 * JD-Core Version:    0.7.0.1
 */