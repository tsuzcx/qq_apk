package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectScanModePanel
  extends LinearLayout
{
  private static int qBn = 85;
  private static int qBo = 85;
  private Context context;
  private int ext;
  private int qBA;
  private int qBB;
  private MMFlipper qBC;
  private MMDotView qBD;
  private SelectScanModePanel.a qBE;
  private final int qBp;
  private int qBq;
  protected List<SelectScanModeGrid> qBr;
  private String[] qBs;
  private int[] qBt;
  private int[] qBu;
  private int[] qBv;
  private int[] qBw;
  private Set<Integer> qBx;
  private AdapterView.OnItemClickListener qBy;
  private boolean qBz;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(81334);
    this.qBp = 0;
    this.qBq = 0;
    this.qBs = new String[4];
    this.qBt = new int[] { 2130840197, 2130840185, 2130840200, 2131231939 };
    this.qBu = new int[] { 2130840198, 2130840186, 2130840201, 2131231940 };
    this.qBv = new int[] { 1, 2, 5, 3 };
    this.qBw = new int[] { 1, 2, 5, 3 };
    this.qBx = new HashSet();
    this.ext = 0;
    this.qBz = false;
    this.context = paramContext;
    View.inflate(this.context, 2130970663, this);
    this.qBD = ((MMDotView)findViewById(2131827556));
    this.qBs[0] = this.context.getString(2131302896);
    this.qBs[1] = t.ge(t.qDR, this.context.getString(2131302893));
    this.qBs[2] = this.context.getString(2131302898);
    this.qBs[3] = this.context.getString(2131302894);
    ab.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
    this.qBC = ((MMFlipper)findViewById(2131827555));
    paramContext = findViewById(2131827554);
    if (this.context.getResources().getConfiguration().orientation == 2)
    {
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.b(this.context, qBo);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.qBC.removeAllViews();
      this.qBC.setOnMeasureListener(new SelectScanModePanel.1(this));
      this.qBC.setOnScreenChangedListener(new SelectScanModePanel.2(this));
      AppMethodBeat.o(81334);
      return;
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.b(this.context, qBn);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private int CJ(int paramInt)
  {
    int i = 0;
    while (i < this.qBv.length)
    {
      if (this.qBv[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void cjj()
  {
    int j = 1;
    AppMethodBeat.i(81338);
    if (this.qBy == null) {
      this.qBy = new SelectScanModePanel.3(this);
    }
    this.qBr = new ArrayList();
    if ((this.qBA == 0) || (this.qBB == 0))
    {
      AppMethodBeat.o(81338);
      return;
    }
    this.qBC.removeAllViews();
    int k = BackwardSupportUtil.b.b(this.context, 64.0F);
    int i = BackwardSupportUtil.b.b(this.context, 78.0F);
    int m = this.qBA / k;
    k = this.qBB / i;
    if (m == 0)
    {
      i = 1;
      if (k != 0) {
        break label408;
      }
    }
    for (;;)
    {
      m = i * j;
      this.ext = 0;
      i = 4;
      for (;;)
      {
        if (i > 0)
        {
          i -= m;
          this.ext += 1;
          continue;
          i = m;
          if (m <= this.qBw.length) {
            break;
          }
          i = this.qBw.length;
          break;
        }
      }
      i = 0;
      while (i < this.ext)
      {
        Object localObject = new ArrayList();
        k = i * m;
        j = k;
        while ((j < this.qBw.length) && (j < k + m))
        {
          int n = CJ(this.qBw[j]);
          ((List)localObject).add(new SelectScanModeGrid.b(this.qBs[n], this.qBt[n], this.qBu[n], this.qBw[j], this.qBx.contains(Integer.valueOf(this.qBw[j]))));
          j += 1;
        }
        if (((List)localObject).size() > 0)
        {
          SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, 2130970661, null);
          localSelectScanModeGrid.setNumColumns(m);
          localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
          ((SelectScanModeGrid.a)localObject).qBf = this.qBq;
          localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
          this.qBC.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
          localSelectScanModeGrid.setOnItemClickListener(this.qBy);
          this.qBr.add(localSelectScanModeGrid);
        }
        i += 1;
      }
      cjk();
      AppMethodBeat.o(81338);
      return;
      label408:
      j = k;
    }
  }
  
  private void cjk()
  {
    AppMethodBeat.i(81339);
    if (this.qBr.size() <= 1)
    {
      this.qBD.setVisibility(4);
      AppMethodBeat.o(81339);
      return;
    }
    this.qBD.setVisibility(0);
    this.qBD.setDotCount(this.qBr.size());
    int i = this.qBC.getCurScreen();
    this.qBC.setToScreen(i);
    this.qBD.setSelectedDot(i);
    AppMethodBeat.o(81339);
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(81335);
    this.qBw = paramArrayOfInt;
    cjj();
    AppMethodBeat.o(81335);
  }
  
  public void setOnGridItemClickCallback(SelectScanModePanel.a parama)
  {
    this.qBE = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    AppMethodBeat.i(81337);
    this.qBq = CJ(paramInt);
    if (this.qBr != null)
    {
      int i = 0;
      while (i < this.qBr.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.qBr.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.qBl != null))
            {
              if (localb.qBk != paramInt) {
                break label153;
              }
              localb.qBl.setBackgroundResource(localb.qBj);
              localb.qBm = false;
              if (i > 0)
              {
                this.qBC.setToScreen(i);
                this.qBD.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label153:
              localb.qBl.setBackgroundResource(localb.qBi);
            }
          }
          locala.qBf = this.qBq;
          locala.notifyDataSetChanged();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(81337);
  }
  
  public void setShowRedDotModes(Set<Integer> paramSet)
  {
    AppMethodBeat.i(81336);
    if (paramSet != null)
    {
      this.qBx.clear();
      this.qBx.addAll(paramSet);
    }
    AppMethodBeat.o(81336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */