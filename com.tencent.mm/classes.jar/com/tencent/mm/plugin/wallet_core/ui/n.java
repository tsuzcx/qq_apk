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
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.model.p.a;
import com.tencent.mm.plugin.wallet_core.model.p.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MaxListView;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class n
  extends com.tencent.mm.ui.base.i
{
  private MaxListView BFF;
  private TextView BFG;
  private a BFH;
  private b BFI;
  private d Bjk;
  private View ijA;
  private LayoutInflater mInflater;
  
  private n(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(70947);
    this.mInflater = LayoutInflater.from(paramContext);
    this.ijA = LayoutInflater.from(paramContext).inflate(2131495948, null);
    this.BFF = ((MaxListView)this.ijA.findViewById(2131306744));
    this.BFG = ((TextView)this.ijA.findViewById(2131306741));
    this.BFH = new a();
    this.BFF.setAdapter(this.BFH);
    this.ijA.findViewById(2131306742).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70940);
        n.a(n.this);
        n.this.dismiss();
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
    localn.Bjk = e.BBL.a(paramOrders);
    if (localn.Bjk == null)
    {
      ac.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
      localn.dismiss();
    }
    Object localObject2;
    int i;
    for (;;)
    {
      localn.BFI = paramb;
      localn.show();
      com.tencent.mm.ui.base.h.a(paramContext, localn);
      AppMethodBeat.o(70950);
      return localn;
      paramOrders = localn.BFH;
      localObject2 = paramOrders.BFJ.Bjk.BBG;
      paramOnCancelListener = paramOrders.BFJ.Bjk.azI(paramString);
      paramOrders.BFL = paramOrders.BFJ.Bjk.etg();
      paramOrders.BFM = paramOrders.BFJ.Bjk.azE(paramOnCancelListener);
      paramOrders.BFK = -1;
      i = 0;
      for (;;)
      {
        if (i < paramOrders.BFL.size()) {
          if (((t)paramOrders.BFL.get(i)).BhI == 0) {
            break label273;
          }
        }
        label273:
        for (j = 1; j != 0; j = 0)
        {
          paramOrders.BFK = i;
          paramString = new LinkedList();
          if (paramOrders.BFL == null) {
            break label288;
          }
          i = 0;
          while (i < paramOrders.BFL.size())
          {
            paramString.add(((t)paramOrders.BFL.get(i)).BgF);
            i += 1;
          }
        }
        i += 1;
      }
      label288:
      ac.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
      i = 0;
      label298:
      if (i != 0) {
        break label670;
      }
      ac.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
      localn.dismiss();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).BgM != null))
    {
      i = 0;
      while (i < ((com.tencent.mm.plugin.wallet.a.h)localObject2).BgM.size())
      {
        localObject1 = ((t)((com.tencent.mm.plugin.wallet.a.h)localObject2).BgM.get(i)).BgF;
        if (!paramString.contains(localObject1)) {
          localLinkedList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject1 = new LinkedList();
    label450:
    String str;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).BgN != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).BgN.BgZ != null))
    {
      localObject2 = ((com.tencent.mm.plugin.wallet.a.h)localObject2).BgN.BgZ;
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label563;
      }
      str = ((j)((List)localObject2).get(i)).Bhb;
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
      ac.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
      i = 0;
      break label298;
      localLinkedList = new LinkedList();
      if ((!bs.isNullOrNil(paramOnCancelListener)) && (!paramOnCancelListener.equals("0")))
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
        ac.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
        i = 0;
        break label298;
      }
      paramOrders.BFN.d(paramString, localLinkedList, (List)localObject1);
      i = 1;
      break label298;
      localn.BFG.setText(2131765257);
      localn.BFF.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(70941);
          paramAnonymousAdapterView = n.b(n.this);
          paramAnonymousView = paramAnonymousAdapterView.BFN;
          if (paramAnonymousInt < paramAnonymousView.BwX.size())
          {
            p.a locala1 = ((p.b)paramAnonymousView.BwX.get(paramAnonymousInt)).Bxf;
            p.a locala2 = p.a.Bxb;
            int i = 0;
            while (i < paramAnonymousView.BwX.size())
            {
              paramAnonymousView.a(i, p.a.Bxc);
              i += 1;
            }
            switch (com.tencent.mm.plugin.wallet_core.model.p.1.BwZ[locala1.ordinal()])
            {
            }
          }
          for (;;)
          {
            paramAnonymousAdapterView.notifyDataSetChanged();
            AppMethodBeat.o(70941);
            return;
            paramAnonymousView.a(paramAnonymousInt, p.a.Bxb);
            continue;
            paramAnonymousView.a(paramAnonymousInt, p.a.Bxc);
          }
        }
      });
      break;
    }
  }
  
  private void ety()
  {
    AppMethodBeat.i(70952);
    ac.d("MicroMsg.WalletFavorDialog", "On selection done");
    if (this.BFH != null)
    {
      Object localObject = this.BFH.BFN;
      localObject = ((p)localObject).a(((p)localObject).BwX, -1);
      localObject = this.Bjk.azH((String)localObject);
      this.BFI.a((FavorPayInfo)localObject);
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
      ac.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(70949);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70948);
    super.onCreate(paramBundle);
    setContentView(this.ijA);
    AppMethodBeat.o(70948);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70953);
    if (paramInt == 4) {
      ety();
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
    int BFK;
    List<t> BFL;
    j BFM;
    p<String> BFN;
    
    public a()
    {
      AppMethodBeat.i(70943);
      this.BFK = -1;
      this.BFL = new LinkedList();
      this.BFM = null;
      this.BFN = new p()
      {
        public final String a(Vector<p<String>.b> paramAnonymousVector, int paramAnonymousInt)
        {
          AppMethodBeat.i(70942);
          if (paramAnonymousVector == null)
          {
            ac.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
            AppMethodBeat.o(70942);
            return "";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          int i = 0;
          while (i < paramAnonymousVector.size())
          {
            p.a locala = ((p.b)paramAnonymousVector.get(i)).Bxf;
            if ((i == paramAnonymousInt) || (locala == p.a.Bxb)) {
              localStringBuilder.append((String)((p.b)paramAnonymousVector.get(i)).Bxe + "-");
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
      int i = this.BFL.size();
      AppMethodBeat.o(70944);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70945);
      Object localObject = this.BFL.get(paramInt);
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
        paramViewGroup.BFP = paramView.findViewById(2131306726);
        paramViewGroup.lfN = ((TextView)paramView.findViewById(2131306725));
        paramViewGroup.obn = ((TextView)paramView.findViewById(2131306724));
        paramViewGroup.lgw = ((TextView)paramView.findViewById(2131306723));
        paramViewGroup.BFR = ((CheckBox)paramView.findViewById(2131306722));
        paramViewGroup.BFQ = ((ImageView)paramView.findViewById(2131306721));
        paramView.setTag(paramViewGroup);
        localObject3 = (t)getItem(paramInt);
        if ((paramInt != this.BFK) || (this.BFK <= 0)) {
          break label418;
        }
        paramViewGroup.BFP.setVisibility(0);
        paramViewGroup.BFQ.setVisibility(8);
        if (bs.isNullOrNil(((t)localObject3).BhE)) {
          break label438;
        }
        paramViewGroup.lfN.setText(((t)localObject3).BhE);
        paramViewGroup.lfN.setVisibility(0);
        localObject1 = ((t)localObject3).BgF;
        if ((this.BFM == null) || (this.BFM.Bhd == null)) {
          break label459;
        }
        localObject2 = this.BFM.Bhd;
        i = 0;
        label221:
        if (i >= ((List)localObject2).size()) {
          break label459;
        }
        if (!((String)localObject1).equals(((f)((List)localObject2).get(i)).BgF)) {
          break label450;
        }
        localObject1 = (f)((List)localObject2).get(i);
        label270:
        localObject2 = ((t)localObject3).BgG;
        localObject3 = ((t)localObject3).BgH;
        if (localObject1 == null) {
          break label527;
        }
        localObject3 = ((f)localObject1).BgG;
        localObject2 = ((f)localObject1).BgH;
        localObject1 = localObject3;
      }
      for (;;)
      {
        if (!bs.isNullOrNil((String)localObject1))
        {
          paramViewGroup.obn.setText((CharSequence)localObject1);
          paramViewGroup.obn.setVisibility(0);
          label332:
          if (bs.isNullOrNil((String)localObject2)) {
            break label477;
          }
          paramViewGroup.lgw.setText((CharSequence)localObject2);
          paramViewGroup.lgw.setVisibility(0);
          label357:
          localObject1 = ((p.b)this.BFN.BwX.get(paramInt)).Bxf;
          if (localObject1 != p.a.Bxa) {
            break label489;
          }
          paramViewGroup.BFR.setChecked(false);
          paramViewGroup.BFR.setEnabled(false);
        }
        for (;;)
        {
          AppMethodBeat.o(70946);
          return paramView;
          paramViewGroup = (n.c)paramView.getTag();
          break;
          label418:
          paramViewGroup.BFP.setVisibility(8);
          paramViewGroup.BFQ.setVisibility(0);
          break label154;
          label438:
          paramViewGroup.lfN.setVisibility(8);
          break label185;
          label450:
          i += 1;
          break label221;
          label459:
          localObject1 = null;
          break label270;
          paramViewGroup.obn.setVisibility(8);
          break label332;
          label477:
          paramViewGroup.lgw.setVisibility(8);
          break label357;
          label489:
          paramViewGroup.BFR.setEnabled(true);
          if (localObject1 == p.a.Bxb) {
            paramViewGroup.BFR.setChecked(true);
          } else {
            paramViewGroup.BFR.setChecked(false);
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
    View BFP;
    ImageView BFQ;
    CheckBox BFR;
    TextView lfN;
    TextView lgw;
    TextView obn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n
 * JD-Core Version:    0.7.0.1
 */