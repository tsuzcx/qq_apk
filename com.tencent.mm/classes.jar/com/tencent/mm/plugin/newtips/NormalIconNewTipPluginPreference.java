package com.tencent.mm.plugin.newtips;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/newtips/NormalIconNewTipPluginPreference;", "Lcom/tencent/mm/plugin/newtips/NormalIconNewTipPreference;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setTextDotVisibility", "", "visibility", "plugin-newtips_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  public final void aeD(int paramInt)
  {
    AppMethodBeat.i(266276);
    super.aeD(paramInt);
    if (paramInt == 0) {
      on(0, b.b.unread_dot_shape);
    }
    AppMethodBeat.o(266276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPluginPreference
 * JD-Core Version:    0.7.0.1
 */