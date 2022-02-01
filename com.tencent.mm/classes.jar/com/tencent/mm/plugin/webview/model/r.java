package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.dpy;>;

public final class r
{
  private int DSO = 2000;
  private int DSP = 50;
  private LinkedList<dpy> DSQ = null;
  ArrayList<Integer> DSR = null;
  HashMap<String, String> DSS = null;
  
  private Integer bd(LinkedList<dpy> paramLinkedList)
  {
    AppMethodBeat.i(78893);
    try
    {
      Object localObject1 = new bjg();
      ((bjg)localObject1).GDO = paramLinkedList;
      ((bjg)localObject1).nDh = paramLinkedList.size();
      Object localObject2 = new b.a();
      ((b.a)localObject2).hNM = ((com.tencent.mm.bx.a)localObject1);
      ((b.a)localObject2).hNN = new bjh();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((b.a)localObject2).funcId = 631;
      ((b.a)localObject2).hNO = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).aDC();
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
          paramAnonymousString = this.DST;
          bjh localbjh = (bjh)paramAnonymousb.hNL.hNQ;
          ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramAnonymousString + "  response.MsgList.size() = " + localbjh.GDO.size());
          if (!localr.DSR.remove(paramAnonymousString))
          {
            ad.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
            AppMethodBeat.o(78891);
            return;
          }
          paramAnonymousString = "";
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localbjh.GDO.size())
          {
            dpz localdpz = (dpz)localbjh.GDO.get(paramAnonymousInt1);
            if ((localdpz == null) || (localdpz.Ret != 0) || (localdpz.HEf == null) || (localdpz.HEf.trim().length() == 0))
            {
              ad.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
              paramAnonymousb = paramAnonymousString;
              if (localdpz != null)
              {
                ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localdpz.HEc + " TranslatedText = " + localdpz.HEf + " ret = " + localdpz.Ret);
                paramAnonymousb = paramAnonymousString;
              }
            }
            for (;;)
            {
              paramAnonymousInt1 += 1;
              paramAnonymousString = paramAnonymousb;
              break;
              paramAnonymousb = paramAnonymousString;
              if (localdpz.GWr != null)
              {
                paramAnonymousb = paramAnonymousString;
                if (localdpz.GWr.length() > 0) {
                  paramAnonymousb = localdpz.GWr;
                }
              }
              localr.DSS.put(String.valueOf(localdpz.HEc), localdpz.HEf);
            }
          }
          if (localr.DSR.size() == 0)
          {
            ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localr.DSS.size());
            localr.DSS.put("BrandWording", paramAnonymousString);
            paramAnonymousString = new ww();
            paramAnonymousb = new ArrayList();
            paramAnonymousb.add(localr.DSS);
            paramAnonymousString.dLm.dLn = paramAnonymousb;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString);
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
  
  public final boolean a(LinkedList<dpy> paramLinkedList, int paramInt1, int paramInt2)
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
      this.DSS = new HashMap();
      this.DSQ = paramLinkedList;
      this.DSR = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.DSQ.size()) {
        break label280;
      }
      localObject = (dpy)this.DSQ.get(i);
      int j = ((dpy)localObject).HEd.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      ad.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<dpy>)localObject;
      break label114;
      paramInt1 = this.DSO;
      break;
      label195:
      paramInt2 = this.DSP;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.DSQ.size() - 1) {}
      }
      else
      {
        paramLinkedList = bd(paramLinkedList);
        if (paramLinkedList == null)
        {
          ad.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(78892);
          return false;
        }
        this.DSR.add(paramLinkedList);
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