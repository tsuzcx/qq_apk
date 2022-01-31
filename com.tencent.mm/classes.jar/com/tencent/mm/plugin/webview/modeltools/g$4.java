package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.g.a.wg.a;
import com.tencent.mm.model.r;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class g$4
  extends c<wg>
{
  g$4(g paramg)
  {
    AppMethodBeat.i(6966);
    this.__eventId = wg.class.getName().hashCode();
    AppMethodBeat.o(6966);
  }
  
  private static boolean a(wg paramwg)
  {
    AppMethodBeat.i(153147);
    Object localObject;
    if ((paramwg instanceof wg))
    {
      String str3 = r.Zn();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramwg.cNx.cNy);
      localArrayList.add(paramwg.cNx.cNz);
      localArrayList.add(paramwg.cNx.cNA);
      localArrayList.add(paramwg.cNx.cNB);
      localArrayList.add(paramwg.cNx.url);
      localArrayList.add(paramwg.cNx.cNC);
      localArrayList.add(paramwg.cNx.cND);
      localArrayList.add(paramwg.cNx.cNE);
      localArrayList.add(paramwg.cNx.cNF);
      localArrayList.add(paramwg.cNx.cNG);
      localArrayList.add(str3);
      localArrayList.add(paramwg.cNx.cNH);
      localArrayList.add(paramwg.cNx.cNI);
      PString localPString = new PString();
      String str4 = ((i)com.tencent.mm.kernel.g.E(i.class)).a(paramwg.cNx.cNJ, localPString);
      localArrayList.add(str4);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = u.ah(paramwg.cNx.cNA, paramwg.cNx.cNB);
      int j = u.ah(str3, paramwg.cNx.cND);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      localObject = paramwg.cNx.cNK;
      try
      {
        str1 = URLEncoder.encode((String)localObject, "UTF-8");
        localObject = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1;
          String str5;
          String str6;
          String str7;
          String str8;
          int k;
          String str9;
          String str10;
          int m;
          int n;
          int i1;
          ab.printErrStackTrace("MicroMsg.SubCoreTools", localException, "", new Object[0]);
          continue;
          localObject = paramwg.cNx.url.replace(",", "!");
          continue;
          String str2 = paramwg.cNx.cNI.replace(",", "!");
        }
      }
      localArrayList.add(localObject);
      localArrayList.add(localPString.value);
      str5 = paramwg.cNx.cNy;
      str6 = paramwg.cNx.cNz;
      str7 = paramwg.cNx.cNA;
      str8 = paramwg.cNx.cNB;
      if (paramwg.cNx.url == null)
      {
        localObject = paramwg.cNx.url;
        k = paramwg.cNx.cNC;
        str9 = paramwg.cNx.cND;
        str10 = paramwg.cNx.cNE;
        m = paramwg.cNx.cNF;
        n = paramwg.cNx.cNG;
        i1 = paramwg.cNx.cNH;
        if (paramwg.cNx.cNI != null) {
          break label783;
        }
        str1 = paramwg.cNx.cNI;
        ab.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s", new Object[] { str5, str6, str7, str8, localObject, Integer.valueOf(k), str9, str10, Integer.valueOf(m), Integer.valueOf(n), str3, Integer.valueOf(i1), str1, paramwg.cNx.cNJ, str4, Integer.valueOf(i), Integer.valueOf(j), paramwg.cNx.cNK, localPString.value });
        if (paramwg.cNx.cNL != 2)
        {
          paramwg = h.qsU;
          h.g(11954, localArrayList);
        }
        AppMethodBeat.o(153147);
        return true;
      }
    }
    label783:
    AppMethodBeat.o(153147);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.4
 * JD-Core Version:    0.7.0.1
 */