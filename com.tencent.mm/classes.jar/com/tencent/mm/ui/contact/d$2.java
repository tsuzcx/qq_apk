package com.tencent.mm.ui.contact;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.applet.b.b;

final class d$2
  implements b.b
{
  d$2(d paramd) {}
  
  public final int WL()
  {
    return this.vKc.getCount();
  }
  
  public final String jX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.vKc.getCount()))
    {
      y.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
      return null;
    }
    ad localad = (ad)this.vKc.getItem(paramInt);
    if (localad == null) {
      return null;
    }
    return localad.field_username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d.2
 * JD-Core Version:    0.7.0.1
 */