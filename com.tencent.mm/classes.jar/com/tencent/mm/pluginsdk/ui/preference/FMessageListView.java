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
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class FMessageListView
  extends LinearLayout
{
  private a.a Fyd;
  private com.tencent.mm.pluginsdk.c.a Fyk;
  private k.a Fyl;
  private k.a Fym;
  private FMessageListView.a Fyn;
  private a Fyo;
  private TextView Fyp;
  private Context context;
  private boolean dMl;
  private final LinearLayout.LayoutParams uBy;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31829);
    this.Fyk = new com.tencent.mm.pluginsdk.c.a()
    {
      public final void i(com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(31822);
        if (((paramAnonymousb instanceof ky)) && (!FMessageListView.a(FMessageListView.this))) {
          FMessageListView.a(FMessageListView.this, ((ky)paramAnonymousb).dzf.dmp);
        }
        AppMethodBeat.o(31822);
      }
    };
    this.Fyl = new k.a()
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
    this.Fym = new k.a()
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
    this.uBy = new LinearLayout.LayoutParams(-1, -2);
    this.dMl = false;
    this.context = paramContext;
    AppMethodBeat.o(31829);
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(31834);
    if (paramb == null)
    {
      ae.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
      AppMethodBeat.o(31834);
      return;
    }
    if (paramb.id <= 0L)
    {
      ae.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + paramb.id);
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
        ae.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + paramb.id);
        AppMethodBeat.o(31834);
        return;
      }
      i += 1;
    }
    if (paramb.Fyt != null)
    {
      if (this.Fyp == null) {
        this.Fyp = ((TextView)findViewById(2131298614));
      }
      this.Fyp.setText(paramb.Fyt);
      this.Fyp.setVisibility(0);
    }
    ae.d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(j)));
    if (j == 6)
    {
      ae.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
      removeViewAt(1);
    }
    if (j == 1)
    {
      ae.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
      this.Fyn = new FMessageListView.a(this.context);
      addView(this.Fyn);
      this.Fyo = new a(this.context);
      this.Fyo.setContentText("");
      this.Fyo.setBtnVisibility(0);
      addView(this.Fyo, this.uBy);
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azF().BH(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.contact.c.lO(((aw)localObject1).field_type))) {
        break label505;
      }
      ae.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.Fyn.setVisibility(0);
      this.Fyo.setVisibility(0);
    }
    Object localObject2;
    while (paramb.dPh)
    {
      localObject1 = this.context.getString(2131759478, new Object[] { paramb.hGg });
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            ae.d("MicroMsg.FMessageListView", "jacks long click digest");
            paramAnonymousView = FMessageListView.this.getContext();
            localObject = FMessageListView.this.getContext().getString(2131757150);
            h.c local1 = new h.c()
            {
              public final void lh(int paramAnonymous2Int)
              {
                AppMethodBeat.i(31825);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(31825);
                  return;
                  ((ClipboardManager)ak.getContext().getSystemService("clipboard")).setText(FMessageListView.4.this.Fyr.hGg);
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
      addView((View)localObject2, getChildCount() - 2, this.uBy);
      AppMethodBeat.o(31834);
      return;
      label505:
      ae.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.Fyn.setVisibility(8);
      this.Fyo.setVisibility(8);
    }
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.hGg;
      i = 1;
      break;
      localObject2 = paramb.username;
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(paramb.username);
      localObject1 = localObject2;
      if (localan != null)
      {
        localObject1 = localObject2;
        if ((int)localan.ght > 0) {
          localObject1 = localan.adG();
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31833);
    d.aML().remove(this.Fyl);
    d.aMN().remove(this.Fyl);
    com.tencent.mm.pluginsdk.c.a.b(ky.class.getName(), this.Fyk);
    d.aMO().remove(this.Fym);
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
    this.Fyn = null;
    this.Fyo = null;
    AppMethodBeat.o(31833);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31832);
    super.onAttachedToWindow();
    d.aML().add(this.Fyl);
    com.tencent.mm.pluginsdk.c.a.a(ky.class.getName(), this.Fyk);
    d.aMN().add(this.Fyl);
    d.aMO().add(this.Fym);
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
    this.Fyd = parama;
    a.setFMessageArgs(parama);
    AppMethodBeat.o(31830);
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.dMl = paramBoolean;
  }
  
  public void setReplyBtnVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31835);
    int i = getChildCount();
    ae.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + paramBoolean + ", current child count = " + i);
    if (i <= 2)
    {
      ae.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(i)));
      AppMethodBeat.o(31835);
      return;
    }
    Object localObject;
    if (this.Fyn != null)
    {
      localObject = this.Fyn;
      if (paramBoolean)
      {
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    }
    else if (this.Fyo != null)
    {
      localObject = this.Fyo;
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