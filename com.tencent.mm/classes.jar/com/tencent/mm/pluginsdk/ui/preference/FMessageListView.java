package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.bh.d;
import com.tencent.mm.h.a.iv;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bu;

public class FMessageListView
  extends LinearLayout
{
  private boolean cbz = false;
  private Context context;
  private final LinearLayout.LayoutParams lcr = new LinearLayout.LayoutParams(-1, -2);
  private a.a sib;
  private com.tencent.mm.pluginsdk.c.a sij = new FMessageListView.1(this);
  private j.a sik = new FMessageListView.2(this);
  private j.a sil = new FMessageListView.3(this);
  private FMessageListView.a sim;
  private a sin;
  private TextView sio;
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FMessageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    d.RX().c(this.sik);
    com.tencent.mm.pluginsdk.c.a.a(iv.class.getName(), this.sij);
    d.Sa().c(this.sil);
  }
  
  public final void a(b paramb)
  {
    if (paramb == null)
    {
      y.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
      return;
    }
    if (paramb.id <= 0L)
    {
      y.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + paramb.id);
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
        y.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + paramb.id);
        return;
      }
      i += 1;
    }
    if (paramb.sis != null)
    {
      if (this.sio == null) {
        this.sio = ((TextView)findViewById(R.h.contact_info_fmessage_listview_safewarning_tv));
      }
      this.sio.setText(paramb.sis);
      this.sio.setVisibility(0);
    }
    y.d("MicroMsg.FMessageListView", "addItem, current child count = " + j);
    if (j == 6)
    {
      y.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
      removeViewAt(1);
    }
    if (j == 1)
    {
      y.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
      this.sim = new FMessageListView.a(this.context);
      addView(this.sim);
      this.sin = new a(this.context);
      this.sin.setContentText("");
      this.sin.setBtnVisibility(0);
      addView(this.sin, this.lcr);
      au.Hx();
      localObject1 = c.Fw().abl(paramb.username);
      if ((localObject1 != null) && (com.tencent.mm.n.a.gR(((ao)localObject1).field_type))) {
        break label482;
      }
      y.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + paramb.username);
      this.sim.setVisibility(0);
      this.sin.setVisibility(0);
    }
    Object localObject2;
    while (paramb.ceg)
    {
      localObject1 = this.context.getString(R.l.fmessage_reply, new Object[] { paramb.dTF });
      i = 0;
      localObject2 = new a(this.context);
      ((a)localObject2).setTag(Long.valueOf(paramb.id));
      ((a)localObject2).setContentText((String)localObject1);
      ((a)localObject2).setBtnVisibility(8);
      if (i != 0) {
        ((a)localObject2).setOnLongClickListener(new FMessageListView.4(this, paramb));
      }
      addView((View)localObject2, getChildCount() - 2, this.lcr);
      return;
      label482:
      y.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + paramb.username);
      this.sim.setVisibility(8);
      this.sin.setVisibility(8);
    }
    if ((paramb.nickname != null) && (paramb.nickname.length() > 0)) {
      localObject1 = paramb.nickname;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + ": " + paramb.dTF;
      i = 1;
      break;
      localObject2 = paramb.username;
      au.Hx();
      ad localad = c.Fw().abl(paramb.username);
      localObject1 = localObject2;
      if (localad != null)
      {
        localObject1 = localObject2;
        if ((int)localad.dBe > 0) {
          localObject1 = localad.Bq();
        }
      }
    }
  }
  
  public final void detach()
  {
    d.RX().d(this.sik);
    com.tencent.mm.pluginsdk.c.a.b(iv.class.getName(), this.sij);
    d.Sa().d(this.sil);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof a))
      {
        localObject = (a)localObject;
        au.Dk().b(30, (f)localObject);
        if ((((a)localObject).tipDialog != null) && (((a)localObject).tipDialog.isShowing())) {
          ((a)localObject).tipDialog.dismiss();
        }
      }
      i += 1;
    }
    this.sim = null;
    this.sin = null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    detach();
  }
  
  public void setFMessageArgs(a.a parama)
  {
    this.sib = parama;
    a.setFMessageArgs(parama);
  }
  
  public void setHide(boolean paramBoolean)
  {
    this.cbz = paramBoolean;
  }
  
  public void setReplyBtnVisible(boolean paramBoolean)
  {
    int j = 0;
    int i = getChildCount();
    y.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + paramBoolean + ", current child count = " + i);
    if (i <= 2) {
      y.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = " + i);
    }
    do
    {
      return;
      if (this.sim != null)
      {
        localObject = this.sim;
        if (!paramBoolean) {
          break;
        }
        i = 0;
        ((FMessageListView.a)localObject).setVisibility(i);
      }
    } while (this.sin == null);
    Object localObject = this.sin;
    if (paramBoolean) {}
    for (i = j;; i = 8)
    {
      ((a)localObject).setVisibility(i);
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