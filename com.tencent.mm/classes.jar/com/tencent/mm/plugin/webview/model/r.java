package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.dqv;>;

public final class r
{
  private int EkO = 2000;
  private int EkP = 50;
  private LinkedList<dqv> EkQ = null;
  ArrayList<Integer> EkR = null;
  HashMap<String, String> EkS = null;
  
  private Integer be(LinkedList<dqv> paramLinkedList)
  {
    AppMethodBeat.i(78893);
    try
    {
      Object localObject1 = new bjy();
      ((bjy)localObject1).GXr = paramLinkedList;
      ((bjy)localObject1).nIC = paramLinkedList.size();
      Object localObject2 = new b.a();
      ((b.a)localObject2).hQF = ((com.tencent.mm.bw.a)localObject1);
      ((b.a)localObject2).hQG = new bjz();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((b.a)localObject2).funcId = 631;
      ((b.a)localObject2).hQH = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).aDS();
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ae.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList size = " + paramLinkedList.size() + " hashcode = " + localObject1);
      IPCRunCgi.a((b)localObject2, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(78891);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ae.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(78891);
            return;
          }
          r localr = r.this;
          paramAnonymousString = this.EkT;
          bjz localbjz = (bjz)paramAnonymousb.hQE.hQJ;
          ae.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramAnonymousString + "  response.MsgList.size() = " + localbjz.GXr.size());
          if (!localr.EkR.remove(paramAnonymousString))
          {
            ae.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
            AppMethodBeat.o(78891);
            return;
          }
          paramAnonymousString = "";
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localbjz.GXr.size())
          {
            dqw localdqw = (dqw)localbjz.GXr.get(paramAnonymousInt1);
            if ((localdqw == null) || (localdqw.Ret != 0) || (localdqw.HXS == null) || (localdqw.HXS.trim().length() == 0))
            {
              ae.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
              paramAnonymousb = paramAnonymousString;
              if (localdqw != null)
              {
                ae.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localdqw.HXP + " TranslatedText = " + localdqw.HXS + " ret = " + localdqw.Ret);
                paramAnonymousb = paramAnonymousString;
              }
            }
            for (;;)
            {
              paramAnonymousInt1 += 1;
              paramAnonymousString = paramAnonymousb;
              break;
              paramAnonymousb = paramAnonymousString;
              if (localdqw.HpR != null)
              {
                paramAnonymousb = paramAnonymousString;
                if (localdqw.HpR.length() > 0) {
                  paramAnonymousb = localdqw.HpR;
                }
              }
              localr.EkS.put(String.valueOf(localdqw.HXP), localdqw.HXS);
            }
          }
          if (localr.EkR.size() == 0)
          {
            ae.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localr.EkS.size());
            localr.EkS.put("BrandWording", paramAnonymousString);
            paramAnonymousString = new xa();
            paramAnonymousb = new ArrayList();
            paramAnonymousb.add(localr.EkS);
            paramAnonymousString.dMB.dMC = paramAnonymousb;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString);
          }
          AppMethodBeat.o(78891);
        }
      });
      AppMethodBeat.o(78893);
      return localObject1;
    }
    catch (Exception paramLinkedList)
    {
      ae.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi failed！！！");
      AppMethodBeat.o(78893);
    }
    return null;
  }
  
  public final boolean d(LinkedList<dqv> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78892);
    if (paramLinkedList.size() == 0)
    {
      ae.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList is empty!!");
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
      ae.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi begin !! to translate reqStringList.size() = " + paramLinkedList.size() + " maxByte = " + paramInt1 + " maxCount = " + paramInt2);
      this.EkS = new HashMap();
      this.EkQ = paramLinkedList;
      this.EkR = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.EkQ.size()) {
        break label280;
      }
      localObject = (dqv)this.EkQ.get(i);
      int j = ((dqv)localObject).HXQ.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      ae.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<dqv>)localObject;
      break label114;
      paramInt1 = this.EkO;
      break;
      label195:
      paramInt2 = this.EkP;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.EkQ.size() - 1) {}
      }
      else
      {
        paramLinkedList = be(paramLinkedList);
        if (paramLinkedList == null)
        {
          ae.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(78892);
          return false;
        }
        this.EkR.add(paramLinkedList);
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