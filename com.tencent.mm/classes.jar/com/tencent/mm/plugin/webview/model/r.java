package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.eks;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.ekr;>;

public final class r
{
  private int IXM = 2000;
  private int IXN = 50;
  private LinkedList<ekr> IXO = null;
  ArrayList<Integer> IXP = null;
  HashMap<String, String> IXQ = null;
  
  private Integer bz(LinkedList<ekr> paramLinkedList)
  {
    AppMethodBeat.i(78893);
    try
    {
      Object localObject1 = new bwf();
      ((bwf)localObject1).Mcg = paramLinkedList;
      ((bwf)localObject1).oTy = paramLinkedList.size();
      Object localObject2 = new d.a();
      ((d.a)localObject2).iLN = ((a)localObject1);
      ((d.a)localObject2).iLO = new bwg();
      ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((d.a)localObject2).funcId = 631;
      ((d.a)localObject2).iLP = 0;
      ((d.a)localObject2).respCmdId = 0;
      localObject2 = ((d.a)localObject2).aXF();
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList size = " + paramLinkedList.size() + " hashcode = " + localObject1);
      IPCRunCgi.a((d)localObject2, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(78891);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            Log.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(78891);
            return;
          }
          r localr = r.this;
          paramAnonymousString = this.IXR;
          bwg localbwg = (bwg)paramAnonymousd.iLL.iLR;
          Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramAnonymousString + "  response.MsgList.size() = " + localbwg.Mcg.size());
          if (!localr.IXP.remove(paramAnonymousString))
          {
            Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
            AppMethodBeat.o(78891);
            return;
          }
          paramAnonymousString = "";
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localbwg.Mcg.size())
          {
            eks localeks = (eks)localbwg.Mcg.get(paramAnonymousInt1);
            if ((localeks == null) || (localeks.Ret != 0) || (localeks.NjY == null) || (localeks.NjY.trim().length() == 0))
            {
              Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
              paramAnonymousd = paramAnonymousString;
              if (localeks != null)
              {
                Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localeks.NjV + " TranslatedText = " + localeks.NjY + " ret = " + localeks.Ret);
                paramAnonymousd = paramAnonymousString;
              }
            }
            for (;;)
            {
              paramAnonymousInt1 += 1;
              paramAnonymousString = paramAnonymousd;
              break;
              paramAnonymousd = paramAnonymousString;
              if (localeks.Myy != null)
              {
                paramAnonymousd = paramAnonymousString;
                if (localeks.Myy.length() > 0) {
                  paramAnonymousd = localeks.Myy;
                }
              }
              localr.IXQ.put(String.valueOf(localeks.NjV), localeks.NjY);
            }
          }
          if (localr.IXP.size() == 0)
          {
            Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localr.IXQ.size());
            localr.IXQ.put("BrandWording", paramAnonymousString);
            paramAnonymousString = new yb();
            paramAnonymousd = new ArrayList();
            paramAnonymousd.add(localr.IXQ);
            paramAnonymousString.eet.eeu = paramAnonymousd;
            EventCenter.instance.publish(paramAnonymousString);
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
  
  public final boolean d(LinkedList<ekr> paramLinkedList, int paramInt1, int paramInt2)
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
      this.IXQ = new HashMap();
      this.IXO = paramLinkedList;
      this.IXP = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.IXO.size()) {
        break label280;
      }
      localObject = (ekr)this.IXO.get(i);
      int j = ((ekr)localObject).NjW.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<ekr>)localObject;
      break label114;
      paramInt1 = this.IXM;
      break;
      label195:
      paramInt2 = this.IXN;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.IXO.size() - 1) {}
      }
      else
      {
        paramLinkedList = bz(paramLinkedList);
        if (paramLinkedList == null)
        {
          Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(78892);
          return false;
        }
        this.IXP.add(paramLinkedList);
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