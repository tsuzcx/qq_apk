package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.ui.w;

public class VideoSeekBarEditorView
  extends LinearLayout
{
  private Button mlV;
  public RecyclerThumbSeekBar oQL;
  private Button oQM;
  private LinearLayout oQN;
  
  public VideoSeekBarEditorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55302);
    init(paramContext);
    AppMethodBeat.o(55302);
  }
  
  public VideoSeekBarEditorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55303);
    init(paramContext);
    AppMethodBeat.o(55303);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(55304);
    this.oQN = ((LinearLayout)w.hM(paramContext).inflate(2130971075, this, true));
    this.oQL = ((RecyclerThumbSeekBar)findViewById(2131828735));
    this.mlV = ((Button)findViewById(2131826738));
    this.oQM = ((Button)findViewById(2131826739));
    AppMethodBeat.o(55304);
  }
  
  public final void bSm()
  {
    AppMethodBeat.i(55308);
    this.oQL.release();
    ViewParent localViewParent = this.oQL.getParent();
    if ((localViewParent instanceof LinearLayout))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.oQL.getLayoutParams();
      ((LinearLayout)localViewParent).removeView(this.oQL);
      this.oQL = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localViewParent).addView(this.oQL, 0, localLayoutParams);
    }
    AppMethodBeat.o(55308);
  }
  
  public void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55307);
    this.mlV.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55307);
  }
  
  public void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(55306);
    this.oQM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(55306);
  }
  
  public void setTextColor(String paramString)
  {
    AppMethodBeat.i(55305);
    if (paramString != null) {
      this.oQM.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(55305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView
 * JD-Core Version:    0.7.0.1
 */