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
import com.tencent.mm.plugin.wallet.model.h;
import com.tencent.mm.plugin.wallet.model.j;
import com.tencent.mm.plugin.wallet.model.q;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class p
  extends com.tencent.mm.ui.widget.a.i
{
  private MaxListView VPg;
  private TextView VPh;
  private a VPi;
  private b VPj;
  private f VnX;
  private LayoutInflater mInflater;
  private View plc;
  
  private p(Context paramContext)
  {
    super(paramContext, a.j.mmalertdialog);
    AppMethodBeat.i(70947);
    this.mInflater = LayoutInflater.from(paramContext);
    this.plc = LayoutInflater.from(paramContext).inflate(a.g.wallet_favor_dialog, null);
    this.VPg = ((MaxListView)this.plc.findViewById(a.f.wallet_favor_list));
    this.VPh = ((TextView)this.plc.findViewById(a.f.wallet_favor_discount));
    this.VPi = new a();
    this.VPg.setAdapter(this.VPi);
    this.plc.findViewById(a.f.wallet_favor_footer).setOnClickListener(new p.1(this));
    AppMethodBeat.o(70947);
  }
  
  public static p a(Context paramContext, Orders paramOrders, String paramString, b paramb, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(70950);
    p localp = new p(paramContext);
    localp.setOnCancelListener(paramOnCancelListener);
    localp.setCancelable(true);
    localp.setCanceledOnTouchOutside(false);
    localp.VnX = g.VLx.a(paramOrders);
    if (localp.VnX == null)
    {
      Log.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
      localp.dismiss();
    }
    Object localObject2;
    int i;
    for (;;)
    {
      localp.VPj = paramb;
      localp.show();
      k.a(paramContext, localp);
      AppMethodBeat.o(70950);
      return localp;
      paramOrders = localp.VPi;
      localObject2 = paramOrders.VPk.VnX.VLs;
      paramOnCancelListener = paramOrders.VPk.VnX.bhf(paramString);
      paramOrders.VPm = paramOrders.VPk.VnX.ikx();
      paramOrders.VPn = paramOrders.VPk.VnX.bhb(paramOnCancelListener);
      paramOrders.VPl = -1;
      i = 0;
      for (;;)
      {
        if (i < paramOrders.VPm.size()) {
          if (((q)paramOrders.VPm.get(i)).Vmu == 0) {
            break label273;
          }
        }
        label273:
        for (j = 1; j != 0; j = 0)
        {
          paramOrders.VPl = i;
          paramString = new LinkedList();
          if (paramOrders.VPm == null) {
            break label288;
          }
          i = 0;
          while (i < paramOrders.VPm.size())
          {
            paramString.add(((q)paramOrders.VPm.get(i)).Vlr);
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
      localp.dismiss();
    }
    LinkedList localLinkedList = new LinkedList();
    if ((localObject2 != null) && (((h)localObject2).Vly != null))
    {
      i = 0;
      while (i < ((h)localObject2).Vly.size())
      {
        localObject1 = ((q)((h)localObject2).Vly.get(i)).Vlr;
        if (!paramString.contains(localObject1)) {
          localLinkedList.add(localObject1);
        }
        i += 1;
      }
    }
    Object localObject1 = new LinkedList();
    label450:
    String str;
    if ((localObject2 != null) && (((h)localObject2).Vlz != null) && (((h)localObject2).Vlz.VlL != null))
    {
      localObject2 = ((h)localObject2).Vlz.VlL;
      i = 0;
      if (i >= ((List)localObject2).size()) {
        break label564;
      }
      str = ((j)((List)localObject2).get(i)).VlN;
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
      paramOrders.VPo.f(paramString, localLinkedList, (List)localObject1);
      i = 1;
      break label298;
      localp.VPh.setText(a.i.wallet_favor_dialog_title);
      localp.VPg.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(70941);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousAdapterView);
          ((b)localObject).cH(paramAnonymousView);
          ((b)localObject).sc(paramAnonymousInt);
          ((b)localObject).hB(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
          paramAnonymousAdapterView = p.b(p.this);
          paramAnonymousView = paramAnonymousAdapterView.VPo;
          if (paramAnonymousInt < paramAnonymousView.VGa.size())
          {
            localObject = ((com.tencent.mm.plugin.wallet_core.model.p.b)paramAnonymousView.VGa.get(paramAnonymousInt)).VGi;
            com.tencent.mm.plugin.wallet_core.model.p.a locala = com.tencent.mm.plugin.wallet_core.model.p.a.VGe;
            int i = 0;
            while (i < paramAnonymousView.VGa.size())
            {
              paramAnonymousView.a(i, com.tencent.mm.plugin.wallet_core.model.p.a.VGf);
              i += 1;
            }
            switch (com.tencent.mm.plugin.wallet_core.model.p.1.VGc[localObject.ordinal()])
            {
            }
          }
          for (;;)
          {
            paramAnonymousAdapterView.notifyDataSetChanged();
            a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletFavorDialog$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(70941);
            return;
            paramAnonymousView.a(paramAnonymousInt, com.tencent.mm.plugin.wallet_core.model.p.a.VGe);
            continue;
            paramAnonymousView.a(paramAnonymousInt, com.tencent.mm.plugin.wallet_core.model.p.a.VGf);
          }
        }
      });
      break;
    }
  }
  
  private void ikO()
  {
    AppMethodBeat.i(70952);
    Log.d("MicroMsg.WalletFavorDialog", "On selection done");
    if (this.VPi != null)
    {
      Object localObject = this.VPi.VPo;
      localObject = ((com.tencent.mm.plugin.wallet_core.model.p)localObject).a(((com.tencent.mm.plugin.wallet_core.model.p)localObject).VGa, -1);
      localObject = this.VnX.bhe((String)localObject);
      this.VPj.a((FavorPayInfo)localObject);
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
    setContentView(this.plc);
    AppMethodBeat.o(70948);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70953);
    if (paramInt == 4) {
      ikO();
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
    int VPl;
    List<q> VPm;
    j VPn;
    com.tencent.mm.plugin.wallet_core.model.p<String> VPo;
    
    public a()
    {
      AppMethodBeat.i(70943);
      this.VPl = -1;
      this.VPm = new LinkedList();
      this.VPn = null;
      this.VPo = new com.tencent.mm.plugin.wallet_core.model.p()
      {
        public final String a(Vector<com.tencent.mm.plugin.wallet_core.model.p<String>.b> paramAnonymousVector, int paramAnonymousInt)
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
            com.tencent.mm.plugin.wallet_core.model.p.a locala = ((com.tencent.mm.plugin.wallet_core.model.p.b)paramAnonymousVector.get(i)).VGi;
            if ((i == paramAnonymousInt) || (locala == com.tencent.mm.plugin.wallet_core.model.p.a.VGe)) {
              localStringBuilder.append((String)((com.tencent.mm.plugin.wallet_core.model.p.b)paramAnonymousVector.get(i)).VGh + "-");
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
      int i = this.VPm.size();
      AppMethodBeat.o(70944);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(70945);
      Object localObject = this.VPm.get(paramInt);
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
        paramView = p.c(p.this).inflate(a.g.wallet_coupon_item, paramViewGroup, false);
        paramViewGroup = new p.c();
        paramViewGroup.VPq = paramView.findViewById(a.f.wallet_coupon_section_title);
        paramViewGroup.sUt = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_title));
        paramViewGroup.wzp = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_subtitle));
        paramViewGroup.pJi = ((TextView)paramView.findViewById(a.f.wallet_coupon_item_desc));
        paramViewGroup.VPs = ((CheckBox)paramView.findViewById(a.f.wallet_coupon_item_checkbox));
        paramViewGroup.VPr = ((ImageView)paramView.findViewById(a.f.wallet_coupon_divider));
        paramView.setTag(paramViewGroup);
        localObject3 = (q)getItem(paramInt);
        if ((paramInt != this.VPl) || (this.VPl <= 0)) {
          break label425;
        }
        paramViewGroup.VPq.setVisibility(0);
        paramViewGroup.VPr.setVisibility(8);
        if (Util.isNullOrNil(((q)localObject3).Vmq)) {
          break label445;
        }
        paramViewGroup.sUt.setText(((q)localObject3).Vmq);
        paramViewGroup.sUt.setVisibility(0);
        localObject1 = ((q)localObject3).Vlr;
        if ((this.VPn == null) || (this.VPn.VlP == null)) {
          break label466;
        }
        localObject2 = this.VPn.VlP;
        i = 0;
        label228:
        if (i >= ((List)localObject2).size()) {
          break label466;
        }
        if (!((String)localObject1).equals(((com.tencent.mm.plugin.wallet.model.f)((List)localObject2).get(i)).Vlr)) {
          break label457;
        }
        localObject1 = (com.tencent.mm.plugin.wallet.model.f)((List)localObject2).get(i);
        label277:
        localObject2 = ((q)localObject3).Vls;
        localObject3 = ((q)localObject3).Vlt;
        if (localObject1 == null) {
          break label534;
        }
        localObject3 = ((com.tencent.mm.plugin.wallet.model.f)localObject1).Vls;
        localObject2 = ((com.tencent.mm.plugin.wallet.model.f)localObject1).Vlt;
        localObject1 = localObject3;
      }
      for (;;)
      {
        if (!Util.isNullOrNil((String)localObject1))
        {
          paramViewGroup.wzp.setText((CharSequence)localObject1);
          paramViewGroup.wzp.setVisibility(0);
          label339:
          if (Util.isNullOrNil((String)localObject2)) {
            break label484;
          }
          paramViewGroup.pJi.setText((CharSequence)localObject2);
          paramViewGroup.pJi.setVisibility(0);
          label364:
          localObject1 = ((com.tencent.mm.plugin.wallet_core.model.p.b)this.VPo.VGa.get(paramInt)).VGi;
          if (localObject1 != com.tencent.mm.plugin.wallet_core.model.p.a.VGd) {
            break label496;
          }
          paramViewGroup.VPs.setChecked(false);
          paramViewGroup.VPs.setEnabled(false);
        }
        for (;;)
        {
          AppMethodBeat.o(70946);
          return paramView;
          paramViewGroup = (p.c)paramView.getTag();
          break;
          label425:
          paramViewGroup.VPq.setVisibility(8);
          paramViewGroup.VPr.setVisibility(0);
          break label161;
          label445:
          paramViewGroup.sUt.setVisibility(8);
          break label192;
          label457:
          i += 1;
          break label228;
          label466:
          localObject1 = null;
          break label277;
          paramViewGroup.wzp.setVisibility(8);
          break label339;
          label484:
          paramViewGroup.pJi.setVisibility(8);
          break label364;
          label496:
          paramViewGroup.VPs.setEnabled(true);
          if (localObject1 == com.tencent.mm.plugin.wallet_core.model.p.a.VGe) {
            paramViewGroup.VPs.setChecked(true);
          } else {
            paramViewGroup.VPs.setChecked(false);
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
    View VPq;
    ImageView VPr;
    CheckBox VPs;
    TextView pJi;
    TextView sUt;
    TextView wzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.p
 * JD-Core Version:    0.7.0.1
 */