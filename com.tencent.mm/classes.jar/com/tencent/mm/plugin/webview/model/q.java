package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.bv.a;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.cls;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.cls;>;

public final class q
{
  private LinkedList<cls> uVA = null;
  ArrayList<Integer> uVB = null;
  HashMap<String, String> uVC = null;
  private int uVy = 2000;
  private int uVz = 50;
  
  private Integer aD(LinkedList<cls> paramLinkedList)
  {
    AppMethodBeat.i(153134);
    try
    {
      Object localObject1 = new aqr();
      ((aqr)localObject1).xfZ = paramLinkedList;
      ((aqr)localObject1).jJt = paramLinkedList.size();
      Object localObject2 = new b.a();
      ((b.a)localObject2).fsX = ((a)localObject1);
      ((b.a)localObject2).fsY = new aqs();
      ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/gettranstext";
      ((b.a)localObject2).funcId = 631;
      ((b.a)localObject2).reqCmdId = 0;
      ((b.a)localObject2).respCmdId = 0;
      localObject2 = ((b.a)localObject2).ado();
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ab.i("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList size = " + paramLinkedList.size() + " hashcode = " + localObject1);
      com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject2, new q.1(this, (Integer)localObject1));
      AppMethodBeat.o(153134);
      return localObject1;
    }
    catch (Exception paramLinkedList)
    {
      ab.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi failed！！！");
      AppMethodBeat.o(153134);
    }
    return null;
  }
  
  public final boolean a(LinkedList<cls> paramLinkedList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153133);
    if (paramLinkedList.size() == 0)
    {
      ab.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: reqStringList is empty!!");
      AppMethodBeat.o(153133);
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
      ab.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: all cgi begin !! to translate reqStringList.size() = " + paramLinkedList.size() + " maxByte = " + paramInt1 + " maxCount = " + paramInt2);
      this.uVC = new HashMap();
      this.uVA = paramLinkedList;
      this.uVB = new ArrayList();
      paramLinkedList = new LinkedList();
      i = 0;
      if (i >= this.uVA.size()) {
        break label280;
      }
      localObject = (cls)this.uVA.get(i);
      int j = ((cls)localObject).xVK.getBytes().length;
      if (j <= paramInt1) {
        break label203;
      }
      ab.d("MicroMsg.NetSceneGetTransTextXWeb", "translate: translate string is too long need cut !! len = ".concat(String.valueOf(j)));
      localObject = paramLinkedList;
    }
    for (;;)
    {
      i += 1;
      paramLinkedList = (LinkedList<cls>)localObject;
      break label114;
      paramInt1 = this.uVy;
      break;
      label195:
      paramInt2 = this.uVz;
      break label34;
      label203:
      paramLinkedList.add(localObject);
      if (paramLinkedList.size() != paramInt2)
      {
        localObject = paramLinkedList;
        if (i != this.uVA.size() - 1) {}
      }
      else
      {
        paramLinkedList = aD(paramLinkedList);
        if (paramLinkedList == null)
        {
          ab.e("MicroMsg.NetSceneGetTransTextXWeb", "translate: do cgi err");
          AppMethodBeat.o(153133);
          return false;
        }
        this.uVB.add(paramLinkedList);
        localObject = new LinkedList();
      }
    }
    label280:
    AppMethodBeat.o(153133);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.q
 * JD-Core Version:    0.7.0.1
 */