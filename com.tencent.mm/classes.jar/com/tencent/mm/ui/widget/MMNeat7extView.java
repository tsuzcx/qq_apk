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
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class MMNeat7extView
  extends NeatTextView
{
  public static boolean HzC;
  private static final String HzD;
  private static boolean SE;
  private View.OnLongClickListener HzE;
  private a HzF;
  private b HzG;
  private GestureDetector ktZ;
  
  static
  {
    AppMethodBeat.i(143376);
    HzC = false;
    HzD = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    SE = true;
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
    this.ktZ = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143364);
        if (MMNeat7extView.this.getOnDoubleClickListener() == null)
        {
          AppMethodBeat.o(143364);
          return false;
        }
        boolean bool = MMNeat7extView.this.getOnDoubleClickListener().fT(MMNeat7extView.this);
        AppMethodBeat.o(143364);
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
      if ((this.nmV) && (this.HzG != null)) {
        paramCharSequence.toString();
      }
      if (this.HzF != null) {
        this.HzF.an(paramCharSequence);
      }
      AppMethodBeat.o(143373);
      return;
    }
    catch (Exception paramBufferType)
    {
      for (;;)
      {
        String str = fli().toString().replaceAll(HzD, "*");
        ad.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { str, paramBufferType });
        if (this.HzG == null) {
          break;
        }
        this.HzG.a(paramBufferType, str, "_setText");
      }
      AppMethodBeat.o(143373);
      throw paramBufferType;
    }
  }
  
  public final void aq(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143372);
    for (;;)
    {
      try
      {
        super.aq(paramCharSequence);
        if ((this.nmV) && (this.HzG != null)) {
          paramCharSequence.toString();
        }
        if (this.HzF != null)
        {
          a locala = this.HzF;
          if ((paramCharSequence instanceof Spannable))
          {
            localObject = TextView.BufferType.SPANNABLE;
            locala.an(paramCharSequence);
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
        localObject = fli().toString().replaceAll(HzD, "*");
        ad.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { localObject, localException });
        if (this.HzG != null)
        {
          this.HzG.a(localException, (String)localObject, "_setText");
          continue;
        }
        AppMethodBeat.o(143372);
        throw localException;
      }
      Object localObject = TextView.BufferType.NORMAL;
    }
  }
  
  public final boolean feI()
  {
    return SE;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(143368);
    ad.d("MicroMsg.MMNeat7extView", "[isOpen] %s", new Object[] { Boolean.FALSE });
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    if ((bool1) && (bool2)) {}
    for (int i = 1; (i != 0) || (b.eEQ()); i = 0)
    {
      localObject = super.fli();
      AppMethodBeat.o(143368);
      return localObject;
    }
    AppMethodBeat.o(143368);
    return "";
  }
  
  public float getVerticalOffset()
  {
    AppMethodBeat.i(143367);
    if (HzC)
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
      String str = fli().toString().replaceAll(HzD, "*");
      ad.e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", new Object[] { str, paramCanvas });
      if (this.HzG != null)
      {
        this.HzG.a(paramCanvas, str, "onDraw");
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
      String str = fli().toString().replaceAll(HzD, "*");
      ad.e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", new Object[] { str, localException });
      if (this.HzG != null)
      {
        this.HzG.a(localException, str, "onMeasure");
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
    if ((!SE) || ((this.nmV) && (this.ktZ != null))) {
      this.ktZ.onTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143369);
    return bool;
  }
  
  public void setIsOpen(boolean paramBoolean)
  {
    SE = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(143374);
    this.HzE = paramOnLongClickListener;
    super.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143365);
        if (MMNeat7extView.HzC) {
          Toast.makeText(MMNeat7extView.this.getContext(), MMNeat7extView.aMe(MMNeat7extView.this.fli().toString()), 1).show();
        }
        if (MMNeat7extView.b(MMNeat7extView.this) != null)
        {
          boolean bool = MMNeat7extView.b(MMNeat7extView.this).onLongClick(paramAnonymousView);
          AppMethodBeat.o(143365);
          return bool;
        }
        AppMethodBeat.o(143365);
        return false;
      }
    });
    AppMethodBeat.o(143374);
  }
  
  public void setTextCrashListener(b paramb)
  {
    this.HzG = paramb;
  }
  
  public void setTextListener(a parama)
  {
    this.HzF = parama;
  }
  
  public static abstract interface a
  {
    public abstract void an(CharSequence paramCharSequence);
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