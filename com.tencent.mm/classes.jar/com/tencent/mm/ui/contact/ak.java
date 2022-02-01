package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.List;

public final class ak
{
  public static void a(Activity paramActivity, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(38045);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String str = bCc((String)localObject);
      t.e locale = t.OH(paramString);
      locale.toUser = paramString;
      locale.content = str;
      if (au.bwO((String)localObject)) {}
      for (int i = 66;; i = 42)
      {
        localObject = locale.wF(i);
        ((t.e)localObject).eQp = 0;
        ((t.e)localObject).oNj = 4;
        ((t.e)localObject).bKW().aXz();
        break;
      }
    }
    b.u(paramActivity, paramActivity.getString(R.l.has_send));
    com.tencent.mm.plugin.report.service.h.OAn.b(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38043);
        ak.this.finish();
        AppMethodBeat.o(38043);
      }
    }, 1800L);
    AppMethodBeat.o(38045);
  }
  
  public static String bCc(String paramString)
  {
    AppMethodBeat.i(38044);
    Object localObject = q.bFE().LS(paramString);
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().JE(paramString);
    if (localau == null)
    {
      AppMethodBeat.o(38044);
      return null;
    }
    String str1;
    String str2;
    if (au.bwO(paramString))
    {
      paramString = localau.field_openImAppid;
      str1 = ((e)com.tencent.mm.kernel.h.ax(e.class)).a(localau.field_openImAppid, "openim_desc_icon", e.a.prc, 0);
      str2 = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(localau.field_openImAppid, localau.field_descWordingId);
      paramString = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { Util.escapeStringForXml(((j)localObject).bFw()), Util.escapeStringForXml(((j)localObject).bFx()), Util.escapeStringForXml(localau.field_username), Util.escapeStringForXml(localau.aSU()), Integer.valueOf(localau.sex), paramString, Util.escapeStringForXml(str2), Util.escapeStringForXml(str1) });
      AppMethodBeat.o(38044);
      return paramString;
    }
    int i = localau.jZY;
    if (localObject != null) {
      i = ((j)localObject).jZY;
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
    if (localau.iZC())
    {
      paramString = g.hU(localau.field_username);
      localObject = Util.escapeStringForXml(localau.field_username);
      str1 = Util.escapeStringForXml(localau.aSU());
      str2 = Util.escapeStringForXml(localau.aJs());
      str3 = Util.escapeStringForXml(localau.aSU());
      str4 = Util.escapeStringForXml(localau.aJt());
      str5 = Util.escapeStringForXml(localau.getProvince());
      str6 = Util.escapeStringForXml(localau.getCity());
      str7 = Util.escapeStringForXml(localau.signature);
      j = localau.kag;
      k = localau.sex;
      m = localau.field_verifyFlag;
      str8 = Util.escapeStringForXml(localau.verifyInfo);
      if (paramString != null) {
        break label473;
      }
    }
    label473:
    for (paramString = "";; paramString = Util.escapeStringForXml(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, Util.escapeStringForXml(localau.kaj) });
      AppMethodBeat.o(38044);
      return paramString;
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ak
 * JD-Core Version:    0.7.0.1
 */