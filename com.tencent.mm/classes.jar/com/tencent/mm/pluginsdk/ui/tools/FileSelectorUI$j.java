package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "displayFromUser", "", "getDisplayFromUser", "()Ljava/lang/CharSequence;", "setDisplayFromUser", "(Ljava/lang/CharSequence;)V", "fileLen", "getFileLen", "setFileLen", "fileName", "getFileName", "setFileName", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isDownloaded", "", "()Z", "setDownloaded", "(Z)V", "legalType", "", "getLegalType", "()I", "setLegalType", "(I)V", "msgId", "getMsgId", "setMsgId", "clone", "", "des", "app_release"})
public class FileSelectorUI$j
  extends FileSelectorUI.l
{
  CharSequence Rwc;
  public CharSequence Rwd;
  long Rwe;
  int Rwf;
  boolean Rwg;
  long createTime;
  String filePath;
  long msgId;
  
  public FileSelectorUI$j()
  {
    super(localFileSelectorUI);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(285473);
    p.k(paramj, "des");
    paramj.a(this.Rwj);
    paramj.title = this.title;
    paramj.d(hnv());
    paramj.msgId = this.msgId;
    paramj.createTime = this.createTime;
    paramj.Rwc = this.Rwc;
    CharSequence localCharSequence = this.Rwd;
    if (localCharSequence == null) {
      p.bGy("fileName");
    }
    paramj.Rwd = localCharSequence;
    paramj.filePath = this.filePath;
    paramj.Rwe = this.Rwe;
    paramj.Rwf = this.Rwf;
    paramj.Rwg = this.Rwg;
    AppMethodBeat.o(285473);
  }
  
  public final void aA(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(285471);
    p.k(paramCharSequence, "<set-?>");
    this.Rwd = paramCharSequence;
    AppMethodBeat.o(285471);
  }
  
  public j hnt()
  {
    AppMethodBeat.i(285472);
    j localj = new j(this.Rvw);
    a(localj);
    AppMethodBeat.o(285472);
    return localj;
  }
  
  public final CharSequence hnu()
  {
    AppMethodBeat.i(285470);
    CharSequence localCharSequence = this.Rwd;
    if (localCharSequence == null) {
      p.bGy("fileName");
    }
    AppMethodBeat.o(285470);
    return localCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.j
 * JD-Core Version:    0.7.0.1
 */