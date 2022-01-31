package com.tencent.mm.ui.tools;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Iterator;
import java.util.List;

public final class j
  implements AdapterView.OnItemClickListener
{
  private LayoutInflater Lu;
  private DialogInterface.OnDismissListener hsn;
  private Context mContext;
  public k phG;
  public n.c phH;
  public n.d phI;
  private l phJ;
  private j.a wdq;
  public n.a wdr;
  public n.b wds;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(paramContext);
    this.phG = new k(paramContext);
    this.phJ = new l(paramContext);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      y.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      return;
    }
    this.phJ.clear();
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.phJ, paramView, localAdapterContextMenuInfo);
    paramView = this.phJ.uWD.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).uWG = localAdapterContextMenuInfo;
    }
    bJQ();
    this.phI = paramd;
  }
  
  public final void a(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    this.phI = paramd;
    y.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
    if ((paramView instanceof AbsListView))
    {
      y.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          j.a(j.this).clear();
          y.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView long click");
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(j.a(j.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = j.a(j.this).uWD.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).uWG = paramAnonymousAdapterView;
          }
          j.this.bJQ();
          return true;
        }
      });
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      y.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
      paramView.setOnLongClickListener(new j.2(this, paramOnCreateContextMenuListener));
      return;
    }
    y.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
    paramView.setOnLongClickListener(new j.3(this, paramOnCreateContextMenuListener));
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      y.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      return;
    }
    this.hsn = paramOnDismissListener;
    this.phJ.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.phJ, paramView, null);
    bJQ();
    this.phI = paramd;
  }
  
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    a(paramView, paramOnCreateContextMenuListener, paramd, null);
  }
  
  public final Dialog bJQ()
  {
    if (this.phH != null)
    {
      this.phJ.clear();
      this.phJ = new l(this.mContext);
      this.phH.a(this.phJ);
    }
    if (this.phJ.cAR())
    {
      y.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      return null;
    }
    if (this.wdq == null) {
      this.wdq = new j.a(this, (byte)0);
    }
    this.phG.iqN = this.wdq;
    this.phG.slt = this;
    this.phG.setTitle(this.phJ.VF);
    this.phG.setOnDismissListener(this.hsn);
    this.phG.show();
    return this.phG;
  }
  
  public final void d(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.phG.setOnCancelListener(paramOnCancelListener);
  }
  
  public final void dismiss()
  {
    if (this.phG.isShowing()) {
      this.phG.dismiss();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (m)this.phJ.uWD.get(paramInt);
    if (paramAdapterView.performClick())
    {
      y.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      return;
    }
    if (this.phI != null) {
      this.phI.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */