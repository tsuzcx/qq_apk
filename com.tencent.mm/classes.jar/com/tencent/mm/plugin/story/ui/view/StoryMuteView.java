package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.story.a.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryMuteView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryMuteView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MUTE_IN_BG_PADDING", "MUTE_OUT_BG_PADDING", "mMuteBg", "Landroid/widget/ImageView;", "mMuteTv", "Landroid/widget/TextView;", "muteDrawable", "Landroid/graphics/drawable/Drawable;", "initViews", "", "measureDimension", "defaultSize", "parentMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "triggerMuteIn", "triggerMuteOut", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryMuteView
  extends AbsStoryMuteView
{
  private ImageView SzA;
  private final int Szw;
  private final int Szx;
  private Drawable Szy;
  private TextView Szz;
  
  public StoryMuteView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(120281);
    this.Szw = 30;
    bSZ();
    AppMethodBeat.o(120281);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120282);
    this.Szw = 30;
    bSZ();
    AppMethodBeat.o(120282);
  }
  
  public StoryMuteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120283);
    this.Szw = 30;
    bSZ();
    AppMethodBeat.o(120283);
  }
  
  private final void bSZ()
  {
    AppMethodBeat.i(120276);
    LayoutInflater.from(getContext()).inflate(a.e.SgT, (ViewGroup)this);
    this.Szz = ((TextView)findViewById(a.d.SfV));
    this.SzA = ((ImageView)findViewById(a.d.SfU));
    this.Szy = bb.e(getContext().getResources().getDrawable(a.f.icons_outlined_volume_off), -1);
    Object localObject = this.Szy;
    s.checkNotNull(localObject);
    ((Drawable)localObject).setBounds(0, 0, a.fromDPToPix(getContext(), 48), a.fromDPToPix(getContext(), 48));
    localObject = this.Szz;
    if (localObject != null) {
      ((TextView)localObject).setCompoundDrawables(null, this.Szy, null, null);
    }
    localObject = this.Szz;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getContext().getResources().getString(a.g.ShU));
    }
    localObject = this.SzA;
    if (localObject != null) {
      ((ImageView)localObject).setPadding(this.Szx, this.Szw, this.Szw, this.Szx);
    }
    AppMethodBeat.o(120276);
  }
  
  private static int mc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120277);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(120277);
      return paramInt1;
      paramInt1 = paramInt2;
      continue;
      paramInt1 = Math.min(paramInt1, paramInt2);
    }
  }
  
  public final void huH()
  {
    AppMethodBeat.i(120279);
    ImageView localImageView = this.SzA;
    if (localImageView != null) {
      localImageView.setPadding(this.Szx, this.Szx, this.Szx, this.Szx);
    }
    AppMethodBeat.o(120279);
  }
  
  public final void huI()
  {
    AppMethodBeat.i(120280);
    ImageView localImageView = this.SzA;
    if (localImageView != null) {
      localImageView.setPadding(this.Szx, this.Szw, this.Szw, this.Szx);
    }
    AppMethodBeat.o(120280);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(120278);
    int i = mc(a.bs(getContext(), a.b.flS), paramInt1);
    int j = mc(a.bs(getContext(), a.b.flS), paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(i, j);
    AppMethodBeat.o(120278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryMuteView
 * JD-Core Version:    0.7.0.1
 */