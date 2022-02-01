package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.aa;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.t;
import com.tencent.mm.av.r.a;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.k.2;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.i;
import com.tencent.mm.ui.chatting.t.j;
import com.tencent.mm.ui.chatting.t.l;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Pattern;

public final class e
{
  private static boolean ESt = false;
  
  private static void a(Context paramContext, final boolean paramBoolean, final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.ui.transmit.g.a parama)
  {
    AppMethodBeat.i(233604);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext = View.inflate(paramContext, 2131496726, null);
    Object localObject = (ImageView)paramContext.findViewById(2131309265);
    if (LocaleUtil.isChineseAppLang()) {
      ((ImageView)localObject).setImageResource(2131235319);
    }
    for (;;)
    {
      localObject = new f((byte)0);
      paramContext.findViewById(2131309269).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(233589);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
          this.PHF.PJq = true;
          locale.bMo();
          if (parama != null) {
            parama.gUb();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233589);
        }
      });
      locale.HLX = new e.5(locale, paramContext);
      locale.PGl = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(233591);
          String str;
          int j;
          if (!this.PHF.PJq)
          {
            str = paramString1;
            j = this.gsC;
            if (!paramBoolean) {
              break label56;
            }
          }
          label56:
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.chatroom.d.z.a(str, 1, j, i, 1, paramString2, paramString3);
            AppMethodBeat.o(233591);
            return;
          }
        }
      };
      locale.Dm(true);
      locale.dGm();
      AppMethodBeat.o(233604);
      return;
      ((ImageView)localObject).setImageResource(2131235320);
    }
  }
  
  protected static void a(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(36837);
    switch (paramb.izz)
    {
    default: 
      paramTextView.setText(2131755440);
    }
    for (;;)
    {
      paramTextView.setVisibility(0);
      AppMethodBeat.o(36837);
      return;
      paramTextView.setText(2131755704);
      continue;
      paramTextView.setText(2131755703);
    }
  }
  
  public static void a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36838);
    pa localpa = new pa();
    localpa.dVb.context = parama.Pwc.getContext();
    localpa.dVb.msgId = paramca.field_msgId;
    localpa.dVb.dUo = parama.gRM();
    localpa.dVb.dVc = paramb.ixl;
    localpa.dVb.scene = 6;
    EventCenter.instance.publish(localpa);
    AppMethodBeat.o(36838);
  }
  
  public static void a(ca paramca, c.a parama, com.tencent.mm.ui.chatting.e.a parama1)
  {
    AppMethodBeat.i(179989);
    a(paramca, parama, parama1, 0);
    AppMethodBeat.o(179989);
  }
  
  public static void a(ca paramca, final c.a parama, final com.tencent.mm.ui.chatting.e.a parama1, final int paramInt)
  {
    AppMethodBeat.i(185048);
    if (paramca == null)
    {
      Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185048);
      return;
    }
    if (MultiProcessMMKV.getMMKV("group_to_do").getBoolean("introduce_dialog_first", true))
    {
      MultiProcessMMKV.getMMKV("group_to_do").edit().putBoolean("introduce_dialog_first", false);
      a(parama1.Pwc.getContext(), Util.isNullOrNil(paramca.fRe), parama1.getTalkerUserName(), paramca.fRe, y.f(paramca), new com.tencent.mm.ui.transmit.g.a()
      {
        public final void gUb()
        {
          AppMethodBeat.i(233586);
          e.b(this.iBP, parama, parama1, paramInt);
          AppMethodBeat.o(233586);
        }
      });
      AppMethodBeat.o(185048);
      return;
    }
    a(paramca, parama, parama1, paramInt, 0);
    AppMethodBeat.o(185048);
  }
  
  private static void a(final ca paramca, final c.a parama, final com.tencent.mm.ui.chatting.e.a parama1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185049);
    if (paramca == null)
    {
      Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185049);
      return;
    }
    boolean bool = Util.isNullOrNil(paramca.fRe);
    Activity localActivity = parama1.Pwc.getContext();
    String str2 = paramca.field_talker;
    if (Util.isNullOrNil(paramca.fRe)) {}
    for (String str1 = y.d(paramca);; str1 = paramca.fRe)
    {
      y.a(localActivity, str2, str1, y.f(paramca), bool, 2, paramInt1, paramInt2, new y.a()
      {
        public final void amc()
        {
          AppMethodBeat.i(233587);
          if (!this.PHE) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = y.c(paramca);
            Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", new Object[] { Long.valueOf(paramca.field_msgSvrId), localPair });
            AppMethodBeat.o(233587);
            return;
          }
        }
        
        public final void amd()
        {
          AppMethodBeat.i(233588);
          if (!this.PHE) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = y.e(paramca);
            Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", new Object[] { Long.valueOf(paramca.field_msgSvrId), localPair });
            AppMethodBeat.o(233588);
            return;
          }
        }
      });
      AppMethodBeat.o(185049);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, c.a parama, com.tencent.mm.ui.chatting.e.a parama1)
  {
    AppMethodBeat.i(179987);
    if ((parama instanceof c))
    {
      a(paramBoolean, (c)parama, parama1);
      AppMethodBeat.o(179987);
      return;
    }
    if ((parama instanceof bd.f)) {
      bd.a(paramBoolean, (bd.f)parama, parama1);
    }
    AppMethodBeat.o(179987);
  }
  
  public static void a(boolean paramBoolean, c paramc, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(179988);
    if (paramc == null)
    {
      AppMethodBeat.o(179988);
      return;
    }
    if (paramBoolean)
    {
      paramc.PIY.setBackgroundResource(2131231713);
      paramc.PIZ.setTextColor(parama.Pwc.getContext().getResources().getColor(2131099679));
      paramc.PIZ.setText(2131761505);
      AppMethodBeat.o(179988);
      return;
    }
    paramc.PIY.setBackgroundResource(2131231714);
    paramc.PIZ.setTextColor(parama.Pwc.getContext().getResources().getColor(2131099710));
    paramc.PIZ.setText(2131761507);
    AppMethodBeat.o(179988);
  }
  
  public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(233605);
    Object localObject = paramb.izu;
    String str1 = paramb.izv;
    String str2 = paramb.izw;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(233605);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).aCR((String)localObject);
    if ((WeChatEnvironment.isCoolassistEnv()) || (bool)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.lite.b.f.ecC();
      paramb = com.tencent.mm.plugin.lite.b.f.aCT((String)localObject);
      com.tencent.mm.plugin.report.service.h.CyF.n(1293L, 30L, 1L);
      int j = i;
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(1293L, 31L, 1L);
        j = i;
        if (paramb == null)
        {
          com.tencent.mm.plugin.lite.b.f.ecC();
          if (com.tencent.mm.plugin.lite.b.f.ecE() == null) {
            com.tencent.mm.plugin.lite.b.f.ecC().ecF();
          }
          com.tencent.mm.plugin.lite.b.f.ecC().a((String)localObject, null);
          j = 0;
        }
      }
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(233605);
      return false;
    }
    paramb = new Bundle();
    paramb.putString("appId", (String)localObject);
    if (!Util.isNullOrNil(str1)) {
      paramb.putString("path", str1);
    }
    if (!Util.isNullOrNil(str2)) {
      paramb.putString("query", str2);
    }
    localObject = parama.Pwc.getContext();
    parama.Pwc.getContext().getString(2131755998);
    localObject = com.tencent.mm.ui.base.h.a((Context)localObject, parama.Pwc.getContext().getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).a(parama.Pwc.getContext(), paramb, false, new e.8((com.tencent.mm.ui.base.q)localObject, parama));
    AppMethodBeat.o(233605);
    return true;
  }
  
  public static boolean a(ca paramca, k.b paramb, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(179986);
    if (!y.ama())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (paramca == null)
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if ((!com.tencent.mm.modelappbrand.a.b(paramb)) && (!com.tencent.mm.modelappbrand.a.c(paramb)))
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (cl.aWz() - paramca.field_createTime >= com.tencent.mm.chatroom.storage.d.gtt.longValue())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (ab.IE(parama.getTalkerUserName()))
    {
      AppMethodBeat.o(179986);
      return true;
    }
    AppMethodBeat.o(179986);
    return false;
  }
  
  private static boolean l(k.b paramb)
  {
    AppMethodBeat.i(36839);
    paramb = (aj)paramb.as(aj.class);
    if ((paramb != null) && (!Util.isNullOrNil(paramb.IEy)))
    {
      AppMethodBeat.o(36839);
      return true;
    }
    AppMethodBeat.o(36839);
    return false;
  }
  
  static final class a
  {
    static void a(Intent paramIntent, com.tencent.mm.ui.chatting.e.a parama, ca paramca, c paramc)
    {
      AppMethodBeat.i(36752);
      String str = parama.getTalkerUserName();
      paramc = paramc.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.gRM()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str);
        localBundle.putString("stat_send_msg_user", paramc);
        paramIntent.putExtra("_stat_obj", localBundle);
        AppMethodBeat.o(36752);
        return;
        if (ab.IT(str)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
  }
  
  static final class b
  {
    static void a(com.tencent.mm.ui.chatting.e.a parama, final ca paramca, String paramString)
    {
      AppMethodBeat.i(36756);
      Object localObject1 = bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend);
      final Intent localIntent = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
      localIntent.putExtra("Retr_Msg_content", (String)localObject1);
      localIntent.putExtra("Retr_MsgFromScene", 2);
      localObject1 = k.b.HD((String)localObject1);
      if ((localObject1 != null) && (19 == ((k.b)localObject1).type)) {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_Msg_Id", paramca.field_msgId);
        if ((localObject1 != null) && (((k.b)localObject1).type == 6)) {
          break label599;
        }
        paramca = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramca.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramca.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36756);
        return;
        if ((localObject1 != null) && (24 == ((k.b)localObject1).type))
        {
          localIntent.putExtra("Retr_Msg_Type", 10);
        }
        else
        {
          if ((localObject1 == null) || (16 != ((k.b)localObject1).type)) {
            break;
          }
          localIntent.putExtra("Retr_Msg_Type", 14);
        }
      }
      if ((localObject1 != null) && ((33 == ((k.b)localObject1).type) || (36 == ((k.b)localObject1).type)))
      {
        localObject2 = new aa();
        ((aa)localObject2).iAX = ((k.b)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
      }
      localIntent.putExtra("Retr_Msg_Type", 2);
      Object localObject2 = paramca.field_talker;
      Object localObject3 = ad.JX(paramca.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = ad.aVe().G((String)localObject3, true);
      ((ad.b)localObject3).l("prePublishId", "msg_" + paramca.field_msgSvrId);
      ((ad.b)localObject3).l("preUsername", paramString);
      ((ad.b)localObject3).l("preChatName", localObject2);
      if ((localObject1 != null) && (((k.b)localObject1).as(com.tencent.mm.ag.a.class) != null))
      {
        ((ad.b)localObject3).l("appservicetype", Integer.valueOf(((com.tencent.mm.ag.a)((k.b)localObject1).as(com.tencent.mm.ag.a.class)).iuS));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.ag.a)((k.b)localObject1).as(com.tencent.mm.ag.a.class)).iuS);
      }
      if ((localObject1 != null) && (33 == ((k.b)localObject1).type))
      {
        if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.Pwc.getContext()))
        {
          AppMethodBeat.o(36756);
          return;
        }
        if (!parama.gRM()) {
          break label575;
        }
        ((ad.b)localObject3).l("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", paramca.field_talker);
        ((ad.b)localObject3).l("sendAppMsgScene", Integer.valueOf(1));
        ((j)com.tencent.mm.kernel.g.af(j.class)).a("adExtStr", (ad.b)localObject3, paramca);
        break;
        label575:
        ((ad.b)localObject3).l("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      label599:
      int i;
      if (((k.b)localObject1).type == 6)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1203L, 7L, 1L, false);
        localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
        localObject3 = ((k.b)localObject1).iwW;
        if (((k.b)localObject1).iwM == 1)
        {
          i = 7;
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((k.b)localObject1).iwI), Integer.valueOf(2), Long.valueOf((cl.aWz() - paramca.field_createTime) / 1000L), ((k.b)localObject1).iwJ, paramca.field_talker, Integer.valueOf(1), "", Long.valueOf(paramca.field_msgSvrId), Long.valueOf(paramca.field_createTime) });
        }
      }
      else
      {
        if ((((k.b)localObject1).iwM == 0) && (((k.b)localObject1).iwI <= 26214400)) {
          break label917;
        }
      }
      label917:
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("Retr_Big_File", bool);
        localObject2 = com.tencent.mm.pluginsdk.model.app.m.bdJ(((k.b)localObject1).dCK);
        if (localObject2 == null) {
          break label1066;
        }
        localObject3 = new o(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
        if ((!((o)localObject3).exists()) || (((o)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen)) {
          break label923;
        }
        paramca = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramca.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramca.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36756);
        return;
        i = 5;
        break;
      }
      label923:
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset > 0L) && (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen > ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset))
      {
        paramString = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        if ((paramca.gDB()) || (h(paramca, paramString)))
        {
          Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131759394), parama.Pwc.getContext().getString(2131755998), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            com.tencent.mm.ui.base.h.c(parama.Pwc.getContext(), parama.Pwc.getMMResources().getString(2131758179), "", true);
          }
          AppMethodBeat.o(36756);
          return;
        }
      }
      label1066:
      Log.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((k.b)localObject1).iwI), ((k.b)localObject1).iwW, Util.secPrint(((k.b)localObject1).aesKey) });
      if (!bool)
      {
        a(parama, localIntent, paramca);
        AppMethodBeat.o(36756);
        return;
      }
      localIntent.putExtra("Retr_Big_File", bool);
      localObject3 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject3).taskName = "task_ChattingItemAppMsg";
      ((com.tencent.mm.i.g)localObject3).gqy = new com.tencent.mm.i.g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(36753);
          boolean bool1;
          boolean bool2;
          if (paramAnonymousc != null)
          {
            bool1 = true;
            if (paramAnonymousd == null) {
              break label173;
            }
            bool2 = true;
            label20:
            Log.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label179;
              }
              paramAnonymousString = this.PHb;
              paramAnonymousc = localIntent;
              paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousc);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousc.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousc.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          for (;;)
          {
            AppMethodBeat.o(36753);
            return 0;
            bool1 = false;
            break;
            label173:
            bool2 = false;
            break label20;
            label179:
            if ((paramca.gDB()) || ((this.PgB != null) && (e.b.h(paramca, this.PgB.field_fileFullPath)))) {
              com.tencent.f.h.RTc.aV(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179946);
                  Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                  com.tencent.mm.ui.base.h.d(e.b.1.this.PHb.Pwc.getContext(), e.b.1.this.PHb.Pwc.getContext().getString(2131759394), e.b.1.this.PHb.Pwc.getContext().getString(2131755998), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                  });
                  AppMethodBeat.o(179946);
                }
              });
            } else {
              com.tencent.f.h.RTc.aV(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179947);
                  com.tencent.mm.ui.base.h.c(e.b.1.this.PHb.Pwc.getContext(), e.b.1.this.PHb.Pwc.getMMResources().getString(2131758179), "", true);
                  AppMethodBeat.o(179947);
                }
              });
            }
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), paramString, paramca.field_msgId);
      ((com.tencent.mm.i.g)localObject3).field_fileId = ((k.b)localObject1).iwW;
      ((com.tencent.mm.i.g)localObject3).field_aesKey = ((k.b)localObject1).aesKey;
      ((com.tencent.mm.i.g)localObject3).field_filemd5 = ((k.b)localObject1).filemd5;
      ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.gpO;
      ((com.tencent.mm.i.g)localObject3).field_talker = paramString;
      ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.gpM;
      ((com.tencent.mm.i.g)localObject3).field_svr_signature = "";
      ((com.tencent.mm.i.g)localObject3).field_onlycheckexist = true;
      bool = com.tencent.mm.an.f.baQ().f((com.tencent.mm.i.g)localObject3);
      Log.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.i.g)localObject3).field_fileId, ((com.tencent.mm.i.g)localObject3).field_mediaId, Util.secPrint(((com.tencent.mm.i.g)localObject3).field_aesKey) });
      if (!bool) {
        a(parama, localIntent, paramca);
      }
      AppMethodBeat.o(36756);
    }
    
    static boolean a(Context paramContext, k.b paramb)
    {
      AppMethodBeat.i(233594);
      if ((paramb == null) || (paramContext == null))
      {
        AppMethodBeat.o(233594);
        return false;
      }
      boolean bool;
      if (e.m(paramb) == 3)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, 16L);
        AppMethodBeat.o(233594);
        return bool;
      }
      if (paramb.type == 4)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, 8L);
        AppMethodBeat.o(233594);
        return bool;
      }
      if (paramb.type == 5)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, 32L);
        AppMethodBeat.o(233594);
        return bool;
      }
      if (paramb.type == 6)
      {
        paramb = com.tencent.mm.pluginsdk.e.a.bcU(paramb.iwJ);
        if (paramb == null)
        {
          AppMethodBeat.o(233594);
          return false;
        }
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, paramb.longValue());
        AppMethodBeat.o(233594);
        return bool;
      }
      AppMethodBeat.o(233594);
      return false;
    }
    
    private static boolean a(com.tencent.mm.ui.chatting.e.a parama, Intent paramIntent, ca paramca)
    {
      AppMethodBeat.i(36757);
      if ((paramca.gDB()) || (h(paramca, null)))
      {
        Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.h.d(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131759394), parama.Pwc.getContext().getString(2131755998), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(36757);
        return true;
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramIntent.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36757);
      return false;
    }
    
    static boolean bng(String paramString)
    {
      AppMethodBeat.i(36755);
      boolean bool = Util.isImageExt(paramString);
      AppMethodBeat.o(36755);
      return bool;
    }
    
    public static boolean bnh(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(36759);
      Object localObject = com.tencent.mm.av.q.bcR().d(paramString, false, true);
      if (!com.tencent.mm.vfs.s.YS((String)localObject))
      {
        AppMethodBeat.o(36759);
        return false;
      }
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      localObject = BitmapUtil.decodeFile((String)localObject, paramString);
      if (paramString.outWidth * paramString.outHeight > 1048576)
      {
        Log.i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", new Object[] { Integer.valueOf(paramString.outWidth), Integer.valueOf(paramString.outHeight) });
        bool = true;
      }
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      AppMethodBeat.o(36759);
      return bool;
    }
    
    public static boolean h(ca paramca, String paramString)
    {
      AppMethodBeat.i(36758);
      if ((System.currentTimeMillis() - paramca.field_createTime > 259200000L) && ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.s.YS(paramString))))
      {
        AppMethodBeat.o(36758);
        return true;
      }
      AppMethodBeat.o(36758);
      return false;
    }
  }
  
  static final class c
    extends c.a
  {
    public static int[] tnn = { 2131298531, 2131298532, 2131298533, 2131298534, 2131298535 };
    private ArrayList<MMImageView> EuD;
    protected MMImageView PHM;
    protected MMNeat7extView PHN;
    protected ImageView PHO;
    protected ImageView PHP;
    protected TextView PHQ;
    protected LinearLayout PHR;
    protected TextView PHS;
    protected ImageView PHT;
    protected MMPinProgressBtn PHU;
    protected ImageView PHV;
    protected ImageView PHW;
    protected ImageView PHX;
    protected ImageView PHY;
    protected TextView PHZ;
    protected ImageView PIA;
    LinearLayout PIB;
    TextView PIC;
    TextView PID;
    ImageView PIE;
    ImageView PIF;
    ImageView PIG;
    TextView PIH;
    ImageView PII;
    LinearLayout PIJ;
    MMNeat7extView PIK;
    ImageView PIL;
    ImageView PIM;
    ImageView PIN;
    TextView PIO;
    TextView PIP;
    TextView PIQ;
    LinearLayout PIR;
    LinearLayout PIS;
    ImageView PIT;
    TextView PIU;
    TextView PIV;
    ImageView PIW;
    RelativeLayout PIX;
    LinearLayout PIY;
    TextView PIZ;
    protected ChattingItemFooter PIa;
    protected ImageView PIb;
    protected LinearLayout PIc;
    protected ViewGroup PId;
    protected TextView PIe;
    protected LinearLayout PIf;
    protected RelativeLayout PIg;
    protected FrameLayout PIh;
    protected LinearLayout PIi;
    protected LinearLayout PIj;
    protected ViewStub PIk;
    protected ImageView PIl;
    protected ImageView PIm;
    ImageView PIn;
    protected LinearLayout PIo;
    protected ImageView PIp;
    protected TextView PIq;
    protected ImageView PIr;
    protected TextView PIs;
    protected TextView PIt;
    protected LinearLayout PIu;
    protected ImageView PIv;
    protected ImageView PIw;
    protected ImageView PIx;
    protected TextView PIy;
    protected LinearLayout PIz;
    public int PJa;
    private int PJb;
    protected TextView jBR;
    protected ImageView lrd;
    protected TextView tln;
    
    c()
    {
      AppMethodBeat.i(36762);
      this.PJa = 0;
      this.PJb = 2147483647;
      this.EuD = new ArrayList();
      AppMethodBeat.o(36762);
    }
    
    private static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt, String paramString)
    {
      AppMethodBeat.i(233597);
      int i = 0;
      while (i <= 4)
      {
        localObject1 = (MMImageView)paramc.PIj.findViewById(tnn[i]);
        if (localObject1 != null)
        {
          ((MMImageView)localObject1).setImageDrawable(null);
          ((MMImageView)localObject1).setVisibility(8);
        }
        i += 1;
      }
      Object localObject1 = (ImageView)paramc.PIj.findViewById(2131298536);
      Object localObject2 = (TextView)paramc.PIj.findViewById(2131298530);
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      i = 0;
      if (i < paramInt)
      {
        label150:
        Object localObject3;
        if (paramInt == 1)
        {
          localObject1 = (MMImageView)paramc.PIj.findViewById(tnn[i]);
          ((MMImageView)localObject1).setImageResource(2131689936);
          ((MMImageView)localObject1).setVisibility(0);
          localObject2 = com.tencent.mm.av.q.bcR().o("Note_" + paramArrayOfString1[i], "", "");
          localObject3 = new com.tencent.mm.av.a.a.c.a();
          ((com.tencent.mm.av.a.a.c.a)localObject3).jbi = 1;
          ((com.tencent.mm.av.a.a.c.a)localObject3).jby = true;
          ((com.tencent.mm.av.a.a.c.a)localObject3).jbt = 2131689935;
          ((com.tencent.mm.av.a.a.c.a)localObject3).hZz = ((int)parama.Pwc.getMMResources().getDimension(2131165219));
          ((com.tencent.mm.av.a.a.c.a)localObject3).hZA = ((int)parama.Pwc.getMMResources().getDimension(2131165219));
          localObject3 = ((com.tencent.mm.av.a.a.c.a)localObject3).bdv();
          if (!com.tencent.mm.vfs.s.YS((String)localObject2)) {
            break label326;
          }
          com.tencent.mm.av.q.bcV().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.av.a.a.c)localObject3);
        }
        label326:
        long l;
        String str1;
        String str2;
        String str3;
        do
        {
          Log.i("MicroMsg.AppMsgViewHolder", "note get thumb");
          i += 1;
          break;
          localObject1 = (MMImageView)paramc.PIj.findViewById(tnn[(i + 1)]);
          ((MMImageView)localObject1).setImageResource(2131689935);
          break label150;
          localObject1 = com.tencent.mm.pluginsdk.model.app.ao.gne();
          localObject2 = (com.tencent.mm.pluginsdk.model.app.k.a)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class);
          localObject3 = paramArrayOfString1[i];
          l = Util.nowMilliSecond();
          str1 = paramArrayOfString2[i];
          str2 = paramArrayOfString3[i];
          j = paramArrayOfInt[i];
          str3 = com.tencent.mm.av.q.bcR().o("Note_".concat(String.valueOf(localObject3)), "", "");
        } while (com.tencent.mm.vfs.s.YS(str3));
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.taskName = "task_AppMessageExtension_2";
        localg.field_mediaId = com.tencent.mm.an.c.a("downappthumb", l, paramString, String.valueOf(localObject3));
        localg.field_fullpath = str3;
        localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        localg.field_totalLen = j;
        localg.field_aesKey = str1;
        localg.field_fileId = str2;
        localg.field_priority = com.tencent.mm.i.a.gpN;
        if (ab.Eq(paramString)) {}
        for (int j = 1;; j = 0)
        {
          localg.field_chattype = j;
          Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString });
          localg.gqy = new k.2((com.tencent.mm.pluginsdk.model.app.k)localObject1, (com.tencent.mm.pluginsdk.model.app.k.a)localObject2, str2);
          com.tencent.mm.an.f.baQ().b(localg, -1);
          break;
        }
      }
      AppMethodBeat.o(233597);
    }
    
    @SuppressLint({"ResourceType"})
    public static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb)
    {
      AppMethodBeat.i(233598);
      parama = paramb.w(parama.Pwc.getContext(), false);
      if (!Util.isNullOrNil(parama))
      {
        paramc.PHR.setVisibility(0);
        paramc.tln.setVisibility(0);
        paramc.PHO.setVisibility(0);
        paramc.tln.setText(parama);
        if (com.tencent.mm.ag.k.a.iwB.ordinal() == paramb.izp)
        {
          paramc.PHO.setImageResource(2131691209);
          AppMethodBeat.o(233598);
          return;
        }
        if ((com.tencent.mm.ag.k.a.iwC.ordinal() == paramb.izp) || (!Util.isNullOrNil(paramb.izt))) {
          if (!Util.isNullOrNil(paramb.izt)) {
            break label148;
          }
        }
      }
      label148:
      for (parama = paramb.izB;; parama = paramb.izt)
      {
        com.tencent.mm.av.q.bcU().a(parama, new r.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(233596);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233595);
                e.c.3.this.PJe.PHO.setImageBitmap(paramAnonymousBitmap);
                AppMethodBeat.o(233595);
              }
            });
            AppMethodBeat.o(233596);
          }
        });
        AppMethodBeat.o(233598);
        return;
      }
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, ca paramca, boolean paramBoolean)
    {
      AppMethodBeat.i(36768);
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(paramb.url, 5, "");
      paramc.PIi.setVisibility(8);
      paramc.PIJ.setVisibility(0);
      paramc.PIS.setVisibility(0);
      int i;
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        paramc.PIK.setMaxLines(2);
        paramc.PIK.setVisibility(0);
        paramc.PIK.aw(paramb.getTitle());
        localObject = (com.tencent.mm.ag.e)paramb.as(com.tencent.mm.ag.e.class);
        if (localObject == null) {
          break label479;
        }
        i = ((com.tencent.mm.ag.e)localObject).duration;
        label114:
        String str = com.tencent.mm.ag.m.rJ(i);
        if (Util.isNullOrNil(str)) {
          break label485;
        }
        paramc.PIP.setVisibility(0);
        paramc.PIP.setText(str);
      }
      for (;;)
      {
        paramc.PIN.setVisibility(0);
        if ((localObject != null) && (com.tencent.mm.ag.x.rK(((com.tencent.mm.ag.e)localObject).iwg)))
        {
          paramc.PIP.setVisibility(8);
          paramc.PIN.setVisibility(8);
        }
        al.a(parama.Pwc.getContext(), paramb, paramc.PIM, paramc.PIO);
        al.b(paramc.PIQ, paramb);
        paramc.PHT.setVisibility(4);
        i = com.tencent.mm.cb.a.aG(parama.Pwc.getContext(), 2131166078) - com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 24);
        int j = i * 9 / 16;
        if (com.tencent.mm.cb.a.ez(parama.Pwc.getContext()) > 1.0F)
        {
          int k = (int)((paramc.PJa / com.tencent.mm.cc.a.gvi() - com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 29) * com.tencent.mm.cb.a.ez(parama.Pwc.getContext())) * 9.0F / 16.0F);
          if (paramc.PIX.getLayoutParams().height != k)
          {
            paramc.PIX.getLayoutParams().height = k;
            paramc.PIX.requestLayout();
          }
        }
        if ((!paramBoolean) && (Util.isNullOrNil(paramb.thumburl))) {
          break label497;
        }
        parama = com.tencent.mm.api.b.u(paramb.thumburl, 4);
        paramb = new com.tencent.mm.av.a.a.c.a();
        paramb.jbq = 2131100173;
        paramb.jbe = true;
        paramb.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(parama);
        paramca = paramb.dr(i, j);
        paramca.jaU = new com.tencent.mm.pluginsdk.ui.applet.n(4);
        paramca.jbC = new com.tencent.mm.pluginsdk.ui.applet.e(4);
        paramca.jbd = true;
        com.tencent.mm.av.q.bcV().a(parama, paramc.PIL, paramb.bdv());
        AppMethodBeat.o(36768);
        return;
        paramc.PIK.setVisibility(8);
        break;
        label479:
        i = 0;
        break label114;
        label485:
        paramc.PIP.setVisibility(8);
      }
      label497:
      paramb = null;
      if (!e.b.bnh(paramca.field_imgPath)) {
        paramb = com.tencent.mm.av.q.bcR().a(paramca.field_imgPath, com.tencent.mm.cb.a.getDensity(parama.Pwc.getContext()), false);
      }
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        paramc.PIL.setImageBitmap(paramb);
        AppMethodBeat.o(36768);
        return;
      }
      paramc.PIL.setImageResource(2131100173);
      AppMethodBeat.o(36768);
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(36767);
      paramc.PHN.setVisibility(8);
      String str;
      Object localObject1;
      Object localObject3;
      label221:
      Object localObject2;
      int i;
      if ((paramb.title != null) && (paramb.title.trim().length() > 0))
      {
        str = paramb.title;
        paramc.PHS.setVisibility(0);
        paramc.PHS.setMaxLines(2);
        paramc.jBR.setMaxLines(4);
        paramc.PHY.setVisibility(8);
        paramc.PHT.setVisibility(4);
        if (paramBoolean) {
          paramc.PHM.setVisibility(8);
        }
        localObject1 = new rc();
        ((rc)localObject1).dXF.type = 0;
        ((rc)localObject1).dXF.dXH = paramb.ixl;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject3 = ((rc)localObject1).dXG.dXP;
        if (localObject3 == null) {
          break label1112;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(paramc.PHS.getContext(), Util.nullAs(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.PHS.getTextSize());
        paramc.PHS.setText((CharSequence)localObject1);
        localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
        if (localObject1 != null) {
          break label542;
        }
        Log.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.ixl });
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 100) {
            localObject2 = ((String)localObject1).substring(0, 100);
          }
        }
        paramc.jBR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramc.jBR.getContext(), Util.nullAs((String)localObject2, paramb.description), paramc.jBR.getTextSize()));
        paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).iAd.iterator();
        i = 0;
        localObject2 = null;
        localObject1 = null;
        label305:
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject3 = (aml)paramb.next();
        } while ((com.tencent.mm.plugin.fav.ui.l.j((aml)localObject3)) && (!Util.isNullOrNil(((aml)localObject3).Lwp)) && (((aml)localObject3).Lwp.equals("WeNoteHtmlFile")));
        if (((aml)localObject3).Lwh.LwO.LxA == null) {
          break label567;
        }
        str = parama.Pwc.getContext().getString(2131764266);
        i = 1;
        label390:
        switch (((aml)localObject3).dataType)
        {
        }
      }
      for (;;)
      {
        break label305;
        paramc.PHS.setVisibility(8);
        str = null;
        break;
        label542:
        localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        break label221;
        label567:
        if (((aml)localObject3).Lwh.LwO.dRL == null) {
          break label1109;
        }
        if (localObject1 == null)
        {
          localObject1 = ((aml)localObject3).Lwj;
          break label390;
        }
        if (localObject1 == ((aml)localObject3).Lwj) {
          break label1109;
        }
        localObject2 = ((aml)localObject3).Lwj;
        break label390;
        if (paramBoolean)
        {
          paramc.PHM.setVisibility(0);
          paramc.PHM.setImageResource(2131689586);
        }
        break label305;
        break label305;
        if (paramBoolean)
        {
          paramc.PHM.setVisibility(0);
          paramc.PHM.setImageResource(2131230967);
        }
        break label305;
        if (paramBoolean)
        {
          paramc.PHM.setVisibility(0);
          paramc.PHM.setImageResource(2131689587);
        }
        break label305;
        if ((paramBoolean) && (!com.tencent.mm.plugin.fav.a.b.cUq()))
        {
          paramc.PHM.setVisibility(0);
          paramc.PHM.setImageResource(2131690801);
          break label305;
          if (paramBoolean)
          {
            paramc.PHM.setVisibility(0);
            paramc.PHM.setImageResource(2131689584);
          }
          paramc.PHY.setVisibility(0);
          paramc.PHY.setImageResource(2131235406);
          break label305;
          paramc.PHM.setVisibility(0);
          paramc.PHM.setImageResource(2131689565);
          break label305;
          if (paramBoolean)
          {
            paramc.PHM.setVisibility(0);
            paramc.PHM.setImageResource(2131689567);
          }
          paramc.PHY.setVisibility(0);
          paramc.PHY.setImageResource(2131234185);
          break label305;
          if (paramBoolean)
          {
            paramc.PHM.setVisibility(0);
            paramc.PHM.setImageResource(2131689567);
          }
          paramc.PHY.setVisibility(0);
          paramc.PHY.setImageResource(2131234185);
          break label305;
          if (paramBoolean)
          {
            paramc.PHM.setVisibility(0);
            paramc.PHM.setImageResource(com.tencent.mm.pluginsdk.f.bcX(((aml)localObject3).LvC));
          }
          break label305;
          if (paramBoolean)
          {
            paramc.PHM.setVisibility(0);
            paramc.PHM.setImageResource(2131689580);
          }
          break label305;
          if (paramBoolean)
          {
            paramc.PHM.setVisibility(0);
            paramc.PHM.setImageResource(2131231957);
          }
        }
      }
      if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
        paramb = parama.Pwc.getContext().getString(2131759288, new Object[] { localObject1 });
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramb))
        {
          paramc.PHS.setText(paramb);
          paramc.PHS.setVisibility(0);
        }
        paramc.PHM.setVisibility(8);
        paramc.PIg.setVisibility(8);
        AppMethodBeat.o(36767);
        return;
        paramb = str;
        if (localObject1 != null)
        {
          paramb = str;
          if (localObject2 != null)
          {
            paramb = str;
            if (!((String)localObject1).equals(localObject2))
            {
              paramb = str;
              if (i == 0)
              {
                paramb = parama.Pwc.getContext().getString(2131759287, new Object[] { localObject1, localObject2 });
                continue;
                label1109:
                break;
                label1112:
                paramb = str;
              }
            }
          }
        }
      }
    }
    
    public static void a(c paramc, Boolean paramBoolean, final ca paramca, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(36766);
      final long l = paramca.field_msgId;
      com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(l);
      if (localc == null)
      {
        Log.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
        AppMethodBeat.o(36766);
        return;
      }
      if (paramBoolean.booleanValue()) {
        if (localc.field_status == 101L)
        {
          paramc.PHX.setVisibility(0);
          paramc.PHU.setVisibility(0);
          paramc.PHV.setVisibility(0);
        }
      }
      for (;;)
      {
        if (paramca.field_status == 5)
        {
          paramc.PHX.setVisibility(8);
          paramc.PHW.setVisibility(8);
        }
        paramc.PHX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36760);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if (this.PJc.booleanValue())
            {
              l = l;
              paramAnonymousView = paramca;
              localObject = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(l);
              if (localObject == null) {
                Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36760);
                return;
                if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 101L)
                {
                  Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
                }
                else
                {
                  ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 102L;
                  ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = Util.nowSecond();
                  com.tencent.mm.pluginsdk.model.app.ao.cgO().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
                }
              }
            }
            long l = l;
            paramAnonymousView = paramca;
            localObject = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(l);
            if (localObject == null) {
              Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.iBF.setStatus(5);
              bg.aVF();
              com.tencent.mm.model.c.aSQ().Hb(l);
              break;
              if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status == 101L) {
                break label357;
              }
              Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
            }
            label357:
            if ((Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_clientAppDataId)) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId))) {}
            for (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 102L;; ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 105L)
            {
              ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = Util.nowSecond();
              com.tencent.mm.pluginsdk.model.app.ao.cgO().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
              break;
            }
          }
        });
        paramc.PHW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36761);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if (!this.PJc.booleanValue())
            {
              long l = l;
              paramAnonymousView = paramca;
              localObject = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(l);
              if (localObject != null) {
                break label146;
              }
              Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.iBF.setStatus(1);
              bg.aVF();
              com.tencent.mm.model.c.aSQ().Hb(l);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(36761);
              return;
              label146:
              if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 105L) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 101L))
              {
                Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
              }
              else
              {
                ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 101L;
                ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = Util.nowSecond();
                com.tencent.mm.pluginsdk.model.app.ao.cgO().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
                com.tencent.mm.pluginsdk.model.app.ao.gnh().run();
              }
            }
          }
        });
        AppMethodBeat.o(36766);
        return;
        if (localc.field_status == 102L)
        {
          paramc.PHX.setVisibility(8);
          paramc.PHU.setVisibility(8);
          paramc.PHV.setVisibility(8);
        }
        else
        {
          paramc.PHX.setVisibility(8);
          paramc.PHU.setVisibility(8);
          paramc.PHV.setVisibility(8);
          continue;
          if (localc.field_status == 101L)
          {
            paramc.PHX.setVisibility(0);
            paramc.PHW.setVisibility(8);
          }
          else if (localc.field_status == 105L)
          {
            paramc.PHX.setVisibility(8);
            paramc.PHW.setVisibility(0);
          }
          else
          {
            paramc.PHX.setVisibility(8);
            paramc.PHW.setVisibility(8);
          }
        }
      }
    }
    
    public static void a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(36765);
      int i = com.tencent.mm.pluginsdk.model.app.m.bdI(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        paramc.PHU.setVisibility(8);
        paramc.PHV.setVisibility(8);
        AppMethodBeat.o(36765);
        return;
      }
      paramc.PHU.setVisibility(0);
      paramc.PHV.setVisibility(0);
      paramc.PHU.setProgress(i);
      AppMethodBeat.o(36765);
    }
    
    static void b(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, ca paramca, boolean paramBoolean)
    {
      AppMethodBeat.i(36769);
      Object localObject1 = new rc();
      ((rc)localObject1).dXF.type = 0;
      ((rc)localObject1).dXF.dXH = paramb.ixl;
      EventCenter.instance.publish((IEvent)localObject1);
      Object localObject2 = ((rc)localObject1).dXG.dXP;
      paramc.PIg.setVisibility(8);
      String[] arrayOfString1 = new String[4];
      String[] arrayOfString2 = new String[4];
      int[] arrayOfInt = new int[4];
      Object localObject3 = new String[4];
      String[] arrayOfString4 = new String[4];
      Object localObject4 = new int[4];
      String[] arrayOfString3 = new String[4];
      int k;
      int i;
      aml localaml;
      if (localObject2 != null)
      {
        localObject1 = null;
        paramb = Util.nullAs(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
        k = 0;
        Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject2).iAd.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localaml = (aml)localIterator.next();
          if ((!com.tencent.mm.plugin.fav.ui.l.j(localaml)) || (Util.isNullOrNil(localaml.Lwp)) || (!localaml.Lwp.equals("WeNoteHtmlFile"))) {
            switch (localaml.dataType)
            {
            case 3: 
            case 6: 
            case 4: 
            case 5: 
            case 7: 
            default: 
            case 1: 
              label248:
              String str;
              do
              {
                do
                {
                  break;
                } while (k != 0);
                str = localaml.desc;
              } while (Util.isNullOrNil(str));
              if (Util.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label1205;
              }
              localObject1 = localaml.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
          }
        }
      }
      label791:
      label1196:
      label1199:
      label1205:
      for (;;)
      {
        k = 1;
        break;
        if (paramBoolean)
        {
          paramc.PIg.setVisibility(0);
          paramc.PHM.setVisibility(0);
          paramc.PHM.setImageResource(2131230967);
        }
        if (i < 4)
        {
          arrayOfString1[i] = localaml.iwX;
          arrayOfString2[i] = localaml.Lvk;
          arrayOfInt[i] = ((int)localaml.LvT);
          localObject3[i] = localaml.KuR;
          arrayOfString4[i] = localaml.Lvp;
          localObject4[i] = ((int)localaml.LvI);
          arrayOfString3[i] = localaml.dLl;
        }
        i += 1;
        break;
        if (!Util.isNullOrNil(paramb)) {
          break label248;
        }
        paramb = MMApplicationContext.getContext().getString(2131755851) + localaml.title;
        break label248;
        if (localObject1 != null)
        {
          arrayOfString4 = ((String)localObject1).split("\n", 2);
          localObject3 = new ArrayList();
          if (arrayOfString4.length > 0)
          {
            int m = arrayOfString4.length;
            j = 0;
            while (j < m)
            {
              localObject4 = arrayOfString4[j];
              if (((String)localObject4).length() > 0) {
                ((ArrayList)localObject3).add(localObject4);
              }
              j += 1;
            }
          }
          if (((ArrayList)localObject3).size() != 1) {
            break label1199;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).iAd.size() == 2))
          {
            localObject2 = MMApplicationContext.getContext().getString(2131759360);
            paramb = (k.b)localObject1;
            localObject1 = localObject2;
            localObject1 = ((String)localObject1).trim();
            label616:
            if (localObject1 == null) {
              break label1196;
            }
            localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.pluginsdk.ui.span.l.e(paramc.PHS.getContext(), (CharSequence)localObject1, (int)paramc.PHS.getTextSize());
            paramc.PHS.setText((CharSequence)localObject1);
            if ((paramb != null) && (paramb.length() > 100)) {
              paramb = paramb.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            for (;;)
            {
              for (;;)
              {
                localObject1 = com.tencent.mm.pluginsdk.ui.span.l.e(paramc.jBR.getContext(), paramb, (int)paramc.jBR.getTextSize());
                paramc.jBR.setText((CharSequence)localObject1);
                if (i > 0)
                {
                  paramc.PIg.setVisibility(8);
                  if ((j != 0) || (k == 0) || (Util.isNullOrNil(paramb)))
                  {
                    paramc.jBR.setVisibility(8);
                    paramc.PHS.setMaxLines(2);
                    paramc.PIl.setVisibility(8);
                    paramc.PIk.setLayoutResource(2131493571);
                  }
                  try
                  {
                    if (paramc.PIj == null) {
                      paramc.PIj = ((LinearLayout)paramc.PIk.inflate());
                    }
                    for (;;)
                    {
                      if (i <= 4) {
                        break label1162;
                      }
                      j = 4;
                      a(parama, paramc, j, arrayOfString3, arrayOfString2, arrayOfString1, arrayOfInt, paramca.field_talker);
                      parama = (ImageView)paramc.PIj.findViewById(2131298536);
                      paramc = (TextView)paramc.PIj.findViewById(2131298530);
                      if (paramc != null) {
                        paramc.setTextSize(0, MMApplicationContext.getContext().getResources().getDimensionPixelSize(2131165586));
                      }
                      if (i > 4)
                      {
                        if (parama != null) {
                          parama.setVisibility(0);
                        }
                        if (paramc != null)
                        {
                          paramc.setText("(" + i + ")");
                          paramc.setVisibility(0);
                        }
                      }
                      AppMethodBeat.o(36769);
                      return;
                      if (i > 0)
                      {
                        localObject1 = (String)((ArrayList)localObject3).get(0);
                        if (((ArrayList)localObject3).size() > 1)
                        {
                          paramb = (String)((ArrayList)localObject3).get(1);
                          break;
                        }
                        paramb = null;
                        break;
                      }
                      localObject2 = (String)((ArrayList)localObject3).get(0);
                      localObject3 = paramb.split(Pattern.quote((String)localObject2), 2);
                      paramb = localObject3[0].trim();
                      localObject1 = localObject2;
                      if (localObject3.length <= 1) {
                        break;
                      }
                      paramb = (localObject3[0].trim() + "\n" + localObject3[1].trim()).trim();
                      localObject1 = localObject2;
                      break;
                      localObject1 = MMApplicationContext.getContext().getString(2131759360);
                      j = 0;
                      break label616;
                      paramc.jBR.setMaxLines(1);
                      paramc.jBR.setVisibility(0);
                      paramc.PHS.setMaxLines(1);
                      break label791;
                      paramc.PIj.setVisibility(0);
                    }
                  }
                  catch (Exception paramb)
                  {
                    for (;;)
                    {
                      paramc.PIk.setVisibility(0);
                      continue;
                      j = i;
                    }
                  }
                }
              }
              paramc.PIk.setVisibility(8);
              paramc.PIl.setVisibility(0);
              AppMethodBeat.o(36769);
              return;
            }
          }
        }
      }
    }
    
    public final c F(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(36763);
      super.create(paramView);
      this.PIz = ((LinearLayout)paramView.findViewById(2131298358));
      this.PHM = ((MMImageView)paramView.findViewById(2131298388));
      this.PHN = ((MMNeat7extView)paramView.findViewById(2131298390));
      this.PHS = ((TextView)paramView.findViewById(2131298393));
      this.jBR = ((TextView)paramView.findViewById(2131298367));
      this.tln = ((TextView)paramView.findViewById(2131298385));
      this.PHO = ((ImageView)paramView.findViewById(2131298382));
      this.PHQ = ((TextView)paramView.findViewById(2131298384));
      this.PHP = ((ImageView)paramView.findViewById(2131298383));
      this.PHR = ((LinearLayout)paramView.findViewById(2131298381));
      this.PHT = ((ImageView)paramView.findViewById(2131298386));
      this.PHU = ((MMPinProgressBtn)paramView.findViewById(2131298432));
      this.PHV = ((ImageView)this.convertView.findViewById(2131298431));
      this.PHW = ((ImageView)this.convertView.findViewById(2131298421));
      this.PHX = ((ImageView)this.convertView.findViewById(2131298557));
      this.PHY = ((ImageView)paramView.findViewById(2131298369));
      this.PHZ = ((TextView)paramView.findViewById(2131298364));
      this.PIb = ((ImageView)paramView.findViewById(2131298380));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.PIa = ((ChattingItemFooter)paramView.findViewById(2131301661));
      this.PIc = ((LinearLayout)paramView.findViewById(2131296956));
      this.PId = ((ViewGroup)paramView.findViewById(2131303752));
      this.PIe = ((TextView)paramView.findViewById(2131303749));
      this.PIf = ((LinearLayout)paramView.findViewById(2131298394));
      this.PIh = ((FrameLayout)paramView.findViewById(2131298411));
      this.PIi = ((LinearLayout)paramView.findViewById(2131298365));
      this.PIm = ((ImageView)paramView.findViewById(2131298419));
      this.PIg = ((RelativeLayout)paramView.findViewById(2131298387));
      this.PIk = ((ViewStub)paramView.findViewById(2131305516));
      this.PIl = ((ImageView)paramView.findViewById(2131298424));
      if (!paramBoolean)
      {
        this.PIn = ((ImageView)this.convertView.findViewById(2131298556));
        this.uploadingPB = ((ProgressBar)this.convertView.findViewById(2131309619));
      }
      this.PIu = ((LinearLayout)paramView.findViewById(2131298346));
      this.PIr = ((ImageView)paramView.findViewById(2131298359));
      this.PIs = ((TextView)paramView.findViewById(2131298361));
      this.PIy = ((TextView)paramView.findViewById(2131298357));
      this.PIx = ((ImageView)paramView.findViewById(2131300157));
      this.PIv = ((ImageView)paramView.findViewById(2131298347));
      this.PIw = ((ImageView)paramView.findViewById(2131298344));
      this.PIo = ((LinearLayout)paramView.findViewById(2131298345));
      this.PIp = ((ImageView)paramView.findViewById(2131298320));
      this.PIq = ((TextView)paramView.findViewById(2131298321));
      this.PIt = ((TextView)paramView.findViewById(2131298360));
      this.lrd = ((ImageView)paramView.findViewById(2131298322));
      this.PIA = ((ImageView)paramView.findViewById(2131298324));
      this.PIB = ((LinearLayout)paramView.findViewById(2131298350));
      this.PIC = ((TextView)paramView.findViewById(2131298356));
      this.PID = ((TextView)paramView.findViewById(2131298352));
      this.PIE = ((ImageView)paramView.findViewById(2131298353));
      this.PIF = ((ImageView)paramView.findViewById(2131298351));
      this.PIG = ((ImageView)paramView.findViewById(2131298354));
      this.PIH = ((TextView)paramView.findViewById(2131298355));
      this.PII = ((ImageView)paramView.findViewById(2131298349));
      this.PIJ = ((LinearLayout)paramView.findViewById(2131298371));
      this.PIN = ((ImageView)paramView.findViewById(2131298375));
      this.PIK = ((MMNeat7extView)paramView.findViewById(2131298376));
      this.PIL = ((ImageView)paramView.findViewById(2131298374));
      this.PIR = ((LinearLayout)paramView.findViewById(2131304918));
      this.PIS = ((LinearLayout)paramView.findViewById(2131304920));
      this.PIW = ((ImageView)paramView.findViewById(2131304919));
      this.PIX = ((RelativeLayout)paramView.findViewById(2131298372));
      this.PIT = ((ImageView)this.PIR.findViewById(2131298368));
      this.PIU = ((TextView)this.PIR.findViewById(2131298370));
      this.PIV = ((TextView)this.PIR.findViewById(2131298379));
      this.PIM = ((ImageView)this.PIS.findViewById(2131298368));
      this.PIO = ((TextView)this.PIS.findViewById(2131298370));
      this.PIQ = ((TextView)this.PIS.findViewById(2131298379));
      this.PIP = ((TextView)paramView.findViewById(2131298373));
      this.PIY = ((LinearLayout)paramView.findViewById(2131298391));
      this.PIZ = ((TextView)paramView.findViewById(2131298392));
      if ((this.PHS != null) && (Build.VERSION.SDK_INT >= 16)) {
        this.PJb = this.PHS.getMaxLines();
      }
      this.PJa = c.kk(MMApplicationContext.getContext());
      AppMethodBeat.o(36763);
      return this;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(36764);
      if (this.PHS != null) {
        this.PHS.setMaxLines(this.PJb);
      }
      AppMethodBeat.o(36764);
    }
  }
  
  public static final class d
    extends c
  {
    protected t.i PJg;
    protected t.l PJh;
    protected t.j PJi;
    private com.tencent.mm.ui.chatting.e.a PhN;
    private boolean tcb;
    
    public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36799);
      if ((com.tencent.mm.q.a.cC(parama.Pwc.getContext())) || (com.tencent.mm.q.a.cA(parama.Pwc.getContext())) || (com.tencent.mm.q.a.cE(parama.Pwc.getContext())))
      {
        Log.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        AppMethodBeat.o(36799);
        return true;
      }
      if (paramc.a(parama, paramb, paramca))
      {
        AppMethodBeat.o(36799);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.R(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.R(paramb.iwH, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.Pwc.getContext(), paramb.appId);
      String str1;
      if (localPackageInfo == null)
      {
        str1 = null;
        if (localPackageInfo != null) {
          break label173;
        }
      }
      label173:
      for (int i = 0;; i = localPackageInfo.versionCode)
      {
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, paramca.field_msgId, paramca.field_msgSvrId, paramca);
        AppMethodBeat.o(36799);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(161905);
      Object localObject = com.tencent.mm.ui.tools.x.Qxl;
      com.tencent.mm.ui.tools.x.gXY();
      if ((Util.isNullOrNil(paramb.izj)) && (Util.isNullOrNil(paramb.izi)))
      {
        paramca = paramb.url;
        if (parama.gRM()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.R(paramca, paramc);
          paramca = new Intent();
          paramca.putExtra("rawUrl", paramc);
          paramca.putExtra("webpageTitle", paramb.title);
          paramca.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
          AppMethodBeat.o(161905);
          return true;
        }
      }
      localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.gRM()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.h.R(paramca));
        ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(parama.Pwc.getContext(), parama.getTalkerUserName(), paramc.a(parama, paramca), parama.gRM(), paramb, localBundle);
        AppMethodBeat.o(161905);
        return true;
        if (ab.IT((String)localObject)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean c(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36800);
      Object localObject1 = (com.tencent.mm.ag.a)paramb.as(com.tencent.mm.ag.a.class);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.ag.a)localObject1).ivm)) && (!Util.isNullOrNil(((com.tencent.mm.ag.a)localObject1).ivo)))
      {
        String str2 = ((com.tencent.mm.ag.a)localObject1).ivm;
        String str3 = ((com.tencent.mm.ag.a)localObject1).ivl;
        String str1;
        int i;
        if (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject1).ivp))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ag.a)localObject1).ivn;
          paramb = paramb.izj;
          localObject1 = ((com.tencent.mm.ag.a)localObject1).ivo;
          Log.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { str2, str3, str1, str4, paramb, localObject1 });
          Object localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
          if (!ab.Eq(parama.getTalkerUserName())) {
            break label308;
          }
          i = 2;
          label155:
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(17608, new Object[] { Integer.valueOf(i), paramb, Integer.valueOf(1), Integer.valueOf(1) });
          if (Util.isNullOrNil(str2)) {
            break label314;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_chatting_wording", str1);
          ((Bundle)localObject2).putString("key_chatting_text", str4);
          ((Bundle)localObject2).putString("key_chatting_appid", paramb);
          ((Bundle)localObject2).putLong("key_msg_id", paramca.field_msgId);
          ((Bundle)localObject2).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject2).putString("key_sender_username", paramc.a(parama, paramca));
          e.a(parama, str2, str3, (String)localObject1, (Bundle)localObject2);
        }
        for (;;)
        {
          AppMethodBeat.o(36800);
          return true;
          str1 = ((com.tencent.mm.ag.a)localObject1).ivp;
          break;
          label308:
          i = 1;
          break label155;
          label314:
          Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: video msg invalid!!");
        }
      }
      Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: no remote url provided. treat as default");
      AppMethodBeat.o(36800);
      return false;
    }
    
    public static boolean d(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36801);
      Log.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.izi, paramb.izh, paramb.izj, paramb.url, Integer.valueOf(paramb.izz), paramb.izl });
      if ((44 == paramb.type) && ((!paramb.fn(false)) || (Util.isNullOrNil(paramb.w(parama.Pwc.getContext(), false)))))
      {
        AppMethodBeat.o(36801);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramca);
      paramc = new Bundle();
      int i;
      if ((parama.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        paramc.putInt("stat_scene", i);
        paramc.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        paramc.putString("stat_chat_talker_username", (String)localObject);
        paramc.putString("stat_send_msg_user", str);
        switch (paramb.izk)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cL(paramca);
        if (i != 0) {
          break label582;
        }
        AppMethodBeat.o(36801);
        return true;
        if (parama.gRM())
        {
          i = 2;
          break;
        }
        if (ab.IT((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_username", paramb.izi);
        if (parama.gRM())
        {
          localIntent.putExtra("key_from_scene", 1);
          localIntent.putExtra("key_scene_note", (String)localObject + ":" + str);
        }
        for (;;)
        {
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.izj;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).kNW = paramb.izz;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.izm;
          localIntent.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bAv());
          localIntent.putExtra("_stat_obj", paramc);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "appbrand", ".ui.AppBrandProfileUI", localIntent);
          i = 0;
          break;
          localIntent.putExtra("key_from_scene", 2);
          localIntent.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.al.h.R(paramca))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1157, paramb, paramc);
          i = 0;
        }
        else if (ab.IT((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, paramc);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.gRM(), paramb, paramc);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.gRM(), paramb, paramc);
          i = 0;
        }
      }
      label582:
      AppMethodBeat.o(36801);
      return false;
    }
    
    public static boolean e(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(169872);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!Util.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", paramca.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", paramca.field_imgPath);
          paramb = com.tencent.mm.plugin.sns.data.k.ka(paramb.dRL, paramca.field_talker);
          if (!TextUtils.isEmpty(paramb)) {
            paramc.putExtra("sns_landing_pages_extra", paramb);
          }
          paramc.addFlags(268435456);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        aj localaj = (aj)paramb.as(aj.class);
        if ((localaj != null) && (!Util.isNullOrNil(localaj.IEy)))
        {
          paramb = new fat();
          paramb.IEy = localaj.IEy;
          paramb.IEz = localaj.IEz;
          paramb.IEA = localaj.IEA;
          paramb.IEB = localaj.IEB;
          paramb.IEC = localaj.IEC;
          paramb.IEG = localaj.IEG;
          paramb.rCq = localaj.rCq;
          paramb.msN = localaj.msN;
          paramb.xDQ = localaj.xDQ;
          paramb.IED = localaj.IED;
          paramb.IEE = localaj.IEE;
          paramb.IEF = localaj.IEF;
          paramb.source = localaj.source;
          paramb.eby = localaj.eby;
          paramb.IEH = localaj.IEH;
          paramb.IEJ = localaj.IEJ;
          paramb.IEK = localaj.IEK;
          paramb.IEL = localaj.IEL;
          paramb.IEI = localaj.IEI;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.Pwc.getContext().getString(2131761038));
          com.tencent.mm.plugin.topstory.a.i.a(paramb, paramca);
          ai.a(parama.Pwc.getContext(), paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject2 = paramb.url;
        Object localObject1;
        PackageInfo localPackageInfo;
        Intent localIntent;
        int j;
        if (parama.gRM())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.R((String)localObject2, (String)localObject1);
          String str = paramb.url;
          localPackageInfo = c.getPackageInfo(parama.Pwc.getContext(), paramb.appId);
          localIntent = new Intent();
          j = parama.Pwc.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 1, j, i);
          }
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId))))
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
            localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          }
          if (Util.isNullOrNil(str)) {
            break label1305;
          }
          localIntent.putExtra("shortUrl", str);
          label653:
          if (localPackageInfo != null) {
            break label1320;
          }
          localObject2 = null;
          label661:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1330;
          }
          i = 0;
          label680:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.eag))
          {
            localIntent.putExtra("srcUsername", paramb.eag);
            localIntent.putExtra("srcDisplayname", paramb.eah);
          }
          localIntent.putExtra("msg_id", paramca.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramca));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", paramca.fRa);
          localIntent.putExtra("msgUsername", paramb.dRL);
          localIntent.putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
          i = com.tencent.mm.model.ac.aJ(paramc.a(parama, paramca), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.a(parama, paramca));
          localIntent.putExtra("preChatName", parama.getTalkerUserName());
          localIntent.putExtra("preChatTYPE", i);
          localIntent.putExtra("preMsgIndex", 0);
          switch (i)
          {
          case 3: 
          case 4: 
          case 5: 
          default: 
            i = 0;
            label1007:
            localIntent.putExtra("share_report_pre_msg_url", paramb.url);
            localIntent.putExtra("share_report_pre_msg_title", paramb.title);
            localIntent.putExtra("share_report_pre_msg_desc", paramb.description);
            localIntent.putExtra("share_report_pre_msg_icon_url", paramb.thumburl);
            localIntent.putExtra("share_report_pre_msg_appid", paramb.appId);
            localIntent.putExtra("share_report_from_scene", i);
            localIntent.putExtra("geta8key_scene", 1);
            if (i == 5) {
              localIntent.putExtra("share_report_biz_username", parama.getTalkerUserName());
            }
            paramb = (com.tencent.mm.ag.e)paramb.as(com.tencent.mm.ag.e.class);
            if (paramb == null) {
              break;
            }
          }
        }
        for (int i = paramb.iwc;; i = -1)
        {
          localIntent.putExtra(e.p.OzA, i);
          localIntent.putExtra("key_enable_teen_mode_check", true);
          localIntent.addFlags(536870912);
          if ((paramb == null) || (i != 5) || (paramb.iwe != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld())) {
            break label1364;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.OyQ, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.OyR, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          if ((localaj != null) && (!Util.isNullOrNil(localaj.IEy)))
          {
            paramc = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(localaj.IEy);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.Pwc.getContext(), paramca.field_msgId, paramca.field_msgSvrId, 0, paramb);
          AppMethodBeat.o(169872);
          return true;
          localObject1 = "singlemessage";
          break;
          label1305:
          localIntent.putExtra("shortUrl", paramb.url);
          break label653;
          label1320:
          localObject2 = localPackageInfo.versionName;
          break label661;
          label1330:
          i = localPackageInfo.versionCode;
          break label680;
          i = 2;
          break label1007;
          i = 3;
          break label1007;
          i = 5;
          break label1007;
        }
        label1364:
        c(parama, paramca);
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.Pwc.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          Log.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(169872);
        return true;
      }
      AppMethodBeat.o(169872);
      return false;
    }
    
    private t.i j(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36791);
      if (this.PJg == null) {
        this.PJg = new t.i(parama);
      }
      parama = this.PJg;
      AppMethodBeat.o(36791);
      return parama;
    }
    
    private t.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36792);
      if (this.PJh == null) {
        this.PJh = new t.l(parama);
      }
      parama = this.PJh;
      AppMethodBeat.o(36792);
      return parama;
    }
    
    private t.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36793);
      if (this.PJi == null) {
        this.PJi = new t.j(parama);
      }
      parama = this.PJi;
      AppMethodBeat.o(36793);
      return parama;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36794);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new an(paramLayoutInflater, 2131493526);
        ((View)localObject).setTag(new e.c().F((View)localObject, true));
      }
      AppMethodBeat.o(36794);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36795);
      final e.c localc = (e.c)parama;
      this.PhN = parama1;
      localc.reset();
      String str = paramca.getContent();
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bX(paramca);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bY(paramca);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bZ(paramca);
      int i;
      if (this.tcb)
      {
        i = paramca.getContent().indexOf(':');
        if (i != -1) {
          str = paramca.getContent().substring(i + 1);
        }
      }
      for (;;)
      {
        k.b localb;
        Object localObject3;
        int k;
        Object localObject2;
        com.tencent.mm.pluginsdk.model.app.g localg;
        label549:
        boolean bool1;
        if (str != null)
        {
          localb = k.b.aD(str, paramca.ajQ());
          localObject3 = t.HI(str);
          localObject1 = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
          i = 0;
          k = 0;
          localc.PIY.setVisibility(8);
          localObject2 = localObject1;
          if (localb != null)
          {
            localc.PHN.aw(localb.getTitle());
            localc.jBR.setText(localb.getDescription());
            localc.PHS.setMaxLines(1);
            localc.PHN.setTextColor(parama1.getContext().getResources().getColor(2131099746));
            localc.jBR.setTextColor(parama1.getContext().getResources().getColor(2131100584));
            localc.PIi.setBackgroundResource(2131231671);
            localc.PIi.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165518), 0, 0);
            localc.PHM.setVisibility(0);
            localc.PIg.setVisibility(0);
            localc.jBR.setVisibility(0);
            localc.PHU.setVisibility(8);
            localc.PHX.setVisibility(8);
            localc.PHW.setVisibility(8);
            localc.PIk.setVisibility(8);
            localc.PIl.setVisibility(8);
            localc.PHP.setVisibility(8);
            localc.PHQ.setVisibility(8);
            localc.PIu.setVisibility(8);
            localc.PIo.setVisibility(8);
            localc.PIi.setVisibility(0);
            localc.PIB.setVisibility(8);
            localc.PIJ.setVisibility(8);
            localc.PIR.setVisibility(8);
            localc.PIW.setVisibility(8);
            localc.resetChatBubbleWidth(localc.PIh, localc.PJa);
            localb.as(com.tencent.mm.ag.h.class);
            localc.PIh.setBackgroundResource(2131231671);
            localg = com.tencent.mm.pluginsdk.model.app.h.gE(localb.appId, localb.appVersion);
            if (localg != null) {
              b(parama1, localb, paramca);
            }
            if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
              break label1699;
            }
            localObject2 = localb.appName;
            bool1 = true;
            com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 12);
            if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
              bool1 = o.a.glW().eUk();
            }
            if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!gp((String)localObject2))) {
              break label1739;
            }
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), localg, (String)localObject2);
            if (localb.type != 19) {
              break label1709;
            }
            localc.tln.setText(parama1.getContext().getResources().getString(2131763802, new Object[] { localObject2 }));
            label681:
            localc.tln.setVisibility(0);
            localc.tln.setCompoundDrawables(null, null, null, null);
            localc.PHR.setVisibility(0);
            localc.PHO.setVisibility(0);
            if ((localg == null) || (!localg.NA())) {
              break label1722;
            }
            a(parama1, localc.tln, paramca, localb, localg.field_packageName, paramca.ajM());
            label756:
            localc.PHO.setImageResource(2131231768);
            a(parama1, localc.PHO, localb.appId);
            i = 1;
          }
        }
        for (;;)
        {
          label784:
          if (localb.aSx()) {
            localc.PHR.setVisibility(8);
          }
          for (int j = 0;; j = i)
          {
            localc.PHR.setBackgroundResource(2131233974);
            bool1 = false;
            localc.PHM.setVisibility(0);
            if ((!localb.aSy()) && (this.qoo))
            {
              Bitmap localBitmap = null;
              localObject2 = localBitmap;
              if (localb.type != 33)
              {
                localObject2 = localBitmap;
                if (localb.type != 36)
                {
                  localObject2 = localBitmap;
                  if (localb.type != 44)
                  {
                    localObject2 = localBitmap;
                    if (localb.type != 48)
                    {
                      localObject2 = localBitmap;
                      if (!e.b.bnh(paramca.ajP())) {
                        localObject2 = com.tencent.mm.av.q.bcR().d(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                      }
                    }
                  }
                }
              }
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localBitmap = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject2, false, com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 1));
                localc.PHM.setImageBitmap(localBitmap);
                label977:
                if (e.m(localb) != 3) {
                  break label1934;
                }
                localc.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  private boolean qCs = false;
                  
                  public final boolean onPreDraw()
                  {
                    AppMethodBeat.i(36771);
                    if (this.qCs)
                    {
                      localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                    localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.qCs = true;
                    int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Pwc.getContext(), 24);
                    Bitmap localBitmap = this.val$bitmap;
                    Object localObject;
                    if (localBitmap != null)
                    {
                      localObject = localBitmap;
                      if (!localBitmap.isRecycled()) {}
                    }
                    else
                    {
                      localObject = BitmapUtil.createColorBitmap(parama1.Pwc.getContext().getResources().getColor(2131100161), i, i);
                    }
                    int j = ((Bitmap)localObject).getHeight();
                    if (i > j) {
                      i = j;
                    }
                    for (;;)
                    {
                      localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                      j = localc.PIi.getHeight();
                      int k = localc.PIi.getWidth();
                      i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166076);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166077);
                      }
                      localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, 2131231617, j, i));
                      localc.PIi.setBackgroundDrawable((Drawable)localObject);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                  }
                });
                if (!com.tencent.mm.ui.ao.isDarkMode()) {
                  break label1923;
                }
                localc.PHR.setBackgroundResource(2131233974);
                label1027:
                if ((localb.fQR != null) && (localb.fQR.length() != 0)) {
                  break label1961;
                }
                localc.PHZ.setVisibility(8);
                label1056:
                localc.PHY.setOnClickListener(null);
                localc.PIc.setVisibility(0);
                localc.PHT.setVisibility(8);
                localc.PIf.setVisibility(0);
                localc.PId.setVisibility(8);
                i = e.m(localb);
                if (localb.type == 66)
                {
                  if ((TextUtils.isEmpty(localb.izi)) && (TextUtils.isEmpty(localb.izj))) {
                    break label1991;
                  }
                  i = 33;
                }
              }
            }
            label1146:
            label2555:
            label6011:
            switch (i)
            {
            case 1: 
            case 2: 
            case 8: 
            case 9: 
            case 11: 
            case 12: 
            case 14: 
            case 17: 
            case 18: 
            case 21: 
            case 22: 
            case 23: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 35: 
            case 37: 
            case 38: 
            case 39: 
            case 41: 
            case 42: 
            case 43: 
            case 45: 
            case 46: 
            case 47: 
            default: 
              paramInt = 1;
              parama = (c.a)localObject1;
              i = k;
            case 3: 
            case 6: 
            case 4: 
            case 5: 
            case 36: 
            case 33: 
            case 48: 
            case 44: 
            case 7: 
            case 10: 
            case 13: 
            case 20: 
            case 0: 
              for (;;)
              {
                if (paramInt != 0)
                {
                  if ((localb.title == null) || (localb.title.length() <= 0)) {
                    break label7276;
                  }
                  localc.PHS.setVisibility(0);
                  localc.PHS.setMaxLines(2);
                  localc.PHS.setText(localb.title);
                  localc.PHN.setVisibility(8);
                  if (bool1)
                  {
                    if ((localb.type != 33) && (localb.type != 36)) {
                      break label7289;
                    }
                    paramString = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                    localc.PHM.setImageResource(2131689587);
                    com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PHM, "file://".concat(String.valueOf(paramString)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(50, 50));
                  }
                  if (localb.type == 44) {
                    e.c.a(parama1, localc, localb);
                  }
                }
                if (parama1.gRM()) {
                  break label7466;
                }
                if (!com.tencent.mm.pluginsdk.model.app.h.k(localg)) {
                  break label7450;
                }
                localc.PIb.setVisibility(0);
                c(parama1, localc.PIb, bq.a(localb, paramca));
                localObject2 = parama;
                if (i == 0)
                {
                  localc.PIh.setTag(localObject2);
                  localc.PIh.setOnClickListener(d(parama1));
                }
                if (this.qoo)
                {
                  localc.PIh.setOnLongClickListener(c(parama1));
                  localc.PIh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                }
                AppMethodBeat.o(36795);
                return;
                Log.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.ajL()), paramString });
                localObject3 = null;
                localb = null;
                break;
                localObject2 = localg.field_appName;
                break label549;
                localc.tln.setText((CharSequence)localObject2);
                break label681;
                a(parama1, localc.tln, localb.appId);
                break label756;
                if (localb.type == 24)
                {
                  localc.tln.setText(MMApplicationContext.getContext().getString(2131759168));
                  localc.PHR.setVisibility(0);
                  localc.tln.setVisibility(0);
                  localc.PHO.setVisibility(8);
                  i = 1;
                  break label784;
                }
                if ((localb.type == 19) || (((t)localObject3).iAl == 19))
                {
                  localc.tln.setText(MMApplicationContext.getContext().getString(2131757420));
                  localc.PHR.setVisibility(0);
                  localc.tln.setVisibility(0);
                  localc.PHO.setVisibility(8);
                  i = 1;
                  break label784;
                }
                if (e.a(localb, localc)) {
                  break label7506;
                }
                localc.PHR.setVisibility(8);
                localc.tln.setVisibility(8);
                localc.PHO.setVisibility(8);
                i = 0;
                break label784;
                bool1 = true;
                break label977;
                localc.PHR.setBackgroundResource(2131231749);
                break label1027;
                localc.PHM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131234278));
                bool1 = false;
                break label1027;
                localc.PHZ.setVisibility(0);
                b(parama1, localc.PHZ, bq.bnn(localb.fQR));
                break label1056;
                i = 5;
                break label1146;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.PHN.setVisibility(0);
                  localc.PHN.setTextColor(parama1.getContext().getResources().getColor(2131101427));
                  localc.jBR.setVisibility(0);
                  localc.jBR.setTextColor(parama1.getContext().getResources().getColor(2131101427));
                  localc.PHS.setVisibility(8);
                  localc.PHT.setVisibility(4);
                  localc.PHY.setVisibility(0);
                  if (!paramca.ajL().equals(parama.playingMsgId)) {
                    break label2288;
                  }
                  localc.PHY.setImageResource(2131234170);
                  localc.jBR.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label2302;
                    }
                    localc.PHM.setImageResource(2131689567);
                  }
                }
                for (;;)
                {
                  parama = new e.g();
                  parama.msgId = paramca.ajL();
                  parama.xml = paramca.getContent();
                  parama.dRr = paramca.ajP();
                  localc.PHY.setTag(parama);
                  localc.PHY.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOD());
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.PHN.setVisibility(8);
                  break label2046;
                  localc.PHY.setImageResource(2131234185);
                  break label2143;
                  localc.PHM.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.PHN.setVisibility(0);
                  localc.PHN.setMaxLines(2);
                }
                for (;;)
                {
                  localc.jBR.setVisibility(0);
                  localc.PHS.setVisibility(8);
                  localc.PHY.setVisibility(8);
                  localc.PHT.setVisibility(4);
                  localc.jBR.setMaxLines(2);
                  localc.jBR.setText(Util.getSizeKB(localb.iwI));
                  e.c.a(localc, str, localb.iwI);
                  e.c.a(localc, Boolean.TRUE, paramca, localb.dCK, localb.title);
                  if (!bool1) {
                    break label7482;
                  }
                  if (!e.b.bng(localb.iwJ)) {
                    break label2499;
                  }
                  localc.PHM.setImageResource(2131231098);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.PHN.setVisibility(8);
                }
                localc.PHM.setImageResource(com.tencent.mm.pluginsdk.model.r.bdt(localb.iwJ));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                continue;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.PHN.setVisibility(0);
                  localc.jBR.setVisibility(0);
                  localc.PHS.setVisibility(8);
                  localc.PHY.setVisibility(0);
                  localc.PHY.setImageResource(2131235406);
                  localc.PHT.setVisibility(4);
                  localc.jBR.setMaxLines(2);
                  if (!bool1) {
                    break label7482;
                  }
                  paramString = new com.tencent.mm.av.a.a.c.a();
                  paramString.ty(2131689587).bdq().dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bdo().bdt().aw(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                  localObject2 = com.tencent.mm.av.q.bcV();
                  if (!Util.isNullOrNil(localb.thumburl)) {
                    break label2747;
                  }
                }
                for (parama = localb.iwO;; parama = localb.thumburl)
                {
                  ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.PHM, paramString.bdv());
                  localc.PHY.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.PHN.setVisibility(8);
                  break label2555;
                }
                if (localb != null) {
                  e.a(paramString, parama1, paramca, localb);
                }
                parama = (com.tencent.mm.ag.e)localb.as(com.tencent.mm.ag.e.class);
                if ((parama != null) && (parama.iwe == 1) && (parama.iwc == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()))
                {
                  e.c.a(parama1, localc, localb, paramca, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                }
                else
                {
                  if ((j == 0) && (al.a(localb, parama)))
                  {
                    localc.PIR.setVisibility(0);
                    localc.PIW.setVisibility(0);
                    al.a(parama1.getContext(), localb, localc.PIT, localc.PIU);
                    al.b(localc.PIV, localb);
                  }
                  localc.PHN.setVisibility(8);
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.PHS.setMaxLines(2);
                    localc.PHS.setVisibility(0);
                    localc.PHS.setText(localb.getTitle());
                    localc.jBR.setMaxLines(3);
                    if (!e.n(localb)) {
                      break label3162;
                    }
                    localc.PHY.setVisibility(0);
                    localc.PHY.setImageResource(2131235406);
                    localc.PHT.setVisibility(4);
                    if (!bool1) {
                      break label7482;
                    }
                    paramString = new com.tencent.mm.av.a.a.c.a();
                    paramString.ty(2131689587).bdq().OT(com.tencent.mm.plugin.image.d.dZF()).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bdo().bdt().aw(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                    localObject2 = com.tencent.mm.av.q.bcV();
                    if (!Util.isNullOrNil(localb.thumburl)) {
                      break label3175;
                    }
                  }
                  for (parama = localb.iwO;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.PHM, paramString.bdv());
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    localc.PHS.setVisibility(8);
                    break label2965;
                    localc.PHY.setVisibility(8);
                    break label3002;
                  }
                  if (localc.PIh.getLayoutParams() != null)
                  {
                    localc.PIh.getLayoutParams().width = -2;
                    localc.PIh.requestLayout();
                  }
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localb.izi);
                  final boolean bool2;
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label3530;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.PIi.setVisibility(8);
                    localc.PIu.setVisibility(0);
                    localc.PIo.setVisibility(8);
                    localc.PIB.setVisibility(8);
                    if (!e.a(paramca, localb, parama1)) {
                      break label3540;
                    }
                    localc.PIY.setVisibility(0);
                    bool2 = Util.isNullOrNil(paramca.ajU());
                    localc.PIY.setTag(paramca);
                    localc.PIY.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(179950);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.bm(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                        e.a((ca)paramAnonymousView.getTag(), localc, parama1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(179950);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    localc.PIy.setText(localb.title);
                    e.h(localc.PIy, localb.title);
                    localc.PIs.setText(parama);
                    e.a(localc.PIt, localb);
                    com.tencent.mm.av.q.bcV().a(paramString, localc.PIr, ai.d.gvY);
                    parama = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                    localc.PIv.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PIv, "file://".concat(String.valueOf(parama)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(240, 192));
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label3553;
                    }
                    localc.lrd.setVisibility(0);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    parama = localb.eah;
                    break label3248;
                    paramString = localb.izB;
                    break label3260;
                    localc.PIY.setVisibility(8);
                  }
                  localc.lrd.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  continue;
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localb.izi);
                  ((w)com.tencent.mm.kernel.g.af(w.class)).VA(localb.izi);
                  switch (localb.izk)
                  {
                  default: 
                    localc.PHR.setVisibility(0);
                    localc.PHO.setVisibility(0);
                    localc.PHO.setBackground(null);
                    localc.PHO.setImageResource(2131689686);
                    e.a(localc.tln, localb);
                    break;
                  case 2: 
                  case 3: 
                    if (localc.PIh.getLayoutParams() != null)
                    {
                      localc.PIh.getLayoutParams().width = -2;
                      localc.PIh.requestLayout();
                    }
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4043;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.PIi.setVisibility(8);
                      localc.PIu.setVisibility(0);
                      localc.PIo.setVisibility(8);
                      localc.PIB.setVisibility(8);
                      localc.PIy.setText(localb.title);
                      e.h(localc.PIy, localb.title);
                      localc.PIs.setText(parama);
                      e.a(localc.PIt, localb);
                      com.tencent.mm.av.q.bcV().a(paramString, localc.PIr, ai.d.gvY);
                      parama = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                      localc.PIv.setImageBitmap(null);
                      localc.PIv.setVisibility(4);
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4053;
                      }
                      localc.lrd.setVisibility(0);
                      if (!e.a(paramca, localb, parama1)) {
                        break label4066;
                      }
                      localc.PIY.setVisibility(0);
                      bool2 = Util.isNullOrNil(paramca.ajU());
                      localc.PIY.setTag(paramca);
                      localc.PIY.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymousView)
                        {
                          AppMethodBeat.i(185027);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bm(paramAnonymousView);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                          e.a((ca)paramAnonymousView.getTag(), localc, parama1);
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(185027);
                        }
                      });
                      e.a(bool2, localc, parama1);
                    }
                    for (;;)
                    {
                      bool2 = e.o(localb);
                      com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
                      {
                        public final void I(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36779);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.PIv.setImageBitmap(paramAnonymousBitmap);
                            localc.PIv.setVisibility(0);
                            localc.PIx.setVisibility(4);
                            if (bool2)
                            {
                              localc.PIw.setImageDrawable(com.tencent.mm.cb.a.l(parama1.Pwc.getContext(), 2131691480));
                              localc.PIw.setVisibility(0);
                              AppMethodBeat.o(36779);
                              return;
                            }
                            localc.PIw.setVisibility(8);
                            AppMethodBeat.o(36779);
                            return;
                          }
                          localc.PIv.setVisibility(4);
                          localc.PIx.setVisibility(0);
                          localc.PIw.setVisibility(8);
                          AppMethodBeat.o(36779);
                        }
                        
                        public final String Lb()
                        {
                          AppMethodBeat.i(36781);
                          String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                          AppMethodBeat.o(36781);
                          return str;
                        }
                        
                        public final void aYg()
                        {
                          AppMethodBeat.i(36778);
                          AppMethodBeat.o(36778);
                        }
                        
                        public final void oD()
                        {
                          AppMethodBeat.i(36780);
                          AppMethodBeat.o(36780);
                        }
                      }, e.Lk(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(240, 192));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.eah;
                      break label3742;
                      paramString = localb.izB;
                      break label3754;
                      localc.lrd.setVisibility(8);
                      break label3903;
                      localc.PIY.setVisibility(8);
                    }
                  case 1: 
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4238;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.PIi.setVisibility(8);
                      localc.PIu.setVisibility(8);
                      localc.PIo.setVisibility(0);
                      localc.PIq.setText(parama);
                      localc.PIB.setVisibility(8);
                      if (!Util.isNullOrNil(paramString)) {
                        break label4244;
                      }
                      parama = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                      com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PIp, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                    }
                    for (;;)
                    {
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4267;
                      }
                      localc.PIA.setVisibility(0);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.title;
                      break label4090;
                      paramString = null;
                      break label4102;
                      com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PIp, paramString, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                    }
                    localc.PIA.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    continue;
                    parama = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
                    paramString = localb.izB;
                    localObject2 = localb.eah;
                    str = localb.title;
                    localObject3 = localb.description;
                    if ((parama == null) || (Util.isNullOrNil(parama.ivm)) || (Util.isNullOrNil(parama.ivo)))
                    {
                      Log.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                      break;
                    }
                    localc.PIH.setText((CharSequence)localObject2);
                    localc.PIi.setVisibility(8);
                    localc.PIu.setVisibility(8);
                    localc.PIo.setVisibility(8);
                    localc.PII.setVisibility(0);
                    localc.PIE.setVisibility(8);
                    localc.PII.setImageDrawable(com.tencent.mm.cb.a.l(parama1.getContext(), 2131691480));
                    localc.PIB.setVisibility(0);
                    localc.PIC.setText(str);
                    localc.PID.setText((CharSequence)localObject3);
                    com.tencent.mm.av.q.bcU().a(paramString, new r.a()
                    {
                      public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                      {
                        AppMethodBeat.i(36783);
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(36782);
                            if (!paramAnonymousBitmap.isRecycled()) {
                              e.d.7.this.PJe.PIG.setImageBitmap(paramAnonymousBitmap);
                            }
                            AppMethodBeat.o(36782);
                          }
                        });
                        AppMethodBeat.o(36783);
                      }
                    });
                    paramString = com.tencent.mm.modelappbrand.a.b.aXY().a(parama.ivo, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.iIr));
                    if (paramString != null)
                    {
                      localc.PIF.setImageBitmap(paramString);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                    }
                    else
                    {
                      com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
                      {
                        public final void I(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36785);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.PIF.setImageBitmap(paramAnonymousBitmap);
                            localc.PIF.setVisibility(0);
                          }
                          AppMethodBeat.o(36785);
                        }
                        
                        public final String Lb()
                        {
                          AppMethodBeat.i(36786);
                          String str = "CHAT#" + com.tencent.mm.plugin.appbrand.ac.n.cO(this);
                          AppMethodBeat.o(36786);
                          return str;
                        }
                        
                        public final void aYg()
                        {
                          AppMethodBeat.i(36784);
                          localc.PIF.setVisibility(4);
                          AppMethodBeat.o(36784);
                        }
                        
                        public final void oD()
                        {
                          AppMethodBeat.i(185028);
                          Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                          com.tencent.mm.plugin.report.service.h.CyF.dN(808, 2);
                          AppMethodBeat.o(185028);
                        }
                      }, parama.ivo, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.iIr));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      paramInt = 1;
                      localc.PHS.setMaxLines(2);
                      localc.jBR.setMaxLines(3);
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.PHN.setVisibility(8);
                      if ((localb.title != null) && (localb.title.trim().length() > 0))
                      {
                        localc.PHS.setMaxLines(2);
                        localc.PHS.setVisibility(0);
                        localc.PHS.setText(localb.getTitle());
                      }
                      for (;;)
                      {
                        localc.jBR.setMaxLines(3);
                        localc.PHY.setVisibility(8);
                        localc.PHT.setVisibility(4);
                        if (!bool1) {
                          break label7482;
                        }
                        parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label4795;
                        }
                        localc.PHM.setImageResource(2131689587);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        localc.PHS.setVisibility(8);
                      }
                      localc.PHM.setImageBitmap(parama);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.PHS.setVisibility(0);
                      if (localb.ixg == 1) {
                        localc.PHS.setText(2131764968);
                      }
                      for (;;)
                      {
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.PHN.setVisibility(0);
                          localc.PHN.aw(localb.getTitle());
                        }
                        localc.jBR.setMaxLines(4);
                        localc.PHT.setVisibility(4);
                        localc.PHY.setVisibility(8);
                        if (!bool1) {
                          break label7482;
                        }
                        parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                        if ((parama == null) || (parama.isRecycled())) {
                          break label5031;
                        }
                        localc.PHM.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        if (localb.ixg == 2) {
                          localc.PHS.setText(2131764970);
                        } else if (localb.ixg == 3) {
                          localc.PHS.setText(2131764969);
                        } else {
                          localc.PHS.setText(2131764971);
                        }
                      }
                      localc.PHM.setImageResource(2131689587);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.PHN.setVisibility(0);
                      localc.PHN.aw(localb.getTitle());
                      localc.PHS.setVisibility(0);
                      localc.PHS.setText(2131757460);
                      localc.jBR.setMaxLines(4);
                      localc.PHT.setVisibility(4);
                      localc.PHY.setVisibility(8);
                      if (!bool1) {
                        break label7482;
                      }
                      parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                      if ((parama != null) && (!parama.isRecycled()))
                      {
                        localc.PHM.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                      }
                      else
                      {
                        localc.PHM.setImageResource(2131689587);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.PHN.setVisibility(0);
                          localc.PHN.aw(localb.getTitle());
                          localc.PHS.setVisibility(8);
                        }
                        localc.jBR.setMaxLines(4);
                        localc.PHT.setVisibility(4);
                        localc.PHY.setVisibility(8);
                        if (!bool1) {
                          break label7482;
                        }
                        parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          localc.PHM.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                        }
                        else
                        {
                          localc.PHM.setImageResource(2131689587);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                          continue;
                          if ((localb.title != null) && (localb.title.length() > 0)) {
                            localc.PHN.setVisibility(0);
                          }
                          for (;;)
                          {
                            localc.jBR.setVisibility(0);
                            localc.PHS.setVisibility(8);
                            localc.PHY.setVisibility(8);
                            localc.PHT.setVisibility(4);
                            localc.jBR.setMaxLines(2);
                            if (!bool1) {
                              break label7482;
                            }
                            parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                            if ((parama != null) && (!parama.isRecycled())) {
                              break label5507;
                            }
                            localc.PHM.setImageResource(2131689587);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = k;
                            break;
                            localc.PHN.setVisibility(8);
                          }
                          localc.PHM.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                        }
                      }
                    }
                    break;
                  }
                }
              }
            case 15: 
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.PHN.setVisibility(0);
                localc.jBR.setVisibility(0);
                localc.PHS.setVisibility(8);
                localc.PHY.setVisibility(8);
                localc.PHT.setVisibility(4);
                localc.jBR.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5741;
                  }
                  localc.PHM.setImageResource(2131689587);
                }
              }
              for (;;)
              {
                parama = new bq(paramca, false, paramInt, "", false, localb.title, localb.eag, localb.eah, localb.title, localb.ixo, localb.url, false, false);
                localc.PIh.setTag(parama);
                localc.PIh.setOnClickListener(i(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.PHN.setVisibility(8);
                break label5556;
                localc.PHM.setImageBitmap(parama);
              }
            case 25: 
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.PHN.setVisibility(0);
                localc.jBR.setVisibility(0);
                localc.PHS.setVisibility(8);
                localc.PHY.setVisibility(8);
                localc.PHT.setVisibility(4);
                localc.jBR.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5971;
                  }
                  localc.PHM.setImageResource(2131689587);
                }
              }
              for (;;)
              {
                parama = new bq(paramca, paramInt, "", parama1.gOZ(), localb.eag, localb.eah, localb.title, localb.iyV, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.PIh.setTag(parama);
                localc.PIh.setOnClickListener(j(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.PHN.setVisibility(8);
                break label5781;
                localc.PHM.setImageBitmap(parama);
              }
            case 26: 
            case 27: 
              label2046:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.PHN.setVisibility(0);
                localc.jBR.setVisibility(0);
                localc.PHS.setVisibility(8);
                localc.PHY.setVisibility(8);
                localc.PHT.setVisibility(4);
                localc.jBR.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6282;
                  }
                  localc.PHM.setImageResource(2131689587);
                }
                parama = new bq();
                parama.dTX = paramca;
                parama.Pdm = false;
                parama.position = paramInt;
                parama.PQC = false;
                parama.title = parama1.gOZ();
                parama.eag = localb.eag;
                parama.eah = localb.eah;
                parama.Nwj = localb.title;
                if (localb.type != 26) {
                  break label6294;
                }
                parama.tid = localb.tid;
                parama.iyW = localb.iyW;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.PIh.setOnClickListener(k(parama1));
                paramInt = 1;
              }
              label2302:
              break;
            }
            for (;;)
            {
              label1423:
              label1523:
              label4090:
              localc.PIh.setTag(parama);
              label1584:
              label1722:
              label1739:
              label2143:
              label2288:
              j = 0;
              label1699:
              label1709:
              label1991:
              label3162:
              label3175:
              label5741:
              i = paramInt;
              label1923:
              label1934:
              label1961:
              label2499:
              label3530:
              label3540:
              label3553:
              label4066:
              paramInt = j;
              label2747:
              label3260:
              label3903:
              label4043:
              label4053:
              label6105:
              break;
              label2965:
              label3002:
              label4795:
              label5971:
              localc.PHN.setVisibility(8);
              label3248:
              label5556:
              break label6011;
              label3742:
              label3754:
              label4267:
              localc.PHM.setImageBitmap(parama);
              label4102:
              label4238:
              label4244:
              label5031:
              break label6105;
              label5507:
              label5781:
              label6294:
              if (localb.type == 27)
              {
                parama.tid = localb.tid;
                parama.iyW = localb.iyW;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.PIh.setOnClickListener(l(parama1));
                paramInt = 1;
                continue;
                localc.PHN.setVisibility(0);
                localc.PHN.aw(localb.description);
                localc.jBR.setText(localb.ixU);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.PHS.setVisibility(0);
                  localc.PHS.setText(localb.title);
                }
                for (;;)
                {
                  localc.jBR.setMaxLines(4);
                  localc.PHT.setVisibility(4);
                  localc.PHY.setVisibility(8);
                  if (!bool1) {
                    break label7482;
                  }
                  parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6543;
                  }
                  localc.PHM.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.PHS.setVisibility(8);
                }
                localc.PHM.setImageResource(2131689587);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                localc.PHN.setVisibility(8);
                localc.PHS.setVisibility(0);
                if ((localb.title != null) && (localb.title.trim().length() > 0)) {
                  localc.PHS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localc.PHS.getContext(), localb.title, localc.PHS.getTextSize()));
                }
                for (;;)
                {
                  localc.jBR.setMaxLines(3);
                  localc.PHY.setVisibility(8);
                  localc.PHT.setVisibility(4);
                  if (bool1)
                  {
                    localc.PHM.setVisibility(8);
                    localc.PIg.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, paramca, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.PHS.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localc.PHS.getContext(), MMApplicationContext.getContext().getString(2131759360), localc.PHS.getTextSize()));
                }
                e.c.a(parama1, localc, localb, bool1);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.PHN.setVisibility(0);
                  if (!Util.isNullOrNil(localb.iyd))
                  {
                    localc.PHN.setTextColor(Util.convertStringToRGB(localb.iyd, parama1.getContext().getResources().getColor(2131100904)));
                    label6845:
                    localc.jBR.setMaxLines(2);
                    localc.jBR.setVisibility(0);
                    if (Util.isNullOrNil(localb.iye)) {
                      break label7141;
                    }
                    localc.jBR.setTextColor(Util.convertStringToRGB(localb.iye, parama1.getContext().getResources().getColor(2131100571)));
                    label6903:
                    localc.PHS.setVisibility(8);
                    localc.PHT.setVisibility(4);
                    localc.PHY.setVisibility(8);
                    localc.PHR.setVisibility(0);
                    localc.tln.setVisibility(0);
                    if (Util.isNullOrNil(localb.ixZ)) {
                      break label7165;
                    }
                    localc.tln.setText(localb.ixZ);
                  }
                }
                for (;;)
                {
                  if (this.qoo)
                  {
                    parama = com.tencent.mm.av.q.bcR().d(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = BitmapUtil.getRoundedCornerBitmap(parama, false, parama.getWidth() / 2);
                      localc.PHM.setImageBitmap(paramString);
                    }
                    if (!Util.isNullOrNil(localb.iyc))
                    {
                      com.tencent.mm.av.q.bcV().a(localb.iyc, new ImageView(parama1.getContext()), new com.tencent.mm.av.a.a.c.a().bdp().bdv(), new com.tencent.mm.av.a.c.h()
                      {
                        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
                        {
                          return null;
                        }
                        
                        public final void b(String paramAnonymousString, View paramAnonymousView) {}
                        
                        public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
                        {
                          AppMethodBeat.i(36788);
                          if (paramAnonymousb.bitmap != null)
                          {
                            paramAnonymousString = paramAnonymousb.bitmap;
                            localc.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36787);
                                e.d.9.this.PJe.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.d.9.this.PJe.PIi.getHeight();
                                int k = e.d.9.this.PJe.PIi.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cb.a.aG(e.d.9.this.PHb.Pwc.getContext(), 2131166076);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cb.a.aG(e.d.9.this.PHb.Pwc.getContext(), 2131166077);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapUtil.createMaskImage(paramAnonymousString, 2131231617, j, i));
                                e.d.9.this.PJe.PIi.setBackgroundDrawable(localBitmapDrawable);
                                AppMethodBeat.o(36787);
                                return true;
                              }
                            });
                          }
                          AppMethodBeat.o(36788);
                        }
                      });
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      localc.PHN.setTextColor(parama1.getContext().getResources().getColor(2131100904));
                      break label6845;
                      localc.PHN.setVisibility(8);
                      break label6845;
                      label7141:
                      localc.jBR.setTextColor(parama1.getContext().getResources().getColor(2131100571));
                      break label6903;
                      label7165:
                      localc.tln.setText(2131757418);
                      continue;
                    }
                    localc.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean qCs = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36789);
                        if (this.qCs)
                        {
                          localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                        localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.qCs = true;
                        int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Pwc.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = BitmapUtil.createColorBitmap(parama1.Pwc.getContext().getResources().getColor(2131100161), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                          j = localc.PIi.getHeight();
                          int k = localc.PIi.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166076);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166077);
                          }
                          localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, 2131231617, j, i));
                          localc.PIi.setBackgroundDrawable((Drawable)localObject);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                      }
                    });
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                  }
                }
                localc.PHM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131234278));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if (((t)localObject3).iAl == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  label7276:
                  localc.PHS.setVisibility(8);
                  break label1423;
                  label7289:
                  localObject1 = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = com.tencent.mm.av.q.bcR().d(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.PHM.setImageBitmap(paramString);
                    break label1523;
                  }
                  if (!Util.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.av.a.a.c.a();
                    ((com.tencent.mm.av.a.a.c.a)localObject1).ty(2131100173).bdq().bdo();
                    com.tencent.mm.av.q.bcV().a(paramString, localc.PIL, ((com.tencent.mm.av.a.a.c.a)localObject1).bdv());
                    break label1523;
                  }
                  localc.PHM.setImageResource(2131231098);
                  break label1523;
                  label7450:
                  localc.PIb.setVisibility(8);
                  localObject2 = parama;
                  break label1584;
                  label7466:
                  localc.PIb.setVisibility(8);
                  localObject2 = parama;
                  break label1584;
                }
                label7482:
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
              }
              label6282:
              label6543:
              paramInt = 0;
            }
          }
          label7506:
          i = 1;
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36797);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36797);
        return false;
      case 100: 
        AppMethodBeat.o(36797);
        return false;
      case 111: 
        if (!com.tencent.mm.ui.chatting.ac.bB(paramca))
        {
          com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131759141), "", parama.Pwc.getContext().getString(2131768713), null);
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = br.N(paramca);
        if (Util.isNullOrNil(paramMenuItem)) {
          e.b.a(parama, paramca, a(parama, paramca));
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36790);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(36790);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36772);
              e.b.a(parama, paramca, e.d.this.a(parama, paramca));
              com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(36772);
            }
          });
        }
      case 114: 
        paramMenuItem = paramca.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = k.b.HD(paramMenuItem);
        if (paramMenuItem != null) {
          switch (e.m(paramMenuItem))
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          com.tencent.mm.ui.chatting.an.a(paramca, bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.d(paramca, parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.b(paramca, bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.a(paramca, parama.Pwc.getContext(), a(parama, paramca), parama.gRM());
          continue;
          com.tencent.mm.ui.chatting.an.m(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.c(paramca, bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.c(paramca, parama.Pwc.getContext());
        }
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36797);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233600);
      int i = ((bq)paramView.getTag()).position;
      int j = com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
      k.b localb = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.bm(paramca)))
      {
        if (localb.type != 6) {
          break label626;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.m.bdJ(localb.dCK);
        if (((localc == null) || (!e.b.h(paramca, localc.field_fileFullPath))) && (!paramca.gDB())) {
          paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
        }
      }
      boolean bool1;
      if ((localb.iwI <= 0) || ((localb.iwI > 0) && (j >= 100))) {
        switch (e.m(localb))
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        label275:
        if ((bool1) && (!this.PhN.gRN())) {
          paramm.add(i, 114, 0, paramView.getContext().getString(2131757429));
        }
        if ((com.tencent.mm.br.c.aZU("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).NA()))) {
          switch (e.m(localb))
          {
          }
        }
        for (;;)
        {
          localObject = new ef();
          ((ef)localObject).dHy.msgId = paramca.field_msgId;
          EventCenter.instance.publish((IEvent)localObject);
          if ((((ef)localObject).dHz.dGX) || (e.b.a(this.PhN.Pwc.getContext(), localb))) {
            paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
          }
          if (br.B(paramca)) {
            paramm.clear();
          }
          if (!this.PhN.gRN()) {
            paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
          }
          if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
            paramm.a(i, 144, paramView.getContext().getString(2131763040), 2131690297);
          }
          AppMethodBeat.o(233600);
          return true;
          label626:
          paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
          break;
          bool1 = com.tencent.mm.al.g.aZR();
          break label275;
          bool1 = com.tencent.mm.al.g.aZL();
          break label275;
          boolean bool2 = com.tencent.mm.al.g.aZP();
          bool1 = bool2;
          if (Util.isImageExt(localb.iwJ)) {
            break label275;
          }
          paramm.a(i, 150, this.PhN.Pwc.getMMResources().getString(2131757441), 2131690629);
          bool1 = bool2;
          break label275;
          bool1 = com.tencent.mm.al.g.aZI();
          break label275;
          bool1 = com.tencent.mm.al.g.aZH();
          break label275;
          bool1 = com.tencent.mm.al.g.aZN();
          break label275;
          bool1 = com.tencent.mm.al.g.aZJ();
          break label275;
          if ((localb.ixV != 5) && (localb.ixV != 6) && (localb.ixV != 2)) {
            break label910;
          }
          if ((localb.ixV != 2) || (br.B(paramca))) {
            paramm.clear();
          }
          paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
          AppMethodBeat.o(233600);
          return false;
          paramm.clear();
          paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
          AppMethodBeat.o(233600);
          return false;
          paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
        }
        label910:
        bool1 = false;
      }
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean c(View paramView, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36798);
      com.tencent.mm.modelstat.a.a(paramca, a.a.jma);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      Object localObject1 = paramca.field_content;
      paramView = Boolean.FALSE;
      if (localObject1 == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      final k.b localb = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
      localObject1 = t.HI((String)localObject1);
      if (localb == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      if (((t)localObject1).iAl != 0)
      {
        paramView = Boolean.TRUE;
        localb.type = ((t)localObject1).iAl;
      }
      Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
      localObject1 = d(parama, paramca);
      if (localObject2 != null) {
        a(parama, localb, (String)localObject1, (com.tencent.mm.pluginsdk.model.app.g)localObject2, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (e.m(localb))
      {
      }
      do
      {
        for (;;)
        {
          i = 1;
          do
          {
            while ((i != 0) && (e(localb, parama, this, paramca)))
            {
              AppMethodBeat.o(36798);
              return true;
              if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(parama.Pwc.getContext()))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(13043, new Object[] { Integer.valueOf(2), localb.description, localb.appId });
              c(parama, paramca);
              boolean bool = a(localb, parama, this, paramca);
              AppMethodBeat.o(36798);
              return bool;
              if (!this.qoo)
              {
                u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
                AppMethodBeat.o(36798);
                return true;
              }
              paramView = new Intent();
              paramView.setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramView.putExtra("scene", 2);
              paramView.putExtra("app_msg_id", paramca.field_msgId);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36798);
              return true;
              if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).NA()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject2)))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if ((localb.dCK == null) || (localb.dCK.length() == 0)) {
                ((com.tencent.mm.ui.chatting.d.b.b)parama.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a(paramca, new com.tencent.mm.pluginsdk.model.app.al()
                {
                  public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                  {
                    AppMethodBeat.i(233599);
                    if (this.peF != null)
                    {
                      if (paramAnonymousBoolean1)
                      {
                        e.d.a(parama, localb, this.Ped, this.peF, paramca.field_msgSvrId, 3, parama.getTalkerUserName());
                        AppMethodBeat.o(233599);
                        return;
                      }
                      e.d.a(parama, localb, this.Ped, this.peF, paramca.field_msgSvrId, 7, parama.getTalkerUserName());
                    }
                    AppMethodBeat.o(233599);
                  }
                });
              }
              for (;;)
              {
                AppMethodBeat.o(36798);
                return true;
                if (!this.qoo)
                {
                  u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
                  AppMethodBeat.o(36798);
                  return true;
                }
                paramView = new Intent();
                paramView.setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                paramView.putExtra("app_msg_id", paramca.field_msgId);
                paramView.putExtra("scene", 2);
                parama.Pwc.startActivityForResult(paramView, 210);
              }
              if (Util.isNullOrNil(localb.ixh))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_Product_xml", localb.ixh);
              paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
              if (paramca.field_imgPath == null) {
                paramView.putExtra("key_ProductUI_chatting_msgId", paramca.field_msgId);
              }
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "scanner", ".ui.ProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (Util.isNullOrNil(localb.ixk))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_TV_xml", localb.ixk);
              paramView.putExtra("key_TV_getProductInfoScene", 1);
              if (paramca.field_imgPath == null) {
                paramView.putExtra("key_TVInfoUI_chatting_msgId", paramca.field_msgId);
              }
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "shake", ".ui.TVInfoUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (Util.isNullOrNil(localb.ixn))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_product_info", localb.ixn);
              paramView.putExtra("key_product_scene", 1);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "product", ".ui.MallProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("message_id", paramca.field_msgId);
              ((Intent)localObject2).putExtra("record_xml", localb.ixl);
              ((Intent)localObject2).putExtra("big_appmsg", paramView);
              i = com.tencent.mm.model.ac.aJ(a(parama, paramca), parama.getTalkerUserName());
              ((Intent)localObject2).putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
              ((Intent)localObject2).putExtra("preUsername", a(parama, paramca));
              ((Intent)localObject2).putExtra("preChatName", parama.getTalkerUserName());
              ((Intent)localObject2).putExtra("preChatTYPE", i);
              ((Intent)localObject2).putExtra("msgUsername", (String)localObject1);
              ((Intent)localObject2).putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
              e.a.a((Intent)localObject2, parama, paramca, this);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject2);
              AppMethodBeat.o(36798);
              return true;
              if (Util.isNullOrNil(localb.dPu))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_card_app_msg", localb.dPu);
              paramView.putExtra("key_from_scene", localb.ixV);
              com.tencent.mm.br.c.b(parama.Pwc.getContext(), "card", ".ui.CardDetailUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.Pwc.getContext()))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if (d(localb, parama, this, paramca))
              {
                c(parama, paramca);
                AppMethodBeat.o(36798);
                return true;
              }
              i = 1;
            }
          } while (c(localb, parama, this, paramca));
        }
        b(localb, parama, this, paramca);
        c(parama, paramca);
        AppMethodBeat.o(36798);
        return true;
        e.a(localb, parama, paramca);
        AppMethodBeat.o(36798);
        return true;
        paramView = new Intent();
        paramView.putExtra("key_from_user_name", a(parama, paramca));
        paramView.putExtra("key_biz_uin", localb.ixX);
        paramView.putExtra("key_order_id", localb.ixY);
        if ((paramca.field_talker != null) && (!paramca.field_talker.equals("")) && (ab.Eq(paramca.field_talker))) {
          paramView.putExtra("key_chatroom_name", paramca.field_talker);
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
        AppMethodBeat.o(36798);
        return true;
      } while (!e.a(localb, parama));
      AppMethodBeat.o(36798);
      return true;
      AppMethodBeat.o(36798);
      return false;
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class e
    extends c
    implements t.n
  {
    protected t.i PJg;
    protected t.l PJh;
    protected t.j PJi;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
    private static void a(e.c paramc, com.tencent.mm.ui.chatting.d.b.k paramk, ca paramca)
    {
      AppMethodBeat.i(36827);
      if ((paramca.field_status == 2) && (b(paramk, paramca.field_msgId)))
      {
        if (paramc.PIn != null)
        {
          paramc.PIn.setVisibility(0);
          AppMethodBeat.o(36827);
        }
      }
      else if (paramc.PIn != null) {
        paramc.PIn.setVisibility(8);
      }
      AppMethodBeat.o(36827);
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(161906);
      if ((Util.isNullOrNil(paramb.izj)) && (Util.isNullOrNil(paramb.izi)))
      {
        paramca = paramb.url;
        if (parama.gRM()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.R(paramca, paramc);
          paramca = new Intent();
          paramca.putExtra("rawUrl", paramc);
          paramca.putExtra("webpageTitle", paramb.title);
          paramca.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
          AppMethodBeat.o(161906);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.gRM()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.h.R(paramca));
        ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(parama.Pwc.getContext(), parama.getTalkerUserName(), paramc.a(parama, paramca), parama.gRM(), paramb, localBundle);
        AppMethodBeat.o(161906);
        return true;
        if (ab.IT(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean f(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36831);
      if (paramc.a(parama, paramb, paramca))
      {
        AppMethodBeat.o(36831);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.R(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.R(paramb.iwH, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.Pwc.getContext(), paramb.appId);
      String str1;
      if (localPackageInfo == null)
      {
        str1 = null;
        if (localPackageInfo != null) {
          break label120;
        }
      }
      label120:
      for (int i = 0;; i = localPackageInfo.versionCode)
      {
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, paramca.field_msgId, paramca.field_msgSvrId, paramca);
        AppMethodBeat.o(36831);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean g(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36832);
      Log.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.izi, paramb.izh, paramb.izj, paramb.url, Integer.valueOf(paramb.izz), paramb.izl });
      if ((44 == paramb.type) && ((!paramb.fn(false)) || (Util.isNullOrNil(paramb.w(parama.Pwc.getContext(), false)))))
      {
        AppMethodBeat.o(36832);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      if ((parama.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.h.R(paramca));
        switch (paramb.izk)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cL(paramca);
        if (i != 0) {
          break label577;
        }
        AppMethodBeat.o(36832);
        return true;
        if (parama.gRM())
        {
          i = 2;
          break;
        }
        if (ab.IT((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramc = new Intent();
        paramc.putExtra("key_username", paramb.izi);
        if (parama.gRM())
        {
          paramc.putExtra("key_from_scene", 1);
          paramc.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + str);
        }
        for (;;)
        {
          paramc.putExtra("_stat_obj", localBundle);
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.izj;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).kNW = paramb.izz;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.izm;
          paramc.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bAv());
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramc);
          i = 0;
          break;
          paramc.putExtra("key_from_scene", 2);
          paramc.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, localBundle);
          i = 0;
        }
        else if (ab.IT((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, localBundle);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.gRM(), paramb, localBundle);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.gRM(), paramb, localBundle);
          i = 0;
        }
      }
      label577:
      AppMethodBeat.o(36832);
      return false;
    }
    
    public static boolean h(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36833);
      Object localObject2 = (com.tencent.mm.ag.a)paramb.as(com.tencent.mm.ag.a.class);
      if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.ag.a)localObject2).ivm)) && (!Util.isNullOrNil(((com.tencent.mm.ag.a)localObject2).ivo)))
      {
        String str2 = ((com.tencent.mm.ag.a)localObject2).ivm;
        String str3 = ((com.tencent.mm.ag.a)localObject2).ivl;
        Object localObject1 = ((com.tencent.mm.ag.a)localObject2).ebj;
        String str1;
        int i;
        if (Util.isNullOrNil(((com.tencent.mm.ag.a)localObject2).ivp))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ag.a)localObject2).ivn;
          String str5 = paramb.izj;
          localObject2 = ((com.tencent.mm.ag.a)localObject2).ivo;
          Log.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { str2, str3, str1, str4, str5, localObject2 });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
          if (!ab.Eq(parama.getTalkerUserName())) {
            break label364;
          }
          i = 2;
          label165:
          localh.a(17608, new Object[] { Integer.valueOf(i), str5, Integer.valueOf(1), Integer.valueOf(1) });
          if ((Util.isNullOrNil(str2)) && ((Util.isNullOrNil(str3)) || (!com.tencent.mm.vfs.s.YS(str3)) || (!Util.nullAsNil(com.tencent.mm.vfs.s.bhK(str3)).equals(localObject1)))) {
            break label370;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_chatting_type", paramb.type);
          ((Bundle)localObject1).putString("key_chatting_wording", str1);
          ((Bundle)localObject1).putString("key_chatting_text", str4);
          ((Bundle)localObject1).putString("key_chatting_appid", str5);
          ((Bundle)localObject1).putLong("key_msg_id", paramca.field_msgId);
          ((Bundle)localObject1).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject1).putString("key_sender_username", paramc.a(parama, paramca));
          e.a(parama, str2, str3, (String)localObject2, (Bundle)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(36833);
          return false;
          str1 = ((com.tencent.mm.ag.a)localObject2).ivp;
          break;
          label364:
          i = 1;
          break label165;
          label370:
          Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
        }
      }
      Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
      u.makeText(parama.Pwc.getContext(), parama.Pwc.getMMResources().getString(2131755978), 0).show();
      AppMethodBeat.o(36833);
      return true;
    }
    
    public static boolean i(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      int j = 0;
      AppMethodBeat.i(36834);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!Util.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", paramca.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", paramca.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject1 = (aj)paramb.as(aj.class);
        if ((localObject1 != null) && (!Util.isNullOrNil(((aj)localObject1).IEy)))
        {
          paramb = new fat();
          paramb.IEy = ((aj)localObject1).IEy;
          paramb.IEz = ((aj)localObject1).IEz;
          paramb.IEA = ((aj)localObject1).IEA;
          paramb.IEB = ((aj)localObject1).IEB;
          paramb.IEC = ((aj)localObject1).IEC;
          paramb.IEG = ((aj)localObject1).IEG;
          paramb.rCq = ((aj)localObject1).rCq;
          paramb.msN = ((aj)localObject1).msN;
          paramb.xDQ = ((aj)localObject1).xDQ;
          paramb.IED = ((aj)localObject1).IED;
          paramb.IEE = ((aj)localObject1).IEE;
          paramb.IEF = ((aj)localObject1).IEF;
          paramb.source = ((aj)localObject1).source;
          paramb.eby = ((aj)localObject1).eby;
          paramb.IEH = ((aj)localObject1).IEH;
          paramb.IEJ = ((aj)localObject1).IEJ;
          paramb.IEK = ((aj)localObject1).IEK;
          paramb.IEL = ((aj)localObject1).IEL;
          paramb.IEI = ((aj)localObject1).IEI;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.Pwc.getContext().getString(2131761038));
          ai.a(parama.Pwc.getContext(), paramc);
          com.tencent.mm.plugin.topstory.a.i.a(paramb, paramca);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject2 = paramb.url;
        Intent localIntent;
        label551:
        label559:
        int i;
        if (parama.gRM())
        {
          localObject1 = "groupmessage";
          Object localObject3 = com.tencent.mm.pluginsdk.model.app.q.R((String)localObject2, (String)localObject1);
          localObject1 = paramb.url;
          localObject2 = c.getPackageInfo(parama.Pwc.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("webpageTitle", paramb.title);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId))))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("jsapi_args_appid", paramb.appId);
            localIntent.putExtra("jsapiargs", (Bundle)localObject3);
          }
          if (Util.isNullOrNil((String)localObject1)) {
            break label1006;
          }
          localIntent.putExtra("shortUrl", (String)localObject1);
          if (localObject2 != null) {
            break label1021;
          }
          localObject1 = null;
          localIntent.putExtra("version_name", (String)localObject1);
          if (localObject2 != null) {
            break label1031;
          }
          i = 0;
          label578:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.eag))
          {
            localIntent.putExtra("srcUsername", paramb.eag);
            localIntent.putExtra("srcDisplayname", paramb.eah);
          }
          localIntent.putExtra("msg_id", paramca.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramca));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", paramca.fRa);
          int k = com.tencent.mm.model.ac.aJ(paramc.a(parama, paramca), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.a(parama, paramca));
          localIntent.putExtra("preChatName", parama.getTalkerUserName());
          localIntent.putExtra("preChatTYPE", k);
          localIntent.putExtra("preMsgIndex", 0);
          i = j;
          switch (k)
          {
          default: 
            i = j;
          }
        }
        for (;;)
        {
          localIntent.putExtra("share_report_pre_msg_url", paramb.url);
          localIntent.putExtra("share_report_pre_msg_title", paramb.title);
          localIntent.putExtra("share_report_pre_msg_desc", paramb.description);
          localIntent.putExtra("share_report_pre_msg_icon_url", paramb.thumburl);
          localIntent.putExtra("share_report_pre_msg_appid", paramb.appId);
          localIntent.putExtra("share_report_from_scene", i);
          if (i == 5) {
            localIntent.putExtra("share_report_biz_username", parama.getTalkerUserName());
          }
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(36834);
          return true;
          localObject1 = "singlemessage";
          break;
          label1006:
          localIntent.putExtra("shortUrl", paramb.url);
          break label551;
          label1021:
          localObject1 = ((PackageInfo)localObject2).versionName;
          break label559;
          label1031:
          i = ((PackageInfo)localObject2).versionCode;
          break label578;
          i = 2;
          continue;
          i = 3;
          continue;
          i = 5;
        }
      }
      AppMethodBeat.o(36834);
      return false;
    }
    
    private t.i j(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36822);
      if (this.PJg == null) {
        this.PJg = new t.i(parama);
      }
      parama = this.PJg;
      AppMethodBeat.o(36822);
      return parama;
    }
    
    public static boolean j(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(169873);
      if (!Util.isNullOrNil(paramb.canvasPageXml))
      {
        paramc = new Intent();
        paramc.putExtra("sns_landig_pages_from_source", 5);
        paramc.putExtra("msg_id", paramca.field_msgId);
        paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
        paramc.putExtra("sns_landing_pages_share_thumb_url", paramca.field_imgPath);
        paramb = com.tencent.mm.plugin.sns.data.k.ka(parama.PkU, paramca.field_talker);
        if (!TextUtils.isEmpty(paramb)) {
          paramc.putExtra("sns_landing_pages_extra", paramb);
        }
        paramc.addFlags(268435456);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
        AppMethodBeat.o(169873);
        return true;
      }
      aj localaj = (aj)paramb.as(aj.class);
      if ((localaj != null) && (!Util.isNullOrNil(localaj.IEy)))
      {
        paramb = new fat();
        paramb.IEy = localaj.IEy;
        paramb.IEz = localaj.IEz;
        paramb.IEA = localaj.IEA;
        paramb.IEB = localaj.IEB;
        paramb.IEC = localaj.IEC;
        paramb.IEG = localaj.IEG;
        paramb.rCq = localaj.rCq;
        paramb.msN = localaj.msN;
        paramb.xDQ = localaj.xDQ;
        paramb.IED = localaj.IED;
        paramb.IEE = localaj.IEE;
        paramb.IEF = localaj.IEF;
        paramb.source = localaj.source;
        paramb.eby = localaj.eby;
        paramb.IEH = localaj.IEH;
        paramb.IEJ = localaj.IEJ;
        paramb.IEK = localaj.IEK;
        paramb.IEL = localaj.IEL;
        paramb.IEI = localaj.IEI;
        paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.Pwc.getContext().getString(2131761038));
        ai.a(parama.Pwc.getContext(), paramc);
        com.tencent.mm.plugin.topstory.a.i.a(paramb, paramca);
        AppMethodBeat.o(169873);
        return true;
      }
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        Object localObject2 = paramb.url;
        Object localObject1;
        int j;
        PackageInfo localPackageInfo;
        Intent localIntent;
        if (parama.gRM())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.R((String)localObject2, (String)localObject1);
          String str = paramb.iwH;
          j = parama.Pwc.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 1, j, i);
          }
          localPackageInfo = c.getPackageInfo(parama.Pwc.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          localIntent.putExtra("msgUsername", parama.PkU);
          localIntent.putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_snsad_statextstr", paramb.ean);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId)))) {
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
          }
          localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          if (Util.isNullOrNil(str)) {
            break label1335;
          }
          localIntent.putExtra("shortUrl", str);
          label694:
          if (localPackageInfo != null) {
            break label1350;
          }
          localObject2 = null;
          label702:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1360;
          }
          i = 0;
          label721:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.eag))
          {
            localIntent.putExtra("srcUsername", paramb.eag);
            localIntent.putExtra("srcDisplayname", paramb.eah);
          }
          localIntent.putExtra("msg_id", paramca.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramca));
          localIntent.putExtra("from_scence", 2);
          i = com.tencent.mm.model.ac.aJ(paramc.a(parama, paramca), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.a(parama, paramca));
          localIntent.putExtra("preChatName", parama.getTalkerUserName());
          localIntent.putExtra("preChatTYPE", i);
          localIntent.putExtra("preMsgIndex", 0);
          switch (i)
          {
          case 3: 
          case 4: 
          case 5: 
          default: 
            i = 0;
            label1007:
            localIntent.putExtra("share_report_pre_msg_url", paramb.url);
            localIntent.putExtra("share_report_pre_msg_title", paramb.title);
            localIntent.putExtra("share_report_pre_msg_desc", paramb.description);
            localIntent.putExtra("share_report_pre_msg_icon_url", paramb.thumburl);
            localIntent.putExtra("share_report_pre_msg_appid", paramb.appId);
            localIntent.putExtra("geta8key_scene", 1);
            localIntent.putExtra("share_report_from_scene", i);
            if (i == 5) {
              localIntent.putExtra("share_report_biz_username", parama.getTalkerUserName());
            }
            paramc = (com.tencent.mm.ag.e)paramb.as(com.tencent.mm.ag.e.class);
            if (paramc == null) {
              break;
            }
          }
        }
        for (int i = paramc.iwc;; i = -1)
        {
          localIntent.putExtra(e.p.OzA, i);
          localIntent.putExtra("key_enable_teen_mode_check", true);
          localIntent.putExtra("msgUsername", parama.PkU);
          localIntent.putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
          if ((paramc == null) || (i != 5) || (paramc.iwe != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld())) {
            break label1394;
          }
          paramc = new Bundle();
          paramc.putInt(com.tencent.mm.ui.e.b.OyQ, 1);
          paramc.putInt(com.tencent.mm.ui.e.b.OyR, j);
          paramc.putInt("geta8key_scene", 1);
          paramc.putString("geta8key_username", parama.getTalkerUserName());
          paramc.putString("webpageTitle", paramb.title);
          if ((localaj != null) && (!Util.isNullOrNil(localaj.IEy)))
          {
            paramb = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(localaj.IEy);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.Pwc.getContext(), paramca.field_msgId, paramca.field_msgSvrId, 0, paramc);
          AppMethodBeat.o(169873);
          return true;
          localObject1 = "singlemessage";
          break;
          label1335:
          localIntent.putExtra("shortUrl", paramb.url);
          break label694;
          label1350:
          localObject2 = localPackageInfo.versionName;
          break label702;
          label1360:
          i = localPackageInfo.versionCode;
          break label721;
          i = 2;
          break label1007;
          i = 3;
          break label1007;
          i = 5;
          break label1007;
        }
        label1394:
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.Pwc.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          Log.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          AppMethodBeat.o(169873);
          return true;
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(169873);
      return true;
    }
    
    private t.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36823);
      if (this.PJh == null) {
        this.PJh = new t.l(parama);
      }
      parama = this.PJh;
      AppMethodBeat.o(36823);
      return parama;
    }
    
    private t.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36824);
      if (this.PJi == null) {
        this.PJi = new t.j(parama);
      }
      parama = this.PJi;
      AppMethodBeat.o(36824);
      return parama;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(36825);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new an(paramLayoutInflater, 2131493578);
        ((View)localObject).setTag(new e.c().F((View)localObject, false));
      }
      AppMethodBeat.o(36825);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36826);
      final e.c localc = (e.c)parama;
      this.PhN = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
      localc.reset();
      String str = paramca.getContent();
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bX(paramca);
      k.b localb;
      Object localObject2;
      if (str != null)
      {
        localb = k.b.aD(str, paramca.ajQ());
        localObject2 = t.HI(str);
      }
      label679:
      label1194:
      label2348:
      label5807:
      for (;;)
      {
        Object localObject1 = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
        int j = 0;
        int k = 0;
        localc.PIY.setVisibility(8);
        Object localObject3 = localObject1;
        Object localObject4;
        boolean bool1;
        label604:
        int i;
        if (localb != null)
        {
          localObject4 = com.tencent.mm.pluginsdk.model.app.h.gE(localb.appId, localb.appVersion);
          localc.PHN.aw(localb.title);
          localc.jBR.setText(localb.description);
          localc.PHS.setMaxLines(1);
          localc.PHN.setTextColor(parama1.getContext().getResources().getColor(2131099746));
          localc.jBR.setTextColor(parama1.getContext().getResources().getColor(2131100584));
          localc.PIi.setBackgroundResource(2131231798);
          localc.PIi.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165518), 0, 0);
          localc.PHM.setVisibility(0);
          localc.PIg.setVisibility(0);
          localc.jBR.setVisibility(0);
          localc.PIk.setVisibility(8);
          localc.PIl.setVisibility(8);
          localc.PHX.setVisibility(8);
          localc.PHW.setVisibility(8);
          localc.PHT.setVisibility(8);
          localc.PHQ.setVisibility(8);
          localc.PHP.setVisibility(8);
          localc.PIu.setVisibility(8);
          localc.PIo.setVisibility(8);
          localc.PIi.setVisibility(0);
          localc.PIB.setVisibility(8);
          localc.PIJ.setVisibility(8);
          localc.PIR.setVisibility(8);
          localc.PIW.setVisibility(8);
          localc.resetChatBubbleWidth(localc.PIh, localc.PJa);
          if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName.trim().length() > 0)) {
            break label1467;
          }
          localObject3 = localb.appName;
          bool1 = true;
          com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 12);
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool1 = o.a.glW().eUk();
          }
          if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!gp((String)localObject3))) {
            break label1507;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject4, (String)localObject3);
          if (localb.type != 19) {
            break label1477;
          }
          localc.tln.setText(parama1.getContext().getResources().getString(2131763802, new Object[] { localObject3 }));
          localc.PHR.setVisibility(0);
          localc.tln.setVisibility(0);
          localc.tln.setCompoundDrawables(null, null, null, null);
          localc.PHO.setVisibility(0);
          if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject4).NA())) {
            break label1490;
          }
          a(parama1, localc.tln, paramca, localb, ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_packageName, paramca.ajM());
          localc.PHO.setImageResource(2131231768);
          a(parama1, localc.PHO, localb.appId);
          i = 1;
        }
        label1467:
        label1729:
        label6337:
        for (;;)
        {
          label707:
          localc.PHR.setBackgroundResource(2131233974);
          bool1 = false;
          localc.PHM.setVisibility(0);
          if (this.qoo)
          {
            localObject4 = null;
            localObject3 = localObject4;
            if (localb.type != 33)
            {
              localObject3 = localObject4;
              if (localb.type != 36)
              {
                localObject3 = localObject4;
                if (localb.type != 44)
                {
                  localObject3 = localObject4;
                  if (localb.type != 48)
                  {
                    localObject3 = localObject4;
                    if (!e.b.bnh(paramca.ajP())) {
                      localObject3 = com.tencent.mm.av.q.bcR().d(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    }
                  }
                }
              }
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              localObject4 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject3, false, com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 1));
              localc.PHM.setImageBitmap((Bitmap)localObject4);
              label871:
              if (e.m(localb) != 3) {
                break label1702;
              }
              localc.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                private boolean qCs = false;
                
                public final boolean onPreDraw()
                {
                  AppMethodBeat.i(36803);
                  if (this.qCs)
                  {
                    localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                  localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                  this.qCs = true;
                  int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Pwc.getContext(), 24);
                  Bitmap localBitmap = this.val$bitmap;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = BitmapUtil.createColorBitmap(parama1.Pwc.getContext().getResources().getColor(2131100161), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                    j = localc.PIi.getHeight();
                    int k = localc.PIi.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166076);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166077);
                    }
                    localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, 2131231653, j, i));
                    localc.PIi.setBackgroundDrawable((Drawable)localObject);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                }
              });
              if (!com.tencent.mm.ui.ao.isDarkMode()) {
                break label1691;
              }
              localc.PHR.setBackgroundResource(2131233974);
              localc.PHY.setOnClickListener(null);
              j = e.m(localb);
              if (localb.type == 66)
              {
                if ((TextUtils.isEmpty(localb.izi)) && (TextUtils.isEmpty(localb.izj))) {
                  break label1729;
                }
                j = 33;
              }
            }
          }
          label973:
          label1249:
          label1507:
          label1784:
          final boolean bool2;
          switch (j)
          {
          case 1: 
          case 2: 
          case 8: 
          case 9: 
          case 11: 
          case 12: 
          case 14: 
          case 17: 
          case 18: 
          case 21: 
          case 22: 
          case 23: 
          case 28: 
          case 29: 
          case 30: 
          case 31: 
          case 32: 
          case 35: 
          case 37: 
          case 38: 
          case 39: 
          case 41: 
          case 42: 
          case 43: 
          case 45: 
          case 46: 
          case 47: 
          default: 
            i = 1;
            parama = (c.a)localObject1;
            j = k;
          case 3: 
          case 6: 
            for (;;)
            {
              if (i != 0)
              {
                if ((localb.title == null) || (localb.title.length() <= 0)) {
                  break label7562;
                }
                localc.PHS.setVisibility(0);
                localc.PHS.setMaxLines(2);
                localc.PHS.setText(localb.title);
                localc.PHN.setVisibility(8);
                if (bool1)
                {
                  if ((localb.type != 33) && (localb.type != 36)) {
                    break label7575;
                  }
                  paramString = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                  localc.PHM.setImageResource(2131689587);
                  com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PHM, "file://".concat(String.valueOf(paramString)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(52, 52));
                }
                if (localb.type == 44) {
                  e.c.a(parama1, localc, localb);
                }
              }
              localObject3 = parama;
              if (j == 0)
              {
                localc.PIh.setTag(localObject3);
                localc.PIh.setOnClickListener(d(parama1));
              }
              if (this.qoo)
              {
                localc.PIh.setOnLongClickListener(c(parama1));
                localc.PIh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
              }
              a(paramInt, localc, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
              AppMethodBeat.o(36826);
              return;
              localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              localc.tln.setText((CharSequence)localObject3);
              break label604;
              a(parama1, localc.tln, localb.appId);
              break label679;
              if (localb.type == 24)
              {
                localc.tln.setText(MMApplicationContext.getContext().getString(2131759168));
                localc.PHR.setVisibility(0);
                localc.tln.setVisibility(0);
                localc.PHO.setVisibility(8);
                i = 1;
                break label707;
              }
              if ((localb.type == 19) || (((t)localObject2).iAl == 19))
              {
                localc.tln.setText(MMApplicationContext.getContext().getString(2131757420));
                localc.PHR.setVisibility(0);
                localc.tln.setVisibility(0);
                localc.PHO.setVisibility(8);
                i = 1;
                break label707;
              }
              if (e.a(localb, localc)) {
                break label7762;
              }
              localc.PHR.setVisibility(8);
              localc.tln.setVisibility(8);
              localc.PHO.setVisibility(8);
              i = 0;
              break label707;
              bool1 = true;
              break label871;
              localc.PHR.setBackgroundResource(2131231749);
              break label921;
              localc.PHM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131234278));
              bool1 = false;
              break label921;
              j = 5;
              break label973;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.PHN.setVisibility(0);
                localc.PHN.setTextColor(parama1.getContext().getResources().getColor(2131101427));
                localc.jBR.setVisibility(0);
                localc.jBR.setTextColor(parama1.getContext().getResources().getColor(2131101427));
                localc.PHS.setVisibility(8);
                localc.PHT.setVisibility(4);
                localc.jBR.setMaxLines(2);
                localc.PHY.setVisibility(0);
                if (!paramca.ajL().equals(parama.playingMsgId)) {
                  break label2040;
                }
                localc.PHY.setImageResource(2131234170);
                parama = new e.g();
                parama.msgId = paramca.ajL();
                parama.xml = paramca.getContent();
                parama.dRr = paramca.ajP();
                localc.PHY.setTag(parama);
                localc.PHY.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOD());
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label2054;
                  }
                  localc.PHM.setImageResource(2131689567);
                }
              }
              for (;;)
              {
                if (!gTW()) {
                  break label2066;
                }
                b(localc, false);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.PHN.setVisibility(8);
                break label1784;
                localc.PHY.setImageResource(2131234185);
                break label1890;
                localc.PHM.setImageBitmap(parama);
              }
              if (paramca.getStatus() < 2) {}
              for (bool2 = true;; bool2 = false)
              {
                b(localc, bool2);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
              }
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.PHN.setVisibility(0);
                localc.PHN.setMaxLines(2);
              }
              for (;;)
              {
                localc.jBR.setVisibility(0);
                localc.PHS.setVisibility(8);
                localc.PHT.setVisibility(4);
                localc.jBR.setMaxLines(2);
                localc.jBR.setText(Util.getSizeKB(localb.iwI));
                localc.PHY.setVisibility(8);
                e.c.a(localc, str, localb.iwI);
                e.c.a(localc, Boolean.FALSE, paramca, localb.dCK, localb.title);
                if (!bool1) {
                  break label7736;
                }
                if (!e.b.bng(localb.iwJ)) {
                  break label2291;
                }
                localc.PHM.setImageResource(2131231098);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.PHN.setVisibility(8);
              }
              localc.PHM.setImageResource(com.tencent.mm.pluginsdk.model.r.bdt(localb.iwJ));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
            }
          case 4: 
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.PHN.setVisibility(0);
              localc.jBR.setVisibility(0);
              localc.PHS.setVisibility(8);
              localc.jBR.setMaxLines(2);
              localc.PHT.setVisibility(4);
              localc.PHY.setVisibility(0);
              localc.PHY.setImageResource(2131235406);
              if (!bool1) {
                break label7736;
              }
              paramString = new com.tencent.mm.av.a.a.c.a();
              paramString.ty(2131689587).bdq().dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bdo().bdt().aw(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1));
              localObject2 = com.tencent.mm.av.q.bcV();
              if (!Util.isNullOrNil(localb.thumburl)) {
                break label2541;
              }
            }
            for (parama = localb.iwO;; parama = localb.thumburl)
            {
              ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.PHM, paramString.bdv());
              localc.PHY.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.PHN.setVisibility(8);
              break label2348;
            }
          case 36: 
            label1349:
            label1490:
            label1890:
            label2040:
            if (localc.PIh.getLayoutParams() != null)
            {
              localc.PIh.getLayoutParams().width = -2;
              localc.PIh.requestLayout();
            }
            label1477:
            label2291:
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localb.izi);
            label2541:
            if (localObject2 != null)
            {
              parama = ((WxaAttributes)localObject2).field_nickname;
              if (localObject2 == null) {
                break label2933;
              }
              paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
              localc.PIi.setVisibility(8);
              localc.PIu.setVisibility(0);
              localc.PIo.setVisibility(8);
              localc.PIB.setVisibility(8);
              localc.PIy.setText(localb.title);
              e.h(localc.PIy, localb.title);
              localc.PIs.setText(parama);
              e.a(localc.PIt, localb);
              if (!e.a(paramca, localb, parama1)) {
                break label2943;
              }
              localc.PIY.setVisibility(0);
              bool2 = Util.isNullOrNil(paramca.ajU());
              localc.PIY.setTag(paramca);
              localc.PIY.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179969);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  e.a((ca)paramAnonymousView.getTag(), localc, parama1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(179969);
                }
              });
              e.a(bool2, localc, parama1);
              com.tencent.mm.av.q.bcV().a(paramString, localc.PIr, ai.d.gvY);
              parama = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
              localc.PIv.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PIv, "file://".concat(String.valueOf(parama)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(240, 192));
              if (!gTW()) {
                break label2956;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
            }
            label2626:
            label2777:
            break;
          }
          label4041:
          label4171:
          label7759:
          for (;;)
          {
            bool2 = false;
            for (parama = localc;; parama = localc)
            {
              b(parama, bool2);
              if (!e.a(localb, (WxaAttributes)localObject2)) {
                break label2974;
              }
              localc.lrd.setVisibility(0);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              parama = localb.eah;
              break label2614;
              label2933:
              paramString = localb.izB;
              break label2626;
              label2943:
              localc.PIY.setVisibility(8);
              break label2777;
              if (paramca.getStatus() >= 2) {
                break label7759;
              }
              bool2 = true;
            }
            localc.lrd.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            if (localb != null) {
              e.a(paramString, parama1, paramca, localb);
            }
            parama = (com.tencent.mm.ag.e)localb.as(com.tencent.mm.ag.e.class);
            if ((parama != null) && (parama.iwe == 1) && (parama.iwc == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()))
            {
              e.c.a(parama1, localc, localb, paramca, bool1);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
            }
            if ((i == 0) && (al.a(localb, parama)))
            {
              localc.PIR.setVisibility(0);
              localc.PIW.setVisibility(0);
              al.a(parama1.getContext(), localb, localc.PIT, localc.PIU);
              al.b(localc.PIV, localb);
            }
            localc.PHN.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.PHS.setMaxLines(2);
              localc.PHS.setVisibility(0);
              localc.PHS.setText(localb.title);
              localc.jBR.setMaxLines(3);
              localc.PHT.setVisibility(4);
              if (!e.n(localb)) {
                break label3415;
              }
              localc.PHY.setImageResource(2131235406);
              localc.PHY.setVisibility(0);
              if (bool1)
              {
                paramString = new com.tencent.mm.av.a.a.c.a();
                paramString.ty(2131689587).bdq().OT(com.tencent.mm.plugin.image.d.dZF()).dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bdo().bdt().aw(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                localObject2 = com.tencent.mm.av.q.bcV();
                if (!Util.isNullOrNil(localb.thumburl)) {
                  break label3428;
                }
              }
            }
            label3415:
            label3428:
            for (parama = localb.iwO;; parama = localb.thumburl)
            {
              ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.PHM, paramString.bdv());
              if (!gTW()) {
                break label3437;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.PHS.setVisibility(8);
              break label3207;
              localc.PHY.setVisibility(8);
              break label3253;
            }
            label3437:
            if (paramca.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(localb.izi);
            ((w)com.tencent.mm.kernel.g.af(w.class)).VA(localb.izi);
            switch (localb.izk)
            {
            default: 
              localc.PHR.setVisibility(0);
              localc.PHO.setVisibility(0);
              localc.PHO.setBackground(null);
              localc.PHO.setImageResource(2131689686);
              e.a(localc.tln, localb);
              i = 1;
            }
            for (;;)
            {
              if (i == 0)
              {
                if (gTW())
                {
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
                  b(localc, false);
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                  if (localc.PIh.getLayoutParams() != null)
                  {
                    localc.PIh.getLayoutParams().width = -2;
                    localc.PIh.requestLayout();
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    label3687:
                    if (localObject2 == null) {
                      break label3982;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    label3699:
                    localc.PIi.setVisibility(8);
                    localc.PIu.setVisibility(0);
                    localc.PIo.setVisibility(8);
                    localc.PIB.setVisibility(8);
                    localc.PIy.setText(localb.title);
                    e.h(localc.PIy, localb.title);
                    localc.PIs.setText(parama);
                    e.a(localc.PIt, localb);
                    com.tencent.mm.av.q.bcV().a(paramString, localc.PIr, ai.d.gvY);
                    parama = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                    localc.PIv.setImageBitmap(null);
                    localc.PIx.setVisibility(0);
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label3992;
                    }
                    localc.lrd.setVisibility(0);
                    if (!e.a(paramca, localb, parama1)) {
                      break label4005;
                    }
                    localc.PIY.setVisibility(0);
                    bool2 = Util.isNullOrNil(paramca.ajU());
                    localc.PIY.setTag(paramca);
                    localc.PIY.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(185040);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.bm(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                        e.a((ca)paramAnonymousView.getTag(), localc, parama1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(185040);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    bool2 = e.o(localb);
                    com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
                    {
                      public final void I(Bitmap paramAnonymousBitmap)
                      {
                        AppMethodBeat.i(36810);
                        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                        {
                          localc.PIv.setImageBitmap(paramAnonymousBitmap);
                          localc.PIv.setVisibility(0);
                          localc.PIx.setVisibility(4);
                          if (bool2)
                          {
                            localc.PIw.setImageDrawable(com.tencent.mm.cb.a.l(parama1.Pwc.getContext(), 2131691480));
                            localc.PIw.setVisibility(0);
                            AppMethodBeat.o(36810);
                            return;
                          }
                          localc.PIw.setVisibility(8);
                          AppMethodBeat.o(36810);
                          return;
                        }
                        localc.PIv.setVisibility(4);
                        localc.PIx.setVisibility(0);
                        localc.PIw.setVisibility(8);
                        AppMethodBeat.o(36810);
                      }
                      
                      public final String Lb()
                      {
                        AppMethodBeat.i(36812);
                        String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                        AppMethodBeat.o(36812);
                        return str;
                      }
                      
                      public final void aYg()
                      {
                        AppMethodBeat.i(36809);
                        AppMethodBeat.o(36809);
                      }
                      
                      public final void oD()
                      {
                        AppMethodBeat.i(36811);
                        AppMethodBeat.o(36811);
                      }
                    }, e.Lk(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).jdMethod_do(240, 192));
                    i = 0;
                    break;
                    parama = localb.eah;
                    break label3687;
                    paramString = localb.izB;
                    break label3699;
                    localc.lrd.setVisibility(8);
                    break label3848;
                    localc.PIY.setVisibility(8);
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label4171;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.PIi.setVisibility(8);
                    localc.PIu.setVisibility(8);
                    localc.PIo.setVisibility(0);
                    localc.PIq.setText(parama);
                    localc.PIB.setVisibility(8);
                    if (!Util.isNullOrNil(paramString)) {
                      break label4177;
                    }
                    parama = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                    com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PIp, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                  }
                  for (;;)
                  {
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label4200;
                    }
                    localc.PIA.setVisibility(0);
                    i = 0;
                    break;
                    parama = localb.title;
                    break label4029;
                    paramString = null;
                    break label4041;
                    label4177:
                    com.tencent.mm.modelappbrand.a.b.aXY().a(localc.PIp, paramString, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                  }
                  label4200:
                  localc.PIA.setVisibility(8);
                  i = 0;
                  continue;
                }
                if (paramca.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                parama = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
                paramString = localb.izB;
                localObject2 = localb.eah;
                localObject3 = localb.title;
                localObject4 = localb.description;
                if (parama == null)
                {
                  Log.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
                  break;
                }
                if (((Util.isNullOrNil(parama.ivm)) || (Util.isNullOrNil(parama.ivo))) && (Util.isNullOrNil(parama.ivl)))
                {
                  Log.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
                  break;
                }
                localc.PIH.setText((CharSequence)localObject2);
                localc.PIi.setVisibility(8);
                localc.PIu.setVisibility(8);
                localc.PIo.setVisibility(8);
                localc.PII.setVisibility(0);
                localc.PIE.setVisibility(8);
                localc.PII.setImageDrawable(com.tencent.mm.cb.a.l(parama1.getContext(), 2131691480));
                localc.PIB.setVisibility(0);
                localc.PIC.setText((CharSequence)localObject3);
                localc.PID.setText((CharSequence)localObject4);
                com.tencent.mm.av.q.bcU().a(paramString, new r.a()
                {
                  public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                  {
                    AppMethodBeat.i(36814);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(36813);
                        if (!paramAnonymousBitmap.isRecycled()) {
                          e.e.7.this.PJe.PIG.setImageBitmap(paramAnonymousBitmap);
                        }
                        AppMethodBeat.o(36813);
                      }
                    });
                    AppMethodBeat.o(36814);
                  }
                });
                parama = com.tencent.mm.av.q.bcR().OF(paramca.ajP());
                localc.PIF.setImageBitmap(null);
                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
                {
                  public final void I(Bitmap paramAnonymousBitmap)
                  {
                    AppMethodBeat.i(36816);
                    if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                    {
                      localc.PIF.setImageBitmap(paramAnonymousBitmap);
                      localc.PIF.setVisibility(0);
                    }
                    AppMethodBeat.o(36816);
                  }
                  
                  public final String Lb()
                  {
                    AppMethodBeat.i(36817);
                    String str = "CHAT#" + com.tencent.mm.plugin.appbrand.ac.n.cO(this);
                    AppMethodBeat.o(36817);
                    return str;
                  }
                  
                  public final void aYg()
                  {
                    AppMethodBeat.i(36815);
                    localc.PIF.setVisibility(4);
                    AppMethodBeat.o(36815);
                  }
                  
                  public final void oD()
                  {
                    AppMethodBeat.i(185041);
                    Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
                    com.tencent.mm.plugin.report.service.h.CyF.dN(808, 3);
                    AppMethodBeat.o(185041);
                  }
                }, e.Lk(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.iIr));
                if (gTW())
                {
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                }
                if (paramca.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                i = 1;
                localc.jBR.setMaxLines(3);
                localc.PHS.setMaxLines(2);
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                localc.PHN.setVisibility(8);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.PHS.setMaxLines(2);
                  localc.PHS.setVisibility(0);
                  localc.PHS.setText(localb.title);
                  label4712:
                  localc.jBR.setMaxLines(3);
                  localc.PHT.setVisibility(4);
                  localc.PHY.setVisibility(8);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label4823;
                    }
                    localc.PHM.setImageResource(2131689587);
                  }
                }
                for (;;)
                {
                  if (!gTW()) {
                    break label4835;
                  }
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.PHS.setVisibility(8);
                  break label4712;
                  label4823:
                  localc.PHM.setImageBitmap(parama);
                }
                label4835:
                if (paramca.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                localc.PHS.setVisibility(0);
                if (localb.ixg == 1) {
                  localc.PHS.setText(2131764968);
                }
                for (;;)
                {
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.PHN.setVisibility(0);
                    localc.PHN.aw(localb.title);
                  }
                  localc.jBR.setMaxLines(4);
                  localc.PHT.setVisibility(4);
                  localc.PHY.setVisibility(8);
                  if (!bool1) {
                    break label7736;
                  }
                  parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama == null) || (parama.isRecycled())) {
                    break label5090;
                  }
                  localc.PHM.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  if (localb.ixg == 2) {
                    localc.PHS.setText(2131764970);
                  } else if (localb.ixg == 3) {
                    localc.PHS.setText(2131764969);
                  } else {
                    localc.PHS.setText(2131764971);
                  }
                }
                label5090:
                localc.PHM.setImageResource(2131689587);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                localc.PHN.setVisibility(0);
                localc.PHN.aw(localb.title);
                localc.PHS.setVisibility(0);
                localc.PHS.setText(2131757460);
                localc.jBR.setMaxLines(4);
                localc.PHT.setVisibility(4);
                localc.PHY.setVisibility(8);
                if (bool1)
                {
                  parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled()))
                  {
                    localc.PHM.setImageBitmap(parama);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                  }
                  localc.PHM.setImageResource(2131689587);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.PHN.setVisibility(0);
                    localc.PHN.aw(localb.title);
                    localc.PHS.setVisibility(8);
                  }
                  localc.jBR.setMaxLines(4);
                  localc.PHT.setVisibility(4);
                  localc.PHY.setVisibility(8);
                  if (bool1)
                  {
                    parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      localc.PHM.setImageBitmap(parama);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1194;
                    }
                    localc.PHM.setImageResource(2131689587);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    if ((localb.title != null) && (localb.title.length() > 0)) {
                      localc.PHN.setVisibility(0);
                    }
                    for (;;)
                    {
                      localc.jBR.setVisibility(0);
                      localc.PHS.setVisibility(8);
                      localc.PHT.setVisibility(8);
                      localc.PHY.setVisibility(4);
                      localc.jBR.setMaxLines(2);
                      if (!bool1) {
                        break label7736;
                      }
                      parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                      if ((parama != null) && (!parama.isRecycled())) {
                        break label5572;
                      }
                      localc.PHM.setImageResource(2131689587);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.PHN.setVisibility(8);
                    }
                    localc.PHM.setImageBitmap(parama);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.PHN.setVisibility(0);
                      label5622:
                      localc.jBR.setVisibility(0);
                      localc.PHS.setVisibility(8);
                      localc.PHY.setVisibility(8);
                      localc.PHT.setVisibility(4);
                      localc.jBR.setMaxLines(2);
                      if (bool1)
                      {
                        parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label5807;
                        }
                        localc.PHM.setImageResource(2131689587);
                      }
                    }
                    for (;;)
                    {
                      parama = new bq(paramca, false, paramInt, "", false, parama1.gOZ(), localb.eag, localb.eah, localb.title, localb.ixo, localb.url, false, false);
                      localc.PIh.setTag(parama);
                      localc.PIh.setOnClickListener(i(parama1));
                      j = 1;
                      i = 0;
                      break;
                      localc.PHN.setVisibility(8);
                      break label5622;
                      localc.PHM.setImageBitmap(parama);
                    }
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.PHN.setVisibility(0);
                      label5847:
                      localc.jBR.setVisibility(0);
                      localc.PHS.setVisibility(8);
                      localc.PHY.setVisibility(8);
                      localc.PHT.setVisibility(4);
                      localc.jBR.setMaxLines(2);
                      if (bool1)
                      {
                        parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label6038;
                        }
                        localc.PHM.setImageResource(2131689587);
                      }
                    }
                    for (;;)
                    {
                      parama = new bq(paramca, paramInt, "", parama1.gOZ(), localb.eag, localb.eah, localb.title, localb.iyV, localb.designerName, localb.designerRediretctUrl, localb.url);
                      localc.PIh.setTag(parama);
                      localc.PIh.setOnClickListener(j(parama1));
                      j = 1;
                      i = 0;
                      break;
                      localc.PHN.setVisibility(8);
                      break label5847;
                      localc.PHM.setImageBitmap(parama);
                    }
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.PHN.setVisibility(0);
                      localc.jBR.setVisibility(0);
                      localc.PHS.setVisibility(8);
                      localc.PHY.setVisibility(8);
                      localc.PHT.setVisibility(4);
                      localc.jBR.setMaxLines(2);
                      if (bool1)
                      {
                        if (!Util.isNullOrNil(paramca.ajP())) {
                          break label6337;
                        }
                        com.tencent.mm.av.q.bcV().loadImage(localb.thumburl, localc.PHM);
                      }
                      parama = new bq();
                      parama.dTX = paramca;
                      parama.Pdm = false;
                      parama.position = paramInt;
                      parama.PQC = false;
                      parama.title = parama1.gOZ();
                      parama.eag = localb.eag;
                      parama.eah = localb.eah;
                      parama.Nwj = localb.title;
                      if (localb.type != 26) {
                        break label6394;
                      }
                      parama.tid = localb.tid;
                      parama.iyW = localb.iyW;
                      parama.desc = localb.desc;
                      parama.iconUrl = localb.iconUrl;
                      parama.secondUrl = localb.secondUrl;
                      parama.pageType = localb.pageType;
                      localc.PIh.setOnClickListener(k(parama1));
                      i = 1;
                    }
                    for (;;)
                    {
                      localc.PIh.setTag(parama);
                      k = 0;
                      j = i;
                      i = k;
                      break;
                      localc.PHN.setVisibility(8);
                      break label6078;
                      parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                      if ((parama == null) || (parama.isRecycled()))
                      {
                        localc.PHM.setImageResource(2131689587);
                        break label6157;
                      }
                      localc.PHM.setImageBitmap(parama);
                      break label6157;
                      label6394:
                      if (localb.type == 27)
                      {
                        parama.tid = localb.tid;
                        parama.iyW = localb.iyW;
                        parama.desc = localb.desc;
                        parama.iconUrl = localb.iconUrl;
                        parama.secondUrl = localb.secondUrl;
                        parama.pageType = localb.pageType;
                        localc.PIh.setOnClickListener(l(parama1));
                        i = 1;
                      }
                      else
                      {
                        Log.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                        i = 0;
                      }
                    }
                    localc.PHN.setVisibility(0);
                    localc.PHN.aw(localb.description);
                    localc.jBR.setText(localb.ixU);
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.PHS.setVisibility(0);
                      localc.PHS.setText(localb.title);
                    }
                    for (;;)
                    {
                      localc.jBR.setMaxLines(4);
                      localc.PHT.setVisibility(4);
                      localc.PHY.setVisibility(8);
                      if (!bool1) {
                        break label7736;
                      }
                      parama = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                      if (parama == null) {
                        break label6660;
                      }
                      localc.PHM.setImageBitmap(parama);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.PHS.setVisibility(8);
                    }
                    localc.PHM.setImageResource(2131689587);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    localc.PHN.setVisibility(8);
                    localc.PHS.setVisibility(0);
                    if ((localb.title != null) && (localb.title.length() > 0)) {
                      localc.PHS.setText(com.tencent.mm.pluginsdk.ui.span.l.e(localc.PHS.getContext(), localb.title, (int)localc.PHS.getTextSize()));
                    }
                    for (;;)
                    {
                      localc.jBR.setMaxLines(3);
                      localc.PHT.setVisibility(4);
                      localc.PHY.setVisibility(8);
                      if (bool1) {
                        localc.PHM.setVisibility(8);
                      }
                      e.c.b(parama1, localc, localb, paramca, bool1);
                      if (!gTW()) {
                        break label6893;
                      }
                      a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
                      b(localc, false);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.PHS.setText(com.tencent.mm.pluginsdk.ui.span.l.e(localc.PHS.getContext(), MMApplicationContext.getContext().getString(2131759360), (int)localc.PHS.getTextSize()));
                    }
                    label6893:
                    if (paramca.getStatus() < 2) {}
                    for (bool2 = true;; bool2 = false)
                    {
                      b(localc, bool2);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                    }
                    e.c.a(parama1, localc, localb, bool1);
                    if (gTW())
                    {
                      a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
                      b(localc, false);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1194;
                    }
                    if (paramca.getStatus() < 2) {}
                    for (bool2 = true;; bool2 = false)
                    {
                      b(localc, bool2);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                    }
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.PHN.setVisibility(0);
                      if (!Util.isNullOrNil(localb.iyd)) {
                        if (!Util.isNullOrNil(localb.iyd))
                        {
                          localc.PHN.setTextColor(Util.convertStringToRGB(localb.iyd, parama1.getContext().getResources().getColor(2131100904)));
                          localc.jBR.setMaxLines(2);
                          localc.jBR.setVisibility(0);
                          if (Util.isNullOrNil(localb.iye)) {
                            break label7424;
                          }
                          localc.jBR.setTextColor(Util.convertStringToRGB(localb.iye, parama1.getContext().getResources().getColor(2131100571)));
                          label7161:
                          localc.PHS.setVisibility(8);
                          localc.PHT.setVisibility(4);
                          localc.PHY.setVisibility(8);
                          localc.PHR.setVisibility(0);
                          localc.tln.setVisibility(0);
                          if (Util.isNullOrNil(localb.ixZ)) {
                            break label7448;
                          }
                          localc.tln.setText(localb.ixZ);
                        }
                      }
                    }
                    for (;;)
                    {
                      if (this.qoo)
                      {
                        parama = com.tencent.mm.av.q.bcR().d(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          paramString = BitmapUtil.getRoundedCornerBitmap(parama, false, parama.getWidth() / 2);
                          localc.PHM.setImageBitmap(paramString);
                        }
                        if (!Util.isNullOrNil(localb.iyc))
                        {
                          com.tencent.mm.av.q.bcV().a(localb.iyc, new ImageView(parama1.getContext()), new com.tencent.mm.av.a.a.c.a().bdp().bdv(), new com.tencent.mm.av.a.c.h()
                          {
                            public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
                            {
                              return null;
                            }
                            
                            public final void b(String paramAnonymousString, View paramAnonymousView) {}
                            
                            public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
                            {
                              AppMethodBeat.i(36819);
                              if (paramAnonymousb.bitmap != null)
                              {
                                paramAnonymousString = paramAnonymousb.bitmap;
                                localc.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                                {
                                  public final boolean onPreDraw()
                                  {
                                    AppMethodBeat.i(36818);
                                    e.e.9.this.PJe.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                                    int j = e.e.9.this.PJe.PIi.getHeight();
                                    int k = e.e.9.this.PJe.PIi.getWidth();
                                    int i = j;
                                    if (j == 0) {
                                      i = com.tencent.mm.cb.a.aG(e.e.9.this.PHb.Pwc.getContext(), 2131166076);
                                    }
                                    j = k;
                                    if (k == 0) {
                                      j = com.tencent.mm.cb.a.aG(e.e.9.this.PHb.Pwc.getContext(), 2131166077);
                                    }
                                    BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapUtil.createMaskImage(paramAnonymousString, 2131231653, j, i));
                                    e.e.9.this.PJe.PIi.setBackgroundDrawable(localBitmapDrawable);
                                    AppMethodBeat.o(36818);
                                    return true;
                                  }
                                });
                              }
                              AppMethodBeat.o(36819);
                            }
                          });
                          i = 0;
                          parama = (c.a)localObject1;
                          j = k;
                          break;
                          localc.PHN.setTextColor(parama1.getContext().getResources().getColor(2131100904));
                          break label7103;
                          localc.PHN.setTextColor(parama1.getContext().getResources().getColor(2131100904));
                          break label7103;
                          localc.PHN.setVisibility(8);
                          break label7103;
                          localc.jBR.setTextColor(parama1.getContext().getResources().getColor(2131100571));
                          break label7161;
                          localc.tln.setText(2131757418);
                          continue;
                        }
                        localc.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                        {
                          private boolean qCs = false;
                          
                          public final boolean onPreDraw()
                          {
                            AppMethodBeat.i(36820);
                            if (this.qCs)
                            {
                              localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                              AppMethodBeat.o(36820);
                              return true;
                            }
                            localc.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.qCs = true;
                            int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Pwc.getContext(), 24);
                            Bitmap localBitmap = parama;
                            Object localObject;
                            if (localBitmap != null)
                            {
                              localObject = localBitmap;
                              if (!localBitmap.isRecycled()) {}
                            }
                            else
                            {
                              localObject = BitmapUtil.createColorBitmap(parama1.Pwc.getContext().getResources().getColor(2131100161), i, i);
                            }
                            int j = ((Bitmap)localObject).getHeight();
                            if (i > j) {
                              i = j;
                            }
                            for (;;)
                            {
                              localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                              j = localc.PIi.getHeight();
                              int k = localc.PIi.getWidth();
                              i = j;
                              if (j == 0) {
                                i = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166076);
                              }
                              j = k;
                              if (k == 0) {
                                j = com.tencent.mm.cb.a.aG(parama1.Pwc.getContext(), 2131166077);
                              }
                              localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, 2131231653, j, i));
                              localc.PIi.setBackgroundDrawable((Drawable)localObject);
                              AppMethodBeat.o(36820);
                              return true;
                            }
                          }
                        });
                        i = 0;
                        parama = (c.a)localObject1;
                        j = k;
                        break;
                      }
                    }
                    localc.PHM.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131234278));
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    if (((t)localObject2).iAl == 19)
                    {
                      e.c.a(parama1, localc, localb, bool1);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1194;
                      localc.PHS.setVisibility(8);
                      break label1249;
                      localObject1 = com.tencent.mm.av.q.bcR().b(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                      if (localObject1 != null)
                      {
                        paramString = (String)localObject1;
                        if (!((Bitmap)localObject1).isRecycled()) {}
                      }
                      else
                      {
                        paramString = com.tencent.mm.av.q.bcR().d(paramca.ajP(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                      }
                      if ((paramString != null) && (!paramString.isRecycled()))
                      {
                        localc.PHM.setImageBitmap(paramString);
                        break label1349;
                      }
                      if (!Util.isNullOrNil(localb.thumburl))
                      {
                        paramString = localb.thumburl;
                        localObject1 = new com.tencent.mm.av.a.a.c.a();
                        ((com.tencent.mm.av.a.a.c.a)localObject1).ty(2131100173).bdq().bdo();
                        com.tencent.mm.av.q.bcV().a(paramString, localc.PIL, ((com.tencent.mm.av.a.a.c.a)localObject1).bdv());
                        break label1349;
                      }
                      localc.PHM.setImageResource(2131231098);
                      break label1349;
                    }
                  }
                }
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
              }
            }
            parama = (c.a)localObject1;
            j = k;
            break label1194;
          }
          label5572:
          label7762:
          i = 1;
        }
        label2614:
        label4029:
        label6078:
        label7103:
        localObject2 = null;
        label3253:
        label7736:
        localb = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36829);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(36829);
        return false;
      case 100: 
        AppMethodBeat.o(36829);
        return false;
      case 111: 
        if ((paramca != null) && (paramca.dOQ()))
        {
          paramMenuItem = k.b.HD(paramca.field_content);
          if (paramMenuItem != null)
          {
            if (paramMenuItem.type == 40)
            {
              com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131759141), "", parama.Pwc.getContext().getString(2131768713), null);
              AppMethodBeat.o(36829);
              return false;
            }
            if ((paramMenuItem.type == 33) && (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.Pwc.getContext())))
            {
              AppMethodBeat.o(36829);
              return false;
            }
          }
        }
        e.b.a(parama, paramca, a(parama, paramca));
        AppMethodBeat.o(36829);
        return false;
      case 114: 
        paramMenuItem = paramca.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.HD(paramMenuItem);
        if (paramMenuItem != null) {
          switch (e.m(paramMenuItem))
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          com.tencent.mm.ui.chatting.an.a(paramca, bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.d(paramca, parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.b(paramca, bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.a(paramca, parama.Pwc.getContext(), a(parama, paramca), parama.gRM());
          continue;
          com.tencent.mm.ui.chatting.an.m(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.c(paramca, bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend), parama.Pwc.getContext());
          continue;
          com.tencent.mm.ui.chatting.an.c(paramca, parama.Pwc.getContext());
        }
      case 103: 
        paramMenuItem = paramca.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.HD(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        break;
      }
      for (;;)
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        AppMethodBeat.o(36829);
        return false;
        kj localkj = new kj();
        localkj.dPt.dPu = paramMenuItem.dPu;
        localkj.dPt.dFm = paramca.field_msgId;
        localkj.dPt.dPv = paramca.field_talker;
        EventCenter.instance.publish(localkj);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233602);
      int i = ((bq)paramView.getTag()).position;
      if (paramca.field_content == null)
      {
        AppMethodBeat.o(233602);
        return true;
      }
      k.b localb = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(233602);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.bm(paramca)) && ((localb.type != 19) || (paramca.field_status != 1))) {
        paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
      if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
        paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
      }
      boolean bool1;
      switch (e.m(localb))
      {
      default: 
        bool1 = false;
      }
      for (;;)
      {
        if ((bool1) && (!this.PhN.gRN())) {
          paramm.add(i, 114, 0, paramView.getContext().getString(2131757429));
        }
        if ((com.tencent.mm.br.c.aZU("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).NA()))) {
          switch (e.m(localb))
          {
          }
        }
        for (;;)
        {
          localObject = new ef();
          ((ef)localObject).dHy.msgId = paramca.field_msgId;
          EventCenter.instance.publish((IEvent)localObject);
          if ((((ef)localObject).dHz.dGX) || (e.b.a(this.PhN.Pwc.getContext(), localb))) {
            paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
          }
          if (!this.PhN.gRN()) {
            paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
          }
          if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
            paramm.a(i, 144, paramView.getContext().getString(2131763040), 2131690297);
          }
          AppMethodBeat.o(233602);
          return true;
          bool1 = com.tencent.mm.al.g.aZR();
          break;
          bool1 = com.tencent.mm.al.g.aZL();
          break;
          boolean bool2 = com.tencent.mm.al.g.aZP();
          bool1 = bool2;
          if (Util.isImageExt(localb.iwJ)) {
            break;
          }
          paramm.a(i, 150, this.PhN.Pwc.getMMResources().getString(2131757441), 2131690629);
          bool1 = bool2;
          break;
          bool1 = com.tencent.mm.al.g.aZI();
          break;
          bool1 = com.tencent.mm.al.g.aZH();
          break;
          bool1 = com.tencent.mm.al.g.aZN();
          break;
          bool1 = com.tencent.mm.al.g.aZJ();
          break;
          if ((localb.ixV != 5) && (localb.ixV != 6) && (localb.ixV != 2)) {
            break label889;
          }
          if (localb.ixV != 2) {
            paramm.clear();
          }
          paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
          AppMethodBeat.o(233602);
          return false;
          paramm.clear();
          paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
          AppMethodBeat.o(233602);
          return false;
          paramm.a(i, 116, paramView.getContext().getString(2131763947), 2131690551);
        }
        label889:
        bool1 = false;
      }
    }
    
    public final void b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(233603);
      com.tencent.mm.ui.base.h.c(parama.Pwc.getContext(), parama.Pwc.getMMResources().getString(2131757499), "", parama.Pwc.getMMResources().getString(2131755966), parama.Pwc.getMMResources().getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(36804);
          if (paramca.dOQ())
          {
            com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
            parama.BN(true);
            AppMethodBeat.o(36804);
            return;
          }
          AppMethodBeat.o(36804);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(179968);
          AppMethodBeat.o(179968);
        }
      });
      AppMethodBeat.o(233603);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean c(final View paramView, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36830);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      paramView.getTag();
      paramView = paramca.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      paramView = k.b.HD(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
      if ((localObject != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId))) {
        a(parama, paramView, com.tencent.mm.model.z.aTY(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (e.m(paramView))
      {
      }
      do
      {
        i = 1;
        while ((i != 0) && (i(paramView, parama, this, paramca)))
        {
          AppMethodBeat.o(36830);
          return true;
          bg.aVF();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
            AppMethodBeat.o(36830);
            return true;
          }
          if (Util.isImageExt(paramView.iwJ))
          {
            long l = paramca.field_msgId;
            localObject = paramView.dCK;
            paramView = com.tencent.mm.pluginsdk.model.app.ao.cgO().bdx((String)localObject);
            if ((paramView == null) || (!paramView.deQ())) {
              i = 0;
            }
            while (i != 0)
            {
              AppMethodBeat.o(36830);
              return true;
              bg.aVF();
              ca localca = com.tencent.mm.model.c.aSQ().Hb(l);
              if (localca.gDB())
              {
                Log.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject, Long.valueOf(l), Long.valueOf(localca.field_msgSvrId), localca.field_imgPath });
                localObject = new Intent();
                ((Intent)localObject).setClassName(this.PhN.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                ((Intent)localObject).putExtra("clean_view_type", 1);
                paramView = this.PhN;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = 1;
              }
              else
              {
                localObject = new Intent(this.PhN.Pwc.getContext(), ShowImageUI.class);
                ((Intent)localObject).putExtra("key_image_path", paramView.field_fileFullPath);
                ((Intent)localObject).putExtra("key_message_id", l);
                ((Intent)localObject).putExtra("key_favorite", true);
                paramView = this.PhN;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = 1;
              }
            }
          }
          paramView = new Intent();
          paramView.setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          paramView.putExtra("scene", 2);
          paramView.putExtra("app_msg_id", paramca.field_msgId);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36830);
          return true;
          if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(parama.Pwc.getContext()))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(13043, new Object[] { Integer.valueOf(2), paramView.description, paramView.appId });
          boolean bool = f(paramView, parama, this, paramca);
          AppMethodBeat.o(36830);
          return bool;
          bool = j(paramView, parama, this, paramca);
          AppMethodBeat.o(36830);
          return bool;
          if (h(paramView, parama, this, paramca))
          {
            AppMethodBeat.o(36830);
            return true;
            if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.Pwc.getContext()))
            {
              AppMethodBeat.o(36830);
              return true;
            }
            if (g(paramView, parama, this, paramca))
            {
              AppMethodBeat.o(36830);
              return true;
            }
            i = 1;
          }
        }
        b(paramView, parama, this, paramca);
        AppMethodBeat.o(36830);
        return true;
        if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).NA()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
        {
          AppMethodBeat.o(36830);
          return true;
        }
        ((com.tencent.mm.ui.chatting.d.b.b)parama.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a(paramca, new com.tencent.mm.pluginsdk.model.app.al()
        {
          public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(233601);
            if (this.qJW != null)
            {
              if (paramAnonymousBoolean1)
              {
                e.e.a(parama, paramView, com.tencent.mm.model.z.aTY(), this.qJW, paramca.field_msgSvrId, 3, parama.getTalkerUserName());
                AppMethodBeat.o(233601);
                return;
              }
              e.e.a(parama, paramView, com.tencent.mm.model.z.aTY(), this.qJW, paramca.field_msgSvrId, 7, parama.getTalkerUserName());
            }
            AppMethodBeat.o(233601);
          }
        });
        AppMethodBeat.o(36830);
        return true;
        if (Util.isNullOrNil(paramView.ixh))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).setFlags(65536);
        ((Intent)localObject).putExtra("key_Product_xml", paramView.ixh);
        ((Intent)localObject).putExtra("key_ProductUI_getProductInfoScene", 1);
        if (paramca.field_imgPath == null) {
          ((Intent)localObject).putExtra("key_ProductUI_chatting_msgId", paramca.field_msgId);
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
        if (Util.isNullOrNil(paramView.ixk))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).setFlags(65536);
        ((Intent)localObject).putExtra("key_TV_xml", paramView.ixk);
        ((Intent)localObject).putExtra("key_TV_getProductInfoScene", 1);
        if (paramca.field_imgPath == null) {
          ((Intent)localObject).putExtra("key_TVInfoUI_chatting_msgId", paramca.field_msgId);
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
        if (Util.isNullOrNil(paramView.ixn))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        paramca = new Intent();
        paramca.setFlags(65536);
        paramca.putExtra("key_product_info", paramView.ixn);
        paramca.putExtra("key_product_scene", 1);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "product", ".ui.MallProductUI", paramca);
        AppMethodBeat.o(36830);
        return true;
        if (Util.isNullOrNil(paramView.dPu))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        paramca = new Intent();
        paramca.setFlags(65536);
        paramca.putExtra("key_card_app_msg", paramView.dPu);
        paramca.putExtra("key_from_scene", paramView.ixV);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "card", ".ui.CardDetailUI", paramca);
        AppMethodBeat.o(36830);
        return true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("message_id", paramca.field_msgId);
        ((Intent)localObject).putExtra("record_xml", paramView.ixl);
        i = com.tencent.mm.model.ac.aJ(a(parama, paramca), parama.getTalkerUserName());
        ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
        ((Intent)localObject).putExtra("preUsername", a(parama, paramca));
        ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
        ((Intent)localObject).putExtra("preChatTYPE", i);
        ((Intent)localObject).putExtra("msgUsername", parama.PkU);
        ((Intent)localObject).putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
        e.a.a((Intent)localObject, parama, paramca, this);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
        e.a(paramView, parama, paramca);
        AppMethodBeat.o(36830);
        return true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_biz_uin", paramView.ixX);
        ((Intent)localObject).putExtra("key_order_id", paramView.ixY);
        if ((paramca.field_talker != null) && (!paramca.field_talker.equals("")) && (ab.Eq(paramca.field_talker))) {
          ((Intent)localObject).putExtra("key_chatroom_name", paramca.field_talker);
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
      } while (!e.a(paramView, parama));
      AppMethodBeat.o(36830);
      return true;
      AppMethodBeat.o(36830);
      return false;
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
  
  static final class f
  {
    public boolean PJq = false;
  }
  
  public static final class g
  {
    public e.h PJr;
    public int PJs = -1;
    public String dRr;
    public css jfy = null;
    public long msgId;
    public String xml;
  }
  
  public static final class h
  {
    public String JwO;
    public String coverUrl;
    public String iAA;
    public String playUrl;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e
 * JD-Core Version:    0.7.0.1
 */