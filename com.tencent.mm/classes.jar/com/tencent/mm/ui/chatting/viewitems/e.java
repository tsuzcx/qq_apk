package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
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
import android.util.Pair;
import android.view.ContextMenu;
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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.a;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.n.a;
import com.tencent.mm.pluginsdk.n.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.s.i;
import com.tencent.mm.ui.chatting.s.j;
import com.tencent.mm.ui.chatting.s.l;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Pattern;

public final class e
{
  private static boolean yZq = false;
  
  private static void a(final Context paramContext, final boolean paramBoolean, final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.ui.transmit.e.a parama)
  {
    AppMethodBeat.i(196695);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext = View.inflate(paramContext, 2131495768, null);
    Object localObject = (ImageView)paramContext.findViewById(2131305961);
    if (ab.eUK()) {
      ((ImageView)localObject).setImageResource(2131234395);
    }
    for (;;)
    {
      localObject = new f((byte)0);
      paramContext.findViewById(2131305965).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(185018);
          ac.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
          this.Iix.Ikj = true;
          locale.bmi();
          if (parama != null) {
            parama.fqB();
          }
          AppMethodBeat.o(185018);
        }
      });
      locale.ISu = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(185019);
          paramAnonymousl.clear();
          this.iEb.setFooterView(null);
          this.iEb.setFooterView(paramContext);
          AppMethodBeat.o(185019);
        }
      };
      locale.Ihj = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(185020);
          String str;
          int j;
          if (!this.Iix.Ikj)
          {
            str = paramString1;
            j = this.fsN;
            if (!paramBoolean) {
              break label56;
            }
          }
          label56:
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.chatroom.d.z.a(str, 1, j, i, 1, paramString2, paramString3);
            AppMethodBeat.o(185020);
            return;
          }
        }
      };
      locale.fvq();
      locale.cED();
      AppMethodBeat.o(196695);
      return;
      ((ImageView)localObject).setImageResource(2131234396);
    }
  }
  
  protected static void a(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(36837);
    switch (paramb.hkq)
    {
    default: 
      paramTextView.setText(2131755401);
    }
    for (;;)
    {
      paramTextView.setVisibility(0);
      AppMethodBeat.o(36837);
      return;
      paramTextView.setText(2131755657);
      continue;
      paramTextView.setText(2131755656);
    }
  }
  
  public static void a(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(36838);
    nz localnz = new nz();
    localnz.dqu.context = parama.HZF.getContext();
    localnz.dqu.msgId = parambo.field_msgId;
    localnz.dqu.dpG = parama.foQ();
    localnz.dqu.dqv = paramb.hij;
    localnz.dqu.scene = 6;
    com.tencent.mm.sdk.b.a.GpY.l(localnz);
    AppMethodBeat.o(36838);
  }
  
  public static void a(bo parambo, c.a parama, com.tencent.mm.ui.chatting.d.a parama1)
  {
    AppMethodBeat.i(179989);
    a(parambo, parama, parama1, 0);
    AppMethodBeat.o(179989);
  }
  
  public static void a(bo parambo, final c.a parama, final com.tencent.mm.ui.chatting.d.a parama1, final int paramInt)
  {
    AppMethodBeat.i(185048);
    if (parambo == null)
    {
      ac.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185048);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.aw.aKT("group_to_do").getBoolean("introduce_dialog_first", true))
    {
      com.tencent.mm.sdk.platformtools.aw.aKT("group_to_do").edit().putBoolean("introduce_dialog_first", false);
      a(parama1.HZF.getContext(), bs.isNullOrNil(parambo.eSo), parama1.getTalkerUserName(), parambo.eSo, com.tencent.mm.chatroom.d.y.f(parambo), new com.tencent.mm.ui.transmit.e.a()
      {
        public final void fqB()
        {
          AppMethodBeat.i(179943);
          e.b(this.hmA, parama, parama1, paramInt);
          AppMethodBeat.o(179943);
        }
      });
      AppMethodBeat.o(185048);
      return;
    }
    a(parambo, parama, parama1, paramInt, 0);
    AppMethodBeat.o(185048);
  }
  
  private static void a(final bo parambo, final c.a parama, final com.tencent.mm.ui.chatting.d.a parama1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185049);
    if (parambo == null)
    {
      ac.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185049);
      return;
    }
    boolean bool = bs.isNullOrNil(parambo.eSo);
    Activity localActivity = parama1.HZF.getContext();
    String str2 = parambo.field_talker;
    if (bs.isNullOrNil(parambo.eSo)) {}
    for (String str1 = com.tencent.mm.chatroom.d.y.d(parambo);; str1 = parambo.eSo)
    {
      com.tencent.mm.chatroom.d.y.a(localActivity, str2, str1, com.tencent.mm.chatroom.d.y.f(parambo), bool, 2, paramInt1, paramInt2, new y.a()
      {
        public final void VO()
        {
          AppMethodBeat.i(179944);
          if (!this.Iiw) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.c(parambo);
            ac.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", new Object[] { Long.valueOf(parambo.field_msgSvrId), localPair });
            AppMethodBeat.o(179944);
            return;
          }
        }
        
        public final void VP()
        {
          AppMethodBeat.i(179945);
          if (!this.Iiw) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.e(parambo);
            ac.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", new Object[] { Long.valueOf(parambo.field_msgSvrId), localPair });
            AppMethodBeat.o(179945);
            return;
          }
        }
      });
      AppMethodBeat.o(185049);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, c.a parama, com.tencent.mm.ui.chatting.d.a parama1)
  {
    AppMethodBeat.i(179987);
    if ((parama instanceof c))
    {
      a(paramBoolean, (c)parama, parama1);
      AppMethodBeat.o(179987);
      return;
    }
    if ((parama instanceof aw.f)) {
      aw.a(paramBoolean, (aw.f)parama, parama1);
    }
    AppMethodBeat.o(179987);
  }
  
  public static void a(boolean paramBoolean, c paramc, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(179988);
    if (paramc == null)
    {
      AppMethodBeat.o(179988);
      return;
    }
    if (paramBoolean)
    {
      paramc.IjQ.setBackgroundResource(2131231647);
      paramc.IjR.setTextColor(parama.HZF.getContext().getResources().getColor(2131099673));
      paramc.IjR.setText(2131760124);
      AppMethodBeat.o(179988);
      return;
    }
    paramc.IjQ.setBackgroundResource(2131231648);
    paramc.IjR.setTextColor(parama.HZF.getContext().getResources().getColor(2131099699));
    paramc.IjR.setText(2131760126);
    AppMethodBeat.o(179988);
  }
  
  public static boolean a(bo parambo, k.b paramb, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(179986);
    if (!com.tencent.mm.chatroom.d.y.VM())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (parambo == null)
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
    if (ce.azI() - parambo.field_createTime >= com.tencent.mm.chatroom.storage.b.ftn.longValue())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (w.wu(parama.getTalkerUserName()))
    {
      AppMethodBeat.o(179986);
      return true;
    }
    AppMethodBeat.o(179986);
    return false;
  }
  
  private static boolean j(k.b paramb)
  {
    AppMethodBeat.i(36839);
    paramb = (aa)paramb.ao(aa.class);
    if ((paramb != null) && (!bs.isNullOrNil(paramb.BYK)))
    {
      AppMethodBeat.o(36839);
      return true;
    }
    AppMethodBeat.o(36839);
    return false;
  }
  
  static final class a
  {
    static void a(Intent paramIntent, com.tencent.mm.ui.chatting.d.a parama, bo parambo, c paramc)
    {
      AppMethodBeat.i(36752);
      String str = parama.getTalkerUserName();
      paramc = paramc.b(parama, parambo);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.foQ()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str);
        localBundle.putString("stat_send_msg_user", paramc);
        paramIntent.putExtra("_stat_obj", localBundle);
        AppMethodBeat.o(36752);
        return;
        if (w.wH(str)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
  }
  
  static final class b
  {
    static void a(com.tencent.mm.ui.chatting.d.a parama, final bo parambo, String paramString)
    {
      AppMethodBeat.i(36756);
      Object localObject1 = bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend);
      final Intent localIntent = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      localIntent.putExtra("Retr_Msg_content", (String)localObject1);
      localIntent.putExtra("Retr_MsgFromScene", 2);
      localObject1 = k.b.vA((String)localObject1);
      if ((localObject1 != null) && (19 == ((k.b)localObject1).type)) {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_Msg_Id", parambo.field_msgId);
        if ((localObject1 != null) && (((k.b)localObject1).type == 6)) {
          break label526;
        }
        parambo = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambo.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambo.lR(0));
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
      localIntent.putExtra("Retr_Msg_Type", 2);
      Object localObject2 = parambo.field_talker;
      Object localObject3 = com.tencent.mm.model.y.xJ(parambo.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = com.tencent.mm.model.y.ayq().F((String)localObject3, true);
      ((y.b)localObject3).l("prePublishId", "msg_" + parambo.field_msgSvrId);
      ((y.b)localObject3).l("preUsername", paramString);
      ((y.b)localObject3).l("preChatName", localObject2);
      if ((localObject1 != null) && (((k.b)localObject1).ao(com.tencent.mm.ah.a.class) != null))
      {
        ((y.b)localObject3).l("appservicetype", Integer.valueOf(((com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class)).hfP));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class)).hfP);
      }
      if ((localObject1 != null) && (33 == ((k.b)localObject1).type))
      {
        if (!parama.foQ()) {
          break label502;
        }
        ((y.b)localObject3).l("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", parambo.field_talker);
        ((y.b)localObject3).l("sendAppMsgScene", Integer.valueOf(1));
        ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject3, parambo);
        break;
        label502:
        ((y.b)localObject3).l("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      label526:
      int i;
      if (((k.b)localObject1).type == 6)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(1203L, 7L, 1L, false);
        localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
        localObject3 = ((k.b)localObject1).hhU;
        if (((k.b)localObject1).hhJ == 1)
        {
          i = 7;
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((k.b)localObject1).hhF), Integer.valueOf(2), Long.valueOf((ce.azI() - parambo.field_createTime) / 1000L), ((k.b)localObject1).hhG, parambo.field_talker, Integer.valueOf(1), "", Long.valueOf(parambo.field_msgSvrId), Long.valueOf(parambo.field_createTime) });
        }
      }
      else
      {
        if ((((k.b)localObject1).hhJ == 0) && (((k.b)localObject1).hhF <= 26214400)) {
          break label844;
        }
      }
      label844:
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("Retr_Big_File", bool);
        localObject2 = com.tencent.mm.pluginsdk.model.app.m.aGn(((k.b)localObject1).cZa);
        if (localObject2 == null) {
          break label993;
        }
        localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
        if ((!((com.tencent.mm.vfs.e)localObject3).exists()) || (((com.tencent.mm.vfs.e)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen)) {
          break label850;
        }
        parambo = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambo.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambo.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36756);
        return;
        i = 5;
        break;
      }
      label850:
      if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset > 0L) && (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen > ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset))
      {
        paramString = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        if ((parambo.fbQ()) || (e(parambo, paramString)))
        {
          ac.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.HZF.getContext(), parama.HZF.getContext().getString(2131759063), parama.HZF.getContext().getString(2131755906), new e.b.3());
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            com.tencent.mm.ui.base.h.c(parama.HZF.getContext(), parama.HZF.getMMResources().getString(2131757939), "", true);
          }
          AppMethodBeat.o(36756);
          return;
        }
      }
      label993:
      ac.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((k.b)localObject1).hhF), ((k.b)localObject1).hhU, bs.aLJ(((k.b)localObject1).fQi) });
      if (!bool)
      {
        a(parama, localIntent, parambo);
        AppMethodBeat.o(36756);
        return;
      }
      localIntent.putExtra("Retr_Big_File", bool);
      localObject3 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject3).frb = new g.a()
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
            ac.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label179;
              }
              paramAnonymousString = this.Iiv;
              paramAnonymousc = localIntent;
              paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousc);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousc.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousc.lR(0));
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
            if ((parambo.fbQ()) || ((this.HMI != null) && (e.b.e(parambo, this.HMI.field_fileFullPath)))) {
              com.tencent.e.h.JZN.aQ(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179946);
                  ac.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                  com.tencent.mm.ui.base.h.d(e.b.1.this.Iiv.HZF.getContext(), e.b.1.this.Iiv.HZF.getContext().getString(2131759063), e.b.1.this.Iiv.HZF.getContext().getString(2131755906), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                  });
                  AppMethodBeat.o(179946);
                }
              });
            } else {
              com.tencent.e.h.JZN.aQ(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179947);
                  com.tencent.mm.ui.base.h.c(e.b.1.this.Iiv.HZF.getContext(), e.b.1.this.Iiv.HZF.getMMResources().getString(2131757939), "", true);
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
      ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.an.c.a("checkExist", bs.eWj(), paramString, parambo.field_msgId);
      ((com.tencent.mm.i.g)localObject3).field_fileId = ((k.b)localObject1).hhU;
      ((com.tencent.mm.i.g)localObject3).field_aesKey = ((k.b)localObject1).fQi;
      ((com.tencent.mm.i.g)localObject3).field_filemd5 = ((k.b)localObject1).filemd5;
      ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.fqr;
      ((com.tencent.mm.i.g)localObject3).field_talker = paramString;
      ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fqp;
      ((com.tencent.mm.i.g)localObject3).field_svr_signature = "";
      ((com.tencent.mm.i.g)localObject3).field_onlycheckexist = true;
      bool = com.tencent.mm.an.f.aDD().f((com.tencent.mm.i.g)localObject3);
      ac.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.i.g)localObject3).field_fileId, ((com.tencent.mm.i.g)localObject3).field_mediaId, bs.aLJ(((com.tencent.mm.i.g)localObject3).field_aesKey) });
      if (!bool) {
        a(parama, localIntent, parambo);
      }
      AppMethodBeat.o(36756);
    }
    
    static boolean a(Context paramContext, k.b paramb)
    {
      AppMethodBeat.i(36754);
      if ((paramb == null) || (paramContext == null))
      {
        AppMethodBeat.o(36754);
        return false;
      }
      boolean bool;
      if (paramb.type == 3)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.r(paramContext, 16L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 4)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.r(paramContext, 8L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 5)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.r(paramContext, 32L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 6)
      {
        paramb = d.a.aFF(paramb.hhG);
        if (paramb == null)
        {
          AppMethodBeat.o(36754);
          return false;
        }
        bool = com.tencent.mm.pluginsdk.model.app.h.r(paramContext, paramb.longValue());
        AppMethodBeat.o(36754);
        return bool;
      }
      AppMethodBeat.o(36754);
      return false;
    }
    
    private static boolean a(com.tencent.mm.ui.chatting.d.a parama, Intent paramIntent, bo parambo)
    {
      AppMethodBeat.i(36757);
      if ((parambo.fbQ()) || (e(parambo, null)))
      {
        ac.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.h.d(parama.HZF.getContext(), parama.HZF.getContext().getString(2131759063), parama.HZF.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(36757);
        return true;
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramIntent.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36757);
      return false;
    }
    
    static boolean aQF(String paramString)
    {
      AppMethodBeat.i(36755);
      boolean bool = bs.aLM(paramString);
      AppMethodBeat.o(36755);
      return bool;
    }
    
    public static boolean aQG(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(36759);
      Object localObject = o.aFx().b(paramString, false, true);
      if (!com.tencent.mm.vfs.i.eA((String)localObject))
      {
        AppMethodBeat.o(36759);
        return false;
      }
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      localObject = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, paramString);
      if (paramString.outWidth * paramString.outHeight > 1048576)
      {
        ac.i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", new Object[] { Integer.valueOf(paramString.outWidth), Integer.valueOf(paramString.outHeight) });
        bool = true;
      }
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      AppMethodBeat.o(36759);
      return bool;
    }
    
    public static boolean e(bo parambo, String paramString)
    {
      AppMethodBeat.i(36758);
      if ((System.currentTimeMillis() - parambo.field_createTime > 259200000L) && ((bs.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.i.eA(paramString))))
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
    public static int[] qVd = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    protected MMImageView IiE;
    protected MMNeat7extView IiF;
    protected ImageView IiG;
    protected ImageView IiH;
    protected TextView IiI;
    protected LinearLayout IiJ;
    protected TextView IiK;
    protected ImageView IiL;
    protected MMPinProgressBtn IiM;
    protected ImageView IiN;
    protected ImageView IiO;
    protected ImageView IiP;
    protected ImageView IiQ;
    protected TextView IiR;
    protected ChattingItemFooter IiS;
    protected ImageView IiT;
    protected LinearLayout IiU;
    protected ViewGroup IiV;
    protected TextView IiW;
    protected LinearLayout IiX;
    protected RelativeLayout IiY;
    protected FrameLayout IiZ;
    ImageView IjA;
    LinearLayout IjB;
    MMNeat7extView IjC;
    ImageView IjD;
    ImageView IjE;
    ImageView IjF;
    TextView IjG;
    TextView IjH;
    TextView IjI;
    LinearLayout IjJ;
    LinearLayout IjK;
    ImageView IjL;
    TextView IjM;
    TextView IjN;
    ImageView IjO;
    RelativeLayout IjP;
    LinearLayout IjQ;
    TextView IjR;
    public int IjS;
    private int IjT;
    protected LinearLayout Ija;
    protected LinearLayout Ijb;
    protected ViewStub Ijc;
    protected ImageView Ijd;
    protected ImageView Ije;
    ImageView Ijf;
    protected LinearLayout Ijg;
    protected ImageView Ijh;
    protected TextView Iji;
    protected ImageView Ijj;
    protected TextView Ijk;
    protected TextView Ijl;
    protected LinearLayout Ijm;
    protected ImageView Ijn;
    protected ImageView Ijo;
    protected ImageView Ijp;
    protected TextView Ijq;
    protected LinearLayout Ijr;
    protected ImageView Ijs;
    LinearLayout Ijt;
    TextView Iju;
    TextView Ijv;
    ImageView Ijw;
    ImageView Ijx;
    ImageView Ijy;
    TextView Ijz;
    protected TextView ijE;
    protected ImageView jPU;
    protected TextView qTn;
    private ArrayList<MMImageView> yDo;
    
    c()
    {
      AppMethodBeat.i(36762);
      this.IjS = 0;
      this.IjT = 2147483647;
      this.yDo = new ArrayList();
      AppMethodBeat.o(36762);
    }
    
    private static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt1, String[] paramArrayOfString4, String[] paramArrayOfString5, int[] paramArrayOfInt2, String paramString)
    {
      AppMethodBeat.i(36770);
      int i = 0;
      while (i <= 4)
      {
        localObject1 = (MMImageView)paramc.Ijb.findViewById(qVd[i]);
        if (localObject1 != null)
        {
          ((MMImageView)localObject1).setImageDrawable(null);
          ((MMImageView)localObject1).setVisibility(8);
        }
        i += 1;
      }
      Object localObject1 = (ImageView)paramc.Ijb.findViewById(2131298159);
      Object localObject2 = (TextView)paramc.Ijb.findViewById(2131298153);
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
          localObject1 = (MMImageView)paramc.Ijb.findViewById(qVd[i]);
          ((MMImageView)localObject1).setImageResource(2131689921);
          ((MMImageView)localObject1).setVisibility(0);
          com.tencent.mm.pluginsdk.model.app.ap.eLk().a((com.tencent.mm.pluginsdk.model.app.k.a)parama.bf(com.tencent.mm.ui.chatting.c.b.i.class), paramArrayOfString1[i], bs.eWj(), paramArrayOfString2[i], paramArrayOfString3[i], paramArrayOfInt1[i], paramString);
          localObject2 = o.aFx().p("Note_" + paramArrayOfString1[i], "", "");
          localObject3 = new com.tencent.mm.av.a.a.c.a();
          ((com.tencent.mm.av.a.a.c.a)localObject3).hKA = 1;
          ((com.tencent.mm.av.a.a.c.a)localObject3).hKQ = true;
          ((com.tencent.mm.av.a.a.c.a)localObject3).hKL = 2131689920;
          ((com.tencent.mm.av.a.a.c.a)localObject3).gKg = ((int)parama.HZF.getMMResources().getDimension(2131165216));
          ((com.tencent.mm.av.a.a.c.a)localObject3).gKh = ((int)parama.HZF.getMMResources().getDimension(2131165216));
          localObject3 = ((com.tencent.mm.av.a.a.c.a)localObject3).aFT();
          if (!com.tencent.mm.vfs.i.eA((String)localObject2)) {
            break label357;
          }
          o.aFB().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.av.a.a.c)localObject3);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject1 = (MMImageView)paramc.Ijb.findViewById(qVd[(i + 1)]);
          ((MMImageView)localObject1).setImageResource(2131689920);
          break label150;
          label357:
          com.tencent.mm.pluginsdk.model.app.ap.eLk().a((com.tencent.mm.pluginsdk.model.app.k.a)parama.bf(com.tencent.mm.ui.chatting.c.b.i.class), paramArrayOfString1[i], bs.eWj(), paramArrayOfString4[i], paramArrayOfString5[i], paramArrayOfInt2[i], paramString);
          o.aFx().p("Note_" + paramArrayOfString1[i], "", "");
          com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), 45);
          if (com.tencent.mm.vfs.i.eA((String)localObject2)) {
            o.aFB().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.av.a.a.c)localObject3);
          } else {
            ac.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
          }
        }
      }
      AppMethodBeat.o(36770);
    }
    
    @SuppressLint({"ResourceType"})
    public static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb)
    {
      AppMethodBeat.i(196692);
      parama = paramb.r(parama.HZF.getContext(), false);
      if (!bs.isNullOrNil(parama))
      {
        paramc.IiJ.setVisibility(0);
        paramc.qTn.setVisibility(0);
        paramc.IiG.setVisibility(0);
        paramc.qTn.setText(parama);
        if (com.tencent.mm.ah.k.a.hhy.ordinal() == paramb.hkl)
        {
          paramc.IiG.setImageResource(2131690913);
          AppMethodBeat.o(196692);
          return;
        }
        if (com.tencent.mm.ah.k.a.hhz.ordinal() == paramb.hkl) {
          o.aFA().a(paramb.hks, new p.a()
          {
            public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
            {
              AppMethodBeat.i(196691);
              com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196690);
                  e.c.3.this.IjW.IiG.setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(196690);
                }
              });
              AppMethodBeat.o(196691);
            }
          });
        }
      }
      AppMethodBeat.o(196692);
    }
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, bo parambo, boolean paramBoolean)
    {
      AppMethodBeat.i(36768);
      paramc.Ija.setVisibility(8);
      paramc.IjB.setVisibility(0);
      paramc.IjK.setVisibility(0);
      com.tencent.mm.ah.e locale;
      int i;
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        paramc.IjC.setMaxLines(2);
        paramc.IjC.setVisibility(0);
        paramc.IjC.ar(paramb.getTitle());
        locale = (com.tencent.mm.ah.e)paramb.ao(com.tencent.mm.ah.e.class);
        if (locale == null) {
          break label464;
        }
        i = locale.duration;
        label99:
        String str = com.tencent.mm.ah.m.nJ(i);
        if (bs.isNullOrNil(str)) {
          break label470;
        }
        paramc.IjH.setVisibility(0);
        paramc.IjH.setText(str);
      }
      for (;;)
      {
        paramc.IjF.setVisibility(0);
        if ((locale != null) && (com.tencent.mm.ah.x.nK(locale.hhc)))
        {
          paramc.IjH.setVisibility(8);
          paramc.IjF.setVisibility(8);
        }
        ae.a(parama.HZF.getContext(), paramb, paramc.IjE, paramc.IjG);
        ae.b(paramc.IjI, paramb);
        paramc.IiL.setVisibility(4);
        i = com.tencent.mm.cc.a.au(parama.HZF.getContext(), 2131166038) - com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), 24);
        int j = i * 9 / 16;
        if (com.tencent.mm.cc.a.eb(parama.HZF.getContext()) > 1.0F)
        {
          int k = (int)((paramc.IjS / com.tencent.mm.cd.a.eSl() - com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), 29) * com.tencent.mm.cc.a.eb(parama.HZF.getContext())) * 9.0F / 16.0F);
          if (paramc.IjP.getLayoutParams().height != k)
          {
            paramc.IjP.getLayoutParams().height = k;
            paramc.IjP.requestLayout();
          }
        }
        if ((!paramBoolean) && (bs.isNullOrNil(paramb.thumburl))) {
          break label482;
        }
        parama = com.tencent.mm.api.b.q(paramb.thumburl, 4);
        paramb = new com.tencent.mm.av.a.a.c.a();
        paramb.hKI = 2131100141;
        paramb.hKw = true;
        paramb.gKe = r.aGc(parama);
        parambo = paramb.de(i, j);
        parambo.hKm = new com.tencent.mm.pluginsdk.ui.applet.n(4);
        parambo.hKU = new com.tencent.mm.pluginsdk.ui.applet.e(4);
        parambo.hKv = true;
        o.aFB().a(parama, paramc.IjD, paramb.aFT());
        AppMethodBeat.o(36768);
        return;
        paramc.IjC.setVisibility(8);
        break;
        label464:
        i = 0;
        break label99;
        label470:
        paramc.IjH.setVisibility(8);
      }
      label482:
      paramb = null;
      if (!e.b.aQG(parambo.field_imgPath)) {
        paramb = o.aFx().a(parambo.field_imgPath, com.tencent.mm.cc.a.getDensity(parama.HZF.getContext()), false);
      }
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        paramc.IjD.setImageBitmap(paramb);
        AppMethodBeat.o(36768);
        return;
      }
      paramc.IjD.setImageResource(2131100141);
      AppMethodBeat.o(36768);
    }
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(36767);
      paramc.IiF.setVisibility(8);
      String str;
      Object localObject1;
      Object localObject3;
      label221:
      Object localObject2;
      int i;
      if ((paramb.title != null) && (paramb.title.trim().length() > 0))
      {
        str = paramb.title;
        paramc.IiK.setVisibility(0);
        paramc.IiK.setMaxLines(2);
        paramc.ijE.setMaxLines(4);
        paramc.IiQ.setVisibility(8);
        paramc.IiL.setVisibility(4);
        if (paramBoolean) {
          paramc.IiE.setVisibility(8);
        }
        localObject1 = new pw();
        ((pw)localObject1).dsN.type = 0;
        ((pw)localObject1).dsN.dsP = paramb.hij;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject3 = ((pw)localObject1).dsO.dsX;
        if (localObject3 == null) {
          break label1041;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.IiK.getContext(), bs.bG(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.IiK.getTextSize());
        paramc.IiK.setText((CharSequence)localObject1);
        localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
        if (localObject1 != null) {
          break label514;
        }
        ac.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.hij });
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 100) {
            localObject2 = ((String)localObject1).substring(0, 100);
          }
        }
        paramc.ijE.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramc.ijE.getContext(), bs.bG((String)localObject2, paramb.description), paramc.ijE.getTextSize()));
        paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).hkS.iterator();
        i = 0;
        localObject2 = null;
        localObject1 = null;
        label305:
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject3 = (agx)paramb.next();
        } while ((com.tencent.mm.plugin.fav.ui.l.j((agx)localObject3)) && (!bs.isNullOrNil(((agx)localObject3).EAh)) && (((agx)localObject3).EAh.equals("WeNoteHtmlFile")));
        if (((agx)localObject3).EzZ.EAG.EBj == null) {
          break label539;
        }
        str = parama.HZF.getContext().getString(2131762236);
        i = 1;
        label390:
        switch (((agx)localObject3).dataType)
        {
        }
      }
      for (;;)
      {
        break label305;
        paramc.IiK.setVisibility(8);
        str = null;
        break;
        label514:
        localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        break label221;
        label539:
        if (((agx)localObject3).EzZ.EAG.dng == null) {
          break label1038;
        }
        if (localObject1 == null)
        {
          localObject1 = ((agx)localObject3).EAb;
          break label390;
        }
        if (localObject1 == ((agx)localObject3).EAb) {
          break label1038;
        }
        localObject2 = ((agx)localObject3).EAb;
        break label390;
        if (paramBoolean)
        {
          paramc.IiE.setVisibility(0);
          paramc.IiE.setImageResource(2131689583);
        }
        break label305;
        break label305;
        if (paramBoolean)
        {
          paramc.IiE.setVisibility(0);
          paramc.IiE.setImageResource(2131230944);
        }
        break label305;
        if (paramBoolean)
        {
          paramc.IiE.setVisibility(0);
          paramc.IiE.setImageResource(2131689584);
        }
        break label305;
        if ((paramBoolean) && (!com.tencent.mm.plugin.fav.a.b.cph()))
        {
          paramc.IiE.setVisibility(0);
          paramc.IiE.setImageResource(2131690572);
          break label305;
          if (paramBoolean)
          {
            paramc.IiE.setVisibility(0);
            paramc.IiE.setImageResource(2131689581);
          }
          paramc.IiQ.setVisibility(0);
          paramc.IiQ.setImageResource(2131234464);
          break label305;
          paramc.IiE.setVisibility(0);
          paramc.IiE.setImageResource(2131689562);
          break label305;
          if (paramBoolean)
          {
            paramc.IiE.setVisibility(0);
            paramc.IiE.setImageResource(2131689564);
          }
          paramc.IiQ.setVisibility(0);
          paramc.IiQ.setImageResource(2131233395);
          break label305;
          if (paramBoolean)
          {
            paramc.IiE.setVisibility(0);
            paramc.IiE.setImageResource(com.tencent.mm.pluginsdk.e.aFI(((agx)localObject3).Ezu));
          }
          break label305;
          if (paramBoolean)
          {
            paramc.IiE.setVisibility(0);
            paramc.IiE.setImageResource(2131689577);
          }
          break label305;
          if (paramBoolean)
          {
            paramc.IiE.setVisibility(0);
            paramc.IiE.setImageResource(2131231875);
          }
        }
      }
      if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
        paramb = parama.HZF.getContext().getString(2131758964, new Object[] { localObject1 });
      }
      for (;;)
      {
        if (!bs.isNullOrNil(paramb))
        {
          paramc.IiK.setText(paramb);
          paramc.IiK.setVisibility(0);
        }
        paramc.IiE.setVisibility(8);
        paramc.IiY.setVisibility(8);
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
                paramb = parama.HZF.getContext().getString(2131758963, new Object[] { localObject1, localObject2 });
                continue;
                label1038:
                break;
                label1041:
                paramb = str;
              }
            }
          }
        }
      }
    }
    
    public static void a(c paramc, Boolean paramBoolean, final bo parambo, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(36766);
      final long l = parambo.field_msgId;
      com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(l);
      if (localc == null)
      {
        ac.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
        AppMethodBeat.o(36766);
        return;
      }
      if (paramBoolean.booleanValue()) {
        if (localc.field_status == 101L)
        {
          paramc.IiP.setVisibility(0);
          paramc.IiM.setVisibility(0);
          paramc.IiN.setVisibility(0);
        }
      }
      for (;;)
      {
        if (parambo.field_status == 5)
        {
          paramc.IiP.setVisibility(8);
          paramc.IiO.setVisibility(8);
        }
        paramc.IiP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36760);
            if (this.IjU.booleanValue())
            {
              l = l;
              paramAnonymousView = parambo;
              localc = com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(l);
              if (localc == null)
              {
                ac.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.YG() + " getinfo failed: " + paramAnonymousView);
                AppMethodBeat.o(36760);
                return;
              }
              if (localc.field_status != 101L)
              {
                ac.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.YG() + " get status failed: " + paramAnonymousView + " status:" + localc.field_status);
                AppMethodBeat.o(36760);
                return;
              }
              localc.field_status = 102L;
              localc.field_lastModifyTime = bs.aNx();
              com.tencent.mm.pluginsdk.model.app.ap.bEO().a(localc, new String[0]);
              AppMethodBeat.o(36760);
              return;
            }
            long l = l;
            paramAnonymousView = parambo;
            com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(l);
            if (localc == null) {
              ac.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.YG() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.hmq.setStatus(5);
              az.ayM();
              com.tencent.mm.model.c.awD().vP(l);
              AppMethodBeat.o(36760);
              return;
              if (localc.field_status == 101L) {
                break;
              }
              ac.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.YG() + " get status failed: " + paramAnonymousView + " status:" + localc.field_status);
            }
            if ((bs.isNullOrNil(localc.field_clientAppDataId)) && (!bs.isNullOrNil(localc.field_mediaSvrId))) {}
            for (localc.field_status = 102L;; localc.field_status = 105L)
            {
              localc.field_lastModifyTime = bs.aNx();
              com.tencent.mm.pluginsdk.model.app.ap.bEO().a(localc, new String[0]);
              break;
            }
          }
        });
        paramc.IiO.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36761);
            com.tencent.mm.pluginsdk.model.app.c localc;
            if (!this.IjU.booleanValue())
            {
              long l = l;
              paramAnonymousView = parambo;
              localc = com.tencent.mm.pluginsdk.model.app.ap.bEO().zM(l);
              if (localc != null) {
                break label102;
              }
              ac.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.YG() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.hmq.setStatus(1);
              az.ayM();
              com.tencent.mm.model.c.awD().vP(l);
              AppMethodBeat.o(36761);
              return;
              label102:
              if ((localc.field_status != 105L) && (localc.field_status != 101L))
              {
                ac.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.YG() + " get status failed: " + paramAnonymousView + " status:" + localc.field_status);
              }
              else
              {
                localc.field_status = 101L;
                localc.field_lastModifyTime = bs.aNx();
                com.tencent.mm.pluginsdk.model.app.ap.bEO().a(localc, new String[0]);
                com.tencent.mm.pluginsdk.model.app.ap.eLn().run();
              }
            }
          }
        });
        AppMethodBeat.o(36766);
        return;
        if (localc.field_status == 102L)
        {
          paramc.IiP.setVisibility(8);
          paramc.IiM.setVisibility(8);
          paramc.IiN.setVisibility(8);
        }
        else
        {
          paramc.IiP.setVisibility(8);
          paramc.IiM.setVisibility(8);
          paramc.IiN.setVisibility(8);
          continue;
          if (localc.field_status == 101L)
          {
            paramc.IiP.setVisibility(0);
            paramc.IiO.setVisibility(8);
          }
          else if (localc.field_status == 105L)
          {
            paramc.IiP.setVisibility(8);
            paramc.IiO.setVisibility(0);
          }
          else
          {
            paramc.IiP.setVisibility(8);
            paramc.IiO.setVisibility(8);
          }
        }
      }
    }
    
    public static void a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(36765);
      int i = com.tencent.mm.pluginsdk.model.app.m.aGm(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        paramc.IiM.setVisibility(8);
        paramc.IiN.setVisibility(8);
        AppMethodBeat.o(36765);
        return;
      }
      paramc.IiM.setVisibility(0);
      paramc.IiN.setVisibility(0);
      paramc.IiM.setProgress(i);
      AppMethodBeat.o(36765);
    }
    
    static void b(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, bo parambo, boolean paramBoolean)
    {
      AppMethodBeat.i(36769);
      Object localObject1 = new pw();
      ((pw)localObject1).dsN.type = 0;
      ((pw)localObject1).dsN.dsP = paramb.hij;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      Object localObject2 = ((pw)localObject1).dsO.dsX;
      paramc.IiY.setVisibility(8);
      String[] arrayOfString1 = new String[4];
      String[] arrayOfString2 = new String[4];
      int[] arrayOfInt1 = new int[4];
      String[] arrayOfString3 = new String[4];
      String[] arrayOfString4 = new String[4];
      int[] arrayOfInt2 = new int[4];
      String[] arrayOfString5 = new String[4];
      int k;
      Object localObject3;
      int i;
      Object localObject4;
      label248:
      String str;
      if (localObject2 != null)
      {
        localObject1 = null;
        paramb = bs.bG(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
        k = 0;
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject2).hkS.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (agx)((Iterator)localObject3).next();
          if ((!com.tencent.mm.plugin.fav.ui.l.j((agx)localObject4)) || (bs.isNullOrNil(((agx)localObject4).EAh)) || (!((agx)localObject4).EAh.equals("WeNoteHtmlFile"))) {
            switch (((agx)localObject4).dataType)
            {
            case 3: 
            case 6: 
            case 4: 
            case 5: 
            case 7: 
            default: 
            case 1: 
              do
              {
                do
                {
                  break;
                } while (k != 0);
                str = ((agx)localObject4).desc;
              } while (bs.isNullOrNil(str));
              if (bs.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label1211;
              }
              localObject1 = ((agx)localObject4).desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
          }
        }
      }
      label791:
      label1202:
      label1205:
      label1211:
      for (;;)
      {
        k = 1;
        break;
        if (paramBoolean)
        {
          paramc.IiY.setVisibility(0);
          paramc.IiE.setVisibility(0);
          paramc.IiE.setImageResource(2131230944);
        }
        if (i < 4)
        {
          arrayOfString1[i] = ((agx)localObject4).hhV;
          arrayOfString2[i] = ((agx)localObject4).Ezb;
          arrayOfInt1[i] = ((int)((agx)localObject4).EzL);
          arrayOfString3[i] = ((agx)localObject4).Ezf;
          arrayOfString4[i] = ((agx)localObject4).Ezh;
          arrayOfInt2[i] = ((int)((agx)localObject4).EzA);
          arrayOfString5[i] = ((agx)localObject4).dhw;
        }
        i += 1;
        break;
        if (!bs.isNullOrNil(paramb)) {
          break label248;
        }
        paramb = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131755773) + ((agx)localObject4).title;
        break label248;
        if (localObject1 != null)
        {
          localObject4 = ((String)localObject1).split("\n", 2);
          localObject3 = new ArrayList();
          if (localObject4.length > 0)
          {
            int m = localObject4.length;
            j = 0;
            while (j < m)
            {
              str = localObject4[j];
              if (str.length() > 0) {
                ((ArrayList)localObject3).add(str);
              }
              j += 1;
            }
          }
          if (((ArrayList)localObject3).size() != 1) {
            break label1205;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).hkS.size() == 2))
          {
            localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759034);
            paramb = (k.b)localObject1;
            localObject1 = localObject2;
            localObject1 = ((String)localObject1).trim();
            label616:
            if (localObject1 == null) {
              break label1202;
            }
            localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.IiK.getContext(), (CharSequence)localObject1, (int)paramc.IiK.getTextSize());
            paramc.IiK.setText((CharSequence)localObject1);
            if ((paramb != null) && (paramb.length() > 100)) {
              paramb = paramb.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            for (;;)
            {
              for (;;)
              {
                localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.ijE.getContext(), paramb, (int)paramc.ijE.getTextSize());
                paramc.ijE.setText((CharSequence)localObject1);
                if (i > 0)
                {
                  paramc.IiY.setVisibility(8);
                  if ((j != 0) || (k == 0) || (bs.isNullOrNil(paramb)))
                  {
                    paramc.ijE.setVisibility(8);
                    paramc.IiK.setMaxLines(2);
                    paramc.Ijd.setVisibility(8);
                    paramc.Ijc.setLayoutResource(2131493469);
                  }
                  try
                  {
                    if (paramc.Ijb == null) {
                      paramc.Ijb = ((LinearLayout)paramc.Ijc.inflate());
                    }
                    for (;;)
                    {
                      if (i <= 4) {
                        break label1168;
                      }
                      j = 4;
                      a(parama, paramc, j, arrayOfString5, arrayOfString2, arrayOfString1, arrayOfInt1, arrayOfString4, arrayOfString3, arrayOfInt2, parambo.field_talker);
                      parama = (ImageView)paramc.Ijb.findViewById(2131298159);
                      paramc = (TextView)paramc.Ijb.findViewById(2131298153);
                      if (paramc != null) {
                        paramc.setTextSize(0, com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getDimensionPixelSize(2131165568));
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
                      localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759034);
                      j = 0;
                      break label616;
                      paramc.ijE.setMaxLines(1);
                      paramc.ijE.setVisibility(0);
                      paramc.IiK.setMaxLines(1);
                      break label791;
                      paramc.Ijb.setVisibility(0);
                    }
                  }
                  catch (Exception paramb)
                  {
                    for (;;)
                    {
                      paramc.Ijc.setVisibility(0);
                      continue;
                      j = i;
                    }
                  }
                }
              }
              paramc.Ijc.setVisibility(8);
              paramc.Ijd.setVisibility(0);
              AppMethodBeat.o(36769);
              return;
            }
          }
        }
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(36764);
      if (this.IiK != null) {
        this.IiK.setMaxLines(this.IjT);
      }
      AppMethodBeat.o(36764);
    }
    
    public final c y(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(36763);
      super.fX(paramView);
      this.Ijr = ((LinearLayout)paramView.findViewById(2131298017));
      this.IiE = ((MMImageView)paramView.findViewById(2131298047));
      this.IiF = ((MMNeat7extView)paramView.findViewById(2131298049));
      this.IiK = ((TextView)paramView.findViewById(2131298052));
      this.ijE = ((TextView)paramView.findViewById(2131298026));
      this.qTn = ((TextView)paramView.findViewById(2131298044));
      this.IiG = ((ImageView)paramView.findViewById(2131298041));
      this.IiI = ((TextView)paramView.findViewById(2131298043));
      this.IiH = ((ImageView)paramView.findViewById(2131298042));
      this.IiJ = ((LinearLayout)paramView.findViewById(2131298040));
      this.IiL = ((ImageView)paramView.findViewById(2131298045));
      this.IiM = ((MMPinProgressBtn)paramView.findViewById(2131298088));
      this.IiN = ((ImageView)this.sSS.findViewById(2131298087));
      this.IiO = ((ImageView)this.sSS.findViewById(2131298078));
      this.IiP = ((ImageView)this.sSS.findViewById(2131298177));
      this.IiQ = ((ImageView)paramView.findViewById(2131298028));
      this.IiR = ((TextView)paramView.findViewById(2131298023));
      this.IiT = ((ImageView)paramView.findViewById(2131298039));
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.gGk = paramView.findViewById(2131298147);
      this.xpH = ((TextView)paramView.findViewById(2131298185));
      this.IiS = ((ChattingItemFooter)paramView.findViewById(2131300196));
      this.IiU = ((LinearLayout)paramView.findViewById(2131296863));
      this.IiV = ((ViewGroup)paramView.findViewById(2131301542));
      this.IiW = ((TextView)paramView.findViewById(2131301539));
      this.IiX = ((LinearLayout)paramView.findViewById(2131298053));
      this.IiZ = ((FrameLayout)paramView.findViewById(2131298069));
      this.Ija = ((LinearLayout)paramView.findViewById(2131298024));
      this.Ije = ((ImageView)paramView.findViewById(2131298076));
      this.IiY = ((RelativeLayout)paramView.findViewById(2131298046));
      this.Ijc = ((ViewStub)paramView.findViewById(2131302929));
      this.Ijd = ((ImageView)paramView.findViewById(2131298081));
      if (!paramBoolean)
      {
        this.Ijf = ((ImageView)this.sSS.findViewById(2131298176));
        this.vYf = ((ProgressBar)this.sSS.findViewById(2131306220));
      }
      this.Ijm = ((LinearLayout)paramView.findViewById(2131298005));
      this.Ijj = ((ImageView)paramView.findViewById(2131298018));
      this.Ijk = ((TextView)paramView.findViewById(2131298020));
      this.Ijq = ((TextView)paramView.findViewById(2131298016));
      this.Ijp = ((ImageView)paramView.findViewById(2131299519));
      this.Ijn = ((ImageView)paramView.findViewById(2131298006));
      this.Ijo = ((ImageView)paramView.findViewById(2131307172));
      this.Ijg = ((LinearLayout)paramView.findViewById(2131298004));
      this.Ijh = ((ImageView)paramView.findViewById(2131297979));
      this.Iji = ((TextView)paramView.findViewById(2131297980));
      this.Ijl = ((TextView)paramView.findViewById(2131298019));
      this.jPU = ((ImageView)paramView.findViewById(2131297981));
      this.Ijs = ((ImageView)paramView.findViewById(2131297984));
      this.Ijt = ((LinearLayout)paramView.findViewById(2131298009));
      this.Iju = ((TextView)paramView.findViewById(2131298015));
      this.Ijv = ((TextView)paramView.findViewById(2131298011));
      this.Ijw = ((ImageView)paramView.findViewById(2131298012));
      this.Ijx = ((ImageView)paramView.findViewById(2131298010));
      this.Ijy = ((ImageView)paramView.findViewById(2131298013));
      this.Ijz = ((TextView)paramView.findViewById(2131298014));
      this.IjA = ((ImageView)paramView.findViewById(2131298008));
      this.IjB = ((LinearLayout)paramView.findViewById(2131298030));
      this.IjF = ((ImageView)paramView.findViewById(2131298034));
      this.IjC = ((MMNeat7extView)paramView.findViewById(2131298035));
      this.IjD = ((ImageView)paramView.findViewById(2131298033));
      this.IjJ = ((LinearLayout)paramView.findViewById(2131302491));
      this.IjK = ((LinearLayout)paramView.findViewById(2131302493));
      this.IjO = ((ImageView)paramView.findViewById(2131302492));
      this.IjP = ((RelativeLayout)paramView.findViewById(2131298031));
      this.IjL = ((ImageView)this.IjJ.findViewById(2131298027));
      this.IjM = ((TextView)this.IjJ.findViewById(2131298029));
      this.IjN = ((TextView)this.IjJ.findViewById(2131298038));
      this.IjE = ((ImageView)this.IjK.findViewById(2131298027));
      this.IjG = ((TextView)this.IjK.findViewById(2131298029));
      this.IjI = ((TextView)this.IjK.findViewById(2131298038));
      this.IjH = ((TextView)paramView.findViewById(2131298032));
      this.IjQ = ((LinearLayout)paramView.findViewById(2131298050));
      this.IjR = ((TextView)paramView.findViewById(2131298051));
      if ((this.IiK != null) && (Build.VERSION.SDK_INT >= 16)) {
        this.IjT = this.IiK.getMaxLines();
      }
      this.IjS = c.ka(com.tencent.mm.sdk.platformtools.ai.getContext());
      AppMethodBeat.o(36763);
      return this;
    }
  }
  
  public static final class d
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    protected s.i IjY;
    protected s.l IjZ;
    protected s.j Ika;
    private boolean qKi;
    
    public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(36799);
      if ((com.tencent.mm.r.a.ci(parama.HZF.getContext())) || (com.tencent.mm.r.a.cf(parama.HZF.getContext())) || (com.tencent.mm.r.a.ck(parama.HZF.getContext())))
      {
        ac.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        AppMethodBeat.o(36799);
        return true;
      }
      if (paramc.a(parama, paramb, parambo))
      {
        AppMethodBeat.o(36799);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.P(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.P(paramb.hhE, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.HZF.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambo.field_msgId, parambo.field_msgSvrId, parambo);
        AppMethodBeat.o(36799);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(161905);
      if ((bs.isNullOrNil(paramb.hkf)) && (bs.isNullOrNil(paramb.hke)))
      {
        parambo = paramb.url;
        if (parama.foQ()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.P(parambo, paramc);
          parambo = new Intent();
          parambo.putExtra("rawUrl", paramc);
          parambo.putExtra("webpageTitle", paramb.title);
          parambo.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", parambo);
          AppMethodBeat.o(161905);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.b(parama, parambo);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.foQ()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.g.F(parambo));
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama.HZF.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambo), parama.foQ(), paramb, localBundle);
        AppMethodBeat.o(161905);
        return true;
        if (w.wH(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean c(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(36800);
      Object localObject1 = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
      if ((localObject1 != null) && (!bs.isNullOrNil(((com.tencent.mm.ah.a)localObject1).hgj)) && (!bs.isNullOrNil(((com.tencent.mm.ah.a)localObject1).hgl)))
      {
        String str2 = ((com.tencent.mm.ah.a)localObject1).hgj;
        String str3 = ((com.tencent.mm.ah.a)localObject1).hgi;
        String str1;
        int i;
        if (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject1).hgm))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ah.a)localObject1).hgk;
          paramb = paramb.hkf;
          localObject1 = ((com.tencent.mm.ah.a)localObject1).hgl;
          ac.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { str2, str3, str1, str4, paramb, localObject1 });
          Object localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
          if (!w.sQ(parama.getTalkerUserName())) {
            break label308;
          }
          i = 2;
          label155:
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(17608, new Object[] { Integer.valueOf(i), paramb, Integer.valueOf(1), Integer.valueOf(1) });
          if (bs.isNullOrNil(str2)) {
            break label314;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_chatting_wording", str1);
          ((Bundle)localObject2).putString("key_chatting_text", str4);
          ((Bundle)localObject2).putString("key_chatting_appid", paramb);
          ((Bundle)localObject2).putLong("key_msg_id", parambo.field_msgId);
          ((Bundle)localObject2).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject2).putString("key_sender_username", paramc.b(parama, parambo));
          e.a(parama, str2, str3, (String)localObject1, (Bundle)localObject2);
        }
        for (;;)
        {
          AppMethodBeat.o(36800);
          return true;
          str1 = ((com.tencent.mm.ah.a)localObject1).hgm;
          break;
          label308:
          i = 1;
          break label155;
          label314:
          ac.w("MicroMsg.ChattingItemAppMsgFrom", "hy: video msg invalid!!");
        }
      }
      ac.w("MicroMsg.ChattingItemAppMsgFrom", "hy: no remote url provided. treat as default");
      AppMethodBeat.o(36800);
      return false;
    }
    
    public static boolean d(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(36801);
      ac.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.hke, paramb.hkd, paramb.hkf, paramb.url, Integer.valueOf(paramb.hkq), paramb.hkh });
      if ((44 == paramb.type) && ((!paramb.et(false)) || (bs.isNullOrNil(paramb.r(parama.HZF.getContext(), false)))))
      {
        AppMethodBeat.o(36801);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambo);
      paramc = new Bundle();
      int i;
      if ((parama.HZF instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        paramc.putInt("stat_scene", i);
        paramc.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
        paramc.putString("stat_chat_talker_username", (String)localObject);
        paramc.putString("stat_send_msg_user", str);
        switch (paramb.hkg)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cq(parambo);
        if (i != 0) {
          break label582;
        }
        AppMethodBeat.o(36801);
        return true;
        if (parama.foQ())
        {
          i = 2;
          break;
        }
        if (w.wH((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_username", paramb.hke);
        if (parama.foQ())
        {
          localIntent.putExtra("key_from_scene", 1);
          localIntent.putExtra("key_scene_note", (String)localObject + ":" + str);
        }
        for (;;)
        {
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.hkf;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).jpa = paramb.hkq;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.hki;
          localIntent.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).baT());
          localIntent.putExtra("_stat_obj", paramc);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "appbrand", ".ui.AppBrandProfileUI", localIntent);
          i = 0;
          break;
          localIntent.putExtra("key_from_scene", 2);
          localIntent.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.HZF instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.al.g.F(parambo))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1157, paramb, paramc);
          i = 0;
        }
        else if (w.wH((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, paramc);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.foQ(), paramb, paramc);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.foQ(), paramb, paramc);
          i = 0;
        }
      }
      label582:
      AppMethodBeat.o(36801);
      return false;
    }
    
    public static boolean e(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(169872);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bs.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambo.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambo.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject1 = (aa)paramb.ao(aa.class);
        if ((localObject1 != null) && (!bs.isNullOrNil(((aa)localObject1).BYK)))
        {
          paramb = new dyo();
          paramb.BYK = ((aa)localObject1).BYK;
          paramb.BYL = ((aa)localObject1).BYL;
          paramb.BYM = ((aa)localObject1).BYM;
          paramb.BYN = ((aa)localObject1).BYN;
          paramb.BYO = ((aa)localObject1).BYO;
          paramb.BYS = ((aa)localObject1).BYS;
          paramb.pBl = ((aa)localObject1).pBl;
          paramb.pBm = ((aa)localObject1).pBm;
          paramb.tcG = ((aa)localObject1).tcG;
          paramb.BYP = ((aa)localObject1).BYP;
          paramb.BYQ = ((aa)localObject1).BYQ;
          paramb.BYR = ((aa)localObject1).BYR;
          paramb.source = ((aa)localObject1).source;
          paramb.kRU = ((aa)localObject1).kRU;
          paramb.BYT = ((aa)localObject1).BYT;
          paramb.BYV = ((aa)localObject1).BYV;
          paramb.BYW = ((aa)localObject1).BYW;
          paramb.BYX = ((aa)localObject1).BYX;
          paramb.BYU = ((aa)localObject1).BYU;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.HZF.getContext().getString(2131759717));
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambo);
          com.tencent.mm.plugin.websearch.api.z.a(parama.HZF.getContext(), paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject2 = paramb.url;
        PackageInfo localPackageInfo;
        Intent localIntent;
        int j;
        if (parama.foQ())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.P((String)localObject2, (String)localObject1);
          String str = paramb.url;
          localPackageInfo = c.getPackageInfo(parama.HZF.getContext(), paramb.appId);
          localIntent = new Intent();
          j = parama.HZF.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tg((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 1, j, i);
          }
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId))))
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
            localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          }
          if (bs.isNullOrNil(str)) {
            break label1211;
          }
          localIntent.putExtra("shortUrl", str);
          label625:
          if (localPackageInfo != null) {
            break label1226;
          }
          localObject2 = null;
          label633:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1236;
          }
          i = 0;
          label652:
          localIntent.putExtra("version_code", i);
          if (!bs.isNullOrNil(paramb.dvl))
          {
            localIntent.putExtra("srcUsername", paramb.dvl);
            localIntent.putExtra("srcDisplayname", paramb.dvm);
          }
          localIntent.putExtra("msg_id", parambo.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambo.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambo));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambo.eSk);
          i = com.tencent.mm.model.x.aE(paramc.b(parama, parambo), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambo.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambo));
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
            label951:
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
            paramb = (com.tencent.mm.ah.e)paramb.ao(com.tencent.mm.ah.e.class);
            if (paramb == null) {
              break;
            }
          }
        }
        for (int i = paramb.hgY;; i = -1)
        {
          localIntent.putExtra(e.m.HhB, i);
          localIntent.addFlags(536870912);
          if ((paramb == null) || (i != 5) || (paramb.hha != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP())) {
            break label1270;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.HgX, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.HgY, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.HZF.getContext(), parambo.field_msgId, parambo.field_msgSvrId, 0, paramb);
          AppMethodBeat.o(169872);
          return true;
          localObject1 = "singlemessage";
          break;
          label1211:
          localIntent.putExtra("shortUrl", paramb.url);
          break label625;
          label1226:
          localObject2 = localPackageInfo.versionName;
          break label633;
          label1236:
          i = localPackageInfo.versionCode;
          break label652;
          i = 2;
          break label951;
          i = 3;
          break label951;
          i = 5;
          break label951;
        }
        label1270:
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.HZF.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          ac.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(169872);
        return true;
      }
      AppMethodBeat.o(169872);
      return false;
    }
    
    private s.i j(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36791);
      if (this.IjY == null) {
        this.IjY = new s.i(parama);
      }
      parama = this.IjY;
      AppMethodBeat.o(36791);
      return parama;
    }
    
    private s.l k(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36792);
      if (this.IjZ == null) {
        this.IjZ = new s.l(parama);
      }
      parama = this.IjZ;
      AppMethodBeat.o(36792);
      return parama;
    }
    
    private s.j l(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36793);
      if (this.Ika == null) {
        this.Ika = new s.j(parama);
      }
      parama = this.Ika;
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
        localObject = new ag(paramLayoutInflater, 2131493431);
        ((View)localObject).setTag(new e.c().y((View)localObject, true));
      }
      AppMethodBeat.o(36794);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36795);
      final e.c localc = (e.c)parama;
      this.HNS = parama1;
      localc.reset();
      String str = parambo.getContent();
      Object localObject1 = (com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class);
      ((com.tencent.mm.ui.chatting.c.b.k)localObject1).bC(parambo);
      ((com.tencent.mm.ui.chatting.c.b.k)localObject1).bD(parambo);
      ((com.tencent.mm.ui.chatting.c.b.k)localObject1).bE(parambo);
      int i;
      if (this.qKi)
      {
        i = parambo.getContent().indexOf(':');
        if (i != -1) {
          str = parambo.getContent().substring(i + 1);
        }
      }
      for (;;)
      {
        k.b localb;
        Object localObject3;
        int j;
        Object localObject2;
        com.tencent.mm.pluginsdk.model.app.g localg;
        label558:
        boolean bool1;
        if (str != null)
        {
          localb = k.b.az(str, parambo.TE());
          localObject3 = com.tencent.mm.ah.t.vF(str);
          localObject1 = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
          i = 0;
          j = 0;
          localc.IjQ.setVisibility(8);
          localObject2 = localObject1;
          if (localb != null)
          {
            localc.IiF.ar(localb.getTitle());
            localc.ijE.setText(localb.getDescription());
            localc.IiK.setMaxLines(1);
            localc.IiF.setTextColor(ao.aJ(parama1.getContext(), 2130968584));
            localc.ijE.setTextColor(parama1.getContext().getResources().getColor(2131100482));
            localc.Ija.setBackground(ao.aI(parama1.getContext(), 2130968737));
            localc.Ija.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
            localc.IiE.setVisibility(0);
            localc.IiY.setVisibility(0);
            localc.ijE.setVisibility(0);
            localc.IiM.setVisibility(8);
            localc.IiP.setVisibility(8);
            localc.IiO.setVisibility(8);
            localc.Ijc.setVisibility(8);
            localc.Ijd.setVisibility(8);
            localc.IiH.setVisibility(8);
            localc.IiI.setVisibility(8);
            localc.Ijm.setVisibility(8);
            localc.Ijg.setVisibility(8);
            localc.Ija.setVisibility(0);
            localc.Ijt.setVisibility(8);
            localc.IjB.setVisibility(8);
            localc.IjJ.setVisibility(8);
            localc.IjO.setVisibility(8);
            e.c.aG(localc.IiZ, localc.IjS);
            localb.ao(com.tencent.mm.ah.h.class);
            localc.IiZ.setBackground(ao.aI(parama1.getContext(), 2130968737));
            localg = com.tencent.mm.pluginsdk.model.app.h.fA(localb.appId, localb.aBM);
            if (localg != null) {
              b(parama1, localb, parambo);
            }
            if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
              break label1669;
            }
            localObject2 = localb.appName;
            bool1 = true;
            com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 12);
            if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
              bool1 = n.a.eKi().dDj();
            }
            if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!eC((String)localObject2))) {
              break label1709;
            }
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), localg, (String)localObject2);
            if (localb.type != 19) {
              break label1679;
            }
            localc.qTn.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject2 }));
            label690:
            localc.qTn.setVisibility(0);
            localc.qTn.setCompoundDrawables(null, null, null, null);
            localc.IiJ.setVisibility(0);
            localc.IiG.setVisibility(0);
            if ((localg == null) || (!localg.CC())) {
              break label1692;
            }
            a(parama1, localc.qTn, parambo, localb, localg.field_packageName, parambo.TA());
            label765:
            localc.IiG.setImageResource(2131231697);
            a(parama1, localc.IiG, localb.appId);
            i = 1;
          }
        }
        for (;;)
        {
          label793:
          if (localb.awo())
          {
            localc.IiJ.setVisibility(8);
            i = 0;
          }
          for (;;)
          {
            localc.IiJ.setBackgroundResource(2131233299);
            bool1 = false;
            localc.IiE.setVisibility(0);
            if ((!localb.awp()) && (this.opt))
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
                      if (!e.b.aQG(parambo.TD())) {
                        localObject2 = o.aFx().e(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                      }
                    }
                  }
                }
              }
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localBitmap = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, false, com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 1));
                localc.IiE.setImageBitmap(localBitmap);
                label986:
                if (localb.type != 3) {
                  break label1904;
                }
                localc.Ija.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  private boolean Ikb = false;
                  
                  public final boolean onPreDraw()
                  {
                    AppMethodBeat.i(36771);
                    if (this.Ikb)
                    {
                      localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                    localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.Ikb = true;
                    int i = com.tencent.mm.cc.a.fromDPToPix(parama1.HZF.getContext(), 24);
                    Bitmap localBitmap = this.val$bitmap;
                    Object localObject;
                    if (localBitmap != null)
                    {
                      localObject = localBitmap;
                      if (!localBitmap.isRecycled()) {}
                    }
                    else
                    {
                      localObject = com.tencent.mm.sdk.platformtools.f.aH(parama1.HZF.getContext().getResources().getColor(2131100129), i, i);
                    }
                    int j = ((Bitmap)localObject).getHeight();
                    if (i > j) {
                      i = j;
                    }
                    for (;;)
                    {
                      localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.aB(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                      j = localc.Ija.getHeight();
                      int k = localc.Ija.getWidth();
                      i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166037);
                      }
                      localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231553, j, i));
                      localc.Ija.setBackgroundDrawable((Drawable)localObject);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                  }
                });
                if (!aj.DT()) {
                  break label1893;
                }
                localc.IiJ.setBackgroundResource(2131233299);
                label1036:
                if ((localb.eSb != null) && (localb.eSb.length() != 0)) {
                  break label1931;
                }
                localc.IiR.setVisibility(8);
                label1065:
                localc.IiQ.setOnClickListener(null);
                localc.IiU.setVisibility(0);
                localc.IiL.setVisibility(8);
                localc.IiX.setVisibility(0);
                localc.IiV.setVisibility(8);
              }
            }
            label1328:
            label1493:
            label1893:
            label5991:
            switch (localb.type)
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
              i = j;
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
                    break label7256;
                  }
                  localc.IiK.setVisibility(0);
                  localc.IiK.setMaxLines(2);
                  localc.IiK.setText(localb.title);
                  localc.IiF.setVisibility(8);
                  if (bool1)
                  {
                    if ((localb.type != 33) && (localb.type != 36)) {
                      break label7269;
                    }
                    paramString = o.aFx().Cq(parambo.TD());
                    localc.IiE.setImageResource(2131689584);
                    com.tencent.mm.modelappbrand.a.b.aAS().a(localc.IiE, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(50, 50));
                  }
                  if (localb.type == 44) {
                    e.c.a(parama1, localc, localb);
                  }
                }
                if (parama1.foQ()) {
                  break label7446;
                }
                if (!com.tencent.mm.pluginsdk.model.app.h.k(localg)) {
                  break label7430;
                }
                localc.IiT.setVisibility(0);
                c(parama1, localc.IiT, bj.a(localb, parambo));
                localObject2 = parama;
                if (i == 0)
                {
                  localc.IiZ.setTag(localObject2);
                  localc.IiZ.setOnClickListener(d(parama1));
                }
                if (this.opt)
                {
                  localc.IiZ.setOnLongClickListener(c(parama1));
                  localc.IiZ.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
                }
                AppMethodBeat.o(36795);
                return;
                ac.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambo.Tz()), paramString });
                localObject3 = null;
                localb = null;
                break;
                localObject2 = localg.field_appName;
                break label558;
                localc.qTn.setText((CharSequence)localObject2);
                break label690;
                a(parama1, localc.qTn, localb.appId);
                break label765;
                if (localb.type == 24)
                {
                  localc.qTn.setText(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131758845));
                  localc.IiJ.setVisibility(0);
                  localc.qTn.setVisibility(0);
                  localc.IiG.setVisibility(8);
                  i = 1;
                  break label793;
                }
                if ((localb.type == 19) || (((com.tencent.mm.ah.t)localObject3).hla == 19))
                {
                  localc.qTn.setText(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757208));
                  localc.IiJ.setVisibility(0);
                  localc.qTn.setVisibility(0);
                  localc.IiG.setVisibility(8);
                  i = 1;
                  break label793;
                }
                if (e.a(localb, localc)) {
                  break label7482;
                }
                localc.IiJ.setVisibility(8);
                localc.qTn.setVisibility(8);
                localc.IiG.setVisibility(8);
                i = 0;
                break label793;
                bool1 = true;
                break label986;
                localc.IiJ.setBackgroundResource(2131231682);
                break label1036;
                localc.IiE.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                bool1 = false;
                break label1036;
                localc.IiR.setVisibility(0);
                b(parama1, localc.IiR, bj.aQO(localb.eSb));
                break label1065;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiF.setVisibility(0);
                  localc.IiF.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.ijE.setVisibility(0);
                  localc.ijE.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.IiK.setVisibility(8);
                  localc.IiL.setVisibility(4);
                  localc.IiQ.setVisibility(0);
                  if (!parambo.Tz().equals(parama.IhX)) {
                    break label2252;
                  }
                  localc.IiQ.setImageResource(2131233393);
                  localc.ijE.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label2266;
                    }
                    localc.IiE.setImageResource(2131689564);
                  }
                }
                for (;;)
                {
                  parama = new e.g();
                  parama.msgId = parambo.Tz();
                  parama.dqf = parambo.getContent();
                  parama.dmK = parambo.TD();
                  localc.IiQ.setTag(parama);
                  localc.IiQ.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmc());
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.IiF.setVisibility(8);
                  break label2010;
                  localc.IiQ.setImageResource(2131233395);
                  break label2107;
                  localc.IiE.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiF.setVisibility(0);
                  localc.IiF.setMaxLines(2);
                }
                for (;;)
                {
                  localc.ijE.setVisibility(0);
                  localc.IiK.setVisibility(8);
                  localc.IiQ.setVisibility(8);
                  localc.IiL.setVisibility(4);
                  localc.ijE.setMaxLines(2);
                  localc.ijE.setText(bs.qz(localb.hhF));
                  e.c.a(localc, str, localb.hhF);
                  e.c.a(localc, Boolean.TRUE, parambo, localb.cZa, localb.title);
                  if (!bool1) {
                    break label7462;
                  }
                  if (!e.b.aQF(localb.hhG)) {
                    break label2463;
                  }
                  localc.IiE.setImageResource(2131231063);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.IiF.setVisibility(8);
                }
                localc.IiE.setImageResource(com.tencent.mm.pluginsdk.model.q.aGb(localb.hhG));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                continue;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiF.setVisibility(0);
                  localc.ijE.setVisibility(0);
                  localc.IiK.setVisibility(8);
                  localc.IiQ.setVisibility(0);
                  localc.IiQ.setImageResource(2131234464);
                  localc.IiL.setVisibility(4);
                  localc.ijE.setMaxLines(2);
                  if (!bool1) {
                    break label7462;
                  }
                  paramString = new com.tencent.mm.av.a.a.c.a();
                  paramString.pe(2131689584).aFQ().de(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50)).aFO().aFR().ak(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 1));
                  localObject2 = o.aFB();
                  if (!bs.isNullOrNil(localb.thumburl)) {
                    break label2711;
                  }
                }
                for (parama = localb.hhM;; parama = localb.thumburl)
                {
                  ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.IiE, paramString.aFT());
                  localc.IiQ.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.IiF.setVisibility(8);
                  break label2519;
                }
                if (localb != null) {
                  e.a(paramString, parama1, parambo, localb);
                }
                parama = (com.tencent.mm.ah.e)localb.ao(com.tencent.mm.ah.e.class);
                if ((parama != null) && (parama.hha == 1) && (parama.hgY == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP()))
                {
                  e.c.a(parama1, localc, localb, parambo, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                }
                else
                {
                  if ((i == 0) && (ae.a(localb, parama)))
                  {
                    localc.IjJ.setVisibility(0);
                    localc.IjO.setVisibility(0);
                    ae.a(parama1.getContext(), localb, localc.IjL, localc.IjM);
                    ae.b(localc.IjN, localb);
                  }
                  localc.IiF.setVisibility(8);
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.IiK.setMaxLines(2);
                    localc.IiK.setVisibility(0);
                    localc.IiK.setText(localb.getTitle());
                    localc.ijE.setMaxLines(3);
                    if (!e.k(localb)) {
                      break label3126;
                    }
                    localc.IiQ.setVisibility(0);
                    localc.IiQ.setImageResource(2131234464);
                    localc.IiL.setVisibility(4);
                    if (!bool1) {
                      break label7462;
                    }
                    paramString = new com.tencent.mm.av.a.a.c.a();
                    paramString.pe(2131689584).aFQ().CB(com.tencent.mm.plugin.image.d.cTH()).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).de(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50)).aFO().aFR().ak(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 1));
                    localObject2 = o.aFB();
                    if (!bs.isNullOrNil(localb.thumburl)) {
                      break label3139;
                    }
                  }
                  for (parama = localb.hhM;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.IiE, paramString.aFT());
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                    localc.IiK.setVisibility(8);
                    break label2929;
                    localc.IiQ.setVisibility(8);
                    break label2966;
                  }
                  if (localc.IiZ.getLayoutParams() != null)
                  {
                    localc.IiZ.getLayoutParams().width = -2;
                    localc.IiZ.requestLayout();
                  }
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(localb.hke);
                  final boolean bool2;
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label3496;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.Ija.setVisibility(8);
                    localc.Ijm.setVisibility(0);
                    localc.Ijg.setVisibility(8);
                    localc.Ijt.setVisibility(8);
                    if (!e.a(parambo, localb, parama1)) {
                      break label3506;
                    }
                    localc.IjQ.setVisibility(0);
                    bool2 = bs.isNullOrNil(parambo.TI());
                    localc.IjQ.setTag(parambo);
                    localc.IjQ.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(179950);
                        e.a((bo)paramAnonymousView.getTag(), localc, parama1);
                        AppMethodBeat.o(179950);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    localc.Ijq.setText(localb.title);
                    e.e(localc.Ijq, localb.title);
                    localc.Ijk.setText(parama);
                    e.a(localc.Ijl, localb);
                    o.aFB().a(paramString, localc.Ijj, ab.d.fvC);
                    parama = o.aFx().Cq(parambo.TD());
                    localc.Ijn.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.aAS().a(localc.Ijn, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label3519;
                    }
                    localc.jPU.setVisibility(0);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                    parama = localb.dvm;
                    break label3212;
                    paramString = localb.hks;
                    break label3224;
                    localc.IjQ.setVisibility(8);
                  }
                  localc.jPU.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  continue;
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(localb.hke);
                  ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).Iz(localb.hke);
                  switch (localb.hkg)
                  {
                  default: 
                    paramInt = 1;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                  case 2: 
                  case 3: 
                    if (localc.IiZ.getLayoutParams() != null)
                    {
                      localc.IiZ.getLayoutParams().width = -2;
                      localc.IiZ.requestLayout();
                    }
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label3972;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.Ija.setVisibility(8);
                      localc.Ijm.setVisibility(0);
                      localc.Ijg.setVisibility(8);
                      localc.Ijt.setVisibility(8);
                      localc.Ijq.setText(localb.title);
                      e.e(localc.Ijq, localb.title);
                      localc.Ijk.setText(parama);
                      e.a(localc.Ijl, localb);
                      o.aFB().a(paramString, localc.Ijj, ab.d.fvC);
                      parama = o.aFx().Cq(parambo.TD());
                      localc.Ijn.setImageBitmap(null);
                      localc.Ijn.setVisibility(4);
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label3982;
                      }
                      localc.jPU.setVisibility(0);
                      if (!e.a(parambo, localb, parama1)) {
                        break label3995;
                      }
                      localc.IjQ.setVisibility(0);
                      bool2 = bs.isNullOrNil(parambo.TI());
                      localc.IjQ.setTag(parambo);
                      localc.IjQ.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymousView)
                        {
                          AppMethodBeat.i(185027);
                          e.a((bo)paramAnonymousView.getTag(), localc, parama1);
                          AppMethodBeat.o(185027);
                        }
                      });
                      e.a(bool2, localc, parama1);
                    }
                    for (;;)
                    {
                      bool2 = e.l(localb);
                      com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
                      {
                        public final String Ap()
                        {
                          AppMethodBeat.i(36781);
                          String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                          AppMethodBeat.o(36781);
                          return str;
                        }
                        
                        public final void E(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36779);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.Ijn.setImageBitmap(paramAnonymousBitmap);
                            localc.Ijn.setVisibility(0);
                            localc.Ijp.setVisibility(4);
                            if (bool2)
                            {
                              localc.Ijo.setImageDrawable(com.tencent.mm.cc.a.l(parama1.HZF.getContext(), 2131691166));
                              localc.Ijo.setVisibility(0);
                              AppMethodBeat.o(36779);
                              return;
                            }
                            localc.Ijo.setVisibility(8);
                            AppMethodBeat.o(36779);
                            return;
                          }
                          localc.Ijn.setVisibility(4);
                          localc.Ijp.setVisibility(0);
                          localc.Ijo.setVisibility(8);
                          AppMethodBeat.o(36779);
                        }
                        
                        public final void aBa()
                        {
                          AppMethodBeat.i(36778);
                          AppMethodBeat.o(36778);
                        }
                        
                        public final void of()
                        {
                          AppMethodBeat.i(36780);
                          AppMethodBeat.o(36780);
                        }
                      }, e.access$600(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      break;
                      parama = localb.dvm;
                      break label3671;
                      paramString = localb.hks;
                      break label3683;
                      localc.jPU.setVisibility(8);
                      break label3832;
                      localc.IjQ.setVisibility(8);
                    }
                  case 1: 
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4167;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.Ija.setVisibility(8);
                      localc.Ijm.setVisibility(8);
                      localc.Ijg.setVisibility(0);
                      localc.Iji.setText(parama);
                      localc.Ijt.setVisibility(8);
                      if (!bs.isNullOrNil(paramString)) {
                        break label4173;
                      }
                      parama = o.aFx().Cq(parambo.TD());
                      com.tencent.mm.modelappbrand.a.b.aAS().a(localc.Ijh, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
                    }
                    for (;;)
                    {
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4196;
                      }
                      localc.Ijs.setVisibility(0);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      break;
                      parama = localb.title;
                      break label4019;
                      paramString = null;
                      break label4031;
                      com.tencent.mm.modelappbrand.a.b.aAS().a(localc.Ijh, paramString, com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
                    }
                    localc.Ijs.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                  case 0: 
                    localc.IiJ.setVisibility(0);
                    localc.IiG.setVisibility(0);
                    localc.IiG.setBackground(null);
                    localc.IiG.setImageResource(2131689681);
                    e.a(localc.qTn, localb);
                    break label1328;
                    parama = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
                    paramString = localb.hks;
                    localObject2 = localb.dvm;
                    str = localb.title;
                    localObject3 = localb.description;
                    if ((parama == null) || (bs.isNullOrNil(parama.hgj)) || (bs.isNullOrNil(parama.hgl)))
                    {
                      ac.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                      break label1328;
                    }
                    localc.Ijz.setText((CharSequence)localObject2);
                    localc.Ija.setVisibility(8);
                    localc.Ijm.setVisibility(8);
                    localc.Ijg.setVisibility(8);
                    localc.IjA.setVisibility(0);
                    localc.Ijw.setVisibility(8);
                    localc.IjA.setImageDrawable(com.tencent.mm.cc.a.l(parama1.getContext(), 2131691166));
                    localc.Ijt.setVisibility(0);
                    localc.Iju.setText(str);
                    localc.Ijv.setText((CharSequence)localObject3);
                    o.aFA().a(paramString, new p.a()
                    {
                      public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                      {
                        AppMethodBeat.i(36783);
                        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(36782);
                            if (!paramAnonymousBitmap.isRecycled()) {
                              e.d.7.this.IjW.Ijy.setImageBitmap(paramAnonymousBitmap);
                            }
                            AppMethodBeat.o(36782);
                          }
                        });
                        AppMethodBeat.o(36783);
                      }
                    });
                    paramString = com.tencent.mm.modelappbrand.a.b.aAS().a(parama.hgl, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hsa));
                    if (paramString != null)
                    {
                      localc.Ijx.setImageBitmap(paramString);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                    }
                    else
                    {
                      com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
                      {
                        public final String Ap()
                        {
                          AppMethodBeat.i(36786);
                          String str = "CHAT#" + com.tencent.mm.plugin.appbrand.z.m.cE(this);
                          AppMethodBeat.o(36786);
                          return str;
                        }
                        
                        public final void E(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36785);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.Ijx.setImageBitmap(paramAnonymousBitmap);
                            localc.Ijx.setVisibility(0);
                          }
                          AppMethodBeat.o(36785);
                        }
                        
                        public final void aBa()
                        {
                          AppMethodBeat.i(36784);
                          localc.Ijx.setVisibility(4);
                          AppMethodBeat.o(36784);
                        }
                        
                        public final void of()
                        {
                          AppMethodBeat.i(185028);
                          ac.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                          com.tencent.mm.plugin.report.service.h.wUl.dB(808, 2);
                          AppMethodBeat.o(185028);
                        }
                      }, parama.hgl, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hsa));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      paramInt = 1;
                      localc.IiK.setMaxLines(2);
                      localc.ijE.setMaxLines(3);
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      localc.IiF.setVisibility(8);
                      if ((localb.title != null) && (localb.title.trim().length() > 0))
                      {
                        localc.IiK.setMaxLines(2);
                        localc.IiK.setVisibility(0);
                        localc.IiK.setText(localb.getTitle());
                      }
                      for (;;)
                      {
                        localc.ijE.setMaxLines(3);
                        localc.IiQ.setVisibility(8);
                        localc.IiL.setVisibility(4);
                        if (!bool1) {
                          break label7462;
                        }
                        parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label4775;
                        }
                        localc.IiE.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                        break;
                        localc.IiK.setVisibility(8);
                      }
                      localc.IiE.setImageBitmap(parama);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      localc.IiK.setVisibility(0);
                      if (localb.hie == 1) {
                        localc.IiK.setText(2131762858);
                      }
                      for (;;)
                      {
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.IiF.setVisibility(0);
                          localc.IiF.ar(localb.getTitle());
                        }
                        localc.ijE.setMaxLines(4);
                        localc.IiL.setVisibility(4);
                        localc.IiQ.setVisibility(8);
                        if (!bool1) {
                          break label7462;
                        }
                        parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                        if ((parama == null) || (parama.isRecycled())) {
                          break label5011;
                        }
                        localc.IiE.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                        break;
                        if (localb.hie == 2) {
                          localc.IiK.setText(2131762860);
                        } else if (localb.hie == 3) {
                          localc.IiK.setText(2131762859);
                        } else {
                          localc.IiK.setText(2131762861);
                        }
                      }
                      localc.IiE.setImageResource(2131689584);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      localc.IiF.setVisibility(0);
                      localc.IiF.ar(localb.getTitle());
                      localc.IiK.setVisibility(0);
                      localc.IiK.setText(2131757247);
                      localc.ijE.setMaxLines(4);
                      localc.IiL.setVisibility(4);
                      localc.IiQ.setVisibility(8);
                      if (!bool1) {
                        break label7462;
                      }
                      parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                      if ((parama != null) && (!parama.isRecycled()))
                      {
                        localc.IiE.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                      }
                      else
                      {
                        localc.IiE.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                        continue;
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.IiF.setVisibility(0);
                          localc.IiF.ar(localb.getTitle());
                          localc.IiK.setVisibility(8);
                        }
                        localc.ijE.setMaxLines(4);
                        localc.IiL.setVisibility(4);
                        localc.IiQ.setVisibility(8);
                        if (!bool1) {
                          break label7462;
                        }
                        parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          localc.IiE.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = j;
                        }
                        else
                        {
                          localc.IiE.setImageResource(2131689584);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = j;
                          continue;
                          if ((localb.title != null) && (localb.title.length() > 0)) {
                            localc.IiF.setVisibility(0);
                          }
                          for (;;)
                          {
                            localc.ijE.setVisibility(0);
                            localc.IiK.setVisibility(8);
                            localc.IiQ.setVisibility(8);
                            localc.IiL.setVisibility(4);
                            localc.ijE.setMaxLines(2);
                            if (!bool1) {
                              break label7462;
                            }
                            parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                            if ((parama != null) && (!parama.isRecycled())) {
                              break label5487;
                            }
                            localc.IiE.setImageResource(2131689584);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = j;
                            break;
                            localc.IiF.setVisibility(8);
                          }
                          localc.IiE.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = j;
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
                localc.IiF.setVisibility(0);
                localc.ijE.setVisibility(0);
                localc.IiK.setVisibility(8);
                localc.IiQ.setVisibility(8);
                localc.IiL.setVisibility(4);
                localc.ijE.setMaxLines(2);
                if (bool1)
                {
                  parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5721;
                  }
                  localc.IiE.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bj(parambo, false, paramInt, "", false, localb.title, localb.dvl, localb.dvm, localb.title, localb.him, localb.url, false, false);
                localc.IiZ.setTag(parama);
                localc.IiZ.setOnClickListener(i(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.IiF.setVisibility(8);
                break label5536;
                localc.IiE.setImageBitmap(parama);
              }
            case 25: 
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.IiF.setVisibility(0);
                localc.ijE.setVisibility(0);
                localc.IiK.setVisibility(8);
                localc.IiQ.setVisibility(8);
                localc.IiL.setVisibility(4);
                localc.ijE.setMaxLines(2);
                if (bool1)
                {
                  parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5951;
                  }
                  localc.IiE.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bj(parambo, paramInt, "", parama1.fmy(), localb.dvl, localb.dvm, localb.title, localb.hjS, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.IiZ.setTag(parama);
                localc.IiZ.setOnClickListener(j(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.IiF.setVisibility(8);
                break label5761;
                localc.IiE.setImageBitmap(parama);
              }
            case 26: 
            case 27: 
              label1391:
              label1904:
              label2929:
              label3832:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.IiF.setVisibility(0);
                localc.ijE.setVisibility(0);
                localc.IiK.setVisibility(8);
                localc.IiQ.setVisibility(8);
                localc.IiL.setVisibility(4);
                localc.ijE.setMaxLines(2);
                if (bool1)
                {
                  parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6262;
                  }
                  localc.IiE.setImageResource(2131689584);
                }
                parama = new bj();
                parama.dpq = parambo;
                parama.HJB = false;
                parama.position = paramInt;
                parama.IqQ = false;
                parama.title = parama1.fmy();
                parama.dvl = localb.dvl;
                parama.dvm = localb.dvm;
                parama.IqR = localb.title;
                if (localb.type != 26) {
                  break label6274;
                }
                parama.tid = localb.tid;
                parama.hjT = localb.hjT;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.IiZ.setOnClickListener(k(parama1));
                paramInt = 1;
              }
              label5487:
              break;
            }
            for (;;)
            {
              label1554:
              label1692:
              label1709:
              label2010:
              label3683:
              label4196:
              localc.IiZ.setTag(parama);
              label1669:
              label1679:
              label2107:
              label2252:
              label2266:
              j = 0;
              label1931:
              label2463:
              label2519:
              label3671:
              label5721:
              i = paramInt;
              label2711:
              label3126:
              label3139:
              label4167:
              label4173:
              paramInt = j;
              label2966:
              label3224:
              label3496:
              label3506:
              label3519:
              label4031:
              label6085:
              break;
              label3212:
              label3982:
              label3995:
              label4019:
              label5951:
              localc.IiF.setVisibility(8);
              label3972:
              label4775:
              break label5991;
              label5011:
              label5536:
              label6262:
              localc.IiE.setImageBitmap(parama);
              label5761:
              break label6085;
              label6274:
              if (localb.type == 27)
              {
                parama.tid = localb.tid;
                parama.hjT = localb.hjT;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.IiZ.setOnClickListener(l(parama1));
                paramInt = 1;
                continue;
                localc.IiF.setVisibility(0);
                localc.IiF.ar(localb.description);
                localc.ijE.setText(localb.hiS);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiK.setVisibility(0);
                  localc.IiK.setText(localb.title);
                }
                for (;;)
                {
                  localc.ijE.setMaxLines(4);
                  localc.IiL.setVisibility(4);
                  localc.IiQ.setVisibility(8);
                  if (!bool1) {
                    break label7462;
                  }
                  parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6523;
                  }
                  localc.IiE.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.IiK.setVisibility(8);
                }
                label6523:
                localc.IiE.setImageResource(2131689584);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                localc.IiF.setVisibility(8);
                localc.IiK.setVisibility(0);
                if ((localb.title != null) && (localb.title.trim().length() > 0)) {
                  localc.IiK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.IiK.getContext(), localb.title, localc.IiK.getTextSize()));
                }
                for (;;)
                {
                  localc.ijE.setMaxLines(3);
                  localc.IiQ.setVisibility(8);
                  localc.IiL.setVisibility(4);
                  if (bool1)
                  {
                    localc.IiE.setVisibility(8);
                    localc.IiY.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, parambo, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.IiK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.IiK.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759034), localc.IiK.getTextSize()));
                }
                e.c.a(parama1, localc, localb, bool1);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiF.setVisibility(0);
                  if (!bs.isNullOrNil(localb.titleColor))
                  {
                    localc.IiF.setTextColor(bs.cG(localb.titleColor, parama1.getContext().getResources().getColor(2131100711)));
                    label6825:
                    localc.ijE.setMaxLines(2);
                    localc.ijE.setVisibility(0);
                    if (bs.isNullOrNil(localb.hjb)) {
                      break label7121;
                    }
                    localc.ijE.setTextColor(bs.cG(localb.hjb, parama1.getContext().getResources().getColor(2131100469)));
                    label6883:
                    localc.IiK.setVisibility(8);
                    localc.IiL.setVisibility(4);
                    localc.IiQ.setVisibility(8);
                    localc.IiJ.setVisibility(0);
                    localc.qTn.setVisibility(0);
                    if (bs.isNullOrNil(localb.hiX)) {
                      break label7145;
                    }
                    localc.qTn.setText(localb.hiX);
                  }
                }
                for (;;)
                {
                  if (this.opt)
                  {
                    parama = o.aFx().e(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = com.tencent.mm.sdk.platformtools.f.a(parama, false, parama.getWidth() / 2);
                      localc.IiE.setImageBitmap(paramString);
                    }
                    if (!bs.isNullOrNil(localb.hja))
                    {
                      o.aFB().a(localb.hja, new ImageView(parama1.getContext()), new com.tencent.mm.av.a.a.c.a().aFP().aFT(), new com.tencent.mm.av.a.c.h()
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
                            localc.Ija.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36787);
                                e.d.9.this.IjW.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.d.9.this.IjW.Ija.getHeight();
                                int k = e.d.9.this.IjW.Ija.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cc.a.au(e.d.9.this.Iiv.HZF.getContext(), 2131166036);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cc.a.au(e.d.9.this.Iiv.HZF.getContext(), 2131166037);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b(paramAnonymousString, 2131231553, j, i));
                                e.d.9.this.IjW.Ija.setBackgroundDrawable(localBitmapDrawable);
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
                      i = j;
                      break;
                      localc.IiF.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label6825;
                      localc.IiF.setVisibility(8);
                      break label6825;
                      label7121:
                      localc.ijE.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                      break label6883;
                      label7145:
                      localc.qTn.setText(2131757206);
                      continue;
                    }
                    localc.Ija.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean Ikb = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36789);
                        if (this.Ikb)
                        {
                          localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                        localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.Ikb = true;
                        int i = com.tencent.mm.cc.a.fromDPToPix(parama1.HZF.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = com.tencent.mm.sdk.platformtools.f.aH(parama1.HZF.getContext().getResources().getColor(2131100129), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.aB(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                          j = localc.Ija.getHeight();
                          int k = localc.Ija.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166036);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166037);
                          }
                          localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231553, j, i));
                          localc.Ija.setBackgroundDrawable((Drawable)localObject);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                      }
                    });
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                  }
                }
                localc.IiE.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                if (((com.tencent.mm.ah.t)localObject3).hla == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  label7256:
                  localc.IiK.setVisibility(8);
                  break label1391;
                  label7269:
                  localObject1 = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = o.aFx().e(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.IiE.setImageBitmap(paramString);
                    break label1493;
                  }
                  if (!bs.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.av.a.a.c.a();
                    ((com.tencent.mm.av.a.a.c.a)localObject1).pe(2131100141).aFQ().aFO();
                    o.aFB().a(paramString, localc.IjD, ((com.tencent.mm.av.a.a.c.a)localObject1).aFT());
                    break label1493;
                  }
                  localc.IiE.setImageResource(2131231063);
                  break label1493;
                  label7430:
                  localc.IiT.setVisibility(8);
                  localObject2 = parama;
                  break label1554;
                  label7446:
                  localc.IiT.setVisibility(8);
                  localObject2 = parama;
                  break label1554;
                }
                label7462:
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
              }
              paramInt = 0;
            }
          }
          label7482:
          i = 1;
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36796);
      int i = ((bj)paramView.getTag()).position;
      int j = com.tencent.mm.pluginsdk.model.app.m.aGm(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
      k.b localb = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.k(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.j.aU(parambo)))
      {
        if (localb.type != 6) {
          break label628;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.m.aGn(localb.cZa);
        if (((localc == null) || (!e.b.e(parambo, localc.field_fileFullPath))) && (!parambo.fbQ())) {
          paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
        }
      }
      boolean bool1;
      if ((localb.hhF <= 0) || ((localb.hhF > 0) && (j >= 100))) {
        switch (localb.type)
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        label275:
        if ((bool1) && (!this.HNS.foR())) {
          paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.br.d.aCT("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).CC()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new com.tencent.mm.g.a.dy();
          ((com.tencent.mm.g.a.dy)localObject).ddK.msgId = parambo.field_msgId;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((com.tencent.mm.g.a.dy)localObject).ddL.ddj) || (e.b.a(this.HNS.HZF.getContext(), localb))) {
            paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
          }
          if (bk.x(parambo)) {
            paramContextMenu.clear();
          }
          if (!this.HNS.foR()) {
            paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
          }
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {
            paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
          }
          AppMethodBeat.o(36796);
          return true;
          label628:
          paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
          break;
          bool1 = com.tencent.mm.al.f.aCG();
          break label275;
          bool1 = com.tencent.mm.al.f.aCA();
          break label275;
          boolean bool2 = com.tencent.mm.al.f.aCE();
          bool1 = bool2;
          if (bs.aLM(localb.hhG)) {
            break label275;
          }
          paramContextMenu.add(i, 150, 0, this.HNS.HZF.getMMResources().getString(2131757229));
          bool1 = bool2;
          break label275;
          bool1 = com.tencent.mm.al.f.aCx();
          break label275;
          bool1 = com.tencent.mm.al.f.aCw();
          break label275;
          bool1 = com.tencent.mm.al.f.aCC();
          break label275;
          bool1 = com.tencent.mm.al.f.aCy();
          break label275;
          if ((localb.hiT != 5) && (localb.hiT != 6) && (localb.hiT != 2)) {
            break label916;
          }
          if ((localb.hiT != 2) || (bk.x(parambo))) {
            paramContextMenu.clear();
          }
          paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
          AppMethodBeat.o(36796);
          return false;
          paramContextMenu.clear();
          paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
          AppMethodBeat.o(36796);
          return false;
          paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
        }
        label916:
        bool1 = false;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
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
        paramMenuItem = bk.C(parambo);
        if (bs.isNullOrNil(paramMenuItem)) {
          e.b.a(parama, parambo, b(parama, parambo));
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.HZF.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36790);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(36790);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36772);
              e.b.a(parama, parambo, e.d.this.b(parama, parambo));
              com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(36772);
            }
          });
        }
      case 114: 
        paramMenuItem = parambo.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = k.b.vA(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          al.a(parambo, bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.d(parambo, parama.HZF.getContext());
          continue;
          al.b(parambo, bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.a(parambo, parama.HZF.getContext(), b(parama, parambo), parama.foQ());
          continue;
          al.p(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.c(parambo, bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.c(parambo, parama.HZF.getContext());
        }
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", parambo.field_msgId);
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36797);
      return false;
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(36798);
      com.tencent.mm.modelstat.a.a(parambo, a.a.hUB);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      Object localObject = parambo.field_content;
      paramView = Boolean.FALSE;
      if (localObject == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      final k.b localb = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      localObject = com.tencent.mm.ah.t.vF((String)localObject);
      if (localb == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      if (((com.tencent.mm.ah.t)localObject).hla != 0)
      {
        paramView = Boolean.TRUE;
        localb.type = ((com.tencent.mm.ah.t)localObject).hla;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.h.k(localb.appId, false, false);
      final String str = d(parama, parambo);
      if (localObject != null) {
        a(parama, localb, str, (com.tencent.mm.pluginsdk.model.app.g)localObject, parambo.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (localb.type)
      {
      default: 
      case 3: 
      case 4: 
      case 6: 
      case 7: 
      case 10: 
      case 20: 
      case 13: 
      case 19: 
      case 16: 
      case 33: 
      case 44: 
      case 48: 
        for (;;)
        {
          i = 1;
          do
          {
            while ((i != 0) && (e(localb, parama, this, parambo)))
            {
              AppMethodBeat.o(36798);
              return true;
              com.tencent.mm.plugin.report.service.h.wUl.f(13043, new Object[] { Integer.valueOf(2), localb.description, localb.appId });
              boolean bool = a(localb, parama, this, parambo);
              AppMethodBeat.o(36798);
              return bool;
              if (!this.opt)
              {
                com.tencent.mm.ui.base.t.g(parama.HZF.getContext(), parama.HZF.getContentView());
                AppMethodBeat.o(36798);
                return true;
              }
              paramView = new Intent();
              paramView.setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramView.putExtra("scene", 2);
              paramView.putExtra("app_msg_id", parambo.field_msgId);
              paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36798);
              return true;
              if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).CC()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if ((localb.cZa == null) || (localb.cZa.length() == 0)) {
                ((com.tencent.mm.ui.chatting.c.b.b)parama.bf(com.tencent.mm.ui.chatting.c.b.b.class)).a(parambo, new am()
                {
                  public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                  {
                    AppMethodBeat.i(196693);
                    if (this.nnz != null)
                    {
                      if (paramAnonymousBoolean1)
                      {
                        e.d.a(parama, localb, str, this.nnz, parambo.field_msgSvrId, 3, parama.getTalkerUserName());
                        AppMethodBeat.o(196693);
                        return;
                      }
                      e.d.a(parama, localb, str, this.nnz, parambo.field_msgSvrId, 7, parama.getTalkerUserName());
                    }
                    AppMethodBeat.o(196693);
                  }
                });
              }
              for (;;)
              {
                AppMethodBeat.o(36798);
                return true;
                if (!this.opt)
                {
                  com.tencent.mm.ui.base.t.g(parama.HZF.getContext(), parama.HZF.getContentView());
                  AppMethodBeat.o(36798);
                  return true;
                }
                paramView = new Intent();
                paramView.setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                paramView.putExtra("app_msg_id", parambo.field_msgId);
                paramView.putExtra("scene", 2);
                parama.HZF.startActivityForResult(paramView, 210);
              }
              if (bs.isNullOrNil(localb.hif))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_Product_xml", localb.hif);
              paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
              if (parambo.field_imgPath == null) {
                paramView.putExtra("key_ProductUI_chatting_msgId", parambo.field_msgId);
              }
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "scanner", ".ui.ProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bs.isNullOrNil(localb.hii))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_TV_xml", localb.hii);
              paramView.putExtra("key_TV_getProductInfoScene", 1);
              if (parambo.field_imgPath == null) {
                paramView.putExtra("key_TVInfoUI_chatting_msgId", parambo.field_msgId);
              }
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "shake", ".ui.TVInfoUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bs.isNullOrNil(localb.hil))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_product_info", localb.hil);
              paramView.putExtra("key_product_scene", 1);
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "product", ".ui.MallProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              localObject = new Intent();
              ((Intent)localObject).putExtra("message_id", parambo.field_msgId);
              ((Intent)localObject).putExtra("record_xml", localb.hij);
              ((Intent)localObject).putExtra("big_appmsg", paramView);
              i = com.tencent.mm.model.x.aE(b(parama, parambo), parama.getTalkerUserName());
              ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambo.field_msgSvrId));
              ((Intent)localObject).putExtra("preUsername", b(parama, parambo));
              ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
              ((Intent)localObject).putExtra("preChatTYPE", i);
              e.a.a((Intent)localObject, parama, parambo, this);
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
              AppMethodBeat.o(36798);
              return true;
              if (bs.isNullOrNil(localb.dkV))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_card_app_msg", localb.dkV);
              paramView.putExtra("key_from_scene", localb.hiT);
              com.tencent.mm.br.d.b(parama.HZF.getContext(), "card", ".ui.CardDetailUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (d(localb, parama, this, parambo))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              i = 1;
            }
          } while (c(localb, parama, this, parambo));
        }
      case 36: 
        b(localb, parama, this, parambo);
        AppMethodBeat.o(36798);
        return true;
      case 24: 
        e.a(localb, parama, parambo);
        AppMethodBeat.o(36798);
        return true;
      }
      paramView = new Intent();
      paramView.putExtra("key_from_user_name", b(parama, parambo));
      paramView.putExtra("key_biz_uin", localb.hiV);
      paramView.putExtra("key_order_id", localb.hiW);
      if ((parambo.field_talker != null) && (!parambo.field_talker.equals("")) && (w.sQ(parambo.field_talker))) {
        paramView.putExtra("key_chatroom_name", parambo.field_talker);
      }
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
      AppMethodBeat.o(36798);
      return true;
      AppMethodBeat.o(36798);
      return false;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553));
    }
    
    public final boolean fqu()
    {
      return false;
    }
  }
  
  public static final class e
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    protected s.i IjY;
    protected s.l IjZ;
    protected s.j Ika;
    
    private static void a(e.c paramc, com.tencent.mm.ui.chatting.c.b.i parami, bo parambo)
    {
      AppMethodBeat.i(36827);
      if ((parambo.field_status == 2) && (a(parami, parambo.field_msgId)))
      {
        if (paramc.Ijf != null)
        {
          paramc.Ijf.setVisibility(0);
          AppMethodBeat.o(36827);
        }
      }
      else if (paramc.Ijf != null) {
        paramc.Ijf.setVisibility(8);
      }
      AppMethodBeat.o(36827);
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(161906);
      if ((bs.isNullOrNil(paramb.hkf)) && (bs.isNullOrNil(paramb.hke)))
      {
        parambo = paramb.url;
        if (parama.foQ()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.P(parambo, paramc);
          parambo = new Intent();
          parambo.putExtra("rawUrl", paramc);
          parambo.putExtra("webpageTitle", paramb.title);
          parambo.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", parambo);
          AppMethodBeat.o(161906);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.b(parama, parambo);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.foQ()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.g.F(parambo));
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama.HZF.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambo), parama.foQ(), paramb, localBundle);
        AppMethodBeat.o(161906);
        return true;
        if (w.wH(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean f(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(36831);
      if (paramc.a(parama, paramb, parambo))
      {
        AppMethodBeat.o(36831);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.P(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.P(paramb.hhE, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.HZF.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambo.field_msgId, parambo.field_msgSvrId, parambo);
        AppMethodBeat.o(36831);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean g(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(36832);
      ac.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.hke, paramb.hkd, paramb.hkf, paramb.url, Integer.valueOf(paramb.hkq), paramb.hkh });
      if ((44 == paramb.type) && ((!paramb.et(false)) || (bs.isNullOrNil(paramb.r(parama.HZF.getContext(), false)))))
      {
        AppMethodBeat.o(36832);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambo);
      Bundle localBundle = new Bundle();
      int i;
      if ((parama.HZF instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.g.F(parambo));
        switch (paramb.hkg)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cq(parambo);
        if (i != 0) {
          break label577;
        }
        AppMethodBeat.o(36832);
        return true;
        if (parama.foQ())
        {
          i = 2;
          break;
        }
        if (w.wH((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramc = new Intent();
        paramc.putExtra("key_username", paramb.hke);
        if (parama.foQ())
        {
          paramc.putExtra("key_from_scene", 1);
          paramc.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + str);
        }
        for (;;)
        {
          paramc.putExtra("_stat_obj", localBundle);
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.hkf;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).jpa = paramb.hkq;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.hki;
          paramc.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).baT());
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramc);
          i = 0;
          break;
          paramc.putExtra("key_from_scene", 2);
          paramc.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.HZF instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, localBundle);
          i = 0;
        }
        else if (w.wH((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, localBundle);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.foQ(), paramb, localBundle);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.foQ(), paramb, localBundle);
          i = 0;
        }
      }
      label577:
      AppMethodBeat.o(36832);
      return false;
    }
    
    public static boolean h(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(36833);
      Object localObject2 = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
      if ((localObject2 != null) && (!bs.isNullOrNil(((com.tencent.mm.ah.a)localObject2).hgj)) && (!bs.isNullOrNil(((com.tencent.mm.ah.a)localObject2).hgl)))
      {
        String str2 = ((com.tencent.mm.ah.a)localObject2).hgj;
        String str3 = ((com.tencent.mm.ah.a)localObject2).hgi;
        Object localObject1 = ((com.tencent.mm.ah.a)localObject2).dwi;
        String str1;
        int i;
        if (bs.isNullOrNil(((com.tencent.mm.ah.a)localObject2).hgm))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ah.a)localObject2).hgk;
          String str5 = paramb.hkf;
          localObject2 = ((com.tencent.mm.ah.a)localObject2).hgl;
          ac.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { str2, str3, str1, str4, str5, localObject2 });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
          if (!w.sQ(parama.getTalkerUserName())) {
            break label364;
          }
          i = 2;
          label165:
          localh.f(17608, new Object[] { Integer.valueOf(i), str5, Integer.valueOf(1), Integer.valueOf(1) });
          if ((bs.isNullOrNil(str2)) && ((bs.isNullOrNil(str3)) || (!com.tencent.mm.vfs.i.eA(str3)) || (!bs.nullAsNil(com.tencent.mm.vfs.i.aKe(str3)).equals(localObject1)))) {
            break label370;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_chatting_type", paramb.type);
          ((Bundle)localObject1).putString("key_chatting_wording", str1);
          ((Bundle)localObject1).putString("key_chatting_text", str4);
          ((Bundle)localObject1).putString("key_chatting_appid", str5);
          ((Bundle)localObject1).putLong("key_msg_id", parambo.field_msgId);
          ((Bundle)localObject1).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject1).putString("key_sender_username", paramc.b(parama, parambo));
          e.a(parama, str2, str3, (String)localObject2, (Bundle)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(36833);
          return false;
          str1 = ((com.tencent.mm.ah.a)localObject2).hgm;
          break;
          label364:
          i = 1;
          break label165;
          label370:
          ac.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
        }
      }
      ac.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
      com.tencent.mm.ui.base.t.makeText(parama.HZF.getContext(), parama.HZF.getMMResources().getString(2131755886), 0).show();
      AppMethodBeat.o(36833);
      return true;
    }
    
    public static boolean i(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      int j = 0;
      AppMethodBeat.i(36834);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bs.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambo.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambo.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject1 = (aa)paramb.ao(aa.class);
        if ((localObject1 != null) && (!bs.isNullOrNil(((aa)localObject1).BYK)))
        {
          paramb = new dyo();
          paramb.BYK = ((aa)localObject1).BYK;
          paramb.BYL = ((aa)localObject1).BYL;
          paramb.BYM = ((aa)localObject1).BYM;
          paramb.BYN = ((aa)localObject1).BYN;
          paramb.BYO = ((aa)localObject1).BYO;
          paramb.BYS = ((aa)localObject1).BYS;
          paramb.pBl = ((aa)localObject1).pBl;
          paramb.pBm = ((aa)localObject1).pBm;
          paramb.tcG = ((aa)localObject1).tcG;
          paramb.BYP = ((aa)localObject1).BYP;
          paramb.BYQ = ((aa)localObject1).BYQ;
          paramb.BYR = ((aa)localObject1).BYR;
          paramb.source = ((aa)localObject1).source;
          paramb.kRU = ((aa)localObject1).kRU;
          paramb.BYT = ((aa)localObject1).BYT;
          paramb.BYV = ((aa)localObject1).BYV;
          paramb.BYW = ((aa)localObject1).BYW;
          paramb.BYX = ((aa)localObject1).BYX;
          paramb.BYU = ((aa)localObject1).BYU;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.HZF.getContext().getString(2131759717));
          com.tencent.mm.plugin.websearch.api.z.a(parama.HZF.getContext(), paramc);
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambo);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject2 = paramb.url;
        Intent localIntent;
        label551:
        label559:
        int i;
        if (parama.foQ())
        {
          localObject1 = "groupmessage";
          Object localObject3 = com.tencent.mm.pluginsdk.model.app.q.P((String)localObject2, (String)localObject1);
          localObject1 = paramb.url;
          localObject2 = c.getPackageInfo(parama.HZF.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("webpageTitle", paramb.title);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId))))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("jsapi_args_appid", paramb.appId);
            localIntent.putExtra("jsapiargs", (Bundle)localObject3);
          }
          if (bs.isNullOrNil((String)localObject1)) {
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
          if (!bs.isNullOrNil(paramb.dvl))
          {
            localIntent.putExtra("srcUsername", paramb.dvl);
            localIntent.putExtra("srcDisplayname", paramb.dvm);
          }
          localIntent.putExtra("msg_id", parambo.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambo.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambo));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambo.eSk);
          int k = com.tencent.mm.model.x.aE(paramc.b(parama, parambo), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambo.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambo));
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
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
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
    
    private s.i j(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36822);
      if (this.IjY == null) {
        this.IjY = new s.i(parama);
      }
      parama = this.IjY;
      AppMethodBeat.o(36822);
      return parama;
    }
    
    public static boolean j(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bo parambo)
    {
      AppMethodBeat.i(169873);
      if (!bs.isNullOrNil(paramb.canvasPageXml))
      {
        paramc = new Intent();
        paramc.putExtra("sns_landig_pages_from_source", 5);
        paramc.putExtra("msg_id", parambo.field_msgId);
        paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
        paramc.putExtra("sns_landing_pages_share_thumb_url", parambo.field_imgPath);
        paramc.addFlags(268435456);
        com.tencent.mm.br.d.b(parama.HZF.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
        AppMethodBeat.o(169873);
        return true;
      }
      Object localObject1 = (aa)paramb.ao(aa.class);
      if ((localObject1 != null) && (!bs.isNullOrNil(((aa)localObject1).BYK)))
      {
        paramb = new dyo();
        paramb.BYK = ((aa)localObject1).BYK;
        paramb.BYL = ((aa)localObject1).BYL;
        paramb.BYM = ((aa)localObject1).BYM;
        paramb.BYN = ((aa)localObject1).BYN;
        paramb.BYO = ((aa)localObject1).BYO;
        paramb.BYS = ((aa)localObject1).BYS;
        paramb.pBl = ((aa)localObject1).pBl;
        paramb.pBm = ((aa)localObject1).pBm;
        paramb.tcG = ((aa)localObject1).tcG;
        paramb.BYP = ((aa)localObject1).BYP;
        paramb.BYQ = ((aa)localObject1).BYQ;
        paramb.BYR = ((aa)localObject1).BYR;
        paramb.source = ((aa)localObject1).source;
        paramb.kRU = ((aa)localObject1).kRU;
        paramb.BYT = ((aa)localObject1).BYT;
        paramb.BYV = ((aa)localObject1).BYV;
        paramb.BYW = ((aa)localObject1).BYW;
        paramb.BYX = ((aa)localObject1).BYX;
        paramb.BYU = ((aa)localObject1).BYU;
        paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.HZF.getContext().getString(2131759717));
        com.tencent.mm.plugin.websearch.api.z.a(parama.HZF.getContext(), paramc);
        com.tencent.mm.plugin.topstory.a.i.a(paramb, parambo);
        AppMethodBeat.o(169873);
        return true;
      }
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        Object localObject2 = paramb.url;
        int j;
        PackageInfo localPackageInfo;
        Intent localIntent;
        if (parama.foQ())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.P((String)localObject2, (String)localObject1);
          String str = paramb.hhE;
          j = parama.HZF.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Tg((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 1, j, i);
          }
          localPackageInfo = c.getPackageInfo(parama.HZF.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_snsad_statextstr", paramb.dvs);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId)))) {
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
          }
          localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          if (bs.isNullOrNil(str)) {
            break label1198;
          }
          localIntent.putExtra("shortUrl", str);
          label637:
          if (localPackageInfo != null) {
            break label1213;
          }
          localObject2 = null;
          label645:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1223;
          }
          i = 0;
          label664:
          localIntent.putExtra("version_code", i);
          if (!bs.isNullOrNil(paramb.dvl))
          {
            localIntent.putExtra("srcUsername", paramb.dvl);
            localIntent.putExtra("srcDisplayname", paramb.dvm);
          }
          localIntent.putExtra("msg_id", parambo.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambo.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambo));
          localIntent.putExtra("from_scence", 2);
          i = com.tencent.mm.model.x.aE(paramc.b(parama, parambo), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambo.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambo));
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
            label947:
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
            paramb = (com.tencent.mm.ah.e)paramb.ao(com.tencent.mm.ah.e.class);
            if (paramb == null) {
              break;
            }
          }
        }
        for (int i = paramb.hgY;; i = -1)
        {
          localIntent.putExtra(e.m.HhB, i);
          if ((paramb == null) || (i != 5) || (paramb.hha != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP())) {
            break label1257;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.HgX, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.HgY, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.HZF.getContext(), parambo.field_msgId, parambo.field_msgSvrId, 0, paramb);
          AppMethodBeat.o(169873);
          return true;
          localObject1 = "singlemessage";
          break;
          label1198:
          localIntent.putExtra("shortUrl", paramb.url);
          break label637;
          label1213:
          localObject2 = localPackageInfo.versionName;
          break label645;
          label1223:
          i = localPackageInfo.versionCode;
          break label664;
          i = 2;
          break label947;
          i = 3;
          break label947;
          i = 5;
          break label947;
        }
        label1257:
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.HZF.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          ac.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          AppMethodBeat.o(169873);
          return true;
        }
        com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(169873);
      return true;
    }
    
    private s.l k(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36823);
      if (this.IjZ == null) {
        this.IjZ = new s.l(parama);
      }
      parama = this.IjZ;
      AppMethodBeat.o(36823);
      return parama;
    }
    
    private s.j l(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36824);
      if (this.Ika == null) {
        this.Ika = new s.j(parama);
      }
      parama = this.Ika;
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
        localObject = new ag(paramLayoutInflater, 2131493476);
        ((View)localObject).setTag(new e.c().y((View)localObject, false));
      }
      AppMethodBeat.o(36825);
      return localObject;
    }
    
    public final void a(final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(36836);
      com.tencent.mm.ui.base.h.d(parama.HZF.getContext(), parama.HZF.getMMResources().getString(2131757285), "", parama.HZF.getMMResources().getString(2131755877), parama.HZF.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(36804);
          if (parambo.cKN())
          {
            com.tencent.mm.pluginsdk.model.app.m.aD(parambo);
            parama.xg(true);
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
      AppMethodBeat.o(36836);
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(36826);
      final e.c localc = (e.c)parama;
      this.HNS = parama1;
      ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bE(parambo);
      localc.reset();
      String str = parambo.getContent();
      ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bC(parambo);
      k.b localb;
      Object localObject2;
      if (str != null)
      {
        localb = k.b.az(str, parambo.TE());
        localObject2 = com.tencent.mm.ah.t.vF(str);
      }
      label1158:
      label5774:
      for (;;)
      {
        Object localObject1 = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
        int j = 0;
        int k = 0;
        localc.IjQ.setVisibility(8);
        Object localObject3 = localObject1;
        Object localObject4;
        boolean bool1;
        label606:
        int i;
        if (localb != null)
        {
          localObject4 = com.tencent.mm.pluginsdk.model.app.h.fA(localb.appId, localb.aBM);
          localc.IiF.ar(localb.title);
          localc.ijE.setText(localb.description);
          localc.IiK.setMaxLines(1);
          localc.IiF.setTextColor(ao.aJ(parama1.getContext(), 2130968584));
          localc.ijE.setTextColor(parama1.getContext().getResources().getColor(2131100482));
          localc.Ija.setBackground(ao.aI(parama1.getContext(), 2130968742));
          localc.Ija.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
          localc.IiE.setVisibility(0);
          localc.IiY.setVisibility(0);
          localc.ijE.setVisibility(0);
          localc.Ijc.setVisibility(8);
          localc.Ijd.setVisibility(8);
          localc.IiP.setVisibility(8);
          localc.IiO.setVisibility(8);
          localc.IiL.setVisibility(8);
          localc.IiI.setVisibility(8);
          localc.IiH.setVisibility(8);
          localc.Ijm.setVisibility(8);
          localc.Ijg.setVisibility(8);
          localc.Ija.setVisibility(0);
          localc.Ijt.setVisibility(8);
          localc.IjB.setVisibility(8);
          localc.IjJ.setVisibility(8);
          localc.IjO.setVisibility(8);
          e.c.aG(localc.IiZ, localc.IjS);
          if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName.trim().length() > 0)) {
            break label1433;
          }
          localObject3 = localb.appName;
          bool1 = true;
          com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 12);
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool1 = n.a.eKi().dDj();
          }
          if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!eC((String)localObject3))) {
            break label1473;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject4, (String)localObject3);
          if (localb.type != 19) {
            break label1443;
          }
          localc.qTn.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject3 }));
          localc.IiJ.setVisibility(0);
          localc.qTn.setVisibility(0);
          localc.qTn.setCompoundDrawables(null, null, null, null);
          localc.IiG.setVisibility(0);
          if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject4).CC())) {
            break label1456;
          }
          a(parama1, localc.qTn, parambo, localb, ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_packageName, parambo.TA());
          label681:
          localc.IiG.setImageResource(2131231697);
          a(parama1, localc.IiG, localb.appId);
          i = 1;
        }
        label923:
        label6045:
        label7070:
        for (;;)
        {
          label709:
          localc.IiJ.setBackgroundResource(2131233299);
          bool1 = false;
          localc.IiE.setVisibility(0);
          if (this.opt)
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
                    if (!e.b.aQG(parambo.TD())) {
                      localObject3 = o.aFx().e(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    }
                  }
                }
              }
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              localObject4 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject3, false, com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 1));
              localc.IiE.setImageBitmap((Bitmap)localObject4);
              label873:
              if (localb.type != 3) {
                break label1668;
              }
              localc.Ija.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                private boolean Ikb = false;
                
                public final boolean onPreDraw()
                {
                  AppMethodBeat.i(36803);
                  if (this.Ikb)
                  {
                    localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                  localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                  this.Ikb = true;
                  int i = com.tencent.mm.cc.a.fromDPToPix(parama1.HZF.getContext(), 24);
                  Bitmap localBitmap = this.val$bitmap;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = com.tencent.mm.sdk.platformtools.f.aH(parama1.HZF.getContext().getResources().getColor(2131100129), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.aB(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                    j = localc.Ija.getHeight();
                    int k = localc.Ija.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166036);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166037);
                    }
                    localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231589, j, i));
                    localc.Ija.setBackgroundDrawable((Drawable)localObject);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                }
              });
              if (!aj.DT()) {
                break label1657;
              }
              localc.IiJ.setBackgroundResource(2131233299);
              localc.IiQ.setOnClickListener(null);
            }
          }
          label1213:
          label1473:
          label1657:
          final boolean bool2;
          label1315:
          label1456:
          label2737:
          switch (localb.type)
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
                  break label7529;
                }
                localc.IiK.setVisibility(0);
                localc.IiK.setMaxLines(2);
                localc.IiK.setText(localb.title);
                localc.IiF.setVisibility(8);
                if (bool1)
                {
                  if ((localb.type != 33) && (localb.type != 36)) {
                    break label7542;
                  }
                  paramString = o.aFx().Cq(parambo.TD());
                  localc.IiE.setImageResource(2131689584);
                  com.tencent.mm.modelappbrand.a.b.aAS().a(localc.IiE, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(52, 52));
                }
                if (localb.type == 44) {
                  e.c.a(parama1, localc, localb);
                }
              }
              localObject3 = parama;
              if (j == 0)
              {
                localc.IiZ.setTag(localObject3);
                localc.IiZ.setOnClickListener(d(parama1));
              }
              if (this.opt)
              {
                localc.IiZ.setOnLongClickListener(c(parama1));
                localc.IiZ.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
              }
              a(paramInt, localc, parambo, parama1.foM(), parama1.foQ(), parama1, this);
              AppMethodBeat.o(36826);
              return;
              localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              localc.qTn.setText((CharSequence)localObject3);
              break label606;
              a(parama1, localc.qTn, localb.appId);
              break label681;
              if (localb.type == 24)
              {
                localc.qTn.setText(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131758845));
                localc.IiJ.setVisibility(0);
                localc.qTn.setVisibility(0);
                localc.IiG.setVisibility(8);
                i = 1;
                break label709;
              }
              if ((localb.type == 19) || (((com.tencent.mm.ah.t)localObject2).hla == 19))
              {
                localc.qTn.setText(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757208));
                localc.IiJ.setVisibility(0);
                localc.qTn.setVisibility(0);
                localc.IiG.setVisibility(8);
                i = 1;
                break label709;
              }
              if (e.a(localb, localc)) {
                break label7729;
              }
              localc.IiJ.setVisibility(8);
              localc.qTn.setVisibility(8);
              localc.IiG.setVisibility(8);
              i = 0;
              break label709;
              bool1 = true;
              break label873;
              localc.IiJ.setBackgroundResource(2131231682);
              break label923;
              localc.IiE.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
              bool1 = false;
              break label923;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.IiF.setVisibility(0);
                localc.IiF.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                localc.ijE.setVisibility(0);
                localc.ijE.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                localc.IiK.setVisibility(8);
                localc.IiL.setVisibility(4);
                localc.ijE.setMaxLines(2);
                localc.IiQ.setVisibility(0);
                if (!parambo.Tz().equals(parama.IhX)) {
                  break label2000;
                }
                localc.IiQ.setImageResource(2131233393);
                parama = new e.g();
                parama.msgId = parambo.Tz();
                parama.dqf = parambo.getContent();
                parama.dmK = parambo.TD();
                localc.IiQ.setTag(parama);
                localc.IiQ.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmc());
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label2014;
                  }
                  localc.IiE.setImageResource(2131689564);
                }
              }
              for (;;)
              {
                if (!fqw()) {
                  break label2026;
                }
                b(localc, false);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.IiF.setVisibility(8);
                break label1744;
                localc.IiQ.setImageResource(2131233395);
                break label1850;
                localc.IiE.setImageBitmap(parama);
              }
              if (parambo.getStatus() < 2) {}
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
                localc.IiF.setVisibility(0);
                localc.IiF.setMaxLines(2);
              }
              for (;;)
              {
                localc.ijE.setVisibility(0);
                localc.IiK.setVisibility(8);
                localc.IiL.setVisibility(4);
                localc.ijE.setMaxLines(2);
                localc.ijE.setText(bs.qz(localb.hhF));
                localc.IiQ.setVisibility(8);
                e.c.a(localc, str, localb.hhF);
                e.c.a(localc, Boolean.FALSE, parambo, localb.cZa, localb.title);
                if (!bool1) {
                  break label7703;
                }
                if (!e.b.aQF(localb.hhG)) {
                  break label2251;
                }
                localc.IiE.setImageResource(2131231063);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.IiF.setVisibility(8);
              }
              localc.IiE.setImageResource(com.tencent.mm.pluginsdk.model.q.aGb(localb.hhG));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
            }
          case 4: 
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.IiF.setVisibility(0);
              localc.ijE.setVisibility(0);
              localc.IiK.setVisibility(8);
              localc.ijE.setMaxLines(2);
              localc.IiL.setVisibility(4);
              localc.IiQ.setVisibility(0);
              localc.IiQ.setImageResource(2131234464);
              if (!bool1) {
                break label7703;
              }
              paramString = new com.tencent.mm.av.a.a.c.a();
              paramString.pe(2131689584).aFQ().de(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50)).aFO().aFR().ak(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 1));
              localObject2 = o.aFB();
              if (!bs.isNullOrNil(localb.thumburl)) {
                break label2501;
              }
            }
            for (parama = localb.hhM;; parama = localb.thumburl)
            {
              ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.IiE, paramString.aFT());
              localc.IiQ.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.IiF.setVisibility(8);
              break label2308;
            }
          case 36: 
            label1744:
            label2014:
            label2026:
            if (localc.IiZ.getLayoutParams() != null)
            {
              localc.IiZ.getLayoutParams().width = -2;
              localc.IiZ.requestLayout();
            }
            label1850:
            label2000:
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(localb.hke);
            label2251:
            if (localObject2 != null)
            {
              parama = ((WxaAttributes)localObject2).field_nickname;
              if (localObject2 == null) {
                break label2895;
              }
              paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
              localc.Ija.setVisibility(8);
              localc.Ijm.setVisibility(0);
              localc.Ijg.setVisibility(8);
              localc.Ijt.setVisibility(8);
              localc.Ijq.setText(localb.title);
              e.e(localc.Ijq, localb.title);
              localc.Ijk.setText(parama);
              e.a(localc.Ijl, localb);
              if (!e.a(parambo, localb, parama1)) {
                break label2905;
              }
              localc.IjQ.setVisibility(0);
              bool2 = bs.isNullOrNil(parambo.TI());
              localc.IjQ.setTag(parambo);
              localc.IjQ.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179969);
                  e.a((bo)paramAnonymousView.getTag(), localc, parama1);
                  AppMethodBeat.o(179969);
                }
              });
              e.a(bool2, localc, parama1);
              o.aFB().a(paramString, localc.Ijj, ab.d.fvC);
              parama = o.aFx().Cq(parambo.TD());
              localc.Ijn.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.aAS().a(localc.Ijn, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
              if (!fqw()) {
                break label2918;
              }
              a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo);
            }
            label2501:
            break;
          }
          label1443:
          label5539:
          label7716:
          label7726:
          for (;;)
          {
            bool2 = false;
            for (parama = localc;; parama = localc)
            {
              b(parama, bool2);
              if (!e.a(localb, (WxaAttributes)localObject2)) {
                break label2936;
              }
              localc.jPU.setVisibility(0);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              parama = localb.dvm;
              break label2574;
              label2895:
              paramString = localb.hks;
              break label2586;
              label2905:
              localc.IjQ.setVisibility(8);
              break label2737;
              label2918:
              if (parambo.getStatus() >= 2) {
                break label7726;
              }
              bool2 = true;
            }
            label2936:
            localc.jPU.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1158;
            if (localb != null) {
              e.a(paramString, parama1, parambo, localb);
            }
            parama = (com.tencent.mm.ah.e)localb.ao(com.tencent.mm.ah.e.class);
            if ((parama != null) && (parama.hha == 1) && (parama.hgY == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP()))
            {
              e.c.a(parama1, localc, localb, parambo, bool1);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
            }
            if ((i == 0) && (ae.a(localb, parama)))
            {
              localc.IjJ.setVisibility(0);
              localc.IjO.setVisibility(0);
              ae.a(parama1.getContext(), localb, localc.IjL, localc.IjM);
              ae.b(localc.IjN, localb);
            }
            localc.IiF.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.IiK.setMaxLines(2);
              localc.IiK.setVisibility(0);
              localc.IiK.setText(localb.title);
              label3169:
              localc.ijE.setMaxLines(3);
              localc.IiL.setVisibility(4);
              if (!e.k(localb)) {
                break label3377;
              }
              localc.IiQ.setImageResource(2131234464);
              localc.IiQ.setVisibility(0);
              if (bool1)
              {
                paramString = new com.tencent.mm.av.a.a.c.a();
                paramString.pe(2131689584).aFQ().CB(com.tencent.mm.plugin.image.d.cTH()).de(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 50)).aFO().aFR().ak(com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 1));
                localObject2 = o.aFB();
                if (!bs.isNullOrNil(localb.thumburl)) {
                  break label3390;
                }
              }
            }
            label3377:
            label3390:
            for (parama = localb.hhM;; parama = localb.thumburl)
            {
              ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.IiE, paramString.aFT());
              if (!fqw()) {
                break label3399;
              }
              a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.IiK.setVisibility(8);
              break label3169;
              localc.IiQ.setVisibility(8);
              break label3215;
            }
            label3399:
            if (parambo.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(localb.hke);
            ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).Iz(localb.hke);
            switch (localb.hkg)
            {
            }
            for (;;)
            {
              i = 1;
              for (;;)
              {
                if (i != 0) {
                  break label7716;
                }
                if (!fqw()) {
                  break label4183;
                }
                a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo);
                b(localc, false);
                parama = (c.a)localObject1;
                j = k;
                break;
                if (localc.IiZ.getLayoutParams() != null)
                {
                  localc.IiZ.getLayoutParams().width = -2;
                  localc.IiZ.requestLayout();
                }
                if (localObject2 != null)
                {
                  parama = ((WxaAttributes)localObject2).field_nickname;
                  if (localObject2 == null) {
                    break label3898;
                  }
                  paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                  localc.Ija.setVisibility(8);
                  localc.Ijm.setVisibility(0);
                  localc.Ijg.setVisibility(8);
                  localc.Ijt.setVisibility(8);
                  localc.Ijq.setText(localb.title);
                  e.e(localc.Ijq, localb.title);
                  localc.Ijk.setText(parama);
                  e.a(localc.Ijl, localb);
                  o.aFB().a(paramString, localc.Ijj, ab.d.fvC);
                  parama = o.aFx().Cq(parambo.TD());
                  localc.Ijn.setImageBitmap(null);
                  localc.Ijp.setVisibility(0);
                  if (!e.a(localb, (WxaAttributes)localObject2)) {
                    break label3908;
                  }
                  localc.jPU.setVisibility(0);
                  label3764:
                  if (!e.a(parambo, localb, parama1)) {
                    break label3921;
                  }
                  localc.IjQ.setVisibility(0);
                  bool2 = bs.isNullOrNil(parambo.TI());
                  localc.IjQ.setTag(parambo);
                  localc.IjQ.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(185040);
                      e.a((bo)paramAnonymousView.getTag(), localc, parama1);
                      AppMethodBeat.o(185040);
                    }
                  });
                  e.a(bool2, localc, parama1);
                }
                for (;;)
                {
                  bool2 = e.l(localb);
                  com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
                  {
                    public final String Ap()
                    {
                      AppMethodBeat.i(36812);
                      String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                      AppMethodBeat.o(36812);
                      return str;
                    }
                    
                    public final void E(Bitmap paramAnonymousBitmap)
                    {
                      AppMethodBeat.i(36810);
                      if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                      {
                        localc.Ijn.setImageBitmap(paramAnonymousBitmap);
                        localc.Ijn.setVisibility(0);
                        localc.Ijp.setVisibility(4);
                        if (bool2)
                        {
                          localc.Ijo.setImageDrawable(com.tencent.mm.cc.a.l(parama1.HZF.getContext(), 2131691166));
                          localc.Ijo.setVisibility(0);
                          AppMethodBeat.o(36810);
                          return;
                        }
                        localc.Ijo.setVisibility(8);
                        AppMethodBeat.o(36810);
                        return;
                      }
                      localc.Ijn.setVisibility(4);
                      localc.Ijp.setVisibility(0);
                      localc.Ijo.setVisibility(8);
                      AppMethodBeat.o(36810);
                    }
                    
                    public final void aBa()
                    {
                      AppMethodBeat.i(36809);
                      AppMethodBeat.o(36809);
                    }
                    
                    public final void of()
                    {
                      AppMethodBeat.i(36811);
                      AppMethodBeat.o(36811);
                    }
                  }, e.access$600(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
                  i = 0;
                  break;
                  parama = localb.dvm;
                  break label3603;
                  label3898:
                  paramString = localb.hks;
                  break label3615;
                  label3908:
                  localc.jPU.setVisibility(8);
                  break label3764;
                  label3921:
                  localc.IjQ.setVisibility(8);
                }
                if (localObject2 != null)
                {
                  parama = ((WxaAttributes)localObject2).field_nickname;
                  label3945:
                  if (localObject2 == null) {
                    break label4087;
                  }
                  paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                  label3957:
                  localc.Ija.setVisibility(8);
                  localc.Ijm.setVisibility(8);
                  localc.Ijg.setVisibility(0);
                  localc.Iji.setText(parama);
                  localc.Ijt.setVisibility(8);
                  if (!bs.isNullOrNil(paramString)) {
                    break label4093;
                  }
                  parama = o.aFx().Cq(parambo.TD());
                  com.tencent.mm.modelappbrand.a.b.aAS().a(localc.Ijh, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
                }
                for (;;)
                {
                  if (!e.a(localb, (WxaAttributes)localObject2)) {
                    break label4116;
                  }
                  localc.Ijs.setVisibility(0);
                  i = 0;
                  break;
                  parama = localb.title;
                  break label3945;
                  label4087:
                  paramString = null;
                  break label3957;
                  label4093:
                  com.tencent.mm.modelappbrand.a.b.aAS().a(localc.Ijh, paramString, com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
                }
                localc.Ijs.setVisibility(8);
                i = 0;
              }
              localc.IiJ.setVisibility(0);
              localc.IiG.setVisibility(0);
              localc.IiG.setBackground(null);
              localc.IiG.setImageResource(2131689681);
              e.a(localc.qTn, localb);
            }
            label4183:
            if (parambo.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            parama = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
            paramString = localb.hks;
            localObject2 = localb.dvm;
            localObject3 = localb.title;
            localObject4 = localb.description;
            if (parama == null)
            {
              ac.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
              break;
            }
            if (((bs.isNullOrNil(parama.hgj)) || (bs.isNullOrNil(parama.hgl))) && (bs.isNullOrNil(parama.hgi)))
            {
              ac.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
              break;
            }
            localc.Ijz.setText((CharSequence)localObject2);
            localc.Ija.setVisibility(8);
            localc.Ijm.setVisibility(8);
            localc.Ijg.setVisibility(8);
            localc.IjA.setVisibility(0);
            localc.Ijw.setVisibility(8);
            localc.IjA.setImageDrawable(com.tencent.mm.cc.a.l(parama1.getContext(), 2131691166));
            localc.Ijt.setVisibility(0);
            localc.Iju.setText((CharSequence)localObject3);
            localc.Ijv.setText((CharSequence)localObject4);
            o.aFA().a(paramString, new p.a()
            {
              public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
              {
                AppMethodBeat.i(36814);
                com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36813);
                    if (!paramAnonymousBitmap.isRecycled()) {
                      e.e.7.this.IjW.Ijy.setImageBitmap(paramAnonymousBitmap);
                    }
                    AppMethodBeat.o(36813);
                  }
                });
                AppMethodBeat.o(36814);
              }
            });
            parama = o.aFx().Cq(parambo.TD());
            localc.Ijx.setImageBitmap(null);
            com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
            {
              public final String Ap()
              {
                AppMethodBeat.i(36817);
                String str = "CHAT#" + com.tencent.mm.plugin.appbrand.z.m.cE(this);
                AppMethodBeat.o(36817);
                return str;
              }
              
              public final void E(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(36816);
                if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                {
                  localc.Ijx.setImageBitmap(paramAnonymousBitmap);
                  localc.Ijx.setVisibility(0);
                }
                AppMethodBeat.o(36816);
              }
              
              public final void aBa()
              {
                AppMethodBeat.i(36815);
                localc.Ijx.setVisibility(4);
                AppMethodBeat.o(36815);
              }
              
              public final void of()
              {
                AppMethodBeat.i(185041);
                ac.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
                com.tencent.mm.plugin.report.service.h.wUl.dB(808, 3);
                AppMethodBeat.o(185041);
              }
            }, e.access$600(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hsa));
            if (fqw())
            {
              a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
            }
            if (parambo.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            i = 1;
            localc.ijE.setMaxLines(3);
            localc.IiK.setMaxLines(2);
            parama = (c.a)localObject1;
            j = k;
            break label1158;
            localc.IiF.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.IiK.setMaxLines(2);
              localc.IiK.setVisibility(0);
              localc.IiK.setText(localb.title);
              label4679:
              localc.ijE.setMaxLines(3);
              localc.IiL.setVisibility(4);
              localc.IiQ.setVisibility(8);
              if (bool1)
              {
                parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label4790;
                }
                localc.IiE.setImageResource(2131689584);
              }
            }
            for (;;)
            {
              if (!fqw()) {
                break label4802;
              }
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.IiK.setVisibility(8);
              break label4679;
              label4790:
              localc.IiE.setImageBitmap(parama);
            }
            label4802:
            if (parambo.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            localc.IiK.setVisibility(0);
            if (localb.hie == 1) {
              localc.IiK.setText(2131762858);
            }
            for (;;)
            {
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.IiF.setVisibility(0);
                localc.IiF.ar(localb.title);
              }
              localc.ijE.setMaxLines(4);
              localc.IiL.setVisibility(4);
              localc.IiQ.setVisibility(8);
              if (!bool1) {
                break label7703;
              }
              parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
              if ((parama == null) || (parama.isRecycled())) {
                break label5057;
              }
              localc.IiE.setImageBitmap(parama);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              if (localb.hie == 2) {
                localc.IiK.setText(2131762860);
              } else if (localb.hie == 3) {
                localc.IiK.setText(2131762859);
              } else {
                localc.IiK.setText(2131762861);
              }
            }
            label5057:
            localc.IiE.setImageResource(2131689584);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1158;
            localc.IiF.setVisibility(0);
            localc.IiF.ar(localb.title);
            localc.IiK.setVisibility(0);
            localc.IiK.setText(2131757247);
            localc.ijE.setMaxLines(4);
            localc.IiL.setVisibility(4);
            localc.IiQ.setVisibility(8);
            if (bool1)
            {
              parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localc.IiE.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
              }
              localc.IiE.setImageResource(2131689584);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.IiF.setVisibility(0);
                localc.IiF.ar(localb.title);
                localc.IiK.setVisibility(8);
              }
              localc.ijE.setMaxLines(4);
              localc.IiL.setVisibility(4);
              localc.IiQ.setVisibility(8);
              if (bool1)
              {
                parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                if ((parama != null) && (!parama.isRecycled()))
                {
                  localc.IiE.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1158;
                }
                localc.IiE.setImageResource(2131689584);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
                if ((localb.title != null) && (localb.title.length() > 0)) {
                  localc.IiF.setVisibility(0);
                }
                for (;;)
                {
                  localc.ijE.setVisibility(0);
                  localc.IiK.setVisibility(8);
                  localc.IiL.setVisibility(8);
                  localc.IiQ.setVisibility(4);
                  localc.ijE.setMaxLines(2);
                  if (!bool1) {
                    break label7703;
                  }
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5539;
                  }
                  localc.IiE.setImageResource(2131689584);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.IiF.setVisibility(8);
                }
                localc.IiE.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiF.setVisibility(0);
                  label5589:
                  localc.ijE.setVisibility(0);
                  localc.IiK.setVisibility(8);
                  localc.IiQ.setVisibility(8);
                  localc.IiL.setVisibility(4);
                  localc.ijE.setMaxLines(2);
                  if (bool1)
                  {
                    parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label5774;
                    }
                    localc.IiE.setImageResource(2131689584);
                  }
                }
                for (;;)
                {
                  parama = new bj(parambo, false, paramInt, "", false, parama1.fmy(), localb.dvl, localb.dvm, localb.title, localb.him, localb.url, false, false);
                  localc.IiZ.setTag(parama);
                  localc.IiZ.setOnClickListener(i(parama1));
                  j = 1;
                  i = 0;
                  break;
                  localc.IiF.setVisibility(8);
                  break label5589;
                  localc.IiE.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiF.setVisibility(0);
                  label5814:
                  localc.ijE.setVisibility(0);
                  localc.IiK.setVisibility(8);
                  localc.IiQ.setVisibility(8);
                  localc.IiL.setVisibility(4);
                  localc.ijE.setMaxLines(2);
                  if (bool1)
                  {
                    parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label6005;
                    }
                    localc.IiE.setImageResource(2131689584);
                  }
                }
                for (;;)
                {
                  parama = new bj(parambo, paramInt, "", parama1.fmy(), localb.dvl, localb.dvm, localb.title, localb.hjS, localb.designerName, localb.designerRediretctUrl, localb.url);
                  localc.IiZ.setTag(parama);
                  localc.IiZ.setOnClickListener(j(parama1));
                  j = 1;
                  i = 0;
                  break;
                  localc.IiF.setVisibility(8);
                  break label5814;
                  label6005:
                  localc.IiE.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiF.setVisibility(0);
                  localc.ijE.setVisibility(0);
                  localc.IiK.setVisibility(8);
                  localc.IiQ.setVisibility(8);
                  localc.IiL.setVisibility(4);
                  localc.ijE.setMaxLines(2);
                  if (bool1)
                  {
                    if (!bs.isNullOrNil(parambo.TD())) {
                      break label6304;
                    }
                    o.aFB().loadImage(localb.thumburl, localc.IiE);
                  }
                  label6124:
                  parama = new bj();
                  parama.dpq = parambo;
                  parama.HJB = false;
                  parama.position = paramInt;
                  parama.IqQ = false;
                  parama.title = parama1.fmy();
                  parama.dvl = localb.dvl;
                  parama.dvm = localb.dvm;
                  parama.IqR = localb.title;
                  if (localb.type != 26) {
                    break label6361;
                  }
                  parama.tid = localb.tid;
                  parama.hjT = localb.hjT;
                  parama.desc = localb.desc;
                  parama.iconUrl = localb.iconUrl;
                  parama.secondUrl = localb.secondUrl;
                  parama.pageType = localb.pageType;
                  localc.IiZ.setOnClickListener(k(parama1));
                  i = 1;
                }
                for (;;)
                {
                  localc.IiZ.setTag(parama);
                  k = 0;
                  j = i;
                  i = k;
                  break;
                  localc.IiF.setVisibility(8);
                  break label6045;
                  parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama == null) || (parama.isRecycled()))
                  {
                    localc.IiE.setImageResource(2131689584);
                    break label6124;
                  }
                  localc.IiE.setImageBitmap(parama);
                  break label6124;
                  label6361:
                  if (localb.type == 27)
                  {
                    parama.tid = localb.tid;
                    parama.hjT = localb.hjT;
                    parama.desc = localb.desc;
                    parama.iconUrl = localb.iconUrl;
                    parama.secondUrl = localb.secondUrl;
                    parama.pageType = localb.pageType;
                    localc.IiZ.setOnClickListener(l(parama1));
                    i = 1;
                  }
                  else
                  {
                    ac.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                    i = 0;
                  }
                }
                localc.IiF.setVisibility(0);
                localc.IiF.ar(localb.description);
                localc.ijE.setText(localb.hiS);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.IiK.setVisibility(0);
                  localc.IiK.setText(localb.title);
                }
                for (;;)
                {
                  localc.ijE.setMaxLines(4);
                  localc.IiL.setVisibility(4);
                  localc.IiQ.setVisibility(8);
                  if (!bool1) {
                    break label7703;
                  }
                  parama = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6627;
                  }
                  localc.IiE.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.IiK.setVisibility(8);
                }
                label6627:
                localc.IiE.setImageResource(2131689584);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
                localc.IiF.setVisibility(8);
                localc.IiK.setVisibility(0);
                if ((localb.title != null) && (localb.title.length() > 0)) {
                  localc.IiK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.IiK.getContext(), localb.title, (int)localc.IiK.getTextSize()));
                }
                for (;;)
                {
                  localc.ijE.setMaxLines(3);
                  localc.IiL.setVisibility(4);
                  localc.IiQ.setVisibility(8);
                  if (bool1) {
                    localc.IiE.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, parambo, bool1);
                  if (!fqw()) {
                    break label6860;
                  }
                  a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.IiK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.IiK.getContext(), com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759034), (int)localc.IiK.getTextSize()));
                }
                label6860:
                if (parambo.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                e.c.a(parama1, localc, localb, bool1);
                if (fqw())
                {
                  a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class), parambo);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1158;
                }
                if (parambo.getStatus() < 2) {}
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
                  localc.IiF.setVisibility(0);
                  if (!bs.isNullOrNil(localb.titleColor)) {
                    if (!bs.isNullOrNil(localb.titleColor))
                    {
                      localc.IiF.setTextColor(bs.cG(localb.titleColor, parama1.getContext().getResources().getColor(2131100711)));
                      localc.ijE.setMaxLines(2);
                      localc.ijE.setVisibility(0);
                      if (bs.isNullOrNil(localb.hjb)) {
                        break label7391;
                      }
                      localc.ijE.setTextColor(bs.cG(localb.hjb, parama1.getContext().getResources().getColor(2131100469)));
                      label7128:
                      localc.IiK.setVisibility(8);
                      localc.IiL.setVisibility(4);
                      localc.IiQ.setVisibility(8);
                      localc.IiJ.setVisibility(0);
                      localc.qTn.setVisibility(0);
                      if (bs.isNullOrNil(localb.hiX)) {
                        break label7415;
                      }
                      localc.qTn.setText(localb.hiX);
                    }
                  }
                }
                for (;;)
                {
                  if (this.opt)
                  {
                    parama = o.aFx().e(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = com.tencent.mm.sdk.platformtools.f.a(parama, false, parama.getWidth() / 2);
                      localc.IiE.setImageBitmap(paramString);
                    }
                    if (!bs.isNullOrNil(localb.hja))
                    {
                      o.aFB().a(localb.hja, new ImageView(parama1.getContext()), new com.tencent.mm.av.a.a.c.a().aFP().aFT(), new com.tencent.mm.av.a.c.h()
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
                            localc.Ija.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36818);
                                e.e.9.this.IjW.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.e.9.this.IjW.Ija.getHeight();
                                int k = e.e.9.this.IjW.Ija.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cc.a.au(e.e.9.this.Iiv.HZF.getContext(), 2131166036);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cc.a.au(e.e.9.this.Iiv.HZF.getContext(), 2131166037);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b(paramAnonymousString, 2131231589, j, i));
                                e.e.9.this.IjW.Ija.setBackgroundDrawable(localBitmapDrawable);
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
                      localc.IiF.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label7070;
                      localc.IiF.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label7070;
                      localc.IiF.setVisibility(8);
                      break label7070;
                      label7391:
                      localc.ijE.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                      break label7128;
                      label7415:
                      localc.qTn.setText(2131757206);
                      continue;
                    }
                    localc.Ija.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean Ikb = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36820);
                        if (this.Ikb)
                        {
                          localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36820);
                          return true;
                        }
                        localc.Ija.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.Ikb = true;
                        int i = com.tencent.mm.cc.a.fromDPToPix(parama1.HZF.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = com.tencent.mm.sdk.platformtools.f.aH(parama1.HZF.getContext().getResources().getColor(2131100129), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.aB(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                          j = localc.Ija.getHeight();
                          int k = localc.Ija.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166036);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cc.a.au(parama1.HZF.getContext(), 2131166037);
                          }
                          localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231589, j, i));
                          localc.Ija.setBackgroundDrawable((Drawable)localObject);
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
                localc.IiE.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
                if (((com.tencent.mm.ah.t)localObject2).hla == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1158;
                  label7529:
                  localc.IiK.setVisibility(8);
                  break label1213;
                  label7542:
                  localObject1 = o.aFx().b(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = o.aFx().e(parambo.TD(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.IiE.setImageBitmap(paramString);
                    break label1315;
                  }
                  if (!bs.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.av.a.a.c.a();
                    ((com.tencent.mm.av.a.a.c.a)localObject1).pe(2131100141).aFQ().aFO();
                    o.aFB().a(paramString, localc.IjD, ((com.tencent.mm.av.a.a.c.a)localObject1).aFT());
                    break label1315;
                  }
                  localc.IiE.setImageResource(2131231063);
                  break label1315;
                }
              }
            }
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1158;
            parama = (c.a)localObject1;
            j = k;
            break label1158;
          }
          label3615:
          label6304:
          label7729:
          i = 1;
        }
        label1433:
        label2586:
        localObject2 = null;
        label2574:
        label3215:
        label3603:
        label4116:
        label7703:
        localb = null;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(36828);
      int i = ((bj)paramView.getTag()).position;
      if (parambo.field_content == null)
      {
        AppMethodBeat.o(36828);
        return true;
      }
      k.b localb = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(36828);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.k(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.j.aU(parambo)) && ((localb.type != 19) || (parambo.field_status != 1))) {
        paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      }
      if (((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker)) && (!com.tencent.mm.storage.ai.vC(this.HNS.getTalkerUserName()))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
      }
      boolean bool1;
      switch (localb.type)
      {
      default: 
        bool1 = false;
      }
      for (;;)
      {
        if ((bool1) && (!this.HNS.foR())) {
          paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.br.d.aCT("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).CC()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new com.tencent.mm.g.a.dy();
          ((com.tencent.mm.g.a.dy)localObject).ddK.msgId = parambo.field_msgId;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((com.tencent.mm.g.a.dy)localObject).ddL.ddj) || (e.b.a(this.HNS.HZF.getContext(), localb))) {
            paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
          }
          if (!this.HNS.foR()) {
            paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
          }
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bt.eWo())) {
            paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
          }
          AppMethodBeat.o(36828);
          return true;
          bool1 = com.tencent.mm.al.f.aCG();
          break;
          bool1 = com.tencent.mm.al.f.aCA();
          break;
          boolean bool2 = com.tencent.mm.al.f.aCE();
          bool1 = bool2;
          if (bs.aLM(localb.hhG)) {
            break;
          }
          paramContextMenu.add(i, 150, 0, this.HNS.HZF.getMMResources().getString(2131757229));
          bool1 = bool2;
          break;
          bool1 = com.tencent.mm.al.f.aCx();
          break;
          bool1 = com.tencent.mm.al.f.aCw();
          break;
          bool1 = com.tencent.mm.al.f.aCC();
          break;
          bool1 = com.tencent.mm.al.f.aCy();
          break;
          if ((localb.hiT != 5) && (localb.hiT != 6) && (localb.hiT != 2)) {
            break label893;
          }
          if (localb.hiT != 2) {
            paramContextMenu.clear();
          }
          paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
          AppMethodBeat.o(36828);
          return false;
          paramContextMenu.clear();
          paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
          AppMethodBeat.o(36828);
          return false;
          paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
        }
        label893:
        bool1 = false;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
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
        e.b.a(parama, parambo, b(parama, parambo));
        AppMethodBeat.o(36829);
        return false;
      case 114: 
        paramMenuItem = parambo.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.vA(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          al.a(parambo, bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.d(parambo, parama.HZF.getContext());
          continue;
          al.b(parambo, bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.a(parambo, parama.HZF.getContext(), b(parama, parambo), parama.foQ());
          continue;
          al.p(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.c(parambo, bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend), parama.HZF.getContext());
          continue;
          al.c(parambo, parama.HZF.getContext());
        }
      case 103: 
        paramMenuItem = parambo.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.vA(paramMenuItem);
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
        paramMenuItem.putExtra("Chat_Msg_Id", parambo.field_msgId);
        com.tencent.mm.br.d.b(parama.HZF.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        AppMethodBeat.o(36829);
        return false;
        jl localjl = new jl();
        localjl.dkU.dkV = paramMenuItem.dkV;
        localjl.dkU.dbz = parambo.field_msgId;
        localjl.dkU.dkW = parambo.field_talker;
        com.tencent.mm.sdk.b.a.GpY.l(localjl);
      }
    }
    
    public final boolean b(final View paramView, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(36830);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      paramView.getTag();
      paramView = parambo.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      paramView = k.b.vA(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.k(paramView.appId, true, false);
      if ((localObject != null) && (!bs.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId))) {
        a(parama, paramView, u.axw(), (com.tencent.mm.pluginsdk.model.app.g)localObject, parambo.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (paramView.type)
      {
      default: 
        i = 1;
      }
      while ((i != 0) && (i(paramView, parama, this, parambo)))
      {
        AppMethodBeat.o(36830);
        return true;
        az.ayM();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.g(parama.HZF.getContext(), parama.HZF.getContentView());
          AppMethodBeat.o(36830);
          return true;
        }
        if (bs.aLM(paramView.hhG))
        {
          long l = parambo.field_msgId;
          localObject = paramView.cZa;
          paramView = com.tencent.mm.pluginsdk.model.app.ap.bEO().aGd((String)localObject);
          if ((paramView == null) || (!paramView.cOg())) {
            i = 0;
          }
          while (i != 0)
          {
            AppMethodBeat.o(36830);
            return true;
            az.ayM();
            bo localbo = com.tencent.mm.model.c.awD().vP(l);
            if (localbo.fbQ())
            {
              ac.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject, Long.valueOf(l), Long.valueOf(localbo.field_msgSvrId), localbo.field_imgPath });
              localObject = new Intent();
              ((Intent)localObject).setClassName(this.HNS.HZF.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              ((Intent)localObject).putExtra("clean_view_type", 1);
              paramView = this.HNS;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              i = 1;
            }
            else
            {
              localObject = new Intent(this.HNS.HZF.getContext(), ShowImageUI.class);
              ((Intent)localObject).putExtra("key_image_path", paramView.field_fileFullPath);
              ((Intent)localObject).putExtra("key_message_id", l);
              ((Intent)localObject).putExtra("key_favorite", true);
              paramView = this.HNS;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              i = 1;
            }
          }
        }
        paramView = new Intent();
        paramView.setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramView.putExtra("scene", 2);
        paramView.putExtra("app_msg_id", parambo.field_msgId);
        paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36830);
        return true;
        com.tencent.mm.plugin.report.service.h.wUl.f(13043, new Object[] { Integer.valueOf(2), paramView.description, paramView.appId });
        boolean bool = f(paramView, parama, this, parambo);
        AppMethodBeat.o(36830);
        return bool;
        bool = j(paramView, parama, this, parambo);
        AppMethodBeat.o(36830);
        return bool;
        if (h(paramView, parama, this, parambo))
        {
          AppMethodBeat.o(36830);
          return true;
          if (g(paramView, parama, this, parambo))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          i = 1;
          continue;
          b(paramView, parama, this, parambo);
          AppMethodBeat.o(36830);
          return true;
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).CC()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          ((com.tencent.mm.ui.chatting.c.b.b)parama.bf(com.tencent.mm.ui.chatting.c.b.b.class)).a(parambo, new am()
          {
            public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
            {
              AppMethodBeat.i(196694);
              if (this.oKd != null)
              {
                if (paramAnonymousBoolean1)
                {
                  e.e.a(parama, paramView, u.axw(), this.oKd, parambo.field_msgSvrId, 3, parama.getTalkerUserName());
                  AppMethodBeat.o(196694);
                  return;
                }
                e.e.a(parama, paramView, u.axw(), this.oKd, parambo.field_msgSvrId, 7, parama.getTalkerUserName());
              }
              AppMethodBeat.o(196694);
            }
          });
          AppMethodBeat.o(36830);
          return true;
          if (bs.isNullOrNil(paramView.hif))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_Product_xml", paramView.hif);
          ((Intent)localObject).putExtra("key_ProductUI_getProductInfoScene", 1);
          if (parambo.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_ProductUI_chatting_msgId", parambo.field_msgId);
          }
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (bs.isNullOrNil(paramView.hii))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_TV_xml", paramView.hii);
          ((Intent)localObject).putExtra("key_TV_getProductInfoScene", 1);
          if (parambo.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_TVInfoUI_chatting_msgId", parambo.field_msgId);
          }
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (bs.isNullOrNil(paramView.hil))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          parambo = new Intent();
          parambo.setFlags(65536);
          parambo.putExtra("key_product_info", paramView.hil);
          parambo.putExtra("key_product_scene", 1);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "product", ".ui.MallProductUI", parambo);
          AppMethodBeat.o(36830);
          return true;
          if (bs.isNullOrNil(paramView.dkV))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          parambo = new Intent();
          parambo.setFlags(65536);
          parambo.putExtra("key_card_app_msg", paramView.dkV);
          parambo.putExtra("key_from_scene", paramView.hiT);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "card", ".ui.CardDetailUI", parambo);
          AppMethodBeat.o(36830);
          return true;
          localObject = new Intent();
          ((Intent)localObject).putExtra("message_id", parambo.field_msgId);
          ((Intent)localObject).putExtra("record_xml", paramView.hij);
          i = com.tencent.mm.model.x.aE(b(parama, parambo), parama.getTalkerUserName());
          ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambo.field_msgSvrId));
          ((Intent)localObject).putExtra("preUsername", b(parama, parambo));
          ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
          ((Intent)localObject).putExtra("preChatTYPE", i);
          e.a.a((Intent)localObject, parama, parambo, this);
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          e.a(paramView, parama, parambo);
          AppMethodBeat.o(36830);
          return true;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_biz_uin", paramView.hiV);
          ((Intent)localObject).putExtra("key_order_id", paramView.hiW);
          if ((parambo.field_talker != null) && (!parambo.field_talker.equals("")) && (w.sQ(parambo.field_talker))) {
            ((Intent)localObject).putExtra("key_chatroom_name", parambo.field_talker);
          }
          com.tencent.mm.br.d.b(parama.HZF.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
        }
      }
      AppMethodBeat.o(36830);
      return false;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553));
    }
    
    public final boolean fqu()
    {
      return true;
    }
  }
  
  static final class f
  {
    public boolean Ikj = false;
  }
  
  public static final class g
  {
    public e.h Ikk;
    public int Ikl = -1;
    public String dmK;
    public String dqf;
    public long msgId;
  }
  
  public static final class h
  {
    public String CLp;
    public String coverUrl;
    public String hlr;
    public String playUrl;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e
 * JD-Core Version:    0.7.0.1
 */