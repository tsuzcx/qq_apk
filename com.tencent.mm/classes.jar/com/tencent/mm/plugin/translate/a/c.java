package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class c
  implements a
{
  public ArrayList<c.a> eDb;
  public int evn;
  public final d[] toQ;
  public Queue<c.c> toR;
  public HashMap<String, Integer> toS;
  
  private c()
  {
    AppMethodBeat.i(26063);
    this.evn = 0;
    this.eDb = new ArrayList(1);
    this.toR = new LinkedList();
    this.toS = new HashMap();
    this.toQ = new d[1];
    AppMethodBeat.o(26063);
  }
  
  private void b(int paramInt, SparseArray<c.c> paramSparseArray)
  {
    AppMethodBeat.i(26064);
    Iterator localIterator = this.eDb.iterator();
    while (localIterator.hasNext()) {
      ((c.a)localIterator.next()).a(paramInt, paramSparseArray);
    }
    AppMethodBeat.o(26064);
  }
  
  public final void a(int paramInt, SparseArray<c.c> paramSparseArray, LinkedList<clt> paramLinkedList)
  {
    AppMethodBeat.i(26067);
    this.evn -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      ab.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c.c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c.c)paramSparseArray.valueAt(i)).toU));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        clt localclt;
        c.c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label408;
          }
          localclt = (clt)localIterator.next();
          localc = (c.c)paramSparseArray.get(localclt.xVJ);
          if (localc != null) {
            break;
          }
          ab.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localclt.xVJ), Integer.valueOf(localclt.Ret), bo.aqg(localclt.xVM) });
        }
        String str = localclt.xVM;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = bf.ap(str, localc.toV);
          localc.cKn = bf.ap(localc.cKn, localc.toV);
        }
        localc.cKw = paramLinkedList;
        localc.ret = localclt.Ret;
        localc.cID = localclt.xVN;
        if ((localclt.wYl != null) && (localclt.wYl.getBuffer() != null)) {}
        for (paramLinkedList = localclt.wYl.getBufferToBytes();; paramLinkedList = null)
        {
          localc.dHc = paramLinkedList;
          localc.cKx = localclt.xVO;
          this.toS.remove(localc.id);
          if (localObject == null) {
            break;
          }
          ((HashMap)localObject).remove(localc.id);
          break;
        }
      }
      i = 0;
      while (i < paramSparseArray.size())
      {
        paramLinkedList = (c.c)paramSparseArray.valueAt(i);
        if (paramLinkedList.type == 1) {
          paramLinkedList.cKn = bf.ap(paramLinkedList.cKn, paramLinkedList.toV);
        }
        i += 1;
      }
      label408:
      if ((localObject != null) && (((HashMap)localObject).size() > 0))
      {
        paramLinkedList = ((HashMap)localObject).entrySet().iterator();
        while (paramLinkedList.hasNext())
        {
          localObject = (Map.Entry)paramLinkedList.next();
          this.toS.remove(((Map.Entry)localObject).getKey());
          ab.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      cKT();
      AppMethodBeat.o(26067);
      return;
      localObject = null;
    }
  }
  
  public final boolean aew(String paramString)
  {
    AppMethodBeat.i(26066);
    boolean bool = this.toS.containsKey(paramString);
    AppMethodBeat.o(26066);
    return bool;
  }
  
  public final void cKT()
  {
    int i = 0;
    AppMethodBeat.i(26065);
    ab.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.toR.size()) });
    if (this.toR.size() == 0)
    {
      AppMethodBeat.o(26065);
      return;
    }
    if (this.evn <= this.toQ.length) {
      while (i < this.toQ.length)
      {
        if (this.toQ[i] == null)
        {
          this.toQ[i] = new d(i, this);
          this.toQ[i].init();
        }
        if ((!this.toQ[i].toY) && (this.toQ[i].e(this.toR))) {
          this.evn += 1;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(26065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.c
 * JD-Core Version:    0.7.0.1
 */