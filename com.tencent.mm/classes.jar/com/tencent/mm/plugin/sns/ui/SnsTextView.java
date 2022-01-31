package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class SnsTextView
  extends TextView
{
  private String lGy = "";
  private char pea = '\000';
  
  public SnsTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getBaseline()
  {
    try
    {
      int i = super.getBaseline();
      return i;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.SnsTextView", localThrowable, "", new Object[0]);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
      y.printErrStackTrace("MicroMsg.SnsTextView", paramCanvas, "", new Object[0]);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((q.dyn.dxk == 1) || (q.dyn.dxk == -1)) {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        this.pea = '\000';
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        if (this.pea < '\003') {
          for (;;)
          {
            try
            {
              SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getText());
              MetricAffectingSpan[] arrayOfMetricAffectingSpan = (MetricAffectingSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MetricAffectingSpan.class);
              if ((arrayOfMetricAffectingSpan != null) && (arrayOfMetricAffectingSpan.length > 0))
              {
                localSpannableStringBuilder.insert(localSpannableStringBuilder.getSpanStart(arrayOfMetricAffectingSpan[0]) - 1, " ");
                this.pea = ((char)(this.pea + '\001'));
                setText(localSpannableStringBuilder);
                onMeasure(paramInt1, paramInt2);
                return;
              }
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
            {
              y.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + bk.bl(this.lGy));
              setText(this.lGy);
              onMeasure(paramInt1, paramInt2);
              this.pea = ((char)(this.pea + '\001'));
              return;
            }
            this.pea = 'd';
          }
        }
        if (this.pea == '\003')
        {
          y.i("MicroMsg.SnsTextView", "fix error set origintext " + bk.bl(this.lGy));
          setText(this.lGy);
          onMeasure(paramInt1, paramInt2);
          this.pea = ((char)(this.pea + '\001'));
          return;
        }
        throw localIndexOutOfBoundsException2;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onPreDraw()
  {
    try
    {
      boolean bool = super.onPreDraw();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    return super.onTextContextMenuItem(paramInt);
  }
  
  public void setOriginText(String paramString)
  {
    this.lGy = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTextView
 * JD-Core Version:    0.7.0.1
 */