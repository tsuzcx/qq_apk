package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "displayFromUser", "", "getDisplayFromUser", "()Ljava/lang/CharSequence;", "setDisplayFromUser", "(Ljava/lang/CharSequence;)V", "fileLen", "getFileLen", "setFileLen", "fileName", "getFileName", "setFileName", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isDownloaded", "", "()Z", "setDownloaded", "(Z)V", "legalType", "", "getLegalType", "()I", "setLegalType", "(I)V", "msgId", "getMsgId", "setMsgId", "clone", "", "des", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FileSelectorUI$j
  extends FileSelectorUI.l
{
  int YsA;
  boolean YsB;
  CharSequence Ysx;
  public CharSequence Ysy;
  long Ysz;
  long createTime;
  String filePath;
  long msgId;
  
  public FileSelectorUI$j()
  {
    super(localObject);
    AppMethodBeat.i(245721);
    AppMethodBeat.o(245721);
  }
  
  public final void aO(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(245734);
    s.u(paramCharSequence, "<set-?>");
    this.Ysy = paramCharSequence;
    AppMethodBeat.o(245734);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(245745);
    s.u(paramj, "des");
    paramj.a(this.YsE);
    paramj.title = this.title;
    paramj.d(iOn());
    paramj.msgId = this.msgId;
    paramj.createTime = this.createTime;
    paramj.Ysx = this.Ysx;
    paramj.aO(iOm());
    paramj.filePath = this.filePath;
    paramj.Ysz = this.Ysz;
    paramj.YsA = this.YsA;
    paramj.YsB = this.YsB;
    AppMethodBeat.o(245745);
  }
  
  public j iOl()
  {
    AppMethodBeat.i(245740);
    j localj = new j(this.YrS);
    b(localj);
    AppMethodBeat.o(245740);
    return localj;
  }
  
  public final CharSequence iOm()
  {
    AppMethodBeat.i(245727);
    CharSequence localCharSequence = this.Ysy;
    if (localCharSequence != null)
    {
      AppMethodBeat.o(245727);
      return localCharSequence;
    }
    s.bIx("fileName");
    AppMethodBeat.o(245727);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.j
 * JD-Core Version:    0.7.0.1
 */