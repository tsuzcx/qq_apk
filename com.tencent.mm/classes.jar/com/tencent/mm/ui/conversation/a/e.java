package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bc.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class e
{
  public static com.tencent.mm.pluginsdk.ui.b.a a(Context paramContext, e.a parama, Object[] paramArrayOfObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    label97:
    String str;
    switch (e.1.vUp[parama.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
      label177:
      do
      {
        do
        {
          return null;
        } while ((paramArrayOfObject == null) || (paramArrayOfObject.length != 2));
        if (paramArrayOfObject[0] != null)
        {
          parama = paramArrayOfObject[0].toString();
          if (paramArrayOfObject[1] == null) {
            break label177;
          }
        }
        for (paramArrayOfObject = paramArrayOfObject[1].toString();; paramArrayOfObject = null)
        {
          if (au.Hx().FX() == null) {
            y.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
          }
          if ((au.Hx().FX() == null) || ((!au.Hx().FX().jd(parama)) && (!au.Hx().FX().jd(paramArrayOfObject)))) {
            break;
          }
          return new f(paramContext, parama, paramArrayOfObject);
          parama = null;
          break label97;
        }
      } while ((paramArrayOfObject == null) || (paramArrayOfObject.length != 3));
      if (paramArrayOfObject[0] != null)
      {
        parama = paramArrayOfObject[0].toString();
        label205:
        if (paramArrayOfObject[1] == null) {
          break label304;
        }
        str = paramArrayOfObject[1].toString();
        label219:
        if ((paramArrayOfObject[2] == null) || (!(paramArrayOfObject[2] instanceof Boolean))) {
          break label671;
        }
      }
      break;
    }
    label671:
    for (bool1 = ((Boolean)paramArrayOfObject[2]).booleanValue(); ((au.DK()) && (au.Hx().FY() != null) && (au.Hx().FY().jd(parama))) || (au.Hx().FY().jd(str)); bool1 = false)
    {
      return new g(paramContext, parama, str, bool1);
      parama = null;
      break label205;
      label304:
      str = null;
      break label219;
      return new n(paramContext);
      return new h(paramContext);
      return new a(paramContext);
      bc.HI();
      parama = bc.HJ();
      if (parama == null) {
        break;
      }
      return new k(paramContext, parama);
      parama = com.tencent.mm.model.a.g.Iy().iX("4");
      if (parama == null) {
        break;
      }
      parama = parama.value;
      if ((bk.bl(parama)) || (parama.equals("0"))) {
        break;
      }
      if (parama.equals("1"))
      {
        au.Hx();
        parama = com.tencent.mm.model.c.Dz().get(328195, Boolean.valueOf(false));
        if ((parama instanceof Boolean)) {
          bool1 = ((Boolean)parama).booleanValue();
        }
        if (!bool1)
        {
          bc.HI();
          parama = bc.HK();
          if ((parama == bc.a.dWk) || (parama == bc.a.dWl))
          {
            y.i("MicroMsg.BannerFactory", "already Bind the Mobile");
            return null;
          }
          paramContext = new k(paramContext, new bb(1, 1, ""));
          com.tencent.mm.model.a.f.jb("4");
          return paramContext;
        }
        y.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
        return null;
      }
      if (!parama.equals("2")) {
        break;
      }
      au.Hx();
      parama = com.tencent.mm.model.c.Dz().get(328196, Boolean.valueOf(false));
      bool1 = bool2;
      if ((parama instanceof Boolean)) {
        bool1 = ((Boolean)parama).booleanValue();
      }
      if (!bool1)
      {
        bc.HI();
        if (bc.HK() == bc.a.dWk)
        {
          y.i("MicroMsg.BannerFactory", "already upload the Mobile");
          return null;
        }
        paramContext = new k(paramContext, new bb(2, 1, ""));
        com.tencent.mm.model.a.f.jb("4");
        return paramContext;
      }
      y.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
      return null;
      return new l(paramContext);
      return new o(paramContext);
      return new j(paramContext);
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {}
      for (parama = (b.b)paramArrayOfObject[0];; parama = b.b.dYq) {
        return new com.tencent.mm.ui.d.a(paramContext, parama);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.e
 * JD-Core Version:    0.7.0.1
 */