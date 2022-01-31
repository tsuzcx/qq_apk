package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class AutoHintSizeEditText
  extends EditText
{
  private float zql;
  private Paint zqm;
  private String zqn;
  private int zqo;
  private float zqp;
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107125);
    this.zqn = "";
    this.zqo = -2147483648;
    init();
    AppMethodBeat.o(107125);
  }
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107124);
    this.zqn = "";
    this.zqo = -2147483648;
    init();
    AppMethodBeat.o(107124);
  }
  
  private void a(Editable paramEditable, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(107127);
    if ((paramEditable != null) && (!bo.isNullOrNil(paramEditable.toString())))
    {
      if (getTextSize() != this.zql)
      {
        ab.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[] { Float.valueOf(this.zql) });
        setTextSize(0, this.zql);
      }
      AppMethodBeat.o(107127);
      return;
    }
    if ((paramCharSequence == null) || (bo.isNullOrNil(paramCharSequence.toString())))
    {
      if (getTextSize() != this.zql)
      {
        ab.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[] { Float.valueOf(this.zql) });
        setTextSize(0, this.zql);
      }
      AppMethodBeat.o(107127);
      return;
    }
    paramEditable = paramCharSequence.toString();
    if ((this.zqn.equals(paramEditable)) && (this.zqo == paramInt))
    {
      if (getTextSize() != this.zqp)
      {
        ab.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[] { Float.valueOf(this.zqp) });
        setTextSize(0, this.zqp);
      }
      AppMethodBeat.o(107127);
      return;
    }
    this.zqn = paramEditable;
    this.zqo = paramInt;
    if (getPaint().measureText(paramEditable) > paramInt)
    {
      int j = getResources().getDimensionPixelSize(2131427862);
      int k = a.fromDPToPix(getContext(), 1);
      int i = (int)this.zql - k;
      while (i > j)
      {
        this.zqm.setTextSize(i);
        if (this.zqm.measureText(paramEditable) < paramInt)
        {
          ab.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[] { Integer.valueOf(i) });
          this.zqp = i;
          setTextSize(0, i);
          AppMethodBeat.o(107127);
          return;
        }
        i -= k;
      }
    }
    AppMethodBeat.o(107127);
  }
  
  private void init()
  {
    AppMethodBeat.i(107126);
    this.zql = getTextSize();
    this.zqp = this.zql;
    this.zqm = new Paint(getPaint());
    addTextChangedListener(new AutoHintSizeEditText.1(this));
    AppMethodBeat.o(107126);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107128);
    ab.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[] { Boolean.valueOf(paramBoolean) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(getText(), getHint(), paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight());
    }
    AppMethodBeat.o(107128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.AutoHintSizeEditText
 * JD-Core Version:    0.7.0.1
 */