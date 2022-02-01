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
import com.tencent.mm.ui.z;

public class VideoSeekBarEditorView
  extends LinearLayout
{
  private Button qBo;
  public RecyclerThumbSeekBar uUk;
  private Button uUl;
  private LinearLayout uUm;
  
  public VideoSeekBarEditorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94754);
    init(paramContext);
    AppMethodBeat.o(94754);
  }
  
  public VideoSeekBarEditorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94755);
    init(paramContext);
    AppMethodBeat.o(94755);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(94756);
    this.uUm = ((LinearLayout)z.jD(paramContext).inflate(2131495841, this, true));
    this.uUk = ((RecyclerThumbSeekBar)findViewById(2131306400));
    this.qBo = ((Button)findViewById(2131299263));
    this.uUl = ((Button)findViewById(2131299265));
    AppMethodBeat.o(94756);
  }
  
  public final void deO()
  {
    AppMethodBeat.i(94760);
    this.uUk.release();
    ViewParent localViewParent = this.uUk.getParent();
    if ((localViewParent instanceof LinearLayout))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.uUk.getLayoutParams();
      ((LinearLayout)localViewParent).removeView(this.uUk);
      this.uUk = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localViewParent).addView(this.uUk, 0, localLayoutParams);
    }
    AppMethodBeat.o(94760);
  }
  
  public void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94759);
    this.qBo.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94759);
  }
  
  public void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94758);
    this.uUl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94758);
  }
  
  public void setTextColor(String paramString)
  {
    AppMethodBeat.i(94757);
    if (paramString != null) {
      this.uUl.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(94757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView
 * JD-Core Version:    0.7.0.1
 */