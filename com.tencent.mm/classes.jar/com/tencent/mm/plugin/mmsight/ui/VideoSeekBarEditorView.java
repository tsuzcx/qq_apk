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
import com.tencent.mm.plugin.w.a.e;
import com.tencent.mm.plugin.w.a.f;
import com.tencent.mm.ui.af;

public class VideoSeekBarEditorView
  extends LinearLayout
{
  public RecyclerThumbSeekBar Leu;
  private Button Lev;
  private LinearLayout ybr;
  private Button zVS;
  
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
    this.ybr = ((LinearLayout)af.mU(paramContext).inflate(a.f.video_seek_bar_editor_view, this, true));
    this.Leu = ((RecyclerThumbSeekBar)findViewById(a.e.video_thumb_seek_bar));
    this.zVS = ((Button)findViewById(a.e.edit_text_cancel));
    this.Lev = ((Button)findViewById(a.e.edit_text_ok));
    AppMethodBeat.o(94756);
  }
  
  public final void gdz()
  {
    AppMethodBeat.i(94760);
    this.Leu.release();
    ViewParent localViewParent = this.Leu.getParent();
    if ((localViewParent instanceof LinearLayout))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Leu.getLayoutParams();
      ((LinearLayout)localViewParent).removeView(this.Leu);
      this.Leu = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localViewParent).addView(this.Leu, 0, localLayoutParams);
    }
    AppMethodBeat.o(94760);
  }
  
  public void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94759);
    this.zVS.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94759);
  }
  
  public void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(94758);
    this.Lev.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(94758);
  }
  
  public void setTextColor(String paramString)
  {
    AppMethodBeat.i(94757);
    if (paramString != null) {
      this.Lev.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(94757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView
 * JD-Core Version:    0.7.0.1
 */