package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.WebView;

public final class b
  extends RelativeLayout
{
  private WebView DXF;
  private m Ege;
  private boolean Egf;
  private Runnable Egg;
  private int Egh;
  private GestureDetector lwM;
  private boolean mhk;
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198012);
    this.mhk = true;
    this.Egg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198005);
        if ((!b.a(b.this)) || (b.b(b.this)))
        {
          AppMethodBeat.o(198005);
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
              AppMethodBeat.i(198004);
              b.e(b.this);
              AppMethodBeat.o(198004);
            }
          });
          h.MqF.r(b.f(b.this), 100L);
        }
        AppMethodBeat.o(198005);
      }
    };
    this.lwM = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198011);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198010);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198010);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(198007);
        if (!b.b(b.this))
        {
          b.g(b.this);
          b.a(b.this, b.c(b.this).getWebScrollY());
          b.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198006);
              b.e(b.this);
              AppMethodBeat.o(198006);
            }
          });
          h.MqF.r(b.f(b.this), 100L);
        }
        AppMethodBeat.o(198007);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198009);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(198009);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198008);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/webview/luggage/ImmersivePageView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198008);
        return bool;
      }
    }, null);
    AppMethodBeat.o(198012);
  }
  
  private void eSK()
  {
    AppMethodBeat.i(198014);
    int i = this.DXF.getWebScrollY();
    if (i < 300) {
      this.Ege.eTm();
    }
    for (;;)
    {
      ae.i("MicroMsg.ImmersivePageView", "setActionBarAlpha, scrollY : %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(198014);
      return;
      if (i > 450)
      {
        this.Ege.setAlpha(1.0F);
      }
      else
      {
        float f = (i - 300) / 150.0F;
        this.Ege.setAlpha(f);
      }
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198013);
    this.Egf = false;
    if (this.mhk)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(198013);
      return bool;
    }
    GestureDetector localGestureDetector = this.lwM;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/webview/luggage/ImmersivePageView", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int i = paramMotionEvent.getAction();
    if ((i == 2) || (i == 1)) {
      eSK();
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(198013);
    return bool;
  }
  
  public final void setActionBar(m paramm)
  {
    this.Ege = paramm;
  }
  
  public final void setDisable(boolean paramBoolean)
  {
    this.mhk = paramBoolean;
  }
  
  public final void setWebView(WebView paramWebView)
  {
    this.DXF = paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b
 * JD-Core Version:    0.7.0.1
 */