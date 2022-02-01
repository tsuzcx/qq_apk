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
import com.tencent.mm.ui.aa;

public class VideoSeekBarEditorView
  extends LinearLayout
{
  private Button sTL;
  public RecyclerThumbSeekBar zDX;
  private Button zDY;
  private LinearLayout zDZ;
  
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
    this.zDZ = ((LinearLayout)aa.jQ(paramContext).inflate(2131496810, this, true));
    this.zDX = ((RecyclerThumbSeekBar)findViewById(2131309831));
    this.sTL = ((Button)findViewById(2131299840));
    this.zDY = ((Button)findViewById(2131299843));
    AppMethodBeat.o(94756);
  }
  
  public final void ele()
  {
    AppMethodBeat.i(94760);
    this.zDX.release();
    ViewParent localViewParent = this.zDX.getParent();
    if ((localViewParent instanceof LinearLayout))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.zDX.getLayoutParams();
      ((LinearLayout)localViewParent).removeView(this.zDX);
      this.zDX = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localViewParent).addView(this.zDX, 0, localLayoutParams);
    }
    AppMethodBeat.o(94760);
  }
  
  public void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94759);
    this.sTL.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94759);
  }
  
  public void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94758);
    this.zDY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94758);
  }
  
  public void setTextColor(String paramString)
  {
    AppMethodBeat.i(94757);
    if (paramString != null) {
      this.zDY.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(94757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView
 * JD-Core Version:    0.7.0.1
 */