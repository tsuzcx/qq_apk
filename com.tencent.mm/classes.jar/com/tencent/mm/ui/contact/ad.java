package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
      Object localObject = (String)localIterator.next();
      String str = bnD((String)localObject);
      o.e locale = o.Pl(paramString);
      locale.toUser = paramString;
      locale.content = str;
      if (as.bjp((String)localObject)) {}
      for (int i = 66;; i = 42)
      {
        localObject = locale.tD(i);
        ((o.e)localObject).cSx = 0;
        ((o.e)localObject).jdR = 4;
        ((o.e)localObject).bdQ().execute();
        break;
      }
    }
    b.r(paramActivity, paramActivity.getString(2131761619));
    h.CyF.a(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38043);
        this.PZI.finish();
        AppMethodBeat.o(38043);
      }
    }, 1800L);
    AppMethodBeat.o(38045);
  }
  
  public static String bnD(String paramString)
  {
    AppMethodBeat.i(38044);
    Object localObject = p.aYB().Mx(paramString);
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(paramString);
    if (localas == null)
    {
      AppMethodBeat.o(38044);
      return null;
    }
    String str1;
    String str2;
    if (as.bjp(paramString))
    {
      paramString = localas.field_openImAppid;
      str1 = ((a)com.tencent.mm.kernel.g.af(a.class)).c(localas.field_openImAppid, "openim_desc_icon", a.a.jGT);
      str2 = ((a)com.tencent.mm.kernel.g.af(a.class)).bN(localas.field_openImAppid, localas.field_descWordingId);
      paramString = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { Util.escapeStringForXml(((i)localObject).aYt()), Util.escapeStringForXml(((i)localObject).aYu()), Util.escapeStringForXml(localas.field_username), Util.escapeStringForXml(localas.arI()), Integer.valueOf(localas.fuA), paramString, Util.escapeStringForXml(str2), Util.escapeStringForXml(str1) });
      AppMethodBeat.o(38044);
      return paramString;
    }
    int i = localas.fuz;
    if (localObject != null) {
      i = ((i)localObject).fuz;
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
    if (localas.gBM())
    {
      paramString = com.tencent.mm.al.g.fJ(localas.field_username);
      localObject = Util.escapeStringForXml(localas.field_username);
      str1 = Util.escapeStringForXml(localas.arI());
      str2 = Util.escapeStringForXml(localas.ajx());
      str3 = Util.escapeStringForXml(localas.arI());
      str4 = Util.escapeStringForXml(localas.ajz());
      str5 = Util.escapeStringForXml(localas.getProvince());
      str6 = Util.escapeStringForXml(localas.getCity());
      str7 = Util.escapeStringForXml(localas.signature);
      j = localas.fuI;
      k = localas.fuA;
      m = localas.field_verifyFlag;
      str8 = Util.escapeStringForXml(localas.fuN);
      if (paramString != null) {
        break label472;
      }
    }
    label472:
    for (paramString = "";; paramString = Util.escapeStringForXml(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, Util.escapeStringForXml(localas.fuO) });
      AppMethodBeat.o(38044);
      return paramString;
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ad
 * JD-Core Version:    0.7.0.1
 */