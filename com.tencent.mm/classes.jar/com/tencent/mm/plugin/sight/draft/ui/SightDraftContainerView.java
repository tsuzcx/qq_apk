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
import com.tencent.mm.modelvideo.n;

public class SightDraftContainerView
  extends ListView
{
  private boolean Jul;
  private a Jum;
  b Jun;
  
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
    localTextView.setTextSize(0, com.tencent.mm.ci.a.aY(getContext(), R.f.HintTextSize));
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
        if (paramAnonymousView.Jun != null)
        {
          paramAnonymousView = paramAnonymousView.Jun;
          paramAnonymousView.a(null);
          paramAnonymousView.JtR.fIY();
        }
        AppMethodBeat.o(28685);
        return false;
      }
    });
    AppMethodBeat.o(28689);
  }
  
  public final void fIZ()
  {
    AppMethodBeat.i(28690);
    if (this.Jul)
    {
      this.Jun.JtY = 12;
      this.Jun.a(b.d.Jue, false);
      this.Jun.onNotifyChange(null, null);
      setSelection(0);
      AppMethodBeat.o(28690);
      return;
    }
    this.Jul = true;
    this.Jun = new b(getContext(), this.Jum);
    this.Jun.JtY = 12;
    setAdapter(this.Jun);
    AppMethodBeat.o(28690);
  }
  
  public n getLastDrafInfo()
  {
    b localb = this.Jun;
    if (localb.Juc == null) {
      return null;
    }
    return localb.Juc.Juj;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.Jum = parama;
    if (this.Jun != null) {
      this.Jun.JtW = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.Jun == null) {
      return;
    }
    this.Jun.JtX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */