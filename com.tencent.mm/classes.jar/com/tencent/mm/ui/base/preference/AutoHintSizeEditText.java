package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class AutoHintSizeEditText
  extends EditText
{
  private float vbP;
  private Paint vbQ;
  private String vbR = "";
  private int vbS = -2147483648;
  private float vbT;
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void a(Editable paramEditable, CharSequence paramCharSequence, int paramInt)
  {
    if ((paramEditable != null) && (!bk.bl(paramEditable.toString()))) {
      if (getTextSize() != this.vbP)
      {
        y.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[] { Float.valueOf(this.vbP) });
        setTextSize(0, this.vbP);
      }
    }
    for (;;)
    {
      return;
      if ((paramCharSequence == null) || (bk.bl(paramCharSequence.toString())))
      {
        if (getTextSize() != this.vbP)
        {
          y.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[] { Float.valueOf(this.vbP) });
          setTextSize(0, this.vbP);
        }
      }
      else
      {
        paramEditable = paramCharSequence.toString();
        if ((this.vbR.equals(paramEditable)) && (this.vbS == paramInt))
        {
          if (getTextSize() != this.vbT)
          {
            y.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[] { Float.valueOf(this.vbT) });
            setTextSize(0, this.vbT);
          }
        }
        else
        {
          this.vbR = paramEditable;
          this.vbS = paramInt;
          if (getPaint().measureText(paramEditable) > paramInt)
          {
            int j = getResources().getDimensionPixelSize(a.e.SmallestTextSize);
            int k = a.fromDPToPix(getContext(), 1);
            int i = (int)this.vbP - k;
            while (i > j)
            {
              this.vbQ.setTextSize(i);
              if (this.vbQ.measureText(paramEditable) < paramInt)
              {
                y.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[] { Integer.valueOf(i) });
                this.vbT = i;
                setTextSize(0, i);
                return;
              }
              i -= k;
            }
          }
        }
      }
    }
  }
  
  private void init()
  {
    this.vbP = getTextSize();
    this.vbT = this.vbP;
    this.vbQ = new Paint(getPaint());
    addTextChangedListener(new AutoHintSizeEditText.1(this));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[] { Boolean.valueOf(paramBoolean) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(getText(), getHint(), paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.AutoHintSizeEditText
 * JD-Core Version:    0.7.0.1
 */