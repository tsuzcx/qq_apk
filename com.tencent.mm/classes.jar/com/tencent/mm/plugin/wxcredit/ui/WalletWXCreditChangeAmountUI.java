package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private List<l> EGW;
  private List<l> EGX;
  private l EGY;
  private l EGZ;
  private int EHa;
  private boolean EHb;
  private boolean EHc;
  private TextView EHd;
  private TextView EHe;
  private TextView EHf;
  private TextView EHg;
  private TextView EHh;
  private TextView EHi;
  private EditText EHj;
  private EditText EHk;
  private EditText EHl;
  private EditText EHm;
  private BaseAdapter EHn;
  private BaseAdapter EHo;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(72347);
    this.EGX = new ArrayList();
    this.EHa = -1;
    this.EHn = new BaseAdapter()
    {
      private l Yb(int paramAnonymousInt)
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
        paramAnonymousViewGroup = Yb(paramAnonymousInt);
        paramAnonymousView.setText(paramAnonymousViewGroup.desc);
        if (paramAnonymousViewGroup.EGN != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(72345);
          return paramAnonymousView;
        }
      }
    };
    this.EHo = new BaseAdapter()
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
          if ((WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EGQ == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).vpC))) {
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
        if ((WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EGQ != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).vpC)))
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
    if (this.EGY != null)
    {
      this.EHd.setText(this.EGY.desc);
      if (this.EGY.EGQ == null) {
        break label300;
      }
      this.EHh.setVisibility(0);
      this.EHj.setVisibility(8);
      this.EHf.setText(this.EGY.EGQ.desc);
      this.EHk.setHint(this.EGY.EGQ.oBP);
      if (!"Y".equals(this.EGY.vpC)) {
        break label255;
      }
      this.EHf.setVisibility(0);
      this.EHk.setVisibility(0);
      this.EHh.setText(2131755939);
    }
    while (this.EGZ != null)
    {
      this.EHe.setText(this.EGZ.desc);
      if (this.EGZ.EGQ != null)
      {
        this.EHi.setVisibility(0);
        this.EHl.setVisibility(8);
        this.EHg.setText(this.EGZ.EGQ.desc);
        this.EHm.setHint(this.EGZ.EGQ.oBP);
        if ("Y".equals(this.EGZ.vpC))
        {
          this.EHg.setVisibility(0);
          this.EHm.setVisibility(0);
          this.EHi.setText(2131755939);
          AppMethodBeat.o(72350);
          return;
          label255:
          this.EHf.setVisibility(8);
          this.EHk.setVisibility(8);
          if ("N".equals(this.EGY.vpC))
          {
            this.EHh.setText(2131755831);
            continue;
            label300:
            this.EHh.setVisibility(8);
            this.EHj.setVisibility(0);
            this.EHj.setHint(this.EGY.oBP);
            this.EHf.setVisibility(8);
            this.EHk.setVisibility(8);
          }
        }
        else
        {
          this.EHg.setVisibility(8);
          this.EHm.setVisibility(8);
          if ("N".equals(this.EGZ.vpC))
          {
            this.EHi.setText(2131755831);
            AppMethodBeat.o(72350);
          }
        }
      }
      else
      {
        this.EHi.setVisibility(8);
        this.EHl.setVisibility(0);
        this.EHl.setHint(this.EGZ.oBP);
        this.EHg.setVisibility(8);
        this.EHm.setVisibility(8);
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
    this.EHd = ((TextView)findViewById(2131306856));
    this.EHf = ((TextView)findViewById(2131306857));
    this.EHe = ((TextView)findViewById(2131306858));
    this.EHg = ((TextView)findViewById(2131306859));
    this.EHj = ((EditText)findViewById(2131306846));
    this.EHk = ((EditText)findViewById(2131306847));
    this.EHl = ((EditText)findViewById(2131306848));
    this.EHm = ((EditText)findViewById(2131306849));
    this.EHh = ((TextView)findViewById(2131306850));
    this.EHi = ((TextView)findViewById(2131306851));
    this.EHh.setOnClickListener(this);
    this.EHi.setOnClickListener(this);
    this.EHd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72332);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, true);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72332);
      }
    });
    this.EHe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72336);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, false);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
          if (WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EGQ != null)
          {
            if (WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EGQ.vpC = WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EGQ == null) {
              break label272;
            }
            if (WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EGQ.vpC = WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getText().toString();
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
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72338);
          return;
          WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).vpC = WalletWXCreditChangeAmountUI.e(WalletWXCreditChangeAmountUI.this).getText().toString();
          break;
          label272:
          WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).vpC = WalletWXCreditChangeAmountUI.h(WalletWXCreditChangeAmountUI.this).getText().toString();
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (paramView.getId() == 2131306850)
    {
      this.EHc = true;
      showDialog(2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(72352);
      return;
      if (paramView.getId() == 2131306851)
      {
        this.EHc = false;
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
        this.EGW = ((e)paramn).EGv;
        this.EHa = ((e)paramn).EGw;
        if ((this.EGW != null) && (this.EGW.size() >= 2))
        {
          this.EGY = ((l)this.EGW.get(0));
          this.EGZ = ((l)this.EGW.get(1));
          this.EGY.EGN = 1;
          this.EGZ.EGN = 2;
        }
        updateView();
        AppMethodBeat.o(72351);
        return true;
      }
    }
    else if ((paramn instanceof c))
    {
      h.a(this, paramString, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72335);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.a.br(WalletWXCreditChangeAmountUI.this);
          if (paramAnonymousDialogInterface != null)
          {
            paramAnonymousDialogInterface.b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.getInput());
            AppMethodBeat.o(72335);
            return;
          }
          WalletWXCreditChangeAmountUI.this.finish();
          AppMethodBeat.o(72335);
        }
      });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI
 * JD-Core Version:    0.7.0.1
 */