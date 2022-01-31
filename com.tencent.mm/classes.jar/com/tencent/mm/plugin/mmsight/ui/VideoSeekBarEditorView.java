package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.ui.y;

public class VideoSeekBarEditorView
  extends LinearLayout
{
  private Button jRz;
  RecyclerThumbSeekBar mqW;
  private Button mqX;
  private LinearLayout mqY;
  
  public VideoSeekBarEditorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public VideoSeekBarEditorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mqY = ((LinearLayout)y.gt(paramContext).inflate(a.f.video_seek_bar_editor_view, this, true));
    this.mqW = ((RecyclerThumbSeekBar)findViewById(a.e.video_thumb_seek_bar));
    this.jRz = ((Button)findViewById(a.e.edit_text_cancel));
    this.mqX = ((Button)findViewById(a.e.edit_text_ok));
  }
  
  public final void bkl()
  {
    this.mqW.release();
    ViewParent localViewParent = this.mqW.getParent();
    if ((localViewParent instanceof LinearLayout))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mqW.getLayoutParams();
      ((LinearLayout)localViewParent).removeView(this.mqW);
      this.mqW = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localViewParent).addView(this.mqW, 0, localLayoutParams);
    }
  }
  
  public void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jRz.setOnClickListener(paramOnClickListener);
  }
  
  public void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mqX.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView
 * JD-Core Version:    0.7.0.1
 */