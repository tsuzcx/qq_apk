package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.br.d;
import com.tencent.mm.m.c;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static int nNC = 215;
  private static int nND = 158;
  private static boolean sek = false;
  Context context;
  private boolean dBn = false;
  private SharedPreferences dnD;
  private List<f> ePL = new LinkedList();
  private boolean nNP = false;
  private int nNQ;
  private int nNR;
  public MMFlipper nNS;
  private MMDotView nNT;
  private int sdE = 17;
  private final boolean[] sdN = new boolean[17];
  private AppPanel.a sdO;
  private AppPanel.b sdP;
  private List<AppGrid> sdQ;
  private int sdR = this.sdE;
  private int sdS;
  public a sdT;
  private int sdU = 0;
  private int sdV = 0;
  private int sdW = 0;
  private boolean sdX = false;
  private boolean sdY = false;
  private boolean sdZ = false;
  private boolean sea = false;
  boolean seb = false;
  boolean sec = false;
  boolean sed = false;
  public boolean see = false;
  private Map<String, f> sef = null;
  private boolean seg = true;
  private final int seh = 2;
  private int sei = -1;
  private AppGrid.b sej = new AppPanel.3(this);
  private boolean sel = true;
  private int sem = -1;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private void bye()
  {
    if ((this.nNQ == 0) || (this.nNR == 0)) {
      return;
    }
    int i = BackwardSupportUtil.b.b(this.context, 82.0F);
    int m = BackwardSupportUtil.b.b(this.context, 90.0F);
    cmV();
    int j = 4;
    if (!this.seg) {
      j = this.nNQ / i;
    }
    int k = this.nNR / m;
    i = k;
    if (k > 2) {
      i = 2;
    }
    m = (this.nNR - m * i) / (i + 1);
    y.d("MicroMsg.AppPanel", "jacks spacing2 = %d", new Object[] { Integer.valueOf(m) });
    y.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", new Object[] { Integer.valueOf(this.nNQ), Integer.valueOf(this.nNR) });
    if (j == 0) {
      j = 1;
    }
    for (;;)
    {
      k = i;
      if (i == 0) {
        k = 1;
      }
      this.sdS = k;
      int i1 = j * k;
      int n;
      if (this.sdT.sez.value)
      {
        this.sdR = (this.sdE + this.ePL.size());
        n = (int)Math.ceil(this.sdR / i1);
        y.i("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d visibleLocalAppCount = %d infoList = %d", new Object[] { Integer.valueOf(this.sdR), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(this.sdE), Integer.valueOf(this.ePL.size()) });
        if (this.sei != n) {
          break label851;
        }
        y.i("MicroMsg.AppPanel", "mLastPageCount == pageCount! [%s:%s]", new Object[] { Integer.valueOf(this.sei), Integer.valueOf(n) });
      }
      label851:
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          this.sdQ = new ArrayList();
          this.nNS.removeAllViews();
        }
        long l2 = System.currentTimeMillis();
        k = 0;
        long l1 = 0L;
        label342:
        if (k < n)
        {
          long l3 = System.currentTimeMillis();
          if ((i == 0) && (this.sdQ.size() > k) && (this.sdQ.get(k) != null)) {}
          for (localObject = (AppGrid)this.sdQ.get(k);; localObject = (AppGrid)inflate(this.context, R.i.app_grid, null))
          {
            l1 += System.currentTimeMillis() - l3;
            List localList = this.ePL;
            Map localMap = this.sef;
            ((AppGrid)localObject).sdF = new AppGrid.a((AppGrid)localObject, ((AppGrid)localObject).context, localList, localMap);
            ((AppGrid)localObject).setBackgroundResource(0);
            ((AppGrid)localObject).setAdapter(((AppGrid)localObject).sdF);
            ((AppGrid)localObject).setOnItemClickListener(((AppGrid)localObject).idL);
            ((AppGrid)localObject).setOnItemLongClickListener(((AppGrid)localObject).kec);
            int i2 = BackwardSupportUtil.b.b(((AppGrid)localObject).context, 16.0F);
            int i3 = BackwardSupportUtil.b.b(((AppGrid)localObject).context, 16.0F);
            ((AppGrid)localObject).setPadding(i2, BackwardSupportUtil.b.b(((AppGrid)localObject).context, 6.0F), i3, 0);
            i2 = this.sdR;
            i3 = this.sdE;
            ((AppGrid)localObject).sdD = k;
            ((AppGrid)localObject).sdA = i2;
            ((AppGrid)localObject).sdB = i1;
            ((AppGrid)localObject).sdC = n;
            ((AppGrid)localObject).sdE = i3;
            ((AppGrid)localObject).setNumColumns(j);
            if (m > 0)
            {
              ((AppGrid)localObject).setPadding(BackwardSupportUtil.b.b(((AppGrid)localObject).context, 16.0F), m, BackwardSupportUtil.b.b(((AppGrid)localObject).context, 16.0F), 0);
              ((AppGrid)localObject).setVerticalSpacing(m / 2);
            }
            if (i != 0)
            {
              this.nNS.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
              this.sdQ.add(localObject);
            }
            k += 1;
            break label342;
            this.sdR = this.sdE;
            break;
          }
        }
        y.i("MicroMsg.AppPanel", "[initAppGrid] cost:%sms inflateCost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Long.valueOf(l1) });
        Object localObject = this.sdQ.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((AppGrid)((Iterator)localObject).next()).setOnAppSelectedListener(this.sej);
        }
        if (this.sdQ.size() <= 1) {
          this.nNT.setVisibility(4);
        }
        for (;;)
        {
          this.sei = n;
          requestLayout();
          return;
          this.nNT.setVisibility(0);
          this.nNT.setDotCount(this.sdQ.size());
          i = this.nNS.getCurScreen();
          this.nNS.setToScreen(i);
          this.nNT.setSelectedDot(i);
        }
      }
    }
  }
  
  private void cmW()
  {
    y.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.sei = -1;
    this.nNS.removeAllViews();
    this.nNS.setOnMeasureListener(new MMFlipper.a()
    {
      public final void dH(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        y.i("MicroMsg.AppPanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + AppPanel.a(AppPanel.this));
        if ((AppPanel.a(AppPanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0)) {
            y.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
          }
          return;
        }
        if (AppPanel.b(AppPanel.this) == 2) {
          y.d("MicroMsg.AppPanel", "landspace");
        }
        for (;;)
        {
          AppPanel.c(AppPanel.this);
          AppPanel.a(AppPanel.this, paramAnonymousInt2);
          AppPanel.b(AppPanel.this, paramAnonymousInt1);
          AppPanel.d(AppPanel.this);
          return;
          y.d("MicroMsg.AppPanel", "portrait");
        }
      }
    });
    this.nNS.setOnScreenChangedListener(new AppPanel.2(this));
    cmX();
  }
  
  private boolean cmY()
  {
    if (this.see) {
      return false;
    }
    b localb = (b)com.tencent.mm.kernel.g.r(b.class);
    if (localb != null) {
      return (localb.aAJ()) && (localb.aAM() > 0);
    }
    return false;
  }
  
  private void dg(List<f> paramList)
  {
    boolean bool1 = this.sdX;
    this.sdX = false;
    boolean bool2 = this.sdY;
    boolean bool3 = this.sdZ;
    boolean bool4 = this.sea;
    this.sdY = false;
    this.sdZ = false;
    this.sea = false;
    int i = this.sdW;
    new ArrayList();
    label123:
    Object localObject;
    if (com.tencent.mm.plugin.z.a.a.a.bru() == null)
    {
      y.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
      i = 0;
      y.d("MicroMsg.AppPanel", "serviceCount, %d", new Object[] { Integer.valueOf(i) });
      this.sef = new HashMap();
      if ((i <= 0) || (paramList == null) || (paramList.size() <= 0)) {
        break label410;
      }
      i = 0;
      if (i >= paramList.size()) {
        break label410;
      }
      localObject = (f)paramList.get(i);
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((f)localObject).field_appId != null)
        {
          j = i;
          if (((f)localObject).ckN()) {
            if ((((f)localObject).field_serviceAppInfoFlag & 0x1) == 0) {
              break label405;
            }
          }
        }
      }
    }
    label405:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        this.sdX = true;
      }
      j = i;
      if (f.rUa.equals(((f)localObject).field_appId))
      {
        this.sef.put(f.rUa, localObject);
        if (!this.sec) {
          this.sdY = true;
        }
        paramList.remove(i);
        j = i - 1;
      }
      i = j;
      if (f.rUc.equals(((f)localObject).field_appId))
      {
        this.sef.put(f.rUc, localObject);
        if (!this.seb) {
          this.sdZ = true;
        }
        paramList.remove(j);
        i = j - 1;
      }
      j = i;
      if (f.rUd.equals(((f)localObject).field_appId))
      {
        this.sef.put(f.rUd, localObject);
        if (!this.sed) {
          this.sea = true;
        }
        paramList.remove(i);
        j = i - 1;
      }
      i = j + 1;
      break label123;
      localObject = com.tencent.mm.plugin.z.a.a.a.bru().dz(0, i);
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((Cursor)localObject).getCount();
      ((Cursor)localObject).close();
      break;
    }
    label410:
    y.d("MicroMsg.AppPanel", "hasService %b", new Object[] { Boolean.valueOf(this.sdX) });
    if ((bool1 != this.sdX) || (bool2 != this.sdY) || (bool3 != this.sdZ) || (bool4 != this.sea))
    {
      this.sdT.lV(this.sdX);
      this.sdT.lW(this.sdY);
      this.sdT.lX(this.sdZ);
      this.sdT.lY(this.sea);
      cmV();
    }
  }
  
  private static void dh(List<f> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        f localf = (f)paramList.get(i);
        if ((localf != null) && (f.rUb.equals(localf.field_appId)))
        {
          paramList.remove(localf);
          return;
        }
        i += 1;
      }
    }
  }
  
  private int getPortHeightPX()
  {
    if (this.sem > 0) {
      return this.sem;
    }
    return BackwardSupportUtil.b.b(this.context, nNC);
  }
  
  private int getScreenOrientation()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {
      return 1;
    }
    return 2;
  }
  
  public final void cmT()
  {
    a locala = this.sdT;
    locala.sep.value = true;
    locala.seq.value = true;
    locala.ser.value = true;
    locala.ses.value = true;
    locala.set.value = true;
    locala.seu.value = true;
    locala.sev.value = true;
    locala.seF.value = true;
    locala.seD.value = true;
    locala.sew.value = true;
    locala.sey.value = true;
    locala.sez.value = true;
    locala.seA.value = true;
    locala.seB.value = true;
    locala.seC.value = true;
    locala.seE.value = true;
    locala.seG.value = true;
    locala.seH.value = false;
    locala.seI.value = true;
    locala.seJ.value = true;
    locala.seL.value = true;
    locala.seM.value = true;
    locala.seL.value = false;
    locala.seN.value = true;
    this.seb = false;
    this.sec = false;
    this.sed = false;
    this.see = false;
    cmU();
    this.sdT.lV(this.sdX);
    this.sdT.lW(this.sdY);
    this.sdT.lX(this.sdZ);
    this.sdT.lY(this.sea);
    cmV();
  }
  
  public final void cmU()
  {
    com.tencent.mm.m.g.AB();
    if (c.Am() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.sdT.sev.value = true;
      this.sdT.seC.value = bool;
      bool = d.SP("location");
      this.sdT.seG.value = bool;
      this.sdT.seE.value = true;
      return;
    }
  }
  
  public final void cmV()
  {
    int j = this.sdN.length;
    int i = 0;
    while (i < j)
    {
      this.sdN[i] = true;
      i += 1;
    }
    if (!this.sdT.ser.value) {
      this.sdN[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.sdT.seq.value)
      {
        this.sdN[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sdT.seN.value)
      {
        this.sdN[16] = false;
        j = i + 1;
      }
      if (this.sdT.seF.value)
      {
        i = j;
        if (this.sdT.seG.value) {}
      }
      else
      {
        this.sdN[6] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sdT.sew.value)
      {
        this.sdN[14] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sdT.sey.value)
      {
        this.sdN[8] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sdT.ses.value)
      {
        this.sdN[12] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sdT.seH.value)
      {
        this.sdN[13] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sdT.seK.value)
      {
        this.sdN[3] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sdT.set.value)
      {
        this.sdN[11] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sdT.seA.value)
      {
        this.sdN[5] = false;
        j = i + 1;
      }
      if (this.sdT.seC.value)
      {
        i = j;
        if (this.sdT.seB.value) {}
      }
      else
      {
        this.sdN[4] = false;
        i = j + 1;
      }
      if (this.sdT.sev.value)
      {
        j = i;
        if (this.sdT.seu.value) {}
      }
      else
      {
        this.sdN[2] = false;
        j = i + 1;
      }
      if (this.sdT.seE.value)
      {
        i = j;
        if (this.sdT.seD.value) {}
      }
      else
      {
        this.sdN[10] = false;
        i = j + 1;
      }
      j = i;
      if (!this.sdT.seJ.value)
      {
        this.sdN[7] = false;
        j = i + 1;
      }
      i = j;
      if (!this.sdT.seL.value)
      {
        this.sdN[15] = false;
        i = j + 1;
      }
      this.sdN[9] = false;
      this.sdE = (17 - (i + 1));
      return;
    }
  }
  
  public final void cmX()
  {
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.sel)
    {
      if (getScreenOrientation() != 2) {
        break label67;
      }
      y.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(R.h.app_panel_display_view);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.b.b(this.context, nND);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.sel = false;
      return;
      label67:
      y.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(nNC) });
      localView = findViewById(R.h.app_panel_display_view);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public int getPageMaxRowCount()
  {
    if (this.sdS == 0)
    {
      int i = (this.sdR + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.sdS;
  }
  
  public final void init(int paramInt)
  {
    this.sdT = new a();
    this.sdW = paramInt;
    Object localObject = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (((Display)localObject).getWidth() < ((Display)localObject).getHeight())
    {
      this.sdU = ((Display)localObject).getWidth();
      this.sdV = ((Display)localObject).getHeight();
      View.inflate(this.context, R.i.app_panel, this);
      this.nNT = ((MMDotView)findViewById(R.h.app_panel_dot));
      this.nNS = ((MMFlipper)findViewById(R.h.app_panel_flipper));
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.m.g.AA().getValue("ShowAPPSuggestion");
        if ((!bk.bl((String)localObject)) && (Integer.valueOf((String)localObject).intValue() == 1)) {
          continue;
        }
        this.ePL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sdW);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.ePL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sdW);
        continue;
      }
      if (!cmY()) {
        dh(this.ePL);
      }
      dg(this.ePL);
      cmW();
      cmT();
      return;
      this.sdU = ((Display)localObject).getHeight();
      this.sdV = ((Display)localObject).getWidth();
      break;
      this.ePL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.sdW);
    }
  }
  
  public final void lU(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.sdT.seB.value = paramBoolean;
      cmV();
      y.d("MicroMsg.AppPanel", "enable " + this.sdT.seC.value + " isVoipAudioEnable " + paramBoolean);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      y.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label64;
      }
    }
    label64:
    for (this.seg = true;; this.seg = false)
    {
      setNeedRefreshHeight(true);
      si();
      return;
    }
  }
  
  public final void refresh()
  {
    y.i("MicroMsg.AppPanel", "app panel refleshed");
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.m.g.AA().getValue("ShowAPPSuggestion");
        if ((!bk.bl(str)) && (Integer.valueOf(str).intValue() == 1)) {
          continue;
        }
        this.ePL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sdW);
        y.d("MicroMsg.AppPanel", "jacks not show App Suggestion");
      }
      catch (Exception localException)
      {
        int i;
        y.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.ePL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.sdW);
        continue;
      }
      if (!cmY()) {
        dh(this.ePL);
      }
      dg(this.ePL);
      if (this.sdT != null)
      {
        this.sdT.lV(this.sdX);
        this.sdT.lW(this.sdY);
        this.sdT.lX(this.sdZ);
        this.sdT.lY(this.sea);
      }
      i = this.nNS.getCurScreen();
      bye();
      this.nNS.setToScreen(i);
      this.nNT.setSelectedDot(i);
      return;
      y.d("MicroMsg.AppPanel", "jacks show App Suggestion");
      this.ePL = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.sdW);
    }
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    this.sdO = parama;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.sel = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(AppPanel.b paramb)
  {
    this.sdP = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (nNC != paramInt)
    {
      nNC = paramInt;
      this.sel = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.sem != paramInt)
    {
      this.sem = paramInt;
      this.sel = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    this.sdW = paramInt;
  }
  
  public final void si()
  {
    y.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.nNP = false;
    this.nNS.setToScreen(0);
    cmW();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */