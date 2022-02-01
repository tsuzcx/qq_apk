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
import com.tencent.mm.ui.y;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cancelButton", "Landroid/widget/Button;", "finishButton", "getFinishButton", "()Landroid/widget/Button;", "setFinishButton", "(Landroid/widget/Button;)V", "hasInit", "", "recyclerThumbSeekBar", "Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "getRecyclerThumbSeekBar", "()Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "setRecyclerThumbSeekBar", "(Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;)V", "root", "changeThumbBarPercent", "", "currentTime", "checkInitThumbSeekBar", "initAsync", "path", "", "duration", "minDuration", "release", "reset", "setCancelButtonClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setFinishButtonClickListener", "setSeekBarHeight", "h", "setTextColor", "color", "setThumbBarSeekListener", "listener", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Companion", "plugin-recordvideo_release"})
public final class EditVideoSeekBarView
  extends LinearLayout
{
  public static final a vmb;
  public boolean hasInit;
  private Button pSG;
  public RecyclerThumbSeekBar tLG;
  private Button tLH;
  private LinearLayout tLI;
  
  static
  {
    AppMethodBeat.i(75714);
    vmb = new a((byte)0);
    AppMethodBeat.o(75714);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75712);
    paramContext = y.js(getContext()).inflate(2131495840, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75712);
      throw paramContext;
    }
    this.tLI = ((LinearLayout)paramContext);
    paramContext = findViewById(2131306400);
    k.g(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.tLG = ((RecyclerThumbSeekBar)paramContext);
    this.pSG = ((Button)findViewById(2131299263));
    this.tLH = ((Button)findViewById(2131299265));
    AppMethodBeat.o(75712);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75713);
    paramContext = y.js(getContext()).inflate(2131495840, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75713);
      throw paramContext;
    }
    this.tLI = ((LinearLayout)paramContext);
    paramContext = findViewById(2131306400);
    k.g(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.tLG = ((RecyclerThumbSeekBar)paramContext);
    this.pSG = ((Button)findViewById(2131299263));
    this.tLH = ((Button)findViewById(2131299265));
    AppMethodBeat.o(75713);
  }
  
  public final Button getFinishButton()
  {
    return this.tLH;
  }
  
  public final RecyclerThumbSeekBar getRecyclerThumbSeekBar()
  {
    return this.tLG;
  }
  
  public final void release()
  {
    AppMethodBeat.i(75711);
    this.hasInit = false;
    this.tLG.release();
    Object localObject1 = this.tLG.getParent();
    if ((localObject1 instanceof LinearLayout))
    {
      Object localObject2 = this.tLG.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(75711);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout)localObject1).removeView((View)this.tLG);
      this.tLG = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localObject1).addView((View)this.tLG, 0, (ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(75711);
  }
  
  public final void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75710);
    k.h(paramOnClickListener, "onClickListener");
    Button localButton = this.pSG;
    if (localButton == null) {
      k.fvU();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75710);
  }
  
  public final void setFinishButton(Button paramButton)
  {
    this.tLH = paramButton;
  }
  
  public final void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75709);
    k.h(paramOnClickListener, "onClickListener");
    Button localButton = this.tLH;
    if (localButton == null) {
      k.fvU();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75709);
  }
  
  public final void setRecyclerThumbSeekBar(RecyclerThumbSeekBar paramRecyclerThumbSeekBar)
  {
    AppMethodBeat.i(75705);
    k.h(paramRecyclerThumbSeekBar, "<set-?>");
    this.tLG = paramRecyclerThumbSeekBar;
    AppMethodBeat.o(75705);
  }
  
  public final void setSeekBarHeight(int paramInt)
  {
    AppMethodBeat.i(75706);
    ViewGroup.LayoutParams localLayoutParams = this.tLG.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.tLG.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(75706);
  }
  
  public final void setTextColor(String paramString)
  {
    AppMethodBeat.i(75707);
    if (paramString != null)
    {
      Button localButton = this.tLH;
      if (localButton == null) {
        k.fvU();
      }
      localButton.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(75707);
  }
  
  public final void setThumbBarSeekListener(c.b paramb)
  {
    AppMethodBeat.i(75708);
    k.h(paramb, "listener");
    this.tLG.setThumbBarSeekListener(paramb);
    AppMethodBeat.o(75708);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView
 * JD-Core Version:    0.7.0.1
 */