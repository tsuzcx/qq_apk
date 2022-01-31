package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Map;

final class MailWebViewUI$1
  extends v.a
{
  MailWebViewUI$1(MailWebViewUI paramMailWebViewUI) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(68393);
    MailWebViewUI.a(this.pOf).post(new MailWebViewUI.1.2(this, paramString));
    AppMethodBeat.o(68393);
  }
  
  public final void onSuccess(String paramString, Map paramMap)
  {
    AppMethodBeat.i(68392);
    MailWebViewUI.a(this.pOf).post(new MailWebViewUI.1.1(this, paramString));
    AppMethodBeat.o(68392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */