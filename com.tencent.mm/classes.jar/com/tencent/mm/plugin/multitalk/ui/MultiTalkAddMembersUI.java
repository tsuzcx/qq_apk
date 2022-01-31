package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.ui.widget.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;

public class MultiTalkAddMembersUI
  extends MultiTalkSelectContactUI
{
  protected final void initView()
  {
    super.initView();
    this.mbR.setBackgroundResource(a.b.default_bg_color);
    this.mbR.setPadding(b.mvw, b.mvw, b.mvw, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI
 * JD-Core Version:    0.7.0.1
 */