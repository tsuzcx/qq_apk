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
  private boolean zjQ;
  private a zjR;
  b zjS;
  
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
    localTextView.setTextSize(0, com.tencent.mm.cb.a.ax(getContext(), 2131165466));
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        paramAnonymousView = SightDraftContainerView.this;
        if (paramAnonymousView.zjS != null)
        {
          paramAnonymousView = paramAnonymousView.zjS;
          paramAnonymousView.a(null);
          paramAnonymousView.zjv.dTV();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(28685);
        return false;
      }
    });
    AppMethodBeat.o(28689);
  }
  
  public final void dTW()
  {
    AppMethodBeat.i(28690);
    if (this.zjQ)
    {
      this.zjS.zjC = 12;
      this.zjS.a(b.d.zjI, false);
      this.zjS.a(null, null);
      setSelection(0);
      AppMethodBeat.o(28690);
      return;
    }
    this.zjQ = true;
    this.zjS = new b(getContext(), this.zjR);
    this.zjS.zjC = 12;
    setAdapter(this.zjS);
    AppMethodBeat.o(28690);
  }
  
  public j getLastDrafInfo()
  {
    b localb = this.zjS;
    if (localb.zjG == null) {
      return null;
    }
    return localb.zjG.zjO;
  }
  
  public void setSightDraftCallback(a parama)
  {
    this.zjR = parama;
    if (this.zjS != null) {
      this.zjS.zjA = parama;
    }
  }
  
  public void setTipsResId(int paramInt)
  {
    if (this.zjS == null) {
      return;
    }
    this.zjS.zjB = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView
 * JD-Core Version:    0.7.0.1
 */