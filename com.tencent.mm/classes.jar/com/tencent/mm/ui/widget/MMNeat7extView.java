package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
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
  public static boolean Ybv;
  private static final String Ybw;
  private static boolean gZ;
  private final View.AccessibilityDelegate YbA;
  private View.OnLongClickListener Ybx;
  private a Yby;
  private MMNeat7extView.b Ybz;
  private GestureDetector pCU;
  
  static
  {
    AppMethodBeat.i(143376);
    Ybv = false;
    Ybw = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    gZ = true;
    AppMethodBeat.o(143376);
  }
  
  public MMNeat7extView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164209);
    this.YbA = new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(220046);
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        if (paramAnonymousAccessibilityEvent.getEventType() == 8192)
        {
          paramAnonymousAccessibilityEvent.setFromIndex(Selection.getSelectionStart(MMNeat7extView.this.ikC()));
          paramAnonymousAccessibilityEvent.setToIndex(Selection.getSelectionEnd(MMNeat7extView.this.ikC()));
          paramAnonymousAccessibilityEvent.setItemCount(MMNeat7extView.this.ikC().length());
        }
        AppMethodBeat.o(220046);
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(220050);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousAccessibilityNodeInfo.setText(MMNeat7extView.this.ikC());
        paramAnonymousAccessibilityNodeInfo.setContentDescription(null);
        paramAnonymousAccessibilityNodeInfo.setAccessibilityFocused(true);
        paramAnonymousAccessibilityNodeInfo.setClickable(true);
        if (!TextUtils.isEmpty(MMNeat7extView.this.ikC()))
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
        AppMethodBeat.o(220050);
      }
    };
    init();
    AppMethodBeat.o(164209);
  }
  
  public MMNeat7extView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143366);
    this.YbA = new View.AccessibilityDelegate()
    {
      public final void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
      {
        AppMethodBeat.i(220046);
        super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
        if (paramAnonymousAccessibilityEvent.getEventType() == 8192)
        {
          paramAnonymousAccessibilityEvent.setFromIndex(Selection.getSelectionStart(MMNeat7extView.this.ikC()));
          paramAnonymousAccessibilityEvent.setToIndex(Selection.getSelectionEnd(MMNeat7extView.this.ikC()));
          paramAnonymousAccessibilityEvent.setItemCount(MMNeat7extView.this.ikC().length());
        }
        AppMethodBeat.o(220046);
      }
      
      public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
      {
        AppMethodBeat.i(220050);
        super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
        paramAnonymousAccessibilityNodeInfo.setText(MMNeat7extView.this.ikC());
        paramAnonymousAccessibilityNodeInfo.setContentDescription(null);
        paramAnonymousAccessibilityNodeInfo.setAccessibilityFocused(true);
        paramAnonymousAccessibilityNodeInfo.setClickable(true);
        if (!TextUtils.isEmpty(MMNeat7extView.this.ikC()))
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
        AppMethodBeat.o(220050);
      }
    };
    init();
    AppMethodBeat.o(143366);
  }
  
  private void init()
  {
    AppMethodBeat.i(164210);
    this.pCU = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206281);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(206281);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143364);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        if (MMNeat7extView.this.getOnDoubleClickListener() == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143364);
          return false;
        }
        boolean bool = MMNeat7extView.this.getOnDoubleClickListener().ie(MMNeat7extView.this);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143364);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206280);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(206280);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206277);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMNeat7extView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(206277);
        return bool;
      }
    });
    setAccessibilityDelegate(this.YbA);
    AppMethodBeat.o(164210);
  }
  
  public final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(143373);
    try
    {
      super.a(paramCharSequence, paramBufferType);
      if ((this.sTK) && (this.Ybz != null)) {
        paramCharSequence.toString();
      }
      if (this.Yby != null) {
        this.Yby.aI(paramCharSequence);
      }
      AppMethodBeat.o(143373);
      return;
    }
    catch (Exception paramBufferType)
    {
      for (;;)
      {
        String str = ikC().toString().replaceAll(Ybw, "*");
        Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { str, paramBufferType });
        if (this.Ybz == null) {
          break;
        }
        this.Ybz.a(paramBufferType, str, "_setText");
      }
      AppMethodBeat.o(143373);
      throw paramBufferType;
    }
  }
  
  public final void aL(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143372);
    for (;;)
    {
      try
      {
        super.aL(paramCharSequence);
        if ((this.sTK) && (this.Ybz != null)) {
          paramCharSequence.toString();
        }
        if (this.Yby != null)
        {
          a locala = this.Yby;
          if ((paramCharSequence instanceof Spannable))
          {
            localObject = TextView.BufferType.SPANNABLE;
            locala.aI(paramCharSequence);
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
        localObject = ikC().toString().replaceAll(Ybw, "*");
        Log.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { localObject, localException });
        if (this.Ybz != null)
        {
          this.Ybz.a(localException, (String)localObject, "_setText");
          continue;
        }
        AppMethodBeat.o(143372);
        throw localException;
      }
      Object localObject = TextView.BufferType.NORMAL;
    }
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(200383);
    String str = TextView.class.getName();
    AppMethodBeat.o(200383);
    return str;
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
      localObject = super.ikC();
      AppMethodBeat.o(143368);
      return localObject;
    }
    AppMethodBeat.o(143368);
    return "";
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(200380);
    int i = Selection.getSelectionEnd(ikC());
    AppMethodBeat.o(200380);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(200379);
    int i = Selection.getSelectionStart(ikC());
    AppMethodBeat.o(200379);
    return i;
  }
  
  public float getVerticalOffset()
  {
    AppMethodBeat.i(143367);
    if (Ybv)
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
  
  public final boolean hZE()
  {
    return gZ;
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
      String str = ikC().toString().replaceAll(Ybw, "*");
      Log.e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", new Object[] { str, paramCanvas });
      if (this.Ybz != null)
      {
        this.Ybz.a(paramCanvas, str, "onDraw");
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
      String str = ikC().toString().replaceAll(Ybw, "*");
      Log.e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", new Object[] { str, localException });
      if (this.Ybz != null)
      {
        this.Ybz.a(localException, str, "onMeasure");
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
    if ((!gZ) || ((this.sTK) && (this.pCU != null)))
    {
      GestureDetector localGestureDetector = this.pCU;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/widget/MMNeat7extView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143369);
    return bool;
  }
  
  public void setIsOpen(boolean paramBoolean)
  {
    gZ = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(143374);
    this.Ybx = paramOnLongClickListener;
    super.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143365);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/MMNeat7extView$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (MMNeat7extView.Ybv) {
          Toast.makeText(MMNeat7extView.this.getContext(), MMNeat7extView.bBb(MMNeat7extView.this.ikC().toString()), 1).show();
        }
        if (MMNeat7extView.f(MMNeat7extView.this) != null)
        {
          boolean bool = MMNeat7extView.f(MMNeat7extView.this).onLongClick(paramAnonymousView);
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
  
  public void setTextCrashListener(MMNeat7extView.b paramb)
  {
    this.Ybz = paramb;
  }
  
  public void setTextListener(a parama)
  {
    this.Yby = parama;
  }
  
  public static abstract interface a
  {
    public abstract void aI(CharSequence paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMNeat7extView
 * JD-Core Version:    0.7.0.1
 */