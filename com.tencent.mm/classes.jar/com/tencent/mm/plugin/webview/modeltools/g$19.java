package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.h.a.um;
import com.tencent.mm.h.a.um.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class g$19
  extends c<um>
{
  g$19(g paramg)
  {
    this.udX = um.class.getName().hashCode();
  }
  
  private static boolean a(um paramum)
  {
    Object localObject;
    if ((paramum instanceof um))
    {
      String str3 = q.Gj();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramum.ceR.ceS);
      localArrayList.add(paramum.ceR.ceT);
      localArrayList.add(paramum.ceR.ceU);
      localArrayList.add(paramum.ceR.ceV);
      localArrayList.add(paramum.ceR.url);
      localArrayList.add(paramum.ceR.ceW);
      localArrayList.add(paramum.ceR.ceX);
      localArrayList.add(paramum.ceR.ceY);
      localArrayList.add(paramum.ceR.ceZ);
      localArrayList.add(paramum.ceR.cfa);
      localArrayList.add(str3);
      localArrayList.add(paramum.ceR.cfb);
      localArrayList.add(paramum.ceR.cfc);
      PString localPString = new PString();
      String str4 = ((i)com.tencent.mm.kernel.g.r(i.class)).a(paramum.ceR.cfd, localPString);
      localArrayList.add(str4);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = t.R(paramum.ceR.ceU, paramum.ceR.ceV);
      int j = t.R(str3, paramum.ceR.ceX);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      localObject = paramum.ceR.cfe;
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
          y.printErrStackTrace("MicroMsg.SubCoreTools", localException, "", new Object[0]);
          continue;
          localObject = paramum.ceR.url.replace(",", "!");
          continue;
          String str2 = paramum.ceR.cfc.replace(",", "!");
        }
      }
      localArrayList.add(localObject);
      localArrayList.add(localPString.value);
      str5 = paramum.ceR.ceS;
      str6 = paramum.ceR.ceT;
      str7 = paramum.ceR.ceU;
      str8 = paramum.ceR.ceV;
      if (paramum.ceR.url == null)
      {
        localObject = paramum.ceR.url;
        k = paramum.ceR.ceW;
        str9 = paramum.ceR.ceX;
        str10 = paramum.ceR.ceY;
        m = paramum.ceR.ceZ;
        n = paramum.ceR.cfa;
        i1 = paramum.ceR.cfb;
        if (paramum.ceR.cfc != null) {
          break label773;
        }
        str1 = paramum.ceR.cfc;
        y.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s", new Object[] { str5, str6, str7, str8, localObject, Integer.valueOf(k), str9, str10, Integer.valueOf(m), Integer.valueOf(n), str3, Integer.valueOf(i1), str1, paramum.ceR.cfd, str4, Integer.valueOf(i), Integer.valueOf(j), paramum.ceR.cfe, localPString.value });
        if (paramum.ceR.cff != 2)
        {
          paramum = h.nFQ;
          h.f(11954, localArrayList);
        }
        return true;
      }
    }
    label773:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.g.19
 * JD-Core Version:    0.7.0.1
 */