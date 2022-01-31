package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.c;
import com.tencent.mm.plugin.card.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static int qBn = 215;
  private static int qBo = 158;
  private static boolean vVp = false;
  private boolean bRB;
  Context context;
  private List<f> gfG;
  private int qBA;
  private int qBB;
  public MMFlipper qBC;
  private MMDotView qBD;
  private boolean qBz;
  private SharedPreferences sp;
  private int vUJ;
  private final boolean[] vUS;
  private AppPanel.a vUT;
  private AppPanel.b vUU;
  private List<AppGrid> vUV;
  private int vUW;
  private int vUX;
  public a vUY;
  private int vUZ;
  private int vVa;
  private int vVb;
  private boolean vVc;
  private boolean vVd;
  private boolean vVe;
  private boolean vVf;
  boolean vVg;
  boolean vVh;
  boolean vVi;
  public boolean vVj;
  private Map<String, f> vVk;
  private boolean vVl;
  private final int vVm;
  private int vVn;
  private AppGrid.b vVo;
  private boolean vVq;
  private int vVr;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27752);
    this.vUS = new boolean[17];
    this.qBz = false;
    this.vUJ = 17;
    this.vUW = this.vUJ;
    this.bRB = false;
    this.vUZ = 0;
    this.vVa = 0;
    this.vVb = 0;
    this.vVc = false;
    this.vVd = false;
    this.vVe = false;
    this.vVf = false;
    this.vVg = false;
    this.vVh = false;
    this.vVi = false;
    this.vVj = false;
    this.vVk = null;
    this.vVl = true;
    this.gfG = new LinkedList();
    this.vVm = 2;
    this.vVn = -1;
    this.vVo = new AppPanel.4(this);
    this.vVq = true;
    this.vVr = -1;
    this.context = paramContext;
    AppMethodBeat.o(27752);
  }
  
  private void cjj()
  {
    AppMethodBeat.i(27772);
    ab.i("MicroMsg.AppPanel", "init app grid: %s, %s", new Object[] { Integer.valueOf(this.qBA), Integer.valueOf(this.qBB) });
    if ((this.qBA == 0) || (this.qBB == 0))
    {
      AppMethodBeat.o(27772);
      return;
    }
    int i = BackwardSupportUtil.b.b(this.context, 82.0F);
    int m = BackwardSupportUtil.b.b(this.context, 90.0F);
    dnT();
    int j = 4;
    if (!this.vVl) {
      j = this.qBA / i;
    }
    int k = this.qBB / m;
    i = k;
    if (k > 2) {
      i = 2;
    }
    m = (this.qBB - m * i) / (i + 1);
    ab.d("MicroMsg.AppPanel", "jacks spacing2 = %d", new Object[] { Integer.valueOf(m) });
    ab.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", new Object[] { Integer.valueOf(this.qBA), Integer.valueOf(this.qBB) });
    if (j == 0) {
      j = 1;
    }
    for (;;)
    {
      k = i;
      if (i == 0) {
        k = 1;
      }
      this.vUX = k;
      int n = j * k;
      int i1;
      if (this.vUY.vVD.value)
      {
        this.vUW = (this.vUJ + this.gfG.size());
        i1 = (int)Math.ceil(this.vUW / n);
        ab.i("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d visibleLocalAppCount = %d infoList = %d", new Object[] { Integer.valueOf(this.vUW), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(this.vUJ), Integer.valueOf(this.gfG.size()) });
        if (this.vVn != i1) {
          break label833;
        }
        ab.i("MicroMsg.AppPanel", "mLastPageCount == pageCount! [%s:%s]", new Object[] { Integer.valueOf(this.vVn), Integer.valueOf(i1) });
      }
      label833:
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          this.vUV = new ArrayList();
          this.qBC.removeAllViews();
        }
        long l2 = System.currentTimeMillis();
        long l1 = 0L;
        if (i1 > 10)
        {
          h.qsU.e(16776, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
          h.qsU.j(999L, 1L, 1L);
        }
        AppPanel.3 local3 = new AppPanel.3(this);
        com.tencent.mm.sdk.g.d.ysm.r(local3, 5000L);
        k = 0;
        if (k < i1)
        {
          if (k >= i1)
          {
            ab.e("MicroMsg.AppPanel", "my god! you see a ghost! %s", new Object[] { Integer.valueOf(i1) });
            h.qsU.j(999L, 0L, 1L);
            h.qsU.e(16776, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          }
        }
        else
        {
          com.tencent.mm.sdk.g.d.ysm.remove(local3);
          ab.i("MicroMsg.AppPanel", "[initAppGrid] cost:%sms inflateCost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Long.valueOf(l1) });
          localObject = this.vUV.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((AppGrid)((Iterator)localObject).next()).setOnAppSelectedListener(this.vVo);
          }
          this.vUW = this.vUJ;
          break;
        }
        long l3 = System.currentTimeMillis();
        if ((i == 0) && (this.vUV.size() > k) && (this.vUV.get(k) != null)) {}
        for (Object localObject = (AppGrid)this.vUV.get(k);; localObject = (AppGrid)inflate(this.context, 2130968756, null))
        {
          ab.i("MicroMsg.AppPanel", "[initAppGrid] i:%s cost:%sms", new Object[] { Integer.valueOf(k), Long.valueOf(System.currentTimeMillis() - l2) });
          l1 += System.currentTimeMillis() - l3;
          ((AppGrid)localObject).d(this.gfG, this.vVk);
          ((AppGrid)localObject).b(k, this.vUW, n, i1, j, this.vUJ);
          ((AppGrid)localObject).Me(m);
          if (i != 0)
          {
            this.qBC.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            this.vUV.add(localObject);
          }
          k += 1;
          break;
        }
        cjk();
        this.vVn = i1;
        requestLayout();
        AppMethodBeat.o(27772);
        return;
      }
    }
  }
  
  private void cjk()
  {
    AppMethodBeat.i(27773);
    if (this.vUV.size() <= 1)
    {
      this.qBD.setVisibility(4);
      AppMethodBeat.o(27773);
      return;
    }
    this.qBD.setVisibility(0);
    this.qBD.setDotCount(this.vUV.size());
    int i = this.qBC.getCurScreen();
    this.qBC.setToScreen(i);
    this.qBD.setSelectedDot(i);
    AppMethodBeat.o(27773);
  }
  
  private void dnU()
  {
    AppMethodBeat.i(27770);
    ab.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.vVn = -1;
    this.qBC.removeAllViews();
    this.qBC.setOnMeasureListener(new AppPanel.1(this));
    this.qBC.setOnScreenChangedListener(new AppPanel.2(this));
    dnW();
    AppMethodBeat.o(27770);
  }
  
  private void dnV()
  {
    AppMethodBeat.i(27775);
    ab.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.qBz = false;
    this.qBC.setToScreen(0);
    dnU();
    requestLayout();
    AppMethodBeat.o(27775);
  }
  
  private void dnW()
  {
    AppMethodBeat.i(27777);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.vVq)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      ab.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(2131821491);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.b.b(this.context, qBo);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.vVq = false;
      AppMethodBeat.o(27777);
      return;
      label79:
      ab.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(qBn) });
      localView = findViewById(2131821491);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean dnX()
  {
    AppMethodBeat.i(27780);
    if (this.vVj)
    {
      AppMethodBeat.o(27780);
      return false;
    }
    b localb = (b)com.tencent.mm.kernel.g.E(b.class);
    if (localb != null)
    {
      if ((localb.bcu()) && (localb.bcx() > 0))
      {
        AppMethodBeat.o(27780);
        return true;
      }
      AppMethodBeat.o(27780);
      return false;
    }
    AppMethodBeat.o(27780);
    return false;
  }
  
  private void eo(List<f> paramList)
  {
    AppMethodBeat.i(27755);
    boolean bool1 = this.vVc;
    this.vVc = false;
    boolean bool2 = this.vVd;
    boolean bool3 = this.vVe;
    boolean bool4 = this.vVf;
    this.vVd = false;
    this.vVe = false;
    this.vVf = false;
    int j = com.tencent.mm.pluginsdk.model.app.g.LB(this.vVb);
    int k = this.vVb;
    if (paramList != null) {}
    for (int i = paramList.size();; i = -1)
    {
      ab.i("MicroMsg.AppPanel", "serviceCount, %d, %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.vVk = new HashMap();
      if (j <= 0) {
        break label485;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      for (i = 0; i < paramList.size(); i = j + 1)
      {
        f localf = (f)paramList.get(i);
        j = i;
        if (localf != null)
        {
          j = i;
          if (localf.field_appId != null)
          {
            j = i;
            if (localf.dlw())
            {
              if (!localf.dly()) {
                this.vVc = true;
              }
              j = i;
              if (f.vKX.equals(localf.field_appId))
              {
                this.vVk.put(f.vKX, localf);
                ab.i("MicroMsg.AppPanel", "remittance: %s, %s", new Object[] { Boolean.valueOf(this.vVh), Boolean.valueOf(this.vVd) });
                if (!this.vVh) {
                  this.vVd = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
              i = j;
              if (f.vKZ.equals(localf.field_appId))
              {
                this.vVk.put(f.vKZ, localf);
                ab.i("MicroMsg.AppPanel", "luckyMoney: %s, %s", new Object[] { Boolean.valueOf(this.vVg), Boolean.valueOf(this.vVe) });
                if (!this.vVg) {
                  this.vVe = true;
                }
                paramList.remove(j);
                i = j - 1;
              }
              j = i;
              if (f.vLa.equals(localf.field_appId))
              {
                this.vVk.put(f.vLa, localf);
                ab.i("MicroMsg.AppPanel", "aa: %s, %s", new Object[] { Boolean.valueOf(this.vVg), Boolean.valueOf(this.vVe) });
                if (!this.vVi) {
                  this.vVf = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
            }
          }
        }
      }
    }
    h.qsU.cT(965, 36);
    label485:
    ab.i("MicroMsg.AppPanel", "hasService %b", new Object[] { Boolean.valueOf(this.vVc) });
    if ((bool1 != this.vVc) || (bool2 != this.vVd) || (bool3 != this.vVe) || (bool4 != this.vVf))
    {
      this.vUY.pl(this.vVc);
      this.vUY.pm(this.vVd);
      this.vUY.pp(this.vVe);
      this.vUY.pq(this.vVf);
      dnT();
    }
    AppMethodBeat.o(27755);
  }
  
  private static void ep(List<f> paramList)
  {
    AppMethodBeat.i(27779);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(27779);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      f localf = (f)paramList.get(i);
      if ((localf != null) && (f.vKY.equals(localf.field_appId)))
      {
        paramList.remove(localf);
        ab.i("MicroMsg.AppPanel", "do remove card");
        AppMethodBeat.o(27779);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(27779);
  }
  
  private int getPortHeightPX()
  {
    AppMethodBeat.i(27778);
    if (this.vVr > 0)
    {
      i = this.vVr;
      AppMethodBeat.o(27778);
      return i;
    }
    int i = BackwardSupportUtil.b.b(this.context, qBn);
    AppMethodBeat.o(27778);
    return i;
  }
  
  private int getScreenOrientation()
  {
    AppMethodBeat.i(27769);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {}
    for (int i = 1;; i = 2)
    {
      AppMethodBeat.o(27769);
      return i;
    }
  }
  
  public final void AD()
  {
    AppMethodBeat.i(27776);
    ab.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    dnW();
    dnV();
    AppMethodBeat.o(27776);
  }
  
  public final void dnL()
  {
    AppMethodBeat.i(27756);
    this.vUY.doa();
    this.vVg = false;
    this.vVh = false;
    this.vVi = false;
    this.vVj = false;
    dnM();
    this.vUY.pl(this.vVc);
    this.vUY.pm(this.vVd);
    this.vUY.pp(this.vVe);
    this.vUY.pq(this.vVf);
    dnT();
    AppMethodBeat.o(27756);
  }
  
  public final void dnM()
  {
    AppMethodBeat.i(27757);
    com.tencent.mm.m.g.Nr();
    if (c.Nb() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.vUY.dob();
      this.vUY.pn(bool);
      bool = com.tencent.mm.bq.d.ahR("location");
      this.vUY.po(bool);
      this.vUY.doc();
      AppMethodBeat.o(27757);
      return;
    }
  }
  
  public final void dnN()
  {
    AppMethodBeat.i(27758);
    this.vUY.vVx.value = false;
    dnT();
    AppMethodBeat.o(27758);
  }
  
  public final void dnO()
  {
    AppMethodBeat.i(27763);
    this.vUY.vVE.value = false;
    dnT();
    ab.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(27763);
  }
  
  public final void dnP()
  {
    AppMethodBeat.i(27764);
    this.vUY.vVJ.value = false;
    dnT();
    AppMethodBeat.o(27764);
  }
  
  public final void dnQ()
  {
    AppMethodBeat.i(27765);
    this.vUY.vVD.value = false;
    dnT();
    AppMethodBeat.o(27765);
  }
  
  public final void dnR()
  {
    AppMethodBeat.i(27766);
    this.vUY.vVL.value = false;
    dnT();
    AppMethodBeat.o(27766);
  }
  
  public final void dnS()
  {
    AppMethodBeat.i(27767);
    this.vUY.vVR.value = false;
    dnT();
    AppMethodBeat.o(27767);
  }
  
  public final void dnT()
  {
    AppMethodBeat.i(27768);
    int j = this.vUS.length;
    int i = 0;
    while (i < j)
    {
      this.vUS[i] = true;
      i += 1;
    }
    if (!this.vUY.vVw.value) {
      this.vUS[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.vUY.vVv.value)
      {
        this.vUS[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.vUY.vVR.value)
      {
        this.vUS[16] = false;
        j = i + 1;
      }
      if (this.vUY.vVJ.value)
      {
        i = j;
        if (this.vUY.vVK.value) {}
      }
      else
      {
        this.vUS[6] = false;
        i = j + 1;
      }
      j = i;
      if (!this.vUY.vVB.value)
      {
        this.vUS[14] = false;
        j = i + 1;
      }
      i = j;
      if (!this.vUY.vVC.value)
      {
        ab.i("MicroMsg.AppPanel", "disable remittance");
        this.vUS[8] = false;
        i = j + 1;
      }
      j = i;
      if (!this.vUY.vVx.value)
      {
        this.vUS[12] = false;
        j = i + 1;
      }
      i = j;
      if (!this.vUY.vVL.value)
      {
        this.vUS[13] = false;
        i = j + 1;
      }
      j = i;
      if (!this.vUY.vVO.value)
      {
        this.vUS[3] = false;
        j = i + 1;
      }
      i = j;
      if (!this.vUY.vVy.value)
      {
        this.vUS[11] = false;
        i = j + 1;
      }
      j = i;
      if (!this.vUY.vVE.value)
      {
        this.vUS[5] = false;
        j = i + 1;
      }
      if (this.vUY.vVG.value)
      {
        i = j;
        if (this.vUY.vVF.value) {}
      }
      else
      {
        this.vUS[4] = false;
        i = j + 1;
      }
      if (this.vUY.vVA.value)
      {
        j = i;
        if (this.vUY.vVz.value) {}
      }
      else
      {
        this.vUS[2] = false;
        j = i + 1;
      }
      if (this.vUY.vVI.value)
      {
        i = j;
        if (this.vUY.vVH.value) {}
      }
      else
      {
        this.vUS[10] = false;
        i = j + 1;
      }
      j = i;
      if (!this.vUY.vVN.value)
      {
        ab.i("MicroMsg.AppPanel", "disable lucky money");
        this.vUS[7] = false;
        j = i + 1;
      }
      i = j;
      if (!this.vUY.vVP.value)
      {
        this.vUS[15] = false;
        i = j + 1;
      }
      this.vUS[9] = false;
      this.vUJ = (17 - (i + 1));
      AppMethodBeat.o(27768);
      return;
    }
  }
  
  public int getPageMaxRowCount()
  {
    if (this.vUX == 0)
    {
      int i = (this.vUW + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.vUX;
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(27753);
    ab.i("MicroMsg.AppPanel", "init: %s", new Object[] { Integer.valueOf(paramInt) });
    this.vUY = new a();
    this.vVb = paramInt;
    Object localObject = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (((Display)localObject).getWidth() < ((Display)localObject).getHeight())
    {
      this.vUZ = ((Display)localObject).getWidth();
      this.vVa = ((Display)localObject).getHeight();
      View.inflate(this.context, 2130968760, this);
      this.qBD = ((MMDotView)findViewById(2131821493));
      this.qBC = ((MMFlipper)findViewById(2131821492));
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.m.g.Nq().getValue("ShowAPPSuggestion");
        if ((!bo.isNullOrNil((String)localObject)) && (Integer.valueOf((String)localObject).intValue() == 1)) {
          continue;
        }
        this.gfG = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vVb);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.gfG = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vVb);
        continue;
      }
      if (!dnX()) {
        ep(this.gfG);
      }
      eo(this.gfG);
      dnU();
      dnL();
      AppMethodBeat.o(27753);
      return;
      this.vUZ = ((Display)localObject).getHeight();
      this.vVa = ((Display)localObject).getWidth();
      break;
      this.gfG = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.vVb);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(27774);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ab.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label76;
      }
    }
    label76:
    for (this.vVl = true;; this.vVl = false)
    {
      setNeedRefreshHeight(true);
      dnV();
      AppMethodBeat.o(27774);
      return;
    }
  }
  
  public final void ph(boolean paramBoolean)
  {
    AppMethodBeat.i(27759);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.vUY.vVz.value = paramBoolean;
      dnT();
      ab.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.vUY.vVA.value);
      AppMethodBeat.o(27759);
      return;
    }
  }
  
  public final void pi(boolean paramBoolean)
  {
    AppMethodBeat.i(27760);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.vUY.vVF.value = paramBoolean;
      dnT();
      ab.d("MicroMsg.AppPanel", "enable " + this.vUY.vVG.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(27760);
      return;
    }
  }
  
  public final void pj(boolean paramBoolean)
  {
    AppMethodBeat.i(27761);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.vUY.vVO.value = paramBoolean;
      dnT();
      ab.d("MicroMsg.AppPanel", "enable " + this.vUY.vVO.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(27761);
      return;
    }
  }
  
  public final void pk(boolean paramBoolean)
  {
    AppMethodBeat.i(27762);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.vUY.vVH.value = paramBoolean;
      dnT();
      AppMethodBeat.o(27762);
      return;
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(27771);
    ab.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.vVb) });
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.m.g.Nq().getValue("ShowAPPSuggestion");
        if ((!bo.isNullOrNil(str)) && (Integer.valueOf(str).intValue() == 1)) {
          continue;
        }
        this.gfG = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vVb);
        ab.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
      }
      catch (Exception localException)
      {
        int i;
        ab.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.gfG = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.vVb);
        continue;
      }
      if (!dnX()) {
        ep(this.gfG);
      }
      eo(this.gfG);
      if (this.vUY != null)
      {
        this.vUY.pl(this.vVc);
        this.vUY.pm(this.vVd);
        this.vUY.pp(this.vVe);
        this.vUY.pq(this.vVf);
      }
      i = this.qBC.getCurScreen();
      cjj();
      this.qBC.setToScreen(i);
      this.qBD.setSelectedDot(i);
      AppMethodBeat.o(27771);
      return;
      ab.i("MicroMsg.AppPanel", "jacks show App Suggestion");
      this.gfG = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.vVb);
    }
  }
  
  public void setAppPanelListener(AppPanel.a parama)
  {
    this.vUT = parama;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.vVq = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(AppPanel.b paramb)
  {
    this.vUU = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (qBn != paramInt)
    {
      qBn = paramInt;
      this.vVq = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.vVr != paramInt)
    {
      this.vVr = paramInt;
      this.vVq = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(27754);
    ab.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.vVb = paramInt;
    AppMethodBeat.o(27754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */