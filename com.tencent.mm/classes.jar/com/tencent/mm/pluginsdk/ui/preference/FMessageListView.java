package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.d;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.kx.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.ce;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class FMessageListView
  extends LinearLayout
{
  private a.a FfF;
  private com.tencent.mm.pluginsdk.c.a FfM;
  private k.a FfN;
  private k.a FfO;
  private FMessageListView.a FfP;
  private a FfQ;
  private TextView FfR;
  private Context context;
  private boolean dKW;
  private final LinearLayout.LayoutParams uqc;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31829);
    this.FfM = new com.tencent.mm.pluginsdk.c.a()
    {
      public final void i(com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(31822);
        if (((paramAnonymousb instanceof kx)) && (!FMessageListView.a(FMessageListView.this))) {
          FMessageListView.a(FMessageListView.this, ((kx)paramAnonymousb).dya.dln);
        }
        AppMethodBeat.o(31822);
      }
    };
    this.FfN = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(31823);
        if (!FMessageListView.a(FMessageListView.this)) {
          FMessageListView.b(FMessageListView.this, paramAnonymousString);
        }
        AppMethodBeat.o(31823);
      }
    };
    this.FfO = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(31824);
        if (!FMessageListView.a(FMessageListView.this)) {
          FMessageListView.c(FMessageListView.this, paramAnonymousString);
        }
        AppMethodBeat.o(31824);
      }
    };
    this.uqc = new LinearLayout.LayoutParams(-1, -2);
    this.dKW = false;
    this.context = paramContext;
    AppMethodBeat.o(31829);
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(31834);
    if (paramb == null)
    {
      ad.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
      AppMethodBeat.o(31834);
      return;
    }
    if (paramb.id <= 0L)
    {
      ad.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + paramb.id);
      AppMethodBeat.o(31834);
      return;
    }
    int j = getChildCount();
    int i = 1;
    Object localObject1;
    while (i < j)
    {
      localObject1 = getChildAt(i);
      if (((localObject1 instanceof a)) && (((View)localObject1).getTag() != null) && (((View)localObject1).getTag().equals(Long.valueOf(paramb.id))))
      {
        ad.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + paramb.id);
        AppMethodBeat.o(31834);
        return;
      }
      i += 1;
    }
    if (paramb.FfV != null)
    {
      if (this.FfR == null) {
        this.FfR = ((TextView)findViewById(2131298614));
      }
      this.FfR.setText(paramb.FfV);
      this.FfR.setVisibility(0);
    }
    ad.d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(j)));
    if (j == 6)
    {
      ad.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
      removeViewAt(1);
    }
    if (j == 1)
    {
      ad.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
      this.FfP = new FMessageListView.a(this.context);
      addView(this.FfP);
      this.FfQ = new a(this.context);
      this.FfQ.setContentText("");
      this.FfQ.setBtnVisibility(0);
      addView(this.FfQ, this.uqc);
      ba.aBQ();
      localObject1 = c.azp().Bf(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.o.b.lM(((aw)localObject1).field_type))) {
        break label505;
      }
      ad.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.FfP.setVisibility(0);
      this.FfQ.setVisibility(0);
    }
    Object localObject2;
    while (paramb.dNR)
    {
      localObject1 = this.context.getString(2131759478, new Object[] { paramb.hDo });
      i = 0;
      localObject2 = new a(this.context);
      ((a)localObject2).setTag(Long.valueOf(paramb.id));
      ((a)localObject2).setContentText((String)localObject1);
      ((a)localObject2).setBtnVisibility(8);
      if (i != 0) {
        ((a)localObject2).setOnLongClickListener(new View.OnLongClickListener()
        {
          public final boolean onLongClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31826);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            ad.d("MicroMsg.FMessageListView", "jacks long click digest");
            paramAnonymousView = FMessageListView.this.getContext();
            localObject = FMessageListView.this.getContext().getString(2131757150);
            h.c local1 = new h.c()
            {
              public final void lf(int paramAnonymous2Int)
              {
                AppMethodBeat.i(31825);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(31825);
                  return;
                  ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setText(FMessageListView.4.this.FfT.hDo);
                }
              }
            };
            h.a(paramAnonymousView, null, new String[] { localObject }, local1);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(31826);
            return true;
          }
        });
      }
      addView((View)localObject2, getChildCount() - 2, this.uqc);
      AppMethodBeat.o(31834);
      return;
      label505:
      ad.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.FfP.setVisibility(8);
      this.FfQ.setVisibility(8);
    }
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.hDo;
      i = 1;
      break;
      localObject2 = paramb.username;
      ba.aBQ();
      am localam = c.azp().Bf(paramb.username);
      localObject1 = localObject2;
      if (localam != null)
      {
        localObject1 = localObject2;
        if ((int)localam.gfj > 0) {
          localObject1 = localam.adv();
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31833);
    d.aMn().remove(this.FfN);
    d.aMp().remove(this.FfN);
    com.tencent.mm.pluginsdk.c.a.b(kx.class.getName(), this.FfM);
    d.aMq().remove(this.FfO);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).detach();
      }
      i += 1;
    }
    this.FfP = null;
    this.FfQ = null;
    AppMethodBeat.o(31833);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31832);
    super.onAttachedToWindow();
    d.aMn().add(this.FfN);
    com.tencent.mm.pluginsdk.c.a.a(kx.class.getName(), this.FfM);
    d.aMp().add(this.FfN);
    d.aMq().add(this.FfO);
    AppMethodBeat.o(31832);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(31831);
    super.onDetachedFromWindow();
    detach();
    AppMethodBeat.o(31831);
  }
  
  public void setFMessageArgs(a.a parama)
  {
    AppMethodBeat.i(31830);
    this.FfF = parama;
    a.setFMessageArgs(parama);
    AppMethodBeat.o(31830);
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.dKW = paramBoolean;
  }
  
  public void setReplyBtnVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31835);
    int i = getChildCount();
    ad.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + paramBoolean + ", current child count = " + i);
    if (i <= 2)
    {
      ad.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(i)));
      AppMethodBeat.o(31835);
      return;
    }
    Object localObject;
    if (this.FfP != null)
    {
      localObject = this.FfP;
      if (paramBoolean)
      {
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    }
    else if (this.FfQ != null)
    {
      localObject = this.FfQ;
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (i = j;; i = 8)
    {
      ((a)localObject).setVisibility(i);
      AppMethodBeat.o(31835);
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FMessageListView
 * JD-Core Version:    0.7.0.1
 */