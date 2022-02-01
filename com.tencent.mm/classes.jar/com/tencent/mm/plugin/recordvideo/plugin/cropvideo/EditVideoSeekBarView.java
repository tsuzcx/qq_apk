package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cancelButton", "Landroid/widget/Button;", "finishButton", "getFinishButton", "()Landroid/widget/Button;", "setFinishButton", "(Landroid/widget/Button;)V", "hasInit", "", "recyclerThumbSeekBar", "Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "getRecyclerThumbSeekBar", "()Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "setRecyclerThumbSeekBar", "(Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;)V", "root", "changeThumbBarPercent", "", "currentTime", "checkInitThumbSeekBar", "initAsync", "path", "", "duration", "minDuration", "release", "reset", "setCancelButtonClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setFinishButtonClickListener", "setSeekBarHeight", "h", "setTextColor", "color", "setThumbBarSeekListener", "listener", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Companion", "plugin-recordvideo_release"})
public final class EditVideoSeekBarView
  extends LinearLayout
{
  public static final EditVideoSeekBarView.a xCD;
  public boolean hasInit;
  private Button rle;
  public RecyclerThumbSeekBar vXu;
  private Button vXv;
  private LinearLayout vXw;
  
  static
  {
    AppMethodBeat.i(75714);
    xCD = new EditVideoSeekBarView.a((byte)0);
    AppMethodBeat.o(75714);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75712);
    paramContext = z.jO(getContext()).inflate(2131495840, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75712);
      throw paramContext;
    }
    this.vXw = ((LinearLayout)paramContext);
    paramContext = findViewById(2131306400);
    p.g(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.vXu = ((RecyclerThumbSeekBar)paramContext);
    this.rle = ((Button)findViewById(2131299263));
    this.vXv = ((Button)findViewById(2131299265));
    AppMethodBeat.o(75712);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75713);
    paramContext = z.jO(getContext()).inflate(2131495840, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75713);
      throw paramContext;
    }
    this.vXw = ((LinearLayout)paramContext);
    paramContext = findViewById(2131306400);
    p.g(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.vXu = ((RecyclerThumbSeekBar)paramContext);
    this.rle = ((Button)findViewById(2131299263));
    this.vXv = ((Button)findViewById(2131299265));
    AppMethodBeat.o(75713);
  }
  
  public final Button getFinishButton()
  {
    return this.vXv;
  }
  
  public final RecyclerThumbSeekBar getRecyclerThumbSeekBar()
  {
    return this.vXu;
  }
  
  public final void release()
  {
    AppMethodBeat.i(75711);
    this.hasInit = false;
    this.vXu.release();
    Object localObject1 = this.vXu.getParent();
    if ((localObject1 instanceof LinearLayout))
    {
      Object localObject2 = this.vXu.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(75711);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout)localObject1).removeView((View)this.vXu);
      this.vXu = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localObject1).addView((View)this.vXu, 0, (ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(75711);
  }
  
  public final void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75710);
    p.h(paramOnClickListener, "onClickListener");
    Button localButton = this.rle;
    if (localButton == null) {
      p.gfZ();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75710);
  }
  
  public final void setFinishButton(Button paramButton)
  {
    this.vXv = paramButton;
  }
  
  public final void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75709);
    p.h(paramOnClickListener, "onClickListener");
    Button localButton = this.vXv;
    if (localButton == null) {
      p.gfZ();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75709);
  }
  
  public final void setRecyclerThumbSeekBar(RecyclerThumbSeekBar paramRecyclerThumbSeekBar)
  {
    AppMethodBeat.i(75705);
    p.h(paramRecyclerThumbSeekBar, "<set-?>");
    this.vXu = paramRecyclerThumbSeekBar;
    AppMethodBeat.o(75705);
  }
  
  public final void setSeekBarHeight(int paramInt)
  {
    AppMethodBeat.i(75706);
    ViewGroup.LayoutParams localLayoutParams = this.vXu.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.vXu.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(75706);
  }
  
  public final void setTextColor(String paramString)
  {
    AppMethodBeat.i(75707);
    if (paramString != null)
    {
      Button localButton = this.vXv;
      if (localButton == null) {
        p.gfZ();
      }
      localButton.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(75707);
  }
  
  public final void setThumbBarSeekListener(c.b paramb)
  {
    AppMethodBeat.i(75708);
    p.h(paramb, "listener");
    this.vXu.setThumbBarSeekListener(paramb);
    AppMethodBeat.o(75708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView
 * JD-Core Version:    0.7.0.1
 */