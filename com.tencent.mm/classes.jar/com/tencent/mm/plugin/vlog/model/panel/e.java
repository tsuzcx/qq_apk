package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.ac;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "name", "", "pagPath", "pagIconPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPagIconPath", "getPagPath", "contentEquals", "", "other", "", "equals", "plugin-vlog_release"})
public final class e
  extends ac
{
  final String BZi;
  final String name;
  public final String yeY;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    super(b.ewh());
    AppMethodBeat.i(191334);
    this.name = paramString1;
    this.yeY = paramString2;
    this.BZi = paramString3;
    AppMethodBeat.o(191334);
  }
  
  public final boolean aS(Object paramObject)
  {
    AppMethodBeat.i(191333);
    if ((super.aS(paramObject)) && ((paramObject instanceof e)) && (p.i(((e)paramObject).yeY, this.yeY)) && (p.i(((e)paramObject).BZi, this.BZi)))
    {
      AppMethodBeat.o(191333);
      return true;
    }
    AppMethodBeat.o(191333);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191332);
    if ((super.equals(paramObject)) && ((paramObject instanceof e)) && (p.i(((e)paramObject).name, this.name)))
    {
      AppMethodBeat.o(191332);
      return true;
    }
    AppMethodBeat.o(191332);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.e
 * JD-Core Version:    0.7.0.1
 */