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
  private boolean wtG;
  private a wtH;
  b wtI;
  
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
    setBackgroundColor(getResources().getColor(2131100017));
    setSelector(2131101053);
    int i = getResources().getDimensionPixelSize(2131165568);
    int j = getResources().getDimensionPixelSize(2131165480);
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131763702);
    localTextView.setTextSize(0, com.tencent.mm.cd.a.ao(getContext(), 2131165466));
    localTextView.setGravity(17);
    localTextView.setTextColor(getResources().getColor(2131100491));
    localTextView.setTextSize(1, 11.0F);
    localTextView.setPadding(0, i, 0, j);
    addFooterView(localTextView);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(28685);
        paramAnonymousView = SightDraftContainerView.this;
        if (paramAnonymousView.wtI != null)
        {
          paramAnonymousView = paramAnonymousView.wtI;
          paramAnonymousView.a(null);
          paramAnonymousView.wtl.dqN();
        }
        AppMethodBeat.o(28685);
        return false;
      }
    });
    AppMethodBeat.o(28689);
  }
  
  public final void dqO()
  {
    AppMethodBeat.i(28690);
    if (this.wtG)
    {
      this.wtI.wts = 12;
      this.wtI.a(b.d.wty, false);
      this.wtI.a(null, null);
      setSelection(0);
      AppMethodBeat.o(28690);
      return;
    }
    this.wtG = true;
    this.wtI = new b(getContext(), this.wtH);
    this.wtI.wts = 12;
    setAdapter(this.wtI);
    AppMethodBeat.o(28690);
  }
  
  public j getLastDrafInfo()
  {
    b localb = this.wtI;
    if (localb.wtw == null) {
      return null;
    }
    return localb.wtw.wtE;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.wtH = parama;
    if (this.wtI != null) {
      this.wtI.wtq = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.wtI == null) {
      return;
    }
    this.wtI.wtr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */