package com.tencent.mm.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings;

final class MMAppMgr$12
  extends ClickableSpan
{
  MMAppMgr$12(Activity paramActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33414);
    Util.jump(this.dnO, WeChatBrands.Wordings.translate(MMApplicationContext.getResources().getString(2131762219, new Object[] { LocaleUtil.getCurrentLanguage(this.dnO), LocaleUtil.getCurrentCountryCode(), "setting", Integer.valueOf(0), Integer.valueOf(0) })));
    AppMethodBeat.o(33414);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(33415);
    paramTextPaint.setColor(this.dnO.getResources().getColor(2131100685));
    AppMethodBeat.o(33415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.12
 * JD-Core Version:    0.7.0.1
 */