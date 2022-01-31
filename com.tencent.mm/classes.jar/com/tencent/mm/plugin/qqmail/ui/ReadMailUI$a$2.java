package com.tencent.mm.plugin.qqmail.ui;

import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.j;

final class ReadMailUI$a$2
  implements Runnable
{
  ReadMailUI$a$2(ReadMailUI.a parama) {}
  
  public final void run()
  {
    ReadMailUI.h(this.njU.njK).setEnabled(false);
    ReadMailUI.h(this.njU.njK).setText(b.j.readmail_set_unreaded);
    ReadMailUI.h(this.njU.njK).setTextColor(-7829368);
    ReadMailUI.h(this.njU.njK).setCompoundDrawablesWithIntrinsicBounds(a.g(this.njU.njK, b.e.set_unread_icon), null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a.2
 * JD-Core Version:    0.7.0.1
 */