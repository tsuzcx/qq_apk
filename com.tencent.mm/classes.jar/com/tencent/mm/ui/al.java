package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class al
{
  public static List<String> cAh()
  {
    int i = q.Gn();
    ArrayList localArrayList = new ArrayList();
    if ((i & 0x8000) == 0)
    {
      localArrayList.add("floatbottle");
      y.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
    }
    au.Hx();
    if (!c.Dz().getBoolean(ac.a.uty, true))
    {
      localArrayList.add("notifymessage");
      y.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
    }
    au.Hx();
    if (!c.Dz().getBoolean(ac.a.utz, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      y.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
    }
    y.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.al
 * JD-Core Version:    0.7.0.1
 */