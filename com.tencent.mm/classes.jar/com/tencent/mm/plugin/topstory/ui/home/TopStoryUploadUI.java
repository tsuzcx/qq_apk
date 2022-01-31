package com.tencent.mm.plugin.topstory.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;

public class TopStoryUploadUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  public static c thj;
  private String appVersion;
  private String businessType;
  private String cwc;
  private String desc;
  private String extInfo;
  private TextView nUz;
  private long sbQ = 0L;
  private String thk;
  private String thl;
  private View thm;
  private View thn;
  private ImageView tho;
  private ImageView thp;
  private TextView thq;
  private TextView thr;
  private TextView ths;
  private TextView tht;
  private TextView thu;
  private String thumbUrl;
  private SnsEditText thv;
  private TextView thw;
  private boolean thx = false;
  protected com.tencent.mm.ui.base.p tipDialog = null;
  private String title;
  private int type;
  
  static
  {
    AppMethodBeat.i(1699);
    c.a locala = new c.a();
    locala.eNM = true;
    locala.eNL = true;
    locala.eOk = false;
    locala.eNY = 2131690155;
    thj = locala.ahY();
    AppMethodBeat.o(1699);
  }
  
  protected static boolean bDC()
  {
    AppMethodBeat.i(1686);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      i = com.tencent.mm.kernel.g.Rc().adt();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(1686);
        return true;
      }
      AppMethodBeat.o(1686);
      return false;
    }
    if (at.isConnected(ah.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(1686);
      return true;
    }
    AppMethodBeat.o(1686);
    return false;
  }
  
  private void cIU()
  {
    AppMethodBeat.i(1688);
    i.c(this.businessType, "", this.cwc, 0, "");
    finish();
    this.thx = true;
    AppMethodBeat.o(1688);
  }
  
  public static String cIV()
  {
    AppMethodBeat.i(1690);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localObject = com.tencent.mm.a.p.getString(com.tencent.mm.kernel.a.getUin()) + "_" + System.currentTimeMillis();
    AppMethodBeat.o(1690);
    return localObject;
  }
  
  private void cIW()
  {
    AppMethodBeat.i(1694);
    int j = this.thv.getText().toString().length();
    if (j < 180)
    {
      this.nUz.setVisibility(8);
      this.ths.setVisibility(8);
      AppMethodBeat.o(1694);
      return;
    }
    this.nUz.setVisibility(0);
    this.ths.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131690600);; i = getResources().getColor(2131690391))
    {
      this.nUz.setText(String.valueOf(j));
      this.nUz.setTextColor(i);
      AppMethodBeat.o(1694);
      return;
    }
  }
  
  private void exit()
  {
    AppMethodBeat.i(1687);
    com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.cwc });
    if (this.thv.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this, 2131304368, 0, 2131297115, 2131297014, true, new TopStoryUploadUI.5(this), new TopStoryUploadUI.6(this), 2131689778);
      AppMethodBeat.o(1687);
      return;
    }
    cIU();
    AppMethodBeat.o(1687);
  }
  
  public final int a(long paramLong, String paramString1, String paramString2, String paramString3, com.tencent.mm.pluginsdk.model.app.f paramf, String paramString4)
  {
    AppMethodBeat.i(1691);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.g(paramLong, paramString1, paramString2, paramString3, paramf, paramString4);
    com.tencent.mm.kernel.g.Rc().a(paramString1, 0);
    getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131304373), false, null);
    AppMethodBeat.o(1691);
    return 0;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(1693);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      exit();
      AppMethodBeat.o(1693);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(1693);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130971034;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1685);
    ab.i("micromsg.topstory.TopStoryUploadUI", "onCreate");
    super.onCreate(paramBundle);
    setMMTitle(2131304372);
    addTextOptionMenu(0, getString(2131297067), new TopStoryUploadUI.4(this), null, q.b.zbI);
    setBackBtn(new TopStoryUploadUI.1(this));
    com.tencent.mm.kernel.g.Rc().a(2534, this);
    this.type = getIntent().getIntExtra("KEY_TYPE", 0);
    this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
    this.cwc = getIntent().getStringExtra("KEY_APPID");
    this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
    this.title = getIntent().getStringExtra("KEY_TITLE");
    this.desc = getIntent().getStringExtra("KEY_DESC");
    this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
    this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
    this.thk = getIntent().getStringExtra("KEY_MEDIANAME");
    this.thl = getIntent().getStringExtra("KEY_MEDIAHEADURL");
    this.thm = findViewById(2131828610);
    this.tho = ((ImageView)findViewById(2131824405));
    this.thq = ((TextView)findViewById(2131828611));
    this.thr = ((TextView)findViewById(2131824634));
    this.thv = ((SnsEditText)findViewById(2131828527));
    this.thw = ((TextView)findViewById(2131828617));
    this.nUz = ((TextView)findViewById(2131828616));
    this.ths = ((TextView)findViewById(2131828615));
    this.thn = findViewById(2131822579);
    this.thp = ((ImageView)findViewById(2131828612));
    this.tht = ((TextView)findViewById(2131828613));
    this.thu = ((TextView)findViewById(2131828614));
    if (this.type == 1)
    {
      this.thm.setVisibility(0);
      this.thn.setVisibility(8);
      this.thq.setText(this.title);
      this.thr.setText(this.thk);
      o.ahG().a(this.thumbUrl, this.thp, thj, new TopStoryUploadUI.2(this));
    }
    for (;;)
    {
      this.thw.setText(String.format("<a href='%s'>%s</a>", new Object[] { "https://search.weixin.qq.com/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect", getString(2131304370) }));
      j.k(this.thw, 1);
      cIW();
      this.thv.addTextChangedListener(new TopStoryUploadUI.3(this));
      com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(6), Integer.valueOf(1), this.cwc });
      AppMethodBeat.o(1685);
      return;
      this.thm.setVisibility(8);
      this.thn.setVisibility(0);
      this.tht.setText(this.title);
      this.thu.setText(this.thk);
      o.ahG().a(this.thumbUrl, this.thp, thj);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(1692);
    ab.i("micromsg.topstory.TopStoryUploadUI", "onDestroy");
    super.onDestroy();
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.kernel.g.Rc().b(2534, this);
    if (!this.thx) {
      com.tencent.mm.plugin.report.service.h.qsU.e(17080, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.cwc });
    }
    AppMethodBeat.o(1692);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(1689);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        if ((paramm instanceof com.tencent.mm.plugin.topstory.a.c.g))
        {
          paramString = ((ul)((com.tencent.mm.plugin.topstory.a.c.g)paramm).rr.fsW.fta).BaseResponse;
          if (paramString.Ret == 0)
          {
            cIU();
            AppMethodBeat.o(1689);
            return;
            paramInt1 = 0;
            continue;
          }
          if ((paramString.ErrMsg == null) || (bo.isNullOrNil(paramString.ErrMsg.xJE))) {
            break label152;
          }
          com.tencent.mm.ui.base.h.b(this, paramString.ErrMsg.xJE, getString(2131304369), true);
        }
      }
    }
    for (;;)
    {
      e.qrI.idkeyStat(1032L, 2L, 1L, false);
      AppMethodBeat.o(1689);
      return;
      label152:
      com.tencent.mm.ui.base.h.b(this, getString(2131304371), getString(2131304369), true);
      continue;
      if (bo.isNullOrNil(paramString)) {
        com.tencent.mm.ui.base.h.b(this, getString(2131304339), getString(2131304369), true);
      } else {
        com.tencent.mm.ui.base.h.b(this, paramString, getString(2131304369), true);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI
 * JD-Core Version:    0.7.0.1
 */