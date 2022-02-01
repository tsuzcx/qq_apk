package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
      String str1 = (String)localIterator.next();
      String str2 = aWZ(str1);
      o.e locale = o.FX(paramString);
      locale.toUser = paramString;
      locale.content = str2;
      if (am.aSQ(str1)) {}
      for (int i = 66;; i = 42)
      {
        locale.type = i;
        locale.dDp = 0;
        locale.igc = 4;
        locale.aJv().execute();
        break;
      }
    }
    com.tencent.mm.ui.widget.snackbar.b.n(paramActivity, paramActivity.getString(2131760233));
    com.tencent.mm.plugin.report.service.g.yhR.f(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38043);
        this.Kqo.finish();
        AppMethodBeat.o(38043);
      }
    }, 1800L);
    AppMethodBeat.o(38045);
  }
  
  public static String aWZ(String paramString)
  {
    AppMethodBeat.i(38044);
    Object localObject = p.aEx().Dj(paramString);
    ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(paramString);
    if (localam == null)
    {
      AppMethodBeat.o(38044);
      return null;
    }
    String str1;
    String str2;
    if (am.aSQ(paramString))
    {
      paramString = localam.field_openImAppid;
      str1 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(localam.field_openImAppid, "openim_desc_icon", b.a.iHu);
      str2 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bC(localam.field_openImAppid, localam.field_descWordingId);
      paramString = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { bt.aRc(((i)localObject).aEq()), bt.aRc(((i)localObject).aEr()), bt.aRc(localam.field_username), bt.aRc(localam.adu()), Integer.valueOf(localam.ePk), paramString, bt.aRc(str2), bt.aRc(str1) });
      AppMethodBeat.o(38044);
      return paramString;
    }
    int i = localam.ePj;
    if (localObject != null) {
      i = ((i)localObject).ePj;
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
    if (localam.fqg())
    {
      paramString = com.tencent.mm.am.g.eS(localam.field_username);
      localObject = bt.aRc(localam.field_username);
      str1 = bt.aRc(localam.adu());
      str2 = bt.aRc(localam.VA());
      str3 = bt.aRc(localam.adu());
      str4 = bt.aRc(localam.VD());
      str5 = bt.aRc(localam.getProvince());
      str6 = bt.aRc(localam.getCity());
      str7 = bt.aRc(localam.signature);
      j = localam.ePt;
      k = localam.ePk;
      m = localam.field_verifyFlag;
      str8 = bt.aRc(localam.ePz);
      if (paramString != null) {
        break label472;
      }
    }
    label472:
    for (paramString = "";; paramString = bt.aRc(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, bt.aRc(localam.ePA) });
      AppMethodBeat.o(38044);
      return paramString;
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ad
 * JD-Core Version:    0.7.0.1
 */