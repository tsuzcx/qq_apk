package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.conversation.fold.b;

public final class e
{
  public static com.tencent.mm.pluginsdk.ui.a.a a(Context paramContext, a parama, Object[] paramArrayOfObject)
  {
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(38776);
    String str1;
    label128:
    label220:
    label255:
    String str2;
    switch (1.afsN[parama.ordinal()])
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
              break label220;
            }
          }
          for (paramArrayOfObject = paramArrayOfObject[1].toString();; paramArrayOfObject = null)
          {
            if (bh.bCz().bzZ() == null) {
              Log.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
            }
            parama = localObject;
            if (bh.bCz().bzZ() == null) {
              break;
            }
            if (!bh.bCz().bzZ().Ks(str1))
            {
              parama = localObject;
              if (!bh.bCz().bzZ().Ks(paramArrayOfObject)) {
                break;
              }
            }
            parama = new f(paramContext, str1, paramArrayOfObject);
            break;
            str1 = null;
            break label128;
          }
          parama = localObject;
        } while (paramArrayOfObject == null);
        parama = localObject;
      } while (paramArrayOfObject.length != 3);
      if (paramArrayOfObject[0] != null)
      {
        str1 = paramArrayOfObject[0].toString();
        if (paramArrayOfObject[1] == null) {
          break label363;
        }
        str2 = paramArrayOfObject[1].toString();
        label269:
        if ((paramArrayOfObject[2] == null) || (!(paramArrayOfObject[2] instanceof Boolean))) {
          break label809;
        }
      }
      break;
    }
    label809:
    for (bool1 = ((Boolean)paramArrayOfObject[2]).booleanValue();; bool1 = false)
    {
      if ((!bh.baz()) || (bh.bCz().bAa() == null) || (!bh.bCz().bAa().Ks(str1)))
      {
        parama = localObject;
        if (!bh.bCz().bAa().Ks(str2)) {
          break;
        }
      }
      parama = new g(paramContext, str1, str2, bool1);
      break;
      str1 = null;
      break label255;
      label363:
      str2 = null;
      break label269;
      parama = new n(paramContext);
      break;
      parama = new o(paramContext);
      break;
      parama = new h(paramContext);
      break;
      parama = new a(paramContext);
      break;
      bq.bCF();
      paramArrayOfObject = bq.bCG();
      parama = localObject;
      if (paramArrayOfObject == null) {
        break;
      }
      parama = new k(paramContext, paramArrayOfObject);
      break;
      paramArrayOfObject = com.tencent.mm.model.a.g.bDR().Km("4");
      parama = localObject;
      if (paramArrayOfObject == null) {
        break;
      }
      paramArrayOfObject = paramArrayOfObject.value;
      parama = localObject;
      if (Util.isNullOrNil(paramArrayOfObject)) {
        break;
      }
      parama = localObject;
      if (paramArrayOfObject.equals("0")) {
        break;
      }
      if (paramArrayOfObject.equals("1"))
      {
        bh.bCz();
        parama = com.tencent.mm.model.c.ban().d(328195, Boolean.FALSE);
        if ((parama instanceof Boolean)) {
          bool1 = ((Boolean)parama).booleanValue();
        }
        if (!bool1)
        {
          bq.bCF();
          parama = bq.bCH();
          if ((parama == bq.a.olC) || (parama == bq.a.olD))
          {
            Log.i("MicroMsg.BannerFactory", "already Bind the Mobile");
            parama = localObject;
            break;
          }
          parama = new k(paramContext, new bp(1, 1, ""));
          com.tencent.mm.model.a.f.Kq("4");
          break;
        }
        Log.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
        parama = localObject;
        break;
      }
      parama = localObject;
      if (!paramArrayOfObject.equals("2")) {
        break;
      }
      bh.bCz();
      parama = com.tencent.mm.model.c.ban().d(328196, Boolean.FALSE);
      bool1 = bool2;
      if ((parama instanceof Boolean)) {
        bool1 = ((Boolean)parama).booleanValue();
      }
      if (!bool1)
      {
        bq.bCF();
        if (bq.bCH() == bq.a.olC)
        {
          Log.i("MicroMsg.BannerFactory", "already upload the Mobile");
          parama = localObject;
          break;
        }
        parama = new k(paramContext, new bp(2, 1, ""));
        com.tencent.mm.model.a.f.Kq("4");
        break;
      }
      Log.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
      parama = localObject;
      break;
      parama = new l(paramContext);
      break;
      parama = new p(paramContext);
      break;
      parama = new j(paramContext);
      break;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {}
      for (parama = (b.b)paramArrayOfObject[0];; parama = b.b.ook)
      {
        parama = new com.tencent.mm.ui.c.a(paramContext, parama);
        break;
      }
      parama = new b(paramContext);
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(38775);
      afsO = new a("MAIN_FRAME_BANNER", 0);
      afsP = new a("CHATTING_RECOMMEND_BANNER", 1);
      afsQ = new a("CHATTING_SECURITY_BANNER", 2);
      afsR = new a("NET_WARN_BANNER", 3);
      afsS = new a("OTHER_ONLINE_BANNER", 4);
      afsT = new a("FORCE_NOTIFY_BANNER", 5);
      afsU = new a("STORAGE_PERMISSION_BANNER", 6);
      afsV = new a("FACEBOOK_BANNER", 7);
      afsW = new a("AD_BANNER", 8);
      afsX = new a("ABTEST_BANNER", 9);
      afsY = new a("MASS_SEND_SIGHT_BANNER", 10);
      afsZ = new a("TRY_NEW_INIT_BANNER", 11);
      afta = new a("MAIN_FRAME_AND_ABTEST_BANNER", 12);
      aftb = new a("CHATTING_MONITORED_HINT", 13);
      aftc = new a("CHATTING_FOLD_BANNER", 14);
      aftd = new a[] { afsO, afsP, afsQ, afsR, afsS, afsT, afsU, afsV, afsW, afsX, afsY, afsZ, afta, aftb, aftc };
      AppMethodBeat.o(38775);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.e
 * JD-Core Version:    0.7.0.1
 */