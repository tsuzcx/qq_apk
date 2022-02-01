package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "name", "", "pagPath", "pagIconPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPagIconPath", "getPagPath", "contentEquals", "", "other", "", "equals", "plugin-vlog_release"})
public final class e
  extends ae
{
  public final String GaM;
  final String NoE;
  final String name;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    super(b.gua());
    AppMethodBeat.i(250820);
    this.name = paramString1;
    this.GaM = paramString2;
    this.NoE = paramString3;
    AppMethodBeat.o(250820);
  }
  
  public final boolean ba(Object paramObject)
  {
    AppMethodBeat.i(250818);
    if ((super.ba(paramObject)) && ((paramObject instanceof e)) && (p.h(((e)paramObject).GaM, this.GaM)) && (p.h(((e)paramObject).NoE, this.NoE)))
    {
      AppMethodBeat.o(250818);
      return true;
    }
    AppMethodBeat.o(250818);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250816);
    if ((super.equals(paramObject)) && ((paramObject instanceof e)) && (p.h(((e)paramObject).name, this.name)))
    {
      AppMethodBeat.o(250816);
      return true;
    }
    AppMethodBeat.o(250816);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.e
 * JD-Core Version:    0.7.0.1
 */