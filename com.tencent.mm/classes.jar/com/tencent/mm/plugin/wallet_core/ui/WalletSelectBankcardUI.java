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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSelectBankcardUI
  extends WalletBaseUI
{
  private TextView IjT;
  private MaxListView IjU;
  private a IjV = null;
  private String IjW = null;
  private boolean IjX = true;
  private String IjY = null;
  private List<Bankcard> IjZ = null;
  private int mScene = 0;
  private TextView qyy;
  
  public int getLayoutId()
  {
    return 2131497007;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71227);
    super.onCreate(paramBundle);
    setMMTitle(2131767478);
    this.mScene = getInput().getInt("key_scene", 0);
    this.IjW = getInput().getString("key_top_tips");
    this.IjX = getInput().getBoolean("key_is_show_new_bankcard", true);
    this.IjY = getInput().getString("bottom_tips");
    this.IjZ = getInput().getParcelableArrayList("key_showing_bankcards");
    if (this.IjZ == null) {
      this.IjZ = t.fQI().fRE();
    }
    this.IjT = ((TextView)findViewById(2131309248));
    this.IjU = ((MaxListView)findViewById(2131297311));
    this.qyy = ((TextView)findViewById(2131297712));
    if (!Util.isNullOrNil(this.IjW))
    {
      this.IjT.setVisibility(0);
      this.IjT.setText(this.IjW);
      if (Util.isNullOrNil(this.IjY)) {
        break label342;
      }
      this.qyy.setVisibility(0);
      this.qyy.setText(this.IjY);
    }
    for (;;)
    {
      if (this.mScene == 0)
      {
        this.qyy.setVisibility(0);
        paramBundle = new l(this);
        paramBundle.IgH = new l.a()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71220);
            Log.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
            f.cM(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(2131767483));
            AppMethodBeat.o(71220);
          }
        };
        String str = getString(2131768296);
        SpannableString localSpannableString = new SpannableString(str);
        localSpannableString.setSpan(paramBundle, str.length() - 14, str.length(), 33);
        this.qyy.setText(localSpannableString);
        this.qyy.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.IjV = new a((byte)0);
      this.IjU.setAdapter(this.IjV);
      this.IjU.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(71223);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSelectBankcardUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = (Bankcard)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            com.tencent.mm.ui.base.h.a(WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(2131768298, new Object[] { paramAnonymousAdapterView.field_desc, paramAnonymousAdapterView.field_mobile }), WalletSelectBankcardUI.this.getString(2131768300), WalletSelectBankcardUI.this.getString(2131768297), WalletSelectBankcardUI.this.getString(2131768299), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(71221);
                WalletSelectBankcardUI.this.getInput().putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, paramAnonymousAdapterView);
                com.tencent.mm.plugin.report.service.h.CyF.a(11977, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
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
      this.IjT.setVisibility(8);
      break;
      label342:
      this.qyy.setVisibility(8);
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
        localView = LayoutInflater.from(WalletSelectBankcardUI.this).inflate(2131497006, paramViewGroup, false);
        paramView = new a();
        paramView.Ikd = ((TextView)localView.findViewById(2131297298));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        if (localBankcard == null) {
          break label105;
        }
        paramViewGroup.Ikd.setText(localBankcard.field_desc);
      }
      for (;;)
      {
        AppMethodBeat.o(71226);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label105:
        paramViewGroup.Ikd.setText(2131768302);
      }
    }
    
    final class a
    {
      TextView Ikd;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI
 * JD-Core Version:    0.7.0.1
 */