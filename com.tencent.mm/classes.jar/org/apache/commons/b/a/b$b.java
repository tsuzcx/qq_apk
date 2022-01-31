package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.h;

final class b$b
  extends b
{
  b$b()
  {
    AppMethodBeat.i(142937);
    this.pLF = "[";
    String str2 = h.LINE_SEPARATOR + "  ";
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.CRa = str1;
    this.CQY = true;
    azN(h.LINE_SEPARATOR + "]");
    AppMethodBeat.o(142937);
  }
  
  private Object readResolve()
  {
    return b.CQO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */