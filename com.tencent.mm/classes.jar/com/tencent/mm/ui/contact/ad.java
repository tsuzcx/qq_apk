package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.widget.snackbar.b;
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
      String str2 = aYA(str1);
      o.e locale = o.Gz(paramString);
      locale.toUser = paramString;
      locale.content = str2;
      if (an.aUq(str1)) {}
      for (int i = 66;; i = 42)
      {
        locale.type = i;
        locale.dEu = 0;
        locale.iiV = 4;
        locale.aJO().execute();
        break;
      }
    }
    b.n(paramActivity, paramActivity.getString(2131760233));
    com.tencent.mm.plugin.report.service.g.yxI.f(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38043);
        this.KMI.finish();
        AppMethodBeat.o(38043);
      }
    }, 1800L);
    AppMethodBeat.o(38045);
  }
  
  public static String aYA(String paramString)
  {
    AppMethodBeat.i(38044);
    Object localObject = p.aEN().DL(paramString);
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(paramString);
    if (localan == null)
    {
      AppMethodBeat.o(38044);
      return null;
    }
    String str1;
    String str2;
    if (an.aUq(paramString))
    {
      paramString = localan.field_openImAppid;
      str1 = ((a)com.tencent.mm.kernel.g.ab(a.class)).c(localan.field_openImAppid, "openim_desc_icon", a.a.iKn);
      str2 = ((a)com.tencent.mm.kernel.g.ab(a.class)).bC(localan.field_openImAppid, localan.field_descWordingId);
      paramString = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { bu.aSz(((i)localObject).aEG()), bu.aSz(((i)localObject).aEH()), bu.aSz(localan.field_username), bu.aSz(localan.adF()), Integer.valueOf(localan.eQV), paramString, bu.aSz(str2), bu.aSz(str1) });
      AppMethodBeat.o(38044);
      return paramString;
    }
    int i = localan.eQU;
    if (localObject != null) {
      i = ((i)localObject).eQU;
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
    if (localan.fug())
    {
      paramString = com.tencent.mm.al.g.eX(localan.field_username);
      localObject = bu.aSz(localan.field_username);
      str1 = bu.aSz(localan.adF());
      str2 = bu.aSz(localan.VI());
      str3 = bu.aSz(localan.adF());
      str4 = bu.aSz(localan.VL());
      str5 = bu.aSz(localan.getProvince());
      str6 = bu.aSz(localan.getCity());
      str7 = bu.aSz(localan.signature);
      j = localan.eRe;
      k = localan.eQV;
      m = localan.field_verifyFlag;
      str8 = bu.aSz(localan.eRk);
      if (paramString != null) {
        break label472;
      }
    }
    label472:
    for (paramString = "";; paramString = bu.aSz(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, bu.aSz(localan.eRl) });
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