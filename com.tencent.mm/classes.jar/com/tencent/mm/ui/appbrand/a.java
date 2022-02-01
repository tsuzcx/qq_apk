package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class a
  implements e
{
  private static String TAG = "MicroMsg.AppBrandConversationService";
  
  private static void a(au paramau1, au paramau2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(187053);
    Object localObject2 = ((l)g.ab(l.class)).azL().c(x.hIb, null, "appbrandcustomerservicemsg");
    Object localObject1;
    if (localObject2 != null) {
      if ((((Cursor)localObject2).getCount() > 0) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject1 = new au();
        ((au)localObject1).convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
      }
    }
    for (localObject2 = localObject1;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        ae.e(TAG, "The lastest app brand conversation username is %s", new Object[] { ((ba)localObject2).field_username });
        localObject1 = ((l)g.ab(l.class)).doJ().arc(((ba)localObject2).field_username);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((ei)localObject1).field_msgId > 0L))
        {
          paramau2.aK((bv)localObject1);
          paramau2.setContent(((ei)localObject1).field_talker + ":" + ((ei)localObject1).field_content);
          paramau2.tV(Integer.toString(((bv)localObject1).getType()));
          br.b localb = ((l)g.ab(l.class)).azL().MV();
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
            ((bv)localObject1).ui(((ba)localObject2).field_parentRef);
            label260:
            ((bv)localObject1).setContent(paramau2.field_content);
            localb.a((bv)localObject1, localPString2, localPString1, localPInt, true);
            int i = ((bv)localObject1).getType();
            localObject1 = ((ei)localObject1).field_content;
            paramau1 = localObject3;
            if (!bu.isNullOrNil((String)localObject1)) {}
            switch (i)
            {
            default: 
              paramau1 = localObject3;
              label327:
              localObject1 = bu.nullAsNil(localPString2.value);
              if (!bu.isNullOrNil(paramau1)) {
                break;
              }
            }
          }
          for (paramau1 = "";; paramau1 = " " + bu.nullAsNil(paramau1))
          {
            paramau2.tW(((String)localObject1).concat(paramau1));
            paramau2.tX(localPString1.value);
            paramau2.ku(localPInt.value);
            AppMethodBeat.o(187053);
            return;
            if (paramau1 == null) {
              break label518;
            }
            ae.e(TAG, "The lastest app brand conversation is null");
            localObject1 = ((l)g.ab(l.class)).doJ().arc(paramau1.field_username);
            break;
            label417:
            if (paramau1 == null) {
              break label260;
            }
            ((bv)localObject1).ui(paramau1.field_parentRef);
            break label260;
            localObject1 = bx.M((String)localObject1, "msg");
            paramau1 = localObject3;
            if (localObject1 == null) {
              break label327;
            }
            paramau1 = (String)((Map)localObject1).get(".msg.appmsg.title");
            ae.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramau1 });
            break label327;
          }
        }
        ae.e(TAG, "the last of msg is null'");
        paramau2.fuK();
        AppMethodBeat.o(187053);
        return;
        label518:
        localObject1 = null;
      }
      localObject1 = null;
      break;
    }
  }
  
  public final boolean byX()
  {
    AppMethodBeat.i(187052);
    if (((l)g.ab(l.class)).azL().aVa("appbrandcustomerservicemsg") == null)
    {
      AppMethodBeat.o(187052);
      return false;
    }
    AppMethodBeat.o(187052);
    return true;
  }
  
  public final void c(au paramau)
  {
    AppMethodBeat.i(187054);
    au localau = ((l)g.ab(l.class)).azL().aVa("appbrandcustomerservicemsg");
    if (localau == null)
    {
      ae.i(TAG, "create parentConv");
      localau = new au("appbrandcustomerservicemsg");
      localau.fuK();
      a(paramau, localau);
      ((l)g.ab(l.class)).azL().e(localau);
      AppMethodBeat.o(187054);
      return;
    }
    ae.i(TAG, "appBrandSuperConv is created");
    localau.tY(null);
    a(paramau, localau);
    ((l)g.ab(l.class)).azL().a(localau, "appbrandcustomerservicemsg");
    AppMethodBeat.o(187054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */