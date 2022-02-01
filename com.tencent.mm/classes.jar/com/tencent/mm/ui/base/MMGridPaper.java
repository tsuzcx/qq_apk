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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected int JiD;
  protected int JiE;
  protected MMFlipper JkG;
  protected j JkH;
  protected int JkI;
  protected int JkJ;
  protected int JkK;
  protected int JkL;
  protected int JkM;
  protected int JkN;
  protected int JkO;
  protected int JkP;
  protected boolean JkQ;
  protected int JkR;
  protected int JkS;
  protected int JkT;
  protected int JkU;
  protected int JkV;
  protected boolean JkW;
  protected boolean JkX;
  protected int JkY;
  protected int JkZ;
  final MMFlipper.c Jkq;
  final MMFlipper.b Jks;
  protected boolean Jla;
  protected int Jlb;
  protected int Jlc;
  protected a Jld;
  protected View agn;
  protected int mCurrentOrientation;
  protected int mMaxColumns;
  protected int mMaxRows;
  protected int mNumColumns;
  protected int mNumRows;
  protected MMDotView nio;
  protected ap tkw;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141969);
    this.JkK = 0;
    this.JkL = 0;
    this.JkM = 3;
    this.JkN = 0;
    this.JkO = (this.JkM - 1);
    this.JkP = 0;
    this.mNumColumns = 0;
    this.mNumRows = 0;
    this.JkQ = false;
    this.JkR = 9;
    this.JkS = -1;
    this.JkT = -1;
    this.JkU = 96;
    this.JkV = 96;
    this.JiD = 10;
    this.JiE = 10;
    this.JkW = false;
    this.JkX = false;
    this.JkY = -1;
    this.JkZ = -1;
    this.mCurrentOrientation = 0;
    this.mMaxColumns = -1;
    this.mMaxRows = -1;
    this.Jla = false;
    this.Jlb = 0;
    this.Jlc = 0;
    this.Jks = new MMFlipper.b()
    {
      public final void hq(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(141965);
        ad.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.JkI), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.JkJ), Boolean.valueOf(MMGridPaper.this.JkX), Boolean.valueOf(MMGridPaper.this.JkW) });
        if (((Math.abs(MMGridPaper.this.JkJ - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.JkI - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          ad.d("MicroMsg.MMGridPaper", "match width height limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        if ((MMGridPaper.this.JkX) && (MMGridPaper.this.JkI > paramAnonymousInt1) && (!MMGridPaper.this.JkW))
        {
          ad.d("MicroMsg.MMGridPaper", "match ori limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        ad.v("MicroMsg.MMGridPaper", "onMeasure: match");
        ad.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.Jla) });
        MMGridPaper.this.JkW = false;
        if (!MMGridPaper.this.Jla)
        {
          MMGridPaper.this.JkJ = paramAnonymousInt2;
          MMGridPaper.this.JkI = paramAnonymousInt1;
        }
        MMGridPaper.this.refresh();
        AppMethodBeat.o(141965);
      }
    };
    this.Jkq = new MMFlipper.c()
    {
      public final void u(int paramAnonymousInt1, final int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164148);
        ad.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.JkN), Integer.valueOf(MMGridPaper.this.JkO), Integer.valueOf(MMGridPaper.this.JkP) });
        if ((paramAnonymousInt2 <= MMGridPaper.this.JkN) && (MMGridPaper.this.JkN > 0)) {
          MMGridPaper.this.tkw.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141966);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.JkG.getChildAt(MMGridPaper.this.JkG.getChildCount() - 1);
              int i = paramAnonymousInt2 - (MMGridPaper.this.JkG.getChildCount() >> 1);
              ad.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.JkG.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.JkG.removeViewAt(MMGridPaper.this.JkG.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.JkH);
              MMGridPaper.this.JkG.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.JkG.getChildCount();
              MMGridPaper.this.JkG.acg(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              AppMethodBeat.o(141966);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.JkL = paramAnonymousInt2;
          MMGridPaper.this.nio.setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(164148);
          return;
          if ((paramAnonymousInt2 >= MMGridPaper.this.JkO) && (MMGridPaper.this.JkO < MMGridPaper.this.JkP - 1)) {
            MMGridPaper.this.tkw.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141967);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.JkG.getChildAt(0);
                int i = paramAnonymousInt2 + (MMGridPaper.this.JkG.getChildCount() >> 1);
                ad.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.JkG.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.JkH);
                MMGridPaper.this.JkG.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.JkG.getChildCount();
                MMGridPaper.this.JkG.acg(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                AppMethodBeat.o(141967);
              }
            });
          }
        }
      }
    };
    this.tkw = new ap(Looper.getMainLooper());
    View.inflate(getContext(), 2131494795, this);
    this.mCurrentOrientation = getScreenOrientation();
    AppMethodBeat.o(141969);
  }
  
  private boolean aci(int paramInt)
  {
    AppMethodBeat.i(141976);
    ad.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.JkX) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.JkX) {
        break;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    int i = jG(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(141976);
      return true;
    case 2: 
      i = Math.min(i, this.JkZ);
      j = (this.JkV + 10) * i + 8;
      ad.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.JkS), Boolean.valueOf(this.JkW) });
      if (this.JkS != j)
      {
        this.JkS = j;
        AppMethodBeat.o(141976);
        return false;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    i = Math.min(i, this.JkY);
    int j = (this.JkV + 10) * i + 8;
    ad.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.JkT), Boolean.valueOf(this.JkW) });
    if (this.JkT != j)
    {
      this.JkT = j;
      AppMethodBeat.o(141976);
      return false;
    }
    AppMethodBeat.o(141976);
    return true;
  }
  
  private void dMl()
  {
    AppMethodBeat.i(141980);
    ad.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.JkP >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.nio.setDotCount(this.JkP);
      if ((this.JkH != null) && (this.JkP > 1)) {
        break label137;
      }
      this.nio.setVisibility(8);
      ad.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.JkL >= this.JkP) {
        this.JkL = (this.JkP - 1);
      }
      this.JkG.acg(this.JkL - this.JkN);
      this.JkG.ach(this.JkL);
      this.nio.setSelectedDot(this.JkL);
      AppMethodBeat.o(141980);
      return;
      bool = false;
      break;
      label137:
      this.nio.setVisibility(0);
      ad.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private void fcZ()
  {
    AppMethodBeat.i(141975);
    ad.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.nio == null)
    {
      this.nio = ((MMDotView)findViewById(2131300617));
      this.nio.setMaxCount(this.JkR);
    }
    if (this.JkG == null)
    {
      this.JkG = ((MMFlipper)findViewById(2131300618));
      this.JkG.setOnMeasureListener(this.Jks);
      this.JkG.setOnScreenChangedListener(this.Jkq);
    }
    fyH();
    fyI();
    AppMethodBeat.o(141975);
  }
  
  private void fyH()
  {
    AppMethodBeat.i(141974);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.JkS) && (getScreenOrientation() == 2))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.JkS);
      if (i != localLayoutParams.height)
      {
        ad.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.JkS) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.tkw.post(new Runnable()
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
    if ((-1 != this.JkT) && (getScreenOrientation() == 1))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.JkT);
      if (i != localLayoutParams.height)
      {
        ad.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.JkT) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.tkw.post(new Runnable()
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
  
  private void fyI()
  {
    AppMethodBeat.i(141977);
    ad.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.JkI), Integer.valueOf(this.JkJ) });
    if ((this.JkI == 0) || (this.JkJ == 0))
    {
      ad.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(141977);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.JkU);
    int i = a.fromDPToPix(getContext(), this.JkV);
    j = Math.max(this.JkI / j, 1);
    i = Math.max(this.JkJ / i, 1);
    if ((j != this.mNumColumns) || (i != this.mNumRows)) {
      this.JkQ = true;
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
    this.JkP = 0;
    if (this.JkH == null) {}
    for (i = 0;; i = this.JkH.getCount())
    {
      i += 0;
      if (aci(i)) {
        break;
      }
      fyH();
      AppMethodBeat.o(141977);
      return;
    }
    this.JkP = jG(i, j);
    this.JkL = Math.min(this.JkP - 1, jH(this.JkK, j));
    this.JkM = Math.min(3, this.JkP);
    this.JkN = Math.min(this.JkP - this.JkM, Math.max(0, this.JkL - (this.JkM >> 1)));
    this.JkO = (this.JkN + this.JkM - 1);
    ad.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.JkU), Integer.valueOf(this.JkV), Integer.valueOf(this.mNumRows), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.JkM), Integer.valueOf(this.JkP), Integer.valueOf(this.JkL), Integer.valueOf(this.JkN), Integer.valueOf(this.JkO) });
    if ((this.JkG.getChildCount() != this.JkM) || (this.JkQ))
    {
      ad.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.JkQ) });
      this.JkQ = false;
      this.JkG.removeAllViews();
      i = this.JkN;
    }
    while (i <= this.JkO)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), 2131494785, null);
      localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.JkH);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.JiD));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.JiE));
      this.JkG.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.JkN;
      if (i <= this.JkO)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.JkG.getChildAt(i - this.JkN);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          ad.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.JkH);
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
    dMl();
    AppMethodBeat.o(141977);
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(141983);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.JkG.getChildAt(this.JkG.getCurScreen());
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
  
  private static int jG(int paramInt1, int paramInt2)
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
  
  private static int jH(int paramInt1, int paramInt2)
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
  
  public final void fyF()
  {
    this.JkZ = 3;
    this.JkY = 3;
  }
  
  public final void fyG()
  {
    this.JiD = 8;
    this.JiE = 15;
  }
  
  public final int getItemsCountPerPage()
  {
    return this.mNumRows * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.JkP;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141982);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ad.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.JkW = true;
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
      this.JkW = true;
      clearAnimation();
      fyH();
      fyI();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141981);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(141972);
    this.JkK = (this.JkL * this.mNumColumns * this.mNumRows);
    ad.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.JkL), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.mNumRows), Integer.valueOf(this.JkK) });
    fcZ();
    AppMethodBeat.o(141972);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.JkX = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.JkS = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.JkT = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.JkJ = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(141971);
    this.JkH = paramj;
    if (paramj == null) {}
    for (;;)
    {
      ad.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.JkH != null) {
        this.JkH.Jlh = new j.a()
        {
          public final void bOo()
          {
            AppMethodBeat.i(141962);
            MMGridPaper.this.refresh();
            AppMethodBeat.o(141962);
          }
        };
      }
      fcZ();
      AppMethodBeat.o(141971);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.JkI = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(141970);
    this.agn = paramView;
    paramView = (ViewGroup)findViewById(2131300705);
    paramView.removeAllViews();
    if (this.agn != null) {
      paramView.addView(this.agn);
    }
    AppMethodBeat.o(141970);
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.JkV = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.JkU = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.Jla = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.mMaxColumns = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.JkR = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.mMaxRows = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.Jld = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */