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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public class EmbedWebView
  extends MMWebView
{
  private boolean NnA;
  private float[] NnB;
  private float[] NnC;
  private float[] NnD;
  private float[] NnE;
  private GestureDetector Nnz;
  
  public EmbedWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(123006);
    this.NnA = false;
    this.NnB = new float[2];
    this.NnC = new float[2];
    this.NnD = new float[2];
    this.NnE = new float[2];
    this.Nnz = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(266966);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(266966);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(123003);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        paramAnonymousMotionEvent = EmbedWebView.this;
        Log.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + paramAnonymousMotionEvent.getScale());
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
        Log.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + EmbedWebView.this.getScale());
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(123003);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(266963);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(266963);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(266959);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/qqmail/ui/EmbedWebView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(266959);
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
              if (paramAnonymous2MotionEvent.getPointerCount() == 2) {
                EmbedWebView.this.onTouchEvent(paramAnonymous2MotionEvent);
              }
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
    GestureDetector localGestureDetector = this.Nnz;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/plugin/qqmail/ui/EmbedWebView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/qqmail/ui/EmbedWebView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    int i;
    int j;
    if (this.NnA)
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
          this.NnB[i] = paramMotionEvent.getX(i);
          this.NnC[i] = paramMotionEvent.getY(i);
          i += 1;
        }
      case 2: 
        i = 0;
        while (i < j)
        {
          this.NnD[i] = paramMotionEvent.getX(i);
          this.NnE[i] = paramMotionEvent.getY(i);
          i += 1;
        }
        float f1 = (float)(Math.pow(this.NnB[1] - this.NnB[0], 2.0D) + Math.pow(this.NnC[1] - this.NnC[0], 2.0D));
        float f2 = (float)(Math.pow(this.NnD[1] - this.NnD[0], 2.0D) + Math.pow(this.NnE[1] - this.NnE[0], 2.0D));
        if (f1 - f2 > 20000.0F) {
          zoomOut();
        }
        for (;;)
        {
          this.NnB[0] = this.NnD[0];
          this.NnB[1] = this.NnD[1];
          this.NnC[0] = this.NnE[0];
          this.NnC[1] = this.NnE[1];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView
 * JD-Core Version:    0.7.0.1
 */