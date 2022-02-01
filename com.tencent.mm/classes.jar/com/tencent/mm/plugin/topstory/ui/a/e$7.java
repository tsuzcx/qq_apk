package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.r.a;
import com.tencent.mm.br.c;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;

final class e$7
  implements r.a
{
  e$7(e parame, WeakReference paramWeakReference) {}
  
  public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(236409);
    paramString1 = (Context)this.GqB.get();
    if (paramString1 == null)
    {
      AppMethodBeat.o(236409);
      return;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (s.YS(paramString2)))
    {
      paramBitmap = new Intent();
      paramBitmap.putExtra("sns_kemdia_path", paramString2);
      paramBitmap.putExtra("KFilterId", -1);
      paramBitmap.putExtra("Ksnsupload_source", 1);
      paramBitmap.putExtra("KBlockAdd", true);
      c.b(paramString1, "sns", ".ui.SnsUploadUI", paramBitmap);
    }
    AppMethodBeat.o(236409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.e.7
 * JD-Core Version:    0.7.0.1
 */