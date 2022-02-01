package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSelectBankcardUI
  extends WalletBaseUI
{
  private TextView VSQ;
  private MaxListView VSR;
  private a VSS = null;
  private String VST = null;
  private boolean VSU = true;
  private String VSV = null;
  private List<Bankcard> VSW = null;
  private int mScene = 0;
  private TextView xaR;
  
  public int getLayoutId()
  {
    return a.g.wallet_select_bankcard_ui;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71227);
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_bancard_list_dialog_title);
    this.mScene = getInput().getInt("key_scene", 0);
    this.VST = getInput().getString("key_top_tips");
    this.VSU = getInput().getBoolean("key_is_show_new_bankcard", true);
    this.VSV = getInput().getString("bottom_tips");
    this.VSW = getInput().getParcelableArrayList("key_showing_bankcards");
    if (this.VSW == null) {
      this.VSW = u.iiC().ijB();
    }
    this.VSQ = ((TextView)findViewById(a.f.title_tips_tv));
    this.VSR = ((MaxListView)findViewById(a.f.bankcard_lv));
    this.xaR = ((TextView)findViewById(a.f.bottom_tips_tv));
    if (!Util.isNullOrNil(this.VST))
    {
      this.VSQ.setVisibility(0);
      this.VSQ.setText(this.VST);
      if (Util.isNullOrNil(this.VSV)) {
        break label347;
      }
      this.xaR.setVisibility(0);
      this.xaR.setText(this.VSV);
    }
    for (;;)
    {
      if (this.mScene == 0)
      {
        this.xaR.setVisibility(0);
        paramBundle = new n(this);
        paramBundle.VPb = new n.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71220);
            Log.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
            i.dg(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(a.i.wallet_bankcard_detail_bankphone_number));
            AppMethodBeat.o(71220);
          }
        };
        String str = getString(a.i.wallet_select_bankcard_bcp_bottom_tips);
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(paramBundle, str.length() - 14, str.length(), 33);
        this.xaR.setText(localSpannableString);
        this.xaR.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.VSS = new a((byte)0);
      this.VSR.setAdapter(this.VSS);
      this.VSR.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(71223);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletSelectBankcardUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            k.a(WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(a.i.wallet_select_bankcard_bcp_confirm_num_msg, new Object[] { paramAnonymousAdapterView.field_desc, paramAnonymousAdapterView.field_mobile }), WalletSelectBankcardUI.this.getString(a.i.wallet_select_bankcard_bcp_confirm_num_title), WalletSelectBankcardUI.this.getString(a.i.wallet_select_bankcard_bcp_confirm_num_continue), WalletSelectBankcardUI.this.getString(a.i.wallet_select_bankcard_bcp_confirm_num_reset), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(71221);
                WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, paramAnonymousAdapterView);
                h.OAn.b(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
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
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSelectBankcardUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(71223);
            return;
            WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
            WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, null);
          }
        }
      });
      AppMethodBeat.o(71227);
      return;
      this.VSQ.setVisibility(8);
      break;
      label347:
      this.xaR.setVisibility(8);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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
        localView = LayoutInflater.from(WalletSelectBankcardUI.this).inflate(a.g.wallet_select_bankcard_lv_item, paramViewGroup, false);
        paramView = new a();
        paramView.VTa = ((TextView)localView.findViewById(a.f.bankcard_desc));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        if (localBankcard == null) {
          break label107;
        }
        paramViewGroup.VTa.setText(localBankcard.field_desc);
      }
      for (;;)
      {
        AppMethodBeat.o(71226);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label107:
        paramViewGroup.VTa.setText(a.i.wallet_select_bankcard_new_bankcard);
      }
    }
    
    final class a
    {
      TextView VTa;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI
 * JD-Core Version:    0.7.0.1
 */