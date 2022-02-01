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
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.k.2;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ab;
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
  private static boolean Arg = false;
  
  private static void a(final Context paramContext, final boolean paramBoolean, final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.ui.transmit.e.a parama)
  {
    AppMethodBeat.i(194325);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext = View.inflate(paramContext, 2131495768, null);
    Object localObject = (ImageView)paramContext.findViewById(2131305961);
    if (ac.fko()) {
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
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
          this.JYV.KaH = true;
          locale.bpT();
          if (parama != null) {
            parama.fHo();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(185018);
        }
      });
      locale.KJy = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(185019);
          paramAnonymousl.clear();
          this.fPn.setFooterView(null);
          this.fPn.setFooterView(paramContext);
          AppMethodBeat.o(185019);
        }
      };
      locale.JXC = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(185020);
          String str;
          int j;
          if (!this.JYV.KaH)
          {
            str = paramString1;
            j = this.fLn;
            if (!paramBoolean) {
              break label56;
            }
          }
          label56:
          for (int i = 1;; i = 2)
          {
            z.a(str, 1, j, i, 1, paramString2, paramString3);
            AppMethodBeat.o(185020);
            return;
          }
        }
      };
      locale.fMc();
      locale.cMW();
      AppMethodBeat.o(194325);
      return;
      ((ImageView)localObject).setImageResource(2131234396);
    }
  }
  
  protected static void a(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(36837);
    switch (paramb.hCz)
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
  
  public static void a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
  {
    AppMethodBeat.i(36838);
    oh localoh = new oh();
    localoh.dCh.context = parama.JOR.getContext();
    localoh.dCh.msgId = parambu.field_msgId;
    localoh.dCh.dBt = parama.fFv();
    localoh.dCh.dCi = paramb.hAs;
    localoh.dCh.scene = 6;
    com.tencent.mm.sdk.b.a.IbL.l(localoh);
    AppMethodBeat.o(36838);
  }
  
  public static void a(com.tencent.mm.storage.bu parambu, c.a parama, com.tencent.mm.ui.chatting.e.a parama1)
  {
    AppMethodBeat.i(179989);
    a(parambu, parama, parama1, 0);
    AppMethodBeat.o(179989);
  }
  
  public static void a(com.tencent.mm.storage.bu parambu, final c.a parama, final com.tencent.mm.ui.chatting.e.a parama1, final int paramInt)
  {
    AppMethodBeat.i(185048);
    if (parambu == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185048);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.ax.aQz("group_to_do").getBoolean("introduce_dialog_first", true))
    {
      com.tencent.mm.sdk.platformtools.ax.aQz("group_to_do").edit().putBoolean("introduce_dialog_first", false);
      a(parama1.JOR.getContext(), bt.isNullOrNil(parambu.fkD), parama1.getTalkerUserName(), parambu.fkD, com.tencent.mm.chatroom.d.y.f(parambu), new com.tencent.mm.ui.transmit.e.a()
      {
        public final void fHo()
        {
          AppMethodBeat.i(179943);
          e.b(this.hEN, parama, parama1, paramInt);
          AppMethodBeat.o(179943);
        }
      });
      AppMethodBeat.o(185048);
      return;
    }
    a(parambu, parama, parama1, paramInt, 0);
    AppMethodBeat.o(185048);
  }
  
  private static void a(final com.tencent.mm.storage.bu parambu, final c.a parama, final com.tencent.mm.ui.chatting.e.a parama1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185049);
    if (parambu == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185049);
      return;
    }
    boolean bool = bt.isNullOrNil(parambu.fkD);
    Activity localActivity = parama1.JOR.getContext();
    String str2 = parambu.field_talker;
    if (bt.isNullOrNil(parambu.fkD)) {}
    for (String str1 = com.tencent.mm.chatroom.d.y.d(parambu);; str1 = parambu.fkD)
    {
      com.tencent.mm.chatroom.d.y.a(localActivity, str2, str1, com.tencent.mm.chatroom.d.y.f(parambu), bool, 2, paramInt1, paramInt2, new y.a()
      {
        public final void Yf()
        {
          AppMethodBeat.i(179944);
          if (!this.JYU) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.c(parambu);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", new Object[] { Long.valueOf(parambu.field_msgSvrId), localPair });
            AppMethodBeat.o(179944);
            return;
          }
        }
        
        public final void Yg()
        {
          AppMethodBeat.i(179945);
          if (!this.JYU) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.e(parambu);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", new Object[] { Long.valueOf(parambu.field_msgSvrId), localPair });
            AppMethodBeat.o(179945);
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
    if ((parama instanceof ax.f)) {
      ax.a(paramBoolean, (ax.f)parama, parama1);
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
      paramc.Kao.setBackgroundResource(2131231647);
      paramc.Kap.setTextColor(parama.JOR.getContext().getResources().getColor(2131099673));
      paramc.Kap.setText(2131760124);
      AppMethodBeat.o(179988);
      return;
    }
    paramc.Kao.setBackgroundResource(2131231648);
    paramc.Kap.setTextColor(parama.JOR.getContext().getResources().getColor(2131099699));
    paramc.Kap.setText(2131760126);
    AppMethodBeat.o(179988);
  }
  
  public static boolean a(com.tencent.mm.storage.bu parambu, k.b paramb, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(179986);
    if (!com.tencent.mm.chatroom.d.y.Yd())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (parambu == null)
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
    if (cf.aCL() - parambu.field_createTime >= com.tencent.mm.chatroom.storage.d.fMe.longValue())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (w.zq(parama.getTalkerUserName()))
    {
      AppMethodBeat.o(179986);
      return true;
    }
    AppMethodBeat.o(179986);
    return false;
  }
  
  private static boolean k(k.b paramb)
  {
    AppMethodBeat.i(36839);
    paramb = (ae)paramb.ao(ae.class);
    if ((paramb != null) && (!bt.isNullOrNil(paramb.DBG)))
    {
      AppMethodBeat.o(36839);
      return true;
    }
    AppMethodBeat.o(36839);
    return false;
  }
  
  static final class a
  {
    static void a(Intent paramIntent, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu, c paramc)
    {
      AppMethodBeat.i(36752);
      String str = parama.getTalkerUserName();
      paramc = paramc.b(parama, parambu);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.fFv()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str);
        localBundle.putString("stat_send_msg_user", paramc);
        paramIntent.putExtra("_stat_obj", localBundle);
        AppMethodBeat.o(36752);
        return;
        if (w.zE(str)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
  }
  
  static final class b
  {
    static void a(com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bu parambu, String paramString)
    {
      AppMethodBeat.i(36756);
      Object localObject1 = bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend);
      final Intent localIntent = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      localIntent.putExtra("Retr_Msg_content", (String)localObject1);
      localIntent.putExtra("Retr_MsgFromScene", 2);
      localObject1 = k.b.yr((String)localObject1);
      if ((localObject1 != null) && (19 == ((k.b)localObject1).type)) {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_Msg_Id", parambu.field_msgId);
        if ((localObject1 != null) && (((k.b)localObject1).type == 6)) {
          break label526;
        }
        parambu = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambu.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambu.mq(0));
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
      Object localObject2 = parambu.field_talker;
      Object localObject3 = com.tencent.mm.model.y.AH(parambu.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = com.tencent.mm.model.y.aBq().F((String)localObject3, true);
      ((y.b)localObject3).k("prePublishId", "msg_" + parambu.field_msgSvrId);
      ((y.b)localObject3).k("preUsername", paramString);
      ((y.b)localObject3).k("preChatName", localObject2);
      if ((localObject1 != null) && (((k.b)localObject1).ao(com.tencent.mm.ai.a.class) != null))
      {
        ((y.b)localObject3).k("appservicetype", Integer.valueOf(((com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class)).hxX));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class)).hxX);
      }
      if ((localObject1 != null) && (33 == ((k.b)localObject1).type))
      {
        if (!parama.fFv()) {
          break label502;
        }
        ((y.b)localObject3).k("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", parambu.field_talker);
        ((y.b)localObject3).k("sendAppMsgScene", Integer.valueOf(1));
        ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (y.b)localObject3, parambu);
        break;
        label502:
        ((y.b)localObject3).k("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      label526:
      int i;
      if (((k.b)localObject1).type == 6)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(1203L, 7L, 1L, false);
        localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
        localObject3 = ((k.b)localObject1).hAd;
        if (((k.b)localObject1).hzS == 1)
        {
          i = 7;
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((k.b)localObject1).hzO), Integer.valueOf(2), Long.valueOf((cf.aCL() - parambu.field_createTime) / 1000L), ((k.b)localObject1).hzP, parambu.field_talker, Integer.valueOf(1), "", Long.valueOf(parambu.field_msgSvrId), Long.valueOf(parambu.field_createTime) });
        }
      }
      else
      {
        if ((((k.b)localObject1).hzS == 0) && (((k.b)localObject1).hzO <= 26214400)) {
          break label844;
        }
      }
      label844:
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("Retr_Big_File", bool);
        localObject2 = com.tencent.mm.pluginsdk.model.app.m.aLN(((k.b)localObject1).dks);
        if (localObject2 == null) {
          break label993;
        }
        localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
        if ((!((com.tencent.mm.vfs.e)localObject3).exists()) || (((com.tencent.mm.vfs.e)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen)) {
          break label850;
        }
        parambu = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambu.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambu.mq(0));
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
        if ((parambu.frT()) || (e(parambu, paramString)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.JOR.getContext(), parama.JOR.getContext().getString(2131759063), parama.JOR.getContext().getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            com.tencent.mm.ui.base.h.c(parama.JOR.getContext(), parama.JOR.getMMResources().getString(2131757939), "", true);
          }
          AppMethodBeat.o(36756);
          return;
        }
      }
      label993:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((k.b)localObject1).hzO), ((k.b)localObject1).hAd, bt.aRp(((k.b)localObject1).gjI) });
      if (!bool)
      {
        a(parama, localIntent, parambu);
        AppMethodBeat.o(36756);
        return;
      }
      localIntent.putExtra("Retr_Big_File", bool);
      localObject3 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject3).fJi = "task_ChattingItemAppMsg";
      ((com.tencent.mm.i.g)localObject3).fJj = new g.a()
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
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label179;
              }
              paramAnonymousString = this.JYk;
              paramAnonymousc = localIntent;
              paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousc);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousc.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousc.mq(0));
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
            if ((parambu.frT()) || ((this.JAy != null) && (e.b.e(parambu, this.JAy.field_fileFullPath)))) {
              com.tencent.e.h.LTJ.aP(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179946);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                  com.tencent.mm.ui.base.h.d(e.b.1.this.JYk.JOR.getContext(), e.b.1.this.JYk.JOR.getContext().getString(2131759063), e.b.1.this.JYk.JOR.getContext().getString(2131755906), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                  });
                  AppMethodBeat.o(179946);
                }
              });
            } else {
              com.tencent.e.h.LTJ.aP(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179947);
                  com.tencent.mm.ui.base.h.c(e.b.1.this.JYk.JOR.getContext(), e.b.1.this.JYk.JOR.getMMResources().getString(2131757939), "", true);
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
      ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.flT(), paramString, parambu.field_msgId);
      ((com.tencent.mm.i.g)localObject3).field_fileId = ((k.b)localObject1).hAd;
      ((com.tencent.mm.i.g)localObject3).field_aesKey = ((k.b)localObject1).gjI;
      ((com.tencent.mm.i.g)localObject3).field_filemd5 = ((k.b)localObject1).filemd5;
      ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.fIy;
      ((com.tencent.mm.i.g)localObject3).field_talker = paramString;
      ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fIw;
      ((com.tencent.mm.i.g)localObject3).field_svr_signature = "";
      ((com.tencent.mm.i.g)localObject3).field_onlycheckexist = true;
      bool = com.tencent.mm.ao.f.aGI().f((com.tencent.mm.i.g)localObject3);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.i.g)localObject3).field_fileId, ((com.tencent.mm.i.g)localObject3).field_mediaId, bt.aRp(((com.tencent.mm.i.g)localObject3).field_aesKey) });
      if (!bool) {
        a(parama, localIntent, parambu);
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
        paramb = com.tencent.mm.pluginsdk.e.a.aLf(paramb.hzP);
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
    
    private static boolean a(com.tencent.mm.ui.chatting.e.a parama, Intent paramIntent, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36757);
      if ((parambu.frT()) || (e(parambu, null)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.h.d(parama.JOR.getContext(), parama.JOR.getContext().getString(2131759063), parama.JOR.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(36757);
        return true;
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramIntent.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36757);
      return false;
    }
    
    public static boolean aWA(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(36759);
      Object localObject = com.tencent.mm.aw.q.aIF().c(paramString, false, true);
      if (!com.tencent.mm.vfs.i.fv((String)localObject))
      {
        AppMethodBeat.o(36759);
        return false;
      }
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      localObject = com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject, paramString);
      if (paramString.outWidth * paramString.outHeight > 1048576)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", new Object[] { Integer.valueOf(paramString.outWidth), Integer.valueOf(paramString.outHeight) });
        bool = true;
      }
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      AppMethodBeat.o(36759);
      return bool;
    }
    
    static boolean aWz(String paramString)
    {
      AppMethodBeat.i(36755);
      boolean bool = bt.aRt(paramString);
      AppMethodBeat.o(36755);
      return bool;
    }
    
    public static boolean e(com.tencent.mm.storage.bu parambu, String paramString)
    {
      AppMethodBeat.i(36758);
      if ((System.currentTimeMillis() - parambu.field_createTime > 259200000L) && ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.i.fv(paramString))))
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
    public static int[] rFr = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    protected ViewStub JZA;
    protected ImageView JZB;
    protected ImageView JZC;
    ImageView JZD;
    protected LinearLayout JZE;
    protected ImageView JZF;
    protected TextView JZG;
    protected ImageView JZH;
    protected TextView JZI;
    protected TextView JZJ;
    protected LinearLayout JZK;
    protected ImageView JZL;
    protected ImageView JZM;
    protected ImageView JZN;
    protected TextView JZO;
    protected LinearLayout JZP;
    protected ImageView JZQ;
    LinearLayout JZR;
    TextView JZS;
    TextView JZT;
    ImageView JZU;
    ImageView JZV;
    ImageView JZW;
    TextView JZX;
    ImageView JZY;
    LinearLayout JZZ;
    protected MMImageView JZc;
    protected MMNeat7extView JZd;
    protected ImageView JZe;
    protected ImageView JZf;
    protected TextView JZg;
    protected LinearLayout JZh;
    protected TextView JZi;
    protected ImageView JZj;
    protected MMPinProgressBtn JZk;
    protected ImageView JZl;
    protected ImageView JZm;
    protected ImageView JZn;
    protected ImageView JZo;
    protected TextView JZp;
    protected ChattingItemFooter JZq;
    protected ImageView JZr;
    protected LinearLayout JZs;
    protected ViewGroup JZt;
    protected TextView JZu;
    protected LinearLayout JZv;
    protected RelativeLayout JZw;
    protected FrameLayout JZx;
    protected LinearLayout JZy;
    protected LinearLayout JZz;
    MMNeat7extView Kaa;
    ImageView Kab;
    ImageView Kac;
    ImageView Kad;
    TextView Kae;
    TextView Kaf;
    TextView Kag;
    LinearLayout Kah;
    LinearLayout Kai;
    ImageView Kaj;
    TextView Kak;
    TextView Kal;
    ImageView Kam;
    RelativeLayout Kan;
    LinearLayout Kao;
    TextView Kap;
    public int Kaq;
    private int Kar;
    protected TextView iCV;
    protected ImageView kkf;
    protected TextView rDq;
    private ArrayList<MMImageView> zUJ;
    
    c()
    {
      AppMethodBeat.i(36762);
      this.Kaq = 0;
      this.Kar = 2147483647;
      this.zUJ = new ArrayList();
      AppMethodBeat.o(36762);
    }
    
    private static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt, String paramString)
    {
      AppMethodBeat.i(194319);
      int i = 0;
      while (i <= 4)
      {
        localObject1 = (MMImageView)paramc.JZz.findViewById(rFr[i]);
        if (localObject1 != null)
        {
          ((MMImageView)localObject1).setImageDrawable(null);
          ((MMImageView)localObject1).setVisibility(8);
        }
        i += 1;
      }
      Object localObject1 = (ImageView)paramc.JZz.findViewById(2131298159);
      Object localObject2 = (TextView)paramc.JZz.findViewById(2131298153);
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
          localObject1 = (MMImageView)paramc.JZz.findViewById(rFr[i]);
          ((MMImageView)localObject1).setImageResource(2131689921);
          ((MMImageView)localObject1).setVisibility(0);
          localObject2 = com.tencent.mm.aw.q.aIF().o("Note_" + paramArrayOfString1[i], "", "");
          localObject3 = new com.tencent.mm.aw.a.a.c.a();
          ((com.tencent.mm.aw.a.a.c.a)localObject3).idu = 1;
          ((com.tencent.mm.aw.a.a.c.a)localObject3).idL = true;
          ((com.tencent.mm.aw.a.a.c.a)localObject3).idG = 2131689920;
          ((com.tencent.mm.aw.a.a.c.a)localObject3).hdR = ((int)parama.JOR.getMMResources().getDimension(2131165216));
          ((com.tencent.mm.aw.a.a.c.a)localObject3).hdS = ((int)parama.JOR.getMMResources().getDimension(2131165216));
          localObject3 = ((com.tencent.mm.aw.a.a.c.a)localObject3).aJc();
          if (!com.tencent.mm.vfs.i.fv((String)localObject2)) {
            break label326;
          }
          com.tencent.mm.aw.q.aIJ().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.aw.a.a.c)localObject3);
        }
        label326:
        long l;
        String str1;
        String str2;
        String str3;
        do
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMsgViewHolder", "note get thumb");
          i += 1;
          break;
          localObject1 = (MMImageView)paramc.JZz.findViewById(rFr[(i + 1)]);
          ((MMImageView)localObject1).setImageResource(2131689920);
          break label150;
          localObject1 = ao.faf();
          localObject2 = (com.tencent.mm.pluginsdk.model.app.k.a)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class);
          localObject3 = paramArrayOfString1[i];
          l = bt.flT();
          str1 = paramArrayOfString2[i];
          str2 = paramArrayOfString3[i];
          j = paramArrayOfInt[i];
          str3 = com.tencent.mm.aw.q.aIF().o("Note_".concat(String.valueOf(localObject3)), "", "");
        } while (com.tencent.mm.vfs.i.fv(str3));
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.fJi = "task_AppMessageExtension_2";
        localg.field_mediaId = com.tencent.mm.ao.c.a("downappthumb", l, paramString, String.valueOf(localObject3));
        localg.field_fullpath = str3;
        localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        localg.field_totalLen = j;
        localg.field_aesKey = str1;
        localg.field_fileId = str2;
        localg.field_priority = com.tencent.mm.i.a.fIx;
        if (w.vF(paramString)) {}
        for (int j = 1;; j = 0)
        {
          localg.field_chattype = j;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString });
          localg.fJj = new k.2((com.tencent.mm.pluginsdk.model.app.k)localObject1, (com.tencent.mm.pluginsdk.model.app.k.a)localObject2, str2);
          com.tencent.mm.ao.f.aGI().b(localg, -1);
          break;
        }
      }
      AppMethodBeat.o(194319);
    }
    
    @SuppressLint({"ResourceType"})
    public static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb)
    {
      AppMethodBeat.i(194320);
      parama = paramb.t(parama.JOR.getContext(), false);
      if (!bt.isNullOrNil(parama))
      {
        paramc.JZh.setVisibility(0);
        paramc.rDq.setVisibility(0);
        paramc.JZe.setVisibility(0);
        paramc.rDq.setText(parama);
        if (com.tencent.mm.ai.k.a.hzH.ordinal() == paramb.hCu)
        {
          paramc.JZe.setImageResource(2131690913);
          AppMethodBeat.o(194320);
          return;
        }
        if (com.tencent.mm.ai.k.a.hzI.ordinal() == paramb.hCu) {
          com.tencent.mm.aw.q.aII().a(paramb.hCB, new r.a()
          {
            public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
            {
              AppMethodBeat.i(194318);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(194317);
                  e.c.3.this.Kau.JZe.setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(194317);
                }
              });
              AppMethodBeat.o(194318);
            }
          });
        }
      }
      AppMethodBeat.o(194320);
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, com.tencent.mm.storage.bu parambu, boolean paramBoolean)
    {
      AppMethodBeat.i(36768);
      paramc.JZy.setVisibility(8);
      paramc.JZZ.setVisibility(0);
      paramc.Kai.setVisibility(0);
      com.tencent.mm.ai.e locale;
      int i;
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        paramc.Kaa.setMaxLines(2);
        paramc.Kaa.setVisibility(0);
        paramc.Kaa.ar(paramb.getTitle());
        locale = (com.tencent.mm.ai.e)paramb.ao(com.tencent.mm.ai.e.class);
        if (locale == null) {
          break label464;
        }
        i = locale.duration;
        label99:
        String str = com.tencent.mm.ai.m.oi(i);
        if (bt.isNullOrNil(str)) {
          break label470;
        }
        paramc.Kaf.setVisibility(0);
        paramc.Kaf.setText(str);
      }
      for (;;)
      {
        paramc.Kad.setVisibility(0);
        if ((locale != null) && (com.tencent.mm.ai.x.oj(locale.hzl)))
        {
          paramc.Kaf.setVisibility(8);
          paramc.Kad.setVisibility(8);
        }
        af.a(parama.JOR.getContext(), paramb, paramc.Kac, paramc.Kae);
        af.b(paramc.Kag, paramb);
        paramc.JZj.setVisibility(4);
        i = com.tencent.mm.cc.a.ax(parama.JOR.getContext(), 2131166038) - com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), 24);
        int j = i * 9 / 16;
        if (com.tencent.mm.cc.a.eb(parama.JOR.getContext()) > 1.0F)
        {
          int k = (int)((paramc.Kaq / com.tencent.mm.cd.a.fhE() - com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), 29) * com.tencent.mm.cc.a.eb(parama.JOR.getContext())) * 9.0F / 16.0F);
          if (paramc.Kan.getLayoutParams().height != k)
          {
            paramc.Kan.getLayoutParams().height = k;
            paramc.Kan.requestLayout();
          }
        }
        if ((!paramBoolean) && (bt.isNullOrNil(paramb.thumburl))) {
          break label482;
        }
        parama = com.tencent.mm.api.b.s(paramb.thumburl, 4);
        paramb = new com.tencent.mm.aw.a.a.c.a();
        paramb.idD = 2131100141;
        paramb.idq = true;
        paramb.hdP = com.tencent.mm.pluginsdk.model.r.aLC(parama);
        parambu = paramb.dh(i, j);
        parambu.idg = new com.tencent.mm.pluginsdk.ui.applet.n(4);
        parambu.idP = new com.tencent.mm.pluginsdk.ui.applet.e(4);
        parambu.idp = true;
        com.tencent.mm.aw.q.aIJ().a(parama, paramc.Kab, paramb.aJc());
        AppMethodBeat.o(36768);
        return;
        paramc.Kaa.setVisibility(8);
        break;
        label464:
        i = 0;
        break label99;
        label470:
        paramc.Kaf.setVisibility(8);
      }
      label482:
      paramb = null;
      if (!e.b.aWA(parambu.field_imgPath)) {
        paramb = com.tencent.mm.aw.q.aIF().a(parambu.field_imgPath, com.tencent.mm.cc.a.getDensity(parama.JOR.getContext()), false);
      }
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        paramc.Kab.setImageBitmap(paramb);
        AppMethodBeat.o(36768);
        return;
      }
      paramc.Kab.setImageResource(2131100141);
      AppMethodBeat.o(36768);
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(36767);
      paramc.JZd.setVisibility(8);
      String str;
      Object localObject1;
      Object localObject3;
      label221:
      Object localObject2;
      int i;
      if ((paramb.title != null) && (paramb.title.trim().length() > 0))
      {
        str = paramb.title;
        paramc.JZi.setVisibility(0);
        paramc.JZi.setMaxLines(2);
        paramc.iCV.setMaxLines(4);
        paramc.JZo.setVisibility(8);
        paramc.JZj.setVisibility(4);
        if (paramBoolean) {
          paramc.JZc.setVisibility(8);
        }
        localObject1 = new qh();
        ((qh)localObject1).dEN.type = 0;
        ((qh)localObject1).dEN.dEP = paramb.hAs;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject3 = ((qh)localObject1).dEO.dEY;
        if (localObject3 == null) {
          break label1041;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.JZi.getContext(), bt.bI(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.JZi.getTextSize());
        paramc.JZi.setText((CharSequence)localObject1);
        localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
        if (localObject1 != null) {
          break label514;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.hAs });
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 100) {
            localObject2 = ((String)localObject1).substring(0, 100);
          }
        }
        paramc.iCV.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramc.iCV.getContext(), bt.bI((String)localObject2, paramb.description), paramc.iCV.getTextSize()));
        paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).hDb.iterator();
        i = 0;
        localObject2 = null;
        localObject1 = null;
        label305:
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject3 = (ajn)paramb.next();
        } while ((com.tencent.mm.plugin.fav.ui.l.j((ajn)localObject3)) && (!bt.isNullOrNil(((ajn)localObject3).GhT)) && (((ajn)localObject3).GhT.equals("WeNoteHtmlFile")));
        if (((ajn)localObject3).GhL.Gis.GiV == null) {
          break label539;
        }
        str = parama.JOR.getContext().getString(2131762236);
        i = 1;
        label390:
        switch (((ajn)localObject3).dataType)
        {
        }
      }
      for (;;)
      {
        break label305;
        paramc.JZi.setVisibility(8);
        str = null;
        break;
        label514:
        localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        break label221;
        label539:
        if (((ajn)localObject3).GhL.Gis.dyU == null) {
          break label1038;
        }
        if (localObject1 == null)
        {
          localObject1 = ((ajn)localObject3).GhN;
          break label390;
        }
        if (localObject1 == ((ajn)localObject3).GhN) {
          break label1038;
        }
        localObject2 = ((ajn)localObject3).GhN;
        break label390;
        if (paramBoolean)
        {
          paramc.JZc.setVisibility(0);
          paramc.JZc.setImageResource(2131689583);
        }
        break label305;
        break label305;
        if (paramBoolean)
        {
          paramc.JZc.setVisibility(0);
          paramc.JZc.setImageResource(2131230944);
        }
        break label305;
        if (paramBoolean)
        {
          paramc.JZc.setVisibility(0);
          paramc.JZc.setImageResource(2131689584);
        }
        break label305;
        if ((paramBoolean) && (!com.tencent.mm.plugin.fav.a.b.cuM()))
        {
          paramc.JZc.setVisibility(0);
          paramc.JZc.setImageResource(2131690572);
          break label305;
          if (paramBoolean)
          {
            paramc.JZc.setVisibility(0);
            paramc.JZc.setImageResource(2131689581);
          }
          paramc.JZo.setVisibility(0);
          paramc.JZo.setImageResource(2131234464);
          break label305;
          paramc.JZc.setVisibility(0);
          paramc.JZc.setImageResource(2131689562);
          break label305;
          if (paramBoolean)
          {
            paramc.JZc.setVisibility(0);
            paramc.JZc.setImageResource(2131689564);
          }
          paramc.JZo.setVisibility(0);
          paramc.JZo.setImageResource(2131233395);
          break label305;
          if (paramBoolean)
          {
            paramc.JZc.setVisibility(0);
            paramc.JZc.setImageResource(com.tencent.mm.pluginsdk.f.aLi(((ajn)localObject3).Ghg));
          }
          break label305;
          if (paramBoolean)
          {
            paramc.JZc.setVisibility(0);
            paramc.JZc.setImageResource(2131689577);
          }
          break label305;
          if (paramBoolean)
          {
            paramc.JZc.setVisibility(0);
            paramc.JZc.setImageResource(2131231875);
          }
        }
      }
      if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
        paramb = parama.JOR.getContext().getString(2131758964, new Object[] { localObject1 });
      }
      for (;;)
      {
        if (!bt.isNullOrNil(paramb))
        {
          paramc.JZi.setText(paramb);
          paramc.JZi.setVisibility(0);
        }
        paramc.JZc.setVisibility(8);
        paramc.JZw.setVisibility(8);
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
                paramb = parama.JOR.getContext().getString(2131758963, new Object[] { localObject1, localObject2 });
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
    
    public static void a(c paramc, Boolean paramBoolean, final com.tencent.mm.storage.bu parambu, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(36766);
      final long l = parambu.field_msgId;
      com.tencent.mm.pluginsdk.model.app.c localc = ao.bIX().CB(l);
      if (localc == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
        AppMethodBeat.o(36766);
        return;
      }
      if (paramBoolean.booleanValue()) {
        if (localc.field_status == 101L)
        {
          paramc.JZn.setVisibility(0);
          paramc.JZk.setVisibility(0);
          paramc.JZl.setVisibility(0);
        }
      }
      for (;;)
      {
        if (parambu.field_status == 5)
        {
          paramc.JZn.setVisibility(8);
          paramc.JZm.setVisibility(8);
        }
        paramc.JZn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36760);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if (this.Kas.booleanValue())
            {
              l = l;
              paramAnonymousView = parambu;
              localObject = ao.bIX().CB(l);
              if (localObject == null) {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abi() + " getinfo failed: " + paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36760);
                return;
                if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 101L)
                {
                  com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abi() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
                }
                else
                {
                  ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 102L;
                  ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = bt.aQJ();
                  ao.bIX().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
                }
              }
            }
            long l = l;
            paramAnonymousView = parambu;
            localObject = ao.bIX().CB(l);
            if (localObject == null) {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abi() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.hED.setStatus(5);
              ba.aBQ();
              com.tencent.mm.model.c.azs().xY(l);
              break;
              if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status == 101L) {
                break label357;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abi() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
            }
            label357:
            if ((bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_clientAppDataId)) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId))) {}
            for (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 102L;; ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 105L)
            {
              ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = bt.aQJ();
              ao.bIX().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
              break;
            }
          }
        });
        paramc.JZm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36761);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if (!this.Kas.booleanValue())
            {
              long l = l;
              paramAnonymousView = parambu;
              localObject = ao.bIX().CB(l);
              if (localObject != null) {
                break label146;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abi() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.hED.setStatus(1);
              ba.aBQ();
              com.tencent.mm.model.c.azs().xY(l);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(36761);
              return;
              label146:
              if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 105L) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 101L))
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abi() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
              }
              else
              {
                ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 101L;
                ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = bt.aQJ();
                ao.bIX().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
                ao.fai().run();
              }
            }
          }
        });
        AppMethodBeat.o(36766);
        return;
        if (localc.field_status == 102L)
        {
          paramc.JZn.setVisibility(8);
          paramc.JZk.setVisibility(8);
          paramc.JZl.setVisibility(8);
        }
        else
        {
          paramc.JZn.setVisibility(8);
          paramc.JZk.setVisibility(8);
          paramc.JZl.setVisibility(8);
          continue;
          if (localc.field_status == 101L)
          {
            paramc.JZn.setVisibility(0);
            paramc.JZm.setVisibility(8);
          }
          else if (localc.field_status == 105L)
          {
            paramc.JZn.setVisibility(8);
            paramc.JZm.setVisibility(0);
          }
          else
          {
            paramc.JZn.setVisibility(8);
            paramc.JZm.setVisibility(8);
          }
        }
      }
    }
    
    public static void a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(36765);
      int i = com.tencent.mm.pluginsdk.model.app.m.aLM(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        paramc.JZk.setVisibility(8);
        paramc.JZl.setVisibility(8);
        AppMethodBeat.o(36765);
        return;
      }
      paramc.JZk.setVisibility(0);
      paramc.JZl.setVisibility(0);
      paramc.JZk.setProgress(i);
      AppMethodBeat.o(36765);
    }
    
    static void b(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, com.tencent.mm.storage.bu parambu, boolean paramBoolean)
    {
      AppMethodBeat.i(36769);
      Object localObject1 = new qh();
      ((qh)localObject1).dEN.type = 0;
      ((qh)localObject1).dEN.dEP = paramb.hAs;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      Object localObject2 = ((qh)localObject1).dEO.dEY;
      paramc.JZw.setVisibility(8);
      String[] arrayOfString1 = new String[4];
      String[] arrayOfString2 = new String[4];
      int[] arrayOfInt = new int[4];
      Object localObject3 = new String[4];
      String[] arrayOfString4 = new String[4];
      Object localObject4 = new int[4];
      String[] arrayOfString3 = new String[4];
      int k;
      int i;
      ajn localajn;
      if (localObject2 != null)
      {
        localObject1 = null;
        paramb = bt.bI(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
        k = 0;
        Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject2).hDb.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localajn = (ajn)localIterator.next();
          if ((!com.tencent.mm.plugin.fav.ui.l.j(localajn)) || (bt.isNullOrNil(localajn.GhT)) || (!localajn.GhT.equals("WeNoteHtmlFile"))) {
            switch (localajn.dataType)
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
                str = localajn.desc;
              } while (bt.isNullOrNil(str));
              if (bt.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label1205;
              }
              localObject1 = localajn.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
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
          paramc.JZw.setVisibility(0);
          paramc.JZc.setVisibility(0);
          paramc.JZc.setImageResource(2131230944);
        }
        if (i < 4)
        {
          arrayOfString1[i] = localajn.hAe;
          arrayOfString2[i] = localajn.GgN;
          arrayOfInt[i] = ((int)localajn.Ghx);
          localObject3[i] = localajn.GgR;
          arrayOfString4[i] = localajn.GgT;
          localObject4[i] = ((int)localajn.Ghm);
          arrayOfString3[i] = localajn.dsU;
        }
        i += 1;
        break;
        if (!bt.isNullOrNil(paramb)) {
          break label248;
        }
        paramb = aj.getContext().getString(2131755773) + localajn.title;
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
          if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).hDb.size() == 2))
          {
            localObject2 = aj.getContext().getString(2131759034);
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
            localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.JZi.getContext(), (CharSequence)localObject1, (int)paramc.JZi.getTextSize());
            paramc.JZi.setText((CharSequence)localObject1);
            if ((paramb != null) && (paramb.length() > 100)) {
              paramb = paramb.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            for (;;)
            {
              for (;;)
              {
                localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.iCV.getContext(), paramb, (int)paramc.iCV.getTextSize());
                paramc.iCV.setText((CharSequence)localObject1);
                if (i > 0)
                {
                  paramc.JZw.setVisibility(8);
                  if ((j != 0) || (k == 0) || (bt.isNullOrNil(paramb)))
                  {
                    paramc.iCV.setVisibility(8);
                    paramc.JZi.setMaxLines(2);
                    paramc.JZB.setVisibility(8);
                    paramc.JZA.setLayoutResource(2131493469);
                  }
                  try
                  {
                    if (paramc.JZz == null) {
                      paramc.JZz = ((LinearLayout)paramc.JZA.inflate());
                    }
                    for (;;)
                    {
                      if (i <= 4) {
                        break label1162;
                      }
                      j = 4;
                      a(parama, paramc, j, arrayOfString3, arrayOfString2, arrayOfString1, arrayOfInt, parambu.field_talker);
                      parama = (ImageView)paramc.JZz.findViewById(2131298159);
                      paramc = (TextView)paramc.JZz.findViewById(2131298153);
                      if (paramc != null) {
                        paramc.setTextSize(0, aj.getContext().getResources().getDimensionPixelSize(2131165568));
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
                      localObject1 = aj.getContext().getString(2131759034);
                      j = 0;
                      break label616;
                      paramc.iCV.setMaxLines(1);
                      paramc.iCV.setVisibility(0);
                      paramc.JZi.setMaxLines(1);
                      break label791;
                      paramc.JZz.setVisibility(0);
                    }
                  }
                  catch (Exception paramb)
                  {
                    for (;;)
                    {
                      paramc.JZA.setVisibility(0);
                      continue;
                      j = i;
                    }
                  }
                }
              }
              paramc.JZA.setVisibility(8);
              paramc.JZB.setVisibility(0);
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
      if (this.JZi != null) {
        this.JZi.setMaxLines(this.Kar);
      }
      AppMethodBeat.o(36764);
    }
    
    public final c y(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(36763);
      super.gn(paramView);
      this.JZP = ((LinearLayout)paramView.findViewById(2131298017));
      this.JZc = ((MMImageView)paramView.findViewById(2131298047));
      this.JZd = ((MMNeat7extView)paramView.findViewById(2131298049));
      this.JZi = ((TextView)paramView.findViewById(2131298052));
      this.iCV = ((TextView)paramView.findViewById(2131298026));
      this.rDq = ((TextView)paramView.findViewById(2131298044));
      this.JZe = ((ImageView)paramView.findViewById(2131298041));
      this.JZg = ((TextView)paramView.findViewById(2131298043));
      this.JZf = ((ImageView)paramView.findViewById(2131298042));
      this.JZh = ((LinearLayout)paramView.findViewById(2131298040));
      this.JZj = ((ImageView)paramView.findViewById(2131298045));
      this.JZk = ((MMPinProgressBtn)paramView.findViewById(2131298088));
      this.JZl = ((ImageView)this.tPw.findViewById(2131298087));
      this.JZm = ((ImageView)this.tPw.findViewById(2131298078));
      this.JZn = ((ImageView)this.tPw.findViewById(2131298177));
      this.JZo = ((ImageView)paramView.findViewById(2131298028));
      this.JZp = ((TextView)paramView.findViewById(2131298023));
      this.JZr = ((ImageView)paramView.findViewById(2131298039));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.JZq = ((ChattingItemFooter)paramView.findViewById(2131300196));
      this.JZs = ((LinearLayout)paramView.findViewById(2131296863));
      this.JZt = ((ViewGroup)paramView.findViewById(2131301542));
      this.JZu = ((TextView)paramView.findViewById(2131301539));
      this.JZv = ((LinearLayout)paramView.findViewById(2131298053));
      this.JZx = ((FrameLayout)paramView.findViewById(2131298069));
      this.JZy = ((LinearLayout)paramView.findViewById(2131298024));
      this.JZC = ((ImageView)paramView.findViewById(2131298076));
      this.JZw = ((RelativeLayout)paramView.findViewById(2131298046));
      this.JZA = ((ViewStub)paramView.findViewById(2131302929));
      this.JZB = ((ImageView)paramView.findViewById(2131298081));
      if (!paramBoolean)
      {
        this.JZD = ((ImageView)this.tPw.findViewById(2131298176));
        this.xfR = ((ProgressBar)this.tPw.findViewById(2131306220));
      }
      this.JZK = ((LinearLayout)paramView.findViewById(2131298005));
      this.JZH = ((ImageView)paramView.findViewById(2131298018));
      this.JZI = ((TextView)paramView.findViewById(2131298020));
      this.JZO = ((TextView)paramView.findViewById(2131298016));
      this.JZN = ((ImageView)paramView.findViewById(2131299519));
      this.JZL = ((ImageView)paramView.findViewById(2131298006));
      this.JZM = ((ImageView)paramView.findViewById(2131307172));
      this.JZE = ((LinearLayout)paramView.findViewById(2131298004));
      this.JZF = ((ImageView)paramView.findViewById(2131297979));
      this.JZG = ((TextView)paramView.findViewById(2131297980));
      this.JZJ = ((TextView)paramView.findViewById(2131298019));
      this.kkf = ((ImageView)paramView.findViewById(2131297981));
      this.JZQ = ((ImageView)paramView.findViewById(2131297984));
      this.JZR = ((LinearLayout)paramView.findViewById(2131298009));
      this.JZS = ((TextView)paramView.findViewById(2131298015));
      this.JZT = ((TextView)paramView.findViewById(2131298011));
      this.JZU = ((ImageView)paramView.findViewById(2131298012));
      this.JZV = ((ImageView)paramView.findViewById(2131298010));
      this.JZW = ((ImageView)paramView.findViewById(2131298013));
      this.JZX = ((TextView)paramView.findViewById(2131298014));
      this.JZY = ((ImageView)paramView.findViewById(2131298008));
      this.JZZ = ((LinearLayout)paramView.findViewById(2131298030));
      this.Kad = ((ImageView)paramView.findViewById(2131298034));
      this.Kaa = ((MMNeat7extView)paramView.findViewById(2131298035));
      this.Kab = ((ImageView)paramView.findViewById(2131298033));
      this.Kah = ((LinearLayout)paramView.findViewById(2131302491));
      this.Kai = ((LinearLayout)paramView.findViewById(2131302493));
      this.Kam = ((ImageView)paramView.findViewById(2131302492));
      this.Kan = ((RelativeLayout)paramView.findViewById(2131298031));
      this.Kaj = ((ImageView)this.Kah.findViewById(2131298027));
      this.Kak = ((TextView)this.Kah.findViewById(2131298029));
      this.Kal = ((TextView)this.Kah.findViewById(2131298038));
      this.Kac = ((ImageView)this.Kai.findViewById(2131298027));
      this.Kae = ((TextView)this.Kai.findViewById(2131298029));
      this.Kag = ((TextView)this.Kai.findViewById(2131298038));
      this.Kaf = ((TextView)paramView.findViewById(2131298032));
      this.Kao = ((LinearLayout)paramView.findViewById(2131298050));
      this.Kap = ((TextView)paramView.findViewById(2131298051));
      if ((this.JZi != null) && (Build.VERSION.SDK_INT >= 16)) {
        this.Kar = this.JZi.getMaxLines();
      }
      this.Kaq = c.km(aj.getContext());
      AppMethodBeat.o(36763);
      return this;
    }
  }
  
  public static final class d
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    protected s.i Kaw;
    protected s.l Kax;
    protected s.j Kay;
    private boolean ruk;
    
    public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36799);
      if ((com.tencent.mm.s.a.cf(parama.JOR.getContext())) || (com.tencent.mm.s.a.cd(parama.JOR.getContext())) || (com.tencent.mm.s.a.ch(parama.JOR.getContext())))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        AppMethodBeat.o(36799);
        return true;
      }
      if (paramc.a(parama, paramb, parambu))
      {
        AppMethodBeat.o(36799);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.hzN, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.JOR.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambu.field_msgId, parambu.field_msgSvrId, parambu);
        AppMethodBeat.o(36799);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(161905);
      if ((bt.isNullOrNil(paramb.hCo)) && (bt.isNullOrNil(paramb.hCn)))
      {
        parambu = paramb.url;
        if (parama.fFv()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.Q(parambu, paramc);
          parambu = new Intent();
          parambu.putExtra("rawUrl", paramc);
          parambu.putExtra("webpageTitle", paramb.title);
          parambu.putExtra("shortUrl", paramb.url);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
          AppMethodBeat.o(161905);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.b(parama, parambu);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.fFv()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.am.h.H(parambu));
        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(parama.JOR.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambu), parama.fFv(), paramb, localBundle);
        AppMethodBeat.o(161905);
        return true;
        if (w.zE(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean c(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36800);
      Object localObject1 = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).hys)) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).hyu)))
      {
        String str2 = ((com.tencent.mm.ai.a)localObject1).hys;
        String str3 = ((com.tencent.mm.ai.a)localObject1).hyr;
        String str1;
        int i;
        if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).hyv))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ai.a)localObject1).hyt;
          paramb = paramb.hCo;
          localObject1 = ((com.tencent.mm.ai.a)localObject1).hyu;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { str2, str3, str1, str4, paramb, localObject1 });
          Object localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
          if (!w.vF(parama.getTalkerUserName())) {
            break label308;
          }
          i = 2;
          label155:
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(17608, new Object[] { Integer.valueOf(i), paramb, Integer.valueOf(1), Integer.valueOf(1) });
          if (bt.isNullOrNil(str2)) {
            break label314;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_chatting_wording", str1);
          ((Bundle)localObject2).putString("key_chatting_text", str4);
          ((Bundle)localObject2).putString("key_chatting_appid", paramb);
          ((Bundle)localObject2).putLong("key_msg_id", parambu.field_msgId);
          ((Bundle)localObject2).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject2).putString("key_sender_username", paramc.b(parama, parambu));
          e.a(parama, str2, str3, (String)localObject1, (Bundle)localObject2);
        }
        for (;;)
        {
          AppMethodBeat.o(36800);
          return true;
          str1 = ((com.tencent.mm.ai.a)localObject1).hyv;
          break;
          label308:
          i = 1;
          break label155;
          label314:
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgFrom", "hy: video msg invalid!!");
        }
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgFrom", "hy: no remote url provided. treat as default");
      AppMethodBeat.o(36800);
      return false;
    }
    
    public static boolean d(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36801);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.hCn, paramb.hCm, paramb.hCo, paramb.url, Integer.valueOf(paramb.hCz), paramb.hCq });
      if ((44 == paramb.type) && ((!paramb.ev(false)) || (bt.isNullOrNil(paramb.t(parama.JOR.getContext(), false)))))
      {
        AppMethodBeat.o(36801);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambu);
      paramc = new Bundle();
      int i;
      if ((parama.JOR instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        paramc.putInt("stat_scene", i);
        paramc.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
        paramc.putString("stat_chat_talker_username", (String)localObject);
        paramc.putString("stat_send_msg_user", str);
        switch (paramb.hCp)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cw(parambu);
        if (i != 0) {
          break label582;
        }
        AppMethodBeat.o(36801);
        return true;
        if (parama.fFv())
        {
          i = 2;
          break;
        }
        if (w.zE((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_username", paramb.hCn);
        if (parama.fFv())
        {
          localIntent.putExtra("key_from_scene", 1);
          localIntent.putExtra("key_scene_note", (String)localObject + ":" + str);
        }
        for (;;)
        {
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.hCo;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).jIU = paramb.hCz;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.hCr;
          localIntent.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bet());
          localIntent.putExtra("_stat_obj", paramc);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "appbrand", ".ui.AppBrandProfileUI", localIntent);
          i = 0;
          break;
          localIntent.putExtra("key_from_scene", 2);
          localIntent.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.JOR instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.am.h.H(parambu))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1157, paramb, paramc);
          i = 0;
        }
        else if (w.zE((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, paramc);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.fFv(), paramb, paramc);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.fFv(), paramb, paramc);
          i = 0;
        }
      }
      label582:
      AppMethodBeat.o(36801);
      return false;
    }
    
    public static boolean e(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(169872);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bt.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambu.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambu.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject1 = (ae)paramb.ao(ae.class);
        if ((localObject1 != null) && (!bt.isNullOrNil(((ae)localObject1).DBG)))
        {
          paramb = new eeq();
          paramb.DBG = ((ae)localObject1).DBG;
          paramb.DBH = ((ae)localObject1).DBH;
          paramb.DBI = ((ae)localObject1).DBI;
          paramb.DBJ = ((ae)localObject1).DBJ;
          paramb.DBK = ((ae)localObject1).DBK;
          paramb.DBO = ((ae)localObject1).DBO;
          paramb.qeQ = ((ae)localObject1).qeQ;
          paramb.qeR = ((ae)localObject1).qeR;
          paramb.uaw = ((ae)localObject1).uaw;
          paramb.DBL = ((ae)localObject1).DBL;
          paramb.DBM = ((ae)localObject1).DBM;
          paramb.DBN = ((ae)localObject1).DBN;
          paramb.source = ((ae)localObject1).source;
          paramb.lox = ((ae)localObject1).lox;
          paramb.DBP = ((ae)localObject1).DBP;
          paramb.DBR = ((ae)localObject1).DBR;
          paramb.DBS = ((ae)localObject1).DBS;
          paramb.DBT = ((ae)localObject1).DBT;
          paramb.DBQ = ((ae)localObject1).DBQ;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.JOR.getContext().getString(2131759717));
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambu);
          com.tencent.mm.plugin.websearch.api.ad.a(parama.JOR.getContext(), paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject2 = paramb.url;
        PackageInfo localPackageInfo;
        Intent localIntent;
        int j;
        if (parama.fFv())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject2, (String)localObject1);
          String str = paramb.url;
          localPackageInfo = c.getPackageInfo(parama.JOR.getContext(), paramb.appId);
          localIntent = new Intent();
          j = parama.JOR.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WM((String)localObject2))
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
          if (bt.isNullOrNil(str)) {
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
          if (!bt.isNullOrNil(paramb.dHo))
          {
            localIntent.putExtra("srcUsername", paramb.dHo);
            localIntent.putExtra("srcDisplayname", paramb.dHp);
          }
          localIntent.putExtra("msg_id", parambu.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambu.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambu));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambu.fkz);
          i = com.tencent.mm.model.x.aG(paramc.b(parama, parambu), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambu.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambu));
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
            paramc = (com.tencent.mm.ai.e)paramb.ao(com.tencent.mm.ai.e.class);
            if (paramc == null) {
              break;
            }
          }
        }
        for (int i = paramc.hzh;; i = -1)
        {
          localIntent.putExtra(e.m.IUR, i);
          localIntent.addFlags(536870912);
          if ((paramc == null) || (i != 5) || (paramc.hzj != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg())) {
            break label1270;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.IUn, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.IUo, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.JOR.getContext(), parambu.field_msgId, parambu.field_msgSvrId, 0, paramb);
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
        com.tencent.mm.am.l.b(parambu, paramb);
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.JOR.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(169872);
        return true;
      }
      AppMethodBeat.o(169872);
      return false;
    }
    
    private s.i j(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36791);
      if (this.Kaw == null) {
        this.Kaw = new s.i(parama);
      }
      parama = this.Kaw;
      AppMethodBeat.o(36791);
      return parama;
    }
    
    private s.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36792);
      if (this.Kax == null) {
        this.Kax = new s.l(parama);
      }
      parama = this.Kax;
      AppMethodBeat.o(36792);
      return parama;
    }
    
    private s.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36793);
      if (this.Kay == null) {
        this.Kay = new s.j(parama);
      }
      parama = this.Kay;
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
        localObject = new ah(paramLayoutInflater, 2131493431);
        ((View)localObject).setTag(new e.c().y((View)localObject, true));
      }
      AppMethodBeat.o(36794);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bu parambu, String paramString)
    {
      AppMethodBeat.i(36795);
      final e.c localc = (e.c)parama;
      this.JBI = parama1;
      localc.reset();
      String str = parambu.getContent();
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bI(parambu);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bJ(parambu);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bK(parambu);
      int i;
      if (this.ruk)
      {
        i = parambu.getContent().indexOf(':');
        if (i != -1) {
          str = parambu.getContent().substring(i + 1);
        }
      }
      for (;;)
      {
        k.b localb;
        Object localObject3;
        int k;
        Object localObject2;
        com.tencent.mm.pluginsdk.model.app.g localg;
        label547:
        boolean bool1;
        if (str != null)
        {
          localb = k.b.aA(str, parambu.VU());
          localObject3 = com.tencent.mm.ai.t.yw(str);
          localObject1 = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
          i = 0;
          k = 0;
          localc.Kao.setVisibility(8);
          localObject2 = localObject1;
          if (localb != null)
          {
            localc.JZd.ar(localb.getTitle());
            localc.iCV.setText(localb.getDescription());
            localc.JZi.setMaxLines(1);
            localc.JZd.setTextColor(parama1.getContext().getResources().getColor(2131099732));
            localc.iCV.setTextColor(parama1.getContext().getResources().getColor(2131100482));
            localc.JZy.setBackgroundResource(2131231607);
            localc.JZy.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
            localc.JZc.setVisibility(0);
            localc.JZw.setVisibility(0);
            localc.iCV.setVisibility(0);
            localc.JZk.setVisibility(8);
            localc.JZn.setVisibility(8);
            localc.JZm.setVisibility(8);
            localc.JZA.setVisibility(8);
            localc.JZB.setVisibility(8);
            localc.JZf.setVisibility(8);
            localc.JZg.setVisibility(8);
            localc.JZK.setVisibility(8);
            localc.JZE.setVisibility(8);
            localc.JZy.setVisibility(0);
            localc.JZR.setVisibility(8);
            localc.JZZ.setVisibility(8);
            localc.Kah.setVisibility(8);
            localc.Kam.setVisibility(8);
            e.c.aI(localc.JZx, localc.Kaq);
            localb.ao(com.tencent.mm.ai.h.class);
            localc.JZx.setBackgroundResource(2131231607);
            localg = com.tencent.mm.pluginsdk.model.app.h.fX(localb.appId, localb.aDD);
            if (localg != null) {
              b(parama1, localb, parambu);
            }
            if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
              break label1697;
            }
            localObject2 = localb.appName;
            bool1 = true;
            com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 12);
            if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
              bool1 = o.a.eYW().dOM();
            }
            if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!fx((String)localObject2))) {
              break label1737;
            }
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), localg, (String)localObject2);
            if (localb.type != 19) {
              break label1707;
            }
            localc.rDq.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject2 }));
            label679:
            localc.rDq.setVisibility(0);
            localc.rDq.setCompoundDrawables(null, null, null, null);
            localc.JZh.setVisibility(0);
            localc.JZe.setVisibility(0);
            if ((localg == null) || (!localg.Eb())) {
              break label1720;
            }
            a(parama1, localc.rDq, parambu, localb, localg.field_packageName, parambu.VQ());
            label754:
            localc.JZe.setImageResource(2131231697);
            a(parama1, localc.JZe, localb.appId);
            i = 1;
          }
        }
        for (;;)
        {
          label782:
          if (localb.azb()) {
            localc.JZh.setVisibility(8);
          }
          label1025:
          label3719:
          label4232:
          label6027:
          for (int j = 0;; j = i)
          {
            localc.JZh.setBackgroundResource(2131233299);
            bool1 = false;
            localc.JZc.setVisibility(0);
            if ((!localb.azc()) && (this.oSO))
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
                      if (!e.b.aWA(parambu.VT())) {
                        localObject2 = com.tencent.mm.aw.q.aIF().e(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                      }
                    }
                  }
                }
              }
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localBitmap = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, false, com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 1));
                localc.JZc.setImageBitmap(localBitmap);
                label975:
                if (localb.type != 3) {
                  break label1932;
                }
                localc.JZy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  private boolean Kaz = false;
                  
                  public final boolean onPreDraw()
                  {
                    AppMethodBeat.i(36771);
                    if (this.Kaz)
                    {
                      localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                    localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.Kaz = true;
                    int i = com.tencent.mm.cc.a.fromDPToPix(parama1.JOR.getContext(), 24);
                    Bitmap localBitmap = this.val$bitmap;
                    Object localObject;
                    if (localBitmap != null)
                    {
                      localObject = localBitmap;
                      if (!localBitmap.isRecycled()) {}
                    }
                    else
                    {
                      localObject = com.tencent.mm.sdk.platformtools.g.aJ(parama1.JOR.getContext().getResources().getColor(2131100129), i, i);
                    }
                    int j = ((Bitmap)localObject).getHeight();
                    if (i > j) {
                      i = j;
                    }
                    for (;;)
                    {
                      localObject = com.tencent.mm.sdk.platformtools.g.l(com.tencent.mm.sdk.platformtools.g.aD(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                      j = localc.JZy.getHeight();
                      int k = localc.JZy.getWidth();
                      i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166037);
                      }
                      localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.b((Bitmap)localObject, 2131231553, j, i));
                      localc.JZy.setBackgroundDrawable((Drawable)localObject);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                  }
                });
                if (!com.tencent.mm.ui.al.isDarkMode()) {
                  break label1921;
                }
                localc.JZh.setBackgroundResource(2131233299);
                if ((localb.fkq != null) && (localb.fkq.length() != 0)) {
                  break label1959;
                }
                localc.JZp.setVisibility(8);
                label1054:
                localc.JZo.setOnClickListener(null);
                localc.JZs.setVisibility(0);
                localc.JZj.setVisibility(8);
                localc.JZv.setVisibility(0);
                localc.JZt.setVisibility(8);
                i = localb.type;
                if (localb.type == 66)
                {
                  if ((TextUtils.isEmpty(localb.hCn)) && (TextUtils.isEmpty(localb.hCo))) {
                    break label1989;
                  }
                  i = 33;
                }
              }
            }
            label1356:
            label2141:
            label3173:
            label6121:
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
                    break label7292;
                  }
                  localc.JZi.setVisibility(0);
                  localc.JZi.setMaxLines(2);
                  localc.JZi.setText(localb.title);
                  localc.JZd.setVisibility(8);
                  if (bool1)
                  {
                    if ((localb.type != 33) && (localb.type != 36)) {
                      break label7305;
                    }
                    paramString = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
                    localc.JZc.setImageResource(2131689584);
                    com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZc, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(50, 50));
                  }
                  if (localb.type == 44) {
                    e.c.a(parama1, localc, localb);
                  }
                }
                if (parama1.fFv()) {
                  break label7482;
                }
                if (!com.tencent.mm.pluginsdk.model.app.h.k(localg)) {
                  break label7466;
                }
                localc.JZr.setVisibility(0);
                c(parama1, localc.JZr, bk.a(localb, parambu));
                localObject2 = parama;
                if (i == 0)
                {
                  localc.JZx.setTag(localObject2);
                  localc.JZx.setOnClickListener(d(parama1));
                }
                if (this.oSO)
                {
                  localc.JZx.setOnLongClickListener(c(parama1));
                  localc.JZx.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
                }
                AppMethodBeat.o(36795);
                return;
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambu.VP()), paramString });
                localObject3 = null;
                localb = null;
                break;
                localObject2 = localg.field_appName;
                break label547;
                localc.rDq.setText((CharSequence)localObject2);
                break label679;
                a(parama1, localc.rDq, localb.appId);
                break label754;
                if (localb.type == 24)
                {
                  localc.rDq.setText(aj.getContext().getString(2131758845));
                  localc.JZh.setVisibility(0);
                  localc.rDq.setVisibility(0);
                  localc.JZe.setVisibility(8);
                  i = 1;
                  break label782;
                }
                if ((localb.type == 19) || (((com.tencent.mm.ai.t)localObject3).hDj == 19))
                {
                  localc.rDq.setText(aj.getContext().getString(2131757208));
                  localc.JZh.setVisibility(0);
                  localc.rDq.setVisibility(0);
                  localc.JZe.setVisibility(8);
                  i = 1;
                  break label782;
                }
                if (e.a(localb, localc)) {
                  break label7522;
                }
                localc.JZh.setVisibility(8);
                localc.rDq.setVisibility(8);
                localc.JZe.setVisibility(8);
                i = 0;
                break label782;
                bool1 = true;
                break label975;
                localc.JZh.setBackgroundResource(2131231682);
                break label1025;
                localc.JZc.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                bool1 = false;
                break label1025;
                localc.JZp.setVisibility(0);
                b(parama1, localc.JZp, bk.aWI(localb.fkq));
                break label1054;
                i = 5;
                break label1144;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZd.setVisibility(0);
                  localc.JZd.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.iCV.setVisibility(0);
                  localc.iCV.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.JZi.setVisibility(8);
                  localc.JZj.setVisibility(4);
                  localc.JZo.setVisibility(0);
                  if (!parambu.VP().equals(parama.JYu)) {
                    break label2286;
                  }
                  localc.JZo.setImageResource(2131233393);
                  localc.iCV.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label2300;
                    }
                    localc.JZc.setImageResource(2131689564);
                  }
                }
                for (;;)
                {
                  parama = new e.g();
                  parama.msgId = parambu.VP();
                  parama.dBS = parambu.getContent();
                  parama.dyy = parambu.VT();
                  localc.JZo.setTag(parama);
                  localc.JZo.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCv());
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.JZd.setVisibility(8);
                  break label2044;
                  localc.JZo.setImageResource(2131233395);
                  break label2141;
                  localc.JZc.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZd.setVisibility(0);
                  localc.JZd.setMaxLines(2);
                }
                for (;;)
                {
                  localc.iCV.setVisibility(0);
                  localc.JZi.setVisibility(8);
                  localc.JZo.setVisibility(8);
                  localc.JZj.setVisibility(4);
                  localc.iCV.setMaxLines(2);
                  localc.iCV.setText(bt.sy(localb.hzO));
                  e.c.a(localc, str, localb.hzO);
                  e.c.a(localc, Boolean.TRUE, parambu, localb.dks, localb.title);
                  if (!bool1) {
                    break label7498;
                  }
                  if (!e.b.aWz(localb.hzP)) {
                    break label2497;
                  }
                  localc.JZc.setImageResource(2131231063);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.JZd.setVisibility(8);
                }
                localc.JZc.setImageResource(com.tencent.mm.pluginsdk.model.q.aLB(localb.hzP));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                continue;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZd.setVisibility(0);
                  localc.iCV.setVisibility(0);
                  localc.JZi.setVisibility(8);
                  localc.JZo.setVisibility(0);
                  localc.JZo.setImageResource(2131234464);
                  localc.JZj.setVisibility(4);
                  localc.iCV.setMaxLines(2);
                  if (!bool1) {
                    break label7498;
                  }
                  paramString = new com.tencent.mm.aw.a.a.c.a();
                  paramString.pH(2131689584).aIZ().dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50)).aIX().aJa().an(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1));
                  localObject2 = com.tencent.mm.aw.q.aIJ();
                  if (!bt.isNullOrNil(localb.thumburl)) {
                    break label2745;
                  }
                }
                for (parama = localb.hzV;; parama = localb.thumburl)
                {
                  ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.JZc, paramString.aJc());
                  localc.JZo.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.JZd.setVisibility(8);
                  break label2553;
                }
                if (localb != null) {
                  e.a(paramString, parama1, parambu, localb);
                }
                parama = (com.tencent.mm.ai.e)localb.ao(com.tencent.mm.ai.e.class);
                if ((parama != null) && (parama.hzj == 1) && (parama.hzh == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg()))
                {
                  e.c.a(parama1, localc, localb, parambu, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                }
                else
                {
                  if ((j == 0) && (af.a(localb, parama)))
                  {
                    localc.Kah.setVisibility(0);
                    localc.Kam.setVisibility(0);
                    af.a(parama1.getContext(), localb, localc.Kaj, localc.Kak);
                    af.b(localc.Kal, localb);
                  }
                  localc.JZd.setVisibility(8);
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.JZi.setMaxLines(2);
                    localc.JZi.setVisibility(0);
                    localc.JZi.setText(localb.getTitle());
                    localc.iCV.setMaxLines(3);
                    if (!e.l(localb)) {
                      break label3160;
                    }
                    localc.JZo.setVisibility(0);
                    localc.JZo.setImageResource(2131234464);
                    localc.JZj.setVisibility(4);
                    if (!bool1) {
                      break label7498;
                    }
                    paramString = new com.tencent.mm.aw.a.a.c.a();
                    paramString.pH(2131689584).aIZ().FF(com.tencent.mm.plugin.image.d.dcT()).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50)).aIX().aJa().an(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1));
                    localObject2 = com.tencent.mm.aw.q.aIJ();
                    if (!bt.isNullOrNil(localb.thumburl)) {
                      break label3173;
                    }
                  }
                  for (parama = localb.hzV;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.JZc, paramString.aJc());
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    localc.JZi.setVisibility(8);
                    break label2963;
                    localc.JZo.setVisibility(8);
                    break label3000;
                  }
                  if (localc.JZx.getLayoutParams() != null)
                  {
                    localc.JZx.getLayoutParams().width = -2;
                    localc.JZx.requestLayout();
                  }
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(localb.hCn);
                  final boolean bool2;
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label3530;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.JZy.setVisibility(8);
                    localc.JZK.setVisibility(0);
                    localc.JZE.setVisibility(8);
                    localc.JZR.setVisibility(8);
                    if (!e.a(parambu, localb, parama1)) {
                      break label3540;
                    }
                    localc.Kao.setVisibility(0);
                    bool2 = bt.isNullOrNil(parambu.VY());
                    localc.Kao.setTag(parambu);
                    localc.Kao.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(179950);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.bd(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                        e.a((com.tencent.mm.storage.bu)paramAnonymousView.getTag(), localc, parama1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(179950);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    localc.JZO.setText(localb.title);
                    e.e(localc.JZO, localb.title);
                    localc.JZI.setText(parama);
                    e.a(localc.JZJ, localb);
                    com.tencent.mm.aw.q.aIJ().a(paramString, localc.JZH, ac.d.fOJ);
                    parama = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
                    localc.JZL.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZL, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label3553;
                    }
                    localc.kkf.setVisibility(0);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    parama = localb.dHp;
                    break label3246;
                    paramString = localb.hCB;
                    break label3258;
                    localc.Kao.setVisibility(8);
                  }
                  localc.kkf.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  continue;
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(localb.hCn);
                  ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.r.class)).LQ(localb.hCn);
                  switch (localb.hCp)
                  {
                  default: 
                    paramInt = 1;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                  case 2: 
                  case 3: 
                    if (localc.JZx.getLayoutParams() != null)
                    {
                      localc.JZx.getLayoutParams().width = -2;
                      localc.JZx.requestLayout();
                    }
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4008;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.JZy.setVisibility(8);
                      localc.JZK.setVisibility(0);
                      localc.JZE.setVisibility(8);
                      localc.JZR.setVisibility(8);
                      localc.JZO.setText(localb.title);
                      e.e(localc.JZO, localb.title);
                      localc.JZI.setText(parama);
                      e.a(localc.JZJ, localb);
                      com.tencent.mm.aw.q.aIJ().a(paramString, localc.JZH, ac.d.fOJ);
                      parama = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
                      localc.JZL.setImageBitmap(null);
                      localc.JZL.setVisibility(4);
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4018;
                      }
                      localc.kkf.setVisibility(0);
                      if (!e.a(parambu, localb, parama1)) {
                        break label4031;
                      }
                      localc.Kao.setVisibility(0);
                      bool2 = bt.isNullOrNil(parambu.VY());
                      localc.Kao.setTag(parambu);
                      localc.Kao.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymousView)
                        {
                          AppMethodBeat.i(185027);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bd(paramAnonymousView);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                          e.a((com.tencent.mm.storage.bu)paramAnonymousView.getTag(), localc, parama1);
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(185027);
                        }
                      });
                      e.a(bool2, localc, parama1);
                    }
                    for (;;)
                    {
                      bool2 = e.m(localb);
                      com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
                      {
                        public final String BM()
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
                            localc.JZL.setImageBitmap(paramAnonymousBitmap);
                            localc.JZL.setVisibility(0);
                            localc.JZN.setVisibility(4);
                            if (bool2)
                            {
                              localc.JZM.setImageDrawable(com.tencent.mm.cc.a.l(parama1.JOR.getContext(), 2131691166));
                              localc.JZM.setVisibility(0);
                              AppMethodBeat.o(36779);
                              return;
                            }
                            localc.JZM.setVisibility(8);
                            AppMethodBeat.o(36779);
                            return;
                          }
                          localc.JZL.setVisibility(4);
                          localc.JZN.setVisibility(0);
                          localc.JZM.setVisibility(8);
                          AppMethodBeat.o(36779);
                        }
                        
                        public final void aEd()
                        {
                          AppMethodBeat.i(36778);
                          AppMethodBeat.o(36778);
                        }
                        
                        public final void ox()
                        {
                          AppMethodBeat.i(36780);
                          AppMethodBeat.o(36780);
                        }
                      }, e.access$600(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.dHp;
                      break label3707;
                      paramString = localb.hCB;
                      break label3719;
                      localc.kkf.setVisibility(8);
                      break label3868;
                      localc.Kao.setVisibility(8);
                    }
                  case 1: 
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4203;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.JZy.setVisibility(8);
                      localc.JZK.setVisibility(8);
                      localc.JZE.setVisibility(0);
                      localc.JZG.setText(parama);
                      localc.JZR.setVisibility(8);
                      if (!bt.isNullOrNil(paramString)) {
                        break label4209;
                      }
                      parama = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
                      com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZF, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
                    }
                    for (;;)
                    {
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4232;
                      }
                      localc.JZQ.setVisibility(0);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.title;
                      break label4055;
                      paramString = null;
                      break label4067;
                      com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZF, paramString, com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
                    }
                    localc.JZQ.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                  case 0: 
                    localc.JZh.setVisibility(0);
                    localc.JZe.setVisibility(0);
                    localc.JZe.setBackground(null);
                    localc.JZe.setImageResource(2131689681);
                    e.a(localc.rDq, localb);
                    break label1356;
                    parama = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
                    paramString = localb.hCB;
                    localObject2 = localb.dHp;
                    str = localb.title;
                    localObject3 = localb.description;
                    if ((parama == null) || (bt.isNullOrNil(parama.hys)) || (bt.isNullOrNil(parama.hyu)))
                    {
                      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                      break label1356;
                    }
                    localc.JZX.setText((CharSequence)localObject2);
                    localc.JZy.setVisibility(8);
                    localc.JZK.setVisibility(8);
                    localc.JZE.setVisibility(8);
                    localc.JZY.setVisibility(0);
                    localc.JZU.setVisibility(8);
                    localc.JZY.setImageDrawable(com.tencent.mm.cc.a.l(parama1.getContext(), 2131691166));
                    localc.JZR.setVisibility(0);
                    localc.JZS.setText(str);
                    localc.JZT.setText((CharSequence)localObject3);
                    com.tencent.mm.aw.q.aII().a(paramString, new r.a()
                    {
                      public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                      {
                        AppMethodBeat.i(36783);
                        aq.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(36782);
                            if (!paramAnonymousBitmap.isRecycled()) {
                              e.d.7.this.Kau.JZW.setImageBitmap(paramAnonymousBitmap);
                            }
                            AppMethodBeat.o(36782);
                          }
                        });
                        AppMethodBeat.o(36783);
                      }
                    });
                    paramString = com.tencent.mm.modelappbrand.a.b.aDV().a(parama.hyu, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hKs));
                    if (paramString != null)
                    {
                      localc.JZV.setImageBitmap(paramString);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                    }
                    else
                    {
                      com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
                      {
                        public final String BM()
                        {
                          AppMethodBeat.i(36786);
                          String str = "CHAT#" + com.tencent.mm.plugin.appbrand.z.n.cG(this);
                          AppMethodBeat.o(36786);
                          return str;
                        }
                        
                        public final void E(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36785);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.JZV.setImageBitmap(paramAnonymousBitmap);
                            localc.JZV.setVisibility(0);
                          }
                          AppMethodBeat.o(36785);
                        }
                        
                        public final void aEd()
                        {
                          AppMethodBeat.i(36784);
                          localc.JZV.setVisibility(4);
                          AppMethodBeat.o(36784);
                        }
                        
                        public final void ox()
                        {
                          AppMethodBeat.i(185028);
                          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                          com.tencent.mm.plugin.report.service.g.yhR.dD(808, 2);
                          AppMethodBeat.o(185028);
                        }
                      }, parama.hyu, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hKs));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      paramInt = 1;
                      localc.JZi.setMaxLines(2);
                      localc.iCV.setMaxLines(3);
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.JZd.setVisibility(8);
                      if ((localb.title != null) && (localb.title.trim().length() > 0))
                      {
                        localc.JZi.setMaxLines(2);
                        localc.JZi.setVisibility(0);
                        localc.JZi.setText(localb.getTitle());
                      }
                      for (;;)
                      {
                        localc.iCV.setMaxLines(3);
                        localc.JZo.setVisibility(8);
                        localc.JZj.setVisibility(4);
                        if (!bool1) {
                          break label7498;
                        }
                        parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label4811;
                        }
                        localc.JZc.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        localc.JZi.setVisibility(8);
                      }
                      localc.JZc.setImageBitmap(parama);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.JZi.setVisibility(0);
                      if (localb.hAn == 1) {
                        localc.JZi.setText(2131762858);
                      }
                      for (;;)
                      {
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.JZd.setVisibility(0);
                          localc.JZd.ar(localb.getTitle());
                        }
                        localc.iCV.setMaxLines(4);
                        localc.JZj.setVisibility(4);
                        localc.JZo.setVisibility(8);
                        if (!bool1) {
                          break label7498;
                        }
                        parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                        if ((parama == null) || (parama.isRecycled())) {
                          break label5047;
                        }
                        localc.JZc.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        if (localb.hAn == 2) {
                          localc.JZi.setText(2131762860);
                        } else if (localb.hAn == 3) {
                          localc.JZi.setText(2131762859);
                        } else {
                          localc.JZi.setText(2131762861);
                        }
                      }
                      localc.JZc.setImageResource(2131689584);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.JZd.setVisibility(0);
                      localc.JZd.ar(localb.getTitle());
                      localc.JZi.setVisibility(0);
                      localc.JZi.setText(2131757247);
                      localc.iCV.setMaxLines(4);
                      localc.JZj.setVisibility(4);
                      localc.JZo.setVisibility(8);
                      if (!bool1) {
                        break label7498;
                      }
                      parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                      if ((parama != null) && (!parama.isRecycled()))
                      {
                        localc.JZc.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                      }
                      else
                      {
                        localc.JZc.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.JZd.setVisibility(0);
                          localc.JZd.ar(localb.getTitle());
                          localc.JZi.setVisibility(8);
                        }
                        localc.iCV.setMaxLines(4);
                        localc.JZj.setVisibility(4);
                        localc.JZo.setVisibility(8);
                        if (!bool1) {
                          break label7498;
                        }
                        parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          localc.JZc.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                        }
                        else
                        {
                          localc.JZc.setImageResource(2131689584);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                          continue;
                          if ((localb.title != null) && (localb.title.length() > 0)) {
                            localc.JZd.setVisibility(0);
                          }
                          for (;;)
                          {
                            localc.iCV.setVisibility(0);
                            localc.JZi.setVisibility(8);
                            localc.JZo.setVisibility(8);
                            localc.JZj.setVisibility(4);
                            localc.iCV.setMaxLines(2);
                            if (!bool1) {
                              break label7498;
                            }
                            parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                            if ((parama != null) && (!parama.isRecycled())) {
                              break label5523;
                            }
                            localc.JZc.setImageResource(2131689584);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = k;
                            break;
                            localc.JZd.setVisibility(8);
                          }
                          localc.JZc.setImageBitmap(parama);
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
                localc.JZd.setVisibility(0);
                localc.iCV.setVisibility(0);
                localc.JZi.setVisibility(8);
                localc.JZo.setVisibility(8);
                localc.JZj.setVisibility(4);
                localc.iCV.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5757;
                  }
                  localc.JZc.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bk(parambu, false, paramInt, "", false, localb.title, localb.dHo, localb.dHp, localb.title, localb.hAv, localb.url, false, false);
                localc.JZx.setTag(parama);
                localc.JZx.setOnClickListener(i(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.JZd.setVisibility(8);
                break label5572;
                localc.JZc.setImageBitmap(parama);
              }
            case 25: 
              label2286:
              label2553:
              label3707:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.JZd.setVisibility(0);
                localc.iCV.setVisibility(0);
                localc.JZi.setVisibility(8);
                localc.JZo.setVisibility(8);
                localc.JZj.setVisibility(4);
                localc.iCV.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5987;
                  }
                  localc.JZc.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                label4203:
                label4209:
                parama = new bk(parambu, paramInt, "", parama1.fCR(), localb.dHo, localb.dHp, localb.title, localb.hCb, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.JZx.setTag(parama);
                localc.JZx.setOnClickListener(j(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.JZd.setVisibility(8);
                break label5797;
                localc.JZc.setImageBitmap(parama);
              }
            case 26: 
            case 27: 
              label1144:
              label2044:
              label5757:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.JZd.setVisibility(0);
                localc.iCV.setVisibility(0);
                localc.JZi.setVisibility(8);
                localc.JZo.setVisibility(8);
                localc.JZj.setVisibility(4);
                localc.iCV.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6298;
                  }
                  localc.JZc.setImageResource(2131689584);
                }
                parama = new bk();
                parama.dBd = parambu;
                parama.Jxs = false;
                parama.position = paramInt;
                parama.Kht = false;
                parama.title = parama1.fCR();
                parama.dHo = localb.dHo;
                parama.dHp = localb.dHp;
                parama.Khu = localb.title;
                if (localb.type != 26) {
                  break label6310;
                }
                parama.tid = localb.tid;
                parama.hCc = localb.hCc;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.JZx.setOnClickListener(k(parama1));
                paramInt = 1;
              }
              label1521:
              label2300:
              break;
            }
            label1419:
            label1932:
            label7181:
            for (;;)
            {
              label1582:
              label1720:
              label1737:
              label3160:
              label3553:
              label4067:
              localc.JZx.setTag(parama);
              label1697:
              label1707:
              label1989:
              label3530:
              label3540:
              label4055:
              label5987:
              j = 0;
              label1959:
              label2497:
              label4811:
              i = paramInt;
              label2745:
              label3258:
              label4031:
              label5572:
              paramInt = j;
              label2963:
              label3000:
              break;
              label3246:
              label4018:
              label5047:
              localc.JZd.setVisibility(8);
              label3868:
              label4008:
              break label6027;
              label5523:
              label5797:
              localc.JZc.setImageBitmap(parama);
              label6298:
              break label6121;
              label6310:
              if (localb.type == 27)
              {
                parama.tid = localb.tid;
                parama.hCc = localb.hCc;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.JZx.setOnClickListener(l(parama1));
                paramInt = 1;
                continue;
                localc.JZd.setVisibility(0);
                localc.JZd.ar(localb.description);
                localc.iCV.setText(localb.hBb);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZi.setVisibility(0);
                  localc.JZi.setText(localb.title);
                }
                for (;;)
                {
                  localc.iCV.setMaxLines(4);
                  localc.JZj.setVisibility(4);
                  localc.JZo.setVisibility(8);
                  if (!bool1) {
                    break label7498;
                  }
                  parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6559;
                  }
                  localc.JZc.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.JZi.setVisibility(8);
                }
                localc.JZc.setImageResource(2131689584);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                localc.JZd.setVisibility(8);
                localc.JZi.setVisibility(0);
                if ((localb.title != null) && (localb.title.trim().length() > 0)) {
                  localc.JZi.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.JZi.getContext(), localb.title, localc.JZi.getTextSize()));
                }
                for (;;)
                {
                  localc.iCV.setMaxLines(3);
                  localc.JZo.setVisibility(8);
                  localc.JZj.setVisibility(4);
                  if (bool1)
                  {
                    localc.JZc.setVisibility(8);
                    localc.JZw.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, parambu, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.JZi.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.JZi.getContext(), aj.getContext().getString(2131759034), localc.JZi.getTextSize()));
                }
                e.c.a(parama1, localc, localb, bool1);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZd.setVisibility(0);
                  if (!bt.isNullOrNil(localb.titleColor))
                  {
                    localc.JZd.setTextColor(bt.cJ(localb.titleColor, parama1.getContext().getResources().getColor(2131100711)));
                    label6861:
                    localc.iCV.setMaxLines(2);
                    localc.iCV.setVisibility(0);
                    if (bt.isNullOrNil(localb.hBk)) {
                      break label7157;
                    }
                    localc.iCV.setTextColor(bt.cJ(localb.hBk, parama1.getContext().getResources().getColor(2131100469)));
                    localc.JZi.setVisibility(8);
                    localc.JZj.setVisibility(4);
                    localc.JZo.setVisibility(8);
                    localc.JZh.setVisibility(0);
                    localc.rDq.setVisibility(0);
                    if (bt.isNullOrNil(localb.hBg)) {
                      break label7181;
                    }
                    localc.rDq.setText(localb.hBg);
                  }
                }
                for (;;)
                {
                  if (this.oSO)
                  {
                    parama = com.tencent.mm.aw.q.aIF().e(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = com.tencent.mm.sdk.platformtools.g.a(parama, false, parama.getWidth() / 2);
                      localc.JZc.setImageBitmap(paramString);
                    }
                    if (!bt.isNullOrNil(localb.hBj))
                    {
                      com.tencent.mm.aw.q.aIJ().a(localb.hBj, new ImageView(parama1.getContext()), new com.tencent.mm.aw.a.a.c.a().aIY().aJc(), new com.tencent.mm.aw.a.c.h()
                      {
                        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
                        {
                          return null;
                        }
                        
                        public final void b(String paramAnonymousString, View paramAnonymousView) {}
                        
                        public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
                        {
                          AppMethodBeat.i(36788);
                          if (paramAnonymousb.bitmap != null)
                          {
                            paramAnonymousString = paramAnonymousb.bitmap;
                            localc.JZy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36787);
                                e.d.9.this.Kau.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.d.9.this.Kau.JZy.getHeight();
                                int k = e.d.9.this.Kau.JZy.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cc.a.ax(e.d.9.this.JYk.JOR.getContext(), 2131166036);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cc.a.ax(e.d.9.this.JYk.JOR.getContext(), 2131166037);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.b(paramAnonymousString, 2131231553, j, i));
                                e.d.9.this.Kau.JZy.setBackgroundDrawable(localBitmapDrawable);
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
                      localc.JZd.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label6861;
                      localc.JZd.setVisibility(8);
                      break label6861;
                      label7157:
                      localc.iCV.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                      break label6919;
                      localc.rDq.setText(2131757206);
                      continue;
                    }
                    localc.JZy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean Kaz = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36789);
                        if (this.Kaz)
                        {
                          localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                        localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.Kaz = true;
                        int i = com.tencent.mm.cc.a.fromDPToPix(parama1.JOR.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = com.tencent.mm.sdk.platformtools.g.aJ(parama1.JOR.getContext().getResources().getColor(2131100129), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = com.tencent.mm.sdk.platformtools.g.l(com.tencent.mm.sdk.platformtools.g.aD(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                          j = localc.JZy.getHeight();
                          int k = localc.JZy.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166036);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166037);
                          }
                          localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.b((Bitmap)localObject, 2131231553, j, i));
                          localc.JZy.setBackgroundDrawable((Drawable)localObject);
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
                localc.JZc.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if (((com.tencent.mm.ai.t)localObject3).hDj == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  label7292:
                  localc.JZi.setVisibility(8);
                  break label1419;
                  localObject1 = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = com.tencent.mm.aw.q.aIF().e(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.JZc.setImageBitmap(paramString);
                    break label1521;
                  }
                  if (!bt.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.aw.a.a.c.a();
                    ((com.tencent.mm.aw.a.a.c.a)localObject1).pH(2131100141).aIZ().aIX();
                    com.tencent.mm.aw.q.aIJ().a(paramString, localc.Kab, ((com.tencent.mm.aw.a.a.c.a)localObject1).aJc());
                    break label1521;
                  }
                  localc.JZc.setImageResource(2131231063);
                  break label1521;
                  label7466:
                  localc.JZr.setVisibility(8);
                  localObject2 = parama;
                  break label1582;
                  label7482:
                  localc.JZr.setVisibility(8);
                  localObject2 = parama;
                  break label1582;
                }
                label7498:
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
              }
              label6559:
              paramInt = 0;
            }
          }
          label1921:
          label6919:
          label7305:
          label7522:
          i = 1;
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bu parambu)
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
        if (!ab.bn(parambu))
        {
          com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), parama.JOR.getContext().getString(2131766957), "", parama.JOR.getContext().getString(2131766205), null);
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = bl.E(parambu);
        if (bt.isNullOrNil(paramMenuItem)) {
          e.b.a(parama, parambu, b(parama, parambu));
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36790);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(36790);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36772);
              e.b.a(parama, parambu, e.d.this.b(parama, parambu));
              com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(36772);
            }
          });
        }
      case 114: 
        paramMenuItem = parambu.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = k.b.yr(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          com.tencent.mm.ui.chatting.al.a(parambu, bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.d(parambu, parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.b(parambu, bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.a(parambu, parama.JOR.getContext(), b(parama, parambu), parama.fFv());
          continue;
          com.tencent.mm.ui.chatting.al.p(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.c(parambu, bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.c(parambu, parama.JOR.getContext());
        }
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", parambu.field_msgId);
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36797);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(194322);
      int i = ((bk)paramView.getTag()).position;
      int j = com.tencent.mm.pluginsdk.model.app.m.aLM(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
      k.b localb = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.j.aX(parambu)))
      {
        if (localb.type != 6) {
          break label626;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.m.aLN(localb.dks);
        if (((localc == null) || (!e.b.e(parambu, localc.field_fileFullPath))) && (!parambu.frT())) {
          paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
        }
      }
      boolean bool1;
      if ((localb.hzO <= 0) || ((localb.hzO > 0) && (j >= 100))) {
        switch (localb.type)
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        label275:
        if ((bool1) && (!this.JBI.fFw())) {
          paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.bs.d.aIu("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Eb()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new eb();
          ((eb)localObject).dpg.msgId = parambu.field_msgId;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((eb)localObject).dph.doF) || (e.b.a(this.JBI.JOR.getContext(), localb))) {
            paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
          }
          if (bl.z(parambu)) {
            paraml.clear();
          }
          if (!this.JBI.fFw()) {
            paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
          }
          if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bu.flY())) {
            paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
          }
          AppMethodBeat.o(194322);
          return true;
          label626:
          paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
          break;
          bool1 = com.tencent.mm.am.g.aFJ();
          break label275;
          bool1 = com.tencent.mm.am.g.aFD();
          break label275;
          boolean bool2 = com.tencent.mm.am.g.aFH();
          bool1 = bool2;
          if (bt.aRt(localb.hzP)) {
            break label275;
          }
          paraml.a(i, 150, this.JBI.JOR.getMMResources().getString(2131757229), 2131691578);
          bool1 = bool2;
          break label275;
          bool1 = com.tencent.mm.am.g.aFA();
          break label275;
          bool1 = com.tencent.mm.am.g.aFz();
          break label275;
          bool1 = com.tencent.mm.am.g.aFF();
          break label275;
          bool1 = com.tencent.mm.am.g.aFB();
          break label275;
          if ((localb.hBc != 5) && (localb.hBc != 6) && (localb.hBc != 2)) {
            break label910;
          }
          if ((localb.hBc != 2) || (bl.z(parambu))) {
            paraml.clear();
          }
          paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(194322);
          return false;
          paraml.clear();
          paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(194322);
          return false;
          paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        label910:
        bool1 = false;
      }
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36798);
      com.tencent.mm.modelstat.a.a(parambu, a.a.inW);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      Object localObject = parambu.field_content;
      paramView = Boolean.FALSE;
      if (localObject == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      final k.b localb = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      localObject = com.tencent.mm.ai.t.yw((String)localObject);
      if (localb == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      if (((com.tencent.mm.ai.t)localObject).hDj != 0)
      {
        paramView = Boolean.TRUE;
        localb.type = ((com.tencent.mm.ai.t)localObject).hDj;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false);
      final String str = d(parama, parambu);
      if (localObject != null) {
        a(parama, localb, str, (com.tencent.mm.pluginsdk.model.app.g)localObject, parambu.field_msgSvrId, parama.getTalkerUserName());
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
            while ((i != 0) && (e(localb, parama, this, parambu)))
            {
              AppMethodBeat.o(36798);
              return true;
              com.tencent.mm.plugin.report.service.g.yhR.f(13043, new Object[] { Integer.valueOf(2), localb.description, localb.appId });
              com.tencent.mm.am.l.b(parambu, localb);
              boolean bool = a(localb, parama, this, parambu);
              AppMethodBeat.o(36798);
              return bool;
              if (!this.oSO)
              {
                com.tencent.mm.ui.base.t.g(parama.JOR.getContext(), parama.JOR.getContentView());
                AppMethodBeat.o(36798);
                return true;
              }
              paramView = new Intent();
              paramView.setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramView.putExtra("scene", 2);
              paramView.putExtra("app_msg_id", parambu.field_msgId);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36798);
              return true;
              if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).Eb()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if ((localb.dks == null) || (localb.dks.length() == 0)) {
                ((com.tencent.mm.ui.chatting.d.b.b)parama.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a(parambu, new com.tencent.mm.pluginsdk.model.app.al()
                {
                  public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                  {
                    AppMethodBeat.i(194321);
                    if (this.nOm != null)
                    {
                      if (paramAnonymousBoolean1)
                      {
                        e.d.a(parama, localb, str, this.nOm, parambu.field_msgSvrId, 3, parama.getTalkerUserName());
                        AppMethodBeat.o(194321);
                        return;
                      }
                      e.d.a(parama, localb, str, this.nOm, parambu.field_msgSvrId, 7, parama.getTalkerUserName());
                    }
                    AppMethodBeat.o(194321);
                  }
                });
              }
              for (;;)
              {
                AppMethodBeat.o(36798);
                return true;
                if (!this.oSO)
                {
                  com.tencent.mm.ui.base.t.g(parama.JOR.getContext(), parama.JOR.getContentView());
                  AppMethodBeat.o(36798);
                  return true;
                }
                paramView = new Intent();
                paramView.setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                paramView.putExtra("app_msg_id", parambu.field_msgId);
                paramView.putExtra("scene", 2);
                parama.JOR.startActivityForResult(paramView, 210);
              }
              if (bt.isNullOrNil(localb.hAo))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_Product_xml", localb.hAo);
              paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
              if (parambu.field_imgPath == null) {
                paramView.putExtra("key_ProductUI_chatting_msgId", parambu.field_msgId);
              }
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "scanner", ".ui.ProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bt.isNullOrNil(localb.hAr))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_TV_xml", localb.hAr);
              paramView.putExtra("key_TV_getProductInfoScene", 1);
              if (parambu.field_imgPath == null) {
                paramView.putExtra("key_TVInfoUI_chatting_msgId", parambu.field_msgId);
              }
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "shake", ".ui.TVInfoUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bt.isNullOrNil(localb.hAu))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_product_info", localb.hAu);
              paramView.putExtra("key_product_scene", 1);
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "product", ".ui.MallProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              localObject = new Intent();
              ((Intent)localObject).putExtra("message_id", parambu.field_msgId);
              ((Intent)localObject).putExtra("record_xml", localb.hAs);
              ((Intent)localObject).putExtra("big_appmsg", paramView);
              i = com.tencent.mm.model.x.aG(b(parama, parambu), parama.getTalkerUserName());
              ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambu.field_msgSvrId));
              ((Intent)localObject).putExtra("preUsername", b(parama, parambu));
              ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
              ((Intent)localObject).putExtra("preChatTYPE", i);
              e.a.a((Intent)localObject, parama, parambu, this);
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
              AppMethodBeat.o(36798);
              return true;
              if (bt.isNullOrNil(localb.dwI))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_card_app_msg", localb.dwI);
              paramView.putExtra("key_from_scene", localb.hBc);
              com.tencent.mm.bs.d.b(parama.JOR.getContext(), "card", ".ui.CardDetailUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (d(localb, parama, this, parambu))
              {
                com.tencent.mm.am.l.b(parambu, localb);
                AppMethodBeat.o(36798);
                return true;
              }
              i = 1;
            }
          } while (c(localb, parama, this, parambu));
        }
      case 36: 
        b(localb, parama, this, parambu);
        com.tencent.mm.am.l.b(parambu, localb);
        AppMethodBeat.o(36798);
        return true;
      case 24: 
        e.a(localb, parama, parambu);
        AppMethodBeat.o(36798);
        return true;
      }
      paramView = new Intent();
      paramView.putExtra("key_from_user_name", b(parama, parambu));
      paramView.putExtra("key_biz_uin", localb.hBe);
      paramView.putExtra("key_order_id", localb.hBf);
      if ((parambu.field_talker != null) && (!parambu.field_talker.equals("")) && (w.vF(parambu.field_talker))) {
        paramView.putExtra("key_chatroom_name", parambu.field_talker);
      }
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
      AppMethodBeat.o(36798);
      return true;
      AppMethodBeat.o(36798);
      return false;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class e
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    protected s.i Kaw;
    protected s.l Kax;
    protected s.j Kay;
    
    private static void a(e.c paramc, com.tencent.mm.ui.chatting.d.b.k paramk, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36827);
      if ((parambu.field_status == 2) && (b(paramk, parambu.field_msgId)))
      {
        if (paramc.JZD != null)
        {
          paramc.JZD.setVisibility(0);
          AppMethodBeat.o(36827);
        }
      }
      else if (paramc.JZD != null) {
        paramc.JZD.setVisibility(8);
      }
      AppMethodBeat.o(36827);
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(161906);
      if ((bt.isNullOrNil(paramb.hCo)) && (bt.isNullOrNil(paramb.hCn)))
      {
        parambu = paramb.url;
        if (parama.fFv()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.Q(parambu, paramc);
          parambu = new Intent();
          parambu.putExtra("rawUrl", paramc);
          parambu.putExtra("webpageTitle", paramb.title);
          parambu.putExtra("shortUrl", paramb.url);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
          AppMethodBeat.o(161906);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.b(parama, parambu);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.fFv()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.am.h.H(parambu));
        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(parama.JOR.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambu), parama.fFv(), paramb, localBundle);
        AppMethodBeat.o(161906);
        return true;
        if (w.zE(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean f(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36831);
      if (paramc.a(parama, paramb, parambu))
      {
        AppMethodBeat.o(36831);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.hzN, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.JOR.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambu.field_msgId, parambu.field_msgSvrId, parambu);
        AppMethodBeat.o(36831);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean g(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36832);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.hCn, paramb.hCm, paramb.hCo, paramb.url, Integer.valueOf(paramb.hCz), paramb.hCq });
      if ((44 == paramb.type) && ((!paramb.ev(false)) || (bt.isNullOrNil(paramb.t(parama.JOR.getContext(), false)))))
      {
        AppMethodBeat.o(36832);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambu);
      Bundle localBundle = new Bundle();
      int i;
      if ((parama.JOR instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.am.h.H(parambu));
        switch (paramb.hCp)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cw(parambu);
        if (i != 0) {
          break label577;
        }
        AppMethodBeat.o(36832);
        return true;
        if (parama.fFv())
        {
          i = 2;
          break;
        }
        if (w.zE((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramc = new Intent();
        paramc.putExtra("key_username", paramb.hCn);
        if (parama.fFv())
        {
          paramc.putExtra("key_from_scene", 1);
          paramc.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + str);
        }
        for (;;)
        {
          paramc.putExtra("_stat_obj", localBundle);
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.hCo;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).jIU = paramb.hCz;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.hCr;
          paramc.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bet());
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramc);
          i = 0;
          break;
          paramc.putExtra("key_from_scene", 2);
          paramc.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.JOR instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, localBundle);
          i = 0;
        }
        else if (w.zE((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, localBundle);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.fFv(), paramb, localBundle);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.fFv(), paramb, localBundle);
          i = 0;
        }
      }
      label577:
      AppMethodBeat.o(36832);
      return false;
    }
    
    public static boolean h(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36833);
      Object localObject2 = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
      if ((localObject2 != null) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject2).hys)) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject2).hyu)))
      {
        String str2 = ((com.tencent.mm.ai.a)localObject2).hys;
        String str3 = ((com.tencent.mm.ai.a)localObject2).hyr;
        Object localObject1 = ((com.tencent.mm.ai.a)localObject2).dIs;
        String str1;
        int i;
        if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject2).hyv))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ai.a)localObject2).hyt;
          String str5 = paramb.hCo;
          localObject2 = ((com.tencent.mm.ai.a)localObject2).hyu;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { str2, str3, str1, str4, str5, localObject2 });
          com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
          if (!w.vF(parama.getTalkerUserName())) {
            break label364;
          }
          i = 2;
          label165:
          localg.f(17608, new Object[] { Integer.valueOf(i), str5, Integer.valueOf(1), Integer.valueOf(1) });
          if ((bt.isNullOrNil(str2)) && ((bt.isNullOrNil(str3)) || (!com.tencent.mm.vfs.i.fv(str3)) || (!bt.nullAsNil(com.tencent.mm.vfs.i.aPK(str3)).equals(localObject1)))) {
            break label370;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_chatting_type", paramb.type);
          ((Bundle)localObject1).putString("key_chatting_wording", str1);
          ((Bundle)localObject1).putString("key_chatting_text", str4);
          ((Bundle)localObject1).putString("key_chatting_appid", str5);
          ((Bundle)localObject1).putLong("key_msg_id", parambu.field_msgId);
          ((Bundle)localObject1).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject1).putString("key_sender_username", paramc.b(parama, parambu));
          e.a(parama, str2, str3, (String)localObject2, (Bundle)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(36833);
          return false;
          str1 = ((com.tencent.mm.ai.a)localObject2).hyv;
          break;
          label364:
          i = 1;
          break label165;
          label370:
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
        }
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
      com.tencent.mm.ui.base.t.makeText(parama.JOR.getContext(), parama.JOR.getMMResources().getString(2131755886), 0).show();
      AppMethodBeat.o(36833);
      return true;
    }
    
    public static boolean i(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      int j = 0;
      AppMethodBeat.i(36834);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bt.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambu.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambu.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject1 = (ae)paramb.ao(ae.class);
        if ((localObject1 != null) && (!bt.isNullOrNil(((ae)localObject1).DBG)))
        {
          paramb = new eeq();
          paramb.DBG = ((ae)localObject1).DBG;
          paramb.DBH = ((ae)localObject1).DBH;
          paramb.DBI = ((ae)localObject1).DBI;
          paramb.DBJ = ((ae)localObject1).DBJ;
          paramb.DBK = ((ae)localObject1).DBK;
          paramb.DBO = ((ae)localObject1).DBO;
          paramb.qeQ = ((ae)localObject1).qeQ;
          paramb.qeR = ((ae)localObject1).qeR;
          paramb.uaw = ((ae)localObject1).uaw;
          paramb.DBL = ((ae)localObject1).DBL;
          paramb.DBM = ((ae)localObject1).DBM;
          paramb.DBN = ((ae)localObject1).DBN;
          paramb.source = ((ae)localObject1).source;
          paramb.lox = ((ae)localObject1).lox;
          paramb.DBP = ((ae)localObject1).DBP;
          paramb.DBR = ((ae)localObject1).DBR;
          paramb.DBS = ((ae)localObject1).DBS;
          paramb.DBT = ((ae)localObject1).DBT;
          paramb.DBQ = ((ae)localObject1).DBQ;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.JOR.getContext().getString(2131759717));
          com.tencent.mm.plugin.websearch.api.ad.a(parama.JOR.getContext(), paramc);
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambu);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject2 = paramb.url;
        Intent localIntent;
        label551:
        label559:
        int i;
        if (parama.fFv())
        {
          localObject1 = "groupmessage";
          Object localObject3 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject2, (String)localObject1);
          localObject1 = paramb.url;
          localObject2 = c.getPackageInfo(parama.JOR.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("webpageTitle", paramb.title);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId))))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("jsapi_args_appid", paramb.appId);
            localIntent.putExtra("jsapiargs", (Bundle)localObject3);
          }
          if (bt.isNullOrNil((String)localObject1)) {
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
          if (!bt.isNullOrNil(paramb.dHo))
          {
            localIntent.putExtra("srcUsername", paramb.dHo);
            localIntent.putExtra("srcDisplayname", paramb.dHp);
          }
          localIntent.putExtra("msg_id", parambu.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambu.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambu));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambu.fkz);
          int k = com.tencent.mm.model.x.aG(paramc.b(parama, parambu), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambu.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambu));
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
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
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
    
    private s.i j(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36822);
      if (this.Kaw == null) {
        this.Kaw = new s.i(parama);
      }
      parama = this.Kaw;
      AppMethodBeat.o(36822);
      return parama;
    }
    
    public static boolean j(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(169873);
      if (!bt.isNullOrNil(paramb.canvasPageXml))
      {
        paramc = new Intent();
        paramc.putExtra("sns_landig_pages_from_source", 5);
        paramc.putExtra("msg_id", parambu.field_msgId);
        paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
        paramc.putExtra("sns_landing_pages_share_thumb_url", parambu.field_imgPath);
        paramc.addFlags(268435456);
        com.tencent.mm.bs.d.b(parama.JOR.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
        AppMethodBeat.o(169873);
        return true;
      }
      Object localObject1 = (ae)paramb.ao(ae.class);
      if ((localObject1 != null) && (!bt.isNullOrNil(((ae)localObject1).DBG)))
      {
        paramb = new eeq();
        paramb.DBG = ((ae)localObject1).DBG;
        paramb.DBH = ((ae)localObject1).DBH;
        paramb.DBI = ((ae)localObject1).DBI;
        paramb.DBJ = ((ae)localObject1).DBJ;
        paramb.DBK = ((ae)localObject1).DBK;
        paramb.DBO = ((ae)localObject1).DBO;
        paramb.qeQ = ((ae)localObject1).qeQ;
        paramb.qeR = ((ae)localObject1).qeR;
        paramb.uaw = ((ae)localObject1).uaw;
        paramb.DBL = ((ae)localObject1).DBL;
        paramb.DBM = ((ae)localObject1).DBM;
        paramb.DBN = ((ae)localObject1).DBN;
        paramb.source = ((ae)localObject1).source;
        paramb.lox = ((ae)localObject1).lox;
        paramb.DBP = ((ae)localObject1).DBP;
        paramb.DBR = ((ae)localObject1).DBR;
        paramb.DBS = ((ae)localObject1).DBS;
        paramb.DBT = ((ae)localObject1).DBT;
        paramb.DBQ = ((ae)localObject1).DBQ;
        paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.JOR.getContext().getString(2131759717));
        com.tencent.mm.plugin.websearch.api.ad.a(parama.JOR.getContext(), paramc);
        com.tencent.mm.plugin.topstory.a.i.a(paramb, parambu);
        AppMethodBeat.o(169873);
        return true;
      }
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        Object localObject2 = paramb.url;
        int j;
        PackageInfo localPackageInfo;
        Intent localIntent;
        if (parama.fFv())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject2, (String)localObject1);
          String str = paramb.hzN;
          j = parama.JOR.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).WM((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 1, j, i);
          }
          localPackageInfo = c.getPackageInfo(parama.JOR.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_snsad_statextstr", paramb.dHv);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId)))) {
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
          }
          localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          if (bt.isNullOrNil(str)) {
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
          if (!bt.isNullOrNil(paramb.dHo))
          {
            localIntent.putExtra("srcUsername", paramb.dHo);
            localIntent.putExtra("srcDisplayname", paramb.dHp);
          }
          localIntent.putExtra("msg_id", parambu.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambu.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambu));
          localIntent.putExtra("from_scence", 2);
          i = com.tencent.mm.model.x.aG(paramc.b(parama, parambu), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambu.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambu));
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
            paramb = (com.tencent.mm.ai.e)paramb.ao(com.tencent.mm.ai.e.class);
            if (paramb == null) {
              break;
            }
          }
        }
        for (int i = paramb.hzh;; i = -1)
        {
          localIntent.putExtra(e.m.IUR, i);
          if ((paramb == null) || (i != 5) || (paramb.hzj != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg())) {
            break label1257;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.IUn, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.IUo, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.JOR.getContext(), parambu.field_msgId, parambu.field_msgSvrId, 0, paramb);
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.JOR.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          AppMethodBeat.o(169873);
          return true;
        }
        com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(169873);
      return true;
    }
    
    private s.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36823);
      if (this.Kax == null) {
        this.Kax = new s.l(parama);
      }
      parama = this.Kax;
      AppMethodBeat.o(36823);
      return parama;
    }
    
    private s.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36824);
      if (this.Kay == null) {
        this.Kay = new s.j(parama);
      }
      parama = this.Kay;
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
        localObject = new ah(paramLayoutInflater, 2131493476);
        ((View)localObject).setTag(new e.c().y((View)localObject, false));
      }
      AppMethodBeat.o(36825);
      return localObject;
    }
    
    public final void a(final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36836);
      com.tencent.mm.ui.base.h.e(parama.JOR.getContext(), parama.JOR.getMMResources().getString(2131757285), "", parama.JOR.getMMResources().getString(2131755877), parama.JOR.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(36804);
          if (parambu.cTc())
          {
            com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
            parama.xR(true);
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
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bu parambu, String paramString)
    {
      AppMethodBeat.i(36826);
      final e.c localc = (e.c)parama;
      this.JBI = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bK(parambu);
      localc.reset();
      String str = parambu.getContent();
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bI(parambu);
      k.b localb;
      Object localObject2;
      if (str != null)
      {
        localb = k.b.aA(str, parambu.VU());
        localObject2 = com.tencent.mm.ai.t.yw(str);
      }
      label677:
      label705:
      label1731:
      label7747:
      for (;;)
      {
        Object localObject1 = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
        int j = 0;
        int k = 0;
        localc.Kao.setVisibility(8);
        Object localObject3 = localObject1;
        Object localObject4;
        boolean bool1;
        label602:
        int i;
        if (localb != null)
        {
          localObject4 = com.tencent.mm.pluginsdk.model.app.h.fX(localb.appId, localb.aDD);
          localc.JZd.ar(localb.title);
          localc.iCV.setText(localb.description);
          localc.JZi.setMaxLines(1);
          localc.JZd.setTextColor(parama1.getContext().getResources().getColor(2131099732));
          localc.iCV.setTextColor(parama1.getContext().getResources().getColor(2131100482));
          localc.JZy.setBackgroundResource(2131231727);
          localc.JZy.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
          localc.JZc.setVisibility(0);
          localc.JZw.setVisibility(0);
          localc.iCV.setVisibility(0);
          localc.JZA.setVisibility(8);
          localc.JZB.setVisibility(8);
          localc.JZn.setVisibility(8);
          localc.JZm.setVisibility(8);
          localc.JZj.setVisibility(8);
          localc.JZg.setVisibility(8);
          localc.JZf.setVisibility(8);
          localc.JZK.setVisibility(8);
          localc.JZE.setVisibility(8);
          localc.JZy.setVisibility(0);
          localc.JZR.setVisibility(8);
          localc.JZZ.setVisibility(8);
          localc.Kah.setVisibility(8);
          localc.Kam.setVisibility(8);
          e.c.aI(localc.JZx, localc.Kaq);
          if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName.trim().length() > 0)) {
            break label1469;
          }
          localObject3 = localb.appName;
          bool1 = true;
          com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 12);
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool1 = o.a.eYW().dOM();
          }
          if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!fx((String)localObject3))) {
            break label1509;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject4, (String)localObject3);
          if (localb.type != 19) {
            break label1479;
          }
          localc.rDq.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject3 }));
          localc.JZh.setVisibility(0);
          localc.rDq.setVisibility(0);
          localc.rDq.setCompoundDrawables(null, null, null, null);
          localc.JZe.setVisibility(0);
          if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject4).Eb())) {
            break label1492;
          }
          a(parama1, localc.rDq, parambu, localb, ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_packageName, parambu.VQ());
          localc.JZe.setImageResource(2131231697);
          a(parama1, localc.JZe, localb.appId);
          i = 1;
        }
        label1351:
        label6089:
        label7114:
        for (;;)
        {
          localc.JZh.setBackgroundResource(2131233299);
          bool1 = false;
          localc.JZc.setVisibility(0);
          if (this.oSO)
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
                    if (!e.b.aWA(parambu.VT())) {
                      localObject3 = com.tencent.mm.aw.q.aIF().e(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    }
                  }
                }
              }
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              localObject4 = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject3, false, com.tencent.mm.cc.a.fromDPToPix(parama1.getContext(), 1));
              localc.JZc.setImageBitmap((Bitmap)localObject4);
              label869:
              if (localb.type != 3) {
                break label1704;
              }
              localc.JZy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                private boolean Kaz = false;
                
                public final boolean onPreDraw()
                {
                  AppMethodBeat.i(36803);
                  if (this.Kaz)
                  {
                    localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                  localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                  this.Kaz = true;
                  int i = com.tencent.mm.cc.a.fromDPToPix(parama1.JOR.getContext(), 24);
                  Bitmap localBitmap = this.val$bitmap;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = com.tencent.mm.sdk.platformtools.g.aJ(parama1.JOR.getContext().getResources().getColor(2131100129), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = com.tencent.mm.sdk.platformtools.g.l(com.tencent.mm.sdk.platformtools.g.aD(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                    j = localc.JZy.getHeight();
                    int k = localc.JZy.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166036);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166037);
                    }
                    localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.b((Bitmap)localObject, 2131231589, j, i));
                    localc.JZy.setBackgroundDrawable((Drawable)localObject);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                }
              });
              if (!com.tencent.mm.ui.al.isDarkMode()) {
                break label1693;
              }
              localc.JZh.setBackgroundResource(2131233299);
              localc.JZo.setOnClickListener(null);
              j = localb.type;
              if (localb.type == 66)
              {
                if ((TextUtils.isEmpty(localb.hCn)) && (TextUtils.isEmpty(localb.hCo))) {
                  break label1731;
                }
                j = 33;
              }
            }
          }
          label971:
          label1249:
          label1509:
          label1786:
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
                  break label7573;
                }
                localc.JZi.setVisibility(0);
                localc.JZi.setMaxLines(2);
                localc.JZi.setText(localb.title);
                localc.JZd.setVisibility(8);
                if (bool1)
                {
                  if ((localb.type != 33) && (localb.type != 36)) {
                    break label7586;
                  }
                  paramString = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
                  localc.JZc.setImageResource(2131689584);
                  com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZc, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(52, 52));
                }
                if (localb.type == 44) {
                  e.c.a(parama1, localc, localb);
                }
              }
              localObject3 = parama;
              if (j == 0)
              {
                localc.JZx.setTag(localObject3);
                localc.JZx.setOnClickListener(d(parama1));
              }
              if (this.oSO)
              {
                localc.JZx.setOnLongClickListener(c(parama1));
                localc.JZx.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
              }
              a(paramInt, localc, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
              AppMethodBeat.o(36826);
              return;
              localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              localc.rDq.setText((CharSequence)localObject3);
              break label602;
              a(parama1, localc.rDq, localb.appId);
              break label677;
              if (localb.type == 24)
              {
                localc.rDq.setText(aj.getContext().getString(2131758845));
                localc.JZh.setVisibility(0);
                localc.rDq.setVisibility(0);
                localc.JZe.setVisibility(8);
                i = 1;
                break label705;
              }
              if ((localb.type == 19) || (((com.tencent.mm.ai.t)localObject2).hDj == 19))
              {
                localc.rDq.setText(aj.getContext().getString(2131757208));
                localc.JZh.setVisibility(0);
                localc.rDq.setVisibility(0);
                localc.JZe.setVisibility(8);
                i = 1;
                break label705;
              }
              if (e.a(localb, localc)) {
                break label7773;
              }
              localc.JZh.setVisibility(8);
              localc.rDq.setVisibility(8);
              localc.JZe.setVisibility(8);
              i = 0;
              break label705;
              bool1 = true;
              break label869;
              localc.JZh.setBackgroundResource(2131231682);
              break label919;
              localc.JZc.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
              bool1 = false;
              break label919;
              j = 5;
              break label971;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.JZd.setVisibility(0);
                localc.JZd.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                localc.iCV.setVisibility(0);
                localc.iCV.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                localc.JZi.setVisibility(8);
                localc.JZj.setVisibility(4);
                localc.iCV.setMaxLines(2);
                localc.JZo.setVisibility(0);
                if (!parambu.VP().equals(parama.JYu)) {
                  break label2042;
                }
                localc.JZo.setImageResource(2131233393);
                parama = new e.g();
                parama.msgId = parambu.VP();
                parama.dBS = parambu.getContent();
                parama.dyy = parambu.VT();
                localc.JZo.setTag(parama);
                localc.JZo.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCv());
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label2056;
                  }
                  localc.JZc.setImageResource(2131689564);
                }
              }
              for (;;)
              {
                if (!fHj()) {
                  break label2068;
                }
                b(localc, false);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.JZd.setVisibility(8);
                break label1786;
                localc.JZo.setImageResource(2131233395);
                break label1892;
                localc.JZc.setImageBitmap(parama);
              }
              if (parambu.getStatus() < 2) {}
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
                localc.JZd.setVisibility(0);
                localc.JZd.setMaxLines(2);
              }
              for (;;)
              {
                localc.iCV.setVisibility(0);
                localc.JZi.setVisibility(8);
                localc.JZj.setVisibility(4);
                localc.iCV.setMaxLines(2);
                localc.iCV.setText(bt.sy(localb.hzO));
                localc.JZo.setVisibility(8);
                e.c.a(localc, str, localb.hzO);
                e.c.a(localc, Boolean.FALSE, parambu, localb.dks, localb.title);
                if (!bool1) {
                  break label7747;
                }
                if (!e.b.aWz(localb.hzP)) {
                  break label2293;
                }
                localc.JZc.setImageResource(2131231063);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.JZd.setVisibility(8);
              }
              localc.JZc.setImageResource(com.tencent.mm.pluginsdk.model.q.aLB(localb.hzP));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
            }
          case 4: 
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.JZd.setVisibility(0);
              localc.iCV.setVisibility(0);
              localc.JZi.setVisibility(8);
              localc.iCV.setMaxLines(2);
              localc.JZj.setVisibility(4);
              localc.JZo.setVisibility(0);
              localc.JZo.setImageResource(2131234464);
              if (!bool1) {
                break label7747;
              }
              paramString = new com.tencent.mm.aw.a.a.c.a();
              paramString.pH(2131689584).aIZ().dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50)).aIX().aJa().an(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1));
              localObject2 = com.tencent.mm.aw.q.aIJ();
              if (!bt.isNullOrNil(localb.thumburl)) {
                break label2543;
              }
            }
            for (parama = localb.hzV;; parama = localb.thumburl)
            {
              ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.JZc, paramString.aJc());
              localc.JZo.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.JZd.setVisibility(8);
              break label2350;
            }
          case 36: 
            label1492:
            label1892:
            label2042:
            if (localc.JZx.getLayoutParams() != null)
            {
              localc.JZx.getLayoutParams().width = -2;
              localc.JZx.requestLayout();
            }
            label2293:
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(localb.hCn);
            label2543:
            if (localObject2 != null)
            {
              parama = ((WxaAttributes)localObject2).field_nickname;
              if (localObject2 == null) {
                break label2937;
              }
              paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
              localc.JZy.setVisibility(8);
              localc.JZK.setVisibility(0);
              localc.JZE.setVisibility(8);
              localc.JZR.setVisibility(8);
              localc.JZO.setText(localb.title);
              e.e(localc.JZO, localb.title);
              localc.JZI.setText(parama);
              e.a(localc.JZJ, localb);
              if (!e.a(parambu, localb, parama1)) {
                break label2947;
              }
              localc.Kao.setVisibility(0);
              bool2 = bt.isNullOrNil(parambu.VY());
              localc.Kao.setTag(parambu);
              localc.Kao.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179969);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  e.a((com.tencent.mm.storage.bu)paramAnonymousView.getTag(), localc, parama1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(179969);
                }
              });
              e.a(bool2, localc, parama1);
              com.tencent.mm.aw.q.aIJ().a(paramString, localc.JZH, ac.d.fOJ);
              parama = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
              localc.JZL.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZL, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
              if (!fHj()) {
                break label2960;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu);
            }
            label2779:
            break;
          }
          label3659:
          label5583:
          label7760:
          label7770:
          for (;;)
          {
            bool2 = false;
            for (parama = localc;; parama = localc)
            {
              b(parama, bool2);
              if (!e.a(localb, (WxaAttributes)localObject2)) {
                break label2978;
              }
              localc.kkf.setVisibility(0);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              parama = localb.dHp;
              break label2616;
              label2937:
              paramString = localb.hCB;
              break label2628;
              localc.Kao.setVisibility(8);
              break label2779;
              if (parambu.getStatus() >= 2) {
                break label7770;
              }
              bool2 = true;
            }
            localc.kkf.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            if (localb != null) {
              e.a(paramString, parama1, parambu, localb);
            }
            parama = (com.tencent.mm.ai.e)localb.ao(com.tencent.mm.ai.e.class);
            if ((parama != null) && (parama.hzj == 1) && (parama.hzh == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg()))
            {
              e.c.a(parama1, localc, localb, parambu, bool1);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
            }
            if ((i == 0) && (af.a(localb, parama)))
            {
              localc.Kah.setVisibility(0);
              localc.Kam.setVisibility(0);
              af.a(parama1.getContext(), localb, localc.Kaj, localc.Kak);
              af.b(localc.Kal, localb);
            }
            localc.JZd.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.JZi.setMaxLines(2);
              localc.JZi.setVisibility(0);
              localc.JZi.setText(localb.title);
              localc.iCV.setMaxLines(3);
              localc.JZj.setVisibility(4);
              if (!e.l(localb)) {
                break label3419;
              }
              localc.JZo.setImageResource(2131234464);
              localc.JZo.setVisibility(0);
              if (bool1)
              {
                paramString = new com.tencent.mm.aw.a.a.c.a();
                paramString.pH(2131689584).aIZ().FF(com.tencent.mm.plugin.image.d.dcT()).dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 50)).aIX().aJa().an(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1));
                localObject2 = com.tencent.mm.aw.q.aIJ();
                if (!bt.isNullOrNil(localb.thumburl)) {
                  break label3432;
                }
              }
            }
            label3419:
            label3432:
            for (parama = localb.hzV;; parama = localb.thumburl)
            {
              ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.JZc, paramString.aJc());
              if (!fHj()) {
                break label3441;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.JZi.setVisibility(8);
              break label3211;
              localc.JZo.setVisibility(8);
              break label3257;
            }
            label3441:
            if (parambu.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(localb.hCn);
            ((com.tencent.mm.plugin.appbrand.service.r)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.r.class)).LQ(localb.hCn);
            switch (localb.hCp)
            {
            }
            for (;;)
            {
              i = 1;
              for (;;)
              {
                if (i != 0) {
                  break label7760;
                }
                if (!fHj()) {
                  break label4227;
                }
                a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu);
                b(localc, false);
                parama = (c.a)localObject1;
                j = k;
                break;
                if (localc.JZx.getLayoutParams() != null)
                {
                  localc.JZx.getLayoutParams().width = -2;
                  localc.JZx.requestLayout();
                }
                if (localObject2 != null)
                {
                  parama = ((WxaAttributes)localObject2).field_nickname;
                  if (localObject2 == null) {
                    break label3942;
                  }
                  paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                  localc.JZy.setVisibility(8);
                  localc.JZK.setVisibility(0);
                  localc.JZE.setVisibility(8);
                  localc.JZR.setVisibility(8);
                  localc.JZO.setText(localb.title);
                  e.e(localc.JZO, localb.title);
                  localc.JZI.setText(parama);
                  e.a(localc.JZJ, localb);
                  com.tencent.mm.aw.q.aIJ().a(paramString, localc.JZH, ac.d.fOJ);
                  parama = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
                  localc.JZL.setImageBitmap(null);
                  localc.JZN.setVisibility(0);
                  if (!e.a(localb, (WxaAttributes)localObject2)) {
                    break label3952;
                  }
                  localc.kkf.setVisibility(0);
                  label3808:
                  if (!e.a(parambu, localb, parama1)) {
                    break label3965;
                  }
                  localc.Kao.setVisibility(0);
                  bool2 = bt.isNullOrNil(parambu.VY());
                  localc.Kao.setTag(parambu);
                  localc.Kao.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(185040);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bd(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                      e.a((com.tencent.mm.storage.bu)paramAnonymousView.getTag(), localc, parama1);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(185040);
                    }
                  });
                  e.a(bool2, localc, parama1);
                }
                for (;;)
                {
                  bool2 = e.m(localb);
                  com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
                  {
                    public final String BM()
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
                        localc.JZL.setImageBitmap(paramAnonymousBitmap);
                        localc.JZL.setVisibility(0);
                        localc.JZN.setVisibility(4);
                        if (bool2)
                        {
                          localc.JZM.setImageDrawable(com.tencent.mm.cc.a.l(parama1.JOR.getContext(), 2131691166));
                          localc.JZM.setVisibility(0);
                          AppMethodBeat.o(36810);
                          return;
                        }
                        localc.JZM.setVisibility(8);
                        AppMethodBeat.o(36810);
                        return;
                      }
                      localc.JZL.setVisibility(4);
                      localc.JZN.setVisibility(0);
                      localc.JZM.setVisibility(8);
                      AppMethodBeat.o(36810);
                    }
                    
                    public final void aEd()
                    {
                      AppMethodBeat.i(36809);
                      AppMethodBeat.o(36809);
                    }
                    
                    public final void ox()
                    {
                      AppMethodBeat.i(36811);
                      AppMethodBeat.o(36811);
                    }
                  }, e.access$600(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
                  i = 0;
                  break;
                  parama = localb.dHp;
                  break label3647;
                  label3942:
                  paramString = localb.hCB;
                  break label3659;
                  label3952:
                  localc.kkf.setVisibility(8);
                  break label3808;
                  label3965:
                  localc.Kao.setVisibility(8);
                }
                if (localObject2 != null)
                {
                  parama = ((WxaAttributes)localObject2).field_nickname;
                  if (localObject2 == null) {
                    break label4131;
                  }
                  paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                  localc.JZy.setVisibility(8);
                  localc.JZK.setVisibility(8);
                  localc.JZE.setVisibility(0);
                  localc.JZG.setText(parama);
                  localc.JZR.setVisibility(8);
                  if (!bt.isNullOrNil(paramString)) {
                    break label4137;
                  }
                  parama = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
                  com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZF, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
                }
                for (;;)
                {
                  if (!e.a(localb, (WxaAttributes)localObject2)) {
                    break label4160;
                  }
                  localc.JZQ.setVisibility(0);
                  i = 0;
                  break;
                  parama = localb.title;
                  break label3989;
                  paramString = null;
                  break label4001;
                  com.tencent.mm.modelappbrand.a.b.aDV().a(localc.JZF, paramString, com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
                }
                localc.JZQ.setVisibility(8);
                i = 0;
              }
              localc.JZh.setVisibility(0);
              localc.JZe.setVisibility(0);
              localc.JZe.setBackground(null);
              localc.JZe.setImageResource(2131689681);
              e.a(localc.rDq, localb);
            }
            if (parambu.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            parama = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
            paramString = localb.hCB;
            localObject2 = localb.dHp;
            localObject3 = localb.title;
            localObject4 = localb.description;
            if (parama == null)
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
              break;
            }
            if (((bt.isNullOrNil(parama.hys)) || (bt.isNullOrNil(parama.hyu))) && (bt.isNullOrNil(parama.hyr)))
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
              break;
            }
            localc.JZX.setText((CharSequence)localObject2);
            localc.JZy.setVisibility(8);
            localc.JZK.setVisibility(8);
            localc.JZE.setVisibility(8);
            localc.JZY.setVisibility(0);
            localc.JZU.setVisibility(8);
            localc.JZY.setImageDrawable(com.tencent.mm.cc.a.l(parama1.getContext(), 2131691166));
            localc.JZR.setVisibility(0);
            localc.JZS.setText((CharSequence)localObject3);
            localc.JZT.setText((CharSequence)localObject4);
            com.tencent.mm.aw.q.aII().a(paramString, new r.a()
            {
              public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
              {
                AppMethodBeat.i(36814);
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36813);
                    if (!paramAnonymousBitmap.isRecycled()) {
                      e.e.7.this.Kau.JZW.setImageBitmap(paramAnonymousBitmap);
                    }
                    AppMethodBeat.o(36813);
                  }
                });
                AppMethodBeat.o(36814);
              }
            });
            parama = com.tencent.mm.aw.q.aIF().Fs(parambu.VT());
            localc.JZV.setImageBitmap(null);
            com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
            {
              public final String BM()
              {
                AppMethodBeat.i(36817);
                String str = "CHAT#" + com.tencent.mm.plugin.appbrand.z.n.cG(this);
                AppMethodBeat.o(36817);
                return str;
              }
              
              public final void E(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(36816);
                if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                {
                  localc.JZV.setImageBitmap(paramAnonymousBitmap);
                  localc.JZV.setVisibility(0);
                }
                AppMethodBeat.o(36816);
              }
              
              public final void aEd()
              {
                AppMethodBeat.i(36815);
                localc.JZV.setVisibility(4);
                AppMethodBeat.o(36815);
              }
              
              public final void ox()
              {
                AppMethodBeat.i(185041);
                com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
                com.tencent.mm.plugin.report.service.g.yhR.dD(808, 3);
                AppMethodBeat.o(185041);
              }
            }, e.access$600(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hKs));
            if (fHj())
            {
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
            }
            if (parambu.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            i = 1;
            localc.iCV.setMaxLines(3);
            localc.JZi.setMaxLines(2);
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            localc.JZd.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.JZi.setMaxLines(2);
              localc.JZi.setVisibility(0);
              localc.JZi.setText(localb.title);
              label4723:
              localc.iCV.setMaxLines(3);
              localc.JZj.setVisibility(4);
              localc.JZo.setVisibility(8);
              if (bool1)
              {
                parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label4834;
                }
                localc.JZc.setImageResource(2131689584);
              }
            }
            for (;;)
            {
              if (!fHj()) {
                break label4846;
              }
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.JZi.setVisibility(8);
              break label4723;
              label4834:
              localc.JZc.setImageBitmap(parama);
            }
            label4846:
            if (parambu.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            localc.JZi.setVisibility(0);
            if (localb.hAn == 1) {
              localc.JZi.setText(2131762858);
            }
            for (;;)
            {
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.JZd.setVisibility(0);
                localc.JZd.ar(localb.title);
              }
              localc.iCV.setMaxLines(4);
              localc.JZj.setVisibility(4);
              localc.JZo.setVisibility(8);
              if (!bool1) {
                break label7747;
              }
              parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
              if ((parama == null) || (parama.isRecycled())) {
                break label5101;
              }
              localc.JZc.setImageBitmap(parama);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              if (localb.hAn == 2) {
                localc.JZi.setText(2131762860);
              } else if (localb.hAn == 3) {
                localc.JZi.setText(2131762859);
              } else {
                localc.JZi.setText(2131762861);
              }
            }
            label5101:
            localc.JZc.setImageResource(2131689584);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            localc.JZd.setVisibility(0);
            localc.JZd.ar(localb.title);
            localc.JZi.setVisibility(0);
            localc.JZi.setText(2131757247);
            localc.iCV.setMaxLines(4);
            localc.JZj.setVisibility(4);
            localc.JZo.setVisibility(8);
            if (bool1)
            {
              parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localc.JZc.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
              }
              localc.JZc.setImageResource(2131689584);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.JZd.setVisibility(0);
                localc.JZd.ar(localb.title);
                localc.JZi.setVisibility(8);
              }
              localc.iCV.setMaxLines(4);
              localc.JZj.setVisibility(4);
              localc.JZo.setVisibility(8);
              if (bool1)
              {
                parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                if ((parama != null) && (!parama.isRecycled()))
                {
                  localc.JZc.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                }
                localc.JZc.setImageResource(2131689584);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                if ((localb.title != null) && (localb.title.length() > 0)) {
                  localc.JZd.setVisibility(0);
                }
                for (;;)
                {
                  localc.iCV.setVisibility(0);
                  localc.JZi.setVisibility(8);
                  localc.JZj.setVisibility(8);
                  localc.JZo.setVisibility(4);
                  localc.iCV.setMaxLines(2);
                  if (!bool1) {
                    break label7747;
                  }
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5583;
                  }
                  localc.JZc.setImageResource(2131689584);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.JZd.setVisibility(8);
                }
                localc.JZc.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZd.setVisibility(0);
                  localc.iCV.setVisibility(0);
                  localc.JZi.setVisibility(8);
                  localc.JZo.setVisibility(8);
                  localc.JZj.setVisibility(4);
                  localc.iCV.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label5818;
                    }
                    localc.JZc.setImageResource(2131689584);
                  }
                }
                for (;;)
                {
                  parama = new bk(parambu, false, paramInt, "", false, parama1.fCR(), localb.dHo, localb.dHp, localb.title, localb.hAv, localb.url, false, false);
                  localc.JZx.setTag(parama);
                  localc.JZx.setOnClickListener(i(parama1));
                  j = 1;
                  i = 0;
                  break;
                  localc.JZd.setVisibility(8);
                  break label5633;
                  localc.JZc.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZd.setVisibility(0);
                  label5858:
                  localc.iCV.setVisibility(0);
                  localc.JZi.setVisibility(8);
                  localc.JZo.setVisibility(8);
                  localc.JZj.setVisibility(4);
                  localc.iCV.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label6049;
                    }
                    localc.JZc.setImageResource(2131689584);
                  }
                }
                for (;;)
                {
                  parama = new bk(parambu, paramInt, "", parama1.fCR(), localb.dHo, localb.dHp, localb.title, localb.hCb, localb.designerName, localb.designerRediretctUrl, localb.url);
                  localc.JZx.setTag(parama);
                  localc.JZx.setOnClickListener(j(parama1));
                  j = 1;
                  i = 0;
                  break;
                  localc.JZd.setVisibility(8);
                  break label5858;
                  localc.JZc.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZd.setVisibility(0);
                  localc.iCV.setVisibility(0);
                  localc.JZi.setVisibility(8);
                  localc.JZo.setVisibility(8);
                  localc.JZj.setVisibility(4);
                  localc.iCV.setMaxLines(2);
                  if (bool1)
                  {
                    if (!bt.isNullOrNil(parambu.VT())) {
                      break label6348;
                    }
                    com.tencent.mm.aw.q.aIJ().loadImage(localb.thumburl, localc.JZc);
                  }
                  parama = new bk();
                  parama.dBd = parambu;
                  parama.Jxs = false;
                  parama.position = paramInt;
                  parama.Kht = false;
                  parama.title = parama1.fCR();
                  parama.dHo = localb.dHo;
                  parama.dHp = localb.dHp;
                  parama.Khu = localb.title;
                  if (localb.type != 26) {
                    break label6405;
                  }
                  parama.tid = localb.tid;
                  parama.hCc = localb.hCc;
                  parama.desc = localb.desc;
                  parama.iconUrl = localb.iconUrl;
                  parama.secondUrl = localb.secondUrl;
                  parama.pageType = localb.pageType;
                  localc.JZx.setOnClickListener(k(parama1));
                  i = 1;
                }
                for (;;)
                {
                  localc.JZx.setTag(parama);
                  k = 0;
                  j = i;
                  i = k;
                  break;
                  localc.JZd.setVisibility(8);
                  break label6089;
                  parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if ((parama == null) || (parama.isRecycled()))
                  {
                    localc.JZc.setImageResource(2131689584);
                    break label6168;
                  }
                  localc.JZc.setImageBitmap(parama);
                  break label6168;
                  if (localb.type == 27)
                  {
                    parama.tid = localb.tid;
                    parama.hCc = localb.hCc;
                    parama.desc = localb.desc;
                    parama.iconUrl = localb.iconUrl;
                    parama.secondUrl = localb.secondUrl;
                    parama.pageType = localb.pageType;
                    localc.JZx.setOnClickListener(l(parama1));
                    i = 1;
                  }
                  else
                  {
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                    i = 0;
                  }
                }
                localc.JZd.setVisibility(0);
                localc.JZd.ar(localb.description);
                localc.iCV.setText(localb.hBb);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.JZi.setVisibility(0);
                  localc.JZi.setText(localb.title);
                }
                for (;;)
                {
                  localc.iCV.setMaxLines(4);
                  localc.JZj.setVisibility(4);
                  localc.JZo.setVisibility(8);
                  if (!bool1) {
                    break label7747;
                  }
                  parama = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6671;
                  }
                  localc.JZc.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.JZi.setVisibility(8);
                }
                localc.JZc.setImageResource(2131689584);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                localc.JZd.setVisibility(8);
                localc.JZi.setVisibility(0);
                if ((localb.title != null) && (localb.title.length() > 0)) {
                  localc.JZi.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.JZi.getContext(), localb.title, (int)localc.JZi.getTextSize()));
                }
                for (;;)
                {
                  localc.iCV.setMaxLines(3);
                  localc.JZj.setVisibility(4);
                  localc.JZo.setVisibility(8);
                  if (bool1) {
                    localc.JZc.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, parambu, bool1);
                  if (!fHj()) {
                    break label6904;
                  }
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.JZi.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.JZi.getContext(), aj.getContext().getString(2131759034), (int)localc.JZi.getTextSize()));
                }
                label6904:
                if (parambu.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                e.c.a(parama1, localc, localb, bool1);
                if (fHj())
                {
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                }
                if (parambu.getStatus() < 2) {}
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
                  localc.JZd.setVisibility(0);
                  if (!bt.isNullOrNil(localb.titleColor)) {
                    if (!bt.isNullOrNil(localb.titleColor))
                    {
                      localc.JZd.setTextColor(bt.cJ(localb.titleColor, parama1.getContext().getResources().getColor(2131100711)));
                      localc.iCV.setMaxLines(2);
                      localc.iCV.setVisibility(0);
                      if (bt.isNullOrNil(localb.hBk)) {
                        break label7435;
                      }
                      localc.iCV.setTextColor(bt.cJ(localb.hBk, parama1.getContext().getResources().getColor(2131100469)));
                      localc.JZi.setVisibility(8);
                      localc.JZj.setVisibility(4);
                      localc.JZo.setVisibility(8);
                      localc.JZh.setVisibility(0);
                      localc.rDq.setVisibility(0);
                      if (bt.isNullOrNil(localb.hBg)) {
                        break label7459;
                      }
                      localc.rDq.setText(localb.hBg);
                    }
                  }
                }
                for (;;)
                {
                  if (this.oSO)
                  {
                    parama = com.tencent.mm.aw.q.aIF().e(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = com.tencent.mm.sdk.platformtools.g.a(parama, false, parama.getWidth() / 2);
                      localc.JZc.setImageBitmap(paramString);
                    }
                    if (!bt.isNullOrNil(localb.hBj))
                    {
                      com.tencent.mm.aw.q.aIJ().a(localb.hBj, new ImageView(parama1.getContext()), new com.tencent.mm.aw.a.a.c.a().aIY().aJc(), new com.tencent.mm.aw.a.c.h()
                      {
                        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
                        {
                          return null;
                        }
                        
                        public final void b(String paramAnonymousString, View paramAnonymousView) {}
                        
                        public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.aw.a.d.b paramAnonymousb)
                        {
                          AppMethodBeat.i(36819);
                          if (paramAnonymousb.bitmap != null)
                          {
                            paramAnonymousString = paramAnonymousb.bitmap;
                            localc.JZy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36818);
                                e.e.9.this.Kau.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.e.9.this.Kau.JZy.getHeight();
                                int k = e.e.9.this.Kau.JZy.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cc.a.ax(e.e.9.this.JYk.JOR.getContext(), 2131166036);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cc.a.ax(e.e.9.this.JYk.JOR.getContext(), 2131166037);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.b(paramAnonymousString, 2131231589, j, i));
                                e.e.9.this.Kau.JZy.setBackgroundDrawable(localBitmapDrawable);
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
                      localc.JZd.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label7114;
                      localc.JZd.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label7114;
                      localc.JZd.setVisibility(8);
                      break label7114;
                      localc.iCV.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                      break label7172;
                      localc.rDq.setText(2131757206);
                      continue;
                    }
                    localc.JZy.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean Kaz = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36820);
                        if (this.Kaz)
                        {
                          localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36820);
                          return true;
                        }
                        localc.JZy.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.Kaz = true;
                        int i = com.tencent.mm.cc.a.fromDPToPix(parama1.JOR.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = com.tencent.mm.sdk.platformtools.g.aJ(parama1.JOR.getContext().getResources().getColor(2131100129), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = com.tencent.mm.sdk.platformtools.g.l(com.tencent.mm.sdk.platformtools.g.aD(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                          j = localc.JZy.getHeight();
                          int k = localc.JZy.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166036);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cc.a.ax(parama1.JOR.getContext(), 2131166037);
                          }
                          localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.b((Bitmap)localObject, 2131231589, j, i));
                          localc.JZy.setBackgroundDrawable((Drawable)localObject);
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
                localc.JZc.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                if (((com.tencent.mm.ai.t)localObject2).hDj == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                  localc.JZi.setVisibility(8);
                  break label1249;
                  localObject1 = com.tencent.mm.aw.q.aIF().b(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = com.tencent.mm.aw.q.aIF().e(parambu.VT(), com.tencent.mm.cc.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.JZc.setImageBitmap(paramString);
                    break label1351;
                  }
                  if (!bt.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.aw.a.a.c.a();
                    ((com.tencent.mm.aw.a.a.c.a)localObject1).pH(2131100141).aIZ().aIX();
                    com.tencent.mm.aw.q.aIJ().a(paramString, localc.Kab, ((com.tencent.mm.aw.a.a.c.a)localObject1).aJc());
                    break label1351;
                  }
                  localc.JZc.setImageResource(2131231063);
                  break label1351;
                }
              }
            }
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
          }
          label6348:
          label7773:
          i = 1;
        }
        label1479:
        localObject2 = null;
        label2628:
        localb = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bu parambu)
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
        if (!ab.bn(parambu))
        {
          com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), parama.JOR.getContext().getString(2131766957), "", parama.JOR.getContext().getString(2131766205), null);
          AppMethodBeat.o(36829);
          return false;
        }
        e.b.a(parama, parambu, b(parama, parambu));
        AppMethodBeat.o(36829);
        return false;
      case 114: 
        paramMenuItem = parambu.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.yr(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          com.tencent.mm.ui.chatting.al.a(parambu, bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.d(parambu, parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.b(parambu, bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.a(parambu, parama.JOR.getContext(), b(parama, parambu), parama.fFv());
          continue;
          com.tencent.mm.ui.chatting.al.p(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.c(parambu, bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend), parama.JOR.getContext());
          continue;
          com.tencent.mm.ui.chatting.al.c(parambu, parama.JOR.getContext());
        }
      case 103: 
        paramMenuItem = parambu.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.yr(paramMenuItem);
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
        paramMenuItem.putExtra("Chat_Msg_Id", parambu.field_msgId);
        com.tencent.mm.bs.d.b(parama.JOR.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        AppMethodBeat.o(36829);
        return false;
        jt localjt = new jt();
        localjt.dwH.dwI = paramMenuItem.dwI;
        localjt.dwH.dmV = parambu.field_msgId;
        localjt.dwH.dwJ = parambu.field_talker;
        com.tencent.mm.sdk.b.a.IbL.l(localjt);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(194324);
      int i = ((bk)paramView.getTag()).position;
      if (parambu.field_content == null)
      {
        AppMethodBeat.o(194324);
        return true;
      }
      k.b localb = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(194324);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.j.aX(parambu)) && ((localb.type != 19) || (parambu.field_status != 1))) {
        paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
      }
      if (((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker)) && (!am.yt(this.JBI.getTalkerUserName()))) {
        paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
      }
      boolean bool1;
      switch (localb.type)
      {
      default: 
        bool1 = false;
      }
      for (;;)
      {
        if ((bool1) && (!this.JBI.fFw())) {
          paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.bs.d.aIu("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Eb()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new eb();
          ((eb)localObject).dpg.msgId = parambu.field_msgId;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((eb)localObject).dph.doF) || (e.b.a(this.JBI.JOR.getContext(), localb))) {
            paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
          }
          if (!this.JBI.fFw()) {
            paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
          }
          if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bu.flY())) {
            paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
          }
          AppMethodBeat.o(194324);
          return true;
          bool1 = com.tencent.mm.am.g.aFJ();
          break;
          bool1 = com.tencent.mm.am.g.aFD();
          break;
          boolean bool2 = com.tencent.mm.am.g.aFH();
          bool1 = bool2;
          if (bt.aRt(localb.hzP)) {
            break;
          }
          paraml.a(i, 150, this.JBI.JOR.getMMResources().getString(2131757229), 2131691578);
          bool1 = bool2;
          break;
          bool1 = com.tencent.mm.am.g.aFA();
          break;
          bool1 = com.tencent.mm.am.g.aFz();
          break;
          bool1 = com.tencent.mm.am.g.aFF();
          break;
          bool1 = com.tencent.mm.am.g.aFB();
          break;
          if ((localb.hBc != 5) && (localb.hBc != 6) && (localb.hBc != 2)) {
            break label889;
          }
          if (localb.hBc != 2) {
            paraml.clear();
          }
          paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(194324);
          return false;
          paraml.clear();
          paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(194324);
          return false;
          paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        label889:
        bool1 = false;
      }
    }
    
    public final boolean b(final View paramView, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bu parambu)
    {
      AppMethodBeat.i(36830);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      paramView.getTag();
      paramView = parambu.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      paramView = k.b.yr(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, true, false);
      if ((localObject != null) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId))) {
        a(parama, paramView, u.aAm(), (com.tencent.mm.pluginsdk.model.app.g)localObject, parambu.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (paramView.type)
      {
      default: 
        i = 1;
      }
      while ((i != 0) && (i(paramView, parama, this, parambu)))
      {
        AppMethodBeat.o(36830);
        return true;
        ba.aBQ();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.g(parama.JOR.getContext(), parama.JOR.getContentView());
          AppMethodBeat.o(36830);
          return true;
        }
        if (bt.aRt(paramView.hzP))
        {
          long l = parambu.field_msgId;
          localObject = paramView.dks;
          paramView = ao.bIX().aLD((String)localObject);
          if ((paramView == null) || (!paramView.cWz())) {
            i = 0;
          }
          while (i != 0)
          {
            AppMethodBeat.o(36830);
            return true;
            ba.aBQ();
            com.tencent.mm.storage.bu localbu = com.tencent.mm.model.c.azs().xY(l);
            if (localbu.frT())
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject, Long.valueOf(l), Long.valueOf(localbu.field_msgSvrId), localbu.field_imgPath });
              localObject = new Intent();
              ((Intent)localObject).setClassName(this.JBI.JOR.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              ((Intent)localObject).putExtra("clean_view_type", 1);
              paramView = this.JBI;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              i = 1;
            }
            else
            {
              localObject = new Intent(this.JBI.JOR.getContext(), ShowImageUI.class);
              ((Intent)localObject).putExtra("key_image_path", paramView.field_fileFullPath);
              ((Intent)localObject).putExtra("key_message_id", l);
              ((Intent)localObject).putExtra("key_favorite", true);
              paramView = this.JBI;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              i = 1;
            }
          }
        }
        paramView = new Intent();
        paramView.setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramView.putExtra("scene", 2);
        paramView.putExtra("app_msg_id", parambu.field_msgId);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36830);
        return true;
        com.tencent.mm.plugin.report.service.g.yhR.f(13043, new Object[] { Integer.valueOf(2), paramView.description, paramView.appId });
        boolean bool = f(paramView, parama, this, parambu);
        AppMethodBeat.o(36830);
        return bool;
        bool = j(paramView, parama, this, parambu);
        AppMethodBeat.o(36830);
        return bool;
        if (h(paramView, parama, this, parambu))
        {
          AppMethodBeat.o(36830);
          return true;
          if (g(paramView, parama, this, parambu))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          i = 1;
          continue;
          b(paramView, parama, this, parambu);
          AppMethodBeat.o(36830);
          return true;
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).Eb()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          ((com.tencent.mm.ui.chatting.d.b.b)parama.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a(parambu, new com.tencent.mm.pluginsdk.model.app.al()
          {
            public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
            {
              AppMethodBeat.i(194323);
              if (this.pnK != null)
              {
                if (paramAnonymousBoolean1)
                {
                  e.e.a(parama, paramView, u.aAm(), this.pnK, parambu.field_msgSvrId, 3, parama.getTalkerUserName());
                  AppMethodBeat.o(194323);
                  return;
                }
                e.e.a(parama, paramView, u.aAm(), this.pnK, parambu.field_msgSvrId, 7, parama.getTalkerUserName());
              }
              AppMethodBeat.o(194323);
            }
          });
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.hAo))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_Product_xml", paramView.hAo);
          ((Intent)localObject).putExtra("key_ProductUI_getProductInfoScene", 1);
          if (parambu.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_ProductUI_chatting_msgId", parambu.field_msgId);
          }
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.hAr))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_TV_xml", paramView.hAr);
          ((Intent)localObject).putExtra("key_TV_getProductInfoScene", 1);
          if (parambu.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_TVInfoUI_chatting_msgId", parambu.field_msgId);
          }
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.hAu))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          parambu = new Intent();
          parambu.setFlags(65536);
          parambu.putExtra("key_product_info", paramView.hAu);
          parambu.putExtra("key_product_scene", 1);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "product", ".ui.MallProductUI", parambu);
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.dwI))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          parambu = new Intent();
          parambu.setFlags(65536);
          parambu.putExtra("key_card_app_msg", paramView.dwI);
          parambu.putExtra("key_from_scene", paramView.hBc);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "card", ".ui.CardDetailUI", parambu);
          AppMethodBeat.o(36830);
          return true;
          localObject = new Intent();
          ((Intent)localObject).putExtra("message_id", parambu.field_msgId);
          ((Intent)localObject).putExtra("record_xml", paramView.hAs);
          i = com.tencent.mm.model.x.aG(b(parama, parambu), parama.getTalkerUserName());
          ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambu.field_msgSvrId));
          ((Intent)localObject).putExtra("preUsername", b(parama, parambu));
          ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
          ((Intent)localObject).putExtra("preChatTYPE", i);
          e.a.a((Intent)localObject, parama, parambu, this);
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          e.a(paramView, parama, parambu);
          AppMethodBeat.o(36830);
          return true;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_biz_uin", paramView.hBe);
          ((Intent)localObject).putExtra("key_order_id", paramView.hBf);
          if ((parambu.field_talker != null) && (!parambu.field_talker.equals("")) && (w.vF(parambu.field_talker))) {
            ((Intent)localObject).putExtra("key_chatroom_name", parambu.field_talker);
          }
          com.tencent.mm.bs.d.b(parama.JOR.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
        }
      }
      AppMethodBeat.o(36830);
      return false;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
  
  static final class f
  {
    public boolean KaH = false;
  }
  
  public static final class g
  {
    public e.h KaI;
    public int KaJ = -1;
    public String dBS;
    public String dyy;
    public long msgId;
  }
  
  public static final class h
  {
    public String Epf;
    public String coverUrl;
    public String hDA;
    public String playUrl;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e
 * JD-Core Version:    0.7.0.1
 */