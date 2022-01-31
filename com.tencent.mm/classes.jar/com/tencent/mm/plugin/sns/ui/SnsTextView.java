package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class SnsTextView
  extends TextView
{
  private String odL = "";
  private char rWN = '\000';
  
  public SnsTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(39397);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(39397);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.SnsTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(39397);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(39396);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(39396);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ab.printErrStackTrace("MicroMsg.SnsTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(39396);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(39394);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(39394);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39395);
    if ((ac.erF.epi == 1) || (ac.erF.epi == -1)) {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        this.rWN = '\000';
        AppMethodBeat.o(39395);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        if (this.rWN < '\003')
        {
          try
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getText());
            MetricAffectingSpan[] arrayOfMetricAffectingSpan = (MetricAffectingSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MetricAffectingSpan.class);
            if ((arrayOfMetricAffectingSpan != null) && (arrayOfMetricAffectingSpan.length > 0)) {
              localSpannableStringBuilder.insert(localSpannableStringBuilder.getSpanStart(arrayOfMetricAffectingSpan[0]) - 1, " ");
            }
            for (this.rWN = ((char)(this.rWN + '\001'));; this.rWN = 'd')
            {
              setText(localSpannableStringBuilder);
              onMeasure(paramInt1, paramInt2);
              AppMethodBeat.o(39395);
              return;
            }
            if (this.rWN != '\003') {
              break label269;
            }
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
          {
            ab.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + bo.isNullOrNil(this.odL));
            setText(this.odL);
            onMeasure(paramInt1, paramInt2);
            this.rWN = ((char)(this.rWN + '\001'));
            AppMethodBeat.o(39395);
            return;
          }
        }
        else
        {
          ab.i("MicroMsg.SnsTextView", "fix error set origintext " + bo.isNullOrNil(this.odL));
          setText(this.odL);
          onMeasure(paramInt1, paramInt2);
          this.rWN = ((char)(this.rWN + '\001'));
          AppMethodBeat.o(39395);
          return;
        }
        label269:
        AppMethodBeat.o(39395);
        throw localIndexOutOfBoundsException2;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(39395);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(39398);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(39398);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(39398);
    }
    return true;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(39393);
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(39393);
    return bool;
  }
  
  public void setOriginText(String paramString)
  {
    this.odL = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTextView
 * JD-Core Version:    0.7.0.1
 */