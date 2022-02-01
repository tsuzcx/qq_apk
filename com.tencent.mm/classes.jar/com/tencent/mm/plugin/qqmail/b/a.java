package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.e.b;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.r;
import java.util.concurrent.ExecutorService;

public class a
  extends r<Bundle, Integer, Bundle>
{
  public Bundle a(Bundle... paramVarArgs)
  {
    return null;
  }
  
  public final ExecutorService fsl()
  {
    AppMethodBeat.i(250419);
    b localb = h.ZvG.bDi("MailDownloadAsyncTask");
    AppMethodBeat.o(250419);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */