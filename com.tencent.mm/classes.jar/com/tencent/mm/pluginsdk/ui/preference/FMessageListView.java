package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bu;

public class FMessageListView
  extends LinearLayout
{
  private boolean cKc;
  private Context context;
  private final LinearLayout.LayoutParams nAm;
  private a.a waB;
  private com.tencent.mm.pluginsdk.c.a waI;
  private k.a waJ;
  private k.a waK;
  private FMessageListView.a waL;
  private a waM;
  private TextView waN;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(28043);
    this.waI = new FMessageListView.1(this);
    this.waJ = new FMessageListView.2(this);
    this.waK = new FMessageListView.3(this);
    this.nAm = new LinearLayout.LayoutParams(-1, -2);
    this.cKc = false;
    this.context = paramContext;
    AppMethodBeat.o(28043);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(28048);
    if (paramb == null)
    {
      ab.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
      AppMethodBeat.o(28048);
      return;
    }
    if (paramb.id <= 0L)
    {
      ab.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + paramb.id);
      AppMethodBeat.o(28048);
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
        ab.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + paramb.id);
        AppMethodBeat.o(28048);
        return;
      }
      i += 1;
    }
    if (paramb.waR != null)
    {
      if (this.waN == null) {
        this.waN = ((TextView)findViewById(2131823133));
      }
      this.waN.setText(paramb.waR);
      this.waN.setVisibility(0);
    }
    ab.d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(j)));
    if (j == 6)
    {
      ab.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
      removeViewAt(1);
    }
    if (j == 1)
    {
      ab.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
      this.waL = new FMessageListView.a(this.context);
      addView(this.waL);
      this.waM = new a(this.context);
      this.waM.setContentText("");
      this.waM.setBtnVisibility(0);
      addView(this.waM, this.nAm);
      aw.aaz();
      localObject1 = c.YA().arw(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.n.a.je(((aq)localObject1).field_type))) {
        break label505;
      }
      ab.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.waL.setVisibility(0);
      this.waM.setVisibility(0);
    }
    Object localObject2;
    while (paramb.cMU)
    {
      localObject1 = this.context.getString(2131300012, new Object[] { paramb.fjL });
      i = 0;
      localObject2 = new a(this.context);
      ((a)localObject2).setTag(Long.valueOf(paramb.id));
      ((a)localObject2).setContentText((String)localObject1);
      ((a)localObject2).setBtnVisibility(8);
      if (i != 0) {
        ((a)localObject2).setOnLongClickListener(new FMessageListView.4(this, paramb));
      }
      addView((View)localObject2, getChildCount() - 2, this.nAm);
      AppMethodBeat.o(28048);
      return;
      label505:
      ab.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.waL.setVisibility(8);
      this.waM.setVisibility(8);
    }
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.fjL;
      i = 1;
      break;
      localObject2 = paramb.username;
      aw.aaz();
      ad localad = c.YA().arw(paramb.username);
      localObject1 = localObject2;
      if (localad != null)
      {
        localObject1 = localObject2;
        if ((int)localad.euF > 0) {
          localObject1 = localad.Of();
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(28047);
    d.alh().remove(this.waJ);
    d.alj().remove(this.waJ);
    com.tencent.mm.pluginsdk.c.a.b(je.class.getName(), this.waI);
    d.alk().remove(this.waK);
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
    this.waL = null;
    this.waM = null;
    AppMethodBeat.o(28047);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(28046);
    super.onAttachedToWindow();
    d.alh().add(this.waJ);
    com.tencent.mm.pluginsdk.c.a.a(je.class.getName(), this.waI);
    d.alj().add(this.waJ);
    d.alk().add(this.waK);
    AppMethodBeat.o(28046);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(28045);
    super.onDetachedFromWindow();
    detach();
    AppMethodBeat.o(28045);
  }
  
  public void setFMessageArgs(a.a parama)
  {
    AppMethodBeat.i(28044);
    this.waB = parama;
    a.setFMessageArgs(parama);
    AppMethodBeat.o(28044);
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.cKc = paramBoolean;
  }
  
  public void setReplyBtnVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(28049);
    int i = getChildCount();
    ab.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + paramBoolean + ", current child count = " + i);
    if (i <= 2)
    {
      ab.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(i)));
      AppMethodBeat.o(28049);
      return;
    }
    Object localObject;
    if (this.waL != null)
    {
      localObject = this.waL;
      if (paramBoolean)
      {
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    }
    else if (this.waM != null)
    {
      localObject = this.waM;
      if (!paramBoolean) {
        break label135;
      }
    }
    label135:
    for (i = j;; i = 8)
    {
      ((a)localObject).setVisibility(i);
      AppMethodBeat.o(28049);
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