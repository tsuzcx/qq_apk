package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class a
  implements f
{
  private static String TAG = "MicroMsg.AppBrandConversationService";
  
  private static void b(bb parambb1, bb parambb2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(249665);
    Object localObject2 = ((n)h.ax(n.class)).bzG().a(4, null, "appbrandcustomerservicemsg");
    Object localObject1;
    if (localObject2 != null) {
      if ((((Cursor)localObject2).getCount() > 0) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject1 = new bb();
        ((bb)localObject1).convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
      }
    }
    for (localObject2 = localObject1;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        Log.e(TAG, "The lastest app brand conversation username is %s", new Object[] { ((bd)localObject2).field_username });
        localObject1 = ((n)h.ax(n.class)).gaZ().aLG(((bd)localObject2).field_username);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((fi)localObject1).field_msgId > 0L))
        {
          parambb2.bG((cc)localObject1);
          parambb2.setContent(((fi)localObject1).field_talker + ":" + ((fi)localObject1).field_content);
          parambb2.BE(Integer.toString(((cc)localObject1).getType()));
          by.b localb = ((n)h.ax(n.class)).bzG().aDH();
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
            ((cc)localObject1).BS(((bd)localObject2).field_parentRef);
            label258:
            ((cc)localObject1).setContent(parambb2.field_content);
            localb.a((cc)localObject1, localPString2, localPString1, localPInt, true);
            int i = ((cc)localObject1).getType();
            localObject1 = ((fi)localObject1).field_content;
            parambb1 = localObject3;
            if (!Util.isNullOrNil((String)localObject1)) {}
            switch (i)
            {
            default: 
              parambb1 = localObject3;
              label323:
              localObject1 = Util.nullAsNil(localPString2.value);
              if (!Util.isNullOrNil(parambb1)) {
                break;
              }
            }
          }
          for (parambb1 = "";; parambb1 = " " + Util.nullAsNil(parambb1))
          {
            parambb2.BF(((String)localObject1).concat(parambb1));
            parambb2.BG(localPString1.value);
            parambb2.pJ(localPInt.value);
            AppMethodBeat.o(249665);
            return;
            if (parambb1 == null) {
              break label515;
            }
            Log.e(TAG, "The lastest app brand conversation is null");
            localObject1 = ((n)h.ax(n.class)).gaZ().aLG(parambb1.field_username);
            break;
            label413:
            if (parambb1 == null) {
              break label258;
            }
            ((cc)localObject1).BS(parambb1.field_parentRef);
            break label258;
            localObject1 = XmlParser.parseXml((String)localObject1, "msg", null);
            parambb1 = localObject3;
            if (localObject1 == null) {
              break label323;
            }
            parambb1 = (String)((Map)localObject1).get(".msg.appmsg.title");
            Log.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { parambb1 });
            break label323;
          }
        }
        Log.e(TAG, "the last of msg is null'");
        parambb2.jaJ();
        AppMethodBeat.o(249665);
        return;
        label515:
        localObject1 = null;
      }
      localObject1 = null;
      break;
    }
  }
  
  public final boolean bRX()
  {
    AppMethodBeat.i(249672);
    if (((n)h.ax(n.class)).bzG().bxM("appbrandcustomerservicemsg") == null)
    {
      AppMethodBeat.o(249672);
      return false;
    }
    AppMethodBeat.o(249672);
    return true;
  }
  
  public final void e(bb parambb)
  {
    AppMethodBeat.i(249675);
    bb localbb = ((n)h.ax(n.class)).bzG().bxM("appbrandcustomerservicemsg");
    if (localbb == null)
    {
      Log.i(TAG, "create parentConv");
      localbb = new bb("appbrandcustomerservicemsg");
      localbb.jaJ();
      b(parambb, localbb);
      ((n)h.ax(n.class)).bzG().h(localbb);
      AppMethodBeat.o(249675);
      return;
    }
    Log.i(TAG, "appBrandSuperConv is created");
    localbb.BH(null);
    b(parambb, localbb);
    ((n)h.ax(n.class)).bzG().c(localbb, "appbrandcustomerservicemsg");
    AppMethodBeat.o(249675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */