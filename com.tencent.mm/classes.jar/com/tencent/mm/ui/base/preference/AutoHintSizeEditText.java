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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class AutoHintSizeEditText
  extends EditText
{
  private float OXe;
  private Paint OXf;
  private String OXg;
  private int OXh;
  private float OXi;
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142495);
    this.OXg = "";
    this.OXh = -2147483648;
    init();
    AppMethodBeat.o(142495);
  }
  
  public AutoHintSizeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142494);
    this.OXg = "";
    this.OXh = -2147483648;
    init();
    AppMethodBeat.o(142494);
  }
  
  private void a(Editable paramEditable, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(142497);
    if ((paramEditable != null) && (!Util.isNullOrNil(paramEditable.toString())))
    {
      if (getTextSize() != this.OXe)
      {
        Log.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[] { Float.valueOf(this.OXe) });
        setTextSize(0, this.OXe);
      }
      AppMethodBeat.o(142497);
      return;
    }
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      if (getTextSize() != this.OXe)
      {
        Log.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[] { Float.valueOf(this.OXe) });
        setTextSize(0, this.OXe);
      }
      AppMethodBeat.o(142497);
      return;
    }
    paramEditable = paramCharSequence.toString();
    if ((this.OXg.equals(paramEditable)) && (this.OXh == paramInt))
    {
      if (getTextSize() != this.OXi)
      {
        Log.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[] { Float.valueOf(this.OXi) });
        setTextSize(0, this.OXi);
      }
      AppMethodBeat.o(142497);
      return;
    }
    this.OXg = paramEditable;
    this.OXh = paramInt;
    if (getPaint().measureText(paramEditable) > paramInt)
    {
      int j = getResources().getDimensionPixelSize(2131165594);
      int k = a.fromDPToPix(getContext(), 1);
      int i = (int)this.OXe - k;
      while (i > j)
      {
        this.OXf.setTextSize(i);
        if (this.OXf.measureText(paramEditable) < paramInt)
        {
          Log.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[] { Integer.valueOf(i) });
          this.OXi = i;
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
    this.OXe = getTextSize();
    this.OXi = this.OXe;
    this.OXf = new Paint(getPaint());
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
    Log.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[] { Boolean.valueOf(paramBoolean) });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(getText(), getHint(), paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight());
    }
    AppMethodBeat.o(142498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.AutoHintSizeEditText
 * JD-Core Version:    0.7.0.1
 */