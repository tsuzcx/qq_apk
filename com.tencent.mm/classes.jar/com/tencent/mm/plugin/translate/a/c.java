package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eks;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  public final d[] Gtl;
  public Queue<c> Gtm;
  public HashMap<String, Integer> Gtn;
  public int gVP;
  public ArrayList<a> listeners;
  
  private c()
  {
    AppMethodBeat.i(29744);
    this.gVP = 0;
    this.listeners = new ArrayList(1);
    this.Gtm = new LinkedList();
    this.Gtn = new HashMap();
    this.Gtl = new d[1];
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
  
  public final void a(int paramInt, SparseArray<c> paramSparseArray, LinkedList<eks> paramLinkedList)
  {
    AppMethodBeat.i(29748);
    this.gVP -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      Log.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c)paramSparseArray.valueAt(i)).Gtp));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        eks localeks;
        c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label408;
          }
          localeks = (eks)localIterator.next();
          localc = (c)paramSparseArray.get(localeks.NjV);
          if (localc != null) {
            break;
          }
          Log.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localeks.NjV), Integer.valueOf(localeks.Ret), Util.secPrint(localeks.NjY) });
        }
        String str = localeks.NjY;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = bp.aP(str, localc.Gtq);
          localc.eeq = bp.aP(localc.eeq, localc.Gtq);
        }
        localc.eez = paramLinkedList;
        localc.ret = localeks.Ret;
        localc.ecu = localeks.Myy;
        if ((localeks.LRE != null) && (localeks.LRE.getBuffer() != null)) {}
        for (paramLinkedList = localeks.LRE.getBufferToBytes();; paramLinkedList = null)
        {
          localc.fRc = paramLinkedList;
          localc.eeA = localeks.NjZ;
          this.Gtn.remove(localc.id);
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
          paramLinkedList.eeq = bp.aP(paramLinkedList.eeq, paramLinkedList.Gtq);
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
          this.Gtn.remove(((Map.Entry)localObject).getKey());
          Log.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      fAo();
      AppMethodBeat.o(29748);
      return;
      localObject = null;
    }
  }
  
  public final boolean aTM(String paramString)
  {
    AppMethodBeat.i(29747);
    boolean bool = this.Gtn.containsKey(paramString);
    AppMethodBeat.o(29747);
    return bool;
  }
  
  public final void fAo()
  {
    int i = 0;
    AppMethodBeat.i(29746);
    Log.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.Gtm.size()) });
    if (this.Gtm.size() == 0)
    {
      AppMethodBeat.o(29746);
      return;
    }
    if (this.gVP <= this.Gtl.length) {
      while (i < this.Gtl.length)
      {
        if (this.Gtl[i] == null)
        {
          this.Gtl[i] = new d(i, this);
          this.Gtl[i].init();
        }
        if ((!this.Gtl[i].Gtt) && (this.Gtl[i].e(this.Gtm))) {
          this.gVP += 1;
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
    public static final c Gto;
    
    static
    {
      AppMethodBeat.i(29742);
      Gto = new c((byte)0);
      AppMethodBeat.o(29742);
    }
  }
  
  public static final class c
  {
    private static int Gtr = 0;
    public int Gtp;
    public String Gtq;
    public String ecu;
    public int eeA;
    public String eeq;
    public String eez;
    public byte[] fRc;
    public String id;
    public int ret;
    public String source;
    public int type;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(29743);
      this.eeq = paramString1;
      this.id = paramString2;
      this.type = paramInt;
      this.source = paramString3;
      this.fRc = paramArrayOfByte;
      if (Gtr == 2147483647) {
        Gtr = 0;
      }
      int i = Gtr + 1;
      Gtr = i;
      this.Gtp = i;
      if (paramInt == 1)
      {
        paramInt = bp.Kp(paramString1);
        if (paramInt != -1)
        {
          paramString2 = paramString1.substring(0, paramInt).trim();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            this.Gtq = paramString2;
            this.eeq = paramString1.substring(paramInt + 1).trim();
          }
        }
      }
      AppMethodBeat.o(29743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.c
 * JD-Core Version:    0.7.0.1
 */