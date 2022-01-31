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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Iterator;
import java.util.List;

public final class l
  implements AdapterView.OnItemClickListener
{
  private l.a AvX;
  public n.a AvY;
  public n.b AvZ;
  private DialogInterface.OnDismissListener jiU;
  private Context mContext;
  private LayoutInflater mInflater;
  public k san;
  public n.c sao;
  public n.d sap;
  private com.tencent.mm.ui.base.l saq;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(107706);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.san = new k(paramContext);
    this.saq = new com.tencent.mm.ui.base.l(paramContext);
    AppMethodBeat.o(107706);
  }
  
  public final void a(View paramView, int paramInt, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(107708);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      ab.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenuForAdapterView");
      AppMethodBeat.o(107708);
      return;
    }
    this.saq.clear();
    AdapterView.AdapterContextMenuInfo localAdapterContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.saq, paramView, localAdapterContextMenuInfo);
    paramView = this.saq.zkW.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).zkZ = localAdapterContextMenuInfo;
    }
    cwt();
    this.sap = paramd;
    AppMethodBeat.o(107708);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(107707);
    this.sap = paramd;
    ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu");
    if ((paramView instanceof AbsListView))
    {
      ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu AbsListView");
      ((AbsListView)paramView).setOnItemLongClickListener(new l.1(this, paramOnCreateContextMenuListener));
      AppMethodBeat.o(107707);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu for webview");
      paramView.setOnLongClickListener(new l.2(this, paramOnCreateContextMenuListener));
      AppMethodBeat.o(107707);
      return;
    }
    ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view");
    paramView.setOnLongClickListener(new l.3(this, paramOnCreateContextMenuListener));
    AppMethodBeat.o(107707);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(107709);
    if (((this.mContext instanceof MMFragmentActivity)) && (((MMFragmentActivity)this.mContext).isSwiping()))
    {
      ab.w("MicroMsg.MMSubMenuHelper", "is swiping, PASS openContextMenu");
      AppMethodBeat.o(107709);
      return;
    }
    this.jiU = paramOnDismissListener;
    this.saq.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.saq, paramView, null);
    cwt();
    this.sap = paramd;
    AppMethodBeat.o(107709);
  }
  
  public final void a(n.c paramc)
  {
    this.sao = paramc;
  }
  
  public final void a(n.d paramd)
  {
    this.sap = paramd;
  }
  
  public final void b(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(107710);
    a(paramView, paramOnCreateContextMenuListener, paramd, null);
    AppMethodBeat.o(107710);
  }
  
  public final Dialog cwt()
  {
    AppMethodBeat.i(107714);
    if (this.sao != null)
    {
      this.saq.clear();
      this.saq = new com.tencent.mm.ui.base.l(this.mContext);
      this.sao.onCreateMMMenu(this.saq);
    }
    if (this.saq.dEc())
    {
      ab.w("MicroMsg.MMSubMenuHelper", "show, menu empty");
      AppMethodBeat.o(107714);
      return null;
    }
    if (this.AvX == null) {
      this.AvX = new l.a(this, (byte)0);
    }
    this.san.krV = this.AvX;
    this.san.wdV = this;
    this.san.setTitle(this.saq.Wu);
    this.san.setOnDismissListener(this.jiU);
    this.san.show();
    k localk = this.san;
    AppMethodBeat.o(107714);
    return localk;
  }
  
  public final void dNO()
  {
    AppMethodBeat.i(142771);
    this.san.setCancelable(true);
    AppMethodBeat.o(142771);
  }
  
  public final void dNP()
  {
    AppMethodBeat.i(142772);
    this.san.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(142772);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(107713);
    if (this.san.isShowing()) {
      this.san.dismiss();
    }
    AppMethodBeat.o(107713);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107712);
    paramAdapterView = (m)this.saq.zkW.get(paramInt);
    if (paramAdapterView.performClick())
    {
      ab.i("MicroMsg.MMSubMenuHelper", "onItemClick menu item has listener");
      dismiss();
      AppMethodBeat.o(107712);
      return;
    }
    if (this.sap != null) {
      this.sap.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
    AppMethodBeat.o(107712);
  }
  
  public final void setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(142770);
    this.san.setOnCancelListener(paramOnCancelListener);
    AppMethodBeat.o(142770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */