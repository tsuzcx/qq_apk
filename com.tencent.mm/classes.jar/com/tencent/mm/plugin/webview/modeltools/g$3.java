package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.a.yq.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class g$3
  extends c<yq>
{
  g$3(g paramg)
  {
    AppMethodBeat.i(160426);
    this.__eventId = yq.class.getName().hashCode();
    AppMethodBeat.o(160426);
  }
  
  private static boolean a(yq paramyq)
  {
    AppMethodBeat.i(79154);
    Object localObject;
    String str1;
    if ((paramyq instanceof yq))
    {
      String str4 = u.axw();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramyq.dCh.dCi);
      localArrayList.add(paramyq.dCh.dCj);
      localArrayList.add(paramyq.dCh.dCk);
      localArrayList.add(paramyq.dCh.dCl);
      localArrayList.add(paramyq.dCh.url);
      localArrayList.add(paramyq.dCh.dCm);
      localArrayList.add(paramyq.dCh.dCn);
      localArrayList.add(paramyq.dCh.dCo);
      localArrayList.add(paramyq.dCh.dCp);
      localArrayList.add(paramyq.dCh.dCq);
      localArrayList.add(str4);
      localArrayList.add(paramyq.dCh.dCr);
      localArrayList.add(paramyq.dCh.dCs);
      PString localPString = new PString();
      String str5 = ((j)com.tencent.mm.kernel.g.ab(j.class)).a(paramyq.dCh.dCt, localPString);
      localArrayList.add(str5);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = x.aE(paramyq.dCh.dCk, paramyq.dCh.dCl);
      int j = x.aE(str4, paramyq.dCh.dCn);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      String str2 = paramyq.dCh.dCu;
      localObject = paramyq.dCh.dCw;
      for (str1 = str2;; str1 = str2)
      {
        try
        {
          str2 = URLEncoder.encode(str2, "UTF-8");
          str1 = str2;
          if (bs.isNullOrNil((String)localObject)) {
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
            ac.printErrStackTrace("MicroMsg.SubCoreTools", localException, "", new Object[0]);
            continue;
            str1 = paramyq.dCh.url.replace(",", "!");
            continue;
            localObject = paramyq.dCh.dCs.replace(",", "!");
          }
        }
        localArrayList.add(str1);
        localArrayList.add(localPString.value);
        localArrayList.add(localObject);
        str2 = paramyq.dCh.dCi;
        str3 = paramyq.dCh.dCj;
        str6 = paramyq.dCh.dCk;
        str7 = paramyq.dCh.dCl;
        if (paramyq.dCh.url != null) {
          break;
        }
        str1 = paramyq.dCh.url;
        k = paramyq.dCh.dCm;
        str8 = paramyq.dCh.dCn;
        str9 = paramyq.dCh.dCo;
        m = paramyq.dCh.dCp;
        n = paramyq.dCh.dCq;
        i1 = paramyq.dCh.dCr;
        if (paramyq.dCh.dCs != null) {
          break label857;
        }
        localObject = paramyq.dCh.dCs;
        ac.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", new Object[] { str2, str3, str6, str7, str1, Integer.valueOf(k), str8, str9, Integer.valueOf(m), Integer.valueOf(n), str4, Integer.valueOf(i1), localObject, paramyq.dCh.dCt, str5, Integer.valueOf(i), Integer.valueOf(j), paramyq.dCh.dCu, localPString.value, paramyq.dCh.dCw });
        if (paramyq.dCh.dCv != 2)
        {
          paramyq = h.wUl;
          h.k(11954, localArrayList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.3
 * JD-Core Version:    0.7.0.1
 */