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
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.c;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Iterator;
import java.util.List;

public class m
  implements AdapterView.OnItemClickListener
{
  public q.f ODT;
  public q.g ODU;
  public q.b ODW;
  public q.c ODX;
  private o ODY;
  public e XSU;
  private e.b XSV;
  private o XSW;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(143164);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.XSU = new e(paramContext, 1, false);
    this.ODY = new o(paramContext);
    this.XSW = new o(paramContext);
    AppMethodBeat.o(143164);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, q.g paramg)
  {
    AppMethodBeat.i(143166);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      AppMethodBeat.o(143166);
      return;
    }
    this.ODU = paramg;
    this.XSW.clear();
    paramg = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.XSW, paramView, paramg);
    paramView = this.XSW.WkP.iterator();
    while (paramView.hasNext()) {
      ((p)paramView.next()).WkU = paramg;
    }
    this.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(143162);
        paramAnonymouso.clear();
        Iterator localIterator = m.a(m.this).WkP.iterator();
        while (localIterator.hasNext()) {
          paramAnonymouso.h((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143162);
      }
    };
    this.XSU.AUB = true;
    hYu();
    AppMethodBeat.o(143166);
  }
  
  public final void a(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, q.g paramg)
  {
    AppMethodBeat.i(143165);
    this.ODU = paramg;
    Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
    if ((paramView instanceof AbsListView))
    {
      Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(143157);
          m.a(m.this).clear();
          Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(m.a(m.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = m.a(m.this).WkP.iterator();
          while (paramAnonymousView.hasNext()) {
            ((p)paramAnonymousView.next()).WkU = paramAnonymousAdapterView;
          }
          m.a(m.this, new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(143156);
              paramAnonymous2o.clear();
              Iterator localIterator = m.a(m.this).WkP.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2o.h((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143156);
            }
          });
          m.b(m.this).AUB = true;
          m.this.hYu();
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
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/ui/tools/MMListMenuHelper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
          Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
          m.a(m.this).clear();
          paramOnCreateContextMenuListener.onCreateContextMenu(m.a(m.this), paramAnonymousView, null);
          m.a(m.this, new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(143158);
              paramAnonymous2o.clear();
              Iterator localIterator = m.a(m.this).WkP.iterator();
              while (localIterator.hasNext()) {
                paramAnonymous2o.h((MenuItem)localIterator.next());
              }
              AppMethodBeat.o(143158);
            }
          });
          m.b(m.this).AUB = true;
          m.this.hYu();
          if (m.a(m.this).size() > 0)
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
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        Log.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
        m.a(m.this).clear();
        paramOnCreateContextMenuListener.onCreateContextMenu(m.a(m.this), paramAnonymousView, null);
        m.a(m.this, new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(143160);
            paramAnonymous2o.clear();
            Iterator localIterator = m.a(m.this).WkP.iterator();
            while (localIterator.hasNext()) {
              paramAnonymous2o.h((MenuItem)localIterator.next());
            }
            AppMethodBeat.o(143160);
          }
        });
        m.b(m.this).AUB = true;
        m.this.hYu();
        a.a(true, this, "com/tencent/mm/ui/tools/MMListMenuHelper$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(143161);
        return true;
      }
    });
    AppMethodBeat.o(143165);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, q.g paramg, e.b paramb)
  {
    AppMethodBeat.i(143167);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      Log.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      AppMethodBeat.o(143167);
      return;
    }
    this.XSV = paramb;
    this.ODU = paramg;
    this.XSW.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.XSW, paramView, null);
    this.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(143163);
        paramAnonymouso.clear();
        Iterator localIterator = m.a(m.this).WkP.iterator();
        while (localIterator.hasNext()) {
          paramAnonymouso.h((MenuItem)localIterator.next());
        }
        AppMethodBeat.o(143163);
      }
    };
    this.XSU.AUB = true;
    hYu();
    AppMethodBeat.o(143167);
  }
  
  public final void a(q.f paramf)
  {
    this.ODT = paramf;
  }
  
  public final void a(q.g paramg)
  {
    this.ODU = paramg;
  }
  
  public final void a(e.a parama)
  {
    this.XSU.YmE = parama;
  }
  
  public final void a(e.b paramb)
  {
    this.XSV = paramb;
    this.XSU.XbB = paramb;
  }
  
  @Deprecated
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, q.g paramg)
  {
    AppMethodBeat.i(143168);
    a(paramView, paramOnCreateContextMenuListener, paramg, null);
    AppMethodBeat.o(143168);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(143170);
    if (this.XSU.isShowing()) {
      this.XSU.bYF();
    }
    AppMethodBeat.o(143170);
  }
  
  public final Dialog hYu()
  {
    AppMethodBeat.i(143171);
    if (this.ODT != null)
    {
      this.ODY.clear();
      this.ODY = new o(this.mContext);
      this.ODT.onCreateMMMenu(this.ODY);
    }
    if (this.ODY.hJO())
    {
      Log.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      AppMethodBeat.o(143171);
      return null;
    }
    this.XSU.ODT = this.ODT;
    this.XSU.ODU = this.ODU;
    this.XSU.XbB = this.XSV;
    this.XSU.ODX = this.ODX;
    this.XSU.eik();
    AppMethodBeat.o(143171);
    return null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(143169);
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    a.c("com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    paramAdapterView = (p)this.ODY.WkP.get(paramInt);
    if (paramAdapterView.performClick())
    {
      Log.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(143169);
      return;
    }
    if (this.ODU != null) {
      this.ODU.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
    a.a(this, "com/tencent/mm/ui/tools/MMListMenuHelper", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(143169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */