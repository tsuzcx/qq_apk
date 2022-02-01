package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.ac;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "name", "", "pagPath", "pagIconPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPagIconPath", "getPagPath", "contentEquals", "", "other", "", "equals", "plugin-vlog_release"})
public final class e
  extends ac
{
  final String BHJ;
  final String name;
  public final String xPf;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    super(b.esA());
    AppMethodBeat.i(195875);
    this.name = paramString1;
    this.xPf = paramString2;
    this.BHJ = paramString3;
    AppMethodBeat.o(195875);
  }
  
  public final boolean aS(Object paramObject)
  {
    AppMethodBeat.i(195874);
    if ((super.aS(paramObject)) && ((paramObject instanceof e)) && (p.i(((e)paramObject).xPf, this.xPf)) && (p.i(((e)paramObject).BHJ, this.BHJ)))
    {
      AppMethodBeat.o(195874);
      return true;
    }
    AppMethodBeat.o(195874);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195873);
    if ((super.equals(paramObject)) && ((paramObject instanceof e)) && (p.i(((e)paramObject).name, this.name)))
    {
      AppMethodBeat.o(195873);
      return true;
    }
    AppMethodBeat.o(195873);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.e
 * JD-Core Version:    0.7.0.1
 */