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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectPayeeUI
  extends BankRemitBaseUI
  implements n.d
{
  private l kxh;
  private ListView vwT;
  private b vwU;
  private List<TransferRecordParcel> vwV;
  private ArrayList<TransferRecordParcel> vwW;
  private ArrayList<String> vwX;
  private int vwY = -1;
  private int vwZ = -1;
  private Intent vxa;
  
  public int getLayoutId()
  {
    return 2131493165;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67603);
    this.vwT = ((ListView)findViewById(2131297571));
    this.kxh = new l(this);
    this.vwU = new b((byte)0);
    this.vwT.setAdapter(this.vwU);
    this.vwT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67584);
        ad.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousAdapterView = (TransferRecordParcel)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this).putExtra("key_bank_card_seqno", paramAnonymousAdapterView.vuN);
          BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this));
          BankRemitSelectPayeeUI.this.finish();
        }
        AppMethodBeat.o(67584);
      }
    });
    this.vwT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.vwV = new ArrayList();
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.vwY = 0;
      this.vwV.addAll(paramBundle);
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.vwZ = (this.vwV.size() + this.vwY + 1);
      this.vwV.addAll((Collection)localObject);
    }
    ad.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[] { Integer.valueOf(this.vwY), Integer.valueOf(this.vwZ) });
    paramBundle = this.vwV.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (TransferRecordParcel)paramBundle.next();
      ad.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[] { ((TransferRecordParcel)localObject).vuN, ((TransferRecordParcel)localObject).vuO, ((TransferRecordParcel)localObject).vur, ((TransferRecordParcel)localObject).szi, ((TransferRecordParcel)localObject).dca, ((TransferRecordParcel)localObject).vuP, ((TransferRecordParcel)localObject).vuQ });
    }
    this.vxa = new Intent();
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
    paramMenuItem = (TransferRecordParcel)this.vwT.getItemAtPosition(paramMenuItem.position);
    if (paramMenuItem == null)
    {
      ad.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
      AppMethodBeat.o(67605);
      return;
    }
    if (paramInt == 1)
    {
      a.a(this, getString(2131757453), paramMenuItem.vuQ, "", 32, new h.b()new DialogInterface.OnClickListener
      {
        public final boolean onFinish(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67587);
          if (((paramMenuItem.vuQ == null) && (paramAnonymousCharSequence == null)) || ((paramMenuItem.vuQ != null) && (paramMenuItem.vuQ.equals(paramAnonymousCharSequence))))
          {
            ad.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[] { paramMenuItem.vuQ, paramAnonymousCharSequence });
            AppMethodBeat.o(67587);
            return true;
          }
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramMenuItem.vuN, String.valueOf(paramAnonymousCharSequence));
          AppMethodBeat.o(67587);
          return true;
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67589);
          aq.n(new Runnable()
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
      paramMenuItem = paramMenuItem.vuN;
      ad.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
      doSceneProgress(new f(paramMenuItem), true);
      h.vKh.f(14673, new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(67605);
      return;
    }
    ad.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(67605);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(67607);
    if ((paramn instanceof j))
    {
      paramString = (j)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67592);
          ad.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
          BankRemitSelectPayeeUI.b(BankRemitSelectPayeeUI.this, paramString.vud, paramString.iaz);
          AppMethodBeat.o(67592);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67591);
          ad.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.vul.dcG), paramString.vul.nTK });
          if (!bt.isNullOrNil(paramString.vul.nTK)) {
            Toast.makeText(BankRemitSelectPayeeUI.this, paramString.vul.nTK, 1).show();
          }
          AppMethodBeat.o(67591);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67590);
          ad.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[] { paramAnonymousn });
          AppMethodBeat.o(67590);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(67607);
      return false;
      if ((paramn instanceof f))
      {
        paramString = (f)paramn;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67585);
            BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramString.vud);
            AppMethodBeat.o(67585);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67594);
            ad.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.vuh.dcG), paramString.vuh.nTK });
            if (!bt.isNullOrNil(paramString.vuh.nTK)) {
              Toast.makeText(BankRemitSelectPayeeUI.this, paramString.vuh.nTK, 1).show();
            }
            AppMethodBeat.o(67594);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67593);
            ad.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[] { paramAnonymousn });
            AppMethodBeat.o(67593);
          }
        });
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
    TextView vuL;
    CdnImageView vxg;
    TextView vxh;
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private boolean djA()
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
    
    private boolean djz()
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
    
    public final int getCount()
    {
      AppMethodBeat.i(67595);
      int j = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).size();
      int i = j;
      if (djz()) {
        i = j + 1;
      }
      j = i;
      if (djA()) {
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
      if ((djA()) && (paramInt > BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        if (djz())
        {
          localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 2);
          AppMethodBeat.o(67596);
          return localObject;
        }
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      if (djz())
      {
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      ad.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this)), Integer.valueOf(BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)) });
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
          ad.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(67599);
        return localView;
        localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(2131493164, paramViewGroup, false);
        paramView = new BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, (byte)0);
        paramView.vxg = ((CdnImageView)localView.findViewById(2131297567));
        paramView.vuL = ((TextView)localView.findViewById(2131297570));
        paramView.vxh = ((TextView)localView.findViewById(2131297568));
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
        ad.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[] { Integer.valueOf(paramInt) });
        continue;
        paramView = (BankRemitSelectPayeeUI.a)localView.getTag();
        paramViewGroup = (TransferRecordParcel)getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramView.vxg.fz(paramViewGroup.vur, 2131101053);
          if (!bt.isNullOrNil(paramViewGroup.vuQ))
          {
            SpannableString localSpannableString = k.c(paramView.vxb.getContext(), paramView.vxb.getContext().getString(2131756399, new Object[] { paramViewGroup.vuP, paramViewGroup.vuQ }));
            paramView.vuL.setText(localSpannableString);
          }
          for (;;)
          {
            paramView.vxh.setText(paramView.vxb.getString(2131756399, new Object[] { paramViewGroup.szi, paramViewGroup.vuO }));
            break;
            paramView.vuL.setText(paramViewGroup.vuP);
          }
        }
        paramView.vxg.setImageResource(2131101053);
        paramView.vuL.setText("");
        paramView.vxh.setText("");
        ad.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI
 * JD-Core Version:    0.7.0.1
 */