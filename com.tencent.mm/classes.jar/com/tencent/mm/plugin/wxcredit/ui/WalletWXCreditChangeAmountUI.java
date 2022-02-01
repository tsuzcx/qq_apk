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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private EditText JQA;
  private BaseAdapter JQB;
  private BaseAdapter JQC;
  private List<l> JQk;
  private List<l> JQl;
  private l JQm;
  private l JQn;
  private int JQo;
  private boolean JQp;
  private boolean JQq;
  private TextView JQr;
  private TextView JQs;
  private TextView JQt;
  private TextView JQu;
  private TextView JQv;
  private TextView JQw;
  private EditText JQx;
  private EditText JQy;
  private EditText JQz;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(72347);
    this.JQl = new ArrayList();
    this.JQo = -1;
    this.JQB = new BaseAdapter()
    {
      private l aht(int paramAnonymousInt)
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
        paramAnonymousView = (CheckedTextView)View.inflate(WalletWXCreditChangeAmountUI.this, 2131496951, null);
        paramAnonymousViewGroup = aht(paramAnonymousInt);
        paramAnonymousView.setText(paramAnonymousViewGroup.desc);
        if (paramAnonymousViewGroup.JQb != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(72345);
          return paramAnonymousView;
        }
      }
    };
    this.JQC = new BaseAdapter()
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
        paramAnonymousView = (CheckedTextView)View.inflate(WalletWXCreditChangeAmountUI.this, 2131496951, null);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousView.setText(2131756033);
          if (!WalletWXCreditChangeAmountUI.l(WalletWXCreditChangeAmountUI.this)) {
            break label137;
          }
          if ((WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).JQe == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).yWF))) {
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
          paramAnonymousView.setText(2131755917);
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
        if ((WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).JQe != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).yWF)))
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
    if (this.JQm != null)
    {
      this.JQr.setText(this.JQm.desc);
      if (this.JQm.JQe == null) {
        break label300;
      }
      this.JQv.setVisibility(0);
      this.JQx.setVisibility(8);
      this.JQt.setText(this.JQm.JQe.desc);
      this.JQy.setHint(this.JQm.JQe.pWf);
      if (!"Y".equals(this.JQm.yWF)) {
        break label255;
      }
      this.JQt.setVisibility(0);
      this.JQy.setVisibility(0);
      this.JQv.setText(2131756033);
    }
    while (this.JQn != null)
    {
      this.JQs.setText(this.JQn.desc);
      if (this.JQn.JQe != null)
      {
        this.JQw.setVisibility(0);
        this.JQz.setVisibility(8);
        this.JQu.setText(this.JQn.JQe.desc);
        this.JQA.setHint(this.JQn.JQe.pWf);
        if ("Y".equals(this.JQn.yWF))
        {
          this.JQu.setVisibility(0);
          this.JQA.setVisibility(0);
          this.JQw.setText(2131756033);
          AppMethodBeat.o(72350);
          return;
          label255:
          this.JQt.setVisibility(8);
          this.JQy.setVisibility(8);
          if ("N".equals(this.JQm.yWF))
          {
            this.JQv.setText(2131755917);
            continue;
            label300:
            this.JQv.setVisibility(8);
            this.JQx.setVisibility(0);
            this.JQx.setHint(this.JQm.pWf);
            this.JQt.setVisibility(8);
            this.JQy.setVisibility(8);
          }
        }
        else
        {
          this.JQu.setVisibility(8);
          this.JQA.setVisibility(8);
          if ("N".equals(this.JQn.yWF))
          {
            this.JQw.setText(2131755917);
            AppMethodBeat.o(72350);
          }
        }
      }
      else
      {
        this.JQw.setVisibility(8);
        this.JQz.setVisibility(0);
        this.JQz.setHint(this.JQn.pWf);
        this.JQu.setVisibility(8);
        this.JQA.setVisibility(8);
      }
    }
    AppMethodBeat.o(72350);
  }
  
  public int getLayoutId()
  {
    return 2131497024;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72349);
    setMMTitle(2131768481);
    this.JQr = ((TextView)findViewById(2131310318));
    this.JQt = ((TextView)findViewById(2131310319));
    this.JQs = ((TextView)findViewById(2131310320));
    this.JQu = ((TextView)findViewById(2131310321));
    this.JQx = ((EditText)findViewById(2131310308));
    this.JQy = ((EditText)findViewById(2131310309));
    this.JQz = ((EditText)findViewById(2131310310));
    this.JQA = ((EditText)findViewById(2131310311));
    this.JQv = ((TextView)findViewById(2131310312));
    this.JQw = ((TextView)findViewById(2131310313));
    this.JQv.setOnClickListener(this);
    this.JQw.setOnClickListener(this);
    this.JQr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72332);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, true);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72332);
      }
    });
    this.JQs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72336);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    findViewById(2131305423).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72338);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
          if (WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).JQe != null)
          {
            if (WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).JQe.yWF = WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).JQe == null) {
              break label272;
            }
            if (WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).JQe.yWF = WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getText().toString();
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
          WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).yWF = WalletWXCreditChangeAmountUI.e(WalletWXCreditChangeAmountUI.this).getText().toString();
          break;
          label272:
          WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).yWF = WalletWXCreditChangeAmountUI.h(WalletWXCreditChangeAmountUI.this).getText().toString();
          break label148;
          u.makeText(WalletWXCreditChangeAmountUI.this.getContext(), 2131768477, 0).show();
        }
      }
    });
    AppMethodBeat.o(72349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72352);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView.getId() == 2131310312)
    {
      this.JQq = true;
      showDialog(2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(72352);
      return;
      if (paramView.getId() == 2131310313)
      {
        this.JQq = false;
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72351);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof e))
      {
        this.JQk = ((e)paramq).JPJ;
        this.JQo = ((e)paramq).JPK;
        if ((this.JQk != null) && (this.JQk.size() >= 2))
        {
          this.JQm = ((l)this.JQk.get(0));
          this.JQn = ((l)this.JQk.get(1));
          this.JQm.JQb = 1;
          this.JQn.JQb = 2;
        }
        updateView();
        AppMethodBeat.o(72351);
        return true;
      }
    }
    else if ((paramq instanceof c))
    {
      h.a(this, paramString, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72335);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.a.by(WalletWXCreditChangeAmountUI.this);
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