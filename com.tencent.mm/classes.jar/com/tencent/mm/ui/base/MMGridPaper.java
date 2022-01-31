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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected View Ww;
  protected int hkz;
  protected MMDotView jpZ;
  protected ak mHV;
  protected int mMaxColumns;
  protected int mMaxRows;
  protected int mNumColumns;
  protected int mNumRows;
  protected int zhv;
  protected int zhw;
  protected MMFlipper zjD;
  protected j zjE;
  protected int zjF;
  protected int zjG;
  protected int zjH;
  protected int zjI;
  protected int zjJ;
  protected int zjK;
  protected int zjL;
  protected int zjM;
  protected boolean zjN;
  protected int zjO;
  protected int zjP;
  protected int zjQ;
  protected int zjR;
  protected int zjS;
  protected boolean zjT;
  protected boolean zjU;
  protected int zjV;
  protected int zjW;
  protected boolean zjX;
  protected int zjY;
  protected int zjZ;
  final MMFlipper.b zji;
  final MMFlipper.a zjj;
  protected a zka;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106623);
    this.zjH = 0;
    this.zjI = 0;
    this.zjJ = 3;
    this.zjK = 0;
    this.zjL = (this.zjJ - 1);
    this.zjM = 0;
    this.mNumColumns = 0;
    this.mNumRows = 0;
    this.zjN = false;
    this.zjO = 9;
    this.zjP = -1;
    this.zjQ = -1;
    this.zjR = 96;
    this.zjS = 96;
    this.zhv = 10;
    this.zhw = 10;
    this.zjT = false;
    this.zjU = false;
    this.zjV = -1;
    this.zjW = -1;
    this.hkz = 0;
    this.mMaxColumns = -1;
    this.mMaxRows = -1;
    this.zjX = false;
    this.zjY = 0;
    this.zjZ = 0;
    this.zjj = new MMGridPaper.4(this);
    this.zji = new MMGridPaper.5(this);
    this.mHV = new ak(Looper.getMainLooper());
    View.inflate(getContext(), 2130970171, this);
    this.hkz = getScreenOrientation();
    AppMethodBeat.o(106623);
  }
  
  private boolean OH(int paramInt)
  {
    AppMethodBeat.i(106630);
    ab.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.zjU) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.zjU) {
        break;
      }
      AppMethodBeat.o(106630);
      return true;
    }
    int i = hv(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(106630);
      return true;
    case 2: 
      i = Math.min(i, this.zjW);
      j = (this.zjS + 10) * i + 8;
      ab.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.zjP), Boolean.valueOf(this.zjT) });
      if (this.zjP != j)
      {
        this.zjP = j;
        AppMethodBeat.o(106630);
        return false;
      }
      AppMethodBeat.o(106630);
      return true;
    }
    i = Math.min(i, this.zjV);
    int j = (this.zjS + 10) * i + 8;
    ab.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.zjQ), Boolean.valueOf(this.zjT) });
    if (this.zjQ != j)
    {
      this.zjQ = j;
      AppMethodBeat.o(106630);
      return false;
    }
    AppMethodBeat.o(106630);
    return true;
  }
  
  private void cjk()
  {
    AppMethodBeat.i(106634);
    ab.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.zjM >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.jpZ.setDotCount(this.zjM);
      if ((this.zjE != null) && (this.zjM > 1)) {
        break label137;
      }
      this.jpZ.setVisibility(8);
      ab.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.zjI >= this.zjM) {
        this.zjI = (this.zjM - 1);
      }
      this.zjD.OF(this.zjI - this.zjK);
      this.zjD.OG(this.zjI);
      this.jpZ.setSelectedDot(this.zjI);
      AppMethodBeat.o(106634);
      return;
      bool = false;
      break;
      label137:
      this.jpZ.setVisibility(0);
      ab.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private void dDU()
  {
    AppMethodBeat.i(106628);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.zjP) && (getScreenOrientation() == 2))
    {
      localView = findViewById(2131826180);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.zjP);
      if (i != localLayoutParams.height)
      {
        ab.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.zjP) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.mHV.post(new MMGridPaper.2(this));
      }
      AppMethodBeat.o(106628);
      return;
    }
    if ((-1 != this.zjQ) && (getScreenOrientation() == 1))
    {
      localView = findViewById(2131826180);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.zjQ);
      if (i != localLayoutParams.height)
      {
        ab.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.zjQ) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.mHV.post(new MMGridPaper.3(this));
      }
    }
    AppMethodBeat.o(106628);
  }
  
  private void dDV()
  {
    AppMethodBeat.i(106631);
    ab.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.zjF), Integer.valueOf(this.zjG) });
    if ((this.zjF == 0) || (this.zjG == 0))
    {
      ab.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(106631);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.zjR);
    int i = a.fromDPToPix(getContext(), this.zjS);
    j = Math.max(this.zjF / j, 1);
    i = Math.max(this.zjG / i, 1);
    if ((j != this.mNumColumns) || (i != this.mNumRows)) {
      this.zjN = true;
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
    this.zjM = 0;
    if (this.zjE == null) {}
    for (i = 0;; i = this.zjE.getCount())
    {
      i += 0;
      if (OH(i)) {
        break;
      }
      dDU();
      AppMethodBeat.o(106631);
      return;
    }
    this.zjM = hv(i, j);
    this.zjI = Math.min(this.zjM - 1, hw(this.zjH, j));
    this.zjJ = Math.min(3, this.zjM);
    this.zjK = Math.min(this.zjM - this.zjJ, Math.max(0, this.zjI - (this.zjJ >> 1)));
    this.zjL = (this.zjK + this.zjJ - 1);
    ab.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.zjR), Integer.valueOf(this.zjS), Integer.valueOf(this.mNumRows), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.zjJ), Integer.valueOf(this.zjM), Integer.valueOf(this.zjI), Integer.valueOf(this.zjK), Integer.valueOf(this.zjL) });
    if ((this.zjD.getChildCount() != this.zjJ) || (this.zjN))
    {
      ab.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.zjN) });
      this.zjN = false;
      this.zjD.removeAllViews();
      i = this.zjK;
    }
    while (i <= this.zjL)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), 2130970162, null);
      localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.zjE);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.zhv));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.zhw));
      this.zjD.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.zjK;
      if (i <= this.zjL)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.zjD.getChildAt(i - this.zjK);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          ab.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.zjE);
          localMMGridPaperGridView.notifyDataSetChanged();
        }
        for (;;)
        {
          i += 1;
          break;
          ab.v("MicroMsg.MMGridPaper", "same grid index, continus");
        }
      }
    }
    cjk();
    AppMethodBeat.o(106631);
  }
  
  private void dnU()
  {
    AppMethodBeat.i(106629);
    ab.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.jpZ == null)
    {
      this.jpZ = ((MMDotView)findViewById(2131826182));
      this.jpZ.setMaxCount(this.zjO);
    }
    if (this.zjD == null)
    {
      this.zjD = ((MMFlipper)findViewById(2131826181));
      this.zjD.setOnMeasureListener(this.zjj);
      this.zjD.setOnScreenChangedListener(this.zji);
    }
    dDU();
    dDV();
    AppMethodBeat.o(106629);
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(106637);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.zjD.getChildAt(this.zjD.getCurScreen());
    AppMethodBeat.o(106637);
    return localMMGridPaperGridView;
  }
  
  private int getScreenOrientation()
  {
    AppMethodBeat.i(106627);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {}
    for (int i = 1;; i = 2)
    {
      AppMethodBeat.o(106627);
      return i;
    }
  }
  
  private static int hv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106632);
    if (paramInt2 <= 0)
    {
      ab.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(106632);
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
        ab.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(106632);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  private static int hw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106633);
    if ((paramInt1 == 0) || (paramInt2 <= 0))
    {
      ab.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(106633);
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
        ab.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(106633);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  public final void dDS()
  {
    this.zjW = 3;
    this.zjV = 3;
  }
  
  public final void dDT()
  {
    this.zhv = 8;
    this.zhw = 15;
  }
  
  public final int getItemsCountPerPage()
  {
    return this.mNumRows * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.zjM;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106636);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ab.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.zjT = true;
    }
    AppMethodBeat.o(106636);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106635);
    ab.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.hkz != getScreenOrientation())
    {
      this.hkz = getScreenOrientation();
      ab.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
      this.zjT = true;
      clearAnimation();
      dDU();
      dDV();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(106635);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(106626);
    this.zjH = (this.zjI * this.mNumColumns * this.mNumRows);
    ab.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.zjI), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.mNumRows), Integer.valueOf(this.zjH) });
    dnU();
    AppMethodBeat.o(106626);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.zjU = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.zjP = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.zjQ = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.zjG = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(106625);
    this.zjE = paramj;
    if (paramj == null) {}
    for (;;)
    {
      ab.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.zjE != null) {
        this.zjE.zke = new MMGridPaper.1(this);
      }
      dnU();
      AppMethodBeat.o(106625);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.zjF = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(106624);
    this.Ww = paramView;
    paramView = (ViewGroup)findViewById(2131821060);
    paramView.removeAllViews();
    if (this.Ww != null) {
      paramView.addView(this.Ww);
    }
    AppMethodBeat.o(106624);
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.zjS = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.zjR = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.zjX = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.mMaxColumns = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.zjO = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.mMaxRows = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.zka = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */