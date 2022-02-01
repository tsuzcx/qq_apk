package com.tencent.mm.plugin.websearch.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.ui.search.FTSEditTextView;

public class SOSEditTextView
  extends FTSEditTextView
{
  private View PBo;
  private View PBp;
  private View PBq;
  private int PBr = 100;
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void gRA()
  {
    AppMethodBeat.i(116571);
    getEditText().setOnFocusChangeListener(this.jQt);
    AppMethodBeat.o(116571);
  }
  
  public int getLayoutById()
  {
    return a.e.sos_edittext_view;
  }
  
  public int getLimitInputLength()
  {
    AppMethodBeat.i(256006);
    int i = ((c)h.ag(c.class)).getSosLimitLength();
    i = Math.max(this.PBr, i);
    AppMethodBeat.o(256006);
    return i;
  }
  
  @SuppressLint({"WrongViewCast"})
  public final void init()
  {
    AppMethodBeat.i(116570);
    super.init();
    this.PBo = findViewById(a.d.voice_btn_container);
    this.PBp = findViewById(a.d.text_cancel);
    this.PBq = findViewById(a.d.search_bar_cancel_text_container);
    getEditText().setOnFocusChangeListener(null);
    getEditText().setHintTextColor(getResources().getColor(a.a.light_bg_hint_color));
    getEditText().setTextColor(getResources().getColor(a.a.normal_text_color));
    AppMethodBeat.o(116570);
  }
  
  public void setCancelTextViewClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116576);
    if (this.PBp != null) {
      this.PBp.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116576);
  }
  
  public void setCancelTextViewVisibile(int paramInt)
  {
    AppMethodBeat.i(116575);
    if (this.PBp != null) {
      this.PBp.setVisibility(paramInt);
    }
    AppMethodBeat.o(116575);
  }
  
  public void setSearchBarCancelTextContainerVisibile(int paramInt)
  {
    AppMethodBeat.i(116572);
    if (this.PBq != null) {
      this.PBq.setVisibility(paramInt);
    }
    AppMethodBeat.o(116572);
  }
  
  public void setVoiceBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116574);
    if (this.PBo != null) {
      this.PBo.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116574);
  }
  
  public void setVoiceImageButtonVisibile(int paramInt)
  {
    AppMethodBeat.i(116573);
    if (this.PBo != null) {
      this.PBo.setVisibility(paramInt);
    }
    AppMethodBeat.o(116573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView
 * JD-Core Version:    0.7.0.1
 */