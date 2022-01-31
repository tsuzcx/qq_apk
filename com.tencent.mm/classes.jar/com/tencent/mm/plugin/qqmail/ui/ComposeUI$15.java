package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.ui.base.h;
import java.util.Map;

final class ComposeUI$15
  extends v.a
{
  ComposeUI$15(ComposeUI paramComposeUI) {}
  
  public final void onComplete()
  {
    if (ComposeUI.G(this.ngJ) != null)
    {
      ComposeUI.G(this.ngJ).dismiss();
      ComposeUI.a(this.ngJ, null);
    }
  }
  
  public final void onError(int paramInt, String paramString)
  {
    if (paramInt == -5)
    {
      this.ngJ.ngi.a(new ComposeUI.15.2(this));
      return;
    }
    h.a(this.ngJ, paramString, this.ngJ.getString(b.j.plugin_qqmail_compose_send_error), null);
  }
  
  public final void onSuccess(String paramString, Map<String, String> paramMap)
  {
    h.a(this.ngJ, b.j.plugin_qqmail_compose_send_success, b.j.app_tip, new ComposeUI.15.1(this));
    ComposeUI.d(this.ngJ).ca(this.ngJ.nfP.getMailAddrs());
    ComposeUI.d(this.ngJ).ca(ComposeUI.e(this.ngJ).getMailAddrs());
    ComposeUI.d(this.ngJ).ca(ComposeUI.f(this.ngJ).getMailAddrs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.15
 * JD-Core Version:    0.7.0.1
 */