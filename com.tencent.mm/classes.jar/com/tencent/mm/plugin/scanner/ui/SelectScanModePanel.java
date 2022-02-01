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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectScanModePanel
  extends LinearLayout
{
  private static int vVL = 85;
  private static int vVM = 85;
  private Context context;
  private boolean vVN;
  private int vVO;
  private final int vVP;
  private int vVQ;
  protected List<SelectScanModeGrid> vVR;
  private String[] vVS;
  private int[] vVT;
  private int[] vVU;
  private int[] vVV;
  private ArrayList<Integer> vVW;
  private Set<Integer> vVX;
  private AdapterView.OnItemClickListener vVY;
  private int vVZ;
  private boolean vWa;
  private int vWb;
  private int vWc;
  private MMFlipper vWd;
  private MMDotView vWe;
  private a vWf;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51989);
    this.vVN = o.dnp();
    this.vVO = 4;
    this.vVP = 0;
    this.vVQ = 0;
    this.vVT = new int[] { 2131233898, 2131233878, 2131233902, 2131691124, 2131233878 };
    this.vVU = new int[] { 2131233899, 2131233879, 2131233903, 2131691125, 2131233879 };
    this.vVV = new int[] { 1, 2, 5, 3, 12 };
    this.vVW = new ArrayList();
    this.vVX = new HashSet();
    this.vVZ = 0;
    this.vWa = false;
    this.context = paramContext;
    View.inflate(this.context, 2131495358, this);
    this.vWe = ((MMDotView)findViewById(2131304534));
    this.vVW.clear();
    this.vVW.add(Integer.valueOf(1));
    this.vVW.add(Integer.valueOf(2));
    this.vVW.add(Integer.valueOf(5));
    this.vVW.add(Integer.valueOf(3));
    if (this.vVN) {
      this.vVW.add(Integer.valueOf(12));
    }
    int i;
    if (this.vVN)
    {
      i = 5;
      this.vVO = i;
      this.vVS = new String[this.vVO];
      this.vVS[0] = this.context.getString(2131762810);
      this.vVS[1] = o.it(o.wbn, this.context.getString(2131762807));
      this.vVS[2] = this.context.getString(2131762812);
      this.vVS[3] = this.context.getString(2131762808);
      if (this.vVN) {
        this.vVS[4] = this.context.getString(2131762804);
      }
      ad.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
      this.vWd = ((MMFlipper)findViewById(2131304535));
      paramContext = findViewById(2131304533);
      if (this.context.getResources().getConfiguration().orientation != 2) {
        break label494;
      }
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.g(this.context, vVM);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.vWd.removeAllViews();
      this.vWd.setOnMeasureListener(new MMFlipper.a()
      {
        public final void gQ(int paramAnonymousInt1, int paramAnonymousInt2)
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
      this.vWd.setOnScreenChangedListener(new MMFlipper.b()
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
      paramAttributeSet.height = BackwardSupportUtil.b.g(this.context, vVL);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int Lj(int paramInt)
  {
    int i = 0;
    while (i < this.vVV.length)
    {
      if (this.vVV[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void dmG()
  {
    int j = 1;
    AppMethodBeat.i(51993);
    if (this.vVY == null) {
      this.vVY = new AdapterView.OnItemClickListener()
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
              ad.e("MicroMsg.scanner.SelectScanModePanel", bool1);
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
            AppMethodBeat.o(51988);
            return;
          }
          ((SelectScanModeGrid.a)paramAnonymousAdapterView.getAdapter()).vVD = paramAnonymousInt;
          ad.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousView.title });
          if ((SelectScanModePanel.f(SelectScanModePanel.this) != null) && (paramAnonymousView != null)) {
            SelectScanModePanel.f(SelectScanModePanel.this);
          }
          SelectScanModePanel.this.setSelectedMode(paramAnonymousView.vVI);
          AppMethodBeat.o(51988);
        }
      };
    }
    this.vVR = new ArrayList();
    if ((this.vWb == 0) || (this.vWc == 0))
    {
      AppMethodBeat.o(51993);
      return;
    }
    this.vWd.removeAllViews();
    int k = BackwardSupportUtil.b.g(this.context, 64.0F);
    int i = BackwardSupportUtil.b.g(this.context, 78.0F);
    int m = this.vWb / k;
    k = this.vWc / i;
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
      this.vVZ = 0;
      i = this.vVO;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.vVZ += 1;
          continue;
          i = m;
          if (m <= this.vVW.size()) {
            break;
          }
          i = this.vVW.size();
          break;
        }
      }
      i = 0;
      while (i < this.vVZ)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.vVW.size()) && (j < k + m))
        {
          int n = Lj(((Integer)this.vVW.get(j)).intValue());
          ((List)localObject).add(new SelectScanModeGrid.b(this.vVS[n], this.vVT[n], this.vVU[n], ((Integer)this.vVW.get(j)).intValue(), this.vVX.contains(this.vVW.get(j))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, 2131495356, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).vVD = this.vVQ;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.vWd.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.vVY);
          this.vVR.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      dmH();
      AppMethodBeat.o(51993);
      return;
      label434:
      j = k;
    }
  }
  
  private void dmH()
  {
    AppMethodBeat.i(51994);
    if (this.vVR.size() <= 1)
    {
      this.vWe.setVisibility(4);
      AppMethodBeat.o(51994);
      return;
    }
    this.vWe.setVisibility(0);
    this.vWe.setDotCount(this.vVR.size());
    int i = this.vWd.getCurScreen();
    this.vWd.setToScreen(i);
    this.vWe.setSelectedDot(i);
    AppMethodBeat.o(51994);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51990);
    this.vVW.clear();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      this.vVW.add(Integer.valueOf(k));
      i += 1;
    }
    dmG();
    AppMethodBeat.o(51990);
  }
  
  public void setOnGridItemClickCallback(a parama)
  {
    this.vWf = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(51992);
    this.vVQ = Lj(paramInt);
    if (this.vVR != null)
    {
      int i = 0;
      while (i < this.vVR.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.vVR.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.vVJ != null))
            {
              if (localb.vVI != paramInt) {
                break label153;
              }
              localb.vVJ.setBackgroundResource(localb.vVH);
              localb.vVK = false;
              if (i > 0)
              {
                this.vWd.setToScreen(i);
                this.vWe.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.vVJ.setBackgroundResource(localb.vVG);
            }
          }
          locala.vVD = this.vVQ;
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
      this.vVX.clear();
      this.vVX.addAll(paramSet);
    }
    AppMethodBeat.o(51991);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */