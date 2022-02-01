package io.flutter.embedding.engine.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

final class b
{
  private static final String[] SUPPORTED_ABIS;
  
  static
  {
    AppMethodBeat.i(215011);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = Build.SUPPORTED_ABIS;; localObject = (String[])((ArrayList)localObject).toArray(new String[0]))
    {
      SUPPORTED_ABIS = (String[])localObject;
      AppMethodBeat.o(215011);
      return;
      localObject = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
      ((ArrayList)localObject).removeAll(Arrays.asList(new String[] { null, "" }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.embedding.engine.a.b
 * JD-Core Version:    0.7.0.1
 */