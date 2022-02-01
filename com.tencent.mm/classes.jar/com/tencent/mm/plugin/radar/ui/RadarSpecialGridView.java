package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mOldChildHeight", "", "mOldChildWidth", "mTable", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "getMTable", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "setMTable", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;)V", "computeScrollX", "computeScrollY", "initGridView", "", "onLayout", "changed", "", "l", "t", "r", "b", "reset", "OnItemClickListener", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarSpecialGridView
  extends RadarSpecialSmoothScrollView
{
  private a Ntc;
  public RadarSpecialTableLayout Ntd;
  private int Nte;
  private int Ntf;
  
  public RadarSpecialGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138653);
    paramContext = getContext();
    s.s(paramContext, "context");
    setMTable(new RadarSpecialTableLayout(paramContext));
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    getMTable().setLayoutParams((ViewGroup.LayoutParams)paramContext);
    getMTable().setStretchAllColumns(true);
    getMTable().setShrinkAllColumns(true);
    getMTable().setGravity(80);
    addView((View)getMTable());
    AppMethodBeat.o(138653);
  }
  
  public final RadarSpecialTableLayout getMTable()
  {
    AppMethodBeat.i(138650);
    RadarSpecialTableLayout localRadarSpecialTableLayout = this.Ntd;
    if (localRadarSpecialTableLayout != null)
    {
      AppMethodBeat.o(138650);
      return localRadarSpecialTableLayout;
    }
    s.bIx("mTable");
    AppMethodBeat.o(138650);
    return null;
  }
  
  public final a getOnItemClickListener()
  {
    return this.Ntc;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(138652);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = getScrollX() + localView.getWidth() - this.Ntf;
      this.Ntf = localView.getWidth();
      if (paramInt1 > 0)
      {
        if (getChildCount() <= 0) {
          break label138;
        }
        localView = getChildAt(0);
        paramInt3 = getScrollY() + localView.getHeight() - this.Nte;
        this.Nte = localView.getHeight();
        paramInt2 = i;
        if (paramInt3 <= 0) {}
      }
    }
    label138:
    for (paramInt2 = paramInt3;; paramInt2 = getScrollY())
    {
      scrollTo(paramInt1, paramInt2);
      AppMethodBeat.o(138652);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = getScrollX();
      break;
    }
  }
  
  public final void setMTable(RadarSpecialTableLayout paramRadarSpecialTableLayout)
  {
    AppMethodBeat.i(138651);
    s.u(paramRadarSpecialTableLayout, "<set-?>");
    this.Ntd = paramRadarSpecialTableLayout;
    AppMethodBeat.o(138651);
  }
  
  public final void setOnItemClickListener(a parama)
  {
    this.Ntc = parama;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void c(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialGridView
 * JD-Core Version:    0.7.0.1
 */