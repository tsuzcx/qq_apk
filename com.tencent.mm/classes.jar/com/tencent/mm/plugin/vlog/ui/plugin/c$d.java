package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-vlog_release"})
public final class c$d
  extends FrameLayout
{
  private final ImageView dKU;
  private final View maskView;
  private final int padding;
  private final int size;
  private final int vLI;
  private final View vLJ;
  
  public c$d(Context paramContext)
  {
    super((Context)localObject);
    AppMethodBeat.i(191199);
    this.GGE = paramContext;
    paramContext = MMApplicationContext.getContext();
    p.g(paramContext, "MMApplicationContext.getContext()");
    this.vLI = paramContext.getResources().getColor(2131100920);
    this.dKU = new ImageView(getContext());
    this.maskView = new View(getContext());
    this.vLJ = new View(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.padding = ((int)paramContext.getResources().getDimension(2131165277));
    paramContext = getContext();
    p.g(paramContext, "context");
    this.size = ((int)paramContext.getResources().getDimension(2131165310));
    this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
    Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    paramContext.gravity = 17;
    localLayoutParams.gravity = 17;
    this.vLJ.setBackgroundColor(this.vLI);
    addView(this.vLJ, (ViewGroup.LayoutParams)paramContext);
    addView((View)this.dKU, (ViewGroup.LayoutParams)localLayoutParams);
    paramContext = this.maskView;
    localObject = getContext();
    p.g(localObject, "context");
    paramContext.setBackgroundColor(((Context)localObject).getResources().getColor(2131101424));
    this.maskView.setAlpha(0.5F);
    paramContext = new FrameLayout.LayoutParams(-2, -1);
    paramContext.gravity = 17;
    setLayoutParams((ViewGroup.LayoutParams)paramContext);
    AppMethodBeat.o(191199);
  }
  
  public final View getFocusedView()
  {
    return this.vLJ;
  }
  
  public final ImageView getImageView()
  {
    return this.dKU;
  }
  
  public final View getMaskView()
  {
    return this.maskView;
  }
  
  public final int getPadding()
  {
    return this.padding;
  }
  
  public final int getSize()
  {
    return this.size;
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(191197);
    super.setFocusable(paramBoolean);
    if (paramBoolean)
    {
      this.vLJ.setVisibility(0);
      AppMethodBeat.o(191197);
      return;
    }
    this.vLJ.setVisibility(4);
    AppMethodBeat.o(191197);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(191198);
    super.setSelected(paramBoolean);
    if (paramBoolean)
    {
      this.maskView.setVisibility(4);
      AppMethodBeat.o(191198);
      return;
    }
    this.maskView.setVisibility(0);
    AppMethodBeat.o(191198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c.d
 * JD-Core Version:    0.7.0.1
 */