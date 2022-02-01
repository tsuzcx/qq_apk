package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectPayeeUI
  extends BankRemitBaseUI
  implements n.e
{
  private l lzV;
  private List<TransferRecordParcel> ykA;
  private ArrayList<TransferRecordParcel> ykB;
  private ArrayList<String> ykC;
  private int ykD = -1;
  private int ykE = -1;
  private Intent ykF;
  private ListView yky;
  private b ykz;
  
  public int getLayoutId()
  {
    return 2131493165;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67603);
    this.yky = ((ListView)findViewById(2131297571));
    this.lzV = new l(this);
    this.ykz = new b((byte)0);
    this.yky.setAdapter(this.ykz);
    this.yky.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67584);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        ae.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousAdapterView = (TransferRecordParcel)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this).putExtra("key_bank_card_seqno", paramAnonymousAdapterView.yis);
          BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this));
          BankRemitSelectPayeeUI.this.finish();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67584);
      }
    });
    this.yky.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67586);
        BankRemitSelectPayeeUI.b(BankRemitSelectPayeeUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BankRemitSelectPayeeUI.this, BankRemitSelectPayeeUI.this);
        AppMethodBeat.o(67586);
        return true;
      }
    });
    AppMethodBeat.o(67603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67602);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getParcelableArrayListExtra("key_self_transfer_record_list");
    Object localObject = getIntent().getParcelableArrayListExtra("key_freq_transfer_record_list");
    this.ykA = new ArrayList();
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.ykD = 0;
      this.ykA.addAll(paramBundle);
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.ykE = (this.ykA.size() + this.ykD + 1);
      this.ykA.addAll((Collection)localObject);
    }
    ae.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[] { Integer.valueOf(this.ykD), Integer.valueOf(this.ykE) });
    paramBundle = this.ykA.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (TransferRecordParcel)paramBundle.next();
      ae.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[] { ((TransferRecordParcel)localObject).yis, ((TransferRecordParcel)localObject).yit, ((TransferRecordParcel)localObject).yhW, ((TransferRecordParcel)localObject).uVs, ((TransferRecordParcel)localObject).dlT, ((TransferRecordParcel)localObject).yiu, ((TransferRecordParcel)localObject).yiv });
    }
    this.ykF = new Intent();
    initView();
    setMMTitle(2131756403);
    addSceneEndListener(1590);
    addSceneEndListener(1395);
    AppMethodBeat.o(67602);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(67604);
    paramContextMenu.add(0, 1, 0, 2131756401);
    paramContextMenu.add(0, 0, 0, 2131756398);
    AppMethodBeat.o(67604);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67606);
    super.onDestroy();
    removeSceneEndListener(1590);
    removeSceneEndListener(1395);
    AppMethodBeat.o(67606);
  }
  
  public void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(67605);
    paramInt = paramMenuItem.getItemId();
    paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    paramMenuItem = (TransferRecordParcel)this.yky.getItemAtPosition(paramMenuItem.position);
    if (paramMenuItem == null)
    {
      ae.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
      AppMethodBeat.o(67605);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, getString(2131757453), paramMenuItem.yiv, "", 32, new h.b()new DialogInterface.OnClickListener
      {
        public final boolean onFinish(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67587);
          if (((paramMenuItem.yiv == null) && (paramAnonymousCharSequence == null)) || ((paramMenuItem.yiv != null) && (paramMenuItem.yiv.equals(paramAnonymousCharSequence))))
          {
            ae.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[] { paramMenuItem.yiv, paramAnonymousCharSequence });
            AppMethodBeat.o(67587);
            return true;
          }
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramMenuItem.yis, String.valueOf(paramAnonymousCharSequence));
          AppMethodBeat.o(67587);
          return true;
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67589);
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67588);
              BankRemitSelectPayeeUI.this.hideVKB();
              AppMethodBeat.o(67588);
            }
          }, 500L);
          AppMethodBeat.o(67589);
        }
      });
      AppMethodBeat.o(67605);
      return;
    }
    if (paramInt == 0)
    {
      paramMenuItem = paramMenuItem.yis;
      ae.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
      doSceneProgress(new f(paramMenuItem), true);
      g.yxI.f(14673, new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(67605);
      return;
    }
    ae.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(67605);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67607);
    if ((paramn instanceof j))
    {
      paramString = (j)paramn;
      paramString.a(new BankRemitSelectPayeeUI.8(this, paramString)).b(new BankRemitSelectPayeeUI.7(this, paramString)).c(new BankRemitSelectPayeeUI.6(this));
    }
    for (;;)
    {
      AppMethodBeat.o(67607);
      return false;
      if ((paramn instanceof f))
      {
        paramString = (f)paramn;
        paramString.a(new BankRemitSelectPayeeUI.2(this, paramString)).b(new BankRemitSelectPayeeUI.10(this, paramString)).c(new BankRemitSelectPayeeUI.9(this));
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    TextView yiq;
    CdnImageView ykL;
    TextView ykM;
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private boolean dMj()
    {
      AppMethodBeat.i(67600);
      if (BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this) >= 0)
      {
        AppMethodBeat.o(67600);
        return true;
      }
      AppMethodBeat.o(67600);
      return false;
    }
    
    private boolean dMk()
    {
      AppMethodBeat.i(67601);
      if (BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this) >= 0)
      {
        AppMethodBeat.o(67601);
        return true;
      }
      AppMethodBeat.o(67601);
      return false;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(67595);
      int j = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).size();
      int i = j;
      if (dMj()) {
        i = j + 1;
      }
      j = i;
      if (dMk()) {
        j = i + 1;
      }
      AppMethodBeat.o(67595);
      return j;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(67596);
      if ((paramInt == BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this)) || (paramInt == BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        AppMethodBeat.o(67596);
        return null;
      }
      Object localObject;
      if (paramInt < BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this))
      {
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      if ((dMk()) && (paramInt > BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        if (dMj())
        {
          localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 2);
          AppMethodBeat.o(67596);
          return localObject;
        }
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      if (dMj())
      {
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      ae.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this)), Integer.valueOf(BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)) });
      AppMethodBeat.o(67596);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67598);
      if ((paramInt == BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this)) || (paramInt == BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        AppMethodBeat.o(67598);
        return 0;
      }
      AppMethodBeat.o(67598);
      return 1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(67599);
      int i = getItemViewType(paramInt);
      View localView = paramView;
      if (paramView == null)
      {
        if (i == 0) {
          localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(2131493163, paramViewGroup, false);
        }
      }
      else {
        switch (i)
        {
        default: 
          ae.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(67599);
        return localView;
        localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(2131493164, paramViewGroup, false);
        paramView = new BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, (byte)0);
        paramView.ykL = ((CdnImageView)localView.findViewById(2131297567));
        paramView.yiq = ((TextView)localView.findViewById(2131297570));
        paramView.ykM = ((TextView)localView.findViewById(2131297568));
        localView.setTag(paramView);
        break;
        paramView = (TextView)localView.findViewById(2131297566);
        if (BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this) == paramInt) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label223;
          }
          paramView.setText(2131756402);
          break;
        }
        label223:
        if (BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this) == paramInt) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label257;
          }
          paramView.setText(2131756400);
          break;
        }
        label257:
        paramView.setText("");
        ae.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[] { Integer.valueOf(paramInt) });
        continue;
        paramView = (BankRemitSelectPayeeUI.a)localView.getTag();
        paramViewGroup = (TransferRecordParcel)getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramView.ykL.gk(paramViewGroup.yhW, 2131101053);
          if (!bu.isNullOrNil(paramViewGroup.yiv))
          {
            SpannableString localSpannableString = k.c(paramView.ykG.getContext(), paramView.ykG.getContext().getString(2131756399, new Object[] { paramViewGroup.yiu, paramViewGroup.yiv }));
            paramView.yiq.setText(localSpannableString);
          }
          for (;;)
          {
            paramView.ykM.setText(paramView.ykG.getString(2131756399, new Object[] { paramViewGroup.uVs, paramViewGroup.yit }));
            break;
            paramView.yiq.setText(paramViewGroup.yiu);
          }
        }
        paramView.ykL.setImageResource(2131101053);
        paramView.yiq.setText("");
        paramView.ykM.setText("");
        ae.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(67597);
      if ((paramInt == BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this)) || (paramInt == BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        AppMethodBeat.o(67597);
        return false;
      }
      AppMethodBeat.o(67597);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI
 * JD-Core Version:    0.7.0.1
 */