package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "Landroid/widget/TableLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "specialLayoutFlag", "", "layout", "", "l", "", "t", "r", "b", "flag", "onLayout", "changed", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarSpecialTableLayout
  extends TableLayout
{
  private boolean Ntm;
  
  public RadarSpecialTableLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138662);
    AppMethodBeat.o(138662);
  }
  
  public RadarSpecialTableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138661);
    AppMethodBeat.o(138661);
  }
  
  public final void T(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(138659);
    this.Ntm = true;
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(138659);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(138660);
    int j;
    int i;
    if ((!this.Ntm) && (paramInt2 < 0))
    {
      j = paramInt4 - paramInt2;
      i = 1;
    }
    for (;;)
    {
      this.Ntm = false;
      if (i == 0)
      {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(138660);
        return;
      }
      layout(paramInt1, 0, paramInt3, j);
      AppMethodBeat.o(138660);
      return;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialTableLayout
 * JD-Core Version:    0.7.0.1
 */