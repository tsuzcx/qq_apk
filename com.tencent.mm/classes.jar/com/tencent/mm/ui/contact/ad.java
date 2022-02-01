package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
      String str = aRb((String)localObject);
      if (ai.aNc((String)localObject)) {}
      for (int i = 66;; i = 42)
      {
        localObject = new com.tencent.mm.modelmulti.i(paramString, str, i, 0);
        az.agi().a((n)localObject, 0);
        break;
      }
    }
    com.tencent.mm.ui.widget.snackbar.b.n(paramActivity, paramActivity.getString(2131760233));
    h.wUl.f(11003, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramList.size()) });
    paramActivity.setResult(-1);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38043);
        this.Izi.finish();
        AppMethodBeat.o(38043);
      }
    }, 1800L);
    AppMethodBeat.o(38045);
  }
  
  public static String aRb(String paramString)
  {
    AppMethodBeat.i(38044);
    Object localObject = p.aBw().Ak(paramString);
    az.ayM();
    ai localai = com.tencent.mm.model.c.awB().aNt(paramString);
    if (localai == null)
    {
      AppMethodBeat.o(38044);
      return null;
    }
    String str1;
    String str2;
    if (ai.aNc(paramString))
    {
      paramString = localai.field_openImAppid;
      str1 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).c(localai.field_openImAppid, "openim_desc_icon", b.a.inX);
      str2 = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bB(localai.field_openImAppid, localai.field_descWordingId);
      paramString = String.format(" <msg bigheadimgurl=\"%s\" smallheadimgurl=\"%s\" username=\"%s\" nickname=\"%s\" sex=\"%d\"  openimappid=\"%s\" openimdesc=\"%s\" openimdescicon=\"%s\"/>", new Object[] { bs.aLw(((com.tencent.mm.aj.i)localObject).aBo()), bs.aLw(((com.tencent.mm.aj.i)localObject).aBp()), bs.aLw(localai.field_username), bs.aLw(localai.aaR()), Integer.valueOf(localai.exL), paramString, bs.aLw(str2), bs.aLw(str1) });
      AppMethodBeat.o(38044);
      return paramString;
    }
    int i = localai.exK;
    if (localObject != null) {
      i = ((com.tencent.mm.aj.i)localObject).exK;
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
    if (localai.fad())
    {
      paramString = f.dX(localai.field_username);
      localObject = bs.aLw(localai.field_username);
      str1 = bs.aLw(localai.aaR());
      str2 = bs.aLw(localai.Tl());
      str3 = bs.aLw(localai.aaR());
      str4 = bs.aLw(localai.To());
      str5 = bs.aLw(localai.getProvince());
      str6 = bs.aLw(localai.getCity());
      str7 = bs.aLw(localai.signature);
      j = localai.exU;
      k = localai.exL;
      m = localai.field_verifyFlag;
      str8 = bs.aLw(localai.eya);
      if (paramString != null) {
        break label470;
      }
    }
    label470:
    for (paramString = "";; paramString = bs.aLw(paramString.field_brandIconURL))
    {
      paramString = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", new Object[] { localObject, str1, str2, str3, str4, Integer.valueOf(i), str5, str6, str7, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), str8, paramString, bs.aLw(localai.eyb) });
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