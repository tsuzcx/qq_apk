package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aax.a;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class g$3
  extends IListener<aax>
{
  g$3(g paramg)
  {
    AppMethodBeat.i(160426);
    this.__eventId = aax.class.getName().hashCode();
    AppMethodBeat.o(160426);
  }
  
  private static boolean a(aax paramaax)
  {
    AppMethodBeat.i(79154);
    Object localObject;
    String str1;
    if ((paramaax instanceof aax))
    {
      String str4 = z.aTY();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaax.ehN.ehO);
      localArrayList.add(paramaax.ehN.ehP);
      localArrayList.add(paramaax.ehN.ehQ);
      localArrayList.add(paramaax.ehN.ehR);
      localArrayList.add(paramaax.ehN.url);
      localArrayList.add(paramaax.ehN.ehS);
      localArrayList.add(paramaax.ehN.ehT);
      localArrayList.add(paramaax.ehN.ehU);
      localArrayList.add(paramaax.ehN.ehV);
      localArrayList.add(paramaax.ehN.ehW);
      localArrayList.add(str4);
      localArrayList.add(paramaax.ehN.ehX);
      localArrayList.add(paramaax.ehN.ehY);
      PString localPString = new PString();
      String str5 = ((j)com.tencent.mm.kernel.g.af(j.class)).a(paramaax.ehN.ehZ, localPString);
      localArrayList.add(str5);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = ac.aJ(paramaax.ehN.ehQ, paramaax.ehN.ehR);
      int j = ac.aJ(str4, paramaax.ehN.ehT);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      String str2 = paramaax.ehN.eia;
      localObject = paramaax.ehN.eic;
      for (str1 = str2;; str1 = str2)
      {
        try
        {
          str2 = URLEncoder.encode(str2, "UTF-8");
          str1 = str2;
          if (Util.isNullOrNil((String)localObject)) {
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
            Log.printErrStackTrace("MicroMsg.SubCoreTools", localException, "", new Object[0]);
            continue;
            str1 = paramaax.ehN.url.replace(",", "!");
            continue;
            localObject = paramaax.ehN.ehY.replace(",", "!");
          }
        }
        localArrayList.add(str1);
        localArrayList.add(localPString.value);
        localArrayList.add(localObject);
        str2 = paramaax.ehN.ehO;
        str3 = paramaax.ehN.ehP;
        str6 = paramaax.ehN.ehQ;
        str7 = paramaax.ehN.ehR;
        if (paramaax.ehN.url != null) {
          break;
        }
        str1 = paramaax.ehN.url;
        k = paramaax.ehN.ehS;
        str8 = paramaax.ehN.ehT;
        str9 = paramaax.ehN.ehU;
        m = paramaax.ehN.ehV;
        n = paramaax.ehN.ehW;
        i1 = paramaax.ehN.ehX;
        if (paramaax.ehN.ehY != null) {
          break label857;
        }
        localObject = paramaax.ehN.ehY;
        Log.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", new Object[] { str2, str3, str6, str7, str1, Integer.valueOf(k), str8, str9, Integer.valueOf(m), Integer.valueOf(n), str4, Integer.valueOf(i1), localObject, paramaax.ehN.ehZ, str5, Integer.valueOf(i), Integer.valueOf(j), paramaax.ehN.eia, localPString.value, paramaax.ehN.eic });
        if (paramaax.ehN.eib != 2)
        {
          paramaax = h.CyF;
          h.r(11954, localArrayList);
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