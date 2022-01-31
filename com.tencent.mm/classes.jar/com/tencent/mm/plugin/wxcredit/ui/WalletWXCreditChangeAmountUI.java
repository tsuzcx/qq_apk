package com.tencent.mm.plugin.wxcredit.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private EditText rRA;
  private EditText rRB;
  private EditText rRC;
  private BaseAdapter rRD = new WalletWXCreditChangeAmountUI.11(this);
  private BaseAdapter rRE = new WalletWXCreditChangeAmountUI.2(this);
  private List<l> rRm;
  private List<l> rRn = new ArrayList();
  private l rRo;
  private l rRp;
  private int rRq = -1;
  private boolean rRr;
  private boolean rRs;
  private TextView rRt;
  private TextView rRu;
  private TextView rRv;
  private TextView rRw;
  private TextView rRx;
  private TextView rRy;
  private EditText rRz;
  
  private void aZ()
  {
    if (this.rRo != null)
    {
      this.rRt.setText(this.rRo.desc);
      if (this.rRo.rRg == null) {
        break label293;
      }
      this.rRx.setVisibility(0);
      this.rRz.setVisibility(8);
      this.rRv.setText(this.rRo.rRg.desc);
      this.rRA.setHint(this.rRo.rRg.ioU);
      if ("Y".equals(this.rRo.lQN))
      {
        this.rRv.setVisibility(0);
        this.rRA.setVisibility(0);
        this.rRx.setText(a.i.app_yes);
      }
    }
    else if (this.rRp != null)
    {
      this.rRu.setText(this.rRp.desc);
      if (this.rRp.rRg == null) {
        break label389;
      }
      this.rRy.setVisibility(0);
      this.rRB.setVisibility(8);
      this.rRw.setText(this.rRp.rRg.desc);
      this.rRC.setHint(this.rRp.rRg.ioU);
      if (!"Y".equals(this.rRp.lQN)) {
        break label345;
      }
      this.rRw.setVisibility(0);
      this.rRC.setVisibility(0);
      this.rRy.setText(a.i.app_yes);
    }
    label293:
    label345:
    do
    {
      return;
      this.rRv.setVisibility(8);
      this.rRA.setVisibility(8);
      if (!"N".equals(this.rRo.lQN)) {
        break;
      }
      this.rRx.setText(a.i.app_no);
      break;
      this.rRx.setVisibility(8);
      this.rRz.setVisibility(0);
      this.rRz.setHint(this.rRo.ioU);
      this.rRv.setVisibility(8);
      this.rRA.setVisibility(8);
      break;
      this.rRw.setVisibility(8);
      this.rRC.setVisibility(8);
    } while (!"N".equals(this.rRp.lQN));
    this.rRy.setText(a.i.app_no);
    return;
    label389:
    this.rRy.setVisibility(8);
    this.rRB.setVisibility(0);
    this.rRB.setHint(this.rRp.ioU);
    this.rRw.setVisibility(8);
    this.rRC.setVisibility(8);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof e))
      {
        this.rRm = ((e)paramm).rQK;
        this.rRq = ((e)paramm).rQL;
        if ((this.rRm != null) && (this.rRm.size() >= 2))
        {
          this.rRo = ((l)this.rRm.get(0));
          this.rRp = ((l)this.rRm.get(1));
          this.rRo.rRd = 1;
          this.rRp.rRd = 2;
        }
        aZ();
        return true;
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.wxcredit.a.c))
    {
      h.a(this, paramString, null, false, new WalletWXCreditChangeAmountUI.3(this));
      return true;
    }
    return false;
  }
  
  public final int getLayoutId()
  {
    return a.g.wallet_wxcredit_change_amount_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_wxcredit_qustion_title);
    this.rRt = ((TextView)findViewById(a.f.wallet_wxcredit_question_1));
    this.rRv = ((TextView)findViewById(a.f.wallet_wxcredit_question_1_next));
    this.rRu = ((TextView)findViewById(a.f.wallet_wxcredit_question_2));
    this.rRw = ((TextView)findViewById(a.f.wallet_wxcredit_question_2_next));
    this.rRz = ((EditText)findViewById(a.f.wallet_wxcredit_answer_1));
    this.rRA = ((EditText)findViewById(a.f.wallet_wxcredit_answer_1_next));
    this.rRB = ((EditText)findViewById(a.f.wallet_wxcredit_answer_2));
    this.rRC = ((EditText)findViewById(a.f.wallet_wxcredit_answer_2_next));
    this.rRx = ((TextView)findViewById(a.f.wallet_wxcredit_answer_select_1));
    this.rRy = ((TextView)findViewById(a.f.wallet_wxcredit_answer_select_2));
    this.rRx.setOnClickListener(this);
    this.rRy.setOnClickListener(this);
    this.rRt.setOnClickListener(new WalletWXCreditChangeAmountUI.1(this));
    this.rRu.setOnClickListener(new WalletWXCreditChangeAmountUI.4(this));
    setBackBtn(new WalletWXCreditChangeAmountUI.5(this));
    findViewById(a.f.next_btn).setOnClickListener(new WalletWXCreditChangeAmountUI.6(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == a.f.wallet_wxcredit_answer_select_1)
    {
      this.rRs = true;
      showDialog(2);
    }
    while (paramView.getId() != a.f.wallet_wxcredit_answer_select_2) {
      return;
    }
    this.rRs = false;
    showDialog(2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI
 * JD-Core Version:    0.7.0.1
 */