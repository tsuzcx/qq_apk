package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class l
{
  protected Map<Integer, a> kNo = new HashMap();
  protected List<m> reu = new LinkedList();
  
  public l()
  {
    aYL();
    aYM();
  }
  
  private void a(a parama)
  {
    this.kNo.put(Integer.valueOf(parama.id), parama);
  }
  
  private void h(int paramInt, String paramString, boolean paramBoolean)
  {
    this.reu.add(new m(paramInt, paramString, paramBoolean));
  }
  
  public final void RN(String paramString)
  {
    Iterator localIterator = this.reu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.name.equals(paramString)) {
        localm.gPg = true;
      }
    }
  }
  
  public final void RO(String paramString)
  {
    Iterator localIterator = this.reu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.name.equals(paramString)) {
        localm.gPg = false;
      }
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame, MenuItem paramMenuItem)
  {
    if (paramMenuItem == null) {
      return;
    }
    int i = paramMenuItem.getItemId();
    Iterator localIterator = this.reu.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramMenuItem = (m)localIterator.next();
    } while ((paramMenuItem == null) || (paramMenuItem.id != i));
    for (;;)
    {
      paramMenuItem = (a)this.kNo.get(Integer.valueOf(paramMenuItem.id));
      if (paramMenuItem == null) {
        break;
      }
      paramMenuItem.a(paramContext, parame);
      return;
      paramMenuItem = null;
    }
  }
  
  public void aYL()
  {
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
  }
  
  public void aYM()
  {
    this.reu = new LinkedList();
    h(35, "menuItem:minimize", true);
    h(1, "menuItem:share:appMessage", false);
    h(2, "menuItem:share:timeline", false);
    FavUrlTask localFavUrlTask = new FavUrlTask();
    localFavUrlTask.actionType = 3;
    LuggageMainProcessService.b(localFavUrlTask);
    if (localFavUrlTask.rbv)
    {
      h(3, "menuItem:favorite", false);
      h(12, "menuItem:editTag", false);
    }
    h(31, "menuItem:search", true);
    h(6, "menuItem:copyUrl", false);
    h(7, "menuItem:openWithSafari", false);
    h(27, "menuItem:finish", true);
    h(28, "menuItem:refresh", true);
  }
  
  public final void b(Context paramContext, com.tencent.mm.plugin.webview.luggage.e parame, com.tencent.mm.ui.base.l paraml)
  {
    Iterator localIterator = this.reu.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (m)localIterator.next();
      if (!((m)localObject).gPg)
      {
        localObject = (a)this.kNo.get(Integer.valueOf(((m)localObject).id));
        if (localObject != null) {
          ((a)localObject).a(paramContext, parame, paraml);
        }
      }
    }
  }
  
  public final void cbD()
  {
    Iterator localIterator = this.reu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (!localm.rev) {
        localm.gPg = true;
      }
    }
  }
  
  public final void cbE()
  {
    Iterator localIterator = this.reu.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (!localm.rev) {
        localm.gPg = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */