package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae$j
  extends c
{
  private static int KzM;
  private static int KzN;
  private static int ofV;
  private static int ofW = 0;
  private static int ofX;
  private static int ofY = 0;
  private static int oga;
  private static int xCB;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private boolean KzO = false;
  private int KzP = 0;
  private long olE = 0L;
  private boolean olF = false;
  
  static
  {
    ofX = 0;
  }
  
  private static void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(37155);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37155);
  }
  
  private static void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(187818);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(187818);
  }
  
  private static void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(37156);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37156);
  }
  
  private static String a(com.tencent.mm.storage.bv parambv, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(37167);
    if (paramContext == null)
    {
      ae.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(37167);
      return null;
    }
    if (parambv == null)
    {
      ae.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(37167);
      return null;
    }
    parambv = com.tencent.mm.ah.m.a(paramContext, paramInt, parambv.field_content, parambv.field_talker, parambv.field_msgId);
    AppMethodBeat.o(37167);
    return parambv;
  }
  
  private static void a(View paramView, ae.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(37159);
    if (paramBoolean)
    {
      if (paramb.oiV == null) {
        paramb.dD(paramView);
      }
      if (paramb.oiV != null)
      {
        paramb.oiV.setVisibility(0);
        AppMethodBeat.o(37159);
      }
    }
    else if (paramb.oiV != null)
    {
      paramb.oiV.setVisibility(8);
    }
    AppMethodBeat.o(37159);
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.storage.bv parambv, int paramInt)
  {
    AppMethodBeat.i(37158);
    e.g localg = new e.g();
    localg.msgId = parambv.field_msgId;
    localg.Kxc = paramInt;
    localg.dCX = parambv.field_content;
    paramImageView.setTag(localg);
    paramImageView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGx());
    AppMethodBeat.o(37158);
  }
  
  private void a(v paramv, View paramView)
  {
    AppMethodBeat.i(37168);
    s.a(paramv, paramView, this.JWz.getTalkerUserName());
    AppMethodBeat.o(37168);
  }
  
  private void a(v paramv, View paramView, final long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(37169);
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zk(paramv.type)) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169876);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          int i = ae.j.a(ae.j.this).Kkd.getIntExtra("KOpenArticleSceneFromScene", 10000);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt(e.b.JoV, 0);
          paramAnonymousView.putInt(e.b.JoW, i);
          paramAnonymousView.putInt("geta8key_scene", 7);
          paramAnonymousView.putString("geta8key_username", ae.j.a(ae.j.this).getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(ae.j.a(ae.j.this).Kkd.getContext(), paramLong1, paramInt, this.val$index, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169876);
        }
      });
    }
    AppMethodBeat.o(37169);
  }
  
  private void a(v paramv, com.tencent.mm.storage.bv parambv, int paramInt, u paramu, View paramView)
  {
    AppMethodBeat.i(37153);
    String str = ((com.tencent.mm.ui.chatting.d.b.d)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.d.class)).aXA(paramv.url);
    if (!TextUtils.isEmpty(str))
    {
      ae.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramu = new bk(parambv, false, paramInt, paramv.url, false, this.JWz.fGT(), paramu.dIt, paramu.dIu, paramv.title, str, null, false, false);
      paramView.setOnClickListener(i(this.JWz));
    }
    for (;;)
    {
      paramu.Emz = parambv.field_msgSvrId;
      paramu.EmA = 0;
      paramu.KDW = paramv.type;
      paramView.setTag(paramu);
      if (com.tencent.mm.ah.m.zd(paramv.hGj)) {
        a(paramv, paramView);
      }
      a(paramv, paramView, parambv.field_msgId, parambv.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.JWz));
      paramView.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
      AppMethodBeat.o(37153);
      return;
      paramu = new bk(parambv, false, paramInt, paramv.url, false, this.JWz.fGT(), paramu.dIt, paramu.dIu, paramv.title);
      a(paramu, paramv, parambv);
      paramView.setOnClickListener(h(this.JWz));
    }
  }
  
  private static void a(ae.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(37160);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.olp, paramc.KzE, bool1);
      if (!bool1) {
        break label232;
      }
    }
    label46:
    label75:
    label209:
    label215:
    label227:
    label232:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 == 8)
      {
        bool1 = true;
        a(paramc.olp, paramc.KzF, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.olp, paramc.KzG, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.olp, paramc.KzH, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.olp, paramc.KzI, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.olp;
        paramc = paramc.KzD;
        if ((paramInt1 == 0) && (paramInt2 > 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(localLinearLayout, paramc, bool1);
          AppMethodBeat.o(37160);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label46;
          bool1 = false;
          break label75;
          bool1 = false;
          break label104;
          bool1 = false;
          break label133;
        }
      }
    }
  }
  
  private void a(ae.c paramc, final ae.a parama, v paramv, com.tencent.mm.storage.bv parambv, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(37157);
    if (parama.okU != null) {
      parama.okU.setVisibility(8);
    }
    if (paramv.type == 5)
    {
      parama.okW.setVisibility(0);
      parama.okW.setImageResource(2131231270);
      parama.okW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169877);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          parama.oiV.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169877);
        }
      });
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.JWz.Kkd.getContext(), 26);
      if (paramv.type != 7) {
        break label471;
      }
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.JWz.Kkd.getContext(), 32);
    }
    for (;;)
    {
      W(parama.okW, paramInt);
      AppMethodBeat.o(37157);
      return;
      if (paramv.type == 6)
      {
        parama.okW.setVisibility(0);
        if (paramBoolean) {
          if ((parambv.field_msgId + "_" + paramInt).equals(paramc.KuN)) {
            parama.okW.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(parama.okW, parambv, paramInt);
          break;
          parama.okW.setImageResource(2131231673);
          continue;
          if ((parambv.field_msgId + "_" + paramInt).equals(paramc.KuN)) {
            parama.okW.setImageResource(2131689906);
          } else {
            parama.okW.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        parama.okW.setVisibility(8);
        if (parama.okU != null) {
          parama.okU.setVisibility(0);
        }
        Drawable localDrawable = parama.okV.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((parambv.field_msgId + "_" + paramInt).equals(paramc.KuN))
        {
          parama.okV.setImageResource(2131231272);
          if ((parama.okV.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.okV.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.okV, parambv, paramInt);
          break;
          parama.okV.setImageResource(2131231271);
        }
      }
      parama.okW.setVisibility(8);
      break;
      label471:
      if (paramv.type == 5) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.JWz.Kkd.getContext(), 24);
      }
    }
  }
  
  private void a(bk parambk, v paramv, com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(37162);
    Bundle localBundle = new Bundle();
    int i;
    switch (y.aH(b(this.JWz, parambv), this.JWz.getTalkerUserName()))
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      i = 0;
    }
    for (;;)
    {
      localBundle.putString("share_report_pre_msg_url", paramv.url);
      localBundle.putString("share_report_pre_msg_title", paramv.title);
      localBundle.putString("share_report_pre_msg_desc", paramv.hGg);
      localBundle.putString("share_report_pre_msg_icon_url", com.tencent.mm.ah.m.a(paramv));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.JWz.getTalkerUserName());
      }
      parambk.KDU = localBundle;
      AppMethodBeat.o(37162);
      return;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, m.a parama)
  {
    AppMethodBeat.i(37163);
    paramString = com.tencent.mm.api.b.t(paramString, 3);
    com.tencent.mm.av.a.a locala = q.aJb();
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.igy = 2131100141;
    locala1.igk = true;
    locala1 = locala1.dh(paramInt1, paramInt2);
    locala1.ifZ = new com.tencent.mm.pluginsdk.ui.applet.n(2);
    locala1.igH = new e(2);
    locala1.hgD = r.aMY(paramString);
    locala.a(paramString, paramImageView, locala1.aJu(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, null, parama));
    AppMethodBeat.o(37163);
  }
  
  private void a(String paramString, ImageView paramImageView, boolean paramBoolean, int paramInt, m.a parama)
  {
    AppMethodBeat.i(37164);
    paramString = com.tencent.mm.api.b.t(paramString, 3);
    int i;
    boolean bool;
    label28:
    int j;
    label37:
    float f1;
    if (paramBoolean)
    {
      i = 2131231189;
      if (!paramBoolean) {
        break label243;
      }
      bool = false;
      if (!paramBoolean) {
        break label249;
      }
      j = 2131231198;
      f1 = this.JWz.Kkd.getContext().getResources().getDimensionPixelSize(2131166028);
      if (!((com.tencent.mm.ui.chatting.d.b.k)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode()) {
        break label257;
      }
    }
    label257:
    for (int k = 72;; k = 32)
    {
      int m = com.tencent.mm.cb.a.iu(paramImageView.getContext());
      float f2 = com.tencent.mm.cb.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      com.tencent.mm.av.a.a locala = q.aJb();
      com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
      locala1.igy = j;
      locala1.igk = true;
      locala1.igA = String.valueOf(i);
      locala1 = locala1.dh(k, paramInt);
      locala1.ifZ = new com.tencent.mm.pluginsdk.ui.applet.n(2);
      locala1.igH = new e(2);
      locala1.hgD = r.aMY(paramString);
      locala.a(paramString, paramImageView, locala1.aJu(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, k, paramInt, true, bool, f1, parama));
      AppMethodBeat.o(37164);
      return;
      i = 2131231185;
      break;
      label243:
      bool = true;
      break label28;
      label249:
      j = 2131231196;
      break label37;
    }
  }
  
  private static void c(v paramv)
  {
    if (paramv.type == 6) {
      paramv.type = 7;
    }
  }
  
  private void e(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(37165);
    if (this.olF)
    {
      if (!this.olF)
      {
        ae.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        AppMethodBeat.o(37165);
        return;
      }
      s.a(this.KzP, parama.Kkd.getContext(), parambv.field_content, parambv.field_talker, parambv.field_msgId, parambv.field_msgSvrId);
      AppMethodBeat.o(37165);
      return;
    }
    String str = a(parambv, parama.Kkd.getContext(), this.KzP);
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(37165);
      return;
    }
    Intent localIntent = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", str);
    localIntent.putExtra("Retr_Msg_Type", 2);
    localIntent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.KzP);
    localIntent.putExtra("Retr_Msg_Id", parambv.field_msgId);
    localIntent.putExtra("Retr_MsgFromScene", 1);
    str = parambv.field_talker;
    Object localObject = z.Br(parambv.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject);
    localObject = z.aBG().F((String)localObject, true);
    ((z.b)localObject).k("prePublishId", "msg_" + parambv.field_msgSvrId);
    ((z.b)localObject).k("preUsername", str);
    ((z.b)localObject).k("preChatName", str);
    ((z.b)localObject).k("preMsgIndex", Integer.valueOf(this.KzP));
    ((z.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
    parambv = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(parama, parambv.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)parambv.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37165);
  }
  
  private static void kv(Context paramContext)
  {
    AppMethodBeat.i(37151);
    int i;
    int j;
    if (ofY == 0)
    {
      ofY = paramContext.getResources().getDimensionPixelSize(2131165568);
      ofX = paramContext.getResources().getDimensionPixelSize(2131165500);
      ofW = paramContext.getResources().getDimensionPixelSize(2131165480);
      ofV = paramContext.getResources().getDimensionPixelSize(2131166025);
      oga = paramContext.getResources().getDimensionPixelSize(2131166023);
      i = com.tencent.mm.cb.a.iu(paramContext);
      j = com.tencent.mm.cb.a.iv(paramContext);
      if (i >= j) {
        break label141;
      }
    }
    for (;;)
    {
      i -= (int)(com.tencent.mm.cb.a.getDensity(paramContext) * 32.0F);
      xCB = (int)(i / 2.35D);
      KzM = (int)(i / 1.777778F);
      KzN = (int)(i / 1.777778F);
      AppMethodBeat.o(37151);
      return;
      label141:
      i = j;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37150);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493417);
      paramView = new ae.c();
      paramView.fVV = ((TextView)((View)localObject).findViewById(2131298178));
      paramView.KuJ = ((View)localObject).findViewById(2131298104);
      paramView.olp = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramView.iFD = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramView.hcH = ((View)localObject).findViewById(2131298147);
      paramView.KvI = ((TextView)((View)localObject).findViewById(2131298023));
      ((View)localObject).setTag(paramView);
    }
    kv(paramLayoutInflater.getContext());
    AppMethodBeat.o(37150);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final com.tencent.mm.storage.bv parambv, final String paramString)
  {
    AppMethodBeat.i(37152);
    this.JWz = parama1;
    kv(parama1.Kkd.getContext());
    final ae.c localc = (ae.c)parama;
    parama = localc.ols.iterator();
    if (parama.hasNext())
    {
      paramString = (ae.a)parama.next();
      if (localc.ols.indexOf(paramString) != localc.ols.size() - 1) {
        ap.aC(paramString.oiV, 1);
      }
      for (;;)
      {
        localc.olp.removeView(paramString.oiV);
        break;
        ap.aC(paramString.oiV, 2);
      }
    }
    localc.ols.clear();
    u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);
    parama = localu.fmn;
    if ((parama == null) || (parama.length() == 0)) {
      localc.KvI.setVisibility(8);
    }
    LinkedList localLinkedList;
    final int j;
    for (;;)
    {
      localLinkedList = localu.hFT;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.olp.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(37152);
      return;
      localc.KvI.setVisibility(0);
      b(parama1, localc.KvI, bk.aYj(parama));
    }
    localc.olp.setVisibility(0);
    a(localc, ((v)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.Kkd.getActivityLayoutInflater();
    final int i = localc.ols.size() + 2;
    while (i < j)
    {
      paramString = ap.adH(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493418, null);
      }
      localc.gM(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = ap.adH(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493419, null);
      }
      localc.gM(parama);
    }
    for (this.KzO = true;; this.KzO = false)
    {
      i = 0;
      while (i < localc.ols.size())
      {
        ((ae.a)localc.ols.get(i)).oiV.setVisibility(8);
        i += 1;
      }
    }
    paramString = (v)localLinkedList.get(0);
    c(paramString);
    label555:
    label625:
    boolean bool;
    label682:
    label738:
    label741:
    Object localObject2;
    int k;
    if (paramString.type == 5)
    {
      X(localc.KzE.oiA, KzM);
      X(localc.KzE.oiq, KzM);
      if (bu.isNullOrNil(paramString.title))
      {
        localc.KzE.oip.setVisibility(8);
        if (j != 1) {
          break label1437;
        }
        localc.KzE.oiq.setBackgroundResource(2131231708);
        parama = com.tencent.mm.ah.m.ol(paramString.hGi);
        if (TextUtils.isEmpty(parama)) {
          break label1454;
        }
        localc.KzE.timeTv.setVisibility(0);
        localc.KzE.timeTv.setText(parama);
        localc.KzE.timeTv.setTextColor(this.JWz.Kkd.getContext().getResources().getColor(2131100541));
        a(paramString, parambv, paramInt, localu, localc.KzE.oiV);
        localc.KzE.oie.setVisibility(8);
        parama = paramString.hGe;
        localObject1 = localc.KzE.oic;
        if (j <= 1) {
          break label1470;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, KzM, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37143);
            localc.KzE.oie.setVisibility(0);
            localc.KzE.oip.setTextColor(ae.j.a(ae.j.this).Kkd.getContext().getResources().getColor(2131101182));
            localc.KzE.timeTv.setTextColor(ae.j.a(ae.j.this).Kkd.getContext().getResources().getColor(2131101182));
            ImageView localImageView = localc.KzE.oie;
            if (j > 1) {}
            for (int i = 2131231282;; i = 2131235111)
            {
              localImageView.setBackgroundResource(i);
              AppMethodBeat.o(37143);
              return;
            }
          }
          
          public final void onStart() {}
        });
        if (com.tencent.mm.cb.a.ef(this.JWz.Kkd.getContext()) <= 1.125F) {
          break label1476;
        }
        localc.KzE.oip.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label4296;
        }
        localObject1 = (v)localLinkedList.get(i);
        c((v)localObject1);
        localObject2 = (ae.a)localc.ols.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3674;
        }
        if ((k != 0) || (!bu.isNullOrNil(((v)localLinkedList.get(0)).hGe))) {
          break label3661;
        }
        ((ae.a)localObject2).iFF.setVisibility(0);
        label851:
        Y(((ae.a)localObject2).iFF, ofW);
        label862:
        if (i != 1) {
          break label3841;
        }
        if (i != j - 1) {
          break label3822;
        }
        ((ae.a)localObject2).okQ.setPadding(0, ofW, 0, ofW);
        label893:
        a(localc, (ae.a)localObject2, (v)localObject1, parambv, i, false);
        ((ae.a)localObject2).oip.setTextColor(parama1.Kkd.getMMResources().getColor(2131100711));
        if (!bu.isNullOrNil(((v)localObject1).title)) {
          break label3930;
        }
        parama = com.tencent.mm.plugin.brandservice.b.a.obW;
        k = ((v)localObject1).type;
        parama = this.JWz.Kkd.getContext();
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(2131757136);
          label1007:
          com.tencent.mm.plugin.brandservice.b.a.a(parama, ((ae.a)localObject2).oip, (v)localObject1, 3);
          label1019:
          if ((((v)localObject1).hGh == 0) || (((v)localObject1).hGh == 1))
          {
            ((ae.a)localObject2).okT.setVisibility(0);
            ((ae.a)localObject2).oip.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099732));
            if (((v)localObject1).type == 7)
            {
              ((ae.a)localObject2).oic.setVisibility(8);
              if ((bu.isNullOrNil(((v)localObject1).hGg)) || (((v)localObject1).type != 3)) {
                break label4223;
              }
              ((ae.a)localObject2).okS.setText(((v)localObject1).hGg);
              ((ae.a)localObject2).okS.setVisibility(0);
              ((ae.a)localObject2).oiV.setVisibility(0);
              parama = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).aXA(((v)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label4236;
              }
              ae.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new bk(parambv, false, paramInt, ((v)localObject1).url, this.KzO, parama1.fGT(), localu.dIt, localu.dIu, ((v)localObject1).title, parama, null, false, true);
              ((ae.a)localObject2).oiV.setOnClickListener(i(parama1));
            }
          }
          label1089:
          label1131:
          break;
        }
      }
    }
    for (;;)
    {
      parama.Emz = parambv.field_msgSvrId;
      parama.EmA = i;
      parama.KDW = ((v)localObject1).type;
      ((ae.a)localObject2).oiV.setTag(parama);
      if (com.tencent.mm.ah.m.zd(((v)localObject1).hGj)) {
        a((v)localObject1, ((ae.a)localObject2).oiV);
      }
      a((v)localObject1, ((ae.a)localObject2).oiV, parambv.field_msgId, parambv.field_msgSvrId, i);
      ((ae.a)localObject2).oiV.setOnLongClickListener(c(parama1));
      ((ae.a)localObject2).oiV.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
      i += 1;
      break label741;
      localc.KzE.oip.aq(paramString.title);
      localc.KzE.oip.getPaint().setFakeBoldText(true);
      localc.KzE.oip.setVisibility(0);
      localc.KzE.oip.setTextColor(this.JWz.Kkd.getContext().getResources().getColor(2131100541));
      break;
      label1437:
      localc.KzE.oiq.setBackgroundResource(2131231710);
      break label555;
      label1454:
      localc.KzE.timeTv.setVisibility(8);
      break label625;
      label1470:
      bool = false;
      break label682;
      label1476:
      localc.KzE.oip.setMaxLines(2);
      break label738;
      if (paramString.type == 8)
      {
        X(localc.KzF.oiA, KzN);
        X(localc.KzF.oiq, KzN);
        if (j == 1)
        {
          localc.KzF.oie.setBackgroundResource(2131231276);
          localc.KzF.oiq.setBackgroundResource(2131231708);
          localc.KzF.xCM.setBackgroundResource(2131231187);
          label1577:
          localc.KzF.oie.setVisibility(8);
          localc.KzF.xCM.setVisibility(8);
          localc.KzF.ka.setImageResource(2131689781);
          parama = paramString.hGe;
          localObject1 = localc.KzF.oic;
          if (j <= 1) {
            break label1731;
          }
        }
        label1731:
        for (bool = true;; bool = false)
        {
          a(parama, (ImageView)localObject1, bool, xCB, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37145);
              localc.KzF.oie.setVisibility(0);
              localc.KzF.xCM.setVisibility(0);
              localc.KzF.ka.setImageResource(2131689782);
              AppMethodBeat.o(37145);
            }
            
            public final void onStart() {}
          });
          a(paramString, parambv, paramInt, localu, localc.KzF.oiV);
          break;
          localc.KzF.oie.setBackgroundResource(2131231200);
          localc.KzF.oiq.setBackgroundResource(2131231710);
          localc.KzF.xCM.setBackgroundResource(2131231277);
          break label1577;
        }
      }
      if (paramString.type == 7)
      {
        if (bu.isNullOrNil(paramString.title))
        {
          localc.KzG.gqi.setVisibility(8);
          label1771:
          if (j <= 1) {
            break label2018;
          }
          localc.KzG.oiV.setBackgroundResource(2131231694);
          label1791:
          parama = com.tencent.mm.ah.m.ol(paramString.hGi);
          if (TextUtils.isEmpty(parama)) {
            break label2035;
          }
          localc.KzG.okL.setVisibility(0);
          localc.KzG.okL.setText(parama);
          label1831:
          parama = localc.KzG.okW.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(parambv.field_msgId + "_0").equals(localc.KuN)) {
            break label2050;
          }
          localc.KzG.okW.setImageResource(2131231272);
          if ((localc.KzG.okW.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.KzG.okW.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.KzG.okW, parambv, 0);
          a(paramString, parambv, paramInt, localu, localc.KzG.oiV);
          break;
          localc.KzG.gqi.setVisibility(0);
          localc.KzG.gqi.setText(paramString.title);
          break label1771;
          label2018:
          localc.KzG.oiV.setBackgroundResource(2131234795);
          break label1791;
          label2035:
          localc.KzG.okL.setVisibility(4);
          break label1831;
          label2050:
          localc.KzG.okW.setImageResource(2131231271);
        }
      }
      if (paramString.type == 6)
      {
        localObject1 = (v)localLinkedList.get(0);
        if (bu.isNullOrNil(((v)localObject1).title))
        {
          localc.KzH.gqi.setVisibility(8);
          label2114:
          if (j <= 1) {
            break label2380;
          }
          localc.KzH.oiV.setBackgroundResource(2131231694);
          label2134:
          if (TextUtils.isEmpty(((v)localObject1).hGs)) {
            break label2397;
          }
          localc.KzH.olL.setVisibility(0);
          localc.KzH.olL.setText(((v)localObject1).hGs);
          label2173:
          if (((v)localObject1).hGt != 2) {
            break label2413;
          }
          localc.KzH.olM.setImageResource(2131689903);
          label2196:
          a(localc.KzH.okW, parambv, 0);
          a((v)localObject1, parambv, paramInt, localu, localc.KzH.oiV);
          if (!(parambv.field_msgId + "_0").equals(localc.KuN)) {
            break label2430;
          }
          localc.KzH.okW.setImageResource(2131689906);
        }
        for (;;)
        {
          localc.KzH.oie.setVisibility(8);
          parama = new WeakReference(localc);
          localObject1 = ((v)localObject1).hGe;
          localObject2 = localc.KzH.oic;
          i = ofV;
          a((String)localObject1, (ImageView)localObject2, i, i, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37144);
              ae.c localc = (ae.c)parama.get();
              if (localc == null)
              {
                AppMethodBeat.o(37144);
                return;
              }
              localc.KzH.oie.setVisibility(0);
              if ((parambv.field_msgId + "_0").equals(localc.KuN))
              {
                localc.KzH.okW.setImageResource(2131231672);
                AppMethodBeat.o(37144);
                return;
              }
              localc.KzH.okW.setImageResource(2131231673);
              AppMethodBeat.o(37144);
            }
            
            public final void onStart() {}
          });
          break;
          localc.KzH.gqi.setVisibility(0);
          localc.KzH.gqi.setText(((v)localObject1).title);
          break label2114;
          label2380:
          localc.KzH.oiV.setBackgroundResource(2131234795);
          break label2134;
          label2397:
          localc.KzH.olL.setVisibility(8);
          break label2173;
          label2413:
          localc.KzH.olM.setImageResource(2131689912);
          break label2196;
          label2430:
          localc.KzH.okW.setImageResource(2131689909);
        }
      }
      if (paramString.type == 10)
      {
        if (bu.isNullOrNil(paramString.title))
        {
          localc.KzI.oip.setVisibility(8);
          if (j <= 1) {
            break label2952;
          }
          localc.KzI.oiV.setBackgroundResource(2131231694);
        }
        for (;;)
        {
          a(paramString, parambv, paramInt, localu, localc.KzI.oiV);
          break;
          localc.KzI.oip.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(localc.KzI.oip, new com.tencent.mm.pluginsdk.ui.span.n(this.JWz.Kkd.getContext())));
          localc.KzI.oip.setVisibility(0);
          localc.KzI.oip.aq(com.tencent.mm.pluginsdk.ui.span.k.g(this.JWz.Kkd.getContext(), paramString.title, (int)localc.KzI.oip.getTextSize()));
          i = com.tencent.mm.cb.a.iu(this.JWz.Kkd.getContext());
          k = (int)(com.tencent.mm.cb.a.getDensity(this.JWz.Kkd.getContext()) * 80.0F);
          parama = localc.KzI.oip.kR(i - k, 2147483647);
          if (parama != null) {}
          for (i = parama.fXb();; i = 0)
          {
            parama = (LinearLayout.LayoutParams)localc.KzI.oip.getLayoutParams();
            localObject1 = (LinearLayout.LayoutParams)localc.KzI.KzL.getLayoutParams();
            if (i > 3) {
              break label2788;
            }
            localc.KzI.KzK.setVisibility(8);
            ((LinearLayout.LayoutParams)localObject1).gravity = 16;
            localc.KzI.KzL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = 0;
            parama.gravity = 17;
            localc.KzI.oip.setLayoutParams(parama);
            break;
          }
          label2788:
          if (paramString.hGx == 1)
          {
            i = 1;
            label2800:
            localc.KzI.KzK.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject1).gravity = 48;
            localc.KzI.KzL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.JWz.Kkd.getContext(), 38);
            parama.gravity = 8388627;
            if (i == 0) {
              break label2923;
            }
            localc.KzI.oip.setMaxLines(2147483647);
            localc.KzI.KzK.setText(2131756619);
          }
          for (;;)
          {
            localc.KzI.KzK.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37146);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (paramString.hGx == 1)
                {
                  localc.KzI.oip.setMaxLines(3);
                  localc.KzI.KzK.setText(2131756620);
                }
                for (paramString.hGx = 0;; paramString.hGx = 1)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37146);
                  return;
                  localc.KzI.oip.setMaxLines(2147483647);
                  localc.KzI.KzK.setText(2131756619);
                }
              }
            });
            break;
            i = 0;
            break label2800;
            label2923:
            localc.KzI.oip.setMaxLines(3);
            localc.KzI.KzK.setText(2131756620);
          }
          label2952:
          localc.KzI.oiV.setBackgroundResource(2131234795);
        }
      }
      parama = localc.KzD.oip;
      if (j > 1)
      {
        i = 8;
        label2988:
        parama.setVisibility(i);
        parama = localc.KzD.KzJ;
        if ((j <= 1) && (!bu.isNullOrNil(paramString.hGg))) {
          break label3378;
        }
        i = 8;
        label3024:
        parama.setVisibility(i);
        parama = localc.KzD.xCL;
        if (j <= 1) {
          break label3384;
        }
      }
      label3378:
      label3384:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.KzD.xCM.setVisibility(8);
        if (j != 1) {
          break label3391;
        }
        localc.KzD.oiq.setBackgroundResource(2131231708);
        localc.KzD.joL.setVisibility(0);
        X(localc.KzD.oiA, xCB);
        X(localc.KzD.oiq, xCB);
        if (bu.isNullOrNil(paramString.hGe)) {
          break label3503;
        }
        localc.KzD.oiA.setVisibility(0);
        a(paramString.hGe, localc.KzD.oic, true, xCB, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37142);
            if (j > 1)
            {
              localc.KzD.xCL.setTextColor(ae.j.a(ae.j.this).Kkd.getContext().getResources().getColor(2131101182));
              localc.KzD.xCL.setBackgroundResource(2131231208);
            }
            localc.KzD.xCM.setVisibility(0);
            AppMethodBeat.o(37142);
          }
          
          public final void onStart() {}
        });
        localc.KzD.joL.setBackgroundResource(2131231686);
        parama = localc.KzD.joL;
        i = ofW;
        k = ofX;
        int m = ofW;
        parama.setPadding(i, k, m, m);
        localc.KzD.oiq.setVisibility(0);
        localc.KzD.KzJ.setMaxLines(30);
        localc.KzD.KzJ.setText(paramString.hGg);
        parama = com.tencent.mm.plugin.brandservice.b.a.obW;
        com.tencent.mm.plugin.brandservice.b.a.a(paramString.title, localc.KzD.oip, paramString, 2);
        parama = com.tencent.mm.plugin.brandservice.b.a.obW;
        com.tencent.mm.plugin.brandservice.b.a.a(paramString.title, localc.KzD.xCL, paramString, 21);
        if ((paramString.hGh != 0) && (paramString.hGh != 1)) {
          localc.KzD.xCL.setVisibility(4);
        }
        a(paramString, parambv, paramInt, localu, localc.KzD.oiV);
        break;
        i = 0;
        break label2988;
        i = 0;
        break label3024;
      }
      label3391:
      parama = localc.KzD.joL;
      if (bu.isNullOrNil(paramString.hGe)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.KzD.oiq.setBackgroundResource(2131231710);
        localc.KzD.xCL.setTextColor(this.JWz.Kkd.getContext().getResources().getColor(2131100541));
        localc.KzD.xCL.setBackgroundResource(2131233299);
        localc.KzD.xCL.getPaint().setFakeBoldText(true);
        break;
      }
      label3503:
      localc.KzD.KzJ.setMaxLines(100);
      localc.KzD.oiA.setVisibility(8);
      localc.KzD.oip.setVisibility(0);
      parama = localc.KzD.KzJ;
      if (bu.isNullOrNil(paramString.hGg))
      {
        i = 8;
        label3565:
        parama.setVisibility(i);
        if (j != 1) {
          break label3644;
        }
        localc.KzD.joL.setBackgroundResource(2131234795);
      }
      for (;;)
      {
        parama = localc.KzD.joL;
        i = ofW;
        k = ofW;
        parama.setPadding(i, i, k, k);
        localc.KzD.oiq.setVisibility(8);
        break;
        i = 0;
        break label3565;
        label3644:
        localc.KzD.joL.setBackgroundResource(2131231694);
      }
      label3661:
      ((ae.a)localObject2).iFF.setVisibility(8);
      break label862;
      label3674:
      ((ae.a)localObject2).iFF.setVisibility(0);
      if (i <= 1) {
        break label851;
      }
      parama = (v)localLinkedList.get(i - 1);
      Object localObject3 = (v)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (bu.isNullOrNil(parama.hGe))) || ((((v)localObject3).type != 7) && (((v)localObject3).type != 5) && (((v)localObject3).type != 6) && (bu.isNullOrNil(((v)localObject3).hGe))))
      {
        Y(((ae.a)localObject2).iFF, ofW);
        break label862;
      }
      Y(((ae.a)localObject2).iFF, oga);
      break label862;
      label3822:
      ((ae.a)localObject2).okQ.setPadding(0, ofW, 0, ofY);
      break label893;
      label3841:
      if (i == j - 1)
      {
        ((ae.a)localObject2).okQ.setPadding(0, ofY, 0, ofW);
        break label893;
      }
      ((ae.a)localObject2).okQ.setPadding(0, ofY, 0, ofY);
      break label893;
      parama = parama.getResources().getString(2131757144);
      break label1007;
      parama = parama.getResources().getString(2131757145);
      break label1007;
      parama = parama.getResources().getString(2131757137);
      break label1007;
      label3930:
      parama = com.tencent.mm.plugin.brandservice.b.a.obW;
      com.tencent.mm.plugin.brandservice.b.a.a(((v)localObject1).title, ((ae.a)localObject2).oip, (v)localObject1, 3);
      break label1019;
      Object localObject4;
      if (!bu.isNullOrNil(((v)localObject1).hGe))
      {
        ((ae.a)localObject2).oic.setVisibility(0);
        localObject3 = new WeakReference(localc);
        localObject4 = new WeakReference(localObject2);
        if (bu.isNullOrNil(((v)localObject1).hGv)) {}
        for (parama = ((v)localObject1).hGe;; parama = ((v)localObject1).hGv)
        {
          ImageView localImageView = ((ae.a)localObject2).oic;
          k = ofV;
          a(parama, localImageView, k, k, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37141);
              if ((this.KzQ.get() != null) && (this.KzR.get() != null)) {
                ae.j.a(ae.j.this, (ae.c)this.KzQ.get(), (ae.a)this.KzR.get(), this.ogC, parambv, i);
              }
              AppMethodBeat.o(37141);
            }
            
            public final void onStart() {}
          });
          break;
        }
      }
      if ((((v)localObject1).type == 5) || (((v)localObject1).type == 6))
      {
        ((ae.a)localObject2).oic.setVisibility(0);
        parama = ((ae.a)localObject2).oic;
        k = ofV;
        localObject3 = q.aJb();
        localObject4 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject4).igi = true;
        ((com.tencent.mm.av.a.a.c.a)localObject4).igv = 2131100141;
        localObject4 = ((com.tencent.mm.av.a.a.c.a)localObject4).dh(k, k);
        ((com.tencent.mm.av.a.a.c.a)localObject4).ign = 4;
        ((com.tencent.mm.av.a.a)localObject3).a("2131231674", parama, ((com.tencent.mm.av.a.a.c.a)localObject4).aJu(), null, new com.tencent.mm.pluginsdk.ui.applet.m());
        break label1089;
      }
      ((ae.a)localObject2).okT.setVisibility(8);
      break label1089;
      ((ae.a)localObject2).okT.setVisibility(8);
      ((ae.a)localObject2).oip.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131099735));
      break label1089;
      label4223:
      ((ae.a)localObject2).okS.setVisibility(8);
      break label1131;
      label4236:
      parama = new bk(parambv, false, paramInt, ((v)localObject1).url, this.KzO, parama1.fGT(), localu.dIt, localu.dIu);
      a(parama, (v)localObject1, parambv);
      ((ae.a)localObject2).oiV.setOnClickListener(h(parama1));
    }
    label4296:
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (v)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url))
        {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.url, parama.type, 0, new Object[0]);
          if ((parama.hBY == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOf())) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).cw(parama.url, parama.type);
          }
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(37152);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(37166);
    this.olE = bu.aRi();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37166);
      return false;
      paramMenuItem = bn.E(parambv);
      if (bu.isNullOrNil(paramMenuItem))
      {
        e(parama, parambv);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        h.a(parama.Kkd.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37148);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
            com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37148);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169878);
            ae.j.a(ae.j.this, parama, parambv);
            com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(169878);
          }
        });
        continue;
        paramMenuItem = a(parambv, parama.Kkd.getContext(), 0);
        if (!bu.isNullOrNil(paramMenuItem))
        {
          am.c(parambv, paramMenuItem, parama.Kkd.getContext());
          continue;
          s.a(this.olE, this.KzP, parama.Kkd.getContext(), parama.Kkd, null, parambv);
          continue;
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Chat_Msg_Id", parambv.field_msgId);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(187819);
    Object localObject = (bk)paramView.getTag();
    if (localObject == null)
    {
      AppMethodBeat.o(187819);
      return false;
    }
    this.KzP = ((bk)localObject).EmA;
    int i = ((bk)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);
    if (localObject == null)
    {
      ae.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(187819);
      return false;
    }
    this.olF = false;
    if ((this.KzP >= 0) && (this.KzP < ((u)localObject).hFT.size()) && (com.tencent.mm.ah.m.zd(((v)((u)localObject).hFT.get(this.KzP)).hGj))) {
      this.olF = true;
    }
    if ((!this.JWz.fJD()) && (!com.tencent.mm.ui.chatting.k.ba(parambv))) {
      paraml.a(i, 111, paramView.getContext().getString(2131762559), 2131690478);
    }
    if ((com.tencent.mm.br.d.aJN("favorite")) && (!this.olF)) {
      paraml.a(i, 126, paramView.getContext().getString(2131761941), 2131690400);
    }
    if ((j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bv.fpT())) {
      paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
    }
    paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(187819);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.j
 * JD-Core Version:    0.7.0.1
 */