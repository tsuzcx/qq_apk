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

public class n
{
  protected List<o> IXa;
  protected Map<Integer, a> xxy;
  
  public n()
  {
    AppMethodBeat.i(78709);
    this.IXa = new LinkedList();
    this.xxy = new HashMap();
    dTx();
    dTy();
    AppMethodBeat.o(78709);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(78711);
    this.xxy.put(Integer.valueOf(parama.id), parama);
    AppMethodBeat.o(78711);
  }
  
  private void i(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78713);
    this.IXa.add(new o(paramInt, paramString, paramBoolean, false));
    AppMethodBeat.o(78713);
  }
  
  private void j(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78714);
    this.IXa.add(new o(paramInt, paramString, paramBoolean, true));
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
    Iterator localIterator = this.IXa.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramMenuItem = (o)localIterator.next();
    } while ((paramMenuItem == null) || (paramMenuItem.id != i));
    for (;;)
    {
      paramMenuItem = (a)this.xxy.get(Integer.valueOf(paramMenuItem.id));
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
  
  public final void aYA(String paramString)
  {
    AppMethodBeat.i(78720);
    Iterator localIterator = this.IXa.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo.name.equals(paramString)) {
        if (!localo.IXb)
        {
          localo.oBV = true;
          AppMethodBeat.o(78720);
          return;
        }
      }
    }
    AppMethodBeat.o(78720);
  }
  
  public final void aYB(String paramString)
  {
    AppMethodBeat.i(78721);
    Iterator localIterator = this.IXa.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (localo.name.equals(paramString))
      {
        localo.oBV = false;
        AppMethodBeat.o(78721);
        return;
      }
    }
    AppMethodBeat.o(78721);
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, com.tencent.mm.ui.base.m paramm)
  {
    AppMethodBeat.i(78715);
    Iterator localIterator = this.IXa.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if ((!((o)localObject).oBV) && (!((o)localObject).IXc))
      {
        localObject = (a)this.xxy.get(Integer.valueOf(((o)localObject).id));
        if (localObject != null) {
          ((a)localObject).a(paramContext, paramg, paramm);
        }
      }
    }
    AppMethodBeat.o(78715);
  }
  
  public final void c(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, com.tencent.mm.ui.base.m paramm)
  {
    AppMethodBeat.i(78716);
    Iterator localIterator = this.IXa.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (o)localIterator.next();
      if ((!((o)localObject).oBV) && (((o)localObject).IXc))
      {
        localObject = (a)this.xxy.get(Integer.valueOf(((o)localObject).id));
        if (localObject != null) {
          ((a)localObject).a(paramContext, paramg, paramm);
        }
      }
    }
    AppMethodBeat.o(78716);
  }
  
  protected void dTx()
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
  
  protected void dTy()
  {
    AppMethodBeat.i(78712);
    this.IXa.clear();
    j(35, "menuItem:minimize", true);
    i(1, "menuItem:share:appMessage", false);
    i(2, "menuItem:share:timeline", false);
    FavUrlTask localFavUrlTask = new FavUrlTask();
    localFavUrlTask.actionType = 3;
    AppBrandMainProcessService.b(localFavUrlTask);
    if (localFavUrlTask.ISM)
    {
      i(3, "menuItem:favorite", false);
      j(12, "menuItem:editTag", false);
      j(9, "menuItem:favorite", false);
    }
    j(31, "menuItem:search", true);
    j(6, "menuItem:copyUrl", false);
    i(7, "menuItem:openWithSafari", false);
    i(27, "menuItem:finish", true);
    j(28, "menuItem:refresh", true);
    j(29, "menuItem:addShortcut", false);
    AppMethodBeat.o(78712);
  }
  
  public final void gbX()
  {
    AppMethodBeat.i(78718);
    Iterator localIterator = this.IXa.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (!localo.IXb) {
        localo.oBV = true;
      }
    }
    AppMethodBeat.o(78718);
  }
  
  public final void gbY()
  {
    AppMethodBeat.i(78719);
    Iterator localIterator = this.IXa.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if (!localo.IXb) {
        localo.oBV = false;
      }
    }
    AppMethodBeat.o(78719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */