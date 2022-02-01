package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.f.b;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.n;
import java.util.concurrent.ExecutorService;

public class a
  extends n<Bundle, Integer, Bundle>
{
  public Bundle a(Bundle... paramVarArgs)
  {
    return null;
  }
  
  public final ExecutorService eGk()
  {
    AppMethodBeat.i(198569);
    b localb = h.RTc.bqp("MailDownloadAsyncTask");
    AppMethodBeat.o(198569);
    return localb;
  }
  
  public static abstract interface a
  {
    public abstract void onProgress(int paramInt);
    
    public abstract void onResult(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */