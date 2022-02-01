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
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.h;
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
  public EditText Ceg;
  public TextView Jvr;
  public View Jvs;
  private com.tencent.mm.plugin.fts.a.a.a Jvt;
  InputMethodManager Jvu;
  public d.b Jvv;
  public a Jvw;
  private MMHandler handler;
  
  public d()
  {
    AppMethodBeat.i(28746);
    this.Jvv = d.b.Jvy;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(28746);
  }
  
  private void fJn()
  {
    AppMethodBeat.i(28750);
    if (fJl())
    {
      AppMethodBeat.o(28750);
      return;
    }
    this.Jvv = d.b.Jvx;
    this.Jvs.setVisibility(0);
    if (this.Jvw != null) {
      this.Jvw.fJp();
    }
    this.Ceg.requestFocus();
    this.Jvu.showSoftInput(this.Ceg, 0);
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
    if (this.Jvt != null)
    {
      ((n)h.ag(n.class)).cancelSearchTask(this.Jvt);
      this.Jvt = null;
    }
    HashSet localHashSet = new HashSet();
    com.tencent.mm.plugin.fts.a.c.b localb = com.tencent.mm.plugin.fts.a.c.b.BJu;
    MMHandler localMMHandler = this.handler;
    paramEditable = j.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localMMHandler);
    this.Jvt = ((n)h.ag(n.class)).search(2, paramEditable);
    AppMethodBeat.o(28753);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(28752);
    if (paramk.resultCode == 0)
    {
      if ((paramk.BIW == null) || (this.Jvw == null))
      {
        AppMethodBeat.o(28752);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramk = paramk.BIW.iterator();
      while (paramk.hasNext()) {
        localArrayList.add(((m)paramk.next()).BHS);
      }
      this.Jvw.hq(localArrayList);
    }
    AppMethodBeat.o(28752);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean fJl()
  {
    return this.Jvv == d.b.Jvx;
  }
  
  public final void fJm()
  {
    AppMethodBeat.i(28749);
    if (fJl())
    {
      fJo();
      AppMethodBeat.o(28749);
      return;
    }
    fJn();
    AppMethodBeat.o(28749);
  }
  
  public final void fJo()
  {
    AppMethodBeat.i(28751);
    if (!fJl())
    {
      AppMethodBeat.o(28751);
      return;
    }
    this.Ceg.setText("");
    this.Ceg.clearFocus();
    Util.hideVKB(this.Ceg);
    this.Jvv = d.b.Jvy;
    this.Jvs.setVisibility(8);
    if (this.Jvw != null) {
      this.Jvw.fJq();
    }
    AppMethodBeat.o(28751);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28748);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.getId() == R.h.dTi)
    {
      if (!fJl())
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28748);
        return;
      }
      fJm();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28748);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(28747);
    if (!paramBoolean)
    {
      this.Ceg.clearFocus();
      Util.hideVKB(this.Ceg);
    }
    AppMethodBeat.o(28747);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static abstract interface a
  {
    public abstract void fJp();
    
    public abstract void fJq();
    
    public abstract void hq(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */