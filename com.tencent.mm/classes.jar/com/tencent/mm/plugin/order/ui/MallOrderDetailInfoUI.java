package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.b;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.f;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.order.model.j.a;
import com.tencent.mm.plugin.order.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI
  extends WalletBaseUI
  implements x.a
{
  private View.OnClickListener gMO;
  private String kMN;
  private ListView mListView;
  private HashMap<String, View> pmB;
  private List<MallOrderDetailObject.a> poP;
  protected MallOrderDetailObject ppW;
  String pqF;
  private MallOrderDetailInfoUI.a pqG;
  private View pqH;
  private View pqI;
  private View pqJ;
  private View pqK;
  private View pqL;
  private View pqM;
  private View pqN;
  private boolean pqO;
  private boolean pqP;
  private int pqQ;
  private CheckedTextView pqR;
  private CheckedTextView pqS;
  View.OnClickListener pqT;
  
  public MallOrderDetailInfoUI()
  {
    AppMethodBeat.i(43809);
    this.poP = new ArrayList();
    this.ppW = null;
    this.pmB = new HashMap();
    this.pqO = false;
    this.kMN = "";
    this.pqP = false;
    this.pqQ = 0;
    this.gMO = new MallOrderDetailInfoUI.1(this);
    this.pqT = new MallOrderDetailInfoUI.7(this);
    AppMethodBeat.o(43809);
  }
  
  private static void a(View paramView, MallOrderDetailObject.a parama)
  {
    AppMethodBeat.i(43822);
    if (parama == null)
    {
      AppMethodBeat.o(43822);
      return;
    }
    Rect localRect = new Rect();
    localRect.left = paramView.getPaddingLeft();
    localRect.right = paramView.getPaddingRight();
    localRect.top = paramView.getPaddingTop();
    localRect.bottom = paramView.getPaddingBottom();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if ((parama != null) && (parama.kmy)) {
      paramView.setBackgroundResource(2130839676);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
      AppMethodBeat.o(43822);
      return;
      paramView.setBackgroundResource(2130839276);
    }
  }
  
  private void a(View paramView, ProductSectionItem paramProductSectionItem)
  {
    AppMethodBeat.i(43819);
    if ((paramView == null) || (paramProductSectionItem == null))
    {
      AppMethodBeat.o(43819);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131826015);
    if (localTextView != null) {
      localTextView.setText(paramProductSectionItem.name);
    }
    if (!TextUtils.isEmpty(paramProductSectionItem.iconUrl)) {
      q((ImageView)paramView.findViewById(2131826014), paramProductSectionItem.iconUrl);
    }
    AppMethodBeat.o(43819);
  }
  
  private void a(MallOrderDetailObject.b paramb)
  {
    AppMethodBeat.i(43815);
    String str;
    if (paramb != null)
    {
      str = paramb.poV;
      if (TextUtils.isEmpty(paramb.poW)) {
        break label334;
      }
      str = str + "：" + paramb.poW;
    }
    label334:
    for (;;)
    {
      if (!this.pqO)
      {
        this.pqI.setVisibility(8);
        this.pqH.setVisibility(0);
        ((TextView)this.pqH.findViewById(2131825999)).setText(str);
        ((TextView)this.pqH.findViewById(2131826000)).setText(e.kB(this.ppW.poU));
        if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (e.awb(paramb.thumbUrl)))
        {
          q((ImageView)this.pqH.findViewById(2131825998), paramb.thumbUrl);
          AppMethodBeat.o(43815);
          return;
        }
        i((ImageView)this.pqH.findViewById(2131825998));
        AppMethodBeat.o(43815);
        return;
      }
      this.pqH.setVisibility(8);
      this.pqI.setVisibility(0);
      ((TextView)this.pqI.findViewById(2131825999)).setText(str);
      ((TextView)this.pqI.findViewById(2131826000)).setText(e.kB(this.ppW.poU));
      if ((!TextUtils.isEmpty(paramb.thumbUrl)) && (e.awb(paramb.thumbUrl)))
      {
        q((ImageView)this.pqI.findViewById(2131825998), paramb.thumbUrl);
        AppMethodBeat.o(43815);
        return;
      }
      i((ImageView)this.pqI.findViewById(2131825998));
      AppMethodBeat.o(43815);
      return;
      this.pqH.setVisibility(8);
      this.pqI.setVisibility(8);
      AppMethodBeat.o(43815);
      return;
    }
  }
  
  private void a(MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(43816);
    if (paramMallTransactionObject != null)
    {
      this.pqJ.setVisibility(0);
      ((TextView)findViewById(2131825989)).setText(e.e(paramMallTransactionObject.kNS, paramMallTransactionObject.ppp));
      if ((this.ppW != null) && (this.ppW.poP != null) && (this.ppW.poP.size() > 0))
      {
        paramMallTransactionObject = (MallOrderDetailObject.a)this.ppW.poP.get(0);
        a(this.pqK, paramMallTransactionObject);
        AppMethodBeat.o(43816);
      }
    }
    else
    {
      this.pqJ.setVisibility(8);
    }
    AppMethodBeat.o(43816);
  }
  
  private void ary()
  {
    AppMethodBeat.i(43814);
    if (this.ppW == null)
    {
      AppMethodBeat.o(43814);
      return;
    }
    x.a(this);
    this.pmB.clear();
    a(this.ppW.poN);
    ct(this.ppW.poO);
    a(this.ppW.poM);
    cs(this.ppW.poP);
    findViewById(2131825991).setVisibility(0);
    if ((this.ppW != null) && (TextUtils.isEmpty(this.ppW.poT)) && (TextUtils.isEmpty(this.ppW.cvr))) {
      findViewById(2131825991).setVisibility(8);
    }
    for (;;)
    {
      if ((this.ppW != null) && (!TextUtils.isEmpty(this.ppW.poS))) {
        bdQ();
      }
      AppMethodBeat.o(43814);
      return;
      TextView localTextView;
      if ((this.ppW != null) && (!TextUtils.isEmpty(this.ppW.poT)) && (TextUtils.isEmpty(this.ppW.cvr)))
      {
        findViewById(2131825994).setVisibility(8);
        findViewById(2131825993).setVisibility(8);
        localTextView = (TextView)findViewById(2131825992);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
      else if ((this.ppW != null) && (TextUtils.isEmpty(this.ppW.poT)) && (!TextUtils.isEmpty(this.ppW.cvr)))
      {
        findViewById(2131825992).setVisibility(8);
        findViewById(2131825993).setVisibility(8);
        localTextView = (TextView)findViewById(2131825994);
        localTextView.setVisibility(0);
        localTextView.setGravity(3);
      }
    }
  }
  
  private void bdQ()
  {
    AppMethodBeat.i(43821);
    addIconOptionMenu(0, 2130839668, new MallOrderDetailInfoUI.4(this));
    AppMethodBeat.o(43821);
  }
  
  private void cav()
  {
    AppMethodBeat.i(43825);
    if ((!this.pqP) && (this.pqQ != 0))
    {
      g.RM();
      g.RK().eHt.a(new f(this.kMN, "", this.pqQ), 0);
      this.pqP = true;
    }
    AppMethodBeat.o(43825);
  }
  
  private void caw()
  {
    AppMethodBeat.i(43829);
    com.tencent.mm.ui.base.h.a(getContext(), 2131305336, 0, new MallOrderDetailInfoUI.8(this));
    AppMethodBeat.o(43829);
  }
  
  private void cs(List<MallOrderDetailObject.a> paramList)
  {
    AppMethodBeat.i(43817);
    if (paramList != null)
    {
      this.poP.addAll(paramList);
      this.pqG.notifyDataSetChanged();
    }
    AppMethodBeat.o(43817);
  }
  
  private void ct(List<ProductSectionItem> paramList)
  {
    AppMethodBeat.i(43818);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.pqL.setVisibility(8);
      this.pqM.setVisibility(8);
      this.pqN.setVisibility(8);
      AppMethodBeat.o(43818);
      return;
    }
    if (paramList.size() == 1)
    {
      this.pqN.setVisibility(8);
      paramList = (ProductSectionItem)paramList.get(0);
      if (!TextUtils.isEmpty(paramList.iconUrl))
      {
        this.pqL.setVisibility(8);
        this.pqM.setVisibility(0);
        ((TextView)this.pqM.findViewById(2131826015)).setText(paramList.name);
        ((TextView)this.pqM.findViewById(2131826023)).setText(paramList.pqC);
        ((TextView)this.pqM.findViewById(2131826024)).setText("+" + paramList.count);
        ((TextView)this.pqM.findViewById(2131826022)).setText(ProductSectionItem.Skus.cr(paramList.pqB));
        if (!TextUtils.isEmpty(paramList.iconUrl))
        {
          q((ImageView)this.pqM.findViewById(2131826014), paramList.iconUrl);
          AppMethodBeat.o(43818);
        }
      }
      else
      {
        this.pqM.setVisibility(8);
        this.pqL.setVisibility(0);
        ((TextView)this.pqL.findViewById(2131826015)).setText(paramList.name);
        if (TextUtils.isEmpty(paramList.jumpUrl))
        {
          paramList = new Rect();
          paramList.set(this.pqL.findViewById(2131826019).getPaddingLeft(), this.pqL.findViewById(2131826019).getPaddingTop(), this.pqL.findViewById(2131826019).getPaddingRight(), this.pqL.findViewById(2131826019).getPaddingBottom());
          this.pqL.findViewById(2131826019).setBackgroundResource(2130839276);
          this.pqL.findViewById(2131826019).setPadding(paramList.left, paramList.top, paramList.right, paramList.bottom);
          AppMethodBeat.o(43818);
          return;
        }
        ((TextView)this.pqL.findViewById(2131826015)).setTextColor(getResources().getColor(2131690271));
      }
      AppMethodBeat.o(43818);
      return;
    }
    this.pqL.setVisibility(8);
    this.pqM.setVisibility(8);
    this.pqN.setVisibility(0);
    if (paramList.size() == 2)
    {
      a(this.pqN.findViewById(2131826013), (ProductSectionItem)paramList.get(0));
      a(this.pqN.findViewById(2131826016), (ProductSectionItem)paramList.get(1));
      this.pqN.findViewById(2131826017).setVisibility(8);
      this.pqN.findViewById(2131826018).setVisibility(8);
      AppMethodBeat.o(43818);
      return;
    }
    if (paramList.size() == 3)
    {
      a(this.pqN.findViewById(2131826013), (ProductSectionItem)paramList.get(0));
      a(this.pqN.findViewById(2131826016), (ProductSectionItem)paramList.get(1));
      a(this.pqN.findViewById(2131826017), (ProductSectionItem)paramList.get(2));
      this.pqN.findViewById(2131826018).setVisibility(8);
      AppMethodBeat.o(43818);
      return;
    }
    if (paramList.size() >= 4)
    {
      a(this.pqN.findViewById(2131826013), (ProductSectionItem)paramList.get(0));
      a(this.pqN.findViewById(2131826016), (ProductSectionItem)paramList.get(1));
      a(this.pqN.findViewById(2131826017), (ProductSectionItem)paramList.get(2));
      a(this.pqN.findViewById(2131826018), (ProductSectionItem)paramList.get(3));
    }
    AppMethodBeat.o(43818);
  }
  
  private void i(ImageView paramImageView)
  {
    AppMethodBeat.i(43824);
    Bitmap localBitmap = com.tencent.mm.compatible.g.a.decodeResource(getResources(), 2131231629);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(d.a(localBitmap, false, 96.0F));
    }
    AppMethodBeat.o(43824);
  }
  
  private void q(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(43820);
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)) || (!e.awb(paramString)))
    {
      AppMethodBeat.o(43820);
      return;
    }
    paramImageView.setImageBitmap(x.a(new com.tencent.mm.plugin.order.c.b(paramString)));
    this.pmB.put(paramString, paramImageView);
    AppMethodBeat.o(43820);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(43828);
    finish();
    AppMethodBeat.o(43828);
  }
  
  public void finish()
  {
    AppMethodBeat.i(43826);
    cav();
    super.finish();
    AppMethodBeat.o(43826);
  }
  
  public int getLayoutId()
  {
    return 2130970097;
  }
  
  public void initView()
  {
    AppMethodBeat.i(43811);
    int i;
    if (this.pqO)
    {
      com.tencent.mm.plugin.order.a.b.cak();
      j localj = com.tencent.mm.plugin.order.a.b.can().WJ(this.kMN);
      if ((localj != null) && (!TextUtils.isEmpty(localj.pqr)) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.pqr)))
      {
        i = Integer.valueOf(localj.pqr).intValue();
        if (i != 2) {
          break label325;
        }
        setMMTitle(2131301456);
      }
    }
    for (;;)
    {
      this.pqH = findViewById(2131825982);
      this.pqI = findViewById(2131825983);
      this.pqM = findViewById(2131825984);
      this.pqN = findViewById(2131825985);
      this.pqL = findViewById(2131825986);
      this.pqJ = findViewById(2131825987);
      this.pqK = findViewById(2131825988);
      this.pqH.setOnClickListener(this.gMO);
      this.pqN.setOnClickListener(this.gMO);
      this.pqM.setOnClickListener(this.gMO);
      this.pqL.setOnClickListener(this.gMO);
      this.pqJ.setOnClickListener(this.gMO);
      findViewById(2131826001).setOnClickListener(this.gMO);
      findViewById(2131825992).setOnClickListener(this.gMO);
      findViewById(2131825994).setOnClickListener(this.gMO);
      this.mListView = ((ListView)findViewById(2131825990));
      this.pqG = new MallOrderDetailInfoUI.a(this, (byte)0);
      this.mListView.setAdapter(this.pqG);
      this.pqG.notifyDataSetChanged();
      this.mListView.setOnItemClickListener(new MallOrderDetailInfoUI.6(this));
      ary();
      AppMethodBeat.o(43811);
      return;
      i = -1;
      break;
      label325:
      if (i == 1)
      {
        setMMTitle(2131301457);
        continue;
        setMMTitle(2131301458);
      }
    }
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(43823);
    paramString = (ImageView)this.pmB.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(43823);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(43810);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.wallet_core.a.aM(this);
    if ((paramBundle != null) && ((paramBundle instanceof com.tencent.mm.plugin.order.a.a)))
    {
      paramBundle = getInput().getString("key_trans_id");
      this.kMN = paramBundle;
      if (paramBundle == null) {
        break label91;
      }
      com.tencent.mm.plugin.order.a.b.cak();
      if (com.tencent.mm.plugin.order.a.b.can().WI(paramBundle)) {
        break label91;
      }
      this.pqO = false;
      doSceneProgress(new com.tencent.mm.plugin.order.model.h(paramBundle));
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(43810);
      return;
      label91:
      com.tencent.mm.plugin.order.a.b.cak();
      if (com.tencent.mm.plugin.order.a.b.can().WI(paramBundle))
      {
        this.pqO = true;
        com.tencent.mm.plugin.order.a.b.cak();
        Object localObject2 = com.tencent.mm.plugin.order.a.b.can();
        if (TextUtils.isEmpty(paramBundle)) {
          paramBundle = (Bundle)localObject1;
        }
        do
        {
          this.ppW = paramBundle;
          if (this.ppW != null) {
            break;
          }
          caw();
          break;
          ab.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(paramBundle)));
          localObject2 = ((com.tencent.mm.plugin.order.model.c)localObject2).WJ(paramBundle);
          paramBundle = (Bundle)localObject1;
        } while (localObject2 == null);
        paramBundle = new MallOrderDetailObject();
        localObject1 = new MallOrderDetailObject.b();
        ((MallOrderDetailObject.b)localObject1).poV = ((j)localObject2).pqv;
        if ((!TextUtils.isEmpty(((j)localObject2).pqt)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).pqt))) {}
        int i;
        Object localObject3;
        MallOrderDetailObject.a locala;
        for (((MallOrderDetailObject.b)localObject1).oLs = Integer.valueOf(((j)localObject2).pqt).intValue();; ((MallOrderDetailObject.b)localObject1).oLs = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((MallOrderDetailObject.b)localObject1).thumbUrl = ((j)localObject2).pqu;
          ((MallOrderDetailObject.b)localObject1).npR = ((j)localObject2).pqw;
          ((MallOrderDetailObject.b)localObject1).poW = ((j)localObject2).cDI;
          paramBundle.poN = ((MallOrderDetailObject.b)localObject1);
          localObject1 = ((j)localObject2).pqz;
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramBundle.poP = new ArrayList();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.a)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.a)localObject3).name;
            locala.value = "";
            locala.jumpUrl = ((j.a)localObject3).jumpUrl;
            locala.kmy = false;
            paramBundle.poP.add(locala);
            i += 1;
          }
        }
        localObject1 = ((j)localObject2).pqA;
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if (paramBundle.poP == null) {
            paramBundle.poP = new ArrayList();
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject3 = (j.b)((List)localObject1).get(i);
            locala = new MallOrderDetailObject.a();
            locala.name = ((j.b)localObject3).name;
            locala.value = ((j.b)localObject3).value;
            locala.jumpUrl = ((j.b)localObject3).jumpUrl;
            locala.kmy = false;
            if (i == 0) {
              locala.kmy = true;
            }
            paramBundle.poP.add(locala);
            i += 1;
          }
        }
        paramBundle.poT = ((j)localObject2).pqy;
        paramBundle.cvr = ((j)localObject2).pqx;
        if ((!TextUtils.isEmpty(((j)localObject2).pqt)) && (com.tencent.mm.plugin.order.c.c.isNumeric(((j)localObject2).pqt))) {}
        for (paramBundle.poU = Integer.valueOf(((j)localObject2).pqt).intValue();; paramBundle.poU = ((int)(System.currentTimeMillis() / 1000L))) {
          break;
        }
      }
      ab.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
      caw();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43827);
    cav();
    super.onDestroy();
    AppMethodBeat.o(43827);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(43812);
    if (paramInt == 4)
    {
      if ((com.tencent.mm.wallet_core.a.aM(this) instanceof com.tencent.mm.plugin.order.a.a)) {
        com.tencent.mm.wallet_core.a.aJ(this);
      }
      AppMethodBeat.o(43812);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(43812);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43813);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof com.tencent.mm.plugin.order.model.h))
      {
        paramString = ((com.tencent.mm.plugin.order.model.h)paramm).ppW;
        ab.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(paramString)));
        if (paramString != null)
        {
          this.ppW = paramString;
          ary();
        }
      }
      AppMethodBeat.o(43813);
      return true;
    }
    AppMethodBeat.o(43813);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI
 * JD-Core Version:    0.7.0.1
 */