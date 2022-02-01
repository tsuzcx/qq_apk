package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.acf;
import com.tencent.mm.f.a.acf.a;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

final class f$3
  extends IListener<acf>
{
  f$3(f paramf)
  {
    AppMethodBeat.i(160426);
    this.__eventId = acf.class.getName().hashCode();
    AppMethodBeat.o(160426);
  }
  
  private static boolean a(acf paramacf)
  {
    AppMethodBeat.i(79154);
    Object localObject;
    String str1;
    if ((paramacf instanceof acf))
    {
      String str4 = z.bcZ();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramacf.gce.gcf);
      localArrayList.add(paramacf.gce.gcg);
      localArrayList.add(paramacf.gce.gch);
      localArrayList.add(paramacf.gce.gci);
      localArrayList.add(paramacf.gce.url);
      localArrayList.add(paramacf.gce.gcj);
      localArrayList.add(paramacf.gce.gck);
      localArrayList.add(paramacf.gce.gcl);
      localArrayList.add(paramacf.gce.gcm);
      localArrayList.add(paramacf.gce.gcn);
      localArrayList.add(str4);
      localArrayList.add(paramacf.gce.gco);
      localArrayList.add(paramacf.gce.gcp);
      PString localPString = new PString();
      String str5 = ((k)com.tencent.mm.kernel.h.ae(k.class)).a(paramacf.gce.gcq, localPString);
      localArrayList.add(str5);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      int i = ac.aN(paramacf.gce.gch, paramacf.gce.gci);
      int j = ac.aN(str4, paramacf.gce.gck);
      localArrayList.add(String.valueOf(i));
      localArrayList.add(String.valueOf(j));
      String str2 = paramacf.gce.gcr;
      localObject = paramacf.gce.gct;
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
            str1 = paramacf.gce.url.replace(",", "!");
            continue;
            localObject = paramacf.gce.gcp.replace(",", "!");
          }
        }
        localArrayList.add(str1);
        localArrayList.add(localPString.value);
        localArrayList.add(localObject);
        str2 = paramacf.gce.gcf;
        str3 = paramacf.gce.gcg;
        str6 = paramacf.gce.gch;
        str7 = paramacf.gce.gci;
        if (paramacf.gce.url != null) {
          break;
        }
        str1 = paramacf.gce.url;
        k = paramacf.gce.gcj;
        str8 = paramacf.gce.gck;
        str9 = paramacf.gce.gcl;
        m = paramacf.gce.gcm;
        n = paramacf.gce.gcn;
        i1 = paramacf.gce.gco;
        if (paramacf.gce.gcp != null) {
          break label857;
        }
        localObject = paramacf.gce.gcp;
        Log.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", new Object[] { str2, str3, str6, str7, str1, Integer.valueOf(k), str8, str9, Integer.valueOf(m), Integer.valueOf(n), str4, Integer.valueOf(i1), localObject, paramacf.gce.gcq, str5, Integer.valueOf(i), Integer.valueOf(j), paramacf.gce.gcr, localPString.value, paramacf.gce.gct });
        if (paramacf.gce.gcs != 2)
        {
          paramacf = com.tencent.mm.plugin.report.service.h.IzE;
          com.tencent.mm.plugin.report.service.h.u(11954, localArrayList);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.f.3
 * JD-Core Version:    0.7.0.1
 */