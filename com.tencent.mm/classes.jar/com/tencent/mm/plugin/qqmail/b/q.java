package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q
{
  List<a> callbacks;
  int status;
  long uLA;
  private k uLB;
  a uLC;
  private int uLD;
  int uLE;
  private int uLF;
  int uLG;
  
  q(String paramString)
  {
    AppMethodBeat.i(122698);
    this.uLA = 0L;
    this.uLD = 0;
    this.uLE = 1;
    this.uLF = 2;
    this.uLG = 3;
    this.status = this.uLD;
    this.uLB = new k(paramString, 1);
    paramString = k.readFromFile(this.uLB.uLk + "address");
    if (paramString != null)
    {
      this.uLB.a("address", null, paramString);
      i.deleteFile(this.uLB.uLk + "address");
      if (paramString == null) {
        break label216;
      }
    }
    for (;;)
    {
      try
      {
        this.uLC = new a().bv(paramString);
        this.callbacks = new ArrayList();
        AppMethodBeat.o(122698);
        return;
        paramString = this.uLB.A("address", null);
      }
      catch (IOException paramString)
      {
        ad.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", paramString, "", new Object[0]);
        this.uLC = new a();
        this.uLC.akP("");
        continue;
      }
      label216:
      this.uLC = new a();
      this.uLC.akP("");
    }
  }
  
  public static p akW(String paramString)
  {
    AppMethodBeat.i(122706);
    if (paramString == null)
    {
      AppMethodBeat.o(122706);
      return null;
    }
    paramString = paramString.trim();
    int i = paramString.trim().lastIndexOf(" ");
    if (i == -1)
    {
      AppMethodBeat.o(122706);
      return null;
    }
    p localp = new p();
    localp.name = paramString.substring(0, i);
    localp.sOr = paramString.substring(i + 1);
    AppMethodBeat.o(122706);
    return localp;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(122702);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      if ((a)localIterator.next() == parama)
      {
        AppMethodBeat.o(122702);
        return;
      }
    }
    this.callbacks.add(parama);
    AppMethodBeat.o(122702);
  }
  
  public final List<p> akV(String paramString)
  {
    AppMethodBeat.i(122700);
    Object localObject = this.uLC.uKL;
    if (this.status <= this.uLE)
    {
      ddW();
      AppMethodBeat.o(122700);
      return localObject;
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(122700);
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      p localp = (p)((Iterator)localObject).next();
      if ((localp != null) && (((localp.name != null) && (localp.name.contains(paramString))) || ((localp.uLz != null) && (localp.uLz.contains(paramString))) || ((localp.sOr != null) && (localp.sOr.contains(paramString)))))
      {
        a.b(localp);
        localArrayList.add(localp);
      }
    }
    AppMethodBeat.o(122700);
    return localArrayList;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(122703);
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala == parama)
      {
        this.callbacks.remove(locala);
        AppMethodBeat.o(122703);
        return;
      }
    }
    AppMethodBeat.o(122703);
  }
  
  public final void ddW()
  {
    AppMethodBeat.i(122701);
    if (this.status == this.uLF)
    {
      AppMethodBeat.o(122701);
      return;
    }
    if (bt.eGO() - this.uLA <= 600000L)
    {
      localObject = this.callbacks.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onComplete();
      }
      AppMethodBeat.o(122701);
      return;
    }
    this.status = this.uLF;
    HashMap localHashMap = new HashMap();
    if (this.uLC.uKJ == null) {}
    for (Object localObject = "";; localObject = this.uLC.uKJ)
    {
      localHashMap.put("syncinfo", localObject);
      ad.d("MicroMsg.Plugin.MailAddrMgr", "%s", new Object[] { "sync~~~" });
      ((o)g.ad(o.class)).getNormalMailAppService().b("/cgi-bin/syncaddrlist", localHashMap, new w.a()
      {
        public final void onComplete()
        {
          q.this.status = q.this.uLG;
        }
        
        public final void onError(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(122697);
          paramAnonymousString = q.this.callbacks.iterator();
          while (paramAnonymousString.hasNext()) {
            ((q.a)paramAnonymousString.next()).onComplete();
          }
          AppMethodBeat.o(122697);
        }
        
        public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
        {
          AppMethodBeat.i(122696);
          q localq = q.this;
          int m = bt.getInt((String)paramAnonymousMap.get(".Response.result.Count"), 0);
          if (m > 0)
          {
            int i;
            int j;
            Object localObject1;
            if (localq.uLC.uKL.size() == 0)
            {
              i = 1;
              j = 0;
              if (j >= m) {
                break label474;
              }
              localObject1 = new StringBuilder(".Response.result.List.item");
              if (j <= 0) {
                break label328;
              }
            }
            String str1;
            Object localObject2;
            int n;
            int k;
            label328:
            for (paramAnonymousString = String.valueOf(j);; paramAnonymousString = "")
            {
              paramAnonymousString = paramAnonymousString + ".";
              String str2 = (String)paramAnonymousMap.get(paramAnonymousString + "Del");
              str1 = (String)paramAnonymousMap.get(paramAnonymousString + "Freq");
              localObject2 = (String)paramAnonymousMap.get(paramAnonymousString + "Name");
              localObject1 = (String)paramAnonymousMap.get(paramAnonymousString + "Addr");
              if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
                break label401;
              }
              if (localObject2 != null)
              {
                paramAnonymousString = (String)localObject2;
                if (((String)localObject2).length() != 0) {}
              }
              else
              {
                paramAnonymousString = (String)localObject1;
              }
              n = ((String)localObject1).hashCode();
              if (!str2.equals("0")) {
                break label410;
              }
              localObject2 = localq.uLC.uKL;
              k = 0;
              while ((i == 0) && (k < ((List)localObject2).size()) && (((p)((List)localObject2).get(k)).uLx != n)) {
                k += 1;
              }
              i = 0;
              break;
            }
            if ((k >= ((List)localObject2).size()) || (i != 0))
            {
              localObject2 = new p();
              ((p)localObject2).uLx = n;
              ((p)localObject2).name = paramAnonymousString;
              ((p)localObject2).sOr = ((String)localObject1);
              ((p)localObject2).uLy = bt.getInt(str1, 0);
              localq.uLC.a((p)localObject2);
            }
            label401:
            label410:
            label472:
            for (;;)
            {
              j += 1;
              break;
              paramAnonymousString = localq.uLC.uKL.iterator();
              k = 0;
              for (;;)
              {
                if (!paramAnonymousString.hasNext()) {
                  break label472;
                }
                if (((p)paramAnonymousString.next()).uLx == n)
                {
                  localq.uLC.JJ(k);
                  break;
                }
                k += 1;
              }
            }
            label474:
            localq.uLC.akP((String)paramAnonymousMap.get(".Response.result.SyncInfo"));
            localq.save();
          }
          if (((String)paramAnonymousMap.get(".Response.result.ContinueFlag")).equals("1"))
          {
            new ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(122695);
                q.this.status = q.this.uLE;
                q.this.ddW();
                AppMethodBeat.o(122695);
              }
            }, 0L);
            AppMethodBeat.o(122696);
            return;
          }
          q.this.uLA = bt.eGO();
          paramAnonymousString = q.this.callbacks.iterator();
          while (paramAnonymousString.hasNext()) {
            ((q.a)paramAnonymousString.next()).onComplete();
          }
          AppMethodBeat.o(122696);
        }
      });
      AppMethodBeat.o(122701);
      return;
    }
  }
  
  public final void ez(List<p> paramList)
  {
    AppMethodBeat.i(122704);
    a locala = this.uLC;
    if ((paramList == null) || (paramList.size() == 0))
    {
      save();
      AppMethodBeat.o(122704);
      return;
    }
    paramList = paramList.iterator();
    label144:
    for (;;)
    {
      label42:
      p localp1;
      Iterator localIterator;
      int i;
      if (paramList.hasNext())
      {
        localp1 = (p)paramList.next();
        localIterator = locala.uKL.iterator();
        i = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label144;
        }
        p localp2 = (p)localIterator.next();
        if (localp2.sOr.equalsIgnoreCase(localp1.sOr))
        {
          locala.JJ(i);
          localp2.uLy += 1;
          locala.a(localp2);
          break label42;
          break;
        }
        i += 1;
      }
    }
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(122699);
    this.callbacks.clear();
    AppMethodBeat.o(122699);
  }
  
  final void save()
  {
    AppMethodBeat.i(122705);
    try
    {
      this.uLB.a("address", null, this.uLC.toByteArray());
      AppMethodBeat.o(122705);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.Plugin.MailAddrMgr", localIOException, "", new Object[0]);
      AppMethodBeat.o(122705);
    }
  }
  
  public static abstract class a
  {
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.q
 * JD-Core Version:    0.7.0.1
 */