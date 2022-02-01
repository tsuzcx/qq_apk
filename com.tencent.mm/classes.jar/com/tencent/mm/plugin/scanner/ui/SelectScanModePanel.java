package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.ui.base.MMFlipper.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectScanModePanel
  extends LinearLayout
{
  private static int xgx = 85;
  private static int xgy = 85;
  private Context context;
  private int xgA;
  private final int xgB;
  private int xgC;
  protected List<SelectScanModeGrid> xgD;
  private String[] xgE;
  private int[] xgF;
  private int[] xgG;
  private int[] xgH;
  private ArrayList<Integer> xgI;
  private Set<Integer> xgJ;
  private AdapterView.OnItemClickListener xgK;
  private int xgL;
  private boolean xgM;
  private int xgN;
  private int xgO;
  private MMFlipper xgP;
  private MMDotView xgQ;
  private a xgR;
  private boolean xgz;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51989);
    this.xgz = o.dBx();
    this.xgA = 4;
    this.xgB = 0;
    this.xgC = 0;
    this.xgF = new int[] { 2131233898, 2131233878, 2131233902, 2131691124, 2131233878 };
    this.xgG = new int[] { 2131233899, 2131233879, 2131233903, 2131691125, 2131233879 };
    this.xgH = new int[] { 1, 2, 5, 3, 12 };
    this.xgI = new ArrayList();
    this.xgJ = new HashSet();
    this.xgL = 0;
    this.xgM = false;
    this.context = paramContext;
    View.inflate(this.context, 2131495358, this);
    this.xgQ = ((MMDotView)findViewById(2131304534));
    this.xgI.clear();
    this.xgI.add(Integer.valueOf(1));
    this.xgI.add(Integer.valueOf(2));
    this.xgI.add(Integer.valueOf(5));
    this.xgI.add(Integer.valueOf(3));
    if (this.xgz) {
      this.xgI.add(Integer.valueOf(12));
    }
    int i;
    if (this.xgz)
    {
      i = 5;
      this.xgA = i;
      this.xgE = new String[this.xgA];
      this.xgE[0] = this.context.getString(2131762810);
      this.xgE[1] = o.iP(o.xmt, this.context.getString(2131762807));
      this.xgE[2] = this.context.getString(2131762812);
      this.xgE[3] = this.context.getString(2131762808);
      if (this.xgz) {
        this.xgE[4] = this.context.getString(2131762804);
      }
      ac.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
      this.xgP = ((MMFlipper)findViewById(2131304535));
      paramContext = findViewById(2131304533);
      if (this.context.getResources().getConfiguration().orientation != 2) {
        break label494;
      }
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.g(this.context, xgy);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.xgP.removeAllViews();
      this.xgP.setOnMeasureListener(new MMFlipper.b()
      {
        public final void gZ(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(51986);
          ac.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + SelectScanModePanel.a(SelectScanModePanel.this));
          if ((SelectScanModePanel.a(SelectScanModePanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
          {
            AppMethodBeat.o(51986);
            return;
          }
          SelectScanModePanel.b(SelectScanModePanel.this);
          SelectScanModePanel.a(SelectScanModePanel.this, paramAnonymousInt2);
          SelectScanModePanel.b(SelectScanModePanel.this, paramAnonymousInt1);
          SelectScanModePanel.c(SelectScanModePanel.this);
          AppMethodBeat.o(51986);
        }
      });
      this.xgP.setOnScreenChangedListener(new MMFlipper.c()
      {
        public final void u(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163474);
          SelectScanModePanel.d(SelectScanModePanel.this).setSelectedDot(paramAnonymousInt2);
          AppMethodBeat.o(163474);
        }
      });
      AppMethodBeat.o(51989);
      return;
      i = 4;
      break;
      label494:
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.g(this.context, xgx);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int Nj(int paramInt)
  {
    int i = 0;
    while (i < this.xgH.length)
    {
      if (this.xgH[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void dAM()
  {
    int j = 1;
    AppMethodBeat.i(51993);
    if (this.xgK == null) {
      this.xgK = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          boolean bool2 = true;
          AppMethodBeat.i(51988);
          if ((paramAnonymousAdapterView == null) || (SelectScanModePanel.e(SelectScanModePanel.this) == null))
          {
            paramAnonymousView = new StringBuilder("parent == null ? ");
            if (paramAnonymousAdapterView == null)
            {
              bool1 = true;
              paramAnonymousAdapterView = paramAnonymousView.append(bool1).append(", context == null ? ");
              if (SelectScanModePanel.e(SelectScanModePanel.this) != null) {
                break label91;
              }
            }
            label91:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ac.e("MicroMsg.scanner.SelectScanModePanel", bool1);
              AppMethodBeat.o(51988);
              return;
              bool1 = false;
              break;
            }
          }
          paramAnonymousView = (SelectScanModeGrid.b)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ac.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
            AppMethodBeat.o(51988);
            return;
          }
          ((SelectScanModeGrid.a)paramAnonymousAdapterView.getAdapter()).xgp = paramAnonymousInt;
          ac.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousView.title });
          if ((SelectScanModePanel.f(SelectScanModePanel.this) != null) && (paramAnonymousView != null)) {
            SelectScanModePanel.f(SelectScanModePanel.this);
          }
          SelectScanModePanel.this.setSelectedMode(paramAnonymousView.xgu);
          AppMethodBeat.o(51988);
        }
      };
    }
    this.xgD = new ArrayList();
    if ((this.xgN == 0) || (this.xgO == 0))
    {
      AppMethodBeat.o(51993);
      return;
    }
    this.xgP.removeAllViews();
    int k = BackwardSupportUtil.b.g(this.context, 64.0F);
    int i = BackwardSupportUtil.b.g(this.context, 78.0F);
    int m = this.xgN / k;
    k = this.xgO / i;
    if (m == 0)
    {
      i = 1;
      if (k != 0) {
        break label434;
      }
    }
    for (;;)
    {
      m = i * j;
      this.xgL = 0;
      i = this.xgA;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.xgL += 1;
          continue;
          i = m;
          if (m <= this.xgI.size()) {
            break;
          }
          i = this.xgI.size();
          break;
        }
      }
      i = 0;
      while (i < this.xgL)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.xgI.size()) && (j < k + m))
        {
          int n = Nj(((Integer)this.xgI.get(j)).intValue());
          ((List)localObject).add(new SelectScanModeGrid.b(this.xgE[n], this.xgF[n], this.xgG[n], ((Integer)this.xgI.get(j)).intValue(), this.xgJ.contains(this.xgI.get(j))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, 2131495356, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).xgp = this.xgC;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.xgP.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.xgK);
          this.xgD.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      dAN();
      AppMethodBeat.o(51993);
      return;
      label434:
      j = k;
    }
  }
  
  private void dAN()
  {
    AppMethodBeat.i(51994);
    if (this.xgD.size() <= 1)
    {
      this.xgQ.setVisibility(4);
      AppMethodBeat.o(51994);
      return;
    }
    this.xgQ.setVisibility(0);
    this.xgQ.setDotCount(this.xgD.size());
    int i = this.xgP.getCurScreen();
    this.xgP.setToScreen(i);
    this.xgQ.setSelectedDot(i);
    AppMethodBeat.o(51994);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51990);
    this.xgI.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.xgI.add(Integer.valueOf(k));
      i += 1;
    }
    dAM();
    AppMethodBeat.o(51990);
  }
  
  public void setOnGridItemClickCallback(a parama)
  {
    this.xgR = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(51992);
    this.xgC = Nj(paramInt);
    if (this.xgD != null)
    {
      int i = 0;
      while (i < this.xgD.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.xgD.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.xgv != null))
            {
              if (localb.xgu != paramInt) {
                break label153;
              }
              localb.xgv.setBackgroundResource(localb.xgt);
              localb.xgw = false;
              if (i > 0)
              {
                this.xgP.setToScreen(i);
                this.xgQ.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.xgv.setBackgroundResource(localb.xgs);
            }
          }
          locala.xgp = this.xgC;
          locala.notifyDataSetChanged();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(51992);
  }
  
  public void setShowRedDotModes(Set<Integer> paramSet)
  {
    AppMethodBeat.i(51991);
    if (paramSet != null)
    {
      this.xgJ.clear();
      this.xgJ.addAll(paramSet);
    }
    AppMethodBeat.o(51991);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */