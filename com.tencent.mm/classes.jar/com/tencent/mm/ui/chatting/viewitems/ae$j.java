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
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.j;
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
  private static int Kdu;
  private static int oaf;
  private static int oag = 0;
  private static int oah;
  private static int oai = 0;
  private static int oak;
  private static int xmE;
  private com.tencent.mm.ui.chatting.e.a JBI;
  private boolean Kdv = false;
  private int Kdw = 0;
  private long ofG = 0L;
  private boolean ofH = false;
  
  static
  {
    oah = 0;
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
    AppMethodBeat.i(194423);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(194423);
  }
  
  private static void Y(View paramView, int paramInt)
  {
    AppMethodBeat.i(37156);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37156);
  }
  
  private static String a(com.tencent.mm.storage.bu parambu, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(37167);
    if (paramContext == null)
    {
      ad.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(37167);
      return null;
    }
    if (parambu == null)
    {
      ad.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(37167);
      return null;
    }
    parambu = com.tencent.mm.ai.m.a(paramContext, paramInt, parambu.field_content, parambu.field_talker, parambu.field_msgId);
    AppMethodBeat.o(37167);
    return parambu;
  }
  
  private static void a(View paramView, ae.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(37159);
    if (paramBoolean)
    {
      if (paramb.odh == null) {
        paramb.dD(paramView);
      }
      if (paramb.odh != null)
      {
        paramb.odh.setVisibility(0);
        AppMethodBeat.o(37159);
      }
    }
    else if (paramb.odh != null)
    {
      paramb.odh.setVisibility(8);
    }
    AppMethodBeat.o(37159);
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.storage.bu parambu, int paramInt)
  {
    AppMethodBeat.i(37158);
    e.g localg = new e.g();
    localg.msgId = parambu.field_msgId;
    localg.KaJ = paramInt;
    localg.dBS = parambu.field_content;
    paramImageView.setTag(localg);
    paramImageView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCv());
    AppMethodBeat.o(37158);
  }
  
  private void a(v paramv, View paramView)
  {
    AppMethodBeat.i(37168);
    com.tencent.mm.ui.chatting.r.a(paramv, paramView, this.JBI.getTalkerUserName());
    AppMethodBeat.o(37168);
  }
  
  private void a(v paramv, View paramView, final long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(37169);
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zb(paramv.type)) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169876);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          int i = ae.j.a(ae.j.this).JOR.getIntExtra("KOpenArticleSceneFromScene", 10000);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt(e.b.IUn, 0);
          paramAnonymousView.putInt(e.b.IUo, i);
          paramAnonymousView.putInt("geta8key_scene", 7);
          paramAnonymousView.putString("geta8key_username", ae.j.a(ae.j.this).getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(ae.j.a(ae.j.this).JOR.getContext(), paramLong1, paramInt, this.val$index, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169876);
        }
      });
    }
    AppMethodBeat.o(37169);
  }
  
  private void a(v paramv, com.tencent.mm.storage.bu parambu, int paramInt, u paramu, View paramView)
  {
    AppMethodBeat.i(37153);
    String str = ((com.tencent.mm.ui.chatting.d.b.d)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.d.class)).aVZ(paramv.url);
    if (!TextUtils.isEmpty(str))
    {
      ad.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramu = new bk(parambu, false, paramInt, paramv.url, false, this.JBI.fCR(), paramu.dHo, paramu.dHp, paramv.title, str, null, false, false);
      paramView.setOnClickListener(i(this.JBI));
    }
    for (;;)
    {
      paramu.DUA = parambu.field_msgSvrId;
      paramu.DUB = 0;
      paramu.KhB = paramv.type;
      paramView.setTag(paramu);
      if (com.tencent.mm.ai.m.yt(paramv.hDr)) {
        a(paramv, paramView);
      }
      a(paramv, paramView, parambu.field_msgId, parambu.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.JBI));
      paramView.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      AppMethodBeat.o(37153);
      return;
      paramu = new bk(parambu, false, paramInt, paramv.url, false, this.JBI.fCR(), paramu.dHo, paramu.dHp, paramv.title);
      a(paramu, paramv, parambu);
      paramView.setOnClickListener(h(this.JBI));
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
      a(paramc.ofq, paramc.Kdm, bool1);
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
        a(paramc.ofq, paramc.Kdn, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.ofq, paramc.Kdo, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.ofq, paramc.Kdp, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.ofq, paramc.Kdq, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.ofq;
        paramc = paramc.Kdl;
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
  
  private void a(ae.c paramc, final ae.a parama, v paramv, com.tencent.mm.storage.bu parambu, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(37157);
    if (parama.oeU != null) {
      parama.oeU.setVisibility(8);
    }
    if (paramv.type == 5)
    {
      parama.oeW.setVisibility(0);
      parama.oeW.setImageResource(2131231270);
      parama.oeW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169877);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          parama.odh.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169877);
        }
      });
      paramInt = com.tencent.mm.cc.a.fromDPToPix(this.JBI.JOR.getContext(), 26);
      if (paramv.type != 7) {
        break label471;
      }
      paramInt = com.tencent.mm.cc.a.fromDPToPix(this.JBI.JOR.getContext(), 32);
    }
    for (;;)
    {
      W(parama.oeW, paramInt);
      AppMethodBeat.o(37157);
      return;
      if (paramv.type == 6)
      {
        parama.oeW.setVisibility(0);
        if (paramBoolean) {
          if ((parambu.field_msgId + "_" + paramInt).equals(paramc.JYu)) {
            parama.oeW.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(parama.oeW, parambu, paramInt);
          break;
          parama.oeW.setImageResource(2131231673);
          continue;
          if ((parambu.field_msgId + "_" + paramInt).equals(paramc.JYu)) {
            parama.oeW.setImageResource(2131689906);
          } else {
            parama.oeW.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        parama.oeW.setVisibility(8);
        if (parama.oeU != null) {
          parama.oeU.setVisibility(0);
        }
        Drawable localDrawable = parama.oeV.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((parambu.field_msgId + "_" + paramInt).equals(paramc.JYu))
        {
          parama.oeV.setImageResource(2131231272);
          if ((parama.oeV.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.oeV.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.oeV, parambu, paramInt);
          break;
          parama.oeV.setImageResource(2131231271);
        }
      }
      parama.oeW.setVisibility(8);
      break;
      label471:
      if (paramv.type == 5) {
        paramInt = com.tencent.mm.cc.a.fromDPToPix(this.JBI.JOR.getContext(), 24);
      }
    }
  }
  
  private void a(bk parambk, v paramv, com.tencent.mm.storage.bu parambu)
  {
    AppMethodBeat.i(37162);
    Bundle localBundle = new Bundle();
    int i;
    switch (x.aG(b(this.JBI, parambu), this.JBI.getTalkerUserName()))
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
      localBundle.putString("share_report_pre_msg_desc", paramv.hDo);
      localBundle.putString("share_report_pre_msg_icon_url", com.tencent.mm.ai.m.a(paramv));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.JBI.getTalkerUserName());
      }
      parambk.Khz = localBundle;
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
    paramString = com.tencent.mm.api.b.s(paramString, 3);
    com.tencent.mm.aw.a.a locala = q.aIJ();
    com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
    locala1.idG = 2131100141;
    locala1.idr = true;
    locala1 = locala1.dh(paramInt1, paramInt2);
    locala1.idg = new com.tencent.mm.pluginsdk.ui.applet.n(2);
    locala1.idP = new e(2);
    locala1.hdP = com.tencent.mm.pluginsdk.model.r.aLC(paramString);
    locala.a(paramString, paramImageView, locala1.aJc(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, null, parama));
    AppMethodBeat.o(37163);
  }
  
  private void a(String paramString, ImageView paramImageView, boolean paramBoolean, int paramInt, m.a parama)
  {
    AppMethodBeat.i(37164);
    paramString = com.tencent.mm.api.b.s(paramString, 3);
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
      f1 = this.JBI.JOR.getContext().getResources().getDimensionPixelSize(2131166028);
      if (!((com.tencent.mm.ui.chatting.d.b.k)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode()) {
        break label257;
      }
    }
    label257:
    for (int k = 72;; k = 32)
    {
      int m = com.tencent.mm.cc.a.ip(paramImageView.getContext());
      float f2 = com.tencent.mm.cc.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      com.tencent.mm.aw.a.a locala = q.aIJ();
      com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
      locala1.idG = j;
      locala1.idr = true;
      locala1.idI = String.valueOf(i);
      locala1 = locala1.dh(k, paramInt);
      locala1.idg = new com.tencent.mm.pluginsdk.ui.applet.n(2);
      locala1.idP = new e(2);
      locala1.hdP = com.tencent.mm.pluginsdk.model.r.aLC(paramString);
      locala.a(paramString, paramImageView, locala1.aJc(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, k, paramInt, true, bool, f1, parama));
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
  
  private void e(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
  {
    AppMethodBeat.i(37165);
    if (this.ofH)
    {
      if (!this.ofH)
      {
        ad.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        AppMethodBeat.o(37165);
        return;
      }
      com.tencent.mm.ui.chatting.r.a(this.Kdw, parama.JOR.getContext(), parambu.field_content, parambu.field_talker, parambu.field_msgId, parambu.field_msgSvrId);
      AppMethodBeat.o(37165);
      return;
    }
    String str = a(parambu, parama.JOR.getContext(), this.Kdw);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(37165);
      return;
    }
    Intent localIntent = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", str);
    localIntent.putExtra("Retr_Msg_Type", 2);
    localIntent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.Kdw);
    localIntent.putExtra("Retr_Msg_Id", parambu.field_msgId);
    localIntent.putExtra("Retr_MsgFromScene", 1);
    str = parambu.field_talker;
    Object localObject = y.AH(parambu.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject);
    localObject = y.aBq().F((String)localObject, true);
    ((y.b)localObject).k("prePublishId", "msg_" + parambu.field_msgSvrId);
    ((y.b)localObject).k("preUsername", str);
    ((y.b)localObject).k("preChatName", str);
    ((y.b)localObject).k("preMsgIndex", Integer.valueOf(this.Kdw));
    ((y.b)localObject).k("sendAppMsgScene", Integer.valueOf(1));
    parambu = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(parama, parambu.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)parambu.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37165);
  }
  
  private static void ko(Context paramContext)
  {
    AppMethodBeat.i(37151);
    int i;
    int j;
    if (oai == 0)
    {
      oai = paramContext.getResources().getDimensionPixelSize(2131165568);
      oah = paramContext.getResources().getDimensionPixelSize(2131165500);
      oag = paramContext.getResources().getDimensionPixelSize(2131165480);
      oaf = paramContext.getResources().getDimensionPixelSize(2131166025);
      oak = paramContext.getResources().getDimensionPixelSize(2131166023);
      i = com.tencent.mm.cc.a.ip(paramContext);
      j = com.tencent.mm.cc.a.iq(paramContext);
      if (i >= j) {
        break label131;
      }
    }
    for (;;)
    {
      i -= (int)(com.tencent.mm.cc.a.getDensity(paramContext) * 32.0F);
      xmE = (int)(i / 2.35D);
      Kdu = (int)(i / 1.777778F);
      AppMethodBeat.o(37151);
      return;
      label131:
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
      paramView.fTP = ((TextView)((View)localObject).findViewById(2131298178));
      paramView.JYq = ((View)localObject).findViewById(2131298104);
      paramView.ofq = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramView.iCK = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramView.gZU = ((View)localObject).findViewById(2131298147);
      paramView.JZp = ((TextView)((View)localObject).findViewById(2131298023));
      ((View)localObject).setTag(paramView);
    }
    ko(paramLayoutInflater.getContext());
    AppMethodBeat.o(37150);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final com.tencent.mm.storage.bu parambu, final String paramString)
  {
    AppMethodBeat.i(37152);
    this.JBI = parama1;
    ko(parama1.JOR.getContext());
    final ae.c localc = (ae.c)parama;
    parama = localc.oft.iterator();
    if (parama.hasNext())
    {
      paramString = (ae.a)parama.next();
      if (localc.oft.indexOf(paramString) != localc.oft.size() - 1) {
        ao.aC(paramString.odh, 1);
      }
      for (;;)
      {
        localc.ofq.removeView(paramString.odh);
        break;
        ao.aC(paramString.odh, 2);
      }
    }
    localc.oft.clear();
    u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);
    parama = localu.fkq;
    if ((parama == null) || (parama.length() == 0)) {
      localc.JZp.setVisibility(8);
    }
    LinkedList localLinkedList;
    final int j;
    for (;;)
    {
      localLinkedList = localu.hDb;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.ofq.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(37152);
      return;
      localc.JZp.setVisibility(0);
      b(parama1, localc.JZp, bk.aWI(parama));
    }
    localc.ofq.setVisibility(0);
    a(localc, ((v)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.JOR.getActivityLayoutInflater();
    final int i = localc.oft.size() + 2;
    while (i < j)
    {
      paramString = ao.acZ(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493418, null);
      }
      localc.gH(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = ao.acZ(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493419, null);
      }
      localc.gH(parama);
    }
    for (this.Kdv = true;; this.Kdv = false)
    {
      i = 0;
      while (i < localc.oft.size())
      {
        ((ae.a)localc.oft.get(i)).odh.setVisibility(8);
        i += 1;
      }
    }
    paramString = (v)localLinkedList.get(0);
    c(paramString);
    label555:
    label625:
    boolean bool;
    label682:
    label736:
    label739:
    Object localObject2;
    int k;
    if (paramString.type == 5)
    {
      X(localc.Kdm.ocL, Kdu);
      X(localc.Kdm.ocB, Kdu);
      if (bt.isNullOrNil(paramString.title))
      {
        localc.Kdm.ocA.setVisibility(8);
        if (j != 1) {
          break label1433;
        }
        localc.Kdm.ocB.setBackgroundResource(2131231708);
        parama = com.tencent.mm.ai.m.oi(paramString.hDq);
        if (TextUtils.isEmpty(parama)) {
          break label1450;
        }
        localc.Kdm.timeTv.setVisibility(0);
        localc.Kdm.timeTv.setText(parama);
        localc.Kdm.timeTv.setTextColor(this.JBI.JOR.getContext().getResources().getColor(2131100541));
        a(paramString, parambu, paramInt, localu, localc.Kdm.odh);
        localc.Kdm.ocp.setVisibility(8);
        parama = paramString.hDm;
        localObject1 = localc.Kdm.ocn;
        if (j <= 1) {
          break label1466;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, Kdu, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37143);
            localc.Kdm.ocp.setVisibility(0);
            localc.Kdm.ocA.setTextColor(ae.j.a(ae.j.this).JOR.getContext().getResources().getColor(2131101182));
            localc.Kdm.timeTv.setTextColor(ae.j.a(ae.j.this).JOR.getContext().getResources().getColor(2131101182));
            localc.Kdm.ocp.setBackgroundResource(2131231282);
            AppMethodBeat.o(37143);
          }
          
          public final void onStart() {}
        });
        if (com.tencent.mm.cc.a.eb(this.JBI.JOR.getContext()) <= 1.125F) {
          break label1472;
        }
        localc.Kdm.ocA.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label4292;
        }
        localObject1 = (v)localLinkedList.get(i);
        c((v)localObject1);
        localObject2 = (ae.a)localc.oft.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3670;
        }
        if ((k != 0) || (!bt.isNullOrNil(((v)localLinkedList.get(0)).hDm))) {
          break label3657;
        }
        ((ae.a)localObject2).iCM.setVisibility(0);
        label849:
        Y(((ae.a)localObject2).iCM, oag);
        label860:
        if (i != 1) {
          break label3837;
        }
        if (i != j - 1) {
          break label3818;
        }
        ((ae.a)localObject2).oeQ.setPadding(0, oag, 0, oag);
        label891:
        a(localc, (ae.a)localObject2, (v)localObject1, parambu, i, false);
        ((ae.a)localObject2).ocA.setTextColor(parama1.JOR.getMMResources().getColor(2131100711));
        if (!bt.isNullOrNil(((v)localObject1).title)) {
          break label3926;
        }
        parama = com.tencent.mm.plugin.brandservice.b.a.nWn;
        k = ((v)localObject1).type;
        parama = this.JBI.JOR.getContext();
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(2131757136);
          label1003:
          com.tencent.mm.plugin.brandservice.b.a.a(parama, ((ae.a)localObject2).ocA, (v)localObject1, 3);
          label1015:
          if ((((v)localObject1).hDp == 0) || (((v)localObject1).hDp == 1))
          {
            ((ae.a)localObject2).oeT.setVisibility(0);
            ((ae.a)localObject2).ocA.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099732));
            if (((v)localObject1).type == 7)
            {
              ((ae.a)localObject2).ocn.setVisibility(8);
              if ((bt.isNullOrNil(((v)localObject1).hDo)) || (((v)localObject1).type != 3)) {
                break label4219;
              }
              ((ae.a)localObject2).oeS.setText(((v)localObject1).hDo);
              ((ae.a)localObject2).oeS.setVisibility(0);
              ((ae.a)localObject2).odh.setVisibility(0);
              parama = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).aVZ(((v)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label4232;
              }
              ad.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new bk(parambu, false, paramInt, ((v)localObject1).url, this.Kdv, parama1.fCR(), localu.dHo, localu.dHp, ((v)localObject1).title, parama, null, false, true);
              ((ae.a)localObject2).odh.setOnClickListener(i(parama1));
            }
          }
          label1085:
          label1127:
          break;
        }
      }
    }
    for (;;)
    {
      parama.DUA = parambu.field_msgSvrId;
      parama.DUB = i;
      parama.KhB = ((v)localObject1).type;
      ((ae.a)localObject2).odh.setTag(parama);
      if (com.tencent.mm.ai.m.yt(((v)localObject1).hDr)) {
        a((v)localObject1, ((ae.a)localObject2).odh);
      }
      a((v)localObject1, ((ae.a)localObject2).odh, parambu.field_msgId, parambu.field_msgSvrId, i);
      ((ae.a)localObject2).odh.setOnLongClickListener(c(parama1));
      ((ae.a)localObject2).odh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      i += 1;
      break label739;
      localc.Kdm.ocA.ar(paramString.title);
      localc.Kdm.ocA.getPaint().setFakeBoldText(true);
      localc.Kdm.ocA.setVisibility(0);
      localc.Kdm.ocA.setTextColor(this.JBI.JOR.getContext().getResources().getColor(2131100541));
      break;
      label1433:
      localc.Kdm.ocB.setBackgroundResource(2131231710);
      break label555;
      label1450:
      localc.Kdm.timeTv.setVisibility(8);
      break label625;
      label1466:
      bool = false;
      break label682;
      label1472:
      localc.Kdm.ocA.setMaxLines(2);
      break label736;
      if (paramString.type == 8)
      {
        X(localc.Kdn.ocL, xmE);
        X(localc.Kdn.ocB, xmE);
        if (j == 1)
        {
          localc.Kdn.ocp.setBackgroundResource(2131231276);
          localc.Kdn.ocB.setBackgroundResource(2131231708);
          localc.Kdn.xmP.setBackgroundResource(2131231187);
          label1573:
          localc.Kdn.ocp.setVisibility(8);
          localc.Kdn.xmP.setVisibility(8);
          localc.Kdn.ka.setImageResource(2131689781);
          parama = paramString.hDm;
          localObject1 = localc.Kdn.ocn;
          if (j <= 1) {
            break label1727;
          }
        }
        label1727:
        for (bool = true;; bool = false)
        {
          a(parama, (ImageView)localObject1, bool, xmE, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37145);
              localc.Kdn.ocp.setVisibility(0);
              localc.Kdn.xmP.setVisibility(0);
              localc.Kdn.ka.setImageResource(2131689782);
              AppMethodBeat.o(37145);
            }
            
            public final void onStart() {}
          });
          a(paramString, parambu, paramInt, localu, localc.Kdn.odh);
          break;
          localc.Kdn.ocp.setBackgroundResource(2131231200);
          localc.Kdn.ocB.setBackgroundResource(2131231710);
          localc.Kdn.xmP.setBackgroundResource(2131231277);
          break label1573;
        }
      }
      if (paramString.type == 7)
      {
        if (bt.isNullOrNil(paramString.title))
        {
          localc.Kdo.gnM.setVisibility(8);
          label1767:
          if (j <= 1) {
            break label2014;
          }
          localc.Kdo.odh.setBackgroundResource(2131231694);
          label1787:
          parama = com.tencent.mm.ai.m.oi(paramString.hDq);
          if (TextUtils.isEmpty(parama)) {
            break label2031;
          }
          localc.Kdo.umZ.setVisibility(0);
          localc.Kdo.umZ.setText(parama);
          label1827:
          parama = localc.Kdo.oeW.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(parambu.field_msgId + "_0").equals(localc.JYu)) {
            break label2046;
          }
          localc.Kdo.oeW.setImageResource(2131231272);
          if ((localc.Kdo.oeW.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.Kdo.oeW.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.Kdo.oeW, parambu, 0);
          a(paramString, parambu, paramInt, localu, localc.Kdo.odh);
          break;
          localc.Kdo.gnM.setVisibility(0);
          localc.Kdo.gnM.setText(paramString.title);
          break label1767;
          label2014:
          localc.Kdo.odh.setBackgroundResource(2131234795);
          break label1787;
          label2031:
          localc.Kdo.umZ.setVisibility(4);
          break label1827;
          label2046:
          localc.Kdo.oeW.setImageResource(2131231271);
        }
      }
      if (paramString.type == 6)
      {
        localObject1 = (v)localLinkedList.get(0);
        if (bt.isNullOrNil(((v)localObject1).title))
        {
          localc.Kdp.gnM.setVisibility(8);
          label2110:
          if (j <= 1) {
            break label2376;
          }
          localc.Kdp.odh.setBackgroundResource(2131231694);
          label2130:
          if (TextUtils.isEmpty(((v)localObject1).hDA)) {
            break label2393;
          }
          localc.Kdp.ofN.setVisibility(0);
          localc.Kdp.ofN.setText(((v)localObject1).hDA);
          label2169:
          if (((v)localObject1).hDB != 2) {
            break label2409;
          }
          localc.Kdp.ofO.setImageResource(2131689903);
          label2192:
          a(localc.Kdp.oeW, parambu, 0);
          a((v)localObject1, parambu, paramInt, localu, localc.Kdp.odh);
          if (!(parambu.field_msgId + "_0").equals(localc.JYu)) {
            break label2426;
          }
          localc.Kdp.oeW.setImageResource(2131689906);
        }
        for (;;)
        {
          localc.Kdp.ocp.setVisibility(8);
          parama = new WeakReference(localc);
          localObject1 = ((v)localObject1).hDm;
          localObject2 = localc.Kdp.ocn;
          i = oaf;
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
              localc.Kdp.ocp.setVisibility(0);
              if ((parambu.field_msgId + "_0").equals(localc.JYu))
              {
                localc.Kdp.oeW.setImageResource(2131231672);
                AppMethodBeat.o(37144);
                return;
              }
              localc.Kdp.oeW.setImageResource(2131231673);
              AppMethodBeat.o(37144);
            }
            
            public final void onStart() {}
          });
          break;
          localc.Kdp.gnM.setVisibility(0);
          localc.Kdp.gnM.setText(((v)localObject1).title);
          break label2110;
          label2376:
          localc.Kdp.odh.setBackgroundResource(2131234795);
          break label2130;
          label2393:
          localc.Kdp.ofN.setVisibility(8);
          break label2169;
          label2409:
          localc.Kdp.ofO.setImageResource(2131689912);
          break label2192;
          label2426:
          localc.Kdp.oeW.setImageResource(2131689909);
        }
      }
      if (paramString.type == 10)
      {
        if (bt.isNullOrNil(paramString.title))
        {
          localc.Kdq.ocA.setVisibility(8);
          if (j <= 1) {
            break label2948;
          }
          localc.Kdq.odh.setBackgroundResource(2131231694);
        }
        for (;;)
        {
          a(paramString, parambu, paramInt, localu, localc.Kdq.odh);
          break;
          localc.Kdq.ocA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(localc.Kdq.ocA, new com.tencent.mm.pluginsdk.ui.span.n(this.JBI.JOR.getContext())));
          localc.Kdq.ocA.setVisibility(0);
          localc.Kdq.ocA.ar(com.tencent.mm.pluginsdk.ui.span.k.g(this.JBI.JOR.getContext(), paramString.title, (int)localc.Kdq.ocA.getTextSize()));
          i = com.tencent.mm.cc.a.ip(this.JBI.JOR.getContext());
          k = (int)(com.tencent.mm.cc.a.getDensity(this.JBI.JOR.getContext()) * 80.0F);
          parama = localc.Kdq.ocA.kK(i - k, 2147483647);
          if (parama != null) {}
          for (i = parama.fSB();; i = 0)
          {
            parama = (LinearLayout.LayoutParams)localc.Kdq.ocA.getLayoutParams();
            localObject1 = (LinearLayout.LayoutParams)localc.Kdq.Kdt.getLayoutParams();
            if (i > 3) {
              break label2784;
            }
            localc.Kdq.Kds.setVisibility(8);
            ((LinearLayout.LayoutParams)localObject1).gravity = 16;
            localc.Kdq.Kdt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = 0;
            parama.gravity = 17;
            localc.Kdq.ocA.setLayoutParams(parama);
            break;
          }
          label2784:
          if (paramString.hDF == 1)
          {
            i = 1;
            label2796:
            localc.Kdq.Kds.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject1).gravity = 48;
            localc.Kdq.Kdt.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = com.tencent.mm.cc.a.fromDPToPix(this.JBI.JOR.getContext(), 38);
            parama.gravity = 8388627;
            if (i == 0) {
              break label2919;
            }
            localc.Kdq.ocA.setMaxLines(2147483647);
            localc.Kdq.Kds.setText(2131756619);
          }
          for (;;)
          {
            localc.Kdq.Kds.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37146);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (paramString.hDF == 1)
                {
                  localc.Kdq.ocA.setMaxLines(3);
                  localc.Kdq.Kds.setText(2131756620);
                }
                for (paramString.hDF = 0;; paramString.hDF = 1)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37146);
                  return;
                  localc.Kdq.ocA.setMaxLines(2147483647);
                  localc.Kdq.Kds.setText(2131756619);
                }
              }
            });
            break;
            i = 0;
            break label2796;
            label2919:
            localc.Kdq.ocA.setMaxLines(3);
            localc.Kdq.Kds.setText(2131756620);
          }
          label2948:
          localc.Kdq.odh.setBackgroundResource(2131234795);
        }
      }
      parama = localc.Kdl.ocA;
      if (j > 1)
      {
        i = 8;
        label2984:
        parama.setVisibility(i);
        parama = localc.Kdl.Kdr;
        if ((j <= 1) && (!bt.isNullOrNil(paramString.hDo))) {
          break label3374;
        }
        i = 8;
        label3020:
        parama.setVisibility(i);
        parama = localc.Kdl.xmO;
        if (j <= 1) {
          break label3380;
        }
      }
      label3374:
      label3380:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.Kdl.xmP.setVisibility(8);
        if (j != 1) {
          break label3387;
        }
        localc.Kdl.ocB.setBackgroundResource(2131231708);
        localc.Kdl.jlR.setVisibility(0);
        X(localc.Kdl.ocL, xmE);
        X(localc.Kdl.ocB, xmE);
        if (bt.isNullOrNil(paramString.hDm)) {
          break label3499;
        }
        localc.Kdl.ocL.setVisibility(0);
        a(paramString.hDm, localc.Kdl.ocn, true, xmE, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37142);
            if (j > 1)
            {
              localc.Kdl.xmO.setTextColor(ae.j.a(ae.j.this).JOR.getContext().getResources().getColor(2131101182));
              localc.Kdl.xmO.setBackgroundResource(2131231208);
            }
            localc.Kdl.xmP.setVisibility(0);
            AppMethodBeat.o(37142);
          }
          
          public final void onStart() {}
        });
        localc.Kdl.jlR.setBackgroundResource(2131231686);
        parama = localc.Kdl.jlR;
        i = oag;
        k = oah;
        int m = oag;
        parama.setPadding(i, k, m, m);
        localc.Kdl.ocB.setVisibility(0);
        localc.Kdl.Kdr.setMaxLines(30);
        localc.Kdl.Kdr.setText(paramString.hDo);
        parama = com.tencent.mm.plugin.brandservice.b.a.nWn;
        com.tencent.mm.plugin.brandservice.b.a.a(paramString.title, localc.Kdl.ocA, paramString, 2);
        parama = com.tencent.mm.plugin.brandservice.b.a.nWn;
        com.tencent.mm.plugin.brandservice.b.a.a(paramString.title, localc.Kdl.xmO, paramString, 21);
        if ((paramString.hDp != 0) && (paramString.hDp != 1)) {
          localc.Kdl.xmO.setVisibility(4);
        }
        a(paramString, parambu, paramInt, localu, localc.Kdl.odh);
        break;
        i = 0;
        break label2984;
        i = 0;
        break label3020;
      }
      label3387:
      parama = localc.Kdl.jlR;
      if (bt.isNullOrNil(paramString.hDm)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.Kdl.ocB.setBackgroundResource(2131231710);
        localc.Kdl.xmO.setTextColor(this.JBI.JOR.getContext().getResources().getColor(2131100541));
        localc.Kdl.xmO.setBackgroundResource(2131233299);
        localc.Kdl.xmO.getPaint().setFakeBoldText(true);
        break;
      }
      label3499:
      localc.Kdl.Kdr.setMaxLines(100);
      localc.Kdl.ocL.setVisibility(8);
      localc.Kdl.ocA.setVisibility(0);
      parama = localc.Kdl.Kdr;
      if (bt.isNullOrNil(paramString.hDo))
      {
        i = 8;
        label3561:
        parama.setVisibility(i);
        if (j != 1) {
          break label3640;
        }
        localc.Kdl.jlR.setBackgroundResource(2131234795);
      }
      for (;;)
      {
        parama = localc.Kdl.jlR;
        i = oag;
        k = oag;
        parama.setPadding(i, i, k, k);
        localc.Kdl.ocB.setVisibility(8);
        break;
        i = 0;
        break label3561;
        label3640:
        localc.Kdl.jlR.setBackgroundResource(2131231694);
      }
      label3657:
      ((ae.a)localObject2).iCM.setVisibility(8);
      break label860;
      label3670:
      ((ae.a)localObject2).iCM.setVisibility(0);
      if (i <= 1) {
        break label849;
      }
      parama = (v)localLinkedList.get(i - 1);
      Object localObject3 = (v)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (bt.isNullOrNil(parama.hDm))) || ((((v)localObject3).type != 7) && (((v)localObject3).type != 5) && (((v)localObject3).type != 6) && (bt.isNullOrNil(((v)localObject3).hDm))))
      {
        Y(((ae.a)localObject2).iCM, oag);
        break label860;
      }
      Y(((ae.a)localObject2).iCM, oak);
      break label860;
      label3818:
      ((ae.a)localObject2).oeQ.setPadding(0, oag, 0, oai);
      break label891;
      label3837:
      if (i == j - 1)
      {
        ((ae.a)localObject2).oeQ.setPadding(0, oai, 0, oag);
        break label891;
      }
      ((ae.a)localObject2).oeQ.setPadding(0, oai, 0, oai);
      break label891;
      parama = parama.getResources().getString(2131757144);
      break label1003;
      parama = parama.getResources().getString(2131757145);
      break label1003;
      parama = parama.getResources().getString(2131757137);
      break label1003;
      label3926:
      parama = com.tencent.mm.plugin.brandservice.b.a.nWn;
      com.tencent.mm.plugin.brandservice.b.a.a(((v)localObject1).title, ((ae.a)localObject2).ocA, (v)localObject1, 3);
      break label1015;
      Object localObject4;
      if (!bt.isNullOrNil(((v)localObject1).hDm))
      {
        ((ae.a)localObject2).ocn.setVisibility(0);
        localObject3 = new WeakReference(localc);
        localObject4 = new WeakReference(localObject2);
        if (bt.isNullOrNil(((v)localObject1).hDD)) {}
        for (parama = ((v)localObject1).hDm;; parama = ((v)localObject1).hDD)
        {
          ImageView localImageView = ((ae.a)localObject2).ocn;
          k = oaf;
          a(parama, localImageView, k, k, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37141);
              if ((this.Kdx.get() != null) && (this.Kdy.get() != null)) {
                ae.j.a(ae.j.this, (ae.c)this.Kdx.get(), (ae.a)this.Kdy.get(), this.ofE, parambu, i);
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
        ((ae.a)localObject2).ocn.setVisibility(0);
        parama = ((ae.a)localObject2).ocn;
        k = oaf;
        localObject3 = q.aIJ();
        localObject4 = new com.tencent.mm.aw.a.a.c.a();
        ((com.tencent.mm.aw.a.a.c.a)localObject4).idp = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject4).idD = 2131100141;
        localObject4 = ((com.tencent.mm.aw.a.a.c.a)localObject4).dh(k, k);
        ((com.tencent.mm.aw.a.a.c.a)localObject4).idu = 4;
        ((com.tencent.mm.aw.a.a)localObject3).a("2131231674", parama, ((com.tencent.mm.aw.a.a.c.a)localObject4).aJc(), null, new com.tencent.mm.pluginsdk.ui.applet.m());
        break label1085;
      }
      ((ae.a)localObject2).oeT.setVisibility(8);
      break label1085;
      ((ae.a)localObject2).oeT.setVisibility(8);
      ((ae.a)localObject2).ocA.setTextColor(parama1.JOR.getContext().getResources().getColor(2131099735));
      break label1085;
      label4219:
      ((ae.a)localObject2).oeS.setVisibility(8);
      break label1127;
      label4232:
      parama = new bk(parambu, false, paramInt, ((v)localObject1).url, this.Kdv, parama1.fCR(), localu.dHo, localu.dHp);
      a(parama, (v)localObject1, parambu);
      ((ae.a)localObject2).odh.setOnClickListener(h(parama1));
    }
    label4292:
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (v)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url))
        {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.url, parama.type, 0, new Object[0]);
          if ((parama.hzk == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNh())) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).cs(parama.url, parama.type);
          }
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(37152);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bu parambu)
  {
    AppMethodBeat.i(37166);
    this.ofG = bt.aQJ();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37166);
      return false;
      paramMenuItem = bl.E(parambu);
      if (bt.isNullOrNil(paramMenuItem))
      {
        e(parama, parambu);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        h.a(parama.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37148);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
            com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37148);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169878);
            ae.j.a(ae.j.this, parama, parambu);
            com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(169878);
          }
        });
        continue;
        paramMenuItem = a(parambu, parama.JOR.getContext(), 0);
        if (!bt.isNullOrNil(paramMenuItem))
        {
          al.c(parambu, paramMenuItem, parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.r.a(this.ofG, this.Kdw, parama.JOR.getContext(), parama.JOR, null, parambu);
          continue;
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Chat_Msg_Id", parambu.field_msgId);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bu parambu)
  {
    AppMethodBeat.i(194424);
    Object localObject = (bk)paramView.getTag();
    if (localObject == null)
    {
      AppMethodBeat.o(194424);
      return false;
    }
    this.Kdw = ((bk)localObject).DUB;
    int i = ((bk)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);
    if (localObject == null)
    {
      ad.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(194424);
      return false;
    }
    this.ofH = false;
    if ((this.Kdw >= 0) && (this.Kdw < ((u)localObject).hDb.size()) && (com.tencent.mm.ai.m.yt(((v)((u)localObject).hDb.get(this.Kdw)).hDr))) {
      this.ofH = true;
    }
    if ((!this.JBI.fFw()) && (!j.bb(parambu))) {
      paraml.a(i, 111, paramView.getContext().getString(2131762559), 2131690478);
    }
    if ((com.tencent.mm.bs.d.aIu("favorite")) && (!this.ofH)) {
      paraml.a(i, 126, paramView.getContext().getString(2131761941), 2131690400);
    }
    if ((i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bu.flY())) {
      paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
    }
    paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(194424);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.j
 * JD-Core Version:    0.7.0.1
 */