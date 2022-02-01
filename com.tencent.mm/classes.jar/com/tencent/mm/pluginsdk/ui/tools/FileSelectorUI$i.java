package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFavFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "cdnDataUrl", "", "getCdnDataUrl", "()Ljava/lang/String;", "setCdnDataUrl", "(Ljava/lang/String;)V", "dataId", "getDataId", "setDataId", "desc", "getDesc", "setDesc", "favTitle", "getFavTitle", "setFavTitle", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "clone", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FileSelectorUI$i
  extends FileSelectorUI.j
{
  String Ysv;
  String Ysw;
  String desc;
  public String hIQ;
  long localId;
  
  public FileSelectorUI$i()
  {
    super(localObject);
    AppMethodBeat.i(245716);
    AppMethodBeat.o(245716);
  }
  
  public final void brO(String paramString)
  {
    AppMethodBeat.i(245731);
    s.u(paramString, "<set-?>");
    this.hIQ = paramString;
    AppMethodBeat.o(245731);
  }
  
  public final String iOk()
  {
    AppMethodBeat.i(245723);
    String str = this.hIQ;
    if (str != null)
    {
      AppMethodBeat.o(245723);
      return str;
    }
    s.bIx("dataId");
    AppMethodBeat.o(245723);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.i
 * JD-Core Version:    0.7.0.1
 */