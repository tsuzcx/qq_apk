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
import com.tencent.mm.plugin.wxcredit.a.c;
import com.tencent.mm.plugin.wxcredit.a.e;
import com.tencent.mm.plugin.wxcredit.a.l;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class WalletWXCreditChangeAmountUI
  extends WalletBaseUI
  implements View.OnClickListener
{
  private List<l> BKO;
  private List<l> BKP;
  private l BKQ;
  private l BKR;
  private int BKS;
  private boolean BKT;
  private boolean BKU;
  private TextView BKV;
  private TextView BKW;
  private TextView BKX;
  private TextView BKY;
  private TextView BKZ;
  private TextView BLa;
  private EditText BLb;
  private EditText BLc;
  private EditText BLd;
  private EditText BLe;
  private BaseAdapter BLf;
  private BaseAdapter BLg;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(72347);
    this.BKP = new ArrayList();
    this.BKS = -1;
    this.BLf = new BaseAdapter()
    {
      private l Uc(int paramAnonymousInt)
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
        paramAnonymousViewGroup = Uc(paramAnonymousInt);
        paramAnonymousView.setText(paramAnonymousViewGroup.desc);
        if (paramAnonymousViewGroup.BKF != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(72345);
          return paramAnonymousView;
        }
      }
    };
    this.BLg = new BaseAdapter()
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
          if ((WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).BKI == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).teH))) {
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
        if ((WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).BKI != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).teH)))
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
  
  private void cE()
  {
    AppMethodBeat.i(72350);
    if (this.BKQ != null)
    {
      this.BKV.setText(this.BKQ.desc);
      if (this.BKQ.BKI == null) {
        break label300;
      }
      this.BKZ.setVisibility(0);
      this.BLb.setVisibility(8);
      this.BKX.setText(this.BKQ.BKI.desc);
      this.BLc.setHint(this.BKQ.BKI.nvv);
      if (!"Y".equals(this.BKQ.teH)) {
        break label255;
      }
      this.BKX.setVisibility(0);
      this.BLc.setVisibility(0);
      this.BKZ.setText(2131755939);
    }
    while (this.BKR != null)
    {
      this.BKW.setText(this.BKR.desc);
      if (this.BKR.BKI != null)
      {
        this.BLa.setVisibility(0);
        this.BLd.setVisibility(8);
        this.BKY.setText(this.BKR.BKI.desc);
        this.BLe.setHint(this.BKR.BKI.nvv);
        if ("Y".equals(this.BKR.teH))
        {
          this.BKY.setVisibility(0);
          this.BLe.setVisibility(0);
          this.BLa.setText(2131755939);
          AppMethodBeat.o(72350);
          return;
          label255:
          this.BKX.setVisibility(8);
          this.BLc.setVisibility(8);
          if ("N".equals(this.BKQ.teH))
          {
            this.BKZ.setText(2131755831);
            continue;
            label300:
            this.BKZ.setVisibility(8);
            this.BLb.setVisibility(0);
            this.BLb.setHint(this.BKQ.nvv);
            this.BKX.setVisibility(8);
            this.BLc.setVisibility(8);
          }
        }
        else
        {
          this.BKY.setVisibility(8);
          this.BLe.setVisibility(8);
          if ("N".equals(this.BKR.teH))
          {
            this.BLa.setText(2131755831);
            AppMethodBeat.o(72350);
          }
        }
      }
      else
      {
        this.BLa.setVisibility(8);
        this.BLd.setVisibility(0);
        this.BLd.setHint(this.BKR.nvv);
        this.BKY.setVisibility(8);
        this.BLe.setVisibility(8);
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
    this.BKV = ((TextView)findViewById(2131306856));
    this.BKX = ((TextView)findViewById(2131306857));
    this.BKW = ((TextView)findViewById(2131306858));
    this.BKY = ((TextView)findViewById(2131306859));
    this.BLb = ((EditText)findViewById(2131306846));
    this.BLc = ((EditText)findViewById(2131306847));
    this.BLd = ((EditText)findViewById(2131306848));
    this.BLe = ((EditText)findViewById(2131306849));
    this.BKZ = ((TextView)findViewById(2131306850));
    this.BLa = ((TextView)findViewById(2131306851));
    this.BKZ.setOnClickListener(this);
    this.BLa.setOnClickListener(this);
    this.BKV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72332);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, true);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
        AppMethodBeat.o(72332);
      }
    });
    this.BKW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72336);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this, false);
        WalletWXCreditChangeAmountUI.a(WalletWXCreditChangeAmountUI.this);
        WalletWXCreditChangeAmountUI.this.showDialog(1);
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
        if (WalletWXCreditChangeAmountUI.b(WalletWXCreditChangeAmountUI.this))
        {
          if (WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).BKI != null)
          {
            if (WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).BKI.teH = WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).BKI == null) {
              break label231;
            }
            if (WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getVisibility() != 0) {}
          }
          label231:
          for (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).BKI.teH = WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getText().toString();; WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).teH = WalletWXCreditChangeAmountUI.h(WalletWXCreditChangeAmountUI.this).getText().toString())
          {
            paramAnonymousView = new ArrayList();
            paramAnonymousView.add(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this));
            paramAnonymousView.add(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this));
            String str = WalletWXCreditChangeAmountUI.this.getInput().getString("kreq_token");
            WalletWXCreditChangeAmountUI.this.getInput().getString("key_bank_type");
            paramAnonymousView = new c(paramAnonymousView, str);
            WalletWXCreditChangeAmountUI.this.doSceneForceProgress(paramAnonymousView);
            AppMethodBeat.o(72338);
            return;
            WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).teH = WalletWXCreditChangeAmountUI.e(WalletWXCreditChangeAmountUI.this).getText().toString();
            break;
          }
        }
        t.makeText(WalletWXCreditChangeAmountUI.this.getContext(), 2131766024, 0).show();
        AppMethodBeat.o(72338);
      }
    });
    AppMethodBeat.o(72349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(72352);
    if (paramView.getId() == 2131306850)
    {
      this.BKU = true;
      showDialog(2);
      AppMethodBeat.o(72352);
      return;
    }
    if (paramView.getId() == 2131306851)
    {
      this.BKU = false;
      showDialog(2);
    }
    AppMethodBeat.o(72352);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72348);
    super.onCreate(paramBundle);
    initView();
    cE();
    AppMethodBeat.o(72348);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72351);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof e))
      {
        this.BKO = ((e)paramn).BKn;
        this.BKS = ((e)paramn).BKo;
        if ((this.BKO != null) && (this.BKO.size() >= 2))
        {
          this.BKQ = ((l)this.BKO.get(0));
          this.BKR = ((l)this.BKO.get(1));
          this.BKQ.BKF = 1;
          this.BKR.BKF = 2;
        }
        cE();
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
          paramAnonymousDialogInterface = a.bo(WalletWXCreditChangeAmountUI.this);
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