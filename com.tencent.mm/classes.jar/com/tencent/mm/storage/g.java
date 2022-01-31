package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

public final class g
  extends i<com.tencent.mm.h.c.g>
{
  public static final String[] dXp = { i.a(com.tencent.mm.h.c.g.vg(), "AddContactAntispamTicket") };
  private h dXo;
  SparseArray<String> umS = new SparseArray();
  
  public g(e parame)
  {
    super(parame, com.tencent.mm.h.c.g.vg(), "AddContactAntispamTicket", null);
    this.dXo = ((h)parame);
  }
  
  public final String aaE(String paramString)
  {
    if (bk.bl(paramString)) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.umS.get(paramString.hashCode());
      localObject = str;
    } while (!bk.bl(str));
    Object localObject = new g.a();
    ((g.a)localObject).field_userName = paramString;
    if (b((c)localObject, new String[] { "userName" }))
    {
      paramString = ((g.a)localObject).field_userName;
      int i = ((g.a)localObject).field_scene;
      gm(paramString, ((g.a)localObject).field_ticket);
      return ((g.a)localObject).field_ticket;
    }
    return null;
  }
  
  public final void dn(List<com.tencent.mm.h.c.g> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    long l = this.dXo.eV(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((com.tencent.mm.h.c.g)paramList.next());
    }
    this.dXo.hI(l);
  }
  
  public final void gm(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    this.umS.put(paramString1.hashCode(), paramString2);
  }
  
  public final void z(String paramString1, int paramInt, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    g.a locala = new g.a();
    locala.field_userName = paramString1;
    locala.field_scene = paramInt;
    locala.field_ticket = paramString2;
    a(locala);
    gm(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.g
 * JD-Core Version:    0.7.0.1
 */