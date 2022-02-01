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
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.kg.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class FMessageListView
  extends LinearLayout
{
  private a.a Cih;
  private com.tencent.mm.pluginsdk.c.a Cio;
  private k.a Cip;
  private k.a Ciq;
  private FMessageListView.a Cir;
  private a Cis;
  private TextView Cit;
  private Context context;
  private boolean dAY;
  private final LinearLayout.LayoutParams sjM;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31829);
    this.Cio = new com.tencent.mm.pluginsdk.c.a()
    {
      public final void i(com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(31822);
        if (((paramAnonymousb instanceof kg)) && (!FMessageListView.a(FMessageListView.this))) {
          FMessageListView.a(FMessageListView.this, ((kg)paramAnonymousb).doD.dcx);
        }
        AppMethodBeat.o(31822);
      }
    };
    this.Cip = new k.a()
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
    this.Ciq = new k.a()
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
    this.sjM = new LinearLayout.LayoutParams(-1, -2);
    this.dAY = false;
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
    if (paramb.Cix != null)
    {
      if (this.Cit == null) {
        this.Cit = ((TextView)findViewById(2131298614));
      }
      this.Cit.setText(paramb.Cix);
      this.Cit.setVisibility(0);
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
      this.Cir = new FMessageListView.a(this.context);
      addView(this.Cir);
      this.Cis = new a(this.context);
      this.Cis.setContentText("");
      this.Cis.setBtnVisibility(0);
      addView(this.Cis, this.sjM);
      az.arV();
      localObject1 = c.apM().aHY(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.n.b.ls(((au)localObject1).field_type))) {
        break label505;
      }
      ad.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.Cir.setVisibility(0);
      this.Cis.setVisibility(0);
    }
    Object localObject2;
    while (paramb.dDS)
    {
      localObject1 = this.context.getString(2131759478, new Object[] { paramb.gKF });
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
            ad.d("MicroMsg.FMessageListView", "jacks long click digest");
            paramAnonymousView = FMessageListView.this.getContext();
            String str = FMessageListView.this.getContext().getString(2131757150);
            h.c local1 = new h.c()
            {
              public final void kM(int paramAnonymous2Int)
              {
                AppMethodBeat.i(31825);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(31825);
                  return;
                  ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setText(FMessageListView.4.this.Civ.gKF);
                }
              }
            };
            h.a(paramAnonymousView, null, new String[] { str }, local1);
            AppMethodBeat.o(31826);
            return true;
          }
        });
      }
      addView((View)localObject2, getChildCount() - 2, this.sjM);
      AppMethodBeat.o(31834);
      return;
      label505:
      ad.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.Cir.setVisibility(8);
      this.Cis.setVisibility(8);
    }
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.gKF;
      i = 1;
      break;
      localObject2 = paramb.username;
      az.arV();
      af localaf = c.apM().aHY(paramb.username);
      localObject1 = localObject2;
      if (localaf != null)
      {
        localObject1 = localObject2;
        if ((int)localaf.fId > 0) {
          localObject1 = localaf.ZX();
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31833);
    d.aCn().remove(this.Cip);
    d.aCp().remove(this.Cip);
    com.tencent.mm.pluginsdk.c.a.b(kg.class.getName(), this.Cio);
    d.aCq().remove(this.Ciq);
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
    this.Cir = null;
    this.Cis = null;
    AppMethodBeat.o(31833);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31832);
    super.onAttachedToWindow();
    d.aCn().add(this.Cip);
    com.tencent.mm.pluginsdk.c.a.a(kg.class.getName(), this.Cio);
    d.aCp().add(this.Cip);
    d.aCq().add(this.Ciq);
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
    this.Cih = parama;
    a.setFMessageArgs(parama);
    AppMethodBeat.o(31830);
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.dAY = paramBoolean;
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
    if (this.Cir != null)
    {
      localObject = this.Cir;
      if (paramBoolean)
      {
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    }
    else if (this.Cis != null)
    {
      localObject = this.Cis;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FMessageListView
 * JD-Core Version:    0.7.0.1
 */