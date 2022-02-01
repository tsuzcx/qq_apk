package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bi;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.det;
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
  public int fLq;
  public ArrayList<a> fYf;
  public final d[] yVG;
  public Queue<c> yVH;
  public HashMap<String, Integer> yVI;
  
  private c()
  {
    AppMethodBeat.i(29744);
    this.fLq = 0;
    this.fYf = new ArrayList(1);
    this.yVH = new LinkedList();
    this.yVI = new HashMap();
    this.yVG = new d[1];
    AppMethodBeat.o(29744);
  }
  
  private void b(int paramInt, SparseArray<c> paramSparseArray)
  {
    AppMethodBeat.i(29745);
    Iterator localIterator = this.fYf.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt, paramSparseArray);
    }
    AppMethodBeat.o(29745);
  }
  
  public final void a(int paramInt, SparseArray<c> paramSparseArray, LinkedList<det> paramLinkedList)
  {
    AppMethodBeat.i(29748);
    this.fLq -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      ad.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c)paramSparseArray.valueAt(i)).yVK));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        det localdet;
        c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label408;
          }
          localdet = (det)localIterator.next();
          localc = (c)paramSparseArray.get(localdet.Ewl);
          if (localc != null) {
            break;
          }
          ad.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localdet.Ewl), Integer.valueOf(localdet.Ret), bt.aGs(localdet.Ewo) });
        }
        String str = localdet.Ewo;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = bi.aE(str, localc.yVL);
          localc.dBj = bi.aE(localc.dBj, localc.yVL);
        }
        localc.dBs = paramLinkedList;
        localc.ret = localdet.Ret;
        localc.dzt = localdet.Ewp;
        if ((localdet.DpV != null) && (localdet.DpV.getBuffer() != null)) {}
        for (paramLinkedList = localdet.DpV.getBufferToBytes();; paramLinkedList = null)
        {
          localc.ePe = paramLinkedList;
          localc.dBt = localdet.Ewq;
          this.yVI.remove(localc.id);
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
          paramLinkedList.dBj = bi.aE(paramLinkedList.dBj, paramLinkedList.yVL);
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
          this.yVI.remove(((Map.Entry)localObject).getKey());
          ad.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      dQy();
      AppMethodBeat.o(29748);
      return;
      localObject = null;
    }
  }
  
  public final boolean asP(String paramString)
  {
    AppMethodBeat.i(29747);
    boolean bool = this.yVI.containsKey(paramString);
    AppMethodBeat.o(29747);
    return bool;
  }
  
  public final void dQy()
  {
    int i = 0;
    AppMethodBeat.i(29746);
    ad.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.yVH.size()) });
    if (this.yVH.size() == 0)
    {
      AppMethodBeat.o(29746);
      return;
    }
    if (this.fLq <= this.yVG.length) {
      while (i < this.yVG.length)
      {
        if (this.yVG[i] == null)
        {
          this.yVG[i] = new d(i, this);
          this.yVG[i].init();
        }
        if ((!this.yVG[i].yVO) && (this.yVG[i].e(this.yVH))) {
          this.fLq += 1;
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
    public static final c yVJ;
    
    static
    {
      AppMethodBeat.i(29742);
      yVJ = new c((byte)0);
      AppMethodBeat.o(29742);
    }
  }
  
  public static final class c
  {
    private static int yVM = 0;
    public String dBj;
    public String dBs;
    public int dBt;
    public String dzt;
    public byte[] ePe;
    public String id;
    public int ret;
    public String source;
    public int type;
    public int yVK;
    public String yVL;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(29743);
      this.dBj = paramString1;
      this.id = paramString2;
      this.type = paramInt;
      this.source = paramString3;
      this.ePe = paramArrayOfByte;
      if (yVM == 2147483647) {
        yVM = 0;
      }
      int i = yVM + 1;
      yVM = i;
      this.yVK = i;
      if (paramInt == 1)
      {
        paramInt = bi.uc(paramString1);
        if (paramInt != -1)
        {
          paramString2 = paramString1.substring(0, paramInt).trim();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            this.yVL = paramString2;
            this.dBj = paramString1.substring(paramInt + 1).trim();
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