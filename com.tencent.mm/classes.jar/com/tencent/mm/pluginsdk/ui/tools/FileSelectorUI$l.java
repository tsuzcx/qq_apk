package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "from", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "getFrom", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "setFrom", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "getType", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "setType", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;)V", "app_release"})
public class FileSelectorUI$l
{
  FileSelectorUI.g Rwj = FileSelectorUI.g.RvQ;
  public FileSelectorUI.h Rwk;
  String title;
  
  public final void a(FileSelectorUI.g paramg)
  {
    AppMethodBeat.i(290692);
    p.k(paramg, "<set-?>");
    this.Rwj = paramg;
    AppMethodBeat.o(290692);
  }
  
  public final void d(FileSelectorUI.h paramh)
  {
    AppMethodBeat.i(290694);
    p.k(paramh, "<set-?>");
    this.Rwk = paramh;
    AppMethodBeat.o(290694);
  }
  
  public final FileSelectorUI.h hnv()
  {
    AppMethodBeat.i(290693);
    FileSelectorUI.h localh = this.Rwk;
    if (localh == null) {
      p.bGy("from");
    }
    AppMethodBeat.o(290693);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.l
 * JD-Core Version:    0.7.0.1
 */