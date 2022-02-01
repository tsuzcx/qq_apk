package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.ui.span.o.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.cedit.api.d;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import com.tencent.mm.ui.y.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@a(17)
public class SnsCommentUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int FUI = 0;
  SnsInfo PJQ;
  private com.tencent.mm.ui.widget.cedit.api.c RqS;
  private boolean RqT = false;
  private boolean RqU = false;
  private int hHr;
  private int icg;
  private com.tencent.mm.ui.base.w tipDialog = null;
  
  public void finish()
  {
    AppMethodBeat.i(98688);
    super.finish();
    if ((!this.RqU) && (this.FUI == 2))
    {
      long l1 = getIntent().getLongExtra("sns_id", 0L);
      long l2 = getIntent().getLongExtra("action_st_time", 0L);
      String str1 = Util.nullAs(getIntent().getStringExtra("sns_uxinfo"), "");
      String str2 = Util.nullAs(getIntent().getStringExtra("sns_actionresult"), "");
      str2 = str2 + "|4:0:";
      long l3 = System.currentTimeMillis();
      Object localObject = al.hgt().hif();
      if ((localObject == null) || (!((com.tencent.mm.plugin.sns.i.h)localObject).hig()))
      {
        AppMethodBeat.o(98688);
        return;
      }
      String str3 = ((com.tencent.mm.plugin.sns.i.h)localObject).sdF;
      localObject = ((com.tencent.mm.plugin.sns.i.h)localObject).QBF;
      Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + str1 + " actionresult: " + str2 + " " + l2 + " " + l3);
      com.tencent.mm.plugin.report.service.h.OAn.b(11988, new Object[] { str3, localObject, "", "", t.uA(l1), str1, str2, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
    }
    AppMethodBeat.o(98688);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_comment_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98686);
    this.RqS = ((com.tencent.mm.ui.widget.cedit.api.c)findViewById(b.f.content));
    this.RqS.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.az(PluginWebSearch.class)).isUseSysEditText());
    this.RqS.jEJ();
    Object localObject = new a.e()
    {
      public final void I(List<a.c> paramAnonymousList, int paramAnonymousInt)
      {
        AppMethodBeat.i(309173);
        long l = cn.getSyncServerTimeSecond();
        if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramAnonymousInt != 8) && (paramAnonymousInt != 1) && (!aj.aBu()))
        {
          paramAnonymousList.add(new a.c(SnsCommentUI.this.getContext().getString(b.j.tag_search_word), 2));
          if (SnsCommentUI.this.PJQ == null) {
            SnsCommentUI.this.PJQ = al.hgB().alB(SnsCommentUI.d(SnsCommentUI.this));
          }
          SnsCommentFooter.a(SnsCommentUI.this.getContext(), SnsCommentUI.this.PJQ, false, "", 1, "", l);
        }
        AppMethodBeat.o(309173);
      }
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(309174);
        long l = cn.getSyncServerTimeSecond();
        if (paramAnonymousc.id == 2)
        {
          SnsCommentUI.b(SnsCommentUI.this).getText().insert(SnsCommentUI.b(SnsCommentUI.this).getSelectionStart(), SnsCommentUI.this.getContext().getString(b.j.tag_search_word));
          SnsCommentFooter.a(SnsCommentUI.this.getContext(), SnsCommentUI.this.PJQ, false, "", 2, "", l);
        }
        AppMethodBeat.o(309174);
      }
    };
    this.RqS.a(((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(getContext()), (a.e)localObject);
    this.RqS.addTextChangedListener(new TextWatcher()
    {
      private List<ForegroundColorSpan> RqM;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(308939);
        paramAnonymousEditable = SnsCommentUI.b(SnsCommentUI.this).getText();
        Object localObject = this.RqM.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAnonymousEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
        }
        this.RqM.clear();
        localObject = SnsCommentUI.b(SnsCommentUI.this).getText().toString();
        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
        {
          localObject = o.a.YoB.matcher((CharSequence)localObject);
          while (((Matcher)localObject).find())
          {
            int i = ((Matcher)localObject).start();
            int j = ((Matcher)localObject).end();
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(SnsCommentUI.this.getResources().getColor(b.c.Link_100));
            this.RqM.add(localForegroundColorSpan);
            paramAnonymousEditable.setSpan(localForegroundColorSpan, i, j, 33);
          }
        }
        AppMethodBeat.o(308939);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    addTextOptionMenu(0, getString(b.j.app_send), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98679);
        if (SnsCommentUI.a(SnsCommentUI.this) == 0) {
          com.tencent.mm.k.c.aRd();
        }
        if (SnsCommentUI.a(SnsCommentUI.this) == 2) {}
        for (int i = 200;; i = com.tencent.mm.k.c.aRc())
        {
          d.a(SnsCommentUI.b(SnsCommentUI.this)).aEg(i).Nc(true).a(new c.a()
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
                Object localObject = al.hgt().hif();
                if ((localObject == null) || (!((com.tencent.mm.plugin.sns.i.h)localObject).hig()))
                {
                  AppMethodBeat.o(98677);
                  return;
                }
                str2 = ((com.tencent.mm.plugin.sns.i.h)localObject).sdF;
                localObject = ((com.tencent.mm.plugin.sns.i.h)localObject).QBF;
                Log.d("MicroMsg.SnsCommentUI", "report abtestnotlike " + l1 + " uxinfo:" + paramAnonymous2String + " actionresult: " + str1 + " " + l2 + " " + l3);
                com.tencent.mm.plugin.report.service.h.OAn.b(11988, new Object[] { str2, localObject, "", "", t.uA(l1), paramAnonymous2String, str1, Long.valueOf(l2 / 1000L), Long.valueOf(l3 / 1000L) });
                SnsCommentUI.c(SnsCommentUI.this);
                SnsCommentUI.this.finish();
              }
            }
            
            public final void Tx(String paramAnonymous2String) {}
            
            public final void eY(String paramAnonymous2String)
            {
              AppMethodBeat.i(163119);
              k.s(SnsCommentUI.this, b.j.sns_upload_post_text_invalid_more, b.j.sns_upload_post_text_invalid_title);
              AppMethodBeat.o(163119);
            }
          });
          AppMethodBeat.o(98679);
          return false;
        }
      }
    }, null, y.b.adEJ);
    if (this.FUI == 0) {
      setMMTitle(b.j.sns_comment_title);
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
      this.RqS.addTextChangedListener(new TextWatcher()
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
      if (this.FUI == 1)
      {
        setMMTitle(b.j.sns_wirte_down);
        com.tencent.mm.kernel.h.baF();
        localObject = Util.nullAs((String)com.tencent.mm.kernel.h.baE().ban().d(68408, ""), "");
        com.tencent.mm.kernel.h.baF();
        int i = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(7489, Integer.valueOf(0)), 0);
        this.RqS.setPasterLen(i);
        this.RqS.append(Util.nullAs((String)localObject, ""));
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          enableOptionMenu(true);
        } else {
          enableOptionMenu(false);
        }
      }
      else if (this.FUI == 2)
      {
        setMMTitle(b.j.sns_ad_abtest_not_like_title);
        enableOptionMenu(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98682);
    aw.bW(this);
    super.onCreate(paramBundle);
    this.icg = getIntent().getIntExtra("sns_comment_localId", 0);
    this.FUI = getIntent().getIntExtra("sns_comment_type", 0);
    this.hHr = getIntent().getIntExtra("sns_source", 0);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(213, this);
    initView();
    AppMethodBeat.o(98682);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98685);
    super.onDestroy();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(213, this);
    this.RqS.destroy();
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
    if (this.RqS != null)
    {
      String str = this.RqS.getText().toString().trim();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(68408, str);
      if (Util.isNullOrNil(str)) {
        break label101;
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(7489, Integer.valueOf(this.RqS.getPasterLen()));
    }
    for (;;)
    {
      this.RqS.onPause();
      AppMethodBeat.o(98683);
      return;
      label101:
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(7489, Integer.valueOf(0));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98684);
    super.onResume();
    showVKB();
    this.RqS.refresh(((PluginWebSearch)com.tencent.mm.kernel.h.az(PluginWebSearch.class)).isUseSysEditText());
    AppMethodBeat.o(98684);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(98687);
    Log.i("MicroMsg.SnsCommentUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98687);
      return;
      if (this.RqT) {
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