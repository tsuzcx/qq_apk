package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;

final class v$b
  extends AsyncTask<v.d, Integer, v.d>
  implements n.a
{
  private n pJK;
  v.d pJL;
  
  private v$b(v paramv) {}
  
  public final boolean b(v.d paramd)
  {
    AppMethodBeat.i(67995);
    if (!paramd.pJU.onReady())
    {
      AppMethodBeat.o(67995);
      return false;
    }
    this.pJL = paramd;
    super.execute(new v.d[] { paramd });
    AppMethodBeat.o(67995);
    return true;
  }
  
  public final void cdD()
  {
    AppMethodBeat.i(67996);
    publishProgress(new Integer[] { Integer.valueOf(0) });
    AppMethodBeat.o(67996);
  }
  
  protected final void onCancelled()
  {
    AppMethodBeat.i(67997);
    g.RM();
    g.RO().ac(new v.b.1(this));
    super.onCancelled();
    AppMethodBeat.o(67997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.b
 * JD-Core Version:    0.7.0.1
 */