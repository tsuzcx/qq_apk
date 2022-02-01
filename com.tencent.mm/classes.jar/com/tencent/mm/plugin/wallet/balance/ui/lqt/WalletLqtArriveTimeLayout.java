package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtArriveTimeLayout
  extends LinearLayout
{
  private View.OnClickListener olC;
  List<cif> zHN;
  List<WeakReference<b>> zHO;
  cif zHP;
  private WalletLqtArriveTimeLayout.a zHQ;
  boolean zHR;
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(68743);
    this.zHN = new ArrayList();
    this.zHO = new ArrayList();
    this.zHR = false;
    this.olC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.acV.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (cif)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ad.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.kEu.getText() });
          AppMethodBeat.o(68741);
          return;
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, null);
        }
      }
    };
    AppMethodBeat.o(68743);
  }
  
  public WalletLqtArriveTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(68744);
    this.zHN = new ArrayList();
    this.zHO = new ArrayList();
    this.zHR = false;
    this.olC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68741);
        WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this);
        paramAnonymousView = (WalletLqtArriveTimeLayout.b)paramAnonymousView.getTag();
        if ((WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this) != null) && (WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).size() > paramAnonymousView.index))
        {
          paramAnonymousView.acV.setChecked(true);
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, (cif)WalletLqtArriveTimeLayout.b(WalletLqtArriveTimeLayout.this).get(paramAnonymousView.index));
        }
        for (;;)
        {
          WalletLqtArriveTimeLayout.c(WalletLqtArriveTimeLayout.this);
          ad.i("MicroMsg.WalletLqtArriveTimeLayout", "click item: %s, %s", new Object[] { Integer.valueOf(paramAnonymousView.index), paramAnonymousView.kEu.getText() });
          AppMethodBeat.o(68741);
          return;
          WalletLqtArriveTimeLayout.a(WalletLqtArriveTimeLayout.this, null);
        }
      }
    };
    AppMethodBeat.o(68744);
  }
  
  private static void a(b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(68747);
    paramb.acV.setEnabled(paramBoolean);
    paramb.kEu.setEnabled(paramBoolean);
    paramb.kFd.setEnabled(paramBoolean);
    paramb.hIZ.setEnabled(paramBoolean);
    AppMethodBeat.o(68747);
  }
  
  private void dZk()
  {
    AppMethodBeat.i(68745);
    if (this.zHQ != null) {
      this.zHQ.dZl();
    }
    AppMethodBeat.o(68745);
  }
  
  public final void ats(String paramString)
  {
    AppMethodBeat.i(68748);
    ad.i("MicroMsg.WalletLqtArriveTimeLayout", "input money: %s", new Object[] { paramString });
    if ((this.zHN == null) || (this.zHN.isEmpty()))
    {
      AppMethodBeat.o(68748);
      return;
    }
    this.zHP = null;
    Object localObject1 = this.zHO.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null)
      {
        ((b)((WeakReference)localObject2).get()).acV.setEnabled(true);
        ((b)((WeakReference)localObject2).get()).acV.setChecked(false);
      }
    }
    int j = e.lM(paramString, "100");
    paramString = this.zHN.iterator();
    int i = 0;
    if (paramString.hasNext())
    {
      localObject1 = (cif)paramString.next();
      if ((((cif)localObject1).EdH >= 0) && (j > ((cif)localObject1).EdH))
      {
        ad.i("MicroMsg.WalletLqtArriveTimeLayout", "disable item: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((cif)localObject1).EdH) });
        localObject1 = (b)((WeakReference)this.zHO.get(i)).get();
        if (localObject1 != null)
        {
          ((b)localObject1).acV.setChecked(false);
          a((b)localObject1, false);
          this.zHP = null;
          dZk();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject2 = (b)((WeakReference)this.zHO.get(i)).get();
        if (localObject2 != null)
        {
          a((b)localObject2, true);
          if (this.zHP == null)
          {
            ad.i("MicroMsg.WalletLqtArriveTimeLayout", "auto select type: %s", new Object[] { Integer.valueOf(((cif)localObject1).DYb) });
            ((b)localObject2).acV.setChecked(true);
            this.zHP = ((cif)localObject1);
            dZk();
            if (i > 0) {
              ((b)localObject2).kEu.setTextColor(aj.getContext().getResources().getColor(2131100464));
            } else {
              ((b)localObject2).dZm();
            }
          }
          else
          {
            ((b)localObject2).dZm();
          }
        }
      }
    }
    AppMethodBeat.o(68748);
  }
  
  public List<cif> getRedeemTypeList()
  {
    return this.zHN;
  }
  
  public cif getSelectRedeemType()
  {
    return this.zHP;
  }
  
  public final void n(List<cif> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(182505);
    this.zHR = true;
    this.zHN.clear();
    this.zHN.addAll(paramList);
    this.zHO.clear();
    removeAllViews();
    setVisibility(0);
    if ((this.zHN != null) && (!this.zHN.isEmpty()))
    {
      paramList = this.zHN.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        cif localcif = (cif)paramList.next();
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(2131495975, this, false);
        b localb = new b((byte)0);
        localb.hIZ = localLinearLayout;
        localb.kEu = ((TextView)localLinearLayout.findViewById(2131301695));
        localb.kFd = ((TextView)localLinearLayout.findViewById(2131301694));
        localb.acV = ((RadioButton)localLinearLayout.findViewById(2131301697));
        localb.kEu.setText(localcif.EdF);
        if (!bt.isNullOrNil(localcif.EdG))
        {
          localb.kFd.setText(localcif.EdG);
          label217:
          if (this.zHP != null) {
            ad.d("MicroMsg.WalletLqtArriveTimeLayout", "arrive wording: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.zHP.DYb), Integer.valueOf(localcif.DYb) });
          }
          if (!paramBoolean) {
            break label369;
          }
          if ((this.zHP != null) && (this.zHP.DYb == localcif.DYb)) {
            localb.acV.setChecked(true);
          }
        }
        for (;;)
        {
          localb.index = i;
          localLinearLayout.setTag(localb);
          localLinearLayout.setOnClickListener(this.olC);
          this.zHO.add(new WeakReference(localb));
          addView(localLinearLayout);
          i += 1;
          break;
          localb.kFd.setVisibility(8);
          break label217;
          label369:
          if (i == 0)
          {
            localb.acV.setChecked(true);
            this.zHP = localcif;
          }
        }
      }
    }
    AppMethodBeat.o(182505);
  }
  
  public void setCallback(WalletLqtArriveTimeLayout.a parama)
  {
    this.zHQ = parama;
  }
  
  static final class b
  {
    public RadioButton acV;
    public View hIZ;
    public int index;
    public TextView kEu;
    public TextView kFd;
    
    public final void dZm()
    {
      AppMethodBeat.i(68742);
      this.kEu.setTextColor(aj.getContext().getResources().getColorStateList(2131101117));
      AppMethodBeat.o(68742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout
 * JD-Core Version:    0.7.0.1
 */