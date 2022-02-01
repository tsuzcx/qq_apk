package io.flutter.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class a
{
  public static String ly(Context paramContext)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.b.a
 * JD-Core Version:    0.7.0.1
 */