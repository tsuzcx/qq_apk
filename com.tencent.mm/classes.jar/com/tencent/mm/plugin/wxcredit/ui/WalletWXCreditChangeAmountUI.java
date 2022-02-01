package com.tencent.mm.plugin.wxcredit.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private List<l> XHZ;
  private List<l> XIa;
  private l XIb;
  private l XIc;
  private int XId;
  private boolean XIe;
  private boolean XIf;
  private TextView XIg;
  private TextView XIh;
  private TextView XIi;
  private TextView XIj;
  private TextView XIk;
  private TextView XIl;
  private EditText XIm;
  private EditText XIn;
  private EditText XIo;
  private EditText XIp;
  private BaseAdapter XIq;
  private BaseAdapter XIr;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(72347);
    this.XIa = new ArrayList();
    this.XId = -1;
    this.XIq = new BaseAdapter()
    {
      private l avi(int paramAnonymousInt)
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
        paramAnonymousView = (CheckedTextView)View.inflate(WalletWXCreditChangeAmountUI.this, a.g.wallet_list_dialog_item_singlechoice, null);
        paramAnonymousViewGroup = avi(paramAnonymousInt);
        paramAnonymousView.setText(paramAnonymousViewGroup.desc);
        if (paramAnonymousViewGroup.XHQ != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(72345);
          return paramAnonymousView;
        }
      }
    };
    this.XIr = new BaseAdapter()
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
        paramAnonymousView = (CheckedTextView)View.inflate(WalletWXCreditChangeAmountUI.this, a.g.wallet_list_dialog_item_singlechoice, null);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousView.setText(a.i.app_yes);
          if (!WalletWXCreditChangeAmountUI.l(WalletWXCreditChangeAmountUI.this)) {
            break label140;
          }
          if ((WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).XHT == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).KtE))) {
            break label117;
          }
          if (paramAnonymousInt != 0) {
            break label111;
          }
        }
        for (;;)
        {
          paramAnonymousView.setChecked(bool1);
          AppMethodBeat.o(72333);
          return paramAnonymousView;
          paramAnonymousView.setText(a.i.app_no);
          break;
          label111:
          bool1 = false;
        }
        label117:
        if (paramAnonymousInt != 0) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramAnonymousView.setChecked(bool1);
          break;
        }
        label140:
        if ((WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).XHT != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).KtE)))
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
    if (this.XIb != null)
    {
      this.XIg.setText(this.XIb.desc);
      if (this.XIb.XHT == null) {
        break label303;
      }
      this.XIk.setVisibility(0);
      this.XIm.setVisibility(8);
      this.XIi.setText(this.XIb.XHT.desc);
      this.XIn.setHint(this.XIb.XHT.lym);
      if (!"Y".equals(this.XIb.KtE)) {
        break label257;
      }
      this.XIi.setVisibility(0);
      this.XIn.setVisibility(0);
      this.XIk.setText(a.i.app_yes);
    }
    while (this.XIc != null)
    {
      this.XIh.setText(this.XIc.desc);
      if (this.XIc.XHT != null)
      {
        this.XIl.setVisibility(0);
        this.XIo.setVisibility(8);
        this.XIj.setText(this.XIc.XHT.desc);
        this.XIp.setHint(this.XIc.XHT.lym);
        if ("Y".equals(this.XIc.KtE))
        {
          this.XIj.setVisibility(0);
          this.XIp.setVisibility(0);
          this.XIl.setText(a.i.app_yes);
          AppMethodBeat.o(72350);
          return;
          label257:
          this.XIi.setVisibility(8);
          this.XIn.setVisibility(8);
          if ("N".equals(this.XIb.KtE))
          {
            this.XIk.setText(a.i.app_no);
            continue;
            label303:
            this.XIk.setVisibility(8);
            this.XIm.setVisibility(0);
            this.XIm.setHint(this.XIb.lym);
            this.XIi.setVisibility(8);
            this.XIn.setVisibility(8);
          }
        }
        else
        {
          this.XIj.setVisibility(8);
          this.XIp.setVisibility(8);
          if ("N".equals(this.XIc.KtE))
          {
            this.XIl.setText(a.i.app_no);
            AppMethodBeat.o(72350);
          }
        }
      }
      else
      {
        this.XIl.setVisibility(8);
        this.XIo.setVisibility(0);
        this.XIo.setHint(this.XIc.lym);
        this.XIj.setVisibility(8);
        this.XIp.setVisibility(8);
      }
    }
    AppMethodBeat.o(72350);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_wxcredit_change_amount_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72349);
    setMMTitle(a.i.wallet_wxcredit_qustion_title);
    this.XIg = ((TextView)findViewById(a.f.wallet_wxcredit_question_1));
    this.XIi = ((TextView)findViewById(a.f.wallet_wxcredit_question_1_next));
    this.XIh = ((TextView)findViewById(a.f.wallet_wxcredit_question_2));
    this.XIj = ((TextView)findViewById(a.f.wallet_wxcredit_question_2_next));
    this.XIm = ((EditText)findViewById(a.f.wallet_wxcredit_answer_1));
    this.XIn = ((EditText)findViewById(a.f.wallet_wxcredit_answer_1_next));
    this.XIo = ((EditText)findViewById(a.f.wallet_wxcredit_answer_2));
    this.XIp = ((EditText)findViewById(a.f.wallet_wxcredit_answer_2_next));
    this.XIk = ((TextView)findViewById(a.f.wallet_wxcredit_answer_select_1));
    this.XIl = ((TextView)findViewById(a.f.wallet_wxcredit_answer_select_2));
    this.XIk.setOnClickListener(this);
    this.XIl.setOnClickListener(this);
    this.XIg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72332);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, true);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72332);
      }
    });
    this.XIh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72336);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    findViewById(a.f.next_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72338);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
          if (WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).XHT != null)
          {
            if (WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).XHT.KtE = WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).XHT == null) {
              break label272;
            }
            if (WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).XHT.KtE = WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getText().toString();
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
          WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).KtE = WalletWXCreditChangeAmountUI.e(WalletWXCreditChangeAmountUI.this).getText().toString();
          break;
          label272:
          WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).KtE = WalletWXCreditChangeAmountUI.h(WalletWXCreditChangeAmountUI.this).getText().toString();
          break label148;
          aa.makeText(WalletWXCreditChangeAmountUI.this.getContext(), a.i.wallet_wxcredit_qustion_input_err, 0).show();
        }
      }
    });
    AppMethodBeat.o(72349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72352);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView.getId() == a.f.wallet_wxcredit_answer_select_1)
    {
      this.XIf = true;
      showDialog(2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(72352);
      return;
      if (paramView.getId() == a.f.wallet_wxcredit_answer_select_2)
      {
        this.XIf = false;
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72351);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof com.tencent.mm.plugin.wxcredit.a.e))
      {
        this.XHZ = ((com.tencent.mm.plugin.wxcredit.a.e)paramp).XHy;
        this.XId = ((com.tencent.mm.plugin.wxcredit.a.e)paramp).XHz;
        if ((this.XHZ != null) && (this.XHZ.size() >= 2))
        {
          this.XIb = ((l)this.XHZ.get(0));
          this.XIc = ((l)this.XHZ.get(1));
          this.XIb.XHQ = 1;
          this.XIc.XHQ = 2;
        }
        updateView();
        AppMethodBeat.o(72351);
        return true;
      }
    }
    else if ((paramp instanceof c))
    {
      k.a(this, paramString, null, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72335);
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.a.cm(WalletWXCreditChangeAmountUI.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI
 * JD-Core Version:    0.7.0.1
 */