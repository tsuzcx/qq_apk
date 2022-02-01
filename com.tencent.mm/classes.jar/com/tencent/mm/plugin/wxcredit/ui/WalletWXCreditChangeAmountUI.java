package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private TextView EZA;
  private TextView EZB;
  private TextView EZC;
  private TextView EZD;
  private TextView EZE;
  private EditText EZF;
  private EditText EZG;
  private EditText EZH;
  private EditText EZI;
  private BaseAdapter EZJ;
  private BaseAdapter EZK;
  private List<l> EZs;
  private List<l> EZt;
  private l EZu;
  private l EZv;
  private int EZw;
  private boolean EZx;
  private boolean EZy;
  private TextView EZz;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(72347);
    this.EZt = new ArrayList();
    this.EZw = -1;
    this.EZJ = new BaseAdapter()
    {
      private l YH(int paramAnonymousInt)
      {
        AppMethodBeat.i(72344);
        l locall = (l)WalletWXCreditChangeAmountUI.j(WalletWXCreditChangeAmountUI.this).get(paramAnonymousInt);
        AppMethodBeat.o(72344);
        return locall;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(72343);
        if (WalletWXCreditChangeAmountUI.j(WalletWXCreditChangeAmountUI.this) != null)
        {
          int i = WalletWXCreditChangeAmountUI.j(WalletWXCreditChangeAmountUI.this).size();
          AppMethodBeat.o(72343);
          return i;
        }
        AppMethodBeat.o(72343);
        return 0;
      }
      
      public final long getItemId(int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        AppMethodBeat.i(72345);
        paramAnonymousView = (CheckedTextView)View.inflate(WalletWXCreditChangeAmountUI.this, 2131495971, null);
        paramAnonymousViewGroup = YH(paramAnonymousInt);
        paramAnonymousView.setText(paramAnonymousViewGroup.desc);
        if (paramAnonymousViewGroup.EZj != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(72345);
          return paramAnonymousView;
        }
      }
    };
    this.EZK = new BaseAdapter()
    {
      public final int getCount()
      {
        return 2;
      }
      
      public final long getItemId(int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        boolean bool2 = true;
        boolean bool3 = true;
        boolean bool4 = true;
        boolean bool1 = true;
        AppMethodBeat.i(72333);
        paramAnonymousView = (CheckedTextView)View.inflate(WalletWXCreditChangeAmountUI.this, 2131495971, null);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousView.setText(2131755939);
          if (!WalletWXCreditChangeAmountUI.l(WalletWXCreditChangeAmountUI.this)) {
            break label137;
          }
          if ((WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EZm == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).vBH))) {
            break label114;
          }
          if (paramAnonymousInt != 0) {
            break label108;
          }
        }
        for (;;)
        {
          paramAnonymousView.setChecked(bool1);
          AppMethodBeat.o(72333);
          return paramAnonymousView;
          paramAnonymousView.setText(2131755831);
          break;
          label108:
          bool1 = false;
        }
        label114:
        if (paramAnonymousInt != 0) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramAnonymousView.setChecked(bool1);
          break;
        }
        label137:
        if ((WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EZm != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).vBH)))
        {
          if (paramAnonymousInt == 0) {}
          for (bool1 = bool3;; bool1 = false)
          {
            paramAnonymousView.setChecked(bool1);
            break;
          }
        }
        if (paramAnonymousInt != 0) {}
        for (bool1 = bool4;; bool1 = false)
        {
          paramAnonymousView.setChecked(bool1);
          break;
        }
      }
    };
    AppMethodBeat.o(72347);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(72350);
    if (this.EZu != null)
    {
      this.EZz.setText(this.EZu.desc);
      if (this.EZu.EZm == null) {
        break label300;
      }
      this.EZD.setVisibility(0);
      this.EZF.setVisibility(8);
      this.EZB.setText(this.EZu.EZm.desc);
      this.EZG.setHint(this.EZu.EZm.oIr);
      if (!"Y".equals(this.EZu.vBH)) {
        break label255;
      }
      this.EZB.setVisibility(0);
      this.EZG.setVisibility(0);
      this.EZD.setText(2131755939);
    }
    while (this.EZv != null)
    {
      this.EZA.setText(this.EZv.desc);
      if (this.EZv.EZm != null)
      {
        this.EZE.setVisibility(0);
        this.EZH.setVisibility(8);
        this.EZC.setText(this.EZv.EZm.desc);
        this.EZI.setHint(this.EZv.EZm.oIr);
        if ("Y".equals(this.EZv.vBH))
        {
          this.EZC.setVisibility(0);
          this.EZI.setVisibility(0);
          this.EZE.setText(2131755939);
          AppMethodBeat.o(72350);
          return;
          label255:
          this.EZB.setVisibility(8);
          this.EZG.setVisibility(8);
          if ("N".equals(this.EZu.vBH))
          {
            this.EZD.setText(2131755831);
            continue;
            label300:
            this.EZD.setVisibility(8);
            this.EZF.setVisibility(0);
            this.EZF.setHint(this.EZu.oIr);
            this.EZB.setVisibility(8);
            this.EZG.setVisibility(8);
          }
        }
        else
        {
          this.EZC.setVisibility(8);
          this.EZI.setVisibility(8);
          if ("N".equals(this.EZv.vBH))
          {
            this.EZE.setText(2131755831);
            AppMethodBeat.o(72350);
          }
        }
      }
      else
      {
        this.EZE.setVisibility(8);
        this.EZH.setVisibility(0);
        this.EZH.setHint(this.EZv.oIr);
        this.EZC.setVisibility(8);
        this.EZI.setVisibility(8);
      }
    }
    AppMethodBeat.o(72350);
  }
  
  public int getLayoutId()
  {
    return 2131496044;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72349);
    setMMTitle(2131766028);
    this.EZz = ((TextView)findViewById(2131306856));
    this.EZB = ((TextView)findViewById(2131306857));
    this.EZA = ((TextView)findViewById(2131306858));
    this.EZC = ((TextView)findViewById(2131306859));
    this.EZF = ((EditText)findViewById(2131306846));
    this.EZG = ((EditText)findViewById(2131306847));
    this.EZH = ((EditText)findViewById(2131306848));
    this.EZI = ((EditText)findViewById(2131306849));
    this.EZD = ((TextView)findViewById(2131306850));
    this.EZE = ((TextView)findViewById(2131306851));
    this.EZD.setOnClickListener(this);
    this.EZE.setOnClickListener(this);
    this.EZz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72332);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, true);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72332);
      }
    });
    this.EZA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72336);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, false);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72336);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72337);
        WalletWXCreditChangeAmountUI.this.hideVKB();
        WalletWXCreditChangeAmountUI.this.showDialog(3);
        AppMethodBeat.o(72337);
        return true;
      }
    });
    findViewById(2131302852).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72338);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
          if (WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EZm != null)
          {
            if (WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EZm.vBH = WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EZm == null) {
              break label272;
            }
            if (WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EZm.vBH = WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            label148:
            paramAnonymousView = new ArrayList();
            paramAnonymousView.add(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this));
            paramAnonymousView.add(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this));
            localObject = WalletWXCreditChangeAmountUI.this.getInput().getString("kreq_token");
            WalletWXCreditChangeAmountUI.this.getInput().getString("key_bank_type");
            paramAnonymousView = new c(paramAnonymousView, (String)localObject);
            WalletWXCreditChangeAmountUI.this.doSceneForceProgress(paramAnonymousView);
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72338);
          return;
          WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).vBH = WalletWXCreditChangeAmountUI.e(WalletWXCreditChangeAmountUI.this).getText().toString();
          break;
          label272:
          WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).vBH = WalletWXCreditChangeAmountUI.h(WalletWXCreditChangeAmountUI.this).getText().toString();
          break label148;
          t.makeText(WalletWXCreditChangeAmountUI.this.getContext(), 2131766024, 0).show();
        }
      }
    });
    AppMethodBeat.o(72349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72352);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView.getId() == 2131306850)
    {
      this.EZy = true;
      showDialog(2);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(72352);
      return;
      if (paramView.getId() == 2131306851)
      {
        this.EZy = false;
        showDialog(2);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72348);
    super.onCreate(paramBundle);
    initView();
    updateView();
    AppMethodBeat.o(72348);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72351);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof e))
      {
        this.EZs = ((e)paramn).EYR;
        this.EZw = ((e)paramn).EYS;
        if ((this.EZs != null) && (this.EZs.size() >= 2))
        {
          this.EZu = ((l)this.EZs.get(0));
          this.EZv = ((l)this.EZs.get(1));
          this.EZu.EZj = 1;
          this.EZv.EZj = 2;
        }
        updateView();
        AppMethodBeat.o(72351);
        return true;
      }
    }
    else if ((paramn instanceof c))
    {
      h.a(this, paramString, null, false, new WalletWXCreditChangeAmountUI.3(this));
      AppMethodBeat.o(72351);
      return true;
    }
    AppMethodBeat.o(72351);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI
 * JD-Core Version:    0.7.0.1
 */