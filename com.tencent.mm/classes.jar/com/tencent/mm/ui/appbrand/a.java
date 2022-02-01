package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
    AppMethodBeat.i(273500);
    Object localObject2 = ((n)h.ae(n.class)).bbR().a(4, null, "appbrandcustomerservicemsg");
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
        localObject1 = ((n)h.ae(n.class)).eSe().aOH(((bb)localObject2).field_username);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((et)localObject1).field_msgId > 0L))
        {
          paramaz2.bq((ca)localObject1);
          paramaz2.setContent(((et)localObject1).field_talker + ":" + ((et)localObject1).field_content);
          paramaz2.IZ(Integer.toString(((ca)localObject1).getType()));
          bw.b localb = ((n)h.ae(n.class)).bbR().abK();
          PString localPString1;
          PInt localPInt;
          if (localb != null)
          {
            PString localPString2 = new PString();
            localPString1 = new PString();
            localPInt = new PInt();
            if (localObject2 == null) {
              break label413;
            }
            ((ca)localObject1).Jm(((bb)localObject2).field_parentRef);
            label258:
            ((ca)localObject1).setContent(paramaz2.field_content);
            localb.a((ca)localObject1, localPString2, localPString1, localPInt, true);
            int i = ((ca)localObject1).getType();
            localObject1 = ((et)localObject1).field_content;
            paramaz1 = localObject3;
            if (!Util.isNullOrNil((String)localObject1)) {}
            switch (i)
            {
            default: 
              paramaz1 = localObject3;
              label323:
              localObject1 = Util.nullAsNil(localPString2.value);
              if (!Util.isNullOrNil(paramaz1)) {
                break;
              }
            }
          }
          for (paramaz1 = "";; paramaz1 = " " + Util.nullAsNil(paramaz1))
          {
            paramaz2.Ja(((String)localObject1).concat(paramaz1));
            paramaz2.Jb(localPString1.value);
            paramaz2.pK(localPInt.value);
            AppMethodBeat.o(273500);
            return;
            if (paramaz1 == null) {
              break label515;
            }
            Log.e(TAG, "The lastest app brand conversation is null");
            localObject1 = ((n)h.ae(n.class)).eSe().aOH(paramaz1.field_username);
            break;
            label413:
            if (paramaz1 == null) {
              break label258;
            }
            ((ca)localObject1).Jm(paramaz1.field_parentRef);
            break label258;
            localObject1 = XmlParser.parseXml((String)localObject1, "msg", null);
            paramaz1 = localObject3;
            if (localObject1 == null) {
              break label323;
            }
            paramaz1 = (String)((Map)localObject1).get(".msg.appmsg.title");
            Log.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramaz1 });
            break label323;
          }
        }
        Log.e(TAG, "the last of msg is null'");
        paramaz2.hyE();
        AppMethodBeat.o(273500);
        return;
        label515:
        localObject1 = null;
      }
      localObject1 = null;
      break;
    }
  }
  
  public final void c(az paramaz)
  {
    AppMethodBeat.i(273501);
    az localaz = ((n)h.ae(n.class)).bbR().bwx("appbrandcustomerservicemsg");
    if (localaz == null)
    {
      Log.i(TAG, "create parentConv");
      localaz = new az("appbrandcustomerservicemsg");
      localaz.hyE();
      a(paramaz, localaz);
      ((n)h.ae(n.class)).bbR().e(localaz);
      AppMethodBeat.o(273501);
      return;
    }
    Log.i(TAG, "appBrandSuperConv is created");
    localaz.Jc(null);
    a(paramaz, localaz);
    ((n)h.ae(n.class)).bbR().a(localaz, "appbrandcustomerservicemsg");
    AppMethodBeat.o(273501);
  }
  
  public final boolean ciC()
  {
    AppMethodBeat.i(273499);
    if (((n)h.ae(n.class)).bbR().bwx("appbrandcustomerservicemsg") == null)
    {
      AppMethodBeat.o(273499);
      return false;
    }
    AppMethodBeat.o(273499);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */