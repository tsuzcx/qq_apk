package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.j;

public class SightDraftContainerView
  extends ListView
{
  private boolean qVi;
  private a qVj;
  b qVk;
  
  public SightDraftContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(25018);
    init();
    AppMethodBeat.o(25018);
  }
  
  public SightDraftContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25017);
    init();
    AppMethodBeat.o(25017);
  }
  
  public SightDraftContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25016);
    init();
    AppMethodBeat.o(25016);
  }
  
  private void init()
  {
    AppMethodBeat.i(25019);
    setBackgroundColor(getResources().getColor(2131689763));
    setSelector(2131690605);
    int i = getResources().getDimensionPixelSize(2131427854);
    int j = getResources().getDimensionPixelSize(2131427772);
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131303719);
    localTextView.setTextSize(0, com.tencent.mm.cb.a.ao(getContext(), 2131427758));
    localTextView.setGravity(17);
    localTextView.setTextColor(getResources().getColor(2131690169));
    localTextView.setTextSize(1, 11.0F);
    localTextView.setPadding(0, i, 0, j);
    addFooterView(localTextView);
    setOnTouchListener(new SightDraftContainerView.1(this));
    AppMethodBeat.o(25019);
  }
  
  public final void cmX()
  {
    AppMethodBeat.i(25020);
    if (this.qVi)
    {
      this.qVk.qUU = 12;
      this.qVk.a(b.d.qVa, false);
      this.qVk.a(null, null);
      setSelection(0);
      AppMethodBeat.o(25020);
      return;
    }
    this.qVi = true;
    this.qVk = new b(getContext(), this.qVj);
    this.qVk.qUU = 12;
    setAdapter(this.qVk);
    AppMethodBeat.o(25020);
  }
  
  public j getLastDrafInfo()
  {
    b localb = this.qVk;
    if (localb.qUY == null) {
      return null;
    }
    return localb.qUY.qVg;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.qVj = parama;
    if (this.qVk != null) {
      this.qVk.qUS = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.qVk == null) {
      return;
    }
    this.qVk.qUT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */