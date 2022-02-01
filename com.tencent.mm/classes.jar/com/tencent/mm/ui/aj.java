package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.List;

public final class aj
{
  public static List<String> Za()
  {
    AppMethodBeat.i(33782);
    int i = u.aqK();
    ArrayList localArrayList = new ArrayList();
    if ((i & 0x8000) == 0)
    {
      localArrayList.add("floatbottle");
      ad.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
    }
    az.arV();
    if (!c.afk().getBoolean(ae.a.FlZ, true))
    {
      localArrayList.add("notifymessage");
      ad.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
    }
    az.arV();
    if (!c.afk().getBoolean(ae.a.Fma, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      ad.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    ad.d("MicroMsg.UnreadCountHelper", "add appbrand notify message into show unread count blacklist.");
    ad.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", new Object[] { Integer.valueOf(localArrayList.size()) });
    AppMethodBeat.o(33782);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.aj
 * JD-Core Version:    0.7.0.1
 */