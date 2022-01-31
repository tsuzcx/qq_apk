package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  List<p.a> callbacks;
  long pJh;
  private k pJi;
  a pJj;
  private int pJk;
  int pJl;
  private int pJm;
  int pJn;
  int status;
  
  p(String paramString)
  {
    AppMethodBeat.i(67964);
    this.pJh = 0L;
    this.pJk = 0;
    this.pJl = 1;
    this.pJm = 2;
    this.pJn = 3;
    this.status = this.pJk;
    this.pJi = new k(paramString, 1);
    paramString = k.readFromFile(this.pJi.pIR + "address");
    if (paramString != null)
    {
      this.pJi.b("address", null, paramString);
      e.deleteFile(this.pJi.pIR + "address");
      if (paramString == null) {
        break label216;
      }
    }
    for (;;)
    {
      try
      {
        this.pJj = new a().bf(paramString);
        this.callbacks = new ArrayList();
        AppMethodBeat.o(67964);
        return;
        paramString = this.pJi.v("address", null);
      }
      catch (IOException paramString)
      {
        ab.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", paramString, "", new Object[0]);
        this.pJj = new a();
        this.pJj.Xm("");
        continue;
      }
      label216:
      this.pJj = new a();
      this.pJj.Xm("");
    }
  }
  
  public static o Xt(String paramString)
  {
    AppMethodBeat.i(67972);
    if (paramString == null)
    {
      AppMethodBeat.o(67972);
      return null;
    }
    paramString = paramString.trim();
    int i = paramString.trim().lastIndexOf(" ");
    if (i == -1)
    {
      AppMethodBeat.o(67972);
      return null;
    }
    o localo = new o();
    localo.name = paramString.substring(0, i);
    localo.nZR = paramString.substring(i + 1);
    AppMethodBeat.o(67972);
    return localo;
  }
  
  public final List<o> Xs(String paramString)
  {
    AppMethodBeat.i(67966);
    Object localObject = this.pJj.pIr;
    if (this.status <= this.pJl)
    {
      cdE();
      AppMethodBeat.o(67966);
      return localObject;
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(67966);
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      o localo = (o)((Iterator)localObject).next();
      if ((localo != null) && (((localo.name != null) && (localo.name.contains(paramString))) || ((localo.pJg != null) && (localo.pJg.contains(paramString))) || ((localo.nZR != null) && (localo.nZR.contains(paramString)))))
      {
        a.b(localo);
        localArrayList.add(localo);
      }
    }
    AppMethodBeat.o(67966);
    return localArrayList;
  }
  
  public final void a(p.a parama)
  {
    AppMethodBeat.i(67968);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if ((p.a)localIterator.next() == parama)
      {
        AppMethodBeat.o(67968);
        return;
      }
    }
    this.callbacks.add(parama);
    AppMethodBeat.o(67968);
  }
  
  public final void b(p.a parama)
  {
    AppMethodBeat.i(67969);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext())
    {
      p.a locala = (p.a)localIterator.next();
      if (locala == parama)
      {
        this.callbacks.remove(locala);
        AppMethodBeat.o(67969);
        return;
      }
    }
    AppMethodBeat.o(67969);
  }
  
  public final void cC(List<o> paramList)
  {
    AppMethodBeat.i(67970);
    a locala = this.pJj;
    if ((paramList == null) || (paramList.size() == 0))
    {
      save();
      AppMethodBeat.o(67970);
      return;
    }
    paramList = paramList.iterator();
    label142:
    for (;;)
    {
      label40:
      o localo1;
      Iterator localIterator;
      int i;
      if (paramList.hasNext())
      {
        localo1 = (o)paramList.next();
        localIterator = locala.pIr.iterator();
        i = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label142;
        }
        o localo2 = (o)localIterator.next();
        if (localo2.nZR.equalsIgnoreCase(localo1.nZR))
        {
          locala.BU(i);
          localo2.pJf += 1;
          locala.a(localo2);
          break label40;
          break;
        }
        i += 1;
      }
    }
  }
  
  public final void cdE()
  {
    AppMethodBeat.i(67967);
    if (this.status == this.pJm)
    {
      AppMethodBeat.o(67967);
      return;
    }
    if (bo.aoy() - this.pJh <= 600000L)
    {
      localObject = this.callbacks.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((p.a)((Iterator)localObject).next()).onComplete();
      }
      AppMethodBeat.o(67967);
      return;
    }
    this.status = this.pJm;
    HashMap localHashMap = new HashMap();
    if (this.pJj.pIp == null) {}
    for (Object localObject = "";; localObject = this.pJj.pIp)
    {
      localHashMap.put("syncinfo", localObject);
      ab.d("MicroMsg.Plugin.MailAddrMgr", "%s", new Object[] { "sync~~~" });
      ac.cdQ().b("/cgi-bin/syncaddrlist", localHashMap, new p.1(this));
      AppMethodBeat.o(67967);
      return;
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(67965);
    this.callbacks.clear();
    AppMethodBeat.o(67965);
  }
  
  final void save()
  {
    AppMethodBeat.i(67971);
    try
    {
      this.pJi.b("address", null, this.pJj.toByteArray());
      AppMethodBeat.o(67971);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", localIOException, "", new Object[0]);
      AppMethodBeat.o(67971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.p
 * JD-Core Version:    0.7.0.1
 */