package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class a
  implements e
{
  private static String TAG = "MicroMsg.AppBrandConversationService";
  
  private static void a(at paramat1, at paramat2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(193762);
    Object localObject2 = ((l)g.ab(l.class)).azv().c(w.hFj, null, "appbrandcustomerservicemsg");
    Object localObject1;
    if (localObject2 != null) {
      if ((((Cursor)localObject2).getCount() > 0) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject1 = new at();
        ((at)localObject1).convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
      }
    }
    for (localObject2 = localObject1;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        ad.e(TAG, "The lastest app brand conversation username is %s", new Object[] { ((ba)localObject2).field_username });
        localObject1 = ((l)g.ab(l.class)).dlK().apX(((ba)localObject2).field_username);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((ei)localObject1).field_msgId > 0L))
        {
          paramat2.aL((bu)localObject1);
          paramat2.setContent(((ei)localObject1).field_talker + ":" + ((ei)localObject1).field_content);
          paramat2.tA(Integer.toString(((bu)localObject1).getType()));
          bq.b localb = ((l)g.ab(l.class)).azv().Na();
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
            ((bu)localObject1).tN(((ba)localObject2).field_parentRef);
            label260:
            ((bu)localObject1).setContent(paramat2.field_content);
            localb.a((bu)localObject1, localPString2, localPString1, localPInt, true);
            int i = ((bu)localObject1).getType();
            localObject1 = ((ei)localObject1).field_content;
            paramat1 = localObject3;
            if (!bt.isNullOrNil((String)localObject1)) {}
            switch (i)
            {
            default: 
              paramat1 = localObject3;
              label327:
              localObject1 = bt.nullAsNil(localPString2.value);
              if (!bt.isNullOrNil(paramat1)) {
                break;
              }
            }
          }
          for (paramat1 = "";; paramat1 = " " + bt.nullAsNil(paramat1))
          {
            paramat2.tB(((String)localObject1).concat(paramat1));
            paramat2.tC(localPString1.value);
            paramat2.ks(localPInt.value);
            AppMethodBeat.o(193762);
            return;
            if (paramat1 == null) {
              break label518;
            }
            ad.e(TAG, "The lastest app brand conversation is null");
            localObject1 = ((l)g.ab(l.class)).dlK().apX(paramat1.field_username);
            break;
            label417:
            if (paramat1 == null) {
              break label260;
            }
            ((bu)localObject1).tN(paramat1.field_parentRef);
            break label260;
            localObject1 = bw.M((String)localObject1, "msg");
            paramat1 = localObject3;
            if (localObject1 == null) {
              break label327;
            }
            paramat1 = (String)((Map)localObject1).get(".msg.appmsg.title");
            ad.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramat1 });
            break label327;
          }
        }
        ad.e(TAG, "the last of msg is null'");
        paramat2.fqK();
        AppMethodBeat.o(193762);
        return;
        label518:
        localObject1 = null;
      }
      localObject1 = null;
      break;
    }
  }
  
  public final boolean bye()
  {
    AppMethodBeat.i(193761);
    if (((l)g.ab(l.class)).azv().aTz("appbrandcustomerservicemsg") == null)
    {
      AppMethodBeat.o(193761);
      return false;
    }
    AppMethodBeat.o(193761);
    return true;
  }
  
  public final void c(at paramat)
  {
    AppMethodBeat.i(193763);
    at localat = ((l)g.ab(l.class)).azv().aTz("appbrandcustomerservicemsg");
    if (localat == null)
    {
      ad.i(TAG, "create parentConv");
      localat = new at("appbrandcustomerservicemsg");
      localat.fqK();
      a(paramat, localat);
      ((l)g.ab(l.class)).azv().e(localat);
      AppMethodBeat.o(193763);
      return;
    }
    ad.i(TAG, "appBrandSuperConv is created");
    localat.tD(null);
    a(paramat, localat);
    ((l)g.ab(l.class)).azv().a(localat, "appbrandcustomerservicemsg");
    AppMethodBeat.o(193763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */