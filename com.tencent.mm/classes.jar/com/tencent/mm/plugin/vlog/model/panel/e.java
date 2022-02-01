package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "name", "", "pagPath", "pagIconPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPagIconPath", "getPagPath", "contentEquals", "", "other", "", "equals", "plugin-vlog_release"})
public final class e
  extends ac
{
  public final String Cga;
  final String GAV;
  final String name;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    super(b.fCc());
    AppMethodBeat.i(190794);
    this.name = paramString1;
    this.Cga = paramString2;
    this.GAV = paramString3;
    AppMethodBeat.o(190794);
  }
  
  public final boolean aZ(Object paramObject)
  {
    AppMethodBeat.i(190793);
    if ((super.aZ(paramObject)) && ((paramObject instanceof e)) && (p.j(((e)paramObject).Cga, this.Cga)) && (p.j(((e)paramObject).GAV, this.GAV)))
    {
      AppMethodBeat.o(190793);
      return true;
    }
    AppMethodBeat.o(190793);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190792);
    if ((super.equals(paramObject)) && ((paramObject instanceof e)) && (p.j(((e)paramObject).name, this.name)))
    {
      AppMethodBeat.o(190792);
      return true;
    }
    AppMethodBeat.o(190792);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.e
 * JD-Core Version:    0.7.0.1
 */