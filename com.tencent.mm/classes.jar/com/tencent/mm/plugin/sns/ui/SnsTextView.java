package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class SnsTextView
  extends TextView
{
  private char AjC = '\000';
  private String vdt = "";
  
  public SnsTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(99220);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(99220);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.SnsTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(99220);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99219);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(99219);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ad.printErrStackTrace("MicroMsg.SnsTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(99219);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99217);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(99217);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(99218);
    if ((ae.gcP.fZt == 1) || (ae.gcP.fZt == -1)) {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        this.AjC = '\000';
        AppMethodBeat.o(99218);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        if (this.AjC < '\003')
        {
          try
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getText());
            MetricAffectingSpan[] arrayOfMetricAffectingSpan = (MetricAffectingSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MetricAffectingSpan.class);
            if ((arrayOfMetricAffectingSpan != null) && (arrayOfMetricAffectingSpan.length > 0)) {
              localSpannableStringBuilder.insert(localSpannableStringBuilder.getSpanStart(arrayOfMetricAffectingSpan[0]) - 1, " ");
            }
            for (this.AjC = ((char)(this.AjC + '\001'));; this.AjC = 'd')
            {
              setText(localSpannableStringBuilder);
              onMeasure(paramInt1, paramInt2);
              AppMethodBeat.o(99218);
              return;
            }
            if (this.AjC != '\003') {
              break label269;
            }
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
          {
            ad.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + bt.isNullOrNil(this.vdt));
            setText(this.vdt);
            onMeasure(paramInt1, paramInt2);
            this.AjC = ((char)(this.AjC + '\001'));
            AppMethodBeat.o(99218);
            return;
          }
        }
        else
        {
          ad.i("MicroMsg.SnsTextView", "fix error set origintext " + bt.isNullOrNil(this.vdt));
          setText(this.vdt);
          onMeasure(paramInt1, paramInt2);
          this.AjC = ((char)(this.AjC + '\001'));
          AppMethodBeat.o(99218);
          return;
        }
        label269:
        AppMethodBeat.o(99218);
        throw localIndexOutOfBoundsException2;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(99218);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(99221);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(99221);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(99221);
    }
    return true;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(99216);
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(99216);
    return bool;
  }
  
  public void setOriginText(String paramString)
  {
    this.vdt = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTextView
 * JD-Core Version:    0.7.0.1
 */