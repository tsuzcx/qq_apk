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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, l
{
  private ao handler;
  public EditText sTc;
  public TextView xGb;
  public View xGc;
  private a xGd;
  InputMethodManager xGe;
  public d.b xGf;
  public a xGg;
  
  public d()
  {
    AppMethodBeat.i(28746);
    this.xGf = d.b.xGi;
    this.handler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(28746);
  }
  
  private void dFl()
  {
    AppMethodBeat.i(28750);
    if (dFj())
    {
      AppMethodBeat.o(28750);
      return;
    }
    this.xGf = d.b.xGh;
    this.xGc.setVisibility(0);
    if (this.xGg != null) {
      this.xGg.dFn();
    }
    this.sTc.requestFocus();
    this.xGe.showSoftInput(this.sTc, 0);
    AppMethodBeat.o(28750);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(28753);
    if (bs.isNullOrNil(paramEditable.toString()))
    {
      AppMethodBeat.o(28753);
      return;
    }
    paramEditable = paramEditable.toString();
    ac.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[] { paramEditable });
    if (this.xGd != null)
    {
      ((n)g.ad(n.class)).cancelSearchTask(this.xGd);
      this.xGd = null;
    }
    HashSet localHashSet = new HashSet();
    b localb = b.szh;
    ao localao = this.handler;
    paramEditable = j.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localao);
    this.xGd = ((n)g.ad(n.class)).search(2, paramEditable);
    AppMethodBeat.o(28753);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(28752);
    if (paramk.bPH == 0)
    {
      if ((paramk.syK == null) || (this.xGg == null))
      {
        AppMethodBeat.o(28752);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramk = paramk.syK.iterator();
      while (paramk.hasNext()) {
        localArrayList.add(((m)paramk.next()).sxG);
      }
      this.xGg.fr(localArrayList);
    }
    AppMethodBeat.o(28752);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean dFj()
  {
    return this.xGf == d.b.xGh;
  }
  
  public final void dFk()
  {
    AppMethodBeat.i(28749);
    if (dFj())
    {
      dFm();
      AppMethodBeat.o(28749);
      return;
    }
    dFl();
    AppMethodBeat.o(28749);
  }
  
  public final void dFm()
  {
    AppMethodBeat.i(28751);
    if (!dFj())
    {
      AppMethodBeat.o(28751);
      return;
    }
    this.sTc.setText("");
    this.sTc.clearFocus();
    bs.hideVKB(this.sTc);
    this.xGf = d.b.xGi;
    this.xGc.setVisibility(8);
    if (this.xGg != null) {
      this.xGg.dFo();
    }
    AppMethodBeat.o(28751);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28748);
    if (paramView.getId() == 2131304397)
    {
      if (!dFj())
      {
        AppMethodBeat.o(28748);
        return;
      }
      dFk();
    }
    AppMethodBeat.o(28748);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(28747);
    if (!paramBoolean)
    {
      this.sTc.clearFocus();
      bs.hideVKB(this.sTc);
    }
    AppMethodBeat.o(28747);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static abstract interface a
  {
    public abstract void dFn();
    
    public abstract void dFo();
    
    public abstract void fr(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */