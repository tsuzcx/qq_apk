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
    AppMethodBeat.i(197880);
    Object localObject = this.mContext.getCacheDir();
    if (localObject == null)
    {
      AppMethodBeat.o(197880);
      return;
    }
    localObject = new a(((File)localObject).listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        AppMethodBeat.i(197854);
        boolean bool = paramAnonymousString.startsWith(".org.chromium.Chromium.");
        AppMethodBeat.o(197854);
        return bool;
      }
    }));
    if (!((a)localObject).gjt())
    {
      AppMethodBeat.o(197880);
      return;
    }
    new Handler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197879);
        this.NaA.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        AppMethodBeat.o(197879);
      }
    }, 5000L);
    AppMethodBeat.o(197880);
  }
  
  static final class a
    extends AsyncTask<Void, Void, Void>
  {
    private final File[] NaB;
    
    a(File[] paramArrayOfFile)
    {
      this.NaB = paramArrayOfFile;
    }
    
    private void al(File paramFile)
    {
      AppMethodBeat.i(197877);
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          al(arrayOfFile[i]);
          i += 1;
        }
      }
      paramFile.delete();
      AppMethodBeat.o(197877);
    }
    
    final boolean gjt()
    {
      return (this.NaB != null) && (this.NaB.length > 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.b
 * JD-Core Version:    0.7.0.1
 */