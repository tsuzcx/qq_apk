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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectScanModePanel
  extends LinearLayout
{
  private static int nNC = 85;
  private static int nND = 85;
  private Context context;
  private final int nNE = 0;
  private int nNF = 0;
  protected List<SelectScanModeGrid> nNG;
  private String[] nNH = new String[4];
  private int[] nNI = { R.g.scan_qr, R.g.scan_book, R.g.scan_street, R.k.scan_translation };
  private int[] nNJ = { R.g.scan_qr_hl, R.g.scan_book_hl, R.g.scan_street_hl, R.k.scan_translation_hl };
  private int[] nNK = { 1, 2, 5, 3 };
  private int[] nNL = { 1, 2, 5, 3 };
  private Set<Integer> nNM = new HashSet();
  private AdapterView.OnItemClickListener nNN;
  private int nNO = 0;
  private boolean nNP = false;
  private int nNQ;
  private int nNR;
  private MMFlipper nNS;
  private MMDotView nNT;
  private SelectScanModePanel.a nNU;
  
  public SelectScanModePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    View.inflate(this.context, R.i.select_scan_mode_panel, this);
    this.nNT = ((MMDotView)findViewById(R.h.select_scan_mode_panel_dot));
    this.nNH[0] = this.context.getString(R.l.scan_entry_qrcode);
    this.nNH[1] = r.eD(r.nPY, this.context.getString(R.l.scan_entry_image));
    this.nNH[2] = this.context.getString(R.l.scan_entry_street);
    this.nNH[3] = this.context.getString(R.l.scan_entry_ocr);
    y.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
    this.nNS = ((MMFlipper)findViewById(R.h.select_scan_mode_panel_flipper));
    paramContext = findViewById(R.h.select_scan_mode_panel_display_view);
    if (this.context.getResources().getConfiguration().orientation == 2)
    {
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.b(this.context, nND);
      paramContext.setLayoutParams(paramAttributeSet);
    }
    for (;;)
    {
      this.nNS.removeAllViews();
      this.nNS.setOnMeasureListener(new MMFlipper.a()
      {
        public final void dH(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          y.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + SelectScanModePanel.a(SelectScanModePanel.this));
          if ((SelectScanModePanel.a(SelectScanModePanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0)) {
            return;
          }
          SelectScanModePanel.b(SelectScanModePanel.this);
          SelectScanModePanel.a(SelectScanModePanel.this, paramAnonymousInt2);
          SelectScanModePanel.b(SelectScanModePanel.this, paramAnonymousInt1);
          SelectScanModePanel.c(SelectScanModePanel.this);
        }
      });
      this.nNS.setOnScreenChangedListener(new SelectScanModePanel.2(this));
      return;
      paramAttributeSet = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramAttributeSet.height = BackwardSupportUtil.b.b(this.context, nNC);
      paramContext.setLayoutParams(paramAttributeSet);
    }
  }
  
  private void bye()
  {
    if (this.nNN == null) {
      this.nNN = new SelectScanModePanel.3(this);
    }
    this.nNG = new ArrayList();
    if ((this.nNQ == 0) || (this.nNR == 0)) {
      return;
    }
    this.nNS.removeAllViews();
    int j = BackwardSupportUtil.b.b(this.context, 64.0F);
    int i = BackwardSupportUtil.b.b(this.context, 78.0F);
    j = this.nNQ / j;
    int k = this.nNR / i;
    if (j == 0) {
      i = 1;
    }
    int m;
    for (;;)
    {
      j = k;
      if (k == 0) {
        j = 1;
      }
      m = i * j;
      this.nNO = 0;
      i = 4;
      while (i > 0)
      {
        i -= m;
        this.nNO += 1;
      }
      i = j;
      if (j > this.nNL.length) {
        i = this.nNL.length;
      }
    }
    i = 0;
    while (i < this.nNO)
    {
      Object localObject = new ArrayList();
      k = i * m;
      j = k;
      while ((j < this.nNL.length) && (j < k + m))
      {
        int n = wR(this.nNL[j]);
        ((List)localObject).add(new SelectScanModeGrid.b(this.nNH[n], this.nNI[n], this.nNJ[n], this.nNL[j], this.nNM.contains(Integer.valueOf(this.nNL[j]))));
        j += 1;
      }
      if (((List)localObject).size() > 0)
      {
        SelectScanModeGrid localSelectScanModeGrid = (SelectScanModeGrid)inflate(this.context, R.i.select_scan_mode_grid, null);
        localSelectScanModeGrid.setNumColumns(m);
        localObject = new SelectScanModeGrid.a(this.context, (List)localObject);
        ((SelectScanModeGrid.a)localObject).nNu = this.nNF;
        localSelectScanModeGrid.setAdapter((ListAdapter)localObject);
        this.nNS.addView(localSelectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
        localSelectScanModeGrid.setOnItemClickListener(this.nNN);
        this.nNG.add(localSelectScanModeGrid);
      }
      i += 1;
    }
    if (this.nNG.size() <= 1)
    {
      this.nNT.setVisibility(4);
      return;
    }
    this.nNT.setVisibility(0);
    this.nNT.setDotCount(this.nNG.size());
    i = this.nNS.getCurScreen();
    this.nNS.setToScreen(i);
    this.nNT.setSelectedDot(i);
  }
  
  private int wR(int paramInt)
  {
    int i = 0;
    while (i < this.nNK.length)
    {
      if (this.nNK[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void setDisplayModes(int[] paramArrayOfInt)
  {
    this.nNL = paramArrayOfInt;
    bye();
  }
  
  public void setOnGridItemClickCallback(SelectScanModePanel.a parama)
  {
    this.nNU = parama;
  }
  
  public void setSelectedMode(int paramInt)
  {
    this.nNF = wR(paramInt);
    if (this.nNG != null)
    {
      int i = 0;
      while (i < this.nNG.size())
      {
        SelectScanModeGrid.a locala = (SelectScanModeGrid.a)((SelectScanModeGrid)this.nNG.get(i)).getAdapter();
        if (locala != null)
        {
          int j = 0;
          if (j < locala.getCount())
          {
            SelectScanModeGrid.b localb = (SelectScanModeGrid.b)locala.getItem(j);
            if ((localb != null) && (localb.nNA != null))
            {
              if (localb.nNz != paramInt) {
                break label147;
              }
              localb.nNA.setBackgroundResource(localb.nNy);
              localb.nNB = false;
              if (i > 0)
              {
                this.nNS.setToScreen(i);
                this.nNT.setSelectedDot(i);
              }
            }
            for (;;)
            {
              j += 1;
              break;
              label147:
              localb.nNA.setBackgroundResource(localb.nNx);
            }
          }
          locala.nNu = this.nNF;
          locala.notifyDataSetChanged();
        }
        i += 1;
      }
    }
  }
  
  public void setShowRedDotModes(Set<Integer> paramSet)
  {
    if (paramSet != null)
    {
      this.nNM.clear();
      this.nNM.addAll(paramSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SelectScanModePanel
 * JD-Core Version:    0.7.0.1
 */