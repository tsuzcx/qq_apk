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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected int FUZ;
  protected int FVa;
  final MMFlipper.b FWM;
  final MMFlipper.a FWN;
  protected MMFlipper FXb;
  protected j FXc;
  protected int FXd;
  protected int FXe;
  protected int FXf;
  protected int FXg;
  protected int FXh;
  protected int FXi;
  protected int FXj;
  protected int FXk;
  protected boolean FXl;
  protected int FXm;
  protected int FXn;
  protected int FXo;
  protected int FXp;
  protected int FXq;
  protected boolean FXr;
  protected boolean FXs;
  protected int FXt;
  protected int FXu;
  protected boolean FXv;
  protected int FXw;
  protected int FXx;
  protected a FXy;
  protected View adC;
  protected int mCurrentOrientation;
  protected int mMaxColumns;
  protected int mMaxRows;
  protected int mNumColumns;
  protected int mNumRows;
  protected MMDotView mfR;
  protected ap rfb;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141969);
    this.FXf = 0;
    this.FXg = 0;
    this.FXh = 3;
    this.FXi = 0;
    this.FXj = (this.FXh - 1);
    this.FXk = 0;
    this.mNumColumns = 0;
    this.mNumRows = 0;
    this.FXl = false;
    this.FXm = 9;
    this.FXn = -1;
    this.FXo = -1;
    this.FXp = 96;
    this.FXq = 96;
    this.FUZ = 10;
    this.FVa = 10;
    this.FXr = false;
    this.FXs = false;
    this.FXt = -1;
    this.FXu = -1;
    this.mCurrentOrientation = 0;
    this.mMaxColumns = -1;
    this.mMaxRows = -1;
    this.FXv = false;
    this.FXw = 0;
    this.FXx = 0;
    this.FWN = new MMFlipper.a()
    {
      public final void gQ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(141965);
        ad.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.FXd), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.FXe), Boolean.valueOf(MMGridPaper.this.FXs), Boolean.valueOf(MMGridPaper.this.FXr) });
        if (((Math.abs(MMGridPaper.this.FXe - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.FXd - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          ad.d("MicroMsg.MMGridPaper", "match width height limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        if ((MMGridPaper.this.FXs) && (MMGridPaper.this.FXd > paramAnonymousInt1) && (!MMGridPaper.this.FXr))
        {
          ad.d("MicroMsg.MMGridPaper", "match ori limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        ad.v("MicroMsg.MMGridPaper", "onMeasure: match");
        ad.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.FXv) });
        MMGridPaper.this.FXr = false;
        if (!MMGridPaper.this.FXv)
        {
          MMGridPaper.this.FXe = paramAnonymousInt2;
          MMGridPaper.this.FXd = paramAnonymousInt1;
        }
        MMGridPaper.this.refresh();
        AppMethodBeat.o(141965);
      }
    };
    this.FWM = new MMFlipper.b()
    {
      public final void u(int paramAnonymousInt1, final int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164148);
        ad.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.FXi), Integer.valueOf(MMGridPaper.this.FXj), Integer.valueOf(MMGridPaper.this.FXk) });
        if ((paramAnonymousInt2 <= MMGridPaper.this.FXi) && (MMGridPaper.this.FXi > 0)) {
          MMGridPaper.this.rfb.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141966);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.FXb.getChildAt(MMGridPaper.this.FXb.getChildCount() - 1);
              int i = paramAnonymousInt2 - (MMGridPaper.this.FXb.getChildCount() >> 1);
              ad.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.FXb.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.FXb.removeViewAt(MMGridPaper.this.FXb.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.FXc);
              MMGridPaper.this.FXb.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.FXb.getChildCount();
              MMGridPaper.this.FXb.XL(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              AppMethodBeat.o(141966);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.FXg = paramAnonymousInt2;
          MMGridPaper.this.mfR.setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(164148);
          return;
          if ((paramAnonymousInt2 >= MMGridPaper.this.FXj) && (MMGridPaper.this.FXj < MMGridPaper.this.FXk - 1)) {
            MMGridPaper.this.rfb.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141967);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.FXb.getChildAt(0);
                int i = paramAnonymousInt2 + (MMGridPaper.this.FXb.getChildCount() >> 1);
                ad.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.FXb.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.FXc);
                MMGridPaper.this.FXb.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.FXb.getChildCount();
                MMGridPaper.this.FXb.XL(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                AppMethodBeat.o(141967);
              }
            });
          }
        }
      }
    };
    this.rfb = new ap(Looper.getMainLooper());
    View.inflate(getContext(), 2131494795, this);
    this.mCurrentOrientation = getScreenOrientation();
    AppMethodBeat.o(141969);
  }
  
  private boolean XN(int paramInt)
  {
    AppMethodBeat.i(141976);
    ad.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.FXs) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.FXs) {
        break;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    int i = jh(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(141976);
      return true;
    case 2: 
      i = Math.min(i, this.FXu);
      j = (this.FXq + 10) * i + 8;
      ad.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.FXn), Boolean.valueOf(this.FXr) });
      if (this.FXn != j)
      {
        this.FXn = j;
        AppMethodBeat.o(141976);
        return false;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    i = Math.min(i, this.FXt);
    int j = (this.FXq + 10) * i + 8;
    ad.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.FXo), Boolean.valueOf(this.FXr) });
    if (this.FXo != j)
    {
      this.FXo = j;
      AppMethodBeat.o(141976);
      return false;
    }
    AppMethodBeat.o(141976);
    return true;
  }
  
  private void dmH()
  {
    AppMethodBeat.i(141980);
    ad.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.FXk >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.mfR.setDotCount(this.FXk);
      if ((this.FXc != null) && (this.FXk > 1)) {
        break label137;
      }
      this.mfR.setVisibility(8);
      ad.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.FXg >= this.FXk) {
        this.FXg = (this.FXk - 1);
      }
      this.FXb.XL(this.FXg - this.FXi);
      this.FXb.XM(this.FXg);
      this.mfR.setSelectedDot(this.FXg);
      AppMethodBeat.o(141980);
      return;
      bool = false;
      break;
      label137:
      this.mfR.setVisibility(0);
      ad.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private void eSI()
  {
    AppMethodBeat.i(141974);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.FXn) && (getScreenOrientation() == 2))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.FXn);
      if (i != localLayoutParams.height)
      {
        ad.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.FXn) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.rfb.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141963);
            ad.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141963);
          }
        });
      }
      AppMethodBeat.o(141974);
      return;
    }
    if ((-1 != this.FXo) && (getScreenOrientation() == 1))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.FXo);
      if (i != localLayoutParams.height)
      {
        ad.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.FXo) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.rfb.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141964);
            ad.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141964);
          }
        });
      }
    }
    AppMethodBeat.o(141974);
  }
  
  private void eSJ()
  {
    AppMethodBeat.i(141977);
    ad.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.FXd), Integer.valueOf(this.FXe) });
    if ((this.FXd == 0) || (this.FXe == 0))
    {
      ad.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(141977);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.FXp);
    int i = a.fromDPToPix(getContext(), this.FXq);
    j = Math.max(this.FXd / j, 1);
    i = Math.max(this.FXe / i, 1);
    if ((j != this.mNumColumns) || (i != this.mNumRows)) {
      this.FXl = true;
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
    this.FXk = 0;
    if (this.FXc == null) {}
    for (i = 0;; i = this.FXc.getCount())
    {
      i += 0;
      if (XN(i)) {
        break;
      }
      eSI();
      AppMethodBeat.o(141977);
      return;
    }
    this.FXk = jh(i, j);
    this.FXg = Math.min(this.FXk - 1, ji(this.FXf, j));
    this.FXh = Math.min(3, this.FXk);
    this.FXi = Math.min(this.FXk - this.FXh, Math.max(0, this.FXg - (this.FXh >> 1)));
    this.FXj = (this.FXi + this.FXh - 1);
    ad.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.FXp), Integer.valueOf(this.FXq), Integer.valueOf(this.mNumRows), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.FXh), Integer.valueOf(this.FXk), Integer.valueOf(this.FXg), Integer.valueOf(this.FXi), Integer.valueOf(this.FXj) });
    if ((this.FXb.getChildCount() != this.FXh) || (this.FXl))
    {
      ad.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.FXl) });
      this.FXl = false;
      this.FXb.removeAllViews();
      i = this.FXi;
    }
    while (i <= this.FXj)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), 2131494785, null);
      localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.FXc);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.FUZ));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.FVa));
      this.FXb.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.FXi;
      if (i <= this.FXj)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.FXb.getChildAt(i - this.FXi);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          ad.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.FXc);
          localMMGridPaperGridView.notifyDataSetChanged();
        }
        for (;;)
        {
          i += 1;
          break;
          ad.v("MicroMsg.MMGridPaper", "same grid index, continus");
        }
      }
    }
    dmH();
    AppMethodBeat.o(141977);
  }
  
  private void eyF()
  {
    AppMethodBeat.i(141975);
    ad.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.mfR == null)
    {
      this.mfR = ((MMDotView)findViewById(2131300617));
      this.mfR.setMaxCount(this.FXm);
    }
    if (this.FXb == null)
    {
      this.FXb = ((MMFlipper)findViewById(2131300618));
      this.FXb.setOnMeasureListener(this.FWN);
      this.FXb.setOnScreenChangedListener(this.FWM);
    }
    eSI();
    eSJ();
    AppMethodBeat.o(141975);
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(141983);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.FXb.getChildAt(this.FXb.getCurScreen());
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
  
  private static int jh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141978);
    if (paramInt2 <= 0)
    {
      ad.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        ad.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141978);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  private static int ji(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141979);
    if ((paramInt1 == 0) || (paramInt2 <= 0))
    {
      ad.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        ad.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141979);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  public final void eSG()
  {
    this.FXu = 3;
    this.FXt = 3;
  }
  
  public final void eSH()
  {
    this.FUZ = 8;
    this.FVa = 15;
  }
  
  public final int getItemsCountPerPage()
  {
    return this.mNumRows * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.FXk;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141982);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ad.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.FXr = true;
    }
    AppMethodBeat.o(141982);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141981);
    ad.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mCurrentOrientation != getScreenOrientation())
    {
      this.mCurrentOrientation = getScreenOrientation();
      ad.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
      this.FXr = true;
      clearAnimation();
      eSI();
      eSJ();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141981);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(141972);
    this.FXf = (this.FXg * this.mNumColumns * this.mNumRows);
    ad.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.FXg), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.mNumRows), Integer.valueOf(this.FXf) });
    eyF();
    AppMethodBeat.o(141972);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.FXs = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.FXn = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.FXo = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.FXe = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(141971);
    this.FXc = paramj;
    if (paramj == null) {}
    for (;;)
    {
      ad.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.FXc != null) {
        this.FXc.FXC = new j.a()
        {
          public final void bCM()
          {
            AppMethodBeat.i(141962);
            MMGridPaper.this.refresh();
            AppMethodBeat.o(141962);
          }
        };
      }
      eyF();
      AppMethodBeat.o(141971);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.FXd = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(141970);
    this.adC = paramView;
    paramView = (ViewGroup)findViewById(2131300705);
    paramView.removeAllViews();
    if (this.adC != null) {
      paramView.addView(this.adC);
    }
    AppMethodBeat.o(141970);
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.FXq = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.FXp = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.FXv = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.mMaxColumns = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.FXm = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.mMaxRows = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.FXy = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */