package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.t;
import java.util.List;

public final class k
  extends RelativeLayout
{
  public static Boolean AcM = Boolean.TRUE;
  private View AcN;
  k.a AcO;
  private boolean AcP;
  private Context context;
  private View gcq;
  private boolean isVisible;
  private final ap zDw;
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33718);
    this.context = null;
    this.gcq = null;
    this.AcN = null;
    this.isVisible = true;
    this.zDw = new ap(new k.1(this), true);
    this.AcO = new k.2(this);
    this.AcP = false;
    this.context = paramContext;
    com.tencent.mm.bi.d.ali().add(this.AcO);
    dLR();
    init();
    AppMethodBeat.o(33718);
  }
  
  private void a(av paramav)
  {
    AppMethodBeat.i(33721);
    if (this.context == null)
    {
      ab.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
      AppMethodBeat.o(33721);
      return;
    }
    TextView localTextView;
    Object localObject;
    boolean bool;
    if (a.gt(this.context))
    {
      this.gcq = View.inflate(this.context, 2130969609, this);
      ((TextView)this.gcq.findViewById(2131824202)).setText(j.b(this.context, paramav.field_displayName));
      localTextView = (TextView)this.gcq.findViewById(2131824203);
      localObject = com.tencent.mm.bi.d.alh().asd(paramav.field_talker);
      Context localContext = this.context;
      int i = ((ax)localObject).field_type;
      int j = paramav.field_addScene;
      String str = ((ax)localObject).field_msgContent;
      if (((ax)localObject).dxA()) {
        break label240;
      }
      bool = true;
      label136:
      localObject = b.a(localContext, i, j, str, bool);
      if (!ah.isNullOrNil((String)localObject)) {
        break label246;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.AcN = this.gcq.findViewById(2131824195);
      this.gcq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33716);
          ab.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
          com.tencent.mm.model.aw.aaz();
          c.Ru().set(143618, Integer.valueOf(0));
          com.tencent.mm.bq.d.b(k.d(k.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          AppMethodBeat.o(33716);
        }
      });
      a.b.c((ImageView)((MaskLayout)this.gcq.findViewById(2131824197)).getContentView(), paramav.field_talker);
      AppMethodBeat.o(33721);
      return;
      this.gcq = View.inflate(this.context, 2130969608, this);
      break;
      label240:
      bool = false;
      break label136;
      label246:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void dLQ()
  {
    AppMethodBeat.i(33720);
    if (this.context == null)
    {
      ab.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(33720);
      return;
    }
    this.gcq = View.inflate(this.context, 2130969606, this);
    this.AcN = this.gcq.findViewById(2131824196);
    Object localObject = this.AcN.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.ap(this.context, 2131427549) * a.gs(this.context)));
    this.AcN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.gcq.setOnClickListener(new k.4(this));
    localObject = (MaskLayout)this.gcq.findViewById(2131824197);
    o.acQ();
    Bitmap localBitmap = com.tencent.mm.ah.d.rc("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(33720);
  }
  
  private static void dLR()
  {
    AppMethodBeat.i(33724);
    int i = com.tencent.mm.bi.d.ali().dxy();
    ab.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      com.tencent.mm.model.aw.aaz();
      c.Ru().set(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(33724);
  }
  
  public static void dLS()
  {
    AppMethodBeat.i(33725);
    com.tencent.mm.model.aw.aaz();
    if (c.Yw())
    {
      com.tencent.mm.model.aw.aaz();
      if (c.Ru().getInt(143618, 0) > 0) {
        aa.ab("fmessage", 2);
      }
    }
    com.tencent.mm.model.aw.aaz();
    c.Ru().set(143618, Integer.valueOf(0));
    AppMethodBeat.o(33725);
  }
  
  private void fw(List<av> paramList)
  {
    AppMethodBeat.i(33722);
    if (this.context == null)
    {
      ab.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(33722);
      return;
    }
    this.gcq = View.inflate(this.context, 2130969607, this);
    int i = paramList.size();
    ab.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (av)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.gcq.findViewById(2131824197);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((av)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (av)paramList.get(1);
    localMaskLayout = (MaskLayout)this.gcq.findViewById(2131824199);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((av)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (av)paramList.get(2);
      localMaskLayout = (MaskLayout)this.gcq.findViewById(2131824200);
      a.b.c((ImageView)localMaskLayout.getContentView(), ((av)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (av)paramList.get(3);
      localObject = (MaskLayout)this.gcq.findViewById(2131824201);
      a.b.c((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.AcN = this.gcq.findViewById(2131824195);
    this.AcN.setOnClickListener(new k.6(this));
    AppMethodBeat.o(33722);
  }
  
  private void init()
  {
    AppMethodBeat.i(33719);
    Object localObject = com.tencent.mm.bi.d.ali().dxw();
    int i = ((List)localObject).size();
    ab.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      dLQ();
      localObject = this.gcq.findViewById(2131824195);
      if (localObject != null) {
        if (!this.isVisible) {
          break label198;
        }
      }
    }
    label198:
    for (i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.AcN.setOnTouchListener(new k.3(this));
      i = com.tencent.mm.bi.d.ali().dxy();
      ab.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.gcq.findViewById(2131824198);
      ((TextView)localObject).setBackgroundResource(t.iF(this.context));
      if (i > 0) {
        break label204;
      }
      ((TextView)localObject).setVisibility(8);
      AcM = Boolean.FALSE;
      AppMethodBeat.o(33719);
      return;
      if (i == 1)
      {
        a((av)((List)localObject).get(0));
        break;
      }
      fw((List)localObject);
      break;
    }
    label204:
    ((TextView)localObject).setVisibility(0);
    AcM = Boolean.TRUE;
    if (i > 99)
    {
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(2131230963);
      AppMethodBeat.o(33719);
      return;
    }
    ((TextView)localObject).setText(String.valueOf(i));
    ((TextView)localObject).setBackgroundResource(t.iF(this.context));
    AppMethodBeat.o(33719);
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.AcP = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(33723);
    ab.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.gcq.findViewById(2131824195);
    if (localView != null) {
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.isVisible = paramBoolean;
      AppMethodBeat.o(33723);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k
 * JD-Core Version:    0.7.0.1
 */