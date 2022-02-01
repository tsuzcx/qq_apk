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
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, l
{
  private aq handler;
  public EditText uax;
  public TextView zkV;
  public View zkW;
  private com.tencent.mm.plugin.fts.a.a.a zkX;
  InputMethodManager zkY;
  public d.b zkZ;
  public a zla;
  
  public d()
  {
    AppMethodBeat.i(28746);
    this.zkZ = d.b.zlc;
    this.handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(28746);
  }
  
  private void dUk()
  {
    AppMethodBeat.i(28750);
    if (dUi())
    {
      AppMethodBeat.o(28750);
      return;
    }
    this.zkZ = d.b.zlb;
    this.zkW.setVisibility(0);
    if (this.zla != null) {
      this.zla.dUm();
    }
    this.uax.requestFocus();
    this.zkY.showSoftInput(this.uax, 0);
    AppMethodBeat.o(28750);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(28753);
    if (bu.isNullOrNil(paramEditable.toString()))
    {
      AppMethodBeat.o(28753);
      return;
    }
    paramEditable = paramEditable.toString();
    ae.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[] { paramEditable });
    if (this.zkX != null)
    {
      ((n)g.ad(n.class)).cancelSearchTask(this.zkX);
      this.zkX = null;
    }
    HashSet localHashSet = new HashSet();
    com.tencent.mm.plugin.fts.a.c.b localb = com.tencent.mm.plugin.fts.a.c.b.tGz;
    aq localaq = this.handler;
    paramEditable = j.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localaq);
    this.zkX = ((n)g.ad(n.class)).search(2, paramEditable);
    AppMethodBeat.o(28753);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(28752);
    if (paramk.bZU == 0)
    {
      if ((paramk.tGc == null) || (this.zla == null))
      {
        AppMethodBeat.o(28752);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramk = paramk.tGc.iterator();
      while (paramk.hasNext()) {
        localArrayList.add(((m)paramk.next()).tEY);
      }
      this.zla.fM(localArrayList);
    }
    AppMethodBeat.o(28752);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean dUi()
  {
    return this.zkZ == d.b.zlb;
  }
  
  public final void dUj()
  {
    AppMethodBeat.i(28749);
    if (dUi())
    {
      dUl();
      AppMethodBeat.o(28749);
      return;
    }
    dUk();
    AppMethodBeat.o(28749);
  }
  
  public final void dUl()
  {
    AppMethodBeat.i(28751);
    if (!dUi())
    {
      AppMethodBeat.o(28751);
      return;
    }
    this.uax.setText("");
    this.uax.clearFocus();
    bu.hideVKB(this.uax);
    this.zkZ = d.b.zlc;
    this.zkW.setVisibility(8);
    if (this.zla != null) {
      this.zla.dUn();
    }
    AppMethodBeat.o(28751);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28748);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView.getId() == 2131304397)
    {
      if (!dUi())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28748);
        return;
      }
      dUj();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28748);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(28747);
    if (!paramBoolean)
    {
      this.uax.clearFocus();
      bu.hideVKB(this.uax);
    }
    AppMethodBeat.o(28747);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static abstract interface a
  {
    public abstract void dUm();
    
    public abstract void dUn();
    
    public abstract void fM(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */