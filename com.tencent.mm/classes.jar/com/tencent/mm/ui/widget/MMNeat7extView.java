package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class MMNeat7extView
  extends NeatTextView
{
  public static boolean QCT;
  private static final String QCU;
  private static boolean VC;
  private View.OnLongClickListener QCV;
  private a QCW;
  private b QCX;
  private GestureDetector mDJ;
  
  static
  {
    AppMethodBeat.i(143376);
    QCT = false;
    QCU = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    VC = true;
    AppMethodBeat.o(143376);
  }
  
  public MMNeat7extView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164209);
    init();
    AppMethodBeat.o(164209);
  }
  
  public MMNeat7extView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143366);
    init();
    AppMethodBeat.o(143366);
  }
  
  private void init()
  {
    AppMethodBeat.i(164210);
    this.mDJ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205403);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205403);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143364);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        if (MMNeat7extView.this.getOnDoubleClickListener() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143364);
          return false;
        }
        boolean bool = MMNeat7extView.this.getOnDoubleClickListener().gS(MMNeat7extView.this);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143364);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205402);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(205402);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205401);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205401);
        return bool;
      }
    });
    AppMethodBeat.o(164210);
  }
  
  public final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(143373);
    try
    {
      super.a(paramCharSequence, paramBufferType);
      if ((this.pMM) && (this.QCX != null)) {
        paramCharSequence.toString();
      }
      if (this.QCW != null) {
        this.QCW.at(paramCharSequence);
      }
      AppMethodBeat.o(143373);
      return;
    }
    catch (Exception paramBufferType)
    {
      for (;;)
      {
        String str = hiT().toString().replaceAll(QCU, "*");
        Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { str, paramBufferType });
        if (this.QCX == null) {
          break;
        }
        this.QCX.a(paramBufferType, str, "_setText");
      }
      AppMethodBeat.o(143373);
      throw paramBufferType;
    }
  }
  
  public final void aw(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143372);
    for (;;)
    {
      try
      {
        super.aw(paramCharSequence);
        if ((this.pMM) && (this.QCX != null)) {
          paramCharSequence.toString();
        }
        if (this.QCW != null)
        {
          a locala = this.QCW;
          if ((paramCharSequence instanceof Spannable))
          {
            localObject = TextView.BufferType.SPANNABLE;
            locala.at(paramCharSequence);
          }
        }
        else
        {
          AppMethodBeat.o(143372);
          return;
        }
      }
      catch (Exception localException)
      {
        localObject = hiT().toString().replaceAll(QCU, "*");
        Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { localObject, localException });
        if (this.QCX != null)
        {
          this.QCX.a(localException, (String)localObject, "_setText");
          continue;
        }
        AppMethodBeat.o(143372);
        throw localException;
      }
      Object localObject = TextView.BufferType.NORMAL;
    }
  }
  
  public final boolean gYM()
  {
    return VC;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(143368);
    Log.d("MicroMsg.MMNeat7extView", "[isOpen] %s", new Object[] { Boolean.FALSE });
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    if ((bool1) && (bool2)) {}
    for (int i = 1; (i != 0) || (CrashReportFactory.hasDebuger()); i = 0)
    {
      localObject = super.hiT();
      AppMethodBeat.o(143368);
      return localObject;
    }
    AppMethodBeat.o(143368);
    return "";
  }
  
  public float getVerticalOffset()
  {
    AppMethodBeat.i(143367);
    if (QCT)
    {
      f = super.getVerticalOffset();
      getMeasuredHeight();
      AppMethodBeat.o(143367);
      return f;
    }
    float f = super.getVerticalOffset();
    AppMethodBeat.o(143367);
    return f;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143370);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(143370);
      return;
    }
    catch (Exception paramCanvas)
    {
      String str = hiT().toString().replaceAll(QCU, "*");
      Log.e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", new Object[] { str, paramCanvas });
      if (this.QCX != null)
      {
        this.QCX.a(paramCanvas, str, "onDraw");
        AppMethodBeat.o(143370);
        return;
      }
      AppMethodBeat.o(143370);
      throw paramCanvas;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143371);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(143371);
      return;
    }
    catch (Exception localException)
    {
      String str = hiT().toString().replaceAll(QCU, "*");
      Log.e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", new Object[] { str, localException });
      if (this.QCX != null)
      {
        this.QCX.a(localException, str, "onMeasure");
        AppMethodBeat.o(143371);
        return;
      }
      AppMethodBeat.o(143371);
      throw localException;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143369);
    if ((!VC) || ((this.pMM) && (this.mDJ != null)))
    {
      GestureDetector localGestureDetector = this.mDJ;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143369);
    return bool;
  }
  
  public void setIsOpen(boolean paramBoolean)
  {
    VC = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(143374);
    this.QCV = paramOnLongClickListener;
    super.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143365);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (MMNeat7extView.QCT) {
          Toast.makeText(MMNeat7extView.this.getContext(), MMNeat7extView.bom(MMNeat7extView.this.hiT().toString()), 1).show();
        }
        if (MMNeat7extView.d(MMNeat7extView.this) != null)
        {
          boolean bool = MMNeat7extView.d(MMNeat7extView.this).onLongClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(143365);
          return bool;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(143365);
        return false;
      }
    });
    AppMethodBeat.o(143374);
  }
  
  public void setTextCrashListener(b paramb)
  {
    this.QCX = paramb;
  }
  
  public void setTextListener(a parama)
  {
    this.QCW = parama;
  }
  
  public static abstract interface a
  {
    public abstract void at(CharSequence paramCharSequence);
  }
  
  public static abstract interface b
  {
    public abstract void a(Exception paramException, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMNeat7extView
 * JD-Core Version:    0.7.0.1
 */