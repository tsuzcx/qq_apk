package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public class EmbedWebView
  extends MMWebView
{
  private GestureDetector xvn;
  private boolean xvo;
  private float[] xvp;
  private float[] xvq;
  private float[] xvr;
  private float[] xvs;
  
  public EmbedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123006);
    this.xvo = false;
    this.xvp = new float[2];
    this.xvq = new float[2];
    this.xvr = new float[2];
    this.xvs = new float[2];
    this.xvn = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(218051);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(218051);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123003);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        paramAnonymousMotionEvent = EmbedWebView.this;
        ae.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + paramAnonymousMotionEvent.getScale());
        int i = 10;
        while (paramAnonymousMotionEvent.getScale() != 1.0F)
        {
          i -= 1;
          if (i <= 0) {
            break;
          }
          if (paramAnonymousMotionEvent.getScale() > 1.0F) {
            paramAnonymousMotionEvent.zoomOut();
          } else {
            paramAnonymousMotionEvent.zoomIn();
          }
        }
        ae.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + EmbedWebView.this.getScale());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123003);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(218050);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(218050);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(218049);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(218049);
        return bool;
      }
    });
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123005);
        View localView = (View)EmbedWebView.this.getParent();
        if (localView == null)
        {
          AppMethodBeat.o(123005);
          return;
        }
        localView = (View)localView.getParent();
        if ((localView != null) && ((localView instanceof ScrollView)))
        {
          EmbedWebView.a(EmbedWebView.this);
          localView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              AppMethodBeat.i(123004);
              b localb = new b();
              localb.bd(paramAnonymous2View);
              localb.bd(paramAnonymous2MotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
              if (paramAnonymous2MotionEvent.getPointerCount() == 2) {
                EmbedWebView.this.onTouchEvent(paramAnonymous2MotionEvent);
              }
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(123004);
              return false;
            }
          });
        }
        AppMethodBeat.o(123005);
      }
    }, 100L);
    AppMethodBeat.o(123006);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(123007);
    GestureDetector localGestureDetector = this.xvn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/qqmail/ui/EmbedWebView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/qqmail/ui/EmbedWebView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int i;
    int j;
    if (this.xvo)
    {
      i = paramMotionEvent.getAction();
      j = paramMotionEvent.getPointerCount();
      if (j == 2) {
        break label126;
      }
      i = 0;
    }
    while (i == 0)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(123007);
      return bool;
      label126:
      switch (i & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
        i = 1;
        break;
      case 5: 
        i = 0;
        while (i < j)
        {
          this.xvp[i] = paramMotionEvent.getX(i);
          this.xvq[i] = paramMotionEvent.getY(i);
          i += 1;
        }
      case 2: 
        i = 0;
        while (i < j)
        {
          this.xvr[i] = paramMotionEvent.getX(i);
          this.xvs[i] = paramMotionEvent.getY(i);
          i += 1;
        }
        float f1 = (float)(Math.pow(this.xvp[1] - this.xvp[0], 2.0D) + Math.pow(this.xvq[1] - this.xvq[0], 2.0D));
        float f2 = (float)(Math.pow(this.xvr[1] - this.xvr[0], 2.0D) + Math.pow(this.xvs[1] - this.xvs[0], 2.0D));
        if (f1 - f2 > 20000.0F) {
          zoomOut();
        }
        for (;;)
        {
          this.xvp[0] = this.xvr[0];
          this.xvp[1] = this.xvr[1];
          this.xvq[0] = this.xvs[0];
          this.xvq[1] = this.xvs[1];
          break;
          if (f2 - f1 > 20000.0F) {
            zoomIn();
          }
        }
      }
    }
    AppMethodBeat.o(123007);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView
 * JD-Core Version:    0.7.0.1
 */