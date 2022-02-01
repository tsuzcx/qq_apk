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
    AppMethodBeat.i(192849);
    Object localObject = this.mContext.getCacheDir();
    if (localObject == null)
    {
      AppMethodBeat.o(192849);
      return;
    }
    localObject = new a(((File)localObject).listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(192823);
        boolean bool = paramAnonymousString.startsWith(".org.chromium.Chromium.");
        AppMethodBeat.o(192823);
        return bool;
      }
    }));
    if (!((a)localObject).fNs())
    {
      AppMethodBeat.o(192849);
      return;
    }
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192848);
        this.KMy.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        AppMethodBeat.o(192848);
      }
    }, 5000L);
    AppMethodBeat.o(192849);
  }
  
  static final class a
    extends AsyncTask<Void, Void, Void>
  {
    private final File[] KMz;
    
    a(File[] paramArrayOfFile)
    {
      this.KMz = paramArrayOfFile;
    }
    
    private void ak(File paramFile)
    {
      AppMethodBeat.i(192846);
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          ak(arrayOfFile[i]);
          i += 1;
        }
      }
      paramFile.delete();
      AppMethodBeat.o(192846);
    }
    
    final boolean fNs()
    {
      return (this.KMz != null) && (this.KMz.length > 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.b
 * JD-Core Version:    0.7.0.1
 */