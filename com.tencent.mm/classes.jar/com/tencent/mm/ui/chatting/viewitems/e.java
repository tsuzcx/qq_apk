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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.aa;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.t;
import com.tencent.mm.aj.x;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.la;
import com.tencent.mm.f.a.px;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.app.k.2;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.flm;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.t.i;
import com.tencent.mm.ui.chatting.t.j;
import com.tencent.mm.ui.chatting.t.l;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Pattern;

public final class e
{
  private static boolean Lgw = false;
  
  private static void a(final Context paramContext, final boolean paramBoolean, final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.ui.transmit.g.a parama)
  {
    AppMethodBeat.i(278744);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext = View.inflate(paramContext, R.i.elz, null);
    Object localObject = (ImageView)paramContext.findViewById(R.h.dXF);
    if (LocaleUtil.isChineseAppLang()) {
      ((ImageView)localObject).setImageResource(R.g.todo_introduce_chinease);
    }
    for (;;)
    {
      localObject = new f((byte)0);
      paramContext.findViewById(R.h.dXI).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(289909);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
          this.XcY.XeM = true;
          locale.bYF();
          if (parama != null) {
            parama.hTM();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(289909);
        }
      });
      locale.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(287679);
          paramAnonymouso.clear();
          this.jaP.setFooterView(null);
          this.jaP.setFooterView(paramContext);
          AppMethodBeat.o(287679);
        }
      };
      locale.XbB = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(272531);
          String str;
          int j;
          if (!this.XcY.XeM)
          {
            str = paramString1;
            j = this.iWO;
            if (!paramBoolean) {
              break label56;
            }
          }
          label56:
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.chatroom.d.z.a(str, 1, j, i, 1, paramString2, paramString3);
            AppMethodBeat.o(272531);
            return;
          }
        }
      };
      locale.rn(true);
      locale.eik();
      AppMethodBeat.o(278744);
      return;
      ((ImageView)localObject).setImageResource(R.g.todo_introduce_english);
    }
  }
  
  protected static void a(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(36837);
    switch (paramb.loT)
    {
    default: 
      paramTextView.setText(R.l.app_brand_entrance);
    }
    for (;;)
    {
      paramTextView.setVisibility(0);
      AppMethodBeat.o(36837);
      return;
      paramTextView.setText(R.l.app_brand_share_wxa_testing_tag);
      continue;
      paramTextView.setText(R.l.app_brand_share_wxa_preview_tag);
    }
  }
  
  public static void a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(36838);
    px localpx = new px();
    localpx.fOD.context = parama.WQv.getContext();
    localpx.fOD.msgId = paramca.field_msgId;
    localpx.fOD.fNQ = parama.hRi();
    localpx.fOD.fOE = paramb.lmA;
    localpx.fOD.scene = 6;
    EventCenter.instance.publish(localpx);
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
      a(parama1.WQv.getContext(), Util.isNullOrNil(paramca.ilu), parama1.getTalkerUserName(), paramca.ilu, com.tencent.mm.chatroom.d.y.f(paramca), new com.tencent.mm.ui.transmit.g.a()
      {
        public final void hTM()
        {
          AppMethodBeat.i(280738);
          e.b(this.lru, parama, parama1, paramInt);
          AppMethodBeat.o(280738);
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
    boolean bool = Util.isNullOrNil(paramca.ilu);
    Activity localActivity = parama1.WQv.getContext();
    String str2 = paramca.field_talker;
    if (Util.isNullOrNil(paramca.ilu)) {}
    for (String str1 = com.tencent.mm.chatroom.d.y.d(paramca);; str1 = paramca.ilu)
    {
      com.tencent.mm.chatroom.d.y.a(localActivity, str2, str1, com.tencent.mm.chatroom.d.y.f(paramca), bool, 2, paramInt1, paramInt2, new y.a()
      {
        public final void asd()
        {
          AppMethodBeat.i(279738);
          if (!this.XcX) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.c(paramca);
            Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", new Object[] { Long.valueOf(paramca.field_msgSvrId), localPair });
            AppMethodBeat.o(279738);
            return;
          }
        }
        
        public final void ase()
        {
          AppMethodBeat.i(279739);
          if (!this.XcX) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.e(paramca);
            Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", new Object[] { Long.valueOf(paramca.field_msgSvrId), localPair });
            AppMethodBeat.o(279739);
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
    if ((parama instanceof bi.f)) {
      bi.a(paramBoolean, (bi.f)parama, parama1);
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
      paramc.Xet.setBackgroundResource(R.g.dmS);
      paramc.Xeu.setTextColor(parama.WQv.getContext().getResources().getColor(R.e.BW_100_Alpha_0_8));
      paramc.Xeu.setText(R.l.eGp);
      AppMethodBeat.o(179988);
      return;
    }
    paramc.Xet.setBackgroundResource(R.g.dmT);
    paramc.Xeu.setTextColor(parama.WQv.getContext().getResources().getColor(R.e.Brand));
    paramc.Xeu.setText(R.l.eGq);
    AppMethodBeat.o(179988);
  }
  
  public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(278745);
    com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 34L, 1L);
    Object localObject = paramb.loN;
    String str1 = paramb.loO;
    String str2 = paramb.loP;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(278745);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.lite.a.a.class)).aMZ((String)localObject);
    if ((WeChatEnvironment.isCoolassistEnv()) || (bool)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.lite.b.f.eLH();
      paramb = com.tencent.mm.plugin.lite.b.f.cY((String)localObject);
      int j = i;
      if (i != 0)
      {
        j = i;
        if (paramb == null)
        {
          com.tencent.mm.plugin.lite.b.f.eLH();
          if (com.tencent.mm.plugin.lite.b.f.eLJ() == null) {
            com.tencent.mm.plugin.lite.b.f.eLH().eLK();
          }
          com.tencent.mm.plugin.lite.b.f.eLH().a((String)localObject, null);
          j = 0;
        }
      }
      if (j != 0) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 84L, 1L);
      AppMethodBeat.o(278745);
      return false;
    }
    com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 83L, 1L);
    paramb = new Bundle();
    paramb.putString("appId", (String)localObject);
    if (!Util.isNullOrNil(str1)) {
      paramb.putString("path", str1);
    }
    if (!Util.isNullOrNil(str2)) {
      paramb.putString("query", str2);
    }
    localObject = parama.WQv.getContext();
    parama.WQv.getContext().getString(R.l.app_tip);
    localObject = com.tencent.mm.ui.base.h.a((Context)localObject, parama.WQv.getContext().getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.lite.a.a.class)).a(parama.WQv.getContext(), paramb, false, new e.8((s)localObject, parama));
    AppMethodBeat.o(278745);
    return true;
  }
  
  public static boolean a(k.b paramb, c paramc)
  {
    AppMethodBeat.i(278743);
    if (l(paramb))
    {
      paramc.Xdm.setVisibility(0);
      paramc.wRL.setVisibility(0);
      paramc.wRL.setText(R.l.top_story_chatting_app_msg_brand_name);
      paramc.Xdj.setVisibility(0);
      paramc.Xdj.setImageResource(R.g.dpp);
      AppMethodBeat.o(278743);
      return true;
    }
    AppMethodBeat.o(278743);
    return false;
  }
  
  public static boolean a(ca paramca, k.b paramb, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(179986);
    if (!com.tencent.mm.chatroom.d.y.asb())
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
    if (cm.bfD() - paramca.field_createTime >= com.tencent.mm.chatroom.storage.d.iXF.longValue())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (ab.PW(parama.getTalkerUserName()))
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
    paramb = (aj)paramb.ar(aj.class);
    if ((paramb != null) && (!Util.isNullOrNil(paramb.PyQ)))
    {
      AppMethodBeat.o(36839);
      return true;
    }
    AppMethodBeat.o(36839);
    return false;
  }
  
  public static int m(k.b paramb)
  {
    AppMethodBeat.i(278746);
    if ((paramb.type == 3) && (!com.tencent.mm.plugin.music.model.m.asG(paramb.appId)) && (com.tencent.mm.plugin.music.model.m.cPi()))
    {
      AppMethodBeat.o(278746);
      return 5;
    }
    int i = paramb.type;
    AppMethodBeat.o(278746);
    return i;
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
      if (parama.hRi()) {
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
        if (ab.Qm(str)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
  }
  
  static final class b
  {
    private static HashSet<String> Xdd;
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, ca paramca, String paramString)
    {
      AppMethodBeat.i(36756);
      a(parama, paramca, paramString, -1, null);
      AppMethodBeat.o(36756);
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, final ca paramca, String paramString, final int paramInt, final com.tencent.mm.by.c.a parama1)
    {
      AppMethodBeat.i(276846);
      Object localObject1 = bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend);
      final Intent localIntent = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      if (localObject1 != null) {
        localIntent.putExtra("Retr_Msg_content_bytes", ((String)localObject1).getBytes());
      }
      localIntent.putExtra("Retr_MsgFromScene", 2);
      localObject1 = k.b.OQ((String)localObject1);
      if ((localObject1 != null) && (19 == ((k.b)localObject1).type)) {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_Msg_Id", paramca.field_msgId);
        if ((localObject1 != null) && (((k.b)localObject1).type == 6)) {
          break label554;
        }
        parama.a(localIntent, paramInt, parama1);
        AppMethodBeat.o(276846);
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
        ((aa)localObject2).lqv = ((k.b)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
      }
      localIntent.putExtra("Retr_Msg_Type", 2);
      Object localObject2 = paramca.field_talker;
      Object localObject3 = ad.Rp(paramca.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = ad.beh().I((String)localObject3, true);
      ((ad.b)localObject3).k("prePublishId", "msg_" + paramca.field_msgSvrId);
      ((ad.b)localObject3).k("preUsername", paramString);
      ((ad.b)localObject3).k("preChatName", localObject2);
      if ((localObject1 != null) && (((k.b)localObject1).ar(com.tencent.mm.aj.a.class) != null))
      {
        ((ad.b)localObject3).k("appservicetype", Integer.valueOf(((com.tencent.mm.aj.a)((k.b)localObject1).ar(com.tencent.mm.aj.a.class)).lkb));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.aj.a)((k.b)localObject1).ar(com.tencent.mm.aj.a.class)).lkb);
      }
      if ((localObject1 != null) && (33 == ((k.b)localObject1).type))
      {
        if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.WQv.getContext()))
        {
          AppMethodBeat.o(276846);
          return;
        }
        if (!parama.hRi()) {
          break label530;
        }
        ((ad.b)localObject3).k("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", paramca.field_talker);
        ((ad.b)localObject3).k("sendAppMsgScene", Integer.valueOf(1));
        ((com.tencent.mm.plugin.sns.b.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sns.b.k.class)).a("adExtStr", (ad.b)localObject3, paramca);
        break;
        label530:
        ((ad.b)localObject3).k("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      label554:
      long l;
      if (((k.b)localObject1).type == 6)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1203L, 7L, 1L, false);
        l = paramca.field_msgSvrId;
        localObject2 = (com.tencent.mm.aj.a.b)((k.b)localObject1).ar(com.tencent.mm.aj.a.b.class);
        if ((localObject2 == null) || (((com.tencent.mm.aj.a.b)localObject2).lqB == 0L)) {
          break label1321;
        }
        l = ((com.tencent.mm.aj.a.b)localObject2).lqB;
      }
      label1029:
      label1321:
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        localObject3 = ((k.b)localObject1).lml;
        int i;
        if (((k.b)localObject1).lmb == 1)
        {
          i = 7;
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((k.b)localObject1).llX), Integer.valueOf(2), Long.valueOf((cm.bfD() - paramca.field_createTime) / 1000L), ((k.b)localObject1).llY, paramca.field_talker, Integer.valueOf(1), "", Long.valueOf(l), Long.valueOf(paramca.field_createTime), Long.valueOf(cm.bfC()), Integer.valueOf(1) });
          if ((((k.b)localObject1).lmb == 0) && (((k.b)localObject1).llX <= 26214400)) {
            break label880;
          }
        }
        label880:
        for (boolean bool = true;; bool = false)
        {
          localIntent.putExtra("Retr_Big_File", bool);
          localObject2 = com.tencent.mm.pluginsdk.model.app.m.bqf(((k.b)localObject1).fvr);
          if (localObject2 == null) {
            break label1029;
          }
          localObject3 = new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
          if ((!((com.tencent.mm.vfs.q)localObject3).ifE()) || (((com.tencent.mm.vfs.q)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen)) {
            break label886;
          }
          parama.a(localIntent, paramInt, parama1);
          AppMethodBeat.o(276846);
          return;
          i = 5;
          break;
        }
        label886:
        if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset > 0L) && (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen > ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset))
        {
          paramString = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          if ((paramca.Ic()) || (j(paramca, paramString)))
          {
            Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
            com.tencent.mm.ui.base.h.d(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.eEK), parama.WQv.getContext().getString(R.l.app_tip), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
          }
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              com.tencent.mm.ui.base.h.c(parama.WQv.getContext(), parama.WQv.getMMResources().getString(R.l.eAt), "", true);
            }
            AppMethodBeat.o(276846);
            return;
          }
        }
        Log.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((k.b)localObject1).llX), ((k.b)localObject1).lml, Util.secPrint(((k.b)localObject1).aesKey) });
        if (!bool)
        {
          a(parama, localIntent, paramca, paramInt, parama1);
          AppMethodBeat.o(276846);
          return;
        }
        localIntent.putExtra("Retr_Big_File", bool);
        localObject3 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject3).taskName = "task_ChattingItemAppMsg";
        ((com.tencent.mm.i.g)localObject3).iUG = new com.tencent.mm.i.g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
          {
            boolean bool2 = true;
            AppMethodBeat.i(36753);
            boolean bool1;
            if (paramAnonymousc != null)
            {
              bool1 = true;
              if (paramAnonymousd == null) {
                break label122;
              }
              label20:
              Log.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousd != null)
              {
                if (!paramAnonymousd.field_exist_whencheck) {
                  break label128;
                }
                this.QWD.a(localIntent, paramInt, parama1);
              }
            }
            for (;;)
            {
              AppMethodBeat.o(36753);
              return 0;
              bool1 = false;
              break;
              label122:
              bool2 = false;
              break label20;
              label128:
              if ((paramca.Ic()) || ((this.WzU != null) && (e.b.j(paramca, this.WzU.field_fileFullPath)))) {
                com.tencent.e.h.ZvG.bc(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179946);
                    Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                    com.tencent.mm.ui.base.h.d(e.b.1.this.QWD.WQv.getContext(), e.b.1.this.QWD.WQv.getContext().getString(R.l.eEK), e.b.1.this.QWD.WQv.getContext().getString(R.l.app_tip), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                    });
                    AppMethodBeat.o(179946);
                  }
                });
              } else {
                com.tencent.e.h.ZvG.bc(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179947);
                    com.tencent.mm.ui.base.h.c(e.b.1.this.QWD.WQv.getContext(), e.b.1.this.QWD.WQv.getMMResources().getString(R.l.eAt), "", true);
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
        ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.aq.c.a("checkExist", Util.nowMilliSecond(), paramString, paramca.field_msgId);
        ((com.tencent.mm.i.g)localObject3).field_fileId = ((k.b)localObject1).lml;
        ((com.tencent.mm.i.g)localObject3).field_aesKey = ((k.b)localObject1).aesKey;
        ((com.tencent.mm.i.g)localObject3).field_filemd5 = ((k.b)localObject1).filemd5;
        ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.iTW;
        ((com.tencent.mm.i.g)localObject3).field_talker = paramString;
        ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.iTU;
        ((com.tencent.mm.i.g)localObject3).field_svr_signature = "";
        ((com.tencent.mm.i.g)localObject3).field_onlycheckexist = true;
        bool = com.tencent.mm.aq.f.bkg().f((com.tencent.mm.i.g)localObject3);
        Log.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.i.g)localObject3).field_fileId, ((com.tencent.mm.i.g)localObject3).field_mediaId, Util.secPrint(((com.tencent.mm.i.g)localObject3).field_aesKey) });
        if (!bool) {
          a(parama, localIntent, paramca, paramInt, parama1);
        }
        AppMethodBeat.o(276846);
        return;
      }
    }
    
    static boolean a(Context paramContext, k.b paramb)
    {
      AppMethodBeat.i(276842);
      if ((paramb == null) || (paramContext == null))
      {
        AppMethodBeat.o(276842);
        return false;
      }
      boolean bool;
      if (e.m(paramb) == 3)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.u(paramContext, 16L);
        AppMethodBeat.o(276842);
        return bool;
      }
      if (paramb.type == 4)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.u(paramContext, 8L);
        AppMethodBeat.o(276842);
        return bool;
      }
      if (paramb.type == 5)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.u(paramContext, 32L);
        AppMethodBeat.o(276842);
        return bool;
      }
      if (paramb.type == 6)
      {
        paramb = com.tencent.mm.pluginsdk.e.a.boU(paramb.llY);
        if (paramb == null)
        {
          AppMethodBeat.o(276842);
          return false;
        }
        bool = com.tencent.mm.pluginsdk.model.app.h.u(paramContext, paramb.longValue());
        AppMethodBeat.o(276842);
        return bool;
      }
      AppMethodBeat.o(276842);
      return false;
    }
    
    private static boolean a(com.tencent.mm.ui.chatting.e.a parama, Intent paramIntent, ca paramca, int paramInt, com.tencent.mm.by.c.a parama1)
    {
      AppMethodBeat.i(276847);
      if ((paramca.Ic()) || (j(paramca, null)))
      {
        Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.h.d(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.eEK), parama.WQv.getContext().getString(R.l.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(276847);
        return true;
      }
      parama.a(paramIntent, paramInt, parama1);
      AppMethodBeat.o(276847);
      return false;
    }
    
    static boolean bzG(String paramString)
    {
      AppMethodBeat.i(36755);
      boolean bool = Util.isImageExt(paramString);
      AppMethodBeat.o(36755);
      return bool;
    }
    
    static boolean bzH(String paramString)
    {
      AppMethodBeat.i(276844);
      if (Xdd == null)
      {
        HashSet localHashSet = new HashSet();
        Xdd = localHashSet;
        localHashSet.add("h264");
        Xdd.add("h26l");
        Xdd.add("264");
        Xdd.add("avc");
        Xdd.add("mov");
        Xdd.add("mp4");
        Xdd.add("m4a");
        Xdd.add("3gp");
        Xdd.add("3g2");
        Xdd.add("mj2");
        Xdd.add("m4v");
        Xdd.add("swf");
        Xdd.add("vob");
        Xdd.add("mpg");
        Xdd.add("rmvb");
      }
      boolean bool = Xdd.contains(paramString);
      AppMethodBeat.o(276844);
      return bool;
    }
    
    public static boolean bzI(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(36759);
      Object localObject = com.tencent.mm.ay.q.bmh().d(paramString, false, true);
      if (!u.agG((String)localObject))
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
    
    public static boolean j(ca paramca, String paramString)
    {
      AppMethodBeat.i(36758);
      if ((System.currentTimeMillis() - paramca.field_createTime > 259200000L) && ((Util.isNullOrNil(paramString)) || (!u.agG(paramString))))
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
    public static int[] wTL = { R.h.dyT, R.h.dyU, R.h.dyV, R.h.dyW, R.h.dyX };
    private ArrayList<MMImageView> KIu;
    protected LinearLayout XdA;
    protected RelativeLayout XdB;
    protected FrameLayout XdC;
    protected LinearLayout XdD;
    protected LinearLayout XdE;
    protected ViewStub XdF;
    protected ImageView XdG;
    protected ImageView XdH;
    ImageView XdI;
    protected LinearLayout XdJ;
    protected ImageView XdK;
    protected TextView XdL;
    protected ImageView XdM;
    protected TextView XdN;
    protected TextView XdO;
    protected LinearLayout XdP;
    protected ImageView XdQ;
    protected ImageView XdR;
    protected ImageView XdS;
    protected TextView XdT;
    protected LinearLayout XdU;
    protected ImageView XdV;
    LinearLayout XdW;
    TextView XdX;
    TextView XdY;
    ImageView XdZ;
    protected MMImageView Xdh;
    protected MMNeat7extView Xdi;
    protected ImageView Xdj;
    protected ImageView Xdk;
    protected TextView Xdl;
    protected LinearLayout Xdm;
    protected TextView Xdn;
    protected ImageView Xdo;
    protected MMPinProgressBtn Xdp;
    protected ImageView Xdq;
    protected ImageView Xdr;
    protected ImageView Xds;
    protected ImageView Xdt;
    protected TextView Xdu;
    protected ChattingItemFooter Xdv;
    protected ImageView Xdw;
    protected LinearLayout Xdx;
    protected ViewGroup Xdy;
    protected TextView Xdz;
    ImageView Xea;
    ImageView Xeb;
    TextView Xec;
    ImageView Xed;
    LinearLayout Xee;
    MMNeat7extView Xef;
    ImageView Xeg;
    ImageView Xeh;
    ImageView Xei;
    TextView Xej;
    TextView Xek;
    TextView Xel;
    LinearLayout Xem;
    LinearLayout Xen;
    ImageView Xeo;
    TextView Xep;
    TextView Xeq;
    ImageView Xer;
    RelativeLayout Xes;
    LinearLayout Xet;
    TextView Xeu;
    public int Xev;
    private int Xew;
    protected TextView mrM;
    protected ImageView olN;
    protected TextView wRL;
    
    c()
    {
      AppMethodBeat.i(36762);
      this.Xev = 0;
      this.Xew = 2147483647;
      this.KIu = new ArrayList();
      AppMethodBeat.o(36762);
    }
    
    private static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt, String paramString)
    {
      AppMethodBeat.i(291139);
      int i = 0;
      while (i <= 4)
      {
        localObject1 = (MMImageView)paramc.XdE.findViewById(wTL[i]);
        if (localObject1 != null)
        {
          ((MMImageView)localObject1).setImageDrawable(null);
          ((MMImageView)localObject1).setVisibility(8);
        }
        i += 1;
      }
      Object localObject1 = (ImageView)paramc.XdE.findViewById(R.h.dyY);
      Object localObject2 = (TextView)paramc.XdE.findViewById(R.h.dyS);
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(8);
      }
      i = 0;
      if (i < paramInt)
      {
        label153:
        Object localObject3;
        if (paramInt == 1)
        {
          localObject1 = (MMImageView)paramc.XdE.findViewById(wTL[i]);
          ((MMImageView)localObject1).setImageResource(R.k.chatting_note_default_img_one);
          ((MMImageView)localObject1).setVisibility(0);
          localObject2 = com.tencent.mm.ay.q.bmh().r("Note_" + paramArrayOfString1[i], "", "");
          localObject3 = new com.tencent.mm.ay.a.a.c.a();
          ((com.tencent.mm.ay.a.a.c.a)localObject3).lRG = 1;
          ((com.tencent.mm.ay.a.a.c.a)localObject3).lRX = true;
          ((com.tencent.mm.ay.a.a.c.a)localObject3).lRS = R.k.chatting_note_default_img;
          ((com.tencent.mm.ay.a.a.c.a)localObject3).kOf = ((int)parama.WQv.getMMResources().getDimension(R.f.ChatItemThumWidth));
          ((com.tencent.mm.ay.a.a.c.a)localObject3).kOg = ((int)parama.WQv.getMMResources().getDimension(R.f.ChatItemThumWidth));
          localObject3 = ((com.tencent.mm.ay.a.a.c.a)localObject3).bmL();
          if (!u.agG((String)localObject2)) {
            break label333;
          }
          com.tencent.mm.ay.q.bml().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.ay.a.a.c)localObject3);
        }
        label333:
        long l;
        String str1;
        String str2;
        String str3;
        do
        {
          Log.i("MicroMsg.AppMsgViewHolder", "note get thumb");
          i += 1;
          break;
          localObject1 = (MMImageView)paramc.XdE.findViewById(wTL[(i + 1)]);
          ((MMImageView)localObject1).setImageResource(R.k.chatting_note_default_img);
          break label153;
          localObject1 = com.tencent.mm.pluginsdk.model.app.ao.hhG();
          localObject2 = (com.tencent.mm.pluginsdk.model.app.k.a)parama.bC(com.tencent.mm.ui.chatting.d.b.k.class);
          localObject3 = paramArrayOfString1[i];
          l = Util.nowMilliSecond();
          str1 = paramArrayOfString2[i];
          str2 = paramArrayOfString3[i];
          j = paramArrayOfInt[i];
          str3 = com.tencent.mm.ay.q.bmh().r("Note_".concat(String.valueOf(localObject3)), "", "");
        } while (u.agG(str3));
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.taskName = "task_AppMessageExtension_2";
        localg.field_mediaId = com.tencent.mm.aq.c.a("downappthumb", l, paramString, String.valueOf(localObject3));
        localg.field_fullpath = str3;
        localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        localg.field_totalLen = j;
        localg.field_aesKey = str1;
        localg.field_fileId = str2;
        localg.field_priority = com.tencent.mm.i.a.iTV;
        if (ab.Lj(paramString)) {}
        for (int j = 1;; j = 0)
        {
          localg.field_chattype = j;
          Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString });
          localg.iUG = new k.2((com.tencent.mm.pluginsdk.model.app.k)localObject1, (com.tencent.mm.pluginsdk.model.app.k.a)localObject2, str2);
          com.tencent.mm.aq.f.bkg().b(localg, -1);
          break;
        }
      }
      AppMethodBeat.o(291139);
    }
    
    @SuppressLint({"ResourceType"})
    public static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb)
    {
      AppMethodBeat.i(291140);
      parama = paramb.z(parama.WQv.getContext(), false);
      if (!Util.isNullOrNil(parama))
      {
        paramc.Xdm.setVisibility(0);
        paramc.wRL.setVisibility(0);
        paramc.Xdj.setVisibility(0);
        paramc.wRL.setText(parama);
        if (com.tencent.mm.aj.k.a.llQ.ordinal() == paramb.loH)
        {
          paramc.Xdj.setImageResource(R.k.my_life_around_default_icon);
          AppMethodBeat.o(291140);
          return;
        }
        if ((com.tencent.mm.aj.k.a.llR.ordinal() == paramb.loH) || (!Util.isNullOrNil(paramb.loL))) {
          if (!Util.isNullOrNil(paramb.loL)) {
            break label148;
          }
        }
      }
      label148:
      for (parama = paramb.loV;; parama = paramb.loL)
      {
        com.tencent.mm.ay.q.bmk().a(parama, new r.a()
        {
          public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(291040);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(266870);
                e.c.3.this.Xez.Xdj.setImageBitmap(paramAnonymousBitmap);
                AppMethodBeat.o(266870);
              }
            });
            AppMethodBeat.o(291040);
          }
        });
        AppMethodBeat.o(291140);
        return;
      }
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, ca paramca, boolean paramBoolean)
    {
      AppMethodBeat.i(36768);
      Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.sKW;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.G(paramb.url, 5, "");
      paramc.XdD.setVisibility(8);
      paramc.Xee.setVisibility(0);
      paramc.Xen.setVisibility(0);
      int i;
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        paramc.Xef.setMaxLines(2);
        paramc.Xef.setVisibility(0);
        paramc.Xef.aL(paramb.getTitle());
        localObject = (com.tencent.mm.aj.e)paramb.ar(com.tencent.mm.aj.e.class);
        if (localObject == null) {
          break label479;
        }
        i = ((com.tencent.mm.aj.e)localObject).duration;
        label114:
        String str = com.tencent.mm.aj.m.uD(i);
        if (Util.isNullOrNil(str)) {
          break label485;
        }
        paramc.Xek.setVisibility(0);
        paramc.Xek.setText(str);
      }
      for (;;)
      {
        paramc.Xei.setVisibility(0);
        if ((localObject != null) && (x.uE(((com.tencent.mm.aj.e)localObject).llt)))
        {
          paramc.Xek.setVisibility(8);
          paramc.Xei.setVisibility(8);
        }
        ao.a(parama.WQv.getContext(), paramb, paramc.Xeh, paramc.Xej);
        ao.b(paramc.Xel, paramb);
        paramc.Xdo.setVisibility(4);
        i = com.tencent.mm.ci.a.aY(parama.WQv.getContext(), R.f.chatting_normal_item_width) - com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 24);
        int j = i * 9 / 16;
        if (com.tencent.mm.ci.a.ez(parama.WQv.getContext()) > 1.0F)
        {
          int k = (int)((paramc.Xev / com.tencent.mm.cj.a.hrd() - com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 29) * com.tencent.mm.ci.a.ez(parama.WQv.getContext())) * 9.0F / 16.0F);
          if (paramc.Xes.getLayoutParams().height != k)
          {
            paramc.Xes.getLayoutParams().height = k;
            paramc.Xes.requestLayout();
          }
        }
        if ((!paramBoolean) && (Util.isNullOrNil(paramb.thumburl))) {
          break label497;
        }
        parama = com.tencent.mm.api.b.M(paramb.thumburl, 4);
        paramb = new com.tencent.mm.ay.a.a.c.a();
        paramb.lRP = R.e.chatting_item_biz_default_bg;
        paramb.lRC = true;
        paramb.fullPath = com.tencent.mm.pluginsdk.model.w.bpO(parama);
        paramca = paramb.dO(i, j);
        paramca.lRs = new com.tencent.mm.pluginsdk.ui.applet.n(4);
        paramca.lSb = new com.tencent.mm.pluginsdk.ui.applet.e(4);
        paramca.lRB = true;
        com.tencent.mm.ay.q.bml().a(parama, paramc.Xeg, paramb.bmL());
        AppMethodBeat.o(36768);
        return;
        paramc.Xef.setVisibility(8);
        break;
        label479:
        i = 0;
        break label114;
        label485:
        paramc.Xek.setVisibility(8);
      }
      label497:
      paramb = null;
      if (!e.b.bzI(paramca.field_imgPath)) {
        paramb = com.tencent.mm.ay.q.bmh().a(paramca.field_imgPath, com.tencent.mm.ci.a.getDensity(parama.WQv.getContext()), false);
      }
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        paramc.Xeg.setImageBitmap(paramb);
        AppMethodBeat.o(36768);
        return;
      }
      paramc.Xeg.setImageResource(R.e.chatting_item_biz_default_bg);
      AppMethodBeat.o(36768);
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(36767);
      paramc.Xdi.setVisibility(8);
      String str;
      Object localObject1;
      Object localObject3;
      label221:
      Object localObject2;
      int i;
      if ((paramb.title != null) && (paramb.title.trim().length() > 0))
      {
        str = paramb.title;
        paramc.Xdn.setVisibility(0);
        paramc.Xdn.setMaxLines(2);
        paramc.mrM.setMaxLines(4);
        paramc.Xdt.setVisibility(8);
        paramc.Xdo.setVisibility(4);
        if (paramBoolean) {
          paramc.Xdh.setVisibility(8);
        }
        localObject1 = new sc();
        ((sc)localObject1).fRw.type = 0;
        ((sc)localObject1).fRw.fRy = paramb.lmA;
        EventCenter.instance.publish((IEvent)localObject1);
        localObject3 = ((sc)localObject1).fRx.fRG;
        if (localObject3 == null) {
          break label1112;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(paramc.Xdn.getContext(), Util.nullAs(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.Xdn.getTextSize());
        paramc.Xdn.setText((CharSequence)localObject1);
        localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
        if (localObject1 != null) {
          break label542;
        }
        Log.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.lmA });
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 100) {
            localObject2 = ((String)localObject1).substring(0, 100);
          }
        }
        paramc.mrM.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramc.mrM.getContext(), Util.nullAs((String)localObject2, paramb.description), paramc.mrM.getTextSize()));
        paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).lpz.iterator();
        i = 0;
        localObject2 = null;
        localObject1 = null;
        label305:
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject3 = (anm)paramb.next();
        } while ((com.tencent.mm.plugin.fav.ui.l.j((anm)localObject3)) && (!Util.isNullOrNil(((anm)localObject3).SyO)) && (((anm)localObject3).SyO.equals("WeNoteHtmlFile")));
        if (((anm)localObject3).SyG.Szn.SAb == null) {
          break label567;
        }
        str = parama.WQv.getContext().getString(R.l.record_chatroom_title);
        i = 1;
        label390:
        switch (((anm)localObject3).dataType)
        {
        }
      }
      for (;;)
      {
        break label305;
        paramc.Xdn.setVisibility(8);
        str = null;
        break;
        label542:
        localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        break label221;
        label567:
        if (((anm)localObject3).SyG.Szn.fLi == null) {
          break label1109;
        }
        if (localObject1 == null)
        {
          localObject1 = ((anm)localObject3).SyI;
          break label390;
        }
        if (localObject1 == ((anm)localObject3).SyI) {
          break label1109;
        }
        localObject2 = ((anm)localObject3).SyI;
        break label390;
        if (paramBoolean)
        {
          paramc.Xdh.setVisibility(0);
          paramc.Xdh.setImageResource(R.k.app_attach_file_icon_voice);
        }
        break label305;
        break label305;
        if (paramBoolean)
        {
          paramc.Xdh.setVisibility(0);
          paramc.Xdh.setImageResource(R.g.app_attach_file_icon_pic);
        }
        break label305;
        if (paramBoolean)
        {
          paramc.Xdh.setVisibility(0);
          paramc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
        }
        break label305;
        if ((paramBoolean) && (!com.tencent.mm.plugin.fav.a.b.djw()))
        {
          paramc.Xdh.setVisibility(0);
          paramc.Xdh.setImageResource(R.k.icons_outlined_finder_icon);
          break label305;
          if (paramBoolean)
          {
            paramc.Xdh.setVisibility(0);
            paramc.Xdh.setImageResource(R.k.app_attach_file_icon_video);
          }
          paramc.Xdt.setVisibility(0);
          paramc.Xdt.setImageResource(R.g.video_download_btn);
          break label305;
          paramc.Xdh.setVisibility(0);
          paramc.Xdh.setImageResource(R.k.app_attach_file_icon_location);
          break label305;
          if (paramBoolean)
          {
            paramc.Xdh.setVisibility(0);
            paramc.Xdh.setImageResource(R.k.app_attach_file_icon_music);
          }
          paramc.Xdt.setVisibility(0);
          paramc.Xdt.setImageResource(R.g.music_playicon);
          break label305;
          if (paramBoolean)
          {
            paramc.Xdh.setVisibility(0);
            paramc.Xdh.setImageResource(R.k.app_attach_file_icon_music);
          }
          paramc.Xdt.setVisibility(0);
          paramc.Xdt.setImageResource(R.g.music_playicon);
          break label305;
          if (paramBoolean)
          {
            paramc.Xdh.setVisibility(0);
            paramc.Xdh.setImageResource(com.tencent.mm.pluginsdk.f.boX(((anm)localObject3).Syc));
          }
          break label305;
          if (paramBoolean)
          {
            paramc.Xdh.setVisibility(0);
            paramc.Xdh.setImageResource(R.k.app_attach_file_icon_unknow);
          }
          break label305;
          if (paramBoolean)
          {
            paramc.Xdh.setVisibility(0);
            paramc.Xdh.setImageResource(R.g.default_avatar);
          }
        }
      }
      if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
        paramb = parama.WQv.getContext().getString(R.l.favorite_record_chatroom_title, new Object[] { localObject1 });
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramb))
        {
          paramc.Xdn.setText(paramb);
          paramc.Xdn.setVisibility(0);
        }
        paramc.Xdh.setVisibility(8);
        paramc.XdB.setVisibility(8);
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
                paramb = parama.WQv.getContext().getString(R.l.favorite_record_chat_title, new Object[] { localObject1, localObject2 });
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
    
    public static void a(c paramc, Boolean paramBoolean, ca paramca, String paramString1, String paramString2)
    {
      AppMethodBeat.i(36766);
      long l = paramca.field_msgId;
      com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.ao.ctZ().TR(l);
      if (localc == null)
      {
        Log.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
        AppMethodBeat.o(36766);
        return;
      }
      if (paramBoolean.booleanValue()) {
        if (localc.field_status == 101L)
        {
          paramc.Xds.setVisibility(0);
          paramc.Xdp.setVisibility(0);
          paramc.Xdq.setVisibility(0);
        }
      }
      for (;;)
      {
        if (paramca.field_status == 5)
        {
          paramc.Xds.setVisibility(8);
          paramc.Xdr.setVisibility(8);
        }
        paramc.Xds.setOnClickListener(new e.c.1(paramBoolean, l, paramString1, paramString2, paramca));
        paramc.Xdr.setOnClickListener(new e.c.2(paramBoolean, l, paramString2, paramca));
        AppMethodBeat.o(36766);
        return;
        if (localc.field_status == 102L)
        {
          paramc.Xds.setVisibility(8);
          paramc.Xdp.setVisibility(8);
          paramc.Xdq.setVisibility(8);
        }
        else
        {
          paramc.Xds.setVisibility(8);
          paramc.Xdp.setVisibility(8);
          paramc.Xdq.setVisibility(8);
          continue;
          if (localc.field_status == 101L)
          {
            paramc.Xds.setVisibility(0);
            paramc.Xdr.setVisibility(8);
          }
          else if (localc.field_status == 105L)
          {
            paramc.Xds.setVisibility(8);
            paramc.Xdr.setVisibility(0);
          }
          else
          {
            paramc.Xds.setVisibility(8);
            paramc.Xdr.setVisibility(8);
          }
        }
      }
    }
    
    public static void a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(36765);
      int i = com.tencent.mm.pluginsdk.model.app.m.bqe(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        paramc.Xdp.setVisibility(8);
        paramc.Xdq.setVisibility(8);
        AppMethodBeat.o(36765);
        return;
      }
      paramc.Xdp.setVisibility(0);
      paramc.Xdq.setVisibility(0);
      paramc.Xdp.setProgress(i);
      AppMethodBeat.o(36765);
    }
    
    static void b(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, ca paramca, boolean paramBoolean)
    {
      AppMethodBeat.i(36769);
      Object localObject1 = new sc();
      ((sc)localObject1).fRw.type = 0;
      ((sc)localObject1).fRw.fRy = paramb.lmA;
      EventCenter.instance.publish((IEvent)localObject1);
      Object localObject2 = ((sc)localObject1).fRx.fRG;
      paramc.XdB.setVisibility(8);
      String[] arrayOfString1 = new String[4];
      String[] arrayOfString2 = new String[4];
      int[] arrayOfInt = new int[4];
      Object localObject3 = new String[4];
      String[] arrayOfString4 = new String[4];
      Object localObject4 = new int[4];
      String[] arrayOfString3 = new String[4];
      int k;
      int i;
      anm localanm;
      if (localObject2 != null)
      {
        localObject1 = null;
        paramb = Util.nullAs(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
        k = 0;
        Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject2).lpz.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localanm = (anm)localIterator.next();
          if ((!com.tencent.mm.plugin.fav.ui.l.j(localanm)) || (Util.isNullOrNil(localanm.SyO)) || (!localanm.SyO.equals("WeNoteHtmlFile"))) {
            switch (localanm.dataType)
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
                str = localanm.desc;
              } while (Util.isNullOrNil(str));
              if (Util.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label1207;
              }
              localObject1 = localanm.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
          }
        }
      }
      label791:
      label1198:
      label1201:
      label1207:
      for (;;)
      {
        k = 1;
        break;
        if (paramBoolean)
        {
          paramc.XdB.setVisibility(0);
          paramc.Xdh.setVisibility(0);
          paramc.Xdh.setImageResource(R.g.app_attach_file_icon_pic);
        }
        if (i < 4)
        {
          arrayOfString1[i] = localanm.lmm;
          arrayOfString2[i] = localanm.SxK;
          arrayOfInt[i] = ((int)localanm.Sys);
          localObject3[i] = localanm.Rwb;
          arrayOfString4[i] = localanm.SxP;
          localObject4[i] = ((int)localanm.Syi);
          arrayOfString3[i] = localanm.fEa;
        }
        i += 1;
        break;
        if (!Util.isNullOrNil(paramb)) {
          break label248;
        }
        paramb = MMApplicationContext.getContext().getString(R.l.app_file) + localanm.title;
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
            break label1201;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).lpz.size() == 2))
          {
            localObject2 = MMApplicationContext.getContext().getString(R.l.favorite_wenote);
            paramb = (k.b)localObject1;
            localObject1 = localObject2;
            localObject1 = ((String)localObject1).trim();
            label616:
            if (localObject1 == null) {
              break label1198;
            }
            localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.pluginsdk.ui.span.l.d(paramc.Xdn.getContext(), (CharSequence)localObject1, (int)paramc.Xdn.getTextSize());
            paramc.Xdn.setText((CharSequence)localObject1);
            if ((paramb != null) && (paramb.length() > 100)) {
              paramb = paramb.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            for (;;)
            {
              for (;;)
              {
                localObject1 = com.tencent.mm.pluginsdk.ui.span.l.d(paramc.mrM.getContext(), paramb, (int)paramc.mrM.getTextSize());
                paramc.mrM.setText((CharSequence)localObject1);
                if (i > 0)
                {
                  paramc.XdB.setVisibility(8);
                  if ((j != 0) || (k == 0) || (Util.isNullOrNil(paramb)))
                  {
                    paramc.mrM.setVisibility(8);
                    paramc.Xdn.setMaxLines(2);
                    paramc.XdG.setVisibility(8);
                    paramc.XdF.setLayoutResource(R.i.edA);
                  }
                  try
                  {
                    if (paramc.XdE == null) {
                      paramc.XdE = ((LinearLayout)paramc.XdF.inflate());
                    }
                    for (;;)
                    {
                      if (i <= 4) {
                        break label1164;
                      }
                      j = 4;
                      a(parama, paramc, j, arrayOfString3, arrayOfString2, arrayOfString1, arrayOfInt, paramca.field_talker);
                      parama = (ImageView)paramc.XdE.findViewById(R.h.dyY);
                      paramc = (TextView)paramc.XdE.findViewById(R.h.dyS);
                      if (paramc != null) {
                        paramc.setTextSize(0, MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding));
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
                      localObject1 = MMApplicationContext.getContext().getString(R.l.favorite_wenote);
                      j = 0;
                      break label616;
                      paramc.mrM.setMaxLines(1);
                      paramc.mrM.setVisibility(0);
                      paramc.Xdn.setMaxLines(1);
                      break label791;
                      paramc.XdE.setVisibility(0);
                    }
                  }
                  catch (Exception paramb)
                  {
                    for (;;)
                    {
                      paramc.XdF.setVisibility(0);
                      continue;
                      j = i;
                    }
                  }
                }
              }
              paramc.XdF.setVisibility(8);
              paramc.XdG.setVisibility(0);
              AppMethodBeat.o(36769);
              return;
            }
          }
        }
      }
    }
    
    public final c I(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(36763);
      super.create(paramView);
      this.XdU = ((LinearLayout)paramView.findViewById(R.h.dwg));
      this.Xdh = ((MMImageView)paramView.findViewById(R.h.dwL));
      this.Xdi = ((MMNeat7extView)paramView.findViewById(R.h.dwN));
      this.Xdn = ((TextView)paramView.findViewById(R.h.dwQ));
      this.mrM = ((TextView)paramView.findViewById(R.h.dwq));
      this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
      this.Xdj = ((ImageView)paramView.findViewById(R.h.dwF));
      this.Xdl = ((TextView)paramView.findViewById(R.h.dwH));
      this.Xdk = ((ImageView)paramView.findViewById(R.h.dwG));
      this.Xdm = ((LinearLayout)paramView.findViewById(R.h.dwE));
      this.Xdo = ((ImageView)paramView.findViewById(R.h.dwJ));
      this.Xdp = ((MMPinProgressBtn)paramView.findViewById(R.h.dxt));
      this.Xdq = ((ImageView)this.convertView.findViewById(R.h.dxs));
      this.Xdr = ((ImageView)this.convertView.findViewById(R.h.dxi));
      this.Xds = ((ImageView)this.convertView.findViewById(R.h.dzr));
      this.Xdt = ((ImageView)paramView.findViewById(R.h.dws));
      this.Xdu = ((TextView)paramView.findViewById(R.h.dwm));
      this.Xdw = ((ImageView)paramView.findViewById(R.h.dwD));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.Xdv = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
      this.Xdx = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
      this.Xdy = ((ViewGroup)paramView.findViewById(R.h.dLC));
      this.Xdz = ((TextView)paramView.findViewById(R.h.dLz));
      this.XdA = ((LinearLayout)paramView.findViewById(R.h.dwR));
      this.XdC = ((FrameLayout)paramView.findViewById(R.h.chatting_click_area));
      this.XdD = ((LinearLayout)paramView.findViewById(R.h.dwn));
      this.XdH = ((ImageView)paramView.findViewById(R.h.dxg));
      this.XdB = ((RelativeLayout)paramView.findViewById(R.h.dwK));
      this.XdF = ((ViewStub)paramView.findViewById(R.h.dPX));
      this.XdG = ((ImageView)paramView.findViewById(R.h.dxl));
      if (!paramBoolean)
      {
        this.XdI = ((ImageView)this.convertView.findViewById(R.h.chatting_status_tick));
        this.uploadingPB = ((ProgressBar)this.convertView.findViewById(R.h.dYz));
      }
      this.XdP = ((LinearLayout)paramView.findViewById(R.h.dvU));
      this.XdM = ((ImageView)paramView.findViewById(R.h.dwh));
      this.XdN = ((TextView)paramView.findViewById(R.h.dwj));
      this.XdT = ((TextView)paramView.findViewById(R.h.dwf));
      this.XdS = ((ImageView)paramView.findViewById(R.h.error_icon_iv));
      this.XdQ = ((ImageView)paramView.findViewById(R.h.dvV));
      this.XdR = ((ImageView)paramView.findViewById(R.h.dvS));
      this.XdJ = ((LinearLayout)paramView.findViewById(R.h.dvT));
      this.XdK = ((ImageView)paramView.findViewById(R.h.dvw));
      this.XdL = ((TextView)paramView.findViewById(R.h.dvx));
      this.XdO = ((TextView)paramView.findViewById(R.h.dwi));
      this.olN = ((ImageView)paramView.findViewById(R.h.dvy));
      this.XdV = ((ImageView)paramView.findViewById(R.h.dvz));
      this.XdW = ((LinearLayout)paramView.findViewById(R.h.dvY));
      this.XdX = ((TextView)paramView.findViewById(R.h.dwe));
      this.XdY = ((TextView)paramView.findViewById(R.h.dwa));
      this.XdZ = ((ImageView)paramView.findViewById(R.h.dwb));
      this.Xea = ((ImageView)paramView.findViewById(R.h.dvZ));
      this.Xeb = ((ImageView)paramView.findViewById(R.h.dwc));
      this.Xec = ((TextView)paramView.findViewById(R.h.dwd));
      this.Xed = ((ImageView)paramView.findViewById(R.h.dvX));
      this.Xee = ((LinearLayout)paramView.findViewById(R.h.dwu));
      this.Xei = ((ImageView)paramView.findViewById(R.h.dwy));
      this.Xef = ((MMNeat7extView)paramView.findViewById(R.h.dwz));
      this.Xeg = ((ImageView)paramView.findViewById(R.h.dwx));
      this.Xem = ((LinearLayout)paramView.findViewById(R.h.dMQ));
      this.Xen = ((LinearLayout)paramView.findViewById(R.h.dMS));
      this.Xer = ((ImageView)paramView.findViewById(R.h.dMR));
      this.Xes = ((RelativeLayout)paramView.findViewById(R.h.dwv));
      this.Xeo = ((ImageView)this.Xem.findViewById(R.h.dwr));
      this.Xep = ((TextView)this.Xem.findViewById(R.h.dwt));
      this.Xeq = ((TextView)this.Xem.findViewById(R.h.dwC));
      this.Xeh = ((ImageView)this.Xen.findViewById(R.h.dwr));
      this.Xej = ((TextView)this.Xen.findViewById(R.h.dwt));
      this.Xel = ((TextView)this.Xen.findViewById(R.h.dwC));
      this.Xek = ((TextView)paramView.findViewById(R.h.dww));
      this.Xet = ((LinearLayout)paramView.findViewById(R.h.dwO));
      this.Xeu = ((TextView)paramView.findViewById(R.h.dwP));
      if ((this.Xdn != null) && (Build.VERSION.SDK_INT >= 16)) {
        this.Xew = this.Xdn.getMaxLines();
      }
      this.Xev = c.li(MMApplicationContext.getContext());
      AppMethodBeat.o(36763);
      return this;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(36764);
      if (this.Xdn != null) {
        this.Xdn.setMaxLines(this.Xew);
      }
      AppMethodBeat.o(36764);
    }
  }
  
  public static final class d
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    protected t.i XeB;
    protected t.l XeC;
    protected t.j XeD;
    private boolean wIg;
    
    public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36799);
      if ((com.tencent.mm.q.a.cy(parama.WQv.getContext())) || (com.tencent.mm.q.a.cw(parama.WQv.getContext())) || (com.tencent.mm.q.a.cB(parama.WQv.getContext())))
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
      String str2 = com.tencent.mm.pluginsdk.model.app.q.V(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.V(paramb.llW, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.WQv.getContext(), paramb.appId);
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
      Object localObject = com.tencent.mm.ui.tools.y.XVr;
      com.tencent.mm.ui.tools.y.hYJ();
      if ((Util.isNullOrNil(paramb.loB)) && (Util.isNullOrNil(paramb.loA)))
      {
        paramca = paramb.url;
        if (parama.hRi()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.V(paramca, paramc);
          paramca = new Intent();
          paramca.putExtra("rawUrl", paramc);
          paramca.putExtra("webpageTitle", paramb.title);
          paramca.putExtra("shortUrl", paramb.url);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
          AppMethodBeat.o(161905);
          return true;
        }
      }
      localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.hRi()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.ao.h.X(paramca));
        localBundle.putInt("chat_type", com.tencent.mm.modelappbrand.a.SF(parama.getTalkerUserName()));
        ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(parama.WQv.getContext(), parama.getTalkerUserName(), paramc.a(parama, paramca), parama.hRi(), paramb, localBundle);
        AppMethodBeat.o(161905);
        return true;
        if (ab.Qm((String)localObject)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean c(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36800);
      Object localObject1 = (com.tencent.mm.aj.a)paramb.ar(com.tencent.mm.aj.a.class);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.aj.a)localObject1).lkv)) && (!Util.isNullOrNil(((com.tencent.mm.aj.a)localObject1).lkx)))
      {
        String str2 = ((com.tencent.mm.aj.a)localObject1).lkv;
        String str3 = ((com.tencent.mm.aj.a)localObject1).lku;
        String str1;
        int i;
        if (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject1).lky))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.aj.a)localObject1).lkw;
          paramb = paramb.loB;
          localObject1 = ((com.tencent.mm.aj.a)localObject1).lkx;
          Log.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { str2, str3, str1, str4, paramb, localObject1 });
          Object localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
          if (!ab.Lj(parama.getTalkerUserName())) {
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
          str1 = ((com.tencent.mm.aj.a)localObject1).lky;
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
      Log.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.loA, paramb.loz, paramb.loB, paramb.url, Integer.valueOf(paramb.loT), paramb.loD });
      if ((44 == paramb.type) && ((!paramb.fX(false)) || (Util.isNullOrNil(paramb.z(parama.WQv.getContext(), false)))))
      {
        AppMethodBeat.o(36801);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramca);
      paramc = new Bundle();
      int i;
      if ((parama.WQv instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        paramc.putInt("stat_scene", i);
        paramc.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        paramc.putString("stat_chat_talker_username", (String)localObject);
        paramc.putString("stat_send_msg_user", str);
        i = com.tencent.mm.modelappbrand.a.SF(parama.getTalkerUserName());
        switch (paramb.loC)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.de(paramca);
        if (i != 0) {
          break label636;
        }
        AppMethodBeat.o(36801);
        return true;
        if (parama.hRi())
        {
          i = 2;
          break;
        }
        if (ab.Qm((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_username", paramb.loA);
        if (parama.hRi())
        {
          localIntent.putExtra("key_from_scene", 1);
          localIntent.putExtra("key_scene_note", (String)localObject + ":" + str);
        }
        for (;;)
        {
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.loB;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).nHY = paramb.loT;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.loE;
          localIntent.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bLN());
          localIntent.putExtra("_stat_obj", paramc);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "appbrand", ".ui.AppBrandProfileUI", localIntent);
          i = 0;
          break;
          localIntent.putExtra("key_from_scene", 2);
          localIntent.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.WQv instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.ao.h.X(paramca))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1157, paramb, paramc);
          i = 0;
        }
        else if (ab.Qm((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, paramc);
          i = 0;
        }
        else
        {
          paramc.putString("chatroom_username", e.a(parama, (String)localObject));
          paramc.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.hRi(), paramb, paramc);
          i = 0;
          continue;
          paramc.putString("chatroom_username", e.a(parama, (String)localObject));
          paramc.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.hRi(), paramb, paramc);
          i = 0;
        }
      }
      label636:
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
          paramb = com.tencent.mm.plugin.sns.data.m.kt(paramb.fLi, paramca.field_talker);
          if (!TextUtils.isEmpty(paramb)) {
            paramc.putExtra("sns_landing_pages_extra", paramb);
          }
          paramc.addFlags(268435456);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        aj localaj = (aj)paramb.ar(aj.class);
        if ((localaj != null) && (!Util.isNullOrNil(localaj.PyQ)))
        {
          paramb = new flm();
          paramb.PyQ = localaj.PyQ;
          paramb.PyR = localaj.PyR;
          paramb.PyS = localaj.PyS;
          paramb.PyT = localaj.PyT;
          paramb.PyU = localaj.PyU;
          paramb.PyY = localaj.PyY;
          paramb.vhY = localaj.vhY;
          paramb.pqW = localaj.pqW;
          paramb.CHR = localaj.CHR;
          paramb.PyV = localaj.PyV;
          paramb.PyW = localaj.PyW;
          paramb.PyX = localaj.PyX;
          paramb.source = localaj.source;
          paramb.fVx = localaj.fVx;
          paramb.PyZ = localaj.PyZ;
          paramb.Pzb = localaj.Pzb;
          paramb.Pzc = localaj.Pzc;
          paramb.Pzd = localaj.Pzd;
          paramb.Pza = localaj.Pza;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.WQv.getContext().getString(R.l.fts_recommend_search_keyword));
          com.tencent.mm.plugin.topstory.a.i.a(paramb, paramca);
          ai.a(parama.WQv.getContext(), paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject2 = paramb.url;
        Object localObject1;
        PackageInfo localPackageInfo;
        Intent localIntent;
        int j;
        if (parama.hRi())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.V((String)localObject2, (String)localObject1);
          String str = paramb.url;
          localPackageInfo = c.getPackageInfo(parama.WQv.getContext(), paramb.appId);
          localIntent = new Intent();
          j = parama.WQv.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e((String)localObject2, 1, j, i);
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
            break label1295;
          }
          localIntent.putExtra("shortUrl", str);
          label653:
          if (localPackageInfo != null) {
            break label1310;
          }
          localObject2 = null;
          label661:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1320;
          }
          i = 0;
          label680:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.fUd))
          {
            localIntent.putExtra("srcUsername", paramb.fUd);
            localIntent.putExtra("srcDisplayname", paramb.fUe);
          }
          localIntent.putExtra("msg_id", paramca.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramca));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", paramca.ilq);
          localIntent.putExtra("msgUsername", paramb.fLi);
          localIntent.putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
          i = com.tencent.mm.model.ac.aN(paramc.a(parama, paramca), parama.getTalkerUserName());
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
            paramc = (com.tencent.mm.aj.e)paramb.ar(com.tencent.mm.aj.e.class);
            if (paramc == null) {
              break;
            }
          }
        }
        for (int i = paramc.llp;; i = -1)
        {
          localIntent.putExtra(f.r.VSO, i);
          localIntent.putExtra("key_enable_teen_mode_check", true);
          e.a(paramb, parama, localIntent);
          localIntent.addFlags(536870912);
          if ((paramc == null) || (i != 5) || (paramc.llr != 1)) {
            break label1354;
          }
          paramb = new Bundle();
          paramb.putInt(f.b.VRT, 1);
          paramb.putInt(f.b.VRU, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          if ((localaj != null) && (!Util.isNullOrNil(localaj.PyQ)))
          {
            paramc = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bnh(localaj.PyQ);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d.a(parama.WQv.getContext(), paramca.field_msgId, paramca.field_msgSvrId, 0, paramb);
          AppMethodBeat.o(169872);
          return true;
          localObject1 = "singlemessage";
          break;
          label1295:
          localIntent.putExtra("shortUrl", paramb.url);
          break label653;
          label1310:
          localObject2 = localPackageInfo.versionName;
          break label661;
          label1320:
          i = localPackageInfo.versionCode;
          break label680;
          i = 2;
          break label1007;
          i = 3;
          break label1007;
          i = 5;
          break label1007;
        }
        label1354:
        c(parama, paramca);
        if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(3)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(parama.WQv.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          Log.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(169872);
        return true;
      }
      AppMethodBeat.o(169872);
      return false;
    }
    
    private t.i j(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36791);
      if (this.XeB == null) {
        this.XeB = new t.i(parama);
      }
      parama = this.XeB;
      AppMethodBeat.o(36791);
      return parama;
    }
    
    private t.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36792);
      if (this.XeC == null) {
        this.XeC = new t.l(parama);
      }
      parama = this.XeC;
      AppMethodBeat.o(36792);
      return parama;
    }
    
    private t.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36793);
      if (this.XeD == null) {
        this.XeD = new t.j(parama);
      }
      parama = this.XeD;
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
        localObject = new aq(paramLayoutInflater, R.i.ecG);
        ((View)localObject).setTag(new e.c().I((View)localObject, true));
      }
      AppMethodBeat.o(36794);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36795);
      final e.c localc = (e.c)parama;
      this.WBq = parama1;
      localc.reset();
      String str = paramca.getContent();
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).cr(paramca);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).cs(paramca);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).ct(paramca);
      int i;
      if (this.wIg)
      {
        i = paramca.getContent().indexOf(':');
        if (i != -1) {
          str = paramca.getContent().substring(i + 1);
        }
      }
      label1027:
      label2308:
      label7300:
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
          localb = k.b.aG(str, paramca.apL());
          localObject3 = t.OV(str);
          localObject1 = new by(paramca, parama1.hRi(), paramInt, null, '\000');
          i = 0;
          k = 0;
          localc.Xet.setVisibility(8);
          localObject2 = localObject1;
          if (localb != null)
          {
            localc.Xdi.aL(localb.getTitle());
            localc.mrM.setText(localb.getDescription());
            localc.Xdn.setMaxLines(1);
            localc.Xdi.setTextColor(parama1.getContext().getResources().getColor(R.e.FG_0));
            localc.mrM.setTextColor(parama1.getContext().getResources().getColor(R.e.half_alpha_black));
            localc.XdD.setBackgroundResource(R.g.chatfrom_bg_app);
            localc.XdD.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
            localc.Xdh.setVisibility(0);
            localc.XdB.setVisibility(0);
            localc.mrM.setVisibility(0);
            localc.Xdp.setVisibility(8);
            localc.Xds.setVisibility(8);
            localc.Xdr.setVisibility(8);
            localc.XdF.setVisibility(8);
            localc.XdG.setVisibility(8);
            localc.Xdk.setVisibility(8);
            localc.Xdl.setVisibility(8);
            localc.XdP.setVisibility(8);
            localc.XdJ.setVisibility(8);
            localc.XdD.setVisibility(0);
            localc.XdW.setVisibility(8);
            localc.Xee.setVisibility(8);
            localc.Xem.setVisibility(8);
            localc.Xer.setVisibility(8);
            localc.resetChatBubbleWidth(localc.XdC, localc.Xev);
            localb.ar(com.tencent.mm.aj.h.class);
            localc.XdC.setBackgroundResource(R.g.chatfrom_bg_app);
            localg = com.tencent.mm.pluginsdk.model.app.h.hn(localb.appId, localb.appVersion);
            if (localg != null) {
              b(parama1, localb, paramca);
            }
            if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
              break label1699;
            }
            localObject2 = localb.appName;
            bool1 = true;
            com.tencent.mm.ci.a.fromDPToPix(parama1.getContext(), 12);
            if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
              bool1 = o.a.hfN().fHm();
            }
            if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!gZ((String)localObject2))) {
              break label1739;
            }
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), localg, (String)localObject2);
            if (localb.type != 19) {
              break label1709;
            }
            localc.wRL.setText(parama1.getContext().getResources().getString(R.l.opensdk_source_tv_record, new Object[] { localObject2 }));
            label681:
            localc.wRL.setVisibility(0);
            localc.wRL.setCompoundDrawables(null, null, null, null);
            localc.Xdm.setVisibility(0);
            localc.Xdj.setVisibility(0);
            if ((localg == null) || (!localg.Qv())) {
              break label1722;
            }
            a(parama1, localc.wRL, paramca, localb, localg.field_packageName, paramca.apH());
            label756:
            localc.Xdj.setImageResource(R.g.dnd);
            a(parama1, localc.Xdj, localb.appId);
            i = 1;
          }
        }
        label5765:
        for (;;)
        {
          label784:
          if (localb.bbu()) {
            localc.Xdm.setVisibility(8);
          }
          label1423:
          label6927:
          label7313:
          for (int j = 0;; j = i)
          {
            localc.Xdm.setBackgroundResource(R.g.mm_trans);
            bool1 = false;
            localc.Xdh.setVisibility(0);
            if ((!localb.bbv()) && (this.tMW))
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
                      if (!e.b.bzI(paramca.apK())) {
                        localObject2 = com.tencent.mm.ay.q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                      }
                    }
                  }
                }
              }
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localBitmap = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject2, false, com.tencent.mm.ci.a.fromDPToPix(parama1.getContext(), 1));
                localc.Xdh.setImageBitmap(localBitmap);
                label977:
                if (e.m(localb) != 3) {
                  break label1934;
                }
                localc.XdD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  private boolean XeE = false;
                  
                  public final boolean onPreDraw()
                  {
                    AppMethodBeat.i(36771);
                    if (this.XeE)
                    {
                      localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                    localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.XeE = true;
                    int i = com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 24);
                    Bitmap localBitmap = this.val$bitmap;
                    Object localObject;
                    if (localBitmap != null)
                    {
                      localObject = localBitmap;
                      if (!localBitmap.isRecycled()) {}
                    }
                    else
                    {
                      localObject = BitmapUtil.createColorBitmap(parama1.WQv.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                    }
                    int j = ((Bitmap)localObject).getHeight();
                    if (i > j) {
                      i = j;
                    }
                    for (;;)
                    {
                      localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                      j = localc.XdD.getHeight();
                      int k = localc.XdD.getWidth();
                      i = j;
                      if (j == 0) {
                        i = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_height);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_width);
                      }
                      localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_from_content_bg_mask, j, i));
                      localc.XdD.setBackgroundDrawable((Drawable)localObject);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                  }
                });
                if (!ar.isDarkMode()) {
                  break label1923;
                }
                localc.Xdm.setBackgroundResource(R.g.mm_trans);
                if ((localb.ilh != null) && (localb.ilh.length() != 0)) {
                  break label1961;
                }
                localc.Xdu.setVisibility(8);
                label1056:
                localc.Xdt.setOnClickListener(null);
                localc.Xdx.setVisibility(0);
                localc.Xdo.setVisibility(8);
                localc.XdA.setVisibility(0);
                localc.Xdy.setVisibility(8);
                i = e.m(localb);
                if (localb.type == 66)
                {
                  if ((TextUtils.isEmpty(localb.loA)) && (TextUtils.isEmpty(localb.loB))) {
                    break label1991;
                  }
                  i = 33;
                }
              }
            }
            label1584:
            label1722:
            label1739:
            label2149:
            label3565:
            label4077:
            label6129:
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
                    break label7300;
                  }
                  localc.Xdn.setVisibility(0);
                  localc.Xdn.setMaxLines(2);
                  localc.Xdn.setText(localb.title);
                  localc.Xdi.setVisibility(8);
                  if (bool1)
                  {
                    if ((localb.type != 33) && (localb.type != 36)) {
                      break label7313;
                    }
                    paramString = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                    localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                    com.tencent.mm.modelappbrand.a.b.bhh().a(localc.Xdh, "file://".concat(String.valueOf(paramString)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(50, 50));
                  }
                  if (localb.type == 44) {
                    e.c.a(parama1, localc, localb);
                  }
                }
                if (parama1.hRi()) {
                  break label7491;
                }
                if (!com.tencent.mm.pluginsdk.model.app.h.k(localg)) {
                  break label7475;
                }
                localc.Xdw.setVisibility(0);
                c(parama1, localc.Xdw, by.a(localb, paramca));
                localObject2 = parama;
                if (i == 0)
                {
                  localc.XdC.setTag(localObject2);
                  localc.XdC.setOnClickListener(d(parama1));
                }
                if (this.tMW)
                {
                  localc.XdC.setOnLongClickListener(c(parama1));
                  localc.XdC.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
                }
                AppMethodBeat.o(36795);
                return;
                Log.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.apG()), paramString });
                localObject3 = null;
                localb = null;
                break;
                localObject2 = localg.field_appName;
                break label549;
                localc.wRL.setText((CharSequence)localObject2);
                break label681;
                a(parama1, localc.wRL, localb.appId);
                break label756;
                if (localb.type == 24)
                {
                  localc.wRL.setText(MMApplicationContext.getContext().getString(R.l.favorite));
                  localc.Xdm.setVisibility(0);
                  localc.wRL.setVisibility(0);
                  localc.Xdj.setVisibility(8);
                  i = 1;
                  break label784;
                }
                if ((localb.type == 19) || (((t)localObject3).lpH == 19))
                {
                  localc.wRL.setText(MMApplicationContext.getContext().getString(R.l.chatting_item_record));
                  localc.Xdm.setVisibility(0);
                  localc.wRL.setVisibility(0);
                  localc.Xdj.setVisibility(8);
                  i = 1;
                  break label784;
                }
                if (e.a(localb, localc)) {
                  break label7531;
                }
                localc.Xdm.setVisibility(8);
                localc.wRL.setVisibility(8);
                localc.Xdj.setVisibility(8);
                i = 0;
                break label784;
                bool1 = true;
                break label977;
                localc.Xdm.setBackgroundResource(R.g.dmZ);
                break label1027;
                localc.Xdh.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.dok));
                bool1 = false;
                break label1027;
                localc.Xdu.setVisibility(0);
                b(parama1, localc.Xdu, by.bzO(localb.ilh));
                break label1056;
                i = 5;
                break label1146;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Xdi.setVisibility(0);
                  localc.Xdi.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                  localc.mrM.setVisibility(0);
                  localc.mrM.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                  localc.Xdn.setVisibility(8);
                  localc.Xdo.setVisibility(4);
                  localc.Xdt.setVisibility(0);
                  if (!(paramca.apG() + "_msg").equals(parama.playingMsgId)) {
                    break label2294;
                  }
                  localc.Xdt.setImageResource(R.g.music_pauseicon);
                  localc.mrM.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label2308;
                    }
                    localc.Xdh.setImageResource(R.k.app_attach_file_icon_music);
                  }
                }
                for (;;)
                {
                  parama = new e.g();
                  parama.msgId = paramca.apG();
                  parama.xml = paramca.getContent();
                  parama.fKH = paramca.apK();
                  localc.Xdt.setTag(parama);
                  localc.Xdt.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNP());
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Xdi.setVisibility(8);
                  break label2046;
                  localc.Xdt.setImageResource(R.g.music_playicon);
                  break label2149;
                  localc.Xdh.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Xdi.setVisibility(0);
                  localc.Xdi.setMaxLines(2);
                }
                for (;;)
                {
                  localc.mrM.setVisibility(0);
                  localc.Xdn.setVisibility(8);
                  localc.Xdt.setVisibility(8);
                  localc.Xdo.setVisibility(4);
                  localc.mrM.setMaxLines(2);
                  localc.mrM.setText(Util.getSizeKB(localb.llX));
                  e.c.a(localc, str, localb.llX);
                  e.c.a(localc, Boolean.TRUE, paramca, localb.fvr, localb.title);
                  if (!bool1) {
                    break label7507;
                  }
                  if (!e.b.bzG(localb.llY)) {
                    break label2505;
                  }
                  localc.Xdh.setImageResource(R.g.dlY);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Xdi.setVisibility(8);
                }
                if (e.b.bzH(localb.llY))
                {
                  localc.Xdh.setImageResource(R.k.app_attach_file_icon_video);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                }
                else
                {
                  localc.Xdh.setImageResource(v.bpJ(localb.llY));
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  continue;
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.Xdi.setVisibility(0);
                    localc.mrM.setVisibility(0);
                    localc.Xdn.setVisibility(8);
                    localc.Xdt.setVisibility(0);
                    localc.Xdt.setImageResource(R.g.video_download_btn);
                    localc.Xdo.setVisibility(4);
                    localc.mrM.setMaxLines(2);
                    if (!bool1) {
                      break label7507;
                    }
                    paramString = new com.tencent.mm.ay.a.a.c.a();
                    paramString.wy(R.k.app_attach_file_icon_webpage).bmG().dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50)).gs(true).bmJ().aw(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                    localObject2 = com.tencent.mm.ay.q.bml();
                    if (!Util.isNullOrNil(localb.thumburl)) {
                      break label2788;
                    }
                  }
                  for (parama = localb.lmd;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.ay.a.a)localObject2).a(parama, localc.Xdh, paramString.bmL());
                    localc.Xdt.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    localc.Xdi.setVisibility(8);
                    break label2595;
                  }
                  if (localb != null) {
                    e.a(paramString, parama1, paramca, localb);
                  }
                  parama = (com.tencent.mm.aj.e)localb.ar(com.tencent.mm.aj.e.class);
                  if ((parama != null) && (parama.llr == 1) && (parama.llp == 5))
                  {
                    e.c.a(parama1, localc, localb, paramca, bool1);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                  }
                  else
                  {
                    if ((j == 0) && (ao.a(localb, parama)))
                    {
                      localc.Xem.setVisibility(0);
                      localc.Xer.setVisibility(0);
                      ao.a(parama1.getContext(), localb, localc.Xeo, localc.Xep);
                      ao.b(localc.Xeq, localb);
                    }
                    localc.Xdi.setVisibility(8);
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.Xdn.setMaxLines(2);
                      localc.Xdn.setVisibility(0);
                      localc.Xdn.setText(localb.getTitle());
                      localc.mrM.setMaxLines(3);
                      if (!e.n(localb)) {
                        break label3187;
                      }
                      localc.Xdt.setVisibility(0);
                      localc.Xdt.setImageResource(R.g.video_download_btn);
                      localc.Xdo.setVisibility(4);
                      if (!bool1) {
                        break label7507;
                      }
                      paramString = new com.tencent.mm.ay.a.a.c.a();
                      paramString.wy(R.k.app_attach_file_icon_webpage).bmG().Wr(com.tencent.mm.plugin.image.d.eIC()).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50)).gs(true).bmJ().aw(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                      localObject2 = com.tencent.mm.ay.q.bml();
                      if (!Util.isNullOrNil(localb.thumburl)) {
                        break label3200;
                      }
                    }
                    for (parama = localb.lmd;; parama = localb.thumburl)
                    {
                      ((com.tencent.mm.ay.a.a)localObject2).a(parama, localc.Xdh, paramString.bmL());
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      localc.Xdn.setVisibility(8);
                      break label2989;
                      localc.Xdt.setVisibility(8);
                      break label3026;
                    }
                    if (localc.XdC.getLayoutParams() != null)
                    {
                      localc.XdC.getLayoutParams().width = -2;
                      localc.XdC.requestLayout();
                    }
                    localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(localb.loA);
                    final boolean bool2;
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label3555;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.XdD.setVisibility(8);
                      localc.XdP.setVisibility(0);
                      localc.XdJ.setVisibility(8);
                      localc.XdW.setVisibility(8);
                      if (!e.a(paramca, localb, parama1)) {
                        break label3565;
                      }
                      localc.Xet.setVisibility(0);
                      bool2 = Util.isNullOrNil(paramca.apQ());
                      localc.Xet.setTag(paramca);
                      localc.Xet.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymousView)
                        {
                          AppMethodBeat.i(179950);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bn(paramAnonymousView);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                          e.a((ca)paramAnonymousView.getTag(), localc, parama1);
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(179950);
                        }
                      });
                      e.a(bool2, localc, parama1);
                    }
                    for (;;)
                    {
                      localc.XdT.setText(localb.title);
                      e.i(localc.XdT, localb.title);
                      localc.XdN.setText(parama);
                      e.a(localc.XdO, localb);
                      com.tencent.mm.ay.q.bml().a(paramString, localc.XdM, al.d.jak);
                      parama = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                      localc.XdQ.setImageBitmap(null);
                      com.tencent.mm.modelappbrand.a.b.bhh().a(localc.XdQ, "file://".concat(String.valueOf(parama)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(240, 192));
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label3578;
                      }
                      localc.olN.setVisibility(0);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.fUe;
                      break label3273;
                      paramString = localb.loV;
                      break label3285;
                      localc.Xet.setVisibility(8);
                    }
                    localc.olN.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    continue;
                    localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(localb.loA);
                    ((com.tencent.mm.plugin.appbrand.service.w)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.w.class)).adj(localb.loA);
                    switch (localb.loC)
                    {
                    default: 
                      localc.Xdm.setVisibility(0);
                      localc.Xdj.setVisibility(0);
                      localc.Xdj.setBackground(null);
                      localc.Xdj.setImageResource(R.k.app_brand_we_app_logo_share);
                      e.a(localc.wRL, localb);
                      break;
                    case 2: 
                    case 3: 
                      if (localc.XdC.getLayoutParams() != null)
                      {
                        localc.XdC.getLayoutParams().width = -2;
                        localc.XdC.requestLayout();
                      }
                      if (localObject2 != null)
                      {
                        parama = ((WxaAttributes)localObject2).field_nickname;
                        if (localObject2 == null) {
                          break label4067;
                        }
                        paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                        localc.XdD.setVisibility(8);
                        localc.XdP.setVisibility(0);
                        localc.XdJ.setVisibility(8);
                        localc.XdW.setVisibility(8);
                        localc.XdT.setText(localb.title);
                        e.i(localc.XdT, localb.title);
                        localc.XdN.setText(parama);
                        e.a(localc.XdO, localb);
                        com.tencent.mm.ay.q.bml().a(paramString, localc.XdM, al.d.jak);
                        parama = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                        localc.XdQ.setImageBitmap(null);
                        localc.XdQ.setVisibility(4);
                        if (!e.a(localb, (WxaAttributes)localObject2)) {
                          break label4077;
                        }
                        localc.olN.setVisibility(0);
                        if (!e.a(paramca, localb, parama1)) {
                          break label4090;
                        }
                        localc.Xet.setVisibility(0);
                        bool2 = Util.isNullOrNil(paramca.apQ());
                        localc.Xet.setTag(paramca);
                        localc.Xet.setOnClickListener(new View.OnClickListener()
                        {
                          public final void onClick(View paramAnonymousView)
                          {
                            AppMethodBeat.i(185027);
                            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                            localb.bn(paramAnonymousView);
                            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
                        com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
                        {
                          public final void G(Bitmap paramAnonymousBitmap)
                          {
                            AppMethodBeat.i(36779);
                            if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                            {
                              localc.XdQ.setImageBitmap(paramAnonymousBitmap);
                              localc.XdQ.setVisibility(0);
                              localc.XdS.setVisibility(4);
                              if (bool2)
                              {
                                localc.XdR.setImageDrawable(com.tencent.mm.ci.a.m(parama1.WQv.getContext(), R.k.shortvideo_play_btn));
                                localc.XdR.setVisibility(0);
                                AppMethodBeat.o(36779);
                                return;
                              }
                              localc.XdR.setVisibility(8);
                              AppMethodBeat.o(36779);
                              return;
                            }
                            localc.XdQ.setVisibility(4);
                            localc.XdS.setVisibility(0);
                            localc.XdR.setVisibility(8);
                            AppMethodBeat.o(36779);
                          }
                          
                          public final void bhq()
                          {
                            AppMethodBeat.i(36778);
                            AppMethodBeat.o(36778);
                          }
                          
                          public final void bhr()
                          {
                            AppMethodBeat.i(36780);
                            AppMethodBeat.o(36780);
                          }
                          
                          public final String key()
                          {
                            AppMethodBeat.i(36781);
                            String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                            AppMethodBeat.o(36781);
                            return str;
                          }
                        }, e.bzF(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(240, 192));
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        parama = localb.fUe;
                        break label3766;
                        paramString = localb.loV;
                        break label3778;
                        localc.olN.setVisibility(8);
                        break label3927;
                        localc.Xet.setVisibility(8);
                      }
                    case 1: 
                      if (localObject2 != null)
                      {
                        parama = ((WxaAttributes)localObject2).field_nickname;
                        if (localObject2 == null) {
                          break label4262;
                        }
                        paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                        localc.XdD.setVisibility(8);
                        localc.XdP.setVisibility(8);
                        localc.XdJ.setVisibility(0);
                        localc.XdL.setText(parama);
                        localc.XdW.setVisibility(8);
                        if (!Util.isNullOrNil(paramString)) {
                          break label4268;
                        }
                        parama = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                        com.tencent.mm.modelappbrand.a.b.bhh().a(localc.XdK, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.bhg(), com.tencent.mm.modelappbrand.a.g.lzF);
                      }
                      for (;;)
                      {
                        if (!e.a(localb, (WxaAttributes)localObject2)) {
                          break label4291;
                        }
                        localc.XdV.setVisibility(0);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        parama = localb.title;
                        break label4114;
                        paramString = null;
                        break label4126;
                        com.tencent.mm.modelappbrand.a.b.bhh().a(localc.XdK, paramString, com.tencent.mm.modelappbrand.a.a.bhg(), com.tencent.mm.modelappbrand.a.g.lzF);
                      }
                      localc.XdV.setVisibility(8);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      parama = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
                      paramString = localb.loV;
                      localObject2 = localb.fUe;
                      str = localb.title;
                      localObject3 = localb.description;
                      if ((parama == null) || (Util.isNullOrNil(parama.lkv)) || (Util.isNullOrNil(parama.lkx)))
                      {
                        Log.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                        break;
                      }
                      localc.Xec.setText((CharSequence)localObject2);
                      localc.XdD.setVisibility(8);
                      localc.XdP.setVisibility(8);
                      localc.XdJ.setVisibility(8);
                      localc.Xed.setVisibility(0);
                      localc.XdZ.setVisibility(8);
                      localc.Xed.setImageDrawable(com.tencent.mm.ci.a.m(parama1.getContext(), R.k.shortvideo_play_btn));
                      localc.XdW.setVisibility(0);
                      localc.XdX.setText(str);
                      localc.XdY.setText((CharSequence)localObject3);
                      com.tencent.mm.ay.q.bmk().a(paramString, new r.a()
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
                                e.d.8.this.Xez.Xeb.setImageBitmap(paramAnonymousBitmap);
                              }
                              AppMethodBeat.o(36782);
                            }
                          });
                          AppMethodBeat.o(36783);
                        }
                      });
                      paramString = com.tencent.mm.modelappbrand.a.b.bhh().a(parama.lkx, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.lyt));
                      if (paramString != null)
                      {
                        localc.Xea.setImageBitmap(paramString);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                      }
                      else
                      {
                        com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
                        {
                          public final void G(Bitmap paramAnonymousBitmap)
                          {
                            AppMethodBeat.i(36785);
                            if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                            {
                              localc.Xea.setImageBitmap(paramAnonymousBitmap);
                              localc.Xea.setVisibility(0);
                            }
                            AppMethodBeat.o(36785);
                          }
                          
                          public final void bhq()
                          {
                            AppMethodBeat.i(36784);
                            localc.Xea.setVisibility(4);
                            AppMethodBeat.o(36784);
                          }
                          
                          public final void bhr()
                          {
                            AppMethodBeat.i(185028);
                            Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                            com.tencent.mm.plugin.report.service.h.IzE.el(808, 2);
                            AppMethodBeat.o(185028);
                          }
                          
                          public final String key()
                          {
                            AppMethodBeat.i(36786);
                            String str = "CHAT#" + com.tencent.mm.plugin.appbrand.ac.n.cP(this);
                            AppMethodBeat.o(36786);
                            return str;
                          }
                        }, parama.lkx, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.lyt));
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        paramInt = 1;
                        localc.Xdn.setMaxLines(2);
                        localc.mrM.setMaxLines(3);
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        localc.Xdi.setVisibility(8);
                        if ((localb.title != null) && (localb.title.trim().length() > 0))
                        {
                          localc.Xdn.setMaxLines(2);
                          localc.Xdn.setVisibility(0);
                          localc.Xdn.setText(localb.getTitle());
                        }
                        for (;;)
                        {
                          localc.mrM.setMaxLines(3);
                          localc.Xdt.setVisibility(8);
                          localc.Xdo.setVisibility(4);
                          if (!bool1) {
                            break label7507;
                          }
                          parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                          if ((parama != null) && (!parama.isRecycled())) {
                            break label4819;
                          }
                          localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                          break;
                          localc.Xdn.setVisibility(8);
                        }
                        localc.Xdh.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        localc.Xdn.setVisibility(0);
                        if (localb.lmv == 1) {
                          localc.Xdn.setText(R.l.eRx);
                        }
                        for (;;)
                        {
                          if ((localb.title != null) && (localb.title.length() > 0))
                          {
                            localc.Xdi.setVisibility(0);
                            localc.Xdi.aL(localb.getTitle());
                          }
                          localc.mrM.setMaxLines(4);
                          localc.Xdo.setVisibility(4);
                          localc.Xdt.setVisibility(8);
                          if (!bool1) {
                            break label7507;
                          }
                          parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                          if ((parama == null) || (parama.isRecycled())) {
                            break label5055;
                          }
                          localc.Xdh.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                          break;
                          if (localb.lmv == 2) {
                            localc.Xdn.setText(R.l.eRz);
                          } else if (localb.lmv == 3) {
                            localc.Xdn.setText(R.l.eRy);
                          } else {
                            localc.Xdn.setText(R.l.eRA);
                          }
                        }
                        localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        localc.Xdi.setVisibility(0);
                        localc.Xdi.aL(localb.getTitle());
                        localc.Xdn.setVisibility(0);
                        localc.Xdn.setText(R.l.ewp);
                        localc.mrM.setMaxLines(4);
                        localc.Xdo.setVisibility(4);
                        localc.Xdt.setVisibility(8);
                        if (!bool1) {
                          break label7507;
                        }
                        parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          localc.Xdh.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                        }
                        else
                        {
                          localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                          continue;
                          if ((localb.title != null) && (localb.title.length() > 0))
                          {
                            localc.Xdi.setVisibility(0);
                            localc.Xdi.aL(localb.getTitle());
                            localc.Xdn.setVisibility(8);
                          }
                          localc.mrM.setMaxLines(4);
                          localc.Xdo.setVisibility(4);
                          localc.Xdt.setVisibility(8);
                          if (!bool1) {
                            break label7507;
                          }
                          parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                          if ((parama != null) && (!parama.isRecycled()))
                          {
                            localc.Xdh.setImageBitmap(parama);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = k;
                          }
                          else
                          {
                            localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = k;
                            continue;
                            if ((localb.title != null) && (localb.title.length() > 0)) {
                              localc.Xdi.setVisibility(0);
                            }
                            for (;;)
                            {
                              localc.mrM.setVisibility(0);
                              localc.Xdn.setVisibility(8);
                              localc.Xdt.setVisibility(8);
                              localc.Xdo.setVisibility(4);
                              localc.mrM.setMaxLines(2);
                              if (!bool1) {
                                break label7507;
                              }
                              parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                              if ((parama != null) && (!parama.isRecycled())) {
                                break label5531;
                              }
                              localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                              paramInt = 0;
                              parama = (c.a)localObject1;
                              i = k;
                              break;
                              localc.Xdi.setVisibility(8);
                            }
                            localc.Xdh.setImageBitmap(parama);
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
              }
            case 15: 
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Xdi.setVisibility(0);
                localc.mrM.setVisibility(0);
                localc.Xdn.setVisibility(8);
                localc.Xdt.setVisibility(8);
                localc.Xdo.setVisibility(4);
                localc.mrM.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5765;
                  }
                  localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                }
              }
              for (;;)
              {
                parama = new by(paramca, false, paramInt, "", false, localb.title, localb.fUd, localb.fUe, localb.title, localb.lmD, localb.url, false, false);
                localc.XdC.setTag(parama);
                localc.XdC.setOnClickListener(i(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.Xdi.setVisibility(8);
                break label5580;
                localc.Xdh.setImageBitmap(parama);
              }
            case 25: 
              label3187:
              label4090:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Xdi.setVisibility(0);
                localc.mrM.setVisibility(0);
                localc.Xdn.setVisibility(8);
                localc.Xdt.setVisibility(8);
                localc.Xdo.setVisibility(4);
                localc.mrM.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5995;
                  }
                  localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                }
              }
              for (;;)
              {
                parama = new by(paramca, paramInt, "", parama1.hOp(), localb.fUd, localb.fUe, localb.title, localb.lon, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.XdC.setTag(parama);
                localc.XdC.setOnClickListener(j(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.Xdi.setVisibility(8);
                break label5805;
                localc.Xdh.setImageBitmap(parama);
              }
            case 26: 
            case 27: 
              label1146:
              label2046:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Xdi.setVisibility(0);
                localc.mrM.setVisibility(0);
                localc.Xdn.setVisibility(8);
                localc.Xdt.setVisibility(8);
                localc.Xdo.setVisibility(4);
                localc.mrM.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6306;
                  }
                  localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                }
                parama = new by();
                parama.fNz = paramca;
                parama.Wwx = false;
                parama.position = paramInt;
                parama.XmI = false;
                parama.title = parama1.hOp();
                parama.fUd = localb.fUd;
                parama.fUe = localb.fUe;
                parama.UJu = localb.title;
                if (localb.type != 26) {
                  break label6318;
                }
                parama.tid = localb.tid;
                parama.loo = localb.loo;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.XdC.setOnClickListener(k(parama1));
                paramInt = 1;
              }
              label1523:
              label2294:
              label3578:
              break;
            }
            label4114:
            label6035:
            label7189:
            for (;;)
            {
              label1699:
              label1709:
              label1991:
              label2505:
              label2788:
              label5995:
              localc.XdC.setTag(parama);
              label1961:
              label2989:
              label3026:
              label3285:
              label3555:
              label4067:
              j = 0;
              label2595:
              label3273:
              label3927:
              i = paramInt;
              label3766:
              label3778:
              label4291:
              label4819:
              paramInt = j;
              label4126:
              label4262:
              label4268:
              label5055:
              label5580:
              break;
              label5531:
              label5805:
              localc.Xdi.setVisibility(8);
              break label6035;
              label6306:
              localc.Xdh.setImageBitmap(parama);
              break label6129;
              label6318:
              if (localb.type == 27)
              {
                parama.tid = localb.tid;
                parama.loo = localb.loo;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.XdC.setOnClickListener(l(parama1));
                paramInt = 1;
                continue;
                localc.Xdi.setVisibility(0);
                localc.Xdi.aL(localb.description);
                localc.mrM.setText(localb.lnk);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Xdn.setVisibility(0);
                  localc.Xdn.setText(localb.title);
                }
                for (;;)
                {
                  localc.mrM.setMaxLines(4);
                  localc.Xdo.setVisibility(4);
                  localc.Xdt.setVisibility(8);
                  if (!bool1) {
                    break label7507;
                  }
                  parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6567;
                  }
                  localc.Xdh.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Xdn.setVisibility(8);
                }
                localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                localc.Xdi.setVisibility(8);
                localc.Xdn.setVisibility(0);
                if ((localb.title != null) && (localb.title.trim().length() > 0)) {
                  localc.Xdn.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localc.Xdn.getContext(), localb.title, localc.Xdn.getTextSize()));
                }
                for (;;)
                {
                  localc.mrM.setMaxLines(3);
                  localc.Xdt.setVisibility(8);
                  localc.Xdo.setVisibility(4);
                  if (bool1)
                  {
                    localc.Xdh.setVisibility(8);
                    localc.XdB.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, paramca, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Xdn.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localc.Xdn.getContext(), MMApplicationContext.getContext().getString(R.l.favorite_wenote), localc.Xdn.getTextSize()));
                }
                e.c.a(parama1, localc, localb, bool1);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Xdi.setVisibility(0);
                  if (!Util.isNullOrNil(localb.lnt))
                  {
                    localc.Xdi.setTextColor(Util.convertStringToRGB(localb.lnt, parama1.getContext().getResources().getColor(R.e.normal_text_color)));
                    label6869:
                    localc.mrM.setMaxLines(2);
                    localc.mrM.setVisibility(0);
                    if (Util.isNullOrNil(localb.lnu)) {
                      break label7165;
                    }
                    localc.mrM.setTextColor(Util.convertStringToRGB(localb.lnu, parama1.getContext().getResources().getColor(R.e.grey_background_text_color)));
                    localc.Xdn.setVisibility(8);
                    localc.Xdo.setVisibility(4);
                    localc.Xdt.setVisibility(8);
                    localc.Xdm.setVisibility(0);
                    localc.wRL.setVisibility(0);
                    if (Util.isNullOrNil(localb.lnp)) {
                      break label7189;
                    }
                    localc.wRL.setText(localb.lnp);
                  }
                }
                for (;;)
                {
                  if (this.tMW)
                  {
                    parama = com.tencent.mm.ay.q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = BitmapUtil.getRoundedCornerBitmap(parama, false, parama.getWidth() / 2);
                      localc.Xdh.setImageBitmap(paramString);
                    }
                    if (!Util.isNullOrNil(localb.lns))
                    {
                      com.tencent.mm.ay.q.bml().a(localb.lns, new ImageView(parama1.getContext()), new com.tencent.mm.ay.a.a.c.a().bmF().bmL(), new com.tencent.mm.ay.a.c.h()
                      {
                        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
                        {
                          return null;
                        }
                        
                        public final void b(String paramAnonymousString, View paramAnonymousView) {}
                        
                        public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
                        {
                          AppMethodBeat.i(36788);
                          if (paramAnonymousb.bitmap != null)
                          {
                            paramAnonymousString = paramAnonymousb.bitmap;
                            localc.XdD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36787);
                                e.d.10.this.Xez.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.d.10.this.Xez.XdD.getHeight();
                                int k = e.d.10.this.Xez.XdD.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.ci.a.aY(e.d.10.this.QWD.WQv.getContext(), R.f.chatting_music_item_height);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.ci.a.aY(e.d.10.this.QWD.WQv.getContext(), R.f.chatting_music_item_width);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_from_content_bg_mask, j, i));
                                e.d.10.this.Xez.XdD.setBackgroundDrawable(localBitmapDrawable);
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
                      localc.Xdi.setTextColor(parama1.getContext().getResources().getColor(R.e.normal_text_color));
                      break label6869;
                      localc.Xdi.setVisibility(8);
                      break label6869;
                      label7165:
                      localc.mrM.setTextColor(parama1.getContext().getResources().getColor(R.e.grey_background_text_color));
                      break label6927;
                      localc.wRL.setText(R.l.evC);
                      continue;
                    }
                    localc.XdD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean XeE = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36789);
                        if (this.XeE)
                        {
                          localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                        localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.XeE = true;
                        int i = com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = BitmapUtil.createColorBitmap(parama1.WQv.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                          j = localc.XdD.getHeight();
                          int k = localc.XdD.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_height);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_width);
                          }
                          localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_from_content_bg_mask, j, i));
                          localc.XdD.setBackgroundDrawable((Drawable)localObject);
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
                localc.Xdh.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.dok));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if (((t)localObject3).lpH == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Xdn.setVisibility(8);
                  break label1423;
                  localObject1 = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = com.tencent.mm.ay.q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.Xdh.setImageBitmap(paramString);
                    break label1523;
                  }
                  if (!Util.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.ay.a.a.c.a();
                    ((com.tencent.mm.ay.a.a.c.a)localObject1).wy(R.e.chatting_item_biz_default_bg).bmG().gs(true);
                    com.tencent.mm.ay.q.bml().a(paramString, localc.Xeg, ((com.tencent.mm.ay.a.a.c.a)localObject1).bmL());
                    break label1523;
                  }
                  localc.Xdh.setImageResource(R.g.dlY);
                  break label1523;
                  label7475:
                  localc.Xdw.setVisibility(8);
                  localObject2 = parama;
                  break label1584;
                  label7491:
                  localc.Xdw.setVisibility(8);
                  localObject2 = parama;
                  break label1584;
                }
                label7507:
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
              }
              label6567:
              paramInt = 0;
            }
          }
          label1934:
          label7531:
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
        if (!com.tencent.mm.ui.chatting.ac.bV(paramca))
        {
          com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.eEx), "", parama.WQv.getContext().getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = bs.T(paramca);
        if (Util.isNullOrNil(paramMenuItem))
        {
          paramMenuItem = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
          if ((paramMenuItem != null) && (e.m(paramMenuItem) == 3)) {
            e.b.a(parama, paramca, a(parama, paramca), 2000, new com.tencent.mm.by.c.a()
            {
              public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
              {
                AppMethodBeat.i(285589);
                if ((paramAnonymousInt1 == 2000) && (paramAnonymousInt2 == -1))
                {
                  paramAnonymousIntent = Util.listToString(paramAnonymousIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
                  com.tencent.mm.plugin.findersdk.a.al localal = com.tencent.mm.plugin.findersdk.a.al.Bvs;
                  com.tencent.mm.plugin.findersdk.a.al.a(paramca, e.d.this.Wwx, false, paramAnonymousIntent);
                }
                AppMethodBeat.o(285589);
              }
            });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          e.b.a(parama, paramca, a(parama, paramca));
          continue;
          com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new e.d.2(this, paramMenuItem, parama), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179948);
              e.b.a(parama, paramca, e.d.this.a(parama, paramca));
              com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(179948);
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
        paramMenuItem = k.b.OQ(paramMenuItem);
        if (paramMenuItem != null) {
          switch (e.m(paramMenuItem))
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          an.a(paramca, bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.d(paramca, parama.WQv.getContext());
          continue;
          an.b(paramca, bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.a(paramca, parama.WQv.getContext(), a(parama, paramca), parama.hRi());
          continue;
          an.o(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.c(paramca, bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.c(paramca, parama.WQv.getContext());
        }
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", paramca.field_msgId);
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36797);
      return false;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(272080);
      int i = ((by)paramView.getTag()).position;
      int j = com.tencent.mm.pluginsdk.model.app.m.bqe(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
      k.b localb = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.bF(paramca)) && (!bs.O(paramca)) && (!com.tencent.mm.ui.chatting.k.bG(paramca)))
      {
        if (localb.type != 6) {
          break label650;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.m.bqf(localb.fvr);
        if (((localc == null) || (!e.b.j(paramca, localc.field_fileFullPath))) && (!paramca.Ic())) {
          paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
      boolean bool1;
      if ((localb.llX <= 0) || ((localb.llX > 0) && (j >= 100))) {
        switch (e.m(localb))
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        label291:
        if ((bool1) && (!this.WBq.hRj())) {
          paramo.add(i, 114, 0, paramView.getContext().getString(R.l.evJ));
        }
        if ((com.tencent.mm.by.c.blP("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Qv())) && (localb.loM == 0)) {
          switch (e.m(localb))
          {
          }
        }
        for (;;)
        {
          localObject = new em();
          ((em)localObject).fAp.msgId = paramca.field_msgId;
          EventCenter.instance.publish((IEvent)localObject);
          if ((((em)localObject).fAq.fzO) || (e.b.a(this.WBq.WQv.getContext(), localb))) {
            paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
          }
          if (bs.D(paramca)) {
            paramo.clear();
          }
          if (!this.WBq.hRj()) {
            paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
          }
          if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
            paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
          }
          AppMethodBeat.o(272080);
          return true;
          label650:
          paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          break;
          bool1 = com.tencent.mm.ao.g.bjh();
          break label291;
          bool1 = com.tencent.mm.ao.g.bjb();
          break label291;
          boolean bool2 = com.tencent.mm.ao.g.bjf();
          bool1 = bool2;
          if (Util.isImageExt(localb.llY)) {
            break label291;
          }
          paramo.a(i, 150, this.WBq.WQv.getMMResources().getString(R.l.evV), R.k.icons_filled_otherapp);
          bool1 = bool2;
          break label291;
          bool1 = com.tencent.mm.ao.g.biY();
          break label291;
          bool1 = com.tencent.mm.ao.g.biX();
          break label291;
          bool1 = com.tencent.mm.ao.g.bjd();
          break label291;
          bool1 = com.tencent.mm.ao.g.biZ();
          break label291;
          if ((localb.lnl != 5) && (localb.lnl != 6) && (localb.lnl != 2)) {
            break label934;
          }
          if ((localb.lnl != 2) || (bs.D(paramca))) {
            paramo.clear();
          }
          paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
          AppMethodBeat.o(272080);
          return false;
          paramo.clear();
          paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
          AppMethodBeat.o(272080);
          return false;
          paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        label934:
        bool1 = false;
      }
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean c(View paramView, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36798);
      com.tencent.mm.modelstat.a.a(paramca, a.a.mcb);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      Object localObject2 = paramca.field_content;
      paramView = Boolean.FALSE;
      if (localObject2 == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      Object localObject1 = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      localObject2 = t.OV((String)localObject2);
      if (localObject1 == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      if (((t)localObject2).lpH != 0)
      {
        paramView = Boolean.TRUE;
        ((k.b)localObject1).type = ((t)localObject2).lpH;
      }
      final com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, false, false);
      localObject2 = d(parama, paramca);
      if (localg != null) {
        a(parama, (k.b)localObject1, (String)localObject2, localg, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (e.m((k.b)localObject1))
      {
      }
      do
      {
        for (;;)
        {
          i = 1;
          do
          {
            while ((i != 0) && (e((k.b)localObject1, parama, this, paramca)))
            {
              AppMethodBeat.o(36798);
              return true;
              if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(parama.WQv.getContext()))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(13043, new Object[] { Integer.valueOf(2), ((k.b)localObject1).description, ((k.b)localObject1).appId });
              c(parama, paramca);
              boolean bool = a((k.b)localObject1, parama, this, paramca);
              AppMethodBeat.o(36798);
              return bool;
              if (!this.tMW)
              {
                com.tencent.mm.ui.base.w.g(parama.WQv.getContext(), parama.WQv.getContentView());
                AppMethodBeat.o(36798);
                return true;
              }
              paramView = new Intent();
              paramView.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramView.putExtra("scene", 2);
              paramView.putExtra("app_msg_id", paramca.field_msgId);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
              com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36798);
              return true;
              if ((localg != null) && (localg.Qv()) && (a(parama, localg)))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if ((((k.b)localObject1).fvr == null) || (((k.b)localObject1).fvr.length() == 0)) {
                ((com.tencent.mm.ui.chatting.d.b.b)parama.bC(com.tencent.mm.ui.chatting.d.b.b.class)).a(paramca, new com.tencent.mm.pluginsdk.model.app.al()
                {
                  public final void y(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                  {
                    AppMethodBeat.i(219974);
                    if (localg != null)
                    {
                      if (paramAnonymousBoolean1)
                      {
                        e.d.a(parama, this.pqD, this.Wxw, localg, paramca.field_msgSvrId, 3, parama.getTalkerUserName());
                        AppMethodBeat.o(219974);
                        return;
                      }
                      e.d.a(parama, this.pqD, this.Wxw, localg, paramca.field_msgSvrId, 7, parama.getTalkerUserName());
                    }
                    AppMethodBeat.o(219974);
                  }
                });
              }
              for (;;)
              {
                AppMethodBeat.o(36798);
                return true;
                if (!this.tMW)
                {
                  com.tencent.mm.ui.base.w.g(parama.WQv.getContext(), parama.WQv.getContentView());
                  AppMethodBeat.o(36798);
                  return true;
                }
                paramView = new Intent();
                paramView.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                paramView.putExtra("app_msg_id", paramca.field_msgId);
                paramView.putExtra("scene", 2);
                parama.WQv.startActivityForResult(paramView, 210);
              }
              if (Util.isNullOrNil(((k.b)localObject1).lmw))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_Product_xml", ((k.b)localObject1).lmw);
              paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
              if (paramca.field_imgPath == null) {
                paramView.putExtra("key_ProductUI_chatting_msgId", paramca.field_msgId);
              }
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "scanner", ".ui.ProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (Util.isNullOrNil(((k.b)localObject1).lmz))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_TV_xml", ((k.b)localObject1).lmz);
              paramView.putExtra("key_TV_getProductInfoScene", 1);
              if (paramca.field_imgPath == null) {
                paramView.putExtra("key_TVInfoUI_chatting_msgId", paramca.field_msgId);
              }
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "shake", ".ui.TVInfoUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (Util.isNullOrNil(((k.b)localObject1).lmC))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_product_info", ((k.b)localObject1).lmC);
              paramView.putExtra("key_product_scene", 1);
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "product", ".ui.MallProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("message_id", paramca.field_msgId);
              ((Intent)localObject1).putExtra("big_appmsg", paramView);
              i = com.tencent.mm.model.ac.aN(a(parama, paramca), parama.getTalkerUserName());
              ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
              ((Intent)localObject1).putExtra("preUsername", a(parama, paramca));
              ((Intent)localObject1).putExtra("preChatName", parama.getTalkerUserName());
              ((Intent)localObject1).putExtra("preChatTYPE", i);
              ((Intent)localObject1).putExtra("msgUsername", (String)localObject2);
              ((Intent)localObject1).putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
              ((Intent)localObject1).putExtra("chatTypeForAppbrand", com.tencent.mm.modelappbrand.a.SF(parama.getTalkerUserName()));
              e.a.a((Intent)localObject1, parama, paramca, this);
              com.tencent.mm.modelstat.a.ai(paramca);
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject1);
              AppMethodBeat.o(36798);
              return true;
              if (Util.isNullOrNil(((k.b)localObject1).fII))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_card_app_msg", ((k.b)localObject1).fII);
              paramView.putExtra("key_from_scene", ((k.b)localObject1).lnl);
              com.tencent.mm.by.c.b(parama.WQv.getContext(), "card", ".ui.CardDetailUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.WQv.getContext()))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if (d((k.b)localObject1, parama, this, paramca))
              {
                c(parama, paramca);
                AppMethodBeat.o(36798);
                return true;
              }
              i = 1;
            }
          } while (c((k.b)localObject1, parama, this, paramca));
        }
        b((k.b)localObject1, parama, this, paramca);
        c(parama, paramca);
        AppMethodBeat.o(36798);
        return true;
        e.a((k.b)localObject1, parama, paramca);
        AppMethodBeat.o(36798);
        return true;
        paramView = new Intent();
        paramView.putExtra("key_from_user_name", a(parama, paramca));
        paramView.putExtra("key_biz_uin", ((k.b)localObject1).lnn);
        paramView.putExtra("key_order_id", ((k.b)localObject1).lno);
        if ((paramca.field_talker != null) && (!paramca.field_talker.equals("")) && (ab.Lj(paramca.field_talker))) {
          paramView.putExtra("key_chatroom_name", paramca.field_talker);
        }
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
        AppMethodBeat.o(36798);
        return true;
      } while (!e.a((k.b)localObject1, parama));
      AppMethodBeat.o(36798);
      return true;
      AppMethodBeat.o(36798);
      return false;
    }
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class e
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    protected t.i XeB;
    protected t.l XeC;
    protected t.j XeD;
    
    private static void a(e.c paramc, com.tencent.mm.ui.chatting.d.b.k paramk, ca paramca)
    {
      AppMethodBeat.i(36827);
      if ((paramca.field_status == 2) && (b(paramk, paramca.field_msgId)))
      {
        if (paramc.XdI != null)
        {
          paramc.XdI.setVisibility(0);
          AppMethodBeat.o(36827);
        }
      }
      else if (paramc.XdI != null) {
        paramc.XdI.setVisibility(8);
      }
      AppMethodBeat.o(36827);
    }
    
    public static boolean a(long paramLong, String paramString, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(244200);
      com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.ao.ctZ().bpR(paramString);
      if ((localc == null) || (!localc.evg()))
      {
        AppMethodBeat.o(244200);
        return false;
      }
      bh.beI();
      ca localca = com.tencent.mm.model.c.bbO().Oq(paramLong);
      if (localca.Ic())
      {
        Log.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localca.field_msgSvrId), localca.field_imgPath });
        paramString = new Intent();
        paramString.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
        paramString.putExtra("clean_view_type", 1);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramString.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(244200);
        return true;
      }
      paramString = new Intent(parama.WQv.getContext(), ShowImageUI.class);
      paramString.putExtra("key_image_path", localc.field_fileFullPath);
      paramString.putExtra("key_message_id", paramLong);
      paramString.putExtra("key_favorite", true);
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramString.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(244200);
      return true;
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(161906);
      if ((Util.isNullOrNil(paramb.loB)) && (Util.isNullOrNil(paramb.loA)))
      {
        paramca = paramb.url;
        if (parama.hRi()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.V(paramca, paramc);
          paramca = new Intent();
          paramca.putExtra("rawUrl", paramc);
          paramca.putExtra("webpageTitle", paramb.title);
          paramca.putExtra("shortUrl", paramb.url);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
          AppMethodBeat.o(161906);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.hRi()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.ao.h.X(paramca));
        localBundle.putInt("chat_type", com.tencent.mm.modelappbrand.a.SF(parama.getTalkerUserName()));
        ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.r.class)).a(parama.WQv.getContext(), parama.getTalkerUserName(), paramc.a(parama, paramca), parama.hRi(), paramb, localBundle);
        AppMethodBeat.o(161906);
        return true;
        if (ab.Qm(str1)) {
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
      String str2 = com.tencent.mm.pluginsdk.model.app.q.V(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.V(paramb.llW, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.WQv.getContext(), paramb.appId);
      String str1;
      if (localPackageInfo == null)
      {
        str1 = null;
        if (localPackageInfo != null) {
          break label125;
        }
      }
      label125:
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
      Log.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.loA, paramb.loz, paramb.loB, paramb.url, Integer.valueOf(paramb.loT), paramb.loD });
      if ((44 == paramb.type) && ((!paramb.fX(false)) || (Util.isNullOrNil(paramb.z(parama.WQv.getContext(), false)))))
      {
        AppMethodBeat.o(36832);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      if ((parama.WQv instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.ao.h.X(paramca));
        i = com.tencent.mm.modelappbrand.a.SF(parama.getTalkerUserName());
        switch (paramb.loC)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.de(paramca);
        if (i != 0) {
          break label637;
        }
        AppMethodBeat.o(36832);
        return true;
        if (parama.hRi())
        {
          i = 2;
          break;
        }
        if (ab.Qm((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramc = new Intent();
        paramc.putExtra("key_username", paramb.loA);
        if (parama.hRi())
        {
          paramc.putExtra("key_from_scene", 1);
          paramc.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + str);
        }
        for (;;)
        {
          paramc.putExtra("_stat_obj", localBundle);
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.loB;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).nHY = paramb.loT;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.loE;
          paramc.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bLN());
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramc);
          i = 0;
          break;
          paramc.putExtra("key_from_scene", 2);
          paramc.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.WQv instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, localBundle);
          i = 0;
        }
        else if (ab.Qm((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, localBundle);
          i = 0;
        }
        else
        {
          localBundle.putString("chatroom_username", e.a(parama, (String)localObject));
          localBundle.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.hRi(), paramb, localBundle);
          i = 0;
          continue;
          localBundle.putString("chatroom_username", e.a(parama, (String)localObject));
          localBundle.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.hRi(), paramb, localBundle);
          i = 0;
        }
      }
      label637:
      AppMethodBeat.o(36832);
      return false;
    }
    
    public static boolean h(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, ca paramca)
    {
      AppMethodBeat.i(36833);
      Object localObject2 = (com.tencent.mm.aj.a)paramb.ar(com.tencent.mm.aj.a.class);
      if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.aj.a)localObject2).lkv)) && (!Util.isNullOrNil(((com.tencent.mm.aj.a)localObject2).lkx)))
      {
        String str2 = ((com.tencent.mm.aj.a)localObject2).lkv;
        String str3 = ((com.tencent.mm.aj.a)localObject2).lku;
        Object localObject1 = ((com.tencent.mm.aj.a)localObject2).fVg;
        String str1;
        int i;
        if (Util.isNullOrNil(((com.tencent.mm.aj.a)localObject2).lky))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.aj.a)localObject2).lkw;
          String str5 = paramb.loB;
          localObject2 = ((com.tencent.mm.aj.a)localObject2).lkx;
          Log.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { str2, str3, str1, str4, str5, localObject2 });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
          if (!ab.Lj(parama.getTalkerUserName())) {
            break label363;
          }
          i = 2;
          label164:
          localh.a(17608, new Object[] { Integer.valueOf(i), str5, Integer.valueOf(1), Integer.valueOf(1) });
          if ((Util.isNullOrNil(str2)) && ((Util.isNullOrNil(str3)) || (!u.agG(str3)) || (!Util.nullAsNil(u.buc(str3)).equals(localObject1)))) {
            break label369;
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
          str1 = ((com.tencent.mm.aj.a)localObject2).lky;
          break;
          label363:
          i = 1;
          break label164;
          label369:
          Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
        }
      }
      Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
      com.tencent.mm.ui.base.w.makeText(parama.WQv.getContext(), parama.WQv.getMMResources().getString(R.l.app_sending), 0).show();
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
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject1 = (aj)paramb.ar(aj.class);
        if ((localObject1 != null) && (!Util.isNullOrNil(((aj)localObject1).PyQ)))
        {
          paramb = new flm();
          paramb.PyQ = ((aj)localObject1).PyQ;
          paramb.PyR = ((aj)localObject1).PyR;
          paramb.PyS = ((aj)localObject1).PyS;
          paramb.PyT = ((aj)localObject1).PyT;
          paramb.PyU = ((aj)localObject1).PyU;
          paramb.PyY = ((aj)localObject1).PyY;
          paramb.vhY = ((aj)localObject1).vhY;
          paramb.pqW = ((aj)localObject1).pqW;
          paramb.CHR = ((aj)localObject1).CHR;
          paramb.PyV = ((aj)localObject1).PyV;
          paramb.PyW = ((aj)localObject1).PyW;
          paramb.PyX = ((aj)localObject1).PyX;
          paramb.source = ((aj)localObject1).source;
          paramb.fVx = ((aj)localObject1).fVx;
          paramb.PyZ = ((aj)localObject1).PyZ;
          paramb.Pzb = ((aj)localObject1).Pzb;
          paramb.Pzc = ((aj)localObject1).Pzc;
          paramb.Pzd = ((aj)localObject1).Pzd;
          paramb.Pza = ((aj)localObject1).Pza;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.WQv.getContext().getString(R.l.fts_recommend_search_keyword));
          ai.a(parama.WQv.getContext(), paramc);
          com.tencent.mm.plugin.topstory.a.i.a(paramb, paramca);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject2 = paramb.url;
        Intent localIntent;
        label555:
        label563:
        int i;
        if (parama.hRi())
        {
          localObject1 = "groupmessage";
          Object localObject3 = com.tencent.mm.pluginsdk.model.app.q.V((String)localObject2, (String)localObject1);
          localObject1 = paramb.url;
          localObject2 = c.getPackageInfo(parama.WQv.getContext(), paramb.appId);
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
            break label1017;
          }
          localIntent.putExtra("shortUrl", (String)localObject1);
          if (localObject2 != null) {
            break label1033;
          }
          localObject1 = null;
          localIntent.putExtra("version_name", (String)localObject1);
          if (localObject2 != null) {
            break label1043;
          }
          i = 0;
          label582:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.fUd))
          {
            localIntent.putExtra("srcUsername", paramb.fUd);
            localIntent.putExtra("srcDisplayname", paramb.fUe);
          }
          localIntent.putExtra("msg_id", paramca.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramca));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", paramca.ilq);
          int k = com.tencent.mm.model.ac.aN(paramc.a(parama, paramca), parama.getTalkerUserName());
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
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(36834);
          return true;
          localObject1 = "singlemessage";
          break;
          label1017:
          localIntent.putExtra("shortUrl", paramb.url);
          break label555;
          label1033:
          localObject1 = ((PackageInfo)localObject2).versionName;
          break label563;
          label1043:
          i = ((PackageInfo)localObject2).versionCode;
          break label582;
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
      if (this.XeB == null) {
        this.XeB = new t.i(parama);
      }
      parama = this.XeB;
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
        paramb = com.tencent.mm.plugin.sns.data.m.kt(parama.WEE, paramca.field_talker);
        if (!TextUtils.isEmpty(paramb)) {
          paramc.putExtra("sns_landing_pages_extra", paramb);
        }
        paramc.addFlags(268435456);
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
        AppMethodBeat.o(169873);
        return true;
      }
      aj localaj = (aj)paramb.ar(aj.class);
      if ((localaj != null) && (!Util.isNullOrNil(localaj.PyQ)))
      {
        paramb = new flm();
        paramb.PyQ = localaj.PyQ;
        paramb.PyR = localaj.PyR;
        paramb.PyS = localaj.PyS;
        paramb.PyT = localaj.PyT;
        paramb.PyU = localaj.PyU;
        paramb.PyY = localaj.PyY;
        paramb.vhY = localaj.vhY;
        paramb.pqW = localaj.pqW;
        paramb.CHR = localaj.CHR;
        paramb.PyV = localaj.PyV;
        paramb.PyW = localaj.PyW;
        paramb.PyX = localaj.PyX;
        paramb.source = localaj.source;
        paramb.fVx = localaj.fVx;
        paramb.PyZ = localaj.PyZ;
        paramb.Pzb = localaj.Pzb;
        paramb.Pzc = localaj.Pzc;
        paramb.Pzd = localaj.Pzd;
        paramb.Pza = localaj.Pza;
        paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.WQv.getContext().getString(R.l.fts_recommend_search_keyword));
        ai.a(parama.WQv.getContext(), paramc);
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
        if (parama.hRi())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.V((String)localObject2, (String)localObject1);
          String str = paramb.llW;
          j = parama.WQv.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).e((String)localObject2, 1, j, i);
          }
          localPackageInfo = c.getPackageInfo(parama.WQv.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          localIntent.putExtra("msgUsername", parama.WEE);
          localIntent.putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_snsad_statextstr", paramb.fUk);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId)))) {
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
          }
          localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          if (Util.isNullOrNil(str)) {
            break label1324;
          }
          localIntent.putExtra("shortUrl", str);
          label698:
          if (localPackageInfo != null) {
            break label1340;
          }
          localObject2 = null;
          label706:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1350;
          }
          i = 0;
          label725:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.fUd))
          {
            localIntent.putExtra("srcUsername", paramb.fUd);
            localIntent.putExtra("srcDisplayname", paramb.fUe);
          }
          localIntent.putExtra("msg_id", paramca.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramca));
          localIntent.putExtra("from_scence", 2);
          i = com.tencent.mm.model.ac.aN(paramc.a(parama, paramca), parama.getTalkerUserName());
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
            label1011:
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
            paramc = (com.tencent.mm.aj.e)paramb.ar(com.tencent.mm.aj.e.class);
            if (paramc == null) {
              break;
            }
          }
        }
        for (int i = paramc.llp;; i = -1)
        {
          localIntent.putExtra(f.r.VSO, i);
          localIntent.putExtra("key_enable_teen_mode_check", true);
          localIntent.putExtra("msgUsername", parama.WEE);
          localIntent.putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
          if ((paramc == null) || (i != 5) || (paramc.llr != 1)) {
            break label1384;
          }
          paramc = new Bundle();
          paramc.putInt(f.b.VRT, 1);
          paramc.putInt(f.b.VRU, j);
          paramc.putInt("geta8key_scene", 1);
          paramc.putString("geta8key_username", parama.getTalkerUserName());
          paramc.putString("webpageTitle", paramb.title);
          if ((localaj != null) && (!Util.isNullOrNil(localaj.PyQ)))
          {
            paramb = com.tencent.mm.plugin.webview.ui.tools.video.a.QvS;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bnh(localaj.PyQ);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d.a(parama.WQv.getContext(), paramca.field_msgId, paramca.field_msgSvrId, 0, paramc);
          AppMethodBeat.o(169873);
          return true;
          localObject1 = "singlemessage";
          break;
          label1324:
          localIntent.putExtra("shortUrl", paramb.url);
          break label698;
          label1340:
          localObject2 = localPackageInfo.versionName;
          break label706;
          label1350:
          i = localPackageInfo.versionCode;
          break label725;
          i = 2;
          break label1011;
          i = 3;
          break label1011;
          i = 5;
          break label1011;
        }
        label1384:
        e.a(paramb, parama, localIntent);
        if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(3)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(parama.WQv.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          Log.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          AppMethodBeat.o(169873);
          return true;
        }
        localIntent.putExtra("pay_chat_type", com.tencent.mm.modelappbrand.a.SF(parama.getTalkerUserName()));
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(169873);
      return true;
    }
    
    private t.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36823);
      if (this.XeC == null) {
        this.XeC = new t.l(parama);
      }
      parama = this.XeC;
      AppMethodBeat.o(36823);
      return parama;
    }
    
    private t.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36824);
      if (this.XeD == null) {
        this.XeD = new t.j(parama);
      }
      parama = this.XeD;
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
        localObject = new aq(paramLayoutInflater, R.i.edH);
        ((View)localObject).setTag(new e.c().I((View)localObject, false));
      }
      AppMethodBeat.o(36825);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(36826);
      final e.c localc = (e.c)parama;
      this.WBq = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
      localc.reset();
      String str = paramca.getContent();
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).cr(paramca);
      k.b localb;
      Object localObject2;
      if (str != null)
      {
        localb = k.b.aG(str, paramca.apL());
        localObject2 = t.OV(str);
      }
      label679:
      label1194:
      label1467:
      label1729:
      for (;;)
      {
        Object localObject1 = new by(paramca, parama1.hRi(), paramInt, null, '\000');
        int j = 0;
        int k = 0;
        localc.Xet.setVisibility(8);
        Object localObject3 = localObject1;
        Object localObject4;
        boolean bool1;
        label604:
        int i;
        if (localb != null)
        {
          localObject4 = com.tencent.mm.pluginsdk.model.app.h.hn(localb.appId, localb.appVersion);
          localc.Xdi.aL(localb.title);
          localc.mrM.setText(localb.description);
          localc.Xdn.setMaxLines(1);
          localc.Xdi.setTextColor(parama1.getContext().getResources().getColor(R.e.FG_0));
          localc.mrM.setTextColor(parama1.getContext().getResources().getColor(R.e.half_alpha_black));
          localc.XdD.setBackgroundResource(R.g.chatto_bg_app);
          localc.XdD.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
          localc.Xdh.setVisibility(0);
          localc.XdB.setVisibility(0);
          localc.mrM.setVisibility(0);
          localc.XdF.setVisibility(8);
          localc.XdG.setVisibility(8);
          localc.Xds.setVisibility(8);
          localc.Xdr.setVisibility(8);
          localc.Xdo.setVisibility(8);
          localc.Xdl.setVisibility(8);
          localc.Xdk.setVisibility(8);
          localc.XdP.setVisibility(8);
          localc.XdJ.setVisibility(8);
          localc.XdD.setVisibility(0);
          localc.XdW.setVisibility(8);
          localc.Xee.setVisibility(8);
          localc.Xem.setVisibility(8);
          localc.Xer.setVisibility(8);
          localc.resetChatBubbleWidth(localc.XdC, localc.Xev);
          if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName.trim().length() > 0)) {
            break label1467;
          }
          localObject3 = localb.appName;
          bool1 = true;
          com.tencent.mm.ci.a.fromDPToPix(parama1.getContext(), 12);
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool1 = o.a.hfN().fHm();
          }
          if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!gZ((String)localObject3))) {
            break label1507;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject4, (String)localObject3);
          if (localb.type != 19) {
            break label1477;
          }
          localc.wRL.setText(parama1.getContext().getResources().getString(R.l.opensdk_source_tv_record, new Object[] { localObject3 }));
          localc.Xdm.setVisibility(0);
          localc.wRL.setVisibility(0);
          localc.wRL.setCompoundDrawables(null, null, null, null);
          localc.Xdj.setVisibility(0);
          if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject4).Qv())) {
            break label1490;
          }
          a(parama1, localc.wRL, paramca, localb, ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_packageName, paramca.apH());
          localc.Xdj.setImageResource(R.g.dnd);
          a(parama1, localc.Xdj, localb.appId);
          i = 1;
        }
        label707:
        label973:
        label1490:
        label2389:
        label4053:
        label6359:
        for (;;)
        {
          localc.Xdm.setBackgroundResource(R.g.mm_trans);
          bool1 = false;
          localc.Xdh.setVisibility(0);
          if (this.tMW)
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
                    if (!e.b.bzI(paramca.apK())) {
                      localObject3 = com.tencent.mm.ay.q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                    }
                  }
                }
              }
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              localObject4 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject3, false, com.tencent.mm.ci.a.fromDPToPix(parama1.getContext(), 1));
              localc.Xdh.setImageBitmap((Bitmap)localObject4);
              label871:
              if (e.m(localb) != 3) {
                break label1702;
              }
              localc.XdD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                private boolean XeE = false;
                
                public final boolean onPreDraw()
                {
                  AppMethodBeat.i(36803);
                  if (this.XeE)
                  {
                    localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                  localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                  this.XeE = true;
                  int i = com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 24);
                  Bitmap localBitmap = this.val$bitmap;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = BitmapUtil.createColorBitmap(parama1.WQv.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                    j = localc.XdD.getHeight();
                    int k = localc.XdD.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_height);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_width);
                    }
                    localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_to_content_bg_mask, j, i));
                    localc.XdD.setBackgroundDrawable((Drawable)localObject);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                }
              });
              if (!ar.isDarkMode()) {
                break label1691;
              }
              localc.Xdm.setBackgroundResource(R.g.mm_trans);
              localc.Xdt.setOnClickListener(null);
              j = e.m(localb);
              if (localb.type == 66)
              {
                if ((TextUtils.isEmpty(localb.loA)) && (TextUtils.isEmpty(localb.loB))) {
                  break label1729;
                }
                j = 33;
              }
            }
          }
          label1249:
          label1507:
          label1784:
          label2046:
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
                  break label7583;
                }
                localc.Xdn.setVisibility(0);
                localc.Xdn.setMaxLines(2);
                localc.Xdn.setText(localb.title);
                localc.Xdi.setVisibility(8);
                if (bool1)
                {
                  if ((localb.type != 33) && (localb.type != 36)) {
                    break label7596;
                  }
                  paramString = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                  localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                  com.tencent.mm.modelappbrand.a.b.bhh().a(localc.Xdh, "file://".concat(String.valueOf(paramString)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(52, 52));
                }
                if (localb.type == 44) {
                  e.c.a(parama1, localc, localb);
                }
              }
              localObject3 = parama;
              if (j == 0)
              {
                localc.XdC.setTag(localObject3);
                localc.XdC.setOnClickListener(d(parama1));
              }
              if (this.tMW)
              {
                localc.XdC.setOnLongClickListener(c(parama1));
                localc.XdC.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
              }
              a(paramInt, localc, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
              AppMethodBeat.o(36826);
              return;
              localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              localc.wRL.setText((CharSequence)localObject3);
              break label604;
              a(parama1, localc.wRL, localb.appId);
              break label679;
              if (localb.type == 24)
              {
                localc.wRL.setText(MMApplicationContext.getContext().getString(R.l.favorite));
                localc.Xdm.setVisibility(0);
                localc.wRL.setVisibility(0);
                localc.Xdj.setVisibility(8);
                i = 1;
                break label707;
              }
              if ((localb.type == 19) || (((t)localObject2).lpH == 19))
              {
                localc.wRL.setText(MMApplicationContext.getContext().getString(R.l.chatting_item_record));
                localc.Xdm.setVisibility(0);
                localc.wRL.setVisibility(0);
                localc.Xdj.setVisibility(8);
                i = 1;
                break label707;
              }
              if (e.a(localb, localc)) {
                break label7784;
              }
              localc.Xdm.setVisibility(8);
              localc.wRL.setVisibility(8);
              localc.Xdj.setVisibility(8);
              i = 0;
              break label707;
              bool1 = true;
              break label871;
              localc.Xdm.setBackgroundResource(R.g.dmZ);
              break label921;
              localc.Xdh.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.dok));
              bool1 = false;
              break label921;
              j = 5;
              break label973;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Xdi.setVisibility(0);
                localc.Xdi.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                localc.mrM.setVisibility(0);
                localc.mrM.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                localc.Xdn.setVisibility(8);
                localc.Xdo.setVisibility(4);
                localc.mrM.setMaxLines(2);
                localc.Xdt.setVisibility(0);
                if (!(paramca.apG() + "_msg").equals(parama.playingMsgId)) {
                  break label2046;
                }
                localc.Xdt.setImageResource(R.g.music_pauseicon);
                parama = new e.g();
                parama.msgId = paramca.apG();
                parama.xml = paramca.getContent();
                parama.fKH = paramca.apK();
                localc.Xdt.setTag(parama);
                localc.Xdt.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNP());
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label2060;
                  }
                  localc.Xdh.setImageResource(R.k.app_attach_file_icon_music);
                }
              }
              for (;;)
              {
                if (!hTG()) {
                  break label2072;
                }
                b(localc, false);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.Xdi.setVisibility(8);
                break label1784;
                localc.Xdt.setImageResource(R.g.music_playicon);
                break label1896;
                localc.Xdh.setImageBitmap(parama);
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
                localc.Xdi.setVisibility(0);
                localc.Xdi.setMaxLines(2);
              }
              for (;;)
              {
                localc.mrM.setVisibility(0);
                localc.Xdn.setVisibility(8);
                localc.Xdo.setVisibility(4);
                localc.mrM.setMaxLines(2);
                localc.mrM.setText(Util.getSizeKB(localb.llX));
                localc.Xdt.setVisibility(8);
                e.c.a(localc, str, localb.llX);
                e.c.a(localc, Boolean.FALSE, paramca, localb.fvr, localb.title);
                if (!bool1) {
                  break label7758;
                }
                if (!e.b.bzG(localb.llY)) {
                  break label2297;
                }
                localc.Xdh.setImageResource(R.g.dlY);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.Xdi.setVisibility(8);
              }
              if (e.b.bzH(localb.llY))
              {
                localc.Xdh.setImageResource(R.k.app_attach_file_icon_video);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
              }
              else
              {
                localc.Xdh.setImageResource(v.bpJ(localb.llY));
                i = 0;
                parama = (c.a)localObject1;
                j = k;
              }
            }
          case 4: 
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.Xdi.setVisibility(0);
              localc.mrM.setVisibility(0);
              localc.Xdn.setVisibility(8);
              localc.mrM.setMaxLines(2);
              localc.Xdo.setVisibility(4);
              localc.Xdt.setVisibility(0);
              localc.Xdt.setImageResource(R.g.video_download_btn);
              if (!bool1) {
                break label7758;
              }
              paramString = new com.tencent.mm.ay.a.a.c.a();
              paramString.wy(R.k.app_attach_file_icon_webpage).bmG().dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50)).gs(true).bmJ().aw(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1));
              localObject2 = com.tencent.mm.ay.q.bml();
              if (!Util.isNullOrNil(localb.thumburl)) {
                break label2583;
              }
            }
            for (parama = localb.lmd;; parama = localb.thumburl)
            {
              ((com.tencent.mm.ay.a.a)localObject2).a(parama, localc.Xdh, paramString.bmL());
              localc.Xdt.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.Xdi.setVisibility(8);
              break label2389;
            }
          case 36: 
            label1896:
            label2297:
            if (localc.XdC.getLayoutParams() != null)
            {
              localc.XdC.getLayoutParams().width = -2;
              localc.XdC.requestLayout();
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(localb.loA);
            if (localObject2 != null)
            {
              parama = ((WxaAttributes)localObject2).field_nickname;
              label2656:
              if (localObject2 == null) {
                break label2975;
              }
              paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
              label2668:
              localc.XdD.setVisibility(8);
              localc.XdP.setVisibility(0);
              localc.XdJ.setVisibility(8);
              localc.XdW.setVisibility(8);
              localc.XdT.setText(localb.title);
              e.i(localc.XdT, localb.title);
              localc.XdN.setText(parama);
              e.a(localc.XdO, localb);
              if (!e.a(paramca, localb, parama1)) {
                break label2985;
              }
              localc.Xet.setVisibility(0);
              bool2 = Util.isNullOrNil(paramca.apQ());
              localc.Xet.setTag(paramca);
              localc.Xet.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179969);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  e.a((ca)paramAnonymousView.getTag(), localc, parama1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(179969);
                }
              });
              e.a(bool2, localc, parama1);
              com.tencent.mm.ay.q.bml().a(paramString, localc.XdM, al.d.jak);
              parama = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
              localc.XdQ.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.bhh().a(localc.XdQ, "file://".concat(String.valueOf(parama)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(240, 192));
              if (!hTG()) {
                break label2998;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
            }
            break;
          }
          label4065:
          label4195:
          label7781:
          for (;;)
          {
            bool2 = false;
            for (parama = localc;; parama = localc)
            {
              b(parama, bool2);
              if (!e.a(localb, (WxaAttributes)localObject2)) {
                break label3016;
              }
              localc.olN.setVisibility(0);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              parama = localb.fUe;
              break label2656;
              paramString = localb.loV;
              break label2668;
              localc.Xet.setVisibility(8);
              break label2819;
              if (paramca.getStatus() >= 2) {
                break label7781;
              }
              bool2 = true;
            }
            localc.olN.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            if (localb != null) {
              e.a(paramString, parama1, paramca, localb);
            }
            parama = (com.tencent.mm.aj.e)localb.ar(com.tencent.mm.aj.e.class);
            if ((parama != null) && (parama.llr == 1) && (parama.llp == 5))
            {
              e.c.a(parama1, localc, localb, paramca, bool1);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
            }
            if ((i == 0) && (ao.a(localb, parama)))
            {
              localc.Xem.setVisibility(0);
              localc.Xer.setVisibility(0);
              ao.a(parama1.getContext(), localb, localc.Xeo, localc.Xep);
              ao.b(localc.Xeq, localb);
            }
            localc.Xdi.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.Xdn.setMaxLines(2);
              localc.Xdn.setVisibility(0);
              localc.Xdn.setText(localb.title);
              localc.mrM.setMaxLines(3);
              localc.Xdo.setVisibility(4);
              if (!e.n(localb)) {
                break label3441;
              }
              localc.Xdt.setImageResource(R.g.video_download_btn);
              localc.Xdt.setVisibility(0);
              if (bool1)
              {
                paramString = new com.tencent.mm.ay.a.a.c.a();
                paramString.wy(R.k.app_attach_file_icon_webpage).bmG().Wr(com.tencent.mm.plugin.image.d.eIC()).dO(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 50)).gs(true).bmJ().aw(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                localObject2 = com.tencent.mm.ay.q.bml();
                if (!Util.isNullOrNil(localb.thumburl)) {
                  break label3454;
                }
              }
            }
            label3441:
            label3454:
            for (parama = localb.lmd;; parama = localb.thumburl)
            {
              ((com.tencent.mm.ay.a.a)localObject2).a(parama, localc.Xdh, paramString.bmL());
              if (!hTG()) {
                break label3463;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.Xdn.setVisibility(8);
              break label3232;
              localc.Xdt.setVisibility(8);
              break label3278;
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
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(localb.loA);
            ((com.tencent.mm.plugin.appbrand.service.w)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.w.class)).adj(localb.loA);
            switch (localb.loC)
            {
            default: 
              localc.Xdm.setVisibility(0);
              localc.Xdj.setVisibility(0);
              localc.Xdj.setBackground(null);
              localc.Xdj.setImageResource(R.k.app_brand_we_app_logo_share);
              e.a(localc.wRL, localb);
              i = 1;
            }
            for (;;)
            {
              if (i == 0)
              {
                if (hTG())
                {
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
                  b(localc, false);
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                  if (localc.XdC.getLayoutParams() != null)
                  {
                    localc.XdC.getLayoutParams().width = -2;
                    localc.XdC.requestLayout();
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    label3711:
                    if (localObject2 == null) {
                      break label4006;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.XdD.setVisibility(8);
                    localc.XdP.setVisibility(0);
                    localc.XdJ.setVisibility(8);
                    localc.XdW.setVisibility(8);
                    localc.XdT.setText(localb.title);
                    e.i(localc.XdT, localb.title);
                    localc.XdN.setText(parama);
                    e.a(localc.XdO, localb);
                    com.tencent.mm.ay.q.bml().a(paramString, localc.XdM, al.d.jak);
                    parama = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                    localc.XdQ.setImageBitmap(null);
                    localc.XdS.setVisibility(0);
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label4016;
                    }
                    localc.olN.setVisibility(0);
                    if (!e.a(paramca, localb, parama1)) {
                      break label4029;
                    }
                    localc.Xet.setVisibility(0);
                    bool2 = Util.isNullOrNil(paramca.apQ());
                    localc.Xet.setTag(paramca);
                    localc.Xet.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(185040);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.bn(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
                    com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
                    {
                      public final void G(Bitmap paramAnonymousBitmap)
                      {
                        AppMethodBeat.i(36810);
                        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                        {
                          localc.XdQ.setImageBitmap(paramAnonymousBitmap);
                          localc.XdQ.setVisibility(0);
                          localc.XdS.setVisibility(4);
                          if (bool2)
                          {
                            localc.XdR.setImageDrawable(com.tencent.mm.ci.a.m(parama1.WQv.getContext(), R.k.shortvideo_play_btn));
                            localc.XdR.setVisibility(0);
                            AppMethodBeat.o(36810);
                            return;
                          }
                          localc.XdR.setVisibility(8);
                          AppMethodBeat.o(36810);
                          return;
                        }
                        localc.XdQ.setVisibility(4);
                        localc.XdS.setVisibility(0);
                        localc.XdR.setVisibility(8);
                        AppMethodBeat.o(36810);
                      }
                      
                      public final void bhq()
                      {
                        AppMethodBeat.i(36809);
                        AppMethodBeat.o(36809);
                      }
                      
                      public final void bhr()
                      {
                        AppMethodBeat.i(36811);
                        AppMethodBeat.o(36811);
                      }
                      
                      public final String key()
                      {
                        AppMethodBeat.i(36812);
                        String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                        AppMethodBeat.o(36812);
                        return str;
                      }
                    }, e.bzF(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(240, 192));
                    i = 0;
                    break;
                    parama = localb.fUe;
                    break label3711;
                    paramString = localb.loV;
                    break label3723;
                    localc.olN.setVisibility(8);
                    break label3872;
                    localc.Xet.setVisibility(8);
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label4195;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.XdD.setVisibility(8);
                    localc.XdP.setVisibility(8);
                    localc.XdJ.setVisibility(0);
                    localc.XdL.setText(parama);
                    localc.XdW.setVisibility(8);
                    if (!Util.isNullOrNil(paramString)) {
                      break label4201;
                    }
                    parama = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                    com.tencent.mm.modelappbrand.a.b.bhh().a(localc.XdK, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.bhg(), com.tencent.mm.modelappbrand.a.g.lzF);
                  }
                  for (;;)
                  {
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label4224;
                    }
                    localc.XdV.setVisibility(0);
                    i = 0;
                    break;
                    parama = localb.title;
                    break label4053;
                    paramString = null;
                    break label4065;
                    label4201:
                    com.tencent.mm.modelappbrand.a.b.bhh().a(localc.XdK, paramString, com.tencent.mm.modelappbrand.a.a.bhg(), com.tencent.mm.modelappbrand.a.g.lzF);
                  }
                  localc.XdV.setVisibility(8);
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
                parama = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
                paramString = localb.loV;
                localObject2 = localb.fUe;
                localObject3 = localb.title;
                localObject4 = localb.description;
                if (parama == null)
                {
                  Log.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
                  break;
                }
                if (((Util.isNullOrNil(parama.lkv)) || (Util.isNullOrNil(parama.lkx))) && (Util.isNullOrNil(parama.lku)))
                {
                  Log.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
                  break;
                }
                localc.Xec.setText((CharSequence)localObject2);
                localc.XdD.setVisibility(8);
                localc.XdP.setVisibility(8);
                localc.XdJ.setVisibility(8);
                localc.Xed.setVisibility(0);
                localc.XdZ.setVisibility(8);
                localc.Xed.setImageDrawable(com.tencent.mm.ci.a.m(parama1.getContext(), R.k.shortvideo_play_btn));
                localc.XdW.setVisibility(0);
                localc.XdX.setText((CharSequence)localObject3);
                localc.XdY.setText((CharSequence)localObject4);
                com.tencent.mm.ay.q.bmk().a(paramString, new r.a()
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
                          e.e.8.this.Xez.Xeb.setImageBitmap(paramAnonymousBitmap);
                        }
                        AppMethodBeat.o(36813);
                      }
                    });
                    AppMethodBeat.o(36814);
                  }
                });
                parama = com.tencent.mm.ay.q.bmh().Wd(paramca.apK());
                localc.Xea.setImageBitmap(null);
                com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
                {
                  public final void G(Bitmap paramAnonymousBitmap)
                  {
                    AppMethodBeat.i(36816);
                    if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                    {
                      localc.Xea.setImageBitmap(paramAnonymousBitmap);
                      localc.Xea.setVisibility(0);
                    }
                    AppMethodBeat.o(36816);
                  }
                  
                  public final void bhq()
                  {
                    AppMethodBeat.i(36815);
                    localc.Xea.setVisibility(4);
                    AppMethodBeat.o(36815);
                  }
                  
                  public final void bhr()
                  {
                    AppMethodBeat.i(185041);
                    Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
                    com.tencent.mm.plugin.report.service.h.IzE.el(808, 3);
                    AppMethodBeat.o(185041);
                  }
                  
                  public final String key()
                  {
                    AppMethodBeat.i(36817);
                    String str = "CHAT#" + com.tencent.mm.plugin.appbrand.ac.n.cP(this);
                    AppMethodBeat.o(36817);
                    return str;
                  }
                }, e.bzF(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.lyt));
                if (hTG())
                {
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
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
                localc.mrM.setMaxLines(3);
                localc.Xdn.setMaxLines(2);
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                localc.Xdi.setVisibility(8);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Xdn.setMaxLines(2);
                  localc.Xdn.setVisibility(0);
                  localc.Xdn.setText(localb.title);
                  label4734:
                  localc.mrM.setMaxLines(3);
                  localc.Xdo.setVisibility(4);
                  localc.Xdt.setVisibility(8);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label4845;
                    }
                    localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                  }
                }
                for (;;)
                {
                  if (!hTG()) {
                    break label4857;
                  }
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.Xdn.setVisibility(8);
                  break label4734;
                  label4845:
                  localc.Xdh.setImageBitmap(parama);
                }
                label4857:
                if (paramca.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                localc.Xdn.setVisibility(0);
                if (localb.lmv == 1) {
                  localc.Xdn.setText(R.l.eRx);
                }
                for (;;)
                {
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.Xdi.setVisibility(0);
                    localc.Xdi.aL(localb.title);
                  }
                  localc.mrM.setMaxLines(4);
                  localc.Xdo.setVisibility(4);
                  localc.Xdt.setVisibility(8);
                  if (!bool1) {
                    break label7758;
                  }
                  parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                  if ((parama == null) || (parama.isRecycled())) {
                    break label5112;
                  }
                  localc.Xdh.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  if (localb.lmv == 2) {
                    localc.Xdn.setText(R.l.eRz);
                  } else if (localb.lmv == 3) {
                    localc.Xdn.setText(R.l.eRy);
                  } else {
                    localc.Xdn.setText(R.l.eRA);
                  }
                }
                label5112:
                localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                localc.Xdi.setVisibility(0);
                localc.Xdi.aL(localb.title);
                localc.Xdn.setVisibility(0);
                localc.Xdn.setText(R.l.ewp);
                localc.mrM.setMaxLines(4);
                localc.Xdo.setVisibility(4);
                localc.Xdt.setVisibility(8);
                if (bool1)
                {
                  parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled()))
                  {
                    localc.Xdh.setImageBitmap(parama);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                  }
                  localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.Xdi.setVisibility(0);
                    localc.Xdi.aL(localb.title);
                    localc.Xdn.setVisibility(8);
                  }
                  localc.mrM.setMaxLines(4);
                  localc.Xdo.setVisibility(4);
                  localc.Xdt.setVisibility(8);
                  if (bool1)
                  {
                    parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      localc.Xdh.setImageBitmap(parama);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1194;
                    }
                    localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    if ((localb.title != null) && (localb.title.length() > 0)) {
                      localc.Xdi.setVisibility(0);
                    }
                    for (;;)
                    {
                      localc.mrM.setVisibility(0);
                      localc.Xdn.setVisibility(8);
                      localc.Xdo.setVisibility(8);
                      localc.Xdt.setVisibility(4);
                      localc.mrM.setMaxLines(2);
                      if (!bool1) {
                        break label7758;
                      }
                      parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                      if ((parama != null) && (!parama.isRecycled())) {
                        break label5594;
                      }
                      localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.Xdi.setVisibility(8);
                    }
                    localc.Xdh.setImageBitmap(parama);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.Xdi.setVisibility(0);
                      localc.mrM.setVisibility(0);
                      localc.Xdn.setVisibility(8);
                      localc.Xdt.setVisibility(8);
                      localc.Xdo.setVisibility(4);
                      localc.mrM.setMaxLines(2);
                      if (bool1)
                      {
                        parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label5829;
                        }
                        localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                      }
                    }
                    for (;;)
                    {
                      parama = new by(paramca, false, paramInt, "", false, parama1.hOp(), localb.fUd, localb.fUe, localb.title, localb.lmD, localb.url, false, false);
                      localc.XdC.setTag(parama);
                      localc.XdC.setOnClickListener(i(parama1));
                      j = 1;
                      i = 0;
                      break;
                      localc.Xdi.setVisibility(8);
                      break label5644;
                      localc.Xdh.setImageBitmap(parama);
                    }
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.Xdi.setVisibility(0);
                      label5869:
                      localc.mrM.setVisibility(0);
                      localc.Xdn.setVisibility(8);
                      localc.Xdt.setVisibility(8);
                      localc.Xdo.setVisibility(4);
                      localc.mrM.setMaxLines(2);
                      if (bool1)
                      {
                        parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label6060;
                        }
                        localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                      }
                    }
                    for (;;)
                    {
                      parama = new by(paramca, paramInt, "", parama1.hOp(), localb.fUd, localb.fUe, localb.title, localb.lon, localb.designerName, localb.designerRediretctUrl, localb.url);
                      localc.XdC.setTag(parama);
                      localc.XdC.setOnClickListener(j(parama1));
                      j = 1;
                      i = 0;
                      break;
                      localc.Xdi.setVisibility(8);
                      break label5869;
                      localc.Xdh.setImageBitmap(parama);
                    }
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.Xdi.setVisibility(0);
                      localc.mrM.setVisibility(0);
                      localc.Xdn.setVisibility(8);
                      localc.Xdt.setVisibility(8);
                      localc.Xdo.setVisibility(4);
                      localc.mrM.setMaxLines(2);
                      if (bool1)
                      {
                        if (!Util.isNullOrNil(paramca.apK())) {
                          break label6359;
                        }
                        com.tencent.mm.ay.q.bml().loadImage(localb.thumburl, localc.Xdh);
                      }
                      parama = new by();
                      parama.fNz = paramca;
                      parama.Wwx = false;
                      parama.position = paramInt;
                      parama.XmI = false;
                      parama.title = parama1.hOp();
                      parama.fUd = localb.fUd;
                      parama.fUe = localb.fUe;
                      parama.UJu = localb.title;
                      if (localb.type != 26) {
                        break label6416;
                      }
                      parama.tid = localb.tid;
                      parama.loo = localb.loo;
                      parama.desc = localb.desc;
                      parama.iconUrl = localb.iconUrl;
                      parama.secondUrl = localb.secondUrl;
                      parama.pageType = localb.pageType;
                      localc.XdC.setOnClickListener(k(parama1));
                      i = 1;
                    }
                    for (;;)
                    {
                      localc.XdC.setTag(parama);
                      k = 0;
                      j = i;
                      i = k;
                      break;
                      localc.Xdi.setVisibility(8);
                      break label6100;
                      parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                      if ((parama == null) || (parama.isRecycled()))
                      {
                        localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                        break label6179;
                      }
                      localc.Xdh.setImageBitmap(parama);
                      break label6179;
                      if (localb.type == 27)
                      {
                        parama.tid = localb.tid;
                        parama.loo = localb.loo;
                        parama.desc = localb.desc;
                        parama.iconUrl = localb.iconUrl;
                        parama.secondUrl = localb.secondUrl;
                        parama.pageType = localb.pageType;
                        localc.XdC.setOnClickListener(l(parama1));
                        i = 1;
                      }
                      else
                      {
                        Log.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                        i = 0;
                      }
                    }
                    localc.Xdi.setVisibility(0);
                    localc.Xdi.aL(localb.description);
                    localc.mrM.setText(localb.lnk);
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.Xdn.setVisibility(0);
                      localc.Xdn.setText(localb.title);
                    }
                    for (;;)
                    {
                      localc.mrM.setMaxLines(4);
                      localc.Xdo.setVisibility(4);
                      localc.Xdt.setVisibility(8);
                      if (!bool1) {
                        break label7758;
                      }
                      parama = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                      if (parama == null) {
                        break label6681;
                      }
                      localc.Xdh.setImageBitmap(parama);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.Xdn.setVisibility(8);
                    }
                    localc.Xdh.setImageResource(R.k.app_attach_file_icon_webpage);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    localc.Xdi.setVisibility(8);
                    localc.Xdn.setVisibility(0);
                    if ((localb.title != null) && (localb.title.length() > 0)) {
                      localc.Xdn.setText(com.tencent.mm.pluginsdk.ui.span.l.d(localc.Xdn.getContext(), localb.title, (int)localc.Xdn.getTextSize()));
                    }
                    for (;;)
                    {
                      localc.mrM.setMaxLines(3);
                      localc.Xdo.setVisibility(4);
                      localc.Xdt.setVisibility(8);
                      if (bool1) {
                        localc.Xdh.setVisibility(8);
                      }
                      e.c.b(parama1, localc, localb, paramca, bool1);
                      if (!hTG()) {
                        break label6914;
                      }
                      a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
                      b(localc, false);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.Xdn.setText(com.tencent.mm.pluginsdk.ui.span.l.d(localc.Xdn.getContext(), MMApplicationContext.getContext().getString(R.l.favorite_wenote), (int)localc.Xdn.getTextSize()));
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
                    e.c.a(parama1, localc, localb, bool1);
                    if (hTG())
                    {
                      a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca);
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
                      localc.Xdi.setVisibility(0);
                      if (!Util.isNullOrNil(localb.lnt)) {
                        if (!Util.isNullOrNil(localb.lnt))
                        {
                          localc.Xdi.setTextColor(Util.convertStringToRGB(localb.lnt, parama1.getContext().getResources().getColor(R.e.normal_text_color)));
                          localc.mrM.setMaxLines(2);
                          localc.mrM.setVisibility(0);
                          if (Util.isNullOrNil(localb.lnu)) {
                            break label7445;
                          }
                          localc.mrM.setTextColor(Util.convertStringToRGB(localb.lnu, parama1.getContext().getResources().getColor(R.e.grey_background_text_color)));
                          localc.Xdn.setVisibility(8);
                          localc.Xdo.setVisibility(4);
                          localc.Xdt.setVisibility(8);
                          localc.Xdm.setVisibility(0);
                          localc.wRL.setVisibility(0);
                          if (Util.isNullOrNil(localb.lnp)) {
                            break label7469;
                          }
                          localc.wRL.setText(localb.lnp);
                        }
                      }
                    }
                    for (;;)
                    {
                      if (this.tMW)
                      {
                        parama = com.tencent.mm.ay.q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          paramString = BitmapUtil.getRoundedCornerBitmap(parama, false, parama.getWidth() / 2);
                          localc.Xdh.setImageBitmap(paramString);
                        }
                        if (!Util.isNullOrNil(localb.lns))
                        {
                          com.tencent.mm.ay.q.bml().a(localb.lns, new ImageView(parama1.getContext()), new com.tencent.mm.ay.a.a.c.a().bmF().bmL(), new com.tencent.mm.ay.a.c.h()
                          {
                            public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
                            {
                              return null;
                            }
                            
                            public final void b(String paramAnonymousString, View paramAnonymousView) {}
                            
                            public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
                            {
                              AppMethodBeat.i(36819);
                              if (paramAnonymousb.bitmap != null)
                              {
                                paramAnonymousString = paramAnonymousb.bitmap;
                                localc.XdD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                                {
                                  public final boolean onPreDraw()
                                  {
                                    AppMethodBeat.i(36818);
                                    e.e.10.this.Xez.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                                    int j = e.e.10.this.Xez.XdD.getHeight();
                                    int k = e.e.10.this.Xez.XdD.getWidth();
                                    int i = j;
                                    if (j == 0) {
                                      i = com.tencent.mm.ci.a.aY(e.e.10.this.QWD.WQv.getContext(), R.f.chatting_music_item_height);
                                    }
                                    j = k;
                                    if (k == 0) {
                                      j = com.tencent.mm.ci.a.aY(e.e.10.this.QWD.WQv.getContext(), R.f.chatting_music_item_width);
                                    }
                                    BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_to_content_bg_mask, j, i));
                                    e.e.10.this.Xez.XdD.setBackgroundDrawable(localBitmapDrawable);
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
                          localc.Xdi.setTextColor(parama1.getContext().getResources().getColor(R.e.normal_text_color));
                          break label7124;
                          localc.Xdi.setTextColor(parama1.getContext().getResources().getColor(R.e.normal_text_color));
                          break label7124;
                          localc.Xdi.setVisibility(8);
                          break label7124;
                          localc.mrM.setTextColor(parama1.getContext().getResources().getColor(R.e.grey_background_text_color));
                          break label7182;
                          localc.wRL.setText(R.l.evC);
                          continue;
                        }
                        localc.XdD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                        {
                          private boolean XeE = false;
                          
                          public final boolean onPreDraw()
                          {
                            AppMethodBeat.i(36820);
                            if (this.XeE)
                            {
                              localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                              AppMethodBeat.o(36820);
                              return true;
                            }
                            localc.XdD.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.XeE = true;
                            int i = com.tencent.mm.ci.a.fromDPToPix(parama1.WQv.getContext(), 24);
                            Bitmap localBitmap = parama;
                            Object localObject;
                            if (localBitmap != null)
                            {
                              localObject = localBitmap;
                              if (!localBitmap.isRecycled()) {}
                            }
                            else
                            {
                              localObject = BitmapUtil.createColorBitmap(parama1.WQv.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                            }
                            int j = ((Bitmap)localObject).getHeight();
                            if (i > j) {
                              i = j;
                            }
                            for (;;)
                            {
                              localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                              j = localc.XdD.getHeight();
                              int k = localc.XdD.getWidth();
                              i = j;
                              if (j == 0) {
                                i = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_height);
                              }
                              j = k;
                              if (k == 0) {
                                j = com.tencent.mm.ci.a.aY(parama1.WQv.getContext(), R.f.chatting_music_item_width);
                              }
                              localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_to_content_bg_mask, j, i));
                              localc.XdD.setBackgroundDrawable((Drawable)localObject);
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
                    localc.Xdh.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.dok));
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1194;
                    if (((t)localObject2).lpH == 19)
                    {
                      e.c.a(parama1, localc, localb, bool1);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1194;
                      localc.Xdn.setVisibility(8);
                      break label1249;
                      localObject1 = com.tencent.mm.ay.q.bmh().b(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()), false);
                      if (localObject1 != null)
                      {
                        paramString = (String)localObject1;
                        if (!((Bitmap)localObject1).isRecycled()) {}
                      }
                      else
                      {
                        paramString = com.tencent.mm.ay.q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity(parama1.getContext()));
                      }
                      if ((paramString != null) && (!paramString.isRecycled()))
                      {
                        localc.Xdh.setImageBitmap(paramString);
                        break label1349;
                      }
                      if (!Util.isNullOrNil(localb.thumburl))
                      {
                        paramString = localb.thumburl;
                        localObject1 = new com.tencent.mm.ay.a.a.c.a();
                        ((com.tencent.mm.ay.a.a.c.a)localObject1).wy(R.e.chatting_item_biz_default_bg).bmG().gs(true);
                        com.tencent.mm.ay.q.bml().a(paramString, localc.Xeg, ((com.tencent.mm.ay.a.a.c.a)localObject1).bmL());
                        break label1349;
                      }
                      localc.Xdh.setImageResource(R.g.dlY);
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
          label5594:
          label7784:
          i = 1;
        }
        label1349:
        label3016:
        label3278:
        label6100:
        label7124:
        localObject2 = null;
        label1477:
        label5829:
        label7758:
        localb = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
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
        if ((paramca != null) && (paramca.erk()))
        {
          paramMenuItem = k.b.OQ(paramca.field_content);
          if (paramMenuItem != null)
          {
            if (paramMenuItem.type == 40)
            {
              com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.eEx), "", parama.WQv.getContext().getString(R.l.welcome_i_know), null);
              AppMethodBeat.o(36829);
              return false;
            }
            if ((paramMenuItem.type == 33) && (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.WQv.getContext())))
            {
              AppMethodBeat.o(36829);
              return false;
            }
          }
        }
        paramMenuItem = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
        if ((paramMenuItem != null) && (e.m(paramMenuItem) == 3)) {
          e.b.a(parama, paramca, a(parama, paramca), 2000, new com.tencent.mm.by.c.a()
          {
            public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
            {
              AppMethodBeat.i(290073);
              if ((paramAnonymousInt1 == 2000) && (paramAnonymousInt2 == -1))
              {
                paramAnonymousIntent = Util.listToString(paramAnonymousIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
                com.tencent.mm.plugin.findersdk.a.al localal = com.tencent.mm.plugin.findersdk.a.al.Bvs;
                com.tencent.mm.plugin.findersdk.a.al.a(paramca, e.e.this.Wwx, false, paramAnonymousIntent);
              }
              AppMethodBeat.o(290073);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          e.b.a(parama, paramca, a(parama, paramca));
        }
      case 114: 
        paramMenuItem = paramca.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.OQ(paramMenuItem);
        if (paramMenuItem != null) {
          switch (e.m(paramMenuItem))
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          an.a(paramca, bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.d(paramca, parama.WQv.getContext());
          continue;
          an.b(paramca, bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.a(paramca, parama.WQv.getContext(), a(parama, paramca), parama.hRi());
          continue;
          an.o(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.c(paramca, bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend), parama.WQv.getContext());
          continue;
          an.c(paramca, parama.WQv.getContext());
        }
      case 103: 
        paramMenuItem = paramca.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.OQ(paramMenuItem);
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
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        AppMethodBeat.o(36829);
        return false;
        la localla = new la();
        localla.fIH.fII = paramMenuItem.fII;
        localla.fIH.fxU = paramca.field_msgId;
        localla.fIH.fIJ = paramca.field_talker;
        EventCenter.instance.publish(localla);
      }
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(244195);
      int i = ((by)paramView.getTag()).position;
      if (paramca.field_content == null)
      {
        AppMethodBeat.o(244195);
        return true;
      }
      k.b localb = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(244195);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.bF(paramca)) && (!com.tencent.mm.ui.chatting.k.bG(paramca)) && ((localb.type != 19) || (paramca.field_status != 1))) {
        paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker)) && (!as.OS(this.WBq.getTalkerUserName()))) {
        paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
      }
      boolean bool1;
      switch (e.m(localb))
      {
      default: 
        bool1 = false;
      }
      for (;;)
      {
        if ((bool1) && (!this.WBq.hRj())) {
          paramo.add(i, 114, 0, paramView.getContext().getString(R.l.evJ));
        }
        if ((com.tencent.mm.by.c.blP("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Qv())) && (localb.loM == 0)) {
          switch (e.m(localb))
          {
          }
        }
        for (;;)
        {
          localObject = new em();
          ((em)localObject).fAp.msgId = paramca.field_msgId;
          EventCenter.instance.publish((IEvent)localObject);
          if ((((em)localObject).fAq.fzO) || (e.b.a(this.WBq.WQv.getContext(), localb))) {
            paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
          }
          if (!this.WBq.hRj()) {
            paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
          }
          if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
            paramo.a(i, 144, paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
          }
          AppMethodBeat.o(244195);
          return true;
          bool1 = com.tencent.mm.ao.g.bjh();
          break;
          bool1 = com.tencent.mm.ao.g.bjb();
          break;
          boolean bool2 = com.tencent.mm.ao.g.bjf();
          bool1 = bool2;
          if (Util.isImageExt(localb.llY)) {
            break;
          }
          paramo.a(i, 150, this.WBq.WQv.getMMResources().getString(R.l.evV), R.k.icons_filled_otherapp);
          bool1 = bool2;
          break;
          bool1 = com.tencent.mm.ao.g.biY();
          break;
          bool1 = com.tencent.mm.ao.g.biX();
          break;
          bool1 = com.tencent.mm.ao.g.bjd();
          break;
          bool1 = com.tencent.mm.ao.g.biZ();
          break;
          if ((localb.lnl != 5) && (localb.lnl != 6) && (localb.lnl != 2)) {
            break label905;
          }
          if (localb.lnl != 2) {
            paramo.clear();
          }
          paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
          AppMethodBeat.o(244195);
          return false;
          paramo.clear();
          paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
          AppMethodBeat.o(244195);
          return false;
          paramo.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        label905:
        bool1 = false;
      }
    }
    
    public final void b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(244202);
      com.tencent.mm.ui.base.h.c(parama.WQv.getContext(), parama.WQv.getMMResources().getString(R.l.ewI), "", parama.WQv.getMMResources().getString(R.l.app_resend), parama.WQv.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(179968);
          if (paramca.erk())
          {
            com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
            parama.Gi(true);
            AppMethodBeat.o(179968);
            return;
          }
          AppMethodBeat.o(179968);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(244202);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean c(final View paramView, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(36830);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      paramView.getTag();
      paramView = paramca.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      paramView = k.b.OQ(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
      if ((localObject != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId))) {
        a(parama, paramView, com.tencent.mm.model.z.bcZ(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramca.field_msgSvrId, parama.getTalkerUserName());
      }
      int i;
      switch (e.m(paramView))
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (i(paramView, parama, this, paramca)))
        {
          AppMethodBeat.o(36830);
          return true;
          bh.beI();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.w.g(parama.WQv.getContext(), parama.WQv.getContentView());
            AppMethodBeat.o(36830);
            return true;
          }
          if ((Util.isImageExt(paramView.llY)) && (a(paramca.field_msgId, paramView.fvr, parama)))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          paramView = new Intent();
          paramView.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          paramView.putExtra("scene", 2);
          paramView.putExtra("app_msg_id", paramca.field_msgId);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36830);
          return true;
          if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(parama.WQv.getContext()))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(13043, new Object[] { Integer.valueOf(2), paramView.description, paramView.appId });
          boolean bool = f(paramView, parama, this, paramca);
          AppMethodBeat.o(36830);
          return bool;
          bool = j(paramView, parama, this, paramca);
          AppMethodBeat.o(36830);
          return bool;
          if (!h(paramView, parama, this, paramca)) {
            break label1408;
          }
          AppMethodBeat.o(36830);
          return true;
          if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.WQv.getContext()))
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
          continue;
          b(paramView, parama, this, paramca);
          AppMethodBeat.o(36830);
          return true;
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).Qv()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          ((com.tencent.mm.ui.chatting.d.b.b)parama.bC(com.tencent.mm.ui.chatting.d.b.b.class)).a(paramca, new com.tencent.mm.pluginsdk.model.app.al()
          {
            public final void y(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
            {
              AppMethodBeat.i(288355);
              if (this.ujb != null)
              {
                if (paramAnonymousBoolean1)
                {
                  e.e.a(parama, paramView, com.tencent.mm.model.z.bcZ(), this.ujb, paramca.field_msgSvrId, 3, parama.getTalkerUserName());
                  AppMethodBeat.o(288355);
                  return;
                }
                e.e.a(parama, paramView, com.tencent.mm.model.z.bcZ(), this.ujb, paramca.field_msgSvrId, 7, parama.getTalkerUserName());
              }
              AppMethodBeat.o(288355);
            }
          });
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(paramView.lmw))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_Product_xml", paramView.lmw);
          ((Intent)localObject).putExtra("key_ProductUI_getProductInfoScene", 1);
          if (paramca.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_ProductUI_chatting_msgId", paramca.field_msgId);
          }
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(paramView.lmz))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_TV_xml", paramView.lmz);
          ((Intent)localObject).putExtra("key_TV_getProductInfoScene", 1);
          if (paramca.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_TVInfoUI_chatting_msgId", paramca.field_msgId);
          }
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(paramView.lmC))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          paramca = new Intent();
          paramca.setFlags(65536);
          paramca.putExtra("key_product_info", paramView.lmC);
          paramca.putExtra("key_product_scene", 1);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "product", ".ui.MallProductUI", paramca);
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(paramView.fII))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          paramca = new Intent();
          paramca.setFlags(65536);
          paramca.putExtra("key_card_app_msg", paramView.fII);
          paramca.putExtra("key_from_scene", paramView.lnl);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "card", ".ui.CardDetailUI", paramca);
          AppMethodBeat.o(36830);
          return true;
          paramView = new Intent();
          paramView.putExtra("message_id", paramca.field_msgId);
          i = com.tencent.mm.model.ac.aN(a(parama, paramca), parama.getTalkerUserName());
          paramView.putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
          paramView.putExtra("preUsername", a(parama, paramca));
          paramView.putExtra("preChatName", parama.getTalkerUserName());
          paramView.putExtra("preChatTYPE", i);
          paramView.putExtra("msgUsername", parama.WEE);
          paramView.putExtra("serverMsgID", String.valueOf(paramca.field_msgSvrId));
          paramView.putExtra("chatTypeForAppbrand", com.tencent.mm.modelappbrand.a.SF(parama.getTalkerUserName()));
          e.a.a(paramView, parama, paramca, this);
          com.tencent.mm.modelstat.a.ai(paramca);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
          AppMethodBeat.o(36830);
          return true;
          e.a(paramView, parama, paramca);
          AppMethodBeat.o(36830);
          return true;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_biz_uin", paramView.lnn);
          ((Intent)localObject).putExtra("key_order_id", paramView.lno);
          if ((paramca.field_talker != null) && (!paramca.field_talker.equals("")) && (ab.Lj(paramca.field_talker))) {
            ((Intent)localObject).putExtra("key_chatroom_name", paramca.field_talker);
          }
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (!e.a(paramView, parama)) {
            break;
          }
          AppMethodBeat.o(36830);
          return true;
        }
        AppMethodBeat.o(36830);
        return false;
        label1408:
        i = 0;
      }
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
  
  static final class f
  {
    public boolean XeM = false;
  }
  
  public static final class g
  {
    public String TJa;
    public e.h XeN;
    public int XeO = -1;
    public String fKH;
    public dbr lVY = null;
    public int lnm = 0;
    public long msgId;
    public String xml;
  }
  
  public static final class h
  {
    public String QuD;
    public String coverUrl;
    public String lpY;
    public String playUrl;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e
 * JD-Core Version:    0.7.0.1
 */