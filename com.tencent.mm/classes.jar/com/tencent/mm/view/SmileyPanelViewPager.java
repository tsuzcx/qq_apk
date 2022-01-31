package com.tencent.mm.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.n;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.a.g;
import com.tencent.mm.view.f.a;

public class SmileyPanelViewPager
  extends CustomViewPager
{
  private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
  private int hxX = 0;
  private int hxY = 0;
  private a wvQ;
  private SmileyPanelViewPager.a wwu;
  private boolean wwv = j.fA(getContext());
  
  public SmileyPanelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (bk.getInt(Build.VERSION.SDK, 0) >= 9) {
      setOverScrollMode(2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    boolean bool = j.fA(getContext());
    if ((this.wvQ != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.hxX)) || ((paramInt1 > 0) && (paramInt1 != this.hxY))))))
    {
      if (this.wvQ.hxU <= 0) {
        this.wvQ.IU(paramInt2);
      }
      this.wvQ.hxV = paramInt1;
      this.wvQ.vWJ = 0;
      if ((this.wwu != null) && ((!this.wvQ.wzM) || (this.wvQ.wzN) || (this.wwv != bool)))
      {
        y.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
        this.wvQ.wzN = false;
        this.wwu.IN(paramInt2);
      }
    }
    this.wwv = bool;
    if (paramInt2 > 0) {
      this.hxX = paramInt2;
    }
    if (paramInt1 > 0) {
      this.hxY = paramInt1;
    }
  }
  
  public void setAdapter(n paramn)
  {
    super.setAdapter(paramn);
  }
  
  public void setAdapter(g paramg)
  {
    if (paramg != null)
    {
      paramg.cLz();
      paramg.wwX = false;
    }
    super.setAdapter(paramg);
  }
  
  public void setPanelStg(a parama)
  {
    this.wvQ = parama;
  }
  
  public void setSmileyPanelViewPagerLayoutListener(SmileyPanelViewPager.a parama)
  {
    this.wwu = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.SmileyPanelViewPager
 * JD-Core Version:    0.7.0.1
 */