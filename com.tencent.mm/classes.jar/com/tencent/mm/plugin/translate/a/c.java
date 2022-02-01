package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bi;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public final d[] Ajv;
  public Queue<c> Ajw;
  public HashMap<String, Integer> Ajx;
  public int fPc;
  public ArrayList<a> listeners;
  
  private c()
  {
    AppMethodBeat.i(29744);
    this.fPc = 0;
    this.listeners = new ArrayList(1);
    this.Ajw = new LinkedList();
    this.Ajx = new HashMap();
    this.Ajv = new d[1];
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
  
  public final void a(int paramInt, SparseArray<c> paramSparseArray, LinkedList<dki> paramLinkedList)
  {
    AppMethodBeat.i(29748);
    this.fPc -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      ac.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c)paramSparseArray.valueAt(i)).Ajz));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        dki localdki;
        c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label408;
          }
          localdki = (dki)localIterator.next();
          localc = (c)paramSparseArray.get(localdki.FTo);
          if (localc != null) {
            break;
          }
          ac.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localdki.FTo), Integer.valueOf(localdki.Ret), bs.aLJ(localdki.FTr) });
        }
        String str = localdki.FTr;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = bi.aM(str, localc.AjA);
          localc.dyX = bi.aM(localc.dyX, localc.AjA);
        }
        localc.dzg = paramLinkedList;
        localc.ret = localdki.Ret;
        localc.dxf = localdki.FmI;
        if ((localdki.EKY != null) && (localdki.EKY.getBuffer() != null)) {}
        for (paramLinkedList = localdki.EKY.getBufferToBytes();; paramLinkedList = null)
        {
          localc.eSm = paramLinkedList;
          localc.dzh = localdki.FTs;
          this.Ajx.remove(localc.id);
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
          paramLinkedList.dyX = bi.aM(paramLinkedList.dyX, paramLinkedList.AjA);
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
          this.Ajx.remove(((Map.Entry)localObject).getKey());
          ac.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      eeX();
      AppMethodBeat.o(29748);
      return;
      localObject = null;
    }
  }
  
  public final boolean axY(String paramString)
  {
    AppMethodBeat.i(29747);
    boolean bool = this.Ajx.containsKey(paramString);
    AppMethodBeat.o(29747);
    return bool;
  }
  
  public final void eeX()
  {
    int i = 0;
    AppMethodBeat.i(29746);
    ac.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.Ajw.size()) });
    if (this.Ajw.size() == 0)
    {
      AppMethodBeat.o(29746);
      return;
    }
    if (this.fPc <= this.Ajv.length) {
      while (i < this.Ajv.length)
      {
        if (this.Ajv[i] == null)
        {
          this.Ajv[i] = new d(i, this);
          this.Ajv[i].init();
        }
        if ((!this.Ajv[i].AjD) && (this.Ajv[i].e(this.Ajw))) {
          this.fPc += 1;
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
    public static final c Ajy;
    
    static
    {
      AppMethodBeat.i(29742);
      Ajy = new c((byte)0);
      AppMethodBeat.o(29742);
    }
  }
  
  public static final class c
  {
    private static int AjB = 0;
    public String AjA;
    public int Ajz;
    public String dxf;
    public String dyX;
    public String dzg;
    public int dzh;
    public byte[] eSm;
    public String id;
    public int ret;
    public String source;
    public int type;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(29743);
      this.dyX = paramString1;
      this.id = paramString2;
      this.type = paramInt;
      this.source = paramString3;
      this.eSm = paramArrayOfByte;
      if (AjB == 2147483647) {
        AjB = 0;
      }
      int i = AjB + 1;
      AjB = i;
      this.Ajz = i;
      if (paramInt == 1)
      {
        paramInt = bi.yi(paramString1);
        if (paramInt != -1)
        {
          paramString2 = paramString1.substring(0, paramInt).trim();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            this.AjA = paramString2;
            this.dyX = paramString1.substring(paramInt + 1).trim();
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