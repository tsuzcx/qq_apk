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
  private boolean xEW;
  private a xEX;
  b xEY;
  
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
    localTextView.setTextSize(0, com.tencent.mm.cc.a.au(getContext(), 2131165466));
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
        if (paramAnonymousView.xEY != null)
        {
          paramAnonymousView = paramAnonymousView.xEY;
          paramAnonymousView.a(null);
          paramAnonymousView.xEB.dEW();
        }
        AppMethodBeat.o(28685);
        return false;
      }
    });
    AppMethodBeat.o(28689);
  }
  
  public final void dEX()
  {
    AppMethodBeat.i(28690);
    if (this.xEW)
    {
      this.xEY.xEI = 12;
      this.xEY.a(b.d.xEO, false);
      this.xEY.a(null, null);
      setSelection(0);
      AppMethodBeat.o(28690);
      return;
    }
    this.xEW = true;
    this.xEY = new b(getContext(), this.xEX);
    this.xEY.xEI = 12;
    setAdapter(this.xEY);
    AppMethodBeat.o(28690);
  }
  
  public j getLastDrafInfo()
  {
    b localb = this.xEY;
    if (localb.xEM == null) {
      return null;
    }
    return localb.xEM.xEU;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.xEX = parama;
    if (this.xEY != null) {
      this.xEY.xEG = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.xEY == null) {
      return;
    }
    this.xEY.xEH = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */