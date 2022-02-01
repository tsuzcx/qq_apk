package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.lo.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;

public class FMessageListView
  extends LinearLayout
{
  private a.a KoZ;
  private com.tencent.mm.pluginsdk.c.a Kpg;
  private MStorage.IOnStorageChange Kph;
  private MStorage.IOnStorageChange Kpi;
  private FMessageListView.a Kpj;
  private a Kpk;
  private TextView Kpl;
  private Context context;
  private boolean eea;
  private final LinearLayout.LayoutParams xTw;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31829);
    this.Kpg = new com.tencent.mm.pluginsdk.c.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(31822);
        if (((paramAnonymousIEvent instanceof lo)) && (!FMessageListView.a(FMessageListView.this))) {
          FMessageListView.a(FMessageListView.this, ((lo)paramAnonymousIEvent).dQS.event);
        }
        AppMethodBeat.o(31822);
      }
    };
    this.Kph = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(31823);
        if (!FMessageListView.a(FMessageListView.this)) {
          FMessageListView.b(FMessageListView.this, paramAnonymousString);
        }
        AppMethodBeat.o(31823);
      }
    };
    this.Kpi = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(31824);
        if (!FMessageListView.a(FMessageListView.this)) {
          FMessageListView.c(FMessageListView.this, paramAnonymousString);
        }
        AppMethodBeat.o(31824);
      }
    };
    this.xTw = new LinearLayout.LayoutParams(-1, -2);
    this.eea = false;
    this.context = paramContext;
    AppMethodBeat.o(31829);
  }
  
  public final void a(final b paramb)
  {
    AppMethodBeat.i(31834);
    if (paramb == null)
    {
      Log.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
      AppMethodBeat.o(31834);
      return;
    }
    if (paramb.id <= 0L)
    {
      Log.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + paramb.id);
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
        Log.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + paramb.id);
        AppMethodBeat.o(31834);
        return;
      }
      i += 1;
    }
    if (paramb.Kpp != null)
    {
      if (this.Kpl == null) {
        this.Kpl = ((TextView)findViewById(2131299051));
      }
      this.Kpl.setText(paramb.Kpp);
      this.Kpl.setVisibility(0);
    }
    Log.d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(j)));
    if (j == 6)
    {
      Log.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
      removeViewAt(1);
    }
    if (j == 1)
    {
      Log.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
      this.Kpj = new FMessageListView.a(this.context);
      addView(this.Kpj);
      this.Kpk = new a(this.context);
      this.Kpk.setContentText("");
      this.Kpk.setBtnVisibility(0);
      addView(this.Kpk, this.xTw);
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSN().Kn(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.contact.c.oR(((ax)localObject1).field_type))) {
        break label505;
      }
      Log.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.Kpj.setVisibility(0);
      this.Kpk.setVisibility(0);
    }
    Object localObject2;
    while (paramb.ehd)
    {
      localObject1 = this.context.getString(2131760793, new Object[] { paramb.iAq });
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            Log.d("MicroMsg.FMessageListView", "jacks long click digest");
            paramAnonymousView = FMessageListView.this.getContext();
            localObject = FMessageListView.this.getContext().getString(2131757354);
            h.d local1 = new h.d()
            {
              public final void oj(int paramAnonymous2Int)
              {
                AppMethodBeat.i(31825);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(31825);
                  return;
                  ClipboardHelper.setText(FMessageListView.4.this.Kpn.iAq);
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
      addView((View)localObject2, getChildCount() - 2, this.xTw);
      AppMethodBeat.o(31834);
      return;
      label505:
      Log.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.Kpj.setVisibility(8);
      this.Kpk.setVisibility(8);
    }
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.iAq;
      i = 1;
      break;
      localObject2 = paramb.username;
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(paramb.username);
      localObject1 = localObject2;
      if (localas != null)
      {
        localObject1 = localObject2;
        if ((int)localas.gMZ > 0) {
          localObject1 = localas.arJ();
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31833);
    d.bgM().remove(this.Kph);
    d.bgO().remove(this.Kph);
    com.tencent.mm.pluginsdk.c.a.b(lo.class.getName(), this.Kpg);
    d.bgP().remove(this.Kpi);
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
    this.Kpj = null;
    this.Kpk = null;
    AppMethodBeat.o(31833);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31832);
    super.onAttachedToWindow();
    d.bgM().add(this.Kph);
    com.tencent.mm.pluginsdk.c.a.a(lo.class.getName(), this.Kpg);
    d.bgO().add(this.Kph);
    d.bgP().add(this.Kpi);
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
    this.KoZ = parama;
    a.setFMessageArgs(parama);
    AppMethodBeat.o(31830);
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.eea = paramBoolean;
  }
  
  public void setReplyBtnVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(31835);
    int i = getChildCount();
    Log.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + paramBoolean + ", current child count = " + i);
    if (i <= 2)
    {
      Log.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(i)));
      AppMethodBeat.o(31835);
      return;
    }
    Object localObject;
    if (this.Kpj != null)
    {
      localObject = this.Kpj;
      if (paramBoolean)
      {
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    }
    else if (this.Kpk != null)
    {
      localObject = this.Kpk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.FMessageListView
 * JD-Core Version:    0.7.0.1
 */