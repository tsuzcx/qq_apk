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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements u.a
{
  private View.OnClickListener jax;
  private ListView mListView;
  private String owt;
  private HashMap<String, View> vuh;
  private List<MallOrderDetailObject.a> vwL;
  protected MallOrderDetailObject vxS;
  String vyB;
  private a vyC;
  private View vyD;
  private View vyE;
  private View vyF;
  private View vyG;
  private View vyH;
  private View vyI;
  private View vyJ;
  private boolean vyK;
  private boolean vyL;
  private int vyM;
  private CheckedTextView vyN;
  private CheckedTextView vyO;
  View.OnClickListener vyP;
  
  public MallOrderDetailInfoUI()
  {
    AppMethodBeat.i(66717);
    this.vwL = new ArrayList();
    this.vxS = null;
    this.vuh = new HashMap();
    this.vyK = false;
    this.owt = "";
    this.vyL = false;
    this.vyM = 0;
    this.jax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66706);
        if (paramAnonymousView.getId() == 2131303063)
        {
          if (MallOrderDetailInfoUI.this.vxS.vwJ != null)
          {
            com.tencent.mm.plugin.order.c.c.aR(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.vxS.vwJ.thh);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.vxS.vwJ.vwR);
            AppMethodBeat.o(66706);
          }
        }
        else if ((paramAnonymousView.getId() == 2131303077) || (paramAnonymousView.getId() == 2131303076))
        {
          if ((MallOrderDetailInfoUI.this.vxS.vwK == null) || (MallOrderDetailInfoUI.this.vxS.vwK.size() <= 0)) {
            break label598;
          }
          if (TextUtils.isEmpty(((ProductSectionItem)MallOrderDetailInfoUI.this.vxS.vwK.get(0)).jumpUrl)) {
            break label604;
          }
        }
        label598:
        label604:
        for (boolean bool = com.tencent.mm.plugin.order.c.c.aR(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.vxS.vwK.get(0)).jumpUrl);; bool = false)
        {
          if (!bool) {
            com.tencent.mm.plugin.order.c.c.aS(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.vxS.vwK.get(0)).vyz);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, ((ProductSectionItem)MallOrderDetailInfoUI.this.vxS.vwK.get(0)).name);
          AppMethodBeat.o(66706);
          return;
          if (paramAnonymousView.getId() == 2131303075)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput();
            paramAnonymousView.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.vxS.vwK);
            paramAnonymousView.putInt("key_enter_id", 0);
            paramAnonymousView.putString("key_trans_id", MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this));
            paramAnonymousView.putString("appname", MallOrderDetailInfoUI.this.vxS.dia);
            com.tencent.mm.wallet_core.a.k(MallOrderDetailInfoUI.this, new Bundle());
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761111));
            AppMethodBeat.o(66706);
            return;
          }
          if (paramAnonymousView.getId() == 2131303084)
          {
            paramAnonymousView = MallOrderDetailInfoUI.this.getInput().getString("key_trans_id");
            Bundle localBundle = MallOrderDetailInfoUI.this.getInput();
            localBundle.putString("key_trans_id", paramAnonymousView);
            localBundle.putInt("key_enter_id", 1);
            if (MallOrderDetailInfoUI.this.vxS != null) {
              localBundle.putParcelable("transaction_data", MallOrderDetailInfoUI.this.vxS.vwI);
            }
            com.tencent.mm.wallet_core.a.k(MallOrderDetailInfoUI.this, localBundle);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761108));
            AppMethodBeat.o(66706);
            return;
          }
          if (paramAnonymousView.getId() == 2131303059)
          {
            MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this);
            AppMethodBeat.o(66706);
            return;
          }
          if (paramAnonymousView.getId() == 2131300763)
          {
            if ((MallOrderDetailInfoUI.this.vxS != null) && (MallOrderDetailInfoUI.this.vxS.vwP != null))
            {
              MallOrderDetailInfoUI.this.vyB = MallOrderDetailInfoUI.this.vxS.vwP;
              MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
              MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761106));
              AppMethodBeat.o(66706);
            }
          }
          else if (paramAnonymousView.getId() == 2131307105)
          {
            e.ae(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.vxS.dia);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(2131761117));
          }
          AppMethodBeat.o(66706);
          return;
        }
      }
    };
    this.vyP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(66710);
        if ((MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this) != null) && (MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this) != null))
        {
          if (paramAnonymousView.getId() == 2131303055)
          {
            MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setSelected(true);
            MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setSelected(false);
            MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, 100);
            AppMethodBeat.o(66710);
            return;
          }
          MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setSelected(false);
          MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setSelected(true);
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, -100);
        }
        AppMethodBeat.o(66710);
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
    if ((parama != null) && (parama.nUD)) {
      paramView.setBackgroundResource(2131233299);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      AppMethodBeat.o(66730);
      return;
      paramView.setBackgroundResource(2131232867);
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
    TextView localTextView = (TextView)paramView.findViewById(2131301179);
    if (localTextView != null) {
      localTextView.setText(paramProductSectionItem.name);
    }
    if (!TextUtils.isEmpty(paramProductSectionItem.iconUrl)) {
      s((ImageView)paramView.findViewById(2131301180), paramProductSectionItem.iconUrl);
    }
    AppMethodBeat.o(66727);
  }
  
  private void a(MallOrderDetailObject.b paramb)
  {
    AppMethodBeat.i(66723);
    String str;
    if (paramb != null)
    {
      str = paramb.vwR;
      if (TextUtils.isEmpty(paramb.vwS)) {
        break label338;
      }
      str = str + "：" + paramb.vwS;
    }
    label338:
    for (;;)
    {
      if (!this.vyK)
      {
        this.vyE.setVisibility(8);
        this.vyD.setVisibility(0);
        ((TextView)this.vyD.findViewById(2131303065)).setText(str);
        ((TextView)this.vyD.findViewById(2131303064)).setText(e.nV(this.vxS.vwQ));
        if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (e.aSH(paramb.thumbUrl)))
        {
          s((ImageView)this.vyD.findViewById(2131303074), paramb.thumbUrl);
          AppMethodBeat.o(66723);
          return;
        }
        h((ImageView)this.vyD.findViewById(2131303074));
        AppMethodBeat.o(66723);
        return;
      }
      this.vyD.setVisibility(8);
      this.vyE.setVisibility(0);
      ((TextView)this.vyE.findViewById(2131303065)).setText(str);
      ((TextView)this.vyE.findViewById(2131303064)).setText(e.nV(this.vxS.vwQ));
      if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (e.aSH(paramb.thumbUrl)))
      {
        s((ImageView)this.vyE.findViewById(2131303074), paramb.thumbUrl);
        AppMethodBeat.o(66723);
        return;
      }
      h((ImageView)this.vyE.findViewById(2131303074));
      AppMethodBeat.o(66723);
      return;
      this.vyD.setVisibility(8);
      this.vyE.setVisibility(8);
      AppMethodBeat.o(66723);
      return;
    }
  }
  
  private void a(MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66724);
    if (paramMallTransactionObject != null)
    {
      this.vyF.setVisibility(0);
      ((TextView)findViewById(2131303085)).setText(e.d(paramMallTransactionObject.oxA, paramMallTransactionObject.vxl));
      if ((this.vxS != null) && (this.vxS.vwL != null) && (this.vxS.vwL.size() > 0))
      {
        paramMallTransactionObject = (MallOrderDetailObject.a)this.vxS.vwL.get(0);
        a(this.vyG, paramMallTransactionObject);
        AppMethodBeat.o(66724);
      }
    }
    else
    {
      this.vyF.setVisibility(8);
    }
    AppMethodBeat.o(66724);
  }
  
  private void aQP()
  {
    AppMethodBeat.i(66722);
    if (this.vxS == null)
    {
      AppMethodBeat.o(66722);
      return;
    }
    u.a(this);
    this.vuh.clear();
    a(this.vxS.vwJ);
    eu(this.vxS.vwK);
    a(this.vxS.vwI);
    et(this.vxS.vwL);
    findViewById(2131302034).setVisibility(0);
    if ((this.vxS != null) && (TextUtils.isEmpty(this.vxS.vwP)) && (TextUtils.isEmpty(this.vxS.dia))) {
      findViewById(2131302034).setVisibility(8);
    }
    for (;;)
    {
      if ((this.vxS != null) && (!TextUtils.isEmpty(this.vxS.vwO))) {
        bSb();
      }
      AppMethodBeat.o(66722);
      return;
      TextView localTextView;
      if ((this.vxS != null) && (!TextUtils.isEmpty(this.vxS.vwP)) && (TextUtils.isEmpty(this.vxS.dia)))
      {
        findViewById(2131307105).setVisibility(8);
        findViewById(2131307104).setVisibility(8);
        localTextView = (TextView)findViewById(2131300763);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
      else if ((this.vxS != null) && (TextUtils.isEmpty(this.vxS.vwP)) && (!TextUtils.isEmpty(this.vxS.dia)))
      {
        findViewById(2131300763).setVisibility(8);
        findViewById(2131307104).setVisibility(8);
        localTextView = (TextView)findViewById(2131307105);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
    }
  }
  
  private void bSb()
  {
    AppMethodBeat.i(66729);
    addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
  
  private void dnR()
  {
    AppMethodBeat.i(66733);
    if ((!this.vyL) && (this.vyM != 0))
    {
      g.agS();
      g.agQ().ghe.a(new com.tencent.mm.plugin.order.model.f(this.owt, "", this.vyM), 0);
      this.vyL = true;
    }
    AppMethodBeat.o(66733);
  }
  
  private void dnS()
  {
    AppMethodBeat.i(66737);
    com.tencent.mm.ui.base.h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
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
  
  private void et(List<MallOrderDetailObject.a> paramList)
  {
    AppMethodBeat.i(66725);
    if (paramList != null)
    {
      this.vwL.addAll(paramList);
      this.vyC.notifyDataSetChanged();
    }
    AppMethodBeat.o(66725);
  }
  
  private void eu(List<ProductSectionItem> paramList)
  {
    AppMethodBeat.i(66726);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.vyH.setVisibility(8);
      this.vyI.setVisibility(8);
      this.vyJ.setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 1)
    {
      this.vyJ.setVisibility(8);
      paramList = (ProductSectionItem)paramList.get(0);
      if (!TextUtils.isEmpty(paramList.iconUrl))
      {
        this.vyH.setVisibility(8);
        this.vyI.setVisibility(0);
        ((TextView)this.vyI.findViewById(2131301179)).setText(paramList.name);
        ((TextView)this.vyI.findViewById(2131301181)).setText(paramList.vyy);
        ((TextView)this.vyI.findViewById(2131301177)).setText("+" + paramList.count);
        ((TextView)this.vyI.findViewById(2131301176)).setText(ProductSectionItem.Skus.es(paramList.vyx));
        if (!TextUtils.isEmpty(paramList.iconUrl))
        {
          s((ImageView)this.vyI.findViewById(2131301180), paramList.iconUrl);
          AppMethodBeat.o(66726);
        }
      }
      else
      {
        this.vyI.setVisibility(8);
        this.vyH.setVisibility(0);
        ((TextView)this.vyH.findViewById(2131301179)).setText(paramList.name);
        if (TextUtils.isEmpty(paramList.jumpUrl))
        {
          paramList = new Rect();
          paramList.set(this.vyH.findViewById(2131301178).getPaddingLeft(), this.vyH.findViewById(2131301178).getPaddingTop(), this.vyH.findViewById(2131301178).getPaddingRight(), this.vyH.findViewById(2131301178).getPaddingBottom());
          this.vyH.findViewById(2131301178).setBackgroundResource(2131232867);
          this.vyH.findViewById(2131301178).setPadding(paramList.left, paramList.top, paramList.right, paramList.bottom);
          AppMethodBeat.o(66726);
          return;
        }
        ((TextView)this.vyH.findViewById(2131301179)).setTextColor(getResources().getColor(2131100611));
      }
      AppMethodBeat.o(66726);
      return;
    }
    this.vyH.setVisibility(8);
    this.vyI.setVisibility(8);
    this.vyJ.setVisibility(0);
    if (paramList.size() == 2)
    {
      a(this.vyJ.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.vyJ.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      this.vyJ.findViewById(2131303080).setVisibility(8);
      this.vyJ.findViewById(2131303081).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() == 3)
    {
      a(this.vyJ.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.vyJ.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      a(this.vyJ.findViewById(2131303080), (ProductSectionItem)paramList.get(2));
      this.vyJ.findViewById(2131303081).setVisibility(8);
      AppMethodBeat.o(66726);
      return;
    }
    if (paramList.size() >= 4)
    {
      a(this.vyJ.findViewById(2131303078), (ProductSectionItem)paramList.get(0));
      a(this.vyJ.findViewById(2131303079), (ProductSectionItem)paramList.get(1));
      a(this.vyJ.findViewById(2131303080), (ProductSectionItem)paramList.get(2));
      a(this.vyJ.findViewById(2131303081), (ProductSectionItem)paramList.get(3));
    }
    AppMethodBeat.o(66726);
  }
  
  private void h(ImageView paramImageView)
  {
    AppMethodBeat.i(66732);
    Bitmap localBitmap = com.tencent.mm.compatible.e.a.decodeResource(getResources(), 2131690787);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.f.a(localBitmap, false, 96.0F));
    }
    AppMethodBeat.o(66732);
  }
  
  private void s(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(66728);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!e.aSH(paramString)))
    {
      AppMethodBeat.o(66728);
      return;
    }
    paramImageView.setImageBitmap(u.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.vuh.put(paramString, paramImageView);
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
    dnR();
    super.finish();
    AppMethodBeat.o(66734);
  }
  
  public int getLayoutId()
  {
    return 2131494711;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66719);
    int i;
    if (this.vyK)
    {
      com.tencent.mm.plugin.order.a.b.dnG();
      j localj = com.tencent.mm.plugin.order.a.b.dnJ().apb(this.owt);
      if ((localj != null) && (!TextUtils.isEmpty(localj.vyn)) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.vyn)))
      {
        i = bs.getInt(localj.vyn, 0);
        if (i != 2) {
          break label323;
        }
        setMMTitle(2131761103);
      }
    }
    for (;;)
    {
      this.vyD = findViewById(2131303063);
      this.vyE = findViewById(2131303062);
      this.vyI = findViewById(2131303077);
      this.vyJ = findViewById(2131303075);
      this.vyH = findViewById(2131303076);
      this.vyF = findViewById(2131303084);
      this.vyG = findViewById(2131303083);
      this.vyD.setOnClickListener(this.jax);
      this.vyJ.setOnClickListener(this.jax);
      this.vyI.setOnClickListener(this.jax);
      this.vyH.setOnClickListener(this.jax);
      this.vyF.setOnClickListener(this.jax);
      findViewById(2131303059).setOnClickListener(this.jax);
      findViewById(2131300763).setOnClickListener(this.jax);
      findViewById(2131307105).setOnClickListener(this.jax);
      this.mListView = ((ListView)findViewById(2131303058));
      this.vyC = new a((byte)0);
      this.mListView.setAdapter(this.vyC);
      this.vyC.notifyDataSetChanged();
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(66709);
          paramAnonymousAdapterView = (MallOrderDetailObject.a)MallOrderDetailInfoUI.e(MallOrderDetailInfoUI.this).get(paramAnonymousInt);
          if (!TextUtils.isEmpty(paramAnonymousAdapterView.jumpUrl)) {
            com.tencent.mm.plugin.order.c.c.aR(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.jumpUrl);
          }
          MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, paramAnonymousAdapterView.name);
          AppMethodBeat.o(66709);
        }
      });
      aQP();
      AppMethodBeat.o(66719);
      return;
      i = -1;
      break;
      label323:
      if (i == 1)
      {
        setMMTitle(2131761104);
        continue;
        setMMTitle(2131761105);
      }
    }
  }
  
  public final void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(66731);
    paramString = (ImageView)this.vuh.get(paramString);
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
    paramBundle = com.tencent.mm.wallet_core.a.br(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = getInput().getString("key_trans_id");
      this.owt = paramBundle;
      if (paramBundle == null) {
        break label91;
      }
      com.tencent.mm.plugin.order.a.b.dnG();
      if (com.tencent.mm.plugin.order.a.b.dnJ().apa(paramBundle)) {
        break label91;
      }
      this.vyK = false;
      doSceneProgress(new com.tencent.mm.plugin.order.model.h(paramBundle));
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(66718);
      return;
      label91:
      com.tencent.mm.plugin.order.a.b.dnG();
      if (com.tencent.mm.plugin.order.a.b.dnJ().apa(paramBundle))
      {
        this.vyK = true;
        com.tencent.mm.plugin.order.a.b.dnG();
        Object localObject2 = com.tencent.mm.plugin.order.a.b.dnJ();
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = (Bundle)localObject1;
        }
        do
        {
          this.vxS = paramBundle;
          if (this.vxS != null) {
            break;
          }
          dnS();
          break;
          ac.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(paramBundle)));
          localObject2 = ((com.tencent.mm.plugin.order.model.c)localObject2).apb(paramBundle);
          paramBundle = (Bundle)localObject1;
        } while (localObject2 == null);
        paramBundle = new MallOrderDetailObject();
        localObject1 = new MallOrderDetailObject.b();
        ((MallOrderDetailObject.b)localObject1).vwR = ((j)localObject2).vyr;
        if ((!TextUtils.isEmpty(((j)localObject2).vyp)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).vyp))) {}
        int i;
        Object localObject3;
        MallOrderDetailObject.a locala;
        for (((MallOrderDetailObject.b)localObject1).gIh = bs.getInt(((j)localObject2).vyp, 0);; ((MallOrderDetailObject.b)localObject1).gIh = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((MallOrderDetailObject.b)localObject1).thumbUrl = ((j)localObject2).vyq;
          ((MallOrderDetailObject.b)localObject1).thh = ((j)localObject2).vys;
          ((MallOrderDetailObject.b)localObject1).vwS = ((j)localObject2).drV;
          paramBundle.vwJ = ((MallOrderDetailObject.b)localObject1);
          localObject1 = ((j)localObject2).vyv;
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramBundle.vwL = new ArrayList();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.a)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.a)localObject3).name;
            locala.value = "";
            locala.jumpUrl = ((j.a)localObject3).jumpUrl;
            locala.nUD = false;
            paramBundle.vwL.add(locala);
            i += 1;
          }
        }
        localObject1 = ((j)localObject2).vyw;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (paramBundle.vwL == null) {
            paramBundle.vwL = new ArrayList();
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.b)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.b)localObject3).name;
            locala.value = ((j.b)localObject3).value;
            locala.jumpUrl = ((j.b)localObject3).jumpUrl;
            locala.nUD = false;
            if (i == 0) {
              locala.nUD = true;
            }
            paramBundle.vwL.add(locala);
            i += 1;
          }
        }
        paramBundle.vwP = ((j)localObject2).vyu;
        paramBundle.dia = ((j)localObject2).vyt;
        if ((!TextUtils.isEmpty(((j)localObject2).vyp)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).vyp))) {}
        for (paramBundle.vwQ = bs.getInt(((j)localObject2).vyp, 0);; paramBundle.vwQ = ((int)(System.currentTimeMillis() / 1000L))) {
          break;
        }
      }
      ac.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      dnS();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66735);
    dnR();
    super.onDestroy();
    AppMethodBeat.o(66735);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66720);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.br(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.bo(this);
      }
      AppMethodBeat.o(66720);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(66720);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66721);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramn).vxS;
        ac.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          this.vxS = paramString;
          aQP();
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
    
    private MallOrderDetailObject.a KR(int paramInt)
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
      paramInt = KR(paramInt).type;
      AppMethodBeat.o(66715);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66714);
      MallOrderDetailObject.a locala = KR(paramInt);
      switch (locala.type)
      {
      default: 
        if (paramView == null)
        {
          paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494703, null);
          paramViewGroup = new MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (byte)0);
          paramViewGroup.ofO = ((TextView)paramView.findViewById(2131303057));
          paramViewGroup.ogQ = ((TextView)paramView.findViewById(2131303056));
          paramViewGroup.ogR = ((TextView)paramView.findViewById(2131303054));
          paramViewGroup.qe = paramView.findViewById(2131303052);
          paramView.setTag(paramViewGroup);
          paramViewGroup.ofO.setText(locala.name);
          if (!TextUtils.isEmpty(locala.value)) {
            break label432;
          }
          paramViewGroup.ogQ.setVisibility(4);
          label153:
          if (!locala.nUD) {
            break label455;
          }
          paramViewGroup.ogR.setVisibility(0);
        }
        break;
      }
      for (;;)
      {
        if (paramInt + 1 < getCount())
        {
          locala = KR(paramInt + 1);
          MallOrderDetailInfoUI.b(paramViewGroup.qe, locala);
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494705, null);
        paramViewGroup = paramView.findViewById(2131303052);
        MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131303055));
        MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this, (CheckedTextView)paramView.findViewById(2131303051));
        MallOrderDetailInfoUI.f(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.vyP);
        MallOrderDetailInfoUI.g(MallOrderDetailInfoUI.this).setOnClickListener(MallOrderDetailInfoUI.this.vyP);
        if (paramInt + 1 < getCount()) {
          MallOrderDetailInfoUI.b(paramViewGroup, KR(paramInt + 1));
        }
        AppMethodBeat.o(66714);
        return paramView;
        paramView = View.inflate(MallOrderDetailInfoUI.this, 2131494704, null);
        paramViewGroup = (TextView)paramView.findViewById(2131303051);
        View localView = paramView.findViewById(2131303052);
        if (bs.getInt(locala.value, 0) >= 0)
        {
          paramViewGroup.setText(2131761101);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131690781, 0);
        }
        for (;;)
        {
          if (paramInt + 1 < getCount()) {
            MallOrderDetailInfoUI.b(localView, KR(paramInt + 1));
          }
          AppMethodBeat.o(66714);
          return paramView;
          paramViewGroup.setText(2131761100);
          paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131690777, 0);
        }
        paramViewGroup = (MallOrderDetailInfoUI.b)paramView.getTag();
        break;
        label432:
        paramViewGroup.ogQ.setVisibility(0);
        paramViewGroup.ogQ.setText(locala.value);
        break label153;
        label455:
        paramViewGroup.ogR.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
  }
  
  final class b
  {
    TextView ofO;
    TextView ogQ;
    TextView ogR;
    View qe;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */