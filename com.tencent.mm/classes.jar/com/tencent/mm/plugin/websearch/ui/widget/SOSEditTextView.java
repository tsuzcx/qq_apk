package com.tencent.mm.plugin.websearch.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.search.FTSEditTextView;

public class SOSEditTextView
  extends FTSEditTextView
{
  private View DDv;
  private View DDw;
  private View DDx;
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void eMI()
  {
    AppMethodBeat.i(116571);
    getEditText().setOnFocusChangeListener(this.mmc);
    AppMethodBeat.o(116571);
  }
  
  public int getLayoutById()
  {
    return 2131495629;
  }
  
  @SuppressLint({"WrongViewCast"})
  public final void init()
  {
    AppMethodBeat.i(116570);
    super.init();
    this.DDv = findViewById(2131306483);
    this.DDw = findViewById(2131305721);
    this.DDx = findViewById(2131304392);
    getEditText().setOnFocusChangeListener(null);
    getEditText().setHintTextColor(getResources().getColor(2131100538));
    getEditText().setTextColor(getResources().getColor(2131100711));
    AppMethodBeat.o(116570);
  }
  
  public void setCancelTextViewClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116576);
    if (this.DDw != null) {
      this.DDw.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116576);
  }
  
  public void setCancelTextViewVisibile(int paramInt)
  {
    AppMethodBeat.i(116575);
    if (this.DDw != null) {
      this.DDw.setVisibility(paramInt);
    }
    AppMethodBeat.o(116575);
  }
  
  public void setSearchBarCancelTextContainerVisibile(int paramInt)
  {
    AppMethodBeat.i(116572);
    if (this.DDx != null) {
      this.DDx.setVisibility(paramInt);
    }
    AppMethodBeat.o(116572);
  }
  
  public void setVoiceBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(116574);
    if (this.DDv != null) {
      this.DDv.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(116574);
  }
  
  public void setVoiceImageButtonVisibile(int paramInt)
  {
    AppMethodBeat.i(116573);
    if (this.DDv != null) {
      this.DDv.setVisibility(paramInt);
    }
    AppMethodBeat.o(116573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView
 * JD-Core Version:    0.7.0.1
 */