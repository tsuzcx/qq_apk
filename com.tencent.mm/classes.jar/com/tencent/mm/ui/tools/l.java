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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.List;

public final class l
  implements AdapterView.OnItemClickListener
{
  private com.tencent.mm.ui.base.l BoA;
  public e HrW;
  public n.c HrX;
  public n.d HrY;
  private e.b HrZ;
  private com.tencent.mm.ui.base.l Hsa;
  public n.a Hsb;
  public n.b Hsc;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(143164);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.HrW = new e(paramContext, 1, false);
    this.BoA = new com.tencent.mm.ui.base.l(paramContext);
    this.Hsa = new com.tencent.mm.ui.base.l(paramContext);
    AppMethodBeat.o(143164);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(143166);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      ad.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      AppMethodBeat.o(143166);
      return;
    }
    this.HrY = paramd;
    this.Hsa.clear();
    paramd = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.Hsa, paramView, paramd);
    paramView = this.Hsa.FYt.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).FYy = paramd;
    }
    this.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(143162);
        paramAnonymousl.clear();
        Iterator localIterator = l.a(l.this).FYt.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousl.g((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143162);
      }
    };
    this.HrW.qVt = true;
    fdQ();
    AppMethodBeat.o(143166);
  }
  
  public final void a(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(143165);
    this.HrY = paramd;
    ad.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
    if ((paramView instanceof AbsListView))
    {
      ad.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(143157);
          l.a(l.this).clear();
          ad.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = l.a(l.this).FYt.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).FYy = paramAnonymousAdapterView;
          }
          l.a(l.this, new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(143156);
              paramAnonymous2l.clear();
              Iterator localIterator = l.a(l.this).FYt.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2l.g((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143156);
            }
          });
          l.b(l.this).qVt = true;
          l.this.fdQ();
          AppMethodBeat.o(143157);
          return true;
        }
      });
      AppMethodBeat.o(143165);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      ad.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(143159);
          ad.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
          l.a(l.this).clear();
          paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
          l.a(l.this, new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(143158);
              paramAnonymous2l.clear();
              Iterator localIterator = l.a(l.this).FYt.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2l.g((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143158);
            }
          });
          l.b(l.this).qVt = true;
          l.this.fdQ();
          if (l.a(l.this).size() > 0)
          {
            AppMethodBeat.o(143159);
            return true;
          }
          AppMethodBeat.o(143159);
          return false;
        }
      });
      AppMethodBeat.o(143165);
      return;
    }
    ad.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(143161);
        ad.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        l.a(l.this).clear();
        paramOnCreateContextMenuListener.onCreateContextMenu(l.a(l.this), paramAnonymousView, null);
        l.a(l.this, new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(143160);
            paramAnonymous2l.clear();
            Iterator localIterator = l.a(l.this).FYt.iterator();
            while (localIterator.hasNext()) {
              paramAnonymous2l.g((MenuItem)localIterator.next());
            }
            AppMethodBeat.o(143160);
          }
        });
        l.b(l.this).qVt = true;
        l.this.fdQ();
        AppMethodBeat.o(143161);
        return true;
      }
    });
    AppMethodBeat.o(143165);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, e.b paramb)
  {
    AppMethodBeat.i(143167);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      ad.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      AppMethodBeat.o(143167);
      return;
    }
    this.HrZ = paramb;
    this.HrY = paramd;
    this.Hsa.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.Hsa, paramView, null);
    this.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(143163);
        paramAnonymousl.clear();
        Iterator localIterator = l.a(l.this).FYt.iterator();
        while (localIterator.hasNext()) {
          paramAnonymousl.g((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143163);
      }
    };
    this.HrW.qVt = true;
    fdQ();
    AppMethodBeat.o(143167);
  }
  
  public final void a(n.c paramc)
  {
    this.HrX = paramc;
  }
  
  public final void a(n.d paramd)
  {
    this.HrY = paramd;
  }
  
  public final void a(e.a parama)
  {
    this.HrW.HES = parama;
  }
  
  public final void a(e.b paramb)
  {
    this.HrZ = paramb;
    this.HrW.GHn = paramb;
  }
  
  @Deprecated
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(143168);
    a(paramView, paramOnCreateContextMenuListener, paramd, null);
    AppMethodBeat.o(143168);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(143170);
    if (this.HrW.isShowing()) {
      this.HrW.bfo();
    }
    AppMethodBeat.o(143170);
  }
  
  public final Dialog fdQ()
  {
    AppMethodBeat.i(143171);
    if (this.HrX != null)
    {
      this.BoA.clear();
      this.BoA = new com.tencent.mm.ui.base.l(this.mContext);
      this.HrX.onCreateMMMenu(this.BoA);
    }
    if (this.BoA.eSQ())
    {
      ad.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      AppMethodBeat.o(143171);
      return null;
    }
    this.HrW.HrX = this.HrX;
    this.HrW.HrY = this.HrY;
    this.HrW.GHn = this.HrZ;
    this.HrW.csG();
    AppMethodBeat.o(143171);
    return null;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143169);
    paramAdapterView = (m)this.BoA.FYt.get(paramInt);
    if (paramAdapterView.performClick())
    {
      ad.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      AppMethodBeat.o(143169);
      return;
    }
    if (this.HrY != null) {
      this.HrY.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
    AppMethodBeat.o(143169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */