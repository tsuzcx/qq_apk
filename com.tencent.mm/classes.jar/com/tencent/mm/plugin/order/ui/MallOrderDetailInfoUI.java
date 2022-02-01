package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.order.model.j.a;
import com.tencent.mm.plugin.order.model.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements u.a
{
  private HashMap<String, View> AKR;
  private List<MallOrderDetailObject.a> ANL;
  protected MallOrderDetailObject AOR;
  private a APA;
  private View APB;
  private View APC;
  private View APD;
  private View APF;
  private View APG;
  private View APH;
  private View APJ;
  private boolean APK;
  private boolean APL;
  private int APM;
  private CheckedTextView APN;
  private CheckedTextView APO;
  View.OnClickListener APQ;
  String APz;
  private View.OnClickListener kuO;
  private ListView mListView;
  private String qvD;
  
  public MallOrderDetailInfoUI()
  {
    AppMethodBeat.i(66717);
    this.ANL = new ArrayList();
    this.AOR = null;
    this.AKR = new HashMap();
    this.APK = false;
    this.qvD = "";
    this.APL = false;
    this.APM = 0;
    this.kuO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (paramAnonymousView.getId() == 2131305671) {
          if (MallOrderDetailInfoUI.this.AOR.ANJ != null)
          {
            com.tencent.mm.plugin.order.c.c.bl(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANJ.xIy);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.ANJ.ANR);
          }
        }
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66706);
          return;
          if ((paramAnonymousView.getId() != 2131305685) && (paramAnonymousView.getId() != 2131305684)) {
            break;
          }
        } while ((MallOrderDetailInfoUI.this.AOR.ANK == null) || (MallOrderDetailInfoUI.this.AOR.ANK.size() <= 0));
        if (!TextUtils.isEmpty(((ProductSectionItem)MallOrderDetailInfoUI.this.AOR.ANK.get(0)).jumpUrl)) {}
        for (boolean bool = com.tencent.mm.plugin.order.c.c.bl(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.AOR.ANK.get(0)).jumpUrl);; bool = false)
        {
          if (!bool) {
            com.tencent.mm.plugin.order.c.c.bm(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.AOR.ANK.get(0)).APx);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.AOR.ANK.get(0)).name);
          break;
          if (paramAnonymousView.getId() == 2131305683)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput();
            paramAnonymousView.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.AOR.ANK);
            paramAnonymousView.putInt("key_enter_id", 0);
            paramAnonymousView.putString("key_trans_id", MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this));
            paramAnonymousView.putString("appname", MallOrderDetailInfoUI.this.AOR.appUserName);
            com.tencent.mm.wallet_core.a.l(MallOrderDetailInfoUI.this, new Bundle());
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131762898));
            break;
          }
          if (paramAnonymousView.getId() == 2131305692)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput().getString("key_trans_id");
            localObject = MallOrderDetailInfoUI.this.getInput();
            ((Bundle)localObject).putString("key_trans_id", paramAnonymousView);
            ((Bundle)localObject).putInt("key_enter_id", 1);
            if (MallOrderDetailInfoUI.this.AOR != null) {
              ((Bundle)localObject).putParcelable("transaction_data", MallOrderDetailInfoUI.this.AOR.ANI);
            }
            com.tencent.mm.wallet_core.a.l(MallOrderDetailInfoUI.this, (Bundle)localObject);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131762895));
            break;
          }
          if (paramAnonymousView.getId() == 2131305667)
          {
            MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this);
            break;
          }
          if (paramAnonymousView.getId() == 2131302354)
          {
            if ((MallOrderDetailInfoUI.this.AOR == null) || (MallOrderDetailInfoUI.this.AOR.ANP == null)) {
              break;
            }
            MallOrderDetailInfoUI.this.APz = MallOrderDetailInfoUI.this.AOR.ANP;
            MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131762893));
            break;
          }
          if (paramAnonymousView.getId() != 2131310632) {
            break;
          }
          com.tencent.mm.wallet_core.ui.f.an(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.AOR.appUserName);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131762904));
          break;
        }
      }
    };
    this.APQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66710);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this) != null) && (MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this) != null))
        {
          if (paramAnonymousView.getId() != 2131305663) {
            break label113;
          }
          MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setSelected(true);
          MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setSelected(false);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, 100);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66710);
          return;
          label113:
          MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setSelected(false);
          MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setSelected(true);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, -100);
        }
      }
    };
    AppMethodBeat.o(66717);
  }
  
  private static void a(View paramView, MallOrderDetailObject.a parama)
  {
    AppMethodBeat.i(66730);
    if (parama == null)
    {
      AppMethodBeat.o(66730);
      return;
    }
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if ((parama != null) && (parama.pSj)) {
      paramView.setBackgroundResource(2131233974);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      AppMethodBeat.o(66730);
      return;
      paramView.setBackgroundResource(2131233327);
    }
  }
  
  private void a(View paramView, ProductSectionItem paramProductSectionItem)
  {
    AppMethodBeat.i(66727);
    if ((paramView == null) || (paramProductSectionItem == null))
    {
      AppMethodBeat.o(66727);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131302851);
    if (localTextView != null) {
      localTextView.setText(paramProductSectionItem.name);
    }
    if (!TextUtils.isEmpty(paramProductSectionItem.iconUrl)) {
      v((ImageView)paramView.findViewById(2131302852), paramProductSectionItem.iconUrl);
    }
    AppMethodBeat.o(66727);
  }
  
  private void a(MallOrderDetailObject.b paramb)
  {
    AppMethodBeat.i(66723);
    String str;
    if (paramb != null)
    {
      str = paramb.ANR;
      if (TextUtils.isEmpty(paramb.ANS)) {
        break label338;
      }
      str = str + "：" + paramb.ANS;
    }
    label338:
    for (;;)
    {
      if (!this.APK)
      {
        this.APC.setVisibility(8);
        this.APB.setVisibility(0);
        ((TextView)this.APB.findViewById(2131305673)).setText(str);
        ((TextView)this.APB.findViewById(2131305672)).setText(com.tencent.mm.wallet_core.ui.f.rZ(this.AOR.ANQ));
        if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (com.tencent.mm.wallet_core.ui.f.bpr(paramb.thumbUrl)))
        {
          v((ImageView)this.APB.findViewById(2131305682), paramb.thumbUrl);
          AppMethodBeat.o(66723);
          return;
        }
        j((ImageView)this.APB.findViewById(2131305682));
        AppMethodBeat.o(66723);
        return;
      }
      this.APB.setVisibility(8);
      this.APC.setVisibility(0);
      ((TextView)this.APC.findViewById(2131305673)).setText(str);
      ((TextView)this.APC.findViewById(2131305672)).setText(com.tencent.mm.wallet_core.ui.f.rZ(this.AOR.ANQ));
      if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (com.tencent.mm.wallet_core.ui.f.bpr(paramb.thumbUrl)))
      {
        v((ImageView)this.APC.findViewById(2131305682), paramb.thumbUrl);
        AppMethodBeat.o(66723);
        return;
      }
      j((ImageView)this.APC.findViewById(2131305682));
      AppMethodBeat.o(66723);
      return;
      this.APB.setVisibility(8);
      this.APC.setVisibility(8);
      AppMethodBeat.o(66723);
      return;
    }
  }
  
  private void a(MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66724);
    if (paramMallTransactionObject != null)
    {
      this.APD.setVisibility(0);
      ((TextView)findViewById(2131305693)).setText(com.tencent.mm.wallet_core.ui.f.d(paramMallTransactionObject.qwJ, paramMallTransactionObject.AOl));
      if ((this.AOR != null) && (this.AOR.ANL != null) && (this.AOR.ANL.size() > 0))
      {
        paramMallTransactionObject = (MallOrderDetailObject.a)this.AOR.ANL.get(0);
        a(this.APF, paramMallTransactionObject);
        AppMethodBeat.o(66724);
      }
    }
    else
    {
      this.APD.setVisibility(8);
    }
    AppMethodBeat.o(66724);
  }
  
  private void bpn()
  {
    AppMethodBeat.i(66722);
    if (this.AOR == null)
    {
      AppMethodBeat.o(66722);
      return;
    }
    u.a(this);
    this.AKR.clear();
    a(this.AOR.ANJ);
    fL(this.AOR.ANK);
    a(this.AOR.ANI);
    fK(this.AOR.ANL);
    findViewById(2131304373).setVisibility(0);
    if ((this.AOR != null) && (TextUtils.isEmpty(this.AOR.ANP)) && (TextUtils.isEmpty(this.AOR.appUserName))) {
      findViewById(2131304373).setVisibility(8);
    }
    for (;;)
    {
      if ((this.AOR != null) && (!TextUtils.isEmpty(this.AOR.ANO))) {
        cvL();
      }
      AppMethodBeat.o(66722);
      return;
      TextView localTextView;
      if ((this.AOR != null) && (!TextUtils.isEmpty(this.AOR.ANP)) && (TextUtils.isEmpty(this.AOR.appUserName)))
      {
        findViewById(2131310632).setVisibility(8);
        findViewById(2131310631).setVisibility(8);
        localTextView = (TextView)findViewById(2131302354);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
      else if ((this.AOR != null) && (TextUtils.isEmpty(this.AOR.ANP)) && (!TextUtils.isEmpty(this.AOR.appUserName)))
      {
        findViewById(2131302354).setVisibility(8);
        findViewById(2131310631).setVisibility(8);
        localTextView = (TextView)findViewById(2131310632);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
    }
  }
  
  private void cvL()
  {
    AppMethodBeat.i(66729);
    addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(66707);
        MallOrderDetailInfoUI.d(MallOrderDetailInfoUI.this);
        AppMethodBeat.o(66707);
        return true;
      }
    });
    AppMethodBeat.o(66729);
  }
  
  private void eBk()
  {
    AppMethodBeat.i(66733);
    if ((!this.APL) && (this.APM != 0))
    {
      g.aAi();
      g.aAg().hqi.a(new com.tencent.mm.plugin.order.model.f(this.qvD, "", this.APM), 0);
      this.APL = true;
    }
    AppMethodBeat.o(66733);
  }
  
  private void eBl()
  {
    AppMethodBeat.i(66737);
    com.tencent.mm.ui.base.h.a(getContext(), 2131767999, 0, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(66711);
        MallOrderDetailInfoUI.this.finish();
        AppMethodBeat.o(66711);
      }
    });
    AppMethodBeat.o(66737);
  }
  
  private void fK(List<MallOrderDetailObject.a> paramList)
  {
    AppMethodBeat.i(66725);
    if (paramList != null)
    {
      this.ANL.addAll(paramList);
      this.APA.notifyDataSetChanged();
    }
    AppMethodBeat.o(66725);
  }
  
  private void fL(List<ProductSectionItem> paramList)
  {
    AppMethodBeat.i(66726);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.APG.setVisibility(8);
      this.APH.setVisibility(8);
      this.APJ.setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 1)
    {
      this.APJ.setVisibility(8);
      paramList = (ProductSectionItem)paramList.get(0);
      if (!TextUtils.isEmpty(paramList.iconUrl))
      {
        this.APG.setVisibility(8);
        this.APH.setVisibility(0);
        ((TextView)this.APH.findViewById(2131302851)).setText(paramList.name);
        ((TextView)this.APH.findViewById(2131302853)).setText(paramList.price);
        ((TextView)this.APH.findViewById(2131302849)).setText("+" + paramList.count);
        ((TextView)this.APH.findViewById(2131302848)).setText(ProductSectionItem.Skus.fJ(paramList.APw));
        if (!TextUtils.isEmpty(paramList.iconUrl))
        {
          v((ImageView)this.APH.findViewById(2131302852), paramList.iconUrl);
          AppMethodBeat.o(66726);
        }
      }
      else
      {
        this.APH.setVisibility(8);
        this.APG.setVisibility(0);
        ((TextView)this.APG.findViewById(2131302851)).setText(paramList.name);
        if (TextUtils.isEmpty(paramList.jumpUrl))
        {
          paramList = new Rect();
          paramList.set(this.APG.findViewById(2131302850).getPaddingLeft(), this.APG.findViewById(2131302850).getPaddingTop(), this.APG.findViewById(2131302850).getPaddingRight(), this.APG.findViewById(2131302850).getPaddingBottom());
          this.APG.findViewById(2131302850).setBackgroundResource(2131233327);
          this.APG.findViewById(2131302850).setPadding(paramList.left, paramList.top, paramList.right, paramList.bottom);
          AppMethodBeat.o(66726);
          return;
        }
        ((TextView)this.APG.findViewById(2131302851)).setTextColor(getResources().getColor(2131100779));
      }
      AppMethodBeat.o(66726);
      return;
    }
    this.APG.setVisibility(8);
    this.APH.setVisibility(8);
    this.APJ.setVisibility(0);
    if (paramList.size() == 2)
    {
      a(this.APJ.findViewById(2131305686), (ProductSectionItem)paramList.get(0));
      a(this.APJ.findViewById(2131305687), (ProductSectionItem)paramList.get(1));
      this.APJ.findViewById(2131305688).setVisibility(8);
      this.APJ.findViewById(2131305689).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 3)
    {
      a(this.APJ.findViewById(2131305686), (ProductSectionItem)paramList.get(0));
      a(this.APJ.findViewById(2131305687), (ProductSectionItem)paramList.get(1));
      a(this.APJ.findViewById(2131305688), (ProductSectionItem)paramList.get(2));
      this.APJ.findViewById(2131305689).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() >= 4)
    {
      a(this.APJ.findViewById(2131305686), (ProductSectionItem)paramList.get(0));
      a(this.APJ.findViewById(2131305687), (ProductSectionItem)paramList.get(1));
      a(this.APJ.findViewById(2131305688), (ProductSectionItem)paramList.get(2));
      a(this.APJ.findViewById(2131305689), (ProductSectionItem)paramList.get(3));
    }
    AppMethodBeat.o(66726);
  }
  
  private void j(ImageView paramImageView)
  {
    AppMethodBeat.i(66732);
    Bitmap localBitmap = com.tencent.mm.compatible.f.a.decodeResource(getResources(), 2131691071);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 96.0F));
    }
    AppMethodBeat.o(66732);
  }
  
  private void v(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66728);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!com.tencent.mm.wallet_core.ui.f.bpr(paramString)))
    {
      AppMethodBeat.o(66728);
      return;
    }
    paramImageView.setImageBitmap(u.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.AKR.put(paramString, paramImageView);
    AppMethodBeat.o(66728);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(66736);
    finish();
    AppMethodBeat.o(66736);
  }
  
  public void finish()
  {
    AppMethodBeat.i(66734);
    eBk();
    super.finish();
    AppMethodBeat.o(66734);
  }
  
  public int getLayoutId()
  {
    return 2131495440;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66719);
    int i;
    if (this.APK)
    {
      com.tencent.mm.plugin.order.a.b.eBa();
      j localj = com.tencent.mm.plugin.order.a.b.eBd().aJD(this.qvD);
      if ((localj != null) && (!TextUtils.isEmpty(localj.APm)) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.APm)))
      {
        i = Util.getInt(localj.APm, 0);
        if (i != 2) {
          break label323;
        }
        setMMTitle(2131762890);
      }
    }
    for (;;)
    {
      this.APB = findViewById(2131305671);
      this.APC = findViewById(2131305670);
      this.APH = findViewById(2131305685);
      this.APJ = findViewById(2131305683);
      this.APG = findViewById(2131305684);
      this.APD = findViewById(2131305692);
      this.APF = findViewById(2131305691);
      this.APB.setOnClickListener(this.kuO);
      this.APJ.setOnClickListener(this.kuO);
      this.APH.setOnClickListener(this.kuO);
      this.APG.setOnClickListener(this.kuO);
      this.APD.setOnClickListener(this.kuO);
      findViewById(2131305667).setOnClickListener(this.kuO);
      findViewById(2131302354).setOnClickListener(this.kuO);
      findViewById(2131310632).setOnClickListener(this.kuO);
      this.mListView = ((ListView)findViewById(2131305666));
      this.APA = new a((byte)0);
      this.mListView.setAdapter(this.APA);
      this.APA.notifyDataSetChanged();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(66709);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.jumpUrl)) {
            com.tencent.mm.plugin.order.c.c.bl(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.jumpUrl);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.name);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderDetailInfoUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(66709);
        }
      });
      bpn();
      AppMethodBeat.o(66719);
      return;
      i = -1;
      break;
      label323:
      if (i == 1)
      {
        setMMTitle(2131762891);
        continue;
        setMMTitle(2131762892);
      }
    }
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(66731);
    paramString = (ImageView)this.AKR.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(66731);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(66718);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.by(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = getInput().getString("key_trans_id");
      this.qvD = paramBundle;
      if (paramBundle == null) {
        break label91;
      }
      com.tencent.mm.plugin.order.a.b.eBa();
      if (com.tencent.mm.plugin.order.a.b.eBd().aJC(paramBundle)) {
        break label91;
      }
      this.APK = false;
      doSceneProgress(new com.tencent.mm.plugin.order.model.h(paramBundle));
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(66718);
      return;
      label91:
      com.tencent.mm.plugin.order.a.b.eBa();
      if (com.tencent.mm.plugin.order.a.b.eBd().aJC(paramBundle))
      {
        this.APK = true;
        com.tencent.mm.plugin.order.a.b.eBa();
        Object localObject2 = com.tencent.mm.plugin.order.a.b.eBd();
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = (Bundle)localObject1;
        }
        do
        {
          this.AOR = paramBundle;
          if (this.AOR != null) {
            break;
          }
          eBl();
          break;
          Log.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(paramBundle)));
          localObject2 = ((com.tencent.mm.plugin.order.model.c)localObject2).aJD(paramBundle);
          paramBundle = (Bundle)localObject1;
        } while (localObject2 == null);
        paramBundle = new MallOrderDetailObject();
        localObject1 = new MallOrderDetailObject.b();
        ((MallOrderDetailObject.b)localObject1).ANR = ((j)localObject2).APq;
        if ((!TextUtils.isEmpty(((j)localObject2).APo)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).APo))) {}
        int i;
        Object localObject3;
        MallOrderDetailObject.a locala;
        for (((MallOrderDetailObject.b)localObject1).hXs = Util.getInt(((j)localObject2).APo, 0);; ((MallOrderDetailObject.b)localObject1).hXs = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((MallOrderDetailObject.b)localObject1).thumbUrl = ((j)localObject2).APp;
          ((MallOrderDetailObject.b)localObject1).xIy = ((j)localObject2).APr;
          ((MallOrderDetailObject.b)localObject1).ANS = ((j)localObject2).dWG;
          paramBundle.ANJ = ((MallOrderDetailObject.b)localObject1);
          localObject1 = ((j)localObject2).APu;
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramBundle.ANL = new ArrayList();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.a)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.a)localObject3).name;
            locala.value = "";
            locala.jumpUrl = ((j.a)localObject3).jumpUrl;
            locala.pSj = false;
            paramBundle.ANL.add(locala);
            i += 1;
          }
        }
        localObject1 = ((j)localObject2).APv;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (paramBundle.ANL == null) {
            paramBundle.ANL = new ArrayList();
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.b)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.b)localObject3).name;
            locala.value = ((j.b)localObject3).value;
            locala.jumpUrl = ((j.b)localObject3).jumpUrl;
            locala.pSj = false;
            if (i == 0) {
              locala.pSj = true;
            }
            paramBundle.ANL.add(locala);
            i += 1;
          }
        }
        paramBundle.ANP = ((j)localObject2).APt;
        paramBundle.appUserName = ((j)localObject2).APs;
        if ((!TextUtils.isEmpty(((j)localObject2).APo)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).APo))) {}
        for (paramBundle.ANQ = Util.getInt(((j)localObject2).APo, 0);; paramBundle.ANQ = ((int)(System.currentTimeMillis() / 1000L))) {
          break;
        }
      }
      Log.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      eBl();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66735);
    eBk();
    super.onDestroy();
    AppMethodBeat.o(66735);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66720);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.by(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.bv(this);
      }
      AppMethodBeat.o(66720);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66720);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66721);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramq).AOR;
        Log.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          this.AOR = paramString;
          bpn();
        }
      }
      AppMethodBeat.o(66721);
      return true;
    }
    AppMethodBeat.o(66721);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private MallOrderDetailObject.a Ui(int paramInt)
    {
      AppMethodBeat.i(66713);
      MallOrderDetailObject.a locala = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramInt);
      AppMethodBeat.o(66713);
      return locala;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66712);
      int i = MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).size();
      AppMethodBeat.o(66712);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(66715);
      paramInt = Ui(paramInt).type;
      AppMethodBeat.o(66715);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66714);
      MallOrderDetailObject.a locala = Ui(paramInt);
      switch (locala.type)
      {
      default: 
        if (paramView == null)
        {
          paramView = View.inflate(MallOrderDetailInfoUI.this, 2131495432, null);
          paramViewGroup = new MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (byte)0);
          paramViewGroup.qdx = ((TextView)paramView.findViewById(2131305665));
          paramViewGroup.qez = ((TextView)paramView.findViewById(2131305664));
          paramViewGroup.qeA = ((TextView)paramView.findViewById(2131305662));
          paramViewGroup.sc = paramView.findViewById(2131305660);
          paramView.setTag(paramViewGroup);
          paramViewGroup.qdx.setText(locala.name);
          if (!TextUtils.isEmpty(locala.value)) {
            break label432;
          }
          paramViewGroup.qez.setVisibility(4);
          label153:
          if (!locala.pSj) {
            break label455;
          }
          paramViewGroup.qeA.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        if (paramInt + 1 < getCount())
        {
          locala = Ui(paramInt + 1);
          MallOrderDetailInfoUI.b(paramViewGroup.sc, locala);
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131495434, null);
        paramViewGroup = paramView.findViewById(2131305660);
        MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131305663));
        MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131305659));
        MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.APQ);
        MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.APQ);
        if (paramInt + 1 < getCount()) {
          MallOrderDetailInfoUI.b(paramViewGroup, Ui(paramInt + 1));
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131495433, null);
        paramViewGroup = (TextView)paramView.findViewById(2131305659);
        View localView = paramView.findViewById(2131305660);
        if (Util.getInt(locala.value, 0) >= 0)
        {
          paramViewGroup.setText(2131762888);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131691065, 0);
        }
        for (;;)
        {
          if (paramInt + 1 < getCount()) {
            MallOrderDetailInfoUI.b(localView, Ui(paramInt + 1));
          }
          AppMethodBeat.o(66714);
          return paramView;
          paramViewGroup.setText(2131762887);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131691061, 0);
        }
        paramViewGroup = (MallOrderDetailInfoUI.b)paramView.getTag();
        break;
        label432:
        paramViewGroup.qez.setVisibility(0);
        paramViewGroup.qez.setText(locala.value);
        break label153;
        label455:
        paramViewGroup.qeA.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
  
  final class b
  {
    TextView qdx;
    TextView qeA;
    TextView qez;
    View sc;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */