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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BankRemitSelectPayeeUI
  extends BankRemitBaseUI
  implements o.g
{
  private List<TransferRecordParcel> ClA;
  private ArrayList<TransferRecordParcel> ClB;
  private ArrayList<String> ClC;
  private int ClD = -1;
  private int ClE = -1;
  private Intent ClF;
  private ListView Cly;
  private b Clz;
  private com.tencent.mm.ui.tools.l mHj;
  
  public int getLayoutId()
  {
    return 2131493211;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67603);
    this.Cly = ((ListView)findViewById(2131297810));
    this.mHj = new com.tencent.mm.ui.tools.l(this);
    this.Clz = new b((byte)0);
    this.Cly.setAdapter(this.Clz);
    this.Cly.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(67584);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        Log.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousAdapterView = (TransferRecordParcel)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView != null)
        {
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this).putExtra("key_bank_card_seqno", paramAnonymousAdapterView.Cjt);
          BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this));
          BankRemitSelectPayeeUI.this.finish();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectPayeeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(67584);
      }
    });
    this.Cly.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.ClA = new ArrayList();
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      this.ClD = 0;
      this.ClA.addAll(paramBundle);
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.ClE = (this.ClA.size() + this.ClD + 1);
      this.ClA.addAll((Collection)localObject);
    }
    Log.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", new Object[] { Integer.valueOf(this.ClD), Integer.valueOf(this.ClE) });
    paramBundle = this.ClA.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (TransferRecordParcel)paramBundle.next();
      Log.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", new Object[] { ((TransferRecordParcel)localObject).Cjt, ((TransferRecordParcel)localObject).Cju, ((TransferRecordParcel)localObject).CiX, ((TransferRecordParcel)localObject).ynT, ((TransferRecordParcel)localObject).dDj, ((TransferRecordParcel)localObject).Cjv, ((TransferRecordParcel)localObject).Cjw });
    }
    this.ClF = new Intent();
    initView();
    setMMTitle(2131756538);
    addSceneEndListener(1590);
    addSceneEndListener(1395);
    AppMethodBeat.o(67602);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(67604);
    paramContextMenu.add(0, 1, 0, 2131756536);
    paramContextMenu.add(0, 0, 0, 2131756533);
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
    paramMenuItem = (TransferRecordParcel)this.Cly.getItemAtPosition(paramMenuItem.position);
    if (paramMenuItem == null)
    {
      Log.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
      AppMethodBeat.o(67605);
      return;
    }
    if (paramInt == 1)
    {
      com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, getString(2131757672), paramMenuItem.Cjw, "", 32, new h.b()new DialogInterface.OnClickListener
      {
        public final boolean onFinish(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(67587);
          if (((paramMenuItem.Cjw == null) && (paramAnonymousCharSequence == null)) || ((paramMenuItem.Cjw != null) && (paramMenuItem.Cjw.equals(paramAnonymousCharSequence))))
          {
            Log.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[] { paramMenuItem.Cjw, paramAnonymousCharSequence });
            AppMethodBeat.o(67587);
            return true;
          }
          BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramMenuItem.Cjt, String.valueOf(paramAnonymousCharSequence));
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
      paramMenuItem = paramMenuItem.Cjt;
      Log.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
      doSceneProgress(new f(paramMenuItem), true);
      h.CyF.a(14673, new Object[] { Integer.valueOf(7) });
      AppMethodBeat.o(67605);
      return;
    }
    Log.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(67605);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(67607);
    if ((paramq instanceof j))
    {
      paramString = (j)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67592);
          Log.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
          BankRemitSelectPayeeUI.b(BankRemitSelectPayeeUI.this, paramString.CiJ, paramString.remark);
          AppMethodBeat.o(67592);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67591);
          Log.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.CiR.dDN), paramString.CiR.qwn });
          if (!Util.isNullOrNil(paramString.CiR.qwn)) {
            Toast.makeText(BankRemitSelectPayeeUI.this, paramString.CiR.qwn, 1).show();
          }
          AppMethodBeat.o(67591);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67590);
          Log.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[] { paramAnonymousq });
          AppMethodBeat.o(67590);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(67607);
      return false;
      if ((paramq instanceof f))
      {
        paramString = (f)paramq;
        paramString.a(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67585);
            BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, paramString.CiJ);
            AppMethodBeat.o(67585);
          }
        }).b(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67594);
            Log.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", new Object[] { Integer.valueOf(paramString.CiN.dDN), paramString.CiN.qwn });
            if (!Util.isNullOrNil(paramString.CiN.qwn)) {
              Toast.makeText(BankRemitSelectPayeeUI.this, paramString.CiN.qwn, 1).show();
            }
            AppMethodBeat.o(67594);
          }
        }).c(new r.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(67593);
            Log.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[] { paramAnonymousq });
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
    TextView Cjr;
    CdnImageView ClL;
    TextView ClM;
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private boolean eNj()
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
    
    private boolean eNk()
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
      if (eNj()) {
        i = j + 1;
      }
      j = i;
      if (eNk()) {
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
      if ((eNk()) && (paramInt > BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this)))
      {
        if (eNj())
        {
          localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 2);
          AppMethodBeat.o(67596);
          return localObject;
        }
        localObject = BankRemitSelectPayeeUI.c(BankRemitSelectPayeeUI.this).get(paramInt - 1);
        AppMethodBeat.o(67596);
        return localObject;
      }
      if (eNj())
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
          localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(2131493209, paramViewGroup, false);
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
        localView = LayoutInflater.from(BankRemitSelectPayeeUI.this.getContext()).inflate(2131493210, paramViewGroup, false);
        paramView = new BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, (byte)0);
        paramView.ClL = ((CdnImageView)localView.findViewById(2131297806));
        paramView.Cjr = ((TextView)localView.findViewById(2131297809));
        paramView.ClM = ((TextView)localView.findViewById(2131297807));
        localView.setTag(paramView);
        break;
        paramView = (TextView)localView.findViewById(2131297805);
        if (BankRemitSelectPayeeUI.d(BankRemitSelectPayeeUI.this) == paramInt) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label223;
          }
          paramView.setText(2131756537);
          break;
        }
        label223:
        if (BankRemitSelectPayeeUI.e(BankRemitSelectPayeeUI.this) == paramInt) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label257;
          }
          paramView.setText(2131756535);
          break;
        }
        label257:
        paramView.setText("");
        Log.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[] { Integer.valueOf(paramInt) });
        continue;
        paramView = (BankRemitSelectPayeeUI.a)localView.getTag();
        paramViewGroup = (TransferRecordParcel)getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramView.ClL.gI(paramViewGroup.CiX, 2131101287);
          if (!Util.isNullOrNil(paramViewGroup.Cjw))
          {
            SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.l.c(paramView.ClG.getContext(), paramView.ClG.getContext().getString(2131756534, new Object[] { paramViewGroup.Cjv, paramViewGroup.Cjw }));
            paramView.Cjr.setText(localSpannableString);
          }
          for (;;)
          {
            paramView.ClM.setText(paramView.ClG.getString(2131756534, new Object[] { paramViewGroup.ynT, paramViewGroup.Cju }));
            break;
            paramView.Cjr.setText(paramViewGroup.Cjv);
          }
        }
        paramView.ClL.setImageResource(2131101287);
        paramView.Cjr.setText("");
        paramView.ClM.setText("");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI
 * JD-Core Version:    0.7.0.1
 */