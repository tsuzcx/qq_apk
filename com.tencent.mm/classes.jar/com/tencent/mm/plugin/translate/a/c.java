package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bl;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  public final d[] BSF;
  public Queue<c> BSG;
  public HashMap<String, Integer> BSH;
  public int gkU;
  public ArrayList<a> listeners;
  
  private c()
  {
    AppMethodBeat.i(29744);
    this.gkU = 0;
    this.listeners = new ArrayList(1);
    this.BSG = new LinkedList();
    this.BSH = new HashMap();
    this.BSF = new d[1];
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
  
  public final void a(int paramInt, SparseArray<c> paramSparseArray, LinkedList<dqw> paramLinkedList)
  {
    AppMethodBeat.i(29748);
    this.gkU -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      ae.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c)paramSparseArray.valueAt(i)).BSJ));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        dqw localdqw;
        c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label408;
          }
          localdqw = (dqw)localIterator.next();
          localc = (c)paramSparseArray.get(localdqw.HXP);
          if (localc != null) {
            break;
          }
          ae.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localdqw.HXP), Integer.valueOf(localdqw.Ret), bu.aSM(localdqw.HXS) });
        }
        String str = localdqw.HXS;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = bl.aN(str, localc.BSK);
          localc.dMy = bl.aN(localc.dMy, localc.BSK);
        }
        localc.dMH = paramLinkedList;
        localc.ret = localdqw.Ret;
        localc.dKF = localdqw.HpR;
        if ((localdqw.GNA != null) && (localdqw.GNA.getBuffer() != null)) {}
        for (paramLinkedList = localdqw.GNA.getBufferToBytes();; paramLinkedList = null)
        {
          localc.fmy = paramLinkedList;
          localc.dMI = localdqw.HXT;
          this.BSH.remove(localc.id);
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
          paramLinkedList.dMy = bl.aN(paramLinkedList.dMy, paramLinkedList.BSK);
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
          this.BSH.remove(((Map.Entry)localObject).getKey());
          ae.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      euV();
      AppMethodBeat.o(29748);
      return;
      localObject = null;
    }
  }
  
  public final boolean aEw(String paramString)
  {
    AppMethodBeat.i(29747);
    boolean bool = this.BSH.containsKey(paramString);
    AppMethodBeat.o(29747);
    return bool;
  }
  
  public final void euV()
  {
    int i = 0;
    AppMethodBeat.i(29746);
    ae.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.BSG.size()) });
    if (this.BSG.size() == 0)
    {
      AppMethodBeat.o(29746);
      return;
    }
    if (this.gkU <= this.BSF.length) {
      while (i < this.BSF.length)
      {
        if (this.BSF[i] == null)
        {
          this.BSF[i] = new d(i, this);
          this.BSF[i].init();
        }
        if ((!this.BSF[i].BSN) && (this.BSF[i].e(this.BSG))) {
          this.gkU += 1;
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
    public static final c BSI;
    
    static
    {
      AppMethodBeat.i(29742);
      BSI = new c((byte)0);
      AppMethodBeat.o(29742);
    }
  }
  
  public static final class c
  {
    private static int BSL = 0;
    public int BSJ;
    public String BSK;
    public String dKF;
    public String dMH;
    public int dMI;
    public String dMy;
    public byte[] fmy;
    public String id;
    public int ret;
    public String source;
    public int type;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(29743);
      this.dMy = paramString1;
      this.id = paramString2;
      this.type = paramInt;
      this.source = paramString3;
      this.fmy = paramArrayOfByte;
      if (BSL == 2147483647) {
        BSL = 0;
      }
      int i = BSL + 1;
      BSL = i;
      this.BSJ = i;
      if (paramInt == 1)
      {
        paramInt = bl.BJ(paramString1);
        if (paramInt != -1)
        {
          paramString2 = paramString1.substring(0, paramInt).trim();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            this.BSK = paramString2;
            this.dMy = paramString1.substring(paramInt + 1).trim();
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