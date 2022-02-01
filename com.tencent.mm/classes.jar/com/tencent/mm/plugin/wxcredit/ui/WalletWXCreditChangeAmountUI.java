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
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private List<l> QOB;
  private List<l> QOC;
  private l QOD;
  private l QOE;
  private int QOF;
  private boolean QOG;
  private boolean QOH;
  private TextView QOI;
  private TextView QOJ;
  private TextView QOK;
  private TextView QOL;
  private TextView QOM;
  private TextView QON;
  private EditText QOO;
  private EditText QOP;
  private EditText QOQ;
  private EditText QOR;
  private BaseAdapter QOS;
  private BaseAdapter QOT;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(72347);
    this.QOC = new ArrayList();
    this.QOF = -1;
    this.QOS = new BaseAdapter()
    {
      private l apk(int paramAnonymousInt)
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
        paramAnonymousViewGroup = apk(paramAnonymousInt);
        paramAnonymousView.setText(paramAnonymousViewGroup.desc);
        if (paramAnonymousViewGroup.QOs != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(72345);
          return paramAnonymousView;
        }
      }
    };
    this.QOT = new BaseAdapter()
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
          if ((WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).QOv == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EAI))) {
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
        if ((WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).QOv != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EAI)))
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
    if (this.QOD != null)
    {
      this.QOI.setText(this.QOD.desc);
      if (this.QOD.QOv == null) {
        break label303;
      }
      this.QOM.setVisibility(0);
      this.QOO.setVisibility(8);
      this.QOK.setText(this.QOD.QOv.desc);
      this.QOP.setHint(this.QOD.QOv.tsf);
      if (!"Y".equals(this.QOD.EAI)) {
        break label257;
      }
      this.QOK.setVisibility(0);
      this.QOP.setVisibility(0);
      this.QOM.setText(a.i.app_yes);
    }
    while (this.QOE != null)
    {
      this.QOJ.setText(this.QOE.desc);
      if (this.QOE.QOv != null)
      {
        this.QON.setVisibility(0);
        this.QOQ.setVisibility(8);
        this.QOL.setText(this.QOE.QOv.desc);
        this.QOR.setHint(this.QOE.QOv.tsf);
        if ("Y".equals(this.QOE.EAI))
        {
          this.QOL.setVisibility(0);
          this.QOR.setVisibility(0);
          this.QON.setText(a.i.app_yes);
          AppMethodBeat.o(72350);
          return;
          label257:
          this.QOK.setVisibility(8);
          this.QOP.setVisibility(8);
          if ("N".equals(this.QOD.EAI))
          {
            this.QOM.setText(a.i.app_no);
            continue;
            label303:
            this.QOM.setVisibility(8);
            this.QOO.setVisibility(0);
            this.QOO.setHint(this.QOD.tsf);
            this.QOK.setVisibility(8);
            this.QOP.setVisibility(8);
          }
        }
        else
        {
          this.QOL.setVisibility(8);
          this.QOR.setVisibility(8);
          if ("N".equals(this.QOE.EAI))
          {
            this.QON.setText(a.i.app_no);
            AppMethodBeat.o(72350);
          }
        }
      }
      else
      {
        this.QON.setVisibility(8);
        this.QOQ.setVisibility(0);
        this.QOQ.setHint(this.QOE.tsf);
        this.QOL.setVisibility(8);
        this.QOR.setVisibility(8);
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
    this.QOI = ((TextView)findViewById(a.f.wallet_wxcredit_question_1));
    this.QOK = ((TextView)findViewById(a.f.wallet_wxcredit_question_1_next));
    this.QOJ = ((TextView)findViewById(a.f.wallet_wxcredit_question_2));
    this.QOL = ((TextView)findViewById(a.f.wallet_wxcredit_question_2_next));
    this.QOO = ((EditText)findViewById(a.f.wallet_wxcredit_answer_1));
    this.QOP = ((EditText)findViewById(a.f.wallet_wxcredit_answer_1_next));
    this.QOQ = ((EditText)findViewById(a.f.wallet_wxcredit_answer_2));
    this.QOR = ((EditText)findViewById(a.f.wallet_wxcredit_answer_2_next));
    this.QOM = ((TextView)findViewById(a.f.wallet_wxcredit_answer_select_1));
    this.QON = ((TextView)findViewById(a.f.wallet_wxcredit_answer_select_2));
    this.QOM.setOnClickListener(this);
    this.QON.setOnClickListener(this);
    this.QOI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72332);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, true);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72332);
      }
    });
    this.QOJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72336);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this)) {
          if (WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).QOv != null)
          {
            if (WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).QOv.EAI = WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).QOv == null) {
              break label272;
            }
            if (WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).QOv.EAI = WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getText().toString();
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
          WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).EAI = WalletWXCreditChangeAmountUI.e(WalletWXCreditChangeAmountUI.this).getText().toString();
          break;
          label272:
          WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).EAI = WalletWXCreditChangeAmountUI.h(WalletWXCreditChangeAmountUI.this).getText().toString();
          break label148;
          w.makeText(WalletWXCreditChangeAmountUI.this.getContext(), a.i.wallet_wxcredit_qustion_input_err, 0).show();
        }
      }
    });
    AppMethodBeat.o(72349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72352);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView.getId() == a.f.wallet_wxcredit_answer_select_1)
    {
      this.QOH = true;
      showDialog(2);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditChangeAmountUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(72352);
      return;
      if (paramView.getId() == a.f.wallet_wxcredit_answer_select_2)
      {
        this.QOH = false;
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
        this.QOB = ((e)paramq).QOa;
        this.QOF = ((e)paramq).QOb;
        if ((this.QOB != null) && (this.QOB.size() >= 2))
        {
          this.QOD = ((l)this.QOB.get(0));
          this.QOE = ((l)this.QOB.get(1));
          this.QOD.QOs = 1;
          this.QOE.QOs = 2;
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
          paramAnonymousDialogInterface = com.tencent.mm.wallet_core.a.bF(WalletWXCreditChangeAmountUI.this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI
 * JD-Core Version:    0.7.0.1
 */