package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class a
  implements e
{
  private static String TAG = "MicroMsg.AppBrandConversationService";
  
  private static void a(az paramaz1, az paramaz2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(232737);
    Object localObject2 = ((l)g.af(l.class)).aST().c(ab.iCL, null, "appbrandcustomerservicemsg");
    Object localObject1;
    if (localObject2 != null) {
      if ((((Cursor)localObject2).getCount() > 0) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject1 = new az();
        ((az)localObject1).convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
      }
    }
    for (localObject2 = localObject1;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        Log.e(TAG, "The lastest app brand conversation username is %s", new Object[] { ((bb)localObject2).field_username });
        localObject1 = ((l)g.af(l.class)).eiy().aEx(((bb)localObject2).field_username);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((eo)localObject1).field_msgId > 0L))
        {
          paramaz2.aX((ca)localObject1);
          paramaz2.setContent(((eo)localObject1).field_talker + ":" + ((eo)localObject1).field_content);
          paramaz2.Cl(Integer.toString(((ca)localObject1).getType()));
          bw.b localb = ((l)g.af(l.class)).aST().Xh();
          PString localPString1;
          PInt localPInt;
          if (localb != null)
          {
            PString localPString2 = new PString();
            localPString1 = new PString();
            localPInt = new PInt();
            if (localObject2 == null) {
              break label417;
            }
            ((ca)localObject1).Cy(((bb)localObject2).field_parentRef);
            label260:
            ((ca)localObject1).setContent(paramaz2.field_content);
            localb.a((ca)localObject1, localPString2, localPString1, localPInt, true);
            int i = ((ca)localObject1).getType();
            localObject1 = ((eo)localObject1).field_content;
            paramaz1 = localObject3;
            if (!Util.isNullOrNil((String)localObject1)) {}
            switch (i)
            {
            default: 
              paramaz1 = localObject3;
              label327:
              localObject1 = Util.nullAsNil(localPString2.value);
              if (!Util.isNullOrNil(paramaz1)) {
                break;
              }
            }
          }
          for (paramaz1 = "";; paramaz1 = " " + Util.nullAsNil(paramaz1))
          {
            paramaz2.Cm(((String)localObject1).concat(paramaz1));
            paramaz2.Cn(localPString1.value);
            paramaz2.nw(localPInt.value);
            AppMethodBeat.o(232737);
            return;
            if (paramaz1 == null) {
              break label519;
            }
            Log.e(TAG, "The lastest app brand conversation is null");
            localObject1 = ((l)g.af(l.class)).eiy().aEx(paramaz1.field_username);
            break;
            label417:
            if (paramaz1 == null) {
              break label260;
            }
            ((ca)localObject1).Cy(paramaz1.field_parentRef);
            break label260;
            localObject1 = XmlParser.parseXml((String)localObject1, "msg", null);
            paramaz1 = localObject3;
            if (localObject1 == null) {
              break label327;
            }
            paramaz1 = (String)((Map)localObject1).get(".msg.appmsg.title");
            Log.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramaz1 });
            break label327;
          }
        }
        Log.e(TAG, "the last of msg is null'");
        paramaz2.gCr();
        AppMethodBeat.o(232737);
        return;
        label519:
        localObject1 = null;
      }
      localObject1 = null;
      break;
    }
  }
  
  public final boolean bVr()
  {
    AppMethodBeat.i(232736);
    if (((l)g.af(l.class)).aST().bjY("appbrandcustomerservicemsg") == null)
    {
      AppMethodBeat.o(232736);
      return false;
    }
    AppMethodBeat.o(232736);
    return true;
  }
  
  public final void c(az paramaz)
  {
    AppMethodBeat.i(232738);
    az localaz = ((l)g.af(l.class)).aST().bjY("appbrandcustomerservicemsg");
    if (localaz == null)
    {
      Log.i(TAG, "create parentConv");
      localaz = new az("appbrandcustomerservicemsg");
      localaz.gCr();
      a(paramaz, localaz);
      ((l)g.af(l.class)).aST().e(localaz);
      AppMethodBeat.o(232738);
      return;
    }
    Log.i(TAG, "appBrandSuperConv is created");
    localaz.Co(null);
    a(paramaz, localaz);
    ((l)g.af(l.class)).aST().a(localaz, "appbrandcustomerservicemsg");
    AppMethodBeat.o(232738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */