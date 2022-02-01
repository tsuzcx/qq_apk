package com.tencent.mm.ui.base;

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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected MMHandler NBu;
  protected int adOr;
  protected int adOs;
  protected int adQA;
  protected int adQB;
  protected int adQC;
  protected int adQD;
  protected int adQE;
  protected int adQF;
  protected boolean adQG;
  protected int adQH;
  protected int adQI;
  protected int adQJ;
  protected int adQK;
  protected int adQL;
  protected boolean adQM;
  protected boolean adQN;
  protected int adQO;
  protected int adQP;
  protected boolean adQQ;
  protected int adQR;
  protected int adQS;
  protected a adQT;
  final MMFlipper.c adQf;
  final MMFlipper.b adQh;
  protected MMFlipper adQw;
  protected l adQx;
  protected int adQy;
  protected int adQz;
  protected int bgE;
  protected int bgI;
  protected int bgJ;
  protected int mCurrentOrientation;
  protected int mNumColumns;
  protected View nJ;
  protected MMDotView xUq;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141969);
    this.adQA = 0;
    this.adQB = 0;
    this.adQC = 3;
    this.adQD = 0;
    this.adQE = (this.adQC - 1);
    this.adQF = 0;
    this.mNumColumns = 0;
    this.bgI = 0;
    this.adQG = false;
    this.adQH = 9;
    this.adQI = -1;
    this.adQJ = -1;
    this.adQK = 96;
    this.adQL = 96;
    this.adOr = 10;
    this.adOs = 10;
    this.adQM = false;
    this.adQN = false;
    this.adQO = -1;
    this.adQP = -1;
    this.mCurrentOrientation = 0;
    this.bgE = -1;
    this.bgJ = -1;
    this.adQQ = false;
    this.adQR = 0;
    this.adQS = 0;
    this.adQh = new MMFlipper.b()
    {
      public final void kS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(141965);
        Log.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.adQy), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.adQz), Boolean.valueOf(MMGridPaper.this.adQN), Boolean.valueOf(MMGridPaper.this.adQM) });
        if (((Math.abs(MMGridPaper.this.adQz - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.adQy - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          Log.d("MicroMsg.MMGridPaper", "match width height limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        if ((MMGridPaper.this.adQN) && (MMGridPaper.this.adQy > paramAnonymousInt1) && (!MMGridPaper.this.adQM))
        {
          Log.d("MicroMsg.MMGridPaper", "match ori limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        Log.v("MicroMsg.MMGridPaper", "onMeasure: match");
        Log.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.adQQ) });
        MMGridPaper.this.adQM = false;
        if (!MMGridPaper.this.adQQ)
        {
          MMGridPaper.this.adQz = paramAnonymousInt2;
          MMGridPaper.this.adQy = paramAnonymousInt1;
        }
        MMGridPaper.this.bDL();
        AppMethodBeat.o(141965);
      }
    };
    this.adQf = new MMFlipper.c()
    {
      public final void onScreenChanged(int paramAnonymousInt1, final int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164148);
        Log.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.adQD), Integer.valueOf(MMGridPaper.this.adQE), Integer.valueOf(MMGridPaper.this.adQF) });
        if ((paramAnonymousInt2 <= MMGridPaper.this.adQD) && (MMGridPaper.this.adQD > 0)) {
          MMGridPaper.this.NBu.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141966);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.adQw.getChildAt(MMGridPaper.this.adQw.getChildCount() - 1);
              int i = paramAnonymousInt2 - (MMGridPaper.this.adQw.getChildCount() >> 1);
              Log.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.adQw.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.adQw.removeViewAt(MMGridPaper.this.adQw.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.bgI, MMGridPaper.this.mNumColumns, MMGridPaper.this.adQx);
              MMGridPaper.this.adQw.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.adQw.getChildCount();
              MMGridPaper.this.adQw.aAR(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              AppMethodBeat.o(141966);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.adQB = paramAnonymousInt2;
          MMGridPaper.this.xUq.setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(164148);
          return;
          if ((paramAnonymousInt2 >= MMGridPaper.this.adQE) && (MMGridPaper.this.adQE < MMGridPaper.this.adQF - 1)) {
            MMGridPaper.this.NBu.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141967);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.adQw.getChildAt(0);
                int i = paramAnonymousInt2 + (MMGridPaper.this.adQw.getChildCount() >> 1);
                Log.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.adQw.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.bgI, MMGridPaper.this.mNumColumns, MMGridPaper.this.adQx);
                MMGridPaper.this.adQw.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.adQw.getChildCount();
                MMGridPaper.this.adQw.aAR(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                AppMethodBeat.o(141967);
              }
            });
          }
        }
      }
    };
    this.NBu = new MMHandler(Looper.getMainLooper());
    View.inflate(getContext(), a.h.mm_gridpaper, this);
    this.mCurrentOrientation = getScreenOrientation();
    AppMethodBeat.o(141969);
  }
  
  private boolean aAT(int paramInt)
  {
    AppMethodBeat.i(141976);
    Log.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.adQN) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.adQN) {
        break;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    int i = of(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(141976);
      return true;
    case 2: 
      i = Math.min(i, this.adQP);
      j = (this.adQL + 10) * i + 8;
      Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.adQI), Boolean.valueOf(this.adQM) });
      if (this.adQI != j)
      {
        this.adQI = j;
        AppMethodBeat.o(141976);
        return false;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    i = Math.min(i, this.adQO);
    int j = (this.adQL + 10) * i + 8;
    Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.adQJ), Boolean.valueOf(this.adQM) });
    if (this.adQJ != j)
    {
      this.adQJ = j;
      AppMethodBeat.o(141976);
      return false;
    }
    AppMethodBeat.o(141976);
    return true;
  }
  
  private void gTc()
  {
    AppMethodBeat.i(141980);
    Log.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.adQF >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.xUq.setDotCount(this.adQF);
      if ((this.adQx != null) && (this.adQF > 1)) {
        break label137;
      }
      this.xUq.setVisibility(8);
      Log.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.adQB >= this.adQF) {
        this.adQB = (this.adQF - 1);
      }
      this.adQw.aAR(this.adQB - this.adQD);
      this.adQw.aAS(this.adQB);
      this.xUq.setSelectedDot(this.adQB);
      AppMethodBeat.o(141980);
      return;
      bool = false;
      break;
      label137:
      this.xUq.setVisibility(0);
      Log.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(141983);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.adQw.getChildAt(this.adQw.getCurScreen());
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
  
  private void iLM()
  {
    AppMethodBeat.i(141975);
    Log.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.xUq == null)
    {
      this.xUq = ((MMDotView)findViewById(a.g.gridpaper_dot));
      this.xUq.setMaxCount(this.adQH);
    }
    if (this.adQw == null)
    {
      this.adQw = ((MMFlipper)findViewById(a.g.gridpaper_flipper));
      this.adQw.setOnMeasureListener(this.adQh);
      this.adQw.setOnScreenChangedListener(this.adQf);
    }
    jml();
    jmm();
    AppMethodBeat.o(141975);
  }
  
  private void jml()
  {
    AppMethodBeat.i(141974);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.adQI) && (getScreenOrientation() == 2))
    {
      localView = findViewById(a.g.gridpaper_display_view);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.adQI);
      if (i != localLayoutParams.height)
      {
        Log.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.adQI) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.NBu.post(new Runnable()
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
    if ((-1 != this.adQJ) && (getScreenOrientation() == 1))
    {
      localView = findViewById(a.g.gridpaper_display_view);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.adQJ);
      if (i != localLayoutParams.height)
      {
        Log.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.adQJ) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.NBu.post(new Runnable()
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
  
  private void jmm()
  {
    AppMethodBeat.i(141977);
    Log.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.adQy), Integer.valueOf(this.adQz) });
    if ((this.adQy == 0) || (this.adQz == 0))
    {
      Log.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(141977);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.adQK);
    int i = a.fromDPToPix(getContext(), this.adQL);
    j = Math.max(this.adQy / j, 1);
    i = Math.max(this.adQz / i, 1);
    if ((j != this.mNumColumns) || (i != this.bgI)) {
      this.adQG = true;
    }
    this.mNumColumns = j;
    if (this.bgE != -1) {
      this.mNumColumns = Math.min(this.mNumColumns, this.bgE);
    }
    this.bgI = i;
    if (this.bgJ != -1) {
      this.bgI = Math.min(this.bgI, this.bgJ);
    }
    i = this.mNumColumns;
    j = this.bgI * i;
    this.adQF = 0;
    if (this.adQx == null) {}
    for (i = 0;; i = this.adQx.getCount())
    {
      i += 0;
      if (aAT(i)) {
        break;
      }
      jml();
      AppMethodBeat.o(141977);
      return;
    }
    this.adQF = of(i, j);
    this.adQB = Math.min(this.adQF - 1, og(this.adQA, j));
    this.adQC = Math.min(3, this.adQF);
    this.adQD = Math.min(this.adQF - this.adQC, Math.max(0, this.adQB - (this.adQC >> 1)));
    this.adQE = (this.adQD + this.adQC - 1);
    Log.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.adQK), Integer.valueOf(this.adQL), Integer.valueOf(this.bgI), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.adQC), Integer.valueOf(this.adQF), Integer.valueOf(this.adQB), Integer.valueOf(this.adQD), Integer.valueOf(this.adQE) });
    if ((this.adQw.getChildCount() != this.adQC) || (this.adQG))
    {
      Log.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.adQG) });
      this.adQG = false;
      this.adQw.removeAllViews();
      i = this.adQD;
    }
    while (i <= this.adQE)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), a.h.mm_drap_drop_gridview, null);
      localMMGridPaperGridView.a(i, this.bgI, this.mNumColumns, this.adQx);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.adOr));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.adOs));
      this.adQw.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.adQD;
      if (i <= this.adQE)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.adQw.getChildAt(i - this.adQD);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          Log.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.bgI, this.mNumColumns, this.adQx);
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
    gTc();
    AppMethodBeat.o(141977);
  }
  
  private static int of(int paramInt1, int paramInt2)
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
  
  private static int og(int paramInt1, int paramInt2)
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
  
  public final void bDL()
  {
    AppMethodBeat.i(141972);
    this.adQA = (this.adQB * this.mNumColumns * this.bgI);
    Log.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.adQB), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.bgI), Integer.valueOf(this.adQA) });
    iLM();
    AppMethodBeat.o(141972);
  }
  
  public final int getItemsCountPerPage()
  {
    return this.bgI * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.adQF;
  }
  
  public final void jmj()
  {
    this.adQP = 3;
    this.adQO = 3;
  }
  
  public final void jmk()
  {
    this.adOr = 8;
    this.adOs = 15;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141982);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      Log.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.adQM = true;
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
      this.adQM = true;
      clearAnimation();
      jml();
      jmm();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141981);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.adQN = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.adQI = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.adQJ = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.adQz = paramInt;
  }
  
  public final void setGridPaperAdapter(l paraml)
  {
    boolean bool = true;
    AppMethodBeat.i(141971);
    this.adQx = paraml;
    if (paraml == null) {}
    for (;;)
    {
      Log.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.adQx != null) {
        this.adQx.adQX = new l.a()
        {
          public final void dcZ()
          {
            AppMethodBeat.i(141962);
            MMGridPaper.this.bDL();
            AppMethodBeat.o(141962);
          }
        };
      }
      iLM();
      AppMethodBeat.o(141971);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.adQy = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(141970);
    this.nJ = paramView;
    paramView = (ViewGroup)findViewById(a.g.header_area);
    paramView.removeAllViews();
    if (this.nJ != null) {
      paramView.addView(this.nJ);
    }
    AppMethodBeat.o(141970);
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.adQL = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.adQK = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.adQQ = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.bgE = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.adQH = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.bgJ = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.adQT = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */