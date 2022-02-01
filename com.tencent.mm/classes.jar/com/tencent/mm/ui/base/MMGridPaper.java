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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected int JDr;
  protected int JDs;
  protected int JFA;
  protected int JFB;
  protected int JFC;
  protected int JFD;
  protected boolean JFE;
  protected int JFF;
  protected int JFG;
  protected int JFH;
  protected int JFI;
  protected int JFJ;
  protected boolean JFK;
  protected boolean JFL;
  protected int JFM;
  protected int JFN;
  protected boolean JFO;
  protected int JFP;
  protected int JFQ;
  protected a JFR;
  final MMFlipper.c JFe;
  final MMFlipper.b JFg;
  protected MMFlipper JFu;
  protected j JFv;
  protected int JFw;
  protected int JFx;
  protected int JFy;
  protected int JFz;
  protected View agn;
  protected int mCurrentOrientation;
  protected int mMaxColumns;
  protected int mMaxRows;
  protected int mNumColumns;
  protected int mNumRows;
  protected MMDotView nnw;
  protected aq tvo;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141969);
    this.JFy = 0;
    this.JFz = 0;
    this.JFA = 3;
    this.JFB = 0;
    this.JFC = (this.JFA - 1);
    this.JFD = 0;
    this.mNumColumns = 0;
    this.mNumRows = 0;
    this.JFE = false;
    this.JFF = 9;
    this.JFG = -1;
    this.JFH = -1;
    this.JFI = 96;
    this.JFJ = 96;
    this.JDr = 10;
    this.JDs = 10;
    this.JFK = false;
    this.JFL = false;
    this.JFM = -1;
    this.JFN = -1;
    this.mCurrentOrientation = 0;
    this.mMaxColumns = -1;
    this.mMaxRows = -1;
    this.JFO = false;
    this.JFP = 0;
    this.JFQ = 0;
    this.JFg = new MMFlipper.b()
    {
      public final void hs(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(141965);
        ae.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.JFw), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.JFx), Boolean.valueOf(MMGridPaper.this.JFL), Boolean.valueOf(MMGridPaper.this.JFK) });
        if (((Math.abs(MMGridPaper.this.JFx - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.JFw - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          ae.d("MicroMsg.MMGridPaper", "match width height limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        if ((MMGridPaper.this.JFL) && (MMGridPaper.this.JFw > paramAnonymousInt1) && (!MMGridPaper.this.JFK))
        {
          ae.d("MicroMsg.MMGridPaper", "match ori limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        ae.v("MicroMsg.MMGridPaper", "onMeasure: match");
        ae.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.JFO) });
        MMGridPaper.this.JFK = false;
        if (!MMGridPaper.this.JFO)
        {
          MMGridPaper.this.JFx = paramAnonymousInt2;
          MMGridPaper.this.JFw = paramAnonymousInt1;
        }
        MMGridPaper.this.refresh();
        AppMethodBeat.o(141965);
      }
    };
    this.JFe = new MMFlipper.c()
    {
      public final void u(int paramAnonymousInt1, final int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164148);
        ae.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.JFB), Integer.valueOf(MMGridPaper.this.JFC), Integer.valueOf(MMGridPaper.this.JFD) });
        if ((paramAnonymousInt2 <= MMGridPaper.this.JFB) && (MMGridPaper.this.JFB > 0)) {
          MMGridPaper.this.tvo.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141966);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.JFu.getChildAt(MMGridPaper.this.JFu.getChildCount() - 1);
              int i = paramAnonymousInt2 - (MMGridPaper.this.JFu.getChildCount() >> 1);
              ae.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.JFu.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.JFu.removeViewAt(MMGridPaper.this.JFu.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.JFv);
              MMGridPaper.this.JFu.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.JFu.getChildCount();
              MMGridPaper.this.JFu.acN(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              AppMethodBeat.o(141966);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.JFz = paramAnonymousInt2;
          MMGridPaper.this.nnw.setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(164148);
          return;
          if ((paramAnonymousInt2 >= MMGridPaper.this.JFC) && (MMGridPaper.this.JFC < MMGridPaper.this.JFD - 1)) {
            MMGridPaper.this.tvo.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141967);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.JFu.getChildAt(0);
                int i = paramAnonymousInt2 + (MMGridPaper.this.JFu.getChildCount() >> 1);
                ae.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.JFu.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.JFv);
                MMGridPaper.this.JFu.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.JFu.getChildCount();
                MMGridPaper.this.JFu.acN(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                AppMethodBeat.o(141967);
              }
            });
          }
        }
      }
    };
    this.tvo = new aq(Looper.getMainLooper());
    View.inflate(getContext(), 2131494795, this);
    this.mCurrentOrientation = getScreenOrientation();
    AppMethodBeat.o(141969);
  }
  
  private boolean acP(int paramInt)
  {
    AppMethodBeat.i(141976);
    ae.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.JFL) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.JFL) {
        break;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    int i = jK(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(141976);
      return true;
    case 2: 
      i = Math.min(i, this.JFN);
      j = (this.JFJ + 10) * i + 8;
      ae.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.JFG), Boolean.valueOf(this.JFK) });
      if (this.JFG != j)
      {
        this.JFG = j;
        AppMethodBeat.o(141976);
        return false;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    i = Math.min(i, this.JFM);
    int j = (this.JFJ + 10) * i + 8;
    ae.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.JFH), Boolean.valueOf(this.JFK) });
    if (this.JFH != j)
    {
      this.JFH = j;
      AppMethodBeat.o(141976);
      return false;
    }
    AppMethodBeat.o(141976);
    return true;
  }
  
  private void dPE()
  {
    AppMethodBeat.i(141980);
    ae.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.JFD >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.nnw.setDotCount(this.JFD);
      if ((this.JFv != null) && (this.JFD > 1)) {
        break label137;
      }
      this.nnw.setVisibility(8);
      ae.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.JFz >= this.JFD) {
        this.JFz = (this.JFD - 1);
      }
      this.JFu.acN(this.JFz - this.JFB);
      this.JFu.acO(this.JFz);
      this.nnw.setSelectedDot(this.JFz);
      AppMethodBeat.o(141980);
      return;
      bool = false;
      break;
      label137:
      this.nnw.setVisibility(0);
      ae.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private void fCJ()
  {
    AppMethodBeat.i(141974);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.JFG) && (getScreenOrientation() == 2))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.JFG);
      if (i != localLayoutParams.height)
      {
        ae.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.JFG) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.tvo.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141963);
            ae.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141963);
          }
        });
      }
      AppMethodBeat.o(141974);
      return;
    }
    if ((-1 != this.JFH) && (getScreenOrientation() == 1))
    {
      localView = findViewById(2131300616);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.JFH);
      if (i != localLayoutParams.height)
      {
        ae.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.JFH) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.tvo.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141964);
            ae.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141964);
          }
        });
      }
    }
    AppMethodBeat.o(141974);
  }
  
  private void fCK()
  {
    AppMethodBeat.i(141977);
    ae.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.JFw), Integer.valueOf(this.JFx) });
    if ((this.JFw == 0) || (this.JFx == 0))
    {
      ae.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(141977);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.JFI);
    int i = a.fromDPToPix(getContext(), this.JFJ);
    j = Math.max(this.JFw / j, 1);
    i = Math.max(this.JFx / i, 1);
    if ((j != this.mNumColumns) || (i != this.mNumRows)) {
      this.JFE = true;
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
    this.JFD = 0;
    if (this.JFv == null) {}
    for (i = 0;; i = this.JFv.getCount())
    {
      i += 0;
      if (acP(i)) {
        break;
      }
      fCJ();
      AppMethodBeat.o(141977);
      return;
    }
    this.JFD = jK(i, j);
    this.JFz = Math.min(this.JFD - 1, jL(this.JFy, j));
    this.JFA = Math.min(3, this.JFD);
    this.JFB = Math.min(this.JFD - this.JFA, Math.max(0, this.JFz - (this.JFA >> 1)));
    this.JFC = (this.JFB + this.JFA - 1);
    ae.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.JFI), Integer.valueOf(this.JFJ), Integer.valueOf(this.mNumRows), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.JFA), Integer.valueOf(this.JFD), Integer.valueOf(this.JFz), Integer.valueOf(this.JFB), Integer.valueOf(this.JFC) });
    if ((this.JFu.getChildCount() != this.JFA) || (this.JFE))
    {
      ae.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.JFE) });
      this.JFE = false;
      this.JFu.removeAllViews();
      i = this.JFB;
    }
    while (i <= this.JFC)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), 2131494785, null);
      localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.JFv);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.JDr));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.JDs));
      this.JFu.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.JFB;
      if (i <= this.JFC)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.JFu.getChildAt(i - this.JFB);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          ae.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.JFv);
          localMMGridPaperGridView.notifyDataSetChanged();
        }
        for (;;)
        {
          i += 1;
          break;
          ae.v("MicroMsg.MMGridPaper", "same grid index, continus");
        }
      }
    }
    dPE();
    AppMethodBeat.o(141977);
  }
  
  private void fgN()
  {
    AppMethodBeat.i(141975);
    ae.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.nnw == null)
    {
      this.nnw = ((MMDotView)findViewById(2131300617));
      this.nnw.setMaxCount(this.JFF);
    }
    if (this.JFu == null)
    {
      this.JFu = ((MMFlipper)findViewById(2131300618));
      this.JFu.setOnMeasureListener(this.JFg);
      this.JFu.setOnScreenChangedListener(this.JFe);
    }
    fCJ();
    fCK();
    AppMethodBeat.o(141975);
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(141983);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.JFu.getChildAt(this.JFu.getCurScreen());
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
  
  private static int jK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141978);
    if (paramInt2 <= 0)
    {
      ae.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        ae.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141978);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  private static int jL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141979);
    if ((paramInt1 == 0) || (paramInt2 <= 0))
    {
      ae.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        ae.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141979);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  public final void fCH()
  {
    this.JFN = 3;
    this.JFM = 3;
  }
  
  public final void fCI()
  {
    this.JDr = 8;
    this.JDs = 15;
  }
  
  public final int getItemsCountPerPage()
  {
    return this.mNumRows * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.JFD;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141982);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ae.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.JFK = true;
    }
    AppMethodBeat.o(141982);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141981);
    ae.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mCurrentOrientation != getScreenOrientation())
    {
      this.mCurrentOrientation = getScreenOrientation();
      ae.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
      this.JFK = true;
      clearAnimation();
      fCJ();
      fCK();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141981);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(141972);
    this.JFy = (this.JFz * this.mNumColumns * this.mNumRows);
    ae.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.JFz), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.mNumRows), Integer.valueOf(this.JFy) });
    fgN();
    AppMethodBeat.o(141972);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.JFL = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.JFG = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.JFH = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.JFx = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(141971);
    this.JFv = paramj;
    if (paramj == null) {}
    for (;;)
    {
      ae.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.JFv != null) {
        this.JFv.JFV = new j.a()
        {
          public final void bPl()
          {
            AppMethodBeat.i(141962);
            MMGridPaper.this.refresh();
            AppMethodBeat.o(141962);
          }
        };
      }
      fgN();
      AppMethodBeat.o(141971);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.JFw = paramInt;
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
    this.JFJ = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.JFI = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.JFO = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.mMaxColumns = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.JFF = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.mMaxRows = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.JFR = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */