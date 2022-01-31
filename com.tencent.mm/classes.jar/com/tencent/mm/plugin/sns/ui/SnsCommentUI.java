package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s.b;

@a(17)
public class SnsCommentUI
  extends MMActivity
  implements f
{
  private int bMp;
  private SnsEditText oXV;
  private int oXW = 0;
  private boolean oXX = false;
  private boolean oXY = false;
  private int onc;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  public void finish()
  {
    super.finish();
    long l1;
    long l2;
    String str1;
    String str2;
    long l3;
    if ((!this.oXY) && (this.oXW == 2))
    {
      l1 = getIntent().getLongExtra("sns_id", 0L);
      l2 = getIntent().getLongExtra("action_st_time", 0L);
      str1 = bk.aM(getIntent().getStringExtra("sns_uxinfo"), "");
      str2 = bk.aM(getIntent().getStringExtra("sns_actionresult"), "");
      str2 = str2 + "|4:0:";
      l3 = System.currentTimeMillis();
      localObject = af.bDx().bEz();
      if ((localObject != null) && (((com.tencent.mm.plugin.sns.f.h)localObject).bEA())) {}
    }
    else
    {
      return;
    }
    String str3 = ((com.tencent.mm.plugin.sns.f.h)localObject).ovZ;
    Object localObject = ((com.tencent.mm.plugin.sns.f.h)localObject).ovY;
    y.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + str1 + " actionresult: " + str2 + " " + l2 + " " + l3);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11988, new Object[] { str3, localObject, "", "", i.fN(l1), str1, str2, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_comment_ui;
  }
  
  protected final void initView()
  {
    this.oXV = ((SnsEditText)findViewById(i.f.content));
    a(0, getString(i.j.app_send), new SnsCommentUI.2(this), s.b.uNx);
    if (this.oXW == 0) {
      setMMTitle(i.j.sns_comment_title);
    }
    for (;;)
    {
      setBackBtn(new SnsCommentUI.3(this));
      this.oXV.addTextChangedListener(new SnsCommentUI.4(this));
      return;
      if (this.oXW == 1)
      {
        setMMTitle(i.j.sns_wirte_down);
        com.tencent.mm.kernel.g.DQ();
        String str = bk.aM((String)com.tencent.mm.kernel.g.DP().Dz().get(68408, ""), "");
        com.tencent.mm.kernel.g.DQ();
        int i = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(7489, Integer.valueOf(0)), 0);
        this.oXV.setPasterLen(i);
        this.oXV.append(bk.aM(str, ""));
        if ((str != null) && (str.length() > 0)) {
          enableOptionMenu(true);
        } else {
          enableOptionMenu(false);
        }
      }
      else if (this.oXW == 2)
      {
        setMMTitle(i.j.sns_ad_abtest_not_like_title);
        enableOptionMenu(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.onc = getIntent().getIntExtra("sns_comment_localId", 0);
    this.oXW = getIntent().getIntExtra("sns_comment_type", 0);
    this.bMp = getIntent().getIntExtra("sns_source", 0);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(213, this);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(213, this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      XM();
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.oXV != null)
    {
      String str = this.oXV.getText().toString().trim();
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(68408, str);
      if (!bk.bl(str))
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DP().Dz().o(7489, Integer.valueOf(this.oXV.getPasterLen()));
      }
    }
    else
    {
      return;
    }
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().o(7489, Integer.valueOf(0));
  }
  
  public void onResume()
  {
    super.onResume();
    showVKB();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramm.getType())
    {
    }
    do
    {
      return;
    } while (!this.oXX);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI
 * JD-Core Version:    0.7.0.1
 */