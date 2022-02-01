package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;

final class s$1
  implements p.a
{
  s$1(Context paramContext) {}
  
  public final void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204063);
    Toast.makeText(this.val$context, this.val$context.getString(2131761762, new Object[] { paramString2 }), 1).show();
    AppMethodBeat.o(204063);
  }
  
  public final void bQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204064);
    Toast.makeText(this.val$context, this.val$context.getString(2131764864), 1).show();
    AppMethodBeat.o(204064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.s.1
 * JD-Core Version:    0.7.0.1
 */