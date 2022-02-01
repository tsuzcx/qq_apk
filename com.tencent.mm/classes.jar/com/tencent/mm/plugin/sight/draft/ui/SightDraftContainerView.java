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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.modelvideo.q;

public class SightDraftContainerView
  extends ListView
{
  private boolean PHJ;
  private a PHK;
  b PHL;
  
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
    setBackgroundColor(getResources().getColor(R.e.black));
    setSelector(R.e.transparent);
    int i = getResources().getDimensionPixelSize(R.f.SmallPadding);
    int j = getResources().getDimensionPixelSize(R.f.LargePadding);
    TextView localTextView = new TextView(getContext());
    localTextView.setText(R.l.sight_draft_tips);
    localTextView.setTextSize(0, com.tencent.mm.cd.a.br(getContext(), R.f.HintTextSize));
    localTextView.setGravity(17);
    localTextView.setTextColor(getResources().getColor(R.e.hint_text_color_dark_bg));
    localTextView.setTextSize(1, 11.0F);
    localTextView.setPadding(0, i, 0, j);
    addFooterView(localTextView);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(28685);
        paramAnonymousView = SightDraftContainerView.this;
        if (paramAnonymousView.PHL != null)
        {
          paramAnonymousView = paramAnonymousView.PHL;
          paramAnonymousView.a(null);
          paramAnonymousView.PHq.gYR();
        }
        AppMethodBeat.o(28685);
        return false;
      }
    });
    AppMethodBeat.o(28689);
  }
  
  public final void gYS()
  {
    AppMethodBeat.i(28690);
    if (this.PHJ)
    {
      this.PHL.PHx = 12;
      this.PHL.a(b.d.PHC, false);
      this.PHL.onNotifyChange(null, null);
      setSelection(0);
      AppMethodBeat.o(28690);
      return;
    }
    this.PHJ = true;
    this.PHL = new b(getContext(), this.PHK);
    this.PHL.PHx = 12;
    setAdapter(this.PHL);
    AppMethodBeat.o(28690);
  }
  
  public q getLastDrafInfo()
  {
    b localb = this.PHL;
    if (localb.PHA == null) {
      return null;
    }
    return localb.PHA.PHH;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.PHK = parama;
    if (this.PHL != null) {
      this.PHL.PHv = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.PHL == null) {
      return;
    }
    this.PHL.PHw = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */