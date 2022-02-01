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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected int OOj;
  protected int OOk;
  final MMFlipper.c OPW;
  final MMFlipper.b OPY;
  protected int OQA;
  protected int OQB;
  protected boolean OQC;
  protected boolean OQD;
  protected int OQE;
  protected int OQF;
  protected boolean OQG;
  protected int OQH;
  protected int OQI;
  protected a OQJ;
  protected MMFlipper OQm;
  protected j OQn;
  protected int OQo;
  protected int OQp;
  protected int OQq;
  protected int OQr;
  protected int OQs;
  protected int OQt;
  protected int OQu;
  protected int OQv;
  protected boolean OQw;
  protected int OQx;
  protected int OQy;
  protected int OQz;
  protected View agA;
  protected int mCurrentOrientation;
  protected int mMaxColumns;
  protected int mMaxRows;
  protected int mNumColumns;
  protected int mNumRows;
  protected MMDotView oxc;
  protected MMHandler wMu;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141969);
    this.OQq = 0;
    this.OQr = 0;
    this.OQs = 3;
    this.OQt = 0;
    this.OQu = (this.OQs - 1);
    this.OQv = 0;
    this.mNumColumns = 0;
    this.mNumRows = 0;
    this.OQw = false;
    this.OQx = 9;
    this.OQy = -1;
    this.OQz = -1;
    this.OQA = 96;
    this.OQB = 96;
    this.OOj = 10;
    this.OOk = 10;
    this.OQC = false;
    this.OQD = false;
    this.OQE = -1;
    this.OQF = -1;
    this.mCurrentOrientation = 0;
    this.mMaxColumns = -1;
    this.mMaxRows = -1;
    this.OQG = false;
    this.OQH = 0;
    this.OQI = 0;
    this.OPY = new MMFlipper.b()
    {
      public final void ig(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(141965);
        Log.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.OQo), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.OQp), Boolean.valueOf(MMGridPaper.this.OQD), Boolean.valueOf(MMGridPaper.this.OQC) });
        if (((Math.abs(MMGridPaper.this.OQp - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.OQo - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          Log.d("MicroMsg.MMGridPaper", "match width height limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        if ((MMGridPaper.this.OQD) && (MMGridPaper.this.OQo > paramAnonymousInt1) && (!MMGridPaper.this.OQC))
        {
          Log.d("MicroMsg.MMGridPaper", "match ori limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        Log.v("MicroMsg.MMGridPaper", "onMeasure: match");
        Log.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.OQG) });
        MMGridPaper.this.OQC = false;
        if (!MMGridPaper.this.OQG)
        {
          MMGridPaper.this.OQp = paramAnonymousInt2;
          MMGridPaper.this.OQo = paramAnonymousInt1;
        }
        MMGridPaper.this.refresh();
        AppMethodBeat.o(141965);
      }
    };
    this.OPW = new MMFlipper.c()
    {
      public final void z(int paramAnonymousInt1, final int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164148);
        Log.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.OQt), Integer.valueOf(MMGridPaper.this.OQu), Integer.valueOf(MMGridPaper.this.OQv) });
        if ((paramAnonymousInt2 <= MMGridPaper.this.OQt) && (MMGridPaper.this.OQt > 0)) {
          MMGridPaper.this.wMu.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141966);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.OQm.getChildAt(MMGridPaper.this.OQm.getChildCount() - 1);
              int i = paramAnonymousInt2 - (MMGridPaper.this.OQm.getChildCount() >> 1);
              Log.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.OQm.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.OQm.removeViewAt(MMGridPaper.this.OQm.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.OQn);
              MMGridPaper.this.OQm.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.OQm.getChildCount();
              MMGridPaper.this.OQm.alx(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              AppMethodBeat.o(141966);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.OQr = paramAnonymousInt2;
          MMGridPaper.this.oxc.setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(164148);
          return;
          if ((paramAnonymousInt2 >= MMGridPaper.this.OQu) && (MMGridPaper.this.OQu < MMGridPaper.this.OQv - 1)) {
            MMGridPaper.this.wMu.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141967);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.OQm.getChildAt(0);
                int i = paramAnonymousInt2 + (MMGridPaper.this.OQm.getChildCount() >> 1);
                Log.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.OQm.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.mNumRows, MMGridPaper.this.mNumColumns, MMGridPaper.this.OQn);
                MMGridPaper.this.OQm.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.OQm.getChildCount();
                MMGridPaper.this.OQm.alx(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                AppMethodBeat.o(141967);
              }
            });
          }
        }
      }
    };
    this.wMu = new MMHandler(Looper.getMainLooper());
    View.inflate(getContext(), 2131495529, this);
    this.mCurrentOrientation = getScreenOrientation();
    AppMethodBeat.o(141969);
  }
  
  private boolean alz(int paramInt)
  {
    AppMethodBeat.i(141976);
    Log.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.OQD) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.OQD) {
        break;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    int i = kT(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(141976);
      return true;
    case 2: 
      i = Math.min(i, this.OQF);
      j = (this.OQB + 10) * i + 8;
      Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.OQy), Boolean.valueOf(this.OQC) });
      if (this.OQy != j)
      {
        this.OQy = j;
        AppMethodBeat.o(141976);
        return false;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    i = Math.min(i, this.OQE);
    int j = (this.OQB + 10) * i + 8;
    Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.OQz), Boolean.valueOf(this.OQC) });
    if (this.OQz != j)
    {
      this.OQz = j;
      AppMethodBeat.o(141976);
      return false;
    }
    AppMethodBeat.o(141976);
    return true;
  }
  
  private void eRp()
  {
    AppMethodBeat.i(141980);
    Log.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.OQv >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.oxc.setDotCount(this.OQv);
      if ((this.OQn != null) && (this.OQv > 1)) {
        break label137;
      }
      this.oxc.setVisibility(8);
      Log.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.OQr >= this.OQv) {
        this.OQr = (this.OQv - 1);
      }
      this.OQm.alx(this.OQr - this.OQt);
      this.OQm.aly(this.OQr);
      this.oxc.setSelectedDot(this.OQr);
      AppMethodBeat.o(141980);
      return;
      bool = false;
      break;
      label137:
      this.oxc.setVisibility(0);
      Log.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private void gKI()
  {
    AppMethodBeat.i(141974);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.OQy) && (getScreenOrientation() == 2))
    {
      localView = findViewById(2131302171);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.OQy);
      if (i != localLayoutParams.height)
      {
        Log.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.OQy) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.wMu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141963);
            Log.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141963);
          }
        });
      }
      AppMethodBeat.o(141974);
      return;
    }
    if ((-1 != this.OQz) && (getScreenOrientation() == 1))
    {
      localView = findViewById(2131302171);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.OQz);
      if (i != localLayoutParams.height)
      {
        Log.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.OQz) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.wMu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(141964);
            Log.w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.a(MMGridPaper.this);
            AppMethodBeat.o(141964);
          }
        });
      }
    }
    AppMethodBeat.o(141974);
  }
  
  private void gKJ()
  {
    AppMethodBeat.i(141977);
    Log.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.OQo), Integer.valueOf(this.OQp) });
    if ((this.OQo == 0) || (this.OQp == 0))
    {
      Log.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(141977);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.OQA);
    int i = a.fromDPToPix(getContext(), this.OQB);
    j = Math.max(this.OQo / j, 1);
    i = Math.max(this.OQp / i, 1);
    if ((j != this.mNumColumns) || (i != this.mNumRows)) {
      this.OQw = true;
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
    this.OQv = 0;
    if (this.OQn == null) {}
    for (i = 0;; i = this.OQn.getCount())
    {
      i += 0;
      if (alz(i)) {
        break;
      }
      gKI();
      AppMethodBeat.o(141977);
      return;
    }
    this.OQv = kT(i, j);
    this.OQr = Math.min(this.OQv - 1, kU(this.OQq, j));
    this.OQs = Math.min(3, this.OQv);
    this.OQt = Math.min(this.OQv - this.OQs, Math.max(0, this.OQr - (this.OQs >> 1)));
    this.OQu = (this.OQt + this.OQs - 1);
    Log.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.OQA), Integer.valueOf(this.OQB), Integer.valueOf(this.mNumRows), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.OQs), Integer.valueOf(this.OQv), Integer.valueOf(this.OQr), Integer.valueOf(this.OQt), Integer.valueOf(this.OQu) });
    if ((this.OQm.getChildCount() != this.OQs) || (this.OQw))
    {
      Log.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.OQw) });
      this.OQw = false;
      this.OQm.removeAllViews();
      i = this.OQt;
    }
    while (i <= this.OQu)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), 2131495519, null);
      localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.OQn);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.OOj));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.OOk));
      this.OQm.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.OQt;
      if (i <= this.OQu)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.OQm.getChildAt(i - this.OQt);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          Log.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.mNumRows, this.mNumColumns, this.OQn);
          localMMGridPaperGridView.notifyDataSetChanged();
        }
        for (;;)
        {
          i += 1;
          break;
          Log.v("MicroMsg.MMGridPaper", "same grid index, continus");
        }
      }
    }
    eRp();
    AppMethodBeat.o(141977);
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(141983);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.OQm.getChildAt(this.OQm.getCurScreen());
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
  
  private void gpW()
  {
    AppMethodBeat.i(141975);
    Log.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.oxc == null)
    {
      this.oxc = ((MMDotView)findViewById(2131302172));
      this.oxc.setMaxCount(this.OQx);
    }
    if (this.OQm == null)
    {
      this.OQm = ((MMFlipper)findViewById(2131302173));
      this.OQm.setOnMeasureListener(this.OPY);
      this.OQm.setOnScreenChangedListener(this.OPW);
    }
    gKI();
    gKJ();
    AppMethodBeat.o(141975);
  }
  
  private static int kT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141978);
    if (paramInt2 <= 0)
    {
      Log.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        Log.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141978);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  private static int kU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141979);
    if ((paramInt1 == 0) || (paramInt2 <= 0))
    {
      Log.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
        Log.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        AppMethodBeat.o(141979);
        return i;
        j = paramInt1;
        i = 0;
      }
    }
  }
  
  public final void gKG()
  {
    this.OQF = 3;
    this.OQE = 3;
  }
  
  public final void gKH()
  {
    this.OOj = 8;
    this.OOk = 15;
  }
  
  public final int getItemsCountPerPage()
  {
    return this.mNumRows * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.OQv;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141982);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      Log.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.OQC = true;
    }
    AppMethodBeat.o(141982);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141981);
    Log.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.mCurrentOrientation != getScreenOrientation())
    {
      this.mCurrentOrientation = getScreenOrientation();
      Log.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
      this.OQC = true;
      clearAnimation();
      gKI();
      gKJ();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141981);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(141972);
    this.OQq = (this.OQr * this.mNumColumns * this.mNumRows);
    Log.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.OQr), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.mNumRows), Integer.valueOf(this.OQq) });
    gpW();
    AppMethodBeat.o(141972);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.OQD = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.OQy = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.OQz = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.OQp = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(141971);
    this.OQn = paramj;
    if (paramj == null) {}
    for (;;)
    {
      Log.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.OQn != null) {
        this.OQn.OQN = new j.a()
        {
          public final void cmy()
          {
            AppMethodBeat.i(141962);
            MMGridPaper.this.refresh();
            AppMethodBeat.o(141962);
          }
        };
      }
      gpW();
      AppMethodBeat.o(141971);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.OQo = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(141970);
    this.agA = paramView;
    paramView = (ViewGroup)findViewById(2131302277);
    paramView.removeAllViews();
    if (this.agA != null) {
      paramView.addView(this.agA);
    }
    AppMethodBeat.o(141970);
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.OQB = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.OQA = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.OQG = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.mMaxColumns = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.OQx = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.mMaxRows = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.OQJ = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */