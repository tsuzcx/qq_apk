package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.cedit.api.d;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@a(17)
public class SnsCommentUI
  extends MMActivity
  implements i
{
  SnsInfo DqO;
  private com.tencent.mm.ui.widget.cedit.api.c EDk;
  private boolean EDl = false;
  private boolean EDm = false;
  private int dJN;
  private int ecf;
  private com.tencent.mm.ui.base.q tipDialog = null;
  private int vOR = 0;
  
  public void finish()
  {
    AppMethodBeat.i(98688);
    super.finish();
    if ((!this.EDm) && (this.vOR == 2))
    {
      long l1 = getIntent().getLongExtra("sns_id", 0L);
      long l2 = getIntent().getLongExtra("action_st_time", 0L);
      String str1 = Util.nullAs(getIntent().getStringExtra("sns_uxinfo"), "");
      String str2 = Util.nullAs(getIntent().getStringExtra("sns_actionresult"), "");
      str2 = str2 + "|4:0:";
      long l3 = System.currentTimeMillis();
      Object localObject = aj.faG().fcp();
      if ((localObject == null) || (!((com.tencent.mm.plugin.sns.h.h)localObject).fcq()))
      {
        AppMethodBeat.o(98688);
        return;
      }
      String str3 = ((com.tencent.mm.plugin.sns.h.h)localObject).DQT;
      localObject = ((com.tencent.mm.plugin.sns.h.h)localObject).DQS;
      Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + str1 + " actionresult: " + str2 + " " + l2 + " " + l3);
      com.tencent.mm.plugin.report.service.h.CyF.a(11988, new Object[] { str3, localObject, "", "", r.Jb(l1), str1, str2, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
    }
    AppMethodBeat.o(98688);
  }
  
  public int getLayoutId()
  {
    return 2131496430;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98686);
    this.EDk = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(2131299180));
    this.EDk.refresh(((PluginWebSearch)com.tencent.mm.kernel.g.ah(PluginWebSearch.class)).isUseSysEditText());
    this.EDk.gYJ();
    Object localObject = new a.e()
    {
      public final void A(List<a.c> paramAnonymousList, int paramAnonymousInt)
      {
        AppMethodBeat.i(203563);
        long l = cl.aWB();
        if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramAnonymousInt != 8) && (paramAnonymousInt != 1))
        {
          paramAnonymousList.add(new a.c(SnsCommentUI.this.getContext().getString(2131766606), 2));
          if (SnsCommentUI.this.DqO == null) {
            SnsCommentUI.this.DqO = aj.faO().Zr(SnsCommentUI.d(SnsCommentUI.this));
          }
          SnsCommentFooter.a(SnsCommentUI.this.getContext(), SnsCommentUI.this.DqO, false, "", 1, "", l);
        }
        AppMethodBeat.o(203563);
      }
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(203564);
        long l = cl.aWB();
        if (paramAnonymousc.id == 2)
        {
          SnsCommentUI.b(SnsCommentUI.this).getText().insert(SnsCommentUI.b(SnsCommentUI.this).getSelectionStart(), SnsCommentUI.this.getContext().getString(2131766606));
          SnsCommentFooter.a(SnsCommentUI.this.getContext(), SnsCommentUI.this.DqO, false, "", 2, "", l);
        }
        AppMethodBeat.o(203564);
      }
    };
    this.EDk.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), (a.e)localObject);
    this.EDk.addTextChangedListener(new TextWatcher()
    {
      private List<ForegroundColorSpan> EDf;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(203566);
        paramAnonymousEditable = SnsCommentUI.b(SnsCommentUI.this).getText();
        Object localObject = this.EDf.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAnonymousEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
        }
        this.EDf.clear();
        localObject = SnsCommentUI.b(SnsCommentUI.this).getText().toString();
        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
        {
          localObject = k.a.Krb.matcher((CharSequence)localObject);
          while (((Matcher)localObject).find())
          {
            int i = ((Matcher)localObject).start();
            int j = ((Matcher)localObject).end();
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(SnsCommentUI.this.getResources().getColor(2131099784));
            this.EDf.add(localForegroundColorSpan);
            paramAnonymousEditable.setSpan(localForegroundColorSpan, i, j, 33);
          }
        }
        AppMethodBeat.o(203566);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    addTextOptionMenu(0, getString(2131755976), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98679);
        if (SnsCommentUI.a(SnsCommentUI.this) == 0) {
          com.tencent.mm.n.c.aqk();
        }
        if (SnsCommentUI.a(SnsCommentUI.this) == 2) {}
        for (int i = 200;; i = com.tencent.mm.n.c.aqj())
        {
          d.a(SnsCommentUI.b(SnsCommentUI.this)).aoq(i).CN(true).a(new c.a()
          {
            public final void Tw(String paramAnonymous2String)
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
                Object localObject = aj.faG().fcp();
                if ((localObject == null) || (!((com.tencent.mm.plugin.sns.h.h)localObject).fcq()))
                {
                  AppMethodBeat.o(98677);
                  return;
                }
                str2 = ((com.tencent.mm.plugin.sns.h.h)localObject).DQT;
                localObject = ((com.tencent.mm.plugin.sns.h.h)localObject).DQS;
                Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + paramAnonymous2String + " actionresult: " + str1 + " " + l2 + " " + l3);
                com.tencent.mm.plugin.report.service.h.CyF.a(11988, new Object[] { str2, localObject, "", "", r.Jb(l1), paramAnonymous2String, str1, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
                SnsCommentUI.c(SnsCommentUI.this);
                SnsCommentUI.this.finish();
              }
            }
            
            public final void Tx(String paramAnonymous2String) {}
            
            public final void dv(String paramAnonymous2String)
            {
              AppMethodBeat.i(163119);
              com.tencent.mm.ui.base.h.n(SnsCommentUI.this, 2131766298, 2131766299);
              AppMethodBeat.o(163119);
            }
          });
          AppMethodBeat.o(98679);
          return false;
        }
      }
    }, null, t.b.OGU);
    if (this.vOR == 0) {
      setMMTitle(2131766019);
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
      this.EDk.addTextChangedListener(new TextWatcher()
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
      if (this.vOR == 1)
      {
        setMMTitle(2131766308);
        com.tencent.mm.kernel.g.aAi();
        localObject = Util.nullAs((String)com.tencent.mm.kernel.g.aAh().azQ().get(68408, ""), "");
        com.tencent.mm.kernel.g.aAi();
        int i = Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(7489, Integer.valueOf(0)), 0);
        this.EDk.setPasterLen(i);
        this.EDk.append(Util.nullAs((String)localObject, ""));
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          enableOptionMenu(true);
        } else {
          enableOptionMenu(false);
        }
      }
      else if (this.vOR == 2)
      {
        setMMTitle(2131765928);
        enableOptionMenu(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98682);
    super.onCreate(paramBundle);
    this.ecf = getIntent().getIntExtra("sns_comment_localId", 0);
    this.vOR = getIntent().getIntExtra("sns_comment_type", 0);
    this.dJN = getIntent().getIntExtra("sns_source", 0);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(213, this);
    initView();
    AppMethodBeat.o(98682);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98685);
    super.onDestroy();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(213, this);
    this.EDk.destroy();
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
    if (this.EDk != null)
    {
      String str = this.EDk.getText().toString().trim();
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(68408, str);
      if (Util.isNullOrNil(str)) {
        break label101;
      }
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(7489, Integer.valueOf(this.EDk.getPasterLen()));
    }
    for (;;)
    {
      this.EDk.onPause();
      AppMethodBeat.o(98683);
      return;
      label101:
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(7489, Integer.valueOf(0));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98684);
    super.onResume();
    showVKB();
    this.EDk.refresh(((PluginWebSearch)com.tencent.mm.kernel.g.ah(PluginWebSearch.class)).isUseSysEditText());
    AppMethodBeat.o(98684);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      if (this.EDl) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI
 * JD-Core Version:    0.7.0.1
 */