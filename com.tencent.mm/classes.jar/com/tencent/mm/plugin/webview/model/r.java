package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.a.zi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.euw;>;

public final class r
{
  private int PUd = 2000;
  private int PUe = 50;
  private LinkedList<euw> PUf = null;
  ArrayList<Integer> PUg = null;
  HashMap<String, String> PUh = null;
  
  private Integer bW(LinkedList<euw> paramLinkedList)
  {
    AppMethodBeat.i(78893);
    try
    {
      Object localObject1 = new cdv();
      ((cdv)localObject1).TlE = paramLinkedList;
      ((cdv)localObject1).rVw = paramLinkedList.size();
      Object localObject2 = new d.a();
      ((d.a)localObject2).lBU = ((a)localObject1);
      ((d.a)localObject2).lBV = new cdw();
      ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((d.a)localObject2).funcId = 631;
      ((d.a)localObject2).lBW = 0;
      ((d.a)localObject2).respCmdId = 0;
      localObject2 = ((d.a)localObject2).bgN();
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
          paramAnonymousString = this.PUi;
          cdw localcdw = (cdw)d.c.b(paramAnonymousd.lBS);
          Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramAnonymousString + "  response.MsgList.size() = " + localcdw.TlE.size());
          if (!localr.PUg.remove(paramAnonymousString))
          {
            Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
            AppMethodBeat.o(78891);
            return;
          }
          paramAnonymousString = "";
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localcdw.TlE.size())
          {
            eux localeux = (eux)localcdw.TlE.get(paramAnonymousInt1);
            if ((localeux == null) || (localeux.CqV != 0) || (localeux.UwH == null) || (localeux.UwH.trim().length() == 0))
            {
              Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
              paramAnonymousd = paramAnonymousString;
              if (localeux != null)
              {
                Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localeux.UwE + " TranslatedText = " + localeux.UwH + " ret = " + localeux.CqV);
                paramAnonymousd = paramAnonymousString;
              }
            }
            for (;;)
            {
              paramAnonymousInt1 += 1;
              paramAnonymousString = paramAnonymousd;
              break;
              paramAnonymousd = paramAnonymousString;
              if (localeux.TJZ != null)
              {
                paramAnonymousd = paramAnonymousString;
                if (localeux.TJZ.length() > 0) {
                  paramAnonymousd = localeux.TJZ;
                }
              }
              localr.PUh.put(String.valueOf(localeux.UwE), localeux.UwH);
            }
          }
          if (localr.PUg.size() == 0)
          {
            Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localr.PUh.size());
            localr.PUh.put("BrandWording", paramAnonymousString);
            paramAnonymousString = new zi();
            paramAnonymousd = new ArrayList();
            paramAnonymousd.add(localr.PUh);
            paramAnonymousString.fYI.fYJ = paramAnonymousd;
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
  
  public final boolean d(LinkedList<euw> paramLinkedList, int paramInt1, int paramInt2)
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
      this.PUh = new HashMap();
      this.PUf = paramLinkedList;
      this.PUg = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.PUf.size()) {
        break label280;
      }
      localObject = (euw)this.PUf.get(i);
      int j = ((euw)localObject).UwF.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      Log.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<euw>)localObject;
      break label114;
      paramInt1 = this.PUd;
      break;
      label195:
      paramInt2 = this.PUe;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.PUf.size() - 1) {}
      }
      else
      {
        paramLinkedList = bW(paramLinkedList);
        if (paramLinkedList == null)
        {
          Log.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(78892);
          return false;
        }
        this.PUg.add(paramLinkedList);
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