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
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.model.p.a;
import com.tencent.mm.plugin.wallet_core.model.p.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class o
  extends com.tencent.mm.ui.base.i
{
  private MaxListView OYS;
  private TextView OYT;
  private a OYU;
  private b OYV;
  private e OyM;
  private LayoutInflater mInflater;
  private View mrI;
  
  private o(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(70947);
    this.mInflater = LayoutInflater.from(paramContext);
    this.mrI = LayoutInflater.from(paramContext).inflate(a.g.wallet_favor_dialog, null);
    this.OYS = ((MaxListView)this.mrI.findViewById(a.f.wallet_favor_list));
    this.OYT = ((TextView)this.mrI.findViewById(a.f.wallet_favor_discount));
    this.OYU = new a();
    this.OYS.setAdapter(this.OYU);
    this.mrI.findViewById(a.f.wallet_favor_footer).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70940);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        o.a(o.this);
        o.this.dismiss();
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70940);
      }
    });
    AppMethodBeat.o(70947);
  }
  
  public static o a(Context paramContext, Orders paramOrders, String paramString, b paramb, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(70950);
    o localo = new o(paramContext);
    localo.setOnCancelListener(paramOnCancelListener);
    localo.setCancelable(true);
    localo.setCanceledOnTouchOutside(false);
    localo.OyM = f.OVk.a(paramOrders);
    if (localo.OyM == null)
    {
      Log.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
      localo.dismiss();
    }
    Object localObject2;
    int i;
    for (;;)
    {
      localo.OYV = paramb;
      localo.show();
      com.tencent.mm.ui.base.h.a(paramContext, localo);
      AppMethodBeat.o(70950);
      return localo;
      paramOrders = localo.OYU;
      localObject2 = paramOrders.OYW.OyM.OVf;
      paramOnCancelListener = paramOrders.OYW.OyM.bhw(paramString);
      paramOrders.OYY = paramOrders.OYW.OyM.gLg();
      paramOrders.OYZ = paramOrders.OYW.OyM.bhs(paramOnCancelListener);
      paramOrders.OYX = -1;
      i = 0;
      for (;;)
      {
        if (i < paramOrders.OYY.size()) {
          if (((t)paramOrders.OYY.get(i)).Oxj == 0) {
            break label273;
          }
        }
        label273:
        for (j = 1; j != 0; j = 0)
        {
          paramOrders.OYX = i;
          paramString = new LinkedList();
          if (paramOrders.OYY == null) {
            break label288;
          }
          i = 0;
          while (i < paramOrders.OYY.size())
          {
            paramString.add(((t)paramOrders.OYY.get(i)).Owg);
            i += 1;
          }
        }
        i += 1;
      }
      label288:
      Log.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
      i = 0;
      label298:
      if (i != 0) {
        break label672;
      }
      Log.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
      localo.dismiss();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).Own != null))
    {
      i = 0;
      while (i < ((com.tencent.mm.plugin.wallet.a.h)localObject2).Own.size())
      {
        localObject1 = ((t)((com.tencent.mm.plugin.wallet.a.h)localObject2).Own.get(i)).Owg;
        if (!paramString.contains(localObject1)) {
          localLinkedList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject1 = new LinkedList();
    label450:
    String str;
    if ((localObject2 != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).Owo != null) && (((com.tencent.mm.plugin.wallet.a.h)localObject2).Owo.OwA != null))
    {
      localObject2 = ((com.tencent.mm.plugin.wallet.a.h)localObject2).Owo.OwA;
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label564;
      }
      str = ((j)((List)localObject2).get(i)).OwC;
      j = 0;
      label482:
      if (j >= localLinkedList.size()) {
        break label703;
      }
      if (!str.contains((CharSequence)localLinkedList.get(j))) {}
    }
    label564:
    label703:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((List)localObject1).add(str);
      }
      i += 1;
      break label450;
      j += 1;
      break label482;
      Log.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
      i = 0;
      break label298;
      localLinkedList = new LinkedList();
      if ((!Util.isNullOrNil(paramOnCancelListener)) && (!paramOnCancelListener.equals("0")))
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
        Log.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
        i = 0;
        break label298;
      }
      paramOrders.OZa.f(paramString, localLinkedList, (List)localObject1);
      i = 1;
      break label298;
      localo.OYT.setText(a.i.wallet_favor_dialog_title);
      localo.OYS.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(70941);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousAdapterView);
          ((b)localObject).bn(paramAnonymousView);
          ((b)localObject).sg(paramAnonymousInt);
          ((b)localObject).Fs(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
          paramAnonymousAdapterView = o.b(o.this);
          paramAnonymousView = paramAnonymousAdapterView.OZa;
          if (paramAnonymousInt < paramAnonymousView.OQg.size())
          {
            localObject = ((p.b)paramAnonymousView.OQg.get(paramAnonymousInt)).OQo;
            p.a locala = p.a.OQk;
            int i = 0;
            while (i < paramAnonymousView.OQg.size())
            {
              paramAnonymousView.a(i, p.a.OQl);
              i += 1;
            }
            switch (com.tencent.mm.plugin.wallet_core.model.p.1.OQi[localObject.ordinal()])
            {
            }
          }
          for (;;)
          {
            paramAnonymousAdapterView.notifyDataSetChanged();
            a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(70941);
            return;
            paramAnonymousView.a(paramAnonymousInt, p.a.OQk);
            continue;
            paramAnonymousView.a(paramAnonymousInt, p.a.OQl);
          }
        }
      });
      break;
    }
  }
  
  private void gLx()
  {
    AppMethodBeat.i(70952);
    Log.d("MicroMsg.WalletFavorDialog", "On selection done");
    if (this.OYU != null)
    {
      Object localObject = this.OYU.OZa;
      localObject = ((p)localObject).a(((p)localObject).OQg, -1);
      localObject = this.OyM.bhv((String)localObject);
      this.OYV.a((FavorPayInfo)localObject);
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
      Log.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(70949);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70948);
    super.onCreate(paramBundle);
    setContentView(this.mrI);
    AppMethodBeat.o(70948);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70953);
    if (paramInt == 4) {
      gLx();
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
    int OYX;
    List<t> OYY;
    j OYZ;
    p<String> OZa;
    
    public a()
    {
      AppMethodBeat.i(70943);
      this.OYX = -1;
      this.OYY = new LinkedList();
      this.OYZ = null;
      this.OZa = new p()
      {
        public final String a(Vector<p<String>.b> paramAnonymousVector, int paramAnonymousInt)
        {
          AppMethodBeat.i(70942);
          if (paramAnonymousVector == null)
          {
            Log.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
            AppMethodBeat.o(70942);
            return "";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          int i = 0;
          while (i < paramAnonymousVector.size())
          {
            p.a locala = ((p.b)paramAnonymousVector.get(i)).OQo;
            if ((i == paramAnonymousInt) || (locala == p.a.OQk)) {
              localStringBuilder.append((String)((p.b)paramAnonymousVector.get(i)).OQn + "-");
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
      int i = this.OYY.size();
      AppMethodBeat.o(70944);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70945);
      Object localObject = this.OYY.get(paramInt);
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
      label161:
      label192:
      Object localObject1;
      Object localObject2;
      int i;
      if (paramView == null)
      {
        paramView = o.c(o.this).inflate(a.g.wallet_coupon_item, paramViewGroup, false);
        paramViewGroup = new o.c();
        paramViewGroup.OZc = paramView.findViewById(a.f.wallet_coupon_section_title);
        paramViewGroup.pPT = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_title));
        paramViewGroup.tuS = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_subtitle));
        paramViewGroup.mMA = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_desc));
        paramViewGroup.OZe = ((CheckBox)paramView.findViewById(a.f.wallet_coupon_item_checkbox));
        paramViewGroup.OZd = ((ImageView)paramView.findViewById(a.f.wallet_coupon_divider));
        paramView.setTag(paramViewGroup);
        localObject3 = (t)getItem(paramInt);
        if ((paramInt != this.OYX) || (this.OYX <= 0)) {
          break label425;
        }
        paramViewGroup.OZc.setVisibility(0);
        paramViewGroup.OZd.setVisibility(8);
        if (Util.isNullOrNil(((t)localObject3).Oxf)) {
          break label445;
        }
        paramViewGroup.pPT.setText(((t)localObject3).Oxf);
        paramViewGroup.pPT.setVisibility(0);
        localObject1 = ((t)localObject3).Owg;
        if ((this.OYZ == null) || (this.OYZ.OwE == null)) {
          break label466;
        }
        localObject2 = this.OYZ.OwE;
        i = 0;
        label228:
        if (i >= ((List)localObject2).size()) {
          break label466;
        }
        if (!((String)localObject1).equals(((com.tencent.mm.plugin.wallet.a.f)((List)localObject2).get(i)).Owg)) {
          break label457;
        }
        localObject1 = (com.tencent.mm.plugin.wallet.a.f)((List)localObject2).get(i);
        label277:
        localObject2 = ((t)localObject3).Owh;
        localObject3 = ((t)localObject3).Owi;
        if (localObject1 == null) {
          break label534;
        }
        localObject3 = ((com.tencent.mm.plugin.wallet.a.f)localObject1).Owh;
        localObject2 = ((com.tencent.mm.plugin.wallet.a.f)localObject1).Owi;
        localObject1 = localObject3;
      }
      for (;;)
      {
        if (!Util.isNullOrNil((String)localObject1))
        {
          paramViewGroup.tuS.setText((CharSequence)localObject1);
          paramViewGroup.tuS.setVisibility(0);
          label339:
          if (Util.isNullOrNil((String)localObject2)) {
            break label484;
          }
          paramViewGroup.mMA.setText((CharSequence)localObject2);
          paramViewGroup.mMA.setVisibility(0);
          label364:
          localObject1 = ((p.b)this.OZa.OQg.get(paramInt)).OQo;
          if (localObject1 != p.a.OQj) {
            break label496;
          }
          paramViewGroup.OZe.setChecked(false);
          paramViewGroup.OZe.setEnabled(false);
        }
        for (;;)
        {
          AppMethodBeat.o(70946);
          return paramView;
          paramViewGroup = (o.c)paramView.getTag();
          break;
          label425:
          paramViewGroup.OZc.setVisibility(8);
          paramViewGroup.OZd.setVisibility(0);
          break label161;
          label445:
          paramViewGroup.pPT.setVisibility(8);
          break label192;
          label457:
          i += 1;
          break label228;
          label466:
          localObject1 = null;
          break label277;
          paramViewGroup.tuS.setVisibility(8);
          break label339;
          label484:
          paramViewGroup.mMA.setVisibility(8);
          break label364;
          label496:
          paramViewGroup.OZe.setEnabled(true);
          if (localObject1 == p.a.OQk) {
            paramViewGroup.OZe.setChecked(true);
          } else {
            paramViewGroup.OZe.setChecked(false);
          }
        }
        label534:
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
    View OZc;
    ImageView OZd;
    CheckBox OZe;
    TextView mMA;
    TextView pPT;
    TextView tuS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o
 * JD-Core Version:    0.7.0.1
 */