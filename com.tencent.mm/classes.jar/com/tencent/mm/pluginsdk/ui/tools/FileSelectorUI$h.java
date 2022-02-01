package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFavFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "cdnDataUrl", "", "getCdnDataUrl", "()Ljava/lang/String;", "setCdnDataUrl", "(Ljava/lang/String;)V", "dataId", "getDataId", "setDataId", "desc", "getDesc", "setDesc", "favTitle", "getFavTitle", "setFavTitle", "localId", "", "getLocalId", "()J", "setLocalId", "(J)V", "app_release"})
public final class FileSelectorUI$h
  extends FileSelectorUI.i
{
  String KuQ;
  String KuR;
  public String dLl;
  String desc;
  long localId;
  
  public FileSelectorUI$h()
  {
    super(localFileSelectorUI);
  }
  
  public final String gsp()
  {
    AppMethodBeat.i(231101);
    String str = this.dLl;
    if (str == null) {
      p.btv("dataId");
    }
    AppMethodBeat.o(231101);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.h
 * JD-Core Version:    0.7.0.1
 */