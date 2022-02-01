package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class e
{
  public static com.tencent.mm.pluginsdk.ui.b.a a(Context paramContext, a parama, Object[] paramArrayOfObject)
  {
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(38776);
    String str1;
    label132:
    label224:
    String str2;
    switch (1.KxV[parama.ordinal()])
    {
    default: 
      parama = localObject;
    case 1: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(38776);
              return parama;
              parama = localObject;
            } while (paramArrayOfObject == null);
            parama = localObject;
          } while (paramArrayOfObject.length != 2);
          if (paramArrayOfObject[0] != null)
          {
            str1 = paramArrayOfObject[0].toString();
            if (paramArrayOfObject[1] == null) {
              break label224;
            }
          }
          for (paramArrayOfObject = paramArrayOfObject[1].toString();; paramArrayOfObject = null)
          {
            if (ba.aBQ().azO() == null) {
              ad.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
            }
            parama = localObject;
            if (ba.aBQ().azO() == null) {
              break;
            }
            if (!ba.aBQ().azO().BK(str1))
            {
              parama = localObject;
              if (!ba.aBQ().azO().BK(paramArrayOfObject)) {
                break;
              }
            }
            parama = new f(paramContext, str1, paramArrayOfObject);
            break;
            str1 = null;
            break label132;
          }
          parama = localObject;
        } while (paramArrayOfObject == null);
        parama = localObject;
      } while (paramArrayOfObject.length != 3);
      if (paramArrayOfObject[0] != null)
      {
        str1 = paramArrayOfObject[0].toString();
        label259:
        if (paramArrayOfObject[1] == null) {
          break label367;
        }
        str2 = paramArrayOfObject[1].toString();
        label273:
        if ((paramArrayOfObject[2] == null) || (!(paramArrayOfObject[2] instanceof Boolean))) {
          break label825;
        }
      }
      break;
    }
    label825:
    for (bool1 = ((Boolean)paramArrayOfObject[2]).booleanValue();; bool1 = false)
    {
      if ((!ba.ajx()) || (ba.aBQ().azP() == null) || (!ba.aBQ().azP().BK(str1)))
      {
        parama = localObject;
        if (!ba.aBQ().azP().BK(str2)) {
          break;
        }
      }
      parama = new g(paramContext, str1, str2, bool1);
      break;
      str1 = null;
      break label259;
      label367:
      str2 = null;
      break label273;
      parama = new o(paramContext);
      break;
      parama = new p(paramContext);
      break;
      parama = new i(paramContext);
      break;
      parama = new q(paramContext);
      break;
      parama = new h(paramContext);
      break;
      parama = new a(paramContext);
      break;
      bi.aBW();
      paramArrayOfObject = bi.aBX();
      parama = localObject;
      if (paramArrayOfObject == null) {
        break;
      }
      parama = new l(paramContext, paramArrayOfObject);
      break;
      paramArrayOfObject = com.tencent.mm.model.a.g.aCR().BE("4");
      parama = localObject;
      if (paramArrayOfObject == null) {
        break;
      }
      paramArrayOfObject = paramArrayOfObject.value;
      parama = localObject;
      if (bt.isNullOrNil(paramArrayOfObject)) {
        break;
      }
      parama = localObject;
      if (paramArrayOfObject.equals("0")) {
        break;
      }
      if (paramArrayOfObject.equals("1"))
      {
        ba.aBQ();
        parama = com.tencent.mm.model.c.ajl().get(328195, Boolean.FALSE);
        if ((parama instanceof Boolean)) {
          bool1 = ((Boolean)parama).booleanValue();
        }
        if (!bool1)
        {
          bi.aBW();
          parama = bi.aBZ();
          if ((parama == bi.a.hGA) || (parama == bi.a.hGB))
          {
            ad.i("MicroMsg.BannerFactory", "already Bind the Mobile");
            parama = localObject;
            break;
          }
          parama = new l(paramContext, new bh(1, 1, ""));
          com.tencent.mm.model.a.f.BI("4");
          break;
        }
        ad.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
        parama = localObject;
        break;
      }
      parama = localObject;
      if (!paramArrayOfObject.equals("2")) {
        break;
      }
      ba.aBQ();
      parama = com.tencent.mm.model.c.ajl().get(328196, Boolean.FALSE);
      bool1 = bool2;
      if ((parama instanceof Boolean)) {
        bool1 = ((Boolean)parama).booleanValue();
      }
      if (!bool1)
      {
        bi.aBW();
        if (bi.aBZ() == bi.a.hGA)
        {
          ad.i("MicroMsg.BannerFactory", "already upload the Mobile");
          parama = localObject;
          break;
        }
        parama = new l(paramContext, new bh(2, 1, ""));
        com.tencent.mm.model.a.f.BI("4");
        break;
      }
      ad.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
      parama = localObject;
      break;
      parama = new m(paramContext);
      break;
      parama = new r(paramContext);
      break;
      parama = new k(paramContext);
      break;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {}
      for (parama = (b.b)paramArrayOfObject[0];; parama = b.b.hIO)
      {
        parama = new com.tencent.mm.ui.d.a(paramContext, parama);
        break;
      }
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(38775);
      KxW = new a("MAIN_FRAME_BANNER", 0);
      KxX = new a("CHATTING_RECOMMEND_BANNER", 1);
      KxY = new a("CHATTING_SECURITY_BANNER", 2);
      KxZ = new a("NET_WARN_BANNER", 3);
      Kya = new a("OTHER_ONLINE_BANNER", 4);
      Kyb = new a("FORCE_NOTIFY_BANNER", 5);
      Kyc = new a("STORAGE_PERMISSION_BANNER", 6);
      Kyd = new a("FACEBOOK_BANNER", 7);
      Kye = new a("AD_BANNER", 8);
      Kyf = new a("ABTEST_BANNER", 9);
      Kyg = new a("MASS_SEND_SIGHT_BANNER", 10);
      Kyh = new a("TRY_NEW_INIT_BANNER", 11);
      Kyi = new a("MAIN_FRAME_AND_ABTEST_BANNER", 12);
      Kyj = new a("CHATTING_MONITORED_HINT", 13);
      Kyk = new a[] { KxW, KxX, KxY, KxZ, Kya, Kyb, Kyc, Kyd, Kye, Kyf, Kyg, Kyh, Kyi, Kyj };
      AppMethodBeat.o(38775);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.e
 * JD-Core Version:    0.7.0.1
 */