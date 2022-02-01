package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class n
{
  protected Map<Integer, a> Ivx;
  protected List<o> WKb;
  
  public n()
  {
    AppMethodBeat.i(78709);
    this.WKb = new LinkedList();
    this.Ivx = new HashMap();
    fEy();
    fEz();
    AppMethodBeat.o(78709);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(78711);
    this.Ivx.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(78711);
  }
  
  private void k(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78713);
    this.WKb.add(new o(paramInt, paramString, paramBoolean, false));
    AppMethodBeat.o(78713);
  }
  
  private void l(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78714);
    this.WKb.add(new o(paramInt, paramString, paramBoolean, true));
    AppMethodBeat.o(78714);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(78717);
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(78717);
      return;
    }
    int i = paramMenuItem.getItemId();
    Iterator localIterator = this.WKb.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramMenuItem = (o)localIterator.next();
    } while ((paramMenuItem == null) || (paramMenuItem.id != i));
    for (;;)
    {
      paramMenuItem = (a)this.Ivx.get(Integer.valueOf(paramMenuItem.id));
      if (paramMenuItem != null) {
        break;
      }
      AppMethodBeat.o(78717);
      return;
      paramMenuItem = null;
    }
    paramMenuItem.a(paramContext, paramg);
    AppMethodBeat.o(78717);
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, s params)
  {
    AppMethodBeat.i(78715);
    Iterator localIterator = this.WKb.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if ((!((o)localObject).uPP) && (!((o)localObject).WKd))
      {
        localObject = (a)this.Ivx.get(Integer.valueOf(((o)localObject).id));
        if (localObject != null) {
          ((a)localObject).a(paramContext, paramg, params);
        }
      }
    }
    AppMethodBeat.o(78715);
  }
  
  public final void bkf(String paramString)
  {
    AppMethodBeat.i(78720);
    Iterator localIterator = this.WKb.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo.name.equals(paramString)) {
        if (!localo.WKc)
        {
          localo.uPP = true;
          AppMethodBeat.o(78720);
          return;
        }
      }
    }
    AppMethodBeat.o(78720);
  }
  
  public final void bkg(String paramString)
  {
    AppMethodBeat.i(78721);
    Iterator localIterator = this.WKb.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo.name.equals(paramString))
      {
        localo.uPP = false;
        AppMethodBeat.o(78721);
        return;
      }
    }
    AppMethodBeat.o(78721);
  }
  
  public final void c(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, s params)
  {
    AppMethodBeat.i(78716);
    Iterator localIterator = this.WKb.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if ((!((o)localObject).uPP) && (((o)localObject).WKd))
      {
        localObject = (a)this.Ivx.get(Integer.valueOf(((o)localObject).id));
        if (localObject != null) {
          ((a)localObject).a(paramContext, paramg, params);
        }
      }
    }
    AppMethodBeat.o(78716);
  }
  
  protected void fEy()
  {
    AppMethodBeat.i(78710);
    a(new h());
    a(new l());
    a(new m());
    a(new i());
    a(new f());
    a(new d());
    a(new c());
    a(new e());
    a(new g());
    a(new j());
    a(new k());
    a(new b());
    AppMethodBeat.o(78710);
  }
  
  protected void fEz()
  {
    AppMethodBeat.i(78712);
    this.WKb.clear();
    l(35, "menuItem:minimize", true);
    k(1, "menuItem:share:appMessage", false);
    k(2, "menuItem:share:timeline", false);
    FavUrlTask localFavUrlTask = new FavUrlTask();
    localFavUrlTask.actionType = 3;
    localFavUrlTask.cpB();
    if (localFavUrlTask.WFy)
    {
      k(3, "menuItem:favorite", false);
      l(12, "menuItem:editTag", false);
      l(9, "menuItem:favorite", false);
    }
    l(31, "menuItem:search", true);
    l(6, "menuItem:copyUrl", false);
    k(7, "menuItem:openWithSafari", false);
    k(27, "menuItem:finish", true);
    l(28, "menuItem:refresh", true);
    l(29, "menuItem:addShortcut", false);
    AppMethodBeat.o(78712);
  }
  
  public final void iuE()
  {
    AppMethodBeat.i(78718);
    Iterator localIterator = this.WKb.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (!localo.WKc) {
        localo.uPP = true;
      }
    }
    AppMethodBeat.o(78718);
  }
  
  public final void iuF()
  {
    AppMethodBeat.i(78719);
    Iterator localIterator = this.WKb.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (!localo.WKc) {
        localo.uPP = false;
      }
    }
    AppMethodBeat.o(78719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */