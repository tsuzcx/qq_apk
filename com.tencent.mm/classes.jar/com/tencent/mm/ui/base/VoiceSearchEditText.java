package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VoiceSearchEditText
  extends EditText
{
  private Context context;
  public String jqH;
  private View.OnClickListener qMg;
  final Drawable zqc;
  final Drawable zqd;
  final Drawable zqe;
  private VoiceSearchEditText.a zqf;
  private boolean zqg;
  private boolean zqh;
  private boolean zqi;
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107091);
    this.jqH = "";
    this.zqc = getResources().getDrawable(2130840709);
    this.zqd = null;
    this.zqe = getResources().getDrawable(2130840216);
    this.zqg = true;
    this.zqh = false;
    this.zqi = false;
    init(paramContext);
    AppMethodBeat.o(107091);
  }
  
  public VoiceSearchEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107092);
    this.jqH = "";
    this.zqc = getResources().getDrawable(2130840709);
    this.zqd = null;
    this.zqe = getResources().getDrawable(2130840216);
    this.zqg = true;
    this.zqh = false;
    this.zqi = false;
    init(paramContext);
    AppMethodBeat.o(107092);
  }
  
  private void dEG()
  {
    AppMethodBeat.i(107095);
    this.zqg = true;
    if (this.zqh)
    {
      setCompoundDrawables(this.zqd, getCompoundDrawables()[1], this.zqc, getCompoundDrawables()[3]);
      AppMethodBeat.o(107095);
      return;
    }
    if (getText().toString().length() > 0)
    {
      setCompoundDrawables(this.zqd, getCompoundDrawables()[1], this.zqe, getCompoundDrawables()[3]);
      AppMethodBeat.o(107095);
      return;
    }
    setCompoundDrawables(this.zqd, getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(107095);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(107094);
    this.context = paramContext;
    this.zqh = false;
    this.zqc.setBounds(0, 0, this.zqc.getIntrinsicWidth(), this.zqc.getIntrinsicHeight());
    this.zqe.setBounds(0, 0, this.zqe.getIntrinsicWidth(), this.zqe.getIntrinsicHeight());
    dEG();
    setOnTouchListener(new VoiceSearchEditText.1(this));
    addTextChangedListener(new VoiceSearchEditText.2(this));
    setOnFocusChangeListener(new VoiceSearchEditText.3(this));
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getCurrentFocus();
      if ((paramContext == null) || (paramContext != this)) {
        break label141;
      }
    }
    label141:
    for (this.zqi = true;; this.zqi = false)
    {
      requestFocus();
      AppMethodBeat.o(107094);
      return;
    }
  }
  
  public void setNeedIcon(boolean paramBoolean) {}
  
  public void setOnContentClearListener(VoiceSearchEditText.a parama)
  {
    this.zqf = parama;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(107093);
    this.qMg = paramOnClickListener;
    this.zqh = true;
    dEG();
    AppMethodBeat.o(107093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText
 * JD-Core Version:    0.7.0.1
 */