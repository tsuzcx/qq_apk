package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class MMNeat7extView
  extends NeatTextView
{
  public static boolean afTn;
  private static final String afTo;
  private static boolean hU;
  private View.OnLongClickListener afTp;
  private a afTq;
  private MMNeat7extView.b afTr;
  private final View.AccessibilityDelegate afTs;
  private GestureDetector mQj;
  
  static
  {
    AppMethodBeat.i(143376);
    afTn = false;
    afTo = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    hU = true;
    AppMethodBeat.o(143376);
  }
  
  public MMNeat7extView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164209);
    this.afTs = new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(251736);
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        if (paramAnonymousAccessibilityEvent.getEventType() == 8192)
        {
          paramAnonymousAccessibilityEvent.setFromIndex(Selection.getSelectionStart(MMNeat7extView.this.jPy()));
          paramAnonymousAccessibilityEvent.setToIndex(Selection.getSelectionEnd(MMNeat7extView.this.jPy()));
          paramAnonymousAccessibilityEvent.setItemCount(MMNeat7extView.this.jPy().length());
        }
        AppMethodBeat.o(251736);
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(251738);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousAccessibilityNodeInfo.setText(MMNeat7extView.this.jPy());
        paramAnonymousAccessibilityNodeInfo.setContentDescription(null);
        paramAnonymousAccessibilityNodeInfo.setFocusable(true);
        if (!TextUtils.isEmpty(MMNeat7extView.this.jPy()))
        {
          paramAnonymousAccessibilityNodeInfo.addAction(256);
          paramAnonymousAccessibilityNodeInfo.addAction(512);
          paramAnonymousAccessibilityNodeInfo.setMovementGranularities(31);
          paramAnonymousAccessibilityNodeInfo.addAction(131072);
        }
        if (MMNeat7extView.g(MMNeat7extView.this)) {
          paramAnonymousAccessibilityNodeInfo.addAction(16384);
        }
        if (MMNeat7extView.this.getMaxLines() > 0) {
          paramAnonymousAccessibilityNodeInfo.setMultiLine(true);
        }
        AppMethodBeat.o(251738);
      }
    };
    init();
    AppMethodBeat.o(164209);
  }
  
  public MMNeat7extView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143366);
    this.afTs = new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(251736);
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        if (paramAnonymousAccessibilityEvent.getEventType() == 8192)
        {
          paramAnonymousAccessibilityEvent.setFromIndex(Selection.getSelectionStart(MMNeat7extView.this.jPy()));
          paramAnonymousAccessibilityEvent.setToIndex(Selection.getSelectionEnd(MMNeat7extView.this.jPy()));
          paramAnonymousAccessibilityEvent.setItemCount(MMNeat7extView.this.jPy().length());
        }
        AppMethodBeat.o(251736);
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(251738);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousAccessibilityNodeInfo.setText(MMNeat7extView.this.jPy());
        paramAnonymousAccessibilityNodeInfo.setContentDescription(null);
        paramAnonymousAccessibilityNodeInfo.setFocusable(true);
        if (!TextUtils.isEmpty(MMNeat7extView.this.jPy()))
        {
          paramAnonymousAccessibilityNodeInfo.addAction(256);
          paramAnonymousAccessibilityNodeInfo.addAction(512);
          paramAnonymousAccessibilityNodeInfo.setMovementGranularities(31);
          paramAnonymousAccessibilityNodeInfo.addAction(131072);
        }
        if (MMNeat7extView.g(MMNeat7extView.this)) {
          paramAnonymousAccessibilityNodeInfo.addAction(16384);
        }
        if (MMNeat7extView.this.getMaxLines() > 0) {
          paramAnonymousAccessibilityNodeInfo.setMultiLine(true);
        }
        AppMethodBeat.o(251738);
      }
    };
    init();
    AppMethodBeat.o(143366);
  }
  
  private void init()
  {
    AppMethodBeat.i(164210);
    this.mQj = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251742);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251742);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143364);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        if (MMNeat7extView.this.getOnDoubleClickListener() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143364);
          return false;
        }
        boolean bool = MMNeat7extView.this.getOnDoubleClickListener().lA(MMNeat7extView.this);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143364);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251740);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(251740);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251739);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251739);
        return bool;
      }
    });
    setAccessibilityDelegate(this.afTs);
    AppMethodBeat.o(164210);
  }
  
  public final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(143373);
    try
    {
      super.a(paramCharSequence, paramBufferType);
      if ((this.vZb) && (this.afTr != null)) {
        paramCharSequence.toString();
      }
      setContentDescription(paramCharSequence);
    }
    catch (Exception paramBufferType)
    {
      for (;;)
      {
        String str = jPy().toString().replaceAll(afTo, "*");
        Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { str, paramBufferType });
        if (this.afTr == null) {
          break;
        }
        this.afTr.a(paramBufferType, str, "_setText");
      }
      AppMethodBeat.o(143373);
      throw paramBufferType;
    }
    if (this.afTq != null) {
      this.afTq.aW(paramCharSequence);
    }
    AppMethodBeat.o(143373);
  }
  
  public final void aZ(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143372);
    try
    {
      super.aZ(paramCharSequence);
      if ((this.vZb) && (this.afTr != null)) {
        paramCharSequence.toString();
      }
      setContentDescription(paramCharSequence);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a locala;
        localObject = jPy().toString().replaceAll(afTo, "*");
        Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { localObject, localException });
        if (this.afTr == null) {
          break;
        }
        this.afTr.a(localException, (String)localObject, "_setText");
      }
      AppMethodBeat.o(143372);
      throw localException;
    }
    if (this.afTq != null)
    {
      locala = this.afTq;
      if (!(paramCharSequence instanceof Spannable)) {
        break label140;
      }
    }
    label140:
    for (Object localObject = TextView.BufferType.SPANNABLE;; localObject = TextView.BufferType.NORMAL)
    {
      locala.aW(paramCharSequence);
      AppMethodBeat.o(143372);
      return;
    }
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(251737);
    String str = TextView.class.getName();
    AppMethodBeat.o(251737);
    return str;
  }
  
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
      localObject = super.jPy();
      AppMethodBeat.o(143368);
      return localObject;
    }
    AppMethodBeat.o(143368);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(251734);
    int i = Selection.getSelectionEnd(jPy());
    AppMethodBeat.o(251734);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(251731);
    int i = Selection.getSelectionStart(jPy());
    AppMethodBeat.o(251731);
    return i;
  }
  
  public float getVerticalOffset()
  {
    AppMethodBeat.i(143367);
    if (afTn)
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
  
  public final boolean jEM()
  {
    return hU;
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
      String str = jPy().toString().replaceAll(afTo, "*");
      Log.e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", new Object[] { str, paramCanvas });
      if (this.afTr != null)
      {
        this.afTr.a(paramCanvas, str, "onDraw");
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
      String str = jPy().toString().replaceAll(afTo, "*");
      Log.e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", new Object[] { str, localException });
      if (this.afTr != null)
      {
        this.afTr.a(localException, str, "onMeasure");
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
    if ((!hU) || ((this.vZb) && (this.mQj != null)))
    {
      GestureDetector localGestureDetector = this.mQj;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143369);
    return bool;
  }
  
  public void setIsOpen(boolean paramBoolean)
  {
    hU = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(143374);
    this.afTp = paramOnLongClickListener;
    super.setOnLongClickListener(new MMNeat7extView.2(this));
    AppMethodBeat.o(143374);
  }
  
  public void setTextCrashListener(MMNeat7extView.b paramb)
  {
    this.afTr = paramb;
  }
  
  public void setTextListener(a parama)
  {
    this.afTq = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aW(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMNeat7extView
 * JD-Core Version:    0.7.0.1
 */