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
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.c;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.List;

public final class l
  implements AdapterView.OnItemClickListener
{
  public o.f HLX;
  public o.g HLY;
  public o.b HMa;
  public o.c HMb;
  private m HMc;
  public e QuS;
  private e.b QuT;
  private m QuU;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(143164);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.QuS = new e(paramContext, 1, false);
    this.HMc = new m(paramContext);
    this.QuU = new m(paramContext);
    AppMethodBeat.o(143164);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, o.g paramg)
  {
    AppMethodBeat.i(143166);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      AppMethodBeat.o(143166);
      return;
    }
    this.HLY = paramg;
    this.QuU.clear();
    paramg = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.QuU, paramView, paramg);
    paramView = this.QuU.ORD.iterator();
    while (paramView.hasNext()) {
      ((n)paramView.next()).ORH = paramg;
    }
    this.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(143162);
        paramAnonymousm.clear();
        Iterator localIterator = l.a(l.this).ORD.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousm.g((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143162);
      }
    };
    this.QuS.wjN = true;
    gXI();
    AppMethodBeat.o(143166);
  }
  
  public final void a(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, o.g paramg)
  {
    AppMethodBeat.i(143165);
    this.HLY = paramg;
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
          paramAnonymousView = l.a(l.this).ORD.iterator();
          while (paramAnonymousView.hasNext()) {
            ((n)paramAnonymousView.next()).ORH = paramAnonymousAdapterView;
          }
          l.a(l.this, new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(143156);
              paramAnonymous2m.clear();
              Iterator localIterator = l.a(l.this).ORD.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2m.g((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143156);
            }
          });
          l.b(l.this).wjN = true;
          l.this.gXI();
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
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
          l.a(l.this).clear();
          paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
          l.a(l.this, new o.f()
          {
            public final void onCreateMMMenu(m paramAnonymous2m)
            {
              AppMethodBeat.i(143158);
              paramAnonymous2m.clear();
              Iterator localIterator = l.a(l.this).ORD.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2m.g((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143158);
            }
          });
          l.b(l.this).wjN = true;
          l.this.gXI();
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
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        l.a(l.this).clear();
        paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
        l.a(l.this, new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(143160);
            paramAnonymous2m.clear();
            Iterator localIterator = l.a(l.this).ORD.iterator();
            while (localIterator.hasNext()) {
              paramAnonymous2m.g((MenuItem)localIterator.next());
            }
            AppMethodBeat.o(143160);
          }
        });
        l.b(l.this).wjN = true;
        l.this.gXI();
        a.a(true, this, "com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(143161);
        return true;
      }
    });
    AppMethodBeat.o(143165);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, o.g paramg, e.b paramb)
  {
    AppMethodBeat.i(143167);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      AppMethodBeat.o(143167);
      return;
    }
    this.QuT = paramb;
    this.HLY = paramg;
    this.QuU.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.QuU, paramView, null);
    this.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(143163);
        paramAnonymousm.clear();
        Iterator localIterator = l.a(l.this).ORD.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousm.g((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143163);
      }
    };
    this.QuS.wjN = true;
    gXI();
    AppMethodBeat.o(143167);
  }
  
  public final void a(o.f paramf)
  {
    this.HLX = paramf;
  }
  
  public final void a(o.g paramg)
  {
    this.HLY = paramg;
  }
  
  public final void a(e.a parama)
  {
    this.QuS.QNO = parama;
  }
  
  public final void a(e.b paramb)
  {
    this.QuT = paramb;
    this.QuS.PGl = paramb;
  }
  
  @Deprecated
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, o.g paramg)
  {
    AppMethodBeat.i(143168);
    a(paramView, paramOnCreateContextMenuListener, paramg, null);
    AppMethodBeat.o(143168);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(143170);
    if (this.QuS.isShowing()) {
      this.QuS.bMo();
    }
    AppMethodBeat.o(143170);
  }
  
  public final Dialog gXI()
  {
    AppMethodBeat.i(143171);
    if (this.HLX != null)
    {
      this.HMc.clear();
      this.HMc = new m(this.mContext);
      this.HLX.onCreateMMMenu(this.HMc);
    }
    if (this.HMc.gKQ())
    {
      Log.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      AppMethodBeat.o(143171);
      return null;
    }
    this.QuS.HLX = this.HLX;
    this.QuS.HLY = this.HLY;
    this.QuS.PGl = this.QuT;
    this.QuS.HMb = this.HMb;
    this.QuS.dGm();
    AppMethodBeat.o(143171);
    return null;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143169);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    paramAdapterView = (n)this.HMc.ORD.get(paramInt);
    if (paramAdapterView.performClick())
    {
      Log.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(143169);
      return;
    }
    if (this.HLY != null) {
      this.HLY.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(143169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */