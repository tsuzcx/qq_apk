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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.r.a;
import com.tencent.mm.chatroom.d.y.a;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.pluginsdk.model.app.an.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.k.2;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.t.i;
import com.tencent.mm.ui.chatting.t.j;
import com.tencent.mm.ui.chatting.t.l;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.tools.w;
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
  private static boolean AIu = false;
  
  private static void a(final Context paramContext, final boolean paramBoolean, final String paramString1, final String paramString2, final String paramString3, final com.tencent.mm.ui.transmit.e.a parama)
  {
    AppMethodBeat.i(187719);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
    paramContext = View.inflate(paramContext, 2131495768, null);
    Object localObject = (ImageView)paramContext.findViewById(2131305961);
    if (com.tencent.mm.sdk.platformtools.ad.foi()) {
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
          this.Kvo.Kxa = true;
          locale.bqD();
          if (parama != null) {
            parama.fLG();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(185018);
        }
      });
      locale.LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(185019);
          paramAnonymousl.clear();
          this.fRt.setFooterView(null);
          this.fRt.setFooterView(paramContext);
          AppMethodBeat.o(185019);
        }
      };
      locale.KtV = new com.tencent.mm.ui.widget.a.e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(185020);
          String str;
          int j;
          if (!this.Kvo.Kxa)
          {
            str = paramString1;
            j = this.fNr;
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
      locale.fQw();
      locale.cPF();
      AppMethodBeat.o(187719);
      return;
      ((ImageView)localObject).setImageResource(2131234396);
    }
  }
  
  protected static void a(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(36837);
    switch (paramb.hFr)
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
  
  public static void a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
  {
    AppMethodBeat.i(36838);
    oi localoi = new oi();
    localoi.dDm.context = parama.Kkd.getContext();
    localoi.dDm.msgId = parambv.field_msgId;
    localoi.dDm.dCy = parama.fJC();
    localoi.dDm.dDn = paramb.hDg;
    localoi.dDm.scene = 6;
    com.tencent.mm.sdk.b.a.IvT.l(localoi);
    AppMethodBeat.o(36838);
  }
  
  public static void a(com.tencent.mm.storage.bv parambv, c.a parama, com.tencent.mm.ui.chatting.e.a parama1)
  {
    AppMethodBeat.i(179989);
    a(parambv, parama, parama1, 0);
    AppMethodBeat.o(179989);
  }
  
  public static void a(com.tencent.mm.storage.bv parambv, final c.a parama, final com.tencent.mm.ui.chatting.e.a parama1, final int paramInt)
  {
    AppMethodBeat.i(185048);
    if (parambv == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185048);
      return;
    }
    if (ay.aRW("group_to_do").getBoolean("introduce_dialog_first", true))
    {
      ay.aRW("group_to_do").edit().putBoolean("introduce_dialog_first", false);
      a(parama1.Kkd.getContext(), bu.isNullOrNil(parambv.fmA), parama1.getTalkerUserName(), parambv.fmA, com.tencent.mm.chatroom.d.y.f(parambv), new com.tencent.mm.ui.transmit.e.a()
      {
        public final void fLG()
        {
          AppMethodBeat.i(179943);
          e.b(this.hHF, parama, parama1, paramInt);
          AppMethodBeat.o(179943);
        }
      });
      AppMethodBeat.o(185048);
      return;
    }
    a(parambv, parama, parama1, paramInt, 0);
    AppMethodBeat.o(185048);
  }
  
  private static void a(final com.tencent.mm.storage.bv parambv, final c.a parama, final com.tencent.mm.ui.chatting.e.a parama1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185049);
    if (parambv == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185049);
      return;
    }
    boolean bool = bu.isNullOrNil(parambv.fmA);
    Activity localActivity = parama1.Kkd.getContext();
    String str2 = parambv.field_talker;
    if (bu.isNullOrNil(parambv.fmA)) {}
    for (String str1 = com.tencent.mm.chatroom.d.y.d(parambv);; str1 = parambv.fmA)
    {
      com.tencent.mm.chatroom.d.y.a(localActivity, str2, str1, com.tencent.mm.chatroom.d.y.f(parambv), bool, 2, paramInt1, paramInt2, new y.a()
      {
        public final void Yp()
        {
          AppMethodBeat.i(179944);
          if (!this.Kvn) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.c(parambv);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", new Object[] { Long.valueOf(parambv.field_msgSvrId), localPair });
            AppMethodBeat.o(179944);
            return;
          }
        }
        
        public final void Yq()
        {
          AppMethodBeat.i(179945);
          if (!this.Kvn) {}
          for (boolean bool = true;; bool = false)
          {
            e.a(bool, parama, parama1);
            Pair localPair = com.tencent.mm.chatroom.d.y.e(parambv);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", new Object[] { Long.valueOf(parambv.field_msgSvrId), localPair });
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
      paramc.KwH.setBackgroundResource(2131231647);
      paramc.KwI.setTextColor(parama.Kkd.getContext().getResources().getColor(2131099673));
      paramc.KwI.setText(2131760124);
      AppMethodBeat.o(179988);
      return;
    }
    paramc.KwH.setBackgroundResource(2131231648);
    paramc.KwI.setTextColor(parama.Kkd.getContext().getResources().getColor(2131099699));
    paramc.KwI.setText(2131760126);
    AppMethodBeat.o(179988);
  }
  
  public static boolean a(k.b paramb, final com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(187720);
    Object localObject = paramb.hFm;
    String str1 = paramb.hFn;
    String str2 = paramb.hFo;
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(187720);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.lite.a.a.class)).diw();
    if ((com.tencent.mm.sdk.platformtools.bv.fpR()) || (bool)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.lite.logic.c.diz();
      paramb = com.tencent.mm.plugin.lite.logic.c.apC((String)localObject);
      com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 30L, 1L);
      int j = i;
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 31L, 1L);
        j = i;
        if (paramb == null)
        {
          com.tencent.mm.plugin.lite.logic.c.diz();
          if (com.tencent.mm.plugin.lite.logic.c.diA() == null) {
            com.tencent.mm.plugin.lite.logic.c.diz().diB();
          }
          com.tencent.mm.plugin.lite.logic.c.diz().a((String)localObject, null);
          j = 0;
        }
      }
      if (j != 0) {
        break;
      }
      AppMethodBeat.o(187720);
      return false;
    }
    paramb = new Bundle();
    paramb.putString("appId", (String)localObject);
    if (!bu.isNullOrNil(str1)) {
      paramb.putString("path", str1);
    }
    if (!bu.isNullOrNil(str2)) {
      paramb.putString("query", str2);
    }
    localObject = parama.Kkd.getContext();
    parama.Kkd.getContext().getString(2131755906);
    localObject = com.tencent.mm.ui.base.h.b((Context)localObject, parama.Kkd.getContext().getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.lite.a.a.class)).a(parama.Kkd.getContext(), paramb, false, new com.tencent.mm.plugin.lite.a.a.a()
    {
      public final void cZN()
      {
        AppMethodBeat.i(187709);
        com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 32L, 1L);
        this.pnC.cancel();
        AppMethodBeat.o(187709);
      }
      
      public final void cZO()
      {
        AppMethodBeat.i(187710);
        com.tencent.mm.ui.base.t.makeText(parama.Kkd.getContext(), 2131760707, 0).show();
        this.pnC.cancel();
        AppMethodBeat.o(187710);
      }
    });
    AppMethodBeat.o(187720);
    return true;
  }
  
  public static boolean a(com.tencent.mm.storage.bv parambv, k.b paramb, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(179986);
    if (!com.tencent.mm.chatroom.d.y.Yn())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (parambv == null)
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
    if (ch.aDb() - parambv.field_createTime >= com.tencent.mm.chatroom.storage.d.fOi.longValue())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (com.tencent.mm.model.x.Aa(parama.getTalkerUserName()))
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
    paramb = (com.tencent.mm.plugin.websearch.api.ae)paramb.ao(com.tencent.mm.plugin.websearch.api.ae.class);
    if ((paramb != null) && (!bu.isNullOrNil(paramb.DTD)))
    {
      AppMethodBeat.o(36839);
      return true;
    }
    AppMethodBeat.o(36839);
    return false;
  }
  
  static final class a
  {
    static void a(Intent paramIntent, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv, c paramc)
    {
      AppMethodBeat.i(36752);
      String str = parama.getTalkerUserName();
      paramc = paramc.b(parama, parambv);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.fJC()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str);
        localBundle.putString("stat_send_msg_user", paramc);
        paramIntent.putExtra("_stat_obj", localBundle);
        AppMethodBeat.o(36752);
        return;
        if (com.tencent.mm.model.x.Ao(str)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
  }
  
  static final class b
  {
    static void a(com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bv parambv, String paramString)
    {
      AppMethodBeat.i(36756);
      Object localObject1 = bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend);
      final Intent localIntent = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      localIntent.putExtra("Retr_Msg_content", (String)localObject1);
      localIntent.putExtra("Retr_MsgFromScene", 2);
      localObject1 = k.b.zb((String)localObject1);
      if ((localObject1 != null) && (19 == ((k.b)localObject1).type)) {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_Msg_Id", parambv.field_msgId);
        if ((localObject1 != null) && (((k.b)localObject1).type == 6)) {
          break label526;
        }
        parambv = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambv.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambv.mt(0));
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
      Object localObject2 = parambv.field_talker;
      Object localObject3 = com.tencent.mm.model.z.Br(parambv.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = com.tencent.mm.model.z.aBG().F((String)localObject3, true);
      ((z.b)localObject3).k("prePublishId", "msg_" + parambv.field_msgSvrId);
      ((z.b)localObject3).k("preUsername", paramString);
      ((z.b)localObject3).k("preChatName", localObject2);
      if ((localObject1 != null) && (((k.b)localObject1).ao(com.tencent.mm.ah.a.class) != null))
      {
        ((z.b)localObject3).k("appservicetype", Integer.valueOf(((com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class)).hAL));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.ah.a)((k.b)localObject1).ao(com.tencent.mm.ah.a.class)).hAL);
      }
      if ((localObject1 != null) && (33 == ((k.b)localObject1).type))
      {
        if (!parama.fJC()) {
          break label502;
        }
        ((z.b)localObject3).k("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", parambv.field_talker);
        ((z.b)localObject3).k("sendAppMsgScene", Integer.valueOf(1));
        ((com.tencent.mm.plugin.sns.b.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.j.class)).a("adExtStr", (z.b)localObject3, parambv);
        break;
        label502:
        ((z.b)localObject3).k("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      label526:
      int i;
      if (((k.b)localObject1).type == 6)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1203L, 7L, 1L, false);
        localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
        localObject3 = ((k.b)localObject1).hCR;
        if (((k.b)localObject1).hCG == 1)
        {
          i = 7;
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((k.b)localObject1).hCC), Integer.valueOf(2), Long.valueOf((ch.aDb() - parambv.field_createTime) / 1000L), ((k.b)localObject1).hCD, parambv.field_talker, Integer.valueOf(1), "", Long.valueOf(parambv.field_msgSvrId), Long.valueOf(parambv.field_createTime) });
        }
      }
      else
      {
        if ((((k.b)localObject1).hCG == 0) && (((k.b)localObject1).hCC <= 26214400)) {
          break label844;
        }
      }
      label844:
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("Retr_Big_File", bool);
        localObject2 = com.tencent.mm.pluginsdk.model.app.m.aNj(((k.b)localObject1).dlu);
        if (localObject2 == null) {
          break label993;
        }
        localObject3 = new com.tencent.mm.vfs.k(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
        if ((!((com.tencent.mm.vfs.k)localObject3).exists()) || (((com.tencent.mm.vfs.k)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen)) {
          break label850;
        }
        parambv = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(parama, parambv.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)parambv.mt(0));
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
        if ((parambv.fvU()) || (f(parambv, paramString)))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
          com.tencent.mm.ui.base.h.d(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131759063), parama.Kkd.getContext().getString(2131755906), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            com.tencent.mm.ui.base.h.c(parama.Kkd.getContext(), parama.Kkd.getMMResources().getString(2131757939), "", true);
          }
          AppMethodBeat.o(36756);
          return;
        }
      }
      label993:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((k.b)localObject1).hCC), ((k.b)localObject1).hCR, bu.aSM(((k.b)localObject1).gmb) });
      if (!bool)
      {
        a(parama, localIntent, parambv);
        AppMethodBeat.o(36756);
        return;
      }
      localIntent.putExtra("Retr_Big_File", bool);
      localObject3 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject3).fLl = "task_ChattingItemAppMsg";
      ((com.tencent.mm.i.g)localObject3).fLm = new g.a()
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
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousd != null)
            {
              if (!paramAnonymousd.field_exist_whencheck) {
                break label179;
              }
              paramAnonymousString = this.KuD;
              paramAnonymousc = localIntent;
              paramAnonymousc = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousc);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, paramAnonymousc.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString.startActivity((Intent)paramAnonymousc.mt(0));
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
            if ((parambv.fvU()) || ((this.JVp != null) && (e.b.f(parambv, this.JVp.field_fileFullPath)))) {
              com.tencent.e.h.MqF.aM(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179946);
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                  com.tencent.mm.ui.base.h.d(e.b.1.this.KuD.Kkd.getContext(), e.b.1.this.KuD.Kkd.getContext().getString(2131759063), e.b.1.this.KuD.Kkd.getContext().getString(2131755906), new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                  });
                  AppMethodBeat.o(179946);
                }
              });
            } else {
              com.tencent.e.h.MqF.aM(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(179947);
                  com.tencent.mm.ui.base.h.c(e.b.1.this.KuD.Kkd.getContext(), e.b.1.this.KuD.Kkd.getMMResources().getString(2131757939), "", true);
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
      ((com.tencent.mm.i.g)localObject3).field_mediaId = com.tencent.mm.an.c.a("checkExist", bu.fpO(), paramString, parambv.field_msgId);
      ((com.tencent.mm.i.g)localObject3).field_fileId = ((k.b)localObject1).hCR;
      ((com.tencent.mm.i.g)localObject3).field_aesKey = ((k.b)localObject1).gmb;
      ((com.tencent.mm.i.g)localObject3).field_filemd5 = ((k.b)localObject1).filemd5;
      ((com.tencent.mm.i.g)localObject3).field_fileType = com.tencent.mm.i.a.fKC;
      ((com.tencent.mm.i.g)localObject3).field_talker = paramString;
      ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.fKA;
      ((com.tencent.mm.i.g)localObject3).field_svr_signature = "";
      ((com.tencent.mm.i.g)localObject3).field_onlycheckexist = true;
      bool = com.tencent.mm.an.f.aGZ().f((com.tencent.mm.i.g)localObject3);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.i.g)localObject3).field_fileId, ((com.tencent.mm.i.g)localObject3).field_mediaId, bu.aSM(((com.tencent.mm.i.g)localObject3).field_aesKey) });
      if (!bool) {
        a(parama, localIntent, parambv);
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
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, 16L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 4)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, 8L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 5)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, 32L);
        AppMethodBeat.o(36754);
        return bool;
      }
      if (paramb.type == 6)
      {
        paramb = com.tencent.mm.pluginsdk.e.a.aMB(paramb.hCD);
        if (paramb == null)
        {
          AppMethodBeat.o(36754);
          return false;
        }
        bool = com.tencent.mm.pluginsdk.model.app.h.s(paramContext, paramb.longValue());
        AppMethodBeat.o(36754);
        return bool;
      }
      AppMethodBeat.o(36754);
      return false;
    }
    
    private static boolean a(com.tencent.mm.ui.chatting.e.a parama, Intent paramIntent, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36757);
      if ((parambv.fvU()) || (f(parambv, null)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.h.d(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131759063), parama.Kkd.getContext().getString(2131755906), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(36757);
        return true;
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramIntent.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramIntent.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(36757);
      return false;
    }
    
    static boolean aYb(String paramString)
    {
      AppMethodBeat.i(36755);
      boolean bool = bu.aSQ(paramString);
      AppMethodBeat.o(36755);
      return bool;
    }
    
    public static boolean aYc(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(36759);
      Object localObject = com.tencent.mm.av.q.aIX().c(paramString, false, true);
      if (!com.tencent.mm.vfs.o.fB((String)localObject))
      {
        AppMethodBeat.o(36759);
        return false;
      }
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      localObject = com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject, paramString);
      if (paramString.outWidth * paramString.outHeight > 1048576)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", new Object[] { Integer.valueOf(paramString.outWidth), Integer.valueOf(paramString.outHeight) });
        bool = true;
      }
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      AppMethodBeat.o(36759);
      return bool;
    }
    
    public static boolean f(com.tencent.mm.storage.bv parambv, String paramString)
    {
      AppMethodBeat.i(36758);
      if ((System.currentTimeMillis() - parambv.field_createTime > 259200000L) && ((bu.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.o.fB(paramString))))
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
    public static int[] rNC = { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    private ArrayList<MMImageView> AlR;
    protected LinearLayout KvA;
    protected TextView KvB;
    protected ImageView KvC;
    protected MMPinProgressBtn KvD;
    protected ImageView KvE;
    protected ImageView KvF;
    protected ImageView KvG;
    protected ImageView KvH;
    protected TextView KvI;
    protected ChattingItemFooter KvJ;
    protected ImageView KvK;
    protected LinearLayout KvL;
    protected ViewGroup KvM;
    protected TextView KvN;
    protected LinearLayout KvO;
    protected RelativeLayout KvP;
    protected FrameLayout KvQ;
    protected LinearLayout KvR;
    protected LinearLayout KvS;
    protected ViewStub KvT;
    protected ImageView KvU;
    protected ImageView KvV;
    ImageView KvW;
    protected LinearLayout KvX;
    protected ImageView KvY;
    protected TextView KvZ;
    protected MMImageView Kvv;
    protected MMNeat7extView Kvw;
    protected ImageView Kvx;
    protected ImageView Kvy;
    protected TextView Kvz;
    LinearLayout KwA;
    LinearLayout KwB;
    ImageView KwC;
    TextView KwD;
    TextView KwE;
    ImageView KwF;
    RelativeLayout KwG;
    LinearLayout KwH;
    TextView KwI;
    public int KwJ;
    private int KwK;
    protected ImageView Kwa;
    protected TextView Kwb;
    protected TextView Kwc;
    protected LinearLayout Kwd;
    protected ImageView Kwe;
    protected ImageView Kwf;
    protected ImageView Kwg;
    protected TextView Kwh;
    protected LinearLayout Kwi;
    protected ImageView Kwj;
    LinearLayout Kwk;
    TextView Kwl;
    TextView Kwm;
    ImageView Kwn;
    ImageView Kwo;
    ImageView Kwp;
    TextView Kwq;
    ImageView Kwr;
    LinearLayout Kws;
    MMNeat7extView Kwt;
    ImageView Kwu;
    ImageView Kwv;
    ImageView Kww;
    TextView Kwx;
    TextView Kwy;
    TextView Kwz;
    protected TextView iFO;
    protected ImageView knv;
    protected TextView rLB;
    
    c()
    {
      AppMethodBeat.i(36762);
      this.KwJ = 0;
      this.KwK = 2147483647;
      this.AlR = new ArrayList();
      AppMethodBeat.o(36762);
    }
    
    private static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt, String paramString)
    {
      AppMethodBeat.i(187713);
      int i = 0;
      while (i <= 4)
      {
        localObject1 = (MMImageView)paramc.KvS.findViewById(rNC[i]);
        if (localObject1 != null)
        {
          ((MMImageView)localObject1).setImageDrawable(null);
          ((MMImageView)localObject1).setVisibility(8);
        }
        i += 1;
      }
      Object localObject1 = (ImageView)paramc.KvS.findViewById(2131298159);
      Object localObject2 = (TextView)paramc.KvS.findViewById(2131298153);
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
          localObject1 = (MMImageView)paramc.KvS.findViewById(rNC[i]);
          ((MMImageView)localObject1).setImageResource(2131689921);
          ((MMImageView)localObject1).setVisibility(0);
          localObject2 = com.tencent.mm.av.q.aIX().o("Note_" + paramArrayOfString1[i], "", "");
          localObject3 = new com.tencent.mm.av.a.a.c.a();
          ((com.tencent.mm.av.a.a.c.a)localObject3).ign = 1;
          ((com.tencent.mm.av.a.a.c.a)localObject3).igD = true;
          ((com.tencent.mm.av.a.a.c.a)localObject3).igy = 2131689920;
          ((com.tencent.mm.av.a.a.c.a)localObject3).hgF = ((int)parama.Kkd.getMMResources().getDimension(2131165216));
          ((com.tencent.mm.av.a.a.c.a)localObject3).hgG = ((int)parama.Kkd.getMMResources().getDimension(2131165216));
          localObject3 = ((com.tencent.mm.av.a.a.c.a)localObject3).aJu();
          if (!com.tencent.mm.vfs.o.fB((String)localObject2)) {
            break label326;
          }
          com.tencent.mm.av.q.aJb().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.av.a.a.c)localObject3);
        }
        label326:
        long l;
        String str1;
        String str2;
        String str3;
        do
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppMsgViewHolder", "note get thumb");
          i += 1;
          break;
          localObject1 = (MMImageView)paramc.KvS.findViewById(rNC[(i + 1)]);
          ((MMImageView)localObject1).setImageResource(2131689920);
          break label150;
          localObject1 = ao.fdT();
          localObject2 = (com.tencent.mm.pluginsdk.model.app.k.a)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class);
          localObject3 = paramArrayOfString1[i];
          l = bu.fpO();
          str1 = paramArrayOfString2[i];
          str2 = paramArrayOfString3[i];
          j = paramArrayOfInt[i];
          str3 = com.tencent.mm.av.q.aIX().o("Note_".concat(String.valueOf(localObject3)), "", "");
        } while (com.tencent.mm.vfs.o.fB(str3));
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.fLl = "task_AppMessageExtension_2";
        localg.field_mediaId = com.tencent.mm.an.c.a("downappthumb", l, paramString, String.valueOf(localObject3));
        localg.field_fullpath = str3;
        localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
        localg.field_totalLen = j;
        localg.field_aesKey = str1;
        localg.field_fileId = str2;
        localg.field_priority = com.tencent.mm.i.a.fKB;
        if (com.tencent.mm.model.x.wb(paramString)) {}
        for (int j = 1;; j = 0)
        {
          localg.field_chattype = j;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString });
          localg.fLm = new k.2((com.tencent.mm.pluginsdk.model.app.k)localObject1, (com.tencent.mm.pluginsdk.model.app.k.a)localObject2, str2);
          com.tencent.mm.an.f.aGZ().b(localg, -1);
          break;
        }
      }
      AppMethodBeat.o(187713);
    }
    
    @SuppressLint({"ResourceType"})
    public static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb)
    {
      AppMethodBeat.i(187714);
      parama = paramb.t(parama.Kkd.getContext(), false);
      if (!bu.isNullOrNil(parama))
      {
        paramc.KvA.setVisibility(0);
        paramc.rLB.setVisibility(0);
        paramc.Kvx.setVisibility(0);
        paramc.rLB.setText(parama);
        if (com.tencent.mm.ah.k.a.hCv.ordinal() == paramb.hFj)
        {
          paramc.Kvx.setImageResource(2131690913);
          AppMethodBeat.o(187714);
          return;
        }
        if (com.tencent.mm.ah.k.a.hCw.ordinal() == paramb.hFj) {
          com.tencent.mm.av.q.aJa().a(paramb.hFt, new r.a()
          {
            public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
            {
              AppMethodBeat.i(187712);
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(187711);
                  e.c.3.this.KwN.Kvx.setImageBitmap(paramAnonymousBitmap);
                  AppMethodBeat.o(187711);
                }
              });
              AppMethodBeat.o(187712);
            }
          });
        }
      }
      AppMethodBeat.o(187714);
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, com.tencent.mm.storage.bv parambv, boolean paramBoolean)
    {
      AppMethodBeat.i(36768);
      paramc.KvR.setVisibility(8);
      paramc.Kws.setVisibility(0);
      paramc.KwB.setVisibility(0);
      com.tencent.mm.ah.e locale;
      int i;
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        paramc.Kwt.setMaxLines(2);
        paramc.Kwt.setVisibility(0);
        paramc.Kwt.aq(paramb.getTitle());
        locale = (com.tencent.mm.ah.e)paramb.ao(com.tencent.mm.ah.e.class);
        if (locale == null) {
          break label464;
        }
        i = locale.duration;
        label99:
        String str = com.tencent.mm.ah.m.ol(i);
        if (bu.isNullOrNil(str)) {
          break label470;
        }
        paramc.Kwy.setVisibility(0);
        paramc.Kwy.setText(str);
      }
      for (;;)
      {
        paramc.Kww.setVisibility(0);
        if ((locale != null) && (com.tencent.mm.ah.x.om(locale.hBZ)))
        {
          paramc.Kwy.setVisibility(8);
          paramc.Kww.setVisibility(8);
        }
        af.a(parama.Kkd.getContext(), paramb, paramc.Kwv, paramc.Kwx);
        af.b(paramc.Kwz, paramb);
        paramc.KvC.setVisibility(4);
        i = com.tencent.mm.cb.a.ax(parama.Kkd.getContext(), 2131166038) - com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), 24);
        int j = i * 9 / 16;
        if (com.tencent.mm.cb.a.ef(parama.Kkd.getContext()) > 1.0F)
        {
          int k = (int)((paramc.KwJ / com.tencent.mm.cc.a.flw() - com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), 29) * com.tencent.mm.cb.a.ef(parama.Kkd.getContext())) * 9.0F / 16.0F);
          if (paramc.KwG.getLayoutParams().height != k)
          {
            paramc.KwG.getLayoutParams().height = k;
            paramc.KwG.requestLayout();
          }
        }
        if ((!paramBoolean) && (bu.isNullOrNil(paramb.thumburl))) {
          break label482;
        }
        parama = com.tencent.mm.api.b.t(paramb.thumburl, 4);
        paramb = new com.tencent.mm.av.a.a.c.a();
        paramb.igv = 2131100141;
        paramb.igj = true;
        paramb.hgD = com.tencent.mm.pluginsdk.model.r.aMY(parama);
        parambv = paramb.dh(i, j);
        parambv.ifZ = new com.tencent.mm.pluginsdk.ui.applet.n(4);
        parambv.igH = new com.tencent.mm.pluginsdk.ui.applet.e(4);
        parambv.igi = true;
        com.tencent.mm.av.q.aJb().a(parama, paramc.Kwu, paramb.aJu());
        AppMethodBeat.o(36768);
        return;
        paramc.Kwt.setVisibility(8);
        break;
        label464:
        i = 0;
        break label99;
        label470:
        paramc.Kwy.setVisibility(8);
      }
      label482:
      paramb = null;
      if (!e.b.aYc(parambv.field_imgPath)) {
        paramb = com.tencent.mm.av.q.aIX().a(parambv.field_imgPath, com.tencent.mm.cb.a.getDensity(parama.Kkd.getContext()), false);
      }
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        paramc.Kwu.setImageBitmap(paramb);
        AppMethodBeat.o(36768);
        return;
      }
      paramc.Kwu.setImageResource(2131100141);
      AppMethodBeat.o(36768);
    }
    
    static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(36767);
      paramc.Kvw.setVisibility(8);
      String str;
      Object localObject1;
      Object localObject3;
      label221:
      Object localObject2;
      int i;
      if ((paramb.title != null) && (paramb.title.trim().length() > 0))
      {
        str = paramb.title;
        paramc.KvB.setVisibility(0);
        paramc.KvB.setMaxLines(2);
        paramc.iFO.setMaxLines(4);
        paramc.KvH.setVisibility(8);
        paramc.KvC.setVisibility(4);
        if (paramBoolean) {
          paramc.Kvv.setVisibility(8);
        }
        localObject1 = new qi();
        ((qi)localObject1).dFS.type = 0;
        ((qi)localObject1).dFS.dFU = paramb.hDg;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject3 = ((qi)localObject1).dFT.dGd;
        if (localObject3 == null) {
          break label1041;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.KvB.getContext(), bu.bI(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.KvB.getTextSize());
        paramc.KvB.setText((CharSequence)localObject1);
        localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
        if (localObject1 != null) {
          break label514;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.hDg });
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 100) {
            localObject2 = ((String)localObject1).substring(0, 100);
          }
        }
        paramc.iFO.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramc.iFO.getContext(), bu.bI((String)localObject2, paramb.description), paramc.iFO.getTextSize()));
        paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).hFT.iterator();
        i = 0;
        localObject2 = null;
        localObject1 = null;
        label305:
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject3 = (ajx)paramb.next();
        } while ((com.tencent.mm.plugin.fav.ui.l.j((ajx)localObject3)) && (!bu.isNullOrNil(((ajx)localObject3).GAC)) && (((ajx)localObject3).GAC.equals("WeNoteHtmlFile")));
        if (((ajx)localObject3).GAu.GBb.GBE == null) {
          break label539;
        }
        str = parama.Kkd.getContext().getString(2131762236);
        i = 1;
        label390:
        switch (((ajx)localObject3).dataType)
        {
        }
      }
      for (;;)
      {
        break label305;
        paramc.KvB.setVisibility(8);
        str = null;
        break;
        label514:
        localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        break label221;
        label539:
        if (((ajx)localObject3).GAu.GBb.dzZ == null) {
          break label1038;
        }
        if (localObject1 == null)
        {
          localObject1 = ((ajx)localObject3).GAw;
          break label390;
        }
        if (localObject1 == ((ajx)localObject3).GAw) {
          break label1038;
        }
        localObject2 = ((ajx)localObject3).GAw;
        break label390;
        if (paramBoolean)
        {
          paramc.Kvv.setVisibility(0);
          paramc.Kvv.setImageResource(2131689583);
        }
        break label305;
        break label305;
        if (paramBoolean)
        {
          paramc.Kvv.setVisibility(0);
          paramc.Kvv.setImageResource(2131230944);
        }
        break label305;
        if (paramBoolean)
        {
          paramc.Kvv.setVisibility(0);
          paramc.Kvv.setImageResource(2131689584);
        }
        break label305;
        if ((paramBoolean) && (!com.tencent.mm.plugin.fav.a.b.cwn()))
        {
          paramc.Kvv.setVisibility(0);
          paramc.Kvv.setImageResource(2131690572);
          break label305;
          if (paramBoolean)
          {
            paramc.Kvv.setVisibility(0);
            paramc.Kvv.setImageResource(2131689581);
          }
          paramc.KvH.setVisibility(0);
          paramc.KvH.setImageResource(2131234464);
          break label305;
          paramc.Kvv.setVisibility(0);
          paramc.Kvv.setImageResource(2131689562);
          break label305;
          if (paramBoolean)
          {
            paramc.Kvv.setVisibility(0);
            paramc.Kvv.setImageResource(2131689564);
          }
          paramc.KvH.setVisibility(0);
          paramc.KvH.setImageResource(2131233395);
          break label305;
          if (paramBoolean)
          {
            paramc.Kvv.setVisibility(0);
            paramc.Kvv.setImageResource(com.tencent.mm.pluginsdk.f.aME(((ajx)localObject3).GzP));
          }
          break label305;
          if (paramBoolean)
          {
            paramc.Kvv.setVisibility(0);
            paramc.Kvv.setImageResource(2131689577);
          }
          break label305;
          if (paramBoolean)
          {
            paramc.Kvv.setVisibility(0);
            paramc.Kvv.setImageResource(2131231875);
          }
        }
      }
      if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
        paramb = parama.Kkd.getContext().getString(2131758964, new Object[] { localObject1 });
      }
      for (;;)
      {
        if (!bu.isNullOrNil(paramb))
        {
          paramc.KvB.setText(paramb);
          paramc.KvB.setVisibility(0);
        }
        paramc.Kvv.setVisibility(8);
        paramc.KvP.setVisibility(8);
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
                paramb = parama.Kkd.getContext().getString(2131758963, new Object[] { localObject1, localObject2 });
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
    
    public static void a(c paramc, Boolean paramBoolean, final com.tencent.mm.storage.bv parambv, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(36766);
      final long l = parambv.field_msgId;
      com.tencent.mm.pluginsdk.model.app.c localc = ao.bJV().CZ(l);
      if (localc == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
        AppMethodBeat.o(36766);
        return;
      }
      if (paramBoolean.booleanValue()) {
        if (localc.field_status == 101L)
        {
          paramc.KvG.setVisibility(0);
          paramc.KvD.setVisibility(0);
          paramc.KvE.setVisibility(0);
        }
      }
      for (;;)
      {
        if (parambv.field_status == 5)
        {
          paramc.KvG.setVisibility(8);
          paramc.KvF.setVisibility(8);
        }
        paramc.KvG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36760);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            if (this.KwL.booleanValue())
            {
              l = l;
              paramAnonymousView = parambv;
              localObject = ao.bJV().CZ(l);
              if (localObject == null) {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abr() + " getinfo failed: " + paramAnonymousView);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(36760);
                return;
                if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 101L)
                {
                  com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abr() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
                }
                else
                {
                  ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 102L;
                  ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = bu.aRi();
                  ao.bJV().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
                }
              }
            }
            long l = l;
            paramAnonymousView = parambv;
            localObject = ao.bJV().CZ(l);
            if (localObject == null) {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abr() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.hHv.setStatus(5);
              bc.aCg();
              com.tencent.mm.model.c.azI().ys(l);
              break;
              if (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status == 101L) {
                break label357;
              }
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abr() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
            }
            label357:
            if ((bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_clientAppDataId)) && (!bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject).field_mediaSvrId))) {}
            for (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 102L;; ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 105L)
            {
              ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = bu.aRi();
              ao.bJV().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
              break;
            }
          }
        });
        paramc.KvF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(36761);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            if (!this.KwL.booleanValue())
            {
              long l = l;
              paramAnonymousView = parambv;
              localObject = ao.bJV().CZ(l);
              if (localObject != null) {
                break label146;
              }
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abr() + " getinfo failed: " + paramAnonymousView);
            }
            for (;;)
            {
              this.hHv.setStatus(1);
              bc.aCg();
              com.tencent.mm.model.c.azI().ys(l);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(36761);
              return;
              label146:
              if ((((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 105L) && (((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status != 101L))
              {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.abr() + " get status failed: " + paramAnonymousView + " status:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status);
              }
              else
              {
                ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_status = 101L;
                ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_lastModifyTime = bu.aRi();
                ao.bJV().a((com.tencent.mm.pluginsdk.model.app.c)localObject, new String[0]);
                ao.fdW().run();
              }
            }
          }
        });
        AppMethodBeat.o(36766);
        return;
        if (localc.field_status == 102L)
        {
          paramc.KvG.setVisibility(8);
          paramc.KvD.setVisibility(8);
          paramc.KvE.setVisibility(8);
        }
        else
        {
          paramc.KvG.setVisibility(8);
          paramc.KvD.setVisibility(8);
          paramc.KvE.setVisibility(8);
          continue;
          if (localc.field_status == 101L)
          {
            paramc.KvG.setVisibility(0);
            paramc.KvF.setVisibility(8);
          }
          else if (localc.field_status == 105L)
          {
            paramc.KvG.setVisibility(8);
            paramc.KvF.setVisibility(0);
          }
          else
          {
            paramc.KvG.setVisibility(8);
            paramc.KvF.setVisibility(8);
          }
        }
      }
    }
    
    public static void a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(36765);
      int i = com.tencent.mm.pluginsdk.model.app.m.aNi(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        paramc.KvD.setVisibility(8);
        paramc.KvE.setVisibility(8);
        AppMethodBeat.o(36765);
        return;
      }
      paramc.KvD.setVisibility(0);
      paramc.KvE.setVisibility(0);
      paramc.KvD.setProgress(i);
      AppMethodBeat.o(36765);
    }
    
    static void b(com.tencent.mm.ui.chatting.e.a parama, c paramc, k.b paramb, com.tencent.mm.storage.bv parambv, boolean paramBoolean)
    {
      AppMethodBeat.i(36769);
      Object localObject1 = new qi();
      ((qi)localObject1).dFS.type = 0;
      ((qi)localObject1).dFS.dFU = paramb.hDg;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      Object localObject2 = ((qi)localObject1).dFT.dGd;
      paramc.KvP.setVisibility(8);
      String[] arrayOfString1 = new String[4];
      String[] arrayOfString2 = new String[4];
      int[] arrayOfInt = new int[4];
      Object localObject3 = new String[4];
      String[] arrayOfString4 = new String[4];
      Object localObject4 = new int[4];
      String[] arrayOfString3 = new String[4];
      int k;
      int i;
      ajx localajx;
      if (localObject2 != null)
      {
        localObject1 = null;
        paramb = bu.bI(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
        k = 0;
        Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject2).hFT.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localajx = (ajx)localIterator.next();
          if ((!com.tencent.mm.plugin.fav.ui.l.j(localajx)) || (bu.isNullOrNil(localajx.GAC)) || (!localajx.GAC.equals("WeNoteHtmlFile"))) {
            switch (localajx.dataType)
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
                str = localajx.desc;
              } while (bu.isNullOrNil(str));
              if (bu.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label1205;
              }
              localObject1 = localajx.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
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
          paramc.KvP.setVisibility(0);
          paramc.Kvv.setVisibility(0);
          paramc.Kvv.setImageResource(2131230944);
        }
        if (i < 4)
        {
          arrayOfString1[i] = localajx.hCS;
          arrayOfString2[i] = localajx.Gzw;
          arrayOfInt[i] = ((int)localajx.GAg);
          localObject3[i] = localajx.GzA;
          arrayOfString4[i] = localajx.GzC;
          localObject4[i] = ((int)localajx.GzV);
          arrayOfString3[i] = localajx.dua;
        }
        i += 1;
        break;
        if (!bu.isNullOrNil(paramb)) {
          break label248;
        }
        paramb = ak.getContext().getString(2131755773) + localajx.title;
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
          if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).hFT.size() == 2))
          {
            localObject2 = ak.getContext().getString(2131759034);
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
            localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.KvB.getContext(), (CharSequence)localObject1, (int)paramc.KvB.getTextSize());
            paramc.KvB.setText((CharSequence)localObject1);
            if ((paramb != null) && (paramb.length() > 100)) {
              paramb = paramb.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            for (;;)
            {
              for (;;)
              {
                localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(paramc.iFO.getContext(), paramb, (int)paramc.iFO.getTextSize());
                paramc.iFO.setText((CharSequence)localObject1);
                if (i > 0)
                {
                  paramc.KvP.setVisibility(8);
                  if ((j != 0) || (k == 0) || (bu.isNullOrNil(paramb)))
                  {
                    paramc.iFO.setVisibility(8);
                    paramc.KvB.setMaxLines(2);
                    paramc.KvU.setVisibility(8);
                    paramc.KvT.setLayoutResource(2131493469);
                  }
                  try
                  {
                    if (paramc.KvS == null) {
                      paramc.KvS = ((LinearLayout)paramc.KvT.inflate());
                    }
                    for (;;)
                    {
                      if (i <= 4) {
                        break label1162;
                      }
                      j = 4;
                      a(parama, paramc, j, arrayOfString3, arrayOfString2, arrayOfString1, arrayOfInt, parambv.field_talker);
                      parama = (ImageView)paramc.KvS.findViewById(2131298159);
                      paramc = (TextView)paramc.KvS.findViewById(2131298153);
                      if (paramc != null) {
                        paramc.setTextSize(0, ak.getContext().getResources().getDimensionPixelSize(2131165568));
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
                      localObject1 = ak.getContext().getString(2131759034);
                      j = 0;
                      break label616;
                      paramc.iFO.setMaxLines(1);
                      paramc.iFO.setVisibility(0);
                      paramc.KvB.setMaxLines(1);
                      break label791;
                      paramc.KvS.setVisibility(0);
                    }
                  }
                  catch (Exception paramb)
                  {
                    for (;;)
                    {
                      paramc.KvT.setVisibility(0);
                      continue;
                      j = i;
                    }
                  }
                }
              }
              paramc.KvT.setVisibility(8);
              paramc.KvU.setVisibility(0);
              AppMethodBeat.o(36769);
              return;
            }
          }
        }
      }
    }
    
    public final c D(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(36763);
      super.gs(paramView);
      this.Kwi = ((LinearLayout)paramView.findViewById(2131298017));
      this.Kvv = ((MMImageView)paramView.findViewById(2131298047));
      this.Kvw = ((MMNeat7extView)paramView.findViewById(2131298049));
      this.KvB = ((TextView)paramView.findViewById(2131298052));
      this.iFO = ((TextView)paramView.findViewById(2131298026));
      this.rLB = ((TextView)paramView.findViewById(2131298044));
      this.Kvx = ((ImageView)paramView.findViewById(2131298041));
      this.Kvz = ((TextView)paramView.findViewById(2131298043));
      this.Kvy = ((ImageView)paramView.findViewById(2131298042));
      this.KvA = ((LinearLayout)paramView.findViewById(2131298040));
      this.KvC = ((ImageView)paramView.findViewById(2131298045));
      this.KvD = ((MMPinProgressBtn)paramView.findViewById(2131298088));
      this.KvE = ((ImageView)this.uan.findViewById(2131298087));
      this.KvF = ((ImageView)this.uan.findViewById(2131298078));
      this.KvG = ((ImageView)this.uan.findViewById(2131298177));
      this.KvH = ((ImageView)paramView.findViewById(2131298028));
      this.KvI = ((TextView)paramView.findViewById(2131298023));
      this.KvK = ((ImageView)paramView.findViewById(2131298039));
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.hcH = paramView.findViewById(2131298147);
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      this.KvJ = ((ChattingItemFooter)paramView.findViewById(2131300196));
      this.KvL = ((LinearLayout)paramView.findViewById(2131296863));
      this.KvM = ((ViewGroup)paramView.findViewById(2131301542));
      this.KvN = ((TextView)paramView.findViewById(2131301539));
      this.KvO = ((LinearLayout)paramView.findViewById(2131298053));
      this.KvQ = ((FrameLayout)paramView.findViewById(2131298069));
      this.KvR = ((LinearLayout)paramView.findViewById(2131298024));
      this.KvV = ((ImageView)paramView.findViewById(2131298076));
      this.KvP = ((RelativeLayout)paramView.findViewById(2131298046));
      this.KvT = ((ViewStub)paramView.findViewById(2131302929));
      this.KvU = ((ImageView)paramView.findViewById(2131298081));
      if (!paramBoolean)
      {
        this.KvW = ((ImageView)this.uan.findViewById(2131298176));
        this.xvJ = ((ProgressBar)this.uan.findViewById(2131306220));
      }
      this.Kwd = ((LinearLayout)paramView.findViewById(2131298005));
      this.Kwa = ((ImageView)paramView.findViewById(2131298018));
      this.Kwb = ((TextView)paramView.findViewById(2131298020));
      this.Kwh = ((TextView)paramView.findViewById(2131298016));
      this.Kwg = ((ImageView)paramView.findViewById(2131299519));
      this.Kwe = ((ImageView)paramView.findViewById(2131298006));
      this.Kwf = ((ImageView)paramView.findViewById(2131307172));
      this.KvX = ((LinearLayout)paramView.findViewById(2131298004));
      this.KvY = ((ImageView)paramView.findViewById(2131297979));
      this.KvZ = ((TextView)paramView.findViewById(2131297980));
      this.Kwc = ((TextView)paramView.findViewById(2131298019));
      this.knv = ((ImageView)paramView.findViewById(2131297981));
      this.Kwj = ((ImageView)paramView.findViewById(2131297984));
      this.Kwk = ((LinearLayout)paramView.findViewById(2131298009));
      this.Kwl = ((TextView)paramView.findViewById(2131298015));
      this.Kwm = ((TextView)paramView.findViewById(2131298011));
      this.Kwn = ((ImageView)paramView.findViewById(2131298012));
      this.Kwo = ((ImageView)paramView.findViewById(2131298010));
      this.Kwp = ((ImageView)paramView.findViewById(2131298013));
      this.Kwq = ((TextView)paramView.findViewById(2131298014));
      this.Kwr = ((ImageView)paramView.findViewById(2131298008));
      this.Kws = ((LinearLayout)paramView.findViewById(2131298030));
      this.Kww = ((ImageView)paramView.findViewById(2131298034));
      this.Kwt = ((MMNeat7extView)paramView.findViewById(2131298035));
      this.Kwu = ((ImageView)paramView.findViewById(2131298033));
      this.KwA = ((LinearLayout)paramView.findViewById(2131302491));
      this.KwB = ((LinearLayout)paramView.findViewById(2131302493));
      this.KwF = ((ImageView)paramView.findViewById(2131302492));
      this.KwG = ((RelativeLayout)paramView.findViewById(2131298031));
      this.KwC = ((ImageView)this.KwA.findViewById(2131298027));
      this.KwD = ((TextView)this.KwA.findViewById(2131298029));
      this.KwE = ((TextView)this.KwA.findViewById(2131298038));
      this.Kwv = ((ImageView)this.KwB.findViewById(2131298027));
      this.Kwx = ((TextView)this.KwB.findViewById(2131298029));
      this.Kwz = ((TextView)this.KwB.findViewById(2131298038));
      this.Kwy = ((TextView)paramView.findViewById(2131298032));
      this.KwH = ((LinearLayout)paramView.findViewById(2131298050));
      this.KwI = ((TextView)paramView.findViewById(2131298051));
      if ((this.KvB != null) && (Build.VERSION.SDK_INT >= 16)) {
        this.KwK = this.KvB.getMaxLines();
      }
      this.KwJ = c.kt(ak.getContext());
      AppMethodBeat.o(36763);
      return this;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(36764);
      if (this.KvB != null) {
        this.KvB.setMaxLines(this.KwK);
      }
      AppMethodBeat.o(36764);
    }
  }
  
  public static final class d
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    protected t.i KwP;
    protected t.l KwQ;
    protected t.j KwR;
    private boolean rCw;
    
    public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36799);
      if ((com.tencent.mm.r.a.ch(parama.Kkd.getContext())) || (com.tencent.mm.r.a.cf(parama.Kkd.getContext())) || (com.tencent.mm.r.a.cj(parama.Kkd.getContext())))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        AppMethodBeat.o(36799);
        return true;
      }
      if (paramc.a(parama, paramb, parambv))
      {
        AppMethodBeat.o(36799);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.hCB, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.Kkd.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambv.field_msgId, parambv.field_msgSvrId, parambv);
        AppMethodBeat.o(36799);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(161905);
      Object localObject = w.Lim;
      w.fPe();
      if ((bu.isNullOrNil(paramb.hFd)) && (bu.isNullOrNil(paramb.hFc)))
      {
        parambv = paramb.url;
        if (parama.fJC()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.Q(parambv, paramc);
          parambv = new Intent();
          parambv.putExtra("rawUrl", paramc);
          parambv.putExtra("webpageTitle", paramb.title);
          parambv.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
          AppMethodBeat.o(161905);
          return true;
        }
      }
      localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambv);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.fJC()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.h.H(parambv));
        ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(parama.Kkd.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambv), parama.fJC(), paramb, localBundle);
        AppMethodBeat.o(161905);
        return true;
        if (com.tencent.mm.model.x.Ao((String)localObject)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean c(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36800);
      Object localObject1 = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
      if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.ah.a)localObject1).hBg)) && (!bu.isNullOrNil(((com.tencent.mm.ah.a)localObject1).hBi)))
      {
        String str2 = ((com.tencent.mm.ah.a)localObject1).hBg;
        String str3 = ((com.tencent.mm.ah.a)localObject1).hBf;
        String str1;
        int i;
        if (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject1).hBj))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ah.a)localObject1).hBh;
          paramb = paramb.hFd;
          localObject1 = ((com.tencent.mm.ah.a)localObject1).hBi;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { str2, str3, str1, str4, paramb, localObject1 });
          Object localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
          if (!com.tencent.mm.model.x.wb(parama.getTalkerUserName())) {
            break label308;
          }
          i = 2;
          label155:
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(17608, new Object[] { Integer.valueOf(i), paramb, Integer.valueOf(1), Integer.valueOf(1) });
          if (bu.isNullOrNil(str2)) {
            break label314;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_chatting_wording", str1);
          ((Bundle)localObject2).putString("key_chatting_text", str4);
          ((Bundle)localObject2).putString("key_chatting_appid", paramb);
          ((Bundle)localObject2).putLong("key_msg_id", parambv.field_msgId);
          ((Bundle)localObject2).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject2).putString("key_sender_username", paramc.b(parama, parambv));
          e.a(parama, str2, str3, (String)localObject1, (Bundle)localObject2);
        }
        for (;;)
        {
          AppMethodBeat.o(36800);
          return true;
          str1 = ((com.tencent.mm.ah.a)localObject1).hBj;
          break;
          label308:
          i = 1;
          break label155;
          label314:
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingItemAppMsgFrom", "hy: video msg invalid!!");
        }
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingItemAppMsgFrom", "hy: no remote url provided. treat as default");
      AppMethodBeat.o(36800);
      return false;
    }
    
    public static boolean d(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36801);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.hFc, paramb.hFb, paramb.hFd, paramb.url, Integer.valueOf(paramb.hFr), paramb.hFf });
      if ((44 == paramb.type) && ((!paramb.ex(false)) || (bu.isNullOrNil(paramb.t(parama.Kkd.getContext(), false)))))
      {
        AppMethodBeat.o(36801);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambv);
      paramc = new Bundle();
      int i;
      if ((parama.Kkd instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        paramc.putInt("stat_scene", i);
        paramc.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
        paramc.putString("stat_chat_talker_username", (String)localObject);
        paramc.putString("stat_send_msg_user", str);
        switch (paramb.hFe)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cv(parambv);
        if (i != 0) {
          break label582;
        }
        AppMethodBeat.o(36801);
        return true;
        if (parama.fJC())
        {
          i = 2;
          break;
        }
        if (com.tencent.mm.model.x.Ao((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_username", paramb.hFc);
        if (parama.fJC())
        {
          localIntent.putExtra("key_from_scene", 1);
          localIntent.putExtra("key_scene_note", (String)localObject + ":" + str);
        }
        for (;;)
        {
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.hFd;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).jLV = paramb.hFr;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.hFg;
          localIntent.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bfb());
          localIntent.putExtra("_stat_obj", paramc);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "appbrand", ".ui.AppBrandProfileUI", localIntent);
          i = 0;
          break;
          localIntent.putExtra("key_from_scene", 2);
          localIntent.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.Kkd instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.al.h.H(parambv))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1157, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.model.x.Ao((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, paramc);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.fJC(), paramb, paramc);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.fJC(), paramb, paramc);
          i = 0;
        }
      }
      label582:
      AppMethodBeat.o(36801);
      return false;
    }
    
    public static boolean e(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(169872);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bu.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambv.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambv.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.plugin.websearch.api.ae localae = (com.tencent.mm.plugin.websearch.api.ae)paramb.ao(com.tencent.mm.plugin.websearch.api.ae.class);
        if ((localae != null) && (!bu.isNullOrNil(localae.DTD)))
        {
          paramb = new egh();
          paramb.DTD = localae.DTD;
          paramb.DTE = localae.DTE;
          paramb.DTF = localae.DTF;
          paramb.DTG = localae.DTG;
          paramb.DTH = localae.DTH;
          paramb.DTL = localae.DTL;
          paramb.qlv = localae.qlv;
          paramb.qlw = localae.qlw;
          paramb.uly = localae.uly;
          paramb.DTI = localae.DTI;
          paramb.DTJ = localae.DTJ;
          paramb.DTK = localae.DTK;
          paramb.source = localae.source;
          paramb.dJL = localae.dJL;
          paramb.DTM = localae.DTM;
          paramb.DTO = localae.DTO;
          paramb.DTP = localae.DTP;
          paramb.DTQ = localae.DTQ;
          paramb.DTN = localae.DTN;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.Kkd.getContext().getString(2131759717));
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambv);
          com.tencent.mm.plugin.websearch.api.ad.a(parama.Kkd.getContext(), paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject2 = paramb.url;
        Object localObject1;
        PackageInfo localPackageInfo;
        Intent localIntent;
        int j;
        if (parama.fJC())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject2, (String)localObject1);
          String str = paramb.url;
          localPackageInfo = c.getPackageInfo(parama.Kkd.getContext(), paramb.appId);
          localIntent = new Intent();
          j = parama.Kkd.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xy((String)localObject2))
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
          if (bu.isNullOrNil(str)) {
            break label1239;
          }
          localIntent.putExtra("shortUrl", str);
          label625:
          if (localPackageInfo != null) {
            break label1254;
          }
          localObject2 = null;
          label633:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1264;
          }
          i = 0;
          label652:
          localIntent.putExtra("version_code", i);
          if (!bu.isNullOrNil(paramb.dIt))
          {
            localIntent.putExtra("srcUsername", paramb.dIt);
            localIntent.putExtra("srcDisplayname", paramb.dIu);
          }
          localIntent.putExtra("msg_id", parambv.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambv.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambv));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambv.fmw);
          i = com.tencent.mm.model.y.aH(paramc.b(parama, parambv), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambv.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambv));
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
            paramc = (com.tencent.mm.ah.e)paramb.ao(com.tencent.mm.ah.e.class);
            if (paramc == null) {
              break;
            }
          }
        }
        for (int i = paramc.hBV;; i = -1)
        {
          localIntent.putExtra(e.m.Jpz, i);
          localIntent.addFlags(536870912);
          if ((paramc == null) || (i != 5) || (paramc.hBX != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe())) {
            break label1298;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.JoV, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.JoW, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          if ((localae != null) && (!bu.isNullOrNil(localae.DTD)))
          {
            paramc = com.tencent.mm.plugin.webview.ui.tools.video.a.EHX;
            com.tencent.mm.plugin.webview.ui.tools.video.a.aKS(localae.DTD);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.Kkd.getContext(), parambv.field_msgId, parambv.field_msgSvrId, 0, paramb);
          AppMethodBeat.o(169872);
          return true;
          localObject1 = "singlemessage";
          break;
          label1239:
          localIntent.putExtra("shortUrl", paramb.url);
          break label625;
          label1254:
          localObject2 = localPackageInfo.versionName;
          break label633;
          label1264:
          i = localPackageInfo.versionCode;
          break label652;
          i = 2;
          break label951;
          i = 3;
          break label951;
          i = 5;
          break label951;
        }
        label1298:
        com.tencent.mm.al.l.b(parambv, paramb);
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.Kkd.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(169872);
        return true;
      }
      AppMethodBeat.o(169872);
      return false;
    }
    
    private t.i j(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36791);
      if (this.KwP == null) {
        this.KwP = new t.i(parama);
      }
      parama = this.KwP;
      AppMethodBeat.o(36791);
      return parama;
    }
    
    private t.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36792);
      if (this.KwQ == null) {
        this.KwQ = new t.l(parama);
      }
      parama = this.KwQ;
      AppMethodBeat.o(36792);
      return parama;
    }
    
    private t.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36793);
      if (this.KwR == null) {
        this.KwR = new t.j(parama);
      }
      parama = this.KwR;
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
        ((View)localObject).setTag(new e.c().D((View)localObject, true));
      }
      AppMethodBeat.o(36794);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bv parambv, String paramString)
    {
      AppMethodBeat.i(36795);
      final e.c localc = (e.c)parama;
      this.JWz = parama1;
      localc.reset();
      String str = parambv.getContent();
      Object localObject1 = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bH(parambv);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bI(parambv);
      ((com.tencent.mm.ui.chatting.d.b.m)localObject1).bJ(parambv);
      int i;
      if (this.rCw)
      {
        i = parambv.getContent().indexOf(':');
        if (i != -1) {
          str = parambv.getContent().substring(i + 1);
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
          localb = k.b.aB(str, parambv.Wc());
          localObject3 = com.tencent.mm.ah.t.zg(str);
          localObject1 = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
          i = 0;
          k = 0;
          localc.KwH.setVisibility(8);
          localObject2 = localObject1;
          if (localb != null)
          {
            localc.Kvw.aq(localb.getTitle());
            localc.iFO.setText(localb.getDescription());
            localc.KvB.setMaxLines(1);
            localc.Kvw.setTextColor(parama1.getContext().getResources().getColor(2131099732));
            localc.iFO.setTextColor(parama1.getContext().getResources().getColor(2131100482));
            localc.KvR.setBackgroundResource(2131231607);
            localc.KvR.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
            localc.Kvv.setVisibility(0);
            localc.KvP.setVisibility(0);
            localc.iFO.setVisibility(0);
            localc.KvD.setVisibility(8);
            localc.KvG.setVisibility(8);
            localc.KvF.setVisibility(8);
            localc.KvT.setVisibility(8);
            localc.KvU.setVisibility(8);
            localc.Kvy.setVisibility(8);
            localc.Kvz.setVisibility(8);
            localc.Kwd.setVisibility(8);
            localc.KvX.setVisibility(8);
            localc.KvR.setVisibility(0);
            localc.Kwk.setVisibility(8);
            localc.Kws.setVisibility(8);
            localc.KwA.setVisibility(8);
            localc.KwF.setVisibility(8);
            e.c.aI(localc.KvQ, localc.KwJ);
            localb.ao(com.tencent.mm.ah.h.class);
            localc.KvQ.setBackgroundResource(2131231607);
            localg = com.tencent.mm.pluginsdk.model.app.h.gg(localb.appId, localb.aDD);
            if (localg != null) {
              b(parama1, localb, parambv);
            }
            if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
              break label1697;
            }
            localObject2 = localb.appName;
            bool1 = true;
            com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 12);
            if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
              bool1 = o.a.fcK().dSj();
            }
            if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!fD((String)localObject2))) {
              break label1737;
            }
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), localg, (String)localObject2);
            if (localb.type != 19) {
              break label1707;
            }
            localc.rLB.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject2 }));
            label679:
            localc.rLB.setVisibility(0);
            localc.rLB.setCompoundDrawables(null, null, null, null);
            localc.KvA.setVisibility(0);
            localc.Kvx.setVisibility(0);
            if ((localg == null) || (!localg.Ee())) {
              break label1720;
            }
            a(parama1, localc.rLB, parambv, localb, localg.field_packageName, parambv.VY());
            label754:
            localc.Kvx.setImageResource(2131231697);
            a(parama1, localc.Kvx, localb.appId);
            i = 1;
          }
        }
        for (;;)
        {
          label782:
          if (localb.azq()) {
            localc.KvA.setVisibility(8);
          }
          label1025:
          label3719:
          label4232:
          label6027:
          for (int j = 0;; j = i)
          {
            localc.KvA.setBackgroundResource(2131233299);
            bool1 = false;
            localc.Kvv.setVisibility(0);
            if ((!localb.azr()) && (this.oZq))
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
                      if (!e.b.aYc(parambv.Wb())) {
                        localObject2 = com.tencent.mm.av.q.aIX().e(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                      }
                    }
                  }
                }
              }
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localBitmap = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject2, false, com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 1));
                localc.Kvv.setImageBitmap(localBitmap);
                label975:
                if (localb.type != 3) {
                  break label1932;
                }
                localc.KvR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  private boolean KwS = false;
                  
                  public final boolean onPreDraw()
                  {
                    AppMethodBeat.i(36771);
                    if (this.KwS)
                    {
                      localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                    localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.KwS = true;
                    int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Kkd.getContext(), 24);
                    Bitmap localBitmap = this.val$bitmap;
                    Object localObject;
                    if (localBitmap != null)
                    {
                      localObject = localBitmap;
                      if (!localBitmap.isRecycled()) {}
                    }
                    else
                    {
                      localObject = com.tencent.mm.sdk.platformtools.h.aK(parama1.Kkd.getContext().getResources().getColor(2131100129), i, i);
                    }
                    int j = ((Bitmap)localObject).getHeight();
                    if (i > j) {
                      i = j;
                    }
                    for (;;)
                    {
                      localObject = com.tencent.mm.sdk.platformtools.h.l(com.tencent.mm.sdk.platformtools.h.aE(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                      j = localc.KvR.getHeight();
                      int k = localc.KvR.getWidth();
                      i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166036);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166037);
                      }
                      localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.b((Bitmap)localObject, 2131231553, j, i));
                      localc.KvR.setBackgroundDrawable((Drawable)localObject);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                  }
                });
                if (!com.tencent.mm.ui.al.isDarkMode()) {
                  break label1921;
                }
                localc.KvA.setBackgroundResource(2131233299);
                if ((localb.fmn != null) && (localb.fmn.length() != 0)) {
                  break label1959;
                }
                localc.KvI.setVisibility(8);
                label1054:
                localc.KvH.setOnClickListener(null);
                localc.KvL.setVisibility(0);
                localc.KvC.setVisibility(8);
                localc.KvO.setVisibility(0);
                localc.KvM.setVisibility(8);
                i = localb.type;
                if (localb.type == 66)
                {
                  if ((TextUtils.isEmpty(localb.hFc)) && (TextUtils.isEmpty(localb.hFd))) {
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
                  localc.KvB.setVisibility(0);
                  localc.KvB.setMaxLines(2);
                  localc.KvB.setText(localb.title);
                  localc.Kvw.setVisibility(8);
                  if (bool1)
                  {
                    if ((localb.type != 33) && (localb.type != 36)) {
                      break label7305;
                    }
                    paramString = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
                    localc.Kvv.setImageResource(2131689584);
                    com.tencent.mm.modelappbrand.a.b.aEl().a(localc.Kvv, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(50, 50));
                  }
                  if (localb.type == 44) {
                    e.c.a(parama1, localc, localb);
                  }
                }
                if (parama1.fJC()) {
                  break label7482;
                }
                if (!com.tencent.mm.pluginsdk.model.app.h.k(localg)) {
                  break label7466;
                }
                localc.KvK.setVisibility(0);
                c(parama1, localc.KvK, bk.a(localb, parambv));
                localObject2 = parama;
                if (i == 0)
                {
                  localc.KvQ.setTag(localObject2);
                  localc.KvQ.setOnClickListener(d(parama1));
                }
                if (this.oZq)
                {
                  localc.KvQ.setOnLongClickListener(c(parama1));
                  localc.KvQ.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
                }
                AppMethodBeat.o(36795);
                return;
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambv.VX()), paramString });
                localObject3 = null;
                localb = null;
                break;
                localObject2 = localg.field_appName;
                break label547;
                localc.rLB.setText((CharSequence)localObject2);
                break label679;
                a(parama1, localc.rLB, localb.appId);
                break label754;
                if (localb.type == 24)
                {
                  localc.rLB.setText(ak.getContext().getString(2131758845));
                  localc.KvA.setVisibility(0);
                  localc.rLB.setVisibility(0);
                  localc.Kvx.setVisibility(8);
                  i = 1;
                  break label782;
                }
                if ((localb.type == 19) || (((com.tencent.mm.ah.t)localObject3).hGb == 19))
                {
                  localc.rLB.setText(ak.getContext().getString(2131757208));
                  localc.KvA.setVisibility(0);
                  localc.rLB.setVisibility(0);
                  localc.Kvx.setVisibility(8);
                  i = 1;
                  break label782;
                }
                if (e.a(localb, localc)) {
                  break label7522;
                }
                localc.KvA.setVisibility(8);
                localc.rLB.setVisibility(8);
                localc.Kvx.setVisibility(8);
                i = 0;
                break label782;
                bool1 = true;
                break label975;
                localc.KvA.setBackgroundResource(2131231682);
                break label1025;
                localc.Kvv.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                bool1 = false;
                break label1025;
                localc.KvI.setVisibility(0);
                b(parama1, localc.KvI, bk.aYj(localb.fmn));
                break label1054;
                i = 5;
                break label1144;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Kvw.setVisibility(0);
                  localc.Kvw.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.iFO.setVisibility(0);
                  localc.iFO.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                  localc.KvB.setVisibility(8);
                  localc.KvC.setVisibility(4);
                  localc.KvH.setVisibility(0);
                  if (!parambv.VX().equals(parama.KuN)) {
                    break label2286;
                  }
                  localc.KvH.setImageResource(2131233393);
                  localc.iFO.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label2300;
                    }
                    localc.Kvv.setImageResource(2131689564);
                  }
                }
                for (;;)
                {
                  parama = new e.g();
                  parama.msgId = parambv.VX();
                  parama.dCX = parambv.getContent();
                  parama.dzD = parambv.Wb();
                  localc.KvH.setTag(parama);
                  localc.KvH.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGx());
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Kvw.setVisibility(8);
                  break label2044;
                  localc.KvH.setImageResource(2131233395);
                  break label2141;
                  localc.Kvv.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Kvw.setVisibility(0);
                  localc.Kvw.setMaxLines(2);
                }
                for (;;)
                {
                  localc.iFO.setVisibility(0);
                  localc.KvB.setVisibility(8);
                  localc.KvH.setVisibility(8);
                  localc.KvC.setVisibility(4);
                  localc.iFO.setMaxLines(2);
                  localc.iFO.setText(bu.sL(localb.hCC));
                  e.c.a(localc, str, localb.hCC);
                  e.c.a(localc, Boolean.TRUE, parambv, localb.dlu, localb.title);
                  if (!bool1) {
                    break label7498;
                  }
                  if (!e.b.aYb(localb.hCD)) {
                    break label2497;
                  }
                  localc.Kvv.setImageResource(2131231063);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Kvw.setVisibility(8);
                }
                localc.Kvv.setImageResource(com.tencent.mm.pluginsdk.model.q.aMX(localb.hCD));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                continue;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Kvw.setVisibility(0);
                  localc.iFO.setVisibility(0);
                  localc.KvB.setVisibility(8);
                  localc.KvH.setVisibility(0);
                  localc.KvH.setImageResource(2131234464);
                  localc.KvC.setVisibility(4);
                  localc.iFO.setMaxLines(2);
                  if (!bool1) {
                    break label7498;
                  }
                  paramString = new com.tencent.mm.av.a.a.c.a();
                  paramString.pK(2131689584).aJr().dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50)).aJp().aJs().an(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1));
                  localObject2 = com.tencent.mm.av.q.aJb();
                  if (!bu.isNullOrNil(localb.thumburl)) {
                    break label2745;
                  }
                }
                for (parama = localb.hCJ;; parama = localb.thumburl)
                {
                  ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.Kvv, paramString.aJu());
                  localc.KvH.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.Kvw.setVisibility(8);
                  break label2553;
                }
                if (localb != null) {
                  e.a(paramString, parama1, parambv, localb);
                }
                parama = (com.tencent.mm.ah.e)localb.ao(com.tencent.mm.ah.e.class);
                if ((parama != null) && (parama.hBX == 1) && (parama.hBV == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe()))
                {
                  e.c.a(parama1, localc, localb, parambv, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                }
                else
                {
                  if ((j == 0) && (af.a(localb, parama)))
                  {
                    localc.KwA.setVisibility(0);
                    localc.KwF.setVisibility(0);
                    af.a(parama1.getContext(), localb, localc.KwC, localc.KwD);
                    af.b(localc.KwE, localb);
                  }
                  localc.Kvw.setVisibility(8);
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.KvB.setMaxLines(2);
                    localc.KvB.setVisibility(0);
                    localc.KvB.setText(localb.getTitle());
                    localc.iFO.setMaxLines(3);
                    if (!e.l(localb)) {
                      break label3160;
                    }
                    localc.KvH.setVisibility(0);
                    localc.KvH.setImageResource(2131234464);
                    localc.KvC.setVisibility(4);
                    if (!bool1) {
                      break label7498;
                    }
                    paramString = new com.tencent.mm.av.a.a.c.a();
                    paramString.pK(2131689584).aJr().Gh(com.tencent.mm.plugin.image.d.dfL()).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50)).aJp().aJs().an(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1));
                    localObject2 = com.tencent.mm.av.q.aJb();
                    if (!bu.isNullOrNil(localb.thumburl)) {
                      break label3173;
                    }
                  }
                  for (parama = localb.hCJ;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.Kvv, paramString.aJu());
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    localc.KvB.setVisibility(8);
                    break label2963;
                    localc.KvH.setVisibility(8);
                    break label3000;
                  }
                  if (localc.KvQ.getLayoutParams() != null)
                  {
                    localc.KvQ.getLayoutParams().width = -2;
                    localc.KvQ.requestLayout();
                  }
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(localb.hFc);
                  final boolean bool2;
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label3530;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.KvR.setVisibility(8);
                    localc.Kwd.setVisibility(0);
                    localc.KvX.setVisibility(8);
                    localc.Kwk.setVisibility(8);
                    if (!e.a(parambv, localb, parama1)) {
                      break label3540;
                    }
                    localc.KwH.setVisibility(0);
                    bool2 = bu.isNullOrNil(parambv.Wg());
                    localc.KwH.setTag(parambv);
                    localc.KwH.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(179950);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.bd(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                        e.a((com.tencent.mm.storage.bv)paramAnonymousView.getTag(), localc, parama1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(179950);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    localc.Kwh.setText(localb.title);
                    e.f(localc.Kwh, localb.title);
                    localc.Kwb.setText(parama);
                    e.a(localc.Kwc, localb);
                    com.tencent.mm.av.q.aJb().a(paramString, localc.Kwa, ac.d.fQP);
                    parama = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
                    localc.Kwe.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.aEl().a(localc.Kwe, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
                    if (!e.a(localb, (WxaAttributes)localObject2)) {
                      break label3553;
                    }
                    localc.knv.setVisibility(0);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    parama = localb.dIu;
                    break label3246;
                    paramString = localb.hFt;
                    break label3258;
                    localc.KwH.setVisibility(8);
                  }
                  localc.knv.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  continue;
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(localb.hFc);
                  ((s)com.tencent.mm.kernel.g.ab(s.class)).Mt(localb.hFc);
                  switch (localb.hFe)
                  {
                  default: 
                    paramInt = 1;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                  case 2: 
                  case 3: 
                    if (localc.KvQ.getLayoutParams() != null)
                    {
                      localc.KvQ.getLayoutParams().width = -2;
                      localc.KvQ.requestLayout();
                    }
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4008;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.KvR.setVisibility(8);
                      localc.Kwd.setVisibility(0);
                      localc.KvX.setVisibility(8);
                      localc.Kwk.setVisibility(8);
                      localc.Kwh.setText(localb.title);
                      e.f(localc.Kwh, localb.title);
                      localc.Kwb.setText(parama);
                      e.a(localc.Kwc, localb);
                      com.tencent.mm.av.q.aJb().a(paramString, localc.Kwa, ac.d.fQP);
                      parama = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
                      localc.Kwe.setImageBitmap(null);
                      localc.Kwe.setVisibility(4);
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4018;
                      }
                      localc.knv.setVisibility(0);
                      if (!e.a(parambv, localb, parama1)) {
                        break label4031;
                      }
                      localc.KwH.setVisibility(0);
                      bool2 = bu.isNullOrNil(parambv.Wg());
                      localc.KwH.setTag(parambv);
                      localc.KwH.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymousView)
                        {
                          AppMethodBeat.i(185027);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.bd(paramAnonymousView);
                          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                          e.a((com.tencent.mm.storage.bv)paramAnonymousView.getTag(), localc, parama1);
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(185027);
                        }
                      });
                      e.a(bool2, localc, parama1);
                    }
                    for (;;)
                    {
                      bool2 = e.m(localb);
                      com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
                      {
                        public final String BN()
                        {
                          AppMethodBeat.i(36781);
                          String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                          AppMethodBeat.o(36781);
                          return str;
                        }
                        
                        public final void F(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36779);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.Kwe.setImageBitmap(paramAnonymousBitmap);
                            localc.Kwe.setVisibility(0);
                            localc.Kwg.setVisibility(4);
                            if (bool2)
                            {
                              localc.Kwf.setImageDrawable(com.tencent.mm.cb.a.l(parama1.Kkd.getContext(), 2131691166));
                              localc.Kwf.setVisibility(0);
                              AppMethodBeat.o(36779);
                              return;
                            }
                            localc.Kwf.setVisibility(8);
                            AppMethodBeat.o(36779);
                            return;
                          }
                          localc.Kwe.setVisibility(4);
                          localc.Kwg.setVisibility(0);
                          localc.Kwf.setVisibility(8);
                          AppMethodBeat.o(36779);
                        }
                        
                        public final void aEt()
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
                      parama = localb.dIu;
                      break label3707;
                      paramString = localb.hFt;
                      break label3719;
                      localc.knv.setVisibility(8);
                      break label3868;
                      localc.KwH.setVisibility(8);
                    }
                  case 1: 
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4203;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.KvR.setVisibility(8);
                      localc.Kwd.setVisibility(8);
                      localc.KvX.setVisibility(0);
                      localc.KvZ.setText(parama);
                      localc.Kwk.setVisibility(8);
                      if (!bu.isNullOrNil(paramString)) {
                        break label4209;
                      }
                      parama = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
                      com.tencent.mm.modelappbrand.a.b.aEl().a(localc.KvY, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
                    }
                    for (;;)
                    {
                      if (!e.a(localb, (WxaAttributes)localObject2)) {
                        break label4232;
                      }
                      localc.Kwj.setVisibility(0);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.title;
                      break label4055;
                      paramString = null;
                      break label4067;
                      com.tencent.mm.modelappbrand.a.b.aEl().a(localc.KvY, paramString, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
                    }
                    localc.Kwj.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                  case 0: 
                    localc.KvA.setVisibility(0);
                    localc.Kvx.setVisibility(0);
                    localc.Kvx.setBackground(null);
                    localc.Kvx.setImageResource(2131689681);
                    e.a(localc.rLB, localb);
                    break label1356;
                    parama = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
                    paramString = localb.hFt;
                    localObject2 = localb.dIu;
                    str = localb.title;
                    localObject3 = localb.description;
                    if ((parama == null) || (bu.isNullOrNil(parama.hBg)) || (bu.isNullOrNil(parama.hBi)))
                    {
                      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                      break label1356;
                    }
                    localc.Kwq.setText((CharSequence)localObject2);
                    localc.KvR.setVisibility(8);
                    localc.Kwd.setVisibility(8);
                    localc.KvX.setVisibility(8);
                    localc.Kwr.setVisibility(0);
                    localc.Kwn.setVisibility(8);
                    localc.Kwr.setImageDrawable(com.tencent.mm.cb.a.l(parama1.getContext(), 2131691166));
                    localc.Kwk.setVisibility(0);
                    localc.Kwl.setText(str);
                    localc.Kwm.setText((CharSequence)localObject3);
                    com.tencent.mm.av.q.aJa().a(paramString, new r.a()
                    {
                      public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                      {
                        AppMethodBeat.i(36783);
                        ar.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(36782);
                            if (!paramAnonymousBitmap.isRecycled()) {
                              e.d.7.this.KwN.Kwp.setImageBitmap(paramAnonymousBitmap);
                            }
                            AppMethodBeat.o(36782);
                          }
                        });
                        AppMethodBeat.o(36783);
                      }
                    });
                    paramString = com.tencent.mm.modelappbrand.a.b.aEl().a(parama.hBi, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hNl));
                    if (paramString != null)
                    {
                      localc.Kwo.setImageBitmap(paramString);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                    }
                    else
                    {
                      com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
                      {
                        public final String BN()
                        {
                          AppMethodBeat.i(36786);
                          String str = "CHAT#" + com.tencent.mm.plugin.appbrand.y.n.cH(this);
                          AppMethodBeat.o(36786);
                          return str;
                        }
                        
                        public final void F(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36785);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.Kwo.setImageBitmap(paramAnonymousBitmap);
                            localc.Kwo.setVisibility(0);
                          }
                          AppMethodBeat.o(36785);
                        }
                        
                        public final void aEt()
                        {
                          AppMethodBeat.i(36784);
                          localc.Kwo.setVisibility(4);
                          AppMethodBeat.o(36784);
                        }
                        
                        public final void ox()
                        {
                          AppMethodBeat.i(185028);
                          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                          com.tencent.mm.plugin.report.service.g.yxI.dD(808, 2);
                          AppMethodBeat.o(185028);
                        }
                      }, parama.hBi, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hNl));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      paramInt = 1;
                      localc.KvB.setMaxLines(2);
                      localc.iFO.setMaxLines(3);
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.Kvw.setVisibility(8);
                      if ((localb.title != null) && (localb.title.trim().length() > 0))
                      {
                        localc.KvB.setMaxLines(2);
                        localc.KvB.setVisibility(0);
                        localc.KvB.setText(localb.getTitle());
                      }
                      for (;;)
                      {
                        localc.iFO.setMaxLines(3);
                        localc.KvH.setVisibility(8);
                        localc.KvC.setVisibility(4);
                        if (!bool1) {
                          break label7498;
                        }
                        parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label4811;
                        }
                        localc.Kvv.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        localc.KvB.setVisibility(8);
                      }
                      localc.Kvv.setImageBitmap(parama);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.KvB.setVisibility(0);
                      if (localb.hDb == 1) {
                        localc.KvB.setText(2131762858);
                      }
                      for (;;)
                      {
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.Kvw.setVisibility(0);
                          localc.Kvw.aq(localb.getTitle());
                        }
                        localc.iFO.setMaxLines(4);
                        localc.KvC.setVisibility(4);
                        localc.KvH.setVisibility(8);
                        if (!bool1) {
                          break label7498;
                        }
                        parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                        if ((parama == null) || (parama.isRecycled())) {
                          break label5047;
                        }
                        localc.Kvv.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        if (localb.hDb == 2) {
                          localc.KvB.setText(2131762860);
                        } else if (localb.hDb == 3) {
                          localc.KvB.setText(2131762859);
                        } else {
                          localc.KvB.setText(2131762861);
                        }
                      }
                      localc.Kvv.setImageResource(2131689584);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.Kvw.setVisibility(0);
                      localc.Kvw.aq(localb.getTitle());
                      localc.KvB.setVisibility(0);
                      localc.KvB.setText(2131757247);
                      localc.iFO.setMaxLines(4);
                      localc.KvC.setVisibility(4);
                      localc.KvH.setVisibility(8);
                      if (!bool1) {
                        break label7498;
                      }
                      parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                      if ((parama != null) && (!parama.isRecycled()))
                      {
                        localc.Kvv.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                      }
                      else
                      {
                        localc.Kvv.setImageResource(2131689584);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.Kvw.setVisibility(0);
                          localc.Kvw.aq(localb.getTitle());
                          localc.KvB.setVisibility(8);
                        }
                        localc.iFO.setMaxLines(4);
                        localc.KvC.setVisibility(4);
                        localc.KvH.setVisibility(8);
                        if (!bool1) {
                          break label7498;
                        }
                        parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          localc.Kvv.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                        }
                        else
                        {
                          localc.Kvv.setImageResource(2131689584);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                          continue;
                          if ((localb.title != null) && (localb.title.length() > 0)) {
                            localc.Kvw.setVisibility(0);
                          }
                          for (;;)
                          {
                            localc.iFO.setVisibility(0);
                            localc.KvB.setVisibility(8);
                            localc.KvH.setVisibility(8);
                            localc.KvC.setVisibility(4);
                            localc.iFO.setMaxLines(2);
                            if (!bool1) {
                              break label7498;
                            }
                            parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                            if ((parama != null) && (!parama.isRecycled())) {
                              break label5523;
                            }
                            localc.Kvv.setImageResource(2131689584);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = k;
                            break;
                            localc.Kvw.setVisibility(8);
                          }
                          localc.Kvv.setImageBitmap(parama);
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
                localc.Kvw.setVisibility(0);
                localc.iFO.setVisibility(0);
                localc.KvB.setVisibility(8);
                localc.KvH.setVisibility(8);
                localc.KvC.setVisibility(4);
                localc.iFO.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5757;
                  }
                  localc.Kvv.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                parama = new bk(parambv, false, paramInt, "", false, localb.title, localb.dIt, localb.dIu, localb.title, localb.hDj, localb.url, false, false);
                localc.KvQ.setTag(parama);
                localc.KvQ.setOnClickListener(i(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.Kvw.setVisibility(8);
                break label5572;
                localc.Kvv.setImageBitmap(parama);
              }
            case 25: 
              label2286:
              label2553:
              label3707:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Kvw.setVisibility(0);
                localc.iFO.setVisibility(0);
                localc.KvB.setVisibility(8);
                localc.KvH.setVisibility(8);
                localc.KvC.setVisibility(4);
                localc.iFO.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5987;
                  }
                  localc.Kvv.setImageResource(2131689584);
                }
              }
              for (;;)
              {
                label4203:
                label4209:
                parama = new bk(parambv, paramInt, "", parama1.fGT(), localb.dIt, localb.dIu, localb.title, localb.hEP, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.KvQ.setTag(parama);
                localc.KvQ.setOnClickListener(j(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.Kvw.setVisibility(8);
                break label5797;
                localc.Kvv.setImageBitmap(parama);
              }
            case 26: 
            case 27: 
              label1144:
              label2044:
              label5757:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Kvw.setVisibility(0);
                localc.iFO.setVisibility(0);
                localc.KvB.setVisibility(8);
                localc.KvH.setVisibility(8);
                localc.KvC.setVisibility(4);
                localc.iFO.setMaxLines(2);
                if (bool1)
                {
                  parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6298;
                  }
                  localc.Kvv.setImageResource(2131689584);
                }
                parama = new bk();
                parama.dCi = parambv;
                parama.JSi = false;
                parama.position = paramInt;
                parama.KDO = false;
                parama.title = parama1.fGT();
                parama.dIt = localb.dIt;
                parama.dIu = localb.dIu;
                parama.KDP = localb.title;
                if (localb.type != 26) {
                  break label6310;
                }
                parama.tid = localb.tid;
                parama.hEQ = localb.hEQ;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.KvQ.setOnClickListener(k(parama1));
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
              localc.KvQ.setTag(parama);
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
              localc.Kvw.setVisibility(8);
              label3868:
              label4008:
              break label6027;
              label5523:
              label5797:
              localc.Kvv.setImageBitmap(parama);
              label6298:
              break label6121;
              label6310:
              if (localb.type == 27)
              {
                parama.tid = localb.tid;
                parama.hEQ = localb.hEQ;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.KvQ.setOnClickListener(l(parama1));
                paramInt = 1;
                continue;
                localc.Kvw.setVisibility(0);
                localc.Kvw.aq(localb.description);
                localc.iFO.setText(localb.hDP);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.KvB.setVisibility(0);
                  localc.KvB.setText(localb.title);
                }
                for (;;)
                {
                  localc.iFO.setMaxLines(4);
                  localc.KvC.setVisibility(4);
                  localc.KvH.setVisibility(8);
                  if (!bool1) {
                    break label7498;
                  }
                  parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6559;
                  }
                  localc.Kvv.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.KvB.setVisibility(8);
                }
                localc.Kvv.setImageResource(2131689584);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                localc.Kvw.setVisibility(8);
                localc.KvB.setVisibility(0);
                if ((localb.title != null) && (localb.title.trim().length() > 0)) {
                  localc.KvB.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.KvB.getContext(), localb.title, localc.KvB.getTextSize()));
                }
                for (;;)
                {
                  localc.iFO.setMaxLines(3);
                  localc.KvH.setVisibility(8);
                  localc.KvC.setVisibility(4);
                  if (bool1)
                  {
                    localc.Kvv.setVisibility(8);
                    localc.KvP.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, parambv, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.KvB.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.KvB.getContext(), ak.getContext().getString(2131759034), localc.KvB.getTextSize()));
                }
                e.c.a(parama1, localc, localb, bool1);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Kvw.setVisibility(0);
                  if (!bu.isNullOrNil(localb.titleColor))
                  {
                    localc.Kvw.setTextColor(bu.cN(localb.titleColor, parama1.getContext().getResources().getColor(2131100711)));
                    label6861:
                    localc.iFO.setMaxLines(2);
                    localc.iFO.setVisibility(0);
                    if (bu.isNullOrNil(localb.hDY)) {
                      break label7157;
                    }
                    localc.iFO.setTextColor(bu.cN(localb.hDY, parama1.getContext().getResources().getColor(2131100469)));
                    localc.KvB.setVisibility(8);
                    localc.KvC.setVisibility(4);
                    localc.KvH.setVisibility(8);
                    localc.KvA.setVisibility(0);
                    localc.rLB.setVisibility(0);
                    if (bu.isNullOrNil(localb.hDU)) {
                      break label7181;
                    }
                    localc.rLB.setText(localb.hDU);
                  }
                }
                for (;;)
                {
                  if (this.oZq)
                  {
                    parama = com.tencent.mm.av.q.aIX().e(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = com.tencent.mm.sdk.platformtools.h.a(parama, false, parama.getWidth() / 2);
                      localc.Kvv.setImageBitmap(paramString);
                    }
                    if (!bu.isNullOrNil(localb.hDX))
                    {
                      com.tencent.mm.av.q.aJb().a(localb.hDX, new ImageView(parama1.getContext()), new com.tencent.mm.av.a.a.c.a().aJq().aJu(), new com.tencent.mm.av.a.c.h()
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
                            localc.KvR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36787);
                                e.d.9.this.KwN.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.d.9.this.KwN.KvR.getHeight();
                                int k = e.d.9.this.KwN.KvR.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cb.a.ax(e.d.9.this.KuD.Kkd.getContext(), 2131166036);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cb.a.ax(e.d.9.this.KuD.Kkd.getContext(), 2131166037);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.b(paramAnonymousString, 2131231553, j, i));
                                e.d.9.this.KwN.KvR.setBackgroundDrawable(localBitmapDrawable);
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
                      localc.Kvw.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label6861;
                      localc.Kvw.setVisibility(8);
                      break label6861;
                      label7157:
                      localc.iFO.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                      break label6919;
                      localc.rLB.setText(2131757206);
                      continue;
                    }
                    localc.KvR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean KwS = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36789);
                        if (this.KwS)
                        {
                          localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                        localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.KwS = true;
                        int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Kkd.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = com.tencent.mm.sdk.platformtools.h.aK(parama1.Kkd.getContext().getResources().getColor(2131100129), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = com.tencent.mm.sdk.platformtools.h.l(com.tencent.mm.sdk.platformtools.h.aE(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                          j = localc.KvR.getHeight();
                          int k = localc.KvR.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166036);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166037);
                          }
                          localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.b((Bitmap)localObject, 2131231553, j, i));
                          localc.KvR.setBackgroundDrawable((Drawable)localObject);
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
                localc.Kvv.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if (((com.tencent.mm.ah.t)localObject3).hGb == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  label7292:
                  localc.KvB.setVisibility(8);
                  break label1419;
                  localObject1 = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = com.tencent.mm.av.q.aIX().e(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.Kvv.setImageBitmap(paramString);
                    break label1521;
                  }
                  if (!bu.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.av.a.a.c.a();
                    ((com.tencent.mm.av.a.a.c.a)localObject1).pK(2131100141).aJr().aJp();
                    com.tencent.mm.av.q.aJb().a(paramString, localc.Kwu, ((com.tencent.mm.av.a.a.c.a)localObject1).aJu());
                    break label1521;
                  }
                  localc.Kvv.setImageResource(2131231063);
                  break label1521;
                  label7466:
                  localc.KvK.setVisibility(8);
                  localObject2 = parama;
                  break label1582;
                  label7482:
                  localc.KvK.setVisibility(8);
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
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bv parambv)
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
        if (!ac.bm(parambv))
        {
          com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131766957), "", parama.Kkd.getContext().getString(2131766205), null);
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = bn.E(parambv);
        if (bu.isNullOrNil(paramMenuItem)) {
          e.b.a(parama, parambv, b(parama, parambv));
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36790);
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
              paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
              paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
              com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
              AppMethodBeat.o(36790);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(36772);
              e.b.a(parama, parambv, e.d.this.b(parama, parambv));
              com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(36772);
            }
          });
        }
      case 114: 
        paramMenuItem = parambv.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = k.b.zb(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          am.a(parambv, bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.d(parambv, parama.Kkd.getContext());
          continue;
          am.b(parambv, bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.a(parambv, parama.Kkd.getContext(), b(parama, parambv), parama.fJC());
          continue;
          am.o(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.c(parambv, bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.c(parambv, parama.Kkd.getContext());
        }
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Chat_Msg_Id", parambv.field_msgId);
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      AppMethodBeat.o(36797);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(187716);
      int i = ((bk)paramView.getTag()).position;
      int j = com.tencent.mm.pluginsdk.model.app.m.aNi(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
      k.b localb = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.aW(parambv)))
      {
        if (localb.type != 6) {
          break label626;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.m.aNj(localb.dlu);
        if (((localc == null) || (!e.b.f(parambv, localc.field_fileFullPath))) && (!parambv.fvU())) {
          paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
        }
      }
      boolean bool1;
      if ((localb.hCC <= 0) || ((localb.hCC > 0) && (j >= 100))) {
        switch (localb.type)
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        label275:
        if ((bool1) && (!this.JWz.fJD())) {
          paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.br.d.aJN("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Ee()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new ec();
          ((ec)localObject).dql.msgId = parambv.field_msgId;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((ec)localObject).dqm.dpK) || (e.b.a(this.JWz.Kkd.getContext(), localb))) {
            paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
          }
          if (bn.z(parambv)) {
            paraml.clear();
          }
          if (!this.JWz.fJD()) {
            paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
          }
          if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bv.fpT())) {
            paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
          }
          AppMethodBeat.o(187716);
          return true;
          label626:
          paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
          break;
          bool1 = com.tencent.mm.al.g.aFZ();
          break label275;
          bool1 = com.tencent.mm.al.g.aFT();
          break label275;
          boolean bool2 = com.tencent.mm.al.g.aFX();
          bool1 = bool2;
          if (bu.aSQ(localb.hCD)) {
            break label275;
          }
          paraml.a(i, 150, this.JWz.Kkd.getMMResources().getString(2131757229), 2131691578);
          bool1 = bool2;
          break label275;
          bool1 = com.tencent.mm.al.g.aFQ();
          break label275;
          bool1 = com.tencent.mm.al.g.aFP();
          break label275;
          bool1 = com.tencent.mm.al.g.aFV();
          break label275;
          bool1 = com.tencent.mm.al.g.aFR();
          break label275;
          if ((localb.hDQ != 5) && (localb.hDQ != 6) && (localb.hDQ != 2)) {
            break label910;
          }
          if ((localb.hDQ != 2) || (bn.z(parambv))) {
            paraml.clear();
          }
          paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(187716);
          return false;
          paraml.clear();
          paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(187716);
          return false;
          paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        label910:
        bool1 = false;
      }
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36798);
      com.tencent.mm.modelstat.a.a(parambv, com.tencent.mm.modelstat.a.a.iqQ);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      Object localObject = parambv.field_content;
      paramView = Boolean.FALSE;
      if (localObject == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      final k.b localb = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      localObject = com.tencent.mm.ah.t.zg((String)localObject);
      if (localb == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      if (((com.tencent.mm.ah.t)localObject).hGb != 0)
      {
        paramView = Boolean.TRUE;
        localb.type = ((com.tencent.mm.ah.t)localObject).hGb;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false);
      final String str = d(parama, parambv);
      if (localObject != null) {
        a(parama, localb, str, (com.tencent.mm.pluginsdk.model.app.g)localObject, parambv.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (localb.type)
      {
      }
      do
      {
        for (;;)
        {
          i = 1;
          do
          {
            while ((i != 0) && (e(localb, parama, this, parambv)))
            {
              AppMethodBeat.o(36798);
              return true;
              com.tencent.mm.plugin.report.service.g.yxI.f(13043, new Object[] { Integer.valueOf(2), localb.description, localb.appId });
              com.tencent.mm.al.l.b(parambv, localb);
              boolean bool = a(localb, parama, this, parambv);
              AppMethodBeat.o(36798);
              return bool;
              if (!this.oZq)
              {
                com.tencent.mm.ui.base.t.g(parama.Kkd.getContext(), parama.Kkd.getContentView());
                AppMethodBeat.o(36798);
                return true;
              }
              paramView = new Intent();
              paramView.setClassName(parama.Kkd.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramView.putExtra("scene", 2);
              paramView.putExtra("app_msg_id", parambv.field_msgId);
              paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
              com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              parama.startActivity((Intent)paramView.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(36798);
              return true;
              if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).Ee()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
              {
                AppMethodBeat.o(36798);
                return true;
              }
              if ((localb.dlu == null) || (localb.dlu.length() == 0)) {
                ((com.tencent.mm.ui.chatting.d.b.b)parama.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a(parambv, new com.tencent.mm.pluginsdk.model.app.al()
                {
                  public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
                  {
                    AppMethodBeat.i(187715);
                    if (this.nTS != null)
                    {
                      if (paramAnonymousBoolean1)
                      {
                        e.d.a(parama, localb, str, this.nTS, parambv.field_msgSvrId, 3, parama.getTalkerUserName());
                        AppMethodBeat.o(187715);
                        return;
                      }
                      e.d.a(parama, localb, str, this.nTS, parambv.field_msgSvrId, 7, parama.getTalkerUserName());
                    }
                    AppMethodBeat.o(187715);
                  }
                });
              }
              for (;;)
              {
                AppMethodBeat.o(36798);
                return true;
                if (!this.oZq)
                {
                  com.tencent.mm.ui.base.t.g(parama.Kkd.getContext(), parama.Kkd.getContentView());
                  AppMethodBeat.o(36798);
                  return true;
                }
                paramView = new Intent();
                paramView.setClassName(parama.Kkd.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                paramView.putExtra("app_msg_id", parambv.field_msgId);
                paramView.putExtra("scene", 2);
                parama.Kkd.startActivityForResult(paramView, 210);
              }
              if (bu.isNullOrNil(localb.hDc))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_Product_xml", localb.hDc);
              paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
              if (parambv.field_imgPath == null) {
                paramView.putExtra("key_ProductUI_chatting_msgId", parambv.field_msgId);
              }
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "scanner", ".ui.ProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bu.isNullOrNil(localb.hDf))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_TV_xml", localb.hDf);
              paramView.putExtra("key_TV_getProductInfoScene", 1);
              if (parambv.field_imgPath == null) {
                paramView.putExtra("key_TVInfoUI_chatting_msgId", parambv.field_msgId);
              }
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "shake", ".ui.TVInfoUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (bu.isNullOrNil(localb.hDi))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_product_info", localb.hDi);
              paramView.putExtra("key_product_scene", 1);
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "product", ".ui.MallProductUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              localObject = new Intent();
              ((Intent)localObject).putExtra("message_id", parambv.field_msgId);
              ((Intent)localObject).putExtra("record_xml", localb.hDg);
              ((Intent)localObject).putExtra("big_appmsg", paramView);
              i = com.tencent.mm.model.y.aH(b(parama, parambv), parama.getTalkerUserName());
              ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambv.field_msgSvrId));
              ((Intent)localObject).putExtra("preUsername", b(parama, parambv));
              ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
              ((Intent)localObject).putExtra("preChatTYPE", i);
              e.a.a((Intent)localObject, parama, parambv, this);
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
              AppMethodBeat.o(36798);
              return true;
              if (bu.isNullOrNil(localb.dxN))
              {
                AppMethodBeat.o(36798);
                return false;
              }
              paramView = new Intent();
              paramView.setFlags(65536);
              paramView.putExtra("key_card_app_msg", localb.dxN);
              paramView.putExtra("key_from_scene", localb.hDQ);
              com.tencent.mm.br.d.b(parama.Kkd.getContext(), "card", ".ui.CardDetailUI", paramView);
              AppMethodBeat.o(36798);
              return true;
              if (d(localb, parama, this, parambv))
              {
                com.tencent.mm.al.l.b(parambv, localb);
                AppMethodBeat.o(36798);
                return true;
              }
              i = 1;
            }
          } while (c(localb, parama, this, parambv));
        }
        b(localb, parama, this, parambv);
        com.tencent.mm.al.l.b(parambv, localb);
        AppMethodBeat.o(36798);
        return true;
        e.a(localb, parama, parambv);
        AppMethodBeat.o(36798);
        return true;
        paramView = new Intent();
        paramView.putExtra("key_from_user_name", b(parama, parambv));
        paramView.putExtra("key_biz_uin", localb.hDS);
        paramView.putExtra("key_order_id", localb.hDT);
        if ((parambv.field_talker != null) && (!parambv.field_talker.equals("")) && (com.tencent.mm.model.x.wb(parambv.field_talker))) {
          paramView.putExtra("key_chatroom_name", parambv.field_talker);
        }
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
        AppMethodBeat.o(36798);
        return true;
      } while (!e.a(localb, parama));
      AppMethodBeat.o(36798);
      return true;
      AppMethodBeat.o(36798);
      return false;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class e
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    protected t.i KwP;
    protected t.l KwQ;
    protected t.j KwR;
    
    private static void a(e.c paramc, com.tencent.mm.ui.chatting.d.b.k paramk, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36827);
      if ((parambv.field_status == 2) && (b(paramk, parambv.field_msgId)))
      {
        if (paramc.KvW != null)
        {
          paramc.KvW.setVisibility(0);
          AppMethodBeat.o(36827);
        }
      }
      else if (paramc.KvW != null) {
        paramc.KvW.setVisibility(8);
      }
      AppMethodBeat.o(36827);
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(161906);
      if ((bu.isNullOrNil(paramb.hFd)) && (bu.isNullOrNil(paramb.hFc)))
      {
        parambv = paramb.url;
        if (parama.fJC()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.q.Q(parambv, paramc);
          parambv = new Intent();
          parambv.putExtra("rawUrl", paramc);
          parambv.putExtra("webpageTitle", paramb.title);
          parambv.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
          AppMethodBeat.o(161906);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.b(parama, parambv);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.fJC()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.h.H(parambv));
        ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(parama.Kkd.getContext(), parama.getTalkerUserName(), paramc.b(parama, parambv), parama.fJC(), paramb, localBundle);
        AppMethodBeat.o(161906);
        return true;
        if (com.tencent.mm.model.x.Ao(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean f(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36831);
      if (paramc.a(parama, paramb, parambv))
      {
        AppMethodBeat.o(36831);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.q.Q(paramb.hCB, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.Kkd.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, parambv.field_msgId, parambv.field_msgSvrId, parambv);
        AppMethodBeat.o(36831);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean g(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36832);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.hFc, paramb.hFb, paramb.hFd, paramb.url, Integer.valueOf(paramb.hFr), paramb.hFf });
      if ((44 == paramb.type) && ((!paramb.ex(false)) || (bu.isNullOrNil(paramb.t(parama.Kkd.getContext(), false)))))
      {
        AppMethodBeat.o(36832);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.b(parama, parambv);
      Bundle localBundle = new Bundle();
      int i;
      if ((parama.Kkd instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.al.h.H(parambv));
        switch (paramb.hFe)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.cv(parambv);
        if (i != 0) {
          break label577;
        }
        AppMethodBeat.o(36832);
        return true;
        if (parama.fJC())
        {
          i = 2;
          break;
        }
        if (com.tencent.mm.model.x.Ao((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramc = new Intent();
        paramc.putExtra("key_username", paramb.hFc);
        if (parama.fJC())
        {
          paramc.putExtra("key_from_scene", 1);
          paramc.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + str);
        }
        for (;;)
        {
          paramc.putExtra("_stat_obj", localBundle);
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.hFd;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).jLV = paramb.hFr;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.hFg;
          paramc.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).bfb());
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramc);
          i = 0;
          break;
          paramc.putExtra("key_from_scene", 2);
          paramc.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.Kkd instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1073, paramb, localBundle);
          i = 0;
        }
        else if (com.tencent.mm.model.x.Ao((String)localObject))
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, 1074, paramb, localBundle);
          i = 0;
        }
        else
        {
          com.tencent.mm.modelappbrand.a.a((String)localObject, str, parama.fJC(), paramb, localBundle);
          i = 0;
          continue;
          com.tencent.mm.modelappbrand.a.b((String)localObject, str, parama.fJC(), paramb, localBundle);
          i = 0;
        }
      }
      label577:
      AppMethodBeat.o(36832);
      return false;
    }
    
    public static boolean h(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36833);
      Object localObject2 = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
      if ((localObject2 != null) && (!bu.isNullOrNil(((com.tencent.mm.ah.a)localObject2).hBg)) && (!bu.isNullOrNil(((com.tencent.mm.ah.a)localObject2).hBi)))
      {
        String str2 = ((com.tencent.mm.ah.a)localObject2).hBg;
        String str3 = ((com.tencent.mm.ah.a)localObject2).hBf;
        Object localObject1 = ((com.tencent.mm.ah.a)localObject2).dJw;
        String str1;
        int i;
        if (bu.isNullOrNil(((com.tencent.mm.ah.a)localObject2).hBj))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.ah.a)localObject2).hBh;
          String str5 = paramb.hFd;
          localObject2 = ((com.tencent.mm.ah.a)localObject2).hBi;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { str2, str3, str1, str4, str5, localObject2 });
          com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
          if (!com.tencent.mm.model.x.wb(parama.getTalkerUserName())) {
            break label364;
          }
          i = 2;
          label165:
          localg.f(17608, new Object[] { Integer.valueOf(i), str5, Integer.valueOf(1), Integer.valueOf(1) });
          if ((bu.isNullOrNil(str2)) && ((bu.isNullOrNil(str3)) || (!com.tencent.mm.vfs.o.fB(str3)) || (!bu.nullAsNil(com.tencent.mm.vfs.o.aRh(str3)).equals(localObject1)))) {
            break label370;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_chatting_type", paramb.type);
          ((Bundle)localObject1).putString("key_chatting_wording", str1);
          ((Bundle)localObject1).putString("key_chatting_text", str4);
          ((Bundle)localObject1).putString("key_chatting_appid", str5);
          ((Bundle)localObject1).putLong("key_msg_id", parambv.field_msgId);
          ((Bundle)localObject1).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject1).putString("key_sender_username", paramc.b(parama, parambv));
          e.a(parama, str2, str3, (String)localObject2, (Bundle)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(36833);
          return false;
          str1 = ((com.tencent.mm.ah.a)localObject2).hBj;
          break;
          label364:
          i = 1;
          break label165;
          label370:
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
        }
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
      com.tencent.mm.ui.base.t.makeText(parama.Kkd.getContext(), parama.Kkd.getMMResources().getString(2131755886), 0).show();
      AppMethodBeat.o(36833);
      return true;
    }
    
    public static boolean i(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      int j = 0;
      AppMethodBeat.i(36834);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!bu.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", parambv.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", parambv.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject1 = (com.tencent.mm.plugin.websearch.api.ae)paramb.ao(com.tencent.mm.plugin.websearch.api.ae.class);
        if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTD)))
        {
          paramb = new egh();
          paramb.DTD = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTD;
          paramb.DTE = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTE;
          paramb.DTF = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTF;
          paramb.DTG = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTG;
          paramb.DTH = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTH;
          paramb.DTL = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTL;
          paramb.qlv = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).qlv;
          paramb.qlw = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).qlw;
          paramb.uly = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).uly;
          paramb.DTI = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTI;
          paramb.DTJ = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTJ;
          paramb.DTK = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTK;
          paramb.source = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).source;
          paramb.dJL = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).dJL;
          paramb.DTM = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTM;
          paramb.DTO = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTO;
          paramb.DTP = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTP;
          paramb.DTQ = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTQ;
          paramb.DTN = ((com.tencent.mm.plugin.websearch.api.ae)localObject1).DTN;
          paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.Kkd.getContext().getString(2131759717));
          com.tencent.mm.plugin.websearch.api.ad.a(parama.Kkd.getContext(), paramc);
          com.tencent.mm.plugin.topstory.a.i.a(paramb, parambv);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject2 = paramb.url;
        Intent localIntent;
        label551:
        label559:
        int i;
        if (parama.fJC())
        {
          localObject1 = "groupmessage";
          Object localObject3 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject2, (String)localObject1);
          localObject1 = paramb.url;
          localObject2 = c.getPackageInfo(parama.Kkd.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject3);
          localIntent.putExtra("webpageTitle", paramb.title);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId))))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("jsapi_args_appid", paramb.appId);
            localIntent.putExtra("jsapiargs", (Bundle)localObject3);
          }
          if (bu.isNullOrNil((String)localObject1)) {
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
          if (!bu.isNullOrNil(paramb.dIt))
          {
            localIntent.putExtra("srcUsername", paramb.dIt);
            localIntent.putExtra("srcDisplayname", paramb.dIu);
          }
          localIntent.putExtra("msg_id", parambv.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambv.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambv));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", parambv.fmw);
          int k = com.tencent.mm.model.y.aH(paramc.b(parama, parambv), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambv.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambv));
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
          com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
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
      if (this.KwP == null) {
        this.KwP = new t.i(parama);
      }
      parama = this.KwP;
      AppMethodBeat.o(36822);
      return parama;
    }
    
    public static boolean j(k.b paramb, com.tencent.mm.ui.chatting.e.a parama, c paramc, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(169873);
      if (!bu.isNullOrNil(paramb.canvasPageXml))
      {
        paramc = new Intent();
        paramc.putExtra("sns_landig_pages_from_source", 5);
        paramc.putExtra("msg_id", parambv.field_msgId);
        paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
        paramc.putExtra("sns_landing_pages_share_thumb_url", parambv.field_imgPath);
        paramc.addFlags(268435456);
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
        AppMethodBeat.o(169873);
        return true;
      }
      com.tencent.mm.plugin.websearch.api.ae localae = (com.tencent.mm.plugin.websearch.api.ae)paramb.ao(com.tencent.mm.plugin.websearch.api.ae.class);
      if ((localae != null) && (!bu.isNullOrNil(localae.DTD)))
      {
        paramb = new egh();
        paramb.DTD = localae.DTD;
        paramb.DTE = localae.DTE;
        paramb.DTF = localae.DTF;
        paramb.DTG = localae.DTG;
        paramb.DTH = localae.DTH;
        paramb.DTL = localae.DTL;
        paramb.qlv = localae.qlv;
        paramb.qlw = localae.qlw;
        paramb.uly = localae.uly;
        paramb.DTI = localae.DTI;
        paramb.DTJ = localae.DTJ;
        paramb.DTK = localae.DTK;
        paramb.source = localae.source;
        paramb.dJL = localae.dJL;
        paramb.DTM = localae.DTM;
        paramb.DTO = localae.DTO;
        paramb.DTP = localae.DTP;
        paramb.DTQ = localae.DTQ;
        paramb.DTN = localae.DTN;
        paramc = com.tencent.mm.plugin.topstory.a.h.a(paramb, 32, parama.Kkd.getContext().getString(2131759717));
        com.tencent.mm.plugin.websearch.api.ad.a(parama.Kkd.getContext(), paramc);
        com.tencent.mm.plugin.topstory.a.i.a(paramb, parambv);
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
        if (parama.fJC())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject2, (String)localObject1);
          String str = paramb.hCB;
          j = parama.Kkd.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).Xy((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).d((String)localObject2, 1, j, i);
          }
          localPackageInfo = c.getPackageInfo(parama.Kkd.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_snsad_statextstr", paramb.dIA);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId)))) {
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
          }
          localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          if (bu.isNullOrNil(str)) {
            break label1226;
          }
          localIntent.putExtra("shortUrl", str);
          label637:
          if (localPackageInfo != null) {
            break label1241;
          }
          localObject2 = null;
          label645:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1251;
          }
          i = 0;
          label664:
          localIntent.putExtra("version_code", i);
          if (!bu.isNullOrNil(paramb.dIt))
          {
            localIntent.putExtra("srcUsername", paramb.dIt);
            localIntent.putExtra("srcDisplayname", paramb.dIu);
          }
          localIntent.putExtra("msg_id", parambv.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambv.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.b(parama, parambv));
          localIntent.putExtra("from_scence", 2);
          i = com.tencent.mm.model.y.aH(paramc.b(parama, parambv), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambv.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.b(parama, parambv));
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
        for (int i = paramb.hBV;; i = -1)
        {
          localIntent.putExtra(e.m.Jpz, i);
          if ((paramb == null) || (i != 5) || (paramb.hBX != 1) || (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe())) {
            break label1285;
          }
          paramb = new Bundle();
          paramb.putInt(com.tencent.mm.ui.e.b.JoV, 1);
          paramb.putInt(com.tencent.mm.ui.e.b.JoW, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          if ((localae != null) && (!bu.isNullOrNil(localae.DTD)))
          {
            paramc = com.tencent.mm.plugin.webview.ui.tools.video.a.EHX;
            com.tencent.mm.plugin.webview.ui.tools.video.a.aKS(localae.DTD);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(parama.Kkd.getContext(), parambv.field_msgId, parambv.field_msgSvrId, 0, paramb);
          AppMethodBeat.o(169873);
          return true;
          localObject1 = "singlemessage";
          break;
          label1226:
          localIntent.putExtra("shortUrl", paramb.url);
          break label637;
          label1241:
          localObject2 = localPackageInfo.versionName;
          break label645;
          label1251:
          i = localPackageInfo.versionCode;
          break label664;
          i = 2;
          break label947;
          i = 3;
          break label947;
          i = 5;
          break label947;
        }
        label1285:
        if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(3)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(parama.Kkd.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          AppMethodBeat.o(169873);
          return true;
        }
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(169873);
      return true;
    }
    
    private t.l k(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36823);
      if (this.KwQ == null) {
        this.KwQ = new t.l(parama);
      }
      parama = this.KwQ;
      AppMethodBeat.o(36823);
      return parama;
    }
    
    private t.j l(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36824);
      if (this.KwR == null) {
        this.KwR = new t.j(parama);
      }
      parama = this.KwR;
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
        ((View)localObject).setTag(new e.c().D((View)localObject, false));
      }
      AppMethodBeat.o(36825);
      return localObject;
    }
    
    public final void a(final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36836);
      com.tencent.mm.ui.base.h.e(parama.Kkd.getContext(), parama.Kkd.getMMResources().getString(2131757285), "", parama.Kkd.getMMResources().getString(2131755877), parama.Kkd.getMMResources().getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(36804);
          if (parambv.cVH())
          {
            com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
            parama.xY(true);
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
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, com.tencent.mm.storage.bv parambv, String paramString)
    {
      AppMethodBeat.i(36826);
      final e.c localc = (e.c)parama;
      this.JWz = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bJ(parambv);
      localc.reset();
      String str = parambv.getContent();
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bH(parambv);
      k.b localb;
      Object localObject2;
      if (str != null)
      {
        localb = k.b.aB(str, parambv.Wc());
        localObject2 = com.tencent.mm.ah.t.zg(str);
      }
      label677:
      label705:
      label1731:
      label7747:
      for (;;)
      {
        Object localObject1 = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
        int j = 0;
        int k = 0;
        localc.KwH.setVisibility(8);
        Object localObject3 = localObject1;
        Object localObject4;
        boolean bool1;
        label602:
        int i;
        if (localb != null)
        {
          localObject4 = com.tencent.mm.pluginsdk.model.app.h.gg(localb.appId, localb.aDD);
          localc.Kvw.aq(localb.title);
          localc.iFO.setText(localb.description);
          localc.KvB.setMaxLines(1);
          localc.Kvw.setTextColor(parama1.getContext().getResources().getColor(2131099732));
          localc.iFO.setTextColor(parama1.getContext().getResources().getColor(2131100482));
          localc.KvR.setBackgroundResource(2131231727);
          localc.KvR.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(2131165500), 0, 0);
          localc.Kvv.setVisibility(0);
          localc.KvP.setVisibility(0);
          localc.iFO.setVisibility(0);
          localc.KvT.setVisibility(8);
          localc.KvU.setVisibility(8);
          localc.KvG.setVisibility(8);
          localc.KvF.setVisibility(8);
          localc.KvC.setVisibility(8);
          localc.Kvz.setVisibility(8);
          localc.Kvy.setVisibility(8);
          localc.Kwd.setVisibility(8);
          localc.KvX.setVisibility(8);
          localc.KvR.setVisibility(0);
          localc.Kwk.setVisibility(8);
          localc.Kws.setVisibility(8);
          localc.KwA.setVisibility(8);
          localc.KwF.setVisibility(8);
          e.c.aI(localc.KvQ, localc.KwJ);
          if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName.trim().length() > 0)) {
            break label1469;
          }
          localObject3 = localb.appName;
          bool1 = true;
          com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 12);
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool1 = o.a.fcK().dSj();
          }
          if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!fD((String)localObject3))) {
            break label1509;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject4, (String)localObject3);
          if (localb.type != 19) {
            break label1479;
          }
          localc.rLB.setText(parama1.getContext().getResources().getString(2131761823, new Object[] { localObject3 }));
          localc.KvA.setVisibility(0);
          localc.rLB.setVisibility(0);
          localc.rLB.setCompoundDrawables(null, null, null, null);
          localc.Kvx.setVisibility(0);
          if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject4).Ee())) {
            break label1492;
          }
          a(parama1, localc.rLB, parambv, localb, ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_packageName, parambv.VY());
          localc.Kvx.setImageResource(2131231697);
          a(parama1, localc.Kvx, localb.appId);
          i = 1;
        }
        label1351:
        label6089:
        label7114:
        for (;;)
        {
          localc.KvA.setBackgroundResource(2131233299);
          bool1 = false;
          localc.Kvv.setVisibility(0);
          if (this.oZq)
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
                    if (!e.b.aYc(parambv.Wb())) {
                      localObject3 = com.tencent.mm.av.q.aIX().e(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    }
                  }
                }
              }
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              localObject4 = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject3, false, com.tencent.mm.cb.a.fromDPToPix(parama1.getContext(), 1));
              localc.Kvv.setImageBitmap((Bitmap)localObject4);
              label869:
              if (localb.type != 3) {
                break label1704;
              }
              localc.KvR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                private boolean KwS = false;
                
                public final boolean onPreDraw()
                {
                  AppMethodBeat.i(36803);
                  if (this.KwS)
                  {
                    localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                  localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                  this.KwS = true;
                  int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Kkd.getContext(), 24);
                  Bitmap localBitmap = this.val$bitmap;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = com.tencent.mm.sdk.platformtools.h.aK(parama1.Kkd.getContext().getResources().getColor(2131100129), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = com.tencent.mm.sdk.platformtools.h.l(com.tencent.mm.sdk.platformtools.h.aE(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                    j = localc.KvR.getHeight();
                    int k = localc.KvR.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166036);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166037);
                    }
                    localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.b((Bitmap)localObject, 2131231589, j, i));
                    localc.KvR.setBackgroundDrawable((Drawable)localObject);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                }
              });
              if (!com.tencent.mm.ui.al.isDarkMode()) {
                break label1693;
              }
              localc.KvA.setBackgroundResource(2131233299);
              localc.KvH.setOnClickListener(null);
              j = localb.type;
              if (localb.type == 66)
              {
                if ((TextUtils.isEmpty(localb.hFc)) && (TextUtils.isEmpty(localb.hFd))) {
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
                localc.KvB.setVisibility(0);
                localc.KvB.setMaxLines(2);
                localc.KvB.setText(localb.title);
                localc.Kvw.setVisibility(8);
                if (bool1)
                {
                  if ((localb.type != 33) && (localb.type != 36)) {
                    break label7586;
                  }
                  paramString = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
                  localc.Kvv.setImageResource(2131689584);
                  com.tencent.mm.modelappbrand.a.b.aEl().a(localc.Kvv, "file://".concat(String.valueOf(paramString)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(52, 52));
                }
                if (localb.type == 44) {
                  e.c.a(parama1, localc, localb);
                }
              }
              localObject3 = parama;
              if (j == 0)
              {
                localc.KvQ.setTag(localObject3);
                localc.KvQ.setOnClickListener(d(parama1));
              }
              if (this.oZq)
              {
                localc.KvQ.setOnLongClickListener(c(parama1));
                localc.KvQ.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
              }
              a(paramInt, localc, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
              AppMethodBeat.o(36826);
              return;
              localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              localc.rLB.setText((CharSequence)localObject3);
              break label602;
              a(parama1, localc.rLB, localb.appId);
              break label677;
              if (localb.type == 24)
              {
                localc.rLB.setText(ak.getContext().getString(2131758845));
                localc.KvA.setVisibility(0);
                localc.rLB.setVisibility(0);
                localc.Kvx.setVisibility(8);
                i = 1;
                break label705;
              }
              if ((localb.type == 19) || (((com.tencent.mm.ah.t)localObject2).hGb == 19))
              {
                localc.rLB.setText(ak.getContext().getString(2131757208));
                localc.KvA.setVisibility(0);
                localc.rLB.setVisibility(0);
                localc.Kvx.setVisibility(8);
                i = 1;
                break label705;
              }
              if (e.a(localb, localc)) {
                break label7773;
              }
              localc.KvA.setVisibility(8);
              localc.rLB.setVisibility(8);
              localc.Kvx.setVisibility(8);
              i = 0;
              break label705;
              bool1 = true;
              break label869;
              localc.KvA.setBackgroundResource(2131231682);
              break label919;
              localc.Kvv.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
              bool1 = false;
              break label919;
              j = 5;
              break label971;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Kvw.setVisibility(0);
                localc.Kvw.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                localc.iFO.setVisibility(0);
                localc.iFO.setTextColor(parama1.getContext().getResources().getColor(2131101182));
                localc.KvB.setVisibility(8);
                localc.KvC.setVisibility(4);
                localc.iFO.setMaxLines(2);
                localc.KvH.setVisibility(0);
                if (!parambv.VX().equals(parama.KuN)) {
                  break label2042;
                }
                localc.KvH.setImageResource(2131233393);
                parama = new e.g();
                parama.msgId = parambv.VX();
                parama.dCX = parambv.getContent();
                parama.dzD = parambv.Wb();
                localc.KvH.setTag(parama);
                localc.KvH.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGx());
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label2056;
                  }
                  localc.Kvv.setImageResource(2131689564);
                }
              }
              for (;;)
              {
                if (!fLB()) {
                  break label2068;
                }
                b(localc, false);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.Kvw.setVisibility(8);
                break label1786;
                localc.KvH.setImageResource(2131233395);
                break label1892;
                localc.Kvv.setImageBitmap(parama);
              }
              if (parambv.getStatus() < 2) {}
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
                localc.Kvw.setVisibility(0);
                localc.Kvw.setMaxLines(2);
              }
              for (;;)
              {
                localc.iFO.setVisibility(0);
                localc.KvB.setVisibility(8);
                localc.KvC.setVisibility(4);
                localc.iFO.setMaxLines(2);
                localc.iFO.setText(bu.sL(localb.hCC));
                localc.KvH.setVisibility(8);
                e.c.a(localc, str, localb.hCC);
                e.c.a(localc, Boolean.FALSE, parambv, localb.dlu, localb.title);
                if (!bool1) {
                  break label7747;
                }
                if (!e.b.aYb(localb.hCD)) {
                  break label2293;
                }
                localc.Kvv.setImageResource(2131231063);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.Kvw.setVisibility(8);
              }
              localc.Kvv.setImageResource(com.tencent.mm.pluginsdk.model.q.aMX(localb.hCD));
              i = 0;
              parama = (c.a)localObject1;
              j = k;
            }
          case 4: 
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.Kvw.setVisibility(0);
              localc.iFO.setVisibility(0);
              localc.KvB.setVisibility(8);
              localc.iFO.setMaxLines(2);
              localc.KvC.setVisibility(4);
              localc.KvH.setVisibility(0);
              localc.KvH.setImageResource(2131234464);
              if (!bool1) {
                break label7747;
              }
              paramString = new com.tencent.mm.av.a.a.c.a();
              paramString.pK(2131689584).aJr().dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50)).aJp().aJs().an(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1));
              localObject2 = com.tencent.mm.av.q.aJb();
              if (!bu.isNullOrNil(localb.thumburl)) {
                break label2543;
              }
            }
            for (parama = localb.hCJ;; parama = localb.thumburl)
            {
              ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.Kvv, paramString.aJu());
              localc.KvH.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.Kvw.setVisibility(8);
              break label2350;
            }
          case 36: 
            label1492:
            label1892:
            label2042:
            if (localc.KvQ.getLayoutParams() != null)
            {
              localc.KvQ.getLayoutParams().width = -2;
              localc.KvQ.requestLayout();
            }
            label2293:
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(localb.hFc);
            label2543:
            if (localObject2 != null)
            {
              parama = ((WxaAttributes)localObject2).field_nickname;
              if (localObject2 == null) {
                break label2937;
              }
              paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
              localc.KvR.setVisibility(8);
              localc.Kwd.setVisibility(0);
              localc.KvX.setVisibility(8);
              localc.Kwk.setVisibility(8);
              localc.Kwh.setText(localb.title);
              e.f(localc.Kwh, localb.title);
              localc.Kwb.setText(parama);
              e.a(localc.Kwc, localb);
              if (!e.a(parambv, localb, parama1)) {
                break label2947;
              }
              localc.KwH.setVisibility(0);
              bool2 = bu.isNullOrNil(parambv.Wg());
              localc.KwH.setTag(parambv);
              localc.KwH.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179969);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  e.a((com.tencent.mm.storage.bv)paramAnonymousView.getTag(), localc, parama1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(179969);
                }
              });
              e.a(bool2, localc, parama1);
              com.tencent.mm.av.q.aJb().a(paramString, localc.Kwa, ac.d.fQP);
              parama = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
              localc.Kwe.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.aEl().a(localc.Kwe, "file://".concat(String.valueOf(parama)), null, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
              if (!fLB()) {
                break label2960;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv);
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
              localc.knv.setVisibility(0);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              parama = localb.dIu;
              break label2616;
              label2937:
              paramString = localb.hFt;
              break label2628;
              localc.KwH.setVisibility(8);
              break label2779;
              if (parambv.getStatus() >= 2) {
                break label7770;
              }
              bool2 = true;
            }
            localc.knv.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            if (localb != null) {
              e.a(paramString, parama1, parambv, localb);
            }
            parama = (com.tencent.mm.ah.e)localb.ao(com.tencent.mm.ah.e.class);
            if ((parama != null) && (parama.hBX == 1) && (parama.hBV == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe()))
            {
              e.c.a(parama1, localc, localb, parambv, bool1);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
            }
            if ((i == 0) && (af.a(localb, parama)))
            {
              localc.KwA.setVisibility(0);
              localc.KwF.setVisibility(0);
              af.a(parama1.getContext(), localb, localc.KwC, localc.KwD);
              af.b(localc.KwE, localb);
            }
            localc.Kvw.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.KvB.setMaxLines(2);
              localc.KvB.setVisibility(0);
              localc.KvB.setText(localb.title);
              localc.iFO.setMaxLines(3);
              localc.KvC.setVisibility(4);
              if (!e.l(localb)) {
                break label3419;
              }
              localc.KvH.setImageResource(2131234464);
              localc.KvH.setVisibility(0);
              if (bool1)
              {
                paramString = new com.tencent.mm.av.a.a.c.a();
                paramString.pK(2131689584).aJr().Gh(com.tencent.mm.plugin.image.d.dfL()).dh(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 50)).aJp().aJs().an(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1));
                localObject2 = com.tencent.mm.av.q.aJb();
                if (!bu.isNullOrNil(localb.thumburl)) {
                  break label3432;
                }
              }
            }
            label3419:
            label3432:
            for (parama = localb.hCJ;; parama = localb.thumburl)
            {
              ((com.tencent.mm.av.a.a)localObject2).a(parama, localc.Kvv, paramString.aJu());
              if (!fLB()) {
                break label3441;
              }
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.KvB.setVisibility(8);
              break label3211;
              localc.KvH.setVisibility(8);
              break label3257;
            }
            label3441:
            if (parambv.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(localb.hFc);
            ((s)com.tencent.mm.kernel.g.ab(s.class)).Mt(localb.hFc);
            switch (localb.hFe)
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
                if (!fLB()) {
                  break label4227;
                }
                a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv);
                b(localc, false);
                parama = (c.a)localObject1;
                j = k;
                break;
                if (localc.KvQ.getLayoutParams() != null)
                {
                  localc.KvQ.getLayoutParams().width = -2;
                  localc.KvQ.requestLayout();
                }
                if (localObject2 != null)
                {
                  parama = ((WxaAttributes)localObject2).field_nickname;
                  if (localObject2 == null) {
                    break label3942;
                  }
                  paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                  localc.KvR.setVisibility(8);
                  localc.Kwd.setVisibility(0);
                  localc.KvX.setVisibility(8);
                  localc.Kwk.setVisibility(8);
                  localc.Kwh.setText(localb.title);
                  e.f(localc.Kwh, localb.title);
                  localc.Kwb.setText(parama);
                  e.a(localc.Kwc, localb);
                  com.tencent.mm.av.q.aJb().a(paramString, localc.Kwa, ac.d.fQP);
                  parama = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
                  localc.Kwe.setImageBitmap(null);
                  localc.Kwg.setVisibility(0);
                  if (!e.a(localb, (WxaAttributes)localObject2)) {
                    break label3952;
                  }
                  localc.knv.setVisibility(0);
                  label3808:
                  if (!e.a(parambv, localb, parama1)) {
                    break label3965;
                  }
                  localc.KwH.setVisibility(0);
                  bool2 = bu.isNullOrNil(parambv.Wg());
                  localc.KwH.setTag(parambv);
                  localc.KwH.setOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymousView)
                    {
                      AppMethodBeat.i(185040);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bd(paramAnonymousView);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                      e.a((com.tencent.mm.storage.bv)paramAnonymousView.getTag(), localc, parama1);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(185040);
                    }
                  });
                  e.a(bool2, localc, parama1);
                }
                for (;;)
                {
                  bool2 = e.m(localb);
                  com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
                  {
                    public final String BN()
                    {
                      AppMethodBeat.i(36812);
                      String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                      AppMethodBeat.o(36812);
                      return str;
                    }
                    
                    public final void F(Bitmap paramAnonymousBitmap)
                    {
                      AppMethodBeat.i(36810);
                      if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                      {
                        localc.Kwe.setImageBitmap(paramAnonymousBitmap);
                        localc.Kwe.setVisibility(0);
                        localc.Kwg.setVisibility(4);
                        if (bool2)
                        {
                          localc.Kwf.setImageDrawable(com.tencent.mm.cb.a.l(parama1.Kkd.getContext(), 2131691166));
                          localc.Kwf.setVisibility(0);
                          AppMethodBeat.o(36810);
                          return;
                        }
                        localc.Kwf.setVisibility(8);
                        AppMethodBeat.o(36810);
                        return;
                      }
                      localc.Kwe.setVisibility(4);
                      localc.Kwg.setVisibility(0);
                      localc.Kwf.setVisibility(8);
                      AppMethodBeat.o(36810);
                    }
                    
                    public final void aEt()
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
                  parama = localb.dIu;
                  break label3647;
                  label3942:
                  paramString = localb.hFt;
                  break label3659;
                  label3952:
                  localc.knv.setVisibility(8);
                  break label3808;
                  label3965:
                  localc.KwH.setVisibility(8);
                }
                if (localObject2 != null)
                {
                  parama = ((WxaAttributes)localObject2).field_nickname;
                  if (localObject2 == null) {
                    break label4131;
                  }
                  paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                  localc.KvR.setVisibility(8);
                  localc.Kwd.setVisibility(8);
                  localc.KvX.setVisibility(0);
                  localc.KvZ.setText(parama);
                  localc.Kwk.setVisibility(8);
                  if (!bu.isNullOrNil(paramString)) {
                    break label4137;
                  }
                  parama = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
                  com.tencent.mm.modelappbrand.a.b.aEl().a(localc.KvY, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
                }
                for (;;)
                {
                  if (!e.a(localb, (WxaAttributes)localObject2)) {
                    break label4160;
                  }
                  localc.Kwj.setVisibility(0);
                  i = 0;
                  break;
                  parama = localb.title;
                  break label3989;
                  paramString = null;
                  break label4001;
                  com.tencent.mm.modelappbrand.a.b.aEl().a(localc.KvY, paramString, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
                }
                localc.Kwj.setVisibility(8);
                i = 0;
              }
              localc.KvA.setVisibility(0);
              localc.Kvx.setVisibility(0);
              localc.Kvx.setBackground(null);
              localc.Kvx.setImageResource(2131689681);
              e.a(localc.rLB, localb);
            }
            if (parambv.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            parama = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
            paramString = localb.hFt;
            localObject2 = localb.dIu;
            localObject3 = localb.title;
            localObject4 = localb.description;
            if (parama == null)
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
              break;
            }
            if (((bu.isNullOrNil(parama.hBg)) || (bu.isNullOrNil(parama.hBi))) && (bu.isNullOrNil(parama.hBf)))
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
              break;
            }
            localc.Kwq.setText((CharSequence)localObject2);
            localc.KvR.setVisibility(8);
            localc.Kwd.setVisibility(8);
            localc.KvX.setVisibility(8);
            localc.Kwr.setVisibility(0);
            localc.Kwn.setVisibility(8);
            localc.Kwr.setImageDrawable(com.tencent.mm.cb.a.l(parama1.getContext(), 2131691166));
            localc.Kwk.setVisibility(0);
            localc.Kwl.setText((CharSequence)localObject3);
            localc.Kwm.setText((CharSequence)localObject4);
            com.tencent.mm.av.q.aJa().a(paramString, new r.a()
            {
              public final void a(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
              {
                AppMethodBeat.i(36814);
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36813);
                    if (!paramAnonymousBitmap.isRecycled()) {
                      e.e.7.this.KwN.Kwp.setImageBitmap(paramAnonymousBitmap);
                    }
                    AppMethodBeat.o(36813);
                  }
                });
                AppMethodBeat.o(36814);
              }
            });
            parama = com.tencent.mm.av.q.aIX().FU(parambv.Wb());
            localc.Kwo.setImageBitmap(null);
            com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
            {
              public final String BN()
              {
                AppMethodBeat.i(36817);
                String str = "CHAT#" + com.tencent.mm.plugin.appbrand.y.n.cH(this);
                AppMethodBeat.o(36817);
                return str;
              }
              
              public final void F(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(36816);
                if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                {
                  localc.Kwo.setImageBitmap(paramAnonymousBitmap);
                  localc.Kwo.setVisibility(0);
                }
                AppMethodBeat.o(36816);
              }
              
              public final void aEt()
              {
                AppMethodBeat.i(36815);
                localc.Kwo.setVisibility(4);
                AppMethodBeat.o(36815);
              }
              
              public final void ox()
              {
                AppMethodBeat.i(185041);
                com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
                com.tencent.mm.plugin.report.service.g.yxI.dD(808, 3);
                AppMethodBeat.o(185041);
              }
            }, e.access$600(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.hNl));
            if (fLB())
            {
              a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
            }
            if (parambv.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            i = 1;
            localc.iFO.setMaxLines(3);
            localc.KvB.setMaxLines(2);
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            localc.Kvw.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.KvB.setMaxLines(2);
              localc.KvB.setVisibility(0);
              localc.KvB.setText(localb.title);
              label4723:
              localc.iFO.setMaxLines(3);
              localc.KvC.setVisibility(4);
              localc.KvH.setVisibility(8);
              if (bool1)
              {
                parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                if ((parama != null) && (!parama.isRecycled())) {
                  break label4834;
                }
                localc.Kvv.setImageResource(2131689584);
              }
            }
            for (;;)
            {
              if (!fLB()) {
                break label4846;
              }
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.KvB.setVisibility(8);
              break label4723;
              label4834:
              localc.Kvv.setImageBitmap(parama);
            }
            label4846:
            if (parambv.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            localc.KvB.setVisibility(0);
            if (localb.hDb == 1) {
              localc.KvB.setText(2131762858);
            }
            for (;;)
            {
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Kvw.setVisibility(0);
                localc.Kvw.aq(localb.title);
              }
              localc.iFO.setMaxLines(4);
              localc.KvC.setVisibility(4);
              localc.KvH.setVisibility(8);
              if (!bool1) {
                break label7747;
              }
              parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
              if ((parama == null) || (parama.isRecycled())) {
                break label5101;
              }
              localc.Kvv.setImageBitmap(parama);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              if (localb.hDb == 2) {
                localc.KvB.setText(2131762860);
              } else if (localb.hDb == 3) {
                localc.KvB.setText(2131762859);
              } else {
                localc.KvB.setText(2131762861);
              }
            }
            label5101:
            localc.Kvv.setImageResource(2131689584);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1194;
            localc.Kvw.setVisibility(0);
            localc.Kvw.aq(localb.title);
            localc.KvB.setVisibility(0);
            localc.KvB.setText(2131757247);
            localc.iFO.setMaxLines(4);
            localc.KvC.setVisibility(4);
            localc.KvH.setVisibility(8);
            if (bool1)
            {
              parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
              if ((parama != null) && (!parama.isRecycled()))
              {
                localc.Kvv.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
              }
              localc.Kvv.setImageResource(2131689584);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break label1194;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.Kvw.setVisibility(0);
                localc.Kvw.aq(localb.title);
                localc.KvB.setVisibility(8);
              }
              localc.iFO.setMaxLines(4);
              localc.KvC.setVisibility(4);
              localc.KvH.setVisibility(8);
              if (bool1)
              {
                parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                if ((parama != null) && (!parama.isRecycled()))
                {
                  localc.Kvv.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                }
                localc.Kvv.setImageResource(2131689584);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                if ((localb.title != null) && (localb.title.length() > 0)) {
                  localc.Kvw.setVisibility(0);
                }
                for (;;)
                {
                  localc.iFO.setVisibility(0);
                  localc.KvB.setVisibility(8);
                  localc.KvC.setVisibility(8);
                  localc.KvH.setVisibility(4);
                  localc.iFO.setMaxLines(2);
                  if (!bool1) {
                    break label7747;
                  }
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5583;
                  }
                  localc.Kvv.setImageResource(2131689584);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.Kvw.setVisibility(8);
                }
                localc.Kvv.setImageBitmap(parama);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Kvw.setVisibility(0);
                  localc.iFO.setVisibility(0);
                  localc.KvB.setVisibility(8);
                  localc.KvH.setVisibility(8);
                  localc.KvC.setVisibility(4);
                  localc.iFO.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label5818;
                    }
                    localc.Kvv.setImageResource(2131689584);
                  }
                }
                for (;;)
                {
                  parama = new bk(parambv, false, paramInt, "", false, parama1.fGT(), localb.dIt, localb.dIu, localb.title, localb.hDj, localb.url, false, false);
                  localc.KvQ.setTag(parama);
                  localc.KvQ.setOnClickListener(i(parama1));
                  j = 1;
                  i = 0;
                  break;
                  localc.Kvw.setVisibility(8);
                  break label5633;
                  localc.Kvv.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Kvw.setVisibility(0);
                  label5858:
                  localc.iFO.setVisibility(0);
                  localc.KvB.setVisibility(8);
                  localc.KvH.setVisibility(8);
                  localc.KvC.setVisibility(4);
                  localc.iFO.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label6049;
                    }
                    localc.Kvv.setImageResource(2131689584);
                  }
                }
                for (;;)
                {
                  parama = new bk(parambv, paramInt, "", parama1.fGT(), localb.dIt, localb.dIu, localb.title, localb.hEP, localb.designerName, localb.designerRediretctUrl, localb.url);
                  localc.KvQ.setTag(parama);
                  localc.KvQ.setOnClickListener(j(parama1));
                  j = 1;
                  i = 0;
                  break;
                  localc.Kvw.setVisibility(8);
                  break label5858;
                  localc.Kvv.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.Kvw.setVisibility(0);
                  localc.iFO.setVisibility(0);
                  localc.KvB.setVisibility(8);
                  localc.KvH.setVisibility(8);
                  localc.KvC.setVisibility(4);
                  localc.iFO.setMaxLines(2);
                  if (bool1)
                  {
                    if (!bu.isNullOrNil(parambv.Wb())) {
                      break label6348;
                    }
                    com.tencent.mm.av.q.aJb().loadImage(localb.thumburl, localc.Kvv);
                  }
                  parama = new bk();
                  parama.dCi = parambv;
                  parama.JSi = false;
                  parama.position = paramInt;
                  parama.KDO = false;
                  parama.title = parama1.fGT();
                  parama.dIt = localb.dIt;
                  parama.dIu = localb.dIu;
                  parama.KDP = localb.title;
                  if (localb.type != 26) {
                    break label6405;
                  }
                  parama.tid = localb.tid;
                  parama.hEQ = localb.hEQ;
                  parama.desc = localb.desc;
                  parama.iconUrl = localb.iconUrl;
                  parama.secondUrl = localb.secondUrl;
                  parama.pageType = localb.pageType;
                  localc.KvQ.setOnClickListener(k(parama1));
                  i = 1;
                }
                for (;;)
                {
                  localc.KvQ.setTag(parama);
                  k = 0;
                  j = i;
                  i = k;
                  break;
                  localc.Kvw.setVisibility(8);
                  break label6089;
                  parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if ((parama == null) || (parama.isRecycled()))
                  {
                    localc.Kvv.setImageResource(2131689584);
                    break label6168;
                  }
                  localc.Kvv.setImageBitmap(parama);
                  break label6168;
                  if (localb.type == 27)
                  {
                    parama.tid = localb.tid;
                    parama.hEQ = localb.hEQ;
                    parama.desc = localb.desc;
                    parama.iconUrl = localb.iconUrl;
                    parama.secondUrl = localb.secondUrl;
                    parama.pageType = localb.pageType;
                    localc.KvQ.setOnClickListener(l(parama1));
                    i = 1;
                  }
                  else
                  {
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                    i = 0;
                  }
                }
                localc.Kvw.setVisibility(0);
                localc.Kvw.aq(localb.description);
                localc.iFO.setText(localb.hDP);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.KvB.setVisibility(0);
                  localc.KvB.setText(localb.title);
                }
                for (;;)
                {
                  localc.iFO.setMaxLines(4);
                  localc.KvC.setVisibility(4);
                  localc.KvH.setVisibility(8);
                  if (!bool1) {
                    break label7747;
                  }
                  parama = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6671;
                  }
                  localc.Kvv.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.KvB.setVisibility(8);
                }
                localc.Kvv.setImageResource(2131689584);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                localc.Kvw.setVisibility(8);
                localc.KvB.setVisibility(0);
                if ((localb.title != null) && (localb.title.length() > 0)) {
                  localc.KvB.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.KvB.getContext(), localb.title, (int)localc.KvB.getTextSize()));
                }
                for (;;)
                {
                  localc.iFO.setMaxLines(3);
                  localc.KvC.setVisibility(4);
                  localc.KvH.setVisibility(8);
                  if (bool1) {
                    localc.Kvv.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, parambv, bool1);
                  if (!fLB()) {
                    break label6904;
                  }
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.KvB.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localc.KvB.getContext(), ak.getContext().getString(2131759034), (int)localc.KvB.getTextSize()));
                }
                label6904:
                if (parambv.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                e.c.a(parama1, localc, localb, bool1);
                if (fLB())
                {
                  a(localc, (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                }
                if (parambv.getStatus() < 2) {}
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
                  localc.Kvw.setVisibility(0);
                  if (!bu.isNullOrNil(localb.titleColor)) {
                    if (!bu.isNullOrNil(localb.titleColor))
                    {
                      localc.Kvw.setTextColor(bu.cN(localb.titleColor, parama1.getContext().getResources().getColor(2131100711)));
                      localc.iFO.setMaxLines(2);
                      localc.iFO.setVisibility(0);
                      if (bu.isNullOrNil(localb.hDY)) {
                        break label7435;
                      }
                      localc.iFO.setTextColor(bu.cN(localb.hDY, parama1.getContext().getResources().getColor(2131100469)));
                      localc.KvB.setVisibility(8);
                      localc.KvC.setVisibility(4);
                      localc.KvH.setVisibility(8);
                      localc.KvA.setVisibility(0);
                      localc.rLB.setVisibility(0);
                      if (bu.isNullOrNil(localb.hDU)) {
                        break label7459;
                      }
                      localc.rLB.setText(localb.hDU);
                    }
                  }
                }
                for (;;)
                {
                  if (this.oZq)
                  {
                    parama = com.tencent.mm.av.q.aIX().e(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = com.tencent.mm.sdk.platformtools.h.a(parama, false, parama.getWidth() / 2);
                      localc.Kvv.setImageBitmap(paramString);
                    }
                    if (!bu.isNullOrNil(localb.hDX))
                    {
                      com.tencent.mm.av.q.aJb().a(localb.hDX, new ImageView(parama1.getContext()), new com.tencent.mm.av.a.a.c.a().aJq().aJu(), new com.tencent.mm.av.a.c.h()
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
                            localc.KvR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36818);
                                e.e.9.this.KwN.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.e.9.this.KwN.KvR.getHeight();
                                int k = e.e.9.this.KwN.KvR.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cb.a.ax(e.e.9.this.KuD.Kkd.getContext(), 2131166036);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cb.a.ax(e.e.9.this.KuD.Kkd.getContext(), 2131166037);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.b(paramAnonymousString, 2131231589, j, i));
                                e.e.9.this.KwN.KvR.setBackgroundDrawable(localBitmapDrawable);
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
                      localc.Kvw.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label7114;
                      localc.Kvw.setTextColor(parama1.getContext().getResources().getColor(2131100711));
                      break label7114;
                      localc.Kvw.setVisibility(8);
                      break label7114;
                      localc.iFO.setTextColor(parama1.getContext().getResources().getColor(2131100469));
                      break label7172;
                      localc.rLB.setText(2131757206);
                      continue;
                    }
                    localc.KvR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean KwS = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36820);
                        if (this.KwS)
                        {
                          localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36820);
                          return true;
                        }
                        localc.KvR.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.KwS = true;
                        int i = com.tencent.mm.cb.a.fromDPToPix(parama1.Kkd.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = com.tencent.mm.sdk.platformtools.h.aK(parama1.Kkd.getContext().getResources().getColor(2131100129), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = com.tencent.mm.sdk.platformtools.h.l(com.tencent.mm.sdk.platformtools.h.aE(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
                          j = localc.KvR.getHeight();
                          int k = localc.KvR.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166036);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cb.a.ax(parama1.Kkd.getContext(), 2131166037);
                          }
                          localObject = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.b((Bitmap)localObject, 2131231589, j, i));
                          localc.KvR.setBackgroundDrawable((Drawable)localObject);
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
                localc.Kvv.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), 2131233475));
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1194;
                if (((com.tencent.mm.ah.t)localObject2).hGb == 19)
                {
                  e.c.a(parama1, localc, localb, bool1);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1194;
                  localc.KvB.setVisibility(8);
                  break label1249;
                  localObject1 = com.tencent.mm.av.q.aIX().b(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = com.tencent.mm.av.q.aIX().e(parambv.Wb(), com.tencent.mm.cb.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.Kvv.setImageBitmap(paramString);
                    break label1351;
                  }
                  if (!bu.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.av.a.a.c.a();
                    ((com.tencent.mm.av.a.a.c.a)localObject1).pK(2131100141).aJr().aJp();
                    com.tencent.mm.av.q.aJb().a(paramString, localc.Kwu, ((com.tencent.mm.av.a.a.c.a)localObject1).aJu());
                    break label1351;
                  }
                  localc.Kvv.setImageResource(2131231063);
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
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.storage.bv parambv)
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
        if (!ac.bm(parambv))
        {
          com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131766957), "", parama.Kkd.getContext().getString(2131766205), null);
          AppMethodBeat.o(36829);
          return false;
        }
        e.b.a(parama, parambv, b(parama, parambv));
        AppMethodBeat.o(36829);
        return false;
      case 114: 
        paramMenuItem = parambv.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.zb(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          am.a(parambv, bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.d(parambv, parama.Kkd.getContext());
          continue;
          am.b(parambv, bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.a(parambv, parama.Kkd.getContext(), b(parama, parambv), parama.fJC());
          continue;
          am.o(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.c(parambv, bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend), parama.Kkd.getContext());
          continue;
          am.c(parambv, parama.Kkd.getContext());
        }
      case 103: 
        paramMenuItem = parambv.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.zb(paramMenuItem);
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
        paramMenuItem.putExtra("Chat_Msg_Id", parambv.field_msgId);
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
        AppMethodBeat.o(36829);
        return false;
        ju localju = new ju();
        localju.dxM.dxN = paramMenuItem.dxN;
        localju.dxM.dnX = parambv.field_msgId;
        localju.dxM.dxO = parambv.field_talker;
        com.tencent.mm.sdk.b.a.IvT.l(localju);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(187718);
      int i = ((bk)paramView.getTag()).position;
      if (parambv.field_content == null)
      {
        AppMethodBeat.o(187718);
        return true;
      }
      k.b localb = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(187718);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.k.aW(parambv)) && ((localb.type != 19) || (parambv.field_status != 1))) {
        paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      }
      if (((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker)) && (!an.zd(this.JWz.getTalkerUserName()))) {
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
        if ((bool1) && (!this.JWz.fJD())) {
          paraml.add(i, 114, 0, paramView.getContext().getString(2131757217));
        }
        if ((com.tencent.mm.br.d.aJN("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).Ee()))) {
          switch (localb.type)
          {
          }
        }
        for (;;)
        {
          localObject = new ec();
          ((ec)localObject).dql.msgId = parambv.field_msgId;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          if ((((ec)localObject).dqm.dpK) || (e.b.a(this.JWz.Kkd.getContext(), localb))) {
            paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
          }
          if (!this.JWz.fJD()) {
            paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
          }
          if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.bv.fpT())) {
            paraml.a(i, 144, paramView.getContext().getString(2131761225), 2131690202);
          }
          AppMethodBeat.o(187718);
          return true;
          bool1 = com.tencent.mm.al.g.aFZ();
          break;
          bool1 = com.tencent.mm.al.g.aFT();
          break;
          boolean bool2 = com.tencent.mm.al.g.aFX();
          bool1 = bool2;
          if (bu.aSQ(localb.hCD)) {
            break;
          }
          paraml.a(i, 150, this.JWz.Kkd.getMMResources().getString(2131757229), 2131691578);
          bool1 = bool2;
          break;
          bool1 = com.tencent.mm.al.g.aFQ();
          break;
          bool1 = com.tencent.mm.al.g.aFP();
          break;
          bool1 = com.tencent.mm.al.g.aFV();
          break;
          bool1 = com.tencent.mm.al.g.aFR();
          break;
          if ((localb.hDQ != 5) && (localb.hDQ != 6) && (localb.hDQ != 2)) {
            break label889;
          }
          if (localb.hDQ != 2) {
            paraml.clear();
          }
          paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(187718);
          return false;
          paraml.clear();
          paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
          AppMethodBeat.o(187718);
          return false;
          paraml.a(i, 116, paramView.getContext().getString(2131761941), 2131690400);
        }
        label889:
        bool1 = false;
      }
    }
    
    public final boolean b(final View paramView, final com.tencent.mm.ui.chatting.e.a parama, final com.tencent.mm.storage.bv parambv)
    {
      AppMethodBeat.i(36830);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      paramView.getTag();
      paramView = parambv.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      paramView = k.b.zb(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, true, false);
      if ((localObject != null) && (!bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId))) {
        a(parama, paramView, v.aAC(), (com.tencent.mm.pluginsdk.model.app.g)localObject, parambv.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (paramView.type)
      {
      }
      do
      {
        i = 1;
        while ((i != 0) && (i(paramView, parama, this, parambv)))
        {
          AppMethodBeat.o(36830);
          return true;
          bc.aCg();
          if (!com.tencent.mm.model.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.t.g(parama.Kkd.getContext(), parama.Kkd.getContentView());
            AppMethodBeat.o(36830);
            return true;
          }
          if (bu.aSQ(paramView.hCD))
          {
            long l = parambv.field_msgId;
            localObject = paramView.dlu;
            paramView = ao.bJV().aMZ((String)localObject);
            if ((paramView == null) || (!paramView.cZe())) {
              i = 0;
            }
            while (i != 0)
            {
              AppMethodBeat.o(36830);
              return true;
              bc.aCg();
              com.tencent.mm.storage.bv localbv = com.tencent.mm.model.c.azI().ys(l);
              if (localbv.fvU())
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { localObject, Long.valueOf(l), Long.valueOf(localbv.field_msgSvrId), localbv.field_imgPath });
                localObject = new Intent();
                ((Intent)localObject).setClassName(this.JWz.Kkd.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                ((Intent)localObject).putExtra("clean_view_type", 1);
                paramView = this.JWz;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = 1;
              }
              else
              {
                localObject = new Intent(this.JWz.Kkd.getContext(), ShowImageUI.class);
                ((Intent)localObject).putExtra("key_image_path", paramView.field_fileFullPath);
                ((Intent)localObject).putExtra("key_message_id", l);
                ((Intent)localObject).putExtra("key_favorite", true);
                paramView = this.JWz;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = 1;
              }
            }
          }
          paramView = new Intent();
          paramView.setClassName(parama.Kkd.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          paramView.putExtra("scene", 2);
          paramView.putExtra("app_msg_id", parambv.field_msgId);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramView.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36830);
          return true;
          com.tencent.mm.plugin.report.service.g.yxI.f(13043, new Object[] { Integer.valueOf(2), paramView.description, paramView.appId });
          boolean bool = f(paramView, parama, this, parambv);
          AppMethodBeat.o(36830);
          return bool;
          bool = j(paramView, parama, this, parambv);
          AppMethodBeat.o(36830);
          return bool;
          if (h(paramView, parama, this, parambv))
          {
            AppMethodBeat.o(36830);
            return true;
            if (g(paramView, parama, this, parambv))
            {
              AppMethodBeat.o(36830);
              return true;
            }
            i = 1;
          }
        }
        b(paramView, parama, this, parambv);
        AppMethodBeat.o(36830);
        return true;
        if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).Ee()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject)))
        {
          AppMethodBeat.o(36830);
          return true;
        }
        ((com.tencent.mm.ui.chatting.d.b.b)parama.bh(com.tencent.mm.ui.chatting.d.b.b.class)).a(parambv, new com.tencent.mm.pluginsdk.model.app.al()
        {
          public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(187717);
            if (this.pur != null)
            {
              if (paramAnonymousBoolean1)
              {
                e.e.a(parama, paramView, v.aAC(), this.pur, parambv.field_msgSvrId, 3, parama.getTalkerUserName());
                AppMethodBeat.o(187717);
                return;
              }
              e.e.a(parama, paramView, v.aAC(), this.pur, parambv.field_msgSvrId, 7, parama.getTalkerUserName());
            }
            AppMethodBeat.o(187717);
          }
        });
        AppMethodBeat.o(36830);
        return true;
        if (bu.isNullOrNil(paramView.hDc))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).setFlags(65536);
        ((Intent)localObject).putExtra("key_Product_xml", paramView.hDc);
        ((Intent)localObject).putExtra("key_ProductUI_getProductInfoScene", 1);
        if (parambv.field_imgPath == null) {
          ((Intent)localObject).putExtra("key_ProductUI_chatting_msgId", parambv.field_msgId);
        }
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "scanner", ".ui.ProductUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
        if (bu.isNullOrNil(paramView.hDf))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        localObject = new Intent();
        ((Intent)localObject).setFlags(65536);
        ((Intent)localObject).putExtra("key_TV_xml", paramView.hDf);
        ((Intent)localObject).putExtra("key_TV_getProductInfoScene", 1);
        if (parambv.field_imgPath == null) {
          ((Intent)localObject).putExtra("key_TVInfoUI_chatting_msgId", parambv.field_msgId);
        }
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "shake", ".ui.TVInfoUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
        if (bu.isNullOrNil(paramView.hDi))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        parambv = new Intent();
        parambv.setFlags(65536);
        parambv.putExtra("key_product_info", paramView.hDi);
        parambv.putExtra("key_product_scene", 1);
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "product", ".ui.MallProductUI", parambv);
        AppMethodBeat.o(36830);
        return true;
        if (bu.isNullOrNil(paramView.dxN))
        {
          AppMethodBeat.o(36830);
          return false;
        }
        parambv = new Intent();
        parambv.setFlags(65536);
        parambv.putExtra("key_card_app_msg", paramView.dxN);
        parambv.putExtra("key_from_scene", paramView.hDQ);
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "card", ".ui.CardDetailUI", parambv);
        AppMethodBeat.o(36830);
        return true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("message_id", parambv.field_msgId);
        ((Intent)localObject).putExtra("record_xml", paramView.hDg);
        i = com.tencent.mm.model.y.aH(b(parama, parambv), parama.getTalkerUserName());
        ((Intent)localObject).putExtra("prePublishId", "msg_" + Long.toString(parambv.field_msgSvrId));
        ((Intent)localObject).putExtra("preUsername", b(parama, parambv));
        ((Intent)localObject).putExtra("preChatName", parama.getTalkerUserName());
        ((Intent)localObject).putExtra("preChatTYPE", i);
        e.a.a((Intent)localObject, parama, parambv, this);
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "record", ".ui.RecordMsgDetailUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
        e.a(paramView, parama, parambv);
        AppMethodBeat.o(36830);
        return true;
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_biz_uin", paramView.hDS);
        ((Intent)localObject).putExtra("key_order_id", paramView.hDT);
        if ((parambv.field_talker != null) && (!parambv.field_talker.equals("")) && (com.tencent.mm.model.x.wb(parambv.field_talker))) {
          ((Intent)localObject).putExtra("key_chatroom_name", parambv.field_talker);
        }
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "card", ".ui.CardGiftAcceptUI", (Intent)localObject);
        AppMethodBeat.o(36830);
        return true;
      } while (!e.a(paramView, parama));
      AppMethodBeat.o(36830);
      return true;
      AppMethodBeat.o(36830);
      return false;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
  
  static final class f
  {
    public boolean Kxa = false;
  }
  
  public static final class g
  {
    public e.h Kxb;
    public int Kxc = -1;
    public String dCX;
    public String dzD;
    public long msgId;
  }
  
  public static final class h
  {
    public String EHk;
    public String coverUrl;
    public String hGs;
    public String playUrl;
    public String title;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e
 * JD-Core Version:    0.7.0.1
 */