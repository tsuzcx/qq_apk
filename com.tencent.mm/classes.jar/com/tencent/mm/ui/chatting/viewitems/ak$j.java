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
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.br;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ak$j
  extends c
{
  private static int BCA;
  private static int PMp;
  private static int PMq;
  private static int pru;
  private static int prv = 0;
  private static int prw;
  private static int prx = 0;
  private static int prz;
  private boolean PMr = false;
  private int PMs = 0;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private long pxY = 0L;
  private boolean pxZ = false;
  
  static
  {
    prw = 0;
  }
  
  private static void W(View paramView, int paramInt)
  {
    AppMethodBeat.i(233819);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(233819);
  }
  
  private static void X(View paramView, int paramInt)
  {
    AppMethodBeat.i(37156);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.rightMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37156);
  }
  
  private static String a(ca paramca, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(37167);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(37167);
      return null;
    }
    if (paramca == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(37167);
      return null;
    }
    paramca = com.tencent.mm.ag.m.a(paramContext, paramInt, paramca.field_content, paramca.field_talker, paramca.field_msgId);
    AppMethodBeat.o(37167);
    return paramca;
  }
  
  private static void a(View paramView, ak.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(37159);
    if (paramBoolean)
    {
      if (paramb.puO == null) {
        paramb.du(paramView);
      }
      if (paramb.puO != null)
      {
        paramb.puO.setVisibility(0);
        AppMethodBeat.o(37159);
      }
    }
    else if (paramb.puO != null)
    {
      paramb.puO.setVisibility(8);
    }
    AppMethodBeat.o(37159);
  }
  
  private void a(ImageView paramImageView, ca paramca, int paramInt)
  {
    AppMethodBeat.i(37158);
    e.g localg = new e.g();
    localg.msgId = paramca.field_msgId;
    localg.PJs = paramInt;
    localg.xml = paramca.field_content;
    paramImageView.setTag(localg);
    paramImageView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOD());
    AppMethodBeat.o(37158);
  }
  
  private void a(v paramv, View paramView)
  {
    AppMethodBeat.i(37168);
    com.tencent.mm.ui.chatting.s.a(paramv, paramView, this.PhN.getTalkerUserName());
    AppMethodBeat.o(37168);
  }
  
  private void a(v paramv, View paramView, final long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(37169);
    if (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CQ(paramv.type)) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169876);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          int i = ak.j.a(ak.j.this).Pwc.getIntExtra("KOpenArticleSceneFromScene", 10000);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt(e.b.OyQ, 0);
          paramAnonymousView.putInt(e.b.OyR, i);
          paramAnonymousView.putInt("geta8key_scene", 7);
          paramAnonymousView.putString("geta8key_username", ak.j.a(ak.j.this).getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(ak.j.a(ak.j.this).Pwc.getContext(), paramLong1, paramInt, this.val$index, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169876);
        }
      });
    }
    AppMethodBeat.o(37169);
  }
  
  private void a(v paramv, ca paramca, int paramInt, u paramu, View paramView)
  {
    AppMethodBeat.i(37153);
    String str = ((d)this.PhN.bh(d.class)).bmE(paramv.url);
    if (!TextUtils.isEmpty(str))
    {
      Log.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramu = new bq(paramca, false, paramInt, paramv.url, false, this.PhN.gOZ(), paramu.eag, paramu.eah, paramv.title, str, null, false, false);
      paramView.setOnClickListener(i(this.PhN));
    }
    for (;;)
    {
      paramu.IZC = paramca.field_msgSvrId;
      paramu.IZD = 0;
      paramu.PQJ = paramv.type;
      paramView.setTag(paramu);
      if (com.tencent.mm.ag.m.HF(paramv.iAt)) {
        a(paramv, paramView);
      }
      a(paramv, paramView, paramca.field_msgId, paramca.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.PhN));
      paramView.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
      AppMethodBeat.o(37153);
      return;
      paramu = new bq(paramca, false, paramInt, paramv.url, false, this.PhN.gOZ(), paramu.eag, paramu.eah, paramv.title);
      a(paramu, paramv, paramca);
      paramView.setOnClickListener(h(this.PhN));
    }
  }
  
  private static void a(ak.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(37160);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.pxI, paramc.PMf, bool1);
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
        a(paramc.pxI, paramc.PMg, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.pxI, paramc.PMh, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.pxI, paramc.PMi, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.pxI, paramc.PMj, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.pxI;
        paramc = paramc.PMe;
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
  
  private void a(ak.c paramc, final ak.a parama, v paramv, ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(37157);
    if (parama.pxs != null) {
      parama.pxs.setVisibility(8);
    }
    if (paramv.type == 5)
    {
      parama.pxu.setVisibility(0);
      parama.pxu.setImageResource(2131231330);
      parama.pxu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169877);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          parama.puO.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169877);
        }
      });
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.PhN.Pwc.getContext(), 26);
      if (paramv.type != 7) {
        break label471;
      }
      paramInt = com.tencent.mm.cb.a.fromDPToPix(this.PhN.Pwc.getContext(), 32);
    }
    for (;;)
    {
      aM(parama.pxu, paramInt);
      AppMethodBeat.o(37157);
      return;
      if (paramv.type == 6)
      {
        parama.pxu.setVisibility(0);
        if (paramBoolean) {
          if ((paramca.field_msgId + "_" + paramInt).equals(paramc.playingMsgId)) {
            parama.pxu.setImageResource(2131231738);
          }
        }
        for (;;)
        {
          a(parama.pxu, paramca, paramInt);
          break;
          parama.pxu.setImageResource(2131231739);
          continue;
          if ((paramca.field_msgId + "_" + paramInt).equals(paramc.playingMsgId)) {
            parama.pxu.setImageResource(2131689921);
          } else {
            parama.pxu.setImageResource(2131689924);
          }
        }
      }
      if (paramv.type == 7)
      {
        parama.pxu.setVisibility(8);
        if (parama.pxs != null) {
          parama.pxs.setVisibility(0);
        }
        Drawable localDrawable = parama.pxt.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramca.field_msgId + "_" + paramInt).equals(paramc.playingMsgId))
        {
          parama.pxt.setImageResource(2131231332);
          if ((parama.pxt.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.pxt.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.pxt, paramca, paramInt);
          break;
          parama.pxt.setImageResource(2131231331);
        }
      }
      parama.pxu.setVisibility(8);
      break;
      label471:
      if (paramv.type == 5) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(this.PhN.Pwc.getContext(), 24);
      }
    }
  }
  
  private void a(bq parambq, v paramv, ca paramca)
  {
    AppMethodBeat.i(37162);
    Bundle localBundle = new Bundle();
    int i;
    switch (ac.aJ(a(this.PhN, paramca), this.PhN.getTalkerUserName()))
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
      localBundle.putString("share_report_pre_msg_desc", paramv.iAq);
      localBundle.putString("share_report_pre_msg_icon_url", com.tencent.mm.ag.m.a(paramv));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.PhN.getTalkerUserName());
      }
      parambq.PQH = localBundle;
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
    paramString = com.tencent.mm.api.b.u(paramString, 3);
    com.tencent.mm.av.a.a locala = q.bcV();
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.jbt = 2131100173;
    locala1.jbf = true;
    locala1 = locala1.dr(paramInt1, paramInt2);
    locala1.jaU = new n(2);
    locala1.jbC = new com.tencent.mm.pluginsdk.ui.applet.e(2);
    locala1.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(paramString);
    locala.a(paramString, paramImageView, locala1.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, null, parama));
    AppMethodBeat.o(37163);
  }
  
  private void a(String paramString, ImageView paramImageView, boolean paramBoolean, int paramInt, m.a parama)
  {
    AppMethodBeat.i(37164);
    paramString = com.tencent.mm.api.b.u(paramString, 3);
    int i;
    boolean bool;
    label28:
    int j;
    label37:
    float f1;
    if (paramBoolean)
    {
      i = 2131231240;
      if (!paramBoolean) {
        break label243;
      }
      bool = false;
      if (!paramBoolean) {
        break label249;
      }
      j = 2131231255;
      f1 = this.PhN.Pwc.getContext().getResources().getDimensionPixelSize(2131166068);
      if (!((com.tencent.mm.ui.chatting.d.b.k)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.k.class)).isInEditMode()) {
        break label257;
      }
    }
    label257:
    for (int k = 72;; k = 32)
    {
      int m = com.tencent.mm.cb.a.jn(paramImageView.getContext());
      float f2 = com.tencent.mm.cb.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      com.tencent.mm.av.a.a locala = q.bcV();
      com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
      locala1.jbt = j;
      locala1.jbf = true;
      locala1.jbv = String.valueOf(i);
      locala1 = locala1.dr(k, paramInt);
      locala1.jaU = new n(2);
      locala1.jbC = new com.tencent.mm.pluginsdk.ui.applet.e(2);
      locala1.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(paramString);
      locala.a(paramString, paramImageView, locala1.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, k, paramInt, true, bool, f1, parama));
      AppMethodBeat.o(37164);
      return;
      i = 2131231236;
      break;
      label243:
      bool = true;
      break label28;
      label249:
      j = 2131231253;
      break label37;
    }
  }
  
  private static void aM(View paramView, int paramInt)
  {
    AppMethodBeat.i(37155);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37155);
  }
  
  private static void c(v paramv)
  {
    if (paramv.type == 6) {
      paramv.type = 7;
    }
  }
  
  private void e(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37165);
    if (this.pxZ)
    {
      if (!this.pxZ)
      {
        Log.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        AppMethodBeat.o(37165);
        return;
      }
      com.tencent.mm.ui.chatting.s.a(this.PMs, parama.Pwc.getContext(), paramca.field_content, paramca.field_talker, paramca.field_msgId, paramca.field_msgSvrId);
      AppMethodBeat.o(37165);
      return;
    }
    String str = a(paramca, parama.Pwc.getContext(), this.PMs);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(37165);
      return;
    }
    Intent localIntent = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", str);
    localIntent.putExtra("Retr_Msg_Type", 2);
    localIntent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.PMs);
    localIntent.putExtra("Retr_Msg_Id", paramca.field_msgId);
    localIntent.putExtra("Retr_MsgFromScene", 1);
    str = paramca.field_talker;
    Object localObject = ad.JX(paramca.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject);
    localObject = ad.aVe().G((String)localObject, true);
    ((ad.b)localObject).l("prePublishId", "msg_" + paramca.field_msgSvrId);
    ((ad.b)localObject).l("preUsername", str);
    ((ad.b)localObject).l("preChatName", str);
    ((ad.b)localObject).l("preMsgIndex", Integer.valueOf(this.PMs));
    ((ad.b)localObject).l("sendAppMsgScene", Integer.valueOf(1));
    paramca = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramca.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramca.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37165);
  }
  
  private static void km(Context paramContext)
  {
    AppMethodBeat.i(37151);
    int i;
    int j;
    if (prx == 0)
    {
      prx = paramContext.getResources().getDimensionPixelSize(2131165586);
      prw = paramContext.getResources().getDimensionPixelSize(2131165518);
      prv = paramContext.getResources().getDimensionPixelSize(2131165498);
      pru = paramContext.getResources().getDimensionPixelSize(2131166065);
      prz = paramContext.getResources().getDimensionPixelSize(2131166063);
      i = com.tencent.mm.cb.a.jn(paramContext);
      j = com.tencent.mm.cb.a.jo(paramContext);
      if (i >= j) {
        break label141;
      }
    }
    for (;;)
    {
      i -= (int)(com.tencent.mm.cb.a.getDensity(paramContext) * 32.0F);
      BCA = (int)(i / 2.35D);
      PMp = (int)(i / 1.777778F);
      PMq = (int)(i / 1.777778F);
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
      localObject = new an(paramLayoutInflater, 2131493512);
      paramView = new ak.c();
      paramView.timeTV = ((TextView)((View)localObject).findViewById(2131298558));
      paramView.historyMsgTip = ((View)localObject).findViewById(2131298454);
      paramView.pxI = ((LinearLayout)((View)localObject).findViewById(2131298418));
      paramView.checkBox = ((CheckBox)((View)localObject).findViewById(2131298410));
      paramView.maskView = ((View)localObject).findViewById(2131298508);
      paramView.PHZ = ((TextView)((View)localObject).findViewById(2131298364));
      ((View)localObject).setTag(paramView);
    }
    km(paramLayoutInflater.getContext());
    AppMethodBeat.o(37150);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, final String paramString)
  {
    AppMethodBeat.i(37152);
    this.PhN = parama1;
    km(parama1.Pwc.getContext());
    final ak.c localc = (ak.c)parama;
    parama = localc.pxL.iterator();
    if (parama.hasNext())
    {
      paramString = (ak.a)parama.next();
      if (localc.pxL.indexOf(paramString) != localc.pxL.size() - 1) {
        aq.aH(paramString.puO, 1);
      }
      for (;;)
      {
        localc.pxI.removeView(paramString.puO);
        break;
        aq.aH(paramString.puO, 2);
      }
    }
    localc.pxL.clear();
    u localu = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);
    parama = localu.fQR;
    if ((parama == null) || (parama.length() == 0)) {
      localc.PHZ.setVisibility(8);
    }
    LinkedList localLinkedList;
    final int j;
    for (;;)
    {
      localLinkedList = localu.iAd;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.pxI.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(37152);
      return;
      localc.PHZ.setVisibility(0);
      b(parama1, localc.PHZ, bq.bnn(parama));
    }
    localc.pxI.setVisibility(0);
    a(localc, ((v)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.Pwc.getActivityLayoutInflater();
    final int i = localc.pxL.size() + 2;
    while (i < j)
    {
      paramString = aq.ams(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493513, null);
      }
      localc.hc(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = aq.ams(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(2131493514, null);
      }
      localc.hc(parama);
    }
    for (this.PMr = true;; this.PMr = false)
    {
      i = 0;
      while (i < localc.pxL.size())
      {
        ((ak.a)localc.pxL.get(i)).puO.setVisibility(8);
        i += 1;
      }
    }
    paramString = (v)localLinkedList.get(0);
    c(paramString);
    label571:
    final boolean bool;
    label641:
    label698:
    label754:
    label757:
    Object localObject2;
    int k;
    label867:
    label878:
    Object localObject3;
    if (paramString.type == 5)
    {
      parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(paramString.url, 5, "");
      W(localc.PMf.puc, PMp);
      W(localc.PMf.ptS, PMp);
      if (Util.isNullOrNil(paramString.title))
      {
        localc.PMf.ptR.setVisibility(8);
        if (j != 1) {
          break label1519;
        }
        localc.PMf.ptS.setBackgroundResource(2131231779);
        parama = com.tencent.mm.ag.m.rJ(paramString.iAs);
        if (TextUtils.isEmpty(parama)) {
          break label1536;
        }
        localc.PMf.timeTv.setVisibility(0);
        localc.PMf.timeTv.setText(parama);
        localc.PMf.timeTv.setTextColor(this.PhN.Pwc.getContext().getResources().getColor(2131100679));
        a(paramString, paramca, paramInt, localu, localc.PMf.puO);
        localc.PMf.ptG.setVisibility(8);
        parama = paramString.iAo;
        localObject1 = localc.PMf.ptE;
        if (j <= 1) {
          break label1552;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, PMp, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37143);
            localc.PMf.ptG.setVisibility(0);
            localc.PMf.ptR.setTextColor(ak.j.a(ak.j.this).Pwc.getContext().getResources().getColor(2131101427));
            localc.PMf.timeTv.setTextColor(ak.j.a(ak.j.this).Pwc.getContext().getResources().getColor(2131101427));
            ImageView localImageView = localc.PMf.ptG;
            if (j > 1) {}
            for (int i = 2131231342;; i = 2131231343)
            {
              localImageView.setBackgroundResource(i);
              AppMethodBeat.o(37143);
              return;
            }
          }
          
          public final void onStart() {}
        });
        if (com.tencent.mm.cb.a.ez(this.PhN.Pwc.getContext()) <= 1.125F) {
          break label1558;
        }
        localc.PMf.ptR.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label4465;
        }
        localObject1 = (v)localLinkedList.get(i);
        c((v)localObject1);
        localObject2 = (ak.a)localc.pxL.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3808;
        }
        if ((k != 0) || (!Util.isNullOrNil(((v)localLinkedList.get(0)).iAo))) {
          break label3795;
        }
        ((ak.a)localObject2).jBI.setVisibility(0);
        X(((ak.a)localObject2).jBI, prv);
        if (i != 1) {
          break label3975;
        }
        if (i != j - 1) {
          break label3956;
        }
        ((ak.a)localObject2).pxo.setPadding(0, prv, 0, prv);
        label909:
        a(localc, (ak.a)localObject2, (v)localObject1, paramca, i, false);
        ((ak.a)localObject2).ptR.setTextColor(parama1.Pwc.getMMResources().getColor(2131100904));
        if (!Util.isNullOrNil(((v)localObject1).title)) {
          break label4064;
        }
        localObject3 = com.tencent.mm.plugin.brandservice.b.a.pmT;
        k = ((v)localObject1).type;
        parama = this.PhN.Pwc.getContext();
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(2131757340);
          label1023:
          ((com.tencent.mm.plugin.brandservice.b.a)localObject3).a(parama, ((ak.a)localObject2).ptR, (v)localObject1, 3);
          label1037:
          if ((((v)localObject1).iAr == 0) || (((v)localObject1).iAr == 1))
          {
            ((ak.a)localObject2).pxr.setVisibility(0);
            ((ak.a)localObject2).ptR.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099746));
            if (((v)localObject1).type == 7)
            {
              ((ak.a)localObject2).ptE.setVisibility(8);
              label1107:
              if ((Util.isNullOrNil(((v)localObject1).iAq)) || (((v)localObject1).type != 3)) {
                break label4356;
              }
              ((ak.a)localObject2).pxq.setText(((v)localObject1).iAq);
              ((ak.a)localObject2).pxq.setVisibility(0);
              label1149:
              ((ak.a)localObject2).puO.setVisibility(0);
              parama = ((d)parama1.bh(d.class)).bmE(((v)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label4369;
              }
              Log.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new bq(paramca, false, paramInt, ((v)localObject1).url, this.PMr, parama1.gOZ(), localu.eag, localu.eah, ((v)localObject1).title, parama, null, false, true);
              ((ak.a)localObject2).puO.setOnClickListener(i(parama1));
              label1257:
              parama.IZC = paramca.field_msgSvrId;
              parama.IZD = i;
              parama.PQJ = ((v)localObject1).type;
              ((ak.a)localObject2).puO.setTag(parama);
              if (com.tencent.mm.ag.m.HF(((v)localObject1).iAt)) {
                a((v)localObject1, ((ak.a)localObject2).puO);
              }
              a((v)localObject1, ((ak.a)localObject2).puO, paramca.field_msgId, paramca.field_msgSvrId, i);
              ((ak.a)localObject2).puO.setOnLongClickListener(c(parama1));
              ((ak.a)localObject2).puO.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
              if (((v)localObject1).type != 8) {
                break label4442;
              }
              ((ak.a)localObject2).pyp.setImageResource(2131689793);
              ((ak.a)localObject2).pyp.setVisibility(0);
              if (((v)localObject1).iAC <= 1) {
                break label4429;
              }
              ((ak.a)localObject2).PMd.setVisibility(0);
              ((ak.a)localObject2).PMd.setText(String.valueOf(((v)localObject1).iAC));
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label757;
      localc.PMf.ptR.aw(paramString.title);
      localc.PMf.ptR.getPaint().setFakeBoldText(true);
      localc.PMf.ptR.setVisibility(0);
      localc.PMf.ptR.setTextColor(this.PhN.Pwc.getContext().getResources().getColor(2131100679));
      break;
      label1519:
      localc.PMf.ptS.setBackgroundResource(2131231781);
      break label571;
      label1536:
      localc.PMf.timeTv.setVisibility(8);
      break label641;
      label1552:
      bool = false;
      break label698;
      label1558:
      localc.PMf.ptR.setMaxLines(2);
      break label754;
      if (paramString.type == 8)
      {
        W(localc.PMg.puc, PMq);
        W(localc.PMg.ptS, PMq);
        if ((j > 1) || (!Util.isNullOrNil(paramString.iAq)))
        {
          bool = true;
          label1631:
          if (bool) {
            break label1824;
          }
          localc.PMg.ptS.setBackgroundResource(2131231779);
          label1650:
          if (paramString.iAC <= 1) {
            break label1841;
          }
          localc.PMg.PMd.setVisibility(0);
          localc.PMg.PMd.setText(String.valueOf(paramString.iAC));
          label1690:
          if ((Util.isNullOrNil(paramString.iAq)) || (j != 1)) {
            break label1857;
          }
          localc.PMg.PMl.setVisibility(0);
          localc.PMg.PMk.aw(paramString.iAq);
          localc.PMg.PMl.setBackgroundResource(2131231251);
        }
        for (;;)
        {
          localc.PMg.ptG.setVisibility(8);
          a(paramString.iAo, localc.PMg.ptE, bool, PMq, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37145);
              localc.PMg.ptG.setVisibility(0);
              localc.PMg.kc.setImageResource(2131689793);
              ImageView localImageView = localc.PMg.ptG;
              if (bool) {}
              for (int i = 2131231342;; i = 2131231343)
              {
                localImageView.setBackgroundResource(i);
                AppMethodBeat.o(37145);
                return;
              }
            }
            
            public final void onStart() {}
          });
          a(paramString, paramca, paramInt, localu, localc.PMg.puO);
          break;
          bool = false;
          break label1631;
          label1824:
          localc.PMg.ptS.setBackgroundResource(2131231781);
          break label1650;
          label1841:
          localc.PMg.PMd.setVisibility(8);
          break label1690;
          label1857:
          localc.PMg.PMl.setVisibility(8);
        }
      }
      if (paramString.type == 7)
      {
        if (Util.isNullOrNil(paramString.title))
        {
          localc.PMh.hbb.setVisibility(8);
          label1907:
          if (j <= 1) {
            break label2154;
          }
          localc.PMh.puO.setBackgroundResource(2131231761);
          label1927:
          parama = com.tencent.mm.ag.m.rJ(paramString.iAs);
          if (TextUtils.isEmpty(parama)) {
            break label2171;
          }
          localc.PMh.pwO.setVisibility(0);
          localc.PMh.pwO.setText(parama);
          label1967:
          parama = localc.PMh.pxu.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(paramca.field_msgId + "_0").equals(localc.playingMsgId)) {
            break label2186;
          }
          localc.PMh.pxu.setImageResource(2131231332);
          if ((localc.PMh.pxu.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.PMh.pxu.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.PMh.pxu, paramca, 0);
          a(paramString, paramca, paramInt, localu, localc.PMh.puO);
          break;
          localc.PMh.hbb.setVisibility(0);
          localc.PMh.hbb.setText(paramString.title);
          break label1907;
          label2154:
          localc.PMh.puO.setBackgroundResource(2131235778);
          break label1927;
          label2171:
          localc.PMh.pwO.setVisibility(4);
          break label1967;
          label2186:
          localc.PMh.pxu.setImageResource(2131231331);
        }
      }
      if (paramString.type == 6)
      {
        localObject1 = (v)localLinkedList.get(0);
        if (Util.isNullOrNil(((v)localObject1).title))
        {
          localc.PMi.hbb.setVisibility(8);
          label2250:
          if (j <= 1) {
            break label2516;
          }
          localc.PMi.puO.setBackgroundResource(2131231761);
          label2270:
          if (TextUtils.isEmpty(((v)localObject1).iAA)) {
            break label2533;
          }
          localc.PMi.pyj.setVisibility(0);
          localc.PMi.pyj.setText(((v)localObject1).iAA);
          label2309:
          if (((v)localObject1).iAB != 2) {
            break label2549;
          }
          localc.PMi.pyk.setImageResource(2131689918);
          label2332:
          a(localc.PMi.pxu, paramca, 0);
          a((v)localObject1, paramca, paramInt, localu, localc.PMi.puO);
          if (!(paramca.field_msgId + "_0").equals(localc.playingMsgId)) {
            break label2566;
          }
          localc.PMi.pxu.setImageResource(2131689921);
        }
        for (;;)
        {
          localc.PMi.ptG.setVisibility(8);
          parama = new WeakReference(localc);
          localObject1 = ((v)localObject1).iAo;
          localObject2 = localc.PMi.ptE;
          i = pru;
          a((String)localObject1, (ImageView)localObject2, i, i, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37144);
              ak.c localc = (ak.c)parama.get();
              if (localc == null)
              {
                AppMethodBeat.o(37144);
                return;
              }
              localc.PMi.ptG.setVisibility(0);
              if ((paramca.field_msgId + "_0").equals(localc.playingMsgId))
              {
                localc.PMi.pxu.setImageResource(2131231738);
                AppMethodBeat.o(37144);
                return;
              }
              localc.PMi.pxu.setImageResource(2131231739);
              AppMethodBeat.o(37144);
            }
            
            public final void onStart() {}
          });
          break;
          localc.PMi.hbb.setVisibility(0);
          localc.PMi.hbb.setText(((v)localObject1).title);
          break label2250;
          label2516:
          localc.PMi.puO.setBackgroundResource(2131235778);
          break label2270;
          label2533:
          localc.PMi.pyj.setVisibility(8);
          break label2309;
          label2549:
          localc.PMi.pyk.setImageResource(2131689927);
          break label2332;
          label2566:
          localc.PMi.pxu.setImageResource(2131689924);
        }
      }
      if (paramString.type == 10)
      {
        if (Util.isNullOrNil(paramString.title))
        {
          localc.PMj.ptR.setVisibility(8);
          if (j <= 1) {
            break label3088;
          }
          localc.PMj.puO.setBackgroundResource(2131231761);
        }
        for (;;)
        {
          a(paramString, paramca, paramInt, localu, localc.PMj.puO);
          break;
          localc.PMj.ptR.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(localc.PMj.ptR, new o(this.PhN.Pwc.getContext())));
          localc.PMj.ptR.setVisibility(0);
          localc.PMj.ptR.aw(com.tencent.mm.pluginsdk.ui.span.l.j(this.PhN.Pwc.getContext(), paramString.title, (int)localc.PMj.ptR.getTextSize()));
          i = com.tencent.mm.cb.a.jn(this.PhN.Pwc.getContext());
          k = (int)(com.tencent.mm.cb.a.getDensity(this.PhN.Pwc.getContext()) * 80.0F);
          parama = localc.PMj.ptR.mq(i - k, 2147483647);
          if (parama != null) {}
          for (i = parama.hiG();; i = 0)
          {
            parama = (LinearLayout.LayoutParams)localc.PMj.ptR.getLayoutParams();
            localObject1 = (LinearLayout.LayoutParams)localc.PMj.PMo.getLayoutParams();
            if (i > 3) {
              break label2924;
            }
            localc.PMj.PMn.setVisibility(8);
            ((LinearLayout.LayoutParams)localObject1).gravity = 16;
            localc.PMj.PMo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = 0;
            parama.gravity = 17;
            localc.PMj.ptR.setLayoutParams(parama);
            break;
          }
          label2924:
          if (paramString.iAF == 1)
          {
            i = 1;
            label2936:
            localc.PMj.PMn.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject1).gravity = 48;
            localc.PMj.PMo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = com.tencent.mm.cb.a.fromDPToPix(this.PhN.Pwc.getContext(), 38);
            parama.gravity = 8388627;
            if (i == 0) {
              break label3059;
            }
            localc.PMj.ptR.setMaxLines(2147483647);
            localc.PMj.PMn.setText(2131756767);
          }
          for (;;)
          {
            localc.PMj.PMn.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37146);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (paramString.iAF == 1)
                {
                  localc.PMj.ptR.setMaxLines(3);
                  localc.PMj.PMn.setText(2131756768);
                }
                for (paramString.iAF = 0;; paramString.iAF = 1)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37146);
                  return;
                  localc.PMj.ptR.setMaxLines(2147483647);
                  localc.PMj.PMn.setText(2131756767);
                }
              }
            });
            break;
            i = 0;
            break label2936;
            label3059:
            localc.PMj.ptR.setMaxLines(3);
            localc.PMj.PMn.setText(2131756768);
          }
          label3088:
          localc.PMj.puO.setBackgroundResource(2131235778);
        }
      }
      parama = localc.PMe.ptR;
      if (j > 1)
      {
        i = 8;
        label3124:
        parama.setVisibility(i);
        parama = localc.PMe.PMm;
        if ((j <= 1) && (!Util.isNullOrNil(paramString.iAq))) {
          break label3512;
        }
        i = 8;
        label3160:
        parama.setVisibility(i);
        parama = localc.PMe.BCK;
        if (j <= 1) {
          break label3518;
        }
      }
      label3512:
      label3518:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.PMe.BCL.setVisibility(8);
        if (j != 1) {
          break label3525;
        }
        localc.PMe.ptS.setBackgroundResource(2131231779);
        localc.PMe.kmV.setVisibility(0);
        W(localc.PMe.puc, BCA);
        W(localc.PMe.ptS, BCA);
        if (Util.isNullOrNil(paramString.iAo)) {
          break label3637;
        }
        localc.PMe.puc.setVisibility(0);
        a(paramString.iAo, localc.PMe.ptE, true, BCA, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37142);
            if (j > 1)
            {
              localc.PMe.BCK.setTextColor(ak.j.a(ak.j.this).Pwc.getContext().getResources().getColor(2131101427));
              localc.PMe.BCK.setBackgroundResource(2131231265);
            }
            localc.PMe.BCL.setVisibility(0);
            AppMethodBeat.o(37142);
          }
          
          public final void onStart() {}
        });
        localc.PMe.kmV.setBackgroundResource(2131231753);
        parama = localc.PMe.kmV;
        i = prv;
        k = prw;
        int m = prv;
        parama.setPadding(i, k, m, m);
        localc.PMe.ptS.setVisibility(0);
        localc.PMe.PMm.setMaxLines(30);
        localc.PMe.PMm.setText(paramString.iAq);
        com.tencent.mm.plugin.brandservice.b.a.pmT.a(paramString.title, localc.PMe.ptR, paramString, 2);
        com.tencent.mm.plugin.brandservice.b.a.pmT.a(paramString.title, localc.PMe.BCK, paramString, 21);
        if ((paramString.iAr != 0) && (paramString.iAr != 1)) {
          localc.PMe.BCK.setVisibility(4);
        }
        a(paramString, paramca, paramInt, localu, localc.PMe.puO);
        break;
        i = 0;
        break label3124;
        i = 0;
        break label3160;
      }
      label3525:
      parama = localc.PMe.kmV;
      if (Util.isNullOrNil(paramString.iAo)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.PMe.ptS.setBackgroundResource(2131231781);
        localc.PMe.BCK.setTextColor(this.PhN.Pwc.getContext().getResources().getColor(2131100679));
        localc.PMe.BCK.setBackgroundResource(2131233974);
        localc.PMe.BCK.getPaint().setFakeBoldText(true);
        break;
      }
      label3637:
      localc.PMe.PMm.setMaxLines(100);
      localc.PMe.puc.setVisibility(8);
      localc.PMe.ptR.setVisibility(0);
      parama = localc.PMe.PMm;
      if (Util.isNullOrNil(paramString.iAq))
      {
        i = 8;
        label3699:
        parama.setVisibility(i);
        if (j != 1) {
          break label3778;
        }
        localc.PMe.kmV.setBackgroundResource(2131235778);
      }
      for (;;)
      {
        parama = localc.PMe.kmV;
        i = prv;
        k = prv;
        parama.setPadding(i, i, k, k);
        localc.PMe.ptS.setVisibility(8);
        break;
        i = 0;
        break label3699;
        label3778:
        localc.PMe.kmV.setBackgroundResource(2131231761);
      }
      label3795:
      ((ak.a)localObject2).jBI.setVisibility(8);
      break label878;
      label3808:
      ((ak.a)localObject2).jBI.setVisibility(0);
      if (i <= 1) {
        break label867;
      }
      parama = (v)localLinkedList.get(i - 1);
      localObject3 = (v)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (Util.isNullOrNil(parama.iAo))) || ((((v)localObject3).type != 7) && (((v)localObject3).type != 5) && (((v)localObject3).type != 6) && (Util.isNullOrNil(((v)localObject3).iAo))))
      {
        X(((ak.a)localObject2).jBI, prv);
        break label878;
      }
      X(((ak.a)localObject2).jBI, prz);
      break label878;
      label3956:
      ((ak.a)localObject2).pxo.setPadding(0, prv, 0, prx);
      break label909;
      label3975:
      if (i == j - 1)
      {
        ((ak.a)localObject2).pxo.setPadding(0, prx, 0, prv);
        break label909;
      }
      ((ak.a)localObject2).pxo.setPadding(0, prx, 0, prx);
      break label909;
      parama = parama.getResources().getString(2131757348);
      break label1023;
      parama = parama.getResources().getString(2131757349);
      break label1023;
      parama = parama.getResources().getString(2131757341);
      break label1023;
      label4064:
      com.tencent.mm.plugin.brandservice.b.a.pmT.a(((v)localObject1).title, ((ak.a)localObject2).ptR, (v)localObject1, 3);
      break label1037;
      Object localObject4;
      if (!Util.isNullOrNil(((v)localObject1).iAo))
      {
        ((ak.a)localObject2).ptE.setVisibility(0);
        localObject3 = new WeakReference(localc);
        localObject4 = new WeakReference(localObject2);
        if (Util.isNullOrNil(((v)localObject1).iAD)) {}
        for (parama = ((v)localObject1).iAo;; parama = ((v)localObject1).iAD)
        {
          ImageView localImageView = ((ak.a)localObject2).ptE;
          k = pru;
          a(parama, localImageView, k, k, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37141);
              if ((this.PMt.get() != null) && (this.PMu.get() != null)) {
                ak.j.a(ak.j.this, (ak.c)this.PMt.get(), (ak.a)this.PMu.get(), this.pxW, paramca, i);
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
        ((ak.a)localObject2).ptE.setVisibility(0);
        parama = ((ak.a)localObject2).ptE;
        k = pru;
        localObject3 = q.bcV();
        localObject4 = new com.tencent.mm.av.a.a.c.a();
        ((com.tencent.mm.av.a.a.c.a)localObject4).jbd = true;
        ((com.tencent.mm.av.a.a.c.a)localObject4).jbq = 2131100173;
        localObject4 = ((com.tencent.mm.av.a.a.c.a)localObject4).dr(k, k);
        ((com.tencent.mm.av.a.a.c.a)localObject4).jbi = 4;
        ((com.tencent.mm.av.a.a)localObject3).a("2131231740", parama, ((com.tencent.mm.av.a.a.c.a)localObject4).bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m());
        break label1107;
      }
      ((ak.a)localObject2).pxr.setVisibility(8);
      break label1107;
      ((ak.a)localObject2).pxr.setVisibility(8);
      ((ak.a)localObject2).ptR.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131099749));
      break label1107;
      label4356:
      ((ak.a)localObject2).pxq.setVisibility(8);
      break label1149;
      label4369:
      parama = new bq(paramca, false, paramInt, ((v)localObject1).url, this.PMr, parama1.gOZ(), localu.eag, localu.eah);
      a(parama, (v)localObject1, paramca);
      ((ak.a)localObject2).puO.setOnClickListener(h(parama1));
      break label1257;
      label4429:
      ((ak.a)localObject2).PMd.setVisibility(8);
      continue;
      label4442:
      ((ak.a)localObject2).pyp.setVisibility(8);
      ((ak.a)localObject2).PMd.setVisibility(8);
    }
    label4465:
    if (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (v)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url))
        {
          ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.url, parama.type, 0, new Object[0]);
          if ((parama.iwf == 1) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cle())) {
            ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cD(parama.url, parama.type);
          }
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(37152);
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
  {
    AppMethodBeat.i(37166);
    this.pxY = Util.nowSecond();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37166);
      return false;
      paramMenuItem = br.N(paramca);
      if (Util.isNullOrNil(paramMenuItem))
      {
        e(parama, paramca);
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37148);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
            com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37148);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(169878);
            ak.j.a(ak.j.this, parama, paramca);
            com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(169878);
          }
        });
        continue;
        paramMenuItem = a(paramca, parama.Pwc.getContext(), 0);
        if (!Util.isNullOrNil(paramMenuItem))
        {
          com.tencent.mm.ui.chatting.an.c(paramca, paramMenuItem, parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.s.a(this.pxY, this.PMs, parama.Pwc.getContext(), parama.Pwc, null, paramca);
          continue;
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233820);
    Object localObject = (bq)paramView.getTag();
    if (localObject == null)
    {
      AppMethodBeat.o(233820);
      return false;
    }
    this.PMs = ((bq)localObject).IZD;
    int i = ((bq)localObject).position;
    localObject = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);
    if (localObject == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(233820);
      return false;
    }
    this.pxZ = false;
    if ((this.PMs >= 0) && (this.PMs < ((u)localObject).iAd.size()) && (com.tencent.mm.ag.m.HF(((v)((u)localObject).iAd.get(this.PMs)).iAt))) {
      this.pxZ = true;
    }
    if ((!this.PhN.gRN()) && (!com.tencent.mm.ui.chatting.k.bq(paramca))) {
      paramm.a(i, 111, paramView.getContext().getString(2131764628), 2131690674);
    }
    if ((com.tencent.mm.br.c.aZU("favorite")) && (!this.pxZ)) {
      paramm.a(i, 126, paramView.getContext().getString(2131763947), 2131690551);
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
      paramm.a(i, 144, paramView.getContext().getString(2131763040), 2131690297);
    }
    paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    AppMethodBeat.o(233820);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.j
 * JD-Core Version:    0.7.0.1
 */