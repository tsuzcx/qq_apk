package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "name", "", "pagPath", "pagIconPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPagIconPath", "getPagPath", "contentEquals", "", "other", "", "equals", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends ae
{
  public final String LWN;
  final String Ucg;
  final String name;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    super(b.hRI());
    AppMethodBeat.i(283683);
    this.name = paramString1;
    this.LWN = paramString2;
    this.Ucg = paramString3;
    AppMethodBeat.o(283683);
  }
  
  public final boolean cv(Object paramObject)
  {
    AppMethodBeat.i(283697);
    if ((super.cv(paramObject)) && ((paramObject instanceof e)) && (s.p(((e)paramObject).LWN, this.LWN)) && (s.p(((e)paramObject).Ucg, this.Ucg)))
    {
      AppMethodBeat.o(283697);
      return true;
    }
    AppMethodBeat.o(283697);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(283689);
    if ((super.equals(paramObject)) && ((paramObject instanceof e)) && (s.p(((e)paramObject).name, this.name)))
    {
      AppMethodBeat.o(283689);
      return true;
    }
    AppMethodBeat.o(283689);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.e
 * JD-Core Version:    0.7.0.1
 */