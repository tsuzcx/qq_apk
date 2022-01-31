package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class p
{
  List<p.a> dhm;
  long ndR = 0L;
  private k ndS;
  a ndT;
  private int ndU = 0;
  int ndV = 1;
  private int ndW = 2;
  int ndX = 3;
  int status = this.ndU;
  
  p(String paramString)
  {
    this.ndS = new k(paramString, 1);
    paramString = k.readFromFile(this.ndS.ndA + "address");
    if (paramString != null)
    {
      this.ndS.a("address", null, paramString);
      e.deleteFile(this.ndS.ndA + "address");
      if (paramString == null) {
        break label206;
      }
    }
    for (;;)
    {
      try
      {
        this.ndT = new a().aG(paramString);
        this.dhm = new ArrayList();
        return;
        paramString = this.ndS.p("address", null);
      }
      catch (IOException paramString)
      {
        y.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", paramString, "", new Object[0]);
        this.ndT = new a();
        this.ndT.Ld("");
        continue;
      }
      label206:
      this.ndT = new a();
      this.ndT.Ld("");
    }
  }
  
  public static o Lj(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      paramString = paramString.trim();
      i = paramString.trim().lastIndexOf(" ");
    } while (i == -1);
    o localo = new o();
    localo.name = paramString.substring(0, i);
    localo.lCF = paramString.substring(i + 1);
    return localo;
  }
  
  public final List<o> Li(String paramString)
  {
    Object localObject = this.ndT.ncZ;
    if (this.status <= this.ndV) {
      btu();
    }
    while ((paramString == null) || (paramString.length() == 0)) {
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      o localo = (o)((Iterator)localObject).next();
      if ((localo != null) && (((localo.name != null) && (localo.name.contains(paramString))) || ((localo.ndQ != null) && (localo.ndQ.contains(paramString))) || ((localo.lCF != null) && (localo.lCF.contains(paramString)))))
      {
        a.b(localo);
        localArrayList.add(localo);
      }
    }
    return localArrayList;
  }
  
  public final void a(p.a parama)
  {
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext()) {
      if ((p.a)localIterator.next() == parama) {
        return;
      }
    }
    this.dhm.add(parama);
  }
  
  public final void b(p.a parama)
  {
    Iterator localIterator = this.dhm.iterator();
    while (localIterator.hasNext())
    {
      p.a locala = (p.a)localIterator.next();
      if (locala == parama) {
        this.dhm.remove(locala);
      }
    }
  }
  
  public final void btu()
  {
    if (this.status == this.ndW) {}
    for (;;)
    {
      return;
      if (bk.UY() - this.ndR > 600000L) {
        break;
      }
      localObject = this.dhm.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((p.a)((Iterator)localObject).next()).onComplete();
      }
    }
    this.status = this.ndW;
    HashMap localHashMap = new HashMap();
    if (this.ndT.ncX == null) {}
    for (Object localObject = "";; localObject = this.ndT.ncX)
    {
      localHashMap.put("syncinfo", localObject);
      y.d("MicroMsg.Plugin.MailAddrMgr", "%s", new Object[] { "sync~~~" });
      localObject = ac.btF();
      p.1 local1 = new p.1(this);
      ((v)localObject).b("/cgi-bin/syncaddrlist", localHashMap, new v.c(), local1);
      return;
    }
  }
  
  public final void ca(List<o> paramList)
  {
    a locala = this.ndT;
    if ((paramList == null) || (paramList.size() == 0))
    {
      save();
      return;
    }
    paramList = paramList.iterator();
    label132:
    for (;;)
    {
      label30:
      o localo1;
      Iterator localIterator;
      int i;
      if (paramList.hasNext())
      {
        localo1 = (o)paramList.next();
        localIterator = locala.ncZ.iterator();
        i = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label132;
        }
        o localo2 = (o)localIterator.next();
        if (localo2.lCF.equalsIgnoreCase(localo1.lCF))
        {
          locala.wj(i);
          localo2.ndP += 1;
          locala.a(localo2);
          break label30;
          break;
        }
        i += 1;
      }
    }
  }
  
  protected final void finalize()
  {
    this.dhm.clear();
  }
  
  final void save()
  {
    try
    {
      this.ndS.a("address", null, this.ndT.toByteArray());
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", localIOException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.p
 * JD-Core Version:    0.7.0.1
 */