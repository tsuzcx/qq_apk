package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private List<l> vIc;
  private List<l> vId;
  private l vIe;
  private l vIf;
  private int vIg;
  private boolean vIh;
  private boolean vIi;
  private TextView vIj;
  private TextView vIk;
  private TextView vIl;
  private TextView vIm;
  private TextView vIn;
  private TextView vIo;
  private EditText vIp;
  private EditText vIq;
  private EditText vIr;
  private EditText vIs;
  private BaseAdapter vIt;
  private BaseAdapter vIu;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(48703);
    this.vId = new ArrayList();
    this.vIg = -1;
    this.vIt = new WalletWXCreditChangeAmountUI.11(this);
    this.vIu = new WalletWXCreditChangeAmountUI.2(this);
    AppMethodBeat.o(48703);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(48706);
    if (this.vIe != null)
    {
      this.vIj.setText(this.vIe.desc);
      if (this.vIe.vHW == null) {
        break label300;
      }
      this.vIn.setVisibility(0);
      this.vIp.setVisibility(8);
      this.vIl.setText(this.vIe.vHW.desc);
      this.vIq.setHint(this.vIe.vHW.kqb);
      if (!"Y".equals(this.vIe.ooD)) {
        break label255;
      }
      this.vIl.setVisibility(0);
      this.vIq.setVisibility(0);
      this.vIn.setText(2131297115);
    }
    while (this.vIf != null)
    {
      this.vIk.setText(this.vIf.desc);
      if (this.vIf.vHW != null)
      {
        this.vIo.setVisibility(0);
        this.vIr.setVisibility(8);
        this.vIm.setText(this.vIf.vHW.desc);
        this.vIs.setHint(this.vIf.vHW.kqb);
        if ("Y".equals(this.vIf.ooD))
        {
          this.vIm.setVisibility(0);
          this.vIs.setVisibility(0);
          this.vIo.setText(2131297115);
          AppMethodBeat.o(48706);
          return;
          label255:
          this.vIl.setVisibility(8);
          this.vIq.setVisibility(8);
          if ("N".equals(this.vIe.ooD))
          {
            this.vIn.setText(2131297014);
            continue;
            label300:
            this.vIn.setVisibility(8);
            this.vIp.setVisibility(0);
            this.vIp.setHint(this.vIe.kqb);
            this.vIl.setVisibility(8);
            this.vIq.setVisibility(8);
          }
        }
        else
        {
          this.vIm.setVisibility(8);
          this.vIs.setVisibility(8);
          if ("N".equals(this.vIf.ooD))
          {
            this.vIo.setText(2131297014);
            AppMethodBeat.o(48706);
          }
        }
      }
      else
      {
        this.vIo.setVisibility(8);
        this.vIr.setVisibility(0);
        this.vIr.setHint(this.vIf.kqb);
        this.vIm.setVisibility(8);
        this.vIs.setVisibility(8);
      }
    }
    AppMethodBeat.o(48706);
  }
  
  public int getLayoutId()
  {
    return 2130971267;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48705);
    setMMTitle(2131305808);
    this.vIj = ((TextView)findViewById(2131829419));
    this.vIl = ((TextView)findViewById(2131829422));
    this.vIk = ((TextView)findViewById(2131829424));
    this.vIm = ((TextView)findViewById(2131829427));
    this.vIp = ((EditText)findViewById(2131829420));
    this.vIq = ((EditText)findViewById(2131829423));
    this.vIr = ((EditText)findViewById(2131829425));
    this.vIs = ((EditText)findViewById(2131829428));
    this.vIn = ((TextView)findViewById(2131829421));
    this.vIo = ((TextView)findViewById(2131829426));
    this.vIn.setOnClickListener(this);
    this.vIo.setOnClickListener(this);
    this.vIj.setOnClickListener(new WalletWXCreditChangeAmountUI.1(this));
    this.vIk.setOnClickListener(new WalletWXCreditChangeAmountUI.4(this));
    setBackBtn(new WalletWXCreditChangeAmountUI.5(this));
    findViewById(2131822914).setOnClickListener(new WalletWXCreditChangeAmountUI.6(this));
    AppMethodBeat.o(48705);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(48708);
    if (paramView.getId() == 2131829421)
    {
      this.vIi = true;
      showDialog(2);
      AppMethodBeat.o(48708);
      return;
    }
    if (paramView.getId() == 2131829426)
    {
      this.vIi = false;
      showDialog(2);
    }
    AppMethodBeat.o(48708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48704);
    super.onCreate(paramBundle);
    initView();
    bJ();
    AppMethodBeat.o(48704);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48707);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof e))
      {
        this.vIc = ((e)paramm).vHB;
        this.vIg = ((e)paramm).vHC;
        if ((this.vIc != null) && (this.vIc.size() >= 2))
        {
          this.vIe = ((l)this.vIc.get(0));
          this.vIf = ((l)this.vIc.get(1));
          this.vIe.vHT = 1;
          this.vIf.vHT = 2;
        }
        bJ();
        AppMethodBeat.o(48707);
        return true;
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.wxcredit.a.c))
    {
      h.a(this, paramString, null, false, new WalletWXCreditChangeAmountUI.3(this));
      AppMethodBeat.o(48707);
      return true;
    }
    AppMethodBeat.o(48707);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI
 * JD-Core Version:    0.7.0.1
 */