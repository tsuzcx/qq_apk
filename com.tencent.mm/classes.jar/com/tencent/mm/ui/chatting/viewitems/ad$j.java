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
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bo;
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

public final class ad$j
  extends c
{
  private static int ImW;
  private static int nza;
  private static int nzb = 0;
  private static int nzc;
  private static int nzd = 0;
  private static int nzf;
  private static int weV;
  private com.tencent.mm.ui.chatting.d.a HNS;
  private boolean ImX = false;
  private int ImY = 0;
  private long nDh = 0L;
  private boolean nDi = false;
  
  static
  {
    nzc = 0;
  }
  
  private static void V(View paramView, int paramInt)
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
    AppMethodBeat.i(196723);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(196723);
  }
  
  private static void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(37156);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37156);
  }
  
  private static String a(bo parambo, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(37167);
    if (paramContext == null)
    {
      ac.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(37167);
      return null;
    }
    if (parambo == null)
    {
      ac.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(37167);
      return null;
    }
    parambo = com.tencent.mm.ah.m.a(paramContext, paramInt, parambo.field_content, parambo.field_talker, parambo.field_msgId);
    AppMethodBeat.o(37167);
    return parambo;
  }
  
  private static void a(View paramView, ad.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(37159);
    if (paramBoolean)
    {
      if (paramb.nBh == null) {
        paramb.dA(paramView);
      }
      if (paramb.nBh != null)
      {
        paramb.nBh.setVisibility(0);
        AppMethodBeat.o(37159);
      }
    }
    else if (paramb.nBh != null)
    {
      paramb.nBh.setVisibility(8);
    }
    AppMethodBeat.o(37159);
  }
  
  private void a(ImageView paramImageView, bo parambo, int paramInt)
  {
    AppMethodBeat.i(37158);
    e.g localg = new e.g();
    localg.msgId = parambo.field_msgId;
    localg.Ikl = paramInt;
    localg.dqf = parambo.field_content;
    paramImageView.setTag(localg);
    paramImageView.setOnClickListener(((i)this.HNS.bf(i.class)).fmc());
    AppMethodBeat.o(37158);
  }
  
  private void a(v paramv, View paramView)
  {
    AppMethodBeat.i(37168);
    com.tencent.mm.ui.chatting.r.a(paramv, paramView, this.HNS.getTalkerUserName());
    AppMethodBeat.o(37168);
  }
  
  private void a(v paramv, View paramView, final long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(37169);
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).yr(paramv.type)) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169876);
          int i = ad.j.a(ad.j.this).HZF.getIntExtra("KOpenArticleSceneFromScene", 10000);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt(e.b.HgX, 0);
          paramAnonymousView.putInt(e.b.HgY, i);
          paramAnonymousView.putInt("geta8key_scene", 7);
          paramAnonymousView.putString("geta8key_username", ad.j.a(ad.j.this).getTalkerUserName());
          l.a(ad.j.a(ad.j.this).HZF.getContext(), paramLong1, paramInt, this.hNp, paramAnonymousView);
          AppMethodBeat.o(169876);
        }
      });
    }
    AppMethodBeat.o(37169);
  }
  
  private void a(v paramv, bo parambo, int paramInt, u paramu, View paramView)
  {
    AppMethodBeat.i(37153);
    String str = ((com.tencent.mm.ui.chatting.c.b.d)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.d.class)).aQi(paramv.url);
    if (!TextUtils.isEmpty(str))
    {
      ac.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramu = new bj(parambo, false, paramInt, paramv.url, false, this.HNS.fmy(), paramu.dvl, paramu.dvm, paramv.title, str, null, false, false);
      paramView.setOnClickListener(i(this.HNS));
    }
    for (;;)
    {
      paramu.CqW = parambo.field_msgSvrId;
      paramu.CqX = 0;
      paramu.IqY = paramv.type;
      paramView.setTag(paramu);
      if (com.tencent.mm.ah.m.vC(paramv.hli)) {
        a(paramv, paramView);
      }
      a(paramv, paramView, parambo.field_msgId, parambo.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.HNS));
      paramView.setOnTouchListener(((i)this.HNS.bf(i.class)).fmb());
      AppMethodBeat.o(37153);
      return;
      paramu = new bj(parambo, false, paramInt, paramv.url, false, this.HNS.fmy(), paramu.dvl, paramu.dvm, paramv.title);
      a(paramu, paramv, parambo);
      paramView.setOnClickListener(h(this.HNS));
    }
  }
  
  private static void a(ad.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(37160);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.nCR, paramc.ImO, bool1);
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
        a(paramc.nCR, paramc.ImP, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.nCR, paramc.ImQ, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.nCR, paramc.ImR, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.nCR, paramc.ImS, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.nCR;
        paramc = paramc.ImN;
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
  
  private void a(ad.c paramc, final ad.a parama, v paramv, bo parambo, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(37157);
    parama.nCm.setVisibility(8);
    if (paramv.type == 5)
    {
      parama.nCo.setVisibility(0);
      parama.nCo.setImageResource(2131231270);
      parama.nCo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169877);
          parama.nBh.performClick();
          AppMethodBeat.o(169877);
        }
      });
      paramInt = com.tencent.mm.cc.a.fromDPToPix(this.HNS.HZF.getContext(), 26);
      if (paramv.type != 7) {
        break label457;
      }
      paramInt = com.tencent.mm.cc.a.fromDPToPix(this.HNS.HZF.getContext(), 32);
    }
    for (;;)
    {
      V(parama.nCo, paramInt);
      AppMethodBeat.o(37157);
      return;
      if (paramv.type == 6)
      {
        parama.nCo.setVisibility(0);
        if (paramBoolean) {
          if ((parambo.field_msgId + "_" + paramInt).equals(paramc.IhX)) {
            parama.nCo.setImageResource(2131231672);
          }
        }
        for (;;)
        {
          a(parama.nCo, parambo, paramInt);
          break;
          parama.nCo.setImageResource(2131231673);
          continue;
          if ((parambo.field_msgId + "_" + paramInt).equals(paramc.IhX)) {
            parama.nCo.setImageResource(2131689906);
          } else {
            parama.nCo.setImageResource(2131689909);
          }
        }
      }
      if (paramv.type == 7)
      {
        parama.nCo.setVisibility(8);
        parama.nCm.setVisibility(0);
        Drawable localDrawable = parama.nCn.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((parambo.field_msgId + "_" + paramInt).equals(paramc.IhX))
        {
          parama.nCn.setImageResource(2131231272);
          if ((parama.nCn.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.nCn.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.nCn, parambo, paramInt);
          break;
          parama.nCn.setImageResource(2131231271);
        }
      }
      parama.nCo.setVisibility(8);
      break;
      label457:
      if (paramv.type == 5) {
        paramInt = com.tencent.mm.cc.a.fromDPToPix(this.HNS.HZF.getContext(), 24);
      }
    }
  }
  
  private void a(bj parambj, v paramv, bo parambo)
  {
    AppMethodBeat.i(37162);
    Bundle localBundle = new Bundle();
    int i;
    switch (x.aE(b(this.HNS, parambo), this.HNS.getTalkerUserName()))
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
      localBundle.putString("share_report_pre_msg_desc", paramv.hlf);
      localBundle.putString("share_report_pre_msg_icon_url", com.tencent.mm.ah.m.a(paramv));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.HNS.getTalkerUserName());
      }
      parambj.IqW = localBundle;
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
    com.tencent.mm.av.a.a locala = o.aFB();
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.hKL = 2131100141;
    locala1.hKx = true;
    locala1 = locala1.de(paramInt1, paramInt2);
    locala1.hKm = new com.tencent.mm.pluginsdk.ui.applet.n(2);
    locala1.hKU = new e(2);
    locala1.gKe = com.tencent.mm.pluginsdk.model.r.aGc(paramString);
    locala.a(paramString, paramImageView, locala1.aFT(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, null, parama));
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
      f1 = this.HNS.HZF.getContext().getResources().getDimensionPixelSize(2131166028);
      if (!((i)this.HNS.bf(i.class)).isInEditMode()) {
        break label257;
      }
    }
    label257:
    for (int k = 72;; k = 32)
    {
      int m = com.tencent.mm.cc.a.ig(paramImageView.getContext());
      float f2 = com.tencent.mm.cc.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      com.tencent.mm.av.a.a locala = o.aFB();
      com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
      locala1.hKL = j;
      locala1.hKx = true;
      locala1.hKN = String.valueOf(i);
      locala1 = locala1.de(k, paramInt);
      locala1.hKm = new com.tencent.mm.pluginsdk.ui.applet.n(2);
      locala1.hKU = new e(2);
      locala1.gKe = com.tencent.mm.pluginsdk.model.r.aGc(paramString);
      locala.a(paramString, paramImageView, locala1.aFT(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, k, paramInt, true, bool, f1, parama));
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
  
  private void e(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37165);
    if (this.nDi)
    {
      if (!this.nDi)
      {
        ac.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        AppMethodBeat.o(37165);
        return;
      }
      com.tencent.mm.ui.chatting.r.a(this.ImY, parama.HZF.getContext(), parambo.field_content, parambo.field_talker, parambo.field_msgId, parambo.field_msgSvrId);
      AppMethodBeat.o(37165);
      return;
    }
    String str = a(parambo, parama.HZF.getContext(), this.ImY);
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(37165);
      return;
    }
    Intent localIntent = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", str);
    localIntent.putExtra("Retr_Msg_Type", 2);
    localIntent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.ImY);
    localIntent.putExtra("Retr_Msg_Id", parambo.field_msgId);
    localIntent.putExtra("Retr_MsgFromScene", 1);
    str = parambo.field_talker;
    Object localObject = y.xJ(parambo.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject);
    localObject = y.ayq().F((String)localObject, true);
    ((y.b)localObject).l("prePublishId", "msg_" + parambo.field_msgSvrId);
    ((y.b)localObject).l("preUsername", str);
    ((y.b)localObject).l("preChatName", str);
    ((y.b)localObject).l("preMsgIndex", Integer.valueOf(this.ImY));
    ((y.b)localObject).l("sendAppMsgScene", Integer.valueOf(1));
    parambo = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(parama, parambo.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)parambo.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37165);
  }
  
  private static void kc(Context paramContext)
  {
    AppMethodBeat.i(37151);
    int i;
    int j;
    if (nzd == 0)
    {
      nzd = paramContext.getResources().getDimensionPixelSize(2131165568);
      nzc = paramContext.getResources().getDimensionPixelSize(2131165500);
      nzb = paramContext.getResources().getDimensionPixelSize(2131165480);
      nza = paramContext.getResources().getDimensionPixelSize(2131166025);
      nzf = paramContext.getResources().getDimensionPixelSize(2131166023);
      i = com.tencent.mm.cc.a.ig(paramContext);
      j = com.tencent.mm.cc.a.ih(paramContext);
      if (i >= j) {
        break label131;
      }
    }
    for (;;)
    {
      i -= (int)(com.tencent.mm.cc.a.getDensity(paramContext) * 32.0F);
      weV = (int)(i / 2.35D);
      ImW = (int)(i / 1.777778F);
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
      localObject = new ag(paramLayoutInflater, 2131493417);
      paramView = new ad.c();
      paramView.fAz = ((TextView)((View)localObject).findViewById(2131298178));
      paramView.IhV = ((View)localObject).findViewById(2131298104);
      paramView.nCR = ((LinearLayout)((View)localObject).findViewById(2131298075));
      paramView.ijt = ((CheckBox)((View)localObject).findViewById(2131298068));
      paramView.gGk = ((View)localObject).findViewById(2131298147);
      paramView.IiR = ((TextView)((View)localObject).findViewById(2131298023));
      ((View)localObject).setTag(paramView);
    }
    kc(paramLayoutInflater.getContext());
    AppMethodBeat.o(37150);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, final String paramString)
  {
    AppMethodBeat.i(37152);
    this.HNS = parama1;
    kc(parama1.HZF.getContext());
    final ad.c localc = (ad.c)parama;
    parama = localc.nCU.iterator();
    if (parama.hasNext())
    {
      paramString = (ad.a)parama.next();
      if (localc.nCU.indexOf(paramString) != localc.nCU.size() - 1) {
        com.tencent.mm.ui.chatting.ao.aA(paramString.nBh, 1);
      }
      for (;;)
      {
        localc.nCR.removeView(paramString.nBh);
        break;
        com.tencent.mm.ui.chatting.ao.aA(paramString.nBh, 2);
      }
    }
    localc.nCU.clear();
    u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);
    parama = localu.eSb;
    if ((parama == null) || (parama.length() == 0)) {
      localc.IiR.setVisibility(8);
    }
    LinkedList localLinkedList;
    final int j;
    for (;;)
    {
      localLinkedList = localu.hkS;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.nCR.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(37152);
      return;
      localc.IiR.setVisibility(0);
      b(parama1, localc.IiR, bj.aQO(parama));
    }
    localc.nCR.setVisibility(0);
    a(localc, ((v)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.HZF.getActivityLayoutInflater();
    final int i = localc.nCU.size() + 2;
    while (i < j)
    {
      paramString = com.tencent.mm.ui.chatting.ao.aaO(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493418, null);
      }
      localc.gq(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = com.tencent.mm.ui.chatting.ao.aaO(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493419, null);
      }
      localc.gq(parama);
    }
    for (this.ImX = true;; this.ImX = false)
    {
      i = 0;
      while (i < localc.nCU.size())
      {
        ((ad.a)localc.nCU.get(i)).nBh.setVisibility(8);
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
      W(localc.ImO.nDr, ImW);
      W(localc.ImO.nCx, ImW);
      if (bs.isNullOrNil(paramString.title))
      {
        localc.ImO.nCy.setVisibility(8);
        if (j != 1) {
          break label1430;
        }
        localc.ImO.nCx.setBackgroundResource(2131231708);
        parama = com.tencent.mm.ah.m.nJ(paramString.hlh);
        if (TextUtils.isEmpty(parama)) {
          break label1447;
        }
        localc.ImO.timeTv.setVisibility(0);
        localc.ImO.timeTv.setText(parama);
        localc.ImO.timeTv.setTextColor(this.HNS.HZF.getContext().getResources().getColor(2131100541));
        a(paramString, parambo, paramInt, localu, localc.ImO.nBh);
        localc.ImO.nCw.setVisibility(8);
        parama = paramString.hld;
        localObject1 = localc.ImO.nCl;
        if (j <= 1) {
          break label1463;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, ImW, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37143);
            localc.ImO.nCw.setVisibility(0);
            localc.ImO.nCy.setTextColor(ad.j.a(ad.j.this).HZF.getContext().getResources().getColor(2131101182));
            localc.ImO.timeTv.setTextColor(ad.j.a(ad.j.this).HZF.getContext().getResources().getColor(2131101182));
            localc.ImO.nCw.setBackgroundResource(2131231282);
            AppMethodBeat.o(37143);
          }
          
          public final void onStart() {}
        });
        if (com.tencent.mm.cc.a.eb(this.HNS.HZF.getContext()) <= 1.125F) {
          break label1469;
        }
        localc.ImO.nCy.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label4286;
        }
        localObject1 = (v)localLinkedList.get(i);
        c((v)localObject1);
        localObject2 = (ad.a)localc.nCU.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3667;
        }
        if ((k != 0) || (!bs.isNullOrNil(((v)localLinkedList.get(0)).hld))) {
          break label3654;
        }
        ((ad.a)localObject2).ijv.setVisibility(0);
        label849:
        X(((ad.a)localObject2).ijv, nzb);
        label860:
        if (i != 1) {
          break label3834;
        }
        if (i != j - 1) {
          break label3815;
        }
        ((ad.a)localObject2).nCh.setPadding(0, nzb, 0, nzb);
        label891:
        a(localc, (ad.a)localObject2, (v)localObject1, parambo, i, false);
        ((ad.a)localObject2).nCy.setTextColor(parama1.HZF.getMMResources().getColor(2131100711));
        if (!bs.isNullOrNil(((v)localObject1).title)) {
          break label3923;
        }
        parama = com.tencent.mm.plugin.brandservice.b.a.nuP;
        k = ((v)localObject1).type;
        parama = this.HNS.HZF.getContext();
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(2131757136);
          label1003:
          com.tencent.mm.plugin.brandservice.b.a.a(parama, ((ad.a)localObject2).nCy, (v)localObject1, 3);
          label1015:
          if ((((v)localObject1).hlg == 0) || (((v)localObject1).hlg == 1))
          {
            ((ad.a)localObject2).nCk.setVisibility(0);
            ((ad.a)localObject2).nCy.setTextColor(com.tencent.mm.ui.ao.aJ(parama1.HZF.getContext(), 2130968584));
            if (((v)localObject1).type == 7)
            {
              ((ad.a)localObject2).nCl.setVisibility(8);
              if ((bs.isNullOrNil(((v)localObject1).hlf)) || (((v)localObject1).type != 3)) {
                break label4213;
              }
              ((ad.a)localObject2).nCj.setText(((v)localObject1).hlf);
              ((ad.a)localObject2).nCj.setVisibility(0);
              ((ad.a)localObject2).nBh.setVisibility(0);
              parama = ((com.tencent.mm.ui.chatting.c.b.d)parama1.bf(com.tencent.mm.ui.chatting.c.b.d.class)).aQi(((v)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label4226;
              }
              ac.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new bj(parambo, false, paramInt, ((v)localObject1).url, this.ImX, parama1.fmy(), localu.dvl, localu.dvm, ((v)localObject1).title, parama, null, false, true);
              ((ad.a)localObject2).nBh.setOnClickListener(i(parama1));
            }
          }
          label1082:
          label1124:
          break;
        }
      }
    }
    for (;;)
    {
      parama.CqW = parambo.field_msgSvrId;
      parama.CqX = i;
      parama.IqY = ((v)localObject1).type;
      ((ad.a)localObject2).nBh.setTag(parama);
      if (com.tencent.mm.ah.m.vC(((v)localObject1).hli)) {
        a((v)localObject1, ((ad.a)localObject2).nBh);
      }
      a((v)localObject1, ((ad.a)localObject2).nBh, parambo.field_msgId, parambo.field_msgSvrId, i);
      ((ad.a)localObject2).nBh.setOnLongClickListener(c(parama1));
      ((ad.a)localObject2).nBh.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      i += 1;
      break label739;
      localc.ImO.nCy.ar(paramString.title);
      localc.ImO.nCy.getPaint().setFakeBoldText(true);
      localc.ImO.nCy.setVisibility(0);
      localc.ImO.nCy.setTextColor(this.HNS.HZF.getContext().getResources().getColor(2131100541));
      break;
      label1430:
      localc.ImO.nCx.setBackgroundResource(2131231710);
      break label555;
      label1447:
      localc.ImO.timeTv.setVisibility(8);
      break label625;
      label1463:
      bool = false;
      break label682;
      label1469:
      localc.ImO.nCy.setMaxLines(2);
      break label736;
      if (paramString.type == 8)
      {
        W(localc.ImP.nDr, weV);
        W(localc.ImP.nCx, weV);
        if (j == 1)
        {
          localc.ImP.nCw.setBackgroundResource(2131231276);
          localc.ImP.nCx.setBackgroundResource(2131231708);
          localc.ImP.wfg.setBackgroundResource(2131231187);
          label1570:
          localc.ImP.nCw.setVisibility(8);
          localc.ImP.wfg.setVisibility(8);
          localc.ImP.ig.setImageResource(2131689781);
          parama = paramString.hld;
          localObject1 = localc.ImP.nCl;
          if (j <= 1) {
            break label1724;
          }
        }
        label1724:
        for (bool = true;; bool = false)
        {
          a(parama, (ImageView)localObject1, bool, weV, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37145);
              localc.ImP.nCw.setVisibility(0);
              localc.ImP.wfg.setVisibility(0);
              localc.ImP.ig.setImageResource(2131689782);
              AppMethodBeat.o(37145);
            }
            
            public final void onStart() {}
          });
          a(paramString, parambo, paramInt, localu, localc.ImP.nBh);
          break;
          localc.ImP.nCw.setBackgroundResource(2131231200);
          localc.ImP.nCx.setBackgroundResource(2131231710);
          localc.ImP.wfg.setBackgroundResource(2131231277);
          break label1570;
        }
      }
      if (paramString.type == 7)
      {
        if (bs.isNullOrNil(paramString.title))
        {
          localc.ImQ.fUk.setVisibility(8);
          label1764:
          if (j <= 1) {
            break label2011;
          }
          localc.ImQ.nBh.setBackgroundResource(2131231694);
          label1784:
          parama = com.tencent.mm.ah.m.nJ(paramString.hlh);
          if (TextUtils.isEmpty(parama)) {
            break label2028;
          }
          localc.ImQ.toC.setVisibility(0);
          localc.ImQ.toC.setText(parama);
          label1824:
          parama = localc.ImQ.nCo.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(parambo.field_msgId + "_0").equals(localc.IhX)) {
            break label2043;
          }
          localc.ImQ.nCo.setImageResource(2131231272);
          if ((localc.ImQ.nCo.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.ImQ.nCo.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.ImQ.nCo, parambo, 0);
          a(paramString, parambo, paramInt, localu, localc.ImQ.nBh);
          break;
          localc.ImQ.fUk.setVisibility(0);
          localc.ImQ.fUk.setText(paramString.title);
          break label1764;
          label2011:
          localc.ImQ.nBh.setBackgroundResource(2131234795);
          break label1784;
          label2028:
          localc.ImQ.toC.setVisibility(4);
          break label1824;
          label2043:
          localc.ImQ.nCo.setImageResource(2131231271);
        }
      }
      if (paramString.type == 6)
      {
        localObject1 = (v)localLinkedList.get(0);
        if (bs.isNullOrNil(((v)localObject1).title))
        {
          localc.ImR.fUk.setVisibility(8);
          label2107:
          if (j <= 1) {
            break label2373;
          }
          localc.ImR.nBh.setBackgroundResource(2131231694);
          label2127:
          if (TextUtils.isEmpty(((v)localObject1).hlr)) {
            break label2390;
          }
          localc.ImR.nDo.setVisibility(0);
          localc.ImR.nDo.setText(((v)localObject1).hlr);
          label2166:
          if (((v)localObject1).hls != 2) {
            break label2406;
          }
          localc.ImR.nDp.setImageResource(2131689903);
          label2189:
          a(localc.ImR.nCo, parambo, 0);
          a((v)localObject1, parambo, paramInt, localu, localc.ImR.nBh);
          if (!(parambo.field_msgId + "_0").equals(localc.IhX)) {
            break label2423;
          }
          localc.ImR.nCo.setImageResource(2131689906);
        }
        for (;;)
        {
          localc.ImR.nCw.setVisibility(8);
          parama = new WeakReference(localc);
          localObject1 = ((v)localObject1).hld;
          localObject2 = localc.ImR.nCl;
          i = nza;
          a((String)localObject1, (ImageView)localObject2, i, i, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37144);
              ad.c localc = (ad.c)parama.get();
              if (localc == null)
              {
                AppMethodBeat.o(37144);
                return;
              }
              localc.ImR.nCw.setVisibility(0);
              if ((parambo.field_msgId + "_0").equals(localc.IhX))
              {
                localc.ImR.nCo.setImageResource(2131231672);
                AppMethodBeat.o(37144);
                return;
              }
              localc.ImR.nCo.setImageResource(2131231673);
              AppMethodBeat.o(37144);
            }
            
            public final void onStart() {}
          });
          break;
          localc.ImR.fUk.setVisibility(0);
          localc.ImR.fUk.setText(((v)localObject1).title);
          break label2107;
          label2373:
          localc.ImR.nBh.setBackgroundResource(2131234795);
          break label2127;
          label2390:
          localc.ImR.nDo.setVisibility(8);
          break label2166;
          label2406:
          localc.ImR.nDp.setImageResource(2131689912);
          break label2189;
          label2423:
          localc.ImR.nCo.setImageResource(2131689909);
        }
      }
      if (paramString.type == 10)
      {
        if (bs.isNullOrNil(paramString.title))
        {
          localc.ImS.nCy.setVisibility(8);
          if (j <= 1) {
            break label2945;
          }
          localc.ImS.nBh.setBackgroundResource(2131231694);
        }
        for (;;)
        {
          a(paramString, parambo, paramInt, localu, localc.ImS.nBh);
          break;
          localc.ImS.nCy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.g(localc.ImS.nCy, new com.tencent.mm.pluginsdk.ui.span.n(this.HNS.HZF.getContext())));
          localc.ImS.nCy.setVisibility(0);
          localc.ImS.nCy.ar(k.g(this.HNS.HZF.getContext(), paramString.title, (int)localc.ImS.nCy.getTextSize()));
          i = com.tencent.mm.cc.a.ig(this.HNS.HZF.getContext());
          k = (int)(com.tencent.mm.cc.a.getDensity(this.HNS.HZF.getContext()) * 80.0F);
          parama = localc.ImS.nCy.kv(i - k, 2147483647);
          if (parama != null) {}
          for (i = parama.fBm();; i = 0)
          {
            parama = (LinearLayout.LayoutParams)localc.ImS.nCy.getLayoutParams();
            localObject1 = (LinearLayout.LayoutParams)localc.ImS.ImV.getLayoutParams();
            if (i > 3) {
              break label2781;
            }
            localc.ImS.ImU.setVisibility(8);
            ((LinearLayout.LayoutParams)localObject1).gravity = 16;
            localc.ImS.ImV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = 0;
            parama.gravity = 17;
            localc.ImS.nCy.setLayoutParams(parama);
            break;
          }
          label2781:
          if (paramString.hlw == 1)
          {
            i = 1;
            label2793:
            localc.ImS.ImU.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject1).gravity = 48;
            localc.ImS.ImV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = com.tencent.mm.cc.a.fromDPToPix(this.HNS.HZF.getContext(), 38);
            parama.gravity = 8388627;
            if (i == 0) {
              break label2916;
            }
            localc.ImS.nCy.setMaxLines(2147483647);
            localc.ImS.ImU.setText(2131756619);
          }
          for (;;)
          {
            localc.ImS.ImU.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37146);
                if (paramString.hlw == 1)
                {
                  localc.ImS.nCy.setMaxLines(3);
                  localc.ImS.ImU.setText(2131756620);
                  paramString.hlw = 0;
                  AppMethodBeat.o(37146);
                  return;
                }
                localc.ImS.nCy.setMaxLines(2147483647);
                localc.ImS.ImU.setText(2131756619);
                paramString.hlw = 1;
                AppMethodBeat.o(37146);
              }
            });
            break;
            i = 0;
            break label2793;
            label2916:
            localc.ImS.nCy.setMaxLines(3);
            localc.ImS.ImU.setText(2131756620);
          }
          label2945:
          localc.ImS.nBh.setBackgroundResource(2131234795);
        }
      }
      parama = localc.ImN.nCy;
      if (j > 1)
      {
        i = 8;
        label2981:
        parama.setVisibility(i);
        parama = localc.ImN.ImT;
        if ((j <= 1) && (!bs.isNullOrNil(paramString.hlf))) {
          break label3371;
        }
        i = 8;
        label3017:
        parama.setVisibility(i);
        parama = localc.ImN.wff;
        if (j <= 1) {
          break label3377;
        }
      }
      label3371:
      label3377:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.ImN.wfg.setVisibility(8);
        if (j != 1) {
          break label3384;
        }
        localc.ImN.nCx.setBackgroundResource(2131231708);
        localc.ImN.iSJ.setVisibility(0);
        W(localc.ImN.nDr, weV);
        W(localc.ImN.nCx, weV);
        if (bs.isNullOrNil(paramString.hld)) {
          break label3496;
        }
        localc.ImN.nDr.setVisibility(0);
        a(paramString.hld, localc.ImN.nCl, true, weV, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37142);
            if (j > 1)
            {
              localc.ImN.wff.setTextColor(ad.j.a(ad.j.this).HZF.getContext().getResources().getColor(2131101182));
              localc.ImN.wff.setBackgroundResource(2131231208);
            }
            localc.ImN.wfg.setVisibility(0);
            AppMethodBeat.o(37142);
          }
          
          public final void onStart() {}
        });
        localc.ImN.iSJ.setBackgroundResource(2131231686);
        parama = localc.ImN.iSJ;
        i = nzb;
        k = nzc;
        int m = nzb;
        parama.setPadding(i, k, m, m);
        localc.ImN.nCx.setVisibility(0);
        localc.ImN.ImT.setMaxLines(30);
        localc.ImN.ImT.setText(paramString.hlf);
        parama = com.tencent.mm.plugin.brandservice.b.a.nuP;
        com.tencent.mm.plugin.brandservice.b.a.a(paramString.title, localc.ImN.nCy, paramString, 2);
        parama = com.tencent.mm.plugin.brandservice.b.a.nuP;
        com.tencent.mm.plugin.brandservice.b.a.a(paramString.title, localc.ImN.wff, paramString, 21);
        if ((paramString.hlg != 0) && (paramString.hlg != 1)) {
          localc.ImN.wff.setVisibility(4);
        }
        a(paramString, parambo, paramInt, localu, localc.ImN.nBh);
        break;
        i = 0;
        break label2981;
        i = 0;
        break label3017;
      }
      label3384:
      parama = localc.ImN.iSJ;
      if (bs.isNullOrNil(paramString.hld)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.ImN.nCx.setBackgroundResource(2131231710);
        localc.ImN.wff.setTextColor(this.HNS.HZF.getContext().getResources().getColor(2131100541));
        localc.ImN.wff.setBackgroundResource(2131233299);
        localc.ImN.wff.getPaint().setFakeBoldText(true);
        break;
      }
      label3496:
      localc.ImN.ImT.setMaxLines(100);
      localc.ImN.nDr.setVisibility(8);
      localc.ImN.nCy.setVisibility(0);
      parama = localc.ImN.ImT;
      if (bs.isNullOrNil(paramString.hlf))
      {
        i = 8;
        label3558:
        parama.setVisibility(i);
        if (j != 1) {
          break label3637;
        }
        localc.ImN.iSJ.setBackgroundResource(2131234795);
      }
      for (;;)
      {
        parama = localc.ImN.iSJ;
        i = nzb;
        k = nzb;
        parama.setPadding(i, i, k, k);
        localc.ImN.nCx.setVisibility(8);
        break;
        i = 0;
        break label3558;
        label3637:
        localc.ImN.iSJ.setBackgroundResource(2131231694);
      }
      label3654:
      ((ad.a)localObject2).ijv.setVisibility(8);
      break label860;
      label3667:
      ((ad.a)localObject2).ijv.setVisibility(0);
      if (i <= 1) {
        break label849;
      }
      parama = (v)localLinkedList.get(i - 1);
      Object localObject3 = (v)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (bs.isNullOrNil(parama.hld))) || ((((v)localObject3).type != 7) && (((v)localObject3).type != 5) && (((v)localObject3).type != 6) && (bs.isNullOrNil(((v)localObject3).hld))))
      {
        X(((ad.a)localObject2).ijv, nzb);
        break label860;
      }
      X(((ad.a)localObject2).ijv, nzf);
      break label860;
      label3815:
      ((ad.a)localObject2).nCh.setPadding(0, nzb, 0, nzd);
      break label891;
      label3834:
      if (i == j - 1)
      {
        ((ad.a)localObject2).nCh.setPadding(0, nzd, 0, nzb);
        break label891;
      }
      ((ad.a)localObject2).nCh.setPadding(0, nzd, 0, nzd);
      break label891;
      parama = parama.getResources().getString(2131757144);
      break label1003;
      parama = parama.getResources().getString(2131757145);
      break label1003;
      parama = parama.getResources().getString(2131757137);
      break label1003;
      label3923:
      parama = com.tencent.mm.plugin.brandservice.b.a.nuP;
      com.tencent.mm.plugin.brandservice.b.a.a(((v)localObject1).title, ((ad.a)localObject2).nCy, (v)localObject1, 3);
      break label1015;
      Object localObject4;
      if (!bs.isNullOrNil(((v)localObject1).hld))
      {
        ((ad.a)localObject2).nCl.setVisibility(0);
        localObject3 = new WeakReference(localc);
        localObject4 = new WeakReference(localObject2);
        if (bs.isNullOrNil(((v)localObject1).hlu)) {}
        for (parama = ((v)localObject1).hld;; parama = ((v)localObject1).hlu)
        {
          ImageView localImageView = ((ad.a)localObject2).nCl;
          k = nza;
          a(parama, localImageView, k, k, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37141);
              if ((this.ImZ.get() != null) && (this.Ina.get() != null)) {
                ad.j.a(ad.j.this, (ad.c)this.ImZ.get(), (ad.a)this.Ina.get(), this.nDf, parambo, i);
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
        ((ad.a)localObject2).nCl.setVisibility(0);
        parama = ((ad.a)localObject2).nCl;
        k = nza;
        localObject3 = o.aFB();
        localObject4 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject4).hKv = true;
        ((com.tencent.mm.av.a.a.c.a)localObject4).hKI = 2131100141;
        localObject4 = ((com.tencent.mm.av.a.a.c.a)localObject4).de(k, k);
        ((com.tencent.mm.av.a.a.c.a)localObject4).hKA = 4;
        ((com.tencent.mm.av.a.a)localObject3).a("2131231674", parama, ((com.tencent.mm.av.a.a.c.a)localObject4).aFT(), null, new com.tencent.mm.pluginsdk.ui.applet.m());
        break label1082;
      }
      ((ad.a)localObject2).nCk.setVisibility(8);
      break label1082;
      ((ad.a)localObject2).nCk.setVisibility(8);
      ((ad.a)localObject2).nCy.setTextColor(com.tencent.mm.ui.ao.aJ(parama1.HZF.getContext(), 2130968586));
      break label1082;
      label4213:
      ((ad.a)localObject2).nCj.setVisibility(8);
      break label1124;
      label4226:
      parama = new bj(parambo, false, paramInt, ((v)localObject1).url, this.ImX, parama1.fmy(), localu.dvl, localu.dvm);
      a(parama, (v)localObject1, parambo);
      ((ad.a)localObject2).nBh.setOnClickListener(h(parama1));
    }
    label4286:
    if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (v)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url))
        {
          ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.url, parama.type, 0, new Object[0]);
          if ((parama.hhb == 1) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIQ())) {
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).cp(parama.url, parama.type);
          }
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(37152);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37161);
    Object localObject = (bj)paramView.getTag();
    if (localObject == null)
    {
      AppMethodBeat.o(37161);
      return false;
    }
    this.ImY = ((bj)localObject).CqX;
    int i = ((bj)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);
    if (localObject == null)
    {
      ac.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(37161);
      return false;
    }
    this.nDi = false;
    if ((this.ImY >= 0) && (this.ImY < ((u)localObject).hkS.size()) && (com.tencent.mm.ah.m.vC(((v)((u)localObject).hkS.get(this.ImY)).hli))) {
      this.nDi = true;
    }
    if ((!this.HNS.foR()) && (!j.aY(parambo))) {
      paramContextMenu.add(i, 111, 0, paramView.getContext().getString(2131762559));
    }
    if ((com.tencent.mm.br.d.aCT("favorite")) && (!this.nDi)) {
      paramContextMenu.add(i, 126, 0, paramView.getContext().getString(2131761941));
    }
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {
      paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
    }
    AppMethodBeat.o(37161);
    return true;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
  {
    AppMethodBeat.i(37166);
    this.nDh = bs.aNx();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37166);
      return false;
      paramMenuItem = bk.C(parambo);
      if (bs.isNullOrNil(paramMenuItem))
      {
        e(parama, parambo);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.HZF.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37148);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
            com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37148);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169878);
            ad.j.a(ad.j.this, parama, parambo);
            com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(169878);
          }
        });
        continue;
        paramMenuItem = a(parambo, parama.HZF.getContext(), 0);
        if (!bs.isNullOrNil(paramMenuItem))
        {
          al.c(parambo, paramMenuItem, parama.HZF.getContext());
          continue;
          com.tencent.mm.ui.chatting.r.a(this.nDh, this.ImY, parama.HZF.getContext(), parama.HZF, null, parambo);
          continue;
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Chat_Msg_Id", parambo.field_msgId);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        }
      }
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.j
 * JD-Core Version:    0.7.0.1
 */