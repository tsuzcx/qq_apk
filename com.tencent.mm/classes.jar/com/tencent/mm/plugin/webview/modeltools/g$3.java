package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zq.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class g$3
  extends c<zq>
{
  g$3(g paramg)
  {
    AppMethodBeat.i(160426);
    this.__eventId = zq.class.getName().hashCode();
    AppMethodBeat.o(160426);
  }
  
  private static boolean a(zq paramzq)
  {
    AppMethodBeat.i(79154);
    Object localObject;
    String str1;
    if ((paramzq instanceof zq))
    {
      String str4 = v.aAC();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramzq.dPK.dPL);
      localArrayList.add(paramzq.dPK.dPM);
      localArrayList.add(paramzq.dPK.dPN);
      localArrayList.add(paramzq.dPK.dPO);
      localArrayList.add(paramzq.dPK.url);
      localArrayList.add(paramzq.dPK.dPP);
      localArrayList.add(paramzq.dPK.dPQ);
      localArrayList.add(paramzq.dPK.dPR);
      localArrayList.add(paramzq.dPK.dPS);
      localArrayList.add(paramzq.dPK.dPT);
      localArrayList.add(str4);
      localArrayList.add(paramzq.dPK.dPU);
      localArrayList.add(paramzq.dPK.dPV);
      PString localPString = new PString();
      String str5 = ((j)com.tencent.mm.kernel.g.ab(j.class)).a(paramzq.dPK.dPW, localPString);
      localArrayList.add(str5);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = y.aH(paramzq.dPK.dPN, paramzq.dPK.dPO);
      int j = y.aH(str4, paramzq.dPK.dPQ);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      String str2 = paramzq.dPK.dPX;
      localObject = paramzq.dPK.dPZ;
      for (str1 = str2;; str1 = str2)
      {
        try
        {
          str2 = URLEncoder.encode(str2, "UTF-8");
          str1 = str2;
          if (bu.isNullOrNil((String)localObject)) {
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
            ae.printErrStackTrace("MicroMsg.SubCoreTools", localException, "", new Object[0]);
            continue;
            str1 = paramzq.dPK.url.replace(",", "!");
            continue;
            localObject = paramzq.dPK.dPV.replace(",", "!");
          }
        }
        localArrayList.add(str1);
        localArrayList.add(localPString.value);
        localArrayList.add(localObject);
        str2 = paramzq.dPK.dPL;
        str3 = paramzq.dPK.dPM;
        str6 = paramzq.dPK.dPN;
        str7 = paramzq.dPK.dPO;
        if (paramzq.dPK.url != null) {
          break;
        }
        str1 = paramzq.dPK.url;
        k = paramzq.dPK.dPP;
        str8 = paramzq.dPK.dPQ;
        str9 = paramzq.dPK.dPR;
        m = paramzq.dPK.dPS;
        n = paramzq.dPK.dPT;
        i1 = paramzq.dPK.dPU;
        if (paramzq.dPK.dPV != null) {
          break label857;
        }
        localObject = paramzq.dPK.dPV;
        ae.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", new Object[] { str2, str3, str6, str7, str1, Integer.valueOf(k), str8, str9, Integer.valueOf(m), Integer.valueOf(n), str4, Integer.valueOf(i1), localObject, paramzq.dPK.dPW, str5, Integer.valueOf(i), Integer.valueOf(j), paramzq.dPK.dPX, localPString.value, paramzq.dPK.dPZ });
        if (paramzq.dPK.dPY != 2)
        {
          paramzq = com.tencent.mm.plugin.report.service.g.yxI;
          com.tencent.mm.plugin.report.service.g.m(11954, localArrayList);
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