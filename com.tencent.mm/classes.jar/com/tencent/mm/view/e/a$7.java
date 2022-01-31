package com.tencent.mm.view.e;

import android.text.TextUtils;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;

final class a$7
  implements j.a
{
  a$7(a parama) {}
  
  public final void a(String paramString, l paraml)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.equals("event_update_group")) || (paramString.equalsIgnoreCase("productID"))))
    {
      y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
      this.wzg.cLR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.e.a.7
 * JD-Core Version:    0.7.0.1
 */