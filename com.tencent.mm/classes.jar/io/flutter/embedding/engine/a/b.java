package io.flutter.embedding.engine.a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

final class b
{
  private final Context mContext;
  
  b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  final void start()
  {
    AppMethodBeat.i(213298);
    Object localObject = this.mContext.getCacheDir();
    if (localObject == null)
    {
      AppMethodBeat.o(213298);
      return;
    }
    localObject = new a(((File)localObject).listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(213272);
        boolean bool = paramAnonymousString.startsWith(".org.chromium.Chromium.");
        AppMethodBeat.o(213272);
        return bool;
      }
    }));
    if (!((a)localObject).geR())
    {
      AppMethodBeat.o(213298);
      return;
    }
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213297);
        this.MDv.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        AppMethodBeat.o(213297);
      }
    }, 5000L);
    AppMethodBeat.o(213298);
  }
  
  static final class a
    extends AsyncTask<Void, Void, Void>
  {
    private final File[] MDw;
    
    a(File[] paramArrayOfFile)
    {
      this.MDw = paramArrayOfFile;
    }
    
    private void am(File paramFile)
    {
      AppMethodBeat.i(213295);
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          am(arrayOfFile[i]);
          i += 1;
        }
      }
      paramFile.delete();
      AppMethodBeat.o(213295);
    }
    
    final boolean geR()
    {
      return (this.MDw != null) && (this.MDw.length > 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.b
 * JD-Core Version:    0.7.0.1
 */