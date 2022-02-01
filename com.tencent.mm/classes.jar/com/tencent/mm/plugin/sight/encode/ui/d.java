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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, l
{
  public TextView DpM;
  public View DpN;
  private com.tencent.mm.plugin.fts.a.a.a DpO;
  InputMethodManager DpP;
  public d.b DpQ;
  public a DpR;
  private MMHandler handler;
  public EditText xrL;
  
  public d()
  {
    AppMethodBeat.i(28746);
    this.DpQ = d.b.DpT;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(28746);
  }
  
  private void eWk()
  {
    AppMethodBeat.i(28750);
    if (eWi())
    {
      AppMethodBeat.o(28750);
      return;
    }
    this.DpQ = d.b.DpS;
    this.DpN.setVisibility(0);
    if (this.DpR != null) {
      this.DpR.eWm();
    }
    this.xrL.requestFocus();
    this.DpP.showSoftInput(this.xrL, 0);
    AppMethodBeat.o(28750);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(28753);
    if (Util.isNullOrNil(paramEditable.toString()))
    {
      AppMethodBeat.o(28753);
      return;
    }
    paramEditable = paramEditable.toString();
    Log.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[] { paramEditable });
    if (this.DpO != null)
    {
      ((n)g.ah(n.class)).cancelSearchTask(this.DpO);
      this.DpO = null;
    }
    HashSet localHashSet = new HashSet();
    com.tencent.mm.plugin.fts.a.c.b localb = com.tencent.mm.plugin.fts.a.c.b.wXy;
    MMHandler localMMHandler = this.handler;
    paramEditable = j.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localMMHandler);
    this.DpO = ((n)g.ah(n.class)).search(2, paramEditable);
    AppMethodBeat.o(28753);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(28752);
    if (paramk.resultCode == 0)
    {
      if ((paramk.wXb == null) || (this.DpR == null))
      {
        AppMethodBeat.o(28752);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramk = paramk.wXb.iterator();
      while (paramk.hasNext()) {
        localArrayList.add(((m)paramk.next()).wVX);
      }
      this.DpR.gK(localArrayList);
    }
    AppMethodBeat.o(28752);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean eWi()
  {
    return this.DpQ == d.b.DpS;
  }
  
  public final void eWj()
  {
    AppMethodBeat.i(28749);
    if (eWi())
    {
      eWl();
      AppMethodBeat.o(28749);
      return;
    }
    eWk();
    AppMethodBeat.o(28749);
  }
  
  public final void eWl()
  {
    AppMethodBeat.i(28751);
    if (!eWi())
    {
      AppMethodBeat.o(28751);
      return;
    }
    this.xrL.setText("");
    this.xrL.clearFocus();
    Util.hideVKB(this.xrL);
    this.DpQ = d.b.DpT;
    this.DpN.setVisibility(8);
    if (this.DpR != null) {
      this.DpR.eWn();
    }
    AppMethodBeat.o(28751);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28748);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131307362)
    {
      if (!eWi())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28748);
        return;
      }
      eWj();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28748);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(28747);
    if (!paramBoolean)
    {
      this.xrL.clearFocus();
      Util.hideVKB(this.xrL);
    }
    AppMethodBeat.o(28747);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static abstract interface a
  {
    public abstract void eWm();
    
    public abstract void eWn();
    
    public abstract void gK(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */