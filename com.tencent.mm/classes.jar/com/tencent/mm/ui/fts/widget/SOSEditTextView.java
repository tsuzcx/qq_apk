package com.tencent.mm.ui.fts.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;

public class SOSEditTextView
  extends FTSEditTextView
{
  private View Aou;
  private View Aov;
  private View Aow;
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void bDd()
  {
    AppMethodBeat.i(91594);
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2130970902, this, true);
    AppMethodBeat.o(91594);
  }
  
  public final void dNi()
  {
    AppMethodBeat.i(91596);
    getEditText().setOnFocusChangeListener(this.naX);
    AppMethodBeat.o(91596);
  }
  
  @SuppressLint({"WrongViewCast"})
  public final void init()
  {
    AppMethodBeat.i(91595);
    super.init();
    this.Aou = findViewById(2131828189);
    this.Aov = findViewById(2131828191);
    this.Aow = findViewById(2131828190);
    getEditText().setOnFocusChangeListener(null);
    getEditText().setHintTextColor(getResources().getColor(2131690205));
    getEditText().setTextColor(getResources().getColor(2131690322));
    AppMethodBeat.o(91595);
  }
  
  public void setCancelTextViewClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(91602);
    if (this.Aov != null) {
      this.Aov.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(91602);
  }
  
  public void setCancelTextViewVisibile(int paramInt)
  {
    AppMethodBeat.i(91601);
    if (this.Aov != null) {
      this.Aov.setVisibility(paramInt);
    }
    AppMethodBeat.o(91601);
  }
  
  public void setIconRes(Drawable paramDrawable)
  {
    AppMethodBeat.i(91597);
    getIconView().setImageDrawable(paramDrawable);
    AppMethodBeat.o(91597);
  }
  
  public void setSearchBarCancelTextContainerVisibile(int paramInt)
  {
    AppMethodBeat.i(91598);
    if (this.Aow != null) {
      this.Aow.setVisibility(paramInt);
    }
    AppMethodBeat.o(91598);
  }
  
  public void setVoiceBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(91600);
    if (this.Aou != null) {
      this.Aou.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(91600);
  }
  
  public void setVoiceImageButtonVisibile(int paramInt)
  {
    AppMethodBeat.i(91599);
    if (this.Aou != null) {
      this.Aou.setVisibility(paramInt);
    }
    AppMethodBeat.o(91599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.fts.widget.SOSEditTextView
 * JD-Core Version:    0.7.0.1
 */