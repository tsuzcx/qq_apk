package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.g.a.yf.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class g$3
  extends c<yf>
{
  g$3(g paramg)
  {
    AppMethodBeat.i(160426);
    this.__eventId = yf.class.getName().hashCode();
    AppMethodBeat.o(160426);
  }
  
  private static boolean a(yf paramyf)
  {
    AppMethodBeat.i(79154);
    Object localObject;
    String str1;
    if ((paramyf instanceof yf))
    {
      String str4 = u.aqG();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramyf.dEv.dEw);
      localArrayList.add(paramyf.dEv.dEx);
      localArrayList.add(paramyf.dEv.dEy);
      localArrayList.add(paramyf.dEv.dEz);
      localArrayList.add(paramyf.dEv.url);
      localArrayList.add(paramyf.dEv.dEA);
      localArrayList.add(paramyf.dEv.dEB);
      localArrayList.add(paramyf.dEv.dEC);
      localArrayList.add(paramyf.dEv.dED);
      localArrayList.add(paramyf.dEv.dEE);
      localArrayList.add(str4);
      localArrayList.add(paramyf.dEv.dEF);
      localArrayList.add(paramyf.dEv.dEG);
      PString localPString = new PString();
      String str5 = ((j)com.tencent.mm.kernel.g.ab(j.class)).a(paramyf.dEv.dEH, localPString);
      localArrayList.add(str5);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = x.aw(paramyf.dEv.dEy, paramyf.dEv.dEz);
      int j = x.aw(str4, paramyf.dEv.dEB);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      String str2 = paramyf.dEv.dEI;
      localObject = paramyf.dEv.dEK;
      for (str1 = str2;; str1 = str2)
      {
        try
        {
          str2 = URLEncoder.encode(str2, "UTF-8");
          str1 = str2;
          if (bt.isNullOrNil((String)localObject)) {
            break label809;
          }
          str1 = str2;
          str3 = URLEncoder.encode((String)localObject, "UTF-8");
          localObject = str3;
          str1 = str2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str3;
            String str6;
            String str7;
            int k;
            String str8;
            String str9;
            int m;
            int n;
            int i1;
            label809:
            ad.printErrStackTrace("MicroMsg.SubCoreTools", localException, "", new Object[0]);
            continue;
            str1 = paramyf.dEv.url.replace(",", "!");
            continue;
            localObject = paramyf.dEv.dEG.replace(",", "!");
          }
        }
        localArrayList.add(str1);
        localArrayList.add(localPString.value);
        localArrayList.add(localObject);
        str2 = paramyf.dEv.dEw;
        str3 = paramyf.dEv.dEx;
        str6 = paramyf.dEv.dEy;
        str7 = paramyf.dEv.dEz;
        if (paramyf.dEv.url != null) {
          break;
        }
        str1 = paramyf.dEv.url;
        k = paramyf.dEv.dEA;
        str8 = paramyf.dEv.dEB;
        str9 = paramyf.dEv.dEC;
        m = paramyf.dEv.dED;
        n = paramyf.dEv.dEE;
        i1 = paramyf.dEv.dEF;
        if (paramyf.dEv.dEG != null) {
          break label857;
        }
        localObject = paramyf.dEv.dEG;
        ad.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", new Object[] { str2, str3, str6, str7, str1, Integer.valueOf(k), str8, str9, Integer.valueOf(m), Integer.valueOf(n), str4, Integer.valueOf(i1), localObject, paramyf.dEv.dEH, str5, Integer.valueOf(i), Integer.valueOf(j), paramyf.dEv.dEI, localPString.value, paramyf.dEv.dEK });
        if (paramyf.dEv.dEJ != 2)
        {
          paramyf = h.vKh;
          h.h(11954, localArrayList);
        }
        AppMethodBeat.o(79154);
        return true;
        localObject = "";
      }
    }
    label857:
    AppMethodBeat.o(79154);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.3
 * JD-Core Version:    0.7.0.1
 */