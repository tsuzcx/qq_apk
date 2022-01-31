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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;

public class SOSEditTextView
  extends FTSEditTextView
{
  private View vWm;
  private View vWn;
  private View vWo;
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SOSEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void aWw()
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(R.i.sos_edittext_view, this, true);
  }
  
  public final void cIy()
  {
    getEditText().setOnFocusChangeListener(this.kEz);
  }
  
  @SuppressLint({"WrongViewCast"})
  protected final void init()
  {
    super.init();
    this.vWm = findViewById(R.h.voice_btn_container);
    this.vWn = findViewById(R.h.text_cancel);
    this.vWo = findViewById(R.h.search_bar_cancel_text_container);
    getEditText().setOnFocusChangeListener(null);
    getEditText().setHintTextColor(getResources().getColor(R.e.light_bg_hint_color));
    getEditText().setTextColor(getResources().getColor(R.e.normal_text_color));
  }
  
  public void setCancelTextViewClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.vWn != null) {
      this.vWn.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setCancelTextViewVisibile(int paramInt)
  {
    if (this.vWn != null) {
      this.vWn.setVisibility(paramInt);
    }
  }
  
  public void setIconRes(Drawable paramDrawable)
  {
    getIconView().setImageDrawable(paramDrawable);
  }
  
  public void setSearchBarCancelTextContainerVisibile(int paramInt)
  {
    if (this.vWo != null) {
      this.vWo.setVisibility(paramInt);
    }
  }
  
  public void setVoiceBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.vWm != null) {
      this.vWm.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setVoiceImageButtonVisibile(int paramInt)
  {
    if (this.vWm != null) {
      this.vWm.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.fts.widget.SOSEditTextView
 * JD-Core Version:    0.7.0.1
 */