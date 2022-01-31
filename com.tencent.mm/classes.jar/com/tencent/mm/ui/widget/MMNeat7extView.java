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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class MMNeat7extView
  extends NeatTextView
{
  public static boolean ACX;
  private static final String ACY;
  private static boolean LB;
  private View.OnLongClickListener ACZ;
  private a ADa;
  private b ADb;
  private GestureDetector idY;
  
  static
  {
    AppMethodBeat.i(107897);
    ACX = false;
    ACY = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    LB = true;
    AppMethodBeat.o(107897);
  }
  
  public MMNeat7extView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107887);
    this.idY = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(107885);
        if (MMNeat7extView.this.getOnDoubleClickListener() == null)
        {
          AppMethodBeat.o(107885);
          return false;
        }
        boolean bool = MMNeat7extView.this.getOnDoubleClickListener().fp(MMNeat7extView.this);
        AppMethodBeat.o(107885);
        return bool;
      }
    });
    AppMethodBeat.o(107887);
  }
  
  public final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(107894);
    try
    {
      super.a(paramCharSequence, paramBufferType);
      if ((this.kji) && (this.ADb != null)) {
        paramCharSequence.toString();
      }
      if (this.ADa != null) {
        this.ADa.ae(paramCharSequence);
      }
      AppMethodBeat.o(107894);
      return;
    }
    catch (Exception paramBufferType)
    {
      for (;;)
      {
        String str = dTB().toString().replaceAll(ACY, "*");
        ab.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { str, paramBufferType });
        if (this.ADb == null) {
          break;
        }
        this.ADb.a(paramBufferType, str, "_setText");
      }
      AppMethodBeat.o(107894);
      throw paramBufferType;
    }
  }
  
  public final void af(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107893);
    for (;;)
    {
      try
      {
        super.af(paramCharSequence);
        if ((this.kji) && (this.ADb != null)) {
          paramCharSequence.toString();
        }
        if (this.ADa != null)
        {
          a locala = this.ADa;
          if ((paramCharSequence instanceof Spannable))
          {
            localObject = TextView.BufferType.SPANNABLE;
            locala.ae(paramCharSequence);
          }
        }
        else
        {
          AppMethodBeat.o(107893);
          return;
        }
      }
      catch (Exception localException)
      {
        localObject = dTB().toString().replaceAll(ACY, "*");
        ab.e("MicroMsg.MMNeat7extView", "[_setText] replaceContent:%s exception:%s", new Object[] { localObject, localException });
        if (this.ADb != null)
        {
          this.ADb.a(localException, (String)localObject, "_setText");
          continue;
        }
        AppMethodBeat.o(107893);
        throw localException;
      }
      Object localObject = TextView.BufferType.NORMAL;
    }
  }
  
  public final boolean dOE()
  {
    return LB;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    AppMethodBeat.i(107889);
    ab.d("MicroMsg.MMNeat7extView", "[isOpen] %s", new Object[] { Boolean.FALSE });
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    if ((bool1) && (bool2)) {}
    for (int i = 1; (i != 0) || (b.dsf()); i = 0)
    {
      localObject = super.dTB();
      AppMethodBeat.o(107889);
      return localObject;
    }
    AppMethodBeat.o(107889);
    return "";
  }
  
  public float getVerticalOffset()
  {
    AppMethodBeat.i(107888);
    if (ACX)
    {
      f = super.getVerticalOffset();
      getMeasuredHeight();
      AppMethodBeat.o(107888);
      return f;
    }
    float f = super.getVerticalOffset();
    AppMethodBeat.o(107888);
    return f;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107891);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(107891);
      return;
    }
    catch (Exception paramCanvas)
    {
      String str = dTB().toString().replaceAll(ACY, "*");
      ab.e("MicroMsg.MMNeat7extView", "[onDraw] replaceContent:%s exception:%s", new Object[] { str, paramCanvas });
      if (this.ADb != null)
      {
        this.ADb.a(paramCanvas, str, "onDraw");
        AppMethodBeat.o(107891);
        return;
      }
      AppMethodBeat.o(107891);
      throw paramCanvas;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107892);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(107892);
      return;
    }
    catch (Exception localException)
    {
      String str = dTB().toString().replaceAll(ACY, "*");
      ab.e("MicroMsg.MMNeat7extView", "[onMeasure] replaceContent:%s exception:%s", new Object[] { str, localException });
      if (this.ADb != null)
      {
        this.ADb.a(localException, str, "onMeasure");
        AppMethodBeat.o(107892);
        return;
      }
      AppMethodBeat.o(107892);
      throw localException;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107890);
    if ((!LB) || ((this.kji) && (this.idY != null))) {
      this.idY.onTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(107890);
    return bool;
  }
  
  public void setIsOpen(boolean paramBoolean)
  {
    LB = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(107895);
    this.ACZ = paramOnLongClickListener;
    super.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107886);
        if (MMNeat7extView.ACX) {
          Toast.makeText(MMNeat7extView.this.getContext(), MMNeat7extView.avl(MMNeat7extView.this.dTB().toString()), 1).show();
        }
        if (MMNeat7extView.b(MMNeat7extView.this) != null)
        {
          boolean bool = MMNeat7extView.b(MMNeat7extView.this).onLongClick(paramAnonymousView);
          AppMethodBeat.o(107886);
          return bool;
        }
        AppMethodBeat.o(107886);
        return false;
      }
    });
    AppMethodBeat.o(107895);
  }
  
  public void setTextCrashListener(b paramb)
  {
    this.ADb = paramb;
  }
  
  public void setTextListener(a parama)
  {
    this.ADa = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ae(CharSequence paramCharSequence);
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