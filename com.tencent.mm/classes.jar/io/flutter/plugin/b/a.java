package io.flutter.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

final class a
{
  final FlutterJNI SNV;
  
  public a(FlutterJNI paramFlutterJNI)
  {
    this.SNV = paramFlutterJNI;
  }
  
  public static boolean atA(int paramInt)
  {
    return ((48 <= paramInt) && (paramInt <= 57)) || (paramInt == 35) || (paramInt == 42);
  }
  
  public final boolean atx(int paramInt)
  {
    AppMethodBeat.i(214906);
    boolean bool = this.SNV.nativeFlutterTextUtilsIsEmoji(paramInt);
    AppMethodBeat.o(214906);
    return bool;
  }
  
  public final boolean aty(int paramInt)
  {
    AppMethodBeat.i(214907);
    boolean bool = this.SNV.nativeFlutterTextUtilsIsVariationSelector(paramInt);
    AppMethodBeat.o(214907);
    return bool;
  }
  
  public final boolean atz(int paramInt)
  {
    AppMethodBeat.i(214908);
    boolean bool = this.SNV.nativeFlutterTextUtilsIsRegionalIndicator(paramInt);
    AppMethodBeat.o(214908);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */