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
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public class MMNeatTextView
  extends NeatTextView
{
  private static boolean LQ = true;
  public static boolean wjq = false;
  private static final String wjr = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
  private GestureDetector gEU = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
  {
    public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
    {
      if (MMNeatTextView.this.getOnDoubleClickListener() == null) {
        return false;
      }
      return MMNeatTextView.this.getOnDoubleClickListener().eb(MMNeatTextView.this);
    }
  });
  private View.OnLongClickListener wjs;
  private a wjt;
  private b wju;
  
  public MMNeatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void R(CharSequence paramCharSequence)
  {
    for (;;)
    {
      try
      {
        super.R(paramCharSequence);
        if ((this.wEG) && (this.wju != null)) {
          paramCharSequence.toString();
        }
        if (this.wjt != null)
        {
          a locala = this.wjt;
          if ((paramCharSequence instanceof Spannable))
          {
            localObject = TextView.BufferType.SPANNABLE;
            locala.Q(paramCharSequence);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        localObject = this.mText.toString().replaceAll(wjr, "*");
        y.e("MicroMsg.MMNeatTextView", "[_setText] replaceContent:%s exception:%s", new Object[] { localObject, localException });
        if (this.wju != null)
        {
          this.wju.a(localException, (String)localObject, "_setText");
          continue;
        }
        throw localException;
      }
      Object localObject = TextView.BufferType.NORMAL;
    }
  }
  
  public final boolean cJN()
  {
    return LQ;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    y.d("MicroMsg.MMNeatTextView", "[isOpen] %s", new Object[] { Boolean.valueOf(false) });
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)getContext().getSystemService("accessibility");
    boolean bool1 = localAccessibilityManager.isEnabled();
    boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
    if ((bool1) && (bool2)) {}
    for (int i = 1; (i != 0) || (b.cqk()); i = 0) {
      return this.mText;
    }
    return "";
  }
  
  public float getVerticalOffset()
  {
    if (wjq)
    {
      float f1 = super.getVerticalOffset();
      float f2 = getMeasuredHeight();
      y.i("MicroMsg.MMNeatTextView_changelcai", "text:%s [getVerticalOffset] offset:%s height:%s ,layout height:%s", new Object[] { this.mText, Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(getLayout().cNM()[1]) });
      return f1;
    }
    return super.getVerticalOffset();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      String str = this.mText.toString().replaceAll(wjr, "*");
      y.e("MicroMsg.MMNeatTextView", "[onDraw] replaceContent:%s exception:%s", new Object[] { str, paramCanvas });
      if (this.wju != null)
      {
        this.wju.a(paramCanvas, str, "onDraw");
        return;
      }
      throw paramCanvas;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      String str = this.mText.toString().replaceAll(wjr, "*");
      y.e("MicroMsg.MMNeatTextView", "[onMeasure] replaceContent:%s exception:%s", new Object[] { str, localException });
      if (this.wju != null)
      {
        this.wju.a(localException, str, "onMeasure");
        return;
      }
      throw localException;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!LQ) || ((this.wEG) && (this.gEU != null))) {
      this.gEU.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsOpen(boolean paramBoolean)
  {
    LQ = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.wjs = paramOnLongClickListener;
    super.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        if (MMNeatTextView.wjq) {
          Toast.makeText(MMNeatTextView.this.getContext(), MMNeatTextView.aey(MMNeatTextView.this.mText.toString()), 1).show();
        }
        if (MMNeatTextView.a(MMNeatTextView.this) != null) {
          return MMNeatTextView.a(MMNeatTextView.this).onLongClick(paramAnonymousView);
        }
        return false;
      }
    });
  }
  
  public void setTextCrashListener(b paramb)
  {
    this.wju = paramb;
  }
  
  public void setTextListener(a parama)
  {
    this.wjt = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Q(CharSequence paramCharSequence);
  }
  
  public static abstract interface b
  {
    public abstract void a(Exception paramException, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMNeatTextView
 * JD-Core Version:    0.7.0.1
 */