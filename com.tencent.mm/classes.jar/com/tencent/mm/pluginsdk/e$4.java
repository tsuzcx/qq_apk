package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class e$4
  implements e.a
{
  e$4(ProgressDialog paramProgressDialog, Context paramContext) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(11658);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    if ((this.vJx != null) && (this.vJx.isShowing())) {
      this.vJx.dismiss();
    }
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof com.tencent.mm.modelsimple.ab)))
    {
      paramString = ((com.tencent.mm.modelsimple.ab)paramm).ajY();
      if ((paramString != null) && (this.val$context != null)) {
        t.makeText(this.val$context, this.val$context.getString(2131297087) + " : " + bo.nullAsNil(paramString.xVH), 0).show();
      }
    }
    AppMethodBeat.o(11658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.4
 * JD-Core Version:    0.7.0.1
 */