package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;

public class MultiTalkAddMembersUI
  extends MultiTalkSelectContactUI
{
  public void initView()
  {
    AppMethodBeat.i(54117);
    super.initView();
    this.oCs.setBackgroundResource(2131689926);
    MultiSelectContactView localMultiSelectContactView = this.oCs;
    int i = b.oVo;
    localMultiSelectContactView.setPadding(i, i, b.oVo, 0);
    AppMethodBeat.o(54117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI
 * JD-Core Version:    0.7.0.1
 */