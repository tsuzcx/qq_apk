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
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cancelButton", "Landroid/widget/Button;", "finishButton", "getFinishButton", "()Landroid/widget/Button;", "setFinishButton", "(Landroid/widget/Button;)V", "<set-?>", "", "hasInit", "getHasInit", "()Z", "recyclerThumbSeekBar", "Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "getRecyclerThumbSeekBar", "()Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "setRecyclerThumbSeekBar", "(Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;)V", "root", "changeThumbBarPercent", "", "currentTime", "checkInitThumbSeekBar", "initAsync", "path", "", "duration", "minDuration", "release", "reset", "setCancelButtonClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setFinishButtonClickListener", "setSeekBarHeight", "h", "setTextColor", "color", "setThumbBarSeekListener", "listener", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditVideoSeekBarView
  extends LinearLayout
{
  public static final EditVideoSeekBarView.a NMf;
  public RecyclerThumbSeekBar Leu;
  private Button Lev;
  private boolean hasInit;
  private LinearLayout ybr;
  private Button zVS;
  
  static
  {
    AppMethodBeat.i(75714);
    NMf = new EditVideoSeekBarView.a((byte)0);
    AppMethodBeat.o(75714);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75712);
    paramContext = af.mU(getContext()).inflate(b.f.video_seek_bar, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75712);
      throw paramContext;
    }
    this.ybr = ((LinearLayout)paramContext);
    paramContext = findViewById(b.e.video_thumb_seek_bar);
    s.s(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.Leu = ((RecyclerThumbSeekBar)paramContext);
    this.zVS = ((Button)findViewById(b.e.edit_text_cancel));
    this.Lev = ((Button)findViewById(b.e.edit_text_ok));
    AppMethodBeat.o(75712);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75713);
    paramContext = af.mU(getContext()).inflate(b.f.video_seek_bar, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75713);
      throw paramContext;
    }
    this.ybr = ((LinearLayout)paramContext);
    paramContext = findViewById(b.e.video_thumb_seek_bar);
    s.s(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.Leu = ((RecyclerThumbSeekBar)paramContext);
    this.zVS = ((Button)findViewById(b.e.edit_text_cancel));
    this.Lev = ((Button)findViewById(b.e.edit_text_ok));
    AppMethodBeat.o(75713);
  }
  
  private static final void Bc(boolean paramBoolean)
  {
    AppMethodBeat.i(280972);
    if (paramBoolean)
    {
      Log.e("MicroMsg.VideoSeekBarEditorView", "Not Supported init SegmentSeekBar failed.");
      AppMethodBeat.o(280972);
      return;
    }
    AppMethodBeat.o(280972);
  }
  
  private final void gIS()
  {
    AppMethodBeat.i(280965);
    this.Leu.setOnPreparedListener(EditVideoSeekBarView..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(280965);
  }
  
  public final void aJ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(281014);
    s.u(paramString, "path");
    if (this.hasInit)
    {
      AppMethodBeat.o(281014);
      return;
    }
    this.hasInit = true;
    this.Leu.aMx(paramString);
    paramString = new VideoTransPara();
    paramString.duration = (paramInt1 / 1000);
    paramString.minDuration = paramInt2;
    this.Leu.setVideoTransPara(paramString);
    gIS();
    AppMethodBeat.o(281014);
  }
  
  public final Button getFinishButton()
  {
    return this.Lev;
  }
  
  public final boolean getHasInit()
  {
    return this.hasInit;
  }
  
  public final RecyclerThumbSeekBar getRecyclerThumbSeekBar()
  {
    return this.Leu;
  }
  
  public final void release()
  {
    AppMethodBeat.i(75711);
    this.hasInit = false;
    this.Leu.release();
    Object localObject1 = this.Leu.getParent();
    if ((localObject1 instanceof LinearLayout))
    {
      Object localObject2 = this.Leu.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(75711);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout)localObject1).removeView((View)this.Leu);
      this.Leu = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localObject1).addView((View)this.Leu, 0, (ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(75711);
  }
  
  public final void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75710);
    s.u(paramOnClickListener, "onClickListener");
    Button localButton = this.zVS;
    s.checkNotNull(localButton);
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75710);
  }
  
  public final void setFinishButton(Button paramButton)
  {
    this.Lev = paramButton;
  }
  
  public final void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75709);
    s.u(paramOnClickListener, "onClickListener");
    Button localButton = this.Lev;
    s.checkNotNull(localButton);
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75709);
  }
  
  public final void setRecyclerThumbSeekBar(RecyclerThumbSeekBar paramRecyclerThumbSeekBar)
  {
    AppMethodBeat.i(75705);
    s.u(paramRecyclerThumbSeekBar, "<set-?>");
    this.Leu = paramRecyclerThumbSeekBar;
    AppMethodBeat.o(75705);
  }
  
  public final void setSeekBarHeight(int paramInt)
  {
    AppMethodBeat.i(75706);
    ViewGroup.LayoutParams localLayoutParams = this.Leu.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.Leu.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(75706);
  }
  
  public final void setTextColor(String paramString)
  {
    AppMethodBeat.i(75707);
    if (paramString != null)
    {
      Button localButton = this.Lev;
      s.checkNotNull(localButton);
      localButton.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(75707);
  }
  
  public final void setThumbBarSeekListener(c.b paramb)
  {
    AppMethodBeat.i(75708);
    s.u(paramb, "listener");
    this.Leu.setThumbBarSeekListener(paramb);
    AppMethodBeat.o(75708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView
 * JD-Core Version:    0.7.0.1
 */