package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.des;>;

public final class r
{
  private int AXd = 2000;
  private int AXe = 50;
  private LinkedList<des> AXf = null;
  ArrayList<Integer> AXg = null;
  HashMap<String, String> AXh = null;
  
  private Integer aV(LinkedList<des> paramLinkedList)
  {
    AppMethodBeat.i(78893);
    try
    {
      Object localObject1 = new bbg();
      ((bbg)localObject1).DyV = paramLinkedList;
      ((bbg)localObject1).mAJ = paramLinkedList.size();
      Object localObject2 = new b.a();
      ((b.a)localObject2).gUU = ((com.tencent.mm.bx.a)localObject1);
      ((b.a)localObject2).gUV = new bbh();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((b.a)localObject2).funcId = 631;
      ((b.a)localObject2).reqCmdId = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).atI();
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ad.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList size = " + paramLinkedList.size() + " hashcode = " + localObject1);
      IPCRunCgi.a((b)localObject2, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(78891);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(78891);
            return;
          }
          r localr = r.this;
          paramAnonymousString = this.AXi;
          bbh localbbh = (bbh)paramAnonymousb.gUT.gUX;
          ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramAnonymousString + "  response.MsgList.size() = " + localbbh.DyV.size());
          if (!localr.AXg.remove(paramAnonymousString))
          {
            ad.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
            AppMethodBeat.o(78891);
            return;
          }
          paramAnonymousString = "";
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localbbh.DyV.size())
          {
            det localdet = (det)localbbh.DyV.get(paramAnonymousInt1);
            if ((localdet == null) || (localdet.Ret != 0) || (localdet.Ewo == null) || (localdet.Ewo.trim().length() == 0))
            {
              ad.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
              paramAnonymousb = paramAnonymousString;
              if (localdet != null)
              {
                ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localdet.Ewl + " TranslatedText = " + localdet.Ewo + " ret = " + localdet.Ret);
                paramAnonymousb = paramAnonymousString;
              }
            }
            for (;;)
            {
              paramAnonymousInt1 += 1;
              paramAnonymousString = paramAnonymousb;
              break;
              paramAnonymousb = paramAnonymousString;
              if (localdet.Ewp != null)
              {
                paramAnonymousb = paramAnonymousString;
                if (localdet.Ewp.length() > 0) {
                  paramAnonymousb = localdet.Ewp;
                }
              }
              localr.AXh.put(String.valueOf(localdet.Ewl), localdet.Ewo);
            }
          }
          if (localr.AXg.size() == 0)
          {
            ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localr.AXh.size());
            localr.AXh.put("BrandWording", paramAnonymousString);
            paramAnonymousString = new vs();
            paramAnonymousb = new ArrayList();
            paramAnonymousb.add(localr.AXh);
            paramAnonymousString.dBm.dBn = paramAnonymousb;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
          AppMethodBeat.o(78891);
        }
      });
      AppMethodBeat.o(78893);
      return localObject1;
    }
    catch (Exception paramLinkedList)
    {
      ad.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi failed！！！");
      AppMethodBeat.o(78893);
    }
    return null;
  }
  
  public final boolean a(LinkedList<des> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78892);
    if (paramLinkedList.size() == 0)
    {
      ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList is empty!!");
      AppMethodBeat.o(78892);
      return false;
    }
    label34:
    int i;
    label114:
    Object localObject;
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        break label195;
      }
      ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi begin !! to translate reqStringList.size() = " + paramLinkedList.size() + " maxByte = " + paramInt1 + " maxCount = " + paramInt2);
      this.AXh = new HashMap();
      this.AXf = paramLinkedList;
      this.AXg = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.AXf.size()) {
        break label280;
      }
      localObject = (des)this.AXf.get(i);
      int j = ((des)localObject).Ewm.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<des>)localObject;
      break label114;
      paramInt1 = this.AXd;
      break;
      label195:
      paramInt2 = this.AXe;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.AXf.size() - 1) {}
      }
      else
      {
        paramLinkedList = aV(paramLinkedList);
        if (paramLinkedList == null)
        {
          ad.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(78892);
          return false;
        }
        this.AXg.add(paramLinkedList);
        localObject = new LinkedList();
      }
    }
    label280:
    AppMethodBeat.o(78892);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.r
 * JD-Core Version:    0.7.0.1
 */