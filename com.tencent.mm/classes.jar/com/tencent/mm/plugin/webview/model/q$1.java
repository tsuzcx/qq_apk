package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

final class q$1
  implements b.a
{
  q$1(q paramq, Integer paramInteger) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(153132);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(153132);
      return;
    }
    q localq = this.uVE;
    paramString = this.uVD;
    aqs localaqs = (aqs)paramb.fsW.fta;
    ab.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramString + "  response.MsgList.size() = " + localaqs.xfZ.size());
    if (!localq.uVB.remove(paramString))
    {
      ab.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
      AppMethodBeat.o(153132);
      return;
    }
    paramString = "";
    paramInt1 = 0;
    if (paramInt1 < localaqs.xfZ.size())
    {
      clt localclt = (clt)localaqs.xfZ.get(paramInt1);
      if ((localclt == null) || (localclt.Ret != 0) || (localclt.xVM == null) || (localclt.xVM.trim().length() == 0))
      {
        ab.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
        paramb = paramString;
        if (localclt != null)
        {
          ab.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localclt.xVJ + " TranslatedText = " + localclt.xVM + " ret = " + localclt.Ret);
          paramb = paramString;
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        paramString = paramb;
        break;
        paramb = paramString;
        if (localclt.xVN != null)
        {
          paramb = paramString;
          if (localclt.xVN.length() > 0) {
            paramb = localclt.xVN;
          }
        }
        localq.uVC.put(String.valueOf(localclt.xVJ), localclt.xVM);
      }
    }
    if (localq.uVB.size() == 0)
    {
      ab.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localq.uVC.size());
      localq.uVC.put("BrandWording", paramString);
      paramString = new tu();
      paramb = new ArrayList();
      paramb.add(localq.uVC);
      paramString.cKq.cKr = paramb;
      a.ymk.l(paramString);
    }
    AppMethodBeat.o(153132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.q.1
 * JD-Core Version:    0.7.0.1
 */