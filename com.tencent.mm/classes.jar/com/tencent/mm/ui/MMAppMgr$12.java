package com.tencent.mm.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class MMAppMgr$12
  extends ClickableSpan
{
  MMAppMgr$12(Activity paramActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153817);
    bo.M(this.gjR, ah.getResources().getString(2131306182, new Object[] { aa.gP(this.gjR), aa.dsF(), "setting", Integer.valueOf(0), Integer.valueOf(0) }));
    AppMethodBeat.o(153817);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(153818);
    paramTextPaint.setColor(this.gjR.getResources().getColor(2131690214));
    AppMethodBeat.o(153818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.12
 * JD-Core Version:    0.7.0.1
 */