package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;

final class q$1
  implements p.a
{
  q$1(Context paramContext) {}
  
  public final void bF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213203);
    Toast.makeText(this.val$context, this.val$context.getString(2131760319, new Object[] { paramString2 }), 1).show();
    AppMethodBeat.o(213203);
  }
  
  public final void bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213204);
    Toast.makeText(this.val$context, this.val$context.getString(2131762779), 1).show();
    AppMethodBeat.o(213204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.q.1
 * JD-Core Version:    0.7.0.1
 */