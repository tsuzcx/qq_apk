package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class a
  implements e
{
  private static String TAG = "MicroMsg.AppBrandConversationService";
  
  private static void a(ap paramap1, ap paramap2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(196343);
    Object localObject2 = ((k)g.ab(k.class)).awG().c(w.hmT, null, "appbrandcustomerservicemsg");
    Object localObject1;
    if (localObject2 != null) {
      if ((((Cursor)localObject2).getCount() > 0) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject1 = new ap();
        ((ap)localObject1).convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
      }
    }
    for (localObject2 = localObject1;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        ac.e(TAG, "The lastest app brand conversation username is %s", new Object[] { ((az)localObject2).field_username });
        localObject1 = ((k)g.ab(k.class)).dcr().alk(((az)localObject2).field_username);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((dy)localObject1).field_msgId > 0L))
        {
          paramap2.aI((bo)localObject1);
          paramap2.setContent(((dy)localObject1).field_talker + ":" + ((dy)localObject1).field_content);
          paramap2.qQ(Integer.toString(((bo)localObject1).getType()));
          bk.b localb = ((k)g.ab(k.class)).awG().Ls();
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
            ((bo)localObject1).re(((az)localObject2).field_parentRef);
            label260:
            ((bo)localObject1).setContent(paramap2.field_content);
            localb.a((bo)localObject1, localPString2, localPString1, localPInt, true);
            int i = ((bo)localObject1).getType();
            localObject1 = ((dy)localObject1).field_content;
            paramap1 = localObject3;
            if (!bs.isNullOrNil((String)localObject1)) {}
            switch (i)
            {
            default: 
              paramap1 = localObject3;
              label327:
              localObject1 = bs.nullAsNil(localPString2.value);
              if (!bs.isNullOrNil(paramap1)) {
                break;
              }
            }
          }
          for (paramap1 = "";; paramap1 = " " + bs.nullAsNil(paramap1))
          {
            paramap2.qR(((String)localObject1).concat(paramap1));
            paramap2.qS(localPString1.value);
            paramap2.jU(localPInt.value);
            AppMethodBeat.o(196343);
            return;
            if (paramap1 == null) {
              break label518;
            }
            ac.e(TAG, "The lastest app brand conversation is null");
            localObject1 = ((k)g.ab(k.class)).dcr().alk(paramap1.field_username);
            break;
            label417:
            if (paramap1 == null) {
              break label260;
            }
            ((bo)localObject1).re(paramap1.field_parentRef);
            break label260;
            localObject1 = bv.L((String)localObject1, "msg");
            paramap1 = localObject3;
            if (localObject1 == null) {
              break label327;
            }
            paramap1 = (String)((Map)localObject1).get(".msg.appmsg.title");
            ac.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramap1 });
            break label327;
          }
        }
        ac.e(TAG, "the last of msg is null'");
        paramap2.faH();
        AppMethodBeat.o(196343);
        return;
        label518:
        localObject1 = null;
      }
      localObject1 = null;
      break;
    }
  }
  
  public final boolean btZ()
  {
    AppMethodBeat.i(196342);
    if (((k)g.ab(k.class)).awG().aNI("appbrandcustomerservicemsg") == null)
    {
      AppMethodBeat.o(196342);
      return false;
    }
    AppMethodBeat.o(196342);
    return true;
  }
  
  public final void c(ap paramap)
  {
    AppMethodBeat.i(196344);
    ap localap = ((k)g.ab(k.class)).awG().aNI("appbrandcustomerservicemsg");
    if (localap == null)
    {
      ac.i(TAG, "create parentConv");
      localap = new ap("appbrandcustomerservicemsg");
      localap.faH();
      a(paramap, localap);
      ((k)g.ab(k.class)).awG().e(localap);
      AppMethodBeat.o(196344);
      return;
    }
    ac.i(TAG, "appBrandSuperConv is created");
    localap.qT(null);
    a(paramap, localap);
    ((k)g.ab(k.class)).awG().a(localap, "appbrandcustomerservicemsg");
    AppMethodBeat.o(196344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */