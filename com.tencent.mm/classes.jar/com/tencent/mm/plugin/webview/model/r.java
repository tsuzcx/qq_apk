package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.abc;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.fqj;
import com.tencent.mm.protocal.protobuf.fqk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.fqj;>;

public final class r
{
  private int WKP = 2000;
  private int WKQ = 50;
  private LinkedList<fqj> WKR = null;
  ArrayList<Integer> WKS = null;
  HashMap<String, String> WKT = null;
  
  private Integer ch(LinkedList<fqj> paramLinkedList)
  {
    AppMethodBeat.i(78893);
    try
    {
      Object localObject1 = new ctv();
      ((ctv)localObject1).aazx = paramLinkedList;
      ((ctv)localObject1).vgM = paramLinkedList.size();
      Object localObject2 = new c.a();
      ((c.a)localObject2).otE = ((a)localObject1);
      ((c.a)localObject2).otF = new ctw();
      ((c.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((c.a)localObject2).funcId = 631;
      ((c.a)localObject2).otG = 0;
      ((c.a)localObject2).respCmdId = 0;
      localObject2 = ((c.a)localObject2).bEF();
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList size = " + paramLinkedList.size() + " hashcode = " + localObject1);
      IPCRunCgi.a((c)localObject2, new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
        {
          AppMethodBeat.i(78891);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(78891);
            return;
          }
          r localr = r.this;
          paramAnonymousString = this.WKU;
          ctw localctw = (ctw)c.c.b(paramAnonymousc.otC);
          Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramAnonymousString + "  response.MsgList.size() = " + localctw.aazx.size());
          if (!localr.WKS.remove(paramAnonymousString))
          {
            Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
            AppMethodBeat.o(78891);
            return;
          }
          paramAnonymousString = "";
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localctw.aazx.size())
          {
            fqk localfqk = (fqk)localctw.aazx.get(paramAnonymousInt1);
            if ((localfqk == null) || (localfqk.Idd != 0) || (localfqk.TSI == null) || (localfqk.TSI.trim().length() == 0))
            {
              Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
              paramAnonymousc = paramAnonymousString;
              if (localfqk != null)
              {
                Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localfqk.abQm + " TranslatedText = " + localfqk.TSI + " ret = " + localfqk.Idd);
                paramAnonymousc = paramAnonymousString;
              }
            }
            for (;;)
            {
              paramAnonymousInt1 += 1;
              paramAnonymousString = paramAnonymousc;
              break;
              paramAnonymousc = paramAnonymousString;
              if (localfqk.aaZO != null)
              {
                paramAnonymousc = paramAnonymousString;
                if (localfqk.aaZO.length() > 0) {
                  paramAnonymousc = localfqk.aaZO;
                }
              }
              localr.WKT.put(String.valueOf(localfqk.abQm), localfqk.TSI);
            }
          }
          if (localr.WKS.size() == 0)
          {
            Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localr.WKT.size());
            localr.WKT.put("BrandWording", paramAnonymousString);
            paramAnonymousString = new abc();
            paramAnonymousc = new ArrayList();
            paramAnonymousc.add(localr.WKT);
            paramAnonymousString.ieK.ieL = paramAnonymousc;
            paramAnonymousString.publish();
          }
          AppMethodBeat.o(78891);
        }
      });
      AppMethodBeat.o(78893);
      return localObject1;
    }
    catch (Exception paramLinkedList)
    {
      Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi failed！！！");
      AppMethodBeat.o(78893);
    }
    return null;
  }
  
  public final boolean d(LinkedList<fqj> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78892);
    if (paramLinkedList.size() == 0)
    {
      Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList is empty!!");
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
      Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi begin !! to translate reqStringList.size() = " + paramLinkedList.size() + " maxByte = " + paramInt1 + " maxCount = " + paramInt2);
      this.WKT = new HashMap();
      this.WKR = paramLinkedList;
      this.WKS = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.WKR.size()) {
        break label280;
      }
      localObject = (fqj)this.WKR.get(i);
      int j = ((fqj)localObject).abQn.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<fqj>)localObject;
      break label114;
      paramInt1 = this.WKP;
      break;
      label195:
      paramInt2 = this.WKQ;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.WKR.size() - 1) {}
      }
      else
      {
        paramLinkedList = ch(paramLinkedList);
        if (paramLinkedList == null)
        {
          Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(78892);
          return false;
        }
        this.WKS.add(paramLinkedList);
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