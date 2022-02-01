package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.nl;
import com.tencent.mm.autogen.a.nl.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;

public class FMessageListView
  extends LinearLayout
{
  private final LinearLayout.LayoutParams IRX;
  private a.b MYn;
  private a.a Ymg;
  private IListenerMStorage Ymn;
  private MStorage.IOnStorageChange Ymo;
  private MStorage.IOnStorageChange Ymp;
  private FMessageListView.a Ymq;
  private a Ymr;
  private TextView Yms;
  private boolean Ymt;
  private Context context;
  private boolean iep;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31829);
    this.Ymn = new IListenerMStorage()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(31822);
        if (((paramAnonymousIEvent instanceof nl)) && (!FMessageListView.a(FMessageListView.this))) {
          FMessageListView.a(FMessageListView.this, ((nl)paramAnonymousIEvent).hPO.event);
        }
        AppMethodBeat.o(31822);
      }
    };
    this.Ymo = new MStorage.IOnStorageChange()
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
    this.Ymp = new MStorage.IOnStorageChange()
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
    this.IRX = new LinearLayout.LayoutParams(-1, -2);
    this.iep = false;
    this.Ymt = false;
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
    if (paramb.Ymx != null)
    {
      if (this.Yms == null) {
        this.Yms = ((TextView)findViewById(R.h.contact_info_fmessage_listview_safewarning_tv));
      }
      this.Yms.setText(paramb.Ymx);
      this.Yms.setVisibility(0);
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
      this.Ymq = new FMessageListView.a(this.context);
      addView(this.Ymq);
      this.Ymr = new a(this.context);
      this.Ymr.setGotoSayHiCallBack(this.MYn);
      this.Ymr.setContentText("");
      Log.i("MicroMsg.FMessageListView", "addItem, isForceHideReply = %s.", new Object[] { Boolean.valueOf(this.Ymt) });
      if (!this.Ymt) {
        break label546;
      }
      this.Ymr.setBtnVisibility(8);
      addView(this.Ymr, this.IRX);
      bh.bCz();
      localObject1 = c.bzA().JE(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.contact.d.rs(((az)localObject1).field_type))) {
        break label557;
      }
      Log.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.Ymq.setVisibility(0);
      this.Ymr.setVisibility(0);
    }
    Object localObject2;
    for (;;)
    {
      if (!paramb.ihD) {
        break label603;
      }
      localObject1 = this.context.getString(R.l.gIi, new Object[] { paramb.nUO });
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
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            Log.d("MicroMsg.FMessageListView", "jacks long click digest");
            paramAnonymousView = FMessageListView.this.getContext();
            localObject = FMessageListView.this.getContext().getString(R.l.gxg);
            k.d local1 = new k.d()
            {
              public final void qz(int paramAnonymous2Int)
              {
                AppMethodBeat.i(31825);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(31825);
                  return;
                  ClipboardHelper.setText(FMessageListView.4.this.Ymv.nUO);
                }
              }
            };
            k.a(paramAnonymousView, null, new String[] { localObject }, local1);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(31826);
            return true;
          }
        });
      }
      addView((View)localObject2, getChildCount() - 2, this.IRX);
      AppMethodBeat.o(31834);
      return;
      label546:
      this.Ymr.setBtnVisibility(0);
      break;
      label557:
      Log.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.Ymq.setVisibility(8);
      this.Ymr.setVisibility(8);
    }
    label603:
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.nUO;
      i = 1;
      break;
      localObject2 = paramb.username;
      bh.bCz();
      au localau = c.bzA().JE(paramb.username);
      localObject1 = localObject2;
      if (localau != null)
      {
        localObject1 = localObject2;
        if ((int)localau.maN > 0) {
          localObject1 = localau.aSV();
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(31833);
    com.tencent.mm.modelverify.d.bNH().remove(this.Ymo);
    com.tencent.mm.modelverify.d.bNJ().remove(this.Ymo);
    IListenerMStorage.b(nl.class.getName(), this.Ymn);
    com.tencent.mm.modelverify.d.bNK().remove(this.Ymp);
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
    this.Ymq = null;
    this.Ymr = null;
    AppMethodBeat.o(31833);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(31832);
    super.onAttachedToWindow();
    com.tencent.mm.modelverify.d.bNH().add(this.Ymo);
    IListenerMStorage.a(nl.class.getName(), this.Ymn);
    com.tencent.mm.modelverify.d.bNJ().add(this.Ymo);
    com.tencent.mm.modelverify.d.bNK().add(this.Ymp);
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
    this.Ymg = parama;
    a.setFMessageArgs(parama);
    AppMethodBeat.o(31830);
  }
  
  public void setForceHideReply(boolean paramBoolean)
  {
    AppMethodBeat.i(245121);
    this.Ymt = paramBoolean;
    Log.i("MicroMsg.FMessageListView", "setForceHideReply = %s, stack = ", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
    AppMethodBeat.o(245121);
  }
  
  public void setGotoSayHiCallBack(a.b paramb)
  {
    this.MYn = paramb;
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.iep = paramBoolean;
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
    if (this.Ymq != null)
    {
      localObject = this.Ymq;
      if (paramBoolean)
      {
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    }
    else if (this.Ymr != null)
    {
      localObject = this.Ymr;
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