package com.tencent.mm.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.a.i;
import com.tencent.mm.view.f.a;

public class SmileyPanelViewPager
  extends CustomViewPager
{
  private a AQS;
  private SmileyPanelViewPager.a ARw;
  private boolean ARx;
  private final String TAG;
  private int jqh;
  private int jqi;
  
  public SmileyPanelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62951);
    this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    this.ARx = j.gN(getContext());
    this.jqh = 0;
    this.jqi = 0;
    if (bo.getInt(Build.VERSION.SDK, 0) >= 9) {
      setOverScrollMode(2);
    }
    AppMethodBeat.o(62951);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62952);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    boolean bool = j.gN(getContext());
    if ((this.AQS != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.jqh)) || ((paramInt1 > 0) && (paramInt1 != this.jqi))))))
    {
      this.AQS.RN(paramInt2);
      this.AQS.jqf = paramInt1;
      if ((this.ARw != null) && ((!this.AQS.AVi) || (this.AQS.AVj) || (this.ARx != bool)))
      {
        ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
        this.AQS.AVj = false;
        this.ARw.RG(paramInt2);
      }
    }
    this.ARx = bool;
    if (paramInt2 > 0) {
      this.jqh = paramInt2;
    }
    if (paramInt1 > 0) {
      this.jqi = paramInt1;
    }
    AppMethodBeat.o(62952);
  }
  
  public void setAdapter(q paramq)
  {
    AppMethodBeat.i(62953);
    super.setAdapter(paramq);
    AppMethodBeat.o(62953);
  }
  
  public void setAdapter(i parami)
  {
    AppMethodBeat.i(62954);
    if (parami != null)
    {
      parami.refreshData();
      parami.ASf = false;
    }
    super.setAdapter(parami);
    AppMethodBeat.o(62954);
  }
  
  public void setPanelStg(a parama)
  {
    this.AQS = parama;
  }
  
  public void setSmileyPanelViewPagerLayoutListener(SmileyPanelViewPager.a parama)
  {
    this.ARw = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelViewPager
 * JD-Core Version:    0.7.0.1
 */