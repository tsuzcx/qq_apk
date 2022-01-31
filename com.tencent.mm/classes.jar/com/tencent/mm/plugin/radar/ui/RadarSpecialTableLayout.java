package com.tencent.mm.plugin.radar.ui;

import a.l;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "Landroid/widget/TableLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "specialLayoutFlag", "", "layout", "", "l", "", "t", "r", "b", "flag", "onLayout", "changed", "plugin-radar_release"})
public final class RadarSpecialTableLayout
  extends TableLayout
{
  private boolean pRP;
  
  public RadarSpecialTableLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(103015);
    AppMethodBeat.o(103015);
  }
  
  public RadarSpecialTableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103014);
    AppMethodBeat.o(103014);
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(103012);
    this.pRP = true;
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(103012);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(103013);
    int j;
    int i;
    if ((!this.pRP) && (paramInt2 < 0))
    {
      j = paramInt4 - paramInt2;
      i = 1;
    }
    for (;;)
    {
      this.pRP = false;
      if (i == 0)
      {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        AppMethodBeat.o(103013);
        return;
      }
      layout(paramInt1, 0, paramInt3, j);
      AppMethodBeat.o(103013);
      return;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialTableLayout
 * JD-Core Version:    0.7.0.1
 */