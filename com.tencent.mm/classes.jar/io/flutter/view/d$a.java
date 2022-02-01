package io.flutter.view;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class d$a
  extends AsyncTask<Void, Void, Void>
{
  final File[] JfB;
  
  d$a(File[] paramArrayOfFile)
  {
    this.JfB = paramArrayOfFile;
  }
  
  private void ag(File paramFile)
  {
    AppMethodBeat.i(9694);
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        ag(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
    AppMethodBeat.o(9694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.view.d.a
 * JD-Core Version:    0.7.0.1
 */