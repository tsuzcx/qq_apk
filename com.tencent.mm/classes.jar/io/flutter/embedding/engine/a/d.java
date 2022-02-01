package io.flutter.embedding.engine.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

final class d
{
  private static final String[] aarB;
  
  static
  {
    AppMethodBeat.i(255236);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = Build.SUPPORTED_ABIS;; localObject = (String[])((ArrayList)localObject).toArray(new String[0]))
    {
      aarB = (String[])localObject;
      AppMethodBeat.o(255236);
      return;
      localObject = new ArrayList(Arrays.asList(new String[] { Build.CPU_ABI, Build.CPU_ABI2 }));
      ((ArrayList)localObject).removeAll(Arrays.asList(new String[] { null, "" }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.a.d
 * JD-Core Version:    0.7.0.1
 */