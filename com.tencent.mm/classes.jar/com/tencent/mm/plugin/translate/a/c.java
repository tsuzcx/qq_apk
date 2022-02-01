package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bj;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  public final d[] BBh;
  public Queue<c> BBi;
  public HashMap<String, Integer> BBj;
  public int giC;
  public ArrayList<a> listeners;
  
  private c()
  {
    AppMethodBeat.i(29744);
    this.giC = 0;
    this.listeners = new ArrayList(1);
    this.BBi = new LinkedList();
    this.BBj = new HashMap();
    this.BBh = new d[1];
    AppMethodBeat.o(29744);
  }
  
  private void b(int paramInt, SparseArray<c> paramSparseArray)
  {
    AppMethodBeat.i(29745);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt, paramSparseArray);
    }
    AppMethodBeat.o(29745);
  }
  
  public final void a(int paramInt, SparseArray<c> paramSparseArray, LinkedList<dpz> paramLinkedList)
  {
    AppMethodBeat.i(29748);
    this.giC -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      ad.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c)paramSparseArray.valueAt(i)).BBl));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        dpz localdpz;
        c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label408;
          }
          localdpz = (dpz)localIterator.next();
          localc = (c)paramSparseArray.get(localdpz.HEc);
          if (localc != null) {
            break;
          }
          ad.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localdpz.HEc), Integer.valueOf(localdpz.Ret), bt.aRp(localdpz.HEf) });
        }
        String str = localdpz.HEf;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = bj.aN(str, localc.BBm);
          localc.dLj = bj.aN(localc.dLj, localc.BBm);
        }
        localc.dLs = paramLinkedList;
        localc.ret = localdpz.Ret;
        localc.dJr = localdpz.GWr;
        if ((localdpz.Gub != null) && (localdpz.Gub.getBuffer() != null)) {}
        for (paramLinkedList = localdpz.Gub.getBufferToBytes();; paramLinkedList = null)
        {
          localc.fkB = paramLinkedList;
          localc.dLt = localdpz.HEg;
          this.BBj.remove(localc.id);
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
        paramLinkedList = (c)paramSparseArray.valueAt(i);
        if (paramLinkedList.type == 1) {
          paramLinkedList.dLj = bj.aN(paramLinkedList.dLj, paramLinkedList.BBm);
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
          this.BBj.remove(((Map.Entry)localObject).getKey());
          ad.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      ero();
      AppMethodBeat.o(29748);
      return;
      localObject = null;
    }
  }
  
  public final boolean aDd(String paramString)
  {
    AppMethodBeat.i(29747);
    boolean bool = this.BBj.containsKey(paramString);
    AppMethodBeat.o(29747);
    return bool;
  }
  
  public final void ero()
  {
    int i = 0;
    AppMethodBeat.i(29746);
    ad.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.BBi.size()) });
    if (this.BBi.size() == 0)
    {
      AppMethodBeat.o(29746);
      return;
    }
    if (this.giC <= this.BBh.length) {
      while (i < this.BBh.length)
      {
        if (this.BBh[i] == null)
        {
          this.BBh[i] = new d(i, this);
          this.BBh[i].init();
        }
        if ((!this.BBh[i].BBp) && (this.BBh[i].e(this.BBi))) {
          this.giC += 1;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(29746);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, SparseArray<c.c> paramSparseArray);
  }
  
  public static final class b
  {
    public static final c BBk;
    
    static
    {
      AppMethodBeat.i(29742);
      BBk = new c((byte)0);
      AppMethodBeat.o(29742);
    }
  }
  
  public static final class c
  {
    private static int BBn = 0;
    public int BBl;
    public String BBm;
    public String dJr;
    public String dLj;
    public String dLs;
    public int dLt;
    public byte[] fkB;
    public String id;
    public int ret;
    public String source;
    public int type;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(29743);
      this.dLj = paramString1;
      this.id = paramString2;
      this.type = paramInt;
      this.source = paramString3;
      this.fkB = paramArrayOfByte;
      if (BBn == 2147483647) {
        BBn = 0;
      }
      int i = BBn + 1;
      BBn = i;
      this.BBl = i;
      if (paramInt == 1)
      {
        paramInt = bj.Bh(paramString1);
        if (paramInt != -1)
        {
          paramString2 = paramString1.substring(0, paramInt).trim();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            this.BBm = paramString2;
            this.dLj = paramString1.substring(paramInt + 1).trim();
          }
        }
      }
      AppMethodBeat.o(29743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.c
 * JD-Core Version:    0.7.0.1
 */