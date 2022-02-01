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
import com.tencent.mm.plugin.scanner.util.r;
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
  private static int ITN = 85;
  private static int ITO = 85;
  private boolean ITP;
  private int ITQ;
  private final int ITR;
  private int ITS;
  protected List<SelectScanModeGrid> ITT;
  private String[] ITU;
  private int[] ITV;
  private int[] ITW;
  private int[] ITX;
  private ArrayList<Integer> ITY;
  private Set<Integer> ITZ;
  private AdapterView.OnItemClickListener IUa;
  private int IUb;
  private boolean IUc;
  private int IUd;
  private int IUe;
  private MMFlipper IUf;
  private MMDotView IUg;
  private a IUh;
  private Context context;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51989);
    this.ITP = r.fFe();
    this.ITQ = 4;
    this.ITR = 0;
    this.ITS = 0;
    this.ITV = new int[] { l.e.ICp, l.e.ICn, l.e.ICs, l.h.scan_translation, l.e.ICn };
    this.ITW = new int[] { l.e.ICq, l.e.ICo, l.e.ICt, l.h.scan_translation_hl, l.e.ICo };
    this.ITX = new int[] { 1, 2, 5, 3, 12 };
    this.ITY = new ArrayList();
    this.ITZ = new HashSet();
    this.IUb = 0;
    this.IUc = false;
    this.context = paramContext;
    View.inflate(this.context, l.g.IEA, this);
    this.IUg = ((MMDotView)findViewById(l.f.IDG));
    this.ITY.clear();
    this.ITY.add(Integer.valueOf(1));
    this.ITY.add(Integer.valueOf(2));
    this.ITY.add(Integer.valueOf(5));
    this.ITY.add(Integer.valueOf(3));
    if (this.ITP) {
      this.ITY.add(Integer.valueOf(12));
    }
    int i;
    if (this.ITP)
    {
      i = 5;
      this.ITQ = i;
      this.ITU = new String[this.ITQ];
      this.ITU[0] = this.context.getString(l.i.IEQ);
      this.ITU[1] = r.kj(r.IZY, this.context.getString(l.i.IEO));
      this.ITU[2] = this.context.getString(l.i.scan_entry_street);
      this.ITU[3] = this.context.getString(l.i.scan_entry_ocr);
      if (this.ITP) {
        this.ITU[4] = this.context.getString(l.i.IEN);
      }
      Log.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
      this.IUf = ((MMFlipper)findViewById(l.f.IDH));
      paramContext = findViewById(l.f.IDF);
      if (this.context.getResources().getConfiguration().orientation != 2) {
        break label513;
      }
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, ITO);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.IUf.removeAllViews();
      this.IUf.setOnMeasureListener(new MMFlipper.b()
      {
        public final void jl(int paramAnonymousInt1, int paramAnonymousInt2)
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
      this.IUf.setOnScreenChangedListener(new MMFlipper.c()
      {
        public final void E(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
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
      paramAttributeSet.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, ITN);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int adQ(int paramInt)
  {
    int i = 0;
    while (i < this.ITX.length)
    {
      if (this.ITX[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void fEo()
  {
    int j = 1;
    AppMethodBeat.i(51993);
    if (this.IUa == null) {
      this.IUa = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          boolean bool2 = true;
          AppMethodBeat.i(51988);
          b localb = new b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
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
          ((SelectScanModeGrid.a)paramAnonymousAdapterView.getAdapter()).ITG = paramAnonymousInt;
          Log.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousView.title });
          if ((SelectScanModePanel.f(SelectScanModePanel.this) != null) && (paramAnonymousView != null)) {
            SelectScanModePanel.f(SelectScanModePanel.this);
          }
          SelectScanModePanel.this.setSelectedMode(paramAnonymousView.ITK);
          a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(51988);
        }
      };
    }
    this.ITT = new ArrayList();
    if ((this.IUd == 0) || (this.IUe == 0))
    {
      AppMethodBeat.o(51993);
      return;
    }
    this.IUf.removeAllViews();
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 64.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 78.0F);
    int m = this.IUd / k;
    k = this.IUe / i;
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
      this.IUb = 0;
      i = this.ITQ;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.IUb += 1;
          continue;
          i = m;
          if (m <= this.ITY.size()) {
            break;
          }
          i = this.ITY.size();
          break;
        }
      }
      i = 0;
      while (i < this.IUb)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.ITY.size()) && (j < k + m))
        {
          int n = adQ(((Integer)this.ITY.get(j)).intValue());
          ((List)localObject).add(new SelectScanModeGrid.b(this.ITU[n], this.ITV[n], this.ITW[n], ((Integer)this.ITY.get(j)).intValue(), this.ITZ.contains(this.ITY.get(j))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, l.g.IEy, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).ITG = this.ITS;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.IUf.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.IUa);
          this.ITT.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      fEp();
      AppMethodBeat.o(51993);
      return;
      label437:
      j = k;
    }
  }
  
  private void fEp()
  {
    AppMethodBeat.i(51994);
    if (this.ITT.size() <= 1)
    {
      this.IUg.setVisibility(4);
      AppMethodBeat.o(51994);
      return;
    }
    this.IUg.setVisibility(0);
    this.IUg.setDotCount(this.ITT.size());
    int i = this.IUf.getCurScreen();
    this.IUf.setToScreen(i);
    this.IUg.setSelectedDot(i);
    AppMethodBeat.o(51994);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51990);
    this.ITY.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.ITY.add(Integer.valueOf(k));
      i += 1;
    }
    fEo();
    AppMethodBeat.o(51990);
  }
  
  public void setOnGridItemClickCallback(a parama)
  {
    this.IUh = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(51992);
    this.ITS = adQ(paramInt);
    if (this.ITT != null)
    {
      int i = 0;
      while (i < this.ITT.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.ITT.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.ITL != null))
            {
              if (localb.ITK != paramInt) {
                break label153;
              }
              localb.ITL.setBackgroundResource(localb.ITJ);
              localb.ITM = false;
              if (i > 0)
              {
                this.IUf.setToScreen(i);
                this.IUg.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.ITL.setBackgroundResource(localb.ITI);
            }
          }
          locala.ITG = this.ITS;
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
      this.ITZ.clear();
      this.ITZ.addAll(paramSet);
    }
    AppMethodBeat.o(51991);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */