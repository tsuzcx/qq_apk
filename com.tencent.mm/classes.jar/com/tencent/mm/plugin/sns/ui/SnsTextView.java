package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SnsTextView
  extends TextView
{
  private String KfV = "";
  private char Ryn = '\000';
  
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
    finally
    {
      Log.printErrStackTrace("MicroMsg.SnsTextView", localThrowable, "", new Object[0]);
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
    finally
    {
      Log.printErrStackTrace("MicroMsg.SnsTextView", paramCanvas, "", new Object[0]);
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
    if ((af.lYj.lUs == 1) || (af.lYj.lUs == -1)) {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        this.Ryn = '\000';
        AppMethodBeat.o(99218);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
      {
        if (this.Ryn < '\003')
        {
          try
          {
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getText());
            MetricAffectingSpan[] arrayOfMetricAffectingSpan = (MetricAffectingSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), MetricAffectingSpan.class);
            if ((arrayOfMetricAffectingSpan != null) && (arrayOfMetricAffectingSpan.length > 0)) {
              localSpannableStringBuilder.insert(localSpannableStringBuilder.getSpanStart(arrayOfMetricAffectingSpan[0]) - 1, " ");
            }
            for (this.Ryn = ((char)(this.Ryn + '\001'));; this.Ryn = 'd')
            {
              setText(localSpannableStringBuilder);
              onMeasure(paramInt1, paramInt2);
              AppMethodBeat.o(99218);
              return;
            }
            if (this.Ryn != '\003') {
              break label269;
            }
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException2)
          {
            Log.i("MicroMsg.SnsTextView", "tryToFix error set origintext " + Util.isNullOrNil(this.KfV));
            setText(this.KfV);
            onMeasure(paramInt1, paramInt2);
            this.Ryn = ((char)(this.Ryn + '\001'));
            AppMethodBeat.o(99218);
            return;
          }
        }
        else
        {
          Log.i("MicroMsg.SnsTextView", "fix error set origintext " + Util.isNullOrNil(this.KfV));
          setText(this.KfV);
          onMeasure(paramInt1, paramInt2);
          this.Ryn = ((char)(this.Ryn + '\001'));
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
      return bool;
    }
    finally
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
    this.KfV = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTextView
 * JD-Core Version:    0.7.0.1
 */