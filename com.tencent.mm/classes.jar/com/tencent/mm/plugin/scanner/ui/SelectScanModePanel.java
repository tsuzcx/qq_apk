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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
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
  private static int yuy = 85;
  private static int yuz = 85;
  private Context context;
  private boolean yuA;
  private int yuB;
  private final int yuC;
  private int yuD;
  protected List<SelectScanModeGrid> yuE;
  private String[] yuF;
  private int[] yuG;
  private int[] yuH;
  private int[] yuI;
  private ArrayList<Integer> yuJ;
  private Set<Integer> yuK;
  private AdapterView.OnItemClickListener yuL;
  private int yuM;
  private boolean yuN;
  private int yuO;
  private int yuP;
  private MMFlipper yuQ;
  private MMDotView yuR;
  private a yuS;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51989);
    this.yuA = o.dMU();
    this.yuB = 4;
    this.yuC = 0;
    this.yuD = 0;
    this.yuG = new int[] { 2131233898, 2131233878, 2131233902, 2131691124, 2131233878 };
    this.yuH = new int[] { 2131233899, 2131233879, 2131233903, 2131691125, 2131233879 };
    this.yuI = new int[] { 1, 2, 5, 3, 12 };
    this.yuJ = new ArrayList();
    this.yuK = new HashSet();
    this.yuM = 0;
    this.yuN = false;
    this.context = paramContext;
    View.inflate(this.context, 2131495358, this);
    this.yuR = ((MMDotView)findViewById(2131304534));
    this.yuJ.clear();
    this.yuJ.add(Integer.valueOf(1));
    this.yuJ.add(Integer.valueOf(2));
    this.yuJ.add(Integer.valueOf(5));
    this.yuJ.add(Integer.valueOf(3));
    if (this.yuA) {
      this.yuJ.add(Integer.valueOf(12));
    }
    int i;
    if (this.yuA)
    {
      i = 5;
      this.yuB = i;
      this.yuF = new String[this.yuB];
      this.yuF[0] = this.context.getString(2131762810);
      this.yuF[1] = o.ja(o.yAu, this.context.getString(2131762807));
      this.yuF[2] = this.context.getString(2131762812);
      this.yuF[3] = this.context.getString(2131762808);
      if (this.yuA) {
        this.yuF[4] = this.context.getString(2131762804);
      }
      ad.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
      this.yuQ = ((MMFlipper)findViewById(2131304535));
      paramContext = findViewById(2131304533);
      if (this.context.getResources().getConfiguration().orientation != 2) {
        break label494;
      }
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.g(this.context, yuz);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.yuQ.removeAllViews();
      this.yuQ.setOnMeasureListener(new MMFlipper.b()
      {
        public final void hq(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(51986);
          ad.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + SelectScanModePanel.a(SelectScanModePanel.this));
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
      this.yuQ.setOnScreenChangedListener(new MMFlipper.c()
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
      paramAttributeSet.height = BackwardSupportUtil.b.g(this.context, yuy);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int OL(int paramInt)
  {
    int i = 0;
    while (i < this.yuI.length)
    {
      if (this.yuI[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void dMk()
  {
    int j = 1;
    AppMethodBeat.i(51993);
    if (this.yuL == null) {
      this.yuL = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          boolean bool2 = true;
          AppMethodBeat.i(51988);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          if ((paramAnonymousAdapterView == null) || (SelectScanModePanel.e(SelectScanModePanel.this) == null))
          {
            paramAnonymousView = new StringBuilder("parent == null ? ");
            if (paramAnonymousAdapterView == null)
            {
              bool1 = true;
              paramAnonymousAdapterView = paramAnonymousView.append(bool1).append(", context == null ? ");
              if (SelectScanModePanel.e(SelectScanModePanel.this) != null) {
                break label154;
              }
            }
            label154:
            for (boolean bool1 = bool2;; bool1 = false)
            {
              ad.e("MicroMsg.scanner.SelectScanModePanel", bool1);
              a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(51988);
              return;
              bool1 = false;
              break;
            }
          }
          paramAnonymousView = (SelectScanModeGrid.b)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            ad.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
            a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(51988);
            return;
          }
          ((SelectScanModeGrid.a)paramAnonymousAdapterView.getAdapter()).yuq = paramAnonymousInt;
          ad.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousView.title });
          if ((SelectScanModePanel.f(SelectScanModePanel.this) != null) && (paramAnonymousView != null)) {
            SelectScanModePanel.f(SelectScanModePanel.this);
          }
          SelectScanModePanel.this.setSelectedMode(paramAnonymousView.yuv);
          a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(51988);
        }
      };
    }
    this.yuE = new ArrayList();
    if ((this.yuO == 0) || (this.yuP == 0))
    {
      AppMethodBeat.o(51993);
      return;
    }
    this.yuQ.removeAllViews();
    int k = BackwardSupportUtil.b.g(this.context, 64.0F);
    int i = BackwardSupportUtil.b.g(this.context, 78.0F);
    int m = this.yuO / k;
    k = this.yuP / i;
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
      this.yuM = 0;
      i = this.yuB;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.yuM += 1;
          continue;
          i = m;
          if (m <= this.yuJ.size()) {
            break;
          }
          i = this.yuJ.size();
          break;
        }
      }
      i = 0;
      while (i < this.yuM)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.yuJ.size()) && (j < k + m))
        {
          int n = OL(((Integer)this.yuJ.get(j)).intValue());
          ((List)localObject).add(new SelectScanModeGrid.b(this.yuF[n], this.yuG[n], this.yuH[n], ((Integer)this.yuJ.get(j)).intValue(), this.yuK.contains(this.yuJ.get(j))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, 2131495356, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).yuq = this.yuD;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.yuQ.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.yuL);
          this.yuE.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      dMl();
      AppMethodBeat.o(51993);
      return;
      label434:
      j = k;
    }
  }
  
  private void dMl()
  {
    AppMethodBeat.i(51994);
    if (this.yuE.size() <= 1)
    {
      this.yuR.setVisibility(4);
      AppMethodBeat.o(51994);
      return;
    }
    this.yuR.setVisibility(0);
    this.yuR.setDotCount(this.yuE.size());
    int i = this.yuQ.getCurScreen();
    this.yuQ.setToScreen(i);
    this.yuR.setSelectedDot(i);
    AppMethodBeat.o(51994);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51990);
    this.yuJ.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.yuJ.add(Integer.valueOf(k));
      i += 1;
    }
    dMk();
    AppMethodBeat.o(51990);
  }
  
  public void setOnGridItemClickCallback(a parama)
  {
    this.yuS = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(51992);
    this.yuD = OL(paramInt);
    if (this.yuE != null)
    {
      int i = 0;
      while (i < this.yuE.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.yuE.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.yuw != null))
            {
              if (localb.yuv != paramInt) {
                break label153;
              }
              localb.yuw.setBackgroundResource(localb.yuu);
              localb.yux = false;
              if (i > 0)
              {
                this.yuQ.setToScreen(i);
                this.yuR.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.yuw.setBackgroundResource(localb.yut);
            }
          }
          locala.yuq = this.yuD;
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
      this.yuK.clear();
      this.yuK.addAll(paramSet);
    }
    AppMethodBeat.o(51991);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */