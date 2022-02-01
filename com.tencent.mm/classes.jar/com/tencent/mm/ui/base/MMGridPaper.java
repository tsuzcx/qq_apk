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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected int HuN;
  protected int HuO;
  final MMFlipper.c HwA;
  final MMFlipper.b HwC;
  protected MMFlipper HwQ;
  protected j HwR;
  protected int HwS;
  protected int HwT;
  protected int HwU;
  protected int HwV;
  protected int HwW;
  protected int HwX;
  protected int HwY;
  protected int HwZ;
  protected boolean Hxa;
  protected int Hxb;
  protected int Hxc;
  protected int Hxd;
  protected int Hxe;
  protected int Hxf;
  protected boolean Hxg;
  protected boolean Hxh;
  protected int Hxi;
  protected int Hxj;
  protected boolean Hxk;
  protected int Hxl;
  protected int Hxm;
  protected a Hxn;
  protected View aew;
  protected int mCurrentOrientation;
  protected MMDotView mHQ;
  protected int mMaxColumns;
  protected int mMaxRows;
  protected int mNumColumns;
  protected int mNumRows;
  protected ao snT;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141969);
    this.HwU = 0;
    this.HwV = 0;
    this.HwW = 3;
    this.HwX = 0;
    this.HwY = (this.HwW - 1);
    this.HwZ = 0;
    this.mNumColumns = 0;
    this.mNumRows = 0;
    this.Hxa = false;
    this.Hxb = 9;
    this.Hxc = -1;
    this.Hxd = -1;
    this.Hxe = 96;
    this.Hxf = 96;
    this.HuN = 10;
    this.HuO = 10;
    this.Hxg = false;
    this.Hxh = false;
    this.Hxi = -1;
    this.Hxj = -1;
    this.mCurrentOrientation = 0;
    this.mMaxColumns = -1;
    this.mMaxRows = -1;
    this.Hxk = false;
    this.Hxl = 0;
    this.Hxm = 0;
    this.HwC = new MMFlipper.b()
    {
      public final void gZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(141965);
        ac.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.HwS), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.HwT), Boolean.valueOf(MMGridPaper.this.Hxh), Boolean.valueOf(MMGridPaper.this.Hxg) });
        if (((Math.abs(MMGridPaper.this.HwT - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.HwS - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          ac.d("MicroMsg.MMGridPaper", "match width height limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        if ((MMGridPaper.this.Hxh) && (MMGridPaper.this.HwS > paramAnonymousInt1) && (!MMGridPaper.this.Hxg))
        {
          ac.d("MicroMsg.MMGridPaper", "match ori limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        ac.v("MicroMsg.MMGridPaper", "onMeasure: match");
        ac.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.Hxk) });
        MMGridPaper.this.Hxg = false;
        if (!MMGridPaper.this.Hxk)
        {
          MMGridPaper.this.HwT = paramAnonymousInt2;
          MMGridPaper.this.HwS = paramAnonymousInt1;
        }
        MMGridPaper.this.refresh();
        AppMethodBeat.o(141965);
      }
    };
    this.HwA = new MMFlipper.c()
    {
      public final void u(int paramAnonymousInt1, final int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164148);
        ac.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.HwX), Integer.valueOf(MMGridPaper.this.HwY), Integer.valueOf(MMGridPaper.this.HwZ) });
        if ((paramAnonymousInt2 <= MMGridPaper.this.HwX) && (MMGridPaper.this.HwX > 0)) {
          MMGridPaper.this.snT.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141966);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.HwQ.getChildAt(MMGridPaper.this.HwQ.getChildCount() - 1);
              int i = paramAnonymousInt2 - (MMGridPaper.this.HwQ.getChildCount() >> 1);
              ac.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.HwQ.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.HwQ.removeViewAt(MMGridPaper.this.HwQ.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.HwR);
              MMGridPaper.this.HwQ.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.HwQ.getChildCount();
              MMGridPaper.this.HwQ.ZW(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              AppMethodBeat.o(141966);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.HwV = paramAnonymousInt2;
          MMGridPaper.this.mHQ.setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(164148);
          return;
          if ((paramAnonymousInt2 >= MMGridPaper.this.HwY) && (MMGridPaper.this.HwY < MMGridPaper.this.HwZ - 1)) {
            MMGridPaper.this.snT.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141967);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.HwQ.getChildAt(0);
                int i = paramAnonymousInt2 + (MMGridPaper.this.HwQ.getChildCount() >> 1);
                ac.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.HwQ.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.HwR);
                MMGridPaper.this.HwQ.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.HwQ.getChildCount();
                MMGridPaper.this.HwQ.ZW(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                AppMethodBeat.o(141967);
              }
            });
          }
        }
      }
    };
    this.snT = new ao(Looper.getMainLooper());
    View.inflate(getContext(), 2131494795, this);
    this.mCurrentOrientation = getScreenOrientation();
    AppMethodBeat.o(141969);
  }
  
  private boolean ZY(int paramInt)
  {
    AppMethodBeat.i(141976);
    ac.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Hxh) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.Hxh) {
        break;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    int i = ju(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(141976);
      return true;
    case 2: 
      i = Math.min(i, this.Hxj);
      j = (this.Hxf + 10) * i + 8;
      ac.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.Hxc), Boolean.valueOf(this.Hxg) });
      if (this.Hxc != j)
      {
        this.Hxc = j;
        AppMethodBeat.o(141976);
        return false;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    i = Math.min(i, this.Hxi);
    int j = (this.Hxf + 10) * i + 8;
    ac.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.Hxd), Boolean.valueOf(this.Hxg) });
    if (this.Hxd != j)
    {
      this.Hxd = j;
      AppMethodBeat.o(141976);
      return false;
    }
    AppMethodBeat.o(141976);
    return true;
  }
  
  private void dAN()
  {
    AppMethodBeat.i(141980);
    ac.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.HwZ >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.mHQ.setDotCount(this.HwZ);
      if ((this.HwR != null) && (this.HwZ > 1)) {
        break label137;
      }
      this.mHQ.setVisibility(8);
      ac.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.HwV >= this.HwZ) {
        this.HwV = (this.HwZ - 1);
      }
      this.HwQ.ZW(this.HwV - this.HwX);
      this.HwQ.ZX(this.HwV);
      this.mHQ.setSelectedDot(this.HwV);
      AppMethodBeat.o(141980);
      return;
      bool = false;
      break;
      label137:
      this.mHQ.setVisibility(0);
      ac.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private void eOa()
  {
    AppMethodBeat.i(141975);
    ac.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.mHQ == null)
    {
      this.mHQ = ((MMDotView)findViewById(2131300617));
      this.mHQ.setMaxCount(this.Hxb);
    }
    if (this.HwQ == null)
    {
      this.HwQ = ((MMFlipper)findViewById(2131300618));
      this.HwQ.setOnMeasureListener(this.HwC);
      this.HwQ.setOnScreenChangedListener(this.HwA);
    }
    fis();
    fit();
    AppMethodBeat.o(141975);
  }
  
  private void fis()
  {
    AppMethodBeat.i(141974);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.Hxc) && (getScreenOrientation() == 2))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.Hxc);
      if (i != localLayoutParams.height)
      {
        ac.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.Hxc) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.snT.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141963);
            ac.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141963);
          }
        });
      }
      AppMethodBeat.o(141974);
      return;
    }
    if ((-1 != this.Hxd) && (getScreenOrientation() == 1))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.Hxd);
      if (i != localLayoutParams.height)
      {
        ac.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.Hxd) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.snT.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141964);
            ac.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141964);
          }
        });
      }
    }
    AppMethodBeat.o(141974);
  }
  
  private void fit()
  {
    AppMethodBeat.i(141977);
    ac.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.HwS), Integer.valueOf(this.HwT) });
    if ((this.HwS == 0) || (this.HwT == 0))
    {
      ac.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(141977);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.Hxe);
    int i = a.fromDPToPix(getContext(), this.Hxf);
    j = Math.max(this.HwS / j, 1);
    i = Math.max(this.HwT / i, 1);
    if ((j != this.mNumColumns) || (i != this.mNumRows)) {
      this.Hxa = true;
    }
    this.mNumColumns = j;
    if (this.mMaxColumns != -1) {
      this.mNumColumns = Math.min(this.mNumColumns, this.mMaxColumns);
    }
    this.mNumRows = i;
    if (this.mMaxRows != -1) {
      this.mNumRows = Math.min(this.mNumRows, this.mMaxRows);
    }
    i = this.mNumColumns;
    j = this.mNumRows * i;
    this.HwZ = 0;
    if (this.HwR == null) {}
    for (i = 0;; i = this.HwR.getCount())
    {
      i += 0;
      if (ZY(i)) {
        break;
      }
      fis();
      AppMethodBeat.o(141977);
      return;
    }
    this.HwZ = ju(i, j);
    this.HwV = Math.min(this.HwZ - 1, jv(this.HwU, j));
    this.HwW = Math.min(3, this.HwZ);
    this.HwX = Math.min(this.HwZ - this.HwW, Math.max(0, this.HwV - (this.HwW >> 1)));
    this.HwY = (this.HwX + this.HwW - 1);
    ac.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.Hxe), Integer.valueOf(this.Hxf), Integer.valueOf(this.mNumRows), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.HwW), Integer.valueOf(this.HwZ), Integer.valueOf(this.HwV), Integer.valueOf(this.HwX), Integer.valueOf(this.HwY) });
    if ((this.HwQ.getChildCount() != this.HwW) || (this.Hxa))
    {
      ac.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.Hxa) });
      this.Hxa = false;
      this.HwQ.removeAllViews();
      i = this.HwX;
    }
    while (i <= this.HwY)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), 2131494785, null);
      localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.HwR);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.HuN));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.HuO));
      this.HwQ.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.HwX;
      if (i <= this.HwY)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.HwQ.getChildAt(i - this.HwX);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          ac.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.HwR);
          localMMGridPaperGridView.notifyDataSetChanged();
        }
        for (;;)
        {
          i += 1;
          break;
          ac.v("MicroMsg.MMGridPaper", "same grid index, continus");
        }
      }
    }
    dAN();
    AppMethodBeat.o(141977);
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(141983);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.HwQ.getChildAt(this.HwQ.getCurScreen());
    AppMethodBeat.o(141983);
    return localMMGridPaperGridView;
  }
  
  private int getScreenOrientation()
  {
    AppMethodBeat.i(141973);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {}
    for (int i = 1;; i = 2)
    {
      AppMethodBeat.o(141973);
      return i;
    }
  }
  
  private static int ju(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141978);
    if (paramInt2 <= 0)
    {
      ac.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(141978);
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
        ac.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141978);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  private static int jv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141979);
    if ((paramInt1 == 0) || (paramInt2 <= 0))
    {
      ac.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(141979);
      return 0;
    }
    for (;;)
    {
      int j;
      int i;
      if (j >= paramInt2)
      {
        j -= paramInt2;
        i += 1;
      }
      else
      {
        ac.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141979);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  public final void fiq()
  {
    this.Hxj = 3;
    this.Hxi = 3;
  }
  
  public final void fir()
  {
    this.HuN = 8;
    this.HuO = 15;
  }
  
  public final int getItemsCountPerPage()
  {
    return this.mNumRows * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.HwZ;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141982);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ac.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.Hxg = true;
    }
    AppMethodBeat.o(141982);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141981);
    ac.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mCurrentOrientation != getScreenOrientation())
    {
      this.mCurrentOrientation = getScreenOrientation();
      ac.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
      this.Hxg = true;
      clearAnimation();
      fis();
      fit();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141981);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(141972);
    this.HwU = (this.HwV * this.mNumColumns * this.mNumRows);
    ac.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.HwV), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.mNumRows), Integer.valueOf(this.HwU) });
    eOa();
    AppMethodBeat.o(141972);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.Hxh = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.Hxc = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.Hxd = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.HwT = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(141971);
    this.HwR = paramj;
    if (paramj == null) {}
    for (;;)
    {
      ac.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.HwR != null) {
        this.HwR.Hxr = new j.a()
        {
          public final void bJU()
          {
            AppMethodBeat.i(141962);
            MMGridPaper.this.refresh();
            AppMethodBeat.o(141962);
          }
        };
      }
      eOa();
      AppMethodBeat.o(141971);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.HwS = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(141970);
    this.aew = paramView;
    paramView = (ViewGroup)findViewById(2131300705);
    paramView.removeAllViews();
    if (this.aew != null) {
      paramView.addView(this.aew);
    }
    AppMethodBeat.o(141970);
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.Hxf = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.Hxe = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.Hxk = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.mMaxColumns = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.Hxb = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.mMaxRows = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.Hxn = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */