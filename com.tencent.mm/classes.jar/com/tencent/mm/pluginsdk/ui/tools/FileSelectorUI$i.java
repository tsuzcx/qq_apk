package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "displayFromUser", "", "getDisplayFromUser", "()Ljava/lang/CharSequence;", "setDisplayFromUser", "(Ljava/lang/CharSequence;)V", "fileLen", "", "getFileLen", "()I", "setFileLen", "(I)V", "fileName", "getFileName", "setFileName", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isDownloaded", "", "()Z", "setDownloaded", "(Z)V", "legalType", "getLegalType", "setLegalType", "msgId", "getMsgId", "setMsgId", "clone", "app_release"})
public class FileSelectorUI$i
  extends FileSelectorUI.k
{
  CharSequence KuS;
  public CharSequence KuT;
  int KuU;
  boolean KuV;
  long createTime;
  String filePath;
  long msgId;
  int zGp;
  
  public FileSelectorUI$i()
  {
    super(localFileSelectorUI);
  }
  
  public final void am(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(231103);
    p.h(paramCharSequence, "<set-?>");
    this.KuT = paramCharSequence;
    AppMethodBeat.o(231103);
  }
  
  public final CharSequence gsq()
  {
    AppMethodBeat.i(231102);
    CharSequence localCharSequence = this.KuT;
    if (localCharSequence == null) {
      p.btv("fileName");
    }
    AppMethodBeat.o(231102);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.i
 * JD-Core Version:    0.7.0.1
 */