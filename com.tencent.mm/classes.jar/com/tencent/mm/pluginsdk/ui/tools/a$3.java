package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.x.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;

final class a$3
  implements f.c
{
  a$3(Activity paramActivity) {}
  
  public final void e(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(184243);
    if (paramBoolean)
    {
      paramString = new f.a(this.val$activity).bow(this.val$activity.getString(2131766648));
      paramString.JnN = true;
      paramString.apa(2131755873).b(new f.c()
      {
        public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(184242);
          x.a.zK(true);
          AppMethodBeat.o(184242);
        }
      }).show();
    }
    AppMethodBeat.o(184243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a.3
 * JD-Core Version:    0.7.0.1
 */