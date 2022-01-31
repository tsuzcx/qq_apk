package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.o;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ArtistUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private ListView gJa;
  ak loX;
  private String nZZ;
  private f rEJ;
  private ArtistHeader rEK;
  private com.tencent.mm.ai.m rEL;
  com.tencent.mm.plugin.sns.model.g rEM;
  com.tencent.mm.plugin.sns.model.b rEN;
  private Runnable rEO;
  private Runnable rEP;
  private SharedPreferences sp;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public ArtistUI()
  {
    AppMethodBeat.i(38122);
    this.nZZ = "";
    this.rEL = null;
    this.tipDialog = null;
    this.loX = ag.bEf();
    this.rEM = ag.cpc();
    this.rEN = ag.cpa();
    this.rEO = new ArtistUI.1(this);
    this.rEP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38115);
        if (ArtistUI.a(ArtistUI.this) == null)
        {
          AppMethodBeat.o(38115);
          return;
        }
        ab.d("MicroMsg.ArtistUI", "will start ImageLoader");
        ag.cpc().start();
        ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
        AppMethodBeat.o(38115);
      }
    };
    AppMethodBeat.o(38122);
  }
  
  public int getLayoutId()
  {
    return 2130970809;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38127);
    setMMTitle(2131303437);
    getString(2131297087);
    this.tipDialog = h.b(this, getString(2131296988), true, new ArtistUI.3(this));
    this.gJa = ((ListView)findViewById(2131827916));
    a.gmP.bs(false);
    this.rEJ = new f(this, this.nZZ, new ArtistUI.4(this), new ArtistUI.5(this));
    this.gJa.setOnScrollListener(new ArtistUI.6(this));
    this.rEK = new ArtistHeader(this);
    this.gJa.addHeaderView(this.rEK);
    this.gJa.setAdapter(this.rEJ);
    this.rEJ.notifyDataSetChanged();
    this.rEK.setVisibility(8);
    setBackBtn(new ArtistUI.7(this));
    AppMethodBeat.o(38127);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38123);
    super.onCreate(paramBundle);
    String str = aa.f(getSharedPreferences(ah.dsP(), 0));
    ab.d("MicroMsg.ArtistUI", "filterLan temp ".concat(String.valueOf(str)));
    paramBundle = str;
    if (!str.equals("zh_CN"))
    {
      paramBundle = str;
      if (!str.equals("en"))
      {
        if (!str.equals("zh_TW")) {
          break label149;
        }
        paramBundle = str;
      }
    }
    for (;;)
    {
      this.nZZ = paramBundle;
      ab.d("MicroMsg.ArtistUI", "lan " + this.nZZ);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(159, this);
      this.sp = getSharedPreferences(ah.dsP(), 0);
      initView();
      paramBundle = this.rEK;
      ag.cpa().a(paramBundle);
      AppMethodBeat.o(38123);
      return;
      label149:
      if (str.equals("zh_HK")) {
        paramBundle = "zh_TW";
      } else {
        paramBundle = "en";
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38124);
    super.onDestroy();
    if (this.tipDialog != null) {
      this.tipDialog = null;
    }
    if (this.rEK != null)
    {
      ArtistHeader localArtistHeader = this.rEK;
      ag.cpa().b(localArtistHeader);
    }
    ag.cpc().ah(this);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(159, this);
    AppMethodBeat.o(38124);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38126);
    super.onPause();
    AppMethodBeat.o(38126);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38125);
    super.onResume();
    AppMethodBeat.o(38125);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(38128);
    if ((!(paramm instanceof o)) || (((o)paramm).ads() != 4))
    {
      ab.d("MicroMsg.ArtistUI", "another scene");
      AppMethodBeat.o(38128);
      return;
    }
    ab.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramm.getType() == 159) && (this.tipDialog != null)) {
        this.tipDialog.dismiss();
      }
      AppMethodBeat.o(38128);
      return;
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38128);
      return;
      if (this.rEJ != null) {
        this.rEJ.Ku();
      }
      this.rEL = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI
 * JD-Core Version:    0.7.0.1
 */