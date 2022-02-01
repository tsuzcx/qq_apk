package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.threadpool.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.ExecutorService;

public class a
  extends t<Bundle, Integer, Bundle>
{
  public Bundle a(Bundle... paramVarArgs)
  {
    return null;
  }
  
  public final ExecutorService gDT()
  {
    AppMethodBeat.i(266905);
    b localb = h.ahAA.bFR("MailDownloadAsyncTask");
    AppMethodBeat.o(266905);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */