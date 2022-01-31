package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.b;
import com.tencent.mm.plugin.fts.ui.widget.a.b;
import com.tencent.mm.plugin.setting.a.a;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.model.i;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.protocal.c.boj;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SettingsSearchAuthUI
  extends MMActivity
  implements f
{
  private ListView Nn;
  private ProgressDialog lxZ;
  private byte[] nQH;
  private boolean nUz;
  private com.tencent.mm.plugin.fts.ui.widget.a nVH;
  private View nVI;
  private TextView nVJ;
  private TextView nVK;
  private List<cby> nVL = new ArrayList();
  private SettingsSearchAuthUI.a nVM;
  
  private void bzb()
  {
    this.mController.removeAllOptionMenu();
    if (!this.nVL.isEmpty())
    {
      if (this.nUz) {
        addTextOptionMenu(700, getString(a.i.app_finish), new SettingsSearchAuthUI.6(this));
      }
    }
    else {
      return;
    }
    addTextOptionMenu(700, getString(a.i.app_manage), new SettingsSearchAuthUI.7(this));
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(a.a.pop_out, a.a.anim_not_change);
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_search_auth;
  }
  
  protected final void initView()
  {
    this.nVH = new com.tencent.mm.plugin.fts.ui.widget.a(this);
    this.Nn = ((ListView)findViewById(a.f.auth_list_view));
    this.nVM = new SettingsSearchAuthUI.a(this, (byte)0);
    this.Nn.setAdapter(this.nVM);
    this.nVI = findViewById(a.f.search_result_container);
    this.nVJ = ((TextView)findViewById(a.f.search_bg_view));
    this.nVK = ((TextView)findViewById(a.f.search_no_result));
    bzb();
    getSupportActionBar().setCustomView(this.nVH);
    this.nVH.setSearchViewListener(new SettingsSearchAuthUI.1(this));
    this.nVH.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, List<a.b> paramAnonymousList, FTSEditTextView.b paramAnonymousb)
      {
        y.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[] { paramAnonymousString1 });
        if (!bk.bl(paramAnonymousString1))
        {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this);
          paramAnonymousString2 = SettingsSearchAuthUI.this.getString(a.i.app_search);
          paramAnonymousString1 = new k(paramAnonymousString2 + " " + paramAnonymousString1.trim());
          paramAnonymousString1.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(a.c.green_text_color)), paramAnonymousString2.length(), paramAnonymousString1.length(), 33);
          SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setText(paramAnonymousString1);
          return;
        }
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
      }
      
      public final void aWb() {}
      
      public final boolean apb()
      {
        y.i("MicroMsg.SettingsSearchAuthUI", "search key down");
        Editable localEditable = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setVisibility(8);
        SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().clearFocus();
        SettingsSearchAuthUI.this.XM();
        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
        if (!bk.L(localEditable)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, localEditable.toString().trim());
        }
        return true;
      }
      
      public final void gn(boolean paramAnonymousBoolean)
      {
        y.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          SettingsSearchAuthUI.this.showVKB();
          return;
        }
        SettingsSearchAuthUI.this.XM();
      }
      
      public final void onClickClearTextBtn(View paramAnonymousView)
      {
        y.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
      }
    });
    this.nVJ.setOnClickListener(new SettingsSearchAuthUI.3(this));
    this.Nn.setOnItemClickListener(new SettingsSearchAuthUI.4(this));
    this.Nn.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          y.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
          if (SettingsSearchAuthUI.h(SettingsSearchAuthUI.this) != null)
          {
            SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.h(SettingsSearchAuthUI.this));
            SettingsSearchAuthUI.i(SettingsSearchAuthUI.this);
          }
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onPause()
  {
    super.onPause();
    g.Dk().b(1169, this);
    g.Dk().b(1127, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(1169, this);
    g.Dk().a(1127, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.lxZ != null) {
      this.lxZ.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 1169)
      {
        paramString = (i)paramm;
        if ((paramString.nQK != null) && (paramString.nQK.thD == 1))
        {
          paramString = paramString.nQK.thB.toByteArray();
          this.nQH = paramString;
          if (((i)paramm).nQH == null) {
            break label223;
          }
          paramInt1 = 1;
          label117:
          if (paramInt1 == 0) {
            this.nVL.clear();
          }
          List localList = this.nVL;
          paramString = (i)paramm;
          if (paramString.nQK == null) {
            break label228;
          }
          paramString = paramString.nQK.thC;
          label157:
          localList.addAll(paramString);
          if (this.nVL.isEmpty()) {
            break label235;
          }
          this.nVM.nUB = this.nVL;
          this.nVM.notifyDataSetChanged();
          this.nVI.setVisibility(8);
          this.Nn.setVisibility(0);
          bzb();
        }
      }
      label223:
      label228:
      label235:
      do
      {
        do
        {
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label117;
          paramString = Collections.emptyList();
          break label157;
          this.nVI.setVisibility(0);
          this.nVJ.setVisibility(8);
          this.nVK.setVisibility(0);
          this.Nn.setVisibility(8);
          this.nVL.clear();
          bzb();
          return;
        } while (paramm.getType() != 1127);
        paramString = ((c)paramm).appId;
      } while (bk.bl(paramString));
      if (!this.nVL.isEmpty())
      {
        paramm = this.nVL.iterator();
        while (paramm.hasNext()) {
          if (((cby)paramm.next()).bOL.equals(paramString)) {
            paramm.remove();
          }
        }
      }
      this.nVM.notifyDataSetChanged();
      return;
    }
    h.bC(this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */