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
  private static int COl = 85;
  private static int COm = 85;
  private boolean COA;
  private int COB;
  private int COC;
  private MMFlipper COD;
  private MMDotView COE;
  private a COF;
  private boolean COn;
  private int COo;
  private final int COp;
  private int COq;
  protected List<SelectScanModeGrid> COr;
  private String[] COs;
  private int[] COt;
  private int[] COu;
  private int[] COv;
  private ArrayList<Integer> COw;
  private Set<Integer> COx;
  private AdapterView.OnItemClickListener COy;
  private int COz;
  private Context context;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51989);
    this.COn = r.eSf();
    this.COo = 4;
    this.COp = 0;
    this.COq = 0;
    this.COt = new int[] { 2131234725, 2131234703, 2131234729, 2131691432, 2131234703 };
    this.COu = new int[] { 2131234726, 2131234704, 2131234730, 2131691433, 2131234704 };
    this.COv = new int[] { 1, 2, 5, 3, 12 };
    this.COw = new ArrayList();
    this.COx = new HashSet();
    this.COz = 0;
    this.COA = false;
    this.context = paramContext;
    View.inflate(this.context, 2131496219, this);
    this.COE = ((MMDotView)findViewById(2131307557));
    this.COw.clear();
    this.COw.add(Integer.valueOf(1));
    this.COw.add(Integer.valueOf(2));
    this.COw.add(Integer.valueOf(5));
    this.COw.add(Integer.valueOf(3));
    if (this.COn) {
      this.COw.add(Integer.valueOf(12));
    }
    int i;
    if (this.COn)
    {
      i = 5;
      this.COo = i;
      this.COs = new String[this.COo];
      this.COs[0] = this.context.getString(2131764907);
      this.COs[1] = r.jR(r.CUF, this.context.getString(2131764904));
      this.COs[2] = this.context.getString(2131764909);
      this.COs[3] = this.context.getString(2131764905);
      if (this.COn) {
        this.COs[4] = this.context.getString(2131764901);
      }
      Log.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
      this.COD = ((MMFlipper)findViewById(2131307558));
      paramContext = findViewById(2131307556);
      if (this.context.getResources().getConfiguration().orientation != 2) {
        break label494;
      }
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, COm);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.COD.removeAllViews();
      this.COD.setOnMeasureListener(new MMFlipper.b()
      {
        public final void ig(int paramAnonymousInt1, int paramAnonymousInt2)
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
      this.COD.setOnScreenChangedListener(new MMFlipper.c()
      {
        public final void z(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
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
      paramAttributeSet.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, COl);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int WR(int paramInt)
  {
    int i = 0;
    while (i < this.COv.length)
    {
      if (this.COv[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void eRo()
  {
    int j = 1;
    AppMethodBeat.i(51993);
    if (this.COy == null) {
      this.COy = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          boolean bool2 = true;
          AppMethodBeat.i(51988);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
          ((SelectScanModeGrid.a)paramAnonymousAdapterView.getAdapter()).COe = paramAnonymousInt;
          Log.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousView.title });
          if ((SelectScanModePanel.f(SelectScanModePanel.this) != null) && (paramAnonymousView != null)) {
            SelectScanModePanel.f(SelectScanModePanel.this);
          }
          SelectScanModePanel.this.setSelectedMode(paramAnonymousView.COi);
          a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(51988);
        }
      };
    }
    this.COr = new ArrayList();
    if ((this.COB == 0) || (this.COC == 0))
    {
      AppMethodBeat.o(51993);
      return;
    }
    this.COD.removeAllViews();
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 64.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 78.0F);
    int m = this.COB / k;
    k = this.COC / i;
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
      this.COz = 0;
      i = this.COo;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.COz += 1;
          continue;
          i = m;
          if (m <= this.COw.size()) {
            break;
          }
          i = this.COw.size();
          break;
        }
      }
      i = 0;
      while (i < this.COz)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.COw.size()) && (j < k + m))
        {
          int n = WR(((Integer)this.COw.get(j)).intValue());
          ((List)localObject).add(new SelectScanModeGrid.b(this.COs[n], this.COt[n], this.COu[n], ((Integer)this.COw.get(j)).intValue(), this.COx.contains(this.COw.get(j))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, 2131496217, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).COe = this.COq;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.COD.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.COy);
          this.COr.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      eRp();
      AppMethodBeat.o(51993);
      return;
      label434:
      j = k;
    }
  }
  
  private void eRp()
  {
    AppMethodBeat.i(51994);
    if (this.COr.size() <= 1)
    {
      this.COE.setVisibility(4);
      AppMethodBeat.o(51994);
      return;
    }
    this.COE.setVisibility(0);
    this.COE.setDotCount(this.COr.size());
    int i = this.COD.getCurScreen();
    this.COD.setToScreen(i);
    this.COE.setSelectedDot(i);
    AppMethodBeat.o(51994);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51990);
    this.COw.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.COw.add(Integer.valueOf(k));
      i += 1;
    }
    eRo();
    AppMethodBeat.o(51990);
  }
  
  public void setOnGridItemClickCallback(a parama)
  {
    this.COF = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(51992);
    this.COq = WR(paramInt);
    if (this.COr != null)
    {
      int i = 0;
      while (i < this.COr.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.COr.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.COj != null))
            {
              if (localb.COi != paramInt) {
                break label153;
              }
              localb.COj.setBackgroundResource(localb.COh);
              localb.COk = false;
              if (i > 0)
              {
                this.COD.setToScreen(i);
                this.COE.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.COj.setBackgroundResource(localb.COg);
            }
          }
          locala.COe = this.COq;
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
      this.COx.clear();
      this.COx.addAll(paramSet);
    }
    AppMethodBeat.o(51991);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */