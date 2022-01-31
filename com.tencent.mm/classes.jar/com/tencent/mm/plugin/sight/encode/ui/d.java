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
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements TextWatcher, View.OnClickListener, View.OnFocusChangeListener, com.tencent.mm.plugin.fts.a.l
{
  private ak handler;
  public EditText qWm;
  public TextView qWn;
  public View qWo;
  private a qWp;
  InputMethodManager qWq;
  public d.b qWr;
  public d.a qWs;
  
  public d()
  {
    AppMethodBeat.i(25075);
    this.qWr = d.b.qWu;
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(25075);
  }
  
  private void cnm()
  {
    AppMethodBeat.i(25079);
    if (cnk())
    {
      AppMethodBeat.o(25079);
      return;
    }
    this.qWr = d.b.qWt;
    this.qWo.setVisibility(0);
    if (this.qWs != null) {
      this.qWs.cno();
    }
    this.qWm.requestFocus();
    this.qWq.showSoftInput(this.qWm, 0);
    AppMethodBeat.o(25079);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(25082);
    if (bo.isNullOrNil(paramEditable.toString()))
    {
      AppMethodBeat.o(25082);
      return;
    }
    paramEditable = paramEditable.toString();
    ab.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[] { paramEditable });
    if (this.qWp != null)
    {
      ((n)g.G(n.class)).cancelSearchTask(this.qWp);
      this.qWp = null;
    }
    HashSet localHashSet = new HashSet();
    b localb = b.mTt;
    ak localak = this.handler;
    paramEditable = i.a(paramEditable, new int[] { 131072, 131075 }, null, 3, localHashSet, localb, this, localak);
    this.qWp = ((n)g.G(n.class)).search(2, paramEditable);
    AppMethodBeat.o(25082);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(25081);
    if (paramj.bpE == 0)
    {
      if ((paramj.mSW == null) || (this.qWs == null))
      {
        AppMethodBeat.o(25081);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramj = paramj.mSW.iterator();
      while (paramj.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.fts.a.a.l)paramj.next()).mRV);
      }
      this.qWs.cX(localArrayList);
    }
    AppMethodBeat.o(25081);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final boolean cnk()
  {
    return this.qWr == d.b.qWt;
  }
  
  public final void cnl()
  {
    AppMethodBeat.i(25078);
    if (cnk())
    {
      cnn();
      AppMethodBeat.o(25078);
      return;
    }
    cnm();
    AppMethodBeat.o(25078);
  }
  
  public final void cnn()
  {
    AppMethodBeat.i(25080);
    if (!cnk())
    {
      AppMethodBeat.o(25080);
      return;
    }
    this.qWm.setText("");
    this.qWm.clearFocus();
    bo.hideVKB(this.qWm);
    this.qWr = d.b.qWu;
    this.qWo.setVisibility(8);
    if (this.qWs != null) {
      this.qWs.cnp();
    }
    AppMethodBeat.o(25080);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25077);
    if (paramView.getId() == 2131825893)
    {
      if (!cnk())
      {
        AppMethodBeat.o(25077);
        return;
      }
      cnl();
    }
    AppMethodBeat.o(25077);
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(25076);
    if (!paramBoolean)
    {
      this.qWm.clearFocus();
      bo.hideVKB(this.qWm);
    }
    AppMethodBeat.o(25076);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.d
 * JD-Core Version:    0.7.0.1
 */