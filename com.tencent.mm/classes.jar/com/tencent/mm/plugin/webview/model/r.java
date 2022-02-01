package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.protocal.protobuf.bez;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.dkh;>;

public final class r
{
  private int Cpq = 2000;
  private int Cpr = 50;
  private LinkedList<dkh> Cps = null;
  ArrayList<Integer> Cpt = null;
  HashMap<String, String> Cpu = null;
  
  private Integer bc(LinkedList<dkh> paramLinkedList)
  {
    AppMethodBeat.i(78893);
    try
    {
      Object localObject1 = new bey();
      ((bey)localObject1).EUr = paramLinkedList;
      ((bey)localObject1).ncK = paramLinkedList.size();
      Object localObject2 = new b.a();
      ((b.a)localObject2).hvt = ((com.tencent.mm.bw.a)localObject1);
      ((b.a)localObject2).hvu = new bez();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((b.a)localObject2).funcId = 631;
      ((b.a)localObject2).reqCmdId = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).aAz();
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ac.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList size = " + paramLinkedList.size() + " hashcode = " + localObject1);
      IPCRunCgi.a((b)localObject2, new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(78891);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            AppMethodBeat.o(78891);
            return;
          }
          r localr = r.this;
          paramAnonymousString = this.Cpv;
          bez localbez = (bez)paramAnonymousb.hvs.hvw;
          ac.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: cgi return!!  processRespData hashcode = " + paramAnonymousString + "  response.MsgList.size() = " + localbez.EUr.size());
          if (!localr.Cpt.remove(paramAnonymousString))
          {
            ac.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: err cgi return!!");
            AppMethodBeat.o(78891);
            return;
          }
          paramAnonymousString = "";
          paramAnonymousInt1 = 0;
          if (paramAnonymousInt1 < localbez.EUr.size())
          {
            dki localdki = (dki)localbez.EUr.get(paramAnonymousInt1);
            if ((localdki == null) || (localdki.Ret != 0) || (localdki.FTr == null) || (localdki.FTr.trim().length() == 0))
            {
              ac.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! ");
              paramAnonymousb = paramAnonymousString;
              if (localdki != null)
              {
                ac.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: some translate message err!! rsp ClientMsgID = " + localdki.FTo + " TranslatedText = " + localdki.FTr + " ret = " + localdki.Ret);
                paramAnonymousb = paramAnonymousString;
              }
            }
            for (;;)
            {
              paramAnonymousInt1 += 1;
              paramAnonymousString = paramAnonymousb;
              break;
              paramAnonymousb = paramAnonymousString;
              if (localdki.FmI != null)
              {
                paramAnonymousb = paramAnonymousString;
                if (localdki.FmI.length() > 0) {
                  paramAnonymousb = localdki.FmI;
                }
              }
              localr.Cpu.put(String.valueOf(localdki.FTo), localdki.FTr);
            }
          }
          if (localr.Cpt.size() == 0)
          {
            ac.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi finish !! TranslateMessageListResultEvent publish!  translated HashMapAll.size() = " + localr.Cpu.size());
            localr.Cpu.put("BrandWording", paramAnonymousString);
            paramAnonymousString = new wd();
            paramAnonymousb = new ArrayList();
            paramAnonymousb.add(localr.Cpu);
            paramAnonymousString.dza.dzb = paramAnonymousb;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
          AppMethodBeat.o(78891);
        }
      });
      AppMethodBeat.o(78893);
      return localObject1;
    }
    catch (Exception paramLinkedList)
    {
      ac.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi failed！！！");
      AppMethodBeat.o(78893);
    }
    return null;
  }
  
  public final boolean a(LinkedList<dkh> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78892);
    if (paramLinkedList.size() == 0)
    {
      ac.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList is empty!!");
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
      ac.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi begin !! to translate reqStringList.size() = " + paramLinkedList.size() + " maxByte = " + paramInt1 + " maxCount = " + paramInt2);
      this.Cpu = new HashMap();
      this.Cps = paramLinkedList;
      this.Cpt = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.Cps.size()) {
        break label280;
      }
      localObject = (dkh)this.Cps.get(i);
      int j = ((dkh)localObject).FTp.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      ac.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<dkh>)localObject;
      break label114;
      paramInt1 = this.Cpq;
      break;
      label195:
      paramInt2 = this.Cpr;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.Cps.size() - 1) {}
      }
      else
      {
        paramLinkedList = bc(paramLinkedList);
        if (paramLinkedList == null)
        {
          ac.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(78892);
          return false;
        }
        this.Cpt.add(paramLinkedList);
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