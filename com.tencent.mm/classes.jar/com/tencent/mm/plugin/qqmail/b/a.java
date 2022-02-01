package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.e.b;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.m;
import java.util.concurrent.ExecutorService;

public class a
  extends m<Bundle, Integer, Bundle>
{
  public Bundle a(Bundle... paramVarArgs)
  {
    return null;
  }
  
  public final ExecutorService dCe()
  {
    AppMethodBeat.i(215169);
    b localb = h.LTJ.aZA("MailDownloadAsyncTask");
    AppMethodBeat.o(215169);
    return localb;
  }
  
  public static abstract interface a
  {
    public abstract void onProgress(int paramInt);
    
    public abstract void onResult(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.a
 * JD-Core Version:    0.7.0.1
 */