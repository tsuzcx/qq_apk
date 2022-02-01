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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, com.tencent.mm.plugin.fts.a.l
{
  public EditText HQl;
  public TextView PIP;
  public View PIQ;
  private c PIR;
  InputMethodManager PIS;
  public d.b PIT;
  public a PIU;
  private MMHandler handler;
  
  public d()
  {
    AppMethodBeat.i(28746);
    this.PIT = d.b.PIW;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(28746);
  }
  
  private void gZh()
  {
    AppMethodBeat.i(28750);
    if (gZf())
    {
      AppMethodBeat.o(28750);
      return;
    }
    this.PIT = d.b.PIV;
    this.PIQ.setVisibility(0);
    if (this.PIU != null) {
      this.PIU.gZj();
    }
    this.HQl.requestFocus();
    this.PIS.showSoftInput(this.HQl, 0);
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
    if (this.PIR != null)
    {
      ((n)h.az(n.class)).cancelSearchTask(this.PIR);
      this.PIR = null;
    }
    HashSet localHashSet = new HashSet();
    com.tencent.mm.plugin.fts.a.c.b localb = com.tencent.mm.plugin.fts.a.c.b.Hue;
    MMHandler localMMHandler = this.handler;
    paramEditable = com.tencent.mm.plugin.fts.a.a.l.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localMMHandler);
    this.PIR = ((n)h.az(n.class)).search(2, paramEditable);
    AppMethodBeat.o(28753);
  }
  
  public final void b(m paramm)
  {
    AppMethodBeat.i(28752);
    if (paramm.resultCode == 0)
    {
      if ((paramm.HtF == null) || (this.PIU == null))
      {
        AppMethodBeat.o(28752);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramm = paramm.HtF.iterator();
      while (paramm.hasNext()) {
        localArrayList.add(((o)paramm.next()).Hsz);
      }
      this.PIU.ks(localArrayList);
    }
    AppMethodBeat.o(28752);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean gZf()
  {
    return this.PIT == d.b.PIV;
  }
  
  public final void gZg()
  {
    AppMethodBeat.i(28749);
    if (gZf())
    {
      gZi();
      AppMethodBeat.o(28749);
      return;
    }
    gZh();
    AppMethodBeat.o(28749);
  }
  
  public final void gZi()
  {
    AppMethodBeat.i(28751);
    if (!gZf())
    {
      AppMethodBeat.o(28751);
      return;
    }
    this.HQl.setText("");
    this.HQl.clearFocus();
    Util.hideVKB(this.HQl);
    this.PIT = d.b.PIW;
    this.PIQ.setVisibility(8);
    if (this.PIU != null) {
      this.PIU.gZk();
    }
    AppMethodBeat.o(28751);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28748);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == R.h.fVq)
    {
      if (!gZf())
      {
        a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28748);
        return;
      }
      gZg();
    }
    a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightSelectContactSearchHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28748);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(28747);
    if (!paramBoolean)
    {
      this.HQl.clearFocus();
      Util.hideVKB(this.HQl);
    }
    AppMethodBeat.o(28747);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public static abstract interface a
  {
    public abstract void gZj();
    
    public abstract void gZk();
    
    public abstract void ks(List<String> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */