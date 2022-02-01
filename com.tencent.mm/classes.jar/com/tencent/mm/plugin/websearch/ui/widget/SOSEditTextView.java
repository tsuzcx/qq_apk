package com.tencent.mm.plugin.websearch.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.ui.search.FTSEditTextView;

public class SOSEditTextView
  extends FTSEditTextView
{
  private View IHa;
  private View IHb;
  private View IHc;
  private int IHd = 100;
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void fYP()
  {
    AppMethodBeat.i(116571);
    getEditText().setOnFocusChangeListener(this.heD);
    AppMethodBeat.o(116571);
  }
  
  public int getLayoutById()
  {
    return 2131496531;
  }
  
  public int getLimitInputLength()
  {
    AppMethodBeat.i(201778);
    int i = ((c)g.ah(c.class)).getSosLimitLength();
    i = Math.max(this.IHd, i);
    AppMethodBeat.o(201778);
    return i;
  }
  
  @SuppressLint({"WrongViewCast"})
  public final void init()
  {
    AppMethodBeat.i(116570);
    super.init();
    this.IHa = findViewById(2131309942);
    this.IHb = findViewById(2131308988);
    this.IHc = findViewById(2131307357);
    getEditText().setOnFocusChangeListener(null);
    getEditText().setHintTextColor(getResources().getColor(2131100676));
    getEditText().setTextColor(getResources().getColor(2131100904));
    AppMethodBeat.o(116570);
  }
  
  public void setCancelTextViewClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116576);
    if (this.IHb != null) {
      this.IHb.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116576);
  }
  
  public void setCancelTextViewVisibile(int paramInt)
  {
    AppMethodBeat.i(116575);
    if (this.IHb != null) {
      this.IHb.setVisibility(paramInt);
    }
    AppMethodBeat.o(116575);
  }
  
  public void setSearchBarCancelTextContainerVisibile(int paramInt)
  {
    AppMethodBeat.i(116572);
    if (this.IHc != null) {
      this.IHc.setVisibility(paramInt);
    }
    AppMethodBeat.o(116572);
  }
  
  public void setVoiceBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116574);
    if (this.IHa != null) {
      this.IHa.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116574);
  }
  
  public void setVoiceImageButtonVisibile(int paramInt)
  {
    AppMethodBeat.i(116573);
    if (this.IHa != null) {
      this.IHa.setVisibility(paramInt);
    }
    AppMethodBeat.o(116573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView
 * JD-Core Version:    0.7.0.1
 */