package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.List;

public final class ad
{
  public static void a(Activity paramActivity, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(38045);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String str = aLx((String)localObject);
      if (af.aHH((String)localObject)) {}
      for (int i = 66;; i = 42)
      {
        localObject = new com.tencent.mm.modelmulti.i(paramString, str, i, 0);
        az.aeS().a((n)localObject, 0);
        break;
      }
    }
    com.tencent.mm.ui.widget.snackbar.b.n(paramActivity, paramActivity.getString(2131760233));
    h.vKh.f(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38043);
        this.GYS.finish();
        AppMethodBeat.o(38043);
      }
    }, 1800L);
    AppMethodBeat.o(38045);
  }
  
  public static String aLx(String paramString)
  {
    AppMethodBeat.i(38044);
    Object localObject = p.auF().we(paramString);
    az.arV();
    af localaf = com.tencent.mm.model.c.apM().aHY(paramString);
    if (localaf == null)
    {
      AppMethodBeat.o(38044);
      return null;
    }
    String str1;
    String str2;
    if (af.aHH(paramString))
    {
      paramString = localaf.field_openImAppid;
      str1 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).c(localaf.field_openImAppid, "openim_desc_icon", b.a.hNB);
      str2 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bt(localaf.field_openImAppid, localaf.field_descWordingId);
      paramString = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { bt.aGf(((com.tencent.mm.ak.i)localObject).aux()), bt.aGf(((com.tencent.mm.ak.i)localObject).auy()), bt.aGf(localaf.field_username), bt.aGf(localaf.ZW()), Integer.valueOf(localaf.evp), paramString, bt.aGf(str2), bt.aGf(str1) });
      AppMethodBeat.o(38044);
      return paramString;
    }
    int i = localaf.evo;
    if (localObject != null) {
      i = ((com.tencent.mm.ak.i)localObject).evo;
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
    if (localaf.eKB())
    {
      paramString = f.ei(localaf.field_username);
      localObject = bt.aGf(localaf.field_username);
      str1 = bt.aGf(localaf.ZW());
      str2 = bt.aGf(localaf.Ss());
      str3 = bt.aGf(localaf.ZW());
      str4 = bt.aGf(localaf.Sv());
      str5 = bt.aGf(localaf.getProvince());
      str6 = bt.aGf(localaf.getCity());
      str7 = bt.aGf(localaf.signature);
      j = localaf.evy;
      k = localaf.evp;
      m = localaf.field_verifyFlag;
      str8 = bt.aGf(localaf.evE);
      if (paramString != null) {
        break label470;
      }
    }
    label470:
    for (paramString = "";; paramString = bt.aGf(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, bt.aGf(localaf.evF) });
      AppMethodBeat.o(38044);
      return paramString;
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ad
 * JD-Core Version:    0.7.0.1
 */