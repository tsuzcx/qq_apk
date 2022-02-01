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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
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
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.n.a;
import com.tencent.mm.pluginsdk.n.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ai;
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
  private static boolean xMB = false;
  
  private static void a(final Context paramContext, final boolean paramBoolean, final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.ui.transmit.e.a parama)
  {
    AppMethodBeat.i(191629);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext = View.inflate(paramContext, 2131495768, null);
    Object localObject = (ImageView)paramContext.findViewById(2131305961);
    if (ac.eFq()) {
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
          this.GIA.GKm = true;
          locale.bfo();
          if (parama != null) {
            parama.faL();
          }
          AppMethodBeat.o(185018);
        }
      });
      locale.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(185019);
          paramAnonymousl.clear();
          this.idS.setFooterView(null);
          this.idS.setFooterView(paramContext);
          AppMethodBeat.o(185019);
        }
      };
      locale.GHn = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(185020);
          String str;
          int j;
          if (!this.GIA.GKm)
          {
            str = paramString1;
            j = this.fpn;
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
      locale.ffu();
      locale.csG();
      AppMethodBeat.o(191629);
      return;
      ((ImageView)localObject).setImageResource(2131234396);
    }
  }
  
  protected static void a(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(36837);
    switch (paramb.gJQ)
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
  
  public static void a(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(36838);
    nq localnq = new nq();
    localnq.dsK.context = parama.GzJ.getContext();
    localnq.dsK.msgId = parambl.field_msgId;
    localnq.dsK.drV = parama.eZb();
    localnq.dsK.dsL = paramb.gHI;
    localnq.dsK.scene = 6;
    com.tencent.mm.sdk.b.a.ESL.l(localnq);
    AppMethodBeat.o(36838);
  }
  
  public static void a(bl parambl, c.a parama, com.tencent.mm.ui.chatting.d.a parama1)
  {
    AppMethodBeat.i(179989);
    a(parambl, parama, parama1, 0);
    AppMethodBeat.o(179989);
  }
  
  public static void a(bl parambl, final c.a parama, final com.tencent.mm.ui.chatting.d.a parama1, final int paramInt)
  {
    AppMethodBeat.i(185048);
    if (parambl == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185048);
      return;
    }
    if (ax.aFC("group_to_do").getBoolean("introduce_dialog_first", true))
    {
      ax.aFC("group_to_do").edit().putBoolean("introduce_dialog_first", false);
      a(parama1.GzJ.getContext(), bt.isNullOrNil(parambl.ePg), parama1.getTalkerUserName(), parambl.ePg, com.tencent.mm.chatroom.d.y.f(parambl), new com.tencent.mm.ui.transmit.e.a()
      {
        public final void faL()
        {
          AppMethodBeat.i(179943);
          e.b(this.gMa, parama, parama1, paramInt);
          AppMethodBeat.o(179943);
        }
      });
      AppMethodBeat.o(185048);
      return;
    }
    a(parambl, parama, parama1, paramInt, 0);
    AppMethodBeat.o(185048);
  }
  
  private static void a(final bl parambl, final c.a parama, final com.tencent.mm.ui.chatting.d.a parama1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185049);
    if (parambl == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185049);
      return;
    }
    boolean bool = bt.isNullOrNil(parambl.ePg);
    Activity localActivity = parama1.GzJ.getContext();
    String str2 = parambl.field_talker;
    if (bt.isNullOrNil(parambl.ePg)) {}
    for (String str1 = com.tencent.mm.chatroom.d.y.d(parambl);; str1 = parambl.ePg)
    {
      com.tencent.mm.chatroom.d.y.a(localActivity, str2, str1, com.tencent.mm.chatroom.d.y.f(parambl), bool, 2, paramInt1, paramInt2, new y.a()
      {
        public final void US()
        {
          AppMethodBeat.i(179944);
          if (!this.GIz) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.c(parambl);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", new Object[] { Long.valueOf(parambl.field_msgSvrId), localPair });
            AppMethodBeat.o(179944);
            return;
          }
        }
        
        public final void UT()
        {
          AppMethodBeat.i(179945);
          if (!this.GIz) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.e(parambl);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", new Object[] { Long.valueOf(parambl.field_msgSvrId), localPair });
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
    if ((parama instanceof av.f)) {
      av.a(paramBoolean, (av.f)parama, parama1);
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
      paramc.GJT.setBackgroundResource(2131231647);
      paramc.GJU.setTextColor(parama.GzJ.getContext().getResources().getColor(2131099673));
      paramc.GJU.setText(2131760124);
      AppMethodBeat.o(179988);
      return;
    }
    paramc.GJT.setBackgroundResource(2131231648);
    paramc.GJU.setTextColor(parama.GzJ.getContext().getResources().getColor(2131099699));
    paramc.GJU.setText(2131760126);
    AppMethodBeat.o(179988);
  }
  
  public static boolean a(bl parambl, k.b paramb, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(179986);
    if (!com.tencent.mm.chatroom.d.y.UQ())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (parambl == null)
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
    if (ce.asR() - parambl.field_createTime >= com.tencent.mm.chatroom.storage.b.fpK.longValue())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (w.sr(parama.getTalkerUserName()))
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
    paramb = (ab)paramb.ao(ab.class);
    if ((paramb != null) && (!bt.isNullOrNil(paramb.AGs)))
    {
      AppMethodBeat.o(36839);
      return true;
    }
    AppMethodBeat.o(36839);
    return false;
  }
  
  static final class a
  {
    static void a(Intent paramIntent, com.tencent.mm.ui.chatting.d.a parama, bl parambl, c paramc)
    {
      AppMethodBeat.i(36752);
      String str = parama.getTalkerUserName();
      paramc = paramc.b(parama, parambl);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.eZb()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str);
        localBundle.putString("stat_send_msg_user", paramc);
        paramIntent.putExtra("_stat_obj", localBundle);
        AppMethodBeat.o(36752);
        return;
        if (w.sE(str)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
  }
  
  static final class b
  {
    static void a(com.tencent.mm.ui.chatting.d.a parama, final bl parambl, String paramString)
    {
      AppMethodBeat.i(36756);
      Object localObject1 = com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend);
      final Intent localIntent = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      localIntent.putExtra("Retr_Msg_content", (String)localObject1);
      localIntent.putExtra("Retr_MsgFromScene", 2);
      localObject1 = k.b.rx((String)localObject1);
      if ((localObject1 != null) && (19 == ((k.b)localObject1).type)) {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_Msg_Id", parambl.field_msgId);
        if ((localObject1 != null) && (((k.b)localObject1).type == 6)) {
          break label526;
        }
        parambl = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambl.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambl.lS(0));
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
      Object localObject2 = parambl.field_talker;
      Object localObject3 = com.tencent.mm.model.y.tD(parambl.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = com.tencent.mm.model.y.arz().E((String)localObject3, true);
      ((y.b)localObject3).m("prePublishId", "msg_" + parambl.field_msgSvrId);
      ((y.b)localObject3).m("preUsername", paramString);
      ((y.b)localObject3).m("preChatName", localObject2);
      if ((localObject1 != null) && (((k.b)localObject1).ao(com.tencent.mm.ai.a.class) != null))
      {
        ((y.b)localObject3).m("appservicetype", Integer.valueOf(((com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class)).gFo));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.ai.a)((k.b)localObject1).ao(com.tencent.mm.ai.a.class)).gFo);
      }
      if ((localObject1 != null) && (33 == ((k.b)localObject1).type))
      {
        if (!parama.eZb()) {
          break label502;
        }
        ((y.b)localObject3).m("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", parambl.field_talker);
        ((y.b)localObject3).m("sendAppMsgScene", Integer.valueOf(1));
        ((com.tencent.mm.plugin.sns.c.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.j.class)).a("adExtStr", (y.b)localObject3, parambl);
        break;
        label502:
        ((y.b)localObject3).m("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      label526:
      int i;
      if (((k.b)localObject1).type == 6)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(1203L, 7L, 1L, false);
        localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
        localObject3 = ((k.b)localObject1).gHt;
        if (((k.b)localObject1).gHi == 1)
        {
          i = 7;
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((k.b)localObject1).gHe), Integer.valueOf(2), Long.valueOf((ce.asR() - parambl.field_createTime) / 1000L), ((k.b)localObject1).gHf, parambl.field_talker, Integer.valueOf(1), "", Long.valueOf(parambl.field_msgSvrId), Long.valueOf(parambl.field_createTime) });
        }
      }
      else
      {
        if ((((k.b)localObject1).gHi == 0) && (((k.b)localObject1).gHe <= 26214400)) {
          break label844;
        }
      }
      label844:
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("Retr_Big_File", bool);
        localObject2 = com.tencent.mm.pluginsdk.model.app.m.aAV(((k.b)localObject1).dbA);
        if (localObject2 == null) {
          break label993;
        }
        localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
        if ((!((com.tencent.mm.vfs.e)localObject3).exists()) || (((com.tencent.mm.vfs.e)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen)) {
          break label850;
        }
        parambl = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambl.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambl.lS(0));
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
        if ((parambl.eMl()) || (e(parambl, paramString)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131759063), parama.GzJ.getContext().getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            com.tencent.mm.ui.base.h.c(parama.GzJ.getContext(), parama.GzJ.getMMResources().getString(2131757939), "", true);
          }
          AppMethodBeat.o(36756);
          return;
        }
      }
      label993:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((k.b)localObject1).gHe), ((k.b)localObject1).gHt, bt.aGs(((k.b)localObject1).fMw) });
      if (!bool)
      {
        a(parama, localIntent, parambl);
        AppMethodBeat.o(36756);
        return;
      }
      localIntent.putExtra("Retr_Big_File", bool);
      localObject3 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject3).fnH = new g.a()
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
              paramAnonymousString = this.GIy;
              paramAnonymousc = localIntent;
              paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousc);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousc.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousc.lS(0));
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
            if ((parambl.eMl()) || ((this.GmS != null) && (e.b.e(parambl, this.GmS.field_fileFullPath)))) {
              com.tencent.e.h.Iye.aN(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179946);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                  com.tencent.mm.ui.base.h.d(e.b.1.this.GIy.GzJ.getContext(), e.b.1.this.GIy.GzJ.getContext().getString(2131759063), e.b.1.this.GIy.GzJ.getContext().getString(2131755906), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                  });
                  AppMethodBeat.o(179946);
                }
              });
            } else {
              com.tencent.e.h.Iye.aN(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179947);
                  com.tencent.mm.ui.base.h.c(e.b.1.this.GIy.GzJ.getContext(), e.b.1.this.GIy.GzJ.getMMResources().getString(2131757939), "", true);
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
      ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.ao.c.a("checkExist", bt.eGO(), paramString, parambl.field_msgId);
      ((com.tencent.mm.i.g)localObject3).field_fileId = ((k.b)localObject1).gHt;
      ((com.tencent.mm.i.g)localObject3).field_aesKey = ((k.b)localObject1).fMw;
      ((com.tencent.mm.i.g)localObject3).field_filemd5 = ((k.b)localObject1).filemd5;
      ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.fmX;
      ((com.tencent.mm.i.g)localObject3).field_talker = paramString;
      ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fmV;
      ((com.tencent.mm.i.g)localObject3).field_svr_signature = "";
      ((com.tencent.mm.i.g)localObject3).field_onlycheckexist = true;
      bool = com.tencent.mm.ao.f.awL().e((com.tencent.mm.i.g)localObject3);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.i.g)localObject3).field_fileId, ((com.tencent.mm.i.g)localObject3).field_mediaId, bt.aGs(((com.tencent.mm.i.g)localObject3).field_aesKey) });
      if (!bool) {
        a(parama, localIntent, parambl);
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
        bool = com.tencent.mm.pluginsdk.model.app.h.q(paramContext, 16L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 4)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.q(paramContext, 8L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 5)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.q(paramContext, 32L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 6)
      {
        paramb = d.a.aAn(paramb.gHf);
        if (paramb == null)
        {
          AppMethodBeat.o(36754);
          return false;
        }
        bool = com.tencent.mm.pluginsdk.model.app.h.q(paramContext, paramb.longValue());
        AppMethodBeat.o(36754);
        return bool;
      }
      AppMethodBeat.o(36754);
      return false;
    }
    
    private static boolean a(com.tencent.mm.ui.chatting.d.a parama, Intent paramIntent, bl parambl)
    {
      AppMethodBeat.i(36757);
      if ((parambl.eMl()) || (e(parambl, null)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.h.d(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131759063), parama.GzJ.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(36757);
        return true;
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramIntent.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramIntent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36757);
      return false;
    }
    
    static boolean aLb(String paramString)
    {
      AppMethodBeat.i(36755);
      boolean bool = bt.aGv(paramString);
      AppMethodBeat.o(36755);
      return bool;
    }
    
    public static boolean aLc(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(36759);
      Object localObject = o.ayF().b(paramString, false, true);
      if (!com.tencent.mm.vfs.i.eK((String)localObject))
      {
        AppMethodBeat.o(36759);
        return false;
      }
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      localObject = com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, paramString);
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
    
    public static boolean e(bl parambl, String paramString)
    {
      AppMethodBeat.i(36758);
      if ((System.currentTimeMillis() - parambl.field_createTime > 259200000L) && ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.i.eK(paramString))))
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
    public static int[] qmB = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    protected MMImageView GIH;
    protected MMNeat7extView GII;
    protected ImageView GIJ;
    protected ImageView GIK;
    protected TextView GIL;
    protected LinearLayout GIM;
    protected TextView GIN;
    protected ImageView GIO;
    protected MMPinProgressBtn GIP;
    protected ImageView GIQ;
    protected ImageView GIR;
    protected ImageView GIS;
    protected ImageView GIT;
    protected TextView GIU;
    protected ChattingItemFooter GIV;
    protected ImageView GIW;
    protected LinearLayout GIX;
    protected ViewGroup GIY;
    protected TextView GIZ;
    ImageView GJA;
    ImageView GJB;
    TextView GJC;
    ImageView GJD;
    LinearLayout GJE;
    MMNeat7extView GJF;
    ImageView GJG;
    ImageView GJH;
    ImageView GJI;
    TextView GJJ;
    TextView GJK;
    TextView GJL;
    LinearLayout GJM;
    LinearLayout GJN;
    ImageView GJO;
    TextView GJP;
    TextView GJQ;
    ImageView GJR;
    RelativeLayout GJS;
    LinearLayout GJT;
    TextView GJU;
    public int GJV;
    private int GJW;
    protected LinearLayout GJa;
    protected RelativeLayout GJb;
    protected FrameLayout GJc;
    protected LinearLayout GJd;
    protected LinearLayout GJe;
    protected ViewStub GJf;
    protected ImageView GJg;
    protected ImageView GJh;
    ImageView GJi;
    protected LinearLayout GJj;
    protected ImageView GJk;
    protected TextView GJl;
    protected ImageView GJm;
    protected TextView GJn;
    protected TextView GJo;
    protected LinearLayout GJp;
    protected ImageView GJq;
    protected ImageView GJr;
    protected ImageView GJs;
    protected TextView GJt;
    protected LinearLayout GJu;
    protected ImageView GJv;
    LinearLayout GJw;
    TextView GJx;
    TextView GJy;
    ImageView GJz;
    protected TextView hJe;
    protected ImageView jpF;
    protected TextView qkL;
    private ArrayList<MMImageView> xqy;
    
    c()
    {
      AppMethodBeat.i(36762);
      this.GJV = 0;
      this.GJW = 2147483647;
      this.xqy = new ArrayList();
      AppMethodBeat.o(36762);
    }
    
    private static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt1, String[] paramArrayOfString4, String[] paramArrayOfString5, int[] paramArrayOfInt2, String paramString)
    {
      AppMethodBeat.i(36770);
      int i = 0;
      while (i <= 4)
      {
        localObject1 = (MMImageView)paramc.GJe.findViewById(qmB[i]);
        if (localObject1 != null)
        {
          ((MMImageView)localObject1).setImageDrawable(null);
          ((MMImageView)localObject1).setVisibility(8);
        }
        i += 1;
      }
      Object localObject1 = (ImageView)paramc.GJe.findViewById(2131298159);
      Object localObject2 = (TextView)paramc.GJe.findViewById(2131298153);
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
          localObject1 = (MMImageView)paramc.GJe.findViewById(qmB[i]);
          ((MMImageView)localObject1).setImageResource(2131689921);
          ((MMImageView)localObject1).setVisibility(0);
          ap.evQ().a((com.tencent.mm.pluginsdk.model.app.k.a)parama.be(com.tencent.mm.ui.chatting.c.b.i.class), paramArrayOfString1[i], bt.eGO(), paramArrayOfString2[i], paramArrayOfString3[i], paramArrayOfInt1[i], paramString);
          localObject2 = o.ayF().p("Note_" + paramArrayOfString1[i], "", "");
          localObject3 = new com.tencent.mm.aw.a.a.c.a();
          ((com.tencent.mm.aw.a.a.c.a)localObject3).hjX = 1;
          ((com.tencent.mm.aw.a.a.c.a)localObject3).hkn = true;
          ((com.tencent.mm.aw.a.a.c.a)localObject3).hki = 2131689920;
          ((com.tencent.mm.aw.a.a.c.a)localObject3).gjv = ((int)parama.GzJ.getMMResources().getDimension(2131165216));
          ((com.tencent.mm.aw.a.a.c.a)localObject3).gjw = ((int)parama.GzJ.getMMResources().getDimension(2131165216));
          localObject3 = ((com.tencent.mm.aw.a.a.c.a)localObject3).azc();
          if (!com.tencent.mm.vfs.i.eK((String)localObject2)) {
            break label357;
          }
          o.ayJ().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.aw.a.a.c)localObject3);
        }
        for (;;)
        {
          i += 1;
          break;
          localObject1 = (MMImageView)paramc.GJe.findViewById(qmB[(i + 1)]);
          ((MMImageView)localObject1).setImageResource(2131689920);
          break label150;
          label357:
          ap.evQ().a((com.tencent.mm.pluginsdk.model.app.k.a)parama.be(com.tencent.mm.ui.chatting.c.b.i.class), paramArrayOfString1[i], bt.eGO(), paramArrayOfString4[i], paramArrayOfString5[i], paramArrayOfInt2[i], paramString);
          o.ayF().p("Note_" + paramArrayOfString1[i], "", "");
          com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), 45);
          if (com.tencent.mm.vfs.i.eK((String)localObject2)) {
            o.ayJ().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.aw.a.a.c)localObject3);
          } else {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
          }
        }
      }
      AppMethodBeat.o(36770);
    }
    
    @SuppressLint({"ResourceType"})
    public static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb)
    {
      AppMethodBeat.i(191626);
      parama = paramb.r(parama.GzJ.getContext(), false);
      if (!bt.isNullOrNil(parama))
      {
        paramc.GIM.setVisibility(0);
        paramc.qkL.setVisibility(0);
        paramc.GIJ.setVisibility(0);
        paramc.qkL.setText(parama);
        if (com.tencent.mm.ai.k.a.gGX.ordinal() == paramb.gJL)
        {
          paramc.GIJ.setImageResource(2131690913);
          AppMethodBeat.o(191626);
          return;
        }
        if (com.tencent.mm.ai.k.a.gGY.ordinal() == paramb.gJL) {
          o.ayI().a(paramb.gJS, new p.a()
          {
            public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
            {
              AppMethodBeat.i(191625);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(191624);
                  e.c.3.this.GJZ.GIJ.setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(191624);
                }
              });
              AppMethodBeat.o(191625);
            }
          });
        }
      }
      AppMethodBeat.o(191626);
    }
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, bl parambl, boolean paramBoolean)
    {
      AppMethodBeat.i(36768);
      paramc.GJd.setVisibility(8);
      paramc.GJE.setVisibility(0);
      paramc.GJN.setVisibility(0);
      com.tencent.mm.ai.e locale;
      int i;
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        paramc.GJF.setMaxLines(2);
        paramc.GJF.setVisibility(0);
        paramc.GJF.aq(paramb.getTitle());
        locale = (com.tencent.mm.ai.e)paramb.ao(com.tencent.mm.ai.e.class);
        if (locale == null) {
          break label464;
        }
        i = locale.duration;
        label99:
        String str = com.tencent.mm.ai.m.mV(i);
        if (bt.isNullOrNil(str)) {
          break label470;
        }
        paramc.GJK.setVisibility(0);
        paramc.GJK.setText(str);
      }
      for (;;)
      {
        paramc.GJI.setVisibility(0);
        if ((locale != null) && (com.tencent.mm.ai.x.mW(locale.gGB)))
        {
          paramc.GJK.setVisibility(8);
          paramc.GJI.setVisibility(8);
        }
        ad.a(parama.GzJ.getContext(), paramb, paramc.GJH, paramc.GJJ);
        ad.b(paramc.GJL, paramb);
        paramc.GIO.setVisibility(4);
        i = com.tencent.mm.cd.a.ao(parama.GzJ.getContext(), 2131166038) - com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), 24);
        int j = i * 9 / 16;
        if (com.tencent.mm.cd.a.dT(parama.GzJ.getContext()) > 1.0F)
        {
          int k = (int)((paramc.GJV / com.tencent.mm.ce.a.eCR() - com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), 29) * com.tencent.mm.cd.a.dT(parama.GzJ.getContext())) * 9.0F / 16.0F);
          if (paramc.GJS.getLayoutParams().height != k)
          {
            paramc.GJS.getLayoutParams().height = k;
            paramc.GJS.requestLayout();
          }
        }
        if ((!paramBoolean) && (bt.isNullOrNil(paramb.thumburl))) {
          break label482;
        }
        parama = com.tencent.mm.api.b.q(paramb.thumburl, 4);
        paramb = new com.tencent.mm.aw.a.a.c.a();
        paramb.hkf = 2131100141;
        paramb.hjT = true;
        paramb.gjt = r.aAK(parama);
        parambl = paramb.de(i, j);
        parambl.hjJ = new com.tencent.mm.pluginsdk.ui.applet.n(4);
        parambl.hkr = new com.tencent.mm.pluginsdk.ui.applet.e(4);
        parambl.hjS = true;
        o.ayJ().a(parama, paramc.GJG, paramb.azc());
        AppMethodBeat.o(36768);
        return;
        paramc.GJF.setVisibility(8);
        break;
        label464:
        i = 0;
        break label99;
        label470:
        paramc.GJK.setVisibility(8);
      }
      label482:
      paramb = null;
      if (!e.b.aLc(parambl.field_imgPath)) {
        paramb = o.ayF().a(parambl.field_imgPath, com.tencent.mm.cd.a.getDensity(parama.GzJ.getContext()), false);
      }
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        paramc.GJG.setImageBitmap(paramb);
        AppMethodBeat.o(36768);
        return;
      }
      paramc.GJG.setImageResource(2131100141);
      AppMethodBeat.o(36768);
    }
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(36767);
      paramc.GII.setVisibility(8);
      String str;
      Object localObject1;
      Object localObject3;
      label221:
      Object localObject2;
      int i;
      if ((paramb.title != null) && (paramb.title.trim().length() > 0))
      {
        str = paramb.title;
        paramc.GIN.setVisibility(0);
        paramc.GIN.setMaxLines(2);
        paramc.hJe.setMaxLines(4);
        paramc.GIT.setVisibility(8);
        paramc.GIO.setVisibility(4);
        if (paramBoolean) {
          paramc.GIH.setVisibility(8);
        }
        localObject1 = new pn();
        ((pn)localObject1).dvb.type = 0;
        ((pn)localObject1).dvb.dvd = paramb.gHI;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject3 = ((pn)localObject1).dvc.dvl;
        if (localObject3 == null) {
          break label1041;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.GIN.getContext(), bt.by(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.GIN.getTextSize());
        paramc.GIN.setText((CharSequence)localObject1);
        localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
        if (localObject1 != null) {
          break label514;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.gHI });
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 100) {
            localObject2 = ((String)localObject1).substring(0, 100);
          }
        }
        paramc.hJe.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramc.hJe.getContext(), bt.by((String)localObject2, paramb.description), paramc.hJe.getTextSize()));
        paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).gKs.iterator();
        i = 0;
        localObject2 = null;
        localObject1 = null;
        label305:
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject3 = (afy)paramb.next();
        } while ((com.tencent.mm.plugin.fav.ui.l.j((afy)localObject3)) && (!bt.isNullOrNil(((afy)localObject3).Dhb)) && (((afy)localObject3).Dhb.equals("WeNoteHtmlFile")));
        if (((afy)localObject3).DgT.DhA.Did == null) {
          break label539;
        }
        str = parama.GzJ.getContext().getString(2131762236);
        i = 1;
        label390:
        switch (((afy)localObject3).dataType)
        {
        }
      }
      for (;;)
      {
        break label305;
        paramc.GIN.setVisibility(8);
        str = null;
        break;
        label514:
        localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        break label221;
        label539:
        if (((afy)localObject3).DgT.DhA.dpv == null) {
          break label1038;
        }
        if (localObject1 == null)
        {
          localObject1 = ((afy)localObject3).DgV;
          break label390;
        }
        if (localObject1 == ((afy)localObject3).DgV) {
          break label1038;
        }
        localObject2 = ((afy)localObject3).DgV;
        break label390;
        if (paramBoolean)
        {
          paramc.GIH.setVisibility(0);
          paramc.GIH.setImageResource(2131689583);
        }
        break label305;
        break label305;
        if (paramBoolean)
        {
          paramc.GIH.setVisibility(0);
          paramc.GIH.setImageResource(2131230944);
        }
        break label305;
        if (paramBoolean)
        {
          paramc.GIH.setVisibility(0);
          paramc.GIH.setImageResource(2131689584);
        }
        break label305;
        if ((paramBoolean) && (!com.tencent.mm.plugin.fav.a.b.chA()))
        {
          paramc.GIH.setVisibility(0);
          paramc.GIH.setImageResource(2131690572);
          break label305;
          if (paramBoolean)
          {
            paramc.GIH.setVisibility(0);
            paramc.GIH.setImageResource(2131689581);
          }
          paramc.GIT.setVisibility(0);
          paramc.GIT.setImageResource(2131234464);
          break label305;
          paramc.GIH.setVisibility(0);
          paramc.GIH.setImageResource(2131689562);
          break label305;
          if (paramBoolean)
          {
            paramc.GIH.setVisibility(0);
            paramc.GIH.setImageResource(2131689564);
          }
          paramc.GIT.setVisibility(0);
          paramc.GIT.setImageResource(2131233395);
          break label305;
          if (paramBoolean)
          {
            paramc.GIH.setVisibility(0);
            paramc.GIH.setImageResource(com.tencent.mm.pluginsdk.e.aAq(((afy)localObject3).Dgo));
          }
          break label305;
          if (paramBoolean)
          {
            paramc.GIH.setVisibility(0);
            paramc.GIH.setImageResource(2131689577);
          }
          break label305;
          if (paramBoolean)
          {
            paramc.GIH.setVisibility(0);
            paramc.GIH.setImageResource(2131231875);
          }
        }
      }
      if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
        paramb = parama.GzJ.getContext().getString(2131758964, new Object[] { localObject1 });
      }
      for (;;)
      {
        if (!bt.isNullOrNil(paramb))
        {
          paramc.GIN.setText(paramb);
          paramc.GIN.setVisibility(0);
        }
        paramc.GIH.setVisibility(8);
        paramc.GJb.setVisibility(8);
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
                paramb = parama.GzJ.getContext().getString(2131758963, new Object[] { localObject1, localObject2 });
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
    
    public static void a(c paramc, Boolean paramBoolean, final bl parambl, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(36766);
      final long l = parambl.field_msgId;
      com.tencent.mm.pluginsdk.model.app.c localc = ap.bxS().vj(l);
      if (localc == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
        AppMethodBeat.o(36766);
        return;
      }
      if (paramBoolean.booleanValue()) {
        if (localc.field_status == 101L)
        {
          paramc.GIS.setVisibility(0);
          paramc.GIP.setVisibility(0);
          paramc.GIQ.setVisibility(0);
        }
      }
      for (;;)
      {
        if (parambl.field_status == 5)
        {
          paramc.GIS.setVisibility(8);
          paramc.GIR.setVisibility(8);
        }
        paramc.GIS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36760);
            if (this.GJX.booleanValue())
            {
              l = l;
              paramAnonymousView = parambl;
              localc = ap.bxS().vj(l);
              if (localc == null)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.XJ() + " getinfo failed: " + paramAnonymousView);
                AppMethodBeat.o(36760);
                return;
              }
              if (localc.field_status != 101L)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.XJ() + " get status failed: " + paramAnonymousView + " status:" + localc.field_status);
                AppMethodBeat.o(36760);
                return;
              }
              localc.field_status = 102L;
              localc.field_lastModifyTime = bt.aGK();
              ap.bxS().a(localc, new String[0]);
              AppMethodBeat.o(36760);
              return;
            }
            long l = l;
            paramAnonymousView = parambl;
            com.tencent.mm.pluginsdk.model.app.c localc = ap.bxS().vj(l);
            if (localc == null) {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.XJ() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.gLQ.setStatus(5);
              az.arV();
              com.tencent.mm.model.c.apO().rm(l);
              AppMethodBeat.o(36760);
              return;
              if (localc.field_status == 101L) {
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.XJ() + " get status failed: " + paramAnonymousView + " status:" + localc.field_status);
            }
            if ((bt.isNullOrNil(localc.field_clientAppDataId)) && (!bt.isNullOrNil(localc.field_mediaSvrId))) {}
            for (localc.field_status = 102L;; localc.field_status = 105L)
            {
              localc.field_lastModifyTime = bt.aGK();
              ap.bxS().a(localc, new String[0]);
              break;
            }
          }
        });
        paramc.GIR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36761);
            com.tencent.mm.pluginsdk.model.app.c localc;
            if (!this.GJX.booleanValue())
            {
              long l = l;
              paramAnonymousView = parambl;
              localc = ap.bxS().vj(l);
              if (localc != null) {
                break label102;
              }
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.XJ() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.gLQ.setStatus(1);
              az.arV();
              com.tencent.mm.model.c.apO().rm(l);
              AppMethodBeat.o(36761);
              return;
              label102:
              if ((localc.field_status != 105L) && (localc.field_status != 101L))
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.XJ() + " get status failed: " + paramAnonymousView + " status:" + localc.field_status);
              }
              else
              {
                localc.field_status = 101L;
                localc.field_lastModifyTime = bt.aGK();
                ap.bxS().a(localc, new String[0]);
                ap.evT().run();
              }
            }
          }
        });
        AppMethodBeat.o(36766);
        return;
        if (localc.field_status == 102L)
        {
          paramc.GIS.setVisibility(8);
          paramc.GIP.setVisibility(8);
          paramc.GIQ.setVisibility(8);
        }
        else
        {
          paramc.GIS.setVisibility(8);
          paramc.GIP.setVisibility(8);
          paramc.GIQ.setVisibility(8);
          continue;
          if (localc.field_status == 101L)
          {
            paramc.GIS.setVisibility(0);
            paramc.GIR.setVisibility(8);
          }
          else if (localc.field_status == 105L)
          {
            paramc.GIS.setVisibility(8);
            paramc.GIR.setVisibility(0);
          }
          else
          {
            paramc.GIS.setVisibility(8);
            paramc.GIR.setVisibility(8);
          }
        }
      }
    }
    
    public static void a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(36765);
      int i = com.tencent.mm.pluginsdk.model.app.m.aAU(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        paramc.GIP.setVisibility(8);
        paramc.GIQ.setVisibility(8);
        AppMethodBeat.o(36765);
        return;
      }
      paramc.GIP.setVisibility(0);
      paramc.GIQ.setVisibility(0);
      paramc.GIP.setProgress(i);
      AppMethodBeat.o(36765);
    }
    
    static void b(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, bl parambl, boolean paramBoolean)
    {
      AppMethodBeat.i(36769);
      Object localObject1 = new pn();
      ((pn)localObject1).dvb.type = 0;
      ((pn)localObject1).dvb.dvd = paramb.gHI;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      Object localObject2 = ((pn)localObject1).dvc.dvl;
      paramc.GJb.setVisibility(8);
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
        paramb = bt.by(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
        k = 0;
        localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject2).gKs.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (afy)((Iterator)localObject3).next();
          if ((!com.tencent.mm.plugin.fav.ui.l.j((afy)localObject4)) || (bt.isNullOrNil(((afy)localObject4).Dhb)) || (!((afy)localObject4).Dhb.equals("WeNoteHtmlFile"))) {
            switch (((afy)localObject4).dataType)
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
                str = ((afy)localObject4).desc;
              } while (bt.isNullOrNil(str));
              if (bt.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label1211;
              }
              localObject1 = ((afy)localObject4).desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
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
          paramc.GJb.setVisibility(0);
          paramc.GIH.setVisibility(0);
          paramc.GIH.setImageResource(2131230944);
        }
        if (i < 4)
        {
          arrayOfString1[i] = ((afy)localObject4).gHu;
          arrayOfString2[i] = ((afy)localObject4).DfV;
          arrayOfInt1[i] = ((int)((afy)localObject4).DgF);
          arrayOfString3[i] = ((afy)localObject4).DfZ;
          arrayOfString4[i] = ((afy)localObject4).Dgb;
          arrayOfInt2[i] = ((int)((afy)localObject4).Dgu);
          arrayOfString5[i] = ((afy)localObject4).dkb;
        }
        i += 1;
        break;
        if (!bt.isNullOrNil(paramb)) {
          break label248;
        }
        paramb = aj.getContext().getString(2131755773) + ((afy)localObject4).title;
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
          if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).gKs.size() == 2))
          {
            localObject2 = aj.getContext().getString(2131759034);
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
            localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.GIN.getContext(), (CharSequence)localObject1, (int)paramc.GIN.getTextSize());
            paramc.GIN.setText((CharSequence)localObject1);
            if ((paramb != null) && (paramb.length() > 100)) {
              paramb = paramb.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            for (;;)
            {
              for (;;)
              {
                localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.hJe.getContext(), paramb, (int)paramc.hJe.getTextSize());
                paramc.hJe.setText((CharSequence)localObject1);
                if (i > 0)
                {
                  paramc.GJb.setVisibility(8);
                  if ((j != 0) || (k == 0) || (bt.isNullOrNil(paramb)))
                  {
                    paramc.hJe.setVisibility(8);
                    paramc.GIN.setMaxLines(2);
                    paramc.GJg.setVisibility(8);
                    paramc.GJf.setLayoutResource(2131493469);
                  }
                  try
                  {
                    if (paramc.GJe == null) {
                      paramc.GJe = ((LinearLayout)paramc.GJf.inflate());
                    }
                    for (;;)
                    {
                      if (i <= 4) {
                        break label1168;
                      }
                      j = 4;
                      a(parama, paramc, j, arrayOfString5, arrayOfString2, arrayOfString1, arrayOfInt1, arrayOfString4, arrayOfString3, arrayOfInt2, parambl.field_talker);
                      parama = (ImageView)paramc.GJe.findViewById(2131298159);
                      paramc = (TextView)paramc.GJe.findViewById(2131298153);
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
                      paramc.hJe.setMaxLines(1);
                      paramc.hJe.setVisibility(0);
                      paramc.GIN.setMaxLines(1);
                      break label791;
                      paramc.GJe.setVisibility(0);
                    }
                  }
                  catch (Exception paramb)
                  {
                    for (;;)
                    {
                      paramc.GJf.setVisibility(0);
                      continue;
                      j = i;
                    }
                  }
                }
              }
              paramc.GJf.setVisibility(8);
              paramc.GJg.setVisibility(0);
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
      if (this.GIN != null) {
        this.GIN.setMaxLines(this.GJW);
      }
      AppMethodBeat.o(36764);
    }
    
    public final c y(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(36763);
      super.fK(paramView);
      this.GJu = ((LinearLayout)paramView.findViewById(2131298017));
      this.GIH = ((MMImageView)paramView.findViewById(2131298047));
      this.GII = ((MMNeat7extView)paramView.findViewById(2131298049));
      this.GIN = ((TextView)paramView.findViewById(2131298052));
      this.hJe = ((TextView)paramView.findViewById(2131298026));
      this.qkL = ((TextView)paramView.findViewById(2131298044));
      this.GIJ = ((ImageView)paramView.findViewById(2131298041));
      this.GIL = ((TextView)paramView.findViewById(2131298043));
      this.GIK = ((ImageView)paramView.findViewById(2131298042));
      this.GIM = ((LinearLayout)paramView.findViewById(2131298040));
      this.GIO = ((ImageView)paramView.findViewById(2131298045));
      this.GIP = ((MMPinProgressBtn)paramView.findViewById(2131298088));
      this.GIQ = ((ImageView)this.rLd.findViewById(2131298087));
      this.GIR = ((ImageView)this.rLd.findViewById(2131298078));
      this.GIS = ((ImageView)this.rLd.findViewById(2131298177));
      this.GIT = ((ImageView)paramView.findViewById(2131298028));
      this.GIU = ((TextView)paramView.findViewById(2131298023));
      this.GIW = ((ImageView)paramView.findViewById(2131298039));
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.lRB = paramView.findViewById(2131298147);
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.GIV = ((ChattingItemFooter)paramView.findViewById(2131300196));
      this.GIX = ((LinearLayout)paramView.findViewById(2131296863));
      this.GIY = ((ViewGroup)paramView.findViewById(2131301542));
      this.GIZ = ((TextView)paramView.findViewById(2131301539));
      this.GJa = ((LinearLayout)paramView.findViewById(2131298053));
      this.GJc = ((FrameLayout)paramView.findViewById(2131298069));
      this.GJd = ((LinearLayout)paramView.findViewById(2131298024));
      this.GJh = ((ImageView)paramView.findViewById(2131298076));
      this.GJb = ((RelativeLayout)paramView.findViewById(2131298046));
      this.GJf = ((ViewStub)paramView.findViewById(2131302929));
      this.GJg = ((ImageView)paramView.findViewById(2131298081));
      if (!paramBoolean)
      {
        this.GJi = ((ImageView)this.rLd.findViewById(2131298176));
        this.uPp = ((ProgressBar)this.rLd.findViewById(2131306220));
      }
      this.GJp = ((LinearLayout)paramView.findViewById(2131298005));
      this.GJm = ((ImageView)paramView.findViewById(2131298018));
      this.GJn = ((TextView)paramView.findViewById(2131298020));
      this.GJt = ((TextView)paramView.findViewById(2131298016));
      this.GJs = ((ImageView)paramView.findViewById(2131299519));
      this.GJq = ((ImageView)paramView.findViewById(2131298006));
      this.GJr = ((ImageView)paramView.findViewById(2131307172));
      this.GJj = ((LinearLayout)paramView.findViewById(2131298004));
      this.GJk = ((ImageView)paramView.findViewById(2131297979));
      this.GJl = ((TextView)paramView.findViewById(2131297980));
      this.GJo = ((TextView)paramView.findViewById(2131298019));
      this.jpF = ((ImageView)paramView.findViewById(2131297981));
      this.GJv = ((ImageView)paramView.findViewById(2131297984));
      this.GJw = ((LinearLayout)paramView.findViewById(2131298009));
      this.GJx = ((TextView)paramView.findViewById(2131298015));
      this.GJy = ((TextView)paramView.findViewById(2131298011));
      this.GJz = ((ImageView)paramView.findViewById(2131298012));
      this.GJA = ((ImageView)paramView.findViewById(2131298010));
      this.GJB = ((ImageView)paramView.findViewById(2131298013));
      this.GJC = ((TextView)paramView.findViewById(2131298014));
      this.GJD = ((ImageView)paramView.findViewById(2131298008));
      this.GJE = ((LinearLayout)paramView.findViewById(2131298030));
      this.GJI = ((ImageView)paramView.findViewById(2131298034));
      this.GJF = ((MMNeat7extView)paramView.findViewById(2131298035));
      this.GJG = ((ImageView)paramView.findViewById(2131298033));
      this.GJM = ((LinearLayout)paramView.findViewById(2131302491));
      this.GJN = ((LinearLayout)paramView.findViewById(2131302493));
      this.GJR = ((ImageView)paramView.findViewById(2131302492));
      this.GJS = ((RelativeLayout)paramView.findViewById(2131298031));
      this.GJO = ((ImageView)this.GJM.findViewById(2131298027));
      this.GJP = ((TextView)this.GJM.findViewById(2131298029));
      this.GJQ = ((TextView)this.GJM.findViewById(2131298038));
      this.GJH = ((ImageView)this.GJN.findViewById(2131298027));
      this.GJJ = ((TextView)this.GJN.findViewById(2131298029));
      this.GJL = ((TextView)this.GJN.findViewById(2131298038));
      this.GJK = ((TextView)paramView.findViewById(2131298032));
      this.GJT = ((LinearLayout)paramView.findViewById(2131298050));
      this.GJU = ((TextView)paramView.findViewById(2131298051));
      if ((this.GIN != null) && (Build.VERSION.SDK_INT >= 16)) {
        this.GJW = this.GIN.getMaxLines();
      }
      this.GJV = c.jP(aj.getContext());
      AppMethodBeat.o(36763);
      return this;
    }
  }
  
  public static final class d
    extends c
  {
    protected s.i GKb;
    protected s.l GKc;
    protected s.j GKd;
    private com.tencent.mm.ui.chatting.d.a Gob;
    private boolean qbC;
    
    public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(36799);
      if ((com.tencent.mm.r.a.ce(parama.GzJ.getContext())) || (com.tencent.mm.r.a.cc(parama.GzJ.getContext())))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        AppMethodBeat.o(36799);
        return true;
      }
      if (paramc.a(parama, paramb, parambl))
      {
        AppMethodBeat.o(36799);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.O(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.O(paramb.gHd, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.GzJ.getContext(), paramb.appId);
      String str1;
      if (localPackageInfo == null)
      {
        str1 = null;
        if (localPackageInfo != null) {
          break label160;
        }
      }
      label160:
      for (int i = 0;; i = localPackageInfo.versionCode)
      {
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambl.field_msgId, parambl.field_msgSvrId, parambl);
        AppMethodBeat.o(36799);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(161905);
      if ((bt.isNullOrNil(paramb.gJF)) && (bt.isNullOrNil(paramb.gJE)))
      {
        parambl = paramb.url;
        if (parama.eZb()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.O(parambl, paramc);
          parambl = new Intent();
          parambl.putExtra("rawUrl", paramc);
          parambl.putExtra("webpageTitle", paramb.title);
          parambl.putExtra("shortUrl", paramb.url);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", parambl);
          AppMethodBeat.o(161905);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.b(parama, parambl);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.eZb()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.am.g.F(parambl));
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama.GzJ.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambl), parama.eZb(), paramb, localBundle);
        AppMethodBeat.o(161905);
        return true;
        if (w.sE(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean c(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(36800);
      Object localObject1 = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).gFI)) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).gFK)))
      {
        String str2 = ((com.tencent.mm.ai.a)localObject1).gFI;
        String str3 = ((com.tencent.mm.ai.a)localObject1).gFH;
        String str1;
        int i;
        if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject1).gFL))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ai.a)localObject1).gFJ;
          paramb = paramb.gJF;
          localObject1 = ((com.tencent.mm.ai.a)localObject1).gFK;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { str2, str3, str1, str4, paramb, localObject1 });
          Object localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
          if (!w.pF(parama.getTalkerUserName())) {
            break label308;
          }
          i = 2;
          label155:
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(17608, new Object[] { Integer.valueOf(i), paramb, Integer.valueOf(1), Integer.valueOf(1) });
          if (bt.isNullOrNil(str2)) {
            break label314;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_chatting_wording", str1);
          ((Bundle)localObject2).putString("key_chatting_text", str4);
          ((Bundle)localObject2).putString("key_chatting_appid", paramb);
          ((Bundle)localObject2).putLong("key_msg_id", parambl.field_msgId);
          ((Bundle)localObject2).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject2).putString("key_sender_username", paramc.b(parama, parambl));
          e.a(parama, str2, str3, (String)localObject1, (Bundle)localObject2);
        }
        for (;;)
        {
          AppMethodBeat.o(36800);
          return true;
          str1 = ((com.tencent.mm.ai.a)localObject1).gFL;
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
    
    public static boolean d(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(36801);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.gJE, paramb.gJD, paramb.gJF, paramb.url, Integer.valueOf(paramb.gJQ), paramb.gJH });
      if ((44 == paramb.type) && ((!paramb.dY(false)) || (bt.isNullOrNil(paramb.r(parama.GzJ.getContext(), false)))))
      {
        AppMethodBeat.o(36801);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambl);
      paramc = new Bundle();
      int i;
      if ((parama.GzJ instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        paramc.putInt("stat_scene", i);
        paramc.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
        paramc.putString("stat_chat_talker_username", (String)localObject);
        paramc.putString("stat_send_msg_user", str);
        switch (paramb.gJG)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cn(parambl);
        if (i != 0) {
          break label582;
        }
        AppMethodBeat.o(36801);
        return true;
        if (parama.eZb())
        {
          i = 2;
          break;
        }
        if (w.sE((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_username", paramb.gJE);
        if (parama.eZb())
        {
          localIntent.putExtra("key_from_scene", 1);
          localIntent.putExtra("key_scene_note", (String)localObject + ":" + str);
        }
        for (;;)
        {
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.gJF;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).iOQ = paramb.gJQ;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.gJI;
          localIntent.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).aTV());
          localIntent.putExtra("_stat_obj", paramc);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "appbrand", ".ui.AppBrandProfileUI", localIntent);
          i = 0;
          break;
          localIntent.putExtra("key_from_scene", 2);
          localIntent.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.GzJ instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.am.g.F(parambl))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1157, paramb, paramc);
          i = 0;
        }
        else if (w.sE((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, paramc);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.eZb(), paramb, paramc);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.eZb(), paramb, paramc);
          i = 0;
        }
      }
      label582:
      AppMethodBeat.o(36801);
      return false;
    }
    
    public static boolean e(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(169872);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bt.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambl.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambl.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject1 = (ab)paramb.ao(ab.class);
        if ((localObject1 != null) && (!bt.isNullOrNil(((ab)localObject1).AGs)))
        {
          paramb = new dsx();
          paramb.AGs = ((ab)localObject1).AGs;
          paramb.AGt = ((ab)localObject1).AGt;
          paramb.AGu = ((ab)localObject1).AGu;
          paramb.AGv = ((ab)localObject1).AGv;
          paramb.AGw = ((ab)localObject1).AGw;
          paramb.AGA = ((ab)localObject1).AGA;
          paramb.oYa = ((ab)localObject1).oYa;
          paramb.oYb = ((ab)localObject1).oYb;
          paramb.rUO = ((ab)localObject1).rUO;
          paramb.AGx = ((ab)localObject1).AGx;
          paramb.AGy = ((ab)localObject1).AGy;
          paramb.AGz = ((ab)localObject1).AGz;
          paramb.source = ((ab)localObject1).source;
          paramb.kqB = ((ab)localObject1).kqB;
          paramb.AGB = ((ab)localObject1).AGB;
          paramb.AGD = ((ab)localObject1).AGD;
          paramb.AGE = ((ab)localObject1).AGE;
          paramb.AGF = ((ab)localObject1).AGF;
          paramb.AGC = ((ab)localObject1).AGC;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.GzJ.getContext().getString(2131759717));
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambl);
          aa.a(parama.GzJ.getContext(), paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject2 = paramb.url;
        PackageInfo localPackageInfo;
        Intent localIntent;
        int j;
        if (parama.eZb())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.O((String)localObject2, (String)localObject1);
          String str = paramb.url;
          localPackageInfo = c.getPackageInfo(parama.GzJ.getContext(), paramb.appId);
          localIntent = new Intent();
          j = parama.GzJ.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2))
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
          if (!bt.isNullOrNil(paramb.dxz))
          {
            localIntent.putExtra("srcUsername", paramb.dxz);
            localIntent.putExtra("srcDisplayname", paramb.dxA);
          }
          localIntent.putExtra("msg_id", parambl.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambl.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambl));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambl.ePc);
          i = com.tencent.mm.model.x.aw(paramc.b(parama, parambl), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambl.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambl));
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
            paramb = (com.tencent.mm.ai.e)paramb.ao(com.tencent.mm.ai.e.class);
            if (paramb == null) {
              break;
            }
          }
        }
        for (int i = paramb.gGx;; i = -1)
        {
          localIntent.putExtra(e.m.FIt, i);
          localIntent.addFlags(536870912);
          if ((paramb == null) || (i != 5) || (paramb.gGz != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR())) {
            break label1270;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.FHP, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.FHQ, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.GzJ.getContext(), parambl.field_msgId, parambl.field_msgSvrId, 0, paramb);
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.GzJ.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(169872);
        return true;
      }
      AppMethodBeat.o(169872);
      return false;
    }
    
    private s.i j(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36791);
      if (this.GKb == null) {
        this.GKb = new s.i(parama);
      }
      parama = this.GKb;
      AppMethodBeat.o(36791);
      return parama;
    }
    
    private s.l k(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36792);
      if (this.GKc == null) {
        this.GKc = new s.l(parama);
      }
      parama = this.GKc;
      AppMethodBeat.o(36792);
      return parama;
    }
    
    private s.j l(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36793);
      if (this.GKd == null) {
        this.GKd = new s.j(parama);
      }
      parama = this.GKd;
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
        localObject = new af(paramLayoutInflater, 2131493431);
        ((View)localObject).setTag(new e.c().y((View)localObject, true));
      }
      AppMethodBeat.o(36794);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36795);
      final e.c localc = (e.c)parama;
      this.Gob = parama1;
      localc.reset();
      String str = parambl.getContent();
      Object localObject1 = (com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class);
      ((com.tencent.mm.ui.chatting.c.b.k)localObject1).bA(parambl);
      ((com.tencent.mm.ui.chatting.c.b.k)localObject1).bB(parambl);
      ((com.tencent.mm.ui.chatting.c.b.k)localObject1).bC(parambl);
      int i;
      if (this.qbC)
      {
        i = parambl.getContent().indexOf(':');
        if (i != -1) {
          str = parambl.getContent().substring(i + 1);
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
          localb = k.b.ar(str, parambl.SK());
          localObject3 = com.tencent.mm.ai.t.rC(str);
          localObject1 = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
          i = 0;
          j = 0;
          localc.GJT.setVisibility(8);
          localObject2 = localObject1;
          if (localb != null)
          {
            localc.GII.aq(localb.getTitle());
            localc.hJe.setText(localb.getDescription());
            localc.GIN.setMaxLines(1);
            localc.GII.setTextColor(ao.aD(parama1.getContext(), 2130968584));
            localc.hJe.setTextColor(parama1.getContext().getResources().getColor(2131100482));
            localc.GJd.setBackground(ao.aC(parama1.getContext(), 2130968737));
            localc.GJd.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
            localc.GIH.setVisibility(0);
            localc.GJb.setVisibility(0);
            localc.hJe.setVisibility(0);
            localc.GIP.setVisibility(8);
            localc.GIS.setVisibility(8);
            localc.GIR.setVisibility(8);
            localc.GJf.setVisibility(8);
            localc.GJg.setVisibility(8);
            localc.GIK.setVisibility(8);
            localc.GIL.setVisibility(8);
            localc.GJp.setVisibility(8);
            localc.GJj.setVisibility(8);
            localc.GJd.setVisibility(0);
            localc.GJw.setVisibility(8);
            localc.GJE.setVisibility(8);
            localc.GJM.setVisibility(8);
            localc.GJR.setVisibility(8);
            e.c.aE(localc.GJc, localc.GJV);
            localb.ao(com.tencent.mm.ai.h.class);
            localc.GJc.setBackground(ao.aC(parama1.getContext(), 2130968737));
            localg = com.tencent.mm.pluginsdk.model.app.h.fv(localb.appId, localb.aAS);
            if (localg != null) {
              b(parama1, localb, parambl);
            }
            if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
              break label1669;
            }
            localObject2 = localb.appName;
            bool1 = true;
            com.tencent.mm.cd.a.fromDPToPix(parama1.getContext(), 12);
            if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
              bool1 = n.a.euP().doZ();
            }
            if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!eM((String)localObject2))) {
              break label1709;
            }
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), localg, (String)localObject2);
            if (localb.type != 19) {
              break label1679;
            }
            localc.qkL.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject2 }));
            label690:
            localc.qkL.setVisibility(0);
            localc.qkL.setCompoundDrawables(null, null, null, null);
            localc.GIM.setVisibility(0);
            localc.GIJ.setVisibility(0);
            if ((localg == null) || (!localg.CZ())) {
              break label1692;
            }
            a(parama1, localc.qkL, parambl, localb, localg.field_packageName, parambl.SG());
            label765:
            localc.GIJ.setImageResource(2131231697);
            a(parama1, localc.GIJ, localb.appId);
            i = 1;
          }
        }
        for (;;)
        {
          label793:
          if (localb.apy())
          {
            localc.GIM.setVisibility(8);
            i = 0;
          }
          for (;;)
          {
            localc.GIM.setBackgroundResource(2131233299);
            bool1 = false;
            localc.GIH.setVisibility(0);
            if ((!localb.apz()) && (this.nMt))
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
                      if (!e.b.aLc(parambl.SJ())) {
                        localObject2 = o.ayF().e(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                      }
                    }
                  }
                }
              }
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localBitmap = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, false, com.tencent.mm.cd.a.fromDPToPix(parama1.getContext(), 1));
                localc.GIH.setImageBitmap(localBitmap);
                label986:
                if (localb.type != 3) {
                  break label1904;
                }
                localc.GJd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  private boolean GKe = false;
                  
                  public final boolean onPreDraw()
                  {
                    AppMethodBeat.i(36771);
                    if (this.GKe)
                    {
                      localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                    localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.GKe = true;
                    int i = com.tencent.mm.cd.a.fromDPToPix(parama1.GzJ.getContext(), 24);
                    Bitmap localBitmap = this.val$bitmap;
                    Object localObject;
                    if (localBitmap != null)
                    {
                      localObject = localBitmap;
                      if (!localBitmap.isRecycled()) {}
                    }
                    else
                    {
                      localObject = com.tencent.mm.sdk.platformtools.f.aG(parama1.GzJ.getContext().getResources().getColor(2131100129), i, i);
                    }
                    int j = ((Bitmap)localObject).getHeight();
                    if (i > j) {
                      i = j;
                    }
                    for (;;)
                    {
                      localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.az(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                      j = localc.GJd.getHeight();
                      int k = localc.GJd.getWidth();
                      i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166037);
                      }
                      localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231553, j, i));
                      localc.GJd.setBackgroundDrawable((Drawable)localObject);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                  }
                });
                if (!ai.Eq()) {
                  break label1893;
                }
                localc.GIM.setBackgroundResource(2131233299);
                label1036:
                if ((localb.eOT != null) && (localb.eOT.length() != 0)) {
                  break label1931;
                }
                localc.GIU.setVisibility(8);
                label1065:
                localc.GIT.setOnClickListener(null);
                localc.GIX.setVisibility(0);
                localc.GIO.setVisibility(8);
                localc.GJa.setVisibility(0);
                localc.GIY.setVisibility(8);
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
                  localc.GIN.setVisibility(0);
                  localc.GIN.setMaxLines(2);
                  localc.GIN.setText(localb.title);
                  localc.GII.setVisibility(8);
                  if (bool1)
                  {
                    if ((localb.type != 33) && (localb.type != 36)) {
                      break label7269;
                    }
                    paramString = o.ayF().yl(parambl.SJ());
                    localc.GIH.setImageResource(2131689584);
                    com.tencent.mm.modelappbrand.a.b.aub().a(localc.GIH, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(50, 50));
                  }
                  if (localb.type == 44) {
                    e.c.a(parama1, localc, localb);
                  }
                }
                if (parama1.eZb()) {
                  break label7446;
                }
                if (!com.tencent.mm.pluginsdk.model.app.h.k(localg)) {
                  break label7430;
                }
                localc.GIW.setVisibility(0);
                c(parama1, localc.GIW, bi.a(localb, parambl));
                localObject2 = parama;
                if (i == 0)
                {
                  localc.GJc.setTag(localObject2);
                  localc.GJc.setOnClickListener(d(parama1));
                }
                if (this.nMt)
                {
                  localc.GJc.setOnLongClickListener(c(parama1));
                  localc.GJc.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
                }
                AppMethodBeat.o(36795);
                return;
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambl.SF()), paramString });
                localObject3 = null;
                localb = null;
                break;
                localObject2 = localg.field_appName;
                break label558;
                localc.qkL.setText((CharSequence)localObject2);
                break label690;
                a(parama1, localc.qkL, localb.appId);
                break label765;
                if (localb.type == 24)
                {
                  localc.qkL.setText(aj.getContext().getString(2131758845));
                  localc.GIM.setVisibility(0);
                  localc.qkL.setVisibility(0);
                  localc.GIJ.setVisibility(8);
                  i = 1;
                  break label793;
                }
                if ((localb.type == 19) || (((com.tencent.mm.ai.t)localObject3).gKA == 19))
                {
                  localc.qkL.setText(aj.getContext().getString(2131757208));
                  localc.GIM.setVisibility(0);
                  localc.qkL.setVisibility(0);
                  localc.GIJ.setVisibility(8);
                  i = 1;
                  break label793;
                }
                if (e.a(localb, localc)) {
                  break label7482;
                }
                localc.GIM.setVisibility(8);
                localc.qkL.setVisibility(8);
                localc.GIJ.setVisibility(8);
                i = 0;
                break label793;
                bool1 = true;
                break label986;
                localc.GIM.setBackgroundResource(2131231682);
                break label1036;
                localc.GIH.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                bool1 = false;
                break label1036;
                localc.GIU.setVisibility(0);
                b(parama1, localc.GIU, bi.aLk(localb.eOT));
                break label1065;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.GII.setVisibility(0);
                  localc.GII.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.hJe.setVisibility(0);
                  localc.hJe.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.GIN.setVisibility(8);
                  localc.GIO.setVisibility(4);
                  localc.GIT.setVisibility(0);
                  if (!parambl.SF().equals(parama.GIa)) {
                    break label2252;
                  }
                  localc.GIT.setImageResource(2131233393);
                  localc.hJe.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label2266;
                    }
                    localc.GIH.setImageResource(2131689564);
                  }
                }
                for (;;)
                {
                  parama = new e.g();
                  parama.msgId = parambl.SF();
                  parama.dsv = parambl.getContent();
                  parama.dpa = parambl.SJ();
                  localc.GIT.setTag(parama);
                  localc.GIT.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWq());
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.GII.setVisibility(8);
                  break label2010;
                  localc.GIT.setImageResource(2131233395);
                  break label2107;
                  localc.GIH.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.GII.setVisibility(0);
                  localc.GII.setMaxLines(2);
                }
                for (;;)
                {
                  localc.hJe.setVisibility(0);
                  localc.GIN.setVisibility(8);
                  localc.GIT.setVisibility(8);
                  localc.GIO.setVisibility(4);
                  localc.hJe.setMaxLines(2);
                  localc.hJe.setText(bt.mK(localb.gHe));
                  e.c.a(localc, str, localb.gHe);
                  e.c.a(localc, Boolean.TRUE, parambl, localb.dbA, localb.title);
                  if (!bool1) {
                    break label7462;
                  }
                  if (!e.b.aLb(localb.gHf)) {
                    break label2463;
                  }
                  localc.GIH.setImageResource(2131231063);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.GII.setVisibility(8);
                }
                localc.GIH.setImageResource(com.tencent.mm.pluginsdk.model.q.aAJ(localb.gHf));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                continue;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.GII.setVisibility(0);
                  localc.hJe.setVisibility(0);
                  localc.GIN.setVisibility(8);
                  localc.GIT.setVisibility(0);
                  localc.GIT.setImageResource(2131234464);
                  localc.GIO.setVisibility(4);
                  localc.hJe.setMaxLines(2);
                  if (!bool1) {
                    break label7462;
                  }
                  paramString = new com.tencent.mm.aw.a.a.c.a();
                  paramString.oq(2131689584).ayZ().de(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50)).ayX().aza().ag(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1));
                  localObject2 = o.ayJ();
                  if (!bt.isNullOrNil(localb.thumburl)) {
                    break label2711;
                  }
                }
                for (parama = localb.gHl;; parama = localb.thumburl)
                {
                  ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.GIH, paramString.azc());
                  localc.GIT.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.GII.setVisibility(8);
                  break label2519;
                }
                if (localb != null) {
                  e.a(paramString, parama1, parambl, localb);
                }
                parama = (com.tencent.mm.ai.e)localb.ao(com.tencent.mm.ai.e.class);
                if ((parama != null) && (parama.gGz == 1) && (parama.gGx == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR()))
                {
                  e.c.a(parama1, localc, localb, parambl, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                }
                else
                {
                  if ((i == 0) && (ad.a(localb, parama)))
                  {
                    localc.GJM.setVisibility(0);
                    localc.GJR.setVisibility(0);
                    ad.a(parama1.getContext(), localb, localc.GJO, localc.GJP);
                    ad.b(localc.GJQ, localb);
                  }
                  localc.GII.setVisibility(8);
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.GIN.setMaxLines(2);
                    localc.GIN.setVisibility(0);
                    localc.GIN.setText(localb.getTitle());
                    localc.hJe.setMaxLines(3);
                    if (!e.k(localb)) {
                      break label3126;
                    }
                    localc.GIT.setVisibility(0);
                    localc.GIT.setImageResource(2131234464);
                    localc.GIO.setVisibility(4);
                    if (!bool1) {
                      break label7462;
                    }
                    paramString = new com.tencent.mm.aw.a.a.c.a();
                    paramString.oq(2131689584).ayZ().yw(com.tencent.mm.plugin.image.d.cGx()).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).de(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50)).ayX().aza().ag(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1));
                    localObject2 = o.ayJ();
                    if (!bt.isNullOrNil(localb.thumburl)) {
                      break label3139;
                    }
                  }
                  for (parama = localb.gHl;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.GIH, paramString.azc());
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                    localc.GIN.setVisibility(8);
                    break label2929;
                    localc.GIT.setVisibility(8);
                    break label2966;
                  }
                  if (localc.GJc.getLayoutParams() != null)
                  {
                    localc.GJc.getLayoutParams().width = -2;
                    localc.GJc.requestLayout();
                  }
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(localb.gJE);
                  final boolean bool2;
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label3496;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.GJd.setVisibility(8);
                    localc.GJp.setVisibility(0);
                    localc.GJj.setVisibility(8);
                    localc.GJw.setVisibility(8);
                    if (!e.a(parambl, localb, parama1)) {
                      break label3506;
                    }
                    localc.GJT.setVisibility(0);
                    bool2 = bt.isNullOrNil(parambl.SO());
                    localc.GJT.setTag(parambl);
                    localc.GJT.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(179950);
                        e.a((bl)paramAnonymousView.getTag(), localc, parama1);
                        AppMethodBeat.o(179950);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    localc.GJt.setText(localb.title);
                    e.e(localc.GJt, localb.title);
                    localc.GJn.setText(parama);
                    e.a(localc.GJo, localb);
                    o.ayJ().a(paramString, localc.GJm, aa.d.frV);
                    parama = o.ayF().yl(parambl.SJ());
                    localc.GJq.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.aub().a(localc.GJq, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label3519;
                    }
                    localc.jpF.setVisibility(0);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                    parama = localb.dxA;
                    break label3212;
                    paramString = localb.gJS;
                    break label3224;
                    localc.GJT.setVisibility(8);
                  }
                  localc.jpF.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  continue;
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(localb.gJE);
                  ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).Ew(localb.gJE);
                  switch (localb.gJG)
                  {
                  default: 
                    paramInt = 1;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                  case 2: 
                  case 3: 
                    if (localc.GJc.getLayoutParams() != null)
                    {
                      localc.GJc.getLayoutParams().width = -2;
                      localc.GJc.requestLayout();
                    }
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label3972;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.GJd.setVisibility(8);
                      localc.GJp.setVisibility(0);
                      localc.GJj.setVisibility(8);
                      localc.GJw.setVisibility(8);
                      localc.GJt.setText(localb.title);
                      e.e(localc.GJt, localb.title);
                      localc.GJn.setText(parama);
                      e.a(localc.GJo, localb);
                      o.ayJ().a(paramString, localc.GJm, aa.d.frV);
                      parama = o.ayF().yl(parambl.SJ());
                      localc.GJq.setImageBitmap(null);
                      localc.GJq.setVisibility(4);
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label3982;
                      }
                      localc.jpF.setVisibility(0);
                      if (!e.a(parambl, localb, parama1)) {
                        break label3995;
                      }
                      localc.GJT.setVisibility(0);
                      bool2 = bt.isNullOrNil(parambl.SO());
                      localc.GJT.setTag(parambl);
                      localc.GJT.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymousView)
                        {
                          AppMethodBeat.i(185027);
                          e.a((bl)paramAnonymousView.getTag(), localc, parama1);
                          AppMethodBeat.o(185027);
                        }
                      });
                      e.a(bool2, localc, parama1);
                    }
                    for (;;)
                    {
                      bool2 = e.l(localb);
                      com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
                      {
                        public final String AL()
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
                            localc.GJq.setImageBitmap(paramAnonymousBitmap);
                            localc.GJq.setVisibility(0);
                            localc.GJs.setVisibility(4);
                            if (bool2)
                            {
                              localc.GJr.setImageDrawable(com.tencent.mm.cd.a.l(parama1.GzJ.getContext(), 2131691166));
                              localc.GJr.setVisibility(0);
                              AppMethodBeat.o(36779);
                              return;
                            }
                            localc.GJr.setVisibility(8);
                            AppMethodBeat.o(36779);
                            return;
                          }
                          localc.GJq.setVisibility(4);
                          localc.GJs.setVisibility(0);
                          localc.GJr.setVisibility(8);
                          AppMethodBeat.o(36779);
                        }
                        
                        public final void auj()
                        {
                          AppMethodBeat.i(36778);
                          AppMethodBeat.o(36778);
                        }
                        
                        public final void nV()
                        {
                          AppMethodBeat.i(36780);
                          AppMethodBeat.o(36780);
                        }
                      }, e.aLa(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      break;
                      parama = localb.dxA;
                      break label3671;
                      paramString = localb.gJS;
                      break label3683;
                      localc.jpF.setVisibility(8);
                      break label3832;
                      localc.GJT.setVisibility(8);
                    }
                  case 1: 
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4167;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.GJd.setVisibility(8);
                      localc.GJp.setVisibility(8);
                      localc.GJj.setVisibility(0);
                      localc.GJl.setText(parama);
                      localc.GJw.setVisibility(8);
                      if (!bt.isNullOrNil(paramString)) {
                        break label4173;
                      }
                      parama = o.ayF().yl(parambl.SJ());
                      com.tencent.mm.modelappbrand.a.b.aub().a(localc.GJk, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
                    }
                    for (;;)
                    {
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4196;
                      }
                      localc.GJv.setVisibility(0);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      break;
                      parama = localb.title;
                      break label4019;
                      paramString = null;
                      break label4031;
                      com.tencent.mm.modelappbrand.a.b.aub().a(localc.GJk, paramString, com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
                    }
                    localc.GJv.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = j;
                    break;
                  case 0: 
                    localc.GIM.setVisibility(0);
                    localc.GIJ.setVisibility(0);
                    localc.GIJ.setBackground(null);
                    localc.GIJ.setImageResource(2131689681);
                    e.a(localc.qkL, localb);
                    break label1328;
                    parama = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
                    paramString = localb.gJS;
                    localObject2 = localb.dxA;
                    str = localb.title;
                    localObject3 = localb.description;
                    if ((parama == null) || (bt.isNullOrNil(parama.gFI)) || (bt.isNullOrNil(parama.gFK)))
                    {
                      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                      break label1328;
                    }
                    localc.GJC.setText((CharSequence)localObject2);
                    localc.GJd.setVisibility(8);
                    localc.GJp.setVisibility(8);
                    localc.GJj.setVisibility(8);
                    localc.GJD.setVisibility(0);
                    localc.GJz.setVisibility(8);
                    localc.GJD.setImageDrawable(com.tencent.mm.cd.a.l(parama1.getContext(), 2131691166));
                    localc.GJw.setVisibility(0);
                    localc.GJx.setText(str);
                    localc.GJy.setText((CharSequence)localObject3);
                    o.ayI().a(paramString, new p.a()
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
                              e.d.7.this.GJZ.GJB.setImageBitmap(paramAnonymousBitmap);
                            }
                            AppMethodBeat.o(36782);
                          }
                        });
                        AppMethodBeat.o(36783);
                      }
                    });
                    paramString = com.tencent.mm.modelappbrand.a.b.aub().a(parama.gFK, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.gRA));
                    if (paramString != null)
                    {
                      localc.GJA.setImageBitmap(paramString);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                    }
                    else
                    {
                      com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
                      {
                        public final String AL()
                        {
                          AppMethodBeat.i(36786);
                          String str = "CHAT#" + com.tencent.mm.plugin.appbrand.aa.m.cF(this);
                          AppMethodBeat.o(36786);
                          return str;
                        }
                        
                        public final void E(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36785);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.GJA.setImageBitmap(paramAnonymousBitmap);
                            localc.GJA.setVisibility(0);
                          }
                          AppMethodBeat.o(36785);
                        }
                        
                        public final void auj()
                        {
                          AppMethodBeat.i(36784);
                          localc.GJA.setVisibility(4);
                          AppMethodBeat.o(36784);
                        }
                        
                        public final void nV()
                        {
                          AppMethodBeat.i(185028);
                          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                          com.tencent.mm.plugin.report.service.h.vKh.dB(808, 2);
                          AppMethodBeat.o(185028);
                        }
                      }, parama.gFK, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.gRA));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      paramInt = 1;
                      localc.GIN.setMaxLines(2);
                      localc.hJe.setMaxLines(3);
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      localc.GII.setVisibility(8);
                      if ((localb.title != null) && (localb.title.trim().length() > 0))
                      {
                        localc.GIN.setMaxLines(2);
                        localc.GIN.setVisibility(0);
                        localc.GIN.setText(localb.getTitle());
                      }
                      for (;;)
                      {
                        localc.hJe.setMaxLines(3);
                        localc.GIT.setVisibility(8);
                        localc.GIO.setVisibility(4);
                        if (!bool1) {
                          break label7462;
                        }
                        parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label4775;
                        }
                        localc.GIH.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                        break;
                        localc.GIN.setVisibility(8);
                      }
                      localc.GIH.setImageBitmap(parama);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      localc.GIN.setVisibility(0);
                      if (localb.gHD == 1) {
                        localc.GIN.setText(2131762858);
                      }
                      for (;;)
                      {
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.GII.setVisibility(0);
                          localc.GII.aq(localb.getTitle());
                        }
                        localc.hJe.setMaxLines(4);
                        localc.GIO.setVisibility(4);
                        localc.GIT.setVisibility(8);
                        if (!bool1) {
                          break label7462;
                        }
                        parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                        if ((parama == null) || (parama.isRecycled())) {
                          break label5011;
                        }
                        localc.GIH.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                        break;
                        if (localb.gHD == 2) {
                          localc.GIN.setText(2131762860);
                        } else if (localb.gHD == 3) {
                          localc.GIN.setText(2131762859);
                        } else {
                          localc.GIN.setText(2131762861);
                        }
                      }
                      localc.GIH.setImageResource(2131689584);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = j;
                      continue;
                      localc.GII.setVisibility(0);
                      localc.GII.aq(localb.getTitle());
                      localc.GIN.setVisibility(0);
                      localc.GIN.setText(2131757247);
                      localc.hJe.setMaxLines(4);
                      localc.GIO.setVisibility(4);
                      localc.GIT.setVisibility(8);
                      if (!bool1) {
                        break label7462;
                      }
                      parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                      if ((parama != null) && (!parama.isRecycled()))
                      {
                        localc.GIH.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                      }
                      else
                      {
                        localc.GIH.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = j;
                        continue;
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.GII.setVisibility(0);
                          localc.GII.aq(localb.getTitle());
                          localc.GIN.setVisibility(8);
                        }
                        localc.hJe.setMaxLines(4);
                        localc.GIO.setVisibility(4);
                        localc.GIT.setVisibility(8);
                        if (!bool1) {
                          break label7462;
                        }
                        parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          localc.GIH.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = j;
                        }
                        else
                        {
                          localc.GIH.setImageResource(2131689584);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = j;
                          continue;
                          if ((localb.title != null) && (localb.title.length() > 0)) {
                            localc.GII.setVisibility(0);
                          }
                          for (;;)
                          {
                            localc.hJe.setVisibility(0);
                            localc.GIN.setVisibility(8);
                            localc.GIT.setVisibility(8);
                            localc.GIO.setVisibility(4);
                            localc.hJe.setMaxLines(2);
                            if (!bool1) {
                              break label7462;
                            }
                            parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                            if ((parama != null) && (!parama.isRecycled())) {
                              break label5487;
                            }
                            localc.GIH.setImageResource(2131689584);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = j;
                            break;
                            localc.GII.setVisibility(8);
                          }
                          localc.GIH.setImageBitmap(parama);
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
                localc.GII.setVisibility(0);
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIT.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                if (bool1)
                {
                  parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5721;
                  }
                  localc.GIH.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bi(parambl, false, paramInt, "", false, localb.title, localb.dxz, localb.dxA, localb.title, localb.gHL, localb.url, false, false);
                localc.GJc.setTag(parama);
                localc.GJc.setOnClickListener(i(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.GII.setVisibility(8);
                break label5536;
                localc.GIH.setImageBitmap(parama);
              }
            case 25: 
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIT.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                if (bool1)
                {
                  parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5951;
                  }
                  localc.GIH.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bi(parambl, paramInt, "", parama1.eWM(), localb.dxz, localb.dxA, localb.title, localb.gJs, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.GJc.setTag(parama);
                localc.GJc.setOnClickListener(j(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.GII.setVisibility(8);
                break label5761;
                localc.GIH.setImageBitmap(parama);
              }
            case 26: 
            case 27: 
              label1391:
              label1904:
              label2929:
              label3832:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIT.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                if (bool1)
                {
                  parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6262;
                  }
                  localc.GIH.setImageResource(2131689584);
                }
                parama = new bi();
                parama.drF = parambl;
                parama.GjM = false;
                parama.position = paramInt;
                parama.GQP = false;
                parama.title = parama1.eWM();
                parama.dxz = localb.dxz;
                parama.dxA = localb.dxA;
                parama.GQQ = localb.title;
                if (localb.type != 26) {
                  break label6274;
                }
                parama.tid = localb.tid;
                parama.gJt = localb.gJt;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.GJc.setOnClickListener(k(parama1));
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
              localc.GJc.setTag(parama);
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
              localc.GII.setVisibility(8);
              label3972:
              label4775:
              break label5991;
              label5011:
              label5536:
              label6262:
              localc.GIH.setImageBitmap(parama);
              label5761:
              break label6085;
              label6274:
              if (localb.type == 27)
              {
                parama.tid = localb.tid;
                parama.gJt = localb.gJt;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.GJc.setOnClickListener(l(parama1));
                paramInt = 1;
                continue;
                localc.GII.setVisibility(0);
                localc.GII.aq(localb.description);
                localc.hJe.setText(localb.gIr);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.GIN.setVisibility(0);
                  localc.GIN.setText(localb.title);
                }
                for (;;)
                {
                  localc.hJe.setMaxLines(4);
                  localc.GIO.setVisibility(4);
                  localc.GIT.setVisibility(8);
                  if (!bool1) {
                    break label7462;
                  }
                  parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6523;
                  }
                  localc.GIH.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.GIN.setVisibility(8);
                }
                label6523:
                localc.GIH.setImageResource(2131689584);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                localc.GII.setVisibility(8);
                localc.GIN.setVisibility(0);
                if ((localb.title != null) && (localb.title.trim().length() > 0)) {
                  localc.GIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.GIN.getContext(), localb.title, localc.GIN.getTextSize()));
                }
                for (;;)
                {
                  localc.hJe.setMaxLines(3);
                  localc.GIT.setVisibility(8);
                  localc.GIO.setVisibility(4);
                  if (bool1)
                  {
                    localc.GIH.setVisibility(8);
                    localc.GJb.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, parambl, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  localc.GIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.GIN.getContext(), aj.getContext().getString(2131759034), localc.GIN.getTextSize()));
                }
                e.c.a(parama1, localc, localb, bool1);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.GII.setVisibility(0);
                  if (!bt.isNullOrNil(localb.gIA))
                  {
                    localc.GII.setTextColor(bt.cB(localb.gIA, parama1.getContext().getResources().getColor(2131100711)));
                    label6825:
                    localc.hJe.setMaxLines(2);
                    localc.hJe.setVisibility(0);
                    if (bt.isNullOrNil(localb.gIB)) {
                      break label7121;
                    }
                    localc.hJe.setTextColor(bt.cB(localb.gIB, parama1.getContext().getResources().getColor(2131100469)));
                    label6883:
                    localc.GIN.setVisibility(8);
                    localc.GIO.setVisibility(4);
                    localc.GIT.setVisibility(8);
                    localc.GIM.setVisibility(0);
                    localc.qkL.setVisibility(0);
                    if (bt.isNullOrNil(localb.gIw)) {
                      break label7145;
                    }
                    localc.qkL.setText(localb.gIw);
                  }
                }
                for (;;)
                {
                  if (this.nMt)
                  {
                    parama = o.ayF().e(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = com.tencent.mm.sdk.platformtools.f.a(parama, false, parama.getWidth() / 2);
                      localc.GIH.setImageBitmap(paramString);
                    }
                    if (!bt.isNullOrNil(localb.gIz))
                    {
                      o.ayJ().a(localb.gIz, new ImageView(parama1.getContext()), new com.tencent.mm.aw.a.a.c.a().ayY().azc(), new com.tencent.mm.aw.a.c.h()
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
                            localc.GJd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36787);
                                e.d.9.this.GJZ.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.d.9.this.GJZ.GJd.getHeight();
                                int k = e.d.9.this.GJZ.GJd.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cd.a.ao(e.d.9.this.GIy.GzJ.getContext(), 2131166036);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cd.a.ao(e.d.9.this.GIy.GzJ.getContext(), 2131166037);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b(paramAnonymousString, 2131231553, j, i));
                                e.d.9.this.GJZ.GJd.setBackgroundDrawable(localBitmapDrawable);
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
                      localc.GII.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label6825;
                      localc.GII.setVisibility(8);
                      break label6825;
                      label7121:
                      localc.hJe.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                      break label6883;
                      label7145:
                      localc.qkL.setText(2131757206);
                      continue;
                    }
                    localc.GJd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean GKe = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36789);
                        if (this.GKe)
                        {
                          localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                        localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.GKe = true;
                        int i = com.tencent.mm.cd.a.fromDPToPix(parama1.GzJ.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = com.tencent.mm.sdk.platformtools.f.aG(parama1.GzJ.getContext().getResources().getColor(2131100129), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.az(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                          j = localc.GJd.getHeight();
                          int k = localc.GJd.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166036);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166037);
                          }
                          localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231553, j, i));
                          localc.GJd.setBackgroundDrawable((Drawable)localObject);
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
                localc.GIH.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = j;
                break;
                if (((com.tencent.mm.ai.t)localObject3).gKA == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = j;
                  break;
                  label7256:
                  localc.GIN.setVisibility(8);
                  break label1391;
                  label7269:
                  localObject1 = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = o.ayF().e(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.GIH.setImageBitmap(paramString);
                    break label1493;
                  }
                  if (!bt.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.aw.a.a.c.a();
                    ((com.tencent.mm.aw.a.a.c.a)localObject1).oq(2131100141).ayZ().ayX();
                    o.ayJ().a(paramString, localc.GJG, ((com.tencent.mm.aw.a.a.c.a)localObject1).azc());
                    break label1493;
                  }
                  localc.GIH.setImageResource(2131231063);
                  break label1493;
                  label7430:
                  localc.GIW.setVisibility(8);
                  localObject2 = parama;
                  break label1554;
                  label7446:
                  localc.GIW.setVisibility(8);
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
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36796);
      int i = ((bi)paramView.getTag()).position;
      int j = com.tencent.mm.pluginsdk.model.app.m.aAU(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
      k.b localb = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.j(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.j.aS(parambl)))
      {
        if (localb.type != 6) {
          break label628;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.m.aAV(localb.dbA);
        if (((localc == null) || (!e.b.e(parambl, localc.field_fileFullPath))) && (!parambl.eMl())) {
          paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
        }
      }
      boolean bool1;
      if ((localb.gHe <= 0) || ((localb.gHe > 0) && (j >= 100))) {
        switch (localb.type)
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        label275:
        if ((bool1) && (!this.Gob.eZc())) {
          paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.bs.d.axB("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).CZ()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new dx();
          ((dx)localObject).dgp.msgId = parambl.field_msgId;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((dx)localObject).dgq.dfO) || (e.b.a(this.Gob.GzJ.getContext(), localb))) {
            paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
          }
          if (bk.x(parambl)) {
            paramContextMenu.clear();
          }
          if (!this.Gob.eZc()) {
            paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
          }
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {
            paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
          }
          AppMethodBeat.o(36796);
          return true;
          label628:
          paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
          break;
          bool1 = com.tencent.mm.am.f.avO();
          break label275;
          bool1 = com.tencent.mm.am.f.avI();
          break label275;
          boolean bool2 = com.tencent.mm.am.f.avM();
          bool1 = bool2;
          if (bt.aGv(localb.gHf)) {
            break label275;
          }
          paramContextMenu.add(i, 150, 0, this.Gob.GzJ.getMMResources().getString(2131757229));
          bool1 = bool2;
          break label275;
          bool1 = com.tencent.mm.am.f.avF();
          break label275;
          bool1 = com.tencent.mm.am.f.avE();
          break label275;
          bool1 = com.tencent.mm.am.f.avK();
          break label275;
          bool1 = com.tencent.mm.am.f.avG();
          break label275;
          if ((localb.gIs != 5) && (localb.gIs != 6) && (localb.gIs != 2)) {
            break label916;
          }
          if ((localb.gIs != 2) || (bk.x(parambl))) {
            paramContextMenu.clear();
          }
          paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
          AppMethodBeat.o(36796);
          return false;
          paramContextMenu.clear();
          paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
          AppMethodBeat.o(36796);
          return false;
          paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
        }
        label916:
        bool1 = false;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
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
        paramMenuItem = bk.C(parambl);
        if (bt.isNullOrNil(paramMenuItem)) {
          e.b.a(parama, parambl, b(parama, parambl));
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36790);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(36790);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36772);
              e.b.a(parama, parambl, e.d.this.b(parama, parambl));
              com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(36772);
            }
          });
        }
      case 114: 
        paramMenuItem = parambl.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = k.b.rx(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          al.a(parambl, com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.d(parambl, parama.GzJ.getContext());
          continue;
          al.b(parambl, com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.a(parambl, parama.GzJ.getContext(), b(parama, parambl), parama.eZb());
          continue;
          al.p(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.c(parambl, com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.c(parambl, parama.GzJ.getContext());
        }
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", parambl.field_msgId);
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36797);
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553));
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(36798);
      com.tencent.mm.modelstat.a.a(parambl, a.a.htZ);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      Object localObject = parambl.field_content;
      paramView = Boolean.FALSE;
      if (localObject == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      final k.b localb = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      localObject = com.tencent.mm.ai.t.rC((String)localObject);
      if (localb == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      if (((com.tencent.mm.ai.t)localObject).gKA != 0)
      {
        paramView = Boolean.TRUE;
        localb.type = ((com.tencent.mm.ai.t)localObject).gKA;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.h.j(localb.appId, false, false);
      final String str = d(parama, parambl);
      if (localObject != null) {
        a(parama, localb, str, (com.tencent.mm.pluginsdk.model.app.g)localObject, parambl.field_msgSvrId, parama.getTalkerUserName());
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
            while ((i != 0) && (e(localb, parama, this, parambl)))
            {
              AppMethodBeat.o(36798);
              return true;
              com.tencent.mm.plugin.report.service.h.vKh.f(13043, new Object[] { Integer.valueOf(2), localb.description, localb.appId });
              boolean bool = a(localb, parama, this, parambl);
              AppMethodBeat.o(36798);
              return bool;
              if (!this.nMt)
              {
                com.tencent.mm.ui.base.t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
                AppMethodBeat.o(36798);
                return true;
              }
              paramView = new Intent();
              paramView.setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramView.putExtra("scene", 2);
              paramView.putExtra("app_msg_id", parambl.field_msgId);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36798);
              return true;
              if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).CZ()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if ((localb.dbA == null) || (localb.dbA.length() == 0)) {
                ((com.tencent.mm.ui.chatting.c.b.b)parama.be(com.tencent.mm.ui.chatting.c.b.b.class)).a(parambl, new am()
                {
                  public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                  {
                    AppMethodBeat.i(191627);
                    if (this.mLq != null)
                    {
                      if (paramAnonymousBoolean1)
                      {
                        e.d.a(parama, localb, str, this.mLq, parambl.field_msgSvrId, 3, parama.getTalkerUserName());
                        AppMethodBeat.o(191627);
                        return;
                      }
                      e.d.a(parama, localb, str, this.mLq, parambl.field_msgSvrId, 7, parama.getTalkerUserName());
                    }
                    AppMethodBeat.o(191627);
                  }
                });
              }
              for (;;)
              {
                AppMethodBeat.o(36798);
                return true;
                if (!this.nMt)
                {
                  com.tencent.mm.ui.base.t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
                  AppMethodBeat.o(36798);
                  return true;
                }
                paramView = new Intent();
                paramView.setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                paramView.putExtra("app_msg_id", parambl.field_msgId);
                paramView.putExtra("scene", 2);
                parama.GzJ.startActivityForResult(paramView, 210);
              }
              if (bt.isNullOrNil(localb.gHE))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_Product_xml", localb.gHE);
              paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
              if (parambl.field_imgPath == null) {
                paramView.putExtra("key_ProductUI_chatting_msgId", parambl.field_msgId);
              }
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "scanner", ".ui.ProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bt.isNullOrNil(localb.gHH))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_TV_xml", localb.gHH);
              paramView.putExtra("key_TV_getProductInfoScene", 1);
              if (parambl.field_imgPath == null) {
                paramView.putExtra("key_TVInfoUI_chatting_msgId", parambl.field_msgId);
              }
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "shake", ".ui.TVInfoUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bt.isNullOrNil(localb.gHK))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_product_info", localb.gHK);
              paramView.putExtra("key_product_scene", 1);
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "product", ".ui.MallProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              localObject = new Intent();
              ((Intent)localObject).putExtra("message_id", parambl.field_msgId);
              ((Intent)localObject).putExtra("record_xml", localb.gHI);
              ((Intent)localObject).putExtra("big_appmsg", paramView);
              i = com.tencent.mm.model.x.aw(b(parama, parambl), parama.getTalkerUserName());
              ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambl.field_msgSvrId));
              ((Intent)localObject).putExtra("preUsername", b(parama, parambl));
              ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
              ((Intent)localObject).putExtra("preChatTYPE", i);
              e.a.a((Intent)localObject, parama, parambl, this);
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
              AppMethodBeat.o(36798);
              return true;
              if (bt.isNullOrNil(localb.dnn))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_card_app_msg", localb.dnn);
              paramView.putExtra("key_from_scene", localb.gIs);
              com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "card", ".ui.CardDetailUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (d(localb, parama, this, parambl))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              i = 1;
            }
          } while (c(localb, parama, this, parambl));
        }
      case 36: 
        b(localb, parama, this, parambl);
        AppMethodBeat.o(36798);
        return true;
      case 24: 
        e.a(localb, parama, parambl);
        AppMethodBeat.o(36798);
        return true;
      }
      paramView = new Intent();
      paramView.putExtra("key_from_user_name", b(parama, parambl));
      paramView.putExtra("key_biz_uin", localb.gIu);
      paramView.putExtra("key_order_id", localb.gIv);
      if ((parambl.field_talker != null) && (!parambl.field_talker.equals("")) && (w.pF(parambl.field_talker))) {
        paramView.putExtra("key_chatroom_name", parambl.field_talker);
      }
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
      AppMethodBeat.o(36798);
      return true;
      AppMethodBeat.o(36798);
      return false;
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class e
    extends c
    implements s.n
  {
    protected s.i GKb;
    protected s.l GKc;
    protected s.j GKd;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
    private static void a(e.c paramc, com.tencent.mm.ui.chatting.c.b.i parami, bl parambl)
    {
      AppMethodBeat.i(36827);
      if ((parambl.field_status == 2) && (a(parami, parambl.field_msgId)))
      {
        if (paramc.GJi != null)
        {
          paramc.GJi.setVisibility(0);
          AppMethodBeat.o(36827);
        }
      }
      else if (paramc.GJi != null) {
        paramc.GJi.setVisibility(8);
      }
      AppMethodBeat.o(36827);
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(161906);
      if ((bt.isNullOrNil(paramb.gJF)) && (bt.isNullOrNil(paramb.gJE)))
      {
        parambl = paramb.url;
        if (parama.eZb()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.O(parambl, paramc);
          parambl = new Intent();
          parambl.putExtra("rawUrl", paramc);
          parambl.putExtra("webpageTitle", paramb.title);
          parambl.putExtra("shortUrl", paramb.url);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", parambl);
          AppMethodBeat.o(161906);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.b(parama, parambl);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.eZb()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.am.g.F(parambl));
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(parama.GzJ.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambl), parama.eZb(), paramb, localBundle);
        AppMethodBeat.o(161906);
        return true;
        if (w.sE(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean f(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(36831);
      if (paramc.a(parama, paramb, parambl))
      {
        AppMethodBeat.o(36831);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.O(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.O(paramb.gHd, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.GzJ.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambl.field_msgId, parambl.field_msgSvrId, parambl);
        AppMethodBeat.o(36831);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean g(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(36832);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.gJE, paramb.gJD, paramb.gJF, paramb.url, Integer.valueOf(paramb.gJQ), paramb.gJH });
      if ((44 == paramb.type) && ((!paramb.dY(false)) || (bt.isNullOrNil(paramb.r(parama.GzJ.getContext(), false)))))
      {
        AppMethodBeat.o(36832);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambl);
      Bundle localBundle = new Bundle();
      int i;
      if ((parama.GzJ instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.am.g.F(parambl));
        switch (paramb.gJG)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cn(parambl);
        if (i != 0) {
          break label577;
        }
        AppMethodBeat.o(36832);
        return true;
        if (parama.eZb())
        {
          i = 2;
          break;
        }
        if (w.sE((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramc = new Intent();
        paramc.putExtra("key_username", paramb.gJE);
        if (parama.eZb())
        {
          paramc.putExtra("key_from_scene", 1);
          paramc.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + str);
        }
        for (;;)
        {
          paramc.putExtra("_stat_obj", localBundle);
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.gJF;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).iOQ = paramb.gJQ;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.gJI;
          paramc.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).aTV());
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramc);
          i = 0;
          break;
          paramc.putExtra("key_from_scene", 2);
          paramc.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.GzJ instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, localBundle);
          i = 0;
        }
        else if (w.sE((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, localBundle);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.eZb(), paramb, localBundle);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.eZb(), paramb, localBundle);
          i = 0;
        }
      }
      label577:
      AppMethodBeat.o(36832);
      return false;
    }
    
    public static boolean h(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(36833);
      Object localObject2 = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
      if ((localObject2 != null) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject2).gFI)) && (!bt.isNullOrNil(((com.tencent.mm.ai.a)localObject2).gFK)))
      {
        String str2 = ((com.tencent.mm.ai.a)localObject2).gFI;
        String str3 = ((com.tencent.mm.ai.a)localObject2).gFH;
        Object localObject1 = ((com.tencent.mm.ai.a)localObject2).dyw;
        String str1;
        int i;
        if (bt.isNullOrNil(((com.tencent.mm.ai.a)localObject2).gFL))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ai.a)localObject2).gFJ;
          String str5 = paramb.gJF;
          localObject2 = ((com.tencent.mm.ai.a)localObject2).gFK;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { str2, str3, str1, str4, str5, localObject2 });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
          if (!w.pF(parama.getTalkerUserName())) {
            break label364;
          }
          i = 2;
          label165:
          localh.f(17608, new Object[] { Integer.valueOf(i), str5, Integer.valueOf(1), Integer.valueOf(1) });
          if ((bt.isNullOrNil(str2)) && ((bt.isNullOrNil(str3)) || (!com.tencent.mm.vfs.i.eK(str3)) || (!bt.nullAsNil(com.tencent.mm.vfs.i.aEN(str3)).equals(localObject1)))) {
            break label370;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_chatting_type", paramb.type);
          ((Bundle)localObject1).putString("key_chatting_wording", str1);
          ((Bundle)localObject1).putString("key_chatting_text", str4);
          ((Bundle)localObject1).putString("key_chatting_appid", str5);
          ((Bundle)localObject1).putLong("key_msg_id", parambl.field_msgId);
          ((Bundle)localObject1).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject1).putString("key_sender_username", paramc.b(parama, parambl));
          e.a(parama, str2, str3, (String)localObject2, (Bundle)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(36833);
          return false;
          str1 = ((com.tencent.mm.ai.a)localObject2).gFL;
          break;
          label364:
          i = 1;
          break label165;
          label370:
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
        }
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
      com.tencent.mm.ui.base.t.makeText(parama.GzJ.getContext(), parama.GzJ.getMMResources().getString(2131755886), 0).show();
      AppMethodBeat.o(36833);
      return true;
    }
    
    public static boolean i(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      int j = 0;
      AppMethodBeat.i(36834);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bt.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambl.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambl.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject1 = (ab)paramb.ao(ab.class);
        if ((localObject1 != null) && (!bt.isNullOrNil(((ab)localObject1).AGs)))
        {
          paramb = new dsx();
          paramb.AGs = ((ab)localObject1).AGs;
          paramb.AGt = ((ab)localObject1).AGt;
          paramb.AGu = ((ab)localObject1).AGu;
          paramb.AGv = ((ab)localObject1).AGv;
          paramb.AGw = ((ab)localObject1).AGw;
          paramb.AGA = ((ab)localObject1).AGA;
          paramb.oYa = ((ab)localObject1).oYa;
          paramb.oYb = ((ab)localObject1).oYb;
          paramb.rUO = ((ab)localObject1).rUO;
          paramb.AGx = ((ab)localObject1).AGx;
          paramb.AGy = ((ab)localObject1).AGy;
          paramb.AGz = ((ab)localObject1).AGz;
          paramb.source = ((ab)localObject1).source;
          paramb.kqB = ((ab)localObject1).kqB;
          paramb.AGB = ((ab)localObject1).AGB;
          paramb.AGD = ((ab)localObject1).AGD;
          paramb.AGE = ((ab)localObject1).AGE;
          paramb.AGF = ((ab)localObject1).AGF;
          paramb.AGC = ((ab)localObject1).AGC;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.GzJ.getContext().getString(2131759717));
          aa.a(parama.GzJ.getContext(), paramc);
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambl);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject2 = paramb.url;
        Intent localIntent;
        label551:
        label559:
        int i;
        if (parama.eZb())
        {
          localObject1 = "groupmessage";
          Object localObject3 = com.tencent.mm.pluginsdk.model.app.q.O((String)localObject2, (String)localObject1);
          localObject1 = paramb.url;
          localObject2 = c.getPackageInfo(parama.GzJ.getContext(), paramb.appId);
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
          if (!bt.isNullOrNil(paramb.dxz))
          {
            localIntent.putExtra("srcUsername", paramb.dxz);
            localIntent.putExtra("srcDisplayname", paramb.dxA);
          }
          localIntent.putExtra("msg_id", parambl.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambl.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambl));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambl.ePc);
          int k = com.tencent.mm.model.x.aw(paramc.b(parama, parambl), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambl.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambl));
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
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
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
      if (this.GKb == null) {
        this.GKb = new s.i(parama);
      }
      parama = this.GKb;
      AppMethodBeat.o(36822);
      return parama;
    }
    
    public static boolean j(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, bl parambl)
    {
      AppMethodBeat.i(169873);
      if (!bt.isNullOrNil(paramb.canvasPageXml))
      {
        paramc = new Intent();
        paramc.putExtra("sns_landig_pages_from_source", 5);
        paramc.putExtra("msg_id", parambl.field_msgId);
        paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
        paramc.putExtra("sns_landing_pages_share_thumb_url", parambl.field_imgPath);
        paramc.addFlags(268435456);
        com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
        AppMethodBeat.o(169873);
        return true;
      }
      Object localObject1 = (ab)paramb.ao(ab.class);
      if ((localObject1 != null) && (!bt.isNullOrNil(((ab)localObject1).AGs)))
      {
        paramb = new dsx();
        paramb.AGs = ((ab)localObject1).AGs;
        paramb.AGt = ((ab)localObject1).AGt;
        paramb.AGu = ((ab)localObject1).AGu;
        paramb.AGv = ((ab)localObject1).AGv;
        paramb.AGw = ((ab)localObject1).AGw;
        paramb.AGA = ((ab)localObject1).AGA;
        paramb.oYa = ((ab)localObject1).oYa;
        paramb.oYb = ((ab)localObject1).oYb;
        paramb.rUO = ((ab)localObject1).rUO;
        paramb.AGx = ((ab)localObject1).AGx;
        paramb.AGy = ((ab)localObject1).AGy;
        paramb.AGz = ((ab)localObject1).AGz;
        paramb.source = ((ab)localObject1).source;
        paramb.kqB = ((ab)localObject1).kqB;
        paramb.AGB = ((ab)localObject1).AGB;
        paramb.AGD = ((ab)localObject1).AGD;
        paramb.AGE = ((ab)localObject1).AGE;
        paramb.AGF = ((ab)localObject1).AGF;
        paramb.AGC = ((ab)localObject1).AGC;
        paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.GzJ.getContext().getString(2131759717));
        aa.a(parama.GzJ.getContext(), paramc);
        com.tencent.mm.plugin.topstory.a.i.a(paramb, parambl);
        AppMethodBeat.o(169873);
        return true;
      }
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        Object localObject2 = paramb.url;
        int j;
        PackageInfo localPackageInfo;
        Intent localIntent;
        if (parama.eZb())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.O((String)localObject2, (String)localObject1);
          String str = paramb.gHd;
          j = parama.GzJ.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 1, j, i);
          }
          localPackageInfo = c.getPackageInfo(parama.GzJ.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_snsad_statextstr", paramb.dxG);
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
          if (!bt.isNullOrNil(paramb.dxz))
          {
            localIntent.putExtra("srcUsername", paramb.dxz);
            localIntent.putExtra("srcDisplayname", paramb.dxA);
          }
          localIntent.putExtra("msg_id", parambl.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambl.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambl));
          localIntent.putExtra("from_scence", 2);
          i = com.tencent.mm.model.x.aw(paramc.b(parama, parambl), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambl.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambl));
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
        for (int i = paramb.gGx;; i = -1)
        {
          localIntent.putExtra(e.m.FIt, i);
          if ((paramb == null) || (i != 5) || (paramb.gGz != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR())) {
            break label1257;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.FHP, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.FHQ, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.GzJ.getContext(), parambl.field_msgId, parambl.field_msgSvrId, 0, paramb);
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
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.GzJ.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          AppMethodBeat.o(169873);
          return true;
        }
        com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(169873);
      return true;
    }
    
    private s.l k(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36823);
      if (this.GKc == null) {
        this.GKc = new s.l(parama);
      }
      parama = this.GKc;
      AppMethodBeat.o(36823);
      return parama;
    }
    
    private s.j l(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36824);
      if (this.GKd == null) {
        this.GKd = new s.j(parama);
      }
      parama = this.GKd;
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
        localObject = new af(paramLayoutInflater, 2131493476);
        ((View)localObject).setTag(new e.c().y((View)localObject, false));
      }
      AppMethodBeat.o(36825);
      return localObject;
    }
    
    public final void a(final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(36836);
      com.tencent.mm.ui.base.h.d(parama.GzJ.getContext(), parama.GzJ.getMMResources().getString(2131757285), "", parama.GzJ.getMMResources().getString(2131755877), parama.GzJ.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(36804);
          if (parambl.cxB())
          {
            com.tencent.mm.pluginsdk.model.app.m.aB(parambl);
            parama.wc(true);
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
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(36826);
      final e.c localc = (e.c)parama;
      this.Gob = parama1;
      ((com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class)).bC(parambl);
      localc.reset();
      String str = parambl.getContent();
      ((com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class)).bA(parambl);
      k.b localb;
      Object localObject2;
      if (str != null)
      {
        localb = k.b.ar(str, parambl.SK());
        localObject2 = com.tencent.mm.ai.t.rC(str);
      }
      for (;;)
      {
        Object localObject1 = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
        int j = 0;
        int k = 0;
        localc.GJT.setVisibility(8);
        Object localObject3 = localObject1;
        Object localObject4;
        boolean bool1;
        label606:
        int i;
        if (localb != null)
        {
          localObject4 = com.tencent.mm.pluginsdk.model.app.h.fv(localb.appId, localb.aAS);
          localc.GII.aq(localb.title);
          localc.hJe.setText(localb.description);
          localc.GIN.setMaxLines(1);
          localc.GII.setTextColor(ao.aD(parama1.getContext(), 2130968584));
          localc.hJe.setTextColor(parama1.getContext().getResources().getColor(2131100482));
          localc.GJd.setBackground(ao.aC(parama1.getContext(), 2130968742));
          localc.GJd.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
          localc.GIH.setVisibility(0);
          localc.GJb.setVisibility(0);
          localc.hJe.setVisibility(0);
          localc.GJf.setVisibility(8);
          localc.GJg.setVisibility(8);
          localc.GIS.setVisibility(8);
          localc.GIR.setVisibility(8);
          localc.GIO.setVisibility(8);
          localc.GIL.setVisibility(8);
          localc.GIK.setVisibility(8);
          localc.GJp.setVisibility(8);
          localc.GJj.setVisibility(8);
          localc.GJd.setVisibility(0);
          localc.GJw.setVisibility(8);
          localc.GJE.setVisibility(8);
          localc.GJM.setVisibility(8);
          localc.GJR.setVisibility(8);
          e.c.aE(localc.GJc, localc.GJV);
          if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName.trim().length() > 0)) {
            break label1433;
          }
          localObject3 = localb.appName;
          bool1 = true;
          com.tencent.mm.cd.a.fromDPToPix(parama1.getContext(), 12);
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool1 = n.a.euP().doZ();
          }
          if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!eM((String)localObject3))) {
            break label1473;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject4, (String)localObject3);
          if (localb.type != 19) {
            break label1443;
          }
          localc.qkL.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject3 }));
          localc.GIM.setVisibility(0);
          localc.qkL.setVisibility(0);
          localc.qkL.setCompoundDrawables(null, null, null, null);
          localc.GIJ.setVisibility(0);
          if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject4).CZ())) {
            break label1456;
          }
          a(parama1, localc.qkL, parambl, localb, ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_packageName, parambl.SG());
          label681:
          localc.GIJ.setImageResource(2131231697);
          a(parama1, localc.GIJ, localb.appId);
          i = 1;
        }
        for (;;)
        {
          label709:
          localc.GIM.setBackgroundResource(2131233299);
          bool1 = false;
          localc.GIH.setVisibility(0);
          if (this.nMt)
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
                    if (!e.b.aLc(parambl.SJ())) {
                      localObject3 = o.ayF().e(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                    }
                  }
                }
              }
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              localObject4 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject3, false, com.tencent.mm.cd.a.fromDPToPix(parama1.getContext(), 1));
              localc.GIH.setImageBitmap((Bitmap)localObject4);
              label873:
              if (localb.type != 3) {
                break label1668;
              }
              localc.GJd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                private boolean GKe = false;
                
                public final boolean onPreDraw()
                {
                  AppMethodBeat.i(36803);
                  if (this.GKe)
                  {
                    localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                  localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                  this.GKe = true;
                  int i = com.tencent.mm.cd.a.fromDPToPix(parama1.GzJ.getContext(), 24);
                  Bitmap localBitmap = this.val$bitmap;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = com.tencent.mm.sdk.platformtools.f.aG(parama1.GzJ.getContext().getResources().getColor(2131100129), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.az(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                    j = localc.GJd.getHeight();
                    int k = localc.GJd.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166036);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166037);
                    }
                    localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231589, j, i));
                    localc.GJd.setBackgroundDrawable((Drawable)localObject);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                }
              });
              if (!ai.Eq()) {
                break label1657;
              }
              localc.GIM.setBackgroundResource(2131233299);
              label923:
              localc.GIT.setOnClickListener(null);
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
                label1148:
                i = 1;
                parama = (c.a)localObject1;
                j = k;
              }
            }
          }
          for (;;)
          {
            label1158:
            if (i != 0)
            {
              if ((localb.title == null) || (localb.title.length() <= 0)) {
                break label7702;
              }
              localc.GIN.setVisibility(0);
              localc.GIN.setMaxLines(2);
              localc.GIN.setText(localb.title);
              label1213:
              localc.GII.setVisibility(8);
              if (bool1)
              {
                if ((localb.type != 33) && (localb.type != 36)) {
                  break label7715;
                }
                paramString = o.ayF().yl(parambl.SJ());
                localc.GIH.setImageResource(2131689584);
                com.tencent.mm.modelappbrand.a.b.aub().a(localc.GIH, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(52, 52));
              }
            }
            for (;;)
            {
              if (localb.type == 44) {
                e.c.a(parama1, localc, localb);
              }
              localObject3 = parama;
              if (j == 0)
              {
                localc.GJc.setTag(localObject3);
                localc.GJc.setOnClickListener(d(parama1));
              }
              if (this.nMt)
              {
                localc.GJc.setOnLongClickListener(c(parama1));
                localc.GJc.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
              }
              a(paramInt, localc, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
              AppMethodBeat.o(36826);
              return;
              label1433:
              localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              label1443:
              localc.qkL.setText((CharSequence)localObject3);
              break label606;
              label1456:
              a(parama1, localc.qkL, localb.appId);
              break label681;
              label1473:
              if (localb.type == 24)
              {
                localc.qkL.setText(aj.getContext().getString(2131758845));
                localc.GIM.setVisibility(0);
                localc.qkL.setVisibility(0);
                localc.GIJ.setVisibility(8);
                i = 1;
                break label709;
              }
              if ((localb.type == 19) || (((com.tencent.mm.ai.t)localObject2).gKA == 19))
              {
                localc.qkL.setText(aj.getContext().getString(2131757208));
                localc.GIM.setVisibility(0);
                localc.qkL.setVisibility(0);
                localc.GIJ.setVisibility(8);
                i = 1;
                break label709;
              }
              if (e.a(localb, localc)) {
                break label7899;
              }
              localc.GIM.setVisibility(8);
              localc.qkL.setVisibility(8);
              localc.GIJ.setVisibility(8);
              i = 0;
              break label709;
              bool1 = true;
              break label873;
              label1657:
              localc.GIM.setBackgroundResource(2131231682);
              label1668:
              break label923;
              localc.GIH.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
              bool1 = false;
              break label923;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                localc.GII.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                label1744:
                localc.hJe.setVisibility(0);
                localc.hJe.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                localc.GIN.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                localc.GIT.setVisibility(0);
                if (!parambl.SF().equals(parama.GIa)) {
                  break label2011;
                }
                localc.GIT.setImageResource(2131233393);
                label1850:
                parama = new e.g();
                parama.msgId = parambl.SF();
                parama.dsv = parambl.getContent();
                parama.dpa = parambl.SJ();
                localc.GIT.setTag(parama);
                localc.GIT.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWq());
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label2025;
                  }
                  localc.GIH.setImageResource(2131689564);
                }
              }
              for (;;)
              {
                if (!faG()) {
                  break label2037;
                }
                if (localc.uPp == null) {
                  break label7876;
                }
                localc.uPp.setVisibility(8);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GII.setVisibility(8);
                break label1744;
                label2011:
                localc.GIT.setImageResource(2131233395);
                break label1850;
                label2025:
                localc.GIH.setImageBitmap(parama);
              }
              label2037:
              if (localc.uPp == null) {
                break label7876;
              }
              localc.uPp.setVisibility(0);
              if (parambl.getStatus() < 2) {
                break label7876;
              }
              localc.uPp.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                localc.GII.setMaxLines(2);
              }
              for (;;)
              {
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                localc.hJe.setText(bt.mK(localb.gHe));
                localc.GIT.setVisibility(8);
                e.c.a(localc, str, localb.gHe);
                e.c.a(localc, Boolean.FALSE, parambl, localb.dbA, localb.title);
                if (!bool1) {
                  break label7876;
                }
                if (!e.b.aLb(localb.gHf)) {
                  break label2272;
                }
                localc.GIH.setImageResource(2131231063);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GII.setVisibility(8);
              }
              label2272:
              localc.GIH.setImageResource(com.tencent.mm.pluginsdk.model.q.aAJ(localb.gHf));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                label2329:
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.hJe.setMaxLines(2);
                localc.GIO.setVisibility(4);
                localc.GIT.setVisibility(0);
                localc.GIT.setImageResource(2131234464);
                if (!bool1) {
                  break label7876;
                }
                paramString = new com.tencent.mm.aw.a.a.c.a();
                paramString.oq(2131689584).ayZ().de(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50)).ayX().aza().ag(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1));
                localObject2 = o.ayJ();
                if (!bt.isNullOrNil(localb.thumburl)) {
                  break label2522;
                }
              }
              label2522:
              for (parama = localb.gHl;; parama = localb.thumburl)
              {
                ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.GIH, paramString.azc());
                localc.GIT.setVisibility(8);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GII.setVisibility(8);
                break label2329;
              }
              if (localc.GJc.getLayoutParams() != null)
              {
                localc.GJc.getLayoutParams().width = -2;
                localc.GJc.requestLayout();
              }
              localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(localb.gJE);
              label2595:
              label2607:
              final boolean bool2;
              if (localObject2 != null)
              {
                parama = ((WxaAttributes)localObject2).field_nickname;
                if (localObject2 == null) {
                  break label2921;
                }
                paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                localc.GJd.setVisibility(8);
                localc.GJp.setVisibility(0);
                localc.GJj.setVisibility(8);
                localc.GJw.setVisibility(8);
                localc.GJt.setText(localb.title);
                e.e(localc.GJt, localb.title);
                localc.GJn.setText(parama);
                e.a(localc.GJo, localb);
                if (!e.a(parambl, localb, parama1)) {
                  break label2931;
                }
                localc.GJT.setVisibility(0);
                bool2 = bt.isNullOrNil(parambl.SO());
                localc.GJT.setTag(parambl);
                localc.GJT.setOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(179969);
                    e.a((bl)paramAnonymousView.getTag(), localc, parama1);
                    AppMethodBeat.o(179969);
                  }
                });
                e.a(bool2, localc, parama1);
                label2758:
                o.ayJ().a(paramString, localc.GJm, aa.d.frV);
                parama = o.ayF().yl(parambl.SJ());
                localc.GJq.setImageBitmap(null);
                com.tencent.mm.modelappbrand.a.b.aub().a(localc.GJq, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
                if (!faG()) {
                  break label2944;
                }
                a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl);
                if (localc.uPp != null) {
                  localc.uPp.setVisibility(8);
                }
              }
              for (;;)
              {
                if (!e.a(localb, (WxaAttributes)localObject2)) {
                  break label2983;
                }
                localc.jpF.setVisibility(0);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                parama = localb.dxA;
                break label2595;
                label2921:
                paramString = localb.gJS;
                break label2607;
                label2931:
                localc.GJT.setVisibility(8);
                break label2758;
                label2944:
                if (localc.uPp != null)
                {
                  localc.uPp.setVisibility(0);
                  if (parambl.getStatus() >= 2) {
                    localc.uPp.setVisibility(8);
                  }
                }
              }
              label2983:
              localc.jpF.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if (localb != null) {
                e.a(paramString, parama1, parambl, localb);
              }
              parama = (com.tencent.mm.ai.e)localb.ao(com.tencent.mm.ai.e.class);
              if ((parama != null) && (parama.gGz == 1) && (parama.gGx == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR()))
              {
                e.c.a(parama1, localc, localb, parambl, bool1);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
              }
              if ((i == 0) && (ad.a(localb, parama)))
              {
                localc.GJM.setVisibility(0);
                localc.GJR.setVisibility(0);
                ad.a(parama1.getContext(), localb, localc.GJO, localc.GJP);
                ad.b(localc.GJQ, localb);
              }
              localc.GII.setVisibility(8);
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GIN.setMaxLines(2);
                localc.GIN.setVisibility(0);
                localc.GIN.setText(localb.title);
                label3216:
                localc.hJe.setMaxLines(3);
                localc.GIO.setVisibility(4);
                if (!e.k(localb)) {
                  break label3435;
                }
                localc.GIT.setImageResource(2131234464);
                localc.GIT.setVisibility(0);
                label3262:
                if (bool1)
                {
                  paramString = new com.tencent.mm.aw.a.a.c.a();
                  paramString.oq(2131689584).ayZ().yw(com.tencent.mm.plugin.image.d.cGx()).de(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 50)).ayX().aza().ag(com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 1));
                  localObject2 = o.ayJ();
                  if (!bt.isNullOrNil(localb.thumburl)) {
                    break label3448;
                  }
                }
              }
              label3435:
              label3448:
              for (parama = localb.gHl;; parama = localb.thumburl)
              {
                ((com.tencent.mm.aw.a.a)localObject2).a(parama, localc.GIH, paramString.azc());
                if (!faG()) {
                  break label3457;
                }
                a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl);
                if (localc.uPp == null) {
                  break label7876;
                }
                localc.uPp.setVisibility(8);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GIN.setVisibility(8);
                break label3216;
                localc.GIT.setVisibility(8);
                break label3262;
              }
              label3457:
              if (localc.uPp == null) {
                break label7876;
              }
              localc.uPp.setVisibility(0);
              if (parambl.getStatus() < 2) {
                break label7876;
              }
              localc.uPp.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(localb.gJE);
              ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).Ew(localb.gJE);
              switch (localb.gJG)
              {
              }
              for (;;)
              {
                i = 1;
                for (;;)
                {
                  if (i != 0) {
                    break label7889;
                  }
                  if (!faG()) {
                    break label4262;
                  }
                  a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl);
                  if (localc.uPp == null) {
                    break label7889;
                  }
                  localc.uPp.setVisibility(8);
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  if (localc.GJc.getLayoutParams() != null)
                  {
                    localc.GJc.getLayoutParams().width = -2;
                    localc.GJc.requestLayout();
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    label3682:
                    if (localObject2 == null) {
                      break label3977;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    label3694:
                    localc.GJd.setVisibility(8);
                    localc.GJp.setVisibility(0);
                    localc.GJj.setVisibility(8);
                    localc.GJw.setVisibility(8);
                    localc.GJt.setText(localb.title);
                    e.e(localc.GJt, localb.title);
                    localc.GJn.setText(parama);
                    e.a(localc.GJo, localb);
                    o.ayJ().a(paramString, localc.GJm, aa.d.frV);
                    parama = o.ayF().yl(parambl.SJ());
                    localc.GJq.setImageBitmap(null);
                    localc.GJs.setVisibility(0);
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label3987;
                    }
                    localc.jpF.setVisibility(0);
                    label3843:
                    if (!e.a(parambl, localb, parama1)) {
                      break label4000;
                    }
                    localc.GJT.setVisibility(0);
                    bool2 = bt.isNullOrNil(parambl.SO());
                    localc.GJT.setTag(parambl);
                    localc.GJT.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(185040);
                        e.a((bl)paramAnonymousView.getTag(), localc, parama1);
                        AppMethodBeat.o(185040);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    bool2 = e.l(localb);
                    com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
                    {
                      public final String AL()
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
                          localc.GJq.setImageBitmap(paramAnonymousBitmap);
                          localc.GJq.setVisibility(0);
                          localc.GJs.setVisibility(4);
                          if (bool2)
                          {
                            localc.GJr.setImageDrawable(com.tencent.mm.cd.a.l(parama1.GzJ.getContext(), 2131691166));
                            localc.GJr.setVisibility(0);
                            AppMethodBeat.o(36810);
                            return;
                          }
                          localc.GJr.setVisibility(8);
                          AppMethodBeat.o(36810);
                          return;
                        }
                        localc.GJq.setVisibility(4);
                        localc.GJs.setVisibility(0);
                        localc.GJr.setVisibility(8);
                        AppMethodBeat.o(36810);
                      }
                      
                      public final void auj()
                      {
                        AppMethodBeat.i(36809);
                        AppMethodBeat.o(36809);
                      }
                      
                      public final void nV()
                      {
                        AppMethodBeat.i(36811);
                        AppMethodBeat.o(36811);
                      }
                    }, e.aLa(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
                    i = 0;
                    break;
                    parama = localb.dxA;
                    break label3682;
                    label3977:
                    paramString = localb.gJS;
                    break label3694;
                    label3987:
                    localc.jpF.setVisibility(8);
                    break label3843;
                    label4000:
                    localc.GJT.setVisibility(8);
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    label4024:
                    if (localObject2 == null) {
                      break label4166;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    label4036:
                    localc.GJd.setVisibility(8);
                    localc.GJp.setVisibility(8);
                    localc.GJj.setVisibility(0);
                    localc.GJl.setText(parama);
                    localc.GJw.setVisibility(8);
                    if (!bt.isNullOrNil(paramString)) {
                      break label4172;
                    }
                    parama = o.ayF().yl(parambl.SJ());
                    com.tencent.mm.modelappbrand.a.b.aub().a(localc.GJk, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
                  }
                  for (;;)
                  {
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label4195;
                    }
                    localc.GJv.setVisibility(0);
                    i = 0;
                    break;
                    parama = localb.title;
                    break label4024;
                    label4166:
                    paramString = null;
                    break label4036;
                    label4172:
                    com.tencent.mm.modelappbrand.a.b.aub().a(localc.GJk, paramString, com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
                  }
                  label4195:
                  localc.GJv.setVisibility(8);
                  i = 0;
                }
                localc.GIM.setVisibility(0);
                localc.GIJ.setVisibility(0);
                localc.GIJ.setBackground(null);
                localc.GIJ.setImageResource(2131689681);
                e.a(localc.qkL, localb);
              }
              label4262:
              if (localc.uPp == null) {
                break label7889;
              }
              localc.uPp.setVisibility(0);
              if (parambl.getStatus() < 2) {
                break label7889;
              }
              localc.uPp.setVisibility(8);
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              parama = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
              paramString = localb.gJS;
              localObject2 = localb.dxA;
              localObject3 = localb.title;
              localObject4 = localb.description;
              if (parama == null)
              {
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
                break label1148;
              }
              if (((bt.isNullOrNil(parama.gFI)) || (bt.isNullOrNil(parama.gFK))) && (bt.isNullOrNil(parama.gFH)))
              {
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
                break label1148;
              }
              localc.GJC.setText((CharSequence)localObject2);
              localc.GJd.setVisibility(8);
              localc.GJp.setVisibility(8);
              localc.GJj.setVisibility(8);
              localc.GJD.setVisibility(0);
              localc.GJz.setVisibility(8);
              localc.GJD.setImageDrawable(com.tencent.mm.cd.a.l(parama1.getContext(), 2131691166));
              localc.GJw.setVisibility(0);
              localc.GJx.setText((CharSequence)localObject3);
              localc.GJy.setText((CharSequence)localObject4);
              o.ayI().a(paramString, new p.a()
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
                        e.e.7.this.GJZ.GJB.setImageBitmap(paramAnonymousBitmap);
                      }
                      AppMethodBeat.o(36813);
                    }
                  });
                  AppMethodBeat.o(36814);
                }
              });
              parama = o.ayF().yl(parambl.SJ());
              localc.GJA.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
              {
                public final String AL()
                {
                  AppMethodBeat.i(36817);
                  String str = "CHAT#" + com.tencent.mm.plugin.appbrand.aa.m.cF(this);
                  AppMethodBeat.o(36817);
                  return str;
                }
                
                public final void E(Bitmap paramAnonymousBitmap)
                {
                  AppMethodBeat.i(36816);
                  if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                  {
                    localc.GJA.setImageBitmap(paramAnonymousBitmap);
                    localc.GJA.setVisibility(0);
                  }
                  AppMethodBeat.o(36816);
                }
                
                public final void auj()
                {
                  AppMethodBeat.i(36815);
                  localc.GJA.setVisibility(4);
                  AppMethodBeat.o(36815);
                }
                
                public final void nV()
                {
                  AppMethodBeat.i(185041);
                  com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
                  com.tencent.mm.plugin.report.service.h.vKh.dB(808, 3);
                  AppMethodBeat.o(185041);
                }
              }, e.aLa(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.gRA));
              if (faG())
              {
                a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl);
                if (localc.uPp == null) {
                  break label7876;
                }
                localc.uPp.setVisibility(8);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
              }
              if (localc.uPp == null) {
                break label7876;
              }
              localc.uPp.setVisibility(0);
              if (parambl.getStatus() < 2) {
                break label7876;
              }
              localc.uPp.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              i = 1;
              localc.hJe.setMaxLines(3);
              localc.GIN.setMaxLines(2);
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              localc.GII.setVisibility(8);
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GIN.setMaxLines(2);
                localc.GIN.setVisibility(0);
                localc.GIN.setText(localb.title);
                label4789:
                localc.hJe.setMaxLines(3);
                localc.GIO.setVisibility(4);
                localc.GIT.setVisibility(8);
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label4911;
                  }
                  localc.GIH.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                if (!faG()) {
                  break label4923;
                }
                if (localc.uPp == null) {
                  break label7876;
                }
                localc.uPp.setVisibility(8);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GIN.setVisibility(8);
                break label4789;
                label4911:
                localc.GIH.setImageBitmap(parama);
              }
              label4923:
              if (localc.uPp == null) {
                break label7876;
              }
              localc.uPp.setVisibility(0);
              if (parambl.getStatus() < 2) {
                break label7876;
              }
              localc.uPp.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              localc.GIN.setVisibility(0);
              if (localb.gHD == 1) {
                localc.GIN.setText(2131762858);
              }
              for (;;)
              {
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.GII.setVisibility(0);
                  localc.GII.aq(localb.title);
                }
                localc.hJe.setMaxLines(4);
                localc.GIO.setVisibility(4);
                localc.GIT.setVisibility(8);
                if (!bool1) {
                  break label7876;
                }
                parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                if ((parama == null) || (parama.isRecycled())) {
                  break label5188;
                }
                localc.GIH.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                if (localb.gHD == 2) {
                  localc.GIN.setText(2131762860);
                } else if (localb.gHD == 3) {
                  localc.GIN.setText(2131762859);
                } else {
                  localc.GIN.setText(2131762861);
                }
              }
              label5188:
              localc.GIH.setImageResource(2131689584);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              localc.GII.setVisibility(0);
              localc.GII.aq(localb.title);
              localc.GIN.setVisibility(0);
              localc.GIN.setText(2131757247);
              localc.hJe.setMaxLines(4);
              localc.GIO.setVisibility(4);
              localc.GIT.setVisibility(8);
              if (!bool1) {
                break label7876;
              }
              parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localc.GIH.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
              }
              localc.GIH.setImageResource(2131689584);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                localc.GII.aq(localb.title);
                localc.GIN.setVisibility(8);
              }
              localc.hJe.setMaxLines(4);
              localc.GIO.setVisibility(4);
              localc.GIT.setVisibility(8);
              if (!bool1) {
                break label7876;
              }
              parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localc.GIH.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
              }
              localc.GIH.setImageResource(2131689584);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if ((localb.title != null) && (localb.title.length() > 0)) {
                localc.GII.setVisibility(0);
              }
              for (;;)
              {
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIO.setVisibility(8);
                localc.GIT.setVisibility(4);
                localc.hJe.setMaxLines(2);
                if (!bool1) {
                  break label7876;
                }
                parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label5670;
                }
                localc.GIH.setImageResource(2131689584);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GII.setVisibility(8);
              }
              label5670:
              localc.GIH.setImageBitmap(parama);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                label5720:
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIT.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                if (bool1)
                {
                  parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5905;
                  }
                  localc.GIH.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bi(parambl, false, paramInt, "", false, parama1.eWM(), localb.dxz, localb.dxA, localb.title, localb.gHL, localb.url, false, false);
                localc.GJc.setTag(parama);
                localc.GJc.setOnClickListener(i(parama1));
                j = 1;
                i = 0;
                break;
                localc.GII.setVisibility(8);
                break label5720;
                label5905:
                localc.GIH.setImageBitmap(parama);
              }
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                label5945:
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIT.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                if (bool1)
                {
                  parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6136;
                  }
                  localc.GIH.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bi(parambl, paramInt, "", parama1.eWM(), localb.dxz, localb.dxA, localb.title, localb.gJs, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.GJc.setTag(parama);
                localc.GJc.setOnClickListener(j(parama1));
                j = 1;
                i = 0;
                break;
                localc.GII.setVisibility(8);
                break label5945;
                label6136:
                localc.GIH.setImageBitmap(parama);
              }
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                label6176:
                localc.hJe.setVisibility(0);
                localc.GIN.setVisibility(8);
                localc.GIT.setVisibility(8);
                localc.GIO.setVisibility(4);
                localc.hJe.setMaxLines(2);
                if (bool1)
                {
                  if (!bt.isNullOrNil(parambl.SJ())) {
                    break label6435;
                  }
                  o.ayJ().loadImage(localb.thumburl, localc.GIH);
                }
                label6255:
                parama = new bi();
                parama.drF = parambl;
                parama.GjM = false;
                parama.position = paramInt;
                parama.GQP = false;
                parama.title = parama1.eWM();
                parama.dxz = localb.dxz;
                parama.dxA = localb.dxA;
                parama.GQQ = localb.title;
                if (localb.type != 26) {
                  break label6492;
                }
                parama.tid = localb.tid;
                parama.gJt = localb.gJt;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.GJc.setOnClickListener(k(parama1));
                i = 1;
              }
              for (;;)
              {
                localc.GJc.setTag(parama);
                k = 0;
                j = i;
                i = k;
                break;
                localc.GII.setVisibility(8);
                break label6176;
                label6435:
                parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                if ((parama == null) || (parama.isRecycled()))
                {
                  localc.GIH.setImageResource(2131689584);
                  break label6255;
                }
                localc.GIH.setImageBitmap(parama);
                break label6255;
                label6492:
                if (localb.type == 27)
                {
                  parama.tid = localb.tid;
                  parama.gJt = localb.gJt;
                  parama.desc = localb.desc;
                  parama.iconUrl = localb.iconUrl;
                  parama.secondUrl = localb.secondUrl;
                  parama.pageType = localb.pageType;
                  localc.GJc.setOnClickListener(l(parama1));
                  i = 1;
                }
                else
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                  i = 0;
                }
              }
              localc.GII.setVisibility(0);
              localc.GII.aq(localb.description);
              localc.hJe.setText(localb.gIr);
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GIN.setVisibility(0);
                localc.GIN.setText(localb.title);
              }
              for (;;)
              {
                localc.hJe.setMaxLines(4);
                localc.GIO.setVisibility(4);
                localc.GIT.setVisibility(8);
                if (!bool1) {
                  break label7876;
                }
                parama = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                if (parama == null) {
                  break label6758;
                }
                localc.GIH.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GIN.setVisibility(8);
              }
              label6758:
              localc.GIH.setImageResource(2131689584);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              localc.GII.setVisibility(8);
              localc.GIN.setVisibility(0);
              if ((localb.title != null) && (localb.title.length() > 0)) {
                localc.GIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.GIN.getContext(), localb.title, (int)localc.GIN.getTextSize()));
              }
              for (;;)
              {
                localc.hJe.setMaxLines(3);
                localc.GIO.setVisibility(4);
                localc.GIT.setVisibility(8);
                if (bool1) {
                  localc.GIH.setVisibility(8);
                }
                e.c.b(parama1, localc, localb, parambl, bool1);
                if (!faG()) {
                  break label7002;
                }
                a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl);
                if (localc.uPp == null) {
                  break label7876;
                }
                localc.uPp.setVisibility(8);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.GIN.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.GIN.getContext(), aj.getContext().getString(2131759034), (int)localc.GIN.getTextSize()));
              }
              label7002:
              if (localc.uPp == null) {
                break label7876;
              }
              localc.uPp.setVisibility(0);
              if (parambl.getStatus() < 2) {
                break label7876;
              }
              localc.uPp.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              e.c.a(parama1, localc, localb, bool1);
              if (faG())
              {
                a(localc, (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class), parambl);
                if (localc.uPp == null) {
                  break label7876;
                }
                localc.uPp.setVisibility(8);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1158;
              }
              if (localc.uPp == null) {
                break label7876;
              }
              localc.uPp.setVisibility(0);
              if (parambl.getStatus() < 2) {
                break label7876;
              }
              localc.uPp.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.GII.setVisibility(0);
                if (!bt.isNullOrNil(localb.gIA)) {
                  if (!bt.isNullOrNil(localb.gIA))
                  {
                    localc.GII.setTextColor(bt.cB(localb.gIA, parama1.getContext().getResources().getColor(2131100711)));
                    label7243:
                    localc.hJe.setMaxLines(2);
                    localc.hJe.setVisibility(0);
                    if (bt.isNullOrNil(localb.gIB)) {
                      break label7564;
                    }
                    localc.hJe.setTextColor(bt.cB(localb.gIB, parama1.getContext().getResources().getColor(2131100469)));
                    label7301:
                    localc.GIN.setVisibility(8);
                    localc.GIO.setVisibility(4);
                    localc.GIT.setVisibility(8);
                    localc.GIM.setVisibility(0);
                    localc.qkL.setVisibility(0);
                    if (bt.isNullOrNil(localb.gIw)) {
                      break label7588;
                    }
                    localc.qkL.setText(localb.gIw);
                  }
                }
              }
              for (;;)
              {
                if (this.nMt)
                {
                  parama = o.ayF().e(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled()))
                  {
                    paramString = com.tencent.mm.sdk.platformtools.f.a(parama, false, parama.getWidth() / 2);
                    localc.GIH.setImageBitmap(paramString);
                  }
                  if (!bt.isNullOrNil(localb.gIz))
                  {
                    o.ayJ().a(localb.gIz, new ImageView(parama1.getContext()), new com.tencent.mm.aw.a.a.c.a().ayY().azc(), new com.tencent.mm.aw.a.c.h()
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
                          localc.GJd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                          {
                            public final boolean onPreDraw()
                            {
                              AppMethodBeat.i(36818);
                              e.e.9.this.GJZ.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                              int j = e.e.9.this.GJZ.GJd.getHeight();
                              int k = e.e.9.this.GJZ.GJd.getWidth();
                              int i = j;
                              if (j == 0) {
                                i = com.tencent.mm.cd.a.ao(e.e.9.this.GIy.GzJ.getContext(), 2131166036);
                              }
                              j = k;
                              if (k == 0) {
                                j = com.tencent.mm.cd.a.ao(e.e.9.this.GIy.GzJ.getContext(), 2131166037);
                              }
                              BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b(paramAnonymousString, 2131231589, j, i));
                              e.e.9.this.GJZ.GJd.setBackgroundDrawable(localBitmapDrawable);
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
                    localc.GII.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                    break label7243;
                    localc.GII.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                    break label7243;
                    localc.GII.setVisibility(8);
                    break label7243;
                    label7564:
                    localc.hJe.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                    break label7301;
                    label7588:
                    localc.qkL.setText(2131757206);
                    continue;
                  }
                  localc.GJd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                  {
                    private boolean GKe = false;
                    
                    public final boolean onPreDraw()
                    {
                      AppMethodBeat.i(36820);
                      if (this.GKe)
                      {
                        localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                        AppMethodBeat.o(36820);
                        return true;
                      }
                      localc.GJd.getViewTreeObserver().removeOnPreDrawListener(this);
                      this.GKe = true;
                      int i = com.tencent.mm.cd.a.fromDPToPix(parama1.GzJ.getContext(), 24);
                      Bitmap localBitmap = parama;
                      Object localObject;
                      if (localBitmap != null)
                      {
                        localObject = localBitmap;
                        if (!localBitmap.isRecycled()) {}
                      }
                      else
                      {
                        localObject = com.tencent.mm.sdk.platformtools.f.aG(parama1.GzJ.getContext().getResources().getColor(2131100129), i, i);
                      }
                      int j = ((Bitmap)localObject).getHeight();
                      if (i > j) {
                        i = j;
                      }
                      for (;;)
                      {
                        localObject = com.tencent.mm.sdk.platformtools.f.l(com.tencent.mm.sdk.platformtools.f.az(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                        j = localc.GJd.getHeight();
                        int k = localc.GJd.getWidth();
                        i = j;
                        if (j == 0) {
                          i = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166036);
                        }
                        j = k;
                        if (k == 0) {
                          j = com.tencent.mm.cd.a.ao(parama1.GzJ.getContext(), 2131166037);
                        }
                        localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.b((Bitmap)localObject, 2131231589, j, i));
                        localc.GJd.setBackgroundDrawable((Drawable)localObject);
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
              localc.GIH.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              if (((com.tencent.mm.ai.t)localObject2).gKA != 19) {
                break label7876;
              }
              e.c.a(parama1, localc, localb, bool1);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1158;
              label7702:
              localc.GIN.setVisibility(8);
              break label1213;
              label7715:
              localObject1 = o.ayF().b(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
              if (localObject1 != null)
              {
                paramString = (String)localObject1;
                if (!((Bitmap)localObject1).isRecycled()) {}
              }
              else
              {
                paramString = o.ayF().e(parambl.SJ(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
              }
              if ((paramString != null) && (!paramString.isRecycled()))
              {
                localc.GIH.setImageBitmap(paramString);
              }
              else if (!bt.isNullOrNil(localb.thumburl))
              {
                paramString = localb.thumburl;
                localObject1 = new com.tencent.mm.aw.a.a.c.a();
                ((com.tencent.mm.aw.a.a.c.a)localObject1).oq(2131100141).ayZ().ayX();
                o.ayJ().a(paramString, localc.GJG, ((com.tencent.mm.aw.a.a.c.a)localObject1).azc());
              }
              else
              {
                localc.GIH.setImageResource(2131231063);
              }
            }
            label7876:
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            continue;
            label7889:
            parama = (c.a)localObject1;
            j = k;
          }
          label7899:
          i = 1;
        }
        localObject2 = null;
        localb = null;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(36828);
      int i = ((bi)paramView.getTag()).position;
      if (parambl.field_content == null)
      {
        AppMethodBeat.o(36828);
        return true;
      }
      k.b localb = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(36828);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.j(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.j.aS(parambl)) && ((localb.type != 19) || (parambl.field_status != 1))) {
        paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      }
      if (((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker)) && (!com.tencent.mm.storage.af.rz(this.Gob.getTalkerUserName()))) {
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
        if ((bool1) && (!this.Gob.eZc())) {
          paramContextMenu.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.bs.d.axB("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).CZ()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new dx();
          ((dx)localObject).dgp.msgId = parambl.field_msgId;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((dx)localObject).dgq.dfO) || (e.b.a(this.Gob.GzJ.getContext(), localb))) {
            paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
          }
          if (!this.Gob.eZc()) {
            paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
          }
          if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (bu.eGT())) {
            paramContextMenu.add(i, 144, 0, paramView.getContext().getString(2131761225));
          }
          AppMethodBeat.o(36828);
          return true;
          bool1 = com.tencent.mm.am.f.avO();
          break;
          bool1 = com.tencent.mm.am.f.avI();
          break;
          boolean bool2 = com.tencent.mm.am.f.avM();
          bool1 = bool2;
          if (bt.aGv(localb.gHf)) {
            break;
          }
          paramContextMenu.add(i, 150, 0, this.Gob.GzJ.getMMResources().getString(2131757229));
          bool1 = bool2;
          break;
          bool1 = com.tencent.mm.am.f.avF();
          break;
          bool1 = com.tencent.mm.am.f.avE();
          break;
          bool1 = com.tencent.mm.am.f.avK();
          break;
          bool1 = com.tencent.mm.am.f.avG();
          break;
          if ((localb.gIs != 5) && (localb.gIs != 6) && (localb.gIs != 2)) {
            break label893;
          }
          if (localb.gIs != 2) {
            paramContextMenu.clear();
          }
          paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
          AppMethodBeat.o(36828);
          return false;
          paramContextMenu.clear();
          paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
          AppMethodBeat.o(36828);
          return false;
          paramContextMenu.add(i, 116, 0, paramView.getContext().getString(2131761941));
        }
        label893:
        bool1 = false;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
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
        e.b.a(parama, parambl, b(parama, parambl));
        AppMethodBeat.o(36829);
        return false;
      case 114: 
        paramMenuItem = parambl.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.rx(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          al.a(parambl, com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.d(parambl, parama.GzJ.getContext());
          continue;
          al.b(parambl, com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.a(parambl, parama.GzJ.getContext(), b(parama, parambl), parama.eZb());
          continue;
          al.p(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.c(parambl, com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend), parama.GzJ.getContext());
          continue;
          al.c(parambl, parama.GzJ.getContext());
        }
      case 103: 
        paramMenuItem = parambl.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.rx(paramMenuItem);
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
        paramMenuItem.putExtra("Chat_Msg_Id", parambl.field_msgId);
        com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        AppMethodBeat.o(36829);
        return false;
        je localje = new je();
        localje.dnm.dnn = paramMenuItem.dnn;
        localje.dnm.ded = parambl.field_msgId;
        localje.dnm.dno = parambl.field_talker;
        com.tencent.mm.sdk.b.a.ESL.l(localje);
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553));
    }
    
    public final boolean b(final View paramView, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(36830);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      paramView.getTag();
      paramView = parambl.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      paramView = k.b.rx(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.j(paramView.appId, true, false);
      if ((localObject != null) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId))) {
        a(parama, paramView, u.aqG(), (com.tencent.mm.pluginsdk.model.app.g)localObject, parambl.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (paramView.type)
      {
      default: 
        i = 1;
      }
      while ((i != 0) && (i(paramView, parama, this, parambl)))
      {
        AppMethodBeat.o(36830);
        return true;
        az.arV();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
          AppMethodBeat.o(36830);
          return true;
        }
        if (bt.aGv(paramView.gHf))
        {
          long l = parambl.field_msgId;
          localObject = paramView.dbA;
          paramView = ap.bxS().aAL((String)localObject);
          if ((paramView == null) || (!paramView.cAX())) {
            i = 0;
          }
          while (i != 0)
          {
            AppMethodBeat.o(36830);
            return true;
            az.arV();
            bl localbl = com.tencent.mm.model.c.apO().rm(l);
            if (localbl.eMl())
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject, Long.valueOf(l), Long.valueOf(localbl.field_msgSvrId), localbl.field_imgPath });
              localObject = new Intent();
              ((Intent)localObject).setClassName(this.Gob.GzJ.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
              ((Intent)localObject).putExtra("clean_view_type", 1);
              paramView = this.Gob;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              i = 1;
            }
            else
            {
              localObject = new Intent(this.Gob.GzJ.getContext(), ShowImageUI.class);
              ((Intent)localObject).putExtra("key_image_path", paramView.field_fileFullPath);
              ((Intent)localObject).putExtra("key_message_id", l);
              ((Intent)localObject).putExtra("key_favorite", true);
              paramView = this.Gob;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              i = 1;
            }
          }
        }
        paramView = new Intent();
        paramView.setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramView.putExtra("scene", 2);
        paramView.putExtra("app_msg_id", parambl.field_msgId);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36830);
        return true;
        com.tencent.mm.plugin.report.service.h.vKh.f(13043, new Object[] { Integer.valueOf(2), paramView.description, paramView.appId });
        boolean bool = f(paramView, parama, this, parambl);
        AppMethodBeat.o(36830);
        return bool;
        bool = j(paramView, parama, this, parambl);
        AppMethodBeat.o(36830);
        return bool;
        if (h(paramView, parama, this, parambl))
        {
          AppMethodBeat.o(36830);
          return true;
          if (g(paramView, parama, this, parambl))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          i = 1;
          continue;
          b(paramView, parama, this, parambl);
          AppMethodBeat.o(36830);
          return true;
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).CZ()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          ((com.tencent.mm.ui.chatting.c.b.b)parama.be(com.tencent.mm.ui.chatting.c.b.b.class)).a(parambl, new am()
          {
            public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
            {
              AppMethodBeat.i(191628);
              if (this.ogD != null)
              {
                if (paramAnonymousBoolean1)
                {
                  e.e.a(parama, paramView, u.aqG(), this.ogD, parambl.field_msgSvrId, 3, parama.getTalkerUserName());
                  AppMethodBeat.o(191628);
                  return;
                }
                e.e.a(parama, paramView, u.aqG(), this.ogD, parambl.field_msgSvrId, 7, parama.getTalkerUserName());
              }
              AppMethodBeat.o(191628);
            }
          });
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.gHE))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_Product_xml", paramView.gHE);
          ((Intent)localObject).putExtra("key_ProductUI_getProductInfoScene", 1);
          if (parambl.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_ProductUI_chatting_msgId", parambl.field_msgId);
          }
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.gHH))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          localObject = new Intent();
          ((Intent)localObject).setFlags(65536);
          ((Intent)localObject).putExtra("key_TV_xml", paramView.gHH);
          ((Intent)localObject).putExtra("key_TV_getProductInfoScene", 1);
          if (parambl.field_imgPath == null) {
            ((Intent)localObject).putExtra("key_TVInfoUI_chatting_msgId", parambl.field_msgId);
          }
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.gHK))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          parambl = new Intent();
          parambl.setFlags(65536);
          parambl.putExtra("key_product_info", paramView.gHK);
          parambl.putExtra("key_product_scene", 1);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "product", ".ui.MallProductUI", parambl);
          AppMethodBeat.o(36830);
          return true;
          if (bt.isNullOrNil(paramView.dnn))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          parambl = new Intent();
          parambl.setFlags(65536);
          parambl.putExtra("key_card_app_msg", paramView.dnn);
          parambl.putExtra("key_from_scene", paramView.gIs);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "card", ".ui.CardDetailUI", parambl);
          AppMethodBeat.o(36830);
          return true;
          localObject = new Intent();
          ((Intent)localObject).putExtra("message_id", parambl.field_msgId);
          ((Intent)localObject).putExtra("record_xml", paramView.gHI);
          i = com.tencent.mm.model.x.aw(b(parama, parambl), parama.getTalkerUserName());
          ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambl.field_msgSvrId));
          ((Intent)localObject).putExtra("preUsername", b(parama, parambl));
          ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
          ((Intent)localObject).putExtra("preChatTYPE", i);
          e.a.a((Intent)localObject, parama, parambl, this);
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
          e.a(paramView, parama, parambl);
          AppMethodBeat.o(36830);
          return true;
          localObject = new Intent();
          ((Intent)localObject).putExtra("key_biz_uin", paramView.gIu);
          ((Intent)localObject).putExtra("key_order_id", paramView.gIv);
          if ((parambl.field_talker != null) && (!parambl.field_talker.equals("")) && (w.pF(parambl.field_talker))) {
            ((Intent)localObject).putExtra("key_chatroom_name", parambl.field_talker);
          }
          com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
          AppMethodBeat.o(36830);
          return true;
        }
      }
      AppMethodBeat.o(36830);
      return false;
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
  
  static final class f
  {
    public boolean GKm = false;
  }
  
  public static final class g
  {
    public e.h GKn;
    public int GKo = -1;
    public String dpa;
    public String dsv;
    public long msgId;
  }
  
  public static final class h
  {
    public String Btj;
    public String coverUrl;
    public String gKR;
    public String playUrl;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e
 * JD-Core Version:    0.7.0.1
 */