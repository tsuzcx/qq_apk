package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "from", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "getFrom", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "setFrom", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "getType", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "setType", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FileSelectorUI$l
{
  FileSelectorUI.g YsE;
  public FileSelectorUI.h YsF;
  String title;
  
  public FileSelectorUI$l()
  {
    AppMethodBeat.i(245717);
    this.YsE = FileSelectorUI.g.Ysl;
    AppMethodBeat.o(245717);
  }
  
  public final void a(FileSelectorUI.g paramg)
  {
    AppMethodBeat.i(245722);
    s.u(paramg, "<set-?>");
    this.YsE = paramg;
    AppMethodBeat.o(245722);
  }
  
  public final void d(FileSelectorUI.h paramh)
  {
    AppMethodBeat.i(245735);
    s.u(paramh, "<set-?>");
    this.YsF = paramh;
    AppMethodBeat.o(245735);
  }
  
  public final FileSelectorUI.h iOn()
  {
    AppMethodBeat.i(245728);
    FileSelectorUI.h localh = this.YsF;
    if (localh != null)
    {
      AppMethodBeat.o(245728);
      return localh;
    }
    s.bIx("from");
    AppMethodBeat.o(245728);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.l
 * JD-Core Version:    0.7.0.1
 */