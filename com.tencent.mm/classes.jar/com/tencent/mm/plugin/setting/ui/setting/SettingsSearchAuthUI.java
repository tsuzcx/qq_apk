package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.setting.b.a;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.e;
import com.tencent.mm.plugin.setting.model.n;
import com.tencent.mm.plugin.setting.model.r;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.ewi;
import com.tencent.mm.protocal.protobuf.fun;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@c(0)
public class SettingsSearchAuthUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int ERV;
  private View IwM;
  private byte[] PnI;
  private FTSSearchView PvL;
  private View PvM;
  private View PvN;
  private TextView PvO;
  private TextView PvP;
  private ProgressBar PvQ;
  private List<fun> PvR;
  private a PvS;
  private String PvT;
  private Integer PvU;
  private View PvV;
  private View PvW;
  private boolean PvX;
  private ListView mListView;
  private boolean vDm;
  private View wDF;
  
  public SettingsSearchAuthUI()
  {
    AppMethodBeat.i(74392);
    this.PvR = new ArrayList();
    this.PvU = null;
    this.vDm = false;
    this.PvV = null;
    this.ERV = -1;
    this.wDF = null;
    this.IwM = null;
    this.PvW = null;
    this.PvX = false;
    AppMethodBeat.o(74392);
  }
  
  private void fxG()
  {
    AppMethodBeat.i(299308);
    Log.i("MicroMsg.SettingsSearchAuthUI", "cancelSearch searchId: %s, searchingKeyWord: %s", new Object[] { this.PvU, this.PvT });
    this.vDm = false;
    this.PvT = null;
    if (this.PvU != null)
    {
      com.tencent.mm.kernel.h.aZW().cancel(this.PvU.intValue());
      this.PvU = null;
    }
    AppMethodBeat.o(299308);
  }
  
  private void gWf()
  {
    AppMethodBeat.i(74397);
    this.PvM.setVisibility(0);
    this.PvO.setVisibility(8);
    this.PvQ.setVisibility(8);
    this.PvP.setVisibility(0);
    this.PvP.setText(getResources().getString(b.i.settings_auth_search_result_empty));
    this.mListView.setVisibility(8);
    this.PvR.clear();
    removeAllOptionMenu();
    AppMethodBeat.o(74397);
  }
  
  private void gWg()
  {
    AppMethodBeat.i(299303);
    if (this.PvV != null) {
      this.mListView.removeFooterView(this.PvV);
    }
    AppMethodBeat.o(299303);
  }
  
  public void finish()
  {
    AppMethodBeat.i(74398);
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.pop_out);
    AppMethodBeat.o(74398);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_search_auth;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74394);
    this.PvL = new FTSSearchView(this);
    this.mListView = ((ListView)findViewById(b.f.auth_list_view));
    this.PvS = new a();
    this.mListView.setAdapter(this.PvS);
    this.PvM = findViewById(b.f.search_result_container);
    this.PvO = ((TextView)findViewById(b.f.search_bg_view));
    this.PvP = ((TextView)findViewById(b.f.search_no_result));
    this.PvQ = ((ProgressBar)findViewById(b.f.search_loading));
    removeAllOptionMenu();
    getSupportActionBar().setCustomView(this.PvL);
    this.PvL.setSearchViewListener(new FTSSearchView.b()
    {
      public final void onClickBackBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(298841);
        Log.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        SettingsSearchAuthUI.this.finish();
        AppMethodBeat.o(298841);
      }
    });
    this.PvL.getFtsEditText().jBL();
    this.PvL.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.c()
    {
      public final boolean aWU()
      {
        AppMethodBeat.i(298847);
        Editable localEditable = SettingsSearchAuthUI.i(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        Log.i("MicroMsg.SettingsSearchAuthUI", "search key down text: %s", new Object[] { localEditable.toString() });
        SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).setVisibility(8);
        SettingsSearchAuthUI.i(SettingsSearchAuthUI.this).getFtsEditText().getEditText().clearFocus();
        SettingsSearchAuthUI.this.hideVKB();
        SettingsSearchAuthUI.j(SettingsSearchAuthUI.this);
        if (!Util.isNullOrNil(localEditable)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, localEditable.toString().trim());
        }
        AppMethodBeat.o(298847);
        return true;
      }
      
      public final void eeU() {}
      
      public final void fq(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(298843);
        Log.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          SettingsSearchAuthUI.this.showVKB();
          AppMethodBeat.o(298843);
          return;
        }
        SettingsSearchAuthUI.this.hideVKB();
        AppMethodBeat.o(298843);
      }
      
      public final void onClickClearTextBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(298845);
        Log.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
        SettingsSearchAuthUI.h(SettingsSearchAuthUI.this);
        AppMethodBeat.o(298845);
      }
      
      public final void onEditTextChange(String paramAnonymousString1, String paramAnonymousString2, List<FTSSearchView.c> paramAnonymousList, FTSEditTextView.d paramAnonymousd)
      {
        AppMethodBeat.i(298838);
        Log.i("MicroMsg.SettingsSearchAuthUI", "onEditTextChange search totalText %s", new Object[] { paramAnonymousString1 });
        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
        if (!Util.isNullOrNil(paramAnonymousString1))
        {
          SettingsSearchAuthUI.f(SettingsSearchAuthUI.this);
          paramAnonymousString2 = SettingsSearchAuthUI.this.getString(b.i.app_search);
          paramAnonymousString1 = new q(paramAnonymousString2 + " " + paramAnonymousString1.trim());
          paramAnonymousString1.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(b.c.brand_text_color)), paramAnonymousString2.length(), paramAnonymousString1.length(), 33);
          SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).setText(paramAnonymousString1);
          AppMethodBeat.o(298838);
          return;
        }
        SettingsSearchAuthUI.h(SettingsSearchAuthUI.this);
        AppMethodBeat.o(298838);
      }
    });
    this.PvL.getFtsEditText().aWT();
    this.PvL.getFtsEditText().aWS();
    this.PvO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(299230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = SettingsSearchAuthUI.i(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        SettingsSearchAuthUI.i(SettingsSearchAuthUI.this).getFtsEditText().getEditText().clearFocus();
        SettingsSearchAuthUI.this.hideVKB();
        if (!Util.isNullOrNil(paramAnonymousView)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, paramAnonymousView.toString().trim());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(299230);
      }
    });
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(299223);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        try
        {
          paramAnonymousAdapterView = SettingsSearchAuthUI.k(SettingsSearchAuthUI.this).aiV(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, paramAnonymousInt);
            paramAnonymousView = new Intent(SettingsSearchAuthUI.this, SettingsDelAuthUI.class);
            paramAnonymousView.putExtra("key_user_auth_app", paramAnonymousAdapterView.toByteArray());
            SettingsSearchAuthUI.this.startActivityForResult(paramAnonymousView, 1000);
          }
        }
        catch (Exception paramAnonymousAdapterView)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.SettingsSearchAuthUI", paramAnonymousAdapterView, "", new Object[0]);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(299223);
      }
    });
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(299228);
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          Log.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end nexPageData: %s", new Object[] { SettingsSearchAuthUI.d(SettingsSearchAuthUI.this) });
          if ((SettingsSearchAuthUI.d(SettingsSearchAuthUI.this) != null) && (SettingsSearchAuthUI.a(SettingsSearchAuthUI.this).getVisibility() == 0)) {
            SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.c(SettingsSearchAuthUI.this), SettingsSearchAuthUI.d(SettingsSearchAuthUI.this));
          }
        }
        AppMethodBeat.o(299228);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.PvN = findViewById(b.f.root_container);
    this.PvN.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(299242);
        SettingsSearchAuthUI.l(SettingsSearchAuthUI.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = com.tencent.mm.cd.a.ms(SettingsSearchAuthUI.this);
        int j = com.tencent.mm.cd.a.mt(SettingsSearchAuthUI.this);
        int k = Math.min(Math.max(SettingsSearchAuthUI.l(SettingsSearchAuthUI.this).getMeasuredHeight(), 0), j);
        Log.d("MicroMsg.SettingsSearchAuthUI", "onGlobalLayout width: %s, height: %s, root_container: %s, rootViewHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(SettingsSearchAuthUI.l(SettingsSearchAuthUI.this).getMeasuredHeight()), Integer.valueOf(k) });
        ViewGroup.LayoutParams localLayoutParams;
        if (SettingsSearchAuthUI.m(SettingsSearchAuthUI.this) != null)
        {
          localLayoutParams = SettingsSearchAuthUI.m(SettingsSearchAuthUI.this).getLayoutParams();
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
          {
            ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = ((int)(k * 0.3F));
            SettingsSearchAuthUI.m(SettingsSearchAuthUI.this).setLayoutParams(localLayoutParams);
          }
        }
        if (SettingsSearchAuthUI.n(SettingsSearchAuthUI.this) != null)
        {
          localLayoutParams = SettingsSearchAuthUI.n(SettingsSearchAuthUI.this).getLayoutParams();
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
          {
            ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = ((int)(k * 0.3F));
            SettingsSearchAuthUI.n(SettingsSearchAuthUI.this).setLayoutParams(localLayoutParams);
          }
        }
        AppMethodBeat.o(299242);
      }
    });
    AppMethodBeat.o(74394);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(299364);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1000)
    {
      AppMethodBeat.o(299364);
      return;
    }
    if ((paramInt2 == -1) && (this.PvR != null) && (this.PvS != null) && (this.ERV >= 0) && (this.ERV < this.PvR.size()))
    {
      this.PvR.remove(this.ERV);
      this.PvS.notifyDataSetChanged();
      if ((this.PnI == null) && (this.PvR.size() <= 1)) {
        gWf();
      }
    }
    AppMethodBeat.o(299364);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(299381);
    fxG();
    super.onBackPressed();
    AppMethodBeat.o(299381);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74393);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74396);
    super.onPause();
    com.tencent.mm.kernel.h.aZW().b(1169, this);
    com.tencent.mm.kernel.h.aZW().b(1127, this);
    AppMethodBeat.o(74396);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74395);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(1169, this);
    com.tencent.mm.kernel.h.aZW().a(1127, this);
    AppMethodBeat.o(74395);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(74399);
    int i;
    if (paramp != null)
    {
      i = paramp.getType();
      if (paramp == null) {
        break label184;
      }
    }
    label184:
    for (int j = paramp.hashCode();; j = -1)
    {
      Log.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s, type: %s, id: %s, currentSearchId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(i), Integer.valueOf(j), this.PvU });
      if ((paramp != null) && (paramp.hashCode() == this.PvU.intValue())) {
        this.vDm = false;
      }
      if ((paramp == null) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break label670;
      }
      if (paramp.getType() != 1169) {
        break label569;
      }
      if (paramp.hashCode() == this.PvU.intValue()) {
        break label190;
      }
      Log.w("MicroMsg.SettingsSearchAuthUI", "search scene is cancelled and ignore, %s", new Object[] { Integer.valueOf(paramp.hashCode()) });
      AppMethodBeat.o(74399);
      return;
      i = -1;
      break;
    }
    label190:
    paramString = (n)paramp;
    label243:
    List localList;
    if ((paramString.PnL != null) && (paramString.PnL.aazZ == 1))
    {
      paramString = paramString.PnL.aazX.toByteArray();
      this.PnI = paramString;
      if (((n)paramp).PnI == null) {
        break label546;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        this.PvR.clear();
      }
      localList = this.PvR;
      paramString = (n)paramp;
      if (paramString.PnL == null) {
        break label551;
      }
    }
    label546:
    label551:
    for (paramString = paramString.PnL.aazY;; paramString = Collections.emptyList())
    {
      localList.addAll(paramString);
      if (this.PvR.isEmpty()) {
        break label558;
      }
      this.PvS.PtA = this.PvR;
      this.PvS.notifyDataSetChanged();
      this.PvM.setVisibility(8);
      this.mListView.setVisibility(0);
      removeAllOptionMenu();
      if ((!this.PvR.isEmpty()) && (this.PnI == null))
      {
        if (this.wDF != null)
        {
          this.PvX = false;
          this.mListView.removeFooterView(this.wDF);
        }
        gWg();
        if (this.PvV == null) {
          this.PvV = LayoutInflater.from(this).inflate(b.g.layout_settings_auth_search_no_more_result_footer, null);
        }
        this.mListView.addFooterView(this.PvV);
      }
      if ((!this.PvR.isEmpty()) && (this.PnI != null) && (!this.PvX))
      {
        gWg();
        this.PvX = true;
        if (this.wDF == null)
        {
          this.wDF = LayoutInflater.from(this).inflate(b.g.layout_settings_auth_list_loading_more, null);
          this.IwM = this.wDF.findViewById(b.f.loading_progress_bar);
          this.PvW = this.wDF.findViewById(b.f.loading_reload_layout);
          this.PvW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(298840);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this).setVisibility(0);
              SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setVisibility(8);
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.c(SettingsSearchAuthUI.this), SettingsSearchAuthUI.d(SettingsSearchAuthUI.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(298840);
            }
          });
        }
        this.mListView.addFooterView(this.wDF);
      }
      AppMethodBeat.o(74399);
      return;
      paramString = null;
      break;
      paramInt1 = 0;
      break label243;
    }
    label558:
    gWf();
    AppMethodBeat.o(74399);
    return;
    label569:
    if (paramp.getType() == 1127)
    {
      paramString = ((e)paramp).appId;
      if (!Util.isNullOrNil(paramString))
      {
        if (!this.PvR.isEmpty())
        {
          paramp = this.PvR.iterator();
          while (paramp.hasNext()) {
            if (((fun)paramp.next()).appid.equals(paramString)) {
              paramp.remove();
            }
          }
        }
        this.PvS.notifyDataSetChanged();
      }
      AppMethodBeat.o(74399);
      return;
      if ((paramp != null) && (paramp.getType() == 1169) && (paramp.hashCode() == this.PvU.intValue()))
      {
        if (this.PvR.isEmpty())
        {
          this.PvM.setVisibility(0);
          this.PvO.setVisibility(8);
          this.PvQ.setVisibility(8);
          this.PvP.setVisibility(0);
          this.PvP.setText(getResources().getString(b.i.settings_auth_search_failed));
          this.mListView.setVisibility(8);
          this.PvR.clear();
          removeAllOptionMenu();
          AppMethodBeat.o(74399);
          return;
        }
        if (this.wDF != null)
        {
          this.IwM.setVisibility(8);
          this.PvW.setVisibility(0);
        }
      }
    }
    label670:
    AppMethodBeat.o(74399);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private int Psp;
    private int Psq;
    List<fun> PtA;
    private int contentWidth;
    
    public a()
    {
      AppMethodBeat.i(299397);
      this.contentWidth = 0;
      this.Psp = 0;
      this.Psq = 0;
      int i = com.tencent.mm.cd.a.ms(SettingsSearchAuthUI.this.getContext());
      this$1 = SettingsSearchAuthUI.this.getContext().getResources();
      this.contentWidth = (i - SettingsSearchAuthUI.this.getDimensionPixelSize(b.d.Edge_2A) * 2 - SettingsSearchAuthUI.this.getDimensionPixelSize(b.d.Edge_0_5_A));
      this.Psp = (this.contentWidth / 2);
      this.Psq = (this.contentWidth / 2);
      Log.i("MicroMsg.SettingsSearchAuthUI", "computeViewWidth appName: %s, appType: %s, content: %s", new Object[] { Integer.valueOf(this.Psp), Integer.valueOf(this.Psq), Integer.valueOf(this.contentWidth) });
      AppMethodBeat.o(299397);
    }
    
    public final fun aiV(int paramInt)
    {
      AppMethodBeat.i(74389);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        fun localfun = (fun)this.PtA.get(paramInt);
        AppMethodBeat.o(74389);
        return localfun;
      }
      AppMethodBeat.o(74389);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74388);
      if ((this.PtA != null) && (!this.PtA.isEmpty()))
      {
        int i = this.PtA.size();
        AppMethodBeat.o(74388);
        return i;
      }
      AppMethodBeat.o(74388);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74390);
      View localView;
      if (paramView == null)
      {
        localView = SettingsSearchAuthUI.this.getLayoutInflater().inflate(b.g.layout_settings_search_auth_list_app_item, null);
        paramView = new a((byte)0);
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        paramViewGroup.PvZ = ((MMNeat7extView)localView.findViewById(b.f.settings_auth_item_name));
        paramViewGroup.PtE = ((TextView)localView.findViewById(b.f.settings_auth_item_type));
        if (aiV(paramInt) != null)
        {
          paramViewGroup.PvZ.aZ(aiV(paramInt).nSt);
          paramViewGroup.PtE.setText(aiV(paramInt).abSK);
        }
        r.a(paramViewGroup.PvZ, paramViewGroup.PtE, this.contentWidth, this.Psp, this.Psq, true);
        AppMethodBeat.o(74390);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
    }
    
    final class a
    {
      TextView PtE;
      MMNeat7extView PvZ;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */