package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected View VH;
  protected int dtu = 0;
  protected int fOo = 0;
  protected MMDotView hxP;
  protected int mNumColumns = 0;
  protected ah ntK = new ah(Looper.getMainLooper());
  protected int uSV = 10;
  protected int uSW = 10;
  final MMFlipper.b uUN = new MMGridPaper.5(this);
  final MMFlipper.a uUO = new MMGridPaper.4(this);
  protected int uVA = -1;
  protected int uVB = -1;
  protected int uVC = -1;
  protected int uVD = -1;
  protected boolean uVE = false;
  protected int uVF = 0;
  protected int uVG = 0;
  protected a uVH;
  protected MMFlipper uVi;
  protected j uVj;
  protected int uVk;
  protected int uVl;
  protected int uVm = 0;
  protected int uVn = 0;
  protected int uVo = 3;
  protected int uVp = 0;
  protected int uVq = this.uVo - 1;
  protected int uVr = 0;
  protected boolean uVs = false;
  protected int uVt = 9;
  protected int uVu = -1;
  protected int uVv = -1;
  protected int uVw = 96;
  protected int uVx = 96;
  protected boolean uVy = false;
  protected boolean uVz = false;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    View.inflate(getContext(), a.h.mm_gridpaper, this);
    this.fOo = getScreenOrientation();
  }
  
  private void cAJ()
  {
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.uVu) && (getScreenOrientation() == 2))
    {
      localView = findViewById(a.g.gridpaper_display_view);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.uVu);
      if (i != localLayoutParams.height)
      {
        y.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.uVu) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
      }
    }
    do
    {
      this.ntK.post(new MMGridPaper.2(this));
      do
      {
        return;
      } while ((-1 == this.uVv) || (getScreenOrientation() != 1));
      localView = findViewById(a.g.gridpaper_display_view);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.uVv);
    } while (i == localLayoutParams.height);
    y.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.uVv) });
    localLayoutParams.height = i;
    localView.setLayoutParams(localLayoutParams);
    this.ntK.post(new Runnable()
    {
      public final void run()
      {
        y.w("MicroMsg.MMGridPaper", "post do setDotView");
        MMGridPaper.a(MMGridPaper.this);
      }
    });
  }
  
  private void cAK()
  {
    y.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.uVk), Integer.valueOf(this.uVl) });
    if ((this.uVk == 0) || (this.uVl == 0))
    {
      y.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      return;
    }
    int j = a.fromDPToPix(getContext(), this.uVw);
    int i = a.fromDPToPix(getContext(), this.uVx);
    j = Math.max(this.uVk / j, 1);
    i = Math.max(this.uVl / i, 1);
    if ((j != this.mNumColumns) || (i != this.dtu)) {
      this.uVs = true;
    }
    this.mNumColumns = j;
    if (this.uVC != -1) {
      this.mNumColumns = Math.min(this.mNumColumns, this.uVC);
    }
    this.dtu = i;
    if (this.uVD != -1) {
      this.dtu = Math.min(this.dtu, this.uVD);
    }
    int m = this.mNumColumns * this.dtu;
    this.uVr = 0;
    boolean bool;
    if (this.uVj == null)
    {
      i = 0;
      j = i + 0;
      y.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.uVz) });
      if (j < 0) {
        break label310;
      }
      bool = true;
      label240:
      Assert.assertTrue(bool);
      if (this.uVz)
      {
        k = fp(j, this.mNumColumns);
        i = getScreenOrientation();
      }
      switch (i)
      {
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label520;
      }
      cAJ();
      return;
      i = this.uVj.getCount();
      break;
      label310:
      bool = false;
      break label240;
      k = Math.min(k, this.uVB);
      n = (this.uVx + 10) * k + 8;
      y.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(this.uVu), Boolean.valueOf(this.uVy) });
      if (this.uVu != n)
      {
        this.uVu = n;
        i = 0;
      }
      else
      {
        i = 1;
        continue;
        k = Math.min(k, this.uVA);
        n = (this.uVx + 10) * k + 8;
        y.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(this.uVv), Boolean.valueOf(this.uVy) });
        if (this.uVv != n)
        {
          this.uVv = n;
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
    label520:
    this.uVr = fp(j, m);
    int n = this.uVr;
    int k = this.uVm;
    MMGridPaperGridView localMMGridPaperGridView;
    if ((k == 0) || (m <= 0))
    {
      y.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      i = 0;
      this.uVn = Math.min(n - 1, i);
      this.uVo = Math.min(3, this.uVr);
      this.uVp = Math.min(this.uVr - this.uVo, Math.max(0, this.uVn - (this.uVo >> 1)));
      this.uVq = (this.uVp + this.uVo - 1);
      y.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.uVw), Integer.valueOf(this.uVx), Integer.valueOf(this.dtu), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.uVo), Integer.valueOf(this.uVr), Integer.valueOf(this.uVn), Integer.valueOf(this.uVp), Integer.valueOf(this.uVq) });
      if ((this.uVi.getChildCount() != this.uVo) || (this.uVs))
      {
        y.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.uVs) });
        this.uVs = false;
        this.uVi.removeAllViews();
        i = this.uVp;
        while (i <= this.uVq)
        {
          localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), a.h.mm_drap_drop_gridview, null);
          localMMGridPaperGridView.a(i, this.dtu, this.mNumColumns, this.uVj);
          localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.uSV));
          localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.uSW));
          this.uVi.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
          i += 1;
        }
      }
    }
    for (;;)
    {
      if (j >= m)
      {
        j -= m;
        i += 1;
      }
      else
      {
        y.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i) });
        break;
        i = this.uVp;
        if (i <= this.uVq)
        {
          localMMGridPaperGridView = (MMGridPaperGridView)this.uVi.getChildAt(i - this.uVp);
          if (localMMGridPaperGridView.getIndex() != i)
          {
            y.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
            localMMGridPaperGridView.a(i, this.dtu, this.mNumColumns, this.uVj);
            if (localMMGridPaperGridView.uVR != null) {
              localMMGridPaperGridView.uVR.notifyDataSetChanged();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            y.v("MicroMsg.MMGridPaper", "same grid index, continus");
          }
        }
        cAL();
        return;
        j = k;
        i = 0;
      }
    }
  }
  
  private void cAL()
  {
    y.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.uVr >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.hxP.setDotCount(this.uVr);
      if ((this.uVj != null) && (this.uVr > 1)) {
        break label129;
      }
      this.hxP.setVisibility(8);
      y.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.uVn >= this.uVr) {
        this.uVn = (this.uVr - 1);
      }
      this.uVi.Go(this.uVn - this.uVp);
      this.uVi.Gp(this.uVn);
      this.hxP.setSelectedDot(this.uVn);
      return;
      bool = false;
      break;
      label129:
      this.hxP.setVisibility(0);
      y.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private void cmW()
  {
    y.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.hxP == null)
    {
      this.hxP = ((MMDotView)findViewById(a.g.gridpaper_dot));
      this.hxP.setMaxCount(this.uVt);
    }
    if (this.uVi == null)
    {
      this.uVi = ((MMFlipper)findViewById(a.g.gridpaper_flipper));
      this.uVi.setOnMeasureListener(this.uUO);
      this.uVi.setOnScreenChangedListener(this.uUN);
    }
    cAJ();
    cAK();
  }
  
  private static int fp(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0)
    {
      y.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return 0;
    }
    for (;;)
    {
      int j;
      int i;
      if (j > 0)
      {
        j -= paramInt2;
        i += 1;
      }
      else
      {
        y.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    return (MMGridPaperGridView)this.uVi.getChildAt(this.uVi.getCurScreen());
  }
  
  private int getScreenOrientation()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {
      return 1;
    }
    return 2;
  }
  
  public final void cAH()
  {
    this.uVB = 3;
    this.uVA = 3;
  }
  
  public final void cAI()
  {
    this.uSV = 8;
    this.uSW = 15;
  }
  
  public final int getItemsCountPerPage()
  {
    return this.dtu * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.uVr;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      y.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.uVy = true;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.fOo != getScreenOrientation())
    {
      this.fOo = getScreenOrientation();
      y.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
      this.uVy = true;
      clearAnimation();
      cAJ();
      cAK();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void refresh()
  {
    this.uVm = (this.uVn * this.mNumColumns * this.dtu);
    y.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.uVn), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.dtu), Integer.valueOf(this.uVm) });
    cmW();
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.uVz = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.uVu = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.uVv = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.uVl = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    this.uVj = paramj;
    if (paramj == null) {}
    for (;;)
    {
      y.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.uVj != null) {
        this.uVj.uVL = new MMGridPaper.1(this);
      }
      cmW();
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.uVk = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    this.VH = paramView;
    paramView = (ViewGroup)findViewById(a.g.header_area);
    paramView.removeAllViews();
    if (this.VH != null) {
      paramView.addView(this.VH);
    }
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.uVx = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.uVw = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.uVE = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.uVC = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.uVt = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.uVD = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.uVH = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */