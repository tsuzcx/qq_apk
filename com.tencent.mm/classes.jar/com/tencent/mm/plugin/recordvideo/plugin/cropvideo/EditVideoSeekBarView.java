package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.ui.w;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cancelButton", "Landroid/widget/Button;", "finishButton", "getFinishButton", "()Landroid/widget/Button;", "setFinishButton", "(Landroid/widget/Button;)V", "hasInit", "", "recyclerThumbSeekBar", "Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "root", "changeThumbBarPercent", "", "currentTime", "checkInitThumbSeekBar", "initAsync", "path", "", "duration", "release", "reset", "setCancelButtonClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setFinishButtonClickListener", "setTextColor", "color", "setThumbBarSeekListener", "listener", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Companion", "plugin-recordvideo_release"})
public final class EditVideoSeekBarView
  extends LinearLayout
{
  public static final EditVideoSeekBarView.a qdr;
  public boolean hasInit;
  private Button mlV;
  public RecyclerThumbSeekBar oQL;
  private Button oQM;
  private LinearLayout oQN;
  
  static
  {
    AppMethodBeat.i(150758);
    qdr = new EditVideoSeekBarView.a((byte)0);
    AppMethodBeat.o(150758);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(150756);
    paramContext = w.hM(getContext()).inflate(2130971074, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(150756);
      throw paramContext;
    }
    this.oQN = ((LinearLayout)paramContext);
    paramContext = findViewById(2131828735);
    j.p(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.oQL = ((RecyclerThumbSeekBar)paramContext);
    this.mlV = ((Button)findViewById(2131826738));
    this.oQM = ((Button)findViewById(2131826739));
    AppMethodBeat.o(150756);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(150757);
    paramContext = w.hM(getContext()).inflate(2130971074, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(150757);
      throw paramContext;
    }
    this.oQN = ((LinearLayout)paramContext);
    paramContext = findViewById(2131828735);
    j.p(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.oQL = ((RecyclerThumbSeekBar)paramContext);
    this.mlV = ((Button)findViewById(2131826738));
    this.oQM = ((Button)findViewById(2131826739));
    AppMethodBeat.o(150757);
  }
  
  public final Button getFinishButton()
  {
    return this.oQM;
  }
  
  public final void release()
  {
    AppMethodBeat.i(150755);
    this.hasInit = false;
    this.oQL.release();
    Object localObject1 = this.oQL.getParent();
    if ((localObject1 instanceof LinearLayout))
    {
      Object localObject2 = this.oQL.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(150755);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout)localObject1).removeView((View)this.oQL);
      this.oQL = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localObject1).addView((View)this.oQL, 0, (ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(150755);
  }
  
  public final void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(150754);
    j.q(paramOnClickListener, "onClickListener");
    Button localButton = this.mlV;
    if (localButton == null) {
      j.ebi();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(150754);
  }
  
  public final void setFinishButton(Button paramButton)
  {
    this.oQM = paramButton;
  }
  
  public final void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(150753);
    j.q(paramOnClickListener, "onClickListener");
    Button localButton = this.oQM;
    if (localButton == null) {
      j.ebi();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(150753);
  }
  
  public final void setTextColor(String paramString)
  {
    AppMethodBeat.i(150751);
    if (paramString != null)
    {
      Button localButton = this.oQM;
      if (localButton == null) {
        j.ebi();
      }
      localButton.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(150751);
  }
  
  public final void setThumbBarSeekListener(c.b paramb)
  {
    AppMethodBeat.i(150752);
    j.q(paramb, "listener");
    this.oQL.setThumbBarSeekListener(paramb);
    AppMethodBeat.o(150752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView
 * JD-Core Version:    0.7.0.1
 */