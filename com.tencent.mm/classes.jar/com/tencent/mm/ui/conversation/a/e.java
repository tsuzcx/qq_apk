package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class e
{
  public static com.tencent.mm.pluginsdk.ui.b.a a(Context paramContext, e.a parama, Object[] paramArrayOfObject)
  {
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(38776);
    String str1;
    label132:
    label224:
    String str2;
    switch (e.1.QhF[parama.ordinal()])
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
            if (bg.aVF().aTm() == null) {
              Log.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
            }
            parama = localObject;
            if (bg.aVF().aTm() == null) {
              break;
            }
            if (!bg.aVF().aTm().KX(str1))
            {
              parama = localObject;
              if (!bg.aVF().aTm().KX(paramArrayOfObject)) {
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
      if ((!bg.aAc()) || (bg.aVF().aTn() == null) || (!bg.aVF().aTn().KX(str1)))
      {
        parama = localObject;
        if (!bg.aVF().aTn().KX(str2)) {
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
      bo.aVL();
      paramArrayOfObject = bo.aVM();
      parama = localObject;
      if (paramArrayOfObject == null) {
        break;
      }
      parama = new l(paramContext, paramArrayOfObject);
      break;
      paramArrayOfObject = com.tencent.mm.model.a.g.aWT().KR("4");
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
        bg.aVF();
        parama = com.tencent.mm.model.c.azQ().get(328195, Boolean.FALSE);
        if ((parama instanceof Boolean)) {
          bool1 = ((Boolean)parama).booleanValue();
        }
        if (!bool1)
        {
          bo.aVL();
          parama = bo.aVN();
          if ((parama == bo.a.iEc) || (parama == bo.a.iEd))
          {
            Log.i("MicroMsg.BannerFactory", "already Bind the Mobile");
            parama = localObject;
            break;
          }
          parama = new l(paramContext, new bn(1, 1, ""));
          com.tencent.mm.model.a.f.KV("4");
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
      bg.aVF();
      parama = com.tencent.mm.model.c.azQ().get(328196, Boolean.FALSE);
      bool1 = bool2;
      if ((parama instanceof Boolean)) {
        bool1 = ((Boolean)parama).booleanValue();
      }
      if (!bool1)
      {
        bo.aVL();
        if (bo.aVN() == bo.a.iEc)
        {
          Log.i("MicroMsg.BannerFactory", "already upload the Mobile");
          parama = localObject;
          break;
        }
        parama = new l(paramContext, new bn(2, 1, ""));
        com.tencent.mm.model.a.f.KV("4");
        break;
      }
      Log.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
      parama = localObject;
      break;
      parama = new m(paramContext);
      break;
      parama = new r(paramContext);
      break;
      parama = new k(paramContext);
      break;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {}
      for (parama = (b.b)paramArrayOfObject[0];; parama = b.b.iGJ)
      {
        parama = new com.tencent.mm.ui.d.a(paramContext, parama);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.e
 * JD-Core Version:    0.7.0.1
 */