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
import android.view.ContextMenu;
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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac$j
  extends c
{
  private static int mWB;
  private static int mWC = 0;
  private static int mWD;
  private static int mWE = 0;
  private static int mWG;
  private static int uWg;
  private boolean GMV = false;
  private int GMW = 0;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private long naJ = 0L;
  private boolean naK = false;
  
  static
  {
    mWD = 0;
  }
  
  private static void U(View paramView, int paramInt)
  {
    AppMethodBeat.i(37155);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37155);
  }
  
  private static void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(37156);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37156);
  }
  
  private static String a(bl parambl, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(37167);
    if (paramContext == null)
    {
      ad.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(37167);
      return null;
    }
    if (parambl == null)
    {
      ad.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(37167);
      return null;
    }
    parambl = com.tencent.mm.ai.m.a(paramContext, paramInt, parambl.field_content, parambl.field_talker, parambl.field_msgId);
    AppMethodBeat.o(37167);
    return parambl;
  }
  
  private static void a(View paramView, ac.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(37159);
    if (paramBoolean)
    {
      if (paramb.mYI == null) {
        paramb.dy(paramView);
      }
      if (paramb.mYI != null)
      {
        paramb.mYI.setVisibility(0);
        AppMethodBeat.o(37159);
      }
    }
    else if (paramb.mYI != null)
    {
      paramb.mYI.setVisibility(8);
    }
    AppMethodBeat.o(37159);
  }
  
  private void a(ImageView paramImageView, bl parambl, int paramInt)
  {
    AppMethodBeat.i(37158);
    e.g localg = new e.g();
    localg.msgId = parambl.field_msgId;
    localg.GKo = paramInt;
    localg.dsv = parambl.field_content;
    paramImageView.setTag(localg);
    paramImageView.setOnClickListener(((i)this.Gob.be(i.class)).eWq());
    AppMethodBeat.o(37158);
  }
  
  private void a(v paramv, View paramView)
  {
    AppMethodBeat.i(37168);
    com.tencent.mm.ui.chatting.r.a(paramv, paramView, this.Gob.getTalkerUserName());
    AppMethodBeat.o(37168);
  }
  
  private void a(v paramv, View paramView, final long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(37169);
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xz(paramv.type)) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169876);
          int i = ac.j.a(ac.j.this).GzJ.getIntExtra("KOpenArticleSceneFromScene", 10000);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt(e.b.FHP, 0);
          paramAnonymousView.putInt(e.b.FHQ, i);
          paramAnonymousView.putInt("geta8key_scene", 7);
          paramAnonymousView.putString("geta8key_username", ac.j.a(ac.j.this).getTalkerUserName());
          l.a(ac.j.a(ac.j.this).GzJ.getContext(), paramLong1, paramInt, this.hmM, paramAnonymousView);
          AppMethodBeat.o(169876);
        }
      });
    }
    AppMethodBeat.o(37169);
  }
  
  private void a(v paramv, bl parambl, int paramInt, u paramu, View paramView)
  {
    AppMethodBeat.i(37153);
    String str = ((com.tencent.mm.ui.chatting.c.b.d)this.Gob.be(com.tencent.mm.ui.chatting.c.b.d.class)).aKF(paramv.url);
    if (!TextUtils.isEmpty(str))
    {
      ad.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramu = new bi(parambl, false, paramInt, paramv.url, false, this.Gob.eWM(), paramu.dxz, paramu.dxA, paramv.title, str, null, false, false);
      paramView.setOnClickListener(i(this.Gob));
    }
    for (;;)
    {
      paramu.AYJ = parambl.field_msgSvrId;
      paramu.AYK = 0;
      paramu.GQX = paramv.type;
      paramView.setTag(paramu);
      if (com.tencent.mm.ai.m.rz(paramv.gKI)) {
        a(paramv, paramView);
      }
      a(paramv, paramView, parambl.field_msgId, parambl.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.Gob));
      paramView.setOnTouchListener(((i)this.Gob.be(i.class)).eWp());
      AppMethodBeat.o(37153);
      return;
      paramu = new bi(parambl, false, paramInt, paramv.url, false, this.Gob.eWM(), paramu.dxz, paramu.dxA, paramv.title);
      a(paramu, paramv, parambl);
      paramView.setOnClickListener(h(this.Gob));
    }
  }
  
  private static void a(ac.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(37160);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.nat, paramc.GMM, bool1);
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
        a(paramc.nat, paramc.GMN, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.nat, paramc.GMO, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.nat, paramc.GMP, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.nat, paramc.GMQ, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.nat;
        paramc = paramc.GML;
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
  
  private void a(ac.c paramc, final ac.a parama, v paramv, bl parambl, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(37157);
    parama.mZO.setVisibility(8);
    if (paramv.type == 5)
    {
      parama.mZQ.setVisibility(0);
      parama.mZQ.setImageResource(2131231270);
      parama.mZQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169877);
          parama.mYI.performClick();
          AppMethodBeat.o(169877);
        }
      });
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.Gob.GzJ.getContext(), 26);
      if (paramv.type != 7) {
        break label457;
      }
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.Gob.GzJ.getContext(), 32);
    }
    for (;;)
    {
      U(parama.mZQ, paramInt);
      AppMethodBeat.o(37157);
      return;
      if (paramv.type == 6)
      {
        parama.mZQ.setVisibility(0);
        if (paramBoolean) {
          if ((parambl.field_msgId + "_" + paramInt).equals(paramc.GIa)) {
            parama.mZQ.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(parama.mZQ, parambl, paramInt);
          break;
          parama.mZQ.setImageResource(2131231673);
          continue;
          if ((parambl.field_msgId + "_" + paramInt).equals(paramc.GIa)) {
            parama.mZQ.setImageResource(2131689906);
          } else {
            parama.mZQ.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        parama.mZQ.setVisibility(8);
        parama.mZO.setVisibility(0);
        Drawable localDrawable = parama.mZP.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((parambl.field_msgId + "_" + paramInt).equals(paramc.GIa))
        {
          parama.mZP.setImageResource(2131231272);
          if ((parama.mZP.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.mZP.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.mZP, parambl, paramInt);
          break;
          parama.mZP.setImageResource(2131231271);
        }
      }
      parama.mZQ.setVisibility(8);
      break;
      label457:
      if (paramv.type == 5) {
        paramInt = com.tencent.mm.cd.a.fromDPToPix(this.Gob.GzJ.getContext(), 24);
      }
    }
  }
  
  private void a(bi parambi, v paramv, bl parambl)
  {
    AppMethodBeat.i(37162);
    Bundle localBundle = new Bundle();
    int i;
    switch (x.aw(b(this.Gob, parambl), this.Gob.getTalkerUserName()))
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
      localBundle.putString("share_report_pre_msg_desc", paramv.gKF);
      localBundle.putString("share_report_pre_msg_icon_url", com.tencent.mm.ai.m.a(paramv));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.Gob.getTalkerUserName());
      }
      parambi.GQV = localBundle;
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
    paramString = com.tencent.mm.api.b.q(paramString, 3);
    com.tencent.mm.aw.a.a locala = o.ayJ();
    com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
    locala1.hki = 2131100141;
    locala1.hjU = true;
    locala1 = locala1.de(paramInt1, paramInt2);
    locala1.hjJ = new com.tencent.mm.pluginsdk.ui.applet.n(2);
    locala1.hkr = new e(2);
    locala1.gjt = com.tencent.mm.pluginsdk.model.r.aAK(paramString);
    locala.a(paramString, paramImageView, locala1.azc(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, null, parama));
    AppMethodBeat.o(37163);
  }
  
  private void a(String paramString, ImageView paramImageView, boolean paramBoolean, int paramInt, m.a parama)
  {
    AppMethodBeat.i(37164);
    paramString = com.tencent.mm.api.b.q(paramString, 3);
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
      f1 = this.Gob.GzJ.getContext().getResources().getDimensionPixelSize(2131166028);
      if (!((i)this.Gob.be(i.class)).isInEditMode()) {
        break label257;
      }
    }
    label257:
    for (int k = 72;; k = 32)
    {
      int m = com.tencent.mm.cd.a.hV(paramImageView.getContext());
      float f2 = com.tencent.mm.cd.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      com.tencent.mm.aw.a.a locala = o.ayJ();
      com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
      locala1.hki = j;
      locala1.hjU = true;
      locala1.hkk = String.valueOf(i);
      locala1 = locala1.de(k, paramInt);
      locala1.hjJ = new com.tencent.mm.pluginsdk.ui.applet.n(2);
      locala1.hkr = new e(2);
      locala1.gjt = com.tencent.mm.pluginsdk.model.r.aAK(paramString);
      locala.a(paramString, paramImageView, locala1.azc(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, k, paramInt, true, bool, f1, parama));
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
  
  private static void dA(View paramView)
  {
    AppMethodBeat.i(37154);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = uWg;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37154);
  }
  
  private void e(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37165);
    if (this.naK)
    {
      if (!this.naK)
      {
        ad.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        AppMethodBeat.o(37165);
        return;
      }
      com.tencent.mm.ui.chatting.r.a(this.GMW, parama.GzJ.getContext(), parambl.field_content, parambl.field_talker, parambl.field_msgId, parambl.field_msgSvrId);
      AppMethodBeat.o(37165);
      return;
    }
    String str = a(parambl, parama.GzJ.getContext(), this.GMW);
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(37165);
      return;
    }
    Intent localIntent = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", str);
    localIntent.putExtra("Retr_Msg_Type", 2);
    localIntent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.GMW);
    localIntent.putExtra("Retr_Msg_Id", parambl.field_msgId);
    localIntent.putExtra("Retr_MsgFromScene", 1);
    str = parambl.field_talker;
    Object localObject = y.tD(parambl.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject);
    localObject = y.arz().E((String)localObject, true);
    ((y.b)localObject).m("prePublishId", "msg_" + parambl.field_msgSvrId);
    ((y.b)localObject).m("preUsername", str);
    ((y.b)localObject).m("preChatName", str);
    ((y.b)localObject).m("preMsgIndex", Integer.valueOf(this.GMW));
    ((y.b)localObject).m("sendAppMsgScene", Integer.valueOf(1));
    parambl = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(parama, parambl.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)parambl.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37165);
  }
  
  private static void jR(Context paramContext)
  {
    AppMethodBeat.i(37151);
    int i;
    int j;
    if (mWE == 0)
    {
      mWE = paramContext.getResources().getDimensionPixelSize(2131165568);
      mWD = paramContext.getResources().getDimensionPixelSize(2131165500);
      mWC = paramContext.getResources().getDimensionPixelSize(2131165480);
      mWB = paramContext.getResources().getDimensionPixelSize(2131166025);
      mWG = paramContext.getResources().getDimensionPixelSize(2131166023);
      i = com.tencent.mm.cd.a.hV(paramContext);
      j = com.tencent.mm.cd.a.hW(paramContext);
      if (i >= j) {
        break label119;
      }
    }
    for (;;)
    {
      uWg = (int)((i - (int)(com.tencent.mm.cd.a.getDensity(paramContext) * 32.0F)) / 2.35D);
      AppMethodBeat.o(37151);
      return;
      label119:
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
      localObject = new af(paramLayoutInflater, 2131493417);
      paramView = new ac.c();
      paramView.fwS = ((TextView)((View)localObject).findViewById(2131298178));
      paramView.GHY = ((View)localObject).findViewById(2131298104);
      paramView.nat = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramView.hIS = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramView.lRB = ((View)localObject).findViewById(2131298147);
      paramView.GIU = ((TextView)((View)localObject).findViewById(2131298023));
      ((View)localObject).setTag(paramView);
    }
    jR(paramLayoutInflater.getContext());
    AppMethodBeat.o(37150);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, final String paramString)
  {
    AppMethodBeat.i(37152);
    this.Gob = parama1;
    jR(parama1.GzJ.getContext());
    final ac.c localc = (ac.c)parama;
    parama = localc.naw.iterator();
    if (parama.hasNext())
    {
      paramString = (ac.a)parama.next();
      if (localc.naw.indexOf(paramString) != localc.naw.size() - 1) {
        com.tencent.mm.ui.chatting.ao.ay(paramString.mYI, 1);
      }
      for (;;)
      {
        localc.nat.removeView(paramString.mYI);
        break;
        com.tencent.mm.ui.chatting.ao.ay(paramString.mYI, 2);
      }
    }
    localc.naw.clear();
    u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
    parama = localu.eOT;
    if ((parama == null) || (parama.length() == 0)) {
      localc.GIU.setVisibility(8);
    }
    LinkedList localLinkedList;
    final int j;
    for (;;)
    {
      localLinkedList = localu.gKs;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.nat.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(37152);
      return;
      localc.GIU.setVisibility(0);
      b(parama1, localc.GIU, bi.aLk(parama));
    }
    localc.nat.setVisibility(0);
    a(localc, ((v)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.GzJ.getActivityLayoutInflater();
    final int i = localc.naw.size() + 2;
    while (i < j)
    {
      paramString = com.tencent.mm.ui.chatting.ao.YD(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493418, null);
      }
      localc.gd(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = com.tencent.mm.ui.chatting.ao.YD(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493419, null);
      }
      localc.gd(parama);
    }
    for (this.GMV = true;; this.GMV = false)
    {
      i = 0;
      while (i < localc.naw.size())
      {
        ((ac.a)localc.naw.get(i)).mYI.setVisibility(8);
        i += 1;
      }
    }
    paramString = (v)localLinkedList.get(0);
    c(paramString);
    label549:
    label619:
    boolean bool;
    label676:
    label730:
    label733:
    Object localObject2;
    int k;
    if (paramString.type == 5)
    {
      dA(localc.GMM.naT);
      dA(localc.GMM.mZZ);
      if (bt.isNullOrNil(paramString.title))
      {
        localc.GMM.naa.setVisibility(8);
        if (j != 1) {
          break label1426;
        }
        localc.GMM.mZZ.setBackgroundResource(2131231708);
        parama = com.tencent.mm.ai.m.mV(paramString.gKH);
        if (TextUtils.isEmpty(parama)) {
          break label1443;
        }
        localc.GMM.timeTv.setVisibility(0);
        localc.GMM.timeTv.setText(parama);
        localc.GMM.timeTv.setTextColor(this.Gob.GzJ.getContext().getResources().getColor(2131100541));
        a(paramString, parambl, paramInt, localu, localc.GMM.mYI);
        localc.GMM.mZY.setVisibility(8);
        parama = paramString.gKD;
        localObject1 = localc.GMM.mZN;
        if (j <= 1) {
          break label1459;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, uWg, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37143);
            localc.GMM.mZY.setVisibility(0);
            localc.GMM.naa.setTextColor(ac.j.a(ac.j.this).GzJ.getContext().getResources().getColor(2131101182));
            localc.GMM.timeTv.setTextColor(ac.j.a(ac.j.this).GzJ.getContext().getResources().getColor(2131101182));
            localc.GMM.mZY.setBackgroundResource(2131231282);
            AppMethodBeat.o(37143);
          }
          
          public final void onStart() {}
        });
        if (com.tencent.mm.cd.a.dT(this.Gob.GzJ.getContext()) <= 1.125F) {
          break label1465;
        }
        localc.GMM.naa.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label4224;
        }
        localObject1 = (v)localLinkedList.get(i);
        c((v)localObject1);
        localObject2 = (ac.a)localc.naw.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3625;
        }
        if ((k != 0) || (!bt.isNullOrNil(((v)localLinkedList.get(0)).gKD))) {
          break label3612;
        }
        ((ac.a)localObject2).hIU.setVisibility(0);
        label843:
        W(((ac.a)localObject2).hIU, mWC);
        label854:
        if (i != 1) {
          break label3792;
        }
        if (i != j - 1) {
          break label3773;
        }
        ((ac.a)localObject2).mZJ.setPadding(0, mWC, 0, mWC);
        label885:
        a(localc, (ac.a)localObject2, (v)localObject1, parambl, i, false);
        ((ac.a)localObject2).naa.setTextColor(parama1.GzJ.getMMResources().getColor(2131100711));
        if (!bt.isNullOrNil(((v)localObject1).title)) {
          break label3881;
        }
        parama = com.tencent.mm.plugin.brandservice.b.b.mSC;
        k = ((v)localObject1).type;
        parama = this.Gob.GzJ.getContext();
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(2131757136);
          label999:
          com.tencent.mm.plugin.brandservice.b.b.a(parama, ((ac.a)localObject2).naa, (v)localObject1, 3);
          label1011:
          if ((((v)localObject1).gKG == 0) || (((v)localObject1).gKG == 1))
          {
            ((ac.a)localObject2).mZM.setVisibility(0);
            ((ac.a)localObject2).naa.setTextColor(com.tencent.mm.ui.ao.aD(parama1.GzJ.getContext(), 2130968584));
            if (((v)localObject1).type == 7)
            {
              ((ac.a)localObject2).mZN.setVisibility(8);
              if ((bt.isNullOrNil(((v)localObject1).gKF)) || (((v)localObject1).type != 3)) {
                break label4151;
              }
              ((ac.a)localObject2).mZL.setText(((v)localObject1).gKF);
              ((ac.a)localObject2).mZL.setVisibility(0);
              ((ac.a)localObject2).mYI.setVisibility(0);
              parama = ((com.tencent.mm.ui.chatting.c.b.d)parama1.be(com.tencent.mm.ui.chatting.c.b.d.class)).aKF(((v)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label4164;
              }
              ad.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new bi(parambl, false, paramInt, ((v)localObject1).url, this.GMV, parama1.eWM(), localu.dxz, localu.dxA, ((v)localObject1).title, parama, null, false, true);
              ((ac.a)localObject2).mYI.setOnClickListener(i(parama1));
            }
          }
          label1078:
          label1120:
          break;
        }
      }
    }
    for (;;)
    {
      parama.AYJ = parambl.field_msgSvrId;
      parama.AYK = i;
      parama.GQX = ((v)localObject1).type;
      ((ac.a)localObject2).mYI.setTag(parama);
      if (com.tencent.mm.ai.m.rz(((v)localObject1).gKI)) {
        a((v)localObject1, ((ac.a)localObject2).mYI);
      }
      a((v)localObject1, ((ac.a)localObject2).mYI, parambl.field_msgId, parambl.field_msgSvrId, i);
      ((ac.a)localObject2).mYI.setOnLongClickListener(c(parama1));
      ((ac.a)localObject2).mYI.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      i += 1;
      break label733;
      localc.GMM.naa.aq(paramString.title);
      localc.GMM.naa.getPaint().setFakeBoldText(true);
      localc.GMM.naa.setVisibility(0);
      localc.GMM.naa.setTextColor(this.Gob.GzJ.getContext().getResources().getColor(2131100541));
      break;
      label1426:
      localc.GMM.mZZ.setBackgroundResource(2131231710);
      break label549;
      label1443:
      localc.GMM.timeTv.setVisibility(8);
      break label619;
      label1459:
      bool = false;
      break label676;
      label1465:
      localc.GMM.naa.setMaxLines(2);
      break label730;
      if (paramString.type == 8)
      {
        dA(localc.GMN.naT);
        dA(localc.GMN.mZZ);
        if (j == 1)
        {
          localc.GMN.mZY.setBackgroundResource(2131231276);
          localc.GMN.mZZ.setBackgroundResource(2131231708);
          localc.GMN.uWr.setBackgroundResource(2131231187);
          label1560:
          localc.GMN.mZY.setVisibility(8);
          localc.GMN.uWr.setVisibility(8);
          localc.GMN.hg.setImageResource(2131689781);
          parama = paramString.gKD;
          localObject1 = localc.GMN.mZN;
          if (j <= 1) {
            break label1714;
          }
        }
        label1714:
        for (bool = true;; bool = false)
        {
          a(parama, (ImageView)localObject1, bool, uWg, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37145);
              localc.GMN.mZY.setVisibility(0);
              localc.GMN.uWr.setVisibility(0);
              localc.GMN.hg.setImageResource(2131689782);
              AppMethodBeat.o(37145);
            }
            
            public final void onStart() {}
          });
          a(paramString, parambl, paramInt, localu, localc.GMN.mYI);
          break;
          localc.GMN.mZY.setBackgroundResource(2131231200);
          localc.GMN.mZZ.setBackgroundResource(2131231710);
          localc.GMN.uWr.setBackgroundResource(2131231277);
          break label1560;
        }
      }
      if (paramString.type == 7)
      {
        if (bt.isNullOrNil(paramString.title))
        {
          localc.GMO.fQp.setVisibility(8);
          label1754:
          if (j <= 1) {
            break label2001;
          }
          localc.GMO.mYI.setBackgroundResource(2131231694);
          label1774:
          parama = com.tencent.mm.ai.m.mV(paramString.gKH);
          if (TextUtils.isEmpty(parama)) {
            break label2018;
          }
          localc.GMO.sgI.setVisibility(0);
          localc.GMO.sgI.setText(parama);
          label1814:
          parama = localc.GMO.mZQ.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(parambl.field_msgId + "_0").equals(localc.GIa)) {
            break label2033;
          }
          localc.GMO.mZQ.setImageResource(2131231272);
          if ((localc.GMO.mZQ.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.GMO.mZQ.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.GMO.mZQ, parambl, 0);
          a(paramString, parambl, paramInt, localu, localc.GMO.mYI);
          break;
          localc.GMO.fQp.setVisibility(0);
          localc.GMO.fQp.setText(paramString.title);
          break label1754;
          label2001:
          localc.GMO.mYI.setBackgroundResource(2131234795);
          break label1774;
          label2018:
          localc.GMO.sgI.setVisibility(4);
          break label1814;
          label2033:
          localc.GMO.mZQ.setImageResource(2131231271);
        }
      }
      if (paramString.type == 6)
      {
        localObject1 = (v)localLinkedList.get(0);
        if (bt.isNullOrNil(((v)localObject1).title))
        {
          localc.GMP.fQp.setVisibility(8);
          label2097:
          if (j <= 1) {
            break label2363;
          }
          localc.GMP.mYI.setBackgroundResource(2131231694);
          label2117:
          if (TextUtils.isEmpty(((v)localObject1).gKR)) {
            break label2380;
          }
          localc.GMP.naQ.setVisibility(0);
          localc.GMP.naQ.setText(((v)localObject1).gKR);
          label2156:
          if (((v)localObject1).gKS != 2) {
            break label2396;
          }
          localc.GMP.naR.setImageResource(2131689903);
          label2179:
          a(localc.GMP.mZQ, parambl, 0);
          a((v)localObject1, parambl, paramInt, localu, localc.GMP.mYI);
          if (!(parambl.field_msgId + "_0").equals(localc.GIa)) {
            break label2413;
          }
          localc.GMP.mZQ.setImageResource(2131689906);
        }
        for (;;)
        {
          localc.GMP.mZY.setVisibility(8);
          parama = new WeakReference(localc);
          localObject1 = ((v)localObject1).gKD;
          localObject2 = localc.GMP.mZN;
          i = mWB;
          a((String)localObject1, (ImageView)localObject2, i, i, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37144);
              ac.c localc = (ac.c)parama.get();
              if (localc == null)
              {
                AppMethodBeat.o(37144);
                return;
              }
              localc.GMP.mZY.setVisibility(0);
              if ((parambl.field_msgId + "_0").equals(localc.GIa))
              {
                localc.GMP.mZQ.setImageResource(2131231672);
                AppMethodBeat.o(37144);
                return;
              }
              localc.GMP.mZQ.setImageResource(2131231673);
              AppMethodBeat.o(37144);
            }
            
            public final void onStart() {}
          });
          break;
          localc.GMP.fQp.setVisibility(0);
          localc.GMP.fQp.setText(((v)localObject1).title);
          break label2097;
          label2363:
          localc.GMP.mYI.setBackgroundResource(2131234795);
          break label2117;
          label2380:
          localc.GMP.naQ.setVisibility(8);
          break label2156;
          label2396:
          localc.GMP.naR.setImageResource(2131689912);
          break label2179;
          label2413:
          localc.GMP.mZQ.setImageResource(2131689909);
        }
      }
      if (paramString.type == 10)
      {
        if (bt.isNullOrNil(paramString.title))
        {
          localc.GMQ.naa.setVisibility(8);
          if (j <= 1) {
            break label2935;
          }
          localc.GMQ.mYI.setBackgroundResource(2131231694);
        }
        for (;;)
        {
          a(paramString, parambl, paramInt, localu, localc.GMQ.mYI);
          break;
          localc.GMQ.naa.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(localc.GMQ.naa, new com.tencent.mm.pluginsdk.ui.span.n(this.Gob.GzJ.getContext())));
          localc.GMQ.naa.setVisibility(0);
          localc.GMQ.naa.aq(k.f(this.Gob.GzJ.getContext(), paramString.title, (int)localc.GMQ.naa.getTextSize()));
          i = com.tencent.mm.cd.a.hV(this.Gob.GzJ.getContext());
          k = (int)(com.tencent.mm.cd.a.getDensity(this.Gob.GzJ.getContext()) * 80.0F);
          parama = localc.GMQ.naa.ki(i - k, 2147483647);
          if (parama != null) {}
          for (i = parama.fkV();; i = 0)
          {
            parama = (LinearLayout.LayoutParams)localc.GMQ.naa.getLayoutParams();
            localObject1 = (LinearLayout.LayoutParams)localc.GMQ.GMU.getLayoutParams();
            if (i > 3) {
              break label2771;
            }
            localc.GMQ.GMS.setVisibility(8);
            ((LinearLayout.LayoutParams)localObject1).gravity = 16;
            localc.GMQ.GMU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = 0;
            parama.gravity = 17;
            localc.GMQ.naa.setLayoutParams(parama);
            break;
          }
          label2771:
          if (paramString.gKW == 1)
          {
            i = 1;
            label2783:
            localc.GMQ.GMS.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject1).gravity = 48;
            localc.GMQ.GMU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = com.tencent.mm.cd.a.fromDPToPix(this.Gob.GzJ.getContext(), 38);
            parama.gravity = 8388627;
            if (i == 0) {
              break label2906;
            }
            localc.GMQ.naa.setMaxLines(2147483647);
            localc.GMQ.GMS.setText(2131756619);
          }
          for (;;)
          {
            localc.GMQ.GMS.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37146);
                if (paramString.gKW == 1)
                {
                  localc.GMQ.naa.setMaxLines(3);
                  localc.GMQ.GMS.setText(2131756620);
                  paramString.gKW = 0;
                  AppMethodBeat.o(37146);
                  return;
                }
                localc.GMQ.naa.setMaxLines(2147483647);
                localc.GMQ.GMS.setText(2131756619);
                paramString.gKW = 1;
                AppMethodBeat.o(37146);
              }
            });
            break;
            i = 0;
            break label2783;
            label2906:
            localc.GMQ.naa.setMaxLines(3);
            localc.GMQ.GMS.setText(2131756620);
          }
          label2935:
          localc.GMQ.mYI.setBackgroundResource(2131234795);
        }
      }
      parama = localc.GML.naa;
      if (j > 1)
      {
        i = 8;
        label2971:
        parama.setVisibility(i);
        parama = localc.GML.GMR;
        if ((j <= 1) && (!bt.isNullOrNil(paramString.gKF))) {
          break label3342;
        }
        i = 8;
        label3007:
        parama.setVisibility(i);
        parama = localc.GML.uWq;
        if (j <= 1) {
          break label3348;
        }
      }
      label3342:
      label3348:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.GML.uWr.setVisibility(8);
        if (j != 1) {
          break label3355;
        }
        localc.GML.mZZ.setBackgroundResource(2131231708);
        localc.GML.isE.setVisibility(0);
        dA(localc.GML.naT);
        dA(localc.GML.mZZ);
        if (bt.isNullOrNil(paramString.gKD)) {
          break label3467;
        }
        localc.GML.naT.setVisibility(0);
        a(paramString.gKD, localc.GML.mZN, true, uWg, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37142);
            if (j > 1)
            {
              localc.GML.uWq.setTextColor(ac.j.a(ac.j.this).GzJ.getContext().getResources().getColor(2131101182));
              localc.GML.uWq.setBackgroundResource(2131231208);
            }
            localc.GML.uWr.setVisibility(0);
            AppMethodBeat.o(37142);
          }
          
          public final void onStart() {}
        });
        localc.GML.isE.setBackgroundResource(2131231686);
        parama = localc.GML.isE;
        i = mWC;
        k = mWD;
        int m = mWC;
        parama.setPadding(i, k, m, m);
        localc.GML.mZZ.setVisibility(0);
        localc.GML.GMR.setText(paramString.gKF);
        parama = com.tencent.mm.plugin.brandservice.b.b.mSC;
        com.tencent.mm.plugin.brandservice.b.b.a(paramString.title, localc.GML.naa, paramString, 2);
        parama = com.tencent.mm.plugin.brandservice.b.b.mSC;
        com.tencent.mm.plugin.brandservice.b.b.a(paramString.title, localc.GML.uWq, paramString, 21);
        if ((paramString.gKG != 0) && (paramString.gKG != 1)) {
          localc.GML.uWq.setVisibility(4);
        }
        a(paramString, parambl, paramInt, localu, localc.GML.mYI);
        break;
        i = 0;
        break label2971;
        i = 0;
        break label3007;
      }
      label3355:
      parama = localc.GML.isE;
      if (bt.isNullOrNil(paramString.gKD)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.GML.mZZ.setBackgroundResource(2131231710);
        localc.GML.uWq.setTextColor(this.Gob.GzJ.getContext().getResources().getColor(2131100541));
        localc.GML.uWq.setBackgroundResource(2131233299);
        localc.GML.uWq.getPaint().setFakeBoldText(true);
        break;
      }
      label3467:
      localc.GML.naT.setVisibility(8);
      localc.GML.naa.setVisibility(0);
      parama = localc.GML.GMR;
      if (bt.isNullOrNil(paramString.gKF))
      {
        i = 8;
        label3516:
        parama.setVisibility(i);
        if (j != 1) {
          break label3595;
        }
        localc.GML.isE.setBackgroundResource(2131234795);
      }
      for (;;)
      {
        parama = localc.GML.isE;
        i = mWC;
        k = mWC;
        parama.setPadding(i, i, k, k);
        localc.GML.mZZ.setVisibility(8);
        break;
        i = 0;
        break label3516;
        label3595:
        localc.GML.isE.setBackgroundResource(2131231694);
      }
      label3612:
      ((ac.a)localObject2).hIU.setVisibility(8);
      break label854;
      label3625:
      ((ac.a)localObject2).hIU.setVisibility(0);
      if (i <= 1) {
        break label843;
      }
      parama = (v)localLinkedList.get(i - 1);
      Object localObject3 = (v)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (bt.isNullOrNil(parama.gKD))) || ((((v)localObject3).type != 7) && (((v)localObject3).type != 5) && (((v)localObject3).type != 6) && (bt.isNullOrNil(((v)localObject3).gKD))))
      {
        W(((ac.a)localObject2).hIU, mWC);
        break label854;
      }
      W(((ac.a)localObject2).hIU, mWG);
      break label854;
      label3773:
      ((ac.a)localObject2).mZJ.setPadding(0, mWC, 0, mWE);
      break label885;
      label3792:
      if (i == j - 1)
      {
        ((ac.a)localObject2).mZJ.setPadding(0, mWE, 0, mWC);
        break label885;
      }
      ((ac.a)localObject2).mZJ.setPadding(0, mWE, 0, mWE);
      break label885;
      parama = parama.getResources().getString(2131757144);
      break label999;
      parama = parama.getResources().getString(2131757145);
      break label999;
      parama = parama.getResources().getString(2131757137);
      break label999;
      label3881:
      parama = com.tencent.mm.plugin.brandservice.b.b.mSC;
      com.tencent.mm.plugin.brandservice.b.b.a(((v)localObject1).title, ((ac.a)localObject2).naa, (v)localObject1, 3);
      break label1011;
      Object localObject4;
      if (!bt.isNullOrNil(((v)localObject1).gKD))
      {
        ((ac.a)localObject2).mZN.setVisibility(0);
        parama = new WeakReference(localc);
        localObject3 = new WeakReference(localObject2);
        localObject4 = com.tencent.mm.ai.m.a((v)localObject1);
        ImageView localImageView = ((ac.a)localObject2).mZN;
        k = mWB;
        a((String)localObject4, localImageView, k, k, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37141);
            if ((parama.get() != null) && (this.GMY.get() != null)) {
              ac.j.a(ac.j.this, (ac.c)parama.get(), (ac.a)this.GMY.get(), this.naH, parambl, i);
            }
            AppMethodBeat.o(37141);
          }
          
          public final void onStart() {}
        });
        break label1078;
      }
      if ((((v)localObject1).type == 5) || (((v)localObject1).type == 6))
      {
        ((ac.a)localObject2).mZN.setVisibility(0);
        parama = ((ac.a)localObject2).mZN;
        k = mWB;
        localObject3 = o.ayJ();
        localObject4 = new com.tencent.mm.aw.a.a.c.a();
        ((com.tencent.mm.aw.a.a.c.a)localObject4).hjS = true;
        ((com.tencent.mm.aw.a.a.c.a)localObject4).hkf = 2131100141;
        localObject4 = ((com.tencent.mm.aw.a.a.c.a)localObject4).de(k, k);
        ((com.tencent.mm.aw.a.a.c.a)localObject4).hjX = 4;
        ((com.tencent.mm.aw.a.a)localObject3).a("2131231674", parama, ((com.tencent.mm.aw.a.a.c.a)localObject4).azc(), null, new com.tencent.mm.pluginsdk.ui.applet.m());
        break label1078;
      }
      ((ac.a)localObject2).mZM.setVisibility(8);
      break label1078;
      ((ac.a)localObject2).mZM.setVisibility(8);
      ((ac.a)localObject2).naa.setTextColor(com.tencent.mm.ui.ao.aD(parama1.GzJ.getContext(), 2130968586));
      break label1078;
      label4151:
      ((ac.a)localObject2).mZL.setVisibility(8);
      break label1120;
      label4164:
      parama = new bi(parambl, false, paramInt, ((v)localObject1).url, this.GMV, parama1.eWM(), localu.dxz, localu.dxA);
      a(parama, (v)localObject1, parambl);
      ((ac.a)localObject2).mYI.setOnClickListener(h(parama1));
    }
    label4224:
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (v)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url))
        {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.url, parama.type, 0, new Object[0]);
          if ((parama.gGA == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBS())) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ck(parama.url, parama.type);
          }
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(37152);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37161);
    Object localObject = (bi)paramView.getTag();
    if (localObject == null)
    {
      AppMethodBeat.o(37161);
      return false;
    }
    this.GMW = ((bi)localObject).AYK;
    int i = ((bi)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
    if (localObject == null)
    {
      ad.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(37161);
      return false;
    }
    this.naK = false;
    if ((this.GMW >= 0) && (this.GMW < ((u)localObject).gKs.size()) && (com.tencent.mm.ai.m.rz(((v)((u)localObject).gKs.get(this.GMW)).gKI))) {
      this.naK = true;
    }
    if ((!this.Gob.eZc()) && (!j.aW(parambl))) {
      paramContextMenu.add(i, 111, 0, paramView.getContext().getString(2131762559));
    }
    if ((com.tencent.mm.bs.d.axB("favorite")) && (!this.naK)) {
      paramContextMenu.add(i, 126, 0, paramView.getContext().getString(2131761941));
    }
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {
      paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
    }
    AppMethodBeat.o(37161);
    return true;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
  {
    AppMethodBeat.i(37166);
    this.naJ = bt.aGK();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37166);
      return false;
      paramMenuItem = bk.C(parambl);
      if (bt.isNullOrNil(paramMenuItem))
      {
        e(parama, parambl);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37148);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
            com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37148);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169878);
            ac.j.a(ac.j.this, parama, parambl);
            com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(169878);
          }
        });
        continue;
        paramMenuItem = a(parambl, parama.GzJ.getContext(), 0);
        if (!bt.isNullOrNil(paramMenuItem))
        {
          al.c(parambl, paramMenuItem, parama.GzJ.getContext());
          continue;
          com.tencent.mm.ui.chatting.r.a(this.naJ, this.GMW, parama.GzJ.getContext(), parama.GzJ, null, parambl);
          continue;
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Chat_Msg_Id", parambl.field_msgId);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        }
      }
    }
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.j
 * JD-Core Version:    0.7.0.1
 */