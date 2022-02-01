package com.tencent.mm.plugin.vlog.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/LabelSlider$1", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "onSelected", "", "index", "", "plugin-vlog_release"})
public final class LabelSlider$1
  implements LabelSlider.a
{
  public final void HI(int paramInt)
  {
    AppMethodBeat.i(195958);
    LabelSlider.a locala = this.BKf.getCallback();
    if (locala != null)
    {
      locala.HI(paramInt);
      AppMethodBeat.o(195958);
      return;
    }
    AppMethodBeat.o(195958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.LabelSlider.1
 * JD-Core Version:    0.7.0.1
 */