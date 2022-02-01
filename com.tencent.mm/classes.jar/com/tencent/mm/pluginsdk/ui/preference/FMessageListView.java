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
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.ko.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class FMessageListView
  extends LinearLayout
{
  private com.tencent.mm.pluginsdk.c.a DAF;
  private k.a DAG;
  private k.a DAH;
  private FMessageListView.a DAI;
  private a DAJ;
  private TextView DAK;
  private a.a DAy;
  private Context context;
  private boolean dyK;
  private final LinearLayout.LayoutParams trF;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31829);
    this.DAF = new com.tencent.mm.pluginsdk.c.a()
    {
      public final void i(com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(31822);
        if (((paramAnonymousb instanceof ko)) && (!FMessageListView.a(FMessageListView.this))) {
          FMessageListView.a(FMessageListView.this, ((ko)paramAnonymousb).dmm.cZV);
        }
        AppMethodBeat.o(31822);
      }
    };
    this.DAG = new k.a()
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
    this.DAH = new k.a()
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
    this.trF = new LinearLayout.LayoutParams(-1, -2);
    this.dyK = false;
    this.context = paramContext;
    AppMethodBeat.o(31829);
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(31834);
    if (paramb == null)
    {
      ac.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
      AppMethodBeat.o(31834);
      return;
    }
    if (paramb.id <= 0L)
    {
      ac.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + paramb.id);
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
        ac.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + paramb.id);
        AppMethodBeat.o(31834);
        return;
      }
      i += 1;
    }
    if (paramb.DAO != null)
    {
      if (this.DAK == null) {
        this.DAK = ((TextView)findViewById(2131298614));
      }
      this.DAK.setText(paramb.DAO);
      this.DAK.setVisibility(0);
    }
    ac.d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(j)));
    if (j == 6)
    {
      ac.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
      removeViewAt(1);
    }
    if (j == 1)
    {
      ac.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
      this.DAI = new FMessageListView.a(this.context);
      addView(this.DAI);
      this.DAJ = new a(this.context);
      this.DAJ.setContentText("");
      this.DAJ.setBtnVisibility(0);
      addView(this.DAJ, this.trF);
      az.ayM();
      localObject1 = c.awB().aNt(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.n.b.ln(((av)localObject1).field_type))) {
        break label505;
      }
      ac.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.DAI.setVisibility(0);
      this.DAJ.setVisibility(0);
    }
    Object localObject2;
    while (paramb.dBE)
    {
      localObject1 = this.context.getString(2131759478, new Object[] { paramb.hlf });
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
            ac.d("MicroMsg.FMessageListView", "jacks long click digest");
            paramAnonymousView = FMessageListView.this.getContext();
            String str = FMessageListView.this.getContext().getString(2131757150);
            h.c local1 = new h.c()
            {
              public final void kG(int paramAnonymous2Int)
              {
                AppMethodBeat.i(31825);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(31825);
                  return;
                  ((ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard")).setText(FMessageListView.4.this.DAM.hlf);
                }
              }
            };
            h.a(paramAnonymousView, null, new String[] { str }, local1);
            AppMethodBeat.o(31826);
            return true;
          }
        });
      }
      addView((View)localObject2, getChildCount() - 2, this.trF);
      AppMethodBeat.o(31834);
      return;
      label505:
      ac.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.DAI.setVisibility(8);
      this.DAJ.setVisibility(8);
    }
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.hlf;
      i = 1;
      break;
      localObject2 = paramb.username;
      az.ayM();
      com.tencent.mm.storage.ai localai = c.awB().aNt(paramb.username);
      localObject1 = localObject2;
      if (localai != null)
      {
        localObject1 = localObject2;
        if ((int)localai.fLJ > 0) {
          localObject1 = localai.aaS();
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31833);
    d.aJd().remove(this.DAG);
    d.aJf().remove(this.DAG);
    com.tencent.mm.pluginsdk.c.a.b(ko.class.getName(), this.DAF);
    d.aJg().remove(this.DAH);
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
    this.DAI = null;
    this.DAJ = null;
    AppMethodBeat.o(31833);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31832);
    super.onAttachedToWindow();
    d.aJd().add(this.DAG);
    com.tencent.mm.pluginsdk.c.a.a(ko.class.getName(), this.DAF);
    d.aJf().add(this.DAG);
    d.aJg().add(this.DAH);
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
    this.DAy = parama;
    a.setFMessageArgs(parama);
    AppMethodBeat.o(31830);
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.dyK = paramBoolean;
  }
  
  public void setReplyBtnVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31835);
    int i = getChildCount();
    ac.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + paramBoolean + ", current child count = " + i);
    if (i <= 2)
    {
      ac.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(i)));
      AppMethodBeat.o(31835);
      return;
    }
    Object localObject;
    if (this.DAI != null)
    {
      localObject = this.DAI;
      if (paramBoolean)
      {
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    }
    else if (this.DAJ != null)
    {
      localObject = this.DAJ;
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