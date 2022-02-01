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
import com.tencent.mm.ak.n;
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
  private List<l> DcW;
  private List<l> DcX;
  private l DcY;
  private l DcZ;
  private int Dda;
  private boolean Ddb;
  private boolean Ddc;
  private TextView Ddd;
  private TextView Dde;
  private TextView Ddf;
  private TextView Ddg;
  private TextView Ddh;
  private TextView Ddi;
  private EditText Ddj;
  private EditText Ddk;
  private EditText Ddl;
  private EditText Ddm;
  private BaseAdapter Ddn;
  private BaseAdapter Ddo;
  
  public WalletWXCreditChangeAmountUI()
  {
    AppMethodBeat.i(72347);
    this.DcX = new ArrayList();
    this.Dda = -1;
    this.Ddn = new BaseAdapter()
    {
      private l Wk(int paramAnonymousInt)
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
        paramAnonymousViewGroup = Wk(paramAnonymousInt);
        paramAnonymousView.setText(paramAnonymousViewGroup.desc);
        if (paramAnonymousViewGroup.DcN != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          AppMethodBeat.o(72345);
          return paramAnonymousView;
        }
      }
    };
    this.Ddo = new BaseAdapter()
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
          if ((WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).DcQ == null) || (!"Y".equals(WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).umW))) {
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
        if ((WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).DcQ != null) && ("Y".equals(WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).umW)))
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
  
  private void cL()
  {
    AppMethodBeat.i(72350);
    if (this.DcY != null)
    {
      this.Ddd.setText(this.DcY.desc);
      if (this.DcY.DcQ == null) {
        break label300;
      }
      this.Ddh.setVisibility(0);
      this.Ddj.setVisibility(8);
      this.Ddf.setText(this.DcY.DcQ.desc);
      this.Ddk.setHint(this.DcY.DcQ.nYv);
      if (!"Y".equals(this.DcY.umW)) {
        break label255;
      }
      this.Ddf.setVisibility(0);
      this.Ddk.setVisibility(0);
      this.Ddh.setText(2131755939);
    }
    while (this.DcZ != null)
    {
      this.Dde.setText(this.DcZ.desc);
      if (this.DcZ.DcQ != null)
      {
        this.Ddi.setVisibility(0);
        this.Ddl.setVisibility(8);
        this.Ddg.setText(this.DcZ.DcQ.desc);
        this.Ddm.setHint(this.DcZ.DcQ.nYv);
        if ("Y".equals(this.DcZ.umW))
        {
          this.Ddg.setVisibility(0);
          this.Ddm.setVisibility(0);
          this.Ddi.setText(2131755939);
          AppMethodBeat.o(72350);
          return;
          label255:
          this.Ddf.setVisibility(8);
          this.Ddk.setVisibility(8);
          if ("N".equals(this.DcY.umW))
          {
            this.Ddh.setText(2131755831);
            continue;
            label300:
            this.Ddh.setVisibility(8);
            this.Ddj.setVisibility(0);
            this.Ddj.setHint(this.DcY.nYv);
            this.Ddf.setVisibility(8);
            this.Ddk.setVisibility(8);
          }
        }
        else
        {
          this.Ddg.setVisibility(8);
          this.Ddm.setVisibility(8);
          if ("N".equals(this.DcZ.umW))
          {
            this.Ddi.setText(2131755831);
            AppMethodBeat.o(72350);
          }
        }
      }
      else
      {
        this.Ddi.setVisibility(8);
        this.Ddl.setVisibility(0);
        this.Ddl.setHint(this.DcZ.nYv);
        this.Ddg.setVisibility(8);
        this.Ddm.setVisibility(8);
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
    this.Ddd = ((TextView)findViewById(2131306856));
    this.Ddf = ((TextView)findViewById(2131306857));
    this.Dde = ((TextView)findViewById(2131306858));
    this.Ddg = ((TextView)findViewById(2131306859));
    this.Ddj = ((EditText)findViewById(2131306846));
    this.Ddk = ((EditText)findViewById(2131306847));
    this.Ddl = ((EditText)findViewById(2131306848));
    this.Ddm = ((EditText)findViewById(2131306849));
    this.Ddh = ((TextView)findViewById(2131306850));
    this.Ddi = ((TextView)findViewById(2131306851));
    this.Ddh.setOnClickListener(this);
    this.Ddi.setOnClickListener(this);
    this.Ddd.setOnClickListener(new View.OnClickListener()
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
    this.Dde.setOnClickListener(new View.OnClickListener()
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
          if (WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).DcQ != null)
          {
            if (WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getVisibility() == 0) {
              WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).DcQ.umW = WalletWXCreditChangeAmountUI.d(WalletWXCreditChangeAmountUI.this).getText().toString();
            }
            if (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).DcQ == null) {
              break label231;
            }
            if (WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getVisibility() != 0) {}
          }
          label231:
          for (WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).DcQ.umW = WalletWXCreditChangeAmountUI.g(WalletWXCreditChangeAmountUI.this).getText().toString();; WalletWXCreditChangeAmountUI.f(WalletWXCreditChangeAmountUI.this).umW = WalletWXCreditChangeAmountUI.h(WalletWXCreditChangeAmountUI.this).getText().toString())
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
            WalletWXCreditChangeAmountUI.c(WalletWXCreditChangeAmountUI.this).umW = WalletWXCreditChangeAmountUI.e(WalletWXCreditChangeAmountUI.this).getText().toString();
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
      this.Ddc = true;
      showDialog(2);
      AppMethodBeat.o(72352);
      return;
    }
    if (paramView.getId() == 2131306851)
    {
      this.Ddc = false;
      showDialog(2);
    }
    AppMethodBeat.o(72352);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72348);
    super.onCreate(paramBundle);
    initView();
    cL();
    AppMethodBeat.o(72348);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72351);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof e))
      {
        this.DcW = ((e)paramn).Dcv;
        this.Dda = ((e)paramn).Dcw;
        if ((this.DcW != null) && (this.DcW.size() >= 2))
        {
          this.DcY = ((l)this.DcW.get(0));
          this.DcZ = ((l)this.DcW.get(1));
          this.DcY.DcN = 1;
          this.DcZ.DcN = 2;
        }
        cL();
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
          paramAnonymousDialogInterface = a.br(WalletWXCreditChangeAmountUI.this);
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