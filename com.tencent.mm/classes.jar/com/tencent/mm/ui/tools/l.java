package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.base.u.d;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.Iterator;
import java.util.List;

public class l
  implements AdapterView.OnItemClickListener
{
  public u.i GAC;
  public u.g Vtg;
  public u.b Vti;
  public u.d Vtj;
  private s Vtk;
  public f afJj;
  private f.b afJk;
  private s afJl;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(143164);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.afJj = new f(paramContext, 1, false);
    this.Vtk = new s(paramContext);
    this.afJl = new s(paramContext);
    AppMethodBeat.o(143164);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, u.i parami)
  {
    AppMethodBeat.i(143166);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      AppMethodBeat.o(143166);
      return;
    }
    this.GAC = parami;
    this.afJl.clear();
    parami = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.afJl, paramView, parami);
    paramView = this.afJl.adRW.iterator();
    while (paramView.hasNext()) {
      ((t)paramView.next()).adSb = parami;
    }
    this.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(143162);
        paramAnonymouss.clear();
        Iterator localIterator = l.a(l.this).adRW.iterator();
        while (localIterator.hasNext()) {
          paramAnonymouss.j((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143162);
      }
    };
    this.afJj.GwS = true;
    jDd();
    AppMethodBeat.o(143166);
  }
  
  public final void a(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, u.i parami)
  {
    AppMethodBeat.i(143165);
    this.GAC = parami;
    Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
    if ((paramView instanceof AbsListView))
    {
      Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(143157);
          l.a(l.this).clear();
          Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = l.a(l.this).adRW.iterator();
          while (paramAnonymousView.hasNext()) {
            ((t)paramAnonymousView.next()).adSb = paramAnonymousAdapterView;
          }
          l.a(l.this, new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(143156);
              paramAnonymous2s.clear();
              Iterator localIterator = l.a(l.this).adRW.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2s.j((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143156);
            }
          });
          l.b(l.this).GwS = true;
          l.this.jDd();
          AppMethodBeat.o(143157);
          return true;
        }
      });
      AppMethodBeat.o(143165);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(143159);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
          l.a(l.this).clear();
          paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
          l.a(l.this, new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(143158);
              paramAnonymous2s.clear();
              Iterator localIterator = l.a(l.this).adRW.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2s.j((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143158);
            }
          });
          l.b(l.this).GwS = true;
          l.this.jDd();
          if (l.a(l.this).size() > 0)
          {
            a.a(true, this, "com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(143159);
            return true;
          }
          a.a(false, this, "com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(143159);
          return false;
        }
      });
      AppMethodBeat.o(143165);
      return;
    }
    Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143161);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        l.a(l.this).clear();
        paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
        l.a(l.this, new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(143160);
            paramAnonymous2s.clear();
            Iterator localIterator = l.a(l.this).adRW.iterator();
            while (localIterator.hasNext()) {
              paramAnonymous2s.j((MenuItem)localIterator.next());
            }
            AppMethodBeat.o(143160);
          }
        });
        l.b(l.this).GwS = true;
        l.this.jDd();
        a.a(true, this, "com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(143161);
        return true;
      }
    });
    AppMethodBeat.o(143165);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, u.i parami, f.b paramb)
  {
    AppMethodBeat.i(143167);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      AppMethodBeat.o(143167);
      return;
    }
    this.afJk = paramb;
    this.GAC = parami;
    this.afJl.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.afJl, paramView, null);
    this.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(143163);
        paramAnonymouss.clear();
        Iterator localIterator = l.a(l.this).adRW.iterator();
        while (localIterator.hasNext()) {
          paramAnonymouss.j((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143163);
      }
    };
    this.afJj.GwS = true;
    jDd();
    AppMethodBeat.o(143167);
  }
  
  public final void a(f.a parama)
  {
    this.afJj.ages = parama;
  }
  
  public final void a(f.b paramb)
  {
    this.afJk = paramb;
    this.afJj.aeLi = paramb;
  }
  
  @Deprecated
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, u.i parami)
  {
    AppMethodBeat.i(143168);
    a(paramView, paramOnCreateContextMenuListener, parami, null);
    AppMethodBeat.o(143168);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(143170);
    if (this.afJj.isShowing()) {
      this.afJj.cyW();
    }
    AppMethodBeat.o(143170);
  }
  
  public final Dialog jDd()
  {
    AppMethodBeat.i(143171);
    if (this.Vtg != null)
    {
      this.Vtk.clear();
      this.Vtk = new s(this.mContext);
      this.Vtg.onCreateMMMenu(this.Vtk);
    }
    if (this.Vtk.jmw())
    {
      Log.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      AppMethodBeat.o(143171);
      return null;
    }
    this.afJj.Vtg = this.Vtg;
    this.afJj.GAC = this.GAC;
    this.afJj.aeLi = this.afJk;
    this.afJj.Vtj = this.Vtj;
    this.afJj.dDn();
    AppMethodBeat.o(143171);
    return null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143169);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    paramAdapterView = (t)this.Vtk.adRW.get(paramInt);
    if (paramAdapterView.performClick())
    {
      Log.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(143169);
      return;
    }
    if (this.GAC != null) {
      this.GAC.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(143169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */