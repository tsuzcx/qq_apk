package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.q.b;

@a(17)
public class SnsCommentUI
  extends MMActivity
  implements f
{
  private int cIp;
  private int ctK;
  private SnsEditText rQo;
  private int rQp = 0;
  private boolean rQq = false;
  private boolean rQr = false;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  public void finish()
  {
    AppMethodBeat.i(38926);
    super.finish();
    if ((!this.rQr) && (this.rQp == 2))
    {
      long l1 = getIntent().getLongExtra("sns_id", 0L);
      long l2 = getIntent().getLongExtra("action_st_time", 0L);
      String str1 = bo.bf(getIntent().getStringExtra("sns_uxinfo"), "");
      String str2 = bo.bf(getIntent().getStringExtra("sns_actionresult"), "");
      str2 = str2 + "|4:0:";
      long l3 = System.currentTimeMillis();
      Object localObject = ag.coX().cqb();
      if ((localObject == null) || (!((com.tencent.mm.plugin.sns.g.h)localObject).cqc()))
      {
        AppMethodBeat.o(38926);
        return;
      }
      String str3 = ((com.tencent.mm.plugin.sns.g.h)localObject).rkT;
      localObject = ((com.tencent.mm.plugin.sns.g.h)localObject).rkS;
      ab.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + str1 + " actionresult: " + str2 + " " + l2 + " " + l3);
      com.tencent.mm.plugin.report.service.h.qsU.e(11988, new Object[] { str3, localObject, "", "", i.lq(l1), str1, str2, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
    }
    AppMethodBeat.o(38926);
  }
  
  public int getLayoutId()
  {
    return 2130970820;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38924);
    this.rQo = ((SnsEditText)findViewById(2131820946));
    addTextOptionMenu(0, getString(2131297067), new SnsCommentUI.2(this), null, q.b.zby);
    if (this.rQp == 0) {
      setMMTitle(2131303792);
    }
    for (;;)
    {
      setBackBtn(new SnsCommentUI.3(this));
      this.rQo.addTextChangedListener(new SnsCommentUI.4(this));
      AppMethodBeat.o(38924);
      return;
      if (this.rQp == 1)
      {
        setMMTitle(2131304046);
        com.tencent.mm.kernel.g.RM();
        String str = bo.bf((String)com.tencent.mm.kernel.g.RL().Ru().get(68408, ""), "");
        com.tencent.mm.kernel.g.RM();
        int i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(7489, Integer.valueOf(0)), 0);
        this.rQo.setPasterLen(i);
        this.rQo.append(bo.bf(str, ""));
        if ((str != null) && (str.length() > 0)) {
          enableOptionMenu(true);
        } else {
          enableOptionMenu(false);
        }
      }
      else if (this.rQp == 2)
      {
        setMMTitle(2131303741);
        enableOptionMenu(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38920);
    super.onCreate(paramBundle);
    this.cIp = getIntent().getIntExtra("sns_comment_localId", 0);
    this.rQp = getIntent().getIntExtra("sns_comment_type", 0);
    this.ctK = getIntent().getIntExtra("sns_source", 0);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(213, this);
    initView();
    AppMethodBeat.o(38920);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38923);
    super.onDestroy();
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(213, this);
    AppMethodBeat.o(38923);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38927);
    if (paramInt == 4)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(38927);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(38927);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38921);
    super.onPause();
    if (this.rQo != null)
    {
      String str = this.rQo.getText().toString().trim();
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(68408, str);
      if (!bo.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RL().Ru().set(7489, Integer.valueOf(this.rQo.getPasterLen()));
        AppMethodBeat.o(38921);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(7489, Integer.valueOf(0));
    }
    AppMethodBeat.o(38921);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38922);
    super.onResume();
    showVKB();
    AppMethodBeat.o(38922);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(38925);
    ab.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramm.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38925);
      return;
      if (this.rQq) {
        finish();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI
 * JD-Core Version:    0.7.0.1
 */