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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, l
{
  private ap handler;
  public EditText rLn;
  public TextView wuL;
  public View wuM;
  private a wuN;
  InputMethodManager wuO;
  public d.b wuP;
  public a wuQ;
  
  public d()
  {
    AppMethodBeat.i(28746);
    this.wuP = d.b.wuS;
    this.handler = new ap(Looper.getMainLooper());
    AppMethodBeat.o(28746);
  }
  
  private void drc()
  {
    AppMethodBeat.i(28750);
    if (dra())
    {
      AppMethodBeat.o(28750);
      return;
    }
    this.wuP = d.b.wuR;
    this.wuM.setVisibility(0);
    if (this.wuQ != null) {
      this.wuQ.dre();
    }
    this.rLn.requestFocus();
    this.wuO.showSoftInput(this.rLn, 0);
    AppMethodBeat.o(28750);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(28753);
    if (bt.isNullOrNil(paramEditable.toString()))
    {
      AppMethodBeat.o(28753);
      return;
    }
    paramEditable = paramEditable.toString();
    ad.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[] { paramEditable });
    if (this.wuN != null)
    {
      ((n)g.ad(n.class)).cancelSearchTask(this.wuN);
      this.wuN = null;
    }
    HashSet localHashSet = new HashSet();
    b localb = b.rqn;
    ap localap = this.handler;
    paramEditable = j.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localap);
    this.wuN = ((n)g.ad(n.class)).search(2, paramEditable);
    AppMethodBeat.o(28753);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(28752);
    if (paramk.bRZ == 0)
    {
      if ((paramk.rpQ == null) || (this.wuQ == null))
      {
        AppMethodBeat.o(28752);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramk = paramk.rpQ.iterator();
      while (paramk.hasNext()) {
        localArrayList.add(((m)paramk.next()).roN);
      }
      this.wuQ.fj(localArrayList);
    }
    AppMethodBeat.o(28752);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean dra()
  {
    return this.wuP == d.b.wuR;
  }
  
  public final void drb()
  {
    AppMethodBeat.i(28749);
    if (dra())
    {
      drd();
      AppMethodBeat.o(28749);
      return;
    }
    drc();
    AppMethodBeat.o(28749);
  }
  
  public final void drd()
  {
    AppMethodBeat.i(28751);
    if (!dra())
    {
      AppMethodBeat.o(28751);
      return;
    }
    this.rLn.setText("");
    this.rLn.clearFocus();
    bt.hideVKB(this.rLn);
    this.wuP = d.b.wuS;
    this.wuM.setVisibility(8);
    if (this.wuQ != null) {
      this.wuQ.drf();
    }
    AppMethodBeat.o(28751);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28748);
    if (paramView.getId() == 2131304397)
    {
      if (!dra())
      {
        AppMethodBeat.o(28748);
        return;
      }
      drb();
    }
    AppMethodBeat.o(28748);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(28747);
    if (!paramBoolean)
    {
      this.rLn.clearFocus();
      bt.hideVKB(this.rLn);
    }
    AppMethodBeat.o(28747);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static abstract interface a
  {
    public abstract void dre();
    
    public abstract void drf();
    
    public abstract void fj(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */