package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d;

public final class h<T>
  extends d<T>
{
  static final boolean akdF;
  
  static
  {
    AppMethodBeat.i(90227);
    akdF = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    AppMethodBeat.o(90227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.util.h
 * JD-Core Version:    0.7.0.1
 */