package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFavFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "cdnDataUrl", "", "getCdnDataUrl", "()Ljava/lang/String;", "setCdnDataUrl", "(Ljava/lang/String;)V", "dataId", "getDataId", "setDataId", "desc", "getDesc", "setDesc", "favTitle", "getFavTitle", "setFavTitle", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "clone", "app_release"})
public final class FileSelectorUI$i
  extends FileSelectorUI.j
{
  String Rwa;
  String Rwb;
  String desc;
  public String fEa;
  long localId;
  
  public FileSelectorUI$i()
  {
    super(localFileSelectorUI);
  }
  
  public final String hns()
  {
    AppMethodBeat.i(282508);
    String str = this.fEa;
    if (str == null) {
      p.bGy("dataId");
    }
    AppMethodBeat.o(282508);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.i
 * JD-Core Version:    0.7.0.1
 */