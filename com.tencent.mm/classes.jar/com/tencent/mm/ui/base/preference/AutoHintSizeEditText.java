package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class AutoHintSizeEditText
  extends EditText
{
  private float JMh;
  private Paint JMi;
  private String JMj;
  private int JMk;
  private float JMl;
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142495);
    this.JMj = "";
    this.JMk = -2147483648;
    init();
    AppMethodBeat.o(142495);
  }
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142494);
    this.JMj = "";
    this.JMk = -2147483648;
    init();
    AppMethodBeat.o(142494);
  }
  
  private void a(Editable paramEditable, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(142497);
    if ((paramEditable != null) && (!bu.isNullOrNil(paramEditable.toString())))
    {
      if (getTextSize() != this.JMh)
      {
        ae.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[] { Float.valueOf(this.JMh) });
        setTextSize(0, this.JMh);
      }
      AppMethodBeat.o(142497);
      return;
    }
    if ((paramCharSequence == null) || (bu.isNullOrNil(paramCharSequence.toString())))
    {
      if (getTextSize() != this.JMh)
      {
        ae.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[] { Float.valueOf(this.JMh) });
        setTextSize(0, this.JMh);
      }
      AppMethodBeat.o(142497);
      return;
    }
    paramEditable = paramCharSequence.toString();
    if ((this.JMj.equals(paramEditable)) && (this.JMk == paramInt))
    {
      if (getTextSize() != this.JMl)
      {
        ae.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[] { Float.valueOf(this.JMl) });
        setTextSize(0, this.JMl);
      }
      AppMethodBeat.o(142497);
      return;
    }
    this.JMj = paramEditable;
    this.JMk = paramInt;
    if (getPaint().measureText(paramEditable) > paramInt)
    {
      int j = getResources().getDimensionPixelSize(2131165576);
      int k = a.fromDPToPix(getContext(), 1);
      int i = (int)this.JMh - k;
      while (i > j)
      {
        this.JMi.setTextSize(i);
        if (this.JMi.measureText(paramEditable) < paramInt)
        {
          ae.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[] { Integer.valueOf(i) });
          this.JMl = i;
          setTextSize(0, i);
          AppMethodBeat.o(142497);
          return;
        }
        i -= k;
      }
    }
    AppMethodBeat.o(142497);
  }
  
  private void init()
  {
    AppMethodBeat.i(142496);
    this.JMh = getTextSize();
    this.JMl = this.JMh;
    this.JMi = new Paint(getPaint());
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(142493);
        AutoHintSizeEditText.a(AutoHintSizeEditText.this, paramAnonymousEditable, AutoHintSizeEditText.this.getHint(), AutoHintSizeEditText.this.getWidth() - AutoHintSizeEditText.this.getPaddingLeft() - AutoHintSizeEditText.this.getPaddingRight());
        AppMethodBeat.o(142493);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    AppMethodBeat.o(142496);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142498);
    ae.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[] { Boolean.valueOf(paramBoolean) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(getText(), getHint(), paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight());
    }
    AppMethodBeat.o(142498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.AutoHintSizeEditText
 * JD-Core Version:    0.7.0.1
 */