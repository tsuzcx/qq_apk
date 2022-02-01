package com.tencent.mm.plugin.webview.modeltools;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aec;
import com.tencent.mm.autogen.a.aec.a;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

class SubCoreTools$10
  extends IListener<aec>
{
  SubCoreTools$10(g paramg, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(295777);
    this.__eventId = aec.class.getName().hashCode();
    AppMethodBeat.o(295777);
  }
  
  private static boolean a(aec paramaec)
  {
    AppMethodBeat.i(295796);
    Object localObject;
    String str1;
    if ((paramaec instanceof aec))
    {
      String str4 = z.bAM();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaec.iiq.iir);
      localArrayList.add(paramaec.iiq.iis);
      localArrayList.add(paramaec.iiq.iit);
      localArrayList.add(paramaec.iiq.iiu);
      localArrayList.add(paramaec.iiq.url);
      localArrayList.add(paramaec.iiq.iiv);
      localArrayList.add(paramaec.iiq.iiw);
      localArrayList.add(paramaec.iiq.iix);
      localArrayList.add(paramaec.iiq.iiy);
      localArrayList.add(paramaec.iiq.iiz);
      localArrayList.add(str4);
      localArrayList.add(paramaec.iiq.iiA);
      localArrayList.add(paramaec.iiq.iiB);
      PString localPString = new PString();
      String str5 = ((l)com.tencent.mm.kernel.h.ax(l.class)).a(paramaec.iiq.iiC, localPString);
      localArrayList.add(str5);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = ac.aX(paramaec.iiq.iit, paramaec.iiq.iiu);
      int j = ac.aX(str4, paramaec.iiq.iiw);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      String str2 = paramaec.iiq.iiD;
      localObject = paramaec.iiq.iiF;
      for (str1 = str2;; str1 = str2)
      {
        try
        {
          str2 = URLEncoder.encode(str2, "UTF-8");
          str1 = str2;
          if (Util.isNullOrNil((String)localObject)) {
            break label836;
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
            label836:
            Log.printErrStackTrace("MicroMsg.SubCoreTools", localException, "", new Object[0]);
            continue;
            str1 = "0";
            continue;
            str1 = paramaec.iiq.url.replace(",", "!");
            continue;
            localObject = paramaec.iiq.iiB.replace(",", "!");
          }
        }
        localArrayList.add(str1);
        localArrayList.add(localPString.value);
        localArrayList.add(localObject);
        if (!v.Iv(paramaec.iiq.iiw)) {
          break;
        }
        str1 = "1";
        localArrayList.add(str1);
        str2 = paramaec.iiq.iir;
        str3 = paramaec.iiq.iis;
        str6 = paramaec.iiq.iit;
        str7 = paramaec.iiq.iiu;
        if (paramaec.iiq.url != null) {
          break label872;
        }
        str1 = paramaec.iiq.url;
        k = paramaec.iiq.iiv;
        str8 = paramaec.iiq.iiw;
        str9 = paramaec.iiq.iix;
        m = paramaec.iiq.iiy;
        n = paramaec.iiq.iiz;
        i1 = paramaec.iiq.iiA;
        if (paramaec.iiq.iiB != null) {
          break label891;
        }
        localObject = paramaec.iiq.iiB;
        Log.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", new Object[] { str2, str3, str6, str7, str1, Integer.valueOf(k), str8, str9, Integer.valueOf(m), Integer.valueOf(n), str4, Integer.valueOf(i1), localObject, paramaec.iiq.iiC, str5, Integer.valueOf(i), Integer.valueOf(j), paramaec.iiq.iiD, localPString.value, paramaec.iiq.iiF });
        if (paramaec.iiq.iiE != 2)
        {
          paramaec = com.tencent.mm.plugin.report.service.h.OAn;
          com.tencent.mm.plugin.report.service.h.P(11954, localArrayList);
        }
        AppMethodBeat.o(295796);
        return true;
        localObject = "";
      }
    }
    label872:
    label891:
    AppMethodBeat.o(295796);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.SubCoreTools.10
 * JD-Core Version:    0.7.0.1
 */