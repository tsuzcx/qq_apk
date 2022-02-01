package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MaxListView;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class n
  extends com.tencent.mm.ui.base.i
{
  private d Dbe;
  private MaxListView DxB;
  private TextView DxC;
  private a DxD;
  private b DxE;
  private View iFK;
  private LayoutInflater mInflater;
  
  private n(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(70947);
    this.mInflater = LayoutInflater.from(paramContext);
    this.iFK = LayoutInflater.from(paramContext).inflate(2131495948, null);
    this.DxB = ((MaxListView)this.iFK.findViewById(2131306744));
    this.DxC = ((TextView)this.iFK.findViewById(2131306741));
    this.DxD = new a();
    this.DxB.setAdapter(this.DxD);
    this.iFK.findViewById(2131306742).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70940);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        n.a(n.this);
        n.this.dismiss();
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70940);
      }
    });
    AppMethodBeat.o(70947);
  }
  
  public static n a(Context paramContext, Orders paramOrders, String paramString, b paramb, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(70950);
    n localn = new n(paramContext);
    localn.setOnCancelListener(paramOnCancelListener);
    localn.setCancelable(true);
    localn.setCanceledOnTouchOutside(false);
    localn.Dbe = e.DtH.a(paramOrders);
    if (localn.Dbe == null)
    {
      ae.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
      localn.dismiss();
    }
    Object localObject2;
    int i;
    for (;;)
    {
      localn.DxE = paramb;
      localn.show();
      com.tencent.mm.ui.base.h.a(paramContext, localn);
      AppMethodBeat.o(70950);
      return localn;
      paramOrders = localn.DxD;
      localObject2 = paramOrders.DxF.Dbe.DtC;
      paramOnCancelListener = paramOrders.DxF.Dbe.aGm(paramString);
      paramOrders.DxH = paramOrders.DxF.Dbe.eKU();
      paramOrders.DxI = paramOrders.DxF.Dbe.aGi(paramOnCancelListener);
      paramOrders.DxG = -1;
      i = 0;
      for (;;)
      {
        if (i < paramOrders.DxH.size()) {
          if (((t)paramOrders.DxH.get(i)).CZC == 0) {
            break label273;
          }
        }
        label273:
        for (j = 1; j != 0; j = 0)
        {
          paramOrders.DxG = i;
          paramString = new LinkedList();
          if (paramOrders.DxH == null) {
            break label288;
          }
          i = 0;
          while (i < paramOrders.DxH.size())
          {
            paramString.add(((t)paramOrders.DxH.get(i)).CYz);
            i += 1;
          }
        }
        i += 1;
      }
      label288:
      ae.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
      i = 0;
      label298:
      if (i != 0) {
        break label670;
      }
      ae.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
      localn.dismiss();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).CYG != null))
    {
      i = 0;
      while (i < ((com.tencent.mm.plugin.wallet.a.h)localObject2).CYG.size())
      {
        localObject1 = ((t)((com.tencent.mm.plugin.wallet.a.h)localObject2).CYG.get(i)).CYz;
        if (!paramString.contains(localObject1)) {
          localLinkedList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject1 = new LinkedList();
    label450:
    String str;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).CYH != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).CYH.CYT != null))
    {
      localObject2 = ((com.tencent.mm.plugin.wallet.a.h)localObject2).CYH.CYT;
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label563;
      }
      str = ((j)((List)localObject2).get(i)).CYV;
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
      ae.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
      i = 0;
      break label298;
      localLinkedList = new LinkedList();
      if ((!bu.isNullOrNil(paramOnCancelListener)) && (!paramOnCancelListener.equals("0")))
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
        ae.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
        i = 0;
        break label298;
      }
      paramOrders.DxJ.e(paramString, localLinkedList, (List)localObject1);
      i = 1;
      break label298;
      localn.DxC.setText(2131765257);
      localn.DxB.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(70941);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousAdapterView);
          ((b)localObject).bd(paramAnonymousView);
          ((b)localObject).mu(paramAnonymousInt);
          ((b)localObject).rl(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
          paramAnonymousAdapterView = n.b(n.this);
          paramAnonymousView = paramAnonymousAdapterView.DxJ;
          if (paramAnonymousInt < paramAnonymousView.DoS.size())
          {
            localObject = ((p.b)paramAnonymousView.DoS.get(paramAnonymousInt)).Dpa;
            p.a locala = p.a.DoW;
            int i = 0;
            while (i < paramAnonymousView.DoS.size())
            {
              paramAnonymousView.a(i, p.a.DoX);
              i += 1;
            }
            switch (com.tencent.mm.plugin.wallet_core.model.p.1.DoU[localObject.ordinal()])
            {
            }
          }
          for (;;)
          {
            paramAnonymousAdapterView.notifyDataSetChanged();
            a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(70941);
            return;
            paramAnonymousView.a(paramAnonymousInt, p.a.DoW);
            continue;
            paramAnonymousView.a(paramAnonymousInt, p.a.DoX);
          }
        }
      });
      break;
    }
  }
  
  private void eLm()
  {
    AppMethodBeat.i(70952);
    ae.d("MicroMsg.WalletFavorDialog", "On selection done");
    if (this.DxD != null)
    {
      Object localObject = this.DxD.DxJ;
      localObject = ((p)localObject).a(((p)localObject).DoS, -1);
      localObject = this.Dbe.aGl((String)localObject);
      this.DxE.a((FavorPayInfo)localObject);
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
      ae.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(70949);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70948);
    super.onCreate(paramBundle);
    setContentView(this.iFK);
    AppMethodBeat.o(70948);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70953);
    if (paramInt == 4) {
      eLm();
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
    int DxG;
    List<t> DxH;
    j DxI;
    p<String> DxJ;
    
    public a()
    {
      AppMethodBeat.i(70943);
      this.DxG = -1;
      this.DxH = new LinkedList();
      this.DxI = null;
      this.DxJ = new p()
      {
        public final String a(Vector<p<String>.b> paramAnonymousVector, int paramAnonymousInt)
        {
          AppMethodBeat.i(70942);
          if (paramAnonymousVector == null)
          {
            ae.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
            AppMethodBeat.o(70942);
            return "";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          int i = 0;
          while (i < paramAnonymousVector.size())
          {
            p.a locala = ((p.b)paramAnonymousVector.get(i)).Dpa;
            if ((i == paramAnonymousInt) || (locala == p.a.DoW)) {
              localStringBuilder.append((String)((p.b)paramAnonymousVector.get(i)).DoZ + "-");
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
      int i = this.DxH.size();
      AppMethodBeat.o(70944);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70945);
      Object localObject = this.DxH.get(paramInt);
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
        paramViewGroup.DxL = paramView.findViewById(2131306726);
        paramViewGroup.lHk = ((TextView)paramView.findViewById(2131306725));
        paramViewGroup.oLi = ((TextView)paramView.findViewById(2131306724));
        paramViewGroup.lHT = ((TextView)paramView.findViewById(2131306723));
        paramViewGroup.DxN = ((CheckBox)paramView.findViewById(2131306722));
        paramViewGroup.DxM = ((ImageView)paramView.findViewById(2131306721));
        paramView.setTag(paramViewGroup);
        localObject3 = (t)getItem(paramInt);
        if ((paramInt != this.DxG) || (this.DxG <= 0)) {
          break label418;
        }
        paramViewGroup.DxL.setVisibility(0);
        paramViewGroup.DxM.setVisibility(8);
        if (bu.isNullOrNil(((t)localObject3).CZy)) {
          break label438;
        }
        paramViewGroup.lHk.setText(((t)localObject3).CZy);
        paramViewGroup.lHk.setVisibility(0);
        localObject1 = ((t)localObject3).CYz;
        if ((this.DxI == null) || (this.DxI.CYX == null)) {
          break label459;
        }
        localObject2 = this.DxI.CYX;
        i = 0;
        label221:
        if (i >= ((List)localObject2).size()) {
          break label459;
        }
        if (!((String)localObject1).equals(((f)((List)localObject2).get(i)).CYz)) {
          break label450;
        }
        localObject1 = (f)((List)localObject2).get(i);
        label270:
        localObject2 = ((t)localObject3).CYA;
        localObject3 = ((t)localObject3).CYB;
        if (localObject1 == null) {
          break label527;
        }
        localObject3 = ((f)localObject1).CYA;
        localObject2 = ((f)localObject1).CYB;
        localObject1 = localObject3;
      }
      for (;;)
      {
        if (!bu.isNullOrNil((String)localObject1))
        {
          paramViewGroup.oLi.setText((CharSequence)localObject1);
          paramViewGroup.oLi.setVisibility(0);
          label332:
          if (bu.isNullOrNil((String)localObject2)) {
            break label477;
          }
          paramViewGroup.lHT.setText((CharSequence)localObject2);
          paramViewGroup.lHT.setVisibility(0);
          label357:
          localObject1 = ((p.b)this.DxJ.DoS.get(paramInt)).Dpa;
          if (localObject1 != p.a.DoV) {
            break label489;
          }
          paramViewGroup.DxN.setChecked(false);
          paramViewGroup.DxN.setEnabled(false);
        }
        for (;;)
        {
          AppMethodBeat.o(70946);
          return paramView;
          paramViewGroup = (n.c)paramView.getTag();
          break;
          label418:
          paramViewGroup.DxL.setVisibility(8);
          paramViewGroup.DxM.setVisibility(0);
          break label154;
          label438:
          paramViewGroup.lHk.setVisibility(8);
          break label185;
          label450:
          i += 1;
          break label221;
          label459:
          localObject1 = null;
          break label270;
          paramViewGroup.oLi.setVisibility(8);
          break label332;
          label477:
          paramViewGroup.lHT.setVisibility(8);
          break label357;
          label489:
          paramViewGroup.DxN.setEnabled(true);
          if (localObject1 == p.a.DoW) {
            paramViewGroup.DxN.setChecked(true);
          } else {
            paramViewGroup.DxN.setChecked(false);
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
    View DxL;
    ImageView DxM;
    CheckBox DxN;
    TextView lHT;
    TextView lHk;
    TextView oLi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n
 * JD-Core Version:    0.7.0.1
 */