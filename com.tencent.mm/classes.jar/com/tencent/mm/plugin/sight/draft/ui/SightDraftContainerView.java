package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.j;

public class SightDraftContainerView
  extends ListView
{
  private boolean DoG;
  private a DoH;
  b DoI;
  
  public SightDraftContainerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(28688);
    init();
    AppMethodBeat.o(28688);
  }
  
  public SightDraftContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28687);
    init();
    AppMethodBeat.o(28687);
  }
  
  public SightDraftContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28686);
    init();
    AppMethodBeat.o(28686);
  }
  
  private void init()
  {
    AppMethodBeat.i(28689);
    setBackgroundColor(getResources().getColor(2131100042));
    setSelector(2131101287);
    int i = getResources().getDimensionPixelSize(2131165586);
    int j = getResources().getDimensionPixelSize(2131165498);
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131765893);
    localTextView.setTextSize(0, com.tencent.mm.cb.a.aG(getContext(), 2131165482));
    localTextView.setGravity(17);
    localTextView.setTextColor(getResources().getColor(2131100595));
    localTextView.setTextSize(1, 11.0F);
    localTextView.setPadding(0, i, 0, j);
    addFooterView(localTextView);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(28685);
        paramAnonymousView = SightDraftContainerView.this;
        if (paramAnonymousView.DoI != null)
        {
          paramAnonymousView = paramAnonymousView.DoI;
          paramAnonymousView.a(null);
          paramAnonymousView.Dom.eVV();
        }
        AppMethodBeat.o(28685);
        return false;
      }
    });
    AppMethodBeat.o(28689);
  }
  
  public final void eVW()
  {
    AppMethodBeat.i(28690);
    if (this.DoG)
    {
      this.DoI.Dot = 12;
      this.DoI.a(b.d.Doz, false);
      this.DoI.onNotifyChange(null, null);
      setSelection(0);
      AppMethodBeat.o(28690);
      return;
    }
    this.DoG = true;
    this.DoI = new b(getContext(), this.DoH);
    this.DoI.Dot = 12;
    setAdapter(this.DoI);
    AppMethodBeat.o(28690);
  }
  
  public j getLastDrafInfo()
  {
    b localb = this.DoI;
    if (localb.Dox == null) {
      return null;
    }
    return localb.Dox.DoE;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.DoH = parama;
    if (this.DoI != null) {
      this.DoI.Dor = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.DoI == null) {
      return;
    }
    this.DoI.Dos = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */