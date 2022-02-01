package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zk.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class g$3
  extends c<zk>
{
  g$3(g paramg)
  {
    AppMethodBeat.i(160426);
    this.__eventId = zk.class.getName().hashCode();
    AppMethodBeat.o(160426);
  }
  
  private static boolean a(zk paramzk)
  {
    AppMethodBeat.i(79154);
    Object localObject;
    String str1;
    if ((paramzk instanceof zk))
    {
      String str4 = u.aAm();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramzk.dOu.dOv);
      localArrayList.add(paramzk.dOu.dOw);
      localArrayList.add(paramzk.dOu.dOx);
      localArrayList.add(paramzk.dOu.dOy);
      localArrayList.add(paramzk.dOu.url);
      localArrayList.add(paramzk.dOu.dOz);
      localArrayList.add(paramzk.dOu.dOA);
      localArrayList.add(paramzk.dOu.dOB);
      localArrayList.add(paramzk.dOu.dOC);
      localArrayList.add(paramzk.dOu.dOD);
      localArrayList.add(str4);
      localArrayList.add(paramzk.dOu.dOE);
      localArrayList.add(paramzk.dOu.dOF);
      PString localPString = new PString();
      String str5 = ((j)com.tencent.mm.kernel.g.ab(j.class)).a(paramzk.dOu.dOG, localPString);
      localArrayList.add(str5);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = x.aG(paramzk.dOu.dOx, paramzk.dOu.dOy);
      int j = x.aG(str4, paramzk.dOu.dOA);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      String str2 = paramzk.dOu.dOH;
      localObject = paramzk.dOu.dOJ;
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
            str1 = paramzk.dOu.url.replace(",", "!");
            continue;
            localObject = paramzk.dOu.dOF.replace(",", "!");
          }
        }
        localArrayList.add(str1);
        localArrayList.add(localPString.value);
        localArrayList.add(localObject);
        str2 = paramzk.dOu.dOv;
        str3 = paramzk.dOu.dOw;
        str6 = paramzk.dOu.dOx;
        str7 = paramzk.dOu.dOy;
        if (paramzk.dOu.url != null) {
          break;
        }
        str1 = paramzk.dOu.url;
        k = paramzk.dOu.dOz;
        str8 = paramzk.dOu.dOA;
        str9 = paramzk.dOu.dOB;
        m = paramzk.dOu.dOC;
        n = paramzk.dOu.dOD;
        i1 = paramzk.dOu.dOE;
        if (paramzk.dOu.dOF != null) {
          break label857;
        }
        localObject = paramzk.dOu.dOF;
        ad.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", new Object[] { str2, str3, str6, str7, str1, Integer.valueOf(k), str8, str9, Integer.valueOf(m), Integer.valueOf(n), str4, Integer.valueOf(i1), localObject, paramzk.dOu.dOG, str5, Integer.valueOf(i), Integer.valueOf(j), paramzk.dOu.dOH, localPString.value, paramzk.dOu.dOJ });
        if (paramzk.dOu.dOI != 2)
        {
          paramzk = com.tencent.mm.plugin.report.service.g.yhR;
          com.tencent.mm.plugin.report.service.g.l(11954, localArrayList);
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