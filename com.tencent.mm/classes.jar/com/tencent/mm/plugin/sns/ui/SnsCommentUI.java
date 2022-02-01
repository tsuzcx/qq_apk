package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;

@a(17)
public class SnsCommentUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private int diF;
  private int dzf;
  private p tipDialog = null;
  private SnsEditText xyE;
  private int xyF = 0;
  private boolean xyG = false;
  private boolean xyH = false;
  
  public void finish()
  {
    AppMethodBeat.i(98688);
    super.finish();
    if ((!this.xyH) && (this.xyF == 2))
    {
      long l1 = getIntent().getLongExtra("sns_id", 0L);
      long l2 = getIntent().getLongExtra("action_st_time", 0L);
      String str1 = bt.by(getIntent().getStringExtra("sns_uxinfo"), "");
      String str2 = bt.by(getIntent().getStringExtra("sns_actionresult"), "");
      str2 = str2 + "|4:0:";
      long l3 = System.currentTimeMillis();
      Object localObject = af.dtm().duN();
      if ((localObject == null) || (!((com.tencent.mm.plugin.sns.i.h)localObject).duO()))
      {
        AppMethodBeat.o(98688);
        return;
      }
      String str3 = ((com.tencent.mm.plugin.sns.i.h)localObject).wMZ;
      localObject = ((com.tencent.mm.plugin.sns.i.h)localObject).wMY;
      ad.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + str1 + " actionresult: " + str2 + " " + l2 + " " + l3);
      com.tencent.mm.plugin.report.service.h.vKh.f(11988, new Object[] { str3, localObject, "", "", com.tencent.mm.plugin.sns.data.q.st(l1), str1, str2, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
    }
    AppMethodBeat.o(98688);
  }
  
  public int getLayoutId()
  {
    return 2131495542;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98686);
    this.xyE = ((SnsEditText)findViewById(2131298739));
    this.xyE.requestFocus();
    addTextOptionMenu(0, getString(2131755884), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98679);
        if (SnsCommentUI.a(SnsCommentUI.this) == 0) {
          com.tencent.mm.m.b.YF();
        }
        if (SnsCommentUI.a(SnsCommentUI.this) == 2) {}
        for (int i = 200;; i = com.tencent.mm.m.b.YE())
        {
          paramAnonymousMenuItem = c.d(SnsCommentUI.b(SnsCommentUI.this)).aaj(i);
          paramAnonymousMenuItem.HuM = true;
          paramAnonymousMenuItem.a(new c.a()
          {
            public final void CH(String paramAnonymous2String)
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
                paramAnonymous2String = bt.by(SnsCommentUI.this.getIntent().getStringExtra("sns_uxinfo"), "");
                String str2 = bt.by(SnsCommentUI.this.getIntent().getStringExtra("sns_actionresult"), "");
                str1 = str2 + "|4:1:" + str1;
                long l3 = System.currentTimeMillis();
                Object localObject = af.dtm().duN();
                if ((localObject == null) || (!((com.tencent.mm.plugin.sns.i.h)localObject).duO()))
                {
                  AppMethodBeat.o(98677);
                  return;
                }
                str2 = ((com.tencent.mm.plugin.sns.i.h)localObject).wMZ;
                localObject = ((com.tencent.mm.plugin.sns.i.h)localObject).wMY;
                ad.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + paramAnonymous2String + " actionresult: " + str1 + " " + l2 + " " + l3);
                com.tencent.mm.plugin.report.service.h.vKh.f(11988, new Object[] { str2, localObject, "", "", com.tencent.mm.plugin.sns.data.q.st(l1), paramAnonymous2String, str1, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
                SnsCommentUI.c(SnsCommentUI.this);
                SnsCommentUI.this.finish();
              }
            }
            
            public final void aKr() {}
            
            public final void ck(String paramAnonymous2String)
            {
              AppMethodBeat.i(163119);
              com.tencent.mm.ui.base.h.j(SnsCommentUI.this, 2131764058, 2131764059);
              AppMethodBeat.o(163119);
            }
          });
          AppMethodBeat.o(98679);
          return false;
        }
      }
    }, null, r.b.FOB);
    if (this.xyF == 0) {
      setMMTitle(2131763795);
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
      this.xyE.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(98681);
          if (SnsCommentUI.b(SnsCommentUI.this).getText().toString().trim().length() > 0)
          {
            SnsCommentUI.this.enableOptionMenu(true);
            AppMethodBeat.o(98681);
            return;
          }
          SnsCommentUI.this.enableOptionMenu(false);
          AppMethodBeat.o(98681);
        }
      });
      AppMethodBeat.o(98686);
      return;
      if (this.xyF == 1)
      {
        setMMTitle(2131764068);
        com.tencent.mm.kernel.g.afC();
        String str = bt.by((String)com.tencent.mm.kernel.g.afB().afk().get(68408, ""), "");
        com.tencent.mm.kernel.g.afC();
        int i = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(7489, Integer.valueOf(0)), 0);
        this.xyE.setPasterLen(i);
        this.xyE.append(bt.by(str, ""));
        if ((str != null) && (str.length() > 0)) {
          enableOptionMenu(true);
        } else {
          enableOptionMenu(false);
        }
      }
      else if (this.xyF == 2)
      {
        setMMTitle(2131763735);
        enableOptionMenu(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98682);
    super.onCreate(paramBundle);
    this.dzf = getIntent().getIntExtra("sns_comment_localId", 0);
    this.xyF = getIntent().getIntExtra("sns_comment_type", 0);
    this.diF = getIntent().getIntExtra("sns_source", 0);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(213, this);
    initView();
    AppMethodBeat.o(98682);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98685);
    super.onDestroy();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(213, this);
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
    if (this.xyE != null)
    {
      String str = this.xyE.getText().toString().trim();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(68408, str);
      if (!bt.isNullOrNil(str))
      {
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afB().afk().set(7489, Integer.valueOf(this.xyE.getPasterLen()));
        AppMethodBeat.o(98683);
        return;
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(7489, Integer.valueOf(0));
    }
    AppMethodBeat.o(98683);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98684);
    super.onResume();
    showVKB();
    AppMethodBeat.o(98684);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98687);
    ad.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98687);
      return;
      if (this.xyG) {
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