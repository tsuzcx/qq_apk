package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "from", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "getFrom", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "setFrom", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "getType", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "setType", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;)V", "app_release"})
public class FileSelectorUI$k
{
  FileSelectorUI.f KuY = FileSelectorUI.f.KuH;
  public FileSelectorUI.g KuZ;
  String title;
  
  public final void a(FileSelectorUI.f paramf)
  {
    AppMethodBeat.i(231104);
    p.h(paramf, "<set-?>");
    this.KuY = paramf;
    AppMethodBeat.o(231104);
  }
  
  public final void d(FileSelectorUI.g paramg)
  {
    AppMethodBeat.i(231106);
    p.h(paramg, "<set-?>");
    this.KuZ = paramg;
    AppMethodBeat.o(231106);
  }
  
  public final FileSelectorUI.g gsr()
  {
    AppMethodBeat.i(231105);
    FileSelectorUI.g localg = this.KuZ;
    if (localg == null) {
      p.btv("from");
    }
    AppMethodBeat.o(231105);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.k
 * JD-Core Version:    0.7.0.1
 */