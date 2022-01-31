package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ac.a.f;

public class VoiceSearchEditText
  extends EditText
{
  private Context context;
  public String hyx = "";
  private View.OnClickListener nXW;
  final Drawable vbG = getResources().getDrawable(a.f.voicesearch_enter_btn);
  final Drawable vbH = null;
  final Drawable vbI = getResources().getDrawable(a.f.search_clear);
  private VoiceSearchEditText.a vbJ;
  private boolean vbK = true;
  private boolean vbL = false;
  private boolean vbM = false;
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void cBr()
  {
    this.vbK = true;
    if (this.vbL)
    {
      setCompoundDrawables(this.vbH, getCompoundDrawables()[1], this.vbG, getCompoundDrawables()[3]);
      return;
    }
    if (getText().toString().length() > 0)
    {
      setCompoundDrawables(this.vbH, getCompoundDrawables()[1], this.vbI, getCompoundDrawables()[3]);
      return;
    }
    setCompoundDrawables(this.vbH, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.vbL = false;
    this.vbG.setBounds(0, 0, this.vbG.getIntrinsicWidth(), this.vbG.getIntrinsicHeight());
    this.vbI.setBounds(0, 0, this.vbI.getIntrinsicWidth(), this.vbI.getIntrinsicHeight());
    cBr();
    setOnTouchListener(new VoiceSearchEditText.1(this));
    addTextChangedListener(new VoiceSearchEditText.2(this));
    setOnFocusChangeListener(new VoiceSearchEditText.3(this));
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getCurrentFocus();
      if ((paramContext == null) || (paramContext != this)) {
        break label131;
      }
    }
    label131:
    for (this.vbM = true;; this.vbM = false)
    {
      requestFocus();
      return;
    }
  }
  
  public void setNeedIcon(boolean paramBoolean) {}
  
  public void setOnContentClearListener(VoiceSearchEditText.a parama)
  {
    this.vbJ = parama;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.nXW = paramOnClickListener;
    this.vbL = true;
    cBr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText
 * JD-Core Version:    0.7.0.1
 */