package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eux;
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
  public final d[] NfX;
  public Queue<c> NfY;
  public HashMap<String, Integer> NfZ;
  public int jGL;
  public ArrayList<a> listeners;
  
  private c()
  {
    AppMethodBeat.i(29744);
    this.jGL = 0;
    this.listeners = new ArrayList(1);
    this.NfY = new LinkedList();
    this.NfZ = new HashMap();
    this.NfX = new d[1];
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
  
  public final void a(int paramInt, SparseArray<c> paramSparseArray, LinkedList<eux> paramLinkedList)
  {
    AppMethodBeat.i(29748);
    this.jGL -= 1;
    Object localObject;
    int i;
    if ((paramLinkedList == null) || (paramSparseArray.size() != paramLinkedList.size()))
    {
      Log.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
      localObject = new HashMap();
      i = 0;
      while (i < paramSparseArray.size())
      {
        ((HashMap)localObject).put(((c)paramSparseArray.valueAt(i)).id, Integer.valueOf(((c)paramSparseArray.valueAt(i)).Ngb));
        i += 1;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        Iterator localIterator = paramLinkedList.iterator();
        eux localeux;
        c localc;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label411;
          }
          localeux = (eux)localIterator.next();
          localc = (c)paramSparseArray.get(localeux.UwE);
          if (localc != null) {
            break;
          }
          Log.w("MicroMsg.TranslateServiceManager", "[onTranslateEnd] message is null! %s %s %s", new Object[] { Integer.valueOf(localeux.UwE), Integer.valueOf(localeux.CqV), Util.secPrint(localeux.UwH) });
        }
        String str = localeux.UwH;
        paramLinkedList = str;
        if (localc.type == 1)
        {
          paramLinkedList = bq.aT(str, localc.Ngc);
          localc.fYF = bq.aT(localc.fYF, localc.Ngc);
        }
        localc.fYO = paramLinkedList;
        localc.ret = localeux.CqV;
        localc.fWy = localeux.TJZ;
        if ((localeux.Taj != null) && (localeux.Taj.Tkb != null)) {}
        for (paramLinkedList = localeux.Taj.Tkb.UH;; paramLinkedList = null)
        {
          localc.ils = paramLinkedList;
          localc.fYP = localeux.UwI;
          this.NfZ.remove(localc.id);
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
          paramLinkedList.fYF = bq.aT(paramLinkedList.fYF, paramLinkedList.Ngc);
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
          this.NfZ.remove(((Map.Entry)localObject).getKey());
          Log.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[] { ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
        }
      }
      b(paramInt, paramSparseArray);
      gsp();
      AppMethodBeat.o(29748);
      return;
      localObject = null;
    }
  }
  
  public final boolean bfk(String paramString)
  {
    AppMethodBeat.i(29747);
    boolean bool = this.NfZ.containsKey(paramString);
    AppMethodBeat.o(29747);
    return bool;
  }
  
  public final void gsp()
  {
    int i = 0;
    AppMethodBeat.i(29746);
    Log.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[] { Integer.valueOf(this.NfY.size()) });
    if (this.NfY.size() == 0)
    {
      AppMethodBeat.o(29746);
      return;
    }
    if (this.jGL <= this.NfX.length) {
      while (i < this.NfX.length)
      {
        if (this.NfX[i] == null)
        {
          this.NfX[i] = new d(i, this);
          this.NfX[i].init();
        }
        if ((!this.NfX[i].Ngf) && (this.NfX[i].e(this.NfY))) {
          this.jGL += 1;
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
    public static final c Nga;
    
    static
    {
      AppMethodBeat.i(29742);
      Nga = new c((byte)0);
      AppMethodBeat.o(29742);
    }
  }
  
  public static final class c
  {
    private static int Ngd = 0;
    public int Ngb;
    public String Ngc;
    public String fWy;
    public String fYF;
    public String fYO;
    public int fYP;
    public String id;
    public byte[] ils;
    public int ret;
    public String source;
    public int type;
    
    public c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(29743);
      this.fYF = paramString1;
      this.id = paramString2;
      this.type = paramInt;
      this.source = paramString3;
      this.ils = paramArrayOfByte;
      if (Ngd == 2147483647) {
        Ngd = 0;
      }
      int i = Ngd + 1;
      Ngd = i;
      this.Ngb = i;
      if (paramInt == 1)
      {
        paramInt = bq.RI(paramString1);
        if (paramInt != -1)
        {
          paramString2 = paramString1.substring(0, paramInt).trim();
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            this.Ngc = paramString2;
            this.fYF = paramString1.substring(paramInt + 1).trim();
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