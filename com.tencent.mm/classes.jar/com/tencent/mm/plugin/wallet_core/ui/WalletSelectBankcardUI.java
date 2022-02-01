package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@a(19)
public class WalletSelectBankcardUI
  extends WalletBaseUI
{
  private TextView BIL;
  private MaxListView BIM;
  private a BIN = null;
  private String BIO = null;
  private boolean BIP = true;
  private String BIQ = null;
  private List<Bankcard> BIR = null;
  private int mScene = 0;
  private TextView ozm;
  
  public int getLayoutId()
  {
    return 2131496027;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71227);
    super.onCreate(paramBundle);
    setMMTitle(2131765035);
    this.mScene = getInput().getInt("key_scene", 0);
    this.BIO = getInput().getString("key_top_tips");
    this.BIP = getInput().getBoolean("key_is_show_new_bankcard", true);
    this.BIQ = getInput().getString("bottom_tips");
    this.BIR = getInput().getParcelableArrayList("key_showing_bankcards");
    if (this.BIR == null) {
      this.BIR = s.ery().esu();
    }
    this.BIL = ((TextView)findViewById(2131305947));
    this.BIM = ((MaxListView)findViewById(2131297167));
    this.ozm = ((TextView)findViewById(2131297475));
    if (!bs.isNullOrNil(this.BIO))
    {
      this.BIL.setVisibility(0);
      this.BIL.setText(this.BIO);
      if (bs.isNullOrNil(this.BIQ)) {
        break label342;
      }
      this.ozm.setVisibility(0);
      this.ozm.setText(this.BIQ);
    }
    for (;;)
    {
      if (this.mScene == 0)
      {
        this.ozm.setVisibility(0);
        paramBundle = new l(this);
        paramBundle.BFA = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71220);
            ac.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
            e.cn(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(2131765040));
            AppMethodBeat.o(71220);
          }
        };
        String str = getString(2131765843);
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(paramBundle, str.length() - 14, str.length(), 33);
        this.ozm.setText(localSpannableString);
        this.ozm.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.BIN = new a((byte)0);
      this.BIM.setAdapter(this.BIN);
      this.BIM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(71223);
          paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            com.tencent.mm.ui.base.h.a(WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(2131765845, new Object[] { paramAnonymousAdapterView.field_desc, paramAnonymousAdapterView.field_mobile }), WalletSelectBankcardUI.this.getString(2131765847), WalletSelectBankcardUI.this.getString(2131765844), WalletSelectBankcardUI.this.getString(2131765846), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(71221);
                WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, paramAnonymousAdapterView);
                com.tencent.mm.plugin.report.service.h.wUl.f(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
                AppMethodBeat.o(71221);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(71222);
                WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", true);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, paramAnonymousAdapterView);
                AppMethodBeat.o(71222);
              }
            });
            AppMethodBeat.o(71223);
            return;
          }
          WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
          WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, null);
          AppMethodBeat.o(71223);
        }
      });
      AppMethodBeat.o(71227);
      return;
      this.BIL.setVisibility(8);
      break;
      label342:
      this.ozm.setVisibility(8);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(71224);
      if (WalletSelectBankcardUI.a(WalletSelectBankcardUI.this))
      {
        if (WalletSelectBankcardUI.b(WalletSelectBankcardUI.this) == null)
        {
          AppMethodBeat.o(71224);
          return 1;
        }
        i = WalletSelectBankcardUI.b(WalletSelectBankcardUI.this).size();
        AppMethodBeat.o(71224);
        return i + 1;
      }
      if (WalletSelectBankcardUI.b(WalletSelectBankcardUI.this) == null)
      {
        AppMethodBeat.o(71224);
        return 0;
      }
      int i = WalletSelectBankcardUI.b(WalletSelectBankcardUI.this).size();
      AppMethodBeat.o(71224);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(71225);
      if ((WalletSelectBankcardUI.b(WalletSelectBankcardUI.this) == null) || (WalletSelectBankcardUI.b(WalletSelectBankcardUI.this).size() <= paramInt))
      {
        AppMethodBeat.o(71225);
        return null;
      }
      Object localObject = WalletSelectBankcardUI.b(WalletSelectBankcardUI.this).get(paramInt);
      AppMethodBeat.o(71225);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(71226);
      Bankcard localBankcard = (Bankcard)getItem(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(WalletSelectBankcardUI.this).inflate(2131496026, paramViewGroup, false);
        paramView = new a();
        paramView.BIV = ((TextView)localView.findViewById(2131297154));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        if (localBankcard == null) {
          break label105;
        }
        paramViewGroup.BIV.setText(localBankcard.field_desc);
      }
      for (;;)
      {
        AppMethodBeat.o(71226);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label105:
        paramViewGroup.BIV.setText(2131765849);
      }
    }
    
    final class a
    {
      TextView BIV;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI
 * JD-Core Version:    0.7.0.1
 */