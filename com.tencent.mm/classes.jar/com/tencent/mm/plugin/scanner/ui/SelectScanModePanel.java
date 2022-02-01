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
import com.tencent.mm.sdk.platformtools.ae;
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
  private static int yKy = 85;
  private static int yKz = 85;
  private Context context;
  private boolean yKA;
  private int yKB;
  private final int yKC;
  private int yKD;
  protected List<SelectScanModeGrid> yKE;
  private String[] yKF;
  private int[] yKG;
  private int[] yKH;
  private int[] yKI;
  private ArrayList<Integer> yKJ;
  private Set<Integer> yKK;
  private AdapterView.OnItemClickListener yKL;
  private int yKM;
  private boolean yKN;
  private int yKO;
  private int yKP;
  private MMFlipper yKQ;
  private MMDotView yKR;
  private a yKS;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51989);
    this.yKA = o.dQn();
    this.yKB = 4;
    this.yKC = 0;
    this.yKD = 0;
    this.yKG = new int[] { 2131233898, 2131233878, 2131233902, 2131691124, 2131233878 };
    this.yKH = new int[] { 2131233899, 2131233879, 2131233903, 2131691125, 2131233879 };
    this.yKI = new int[] { 1, 2, 5, 3, 12 };
    this.yKJ = new ArrayList();
    this.yKK = new HashSet();
    this.yKM = 0;
    this.yKN = false;
    this.context = paramContext;
    View.inflate(this.context, 2131495358, this);
    this.yKR = ((MMDotView)findViewById(2131304534));
    this.yKJ.clear();
    this.yKJ.add(Integer.valueOf(1));
    this.yKJ.add(Integer.valueOf(2));
    this.yKJ.add(Integer.valueOf(5));
    this.yKJ.add(Integer.valueOf(3));
    if (this.yKA) {
      this.yKJ.add(Integer.valueOf(12));
    }
    int i;
    if (this.yKA)
    {
      i = 5;
      this.yKB = i;
      this.yKF = new String[this.yKB];
      this.yKF[0] = this.context.getString(2131762810);
      this.yKF[1] = o.jg(o.yQu, this.context.getString(2131762807));
      this.yKF[2] = this.context.getString(2131762812);
      this.yKF[3] = this.context.getString(2131762808);
      if (this.yKA) {
        this.yKF[4] = this.context.getString(2131762804);
      }
      ae.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
      this.yKQ = ((MMFlipper)findViewById(2131304535));
      paramContext = findViewById(2131304533);
      if (this.context.getResources().getConfiguration().orientation != 2) {
        break label494;
      }
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.h(this.context, yKz);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.yKQ.removeAllViews();
      this.yKQ.setOnMeasureListener(new MMFlipper.b()
      {
        public final void hs(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(51986);
          ae.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + SelectScanModePanel.a(SelectScanModePanel.this));
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
      this.yKQ.setOnScreenChangedListener(new MMFlipper.c()
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
      paramAttributeSet.height = BackwardSupportUtil.b.h(this.context, yKy);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int Ps(int paramInt)
  {
    int i = 0;
    while (i < this.yKI.length)
    {
      if (this.yKI[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void dPD()
  {
    int j = 1;
    AppMethodBeat.i(51993);
    if (this.yKL == null) {
      this.yKL = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          boolean bool2 = true;
          AppMethodBeat.i(51988);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
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
              ae.e("MicroMsg.scanner.SelectScanModePanel", bool1);
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
            ae.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
            a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(51988);
            return;
          }
          ((SelectScanModeGrid.a)paramAnonymousAdapterView.getAdapter()).yKr = paramAnonymousInt;
          ae.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousView.title });
          if ((SelectScanModePanel.f(SelectScanModePanel.this) != null) && (paramAnonymousView != null)) {
            SelectScanModePanel.f(SelectScanModePanel.this);
          }
          SelectScanModePanel.this.setSelectedMode(paramAnonymousView.yKv);
          a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(51988);
        }
      };
    }
    this.yKE = new ArrayList();
    if ((this.yKO == 0) || (this.yKP == 0))
    {
      AppMethodBeat.o(51993);
      return;
    }
    this.yKQ.removeAllViews();
    int k = BackwardSupportUtil.b.h(this.context, 64.0F);
    int i = BackwardSupportUtil.b.h(this.context, 78.0F);
    int m = this.yKO / k;
    k = this.yKP / i;
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
      this.yKM = 0;
      i = this.yKB;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.yKM += 1;
          continue;
          i = m;
          if (m <= this.yKJ.size()) {
            break;
          }
          i = this.yKJ.size();
          break;
        }
      }
      i = 0;
      while (i < this.yKM)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.yKJ.size()) && (j < k + m))
        {
          int n = Ps(((Integer)this.yKJ.get(j)).intValue());
          ((List)localObject).add(new SelectScanModeGrid.b(this.yKF[n], this.yKG[n], this.yKH[n], ((Integer)this.yKJ.get(j)).intValue(), this.yKK.contains(this.yKJ.get(j))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, 2131495356, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).yKr = this.yKD;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.yKQ.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.yKL);
          this.yKE.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      dPE();
      AppMethodBeat.o(51993);
      return;
      label434:
      j = k;
    }
  }
  
  private void dPE()
  {
    AppMethodBeat.i(51994);
    if (this.yKE.size() <= 1)
    {
      this.yKR.setVisibility(4);
      AppMethodBeat.o(51994);
      return;
    }
    this.yKR.setVisibility(0);
    this.yKR.setDotCount(this.yKE.size());
    int i = this.yKQ.getCurScreen();
    this.yKQ.setToScreen(i);
    this.yKR.setSelectedDot(i);
    AppMethodBeat.o(51994);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51990);
    this.yKJ.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.yKJ.add(Integer.valueOf(k));
      i += 1;
    }
    dPD();
    AppMethodBeat.o(51990);
  }
  
  public void setOnGridItemClickCallback(a parama)
  {
    this.yKS = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(51992);
    this.yKD = Ps(paramInt);
    if (this.yKE != null)
    {
      int i = 0;
      while (i < this.yKE.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.yKE.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.yKw != null))
            {
              if (localb.yKv != paramInt) {
                break label153;
              }
              localb.yKw.setBackgroundResource(localb.yKu);
              localb.yKx = false;
              if (i > 0)
              {
                this.yKQ.setToScreen(i);
                this.yKR.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.yKw.setBackgroundResource(localb.yKt);
            }
          }
          locala.yKr = this.yKD;
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
      this.yKK.clear();
      this.yKK.addAll(paramSet);
    }
    AppMethodBeat.o(51991);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */