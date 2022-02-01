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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private l kYv;
  private ListView wGY;
  private b wGZ;
  private List<TransferRecordParcel> wHa;
  private ArrayList<TransferRecordParcel> wHb;
  private ArrayList<String> wHc;
  private int wHd = -1;
  private int wHe = -1;
  private Intent wHf;
  
  public int getLayoutId()
  {
    return 2131493165;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67603);
    this.wGY = ((ListView)findViewById(2131297571));
    this.kYv = new l(this);
    this.wGZ = new b((byte)0);
    this.wGY.setAdapter(this.wGZ);
    this.wGY.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67584);
        ac.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousAdapterView = (TransferRecordParcel)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this).putExtra("key_bank_card_seqno", paramAnonymousAdapterView.wES);
          BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this));
          BankRemitSelectPayeeUI.this.finish();
        }
        AppMethodBeat.o(67584);
      }
    });
    this.wGY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.wHa = new ArrayList();
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.wHd = 0;
      this.wHa.addAll(paramBundle);
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.wHe = (this.wHa.size() + this.wHd + 1);
      this.wHa.addAll((Collection)localObject);
    }
    ac.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[] { Integer.valueOf(this.wHd), Integer.valueOf(this.wHe) });
    paramBundle = this.wHa.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (TransferRecordParcel)paramBundle.next();
      ac.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[] { ((TransferRecordParcel)localObject).wES, ((TransferRecordParcel)localObject).wET, ((TransferRecordParcel)localObject).wEw, ((TransferRecordParcel)localObject).tGS, ((TransferRecordParcel)localObject).cZz, ((TransferRecordParcel)localObject).wEU, ((TransferRecordParcel)localObject).wEV });
    }
    this.wHf = new Intent();
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
    paramMenuItem = (TransferRecordParcel)this.wGY.getItemAtPosition(paramMenuItem.position);
    if (paramMenuItem == null)
    {
      ac.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
      AppMethodBeat.o(67605);
      return;
    }
    if (paramInt == 1)
    {
      a.a(this, getString(2131757453), paramMenuItem.wEV, "", 32, new h.b()new DialogInterface.OnClickListener
      {
        public final boolean onFinish(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67587);
          if (((paramMenuItem.wEV == null) && (paramAnonymousCharSequence == null)) || ((paramMenuItem.wEV != null) && (paramMenuItem.wEV.equals(paramAnonymousCharSequence))))
          {
            ac.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[] { paramMenuItem.wEV, paramAnonymousCharSequence });
            AppMethodBeat.o(67587);
            return true;
          }
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramMenuItem.wES, String.valueOf(paramAnonymousCharSequence));
          AppMethodBeat.o(67587);
          return true;
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(67589);
          ap.n(new Runnable()
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
      paramMenuItem = paramMenuItem.wES;
      ac.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
      doSceneProgress(new f(paramMenuItem), true);
      h.wUl.f(14673, new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(67605);
      return;
    }
    ac.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[] { Integer.valueOf(paramInt) });
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
          ac.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
          BankRemitSelectPayeeUI.b(BankRemitSelectPayeeUI.this, paramString.wEi, paramString.iAC);
          AppMethodBeat.o(67592);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67591);
          ac.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.wEq.dae), paramString.wEq.oxf });
          if (!bs.isNullOrNil(paramString.wEq.oxf)) {
            Toast.makeText(BankRemitSelectPayeeUI.this, paramString.wEq.oxf, 1).show();
          }
          AppMethodBeat.o(67591);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(67590);
          ac.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[] { paramAnonymousn });
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
            BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramString.wEi);
            AppMethodBeat.o(67585);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67594);
            ac.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.wEm.dae), paramString.wEm.oxf });
            if (!bs.isNullOrNil(paramString.wEm.oxf)) {
              Toast.makeText(BankRemitSelectPayeeUI.this, paramString.wEm.oxf, 1).show();
            }
            AppMethodBeat.o(67594);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(67593);
            ac.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[] { paramAnonymousn });
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
    TextView wEQ;
    CdnImageView wHl;
    TextView wHm;
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private boolean dxA()
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
    
    private boolean dxB()
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
      if (dxA()) {
        i = j + 1;
      }
      j = i;
      if (dxB()) {
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
      if ((dxB()) && (paramInt > BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        if (dxA())
        {
          localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 2);
          AppMethodBeat.o(67596);
          return localObject;
        }
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      if (dxA())
      {
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      ac.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this)), Integer.valueOf(BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)) });
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
          ac.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        AppMethodBeat.o(67599);
        return localView;
        localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(2131493164, paramViewGroup, false);
        paramView = new BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, (byte)0);
        paramView.wHl = ((CdnImageView)localView.findViewById(2131297567));
        paramView.wEQ = ((TextView)localView.findViewById(2131297570));
        paramView.wHm = ((TextView)localView.findViewById(2131297568));
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
        ac.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[] { Integer.valueOf(paramInt) });
        continue;
        paramView = (BankRemitSelectPayeeUI.a)localView.getTag();
        paramViewGroup = (TransferRecordParcel)getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramView.wHl.fE(paramViewGroup.wEw, 2131101053);
          if (!bs.isNullOrNil(paramViewGroup.wEV))
          {
            SpannableString localSpannableString = k.c(paramView.wHg.getContext(), paramView.wHg.getContext().getString(2131756399, new Object[] { paramViewGroup.wEU, paramViewGroup.wEV }));
            paramView.wEQ.setText(localSpannableString);
          }
          for (;;)
          {
            paramView.wHm.setText(paramView.wHg.getString(2131756399, new Object[] { paramViewGroup.tGS, paramViewGroup.wET }));
            break;
            paramView.wEQ.setText(paramViewGroup.wEU);
          }
        }
        paramView.wHl.setImageResource(2131101053);
        paramView.wEQ.setText("");
        paramView.wHm.setText("");
        ac.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
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