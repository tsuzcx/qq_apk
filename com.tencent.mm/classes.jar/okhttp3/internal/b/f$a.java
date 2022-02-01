package okhttp3.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import okhttp3.ab;

public final class f$a
{
  int ajPA = 0;
  final List<ab> ajPz;
  
  f$a(List<ab> paramList)
  {
    this.ajPz = paramList;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(186835);
    if (this.ajPA < this.ajPz.size())
    {
      AppMethodBeat.o(186835);
      return true;
    }
    AppMethodBeat.o(186835);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     okhttp3.internal.b.f.a
 * JD-Core Version:    0.7.0.1
 */