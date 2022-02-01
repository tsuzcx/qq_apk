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
  private Button rle;
  public RecyclerThumbSeekBar vXu;
  private Button vXv;
  private LinearLayout vXw;
  
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
    this.vXw = ((LinearLayout)z.jO(paramContext).inflate(2131495841, this, true));
    this.vXu = ((RecyclerThumbSeekBar)findViewById(2131306400));
    this.rle = ((Button)findViewById(2131299263));
    this.vXv = ((Button)findViewById(2131299265));
    AppMethodBeat.o(94756);
  }
  
  public final void dom()
  {
    AppMethodBeat.i(94760);
    this.vXu.release();
    ViewParent localViewParent = this.vXu.getParent();
    if ((localViewParent instanceof LinearLayout))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vXu.getLayoutParams();
      ((LinearLayout)localViewParent).removeView(this.vXu);
      this.vXu = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localViewParent).addView(this.vXu, 0, localLayoutParams);
    }
    AppMethodBeat.o(94760);
  }
  
  public void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94759);
    this.rle.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94759);
  }
  
  public void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94758);
    this.vXv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94758);
  }
  
  public void setTextColor(String paramString)
  {
    AppMethodBeat.i(94757);
    if (paramString != null) {
      this.vXv.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(94757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView
 * JD-Core Version:    0.7.0.1
 */