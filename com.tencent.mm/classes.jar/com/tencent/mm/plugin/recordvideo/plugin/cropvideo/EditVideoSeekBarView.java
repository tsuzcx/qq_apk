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
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cancelButton", "Landroid/widget/Button;", "finishButton", "getFinishButton", "()Landroid/widget/Button;", "setFinishButton", "(Landroid/widget/Button;)V", "hasInit", "", "recyclerThumbSeekBar", "Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "getRecyclerThumbSeekBar", "()Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;", "setRecyclerThumbSeekBar", "(Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;)V", "root", "changeThumbBarPercent", "", "currentTime", "checkInitThumbSeekBar", "initAsync", "path", "", "duration", "minDuration", "release", "reset", "setCancelButtonClickListener", "onClickListener", "Landroid/view/View$OnClickListener;", "setFinishButtonClickListener", "setSeekBarHeight", "h", "setTextColor", "color", "setThumbBarSeekListener", "listener", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Companion", "plugin-recordvideo_release"})
public final class EditVideoSeekBarView
  extends LinearLayout
{
  public static final a HPz;
  public RecyclerThumbSeekBar FiW;
  private Button FiX;
  private LinearLayout FiY;
  boolean hasInit;
  private Button wzH;
  
  static
  {
    AppMethodBeat.i(75714);
    HPz = new a((byte)0);
    AppMethodBeat.o(75714);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75712);
    paramContext = ad.kS(getContext()).inflate(b.f.video_seek_bar, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75712);
      throw paramContext;
    }
    this.FiY = ((LinearLayout)paramContext);
    paramContext = findViewById(b.e.video_thumb_seek_bar);
    p.j(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.FiW = ((RecyclerThumbSeekBar)paramContext);
    this.wzH = ((Button)findViewById(b.e.edit_text_cancel));
    this.FiX = ((Button)findViewById(b.e.edit_text_ok));
    AppMethodBeat.o(75712);
  }
  
  public EditVideoSeekBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75713);
    paramContext = ad.kS(getContext()).inflate(b.f.video_seek_bar, (ViewGroup)this, true);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(75713);
      throw paramContext;
    }
    this.FiY = ((LinearLayout)paramContext);
    paramContext = findViewById(b.e.video_thumb_seek_bar);
    p.j(paramContext, "findViewById(R.id.video_thumb_seek_bar)");
    this.FiW = ((RecyclerThumbSeekBar)paramContext);
    this.wzH = ((Button)findViewById(b.e.edit_text_cancel));
    this.FiX = ((Button)findViewById(b.e.edit_text_ok));
    AppMethodBeat.o(75713);
  }
  
  public final Button getFinishButton()
  {
    return this.FiX;
  }
  
  public final RecyclerThumbSeekBar getRecyclerThumbSeekBar()
  {
    return this.FiW;
  }
  
  public final void release()
  {
    AppMethodBeat.i(75711);
    this.hasInit = false;
    this.FiW.release();
    Object localObject1 = this.FiW.getParent();
    if ((localObject1 instanceof LinearLayout))
    {
      Object localObject2 = this.FiW.getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(75711);
        throw ((Throwable)localObject1);
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout)localObject1).removeView((View)this.FiW);
      this.FiW = new RecyclerThumbSeekBar(getContext());
      ((LinearLayout)localObject1).addView((View)this.FiW, 0, (ViewGroup.LayoutParams)localObject2);
    }
    AppMethodBeat.o(75711);
  }
  
  public final void setCancelButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75710);
    p.k(paramOnClickListener, "onClickListener");
    Button localButton = this.wzH;
    if (localButton == null) {
      p.iCn();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75710);
  }
  
  public final void setFinishButton(Button paramButton)
  {
    this.FiX = paramButton;
  }
  
  public final void setFinishButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(75709);
    p.k(paramOnClickListener, "onClickListener");
    Button localButton = this.FiX;
    if (localButton == null) {
      p.iCn();
    }
    localButton.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(75709);
  }
  
  public final void setRecyclerThumbSeekBar(RecyclerThumbSeekBar paramRecyclerThumbSeekBar)
  {
    AppMethodBeat.i(75705);
    p.k(paramRecyclerThumbSeekBar, "<set-?>");
    this.FiW = paramRecyclerThumbSeekBar;
    AppMethodBeat.o(75705);
  }
  
  public final void setSeekBarHeight(int paramInt)
  {
    AppMethodBeat.i(75706);
    ViewGroup.LayoutParams localLayoutParams = this.FiW.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.FiW.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(75706);
  }
  
  public final void setTextColor(String paramString)
  {
    AppMethodBeat.i(75707);
    if (paramString != null)
    {
      Button localButton = this.FiX;
      if (localButton == null) {
        p.iCn();
      }
      localButton.setTextColor(Color.parseColor(paramString));
    }
    AppMethodBeat.o(75707);
  }
  
  public final void setThumbBarSeekListener(c.b paramb)
  {
    AppMethodBeat.i(75708);
    p.k(paramb, "listener");
    this.FiW.setThumbBarSeekListener(paramb);
    AppMethodBeat.o(75708);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "error", "", "onPrepared"})
  static final class b
    implements c.a
  {
    public static final b HPA;
    
    static
    {
      AppMethodBeat.i(75704);
      HPA = new b();
      AppMethodBeat.o(75704);
    }
    
    public final void um(boolean paramBoolean)
    {
      AppMethodBeat.i(75703);
      if (paramBoolean)
      {
        Log.e("MicroMsg.VideoSeekBarEditorView", "Not Supported init SegmentSeekBar failed.");
        AppMethodBeat.o(75703);
        return;
      }
      AppMethodBeat.o(75703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView
 * JD-Core Version:    0.7.0.1
 */