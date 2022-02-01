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
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.h;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
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
  private static int PcG = 85;
  private static int PcH = 85;
  private boolean PcI;
  private int PcJ;
  private final int PcK;
  private int PcL;
  protected List<SelectScanModeGrid> PcM;
  private String[] PcN;
  private int[] PcO;
  private int[] PcP;
  private int[] PcQ;
  private ArrayList<Integer> PcR;
  private Set<Integer> PcS;
  private AdapterView.OnItemClickListener PcT;
  private boolean PcU;
  private int PcV;
  private int PcW;
  private MMFlipper PcX;
  private MMDotView PcY;
  private a PcZ;
  private Context context;
  private int iew;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51989);
    this.PcI = t.gUo();
    this.PcJ = 4;
    this.PcK = 0;
    this.PcL = 0;
    this.PcO = new int[] { l.e.OIr, l.e.OIp, l.e.OIt, l.h.scan_translation, l.e.OIp };
    this.PcP = new int[] { l.e.OIs, l.e.OIq, l.e.OIu, l.h.scan_translation_hl, l.e.OIq };
    this.PcQ = new int[] { 1, 2, 5, 3, 12 };
    this.PcR = new ArrayList();
    this.PcS = new HashSet();
    this.iew = 0;
    this.PcU = false;
    this.context = paramContext;
    View.inflate(this.context, l.g.OKD, this);
    this.PcY = ((MMDotView)findViewById(l.f.OJI));
    this.PcR.clear();
    this.PcR.add(Integer.valueOf(1));
    this.PcR.add(Integer.valueOf(2));
    this.PcR.add(Integer.valueOf(5));
    this.PcR.add(Integer.valueOf(3));
    if (this.PcI) {
      this.PcR.add(Integer.valueOf(12));
    }
    int i;
    if (this.PcI)
    {
      i = 5;
      this.PcJ = i;
      this.PcN = new String[this.PcJ];
      this.PcN[0] = this.context.getString(l.i.OKX);
      this.PcN[1] = t.lI(t.PjQ, this.context.getString(l.i.OKV));
      this.PcN[2] = this.context.getString(l.i.scan_entry_street);
      this.PcN[3] = this.context.getString(l.i.scan_entry_ocr);
      if (this.PcI) {
        this.PcN[4] = this.context.getString(l.i.OKU);
      }
      Log.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
      this.PcX = ((MMFlipper)findViewById(l.f.OJJ));
      paramContext = findViewById(l.f.OJH);
      if (this.context.getResources().getConfiguration().orientation != 2) {
        break label513;
      }
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, PcH);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.PcX.removeAllViews();
      this.PcX.setOnMeasureListener(new MMFlipper.b()
      {
        public final void kS(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(51986);
          Log.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + SelectScanModePanel.a(SelectScanModePanel.this));
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
      this.PcX.setOnScreenChangedListener(new MMFlipper.c()
      {
        public final void onScreenChanged(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
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
      label513:
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, PcG);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int ais(int paramInt)
  {
    int i = 0;
    while (i < this.PcQ.length)
    {
      if (this.PcQ[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void gTb()
  {
    int j = 1;
    AppMethodBeat.i(51993);
    if (this.PcT == null) {
      this.PcT = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          boolean bool2 = true;
          AppMethodBeat.i(51988);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
              Log.e("MicroMsg.scanner.SelectScanModePanel", bool1);
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
            Log.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
            a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(51988);
            return;
          }
          ((SelectScanModeGrid.a)paramAnonymousAdapterView.getAdapter()).Pcz = paramAnonymousInt;
          Log.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousView.title });
          if ((SelectScanModePanel.f(SelectScanModePanel.this) != null) && (paramAnonymousView != null)) {
            SelectScanModePanel.f(SelectScanModePanel.this);
          }
          SelectScanModePanel.this.setSelectedMode(paramAnonymousView.PcD);
          a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(51988);
        }
      };
    }
    this.PcM = new ArrayList();
    if ((this.PcV == 0) || (this.PcW == 0))
    {
      AppMethodBeat.o(51993);
      return;
    }
    this.PcX.removeAllViews();
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 64.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 78.0F);
    int m = this.PcV / k;
    k = this.PcW / i;
    if (m == 0)
    {
      i = 1;
      if (k != 0) {
        break label437;
      }
    }
    for (;;)
    {
      m = i * j;
      this.iew = 0;
      i = this.PcJ;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.iew += 1;
          continue;
          i = m;
          if (m <= this.PcR.size()) {
            break;
          }
          i = this.PcR.size();
          break;
        }
      }
      i = 0;
      while (i < this.iew)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.PcR.size()) && (j < k + m))
        {
          int n = ais(((Integer)this.PcR.get(j)).intValue());
          ((List)localObject).add(new SelectScanModeGrid.b(this.PcN[n], this.PcO[n], this.PcP[n], ((Integer)this.PcR.get(j)).intValue(), this.PcS.contains(this.PcR.get(j))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, l.g.OKB, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).Pcz = this.PcL;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.PcX.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.PcT);
          this.PcM.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      gTc();
      AppMethodBeat.o(51993);
      return;
      label437:
      j = k;
    }
  }
  
  private void gTc()
  {
    AppMethodBeat.i(51994);
    if (this.PcM.size() <= 1)
    {
      this.PcY.setVisibility(4);
      AppMethodBeat.o(51994);
      return;
    }
    this.PcY.setVisibility(0);
    this.PcY.setDotCount(this.PcM.size());
    int i = this.PcX.getCurScreen();
    this.PcX.setToScreen(i);
    this.PcY.setSelectedDot(i);
    AppMethodBeat.o(51994);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51990);
    this.PcR.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.PcR.add(Integer.valueOf(k));
      i += 1;
    }
    gTb();
    AppMethodBeat.o(51990);
  }
  
  public void setOnGridItemClickCallback(a parama)
  {
    this.PcZ = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(51992);
    this.PcL = ais(paramInt);
    if (this.PcM != null)
    {
      int i = 0;
      while (i < this.PcM.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.PcM.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.PcE != null))
            {
              if (localb.PcD != paramInt) {
                break label153;
              }
              localb.PcE.setBackgroundResource(localb.PcC);
              localb.PcF = false;
              if (i > 0)
              {
                this.PcX.setToScreen(i);
                this.PcY.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.PcE.setBackgroundResource(localb.PcB);
            }
          }
          locala.Pcz = this.PcL;
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
      this.PcS.clear();
      this.PcS.addAll(paramSet);
    }
    AppMethodBeat.o(51991);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */