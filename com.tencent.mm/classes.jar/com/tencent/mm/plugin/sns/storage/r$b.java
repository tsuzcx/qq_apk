package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/SnsCoverStorage$SnsCoverClearTask;", "Ljava/lang/Runnable;", "paths", "", "", "([Ljava/lang/String;)V", "getPaths", "()[Ljava/lang/String;", "[Ljava/lang/String;", "run", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r$b
  implements Runnable
{
  private final String[] QYL;
  
  public r$b(String... paramVarArgs)
  {
    AppMethodBeat.i(306601);
    this.QYL = paramVarArgs;
    AppMethodBeat.o(306601);
  }
  
  public final void run()
  {
    AppMethodBeat.i(306604);
    String[] arrayOfString = this.QYL;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      r.a locala = r.QYI;
      Log.i(r.access$getTAG$cp(), "delete path:" + str + " size:" + y.bEl(str));
      y.deleteFile(str);
      i += 1;
    }
    AppMethodBeat.o(306604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.r.b
 * JD-Core Version:    0.7.0.1
 */