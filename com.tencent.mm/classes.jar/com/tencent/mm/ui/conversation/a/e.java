package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.be;
import com.tencent.mm.model.be.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class e
{
  public static com.tencent.mm.pluginsdk.ui.b.a a(Context paramContext, e.a parama, Object[] paramArrayOfObject)
  {
    Object localObject = null;
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(34649);
    String str1;
    label128:
    label220:
    label255:
    String str2;
    switch (e.1.Aml[parama.ordinal()])
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
              AppMethodBeat.o(34649);
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
            if (aw.aaz().YY() == null) {
              ab.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
            }
            parama = localObject;
            if (aw.aaz().YY() == null) {
              break;
            }
            if (!aw.aaz().YY().pR(str1))
            {
              parama = localObject;
              if (!aw.aaz().YY().pR(paramArrayOfObject)) {
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
      if ((!aw.RG()) || (aw.aaz().YZ() == null) || (!aw.aaz().YZ().pR(str1)))
      {
        parama = localObject;
        if (!aw.aaz().YZ().pR(str2)) {
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
      parama = new o(paramContext);
      break;
      parama = new p(paramContext);
      break;
      parama = new i(paramContext);
      break;
      parama = new h(paramContext);
      break;
      parama = new a(paramContext);
      break;
      be.aaG();
      paramArrayOfObject = be.aaH();
      parama = localObject;
      if (paramArrayOfObject == null) {
        break;
      }
      parama = new l(paramContext, paramArrayOfObject);
      break;
      paramArrayOfObject = com.tencent.mm.model.a.g.abw().pL("4");
      parama = localObject;
      if (paramArrayOfObject == null) {
        break;
      }
      paramArrayOfObject = paramArrayOfObject.value;
      parama = localObject;
      if (bo.isNullOrNil(paramArrayOfObject)) {
        break;
      }
      parama = localObject;
      if (paramArrayOfObject.equals("0")) {
        break;
      }
      if (paramArrayOfObject.equals("1"))
      {
        aw.aaz();
        parama = com.tencent.mm.model.c.Ru().get(328195, Boolean.FALSE);
        if ((parama instanceof Boolean)) {
          bool1 = ((Boolean)parama).booleanValue();
        }
        if (!bool1)
        {
          be.aaG();
          parama = be.aaJ();
          if ((parama == be.a.fmu) || (parama == be.a.fmv))
          {
            ab.i("MicroMsg.BannerFactory", "already Bind the Mobile");
            parama = localObject;
            break;
          }
          parama = new l(paramContext, new bd(1, 1, ""));
          com.tencent.mm.model.a.f.pP("4");
          break;
        }
        ab.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
        parama = localObject;
        break;
      }
      parama = localObject;
      if (!paramArrayOfObject.equals("2")) {
        break;
      }
      aw.aaz();
      parama = com.tencent.mm.model.c.Ru().get(328196, Boolean.FALSE);
      bool1 = bool2;
      if ((parama instanceof Boolean)) {
        bool1 = ((Boolean)parama).booleanValue();
      }
      if (!bool1)
      {
        be.aaG();
        if (be.aaJ() == be.a.fmu)
        {
          ab.i("MicroMsg.BannerFactory", "already upload the Mobile");
          parama = localObject;
          break;
        }
        parama = new l(paramContext, new bd(2, 1, ""));
        com.tencent.mm.model.a.f.pP("4");
        break;
      }
      ab.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
      parama = localObject;
      break;
      parama = new m(paramContext);
      break;
      parama = new q(paramContext);
      break;
      parama = new k(paramContext);
      break;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {}
      for (parama = (b.b)paramArrayOfObject[0];; parama = b.b.fou)
      {
        parama = new com.tencent.mm.ui.d.a(paramContext, parama);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.e
 * JD-Core Version:    0.7.0.1
 */