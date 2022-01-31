package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class ag
{
  public static List<String> Nn()
  {
    AppMethodBeat.i(29925);
    int i = r.Zr();
    ArrayList localArrayList = new ArrayList();
    if ((i & 0x8000) == 0)
    {
      localArrayList.add("floatbottle");
      ab.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
    }
    aw.aaz();
    if (!c.Ru().getBoolean(ac.a.yDB, true))
    {
      localArrayList.add("notifymessage");
      ab.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
    }
    aw.aaz();
    if (!c.Ru().getBoolean(ac.a.yDC, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      ab.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
    }
    ab.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(29925);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ag
 * JD-Core Version:    0.7.0.1
 */