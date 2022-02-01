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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.List;

public final class l
  implements AdapterView.OnItemClickListener
{
  private com.tencent.mm.ui.base.l ECx;
  public e LfR;
  public n.d LfS;
  public n.e LfT;
  private e.b LfU;
  private com.tencent.mm.ui.base.l LfV;
  public n.a LfW;
  public n.b LfX;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(143164);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.LfR = new e(paramContext, 1, false);
    this.ECx = new com.tencent.mm.ui.base.l(paramContext);
    this.LfV = new com.tencent.mm.ui.base.l(paramContext);
    AppMethodBeat.o(143164);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.e parame)
  {
    AppMethodBeat.i(143166);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      ae.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      AppMethodBeat.o(143166);
      return;
    }
    this.LfT = parame;
    this.LfV.clear();
    parame = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.LfV, paramView, parame);
    paramView = this.LfV.JGM.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).JGS = parame;
    }
    this.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(143162);
        paramAnonymousl.clear();
        Iterator localIterator = l.a(l.this).JGM.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousl.g((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143162);
      }
    };
    this.LfR.tdt = true;
    fOP();
    AppMethodBeat.o(143166);
  }
  
  public final void a(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.e parame)
  {
    AppMethodBeat.i(143165);
    this.LfT = parame;
    ae.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
    if ((paramView instanceof AbsListView))
    {
      ae.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(143157);
          l.a(l.this).clear();
          ae.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = l.a(l.this).JGM.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).JGS = paramAnonymousAdapterView;
          }
          l.a(l.this, new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(143156);
              paramAnonymous2l.clear();
              Iterator localIterator = l.a(l.this).JGM.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2l.g((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143156);
            }
          });
          l.b(l.this).tdt = true;
          l.this.fOP();
          AppMethodBeat.o(143157);
          return true;
        }
      });
      AppMethodBeat.o(143165);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      ae.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(143159);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          ae.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
          l.a(l.this).clear();
          paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
          l.a(l.this, new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(143158);
              paramAnonymous2l.clear();
              Iterator localIterator = l.a(l.this).JGM.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2l.g((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143158);
            }
          });
          l.b(l.this).tdt = true;
          l.this.fOP();
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
    ae.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143161);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ae.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        l.a(l.this).clear();
        paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
        l.a(l.this, new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(143160);
            paramAnonymous2l.clear();
            Iterator localIterator = l.a(l.this).JGM.iterator();
            while (localIterator.hasNext()) {
              paramAnonymous2l.g((MenuItem)localIterator.next());
            }
            AppMethodBeat.o(143160);
          }
        });
        l.b(l.this).tdt = true;
        l.this.fOP();
        a.a(true, this, "com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(143161);
        return true;
      }
    });
    AppMethodBeat.o(143165);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.e parame, e.b paramb)
  {
    AppMethodBeat.i(143167);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      ae.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      AppMethodBeat.o(143167);
      return;
    }
    this.LfU = paramb;
    this.LfT = parame;
    this.LfV.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.LfV, paramView, null);
    this.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(143163);
        paramAnonymousl.clear();
        Iterator localIterator = l.a(l.this).JGM.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousl.g((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143163);
      }
    };
    this.LfR.tdt = true;
    fOP();
    AppMethodBeat.o(143167);
  }
  
  public final void a(n.d paramd)
  {
    this.LfS = paramd;
  }
  
  public final void a(n.e parame)
  {
    this.LfT = parame;
  }
  
  public final void a(e.a parama)
  {
    this.LfR.LsV = parama;
  }
  
  public final void a(e.b paramb)
  {
    this.LfU = paramb;
    this.LfR.KtV = paramb;
  }
  
  @Deprecated
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.e parame)
  {
    AppMethodBeat.i(143168);
    a(paramView, paramOnCreateContextMenuListener, parame, null);
    AppMethodBeat.o(143168);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(143170);
    if (this.LfR.isShowing()) {
      this.LfR.bqD();
    }
    AppMethodBeat.o(143170);
  }
  
  public final Dialog fOP()
  {
    AppMethodBeat.i(143171);
    if (this.LfS != null)
    {
      this.ECx.clear();
      this.ECx = new com.tencent.mm.ui.base.l(this.mContext);
      this.LfS.onCreateMMMenu(this.ECx);
    }
    if (this.ECx.fCR())
    {
      ae.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      AppMethodBeat.o(143171);
      return null;
    }
    this.LfR.LfS = this.LfS;
    this.LfR.LfT = this.LfT;
    this.LfR.KtV = this.LfU;
    this.LfR.LfX = this.LfX;
    this.LfR.cPF();
    AppMethodBeat.o(143171);
    return null;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143169);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    paramAdapterView = (m)this.ECx.JGM.get(paramInt);
    if (paramAdapterView.performClick())
    {
      ae.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(143169);
      return;
    }
    if (this.LfT != null) {
      this.LfT.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(143169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */