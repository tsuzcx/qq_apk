package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class l
{
  protected Map<Integer, a> njT;
  protected List<m> uUu;
  
  public l()
  {
    AppMethodBeat.i(6446);
    this.uUu = new LinkedList();
    this.njT = new HashMap();
    bFo();
    bFp();
    AppMethodBeat.o(6446);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(6448);
    this.njT.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(6448);
  }
  
  private void h(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6450);
    this.uUu.add(new m(paramInt, paramString, paramBoolean));
    AppMethodBeat.o(6450);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(6452);
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(6452);
      return;
    }
    int i = paramMenuItem.getItemId();
    Iterator localIterator = this.uUu.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramMenuItem = (m)localIterator.next();
    } while ((paramMenuItem == null) || (paramMenuItem.id != i));
    for (;;)
    {
      paramMenuItem = (a)this.njT.get(Integer.valueOf(paramMenuItem.id));
      if (paramMenuItem != null) {
        break;
      }
      AppMethodBeat.o(6452);
      return;
      paramMenuItem = null;
    }
    paramMenuItem.a(paramContext, parame);
    AppMethodBeat.o(6452);
  }
  
  public final void agQ(String paramString)
  {
    AppMethodBeat.i(6455);
    Iterator localIterator = this.uUu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.name.equals(paramString)) {
        if (!localm.uUv)
        {
          localm.iqO = true;
          AppMethodBeat.o(6455);
          return;
        }
      }
    }
    AppMethodBeat.o(6455);
  }
  
  public final void agR(String paramString)
  {
    AppMethodBeat.i(6456);
    Iterator localIterator = this.uUu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.name.equals(paramString))
      {
        localm.iqO = false;
        AppMethodBeat.o(6456);
        return;
      }
    }
    AppMethodBeat.o(6456);
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame, com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(6451);
    Iterator localIterator = this.uUu.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (m)localIterator.next();
      if (!((m)localObject).iqO)
      {
        localObject = (a)this.njT.get(Integer.valueOf(((m)localObject).id));
        if (localObject != null) {
          ((a)localObject).a(paramContext, parame, paraml);
        }
      }
    }
    AppMethodBeat.o(6451);
  }
  
  protected void bFo()
  {
    AppMethodBeat.i(6447);
    a(new f());
    a(new j());
    a(new k());
    a(new g());
    a(new d());
    a(new b());
    a(new c());
    a(new e());
    a(new h());
    a(new i());
    AppMethodBeat.o(6447);
  }
  
  protected void bFp()
  {
    AppMethodBeat.i(6449);
    this.uUu = new LinkedList();
    h(35, "menuItem:minimize", true);
    h(1, "menuItem:share:appMessage", false);
    h(2, "menuItem:share:timeline", false);
    FavUrlTask localFavUrlTask = new FavUrlTask();
    localFavUrlTask.actionType = 3;
    AppBrandMainProcessService.b(localFavUrlTask);
    if (localFavUrlTask.uRd)
    {
      h(3, "menuItem:favorite", false);
      h(12, "menuItem:editTag", false);
    }
    h(31, "menuItem:search", true);
    h(6, "menuItem:copyUrl", false);
    h(7, "menuItem:openWithSafari", false);
    h(27, "menuItem:finish", true);
    h(28, "menuItem:refresh", true);
    AppMethodBeat.o(6449);
  }
  
  public final void dbq()
  {
    AppMethodBeat.i(6453);
    Iterator localIterator = this.uUu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (!localm.uUv) {
        localm.iqO = true;
      }
    }
    AppMethodBeat.o(6453);
  }
  
  public final void dbr()
  {
    AppMethodBeat.i(6454);
    Iterator localIterator = this.uUu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (!localm.uUv) {
        localm.iqO = false;
      }
    }
    AppMethodBeat.o(6454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */