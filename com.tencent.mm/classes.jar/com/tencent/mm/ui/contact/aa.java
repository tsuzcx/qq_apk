package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class aa
{
  public static void a(Activity paramActivity, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(33921);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String str = auE((String)localObject);
      if (ad.arf((String)localObject)) {}
      for (int i = 66;; i = 42)
      {
        localObject = new com.tencent.mm.modelmulti.h(paramString, str, i);
        aw.Rc().a((m)localObject, 0);
        break;
      }
    }
    com.tencent.mm.ui.widget.snackbar.b.l(paramActivity, paramActivity.getString(2131300637));
    com.tencent.mm.plugin.report.service.h.qsU.e(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    al.p(new aa.1(paramActivity), 1800L);
    AppMethodBeat.o(33921);
  }
  
  public static String auE(String paramString)
  {
    AppMethodBeat.i(33920);
    Object localObject = o.adg().rj(paramString);
    aw.aaz();
    ad localad = c.YA().arw(paramString);
    if (localad == null)
    {
      AppMethodBeat.o(33920);
      return null;
    }
    String str1;
    String str2;
    if (ad.arf(paramString))
    {
      paramString = localad.field_openImAppid;
      str1 = ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).c(localad.field_openImAppid, "openim_desc_icon", b.a.gfE);
      str2 = ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).bd(localad.field_openImAppid, localad.field_descWordingId);
      paramString = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { bo.apT(((com.tencent.mm.ah.h)localObject).acX()), bo.apT(((com.tencent.mm.ah.h)localObject).acY()), bo.apT(localad.field_username), bo.apT(localad.Oe()), Integer.valueOf(localad.dqC), paramString, bo.apT(str2), bo.apT(str1) });
      AppMethodBeat.o(33920);
      return paramString;
    }
    int i = localad.dqB;
    if (localObject != null) {
      i = ((com.tencent.mm.ah.h)localObject).dqB;
    }
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    int j;
    int k;
    int m;
    String str8;
    if (localad.dwz())
    {
      paramString = f.rS(localad.field_username);
      localObject = bo.apT(localad.field_username);
      str1 = bo.apT(localad.Oe());
      str2 = bo.apT(localad.Hq());
      str3 = bo.apT(localad.Oe());
      str4 = bo.apT(localad.Ht());
      str5 = bo.apT(localad.getProvince());
      str6 = bo.apT(localad.getCity());
      str7 = bo.apT(localad.signature);
      j = localad.dqL;
      k = localad.dqC;
      m = localad.field_verifyFlag;
      str8 = bo.apT(localad.dqP);
      if (paramString != null) {
        break label470;
      }
    }
    label470:
    for (paramString = "";; paramString = bo.apT(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, bo.apT(localad.dqQ) });
      AppMethodBeat.o(33920);
      return paramString;
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.aa
 * JD-Core Version:    0.7.0.1
 */