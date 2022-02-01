package com.tencent.mm.plugin.translate.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.br;
import com.tencent.mm.protocal.protobuf.fqk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class e
  implements a
{
  public final f[] TSV;
  public Queue<c> TSW;
  public HashMap<String, Integer> TSX;
  public ArrayList<a> listeners;
  public int wrD;
  
  private e()
  {
    AppMethodBeat.i(29744);
    this.wrD = 0;
    this.listeners = new ArrayList(1);
    this.TSW = new LinkedList();
    this.TSX = new HashMap();
    this.TSV = new f[1];
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
  
  public final void a(int paramInt, SparseArray<c> paramSparseArray, LinkedList<fqk> paramLinkedList)
  {
    AppMethodBeat.i(29748);
    this.wrD -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      Log.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c)paramSparseArray.valueAt(i)).TSZ));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        fqk localfqk;
        c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label411;
          }
          localfqk = (fqk)localIterator.next();
          localc = (c)paramSparseArray.get(localfqk.abQm);
          if (localc != null) {
            break;
          }
          Log.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localfqk.abQm), Integer.valueOf(localfqk.Idd), Util.secPrint(localfqk.TSI) });
        }
        String str = localfqk.TSI;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = br.bd(str, localc.TTa);
          localc.ieH = br.bd(localc.ieH, localc.TTa);
        }
        localc.ieQ = paramLinkedList;
        localc.ret = localfqk.Idd;
        localc.icx = localfqk.aaZO;
        if ((localfqk.aanh != null) && (localfqk.aanh.aaxD != null)) {}
        for (paramLinkedList = localfqk.aanh.aaxD.Op;; paramLinkedList = null)
        {
          localc.kLr = paramLinkedList;
          localc.ieR = localfqk.abQq;
          this.TSX.remove(localc.id);
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
          paramLinkedList.ieH = br.bd(paramLinkedList.ieH, paramLinkedList.TTa);
        }
        i += 1;
      }
      label411:
      if ((localObject != null) && (((HashMap)localObject).size() > 0))
      {
        paramLinkedList = ((HashMap)localObject).entrySet().iterator();
        while (paramLinkedList.hasNext())
        {
          localObject = (Map.Entry)paramLinkedList.next();
          this.TSX.remove(((Map.Entry)localObject).getKey());
          Log.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      hPx();
      AppMethodBeat.o(29748);
      return;
      localObject = null;
    }
  }
  
  public final boolean beQ(String paramString)
  {
    AppMethodBeat.i(29747);
    boolean bool = this.TSX.containsKey(paramString);
    AppMethodBeat.o(29747);
    return bool;
  }
  
  public final void hPx()
  {
    int i = 0;
    AppMethodBeat.i(29746);
    Log.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.TSW.size()) });
    if (this.TSW.size() == 0)
    {
      AppMethodBeat.o(29746);
      return;
    }
    if (this.wrD <= this.TSV.length) {
      while (i < this.TSV.length)
      {
        if (this.TSV[i] == null)
        {
          this.TSV[i] = new f(i, this);
          this.TSV[i].init();
        }
        if ((!this.TSV[i].TTd) && (this.TSV[i].g(this.TSW))) {
          this.wrD += 1;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(29746);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, SparseArray<e.c> paramSparseArray);
  }
  
  public static final class b
  {
    public static final e TSY;
    
    static
    {
      AppMethodBeat.i(29742);
      TSY = new e((byte)0);
      AppMethodBeat.o(29742);
    }
  }
  
  public static final class c
  {
    private static int TTb = 0;
    public int TSZ;
    public String TTa;
    public String icx;
    public String id;
    public String ieH;
    public String ieQ;
    public int ieR;
    public byte[] kLr;
    public int ret;
    public String source;
    public int type;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(29743);
      this.ieH = paramString1;
      this.id = paramString2;
      this.type = paramInt;
      this.source = paramString3;
      this.kLr = paramArrayOfByte;
      if (TTb == 2147483647) {
        TTb = 0;
      }
      int i = TTb + 1;
      TTb = i;
      this.TSZ = i;
      if (paramInt == 1)
      {
        paramInt = br.JG(paramString1);
        if (paramInt != -1)
        {
          paramString2 = paramString1.substring(0, paramInt).trim();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            this.TTa = paramString2;
            this.ieH = paramString1.substring(paramInt + 1).trim();
          }
        }
      }
      AppMethodBeat.o(29743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.b.e
 * JD-Core Version:    0.7.0.1
 */