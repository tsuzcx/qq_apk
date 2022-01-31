package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class z
{
  public static void a(Activity paramActivity, String paramString, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String str = adW((String)localObject);
      if (ad.aaU((String)localObject)) {}
      for (int i = 66;; i = 42)
      {
        localObject = new com.tencent.mm.modelmulti.h(paramString, str, i);
        au.Dk().a((m)localObject, 0);
        break;
      }
    }
    com.tencent.mm.ui.widget.snackbar.b.h(paramActivity, paramActivity.getString(R.l.has_send));
    com.tencent.mm.plugin.report.service.h.nFQ.f(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    ai.l(new z.1(paramActivity), 1800L);
  }
  
  public static String adW(String paramString)
  {
    Object localObject = o.Kh().kp(paramString);
    au.Hx();
    ad localad = c.Fw().abl(paramString);
    String str1;
    String str2;
    if (ad.aaU(paramString))
    {
      paramString = localad.field_openImAppid;
      str1 = ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).c(localad.field_openImAppid, "openim_desc_icon", b.a.ePJ);
      str2 = ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).aK(localad.field_openImAppid, localad.field_descWordingId);
      return String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { bk.ZP(((com.tencent.mm.ag.h)localObject).JX()), bk.ZP(((com.tencent.mm.ag.h)localObject).JY()), bk.ZP(localad.field_username), bk.ZP(localad.Bp()), Integer.valueOf(localad.sex), paramString, bk.ZP(str2), bk.ZP(str1) });
    }
    int i = localad.cCq;
    if (localObject != null) {
      i = ((com.tencent.mm.ag.h)localObject).cCq;
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
    if (localad.cua())
    {
      paramString = f.kX(localad.field_username);
      localObject = bk.ZP(localad.field_username);
      str1 = bk.ZP(localad.Bp());
      str2 = bk.ZP(localad.vk());
      str3 = bk.ZP(localad.Bp());
      str4 = bk.ZP(localad.vn());
      str5 = bk.ZP(localad.getProvince());
      str6 = bk.ZP(localad.getCity());
      str7 = bk.ZP(localad.signature);
      j = localad.cCz;
      k = localad.sex;
      m = localad.field_verifyFlag;
      str8 = bk.ZP(localad.cCF);
      if (paramString != null) {
        break label439;
      }
    }
    label439:
    for (paramString = "";; paramString = bk.ZP(paramString.field_brandIconURL))
    {
      return String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, bk.ZP(localad.cCG) });
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.z
 * JD-Core Version:    0.7.0.1
 */