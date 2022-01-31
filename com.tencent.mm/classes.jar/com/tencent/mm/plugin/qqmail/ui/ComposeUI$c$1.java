package com.tencent.mm.plugin.qqmail.ui;

import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import java.util.LinkedList;

final class ComposeUI$c$1
  implements Runnable
{
  ComposeUI$c$1(ComposeUI.c paramc) {}
  
  public final void run()
  {
    if ((!ComposeUI.e(this.ngX.ngJ).nik.isFocused()) && (!ComposeUI.f(this.ngX.ngJ).nik.isFocused()) && (ComposeUI.e(this.ngX.ngJ).getMailAddrs().size() == 0) && (ComposeUI.f(this.ngX.ngJ).getMailAddrs().size() == 0) && (ComposeUI.e(this.ngX.ngJ).buh()) && (ComposeUI.f(this.ngX.ngJ).buh()))
    {
      ComposeUI.z(this.ngX.ngJ).setVisibility(0);
      ComposeUI.A(this.ngX.ngJ).setVisibility(8);
      ComposeUI.B(this.ngX.ngJ).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.c.1
 * JD-Core Version:    0.7.0.1
 */