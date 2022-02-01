package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.cedit.api.d;
import com.tencent.mm.ui.widget.edittext.a.e;

@a(17)
public class SnsCommentUI
  extends MMActivity
  implements i
{
  private int AvD = 0;
  SnsInfo Jws;
  private com.tencent.mm.ui.widget.cedit.api.c KQZ;
  private boolean KRa = false;
  private boolean KRb = false;
  private int fCC;
  private int fWh;
  private s tipDialog = null;
  
  public void finish()
  {
    AppMethodBeat.i(98688);
    super.finish();
    if ((!this.KRb) && (this.AvD == 2))
    {
      long l1 = getIntent().getLongExtra("sns_id", 0L);
      long l2 = getIntent().getLongExtra("action_st_time", 0L);
      String str1 = Util.nullAs(getIntent().getStringExtra("sns_uxinfo"), "");
      String str2 = Util.nullAs(getIntent().getStringExtra("sns_actionresult"), "");
      str2 = str2 + "|4:0:";
      long l3 = System.currentTimeMillis();
      Object localObject = aj.fOA().fQi();
      if ((localObject == null) || (!((com.tencent.mm.plugin.sns.h.h)localObject).fQj()))
      {
        AppMethodBeat.o(98688);
        return;
      }
      String str3 = ((com.tencent.mm.plugin.sns.h.h)localObject).Kea;
      localObject = ((com.tencent.mm.plugin.sns.h.h)localObject).KdZ;
      Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + str1 + " actionresult: " + str2 + " " + l2 + " " + l3);
      com.tencent.mm.plugin.report.service.h.IzE.a(11988, new Object[] { str3, localObject, "", "", com.tencent.mm.plugin.sns.data.t.Qu(l1), str1, str2, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
    }
    AppMethodBeat.o(98688);
  }
  
  public int getLayoutId()
  {
    return i.g.sns_comment_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98686);
    this.KQZ = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(i.f.content));
    this.KQZ.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
    this.KQZ.hZB();
    Object localObject = new SnsCommentUI.5(this);
    this.KQZ.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), (a.e)localObject);
    this.KQZ.addTextChangedListener(new SnsCommentUI.6(this));
    addTextOptionMenu(0, getString(i.j.app_send), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98679);
        if (SnsCommentUI.a(SnsCommentUI.this) == 0) {
          com.tencent.mm.n.c.awD();
        }
        if (SnsCommentUI.a(SnsCommentUI.this) == 2) {}
        for (int i = 200;; i = com.tencent.mm.n.c.awC())
        {
          d.a(SnsCommentUI.b(SnsCommentUI.this)).axx(i).Hh(true).a(new c.a()
          {
            public final void abc(String paramAnonymous2String)
            {
              AppMethodBeat.i(98677);
              String str1 = SnsCommentUI.b(SnsCommentUI.this).getText().toString().trim();
              SnsCommentUI.b(SnsCommentUI.this).setText("");
              if (str1.length() > 0) {
                switch (SnsCommentUI.a(SnsCommentUI.this))
                {
                }
              }
              for (;;)
              {
                AppMethodBeat.o(98677);
                return;
                SnsCommentUI.this.hideVKB();
                SnsCommentUI.a(SnsCommentUI.this, str1);
                AppMethodBeat.o(98677);
                return;
                SnsCommentUI.this.hideVKB();
                SnsCommentUI.b(SnsCommentUI.this, str1);
                AppMethodBeat.o(98677);
                return;
                SnsCommentUI.this.hideVKB();
                long l1 = SnsCommentUI.this.getIntent().getLongExtra("sns_id", 0L);
                long l2 = SnsCommentUI.this.getIntent().getLongExtra("action_st_time", 0L);
                paramAnonymous2String = Util.nullAs(SnsCommentUI.this.getIntent().getStringExtra("sns_uxinfo"), "");
                String str2 = Util.nullAs(SnsCommentUI.this.getIntent().getStringExtra("sns_actionresult"), "");
                str1 = str2 + "|4:1:" + str1;
                long l3 = System.currentTimeMillis();
                Object localObject = aj.fOA().fQi();
                if ((localObject == null) || (!((com.tencent.mm.plugin.sns.h.h)localObject).fQj()))
                {
                  AppMethodBeat.o(98677);
                  return;
                }
                str2 = ((com.tencent.mm.plugin.sns.h.h)localObject).Kea;
                localObject = ((com.tencent.mm.plugin.sns.h.h)localObject).KdZ;
                Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + paramAnonymous2String + " actionresult: " + str1 + " " + l2 + " " + l3);
                com.tencent.mm.plugin.report.service.h.IzE.a(11988, new Object[] { str2, localObject, "", "", com.tencent.mm.plugin.sns.data.t.Qu(l1), paramAnonymous2String, str1, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
                SnsCommentUI.c(SnsCommentUI.this);
                SnsCommentUI.this.finish();
              }
            }
            
            public final void abd(String paramAnonymous2String) {}
            
            public final void dN(String paramAnonymous2String)
            {
              AppMethodBeat.i(163119);
              com.tencent.mm.ui.base.h.p(SnsCommentUI.this, i.j.sns_upload_post_text_invalid_more, i.j.sns_upload_post_text_invalid_title);
              AppMethodBeat.o(163119);
            }
          });
          AppMethodBeat.o(98679);
          return false;
        }
      }
    }, null, w.b.Wao);
    if (this.AvD == 0) {
      setMMTitle(i.j.sns_comment_title);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98680);
          SnsCommentUI.this.hideVKB();
          SnsCommentUI.this.finish();
          AppMethodBeat.o(98680);
          return true;
        }
      });
      this.KQZ.addTextChangedListener(new SnsCommentUI.4(this));
      AppMethodBeat.o(98686);
      return;
      if (this.AvD == 1)
      {
        setMMTitle(i.j.sns_wirte_down);
        com.tencent.mm.kernel.h.aHH();
        localObject = Util.nullAs((String)com.tencent.mm.kernel.h.aHG().aHp().b(68408, ""), "");
        com.tencent.mm.kernel.h.aHH();
        int i = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(7489, Integer.valueOf(0)), 0);
        this.KQZ.setPasterLen(i);
        this.KQZ.append(Util.nullAs((String)localObject, ""));
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          enableOptionMenu(true);
        } else {
          enableOptionMenu(false);
        }
      }
      else if (this.AvD == 2)
      {
        setMMTitle(i.j.sns_ad_abtest_not_like_title);
        enableOptionMenu(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98682);
    super.onCreate(paramBundle);
    this.fWh = getIntent().getIntExtra("sns_comment_localId", 0);
    this.AvD = getIntent().getIntExtra("sns_comment_type", 0);
    this.fCC = getIntent().getIntExtra("sns_source", 0);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(213, this);
    initView();
    AppMethodBeat.o(98682);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98685);
    super.onDestroy();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(213, this);
    this.KQZ.destroy();
    AppMethodBeat.o(98685);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98689);
    if (paramInt == 4)
    {
      hideVKB();
      finish();
      AppMethodBeat.o(98689);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(98689);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98683);
    super.onPause();
    if (this.KQZ != null)
    {
      String str = this.KQZ.getText().toString().trim();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(68408, str);
      if (Util.isNullOrNil(str)) {
        break label101;
      }
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(7489, Integer.valueOf(this.KQZ.getPasterLen()));
    }
    for (;;)
    {
      this.KQZ.onPause();
      AppMethodBeat.o(98683);
      return;
      label101:
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(7489, Integer.valueOf(0));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98684);
    super.onResume();
    showVKB();
    this.KQZ.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.ag(PluginWebSearch.class)).isUseSysEditText());
    AppMethodBeat.o(98684);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(98687);
    Log.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98687);
      return;
      if (this.KRa) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI
 * JD-Core Version:    0.7.0.1
 */