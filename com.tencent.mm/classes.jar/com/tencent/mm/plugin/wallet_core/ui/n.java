package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.model.p.a;
import com.tencent.mm.plugin.wallet_core.model.p.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MaxListView;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class n
  extends com.tencent.mm.ui.base.i
{
  private d CJy;
  private MaxListView DfX;
  private TextView DfY;
  private a DfZ;
  private b Dga;
  private View iCR;
  private LayoutInflater mInflater;
  
  private n(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(70947);
    this.mInflater = LayoutInflater.from(paramContext);
    this.iCR = LayoutInflater.from(paramContext).inflate(2131495948, null);
    this.DfX = ((MaxListView)this.iCR.findViewById(2131306744));
    this.DfY = ((TextView)this.iCR.findViewById(2131306741));
    this.DfZ = new a();
    this.DfX.setAdapter(this.DfZ);
    this.iCR.findViewById(2131306742).setOnClickListener(new n.1(this));
    AppMethodBeat.o(70947);
  }
  
  public static n a(Context paramContext, Orders paramOrders, String paramString, b paramb, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(70950);
    n localn = new n(paramContext);
    localn.setOnCancelListener(paramOnCancelListener);
    localn.setCancelable(true);
    localn.setCanceledOnTouchOutside(false);
    localn.CJy = e.Dcd.a(paramOrders);
    if (localn.CJy == null)
    {
      ad.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
      localn.dismiss();
    }
    Object localObject2;
    int i;
    for (;;)
    {
      localn.Dga = paramb;
      localn.show();
      com.tencent.mm.ui.base.h.a(paramContext, localn);
      AppMethodBeat.o(70950);
      return localn;
      paramOrders = localn.DfZ;
      localObject2 = paramOrders.Dgb.CJy.DbY;
      paramOnCancelListener = paramOrders.Dgb.CJy.aES(paramString);
      paramOrders.Dgd = paramOrders.Dgb.CJy.eHm();
      paramOrders.Dge = paramOrders.Dgb.CJy.aEO(paramOnCancelListener);
      paramOrders.Dgc = -1;
      i = 0;
      for (;;)
      {
        if (i < paramOrders.Dgd.size()) {
          if (((t)paramOrders.Dgd.get(i)).CHW == 0) {
            break label273;
          }
        }
        label273:
        for (j = 1; j != 0; j = 0)
        {
          paramOrders.Dgc = i;
          paramString = new LinkedList();
          if (paramOrders.Dgd == null) {
            break label288;
          }
          i = 0;
          while (i < paramOrders.Dgd.size())
          {
            paramString.add(((t)paramOrders.Dgd.get(i)).CGT);
            i += 1;
          }
        }
        i += 1;
      }
      label288:
      ad.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
      i = 0;
      label298:
      if (i != 0) {
        break label670;
      }
      ad.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
      localn.dismiss();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).CHa != null))
    {
      i = 0;
      while (i < ((com.tencent.mm.plugin.wallet.a.h)localObject2).CHa.size())
      {
        localObject1 = ((t)((com.tencent.mm.plugin.wallet.a.h)localObject2).CHa.get(i)).CGT;
        if (!paramString.contains(localObject1)) {
          localLinkedList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject1 = new LinkedList();
    label450:
    String str;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).CHb != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).CHb.CHn != null))
    {
      localObject2 = ((com.tencent.mm.plugin.wallet.a.h)localObject2).CHb.CHn;
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label563;
      }
      str = ((j)((List)localObject2).get(i)).CHp;
      j = 0;
      label482:
      if (j >= localLinkedList.size()) {
        break label701;
      }
      if (!str.contains((CharSequence)localLinkedList.get(j))) {}
    }
    label563:
    label701:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((List)localObject1).add(str);
      }
      i += 1;
      break label450;
      j += 1;
      break label482;
      ad.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
      i = 0;
      break label298;
      localLinkedList = new LinkedList();
      if ((!bt.isNullOrNil(paramOnCancelListener)) && (!paramOnCancelListener.equals("0")))
      {
        paramOnCancelListener = paramOnCancelListener.split("-");
        if (paramOnCancelListener != null)
        {
          i = 0;
          while (i < paramOnCancelListener.length)
          {
            localLinkedList.add(paramOnCancelListener[i]);
            i += 1;
          }
        }
        ad.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
        i = 0;
        break label298;
      }
      paramOrders.Dgf.e(paramString, localLinkedList, (List)localObject1);
      i = 1;
      break label298;
      localn.DfY.setText(2131765257);
      localn.DfX.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(70941);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousAdapterView);
          ((b)localObject).bd(paramAnonymousView);
          ((b)localObject).mr(paramAnonymousInt);
          ((b)localObject).qY(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahq());
          paramAnonymousAdapterView = n.b(n.this);
          paramAnonymousView = paramAnonymousAdapterView.Dgf;
          if (paramAnonymousInt < paramAnonymousView.CXn.size())
          {
            localObject = ((p.b)paramAnonymousView.CXn.get(paramAnonymousInt)).CXv;
            p.a locala = p.a.CXr;
            int i = 0;
            while (i < paramAnonymousView.CXn.size())
            {
              paramAnonymousView.a(i, p.a.CXs);
              i += 1;
            }
            switch (com.tencent.mm.plugin.wallet_core.model.p.1.CXp[localObject.ordinal()])
            {
            }
          }
          for (;;)
          {
            paramAnonymousAdapterView.notifyDataSetChanged();
            a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(70941);
            return;
            paramAnonymousView.a(paramAnonymousInt, p.a.CXr);
            continue;
            paramAnonymousView.a(paramAnonymousInt, p.a.CXs);
          }
        }
      });
      break;
    }
  }
  
  private void eHE()
  {
    AppMethodBeat.i(70952);
    ad.d("MicroMsg.WalletFavorDialog", "On selection done");
    if (this.DfZ != null)
    {
      Object localObject = this.DfZ.Dgf;
      localObject = ((p)localObject).a(((p)localObject).CXn, -1);
      localObject = this.CJy.aER((String)localObject);
      this.Dga.a((FavorPayInfo)localObject);
    }
    AppMethodBeat.o(70952);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(70949);
    try
    {
      super.dismiss();
      AppMethodBeat.o(70949);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(70949);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70948);
    super.onCreate(paramBundle);
    setContentView(this.iCR);
    AppMethodBeat.o(70948);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70953);
    if (paramInt == 4) {
      eHE();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(70953);
    return bool;
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(70951);
    super.setCancelable(paramBoolean);
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(70951);
  }
  
  final class a
    extends BaseAdapter
  {
    int Dgc;
    List<t> Dgd;
    j Dge;
    p<String> Dgf;
    
    public a()
    {
      AppMethodBeat.i(70943);
      this.Dgc = -1;
      this.Dgd = new LinkedList();
      this.Dge = null;
      this.Dgf = new p()
      {
        public final String a(Vector<p<String>.b> paramAnonymousVector, int paramAnonymousInt)
        {
          AppMethodBeat.i(70942);
          if (paramAnonymousVector == null)
          {
            ad.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
            AppMethodBeat.o(70942);
            return "";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          int i = 0;
          while (i < paramAnonymousVector.size())
          {
            p.a locala = ((p.b)paramAnonymousVector.get(i)).CXv;
            if ((i == paramAnonymousInt) || (locala == p.a.CXr)) {
              localStringBuilder.append((String)((p.b)paramAnonymousVector.get(i)).CXu + "-");
            }
            i += 1;
          }
          if (localStringBuilder.length() == 0)
          {
            AppMethodBeat.o(70942);
            return "0";
          }
          if (localStringBuilder.length() > 1) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          }
          paramAnonymousVector = localStringBuilder.toString();
          AppMethodBeat.o(70942);
          return paramAnonymousVector;
        }
      };
      AppMethodBeat.o(70943);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70944);
      int i = this.Dgd.size();
      AppMethodBeat.o(70944);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70945);
      Object localObject = this.Dgd.get(paramInt);
      AppMethodBeat.o(70945);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(70946);
      Object localObject3;
      label154:
      label185:
      Object localObject1;
      Object localObject2;
      int i;
      if (paramView == null)
      {
        paramView = n.c(n.this).inflate(2131495939, paramViewGroup, false);
        paramViewGroup = new n.c();
        paramViewGroup.Dgh = paramView.findViewById(2131306726);
        paramViewGroup.lCL = ((TextView)paramView.findViewById(2131306725));
        paramViewGroup.oEG = ((TextView)paramView.findViewById(2131306724));
        paramViewGroup.lDu = ((TextView)paramView.findViewById(2131306723));
        paramViewGroup.Dgj = ((CheckBox)paramView.findViewById(2131306722));
        paramViewGroup.Dgi = ((ImageView)paramView.findViewById(2131306721));
        paramView.setTag(paramViewGroup);
        localObject3 = (t)getItem(paramInt);
        if ((paramInt != this.Dgc) || (this.Dgc <= 0)) {
          break label418;
        }
        paramViewGroup.Dgh.setVisibility(0);
        paramViewGroup.Dgi.setVisibility(8);
        if (bt.isNullOrNil(((t)localObject3).CHS)) {
          break label438;
        }
        paramViewGroup.lCL.setText(((t)localObject3).CHS);
        paramViewGroup.lCL.setVisibility(0);
        localObject1 = ((t)localObject3).CGT;
        if ((this.Dge == null) || (this.Dge.CHr == null)) {
          break label459;
        }
        localObject2 = this.Dge.CHr;
        i = 0;
        label221:
        if (i >= ((List)localObject2).size()) {
          break label459;
        }
        if (!((String)localObject1).equals(((f)((List)localObject2).get(i)).CGT)) {
          break label450;
        }
        localObject1 = (f)((List)localObject2).get(i);
        label270:
        localObject2 = ((t)localObject3).CGU;
        localObject3 = ((t)localObject3).CGV;
        if (localObject1 == null) {
          break label527;
        }
        localObject3 = ((f)localObject1).CGU;
        localObject2 = ((f)localObject1).CGV;
        localObject1 = localObject3;
      }
      for (;;)
      {
        if (!bt.isNullOrNil((String)localObject1))
        {
          paramViewGroup.oEG.setText((CharSequence)localObject1);
          paramViewGroup.oEG.setVisibility(0);
          label332:
          if (bt.isNullOrNil((String)localObject2)) {
            break label477;
          }
          paramViewGroup.lDu.setText((CharSequence)localObject2);
          paramViewGroup.lDu.setVisibility(0);
          label357:
          localObject1 = ((p.b)this.Dgf.CXn.get(paramInt)).CXv;
          if (localObject1 != p.a.CXq) {
            break label489;
          }
          paramViewGroup.Dgj.setChecked(false);
          paramViewGroup.Dgj.setEnabled(false);
        }
        for (;;)
        {
          AppMethodBeat.o(70946);
          return paramView;
          paramViewGroup = (n.c)paramView.getTag();
          break;
          label418:
          paramViewGroup.Dgh.setVisibility(8);
          paramViewGroup.Dgi.setVisibility(0);
          break label154;
          label438:
          paramViewGroup.lCL.setVisibility(8);
          break label185;
          label450:
          i += 1;
          break label221;
          label459:
          localObject1 = null;
          break label270;
          paramViewGroup.oEG.setVisibility(8);
          break label332;
          label477:
          paramViewGroup.lDu.setVisibility(8);
          break label357;
          label489:
          paramViewGroup.Dgj.setEnabled(true);
          if (localObject1 == p.a.CXr) {
            paramViewGroup.Dgj.setChecked(true);
          } else {
            paramViewGroup.Dgj.setChecked(false);
          }
        }
        label527:
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(FavorPayInfo paramFavorPayInfo);
  }
  
  static final class c
  {
    View Dgh;
    ImageView Dgi;
    CheckBox Dgj;
    TextView lCL;
    TextView lDu;
    TextView oEG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n
 * JD-Core Version:    0.7.0.1
 */