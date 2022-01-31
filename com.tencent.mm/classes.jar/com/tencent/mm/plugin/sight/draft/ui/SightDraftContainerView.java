package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.modelvideo.j;

public class SightDraftContainerView
  extends ListView
{
  private boolean ogT;
  private a ogU;
  b ogV;
  
  public SightDraftContainerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SightDraftContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SightDraftContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setBackgroundColor(getResources().getColor(R.e.black));
    setSelector(R.e.transparent);
    int i = getResources().getDimensionPixelSize(R.f.SmallPadding);
    int j = getResources().getDimensionPixelSize(R.f.LargePadding);
    TextView localTextView = new TextView(getContext());
    localTextView.setText(R.l.sight_draft_tips);
    localTextView.setTextSize(0, com.tencent.mm.cb.a.aa(getContext(), R.f.HintTextSize));
    localTextView.setGravity(17);
    localTextView.setTextColor(getResources().getColor(R.e.hint_text_color_dark_bg));
    localTextView.setTextSize(1, 11.0F);
    localTextView.setPadding(0, i, 0, j);
    addFooterView(localTextView);
    setOnTouchListener(new SightDraftContainerView.1(this));
  }
  
  public final void bBx()
  {
    if (this.ogT)
    {
      this.ogV.ogF = 12;
      this.ogV.a(b.d.ogL, false);
      this.ogV.a(null, null);
      setSelection(0);
      return;
    }
    this.ogT = true;
    this.ogV = new b(getContext(), this.ogU);
    this.ogV.ogF = 12;
    setAdapter(this.ogV);
  }
  
  public j getLastDrafInfo()
  {
    b localb = this.ogV;
    if (localb.ogJ == null) {
      return null;
    }
    return localb.ogJ.ogR;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.ogU = parama;
    if (this.ogV != null) {
      this.ogV.ogD = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.ogV == null) {
      return;
    }
    this.ogV.ogE = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */