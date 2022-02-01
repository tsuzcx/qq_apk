package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.b.f;
import com.tencent.mm.plugin.remittance.bankcard.b.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k.b;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.model.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectPayeeUI
  extends BankRemitBaseUI
  implements u.i
{
  private ListView Ofc;
  private b Ofd;
  private List<TransferRecordParcel> Ofe;
  private ArrayList<TransferRecordParcel> Off;
  private ArrayList<String> Ofg;
  private int Ofh = -1;
  private int Ofi = -1;
  private Intent Ofj;
  private l sLE;
  
  public int getLayoutId()
  {
    return a.g.bank_remit_select_payee_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67603);
    this.Ofc = ((ListView)findViewById(a.f.brsp_lv));
    this.sLE = new l(this);
    this.Ofd = new b((byte)0);
    this.Ofc.setAdapter(this.Ofd);
    this.Ofc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67584);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        Log.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousAdapterView = (TransferRecordParcel)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this).putExtra("key_bank_card_seqno", paramAnonymousAdapterView.OcL);
          BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this));
          BankRemitSelectPayeeUI.this.finish();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67584);
      }
    });
    this.Ofc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.Ofe = new ArrayList();
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.Ofh = 0;
      this.Ofe.addAll(paramBundle);
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.Ofi = (this.Ofe.size() + this.Ofh + 1);
      this.Ofe.addAll((Collection)localObject);
    }
    Log.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[] { Integer.valueOf(this.Ofh), Integer.valueOf(this.Ofi) });
    paramBundle = this.Ofe.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (TransferRecordParcel)paramBundle.next();
      Log.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[] { ((TransferRecordParcel)localObject).OcL, ((TransferRecordParcel)localObject).OcM, ((TransferRecordParcel)localObject).Ocp, ((TransferRecordParcel)localObject).JFk, ((TransferRecordParcel)localObject).hAk, ((TransferRecordParcel)localObject).OcN, ((TransferRecordParcel)localObject).OcO });
    }
    this.Ofj = new Intent();
    initView();
    setMMTitle(a.i.bank_remit_select_payee_title);
    addSceneEndListener(1590);
    addSceneEndListener(1395);
    AppMethodBeat.o(67602);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(67604);
    paramContextMenu.add(0, 1, 0, a.i.bank_remit_select_payee_remark_text);
    paramContextMenu.add(0, 0, 0, a.i.bank_remit_select_payee_delete_text);
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
    paramMenuItem = (TransferRecordParcel)this.Ofc.getItemAtPosition(paramMenuItem.position);
    if (paramMenuItem == null)
    {
      Log.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
      AppMethodBeat.o(67605);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, getString(a.i.collect_main_add_desc_title), paramMenuItem.OcO, "", 32, new k.b()new DialogInterface.OnClickListener
      {
        public final boolean onFinish(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67587);
          if (((paramMenuItem.OcO == null) && (paramAnonymousCharSequence == null)) || ((paramMenuItem.OcO != null) && (paramMenuItem.OcO.equals(paramAnonymousCharSequence))))
          {
            Log.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[] { paramMenuItem.OcO, paramAnonymousCharSequence });
            AppMethodBeat.o(67587);
            return true;
          }
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramMenuItem.OcL, String.valueOf(paramAnonymousCharSequence));
          AppMethodBeat.o(67587);
          return true;
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67589);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
      paramMenuItem = paramMenuItem.OcL;
      Log.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
      doSceneProgress(new f(paramMenuItem), true);
      h.OAn.b(14673, new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(67605);
      return;
    }
    Log.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(67605);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(67607);
    if ((paramp instanceof j))
    {
      paramString = (j)paramp;
      paramString.a(new BankRemitSelectPayeeUI.8(this, paramString)).b(new BankRemitSelectPayeeUI.7(this, paramString)).c(new BankRemitSelectPayeeUI.6(this));
    }
    for (;;)
    {
      AppMethodBeat.o(67607);
      return false;
      if ((paramp instanceof f))
      {
        paramString = (f)paramp;
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
    TextView OcJ;
    CdnImageView Ofp;
    TextView Ofq;
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private boolean gLJ()
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
    
    private boolean gLK()
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
      if (gLJ()) {
        i = j + 1;
      }
      j = i;
      if (gLK()) {
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
      if ((gLK()) && (paramInt > BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        if (gLJ())
        {
          localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 2);
          AppMethodBeat.o(67596);
          return localObject;
        }
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      if (gLJ())
      {
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      Log.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this)), Integer.valueOf(BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)) });
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
          localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(a.g.bank_remit_select_payee_header_item, paramViewGroup, false);
        }
      }
      else {
        switch (i)
        {
        default: 
          Log.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(67599);
        return localView;
        localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(a.g.bank_remit_select_payee_item, paramViewGroup, false);
        paramView = new BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, (byte)0);
        paramView.Ofp = ((CdnImageView)localView.findViewById(a.f.brsp_item_bank_icon_iv));
        paramView.OcJ = ((TextView)localView.findViewById(a.f.brsp_item_payee_name_tv));
        paramView.Ofq = ((TextView)localView.findViewById(a.f.brsp_item_bank_info_tv));
        localView.setTag(paramView);
        break;
        paramView = (TextView)localView.findViewById(a.f.brsp_header_tv);
        if (BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this) == paramInt) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label229;
          }
          paramView.setText(a.i.bank_remit_select_payee_self_title);
          break;
        }
        label229:
        if (BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this) == paramInt) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label264;
          }
          paramView.setText(a.i.bank_remit_select_payee_other_title);
          break;
        }
        label264:
        paramView.setText("");
        Log.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[] { Integer.valueOf(paramInt) });
        continue;
        paramView = (BankRemitSelectPayeeUI.a)localView.getTag();
        paramViewGroup = (TransferRecordParcel)getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramView.Ofp.iz(paramViewGroup.Ocp, a.c.transparent);
          if (!Util.isNullOrNil(paramViewGroup.OcO))
          {
            SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.b(paramView.Ofk.getContext(), paramView.Ofk.getContext().getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { paramViewGroup.OcN, paramViewGroup.OcO }));
            paramView.OcJ.setText(localSpannableString);
          }
          for (;;)
          {
            paramView.Ofq.setText(paramView.Ofk.getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { paramViewGroup.JFk, paramViewGroup.OcM }));
            break;
            paramView.OcJ.setText(paramViewGroup.OcN);
          }
        }
        paramView.Ofp.setImageResource(a.c.transparent);
        paramView.OcJ.setText("");
        paramView.Ofq.setText("");
        Log.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI
 * JD-Core Version:    0.7.0.1
 */