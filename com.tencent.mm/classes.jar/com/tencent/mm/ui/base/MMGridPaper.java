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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import junit.framework.Assert;

public final class MMGridPaper
  extends LinearLayout
{
  protected int AA;
  protected int AB;
  protected int Aw;
  protected MMHandler HDS;
  protected int Whu;
  protected int Whv;
  protected int WjA;
  protected int WjB;
  protected int WjC;
  protected boolean WjD;
  protected int WjE;
  protected int WjF;
  protected int WjG;
  protected int WjH;
  protected int WjI;
  protected boolean WjJ;
  protected boolean WjK;
  protected int WjL;
  protected int WjM;
  protected boolean WjN;
  protected int WjO;
  protected int WjP;
  protected a WjQ;
  final MMFlipper.c Wjd;
  final MMFlipper.b Wjf;
  protected MMFlipper Wjt;
  protected j Wju;
  protected int Wjv;
  protected int Wjw;
  protected int Wjx;
  protected int Wjy;
  protected int Wjz;
  protected int mCurrentOrientation;
  protected View mL;
  protected int mNumColumns;
  protected MMDotView uLP;
  
  public MMGridPaper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141969);
    this.Wjx = 0;
    this.Wjy = 0;
    this.Wjz = 3;
    this.WjA = 0;
    this.WjB = (this.Wjz - 1);
    this.WjC = 0;
    this.mNumColumns = 0;
    this.AA = 0;
    this.WjD = false;
    this.WjE = 9;
    this.WjF = -1;
    this.WjG = -1;
    this.WjH = 96;
    this.WjI = 96;
    this.Whu = 10;
    this.Whv = 10;
    this.WjJ = false;
    this.WjK = false;
    this.WjL = -1;
    this.WjM = -1;
    this.mCurrentOrientation = 0;
    this.Aw = -1;
    this.AB = -1;
    this.WjN = false;
    this.WjO = 0;
    this.WjP = 0;
    this.Wjf = new MMFlipper.b()
    {
      public final void jl(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(141965);
        Log.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(MMGridPaper.this.Wjv), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.Wjw), Boolean.valueOf(MMGridPaper.this.WjK), Boolean.valueOf(MMGridPaper.this.WjJ) });
        if (((Math.abs(MMGridPaper.this.Wjw - paramAnonymousInt2) < 50) && (Math.abs(MMGridPaper.this.Wjv - paramAnonymousInt1) < 50)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          Log.d("MicroMsg.MMGridPaper", "match width height limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        if ((MMGridPaper.this.WjK) && (MMGridPaper.this.Wjv > paramAnonymousInt1) && (!MMGridPaper.this.WjJ))
        {
          Log.d("MicroMsg.MMGridPaper", "match ori limit, return");
          AppMethodBeat.o(141965);
          return;
        }
        Log.v("MicroMsg.MMGridPaper", "onMeasure: match");
        Log.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", new Object[] { Boolean.valueOf(MMGridPaper.this.WjN) });
        MMGridPaper.this.WjJ = false;
        if (!MMGridPaper.this.WjN)
        {
          MMGridPaper.this.Wjw = paramAnonymousInt2;
          MMGridPaper.this.Wjv = paramAnonymousInt1;
        }
        MMGridPaper.this.bfU();
        AppMethodBeat.o(141965);
      }
    };
    this.Wjd = new MMFlipper.c()
    {
      public final void E(int paramAnonymousInt1, final int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(164148);
        Log.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(MMGridPaper.this.WjA), Integer.valueOf(MMGridPaper.this.WjB), Integer.valueOf(MMGridPaper.this.WjC) });
        if ((paramAnonymousInt2 <= MMGridPaper.this.WjA) && (MMGridPaper.this.WjA > 0)) {
          MMGridPaper.this.HDS.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141966);
              MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.Wjt.getChildAt(MMGridPaper.this.Wjt.getChildCount() - 1);
              int i = paramAnonymousInt2 - (MMGridPaper.this.Wjt.getChildCount() >> 1);
              Log.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", new Object[] { Integer.valueOf(MMGridPaper.this.Wjt.getChildCount() - 1), Integer.valueOf(i) });
              MMGridPaper.this.Wjt.removeViewAt(MMGridPaper.this.Wjt.getChildCount() - 1);
              localMMGridPaperGridView.a(i, MMGridPaper.this.AA, MMGridPaper.this.mNumColumns, MMGridPaper.this.Wju);
              MMGridPaper.this.Wjt.addView(localMMGridPaperGridView, 0);
              i = MMGridPaper.this.Wjt.getChildCount();
              MMGridPaper.this.Wjt.auv(i >> 1);
              MMGridPaper.a(MMGridPaper.this, -1);
              AppMethodBeat.o(141966);
            }
          });
        }
        for (;;)
        {
          MMGridPaper.this.Wjy = paramAnonymousInt2;
          MMGridPaper.this.uLP.setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(164148);
          return;
          if ((paramAnonymousInt2 >= MMGridPaper.this.WjB) && (MMGridPaper.this.WjB < MMGridPaper.this.WjC - 1)) {
            MMGridPaper.this.HDS.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(141967);
                MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)MMGridPaper.this.Wjt.getChildAt(0);
                int i = paramAnonymousInt2 + (MMGridPaper.this.Wjt.getChildCount() >> 1);
                Log.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", new Object[] { Integer.valueOf(i) });
                MMGridPaper.this.Wjt.removeViewAt(0);
                localMMGridPaperGridView.a(i, MMGridPaper.this.AA, MMGridPaper.this.mNumColumns, MMGridPaper.this.Wju);
                MMGridPaper.this.Wjt.addView(localMMGridPaperGridView);
                i = MMGridPaper.this.Wjt.getChildCount();
                MMGridPaper.this.Wjt.auv(i >> 1);
                MMGridPaper.a(MMGridPaper.this, 1);
                AppMethodBeat.o(141967);
              }
            });
          }
        }
      }
    };
    this.HDS = new MMHandler(Looper.getMainLooper());
    View.inflate(getContext(), a.h.mm_gridpaper, this);
    this.mCurrentOrientation = getScreenOrientation();
    AppMethodBeat.o(141969);
  }
  
  private boolean aux(int paramInt)
  {
    AppMethodBeat.i(141976);
    Log.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.WjK) });
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.WjK) {
        break;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    int i = ml(paramInt, this.mNumColumns);
    paramInt = getScreenOrientation();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(141976);
      return true;
    case 2: 
      i = Math.min(i, this.WjM);
      j = (this.WjI + 10) * i + 8;
      Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.WjF), Boolean.valueOf(this.WjJ) });
      if (this.WjF != j)
      {
        this.WjF = j;
        AppMethodBeat.o(141976);
        return false;
      }
      AppMethodBeat.o(141976);
      return true;
    }
    i = Math.min(i, this.WjL);
    int j = (this.WjI + 10) * i + 8;
    Log.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.WjG), Boolean.valueOf(this.WjJ) });
    if (this.WjG != j)
    {
      this.WjG = j;
      AppMethodBeat.o(141976);
      return false;
    }
    AppMethodBeat.o(141976);
    return true;
  }
  
  private void fEp()
  {
    AppMethodBeat.i(141980);
    Log.v("MicroMsg.MMGridPaper", "set DotView");
    boolean bool;
    if (this.WjC >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.uLP.setDotCount(this.WjC);
      if ((this.Wju != null) && (this.WjC > 1)) {
        break label137;
      }
      this.uLP.setVisibility(8);
      Log.v("MicroMsg.MMGridPaper", "set DotView gone");
    }
    for (;;)
    {
      if (this.Wjy >= this.WjC) {
        this.Wjy = (this.WjC - 1);
      }
      this.Wjt.auv(this.Wjy - this.WjA);
      this.Wjt.auw(this.Wjy);
      this.uLP.setSelectedDot(this.Wjy);
      AppMethodBeat.o(141980);
      return;
      bool = false;
      break;
      label137:
      this.uLP.setVisibility(0);
      Log.v("MicroMsg.MMGridPaper", "set DotView visible");
    }
  }
  
  private MMGridPaperGridView getCurrentPage()
  {
    AppMethodBeat.i(141983);
    MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)this.Wjt.getChildAt(this.Wjt.getCurScreen());
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
  
  private void hJG()
  {
    AppMethodBeat.i(141974);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((-1 != this.WjF) && (getScreenOrientation() == 2))
    {
      localView = findViewById(a.g.gridpaper_display_view);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.WjF);
      if (i != localLayoutParams.height)
      {
        Log.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[] { Integer.valueOf(this.WjF) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.HDS.post(new Runnable()
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
    if ((-1 != this.WjG) && (getScreenOrientation() == 1))
    {
      localView = findViewById(a.g.gridpaper_display_view);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = a.fromDPToPix(getContext(), this.WjG);
      if (i != localLayoutParams.height)
      {
        Log.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[] { Integer.valueOf(this.WjG) });
        localLayoutParams.height = i;
        localView.setLayoutParams(localLayoutParams);
        this.HDS.post(new Runnable()
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
  
  private void hJH()
  {
    AppMethodBeat.i(141977);
    Log.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[] { Integer.valueOf(this.Wjv), Integer.valueOf(this.Wjw) });
    if ((this.Wjv == 0) || (this.Wjw == 0))
    {
      Log.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
      AppMethodBeat.o(141977);
      return;
    }
    int j = a.fromDPToPix(getContext(), this.WjH);
    int i = a.fromDPToPix(getContext(), this.WjI);
    j = Math.max(this.Wjv / j, 1);
    i = Math.max(this.Wjw / i, 1);
    if ((j != this.mNumColumns) || (i != this.AA)) {
      this.WjD = true;
    }
    this.mNumColumns = j;
    if (this.Aw != -1) {
      this.mNumColumns = Math.min(this.mNumColumns, this.Aw);
    }
    this.AA = i;
    if (this.AB != -1) {
      this.AA = Math.min(this.AA, this.AB);
    }
    i = this.mNumColumns;
    j = this.AA * i;
    this.WjC = 0;
    if (this.Wju == null) {}
    for (i = 0;; i = this.Wju.getCount())
    {
      i += 0;
      if (aux(i)) {
        break;
      }
      hJG();
      AppMethodBeat.o(141977);
      return;
    }
    this.WjC = ml(i, j);
    this.Wjy = Math.min(this.WjC - 1, mm(this.Wjx, j));
    this.Wjz = Math.min(3, this.WjC);
    this.WjA = Math.min(this.WjC - this.Wjz, Math.max(0, this.Wjy - (this.Wjz >> 1)));
    this.WjB = (this.WjA + this.Wjz - 1);
    Log.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[] { Integer.valueOf(this.WjH), Integer.valueOf(this.WjI), Integer.valueOf(this.AA), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.Wjz), Integer.valueOf(this.WjC), Integer.valueOf(this.Wjy), Integer.valueOf(this.WjA), Integer.valueOf(this.WjB) });
    if ((this.Wjt.getChildCount() != this.Wjz) || (this.WjD))
    {
      Log.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[] { Boolean.valueOf(this.WjD) });
      this.WjD = false;
      this.Wjt.removeAllViews();
      i = this.WjA;
    }
    while (i <= this.WjB)
    {
      MMGridPaperGridView localMMGridPaperGridView = (MMGridPaperGridView)inflate(getContext(), a.h.mm_drap_drop_gridview, null);
      localMMGridPaperGridView.a(i, this.AA, this.mNumColumns, this.Wju);
      localMMGridPaperGridView.setHorizontalSpacing(a.fromDPToPix(getContext(), this.Whu));
      localMMGridPaperGridView.setVerticalSpacing(a.fromDPToPix(getContext(), this.Whv));
      this.Wjt.addView(localMMGridPaperGridView, new LinearLayout.LayoutParams(-1, -1));
      i += 1;
      continue;
      i = this.WjA;
      if (i <= this.WjB)
      {
        localMMGridPaperGridView = (MMGridPaperGridView)this.Wjt.getChildAt(i - this.WjA);
        if (localMMGridPaperGridView.getIndex() != i)
        {
          Log.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[] { Integer.valueOf(localMMGridPaperGridView.getIndex()), Integer.valueOf(i) });
          localMMGridPaperGridView.a(i, this.AA, this.mNumColumns, this.Wju);
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
    fEp();
    AppMethodBeat.o(141977);
  }
  
  private void hkU()
  {
    AppMethodBeat.i(141975);
    Log.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
    if (this.uLP == null)
    {
      this.uLP = ((MMDotView)findViewById(a.g.gridpaper_dot));
      this.uLP.setMaxCount(this.WjE);
    }
    if (this.Wjt == null)
    {
      this.Wjt = ((MMFlipper)findViewById(a.g.gridpaper_flipper));
      this.Wjt.setOnMeasureListener(this.Wjf);
      this.Wjt.setOnScreenChangedListener(this.Wjd);
    }
    hJG();
    hJH();
    AppMethodBeat.o(141975);
  }
  
  private static int ml(int paramInt1, int paramInt2)
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
  
  private static int mm(int paramInt1, int paramInt2)
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
  
  public final void bfU()
  {
    AppMethodBeat.i(141972);
    this.Wjx = (this.Wjy * this.mNumColumns * this.AA);
    Log.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[] { Integer.valueOf(this.Wjy), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.AA), Integer.valueOf(this.Wjx) });
    hkU();
    AppMethodBeat.o(141972);
  }
  
  public final int getItemsCountPerPage()
  {
    return this.AA * this.mNumColumns;
  }
  
  public final int getPageCount()
  {
    return this.WjC;
  }
  
  public final void hJE()
  {
    this.WjM = 3;
    this.WjL = 3;
  }
  
  public final void hJF()
  {
    this.Whu = 8;
    this.Whv = 15;
  }
  
  @TargetApi(8)
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141982);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      Log.d("MicroMsg.MMGridPaper", "onConfigChanged:" + paramConfiguration.orientation);
      this.WjJ = true;
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
      this.WjJ = true;
      clearAnimation();
      hJG();
      hJH();
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(141981);
  }
  
  public final void setDialogMode(boolean paramBoolean)
  {
    this.WjK = paramBoolean;
  }
  
  public final void setDisplayHeightLandInDp(int paramInt)
  {
    this.WjF = paramInt;
  }
  
  public final void setDisplayHeightPortInDp(int paramInt)
  {
    this.WjG = paramInt;
  }
  
  public final void setGridHeight(int paramInt)
  {
    this.Wjw = paramInt;
  }
  
  public final void setGridPaperAdapter(j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(141971);
    this.Wju = paramj;
    if (paramj == null) {}
    for (;;)
    {
      Log.d("MicroMsg.MMGridPaper", "setGridPaperAdapter:adapter is null[%B]", new Object[] { Boolean.valueOf(bool) });
      if (this.Wju != null) {
        this.Wju.WjU = new j.a()
        {
          public final void cAe()
          {
            AppMethodBeat.i(141962);
            MMGridPaper.this.bfU();
            AppMethodBeat.o(141962);
          }
        };
      }
      hkU();
      AppMethodBeat.o(141971);
      return;
      bool = false;
    }
  }
  
  public final void setGridWidth(int paramInt)
  {
    this.Wjv = paramInt;
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(141970);
    this.mL = paramView;
    paramView = (ViewGroup)findViewById(a.g.header_area);
    paramView.removeAllViews();
    if (this.mL != null) {
      paramView.addView(this.mL);
    }
    AppMethodBeat.o(141970);
  }
  
  public final void setItemHeightInDp(int paramInt)
  {
    this.WjI = paramInt;
  }
  
  public final void setItemWidthInDp(int paramInt)
  {
    this.WjH = paramInt;
  }
  
  public final void setManualMeasureMode(boolean paramBoolean)
  {
    this.WjN = paramBoolean;
  }
  
  public final void setMaxCol(int paramInt)
  {
    this.Aw = paramInt;
  }
  
  public final void setMaxDotCount(int paramInt)
  {
    this.WjE = paramInt;
  }
  
  public final void setMaxRow(int paramInt)
  {
    this.AB = paramInt;
  }
  
  public final void setOnPageSizeChangeListener(a parama)
  {
    this.WjQ = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaper
 * JD-Core Version:    0.7.0.1
 */