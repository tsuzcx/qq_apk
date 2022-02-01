package io.flutter.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class PathUtils
{
  public static String getCacheDirectory(Context paramContext)
  {
    AppMethodBeat.i(9593);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = paramContext.getCodeCacheDir().getPath();
      AppMethodBeat.o(9593);
      return paramContext;
    }
    paramContext = paramContext.getCacheDir().getPath();
    AppMethodBeat.o(9593);
    return paramContext;
  }
  
  public static String getDataDirectory(Context paramContext)
  {
    AppMethodBeat.i(189557);
    paramContext = paramContext.getDir("flutter", 0).getPath();
    AppMethodBeat.o(189557);
    return paramContext;
  }
  
  public static String getFilesDir(Context paramContext)
  {
    AppMethodBeat.i(189548);
    paramContext = paramContext.getFilesDir().getPath();
    AppMethodBeat.o(189548);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.util.PathUtils
 * JD-Core Version:    0.7.0.1
 */