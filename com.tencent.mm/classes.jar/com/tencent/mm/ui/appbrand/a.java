package com.tencent.mm.ui.appbrand;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.b;
import com.tencent.mm.storage.bl;
import java.util.Map;

public final class a
  implements f
{
  private static String TAG = "MicroMsg.AppBrandConversationService";
  
  private static void a(am paramam1, am paramam2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(191411);
    Object localObject2 = ((k)g.ab(k.class)).apR().c(w.gMt, null, "appbrandcustomerservicemsg");
    Object localObject1;
    if (localObject2 != null) {
      if ((((Cursor)localObject2).getCount() > 0) && (((Cursor)localObject2).moveToFirst()))
      {
        localObject1 = new am();
        ((am)localObject1).convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
      }
    }
    for (localObject2 = localObject1;; localObject2 = null)
    {
      if (localObject2 != null)
      {
        ad.e(TAG, "The lastest app brand conversation username is %s", new Object[] { ((ay)localObject2).field_username });
        localObject1 = ((k)g.ab(k.class)).cOI().agq(((ay)localObject2).field_username);
      }
      for (;;)
      {
        if ((localObject1 != null) && (((du)localObject1).field_msgId > 0L))
        {
          paramam2.aG((bl)localObject1);
          paramam2.setContent(((du)localObject1).field_talker + ":" + ((du)localObject1).field_content);
          paramam2.nK(Integer.toString(((bl)localObject1).getType()));
          bh.b localb = ((k)g.ab(k.class)).apR().Lu();
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
            ((bl)localObject1).nY(((ay)localObject2).field_parentRef);
            label260:
            ((bl)localObject1).setContent(paramam2.field_content);
            localb.a((bl)localObject1, localPString2, localPString1, localPInt, true);
            int i = ((bl)localObject1).getType();
            localObject1 = ((du)localObject1).field_content;
            paramam1 = localObject3;
            if (!bt.isNullOrNil((String)localObject1)) {}
            switch (i)
            {
            default: 
              paramam1 = localObject3;
              label327:
              localObject1 = bt.nullAsNil(localPString2.value);
              if (!bt.isNullOrNil(paramam1)) {
                break;
              }
            }
          }
          for (paramam1 = "";; paramam1 = " " + bt.nullAsNil(paramam1))
          {
            paramam2.nL(((String)localObject1).concat(paramam1));
            paramam2.nM(localPString1.value);
            paramam2.jW(localPInt.value);
            AppMethodBeat.o(191411);
            return;
            if (paramam1 == null) {
              break label518;
            }
            ad.e(TAG, "The lastest app brand conversation is null");
            localObject1 = ((k)g.ab(k.class)).cOI().agq(paramam1.field_username);
            break;
            label417:
            if (paramam1 == null) {
              break label260;
            }
            ((bl)localObject1).nY(paramam1.field_parentRef);
            break label260;
            localObject1 = bw.K((String)localObject1, "msg");
            paramam1 = localObject3;
            if (localObject1 == null) {
              break label327;
            }
            paramam1 = (String)((Map)localObject1).get(".msg.appmsg.title");
            ad.d(TAG, "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[] { paramam1 });
            break label327;
          }
        }
        ad.e(TAG, "the last of msg is null'");
        paramam2.eLf();
        AppMethodBeat.o(191411);
        return;
        label518:
        localObject1 = null;
      }
      localObject1 = null;
      break;
    }
  }
  
  public final boolean bnd()
  {
    AppMethodBeat.i(191410);
    if (((k)g.ab(k.class)).apR().aIn("appbrandcustomerservicemsg") == null)
    {
      AppMethodBeat.o(191410);
      return false;
    }
    AppMethodBeat.o(191410);
    return true;
  }
  
  public final void c(am paramam)
  {
    AppMethodBeat.i(191412);
    am localam = ((k)g.ab(k.class)).apR().aIn("appbrandcustomerservicemsg");
    if (localam == null)
    {
      ad.i(TAG, "create parentConv");
      localam = new am("appbrandcustomerservicemsg");
      localam.eLf();
      a(paramam, localam);
      ((k)g.ab(k.class)).apR().e(localam);
      AppMethodBeat.o(191412);
      return;
    }
    ad.i(TAG, "appBrandSuperConv is created");
    localam.nN(null);
    a(paramam, localam);
    ((k)g.ab(k.class)).apR().a(localam, "appbrandcustomerservicemsg");
    AppMethodBeat.o(191412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a
 * JD-Core Version:    0.7.0.1
 */