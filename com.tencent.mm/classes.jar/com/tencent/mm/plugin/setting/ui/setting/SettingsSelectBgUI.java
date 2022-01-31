package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.k;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsSelectBgUI
  extends MMActivity
  implements f
{
  private boolean qId;
  private SettingsSelectBgUI.a qKa;
  private GridView qKb;
  private j qKc;
  private List<j> qKd;
  private ap qKe;
  private String username;
  
  public SettingsSelectBgUI()
  {
    AppMethodBeat.i(127480);
    this.qKd = new ArrayList();
    this.qKe = new ap(new SettingsSelectBgUI.1(this), true);
    AppMethodBeat.o(127480);
  }
  
  private void cV(List<j> paramList)
  {
    AppMethodBeat.i(127485);
    if (paramList.size() > 0)
    {
      this.qKc = ((j)paramList.remove(0));
      g.Rc().a(this.qKc, 0);
      AppMethodBeat.o(127485);
      return;
    }
    this.qKc = null;
    AppMethodBeat.o(127485);
  }
  
  public int getLayoutId()
  {
    return 2130970701;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127483);
    setMMTitle(2131303230);
    setBackBtn(new SettingsSelectBgUI.2(this));
    this.qId = getIntent().getBooleanExtra("isApplyToAll", true);
    this.username = getIntent().getStringExtra("username");
    this.qKe.ag(20L, 20L);
    AppMethodBeat.o(127483);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127481);
    super.onCreate(paramBundle);
    initView();
    g.Rc().a(159, this);
    g.Rc().a(160, this);
    if (g.RL().isSDCardAvailable())
    {
      paramBundle = new k(1);
      g.Rc().a(paramBundle, 0);
    }
    AppMethodBeat.o(127481);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127482);
    super.onDestroy();
    if (this.qKc != null)
    {
      g.Rc().a(this.qKc);
      r.aiP().cD(this.qKc.fMD, 1);
    }
    List localList = this.qKd;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      r.aiP().cD(localj.fMD, 1);
    }
    localList.clear();
    g.Rc().b(159, this);
    g.Rc().b(160, this);
    this.qKa.bKb();
    r.aiP().remove(this.qKa);
    AppMethodBeat.o(127482);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127484);
    if ((!(paramm instanceof o)) || (((o)paramm).ads() != 1))
    {
      ab.d("MicroMsg.SettingsSelectBgUI", "another scene");
      AppMethodBeat.o(127484);
      return;
    }
    int i = paramm.getType();
    if ((i != 159) && (i != 160))
    {
      AppMethodBeat.o(127484);
      return;
    }
    if (i == 160) {
      cV(this.qKd);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(127484);
      return;
    }
    AppMethodBeat.o(127484);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI
 * JD-Core Version:    0.7.0.1
 */