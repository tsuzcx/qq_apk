package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.j;
import com.tencent.mm.az.k;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements f
{
  private boolean nUd;
  private SettingsSelectBgUI.a nVR;
  private GridView nVS;
  private j nVT;
  private List<j> nVU = new ArrayList();
  private am nVV = new am(new SettingsSelectBgUI.1(this), true);
  private String username;
  
  private void cr(List<j> paramList)
  {
    if (paramList.size() > 0)
    {
      this.nVT = ((j)paramList.remove(0));
      g.Dk().a(this.nVT, 0);
      return;
    }
    this.nVT = null;
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_select_bg;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_chatting_bg_select_bg);
    setBackBtn(new SettingsSelectBgUI.2(this));
    this.nUd = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.nVV.S(20L, 20L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    g.Dk().a(159, this);
    g.Dk().a(160, this);
    if (g.DP().isSDCardAvailable())
    {
      paramBundle = new k(1);
      g.Dk().a(paramBundle, 0);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.nVT != null)
    {
      g.Dk().c(this.nVT);
      r.PK().bt(this.nVT.ewN, 1);
    }
    List localList = this.nVU;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      r.PK().bt(localj.ewN, 1);
    }
    localList.clear();
    g.Dk().b(159, this);
    g.Dk().b(160, this);
    this.nVR.bcS();
    r.PK().d(this.nVR);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((!(paramm instanceof o)) || (((o)paramm).KF() != 1)) {
      y.d("MicroMsg.SettingsSelectBgUI", "another scene");
    }
    do
    {
      int i;
      do
      {
        return;
        i = paramm.getType();
      } while ((i != 159) && (i != 160));
      if (i == 160) {
        cr(this.nVU);
      }
    } while ((paramInt1 != 0) || (paramInt2 == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI
 * JD-Core Version:    0.7.0.1
 */