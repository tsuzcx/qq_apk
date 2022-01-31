package com.tencent.mm.plugin.sns.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.o;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ArtistUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private SharedPreferences dnD;
  private ListView fry;
  ah jge = af.aXq();
  private String lCN = "";
  private f oMY;
  private ArtistHeader oMZ;
  private m oNa = null;
  com.tencent.mm.plugin.sns.model.g oNb = af.bDC();
  com.tencent.mm.plugin.sns.model.b oNc = af.bDA();
  private Runnable oNd = new ArtistUI.1(this);
  private Runnable oNe = new Runnable()
  {
    public final void run()
    {
      if (ArtistUI.a(ArtistUI.this) == null) {
        return;
      }
      y.d("MicroMsg.ArtistUI", "will start ImageLoader");
      af.bDC().start();
      ArtistUI.a(ArtistUI.this).notifyDataSetChanged();
    }
  };
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  protected final int getLayoutId()
  {
    return i.g.sns_artist_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(i.j.settings_sns_bg_title);
    getString(i.j.app_tip);
    this.tipDialog = h.b(this, getString(i.j.app_loading_data), true, new ArtistUI.3(this));
    this.fry = ((ListView)findViewById(i.f.sns_artist_list));
    a.eUS.aQ(false);
    this.oMY = new f(this, this.lCN, new ArtistUI.4(this), new ArtistUI.5(this));
    this.fry.setOnScrollListener(new ArtistUI.6(this));
    this.oMZ = new ArtistHeader(this);
    this.fry.addHeaderView(this.oMZ);
    this.fry.setAdapter(this.oMY);
    this.oMY.notifyDataSetChanged();
    this.oMZ.setVisibility(8);
    setBackBtn(new ArtistUI.7(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str = x.d(getSharedPreferences(ae.cqR(), 0));
    y.d("MicroMsg.ArtistUI", "filterLan temp " + str);
    paramBundle = str;
    if (!str.equals("zh_CN"))
    {
      paramBundle = str;
      if (!str.equals("en"))
      {
        if (!str.equals("zh_TW")) {
          break label146;
        }
        paramBundle = str;
      }
    }
    for (;;)
    {
      this.lCN = paramBundle;
      y.d("MicroMsg.ArtistUI", "lan " + this.lCN);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(159, this);
      this.dnD = getSharedPreferences(ae.cqR(), 0);
      initView();
      paramBundle = this.oMZ;
      af.bDA().a(paramBundle);
      return;
      label146:
      if (str.equals("zh_HK")) {
        paramBundle = "zh_TW";
      } else {
        paramBundle = "en";
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.tipDialog != null) {
      this.tipDialog = null;
    }
    if (this.oMZ != null)
    {
      ArtistHeader localArtistHeader = this.oMZ;
      af.bDA().b(localArtistHeader);
    }
    af.bDC().M(this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(159, this);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((!(paramm instanceof o)) || (((o)paramm).KF() != 4)) {
      y.d("MicroMsg.ArtistUI", "another scene");
    }
    do
    {
      return;
      y.i("MicroMsg.ArtistUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
    } while ((paramm.getType() != 159) || (this.tipDialog == null));
    this.tipDialog.dismiss();
    return;
    switch (paramm.getType())
    {
    default: 
      return;
    }
    if (this.oMY != null) {
      this.oMY.yc();
    }
    this.oNa = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ArtistUI
 * JD-Core Version:    0.7.0.1
 */