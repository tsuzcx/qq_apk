package com.tencent.mm.plugin.sight.encode.ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, com.tencent.mm.plugin.fts.a.l
{
  private ah handler = new ah(Looper.getMainLooper());
  public EditText ohZ;
  public TextView oia;
  public View oib;
  private a oic;
  InputMethodManager oid;
  public b oie = b.oih;
  public d.a oif;
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (bk.bl(paramEditable.toString())) {
      return;
    }
    paramEditable = paramEditable.toString();
    y.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[] { paramEditable });
    if (this.oic != null)
    {
      ((n)g.t(n.class)).cancelSearchTask(this.oic);
      this.oic = null;
    }
    HashSet localHashSet = new HashSet();
    b localb = b.kxE;
    ah localah = this.handler;
    paramEditable = i.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localah);
    this.oic = ((n)g.t(n.class)).search(2, paramEditable);
  }
  
  public final void b(j paramj)
  {
    if ((paramj.aYY != 0) || (paramj.kxh == null) || (this.oif == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramj = paramj.kxh.iterator();
    while (paramj.hasNext()) {
      localArrayList.add(((com.tencent.mm.plugin.fts.a.a.l)paramj.next()).kwg);
    }
    this.oif.ct(localArrayList);
  }
  
  public final boolean bBK()
  {
    return this.oie == b.oig;
  }
  
  public final void bBL()
  {
    if (bBK()) {
      bBM();
    }
    while (bBK()) {
      return;
    }
    this.oie = b.oig;
    this.oib.setVisibility(0);
    if (this.oif != null) {
      this.oif.bBN();
    }
    this.ohZ.requestFocus();
    this.oid.showSoftInput(this.ohZ, 0);
  }
  
  public final void bBM()
  {
    if (!bBK()) {}
    do
    {
      return;
      this.ohZ.setText("");
      this.ohZ.clearFocus();
      bk.hideVKB(this.ohZ);
      this.oie = b.oih;
      this.oib.setVisibility(8);
    } while (this.oif == null);
    this.oif.bBO();
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getId() != R.h.search_cancel_tv) || (!bBK())) {
      return;
    }
    bBL();
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.ohZ.clearFocus();
      bk.hideVKB(this.ohZ);
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */