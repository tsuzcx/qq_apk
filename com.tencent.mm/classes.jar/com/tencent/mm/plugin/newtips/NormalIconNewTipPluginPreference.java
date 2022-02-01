package com.tencent.mm.plugin.newtips;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/newtips/NormalIconNewTipPluginPreference;", "Lcom/tencent/mm/plugin/newtips/NormalIconNewTipPreference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setTextDotVisibility", "", "visibility", "plugin-newtips_release"})
public final class NormalIconNewTipPluginPreference
  extends NormalIconNewTipPreference
{
  public NormalIconNewTipPluginPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NormalIconNewTipPluginPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void aak(int paramInt)
  {
    AppMethodBeat.i(186563);
    super.aak(paramInt);
    if (paramInt == 0) {
      mt(0, b.b.unread_dot_shape);
    }
    AppMethodBeat.o(186563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPluginPreference
 * JD-Core Version:    0.7.0.1
 */