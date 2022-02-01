package com.tencent.mm.ui.chatting.viewitems;

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
import android.text.TextUtils;
import android.view.ContextMenu.ContextMenuInfo;
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
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.bp;
import com.tencent.mm.autogen.a.bq;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.me;
import com.tencent.mm.autogen.a.rk;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.k.2;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.v.i;
import com.tencent.mm.ui.chatting.v.j;
import com.tencent.mm.ui.chatting.v.l;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.regex.Pattern;

public final class e
{
  private static boolean RGG = false;
  
  private static void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, com.tencent.mm.ui.transmit.g.a parama)
  {
    AppMethodBeat.i(254991);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
    paramContext = View.inflate(paramContext, R.i.goD, null);
    Object localObject = (ImageView)paramContext.findViewById(R.h.gal);
    if (LocaleUtil.isChineseAppLang()) {
      ((ImageView)localObject).setImageResource(R.g.todo_introduce_chinease);
    }
    for (;;)
    {
      localObject = new e.f((byte)0);
      paramContext.findViewById(R.h.gao).setOnClickListener(new e.3((e.f)localObject, localf, parama));
      localf.Vtg = new e.4(localf, paramContext);
      localf.aeLi = new e.5((e.f)localObject, paramString1, paramBoolean, paramString2, paramString3);
      localf.uR(true);
      localf.dDn();
      AppMethodBeat.o(254991);
      return;
      ((ImageView)localObject).setImageResource(R.g.todo_introduce_english);
    }
  }
  
  public static void a(Intent paramIntent, cc paramcc, k.b paramb)
  {
    AppMethodBeat.i(254992);
    paramIntent.putExtra("webpageTitle", paramb.title);
    paramIntent.putExtra("thumbUrl", paramb.thumburl);
    paramIntent.putExtra("thumbPath", r.bKa().d(paramcc.field_imgPath, false, true));
    AppMethodBeat.o(254992);
  }
  
  protected static void a(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(36837);
    switch (paramb.nTW)
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
  
  public static void a(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36838);
    rk localrk = new rk();
    localrk.hUw.context = parama.aezO.getContext();
    localrk.hUw.msgId = paramcc.field_msgId;
    localrk.hUw.hTH = parama.juG();
    localrk.hUw.hUx = paramb.nRF;
    localrk.hUw.scene = 6;
    localrk.publish();
    AppMethodBeat.o(36838);
  }
  
  public static void a(cc paramcc, c.a parama, com.tencent.mm.ui.chatting.d.a parama1)
  {
    AppMethodBeat.i(179989);
    a(paramcc, parama, parama1, 0);
    AppMethodBeat.o(179989);
  }
  
  public static void a(cc paramcc, final c.a parama, final com.tencent.mm.ui.chatting.d.a parama1, final int paramInt)
  {
    AppMethodBeat.i(185048);
    if (paramcc == null)
    {
      Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185048);
      return;
    }
    if (MultiProcessMMKV.getMMKV("group_to_do").getBoolean("introduce_dialog_first", true))
    {
      MultiProcessMMKV.getMMKV("group_to_do").edit().putBoolean("introduce_dialog_first", false);
      a(parama1.aezO.getContext(), Util.isNullOrNil(paramcc.kLt), parama1.getTalkerUserName(), paramcc.kLt, com.tencent.mm.chatroom.d.ab.f(paramcc), new com.tencent.mm.ui.transmit.g.a()
      {
        public final void jxp()
        {
          AppMethodBeat.i(255395);
          e.b(e.this, parama, parama1, paramInt);
          AppMethodBeat.o(255395);
        }
      });
      AppMethodBeat.o(185048);
      return;
    }
    a(paramcc, parama, parama1, paramInt, 0);
    AppMethodBeat.o(185048);
  }
  
  private static void a(cc paramcc, c.a parama, com.tencent.mm.ui.chatting.d.a parama1, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185049);
    if (paramcc == null)
    {
      Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
      AppMethodBeat.o(185049);
      return;
    }
    boolean bool = Util.isNullOrNil(paramcc.kLt);
    Activity localActivity = parama1.aezO.getContext();
    String str2 = paramcc.field_talker;
    if (Util.isNullOrNil(paramcc.kLt)) {}
    for (String str1 = com.tencent.mm.chatroom.d.ab.d(paramcc);; str1 = paramcc.kLt)
    {
      com.tencent.mm.chatroom.d.ab.a(localActivity, str2, str1, com.tencent.mm.chatroom.d.ab.f(paramcc), bool, 2, paramInt1, paramInt2, new e.2(bool, parama, parama1, paramcc));
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
    if ((parama instanceof bj.f)) {
      bj.a(paramBoolean, (bj.f)parama, parama1);
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
      paramc.aeOr.setBackgroundResource(R.g.fne);
      paramc.aeOs.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.BW_100_Alpha_0_8));
      paramc.aeOs.setText(R.l.gJk);
      AppMethodBeat.o(179988);
      return;
    }
    paramc.aeOr.setBackgroundResource(R.g.fnf);
    paramc.aeOs.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.Brand));
    paramc.aeOs.setText(R.l.gJl);
    AppMethodBeat.o(179988);
  }
  
  public static boolean a(k.b paramb, c paramc)
  {
    AppMethodBeat.i(254971);
    if (m(paramb))
    {
      paramc.aeNk.setVisibility(0);
      paramc.Aoo.setVisibility(0);
      paramc.Aoo.setText(R.l.top_story_chatting_app_msg_brand_name);
      paramc.aeNh.setVisibility(0);
      paramc.aeNh.setImageResource(R.g.fpE);
      AppMethodBeat.o(254971);
      return true;
    }
    AppMethodBeat.o(254971);
    return false;
  }
  
  public static boolean a(cc paramcc, k.b paramb, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(179986);
    if (!com.tencent.mm.chatroom.d.ab.aLX())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (paramcc == null)
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if ((!com.tencent.mm.modelappbrand.b.b(paramb)) && (!com.tencent.mm.modelappbrand.b.c(paramb)))
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (cn.bDv() - paramcc.getCreateTime() >= com.tencent.mm.chatroom.storage.d.lzB.longValue())
    {
      AppMethodBeat.o(179986);
      return false;
    }
    if (com.tencent.mm.model.ab.IL(parama.getTalkerUserName()))
    {
      AppMethodBeat.o(179986);
      return true;
    }
    AppMethodBeat.o(179986);
    return false;
  }
  
  private static boolean m(k.b paramb)
  {
    AppMethodBeat.i(36839);
    paramb = (ak)paramb.aK(ak.class);
    if ((paramb != null) && (!Util.isNullOrNil(paramb.WoZ)))
    {
      AppMethodBeat.o(36839);
      return true;
    }
    AppMethodBeat.o(36839);
    return false;
  }
  
  static final class b
  {
    private static HashSet<String> aeNb;
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, String paramString)
    {
      AppMethodBeat.i(36756);
      a(parama, paramcc, paramString, -1, null);
      AppMethodBeat.o(36756);
    }
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, final cc paramcc, String paramString, final int paramInt, final com.tencent.mm.br.c.a parama1)
    {
      AppMethodBeat.i(255261);
      Object localObject1 = br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend);
      final Intent localIntent = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
      if (localObject1 != null) {
        localIntent.putExtra("Retr_Msg_content_bytes", ((String)localObject1).getBytes());
      }
      localIntent.putExtra("Retr_MsgFromScene", 2);
      localObject1 = k.b.Hf((String)localObject1);
      if ((localObject1 != null) && (19 == ((k.b)localObject1).type)) {
        localIntent.putExtra("Retr_Msg_Type", 10);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_Msg_Id", paramcc.field_msgId);
        if ((localObject1 != null) && (((k.b)localObject1).type == 6)) {
          break label551;
        }
        parama.a(localIntent, paramInt, parama1);
        AppMethodBeat.o(255261);
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
        localObject2 = new com.tencent.mm.message.aa();
        ((com.tencent.mm.message.aa)localObject2).nVy = ((k.b)localObject1);
        ((com.tencent.mm.message.aa)localObject2).publish();
      }
      localIntent.putExtra("Retr_Msg_Type", 2);
      Object localObject2 = paramcc.field_talker;
      Object localObject3 = ad.Jo(paramcc.field_msgSvrId);
      localIntent.putExtra("reportSessionId", (String)localObject3);
      localObject3 = ad.bCb().M((String)localObject3, true);
      ((ad.b)localObject3).q("prePublishId", "msg_" + paramcc.field_msgSvrId);
      ((ad.b)localObject3).q("preUsername", paramString);
      ((ad.b)localObject3).q("preChatName", localObject2);
      if ((localObject1 != null) && (((k.b)localObject1).aK(com.tencent.mm.message.a.class) != null))
      {
        ((ad.b)localObject3).q("appservicetype", Integer.valueOf(((com.tencent.mm.message.a)((k.b)localObject1).aK(com.tencent.mm.message.a.class)).nOM));
        localIntent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.message.a)((k.b)localObject1).aK(com.tencent.mm.message.a.class)).nOM);
      }
      if ((localObject1 != null) && (33 == ((k.b)localObject1).type))
      {
        if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.aezO.getContext()))
        {
          AppMethodBeat.o(255261);
          return;
        }
        if (!parama.juG()) {
          break label527;
        }
        ((ad.b)localObject3).q("fromScene", Integer.valueOf(2));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 2);
      }
      for (;;)
      {
        localIntent.putExtra("Retr_MsgFromUserName", paramString);
        localIntent.putExtra("Retr_MsgTalker", paramcc.field_talker);
        ((ad.b)localObject3).q("sendAppMsgScene", Integer.valueOf(1));
        ((com.tencent.mm.plugin.sns.c.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.l.class)).a("adExtStr", (ad.b)localObject3, paramcc);
        break;
        label527:
        ((ad.b)localObject3).q("fromScene", Integer.valueOf(1));
        localIntent.putExtra("Retr_MsgAppBrandFromScene", 1);
      }
      label551:
      long l;
      if (((k.b)localObject1).type == 6)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1203L, 7L, 1L, false);
        l = paramcc.field_msgSvrId;
        localObject2 = (com.tencent.mm.message.a.b)((k.b)localObject1).aK(com.tencent.mm.message.a.b.class);
        if ((localObject2 == null) || (((com.tencent.mm.message.a.b)localObject2).nVD == 0L)) {
          break label1317;
        }
        l = ((com.tencent.mm.message.a.b)localObject2).nVD;
      }
      label1025:
      label1317:
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        localObject3 = ((k.b)localObject1).nRq;
        int i;
        if (((k.b)localObject1).nRh == 1)
        {
          i = 7;
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(14665, new Object[] { localObject3, Integer.valueOf(i), Integer.valueOf(((k.b)localObject1).nRd), Integer.valueOf(2), Long.valueOf((cn.bDv() - paramcc.getCreateTime()) / 1000L), ((k.b)localObject1).nRe, paramcc.field_talker, Integer.valueOf(1), "", Long.valueOf(l), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(cn.bDu()), Integer.valueOf(1) });
          if ((((k.b)localObject1).nRh == 0) && (((k.b)localObject1).nRd <= 26214400)) {
            break label876;
          }
        }
        label876:
        for (boolean bool = true;; bool = false)
        {
          localIntent.putExtra("Retr_Big_File", bool);
          localObject2 = com.tencent.mm.pluginsdk.model.app.n.bpU(((k.b)localObject1).hzM);
          if (localObject2 == null) {
            break label1025;
          }
          localObject3 = new com.tencent.mm.vfs.u(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
          if ((!((com.tencent.mm.vfs.u)localObject3).jKS()) || (((com.tencent.mm.vfs.u)localObject3).length() != ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen)) {
            break label882;
          }
          parama.a(localIntent, paramInt, parama1);
          AppMethodBeat.o(255261);
          return;
          i = 5;
          break;
        }
        label882:
        if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset > 0L) && (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen > ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_offset))
        {
          paramString = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          if ((paramcc.isClean()) || (j(paramcc, paramString)))
          {
            Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
            com.tencent.mm.ui.base.k.d(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gHD), parama.aezO.getContext().getString(R.l.app_tip), new e.b.3());
          }
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt == 0) {
              com.tencent.mm.ui.base.k.c(parama.aezO.getContext(), parama.aezO.getMMResources().getString(R.l.gDm), "", true);
            }
            AppMethodBeat.o(255261);
            return;
          }
        }
        Log.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[] { Integer.valueOf(((k.b)localObject1).nRd), ((k.b)localObject1).nRq, Util.secPrint(((k.b)localObject1).aesKey) });
        if (!bool)
        {
          a(parama, localIntent, paramcc, paramInt, parama1);
          AppMethodBeat.o(255261);
          return;
        }
        localIntent.putExtra("Retr_Big_File", bool);
        localObject3 = new com.tencent.mm.g.g();
        ((com.tencent.mm.g.g)localObject3).taskName = "task_ChattingItemAppMsg";
        ((com.tencent.mm.g.g)localObject3).lwL = new com.tencent.mm.g.g.a()
        {
          public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
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
                e.b.this.a(localIntent, paramInt, parama1);
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
              if ((paramcc.isClean()) || ((this.aehp != null) && (e.b.j(paramcc, this.aehp.field_fileFullPath)))) {
                com.tencent.threadpool.h.ahAA.bk(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179946);
                    Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                    com.tencent.mm.ui.base.k.d(e.b.this.aezO.getContext(), e.b.this.aezO.getContext().getString(R.l.gHD), e.b.this.aezO.getContext().getString(R.l.app_tip), new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int) {}
                    });
                    AppMethodBeat.o(179946);
                  }
                });
              } else {
                com.tencent.threadpool.h.ahAA.bk(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179947);
                    com.tencent.mm.ui.base.k.c(e.b.this.aezO.getContext(), e.b.this.aezO.getMMResources().getString(R.l.gDm), "", true);
                    AppMethodBeat.o(179947);
                  }
                });
              }
            }
          }
          
          public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
          
          public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
          {
            return new byte[0];
          }
        };
        ((com.tencent.mm.g.g)localObject3).field_mediaId = com.tencent.mm.modelcdntran.h.a("checkExist", Util.nowMilliSecond(), paramString, paramcc.field_msgId);
        ((com.tencent.mm.g.g)localObject3).field_fileId = ((k.b)localObject1).nRq;
        ((com.tencent.mm.g.g)localObject3).field_aesKey = ((k.b)localObject1).aesKey;
        ((com.tencent.mm.g.g)localObject3).field_filemd5 = ((k.b)localObject1).filemd5;
        ((com.tencent.mm.g.g)localObject3).field_fileType = com.tencent.mm.g.a.lwb;
        ((com.tencent.mm.g.g)localObject3).field_talker = paramString;
        ((com.tencent.mm.g.g)localObject3).field_priority = com.tencent.mm.g.a.lvZ;
        ((com.tencent.mm.g.g)localObject3).field_svr_signature = "";
        ((com.tencent.mm.g.g)localObject3).field_onlycheckexist = true;
        bool = com.tencent.mm.modelcdntran.k.bHW().g((com.tencent.mm.g.g)localObject3);
        Log.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[] { Boolean.valueOf(bool), ((com.tencent.mm.g.g)localObject3).field_fileId, ((com.tencent.mm.g.g)localObject3).field_mediaId, Util.secPrint(((com.tencent.mm.g.g)localObject3).field_aesKey) });
        if (!bool) {
          a(parama, localIntent, paramcc, paramInt, parama1);
        }
        AppMethodBeat.o(255261);
        return;
      }
    }
    
    static boolean a(Context paramContext, k.b paramb)
    {
      AppMethodBeat.i(255244);
      if ((paramb == null) || (paramContext == null))
      {
        AppMethodBeat.o(255244);
        return false;
      }
      boolean bool;
      if (e.n(paramb) == 3)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.x(paramContext, 16L);
        AppMethodBeat.o(255244);
        return bool;
      }
      if (paramb.type == 4)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.x(paramContext, 8L);
        AppMethodBeat.o(255244);
        return bool;
      }
      if (paramb.type == 5)
      {
        bool = com.tencent.mm.pluginsdk.model.app.h.x(paramContext, 32L);
        AppMethodBeat.o(255244);
        return bool;
      }
      if (paramb.type == 6)
      {
        paramb = com.tencent.mm.pluginsdk.e.a.boO(paramb.nRe);
        if (paramb == null)
        {
          AppMethodBeat.o(255244);
          return false;
        }
        bool = com.tencent.mm.pluginsdk.model.app.h.x(paramContext, paramb.longValue());
        AppMethodBeat.o(255244);
        return bool;
      }
      AppMethodBeat.o(255244);
      return false;
    }
    
    private static boolean a(com.tencent.mm.ui.chatting.d.a parama, Intent paramIntent, cc paramcc, int paramInt, com.tencent.mm.br.c.a parama1)
    {
      AppMethodBeat.i(255265);
      if ((paramcc.isClean()) || (j(paramcc, null)))
      {
        Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
        com.tencent.mm.ui.base.k.d(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gHD), parama.aezO.getContext().getString(R.l.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(255265);
        return true;
      }
      parama.a(paramIntent, paramInt, parama1);
      AppMethodBeat.o(255265);
      return false;
    }
    
    static boolean bBu(String paramString)
    {
      AppMethodBeat.i(36755);
      boolean bool = Util.isImageExt(paramString);
      AppMethodBeat.o(36755);
      return bool;
    }
    
    static boolean bBv(String paramString)
    {
      AppMethodBeat.i(255248);
      if (aeNb == null)
      {
        HashSet localHashSet = new HashSet();
        aeNb = localHashSet;
        localHashSet.add("h264");
        aeNb.add("h26l");
        aeNb.add("264");
        aeNb.add("avc");
        aeNb.add("mov");
        aeNb.add("mp4");
        aeNb.add("m4a");
        aeNb.add("3gp");
        aeNb.add("3g2");
        aeNb.add("mj2");
        aeNb.add("m4v");
        aeNb.add("swf");
        aeNb.add("vob");
        aeNb.add("mpg");
        aeNb.add("rmvb");
      }
      boolean bool = aeNb.contains(paramString);
      AppMethodBeat.o(255248);
      return bool;
    }
    
    public static boolean bBw(String paramString)
    {
      boolean bool = false;
      AppMethodBeat.i(36759);
      Object localObject = r.bKa().d(paramString, false, true);
      if (!com.tencent.mm.vfs.y.ZC((String)localObject))
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
    
    public static boolean j(cc paramcc, String paramString)
    {
      AppMethodBeat.i(36758);
      if ((System.currentTimeMillis() - paramcc.getCreateTime() > 259200000L) && ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.y.ZC(paramString))))
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
    public static int[] Aqo = { R.h.fzE, R.h.fzF, R.h.fzG, R.h.fzH, R.h.fzI };
    protected TextView Aoo;
    private ArrayList<MMImageView> RhU;
    protected FrameLayout aeNA;
    protected LinearLayout aeNB;
    protected LinearLayout aeNC;
    protected ViewStub aeND;
    protected ImageView aeNE;
    protected ImageView aeNF;
    ImageView aeNG;
    protected LinearLayout aeNH;
    protected ImageView aeNI;
    protected TextView aeNJ;
    protected ImageView aeNK;
    protected TextView aeNL;
    protected TextView aeNM;
    protected LinearLayout aeNN;
    protected ImageView aeNO;
    protected ImageView aeNP;
    protected ImageView aeNQ;
    protected TextView aeNR;
    protected LinearLayout aeNS;
    protected ImageView aeNT;
    LinearLayout aeNU;
    TextView aeNV;
    TextView aeNW;
    ImageView aeNX;
    ImageView aeNY;
    ImageView aeNZ;
    protected MMImageView aeNf;
    protected MMNeat7extView aeNg;
    protected ImageView aeNh;
    protected ImageView aeNi;
    protected TextView aeNj;
    protected LinearLayout aeNk;
    protected TextView aeNl;
    protected ImageView aeNm;
    protected MMPinProgressBtn aeNn;
    protected ImageView aeNo;
    protected ImageView aeNp;
    protected ImageView aeNq;
    protected ImageView aeNr;
    protected TextView aeNs;
    protected ChattingItemFooter aeNt;
    protected ImageView aeNu;
    protected LinearLayout aeNv;
    protected ViewGroup aeNw;
    protected TextView aeNx;
    protected LinearLayout aeNy;
    protected RelativeLayout aeNz;
    TextView aeOa;
    ImageView aeOb;
    LinearLayout aeOc;
    MMNeat7extView aeOd;
    ImageView aeOe;
    ImageView aeOf;
    ImageView aeOg;
    TextView aeOh;
    TextView aeOi;
    TextView aeOj;
    LinearLayout aeOk;
    LinearLayout aeOl;
    ImageView aeOm;
    TextView aeOn;
    TextView aeOo;
    ImageView aeOp;
    RelativeLayout aeOq;
    LinearLayout aeOr;
    TextView aeOs;
    public int aeOt;
    private int aeOu;
    protected TextView plr;
    protected ImageView rpw;
    
    c()
    {
      AppMethodBeat.i(36762);
      this.aeOt = 0;
      this.aeOu = 2147483647;
      this.RhU = new ArrayList();
      AppMethodBeat.o(36762);
    }
    
    private static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt, String paramString)
    {
      AppMethodBeat.i(255290);
      int i = 0;
      while (i <= 4)
      {
        localObject1 = (MMImageView)paramc.aeNC.findViewById(Aqo[i]);
        if (localObject1 != null)
        {
          ((MMImageView)localObject1).setImageDrawable(null);
          ((MMImageView)localObject1).setVisibility(8);
        }
        i += 1;
      }
      Object localObject1 = (ImageView)paramc.aeNC.findViewById(R.h.fzJ);
      Object localObject2 = (TextView)paramc.aeNC.findViewById(R.h.fzD);
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
          localObject1 = (MMImageView)paramc.aeNC.findViewById(Aqo[i]);
          ((MMImageView)localObject1).setImageResource(R.k.chatting_note_default_img_one);
          ((MMImageView)localObject1).setVisibility(0);
          localObject2 = r.bKa().v("Note_" + paramArrayOfString1[i], "", "");
          localObject3 = new com.tencent.mm.modelimage.loader.a.c.a();
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).oKs = 1;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).oKJ = true;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).oKE = R.k.chatting_note_default_img;
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).npU = ((int)parama.aezO.getMMResources().getDimension(R.f.ChatItemThumWidth));
          ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).npV = ((int)parama.aezO.getMMResources().getDimension(R.f.ChatItemThumWidth));
          localObject3 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject3).bKx();
          if (!com.tencent.mm.vfs.y.ZC((String)localObject2)) {
            break label333;
          }
          r.bKe().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.modelimage.loader.a.c)localObject3);
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
          localObject1 = (MMImageView)paramc.aeNC.findViewById(Aqo[(i + 1)]);
          ((MMImageView)localObject1).setImageResource(R.k.chatting_note_default_img);
          break label153;
          localObject1 = as.iII();
          localObject2 = (com.tencent.mm.pluginsdk.model.app.k.a)parama.cm(com.tencent.mm.ui.chatting.component.api.m.class);
          localObject3 = paramArrayOfString1[i];
          l = Util.nowMilliSecond();
          str1 = paramArrayOfString2[i];
          str2 = paramArrayOfString3[i];
          j = paramArrayOfInt[i];
          str3 = r.bKa().v("Note_".concat(String.valueOf(localObject3)), "", "");
        } while (com.tencent.mm.vfs.y.ZC(str3));
        com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
        localg.taskName = "task_AppMessageExtension_2";
        localg.field_mediaId = com.tencent.mm.modelcdntran.h.a("downappthumb", l, paramString, String.valueOf(localObject3));
        localg.field_fullpath = str3;
        localg.field_fileType = com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;
        localg.field_totalLen = j;
        localg.field_aesKey = str1;
        localg.field_fileId = str2;
        localg.field_priority = com.tencent.mm.g.a.lwa;
        if (com.tencent.mm.storage.au.bwE(paramString)) {}
        for (int j = 1;; j = 0)
        {
          localg.field_chattype = j;
          Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString });
          localg.lwL = new k.2((com.tencent.mm.pluginsdk.model.app.k)localObject1, (com.tencent.mm.pluginsdk.model.app.k.a)localObject2, str2);
          com.tencent.mm.modelcdntran.k.bHW().b(localg, -1);
          break;
        }
      }
      AppMethodBeat.o(255290);
    }
    
    public static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb)
    {
      AppMethodBeat.i(255293);
      parama = paramb.B(parama.aezO.getContext(), false);
      if (!Util.isNullOrNil(parama))
      {
        paramc.aeNk.setVisibility(0);
        paramc.Aoo.setVisibility(0);
        paramc.aeNh.setVisibility(0);
        paramc.Aoo.setText(parama);
        if (com.tencent.mm.message.k.a.nQW.ordinal() == paramb.nTK)
        {
          paramc.aeNh.setImageResource(R.k.my_life_around_default_icon);
          AppMethodBeat.o(255293);
          return;
        }
        if ((com.tencent.mm.message.k.a.nQX.ordinal() == paramb.nTK) || (!Util.isNullOrNil(paramb.nTO))) {
          if (!Util.isNullOrNil(paramb.nTO)) {
            break label148;
          }
        }
      }
      label148:
      for (parama = paramb.nTY;; parama = paramb.nTO)
      {
        r.bKd().a(parama, new s.a()
        {
          public final void onLoadImageEnd(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
          {
            AppMethodBeat.i(255254);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(255401);
                e.c.this.aeNh.setImageBitmap(paramAnonymousBitmap);
                AppMethodBeat.o(255401);
              }
            });
            AppMethodBeat.o(255254);
          }
        });
        AppMethodBeat.o(255293);
        return;
      }
    }
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, cc paramcc, boolean paramBoolean)
    {
      AppMethodBeat.i(36768);
      paramc.aeNB.setVisibility(8);
      paramc.aeOc.setVisibility(0);
      paramc.aeOl.setVisibility(0);
      com.tencent.mm.message.e locale;
      int i;
      if ((paramb.title != null) && (paramb.title.length() > 0))
      {
        paramc.aeOd.setMaxLines(2);
        paramc.aeOd.setVisibility(0);
        paramc.aeOd.aZ(paramb.getTitle());
        locale = (com.tencent.mm.message.e)paramb.aK(com.tencent.mm.message.e.class);
        if (locale == null) {
          break label464;
        }
        i = locale.duration;
        label99:
        String str = com.tencent.mm.message.m.uD(i);
        if (Util.isNullOrNil(str)) {
          break label470;
        }
        paramc.aeOi.setVisibility(0);
        paramc.aeOi.setText(str);
      }
      for (;;)
      {
        paramc.aeOg.setVisibility(0);
        if ((locale != null) && (com.tencent.mm.message.x.uE(locale.nQq)))
        {
          paramc.aeOi.setVisibility(8);
          paramc.aeOg.setVisibility(8);
        }
        an.a(parama.aezO.getContext(), paramb, paramc.aeOf, paramc.aeOh);
        an.b(paramc.aeOj, paramb);
        paramc.aeNm.setVisibility(4);
        i = com.tencent.mm.cd.a.br(parama.aezO.getContext(), R.f.chatting_normal_item_width) - com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 24);
        int j = i * 9 / 16;
        if (com.tencent.mm.cd.a.getScaleSize(parama.aezO.getContext()) > 1.0F)
        {
          int k = (int)((paramc.aeOt / com.tencent.mm.ce.c.iRs() - com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 29) * com.tencent.mm.cd.a.getScaleSize(parama.aezO.getContext())) * 9.0F / 16.0F);
          if (paramc.aeOq.getLayoutParams().height != k)
          {
            paramc.aeOq.getLayoutParams().height = k;
            paramc.aeOq.requestLayout();
          }
        }
        if ((!paramBoolean) && (Util.isNullOrNil(paramb.thumburl))) {
          break label482;
        }
        parama = com.tencent.mm.api.b.U(paramb.thumburl, 4);
        paramb = new com.tencent.mm.modelimage.loader.a.c.a();
        paramb.oKB = R.e.chatting_item_biz_default_bg;
        paramb.oKo = true;
        paramb.fullPath = com.tencent.mm.pluginsdk.model.y.bpF(parama);
        paramcc = paramb.eG(i, j);
        paramcc.oKe = new com.tencent.mm.pluginsdk.ui.applet.n(4);
        paramcc.oKN = new com.tencent.mm.pluginsdk.ui.applet.e(4);
        paramcc.oKn = true;
        r.bKe().a(parama, paramc.aeOe, paramb.bKx());
        AppMethodBeat.o(36768);
        return;
        paramc.aeOd.setVisibility(8);
        break;
        label464:
        i = 0;
        break label99;
        label470:
        paramc.aeOi.setVisibility(8);
      }
      label482:
      paramb = null;
      if (!e.b.bBw(paramcc.field_imgPath)) {
        paramb = r.bKa().a(paramcc.field_imgPath, com.tencent.mm.cd.a.getDensity(parama.aezO.getContext()), false);
      }
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        paramc.aeOe.setImageBitmap(paramb);
        AppMethodBeat.o(36768);
        return;
      }
      paramc.aeOe.setImageResource(R.e.chatting_item_biz_default_bg);
      AppMethodBeat.o(36768);
    }
    
    static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, boolean paramBoolean)
    {
      AppMethodBeat.i(36767);
      paramc.aeNg.setVisibility(8);
      String str;
      Object localObject1;
      Object localObject3;
      label218:
      Object localObject2;
      int i;
      if ((paramb.title != null) && (paramb.title.trim().length() > 0))
      {
        str = paramb.title;
        paramc.aeNl.setVisibility(0);
        paramc.aeNl.setMaxLines(2);
        paramc.plr.setMaxLines(4);
        paramc.aeNr.setVisibility(8);
        paramc.aeNm.setVisibility(4);
        if (paramBoolean) {
          paramc.aeNf.setVisibility(8);
        }
        localObject1 = new tr();
        ((tr)localObject1).hXt.type = 0;
        ((tr)localObject1).hXt.hXv = paramb.nRF;
        ((tr)localObject1).publish();
        localObject3 = ((tr)localObject1).hXu.hXD;
        if (localObject3 == null) {
          break label1112;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b(paramc.aeNl.getContext(), Util.nullAs(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.aeNl.getTextSize());
        paramc.aeNl.setText((CharSequence)localObject1);
        localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
        if (localObject1 != null) {
          break label542;
        }
        Log.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.nRF });
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 100) {
            localObject2 = ((String)localObject1).substring(0, 100);
          }
        }
        paramc.plr.setText(com.tencent.mm.pluginsdk.ui.span.p.b(paramc.plr.getContext(), Util.nullAs((String)localObject2, paramb.description), paramc.plr.getTextSize()));
        paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).nUC.iterator();
        i = 0;
        localObject2 = null;
        localObject1 = null;
        label302:
        do
        {
          if (!paramb.hasNext()) {
            break;
          }
          localObject3 = (arf)paramb.next();
        } while ((com.tencent.mm.plugin.fav.ui.l.j((arf)localObject3)) && (!Util.isNullOrNil(((arf)localObject3).ZzG)) && (((arf)localObject3).ZzG.equals("WeNoteHtmlFile")));
        if (((arf)localObject3).Zzy.ZAf.ZAT == null) {
          break label567;
        }
        str = parama.aezO.getContext().getString(R.l.record_chatroom_title);
        i = 1;
        label387:
        switch (((arf)localObject3).dataType)
        {
        }
      }
      for (;;)
      {
        break label302;
        paramc.aeNl.setVisibility(8);
        str = null;
        break;
        label542:
        localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        break label218;
        label567:
        if (((arf)localObject3).Zzy.ZAf.hQQ == null) {
          break label1109;
        }
        if (localObject1 == null)
        {
          localObject1 = ((arf)localObject3).ZzA;
          break label387;
        }
        if (localObject1 == ((arf)localObject3).ZzA) {
          break label1109;
        }
        localObject2 = ((arf)localObject3).ZzA;
        break label387;
        if (paramBoolean)
        {
          paramc.aeNf.setVisibility(0);
          paramc.aeNf.setImageResource(R.k.app_attach_file_icon_voice);
        }
        break label302;
        break label302;
        if (paramBoolean)
        {
          paramc.aeNf.setVisibility(0);
          paramc.aeNf.setImageResource(R.g.app_attach_file_icon_pic);
        }
        break label302;
        if (paramBoolean)
        {
          paramc.aeNf.setVisibility(0);
          paramc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
        }
        break label302;
        if ((paramBoolean) && (!com.tencent.mm.plugin.fav.a.b.dQh()))
        {
          paramc.aeNf.setVisibility(0);
          paramc.aeNf.setImageResource(R.k.icons_outlined_finder_icon);
          break label302;
          if (paramBoolean)
          {
            paramc.aeNf.setVisibility(0);
            paramc.aeNf.setImageResource(R.k.app_attach_file_icon_video);
          }
          paramc.aeNr.setVisibility(0);
          paramc.aeNr.setImageResource(R.g.video_download_btn);
          break label302;
          paramc.aeNf.setVisibility(0);
          paramc.aeNf.setImageResource(R.k.app_attach_file_icon_location);
          break label302;
          if (paramBoolean)
          {
            paramc.aeNf.setVisibility(0);
            paramc.aeNf.setImageResource(R.k.app_attach_file_icon_music);
          }
          paramc.aeNr.setVisibility(0);
          paramc.aeNr.setImageResource(R.g.music_playicon);
          break label302;
          if (paramBoolean)
          {
            paramc.aeNf.setVisibility(0);
            paramc.aeNf.setImageResource(R.k.app_attach_file_icon_music);
          }
          paramc.aeNr.setVisibility(0);
          paramc.aeNr.setImageResource(R.g.music_playicon);
          break label302;
          if (paramBoolean)
          {
            paramc.aeNf.setVisibility(0);
            paramc.aeNf.setImageResource(com.tencent.mm.pluginsdk.f.boR(((arf)localObject3).ZyU));
          }
          break label302;
          if (paramBoolean)
          {
            paramc.aeNf.setVisibility(0);
            paramc.aeNf.setImageResource(R.k.app_attach_file_icon_unknow);
          }
          break label302;
          if (paramBoolean)
          {
            paramc.aeNf.setVisibility(0);
            paramc.aeNf.setImageResource(R.g.default_avatar);
          }
        }
      }
      if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
        paramb = parama.aezO.getContext().getString(R.l.favorite_record_chatroom_title, new Object[] { localObject1 });
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramb))
        {
          paramc.aeNl.setText(paramb);
          paramc.aeNl.setVisibility(0);
        }
        paramc.aeNf.setVisibility(8);
        paramc.aeNz.setVisibility(8);
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
                paramb = parama.aezO.getContext().getString(R.l.favorite_record_chat_title, new Object[] { localObject1, localObject2 });
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
    
    public static void a(c paramc, Boolean paramBoolean, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255260);
      long l = paramcc.field_msgId;
      com.tencent.mm.pluginsdk.model.app.c localc = as.cWJ().yi(l);
      if (localc == null)
      {
        Log.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString });
        AppMethodBeat.o(255260);
        return;
      }
      if (paramBoolean.booleanValue()) {
        if (localc.field_status == 101L)
        {
          paramc.aeNq.setVisibility(0);
          paramc.aeNn.setVisibility(0);
          paramc.aeNo.setVisibility(0);
        }
      }
      for (;;)
      {
        if (paramcc.field_status == 5)
        {
          paramc.aeNq.setVisibility(8);
          paramc.aeNp.setVisibility(8);
        }
        paramc.aeNq.setOnClickListener(new e.c.1(paramBoolean, l, paramcc, paramString));
        paramc.aeNp.setOnClickListener(new e.c.2(paramBoolean, l, paramString, paramcc));
        AppMethodBeat.o(255260);
        return;
        if (localc.field_status == 102L)
        {
          paramc.aeNq.setVisibility(8);
          paramc.aeNn.setVisibility(8);
          paramc.aeNo.setVisibility(8);
        }
        else
        {
          paramc.aeNq.setVisibility(8);
          paramc.aeNn.setVisibility(8);
          paramc.aeNo.setVisibility(8);
          continue;
          if (localc.field_status == 101L)
          {
            paramc.aeNq.setVisibility(0);
            paramc.aeNp.setVisibility(8);
          }
          else if (localc.field_status == 105L)
          {
            paramc.aeNq.setVisibility(8);
            paramc.aeNp.setVisibility(0);
          }
          else
          {
            paramc.aeNq.setVisibility(8);
            paramc.aeNp.setVisibility(8);
          }
        }
      }
    }
    
    public static void a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(36765);
      int i = com.tencent.mm.pluginsdk.model.app.n.bpT(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        paramc.aeNn.setVisibility(8);
        paramc.aeNo.setVisibility(8);
        AppMethodBeat.o(36765);
        return;
      }
      paramc.aeNn.setVisibility(0);
      paramc.aeNo.setVisibility(0);
      paramc.aeNn.setProgress(i);
      AppMethodBeat.o(36765);
    }
    
    static void b(com.tencent.mm.ui.chatting.d.a parama, c paramc, k.b paramb, cc paramcc, boolean paramBoolean)
    {
      AppMethodBeat.i(36769);
      Object localObject1 = new tr();
      ((tr)localObject1).hXt.type = 0;
      ((tr)localObject1).hXt.hXv = paramb.nRF;
      ((tr)localObject1).publish();
      Object localObject2 = ((tr)localObject1).hXu.hXD;
      paramc.aeNz.setVisibility(8);
      String[] arrayOfString1 = new String[4];
      String[] arrayOfString2 = new String[4];
      int[] arrayOfInt = new int[4];
      Object localObject3 = new String[4];
      String[] arrayOfString4 = new String[4];
      Object localObject4 = new int[4];
      String[] arrayOfString3 = new String[4];
      int k;
      int i;
      arf localarf;
      if (localObject2 != null)
      {
        localObject1 = null;
        paramb = Util.nullAs(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
        k = 0;
        Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject2).nUC.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          localarf = (arf)localIterator.next();
          if ((!com.tencent.mm.plugin.fav.ui.l.j(localarf)) || (Util.isNullOrNil(localarf.ZzG)) || (!localarf.ZzG.equals("WeNoteHtmlFile"))) {
            switch (localarf.dataType)
            {
            case 3: 
            case 6: 
            case 4: 
            case 5: 
            case 7: 
            default: 
            case 1: 
              label244:
              String str;
              do
              {
                do
                {
                  break;
                } while (k != 0);
                str = localarf.desc;
              } while (Util.isNullOrNil(str));
              if (Util.isNullOrNil(str.replaceAll("\n", "").trim())) {
                break label1211;
              }
              localObject1 = localarf.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
          }
        }
      }
      label795:
      label1202:
      label1205:
      label1211:
      for (;;)
      {
        k = 1;
        break;
        if (paramBoolean)
        {
          paramc.aeNz.setVisibility(0);
          paramc.aeNf.setVisibility(0);
          paramc.aeNf.setImageResource(R.g.app_attach_file_icon_pic);
        }
        if (i < 4)
        {
          arrayOfString1[i] = localarf.nRr;
          arrayOfString2[i] = localarf.ZyC;
          arrayOfInt[i] = ((int)localarf.Zzk);
          localObject3[i] = localarf.Ysw;
          arrayOfString4[i] = localarf.ZyH;
          localObject4[i] = ((int)localarf.Zza);
          arrayOfString3[i] = localarf.hIQ;
        }
        i += 1;
        break;
        if (!Util.isNullOrNil(paramb)) {
          break label244;
        }
        paramb = MMApplicationContext.getContext().getString(R.l.app_file) + localarf.title;
        break label244;
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
            break label1205;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).nUC.size() == 2))
          {
            localObject2 = MMApplicationContext.getContext().getString(R.l.favorite_wenote);
            paramb = (k.b)localObject1;
            localObject1 = localObject2;
            localObject1 = ((String)localObject1).trim();
            label612:
            if (localObject1 == null) {
              break label1202;
            }
            localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
          for (;;)
          {
            localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(paramc.aeNl.getContext(), (CharSequence)localObject1, (int)paramc.aeNl.getTextSize());
            paramc.aeNl.setText((CharSequence)localObject1);
            if ((paramb != null) && (paramb.length() > 100))
            {
              com.tencent.mm.smiley.j.iVg();
              paramb = paramb.substring(0, com.tencent.mm.smiley.j.iE(paramb, 100)).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            for (;;)
            {
              for (;;)
              {
                localObject1 = com.tencent.mm.pluginsdk.ui.span.p.d(paramc.plr.getContext(), paramb, (int)paramc.plr.getTextSize());
                paramc.plr.setText((CharSequence)localObject1);
                if (i > 0)
                {
                  paramc.aeNz.setVisibility(8);
                  if ((j != 0) || (k == 0) || (Util.isNullOrNil(paramb)))
                  {
                    paramc.plr.setVisibility(8);
                    paramc.aeNl.setMaxLines(2);
                    paramc.aeNE.setVisibility(8);
                    paramc.aeND.setLayoutResource(R.i.ggq);
                  }
                  try
                  {
                    if (paramc.aeNC == null) {
                      paramc.aeNC = ((LinearLayout)paramc.aeND.inflate());
                    }
                    for (;;)
                    {
                      if (i <= 4) {
                        break label1168;
                      }
                      j = 4;
                      a(parama, paramc, j, arrayOfString3, arrayOfString2, arrayOfString1, arrayOfInt, paramcc.field_talker);
                      parama = (ImageView)paramc.aeNC.findViewById(R.h.fzJ);
                      paramc = (TextView)paramc.aeNC.findViewById(R.h.fzD);
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
                      break label612;
                      paramc.plr.setMaxLines(1);
                      paramc.plr.setVisibility(0);
                      paramc.aeNl.setMaxLines(1);
                      break label795;
                      paramc.aeNC.setVisibility(0);
                    }
                  }
                  catch (Exception paramb)
                  {
                    for (;;)
                    {
                      paramc.aeND.setVisibility(0);
                      continue;
                      j = i;
                    }
                  }
                }
              }
              paramc.aeND.setVisibility(8);
              paramc.aeNE.setVisibility(0);
              AppMethodBeat.o(36769);
              return;
            }
          }
        }
      }
    }
    
    public final c O(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(36763);
      super.create(paramView);
      this.aeNS = ((LinearLayout)paramView.findViewById(R.h.fwx));
      this.aeNf = ((MMImageView)paramView.findViewById(R.h.fxc));
      this.aeNg = ((MMNeat7extView)paramView.findViewById(R.h.fxe));
      this.aeNl = ((TextView)paramView.findViewById(R.h.fxh));
      this.plr = ((TextView)paramView.findViewById(R.h.fwH));
      this.Aoo = ((TextView)paramView.findViewById(R.h.fwZ));
      this.aeNh = ((ImageView)paramView.findViewById(R.h.fwW));
      this.aeNj = ((TextView)paramView.findViewById(R.h.fwY));
      this.aeNi = ((ImageView)paramView.findViewById(R.h.fwX));
      this.aeNk = ((LinearLayout)paramView.findViewById(R.h.fwV));
      this.aeNm = ((ImageView)paramView.findViewById(R.h.fxa));
      this.aeNn = ((MMPinProgressBtn)paramView.findViewById(R.h.fxO));
      this.aeNo = ((ImageView)this.convertView.findViewById(R.h.fxN));
      this.aeNp = ((ImageView)this.convertView.findViewById(R.h.fxD));
      this.aeNq = ((ImageView)this.convertView.findViewById(R.h.fAl));
      this.aeNr = ((ImageView)paramView.findViewById(R.h.fwJ));
      this.aeNs = ((TextView)paramView.findViewById(R.h.fwD));
      this.aeNu = ((ImageView)paramView.findViewById(R.h.fwU));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.maskView = paramView.findViewById(R.h.fzn);
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.aeNt = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
      this.aeNv = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
      this.aeNw = ((ViewGroup)paramView.findViewById(R.h.fNj));
      this.aeNx = ((TextView)paramView.findViewById(R.h.fNg));
      this.aeNy = ((LinearLayout)paramView.findViewById(R.h.fxi));
      this.aeNA = ((FrameLayout)paramView.findViewById(R.h.chatting_click_area));
      this.aeNB = ((LinearLayout)paramView.findViewById(R.h.fwE));
      this.aeNF = ((ImageView)paramView.findViewById(R.h.fxB));
      this.aeNz = ((RelativeLayout)paramView.findViewById(R.h.fxb));
      this.aeND = ((ViewStub)paramView.findViewById(R.h.fSc));
      this.aeNE = ((ImageView)paramView.findViewById(R.h.fxG));
      if (!paramBoolean)
      {
        this.aeNG = ((ImageView)this.convertView.findViewById(R.h.chatting_status_tick));
        this.uploadingPB = ((ProgressBar)this.convertView.findViewById(R.h.gbo));
      }
      this.aeNN = ((LinearLayout)paramView.findViewById(R.h.fwl));
      this.aeNK = ((ImageView)paramView.findViewById(R.h.fwy));
      this.aeNL = ((TextView)paramView.findViewById(R.h.fwA));
      this.aeNR = ((TextView)paramView.findViewById(R.h.fww));
      this.aeNQ = ((ImageView)paramView.findViewById(R.h.error_icon_iv));
      this.aeNO = ((ImageView)paramView.findViewById(R.h.fwm));
      this.aeNP = ((ImageView)paramView.findViewById(R.h.fwj));
      this.aeNH = ((LinearLayout)paramView.findViewById(R.h.fwk));
      this.aeNI = ((ImageView)paramView.findViewById(R.h.fvN));
      this.aeNJ = ((TextView)paramView.findViewById(R.h.fvO));
      this.aeNM = ((TextView)paramView.findViewById(R.h.fwz));
      this.rpw = ((ImageView)paramView.findViewById(R.h.fvP));
      this.aeNT = ((ImageView)paramView.findViewById(R.h.fvQ));
      this.aeNU = ((LinearLayout)paramView.findViewById(R.h.fwp));
      this.aeNV = ((TextView)paramView.findViewById(R.h.fwv));
      this.aeNW = ((TextView)paramView.findViewById(R.h.fwr));
      this.aeNX = ((ImageView)paramView.findViewById(R.h.fws));
      this.aeNY = ((ImageView)paramView.findViewById(R.h.fwq));
      this.aeNZ = ((ImageView)paramView.findViewById(R.h.fwt));
      this.aeOa = ((TextView)paramView.findViewById(R.h.fwu));
      this.aeOb = ((ImageView)paramView.findViewById(R.h.fwo));
      this.aeOc = ((LinearLayout)paramView.findViewById(R.h.fwL));
      this.aeOg = ((ImageView)paramView.findViewById(R.h.fwP));
      this.aeOd = ((MMNeat7extView)paramView.findViewById(R.h.fwQ));
      this.aeOe = ((ImageView)paramView.findViewById(R.h.fwO));
      this.aeOk = ((LinearLayout)paramView.findViewById(R.h.fOC));
      this.aeOl = ((LinearLayout)paramView.findViewById(R.h.fOE));
      this.aeOp = ((ImageView)paramView.findViewById(R.h.fOD));
      this.aeOq = ((RelativeLayout)paramView.findViewById(R.h.fwM));
      this.aeOm = ((ImageView)this.aeOk.findViewById(R.h.fwI));
      this.aeOn = ((TextView)this.aeOk.findViewById(R.h.fwK));
      this.aeOo = ((TextView)this.aeOk.findViewById(R.h.fwT));
      this.aeOf = ((ImageView)this.aeOl.findViewById(R.h.fwI));
      this.aeOh = ((TextView)this.aeOl.findViewById(R.h.fwK));
      this.aeOj = ((TextView)this.aeOl.findViewById(R.h.fwT));
      this.aeOi = ((TextView)paramView.findViewById(R.h.fwN));
      this.aeOr = ((LinearLayout)paramView.findViewById(R.h.fxf));
      this.aeOs = ((TextView)paramView.findViewById(R.h.fxg));
      if ((this.aeNl != null) && (Build.VERSION.SDK_INT >= 16)) {
        this.aeOu = this.aeNl.getMaxLines();
      }
      this.aeOt = c.nm(MMApplicationContext.getContext());
      AppMethodBeat.o(36763);
      return this;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(36764);
      if (this.aeNl != null) {
        this.aeNl.setMaxLines(this.aeOu);
      }
      AppMethodBeat.o(36764);
    }
  }
  
  public static final class d
    extends c
  {
    private boolean Aeu;
    protected v.l aeOA;
    protected v.j aeOB;
    protected v.i aeOz;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public static boolean a(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(36799);
      if ((com.tencent.mm.n.a.dm(parama.aezO.getContext())) || (com.tencent.mm.n.a.dl(parama.aezO.getContext())) || (com.tencent.mm.n.a.dp(parama.aezO.getContext())))
      {
        Log.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
        AppMethodBeat.o(36799);
        return true;
      }
      if (paramc.a(parama, paramb, paramcc))
      {
        AppMethodBeat.o(36799);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.u.ab(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.u.ab(paramb.nRc, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.aezO.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, paramcc.field_msgId, paramcc.field_msgSvrId, paramcc);
        AppMethodBeat.o(36799);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, boolean paramBoolean, String paramString1, String paramString2, c paramc)
    {
      AppMethodBeat.i(255268);
      Intent localIntent = new Intent();
      localIntent.putExtra("message_id", paramcc.field_msgId);
      localIntent.putExtra("Retr_Security_Msg_Id", paramcc.field_msgId);
      localIntent.putExtra("big_appmsg", paramBoolean);
      int i = ac.aX(paramString2, parama.getTalkerUserName());
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localIntent.putExtra("preUsername", paramString2);
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preChatTYPE", i);
      localIntent.putExtra("msgUsername", paramString1);
      localIntent.putExtra("serverMsgID", String.valueOf(paramcc.field_msgSvrId));
      localIntent.putExtra("chatTypeForAppbrand", com.tencent.mm.modelappbrand.a.KG(parama.getTalkerUserName()));
      e.a.a(localIntent, parama, paramcc, paramc);
      com.tencent.mm.modelstat.a.an(paramcc);
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
      AppMethodBeat.o(255268);
      return true;
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(161905);
      Object localObject = com.tencent.mm.ui.tools.x.afLD;
      com.tencent.mm.ui.tools.x.jDs();
      if ((Util.isNullOrNil(paramb.nTE)) && (Util.isNullOrNil(paramb.nTD)))
      {
        paramcc = paramb.url;
        if (parama.juG()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.u.ab(paramcc, paramc);
          paramcc = new Intent();
          paramcc.putExtra("rawUrl", paramc);
          paramcc.putExtra("webpageTitle", paramb.title);
          paramcc.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
          AppMethodBeat.o(161905);
          return true;
        }
      }
      localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramcc);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.juG()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.an.h.ac(paramcc));
        localBundle.putInt("chat_type", com.tencent.mm.modelappbrand.a.KG(parama.getTalkerUserName()));
        ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(parama.aezO.getContext(), parama.getTalkerUserName(), paramc.a(parama, paramcc), parama.juG(), paramb, localBundle);
        AppMethodBeat.o(161905);
        return true;
        if (com.tencent.mm.model.ab.IS((String)localObject)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean c(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(36800);
      Object localObject1 = (com.tencent.mm.message.a)paramb.aK(com.tencent.mm.message.a.class);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.message.a)localObject1).nPh)) && (!Util.isNullOrNil(((com.tencent.mm.message.a)localObject1).nPj)))
      {
        String str2 = ((com.tencent.mm.message.a)localObject1).nPh;
        String str3 = ((com.tencent.mm.message.a)localObject1).nPg;
        String str1;
        int i;
        if (Util.isNullOrNil(((com.tencent.mm.message.a)localObject1).nPk))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.message.a)localObject1).nPi;
          paramb = paramb.nTE;
          localObject1 = ((com.tencent.mm.message.a)localObject1).nPj;
          Log.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", new Object[] { str2, str3, str1, str4, paramb, localObject1 });
          Object localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
          if (!com.tencent.mm.storage.au.bwE(parama.getTalkerUserName())) {
            break label308;
          }
          i = 2;
          label155:
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(17608, new Object[] { Integer.valueOf(i), paramb, Integer.valueOf(1), Integer.valueOf(1) });
          if (Util.isNullOrNil(str2)) {
            break label314;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_chatting_wording", str1);
          ((Bundle)localObject2).putString("key_chatting_text", str4);
          ((Bundle)localObject2).putString("key_chatting_appid", paramb);
          ((Bundle)localObject2).putLong("key_msg_id", paramcc.field_msgId);
          ((Bundle)localObject2).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject2).putString("key_sender_username", paramc.a(parama, paramcc));
          e.a(parama, str2, str3, (String)localObject1, (Bundle)localObject2);
        }
        for (;;)
        {
          AppMethodBeat.o(36800);
          return true;
          str1 = ((com.tencent.mm.message.a)localObject1).nPk;
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
    
    public static boolean d(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(36801);
      Log.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.nTD, paramb.nTC, paramb.nTE, paramb.url, Integer.valueOf(paramb.nTW), paramb.nTG });
      if ((44 == paramb.type) && ((!paramb.gK(false)) || (Util.isNullOrNil(paramb.B(parama.aezO.getContext(), false)))))
      {
        AppMethodBeat.o(36801);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramcc);
      paramc = new Bundle();
      int i;
      if ((parama.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        paramc.putInt("stat_scene", i);
        paramc.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
        paramc.putString("stat_chat_talker_username", (String)localObject);
        paramc.putString("stat_send_msg_user", str);
        i = com.tencent.mm.modelappbrand.a.KG(parama.getTalkerUserName());
        switch (paramb.nTF)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.dC(paramcc);
        if (i != 0) {
          break label657;
        }
        AppMethodBeat.o(36801);
        return true;
        if (parama.juG())
        {
          i = 2;
          break;
        }
        if (com.tencent.mm.model.ab.IS((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        Intent localIntent = new Intent();
        localIntent.putExtra("key_username", paramb.nTD);
        if (parama.juG())
        {
          localIntent.putExtra("key_from_scene", 1);
          localIntent.putExtra("key_scene_note", (String)localObject + ":" + str);
        }
        for (;;)
        {
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.nTE;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).qHO = paramb.nTW;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.nTH;
          localIntent.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).cll());
          localIntent.putExtra("_stat_obj", paramc);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "appbrand", ".ui.AppBrandProfileUI", localIntent);
          i = 0;
          break;
          localIntent.putExtra("key_from_scene", 2);
          localIntent.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.b.a((String)localObject, str, 1073, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.an.h.ac(paramcc))
        {
          com.tencent.mm.modelappbrand.b.a((String)localObject, af.bHe().MI((String)localObject).field_nickname, 1157, paramb, paramc);
          i = 0;
        }
        else if (com.tencent.mm.model.ab.IS((String)localObject))
        {
          com.tencent.mm.modelappbrand.b.a((String)localObject, str, 1074, paramb, paramc);
          i = 0;
        }
        else
        {
          paramc.putString("chatroom_username", e.a(parama, (String)localObject));
          paramc.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.b.a((String)localObject, str, parama.juG(), paramb, paramc);
          i = 0;
          continue;
          paramc.putString("chatroom_username", e.a(parama, (String)localObject));
          paramc.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.b.b((String)localObject, str, parama.juG(), paramb, paramc);
          i = 0;
        }
      }
      label657:
      AppMethodBeat.o(36801);
      return false;
    }
    
    public static boolean e(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(169872);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        Object localObject1 = new bp();
        ((bp)localObject1).hBE.msgId = paramcc.field_msgId;
        ((bp)localObject1).hBE.type = 0;
        ((bp)localObject1).hBE.hBF = true;
        ((bp)localObject1).publish();
        if (!Util.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", paramcc.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", paramcc.field_imgPath);
          paramb = com.tencent.mm.plugin.sns.data.m.lV(paramb.hQQ, paramcc.field_talker);
          if (!TextUtils.isEmpty(paramb)) {
            paramc.putExtra("sns_landing_pages_extra", paramb);
          }
          paramc.addFlags(268435456);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        ak localak = (ak)paramb.aK(ak.class);
        if ((localak != null) && (!Util.isNullOrNil(localak.WoZ)))
        {
          paramb = new gib();
          paramb.WoZ = localak.WoZ;
          paramb.Wpa = localak.Wpa;
          paramb.Wpb = localak.Wpb;
          paramb.Wpc = localak.Wpc;
          paramb.Wpd = localak.Wpd;
          paramb.Wph = localak.Wph;
          paramb.ytZ = localak.ytZ;
          paramb.svG = localak.svG;
          paramb.ICb = localak.ICb;
          paramb.Wpe = localak.Wpe;
          paramb.Wpf = localak.Wpf;
          paramb.Wpg = localak.Wpg;
          paramb.source = localak.source;
          paramb.ibx = localak.ibx;
          paramb.Wpi = localak.Wpi;
          paramb.Wpk = localak.Wpk;
          paramb.Wpl = localak.Wpl;
          paramb.Wpm = localak.Wpm;
          paramb.Wpj = localak.Wpj;
          paramc = com.tencent.mm.plugin.topstory.a.g.a(paramb, 32, parama.aezO.getContext().getString(R.l.fts_recommend_search_keyword));
          com.tencent.mm.plugin.topstory.a.h.a(paramb, paramcc);
          aj.a(parama.aezO.getContext(), paramc);
          AppMethodBeat.o(169872);
          return true;
        }
        Object localObject2 = paramb.url;
        PackageInfo localPackageInfo;
        Intent localIntent;
        int j;
        if (parama.juG())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.u.ab((String)localObject2, (String)localObject1);
          String str = paramb.url;
          localPackageInfo = c.getPackageInfo(parama.aezO.getContext(), paramb.appId);
          localIntent = new Intent();
          j = parama.aezO.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e((String)localObject2, 1, j, i);
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
            break label1364;
          }
          localIntent.putExtra("shortUrl", str);
          label702:
          if (localPackageInfo != null) {
            break label1380;
          }
          localObject2 = null;
          label710:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1390;
          }
          i = 0;
          label729:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.iaa))
          {
            localIntent.putExtra("srcUsername", paramb.iaa);
            localIntent.putExtra("srcDisplayname", paramb.iab);
          }
          localIntent.putExtra("msg_id", paramcc.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramcc.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramcc));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", paramcc.kLp);
          localIntent.putExtra("msgUsername", paramb.hQQ);
          localIntent.putExtra("serverMsgID", String.valueOf(paramcc.field_msgSvrId));
          localIntent.putExtra("KMsgType", paramcc.getType());
          localIntent.putExtra("KAppMsgType", paramb.type);
          i = ac.aX(paramc.a(parama, paramcc), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramcc.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.a(parama, paramcc));
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
            label1075:
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
            paramc = (com.tencent.mm.message.e)paramb.aK(com.tencent.mm.message.e.class);
            if (paramc == null) {
              break;
            }
          }
        }
        for (int i = paramc.nQm;; i = -1)
        {
          localIntent.putExtra(f.s.adwW, i);
          localIntent.putExtra("key_enable_teen_mode_check", true);
          e.a(paramb, parama, localIntent);
          localIntent.addFlags(536870912);
          e.a(localIntent, paramcc, paramb);
          if ((paramc == null) || (i != 16)) {
            break label1424;
          }
          paramb = new Bundle();
          paramb.putInt("biz_video_scene", 1);
          paramb.putInt(f.b.adwc, j);
          paramb.putInt("geta8key_scene", 1);
          paramb.putString("geta8key_username", parama.getTalkerUserName());
          if ((localak != null) && (!Util.isNullOrNil(localak.WoZ)))
          {
            paramc = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bmO(localak.WoZ);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b.a(parama.aezO.getContext(), paramcc.field_msgId, paramcc.field_msgSvrId, 0, paramb);
          AppMethodBeat.o(169872);
          return true;
          localObject1 = "singlemessage";
          break;
          label1364:
          localIntent.putExtra("shortUrl", paramb.url);
          break label702;
          label1380:
          localObject2 = localPackageInfo.versionName;
          break label710;
          label1390:
          i = localPackageInfo.versionCode;
          break label729;
          i = 2;
          break label1075;
          i = 3;
          break label1075;
          i = 5;
          break label1075;
        }
        label1424:
        c(parama, paramcc);
        if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(3)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(parama.aezO.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          Log.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
          AppMethodBeat.o(169872);
          return true;
        }
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(169872);
        return true;
      }
      AppMethodBeat.o(169872);
      return false;
    }
    
    public static boolean e(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255264);
      Object localObject = paramcc.field_content;
      Boolean localBoolean = Boolean.FALSE;
      if (localObject == null)
      {
        AppMethodBeat.o(255264);
        return false;
      }
      paramcc = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      localObject = com.tencent.mm.message.t.Hk((String)localObject);
      if (paramcc == null)
      {
        AppMethodBeat.o(255264);
        return false;
      }
      parama = localBoolean;
      if (localObject != null)
      {
        parama = localBoolean;
        if (((com.tencent.mm.message.t)localObject).nUJ != 0)
        {
          parama = Boolean.TRUE;
          paramcc.type = ((com.tencent.mm.message.t)localObject).nUJ;
        }
      }
      boolean bool = parama.booleanValue();
      AppMethodBeat.o(255264);
      return bool;
    }
    
    private v.i j(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36791);
      if (this.aeOz == null) {
        this.aeOz = new v.i(parama);
      }
      parama = this.aeOz;
      AppMethodBeat.o(36791);
      return parama;
    }
    
    private v.l k(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36792);
      if (this.aeOA == null) {
        this.aeOA = new v.l(parama);
      }
      parama = this.aeOA;
      AppMethodBeat.o(36792);
      return parama;
    }
    
    private v.j l(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36793);
      if (this.aeOB == null) {
        this.aeOB = new v.j(parama);
      }
      parama = this.aeOB;
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
        localObject = new ap(paramLayoutInflater, R.i.gfw);
        ((View)localObject).setTag(new e.c().O((View)localObject, true));
      }
      AppMethodBeat.o(36794);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(36795);
      final e.c localc = (e.c)parama;
      this.aeiK = parama1;
      localc.reset();
      String str = paramcc.getContent();
      Object localObject1 = (o)parama1.cm(o.class);
      ((o)localObject1).cN(paramcc);
      ((o)localObject1).cO(paramcc);
      ((o)localObject1).cP(paramcc);
      com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
      int i;
      if (this.Aeu)
      {
        i = paramcc.getContent().indexOf(':');
        if (i != -1) {
          str = paramcc.getContent().substring(i + 1);
        }
      }
      label1156:
      label5893:
      for (;;)
      {
        k.b localb;
        Object localObject3;
        int k;
        Object localObject2;
        com.tencent.mm.pluginsdk.model.app.g localg;
        label559:
        boolean bool1;
        if (str != null)
        {
          localb = k.b.aP(str, paramcc.aJM());
          localObject3 = com.tencent.mm.message.t.Hk(str);
          localObject1 = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
          i = 0;
          k = 0;
          localc.aeOr.setVisibility(8);
          localObject2 = localObject1;
          if (localb != null)
          {
            localc.aeNg.aZ(localb.getTitle());
            localc.plr.setText(localb.getDescription());
            localc.aeNl.setMaxLines(1);
            localc.aeNg.setTextColor(parama1.getContext().getResources().getColor(R.e.FG_0));
            localc.plr.setTextColor(parama1.getContext().getResources().getColor(R.e.half_alpha_black));
            localc.aeNB.setBackgroundResource(R.g.chatfrom_bg_app);
            localc.aeNB.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
            localc.aeNf.setVisibility(0);
            localc.aeNz.setVisibility(0);
            localc.plr.setVisibility(0);
            localc.aeNn.setVisibility(8);
            localc.aeNq.setVisibility(8);
            localc.aeNp.setVisibility(8);
            localc.aeND.setVisibility(8);
            localc.aeNE.setVisibility(8);
            localc.aeNi.setVisibility(8);
            localc.aeNj.setVisibility(8);
            localc.aeNN.setVisibility(8);
            localc.aeNH.setVisibility(8);
            localc.aeNB.setVisibility(0);
            localc.aeNU.setVisibility(8);
            localc.aeOc.setVisibility(8);
            localc.aeOk.setVisibility(8);
            localc.aeOp.setVisibility(8);
            localc.resetChatBubbleWidth(localc.aeNA, localc.aeOt);
            localb.aK(com.tencent.mm.message.h.class);
            localc.aeNA.setBackgroundResource(R.g.chatfrom_bg_app);
            localg = com.tencent.mm.pluginsdk.model.app.h.is(localb.appId, localb.appVersion);
            if (localg != null) {
              b(parama1, localb, paramcc);
            }
            if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
              break label1699;
            }
            localObject2 = localb.appName;
            bool1 = true;
            com.tencent.mm.cd.a.fromDPToPix(parama1.getContext(), 12);
            if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
              bool1 = o.a.iGH().gXa();
            }
            if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!iA((String)localObject2))) {
              break label1739;
            }
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), localg, (String)localObject2);
            if (localb.type != 19) {
              break label1709;
            }
            localc.Aoo.setText(parama1.getContext().getResources().getString(R.l.opensdk_source_tv_record, new Object[] { localObject2 }));
            label691:
            localc.Aoo.setVisibility(0);
            localc.Aoo.setCompoundDrawables(null, null, null, null);
            localc.aeNk.setVisibility(0);
            localc.aeNh.setVisibility(0);
            if ((localg == null) || (!localg.aqJ())) {
              break label1722;
            }
            a(parama1, localc.Aoo, paramcc, localb, localg.field_packageName, paramcc.aJH());
            label766:
            localc.aeNh.setImageResource(R.g.fnp);
            a(parama1, localc.aeNh, localb.appId);
            i = 1;
          }
        }
        label4231:
        label7561:
        for (;;)
        {
          label794:
          if (localb.bwn()) {
            localc.aeNk.setVisibility(8);
          }
          label1037:
          label1423:
          label2576:
          for (int j = 0;; j = i)
          {
            localc.aeNk.setBackgroundResource(R.g.mm_trans);
            bool1 = false;
            localc.aeNf.setVisibility(0);
            if ((!localb.bwo()) && (this.wQm))
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
                      if (!e.b.bBw(paramcc.aJL())) {
                        localObject2 = r.bKa().e(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                      }
                    }
                  }
                }
              }
              if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
              {
                localBitmap = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject2, false, com.tencent.mm.cd.a.fromDPToPix(parama1.getContext(), 1));
                localc.aeNf.setImageBitmap(localBitmap);
                label987:
                if (e.n(localb) != 3) {
                  break label2010;
                }
                localc.aeNB.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                {
                  private boolean aeOC = false;
                  
                  public final boolean onPreDraw()
                  {
                    AppMethodBeat.i(36771);
                    if (this.aeOC)
                    {
                      localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                    localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                    this.aeOC = true;
                    int i = com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 24);
                    Bitmap localBitmap = this.val$bitmap;
                    Object localObject;
                    if (localBitmap != null)
                    {
                      localObject = localBitmap;
                      if (!localBitmap.isRecycled()) {}
                    }
                    else
                    {
                      localObject = BitmapUtil.createColorBitmap(parama1.aezO.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                    }
                    int j = ((Bitmap)localObject).getHeight();
                    if (i > j) {
                      i = j;
                    }
                    for (;;)
                    {
                      localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                      j = localc.aeNB.getHeight();
                      int k = localc.aeNB.getWidth();
                      i = j;
                      if (j == 0) {
                        i = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_height);
                      }
                      j = k;
                      if (k == 0) {
                        j = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_width);
                      }
                      localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_from_content_bg_mask, j, i));
                      localc.aeNB.setBackgroundDrawable((Drawable)localObject);
                      AppMethodBeat.o(36771);
                      return true;
                    }
                  }
                });
                if (!aw.isDarkMode()) {
                  break label1999;
                }
                localc.aeNk.setBackgroundResource(R.g.mm_trans);
                if ((localb.kLg != null) && (localb.kLg.length() != 0)) {
                  break label2037;
                }
                localc.aeNs.setVisibility(8);
                label1066:
                localc.aeNr.setOnClickListener(null);
                localc.aeNv.setVisibility(0);
                localc.aeNm.setVisibility(8);
                localc.aeNy.setVisibility(0);
                localc.aeNw.setVisibility(8);
                i = e.n(localb);
                if (localb.type == 66)
                {
                  if ((TextUtils.isEmpty(localb.nTD)) && (TextUtils.isEmpty(localb.nTE))) {
                    break label2067;
                  }
                  i = 33;
                }
              }
            }
            label1584:
            label1722:
            label1739:
            label1999:
            label2010:
            label2666:
            label3434:
            label4207:
            label6257:
            switch (i)
            {
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
                    break label7548;
                  }
                  localc.aeNl.setVisibility(0);
                  localc.aeNl.setMaxLines(2);
                  localc.aeNl.setText(localb.title);
                  localc.aeNg.setVisibility(8);
                  if (bool1)
                  {
                    if ((localb.type != 33) && (localb.type != 36)) {
                      break label7561;
                    }
                    paramString = r.bKa().Oe(paramcc.aJL());
                    localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                    com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNf, "file://".concat(String.valueOf(paramString)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(50, 50));
                  }
                  if (localb.type == 44) {
                    e.c.a(parama1, localc, localb);
                  }
                }
                if (parama1.juG()) {
                  break label7738;
                }
                if (!com.tencent.mm.pluginsdk.model.app.h.k(localg)) {
                  break label7722;
                }
                localc.aeNu.setVisibility(0);
                c(parama1, localc.aeNu, bz.a(localb, paramcc));
                localObject2 = parama;
                if (i == 0)
                {
                  localc.aeNA.setTag(localObject2);
                  localc.aeNA.setOnClickListener(d(parama1));
                }
                if (this.wQm)
                {
                  localc.aeNA.setOnLongClickListener(c(parama1));
                  localc.aeNA.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
                }
                AppMethodBeat.o(36795);
                return;
                Log.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramcc.aJG()), paramString });
                localObject3 = null;
                localb = null;
                break;
                localObject2 = localg.field_appName;
                break label559;
                localc.Aoo.setText((CharSequence)localObject2);
                break label691;
                a(parama1, localc.Aoo, localb.appId);
                break label766;
                if (localb.type == 24)
                {
                  localc.Aoo.setText(MMApplicationContext.getContext().getString(R.l.favorite));
                  localc.aeNk.setVisibility(0);
                  localc.Aoo.setVisibility(0);
                  localc.aeNh.setVisibility(8);
                  i = 1;
                  break label794;
                }
                if ((localb.type == 83) || (localb.type == 84))
                {
                  localc.Aoo.setText(MMApplicationContext.getContext().getString(R.l.app_teen_mode));
                  localc.aeNk.setVisibility(0);
                  localc.Aoo.setVisibility(0);
                  localc.aeNh.setVisibility(8);
                  i = 1;
                  break label794;
                }
                if ((localb.type == 19) || ((localObject3 != null) && (((com.tencent.mm.message.t)localObject3).nUJ == 19)))
                {
                  localc.Aoo.setText(MMApplicationContext.getContext().getString(R.l.chatting_item_record));
                  localc.aeNk.setVisibility(0);
                  localc.Aoo.setVisibility(0);
                  localc.aeNh.setVisibility(8);
                  i = 1;
                  break label794;
                }
                if (e.a(localb, localc)) {
                  break label7778;
                }
                localc.aeNk.setVisibility(8);
                localc.Aoo.setVisibility(8);
                localc.aeNh.setVisibility(8);
                i = 0;
                break label794;
                bool1 = true;
                break label987;
                localc.aeNk.setBackgroundResource(R.g.fnl);
                break label1037;
                localc.aeNf.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.foI));
                bool1 = false;
                break label1037;
                localc.aeNs.setVisibility(0);
                b(parama1, localc.aeNs, bz.bBE(localb.kLg));
                break label1066;
                i = 5;
                break label1156;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.aeNg.setVisibility(0);
                  localc.aeNg.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                  localc.plr.setVisibility(0);
                  localc.plr.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                  localc.aeNl.setVisibility(8);
                  localc.aeNm.setVisibility(4);
                  localc.aeNr.setVisibility(0);
                  if (!(paramcc.aJG() + "_msg").equals(parama.playingMsgId)) {
                    break label2370;
                  }
                  localc.aeNr.setImageResource(R.g.music_pauseicon);
                  localc.plr.setMaxLines(2);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label2384;
                    }
                    localc.aeNf.setImageResource(R.k.app_attach_file_icon_music);
                  }
                }
                for (;;)
                {
                  parama = new e.g();
                  parama.msgId = paramcc.aJG();
                  parama.xml = paramcc.getContent();
                  parama.hQn = paramcc.aJL();
                  localc.aeNr.setTag(parama);
                  localc.aeNr.setOnClickListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqw());
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.aeNg.setVisibility(8);
                  break label2122;
                  localc.aeNr.setImageResource(R.g.music_playicon);
                  break label2225;
                  localc.aeNf.setImageBitmap(parama);
                }
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.aeNg.setVisibility(0);
                  localc.aeNg.setMaxLines(2);
                }
                for (;;)
                {
                  localc.plr.setVisibility(0);
                  localc.aeNl.setVisibility(8);
                  localc.aeNr.setVisibility(8);
                  localc.aeNm.setVisibility(4);
                  localc.plr.setMaxLines(2);
                  localc.plr.setText(Util.getSizeKB(localb.nRd));
                  e.c.a(localc, str, localb.nRd);
                  e.c.a(localc, Boolean.TRUE, paramcc, localb.title);
                  if (!bool1) {
                    break label7754;
                  }
                  if (!e.b.bBu(localb.nRe)) {
                    break label2576;
                  }
                  localc.aeNf.setImageResource(R.g.fmp);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.aeNg.setVisibility(8);
                }
                if (e.b.bBv(localb.nRe))
                {
                  localc.aeNf.setImageResource(R.k.app_attach_file_icon_video);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                }
                else
                {
                  localc.aeNf.setImageResource(com.tencent.mm.pluginsdk.model.x.bpA(localb.nRe));
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  continue;
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.aeNg.setVisibility(0);
                    localc.plr.setVisibility(0);
                    localc.aeNl.setVisibility(8);
                    localc.aeNr.setVisibility(0);
                    localc.aeNr.setImageResource(R.g.video_download_btn);
                    localc.aeNm.setVisibility(4);
                    localc.plr.setMaxLines(2);
                    if (!bool1) {
                      break label7754;
                    }
                    paramString = new com.tencent.mm.modelimage.loader.a.c.a();
                    paramString.wB(R.k.app_attach_file_icon_webpage).bKu().eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bKs().bKw().bt(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                    localObject2 = r.bKe();
                    if (!Util.isNullOrNil(localb.thumburl)) {
                      break label2858;
                    }
                  }
                  for (parama = localb.nRi;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.modelimage.loader.a)localObject2).a(parama, localc.aeNf, paramString.bKx());
                    localc.aeNr.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    localc.aeNg.setVisibility(8);
                    break label2666;
                  }
                  parama = new bq();
                  parama.hBG.msgId = paramcc.aJG();
                  parama.hBG.type = 0;
                  parama.hBG.hBF = true;
                  parama.publish();
                  if (localb != null) {
                    e.a(paramString, parama1, paramcc, localb);
                  }
                  parama = (com.tencent.mm.message.e)localb.aK(com.tencent.mm.message.e.class);
                  if ((parama != null) && (com.tencent.mm.message.e.uA(parama.nQm)))
                  {
                    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
                    com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.dF(localb.url, parama.nQm);
                    if (parama.nQm == 16)
                    {
                      e.c.a(parama1, localc, localb, paramcc, bool1);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                    }
                  }
                  if ((j == 0) && (an.a(localb, parama)))
                  {
                    localc.aeOk.setVisibility(0);
                    localc.aeOp.setVisibility(0);
                    an.a(parama1.getContext(), localb, localc.aeOm, localc.aeOn);
                    an.b(localc.aeOo, localb);
                  }
                  localc.aeNg.setVisibility(8);
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.aeNl.setMaxLines(2);
                    localc.aeNl.setVisibility(0);
                    localc.aeNl.setText(localb.getTitle());
                    localc.plr.setMaxLines(3);
                    if (!e.o(localb)) {
                      break label3317;
                    }
                    localc.aeNr.setVisibility(0);
                    localc.aeNr.setImageResource(R.g.video_download_btn);
                    localc.aeNm.setVisibility(4);
                    if (!bool1) {
                      break label7754;
                    }
                    paramString = new com.tencent.mm.modelimage.loader.a.c.a();
                    paramString.wB(R.k.app_attach_file_icon_webpage).bKu().Or(com.tencent.mm.plugin.image.d.fQD()).a(new com.tencent.mm.pluginsdk.ui.applet.n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bKs().bKw().bt(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                    localObject2 = r.bKe();
                    if (!Util.isNullOrNil(localb.thumburl)) {
                      break label3330;
                    }
                  }
                  for (parama = localb.nRi;; parama = localb.thumburl)
                  {
                    ((com.tencent.mm.modelimage.loader.a)localObject2).a(parama, localc.aeNf, paramString.bKx());
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    localc.aeNl.setVisibility(8);
                    break label3120;
                    localc.aeNr.setVisibility(8);
                    break label3157;
                  }
                  av.a(localc, localb);
                  if (localc.aeNA.getLayoutParams() != null)
                  {
                    localc.aeNA.getLayoutParams().width = -2;
                    localc.aeNA.requestLayout();
                  }
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(localb.nTD);
                  com.tencent.mm.modelappbrand.b.a(localb.nTD, (WxaAttributes)localObject2, localb);
                  final boolean bool2;
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label3689;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.aeNB.setVisibility(8);
                    localc.aeNN.setVisibility(0);
                    localc.aeNH.setVisibility(8);
                    localc.aeNU.setVisibility(8);
                    if (!e.a(paramcc, localb, parama1)) {
                      break label3699;
                    }
                    localc.aeOr.setVisibility(0);
                    bool2 = Util.isNullOrNil(paramcc.aJQ());
                    localc.aeOr.setTag(paramcc);
                    localc.aeOr.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(179950);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.cH(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                        e.a((cc)paramAnonymousView.getTag(), localc, parama1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(179950);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    localc.aeNL.setText(parama);
                    e.a(localc.aeNM, localb);
                    r.bKe().a(paramString, localc.aeNK, ak.d.lCf);
                    parama = r.bKa().Oe(paramcc.aJL());
                    localc.aeNO.setImageBitmap(null);
                    com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNO, "file://".concat(String.valueOf(parama)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(240, 192));
                    if (!e.b(localb, (WxaAttributes)localObject2)) {
                      break label3712;
                    }
                    localc.rpw.setVisibility(0);
                    com.tencent.mm.plugin.appbrand.ui.au.a(localc.rpw, R.k.app_brand_relieved_buy_icon);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    parama = localb.iab;
                    break label3422;
                    paramString = localb.nTY;
                    break label3434;
                    localc.aeOr.setVisibility(8);
                  }
                  localc.rpw.setVisibility(8);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  continue;
                  av.a(localc, localb);
                  localObject2 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(localb.nTD);
                  com.tencent.mm.modelappbrand.b.a(localb.nTD, (WxaAttributes)localObject2, localb);
                  switch (localb.nTF)
                  {
                  default: 
                    localc.aeNk.setVisibility(0);
                    localc.aeNh.setVisibility(0);
                    localc.aeNh.setBackground(null);
                    localc.aeNh.setImageResource(R.k.app_brand_we_app_logo_share);
                    e.a(localc.Aoo, localb);
                    break;
                  case 2: 
                  case 3: 
                    if (localc.aeNA.getLayoutParams() != null)
                    {
                      localc.aeNA.getLayoutParams().width = -2;
                      localc.aeNA.requestLayout();
                    }
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4184;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.aeNB.setVisibility(8);
                      localc.aeNN.setVisibility(0);
                      localc.aeNH.setVisibility(8);
                      localc.aeNU.setVisibility(8);
                      localc.aeNL.setText(parama);
                      e.a(localc.aeNM, localb);
                      r.bKe().a(paramString, localc.aeNK, ak.d.lCf);
                      parama = r.bKa().Oe(paramcc.aJL());
                      localc.aeNO.setImageBitmap(null);
                      localc.aeNO.setVisibility(4);
                      if (!e.b(localb, (WxaAttributes)localObject2)) {
                        break label4194;
                      }
                      localc.rpw.setVisibility(0);
                      com.tencent.mm.plugin.appbrand.ui.au.a(localc.rpw, R.k.app_brand_relieved_buy_icon);
                      if (!e.a(paramcc, localb, parama1)) {
                        break label4207;
                      }
                      localc.aeOr.setVisibility(0);
                      bool2 = Util.isNullOrNil(paramcc.aJQ());
                      localc.aeOr.setTag(paramcc);
                      localc.aeOr.setOnClickListener(new View.OnClickListener()
                      {
                        public final void onClick(View paramAnonymousView)
                        {
                          AppMethodBeat.i(185027);
                          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                          localb.cH(paramAnonymousView);
                          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                          e.a((cc)paramAnonymousView.getTag(), localc, parama1);
                          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                          AppMethodBeat.o(185027);
                        }
                      });
                      e.a(bool2, localc, parama1);
                    }
                    for (;;)
                    {
                      bool2 = e.p(localb);
                      com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
                      {
                        public final void bFg()
                        {
                          AppMethodBeat.i(36778);
                          AppMethodBeat.o(36778);
                        }
                        
                        public final void bFh()
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
                        
                        public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36779);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.aeNO.setImageBitmap(paramAnonymousBitmap);
                            localc.aeNO.setVisibility(0);
                            localc.aeNQ.setVisibility(4);
                            if (bool2)
                            {
                              localc.aeNP.setImageDrawable(com.tencent.mm.cd.a.m(parama1.aezO.getContext(), R.k.shortvideo_play_btn));
                              localc.aeNP.setVisibility(0);
                              AppMethodBeat.o(36779);
                              return;
                            }
                            localc.aeNP.setVisibility(8);
                            AppMethodBeat.o(36779);
                            return;
                          }
                          localc.aeNO.setVisibility(4);
                          localc.aeNQ.setVisibility(0);
                          localc.aeNP.setVisibility(8);
                          AppMethodBeat.o(36779);
                        }
                      }, e.bBt(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(240, 192));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.iab;
                      break label3898;
                      paramString = localb.nTY;
                      break label3910;
                      localc.rpw.setVisibility(8);
                      break label4044;
                      localc.aeOr.setVisibility(8);
                    }
                  case 1: 
                    if (localObject2 != null)
                    {
                      parama = ((WxaAttributes)localObject2).field_nickname;
                      if (localObject2 == null) {
                        break label4390;
                      }
                      paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                      localc.aeNB.setVisibility(8);
                      localc.aeNN.setVisibility(8);
                      localc.aeNH.setVisibility(0);
                      localc.aeNJ.setText(parama);
                      localc.aeNU.setVisibility(8);
                      if (!Util.isNullOrNil(paramString)) {
                        break label4396;
                      }
                      parama = r.bKa().Oe(paramcc.aJL());
                      com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNI, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.bEX(), com.tencent.mm.modelappbrand.a.g.org);
                    }
                    for (;;)
                    {
                      if (!e.b(localb, (WxaAttributes)localObject2)) {
                        break label4419;
                      }
                      localc.aeNT.setVisibility(0);
                      com.tencent.mm.plugin.appbrand.ui.au.a(localc.aeNT, R.k.app_brand_relieved_buy_icon);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      parama = localb.title;
                      break label4231;
                      paramString = null;
                      break label4243;
                      com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNI, paramString, com.tencent.mm.modelappbrand.a.a.bEX(), com.tencent.mm.modelappbrand.a.g.org);
                    }
                    localc.aeNT.setVisibility(8);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    continue;
                    parama = (com.tencent.mm.message.a)localb.aK(com.tencent.mm.message.a.class);
                    paramString = localb.nTY;
                    localObject2 = localb.iab;
                    str = localb.title;
                    localObject3 = localb.description;
                    if ((parama == null) || (Util.isNullOrNil(parama.nPh)) || (Util.isNullOrNil(parama.nPj)))
                    {
                      Log.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                      break;
                    }
                    localc.aeOa.setText((CharSequence)localObject2);
                    localc.aeNB.setVisibility(8);
                    localc.aeNN.setVisibility(8);
                    localc.aeNH.setVisibility(8);
                    localc.aeOb.setVisibility(0);
                    localc.aeNX.setVisibility(8);
                    localc.aeOb.setImageDrawable(com.tencent.mm.cd.a.m(parama1.getContext(), R.k.shortvideo_play_btn));
                    localc.aeNU.setVisibility(0);
                    localc.aeNV.setText(str);
                    localc.aeNW.setText((CharSequence)localObject3);
                    r.bKd().a(paramString, new s.a()
                    {
                      public final void onLoadImageEnd(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                      {
                        AppMethodBeat.i(36783);
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(36782);
                            if (!paramAnonymousBitmap.isRecycled()) {
                              e.d.8.this.aeOx.aeNZ.setImageBitmap(paramAnonymousBitmap);
                            }
                            AppMethodBeat.o(36782);
                          }
                        });
                        AppMethodBeat.o(36783);
                      }
                    });
                    paramString = com.tencent.mm.modelappbrand.a.b.bEY().a(parama.nPj, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.opU));
                    if (paramString != null)
                    {
                      localc.aeNY.setImageBitmap(paramString);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                    }
                    else
                    {
                      com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
                      {
                        public final void bFg()
                        {
                          AppMethodBeat.i(36784);
                          localc.aeNY.setVisibility(4);
                          AppMethodBeat.o(36784);
                        }
                        
                        public final void bFh()
                        {
                          AppMethodBeat.i(185028);
                          Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                          com.tencent.mm.plugin.report.service.h.OAn.kJ(808, 2);
                          AppMethodBeat.o(185028);
                        }
                        
                        public final String key()
                        {
                          AppMethodBeat.i(36786);
                          String str = "CHAT#" + com.tencent.mm.plugin.appbrand.af.p.el(this);
                          AppMethodBeat.o(36786);
                          return str;
                        }
                        
                        public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
                        {
                          AppMethodBeat.i(36785);
                          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                          {
                            localc.aeNY.setImageBitmap(paramAnonymousBitmap);
                            localc.aeNY.setVisibility(0);
                          }
                          AppMethodBeat.o(36785);
                        }
                      }, parama.nPj, null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.opU));
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      paramInt = 1;
                      localc.aeNl.setMaxLines(2);
                      localc.plr.setMaxLines(3);
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.aeNg.setVisibility(8);
                      if ((localb.title != null) && (localb.title.trim().length() > 0))
                      {
                        localc.aeNl.setMaxLines(2);
                        localc.aeNl.setVisibility(0);
                        localc.aeNl.setText(localb.getTitle());
                      }
                      for (;;)
                      {
                        localc.plr.setMaxLines(3);
                        localc.aeNr.setVisibility(8);
                        localc.aeNm.setVisibility(4);
                        if (!bool1) {
                          break label7754;
                        }
                        parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label4947;
                        }
                        localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        localc.aeNl.setVisibility(8);
                      }
                      localc.aeNf.setImageBitmap(parama);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.aeNl.setVisibility(0);
                      if (localb.nRA == 1) {
                        localc.aeNl.setText(R.l.gUd);
                      }
                      for (;;)
                      {
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.aeNg.setVisibility(0);
                          localc.aeNg.aZ(localb.getTitle());
                        }
                        localc.plr.setMaxLines(4);
                        localc.aeNm.setVisibility(4);
                        localc.aeNr.setVisibility(8);
                        if (!bool1) {
                          break label7754;
                        }
                        parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                        if ((parama == null) || (parama.isRecycled())) {
                          break label5183;
                        }
                        localc.aeNf.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        break;
                        if (localb.nRA == 2) {
                          localc.aeNl.setText(R.l.gUf);
                        } else if (localb.nRA == 3) {
                          localc.aeNl.setText(R.l.gUe);
                        } else {
                          localc.aeNl.setText(R.l.gUg);
                        }
                      }
                      localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      continue;
                      localc.aeNg.setVisibility(0);
                      localc.aeNg.aZ(localb.getTitle());
                      localc.aeNl.setVisibility(0);
                      localc.aeNl.setText(R.l.gyP);
                      localc.plr.setMaxLines(4);
                      localc.aeNm.setVisibility(4);
                      localc.aeNr.setVisibility(8);
                      if (!bool1) {
                        break label7754;
                      }
                      parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                      if ((parama != null) && (!parama.isRecycled()))
                      {
                        localc.aeNf.setImageBitmap(parama);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                      }
                      else
                      {
                        localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                        paramInt = 0;
                        parama = (c.a)localObject1;
                        i = k;
                        continue;
                        if ((localb.title != null) && (localb.title.length() > 0))
                        {
                          localc.aeNg.setVisibility(0);
                          localc.aeNg.aZ(localb.getTitle());
                          localc.aeNl.setVisibility(8);
                        }
                        localc.plr.setMaxLines(4);
                        localc.aeNm.setVisibility(4);
                        localc.aeNr.setVisibility(8);
                        if (!bool1) {
                          break label7754;
                        }
                        parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          localc.aeNf.setImageBitmap(parama);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                        }
                        else
                        {
                          localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                          paramInt = 0;
                          parama = (c.a)localObject1;
                          i = k;
                          continue;
                          if ((localb.title != null) && (localb.title.length() > 0)) {
                            localc.aeNg.setVisibility(0);
                          }
                          for (;;)
                          {
                            localc.plr.setVisibility(0);
                            localc.aeNl.setVisibility(8);
                            localc.aeNr.setVisibility(8);
                            localc.aeNm.setVisibility(4);
                            localc.plr.setMaxLines(2);
                            if (!bool1) {
                              break label7754;
                            }
                            parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                            if ((parama != null) && (!parama.isRecycled())) {
                              break label5659;
                            }
                            localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                            paramInt = 0;
                            parama = (c.a)localObject1;
                            i = k;
                            break;
                            localc.aeNg.setVisibility(8);
                          }
                          localc.aeNf.setImageBitmap(parama);
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
                localc.aeNg.setVisibility(0);
                localc.plr.setVisibility(0);
                localc.aeNl.setVisibility(8);
                localc.aeNr.setVisibility(8);
                localc.aeNm.setVisibility(4);
                localc.plr.setMaxLines(2);
                if (bool1)
                {
                  parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label5893;
                  }
                  localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                }
              }
              for (;;)
              {
                parama = new bz(paramcc, false, paramInt, "", false, localb.title, localb.iaa, localb.iab, localb.title, localb.nRI, localb.url, false, false);
                localc.aeNA.setTag(parama);
                localc.aeNA.setOnClickListener(i(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.aeNg.setVisibility(8);
                break label5708;
                localc.aeNf.setImageBitmap(parama);
              }
            case 25: 
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.aeNg.setVisibility(0);
                localc.plr.setVisibility(0);
                localc.aeNl.setVisibility(8);
                localc.aeNr.setVisibility(8);
                localc.aeNm.setVisibility(4);
                localc.plr.setMaxLines(2);
                if (bool1)
                {
                  parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6123;
                  }
                  localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                }
              }
              for (;;)
              {
                parama = new bz(paramcc, paramInt, "", parama1.jrh(), localb.iaa, localb.iab, localb.title, localb.nTq, localb.designerName, localb.designerRediretctUrl, localb.url);
                localc.aeNA.setTag(parama);
                localc.aeNA.setOnClickListener(j(parama1));
                i = 1;
                paramInt = 0;
                break;
                localc.aeNg.setVisibility(8);
                break label5933;
                localc.aeNf.setImageBitmap(parama);
              }
            case 26: 
            case 27: 
              label1523:
              label2037:
              label3317:
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.aeNg.setVisibility(0);
                localc.plr.setVisibility(0);
                localc.aeNl.setVisibility(8);
                localc.aeNr.setVisibility(8);
                localc.aeNm.setVisibility(4);
                localc.plr.setMaxLines(2);
                if (bool1)
                {
                  parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label6434;
                  }
                  localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                }
                parama = new bz();
                parama.hTm = paramcc;
                parama.aedO = false;
                parama.position = paramInt;
                parama.aeXN = false;
                parama.title = parama1.jrh();
                parama.iaa = localb.iaa;
                parama.iab = localb.iab;
                parama.acdC = localb.title;
                if (localb.type != 26) {
                  break label6446;
                }
                parama.tid = localb.tid;
                parama.nTr = localb.nTr;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.aeNA.setOnClickListener(k(parama1));
                paramInt = 1;
              }
              label3699:
              break;
            }
            label2067:
            label4243:
            label6163:
            label7317:
            for (;;)
            {
              label1699:
              label1709:
              label2122:
              label2384:
              label3157:
              label3422:
              label3689:
              label6123:
              localc.aeNA.setTag(parama);
              label2225:
              label2370:
              label3910:
              label4044:
              label4184:
              label4194:
              j = 0;
              label2858:
              label3120:
              label3898:
              label4419:
              label4947:
              i = paramInt;
              label4390:
              label4396:
              label5183:
              label5708:
              paramInt = j;
              label5659:
              label5933:
              break;
              localc.aeNg.setVisibility(8);
              break label6163;
              label6434:
              localc.aeNf.setImageBitmap(parama);
              break label6257;
              label6446:
              if (localb.type == 27)
              {
                parama.tid = localb.tid;
                parama.nTr = localb.nTr;
                parama.desc = localb.desc;
                parama.iconUrl = localb.iconUrl;
                parama.secondUrl = localb.secondUrl;
                parama.pageType = localb.pageType;
                localc.aeNA.setOnClickListener(l(parama1));
                paramInt = 1;
                continue;
                localc.aeNg.setVisibility(0);
                localc.aeNg.aZ(localb.description);
                localc.plr.setText(localb.nSo);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.aeNl.setVisibility(0);
                  localc.aeNl.setText(localb.title);
                }
                for (;;)
                {
                  localc.plr.setMaxLines(4);
                  localc.aeNm.setVisibility(4);
                  localc.aeNr.setVisibility(8);
                  if (!bool1) {
                    break label7754;
                  }
                  parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if (parama == null) {
                    break label6695;
                  }
                  localc.aeNf.setImageBitmap(parama);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.aeNl.setVisibility(8);
                }
                localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                localc.aeNg.setVisibility(8);
                localc.aeNl.setVisibility(0);
                if ((localb.title != null) && (localb.title.trim().length() > 0)) {
                  localc.aeNl.setText(com.tencent.mm.pluginsdk.ui.span.p.b(localc.aeNl.getContext(), localb.title, localc.aeNl.getTextSize()));
                }
                for (;;)
                {
                  localc.plr.setMaxLines(3);
                  localc.aeNr.setVisibility(8);
                  localc.aeNm.setVisibility(4);
                  if (bool1)
                  {
                    localc.aeNf.setVisibility(8);
                    localc.aeNz.setVisibility(8);
                  }
                  e.c.b(parama1, localc, localb, paramcc, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.aeNl.setText(com.tencent.mm.pluginsdk.ui.span.p.b(localc.aeNl.getContext(), MMApplicationContext.getContext().getString(R.l.favorite_wenote), localc.aeNl.getTextSize()));
                }
                e.c.a(parama1, localc, localb, bool1);
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.aeNg.setVisibility(0);
                  if (!Util.isNullOrNil(localb.nSx))
                  {
                    localc.aeNg.setTextColor(Util.convertStringToRGB(localb.nSx, parama1.getContext().getResources().getColor(R.e.normal_text_color)));
                    label6997:
                    localc.plr.setMaxLines(2);
                    localc.plr.setVisibility(0);
                    if (Util.isNullOrNil(localb.nSy)) {
                      break label7293;
                    }
                    localc.plr.setTextColor(Util.convertStringToRGB(localb.nSy, parama1.getContext().getResources().getColor(R.e.grey_background_text_color)));
                    localc.aeNl.setVisibility(8);
                    localc.aeNm.setVisibility(4);
                    localc.aeNr.setVisibility(8);
                    localc.aeNk.setVisibility(0);
                    localc.Aoo.setVisibility(0);
                    if (Util.isNullOrNil(localb.nSt)) {
                      break label7317;
                    }
                    localc.Aoo.setText(localb.nSt);
                  }
                }
                for (;;)
                {
                  if (this.wQm)
                  {
                    parama = r.bKa().e(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      paramString = BitmapUtil.getRoundedCornerBitmap(parama, false, parama.getWidth() / 2);
                      localc.aeNf.setImageBitmap(paramString);
                    }
                    if (!Util.isNullOrNil(localb.nSw))
                    {
                      r.bKe().a(localb.nSw, new ImageView(parama1.getContext()), new com.tencent.mm.modelimage.loader.a.c.a().bKt().bKx(), new com.tencent.mm.modelimage.loader.b.h()
                      {
                        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
                        {
                          return null;
                        }
                        
                        public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
                        {
                          AppMethodBeat.i(36788);
                          if (paramAnonymousb.bitmap != null)
                          {
                            paramAnonymousString = paramAnonymousb.bitmap;
                            localc.aeNB.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                            {
                              public final boolean onPreDraw()
                              {
                                AppMethodBeat.i(36787);
                                e.d.10.this.aeOx.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                                int j = e.d.10.this.aeOx.aeNB.getHeight();
                                int k = e.d.10.this.aeOx.aeNB.getWidth();
                                int i = j;
                                if (j == 0) {
                                  i = com.tencent.mm.cd.a.br(e.d.10.this.XSz.aezO.getContext(), R.f.chatting_music_item_height);
                                }
                                j = k;
                                if (k == 0) {
                                  j = com.tencent.mm.cd.a.br(e.d.10.this.XSz.aezO.getContext(), R.f.chatting_music_item_width);
                                }
                                BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_from_content_bg_mask, j, i));
                                e.d.10.this.aeOx.aeNB.setBackgroundDrawable(localBitmapDrawable);
                                AppMethodBeat.o(36787);
                                return true;
                              }
                            });
                          }
                          AppMethodBeat.o(36788);
                        }
                        
                        public final void c(String paramAnonymousString, View paramAnonymousView) {}
                      });
                      paramInt = 0;
                      parama = (c.a)localObject1;
                      i = k;
                      break;
                      localc.aeNg.setTextColor(parama1.getContext().getResources().getColor(R.e.normal_text_color));
                      break label6997;
                      localc.aeNg.setVisibility(8);
                      break label6997;
                      label7293:
                      localc.plr.setTextColor(parama1.getContext().getResources().getColor(R.e.grey_background_text_color));
                      break label7055;
                      localc.Aoo.setText(R.l.gyc);
                      continue;
                    }
                    localc.aeNB.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                    {
                      private boolean aeOC = false;
                      
                      public final boolean onPreDraw()
                      {
                        AppMethodBeat.i(36789);
                        if (this.aeOC)
                        {
                          localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                          AppMethodBeat.o(36789);
                          return true;
                        }
                        localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.aeOC = true;
                        int i = com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 24);
                        Bitmap localBitmap = parama;
                        Object localObject;
                        if (localBitmap != null)
                        {
                          localObject = localBitmap;
                          if (!localBitmap.isRecycled()) {}
                        }
                        else
                        {
                          localObject = BitmapUtil.createColorBitmap(parama1.aezO.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                        }
                        int j = ((Bitmap)localObject).getHeight();
                        if (i > j) {
                          i = j;
                        }
                        for (;;)
                        {
                          localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                          j = localc.aeNB.getHeight();
                          int k = localc.aeNB.getWidth();
                          i = j;
                          if (j == 0) {
                            i = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_height);
                          }
                          j = k;
                          if (k == 0) {
                            j = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_width);
                          }
                          localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_from_content_bg_mask, j, i));
                          localc.aeNB.setBackgroundDrawable((Drawable)localObject);
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
                localc.aeNf.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.foI));
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
                if ((localObject3 != null) && (((com.tencent.mm.message.t)localObject3).nUJ == 19))
                {
                  e.c.a(parama1, localc, localb, bool1);
                  paramInt = 0;
                  parama = (c.a)localObject1;
                  i = k;
                  break;
                  localc.aeNf.setImageResource(R.g.icon_filled_green_umbrella);
                  localc.aeNg.setVisibility(8);
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.aeNl.setMaxLines(3);
                    localc.aeNl.setVisibility(0);
                    localc.aeNl.setText(localb.getTitle());
                  }
                  for (;;)
                  {
                    localc.aeNr.setVisibility(8);
                    localc.aeNm.setVisibility(4);
                    paramInt = 0;
                    parama = (c.a)localObject1;
                    i = k;
                    break;
                    localc.aeNl.setVisibility(8);
                  }
                  label7548:
                  localc.aeNl.setVisibility(8);
                  break label1423;
                  localObject1 = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if (localObject1 != null)
                  {
                    paramString = (String)localObject1;
                    if (!((Bitmap)localObject1).isRecycled()) {}
                  }
                  else
                  {
                    paramString = r.bKa().e(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                  }
                  if ((paramString != null) && (!paramString.isRecycled()))
                  {
                    localc.aeNf.setImageBitmap(paramString);
                    break label1523;
                  }
                  if (!Util.isNullOrNil(localb.thumburl))
                  {
                    paramString = localb.thumburl;
                    localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
                    ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).wB(R.e.chatting_item_biz_default_bg).bKu().bKs();
                    r.bKe().a(paramString, localc.aeOe, ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx());
                    break label1523;
                  }
                  localc.aeNf.setImageResource(R.g.fmp);
                  break label1523;
                  localc.aeNu.setVisibility(8);
                  localObject2 = parama;
                  break label1584;
                  label7738:
                  localc.aeNu.setVisibility(8);
                  localObject2 = parama;
                  break label1584;
                }
                label7754:
                paramInt = 0;
                parama = (c.a)localObject1;
                i = k;
                break;
              }
              label6695:
              label7722:
              paramInt = 0;
            }
          }
          label7055:
          label7778:
          i = 1;
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
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
        if (!ae.cj(paramcc))
        {
          com.tencent.mm.ui.base.k.a(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gHq), "", parama.aezO.getContext().getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(36797);
          return false;
        }
        paramMenuItem = bt.X(paramcc);
        if (Util.isNullOrNil(paramMenuItem))
        {
          paramMenuItem = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
          if ((paramMenuItem != null) && (e.n(paramMenuItem) == 3)) {
            e.b.a(parama, paramcc, a(parama, paramcc), 2000, new com.tencent.mm.br.c.a()
            {
              public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
              {
                AppMethodBeat.i(255109);
                if ((paramAnonymousInt1 == 2000) && (paramAnonymousInt2 == -1))
                {
                  paramAnonymousIntent = Util.listToString(paramAnonymousIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
                  cp localcp = cp.HcA;
                  cp.a(paramcc, e.d.this.aedO, false, paramAnonymousIntent);
                }
                AppMethodBeat.o(255109);
              }
            });
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36797);
          return false;
          e.b.a(parama, paramcc, a(parama, paramcc));
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          com.tencent.mm.ui.base.k.a(parama.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new e.d.2(this, paramMenuItem, parama), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(179948);
              e.b.a(parama, paramcc, e.d.this.a(parama, paramcc));
              com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
              AppMethodBeat.o(179948);
            }
          });
        }
      }
      paramMenuItem = paramcc.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(36797);
        return false;
      }
      paramMenuItem = k.b.Hf(paramMenuItem);
      if (paramMenuItem != null) {
        switch (e.n(paramMenuItem))
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(36797);
        return false;
        com.tencent.mm.ui.chatting.ap.a(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
        continue;
        com.tencent.mm.ui.chatting.ap.d(paramcc, parama.aezO.getContext());
        continue;
        com.tencent.mm.ui.chatting.ap.b(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
        continue;
        com.tencent.mm.ui.chatting.ap.a(paramcc, parama.aezO.getContext(), a(parama, paramcc), parama.juG());
        continue;
        com.tencent.mm.ui.chatting.ap.p(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
        continue;
        com.tencent.mm.ui.chatting.ap.c(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
        continue;
        com.tencent.mm.ui.chatting.ap.c(paramcc, parama.aezO.getContext());
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255334);
      int i = ((bz)paramView.getTag()).position;
      int j = com.tencent.mm.pluginsdk.model.app.n.bpT(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
      paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.m.bR(paramcc)) && (!bt.Q(paramcc)) && (!com.tencent.mm.ui.chatting.m.bT(paramcc)) && (!com.tencent.mm.ui.chatting.m.bS(paramcc)))
      {
        if (paramContextMenuInfo.type != 6) {
          break label617;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.pluginsdk.model.app.n.bpU(paramContextMenuInfo.hzM);
        if (((localc == null) || (!e.b.j(paramcc, localc.field_fileFullPath))) && (!paramcc.isClean())) {
          params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
      if ((paramContextMenuInfo.nRd <= 0) || ((paramContextMenuInfo.nRd > 0) && (j >= 100))) {}
      boolean bool1;
      switch (e.n(paramContextMenuInfo))
      {
      default: 
        bool1 = false;
        label299:
        if ((bool1) && (!this.aeiK.juH())) {
          params.add(i, 114, 0, paramView.getContext().getString(R.l.gyk));
        }
        if ((com.tencent.mm.br.c.blq("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).aqJ())) && (paramContextMenuInfo.nTP == 0)) {
          switch (e.n(paramContextMenuInfo))
          {
          }
        }
        break;
      }
      for (;;)
      {
        localObject = new ex();
        ((ex)localObject).hFc.msgId = paramcc.field_msgId;
        ((ex)localObject).publish();
        if ((((ex)localObject).hFd.hEn) || (e.b.a(this.aeiK.aezO.getContext(), paramContextMenuInfo))) {
          params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
        }
        if (bt.F(paramcc)) {
          params.clear();
        }
        if (!this.aeiK.juH()) {
          params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(255334);
        return true;
        label617:
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        break;
        bool1 = com.tencent.mm.an.g.bGR();
        break label299;
        bool1 = com.tencent.mm.an.g.bGL();
        break label299;
        boolean bool2 = com.tencent.mm.an.g.bGP();
        bool1 = bool2;
        if (Util.isImageExt(paramContextMenuInfo.nRe)) {
          break label299;
        }
        params.a(i, 150, this.aeiK.aezO.getMMResources().getString(R.l.gyv), R.k.icons_filled_otherapp);
        bool1 = bool2;
        break label299;
        bool1 = com.tencent.mm.an.g.bGI();
        break label299;
        bool1 = com.tencent.mm.an.g.bGH();
        break label299;
        bool1 = com.tencent.mm.an.g.bGN();
        break label299;
        bool1 = com.tencent.mm.an.g.bGJ();
        break label299;
        bool1 = false;
        if ((paramContextMenuInfo.nSp != 5) && (paramContextMenuInfo.nSp != 6) && (paramContextMenuInfo.nSp != 2)) {
          break label299;
        }
        if ((paramContextMenuInfo.nSp != 2) || (bt.F(paramcc))) {
          params.clear();
        }
        params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
        AppMethodBeat.o(255334);
        return false;
        params.clear();
        params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
        AppMethodBeat.o(255334);
        return false;
        params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
    }
    
    public final boolean c(View paramView, final com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
    {
      AppMethodBeat.i(36798);
      com.tencent.mm.modelstat.a.a(paramcc, a.a.oUW);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      Object localObject1 = paramcc.field_content;
      Object localObject2 = Boolean.FALSE;
      if (localObject1 == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      final k.b localb = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      Object localObject3 = com.tencent.mm.message.t.Hk((String)localObject1);
      if (localb == null)
      {
        AppMethodBeat.o(36798);
        return false;
      }
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((com.tencent.mm.message.t)localObject3).nUJ != 0)
        {
          localObject1 = Boolean.TRUE;
          localb.type = ((com.tencent.mm.message.t)localObject3).nUJ;
        }
      }
      localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(localb.appId, false, false);
      localObject3 = d(parama, paramcc);
      if (localObject2 != null) {
        a(parama, localb, (String)localObject3, (com.tencent.mm.pluginsdk.model.app.g)localObject2, paramcc.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (e.n(localb))
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) && (e(localb, parama, this, paramcc)))
        {
          AppMethodBeat.o(36798);
          return true;
          if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(parama.aezO.getContext()))
          {
            AppMethodBeat.o(36798);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(13043, new Object[] { Integer.valueOf(2), localb.description, localb.appId });
          c(parama, paramcc);
          boolean bool = a(localb, parama, this, paramcc);
          AppMethodBeat.o(36798);
          return bool;
          if (!this.wQm)
          {
            com.tencent.mm.ui.base.aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
            AppMethodBeat.o(36798);
            return true;
          }
          paramView = new Intent();
          paramView.setClassName(parama.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          paramView.putExtra("scene", 2);
          paramView.putExtra("app_msg_id", paramcc.field_msgId);
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(36798);
          return true;
          if ((localObject2 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject2).aqJ()) && (a(parama, (com.tencent.mm.pluginsdk.model.app.g)localObject2)))
          {
            AppMethodBeat.o(36798);
            return true;
          }
          if ((localb.hzM == null) || (localb.hzM.length() == 0)) {
            ((com.tencent.mm.ui.chatting.component.api.b)parama.cm(com.tencent.mm.ui.chatting.component.api.b.class)).a(paramcc, new com.tencent.mm.pluginsdk.model.app.ap()
            {
              public final void onLaunchApp(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
              {
                AppMethodBeat.i(255766);
                if (this.vsC != null)
                {
                  if (paramAnonymousBoolean1)
                  {
                    e.d.a(parama, localb, this.aeeO, this.vsC, paramcc.field_msgSvrId, 3, parama.getTalkerUserName());
                    AppMethodBeat.o(255766);
                    return;
                  }
                  e.d.a(parama, localb, this.aeeO, this.vsC, paramcc.field_msgSvrId, 7, parama.getTalkerUserName());
                }
                AppMethodBeat.o(255766);
              }
            });
          }
          for (;;)
          {
            AppMethodBeat.o(36798);
            return true;
            if (!this.wQm)
            {
              com.tencent.mm.ui.base.aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
              AppMethodBeat.o(36798);
              return true;
            }
            paramView = new Intent();
            paramView.setClassName(parama.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramView.putExtra("app_msg_id", paramcc.field_msgId);
            paramView.putExtra("scene", 2);
            parama.aezO.startActivityForResult(paramView, 210);
          }
          if (Util.isNullOrNil(localb.nRB))
          {
            AppMethodBeat.o(36798);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_Product_xml", localb.nRB);
          paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
          if (paramcc.field_imgPath == null) {
            paramView.putExtra("key_ProductUI_chatting_msgId", paramcc.field_msgId);
          }
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "scanner", ".ui.ProductUI", paramView);
          AppMethodBeat.o(36798);
          return true;
          if (Util.isNullOrNil(localb.nRE))
          {
            AppMethodBeat.o(36798);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_TV_xml", localb.nRE);
          paramView.putExtra("key_TV_getProductInfoScene", 1);
          if (paramcc.field_imgPath == null) {
            paramView.putExtra("key_TVInfoUI_chatting_msgId", paramcc.field_msgId);
          }
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "shake", ".ui.TVInfoUI", paramView);
          AppMethodBeat.o(36798);
          return true;
          if (Util.isNullOrNil(localb.nRH))
          {
            AppMethodBeat.o(36798);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_product_info", localb.nRH);
          paramView.putExtra("key_product_scene", 1);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "product", ".ui.MallProductUI", paramView);
          AppMethodBeat.o(36798);
          return true;
          bool = a(parama, paramcc, ((Boolean)localObject1).booleanValue(), (String)localObject3, a(parama, paramcc), this);
          AppMethodBeat.o(36798);
          return bool;
          if (Util.isNullOrNil(localb.hOj))
          {
            AppMethodBeat.o(36798);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_card_app_msg", localb.hOj);
          paramView.putExtra("key_from_scene", localb.nSp);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "card", ".ui.CardDetailUI", paramView);
          AppMethodBeat.o(36798);
          return true;
          if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.aezO.getContext()))
          {
            AppMethodBeat.o(36798);
            return true;
          }
          if (d(localb, parama, this, paramcc))
          {
            com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
            c(parama, paramcc);
            AppMethodBeat.o(36798);
            return true;
          }
          i = 1;
          continue;
          if (!c(localb, parama, this, paramcc))
          {
            break;
            if (b(localb, parama, this, paramcc)) {
              com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
            }
            c(parama, paramcc);
            AppMethodBeat.o(36798);
            return true;
            e.a(localb, parama, paramcc);
            AppMethodBeat.o(36798);
            return true;
            paramView = new Intent();
            paramView.putExtra("key_from_user_name", a(parama, paramcc));
            paramView.putExtra("key_biz_uin", localb.nSr);
            paramView.putExtra("key_order_id", localb.nSs);
            if ((paramcc.field_talker != null) && (!paramcc.field_talker.equals("")) && (com.tencent.mm.storage.au.bwE(paramcc.field_talker))) {
              paramView.putExtra("key_chatroom_name", paramcc.field_talker);
            }
            com.tencent.mm.br.c.b(parama.aezO.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
            AppMethodBeat.o(36798);
            return true;
            if (e.a(localb, parama))
            {
              AppMethodBeat.o(36798);
              return true;
            }
            i = 1;
            continue;
            ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(parama.aezO.getContext(), localb.username, (String)localObject3, ((com.tencent.mm.message.a.c)localb.aK(com.tencent.mm.message.a.c.class)).nVG, paramcc.getCreateTime());
            AppMethodBeat.o(36798);
            return true;
            ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(parama.aezO.getContext(), z.bAM(), (String)localObject3, paramcc.getCreateTime(), paramcc.field_msgSvrId, paramcc.field_content, paramcc.field_imgPath, Boolean.TRUE);
            AppMethodBeat.o(36798);
            return true;
          }
        }
      }
      AppMethodBeat.o(36798);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class e
    extends c
    implements v.n
  {
    protected v.l aeOA;
    protected v.j aeOB;
    protected v.i aeOz;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    private static void a(e.c paramc, com.tencent.mm.ui.chatting.component.api.m paramm, cc paramcc)
    {
      AppMethodBeat.i(36827);
      if ((paramcc.field_status == 2) && (b(paramm, paramcc.field_msgId)))
      {
        if (paramc.aeNG != null)
        {
          paramc.aeNG.setVisibility(0);
          AppMethodBeat.o(36827);
        }
      }
      else if (paramc.aeNG != null) {
        paramc.aeNG.setVisibility(8);
      }
      AppMethodBeat.o(36827);
    }
    
    public static boolean a(long paramLong, String paramString, com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255302);
      com.tencent.mm.pluginsdk.model.app.c localc = as.cWJ().bpI(paramString);
      if ((localc == null) || (!localc.efT()))
      {
        AppMethodBeat.o(255302);
        return false;
      }
      bh.bCz();
      cc localcc = com.tencent.mm.model.c.bzD().sl(paramLong);
      if (localcc.isClean())
      {
        Log.i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localcc.field_msgSvrId), localcc.field_imgPath });
        paramString = new Intent();
        paramString.setClassName(parama.aezO.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
        paramString.putExtra("clean_view_type", 1);
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramString.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(255302);
        return true;
      }
      paramString = new Intent(parama.aezO.getContext(), ShowImageUI.class);
      paramString.putExtra("key_image_path", localc.field_fileFullPath);
      paramString.putExtra("key_message_id", paramLong);
      paramString.putExtra("key_favorite", true);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramString.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "openImg", "(JLjava/lang/String;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(255302);
      return true;
    }
    
    public static boolean a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, String paramString, c paramc)
    {
      AppMethodBeat.i(255267);
      Intent localIntent = new Intent();
      localIntent.putExtra("message_id", paramcc.field_msgId);
      localIntent.putExtra("Retr_Security_Msg_Id", paramcc.field_msgId);
      int i = ac.aX(paramString, parama.getTalkerUserName());
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localIntent.putExtra("preUsername", paramString);
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preChatTYPE", i);
      localIntent.putExtra("msgUsername", parama.aemd);
      localIntent.putExtra("serverMsgID", String.valueOf(paramcc.field_msgSvrId));
      localIntent.putExtra("chatTypeForAppbrand", com.tencent.mm.modelappbrand.a.KG(parama.getTalkerUserName()));
      e.a.a(localIntent, parama, paramcc, paramc);
      com.tencent.mm.modelstat.a.an(paramcc);
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
      AppMethodBeat.o(255267);
      return true;
    }
    
    public static boolean b(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(161906);
      if ((Util.isNullOrNil(paramb.nTE)) && (Util.isNullOrNil(paramb.nTD)))
      {
        paramcc = paramb.url;
        if (parama.juG()) {}
        for (paramc = "groupmessage";; paramc = "singlemessage")
        {
          paramc = com.tencent.mm.pluginsdk.model.app.u.ab(paramcc, paramc);
          paramcc = new Intent();
          paramcc.putExtra("rawUrl", paramc);
          paramcc.putExtra("webpageTitle", paramb.title);
          paramcc.putExtra("shortUrl", paramb.url);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
          AppMethodBeat.o(161906);
          return true;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = paramc.a(parama, paramcc);
      Bundle localBundle = new Bundle();
      int i;
      if (parama.juG()) {
        i = 2;
      }
      for (;;)
      {
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.an.h.ac(paramcc));
        localBundle.putInt("chat_type", com.tencent.mm.modelappbrand.a.KG(parama.getTalkerUserName()));
        ((com.tencent.mm.plugin.appbrand.service.t)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.t.class)).a(parama.aezO.getContext(), parama.getTalkerUserName(), paramc.a(parama, paramcc), parama.juG(), paramb, localBundle);
        AppMethodBeat.o(161906);
        return true;
        if (com.tencent.mm.model.ab.IS(str1)) {
          i = 7;
        } else {
          i = 1;
        }
      }
    }
    
    public static boolean f(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(36831);
      if (paramc.a(parama, paramb, paramcc))
      {
        AppMethodBeat.o(36831);
        return true;
      }
      String str2 = com.tencent.mm.pluginsdk.model.app.u.ab(paramb.url, "message");
      String str3 = com.tencent.mm.pluginsdk.model.app.u.ab(paramb.nRc, "message");
      PackageInfo localPackageInfo = c.getPackageInfo(parama.aezO.getContext(), paramb.appId);
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
        paramc.a(parama, str2, str3, str1, i, paramb.appId, true, paramcc.field_msgId, paramcc.field_msgSvrId, paramcc);
        AppMethodBeat.o(36831);
        return true;
        str1 = localPackageInfo.versionName;
        break;
      }
    }
    
    public static boolean g(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(36832);
      Log.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramb.nTD, paramb.nTC, paramb.nTE, paramb.url, Integer.valueOf(paramb.nTW), paramb.nTG });
      if ((44 == paramb.type) && ((!paramb.gK(false)) || (Util.isNullOrNil(paramb.B(parama.aezO.getContext(), false)))))
      {
        AppMethodBeat.o(36832);
        return false;
      }
      Object localObject = parama.getTalkerUserName();
      String str = paramc.a(parama, paramcc);
      Bundle localBundle = new Bundle();
      int i;
      if ((parama.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
      {
        i = 10;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", (String)localObject);
        localBundle.putString("stat_send_msg_user", str);
        localBundle.putBoolean("stat_kf_guide", com.tencent.mm.an.h.ac(paramcc));
        i = com.tencent.mm.modelappbrand.a.KG(parama.getTalkerUserName());
        switch (paramb.nTF)
        {
        default: 
          i = 1;
        }
      }
      for (;;)
      {
        e.dC(paramcc);
        if (i != 0) {
          break label641;
        }
        AppMethodBeat.o(36832);
        return true;
        if (parama.juG())
        {
          i = 2;
          break;
        }
        if (com.tencent.mm.model.ab.IS((String)localObject))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramc = new Intent();
        paramc.putExtra("key_username", paramb.nTD);
        if (parama.juG())
        {
          paramc.putExtra("key_from_scene", 1);
          paramc.putExtra("key_scene_note", parama.getTalkerUserName() + ":" + str);
        }
        for (;;)
        {
          paramc.putExtra("_stat_obj", localBundle);
          localObject = new WxaExposedParams.a();
          ((WxaExposedParams.a)localObject).appId = paramb.nTE;
          ((WxaExposedParams.a)localObject).from = 6;
          ((WxaExposedParams.a)localObject).qHO = paramb.nTW;
          ((WxaExposedParams.a)localObject).pkgVersion = paramb.nTH;
          paramc.putExtra("key_scene_exposed_params", ((WxaExposedParams.a)localObject).cll());
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "appbrand", ".ui.AppBrandProfileUI", paramc);
          i = 0;
          break;
          paramc.putExtra("key_from_scene", 2);
          paramc.putExtra("key_scene_note", (String)localObject);
        }
        if ((parama.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
        {
          com.tencent.mm.modelappbrand.b.a((String)localObject, str, 1073, paramb, localBundle);
          i = 0;
        }
        else if (com.tencent.mm.model.ab.IS((String)localObject))
        {
          com.tencent.mm.modelappbrand.b.a((String)localObject, str, 1074, paramb, localBundle);
          i = 0;
        }
        else
        {
          localBundle.putString("chatroom_username", e.a(parama, (String)localObject));
          localBundle.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.b.a((String)localObject, str, parama.juG(), paramb, localBundle);
          i = 0;
          continue;
          localBundle.putString("chatroom_username", e.a(parama, (String)localObject));
          localBundle.putInt("chat_type", i);
          com.tencent.mm.modelappbrand.b.b((String)localObject, str, parama.juG(), paramb, localBundle);
          i = 0;
        }
      }
      label641:
      AppMethodBeat.o(36832);
      return false;
    }
    
    public static boolean h(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(36833);
      Object localObject2 = (com.tencent.mm.message.a)paramb.aK(com.tencent.mm.message.a.class);
      if ((localObject2 != null) && (!Util.isNullOrNil(((com.tencent.mm.message.a)localObject2).nPh)) && (!Util.isNullOrNil(((com.tencent.mm.message.a)localObject2).nPj)))
      {
        String str2 = ((com.tencent.mm.message.a)localObject2).nPh;
        String str3 = ((com.tencent.mm.message.a)localObject2).nPg;
        Object localObject1 = ((com.tencent.mm.message.a)localObject2).ibd;
        String str1;
        int i;
        if (Util.isNullOrNil(((com.tencent.mm.message.a)localObject2).nPk))
        {
          str1 = paramb.description;
          String str4 = ((com.tencent.mm.message.a)localObject2).nPi;
          String str5 = paramb.nTE;
          localObject2 = ((com.tencent.mm.message.a)localObject2).nPj;
          Log.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", new Object[] { str2, str3, str1, str4, str5, localObject2 });
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
          if (!com.tencent.mm.storage.au.bwE(parama.getTalkerUserName())) {
            break label363;
          }
          i = 2;
          label164:
          localh.b(17608, new Object[] { Integer.valueOf(i), str5, Integer.valueOf(1), Integer.valueOf(1) });
          if ((Util.isNullOrNil(str2)) && ((Util.isNullOrNil(str3)) || (!com.tencent.mm.vfs.y.ZC(str3)) || (!Util.nullAsNil(com.tencent.mm.vfs.y.bub(str3)).equals(localObject1)))) {
            break label369;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_chatting_type", paramb.type);
          ((Bundle)localObject1).putString("key_chatting_wording", str1);
          ((Bundle)localObject1).putString("key_chatting_text", str4);
          ((Bundle)localObject1).putString("key_chatting_appid", str5);
          ((Bundle)localObject1).putLong("key_msg_id", paramcc.field_msgId);
          ((Bundle)localObject1).putString("key_talker_username", parama.getTalkerUserName());
          ((Bundle)localObject1).putString("key_sender_username", paramc.a(parama, paramcc));
          e.a(parama, str2, str3, (String)localObject2, (Bundle)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(36833);
          return false;
          str1 = ((com.tencent.mm.message.a)localObject2).nPk;
          break;
          label363:
          i = 1;
          break label164;
          label369:
          Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
        }
      }
      Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
      com.tencent.mm.ui.base.aa.makeText(parama.aezO.getContext(), parama.aezO.getMMResources().getString(R.l.app_sending), 0).show();
      AppMethodBeat.o(36833);
      return true;
    }
    
    public static boolean i(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      int j = 0;
      AppMethodBeat.i(36834);
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        if (!Util.isNullOrNil(paramb.canvasPageXml))
        {
          paramc = new Intent();
          paramc.putExtra("sns_landig_pages_from_source", 5);
          paramc.putExtra("msg_id", paramcc.field_msgId);
          paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
          paramc.putExtra("sns_landing_pages_share_thumb_url", paramcc.field_imgPath);
          paramc.addFlags(268435456);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject1 = (ak)paramb.aK(ak.class);
        if ((localObject1 != null) && (!Util.isNullOrNil(((ak)localObject1).WoZ)))
        {
          paramb = new gib();
          paramb.WoZ = ((ak)localObject1).WoZ;
          paramb.Wpa = ((ak)localObject1).Wpa;
          paramb.Wpb = ((ak)localObject1).Wpb;
          paramb.Wpc = ((ak)localObject1).Wpc;
          paramb.Wpd = ((ak)localObject1).Wpd;
          paramb.Wph = ((ak)localObject1).Wph;
          paramb.ytZ = ((ak)localObject1).ytZ;
          paramb.svG = ((ak)localObject1).svG;
          paramb.ICb = ((ak)localObject1).ICb;
          paramb.Wpe = ((ak)localObject1).Wpe;
          paramb.Wpf = ((ak)localObject1).Wpf;
          paramb.Wpg = ((ak)localObject1).Wpg;
          paramb.source = ((ak)localObject1).source;
          paramb.ibx = ((ak)localObject1).ibx;
          paramb.Wpi = ((ak)localObject1).Wpi;
          paramb.Wpk = ((ak)localObject1).Wpk;
          paramb.Wpl = ((ak)localObject1).Wpl;
          paramb.Wpm = ((ak)localObject1).Wpm;
          paramb.Wpj = ((ak)localObject1).Wpj;
          paramc = com.tencent.mm.plugin.topstory.a.g.a(paramb, 32, parama.aezO.getContext().getString(R.l.fts_recommend_search_keyword));
          aj.a(parama.aezO.getContext(), paramc);
          com.tencent.mm.plugin.topstory.a.h.a(paramb, paramcc);
          AppMethodBeat.o(36834);
          return true;
        }
        Object localObject2 = paramb.url;
        Intent localIntent;
        label555:
        label563:
        int i;
        if (parama.juG())
        {
          localObject1 = "groupmessage";
          Object localObject3 = com.tencent.mm.pluginsdk.model.app.u.ab((String)localObject2, (String)localObject1);
          localObject1 = paramb.url;
          localObject2 = c.getPackageInfo(parama.aezO.getContext(), paramb.appId);
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
            break label1033;
          }
          localIntent.putExtra("shortUrl", (String)localObject1);
          if (localObject2 != null) {
            break label1049;
          }
          localObject1 = null;
          localIntent.putExtra("version_name", (String)localObject1);
          if (localObject2 != null) {
            break label1059;
          }
          i = 0;
          label582:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.iaa))
          {
            localIntent.putExtra("srcUsername", paramb.iaa);
            localIntent.putExtra("srcDisplayname", paramb.iab);
          }
          localIntent.putExtra("msg_id", paramcc.field_msgId);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramcc.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramcc));
          localIntent.putExtra("from_scence", 2);
          localIntent.putExtra("expid_str", paramcc.kLp);
          localIntent.putExtra("key_enable_teen_mode_check", true);
          e.a(localIntent, paramcc, paramb);
          int k = ac.aX(paramc.a(parama, paramcc), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramcc.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.a(parama, paramcc));
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
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(36834);
          return true;
          localObject1 = "singlemessage";
          break;
          label1033:
          localIntent.putExtra("shortUrl", paramb.url);
          break label555;
          label1049:
          localObject1 = ((PackageInfo)localObject2).versionName;
          break label563;
          label1059:
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
    
    private v.i j(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36822);
      if (this.aeOz == null) {
        this.aeOz = new v.i(parama);
      }
      parama = this.aeOz;
      AppMethodBeat.o(36822);
      return parama;
    }
    
    public static boolean j(k.b paramb, com.tencent.mm.ui.chatting.d.a parama, c paramc, cc paramcc)
    {
      AppMethodBeat.i(169873);
      Object localObject1 = new bp();
      ((bp)localObject1).hBE.msgId = paramcc.field_msgId;
      ((bp)localObject1).hBE.type = 0;
      ((bp)localObject1).hBE.hBF = false;
      ((bp)localObject1).publish();
      if (!Util.isNullOrNil(paramb.canvasPageXml))
      {
        paramc = new Intent();
        paramc.putExtra("sns_landig_pages_from_source", 5);
        paramc.putExtra("msg_id", paramcc.field_msgId);
        paramc.putExtra("sns_landing_pages_xml", paramb.canvasPageXml);
        paramc.putExtra("sns_landing_pages_share_thumb_url", paramcc.field_imgPath);
        paramb = com.tencent.mm.plugin.sns.data.m.lV(parama.aemd, paramcc.field_talker);
        if (!TextUtils.isEmpty(paramb)) {
          paramc.putExtra("sns_landing_pages_extra", paramb);
        }
        paramc.addFlags(268435456);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", paramc);
        AppMethodBeat.o(169873);
        return true;
      }
      ak localak = (ak)paramb.aK(ak.class);
      if ((localak != null) && (!Util.isNullOrNil(localak.WoZ)))
      {
        paramb = new gib();
        paramb.WoZ = localak.WoZ;
        paramb.Wpa = localak.Wpa;
        paramb.Wpb = localak.Wpb;
        paramb.Wpc = localak.Wpc;
        paramb.Wpd = localak.Wpd;
        paramb.Wph = localak.Wph;
        paramb.ytZ = localak.ytZ;
        paramb.svG = localak.svG;
        paramb.ICb = localak.ICb;
        paramb.Wpe = localak.Wpe;
        paramb.Wpf = localak.Wpf;
        paramb.Wpg = localak.Wpg;
        paramb.source = localak.source;
        paramb.ibx = localak.ibx;
        paramb.Wpi = localak.Wpi;
        paramb.Wpk = localak.Wpk;
        paramb.Wpl = localak.Wpl;
        paramb.Wpm = localak.Wpm;
        paramb.Wpj = localak.Wpj;
        paramc = com.tencent.mm.plugin.topstory.a.g.a(paramb, 32, parama.aezO.getContext().getString(R.l.fts_recommend_search_keyword));
        aj.a(parama.aezO.getContext(), paramc);
        com.tencent.mm.plugin.topstory.a.h.a(paramb, paramcc);
        AppMethodBeat.o(169873);
        return true;
      }
      if ((paramb.url != null) && (!paramb.url.equals("")))
      {
        Object localObject2 = paramb.url;
        int j;
        PackageInfo localPackageInfo;
        Intent localIntent;
        if (parama.juG())
        {
          localObject1 = "groupmessage";
          localObject2 = com.tencent.mm.pluginsdk.model.app.u.ab((String)localObject2, (String)localObject1);
          String str = paramb.nRc;
          j = parama.aezO.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy((String)localObject2))
          {
            i = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e((String)localObject2, 1, j, i);
          }
          localPackageInfo = c.getPackageInfo(parama.aezO.getContext(), paramb.appId);
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", (String)localObject1);
          localIntent.putExtra("webpageTitle", paramb.title);
          localIntent.putExtra("msgUsername", parama.aemd);
          localIntent.putExtra("serverMsgID", String.valueOf(paramcc.field_msgSvrId));
          localIntent.putExtra("KMsgType", paramcc.getType());
          localIntent.putExtra("KAppMsgType", paramb.type);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("key_snsad_statextstr", paramb.iah);
          if ((paramb.appId != null) && (("wx751a1acca5688ba3".equals(paramb.appId)) || ("wxfbc915ff7c30e335".equals(paramb.appId)) || ("wx482a4001c37e2b74".equals(paramb.appId)))) {
            ((Bundle)localObject2).putString("jsapi_args_appid", paramb.appId);
          }
          localIntent.putExtra("jsapiargs", (Bundle)localObject2);
          if (Util.isNullOrNil(str)) {
            break label1397;
          }
          localIntent.putExtra("shortUrl", str);
          label769:
          if (localPackageInfo != null) {
            break label1413;
          }
          localObject2 = null;
          label777:
          localIntent.putExtra("version_name", (String)localObject2);
          if (localPackageInfo != null) {
            break label1423;
          }
          i = 0;
          label796:
          localIntent.putExtra("version_code", i);
          if (!Util.isNullOrNil(paramb.iaa))
          {
            localIntent.putExtra("srcUsername", paramb.iaa);
            localIntent.putExtra("srcDisplayname", paramb.iab);
          }
          localIntent.putExtra("msg_id", paramcc.field_msgId);
          e.a(localIntent, paramcc, paramb);
          localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramcc.field_msgSvrId));
          localIntent.putExtra("KAppId", paramb.appId);
          localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
          localIntent.putExtra("pre_username", paramc.a(parama, paramcc));
          localIntent.putExtra("from_scence", 2);
          i = ac.aX(paramc.a(parama, paramcc), parama.getTalkerUserName());
          localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramcc.field_msgSvrId));
          localIntent.putExtra("preUsername", paramc.a(parama, paramcc));
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
            label1091:
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
            paramc = (com.tencent.mm.message.e)paramb.aK(com.tencent.mm.message.e.class);
            if (paramc == null) {
              break;
            }
          }
        }
        for (int i = paramc.nQm;; i = -1)
        {
          localIntent.putExtra(f.s.adwW, i);
          localIntent.putExtra("key_enable_teen_mode_check", true);
          localIntent.putExtra("msgUsername", parama.aemd);
          localIntent.putExtra("serverMsgID", String.valueOf(paramcc.field_msgSvrId));
          if ((paramc == null) || (i != 16)) {
            break label1457;
          }
          paramc = new Bundle();
          paramc.putInt("biz_video_scene", 1);
          paramc.putInt(f.b.adwc, j);
          paramc.putInt("geta8key_scene", 1);
          paramc.putString("geta8key_username", parama.getTalkerUserName());
          paramc.putString("webpageTitle", paramb.title);
          if ((localak != null) && (!Util.isNullOrNil(localak.WoZ)))
          {
            paramb = com.tencent.mm.plugin.webview.ui.tools.video.a.Xok;
            com.tencent.mm.plugin.webview.ui.tools.video.a.bmO(localak.WoZ);
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b.a(parama.aezO.getContext(), paramcc.field_msgId, paramcc.field_msgSvrId, 0, paramc);
          AppMethodBeat.o(169873);
          return true;
          localObject1 = "singlemessage";
          break;
          label1397:
          localIntent.putExtra("shortUrl", paramb.url);
          break label769;
          label1413:
          localObject2 = localPackageInfo.versionName;
          break label777;
          label1423:
          i = localPackageInfo.versionCode;
          break label796;
          i = 2;
          break label1091;
          i = 3;
          break label1091;
          i = 5;
          break label1091;
        }
        label1457:
        e.a(paramb, parama, localIntent);
        if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(3)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(parama.aezO.getContext(), (String)localObject1, i, 1, j, localIntent)))
        {
          Log.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
          AppMethodBeat.o(169873);
          return true;
        }
        localIntent.putExtra("pay_chat_type", com.tencent.mm.modelappbrand.a.KG(parama.getTalkerUserName()));
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      AppMethodBeat.o(169873);
      return true;
    }
    
    private v.l k(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36823);
      if (this.aeOA == null) {
        this.aeOA = new v.l(parama);
      }
      parama = this.aeOA;
      AppMethodBeat.o(36823);
      return parama;
    }
    
    private v.j l(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36824);
      if (this.aeOB == null) {
        this.aeOB = new v.j(parama);
      }
      parama = this.aeOB;
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
        localObject = new ap(paramLayoutInflater, R.i.ggx);
        ((View)localObject).setTag(new e.c().O((View)localObject, false));
      }
      AppMethodBeat.o(36825);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(36826);
      final e.c localc = (e.c)parama;
      this.aeiK = parama1;
      ((o)parama1.cm(o.class)).cP(paramcc);
      com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
      localc.reset();
      String str = paramcc.getContent();
      ((o)parama1.cm(o.class)).cN(paramcc);
      k.b localb;
      Object localObject2;
      if (str != null)
      {
        localb = k.b.aP(str, paramcc.aJM());
        localObject2 = com.tencent.mm.message.t.Hk(str);
      }
      label679:
      label1459:
      label2360:
      label2874:
      for (;;)
      {
        Object localObject1 = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
        int j = 0;
        int k = 0;
        localc.aeOr.setVisibility(8);
        Object localObject3 = localObject1;
        Object localObject4;
        boolean bool1;
        label604:
        int i;
        if (localb != null)
        {
          localObject4 = com.tencent.mm.pluginsdk.model.app.h.is(localb.appId, localb.appVersion);
          localc.aeNg.aZ(localb.title);
          localc.plr.setText(localb.description);
          localc.aeNl.setMaxLines(1);
          localc.aeNg.setTextColor(parama1.getContext().getResources().getColor(R.e.FG_0));
          localc.plr.setTextColor(parama1.getContext().getResources().getColor(R.e.half_alpha_black));
          localc.aeNB.setBackgroundResource(R.g.chatto_bg_app);
          localc.aeNB.setPadding(0, parama1.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
          localc.aeNf.setVisibility(0);
          localc.aeNz.setVisibility(0);
          localc.plr.setVisibility(0);
          localc.aeND.setVisibility(8);
          localc.aeNE.setVisibility(8);
          localc.aeNq.setVisibility(8);
          localc.aeNp.setVisibility(8);
          localc.aeNm.setVisibility(8);
          localc.aeNj.setVisibility(8);
          localc.aeNi.setVisibility(8);
          localc.aeNN.setVisibility(8);
          localc.aeNH.setVisibility(8);
          localc.aeNB.setVisibility(0);
          localc.aeNU.setVisibility(8);
          localc.aeOc.setVisibility(8);
          localc.aeOk.setVisibility(8);
          localc.aeOp.setVisibility(8);
          localc.resetChatBubbleWidth(localc.aeNA, localc.aeOt);
          if ((localObject4 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName.trim().length() > 0)) {
            break label1459;
          }
          localObject3 = localb.appName;
          bool1 = true;
          if ((localb.type == 20) || ("wxaf060266bfa9a35c".equals(localb.appId))) {
            bool1 = o.a.iGH().gXa();
          }
          if ((!bool1) || (localb.appId == null) || (localb.appId.length() <= 0) || (!iA((String)localObject3))) {
            break label1499;
          }
          localObject3 = com.tencent.mm.pluginsdk.model.app.h.a(parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject4, (String)localObject3);
          if (localb.type != 19) {
            break label1469;
          }
          localc.Aoo.setText(parama1.getContext().getResources().getString(R.l.opensdk_source_tv_record, new Object[] { localObject3 }));
          localc.aeNk.setVisibility(0);
          localc.Aoo.setVisibility(0);
          localc.Aoo.setCompoundDrawables(null, null, null, null);
          localc.aeNh.setVisibility(0);
          if ((localObject4 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject4).aqJ())) {
            break label1482;
          }
          a(parama1, localc.Aoo, paramcc, localb, ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_packageName, paramcc.aJH());
          localc.aeNh.setImageResource(R.g.fnp);
          a(parama1, localc.aeNh, localb.appId);
          i = 1;
        }
        label1341:
        label5953:
        for (;;)
        {
          label707:
          localc.aeNk.setBackgroundResource(R.g.mm_trans);
          bool1 = false;
          localc.aeNf.setVisibility(0);
          if (this.wQm)
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
                    if (!e.b.bBw(paramcc.aJL())) {
                      localObject3 = r.bKa().e(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                    }
                  }
                }
              }
            }
            if ((localObject3 != null) && (!((Bitmap)localObject3).isRecycled()))
            {
              localObject4 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject3, false, com.tencent.mm.cd.a.fromDPToPix(parama1.getContext(), 1));
              localc.aeNf.setImageBitmap((Bitmap)localObject4);
              label871:
              if (e.n(localb) != 3) {
                break label1770;
              }
              localc.aeNB.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                private boolean aeOC = false;
                
                public final boolean onPreDraw()
                {
                  AppMethodBeat.i(36803);
                  if (this.aeOC)
                  {
                    localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                  localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                  this.aeOC = true;
                  int i = com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 24);
                  Bitmap localBitmap = this.val$bitmap;
                  Object localObject;
                  if (localBitmap != null)
                  {
                    localObject = localBitmap;
                    if (!localBitmap.isRecycled()) {}
                  }
                  else
                  {
                    localObject = BitmapUtil.createColorBitmap(parama1.aezO.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                  }
                  int j = ((Bitmap)localObject).getHeight();
                  if (i > j) {
                    i = j;
                  }
                  for (;;)
                  {
                    localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                    j = localc.aeNB.getHeight();
                    int k = localc.aeNB.getWidth();
                    i = j;
                    if (j == 0) {
                      i = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_height);
                    }
                    j = k;
                    if (k == 0) {
                      j = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_width);
                    }
                    localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_to_content_bg_mask, j, i));
                    localc.aeNB.setBackgroundDrawable((Drawable)localObject);
                    AppMethodBeat.o(36803);
                    return true;
                  }
                }
              });
              if (!aw.isDarkMode()) {
                break label1759;
              }
              localc.aeNk.setBackgroundResource(R.g.mm_trans);
              localc.aeNr.setOnClickListener(null);
              j = e.n(localb);
              if (localb.type == 66)
              {
                if ((TextUtils.isEmpty(localb.nTD)) && (TextUtils.isEmpty(localb.nTE))) {
                  break label1797;
                }
                j = 33;
              }
            }
          }
          label973:
          label1241:
          label1499:
          label1759:
          label1770:
          final boolean bool2;
          switch (j)
          {
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
                  break label7823;
                }
                localc.aeNl.setVisibility(0);
                localc.aeNl.setMaxLines(2);
                localc.aeNl.setText(localb.title);
                localc.aeNg.setVisibility(8);
                if (bool1)
                {
                  if ((localb.type != 33) && (localb.type != 36)) {
                    break label7836;
                  }
                  paramString = r.bKa().Oe(paramcc.aJL());
                  localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                  com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNf, "file://".concat(String.valueOf(paramString)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(52, 52));
                }
                if (localb.type == 44) {
                  e.c.a(parama1, localc, localb);
                }
              }
              localObject3 = parama;
              if (j == 0)
              {
                localc.aeNA.setTag(localObject3);
                localc.aeNA.setOnClickListener(d(parama1));
              }
              if (this.wQm)
              {
                localc.aeNA.setOnLongClickListener(c(parama1));
                localc.aeNA.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
              }
              a(paramInt, localc, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
              AppMethodBeat.o(36826);
              return;
              localObject3 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              localc.Aoo.setText((CharSequence)localObject3);
              break label604;
              a(parama1, localc.Aoo, localb.appId);
              break label679;
              if (localb.type == 24)
              {
                localc.Aoo.setText(MMApplicationContext.getContext().getString(R.l.favorite));
                localc.aeNk.setVisibility(0);
                localc.Aoo.setVisibility(0);
                localc.aeNh.setVisibility(8);
                i = 1;
                break label707;
              }
              if ((localb.type == 83) || (localb.type == 84))
              {
                localc.Aoo.setText(MMApplicationContext.getContext().getString(R.l.app_teen_mode));
                localc.aeNk.setVisibility(0);
                localc.Aoo.setVisibility(0);
                localc.aeNh.setVisibility(8);
                i = 1;
                break label707;
              }
              if ((localb.type == 19) || ((localObject2 != null) && (((com.tencent.mm.message.t)localObject2).nUJ == 19)))
              {
                localc.Aoo.setText(MMApplicationContext.getContext().getString(R.l.chatting_item_record));
                localc.aeNk.setVisibility(0);
                localc.Aoo.setVisibility(0);
                localc.aeNh.setVisibility(8);
                i = 1;
                break label707;
              }
              if (e.a(localb, localc)) {
                break label8023;
              }
              localc.aeNk.setVisibility(8);
              localc.Aoo.setVisibility(8);
              localc.aeNh.setVisibility(8);
              i = 0;
              break label707;
              bool1 = true;
              break label871;
              localc.aeNk.setBackgroundResource(R.g.fnl);
              break label921;
              localc.aeNf.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.foI));
              bool1 = false;
              break label921;
              j = 5;
              break label973;
              if ((localb.title != null) && (localb.title.length() > 0))
              {
                localc.aeNg.setVisibility(0);
                localc.aeNg.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                localc.plr.setVisibility(0);
                localc.plr.setTextColor(parama1.getContext().getResources().getColor(R.e.white_text_color));
                localc.aeNl.setVisibility(8);
                localc.aeNm.setVisibility(4);
                localc.plr.setMaxLines(2);
                localc.aeNr.setVisibility(0);
                if (!(paramcc.aJG() + "_msg").equals(parama.playingMsgId)) {
                  break label2114;
                }
                localc.aeNr.setImageResource(R.g.music_pauseicon);
                parama = new e.g();
                parama.msgId = paramcc.aJG();
                parama.xml = paramcc.getContent();
                parama.hQn = paramcc.aJL();
                localc.aeNr.setTag(parama);
                localc.aeNr.setOnClickListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqw());
                if (bool1)
                {
                  parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                  if ((parama != null) && (!parama.isRecycled())) {
                    break label2128;
                  }
                  localc.aeNf.setImageResource(R.k.app_attach_file_icon_music);
                }
              }
              for (;;)
              {
                if (!jxj()) {
                  break label2140;
                }
                b(localc, false);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.aeNg.setVisibility(8);
                break label1852;
                localc.aeNr.setImageResource(R.g.music_playicon);
                break label1964;
                localc.aeNf.setImageBitmap(parama);
              }
              if (paramcc.getStatus() < 2) {}
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
                localc.aeNg.setVisibility(0);
                localc.aeNg.setMaxLines(2);
              }
              for (;;)
              {
                localc.plr.setVisibility(0);
                localc.aeNl.setVisibility(8);
                localc.aeNm.setVisibility(4);
                localc.plr.setMaxLines(2);
                localc.plr.setText(Util.getSizeKB(localb.nRd));
                localc.aeNr.setVisibility(8);
                e.c.a(localc, str, localb.nRd);
                e.c.a(localc, Boolean.FALSE, paramcc, localb.title);
                if (!bool1) {
                  break label7997;
                }
                if (!e.b.bBu(localb.nRe)) {
                  break label2360;
                }
                localc.aeNf.setImageResource(R.g.fmp);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break;
                localc.aeNg.setVisibility(8);
              }
              if (e.b.bBv(localb.nRe))
              {
                localc.aeNf.setImageResource(R.k.app_attach_file_icon_video);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
              }
              else
              {
                localc.aeNf.setImageResource(com.tencent.mm.pluginsdk.model.x.bpA(localb.nRe));
                i = 0;
                parama = (c.a)localObject1;
                j = k;
              }
            }
          case 4: 
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.aeNg.setVisibility(0);
              localc.plr.setVisibility(0);
              localc.aeNl.setVisibility(8);
              localc.plr.setMaxLines(2);
              localc.aeNm.setVisibility(4);
              localc.aeNr.setVisibility(0);
              localc.aeNr.setImageResource(R.g.video_download_btn);
              if (!bool1) {
                break label7997;
              }
              paramString = new com.tencent.mm.modelimage.loader.a.c.a();
              paramString.wB(R.k.app_attach_file_icon_webpage).bKu().eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bKs().bKw().bt(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1));
              localObject2 = r.bKe();
              if (!Util.isNullOrNil(localb.thumburl)) {
                break label2645;
              }
            }
            for (parama = localb.nRi;; parama = localb.thumburl)
            {
              ((com.tencent.mm.modelimage.loader.a)localObject2).a(parama, localc.aeNf, paramString.bKx());
              localc.aeNr.setVisibility(8);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.aeNg.setVisibility(8);
              break label2452;
            }
          case 36: 
            label1482:
            label2128:
            label2140:
            av.a(localc, localb);
            label2114:
            label2645:
            if (localc.aeNA.getLayoutParams() != null)
            {
              localc.aeNA.getLayoutParams().width = -2;
              localc.aeNA.requestLayout();
            }
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(localb.nTD);
            com.tencent.mm.modelappbrand.b.a(localb.nTD, (WxaAttributes)localObject2, localb);
            if (localObject2 != null)
            {
              parama = ((WxaAttributes)localObject2).field_nickname;
              if (localObject2 == null) {
                break label3041;
              }
              paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
              localc.aeNB.setVisibility(8);
              localc.aeNN.setVisibility(0);
              localc.aeNH.setVisibility(8);
              localc.aeNU.setVisibility(8);
              localc.aeNL.setText(parama);
              e.a(localc.aeNM, localb);
              if (!e.a(paramcc, localb, parama1)) {
                break label3051;
              }
              localc.aeOr.setVisibility(0);
              bool2 = Util.isNullOrNil(paramcc.aJQ());
              localc.aeOr.setTag(paramcc);
              localc.aeOr.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(179969);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  e.a((cc)paramAnonymousView.getTag(), localc, parama1);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(179969);
                }
              });
              e.a(bool2, localc, parama1);
              r.bKe().a(paramString, localc.aeNK, ak.d.lCf);
              parama = r.bKa().Oe(paramcc.aJL());
              localc.aeNO.setImageBitmap(null);
              com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNO, "file://".concat(String.valueOf(parama)), ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(240, 192));
              if (!jxj()) {
                break label3064;
              }
              a(localc, (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc);
            }
            break;
          }
          label3405:
          label4178:
          label6483:
          label8020:
          for (;;)
          {
            bool2 = false;
            for (parama = localc;; parama = localc)
            {
              b(parama, bool2);
              if (!e.b(localb, (WxaAttributes)localObject2)) {
                break label3082;
              }
              localc.rpw.setVisibility(0);
              com.tencent.mm.plugin.appbrand.ui.au.a(localc.rpw, R.k.app_brand_relieved_buy_icon);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              parama = localb.iab;
              break label2737;
              label3041:
              paramString = localb.nTY;
              break label2749;
              label3051:
              localc.aeOr.setVisibility(8);
              break label2874;
              label3064:
              if (paramcc.getStatus() >= 2) {
                break label8020;
              }
              bool2 = true;
            }
            localc.rpw.setVisibility(8);
            i = 0;
            parama = (c.a)localObject1;
            j = k;
            break label1186;
            parama = new bq();
            parama.hBG.msgId = paramcc.aJG();
            parama.hBG.type = 0;
            parama.hBG.hBF = false;
            parama.publish();
            if (localb != null) {
              e.a(paramString, parama1, paramcc, localb);
            }
            parama = (com.tencent.mm.message.e)localb.aK(com.tencent.mm.message.e.class);
            if ((parama != null) && (com.tencent.mm.message.e.uA(parama.nQm)))
            {
              paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
              com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.dF(localb.url, parama.nQm);
              if (parama.nQm == 16)
              {
                e.c.a(parama1, localc, localb, paramcc, bool1);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1186;
              }
            }
            if ((i == 0) && (an.a(localb, parama)))
            {
              localc.aeOk.setVisibility(0);
              localc.aeOp.setVisibility(0);
              an.a(parama1.getContext(), localb, localc.aeOm, localc.aeOn);
              an.b(localc.aeOo, localb);
            }
            localc.aeNg.setVisibility(8);
            if ((localb.title != null) && (localb.title.length() > 0))
            {
              localc.aeNl.setMaxLines(2);
              localc.aeNl.setVisibility(0);
              localc.aeNl.setText(localb.title);
              localc.plr.setMaxLines(3);
              localc.aeNm.setVisibility(4);
              if (!e.o(localb)) {
                break label3567;
              }
              localc.aeNr.setImageResource(R.g.video_download_btn);
              localc.aeNr.setVisibility(0);
              if (bool1)
              {
                paramString = new com.tencent.mm.modelimage.loader.a.c.a();
                paramString.wB(R.k.app_attach_file_icon_webpage).bKu().Or(com.tencent.mm.plugin.image.d.fQD()).eG(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bKs().bKw().bt(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                localObject2 = r.bKe();
                if (!Util.isNullOrNil(localb.thumburl)) {
                  break label3580;
                }
              }
            }
            label3567:
            label3580:
            for (parama = localb.nRi;; parama = localb.thumburl)
            {
              ((com.tencent.mm.modelimage.loader.a)localObject2).a(parama, localc.aeNf, paramString.bKx());
              if (!jxj()) {
                break label3589;
              }
              a(localc, (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc);
              b(localc, false);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
              localc.aeNl.setVisibility(8);
              break label3359;
              localc.aeNr.setVisibility(8);
              break label3405;
            }
            if (paramcc.getStatus() < 2) {}
            for (bool2 = true;; bool2 = false)
            {
              b(localc, bool2);
              i = 0;
              parama = (c.a)localObject1;
              j = k;
              break;
            }
            av.a(localc, localb);
            localObject2 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(localb.nTD);
            com.tencent.mm.modelappbrand.b.a(localb.nTD, (WxaAttributes)localObject2, localb);
            switch (localb.nTF)
            {
            default: 
              localc.aeNk.setVisibility(0);
              localc.aeNh.setVisibility(0);
              localc.aeNh.setBackground(null);
              localc.aeNh.setImageResource(R.k.app_brand_we_app_logo_share);
              e.a(localc.Aoo, localb);
              i = 1;
            }
            for (;;)
            {
              if (i == 0)
              {
                if (jxj())
                {
                  a(localc, (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc);
                  b(localc, false);
                  parama = (c.a)localObject1;
                  j = k;
                  break label1186;
                  if (localc.aeNA.getLayoutParams() != null)
                  {
                    localc.aeNA.getLayoutParams().width = -2;
                    localc.aeNA.requestLayout();
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    label3839:
                    if (localObject2 == null) {
                      break label4119;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.aeNB.setVisibility(8);
                    localc.aeNN.setVisibility(0);
                    localc.aeNH.setVisibility(8);
                    localc.aeNU.setVisibility(8);
                    localc.aeNL.setText(parama);
                    e.a(localc.aeNM, localb);
                    r.bKe().a(paramString, localc.aeNK, ak.d.lCf);
                    parama = r.bKa().Oe(paramcc.aJL());
                    localc.aeNO.setImageBitmap(null);
                    localc.aeNQ.setVisibility(0);
                    if (!e.b(localb, (WxaAttributes)localObject2)) {
                      break label4129;
                    }
                    localc.rpw.setVisibility(0);
                    com.tencent.mm.plugin.appbrand.ui.au.a(localc.rpw, R.k.app_brand_relieved_buy_icon);
                    if (!e.a(paramcc, localb, parama1)) {
                      break label4142;
                    }
                    localc.aeOr.setVisibility(0);
                    bool2 = Util.isNullOrNil(paramcc.aJQ());
                    localc.aeOr.setTag(paramcc);
                    localc.aeOr.setOnClickListener(new View.OnClickListener()
                    {
                      public final void onClick(View paramAnonymousView)
                      {
                        AppMethodBeat.i(185040);
                        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                        localb.cH(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                        e.a((cc)paramAnonymousView.getTag(), localc, parama1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(185040);
                      }
                    });
                    e.a(bool2, localc, parama1);
                  }
                  for (;;)
                  {
                    bool2 = e.p(localb);
                    com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
                    {
                      public final void bFg()
                      {
                        AppMethodBeat.i(36809);
                        AppMethodBeat.o(36809);
                      }
                      
                      public final void bFh()
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
                      
                      public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
                      {
                        AppMethodBeat.i(36810);
                        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                        {
                          localc.aeNO.setImageBitmap(paramAnonymousBitmap);
                          localc.aeNO.setVisibility(0);
                          localc.aeNQ.setVisibility(4);
                          if (bool2)
                          {
                            localc.aeNP.setImageDrawable(com.tencent.mm.cd.a.m(parama1.aezO.getContext(), R.k.shortvideo_play_btn));
                            localc.aeNP.setVisibility(0);
                            AppMethodBeat.o(36810);
                            return;
                          }
                          localc.aeNP.setVisibility(8);
                          AppMethodBeat.o(36810);
                          return;
                        }
                        localc.aeNO.setVisibility(4);
                        localc.aeNQ.setVisibility(0);
                        localc.aeNP.setVisibility(8);
                        AppMethodBeat.o(36810);
                      }
                    }, e.bBt(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).eE(240, 192));
                    i = 0;
                    break;
                    parama = localb.iab;
                    break label3839;
                    paramString = localb.nTY;
                    break label3851;
                    localc.rpw.setVisibility(8);
                    break label3985;
                    localc.aeOr.setVisibility(8);
                  }
                  if (localObject2 != null)
                  {
                    parama = ((WxaAttributes)localObject2).field_nickname;
                    if (localObject2 == null) {
                      break label4319;
                    }
                    paramString = ((WxaAttributes)localObject2).field_smallHeadURL;
                    localc.aeNB.setVisibility(8);
                    localc.aeNN.setVisibility(8);
                    localc.aeNH.setVisibility(0);
                    localc.aeNJ.setText(parama);
                    localc.aeNU.setVisibility(8);
                    if (!Util.isNullOrNil(paramString)) {
                      break label4325;
                    }
                    parama = r.bKa().Oe(paramcc.aJL());
                    com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNI, "file://".concat(String.valueOf(parama)), com.tencent.mm.modelappbrand.a.a.bEX(), com.tencent.mm.modelappbrand.a.g.org);
                  }
                  for (;;)
                  {
                    if (!e.b(localb, (WxaAttributes)localObject2)) {
                      break label4348;
                    }
                    localc.aeNT.setVisibility(0);
                    com.tencent.mm.plugin.appbrand.ui.au.a(localc.aeNT, R.k.app_brand_relieved_buy_icon);
                    i = 0;
                    break;
                    parama = localb.title;
                    break label4166;
                    label4319:
                    paramString = null;
                    break label4178;
                    label4325:
                    com.tencent.mm.modelappbrand.a.b.bEY().a(localc.aeNI, paramString, com.tencent.mm.modelappbrand.a.a.bEX(), com.tencent.mm.modelappbrand.a.g.org);
                  }
                  label4348:
                  localc.aeNT.setVisibility(8);
                  i = 0;
                  continue;
                }
                if (paramcc.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                parama = (com.tencent.mm.message.a)localb.aK(com.tencent.mm.message.a.class);
                paramString = localb.nTY;
                localObject2 = localb.iab;
                localObject3 = localb.title;
                localObject4 = localb.description;
                if (parama == null)
                {
                  Log.d("MicroMsg.ChattingItemAppMsgTo", "hy: no appbrand piece. treat as default");
                  break;
                }
                if (((Util.isNullOrNil(parama.nPh)) || (Util.isNullOrNil(parama.nPj))) && (Util.isNullOrNil(parama.nPg)))
                {
                  Log.d("MicroMsg.ChattingItemAppMsgTo", "hy: no video url. treat as default");
                  break;
                }
                localc.aeOa.setText((CharSequence)localObject2);
                localc.aeNB.setVisibility(8);
                localc.aeNN.setVisibility(8);
                localc.aeNH.setVisibility(8);
                localc.aeOb.setVisibility(0);
                localc.aeNX.setVisibility(8);
                localc.aeOb.setImageDrawable(com.tencent.mm.cd.a.m(parama1.getContext(), R.k.shortvideo_play_btn));
                localc.aeNU.setVisibility(0);
                localc.aeNV.setText((CharSequence)localObject3);
                localc.aeNW.setText((CharSequence)localObject4);
                r.bKd().a(paramString, new s.a()
                {
                  public final void onLoadImageEnd(String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
                  {
                    AppMethodBeat.i(36814);
                    MMHandlerThread.postToMainThread(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(36813);
                        if (!paramAnonymousBitmap.isRecycled()) {
                          e.e.8.this.aeOx.aeNZ.setImageBitmap(paramAnonymousBitmap);
                        }
                        AppMethodBeat.o(36813);
                      }
                    });
                    AppMethodBeat.o(36814);
                  }
                });
                parama = r.bKa().Oe(paramcc.aJL());
                localc.aeNY.setImageBitmap(null);
                com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
                {
                  public final void bFg()
                  {
                    AppMethodBeat.i(36815);
                    localc.aeNY.setVisibility(4);
                    AppMethodBeat.o(36815);
                  }
                  
                  public final void bFh()
                  {
                    AppMethodBeat.i(185041);
                    Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: decode recorder cover failed sender!");
                    com.tencent.mm.plugin.report.service.h.OAn.kJ(808, 3);
                    AppMethodBeat.o(185041);
                  }
                  
                  public final String key()
                  {
                    AppMethodBeat.i(36817);
                    String str = "CHAT#" + com.tencent.mm.plugin.appbrand.af.p.el(this);
                    AppMethodBeat.o(36817);
                    return str;
                  }
                  
                  public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
                  {
                    AppMethodBeat.i(36816);
                    if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                    {
                      localc.aeNY.setImageBitmap(paramAnonymousBitmap);
                      localc.aeNY.setVisibility(0);
                    }
                    AppMethodBeat.o(36816);
                  }
                }, e.bBt(parama), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).a(240, 120, com.tencent.mm.modelappbrand.k.a.opU));
                if (jxj())
                {
                  a(localc, (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc);
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1186;
                }
                if (paramcc.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                i = 1;
                localc.plr.setMaxLines(3);
                localc.aeNl.setMaxLines(2);
                parama = (c.a)localObject1;
                j = k;
                break label1186;
                localc.aeNg.setVisibility(8);
                if ((localb.title != null) && (localb.title.length() > 0))
                {
                  localc.aeNl.setMaxLines(2);
                  localc.aeNl.setVisibility(0);
                  localc.aeNl.setText(localb.title);
                  label4858:
                  localc.plr.setMaxLines(3);
                  localc.aeNm.setVisibility(4);
                  localc.aeNr.setVisibility(8);
                  if (bool1)
                  {
                    parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                    if ((parama != null) && (!parama.isRecycled())) {
                      break label4969;
                    }
                    localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                  }
                }
                for (;;)
                {
                  if (!jxj()) {
                    break label4981;
                  }
                  b(localc, false);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  localc.aeNl.setVisibility(8);
                  break label4858;
                  label4969:
                  localc.aeNf.setImageBitmap(parama);
                }
                label4981:
                if (paramcc.getStatus() < 2) {}
                for (bool2 = true;; bool2 = false)
                {
                  b(localc, bool2);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                }
                localc.aeNl.setVisibility(0);
                if (localb.nRA == 1) {
                  localc.aeNl.setText(R.l.gUd);
                }
                for (;;)
                {
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.aeNg.setVisibility(0);
                    localc.aeNg.aZ(localb.title);
                  }
                  localc.plr.setMaxLines(4);
                  localc.aeNm.setVisibility(4);
                  localc.aeNr.setVisibility(8);
                  if (!bool1) {
                    break label7997;
                  }
                  parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama == null) || (parama.isRecycled())) {
                    break label5236;
                  }
                  localc.aeNf.setImageBitmap(parama);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break;
                  if (localb.nRA == 2) {
                    localc.aeNl.setText(R.l.gUf);
                  } else if (localb.nRA == 3) {
                    localc.aeNl.setText(R.l.gUe);
                  } else {
                    localc.aeNl.setText(R.l.gUg);
                  }
                }
                label5236:
                localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1186;
                localc.aeNg.setVisibility(0);
                localc.aeNg.aZ(localb.title);
                localc.aeNl.setVisibility(0);
                localc.aeNl.setText(R.l.gyP);
                localc.plr.setMaxLines(4);
                localc.aeNm.setVisibility(4);
                localc.aeNr.setVisibility(8);
                if (bool1)
                {
                  parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                  if ((parama != null) && (!parama.isRecycled()))
                  {
                    localc.aeNf.setImageBitmap(parama);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1186;
                  }
                  localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                  i = 0;
                  parama = (c.a)localObject1;
                  j = k;
                  break label1186;
                  if ((localb.title != null) && (localb.title.length() > 0))
                  {
                    localc.aeNg.setVisibility(0);
                    localc.aeNg.aZ(localb.title);
                    localc.aeNl.setVisibility(8);
                  }
                  localc.plr.setMaxLines(4);
                  localc.aeNm.setVisibility(4);
                  localc.aeNr.setVisibility(8);
                  if (bool1)
                  {
                    parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                    if ((parama != null) && (!parama.isRecycled()))
                    {
                      localc.aeNf.setImageBitmap(parama);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1186;
                    }
                    localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1186;
                    if ((localb.title != null) && (localb.title.length() > 0)) {
                      localc.aeNg.setVisibility(0);
                    }
                    for (;;)
                    {
                      localc.plr.setVisibility(0);
                      localc.aeNl.setVisibility(8);
                      localc.aeNm.setVisibility(8);
                      localc.aeNr.setVisibility(4);
                      localc.plr.setMaxLines(2);
                      if (!bool1) {
                        break label7997;
                      }
                      parama = com.tencent.mm.pluginsdk.model.app.h.c(localb.appId, 1, com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                      if ((parama != null) && (!parama.isRecycled())) {
                        break label5718;
                      }
                      localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.aeNg.setVisibility(8);
                    }
                    label5718:
                    localc.aeNf.setImageBitmap(parama);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1186;
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.aeNg.setVisibility(0);
                      localc.plr.setVisibility(0);
                      localc.aeNl.setVisibility(8);
                      localc.aeNr.setVisibility(8);
                      localc.aeNm.setVisibility(4);
                      localc.plr.setMaxLines(2);
                      if (bool1)
                      {
                        parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label5953;
                        }
                        localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                      }
                    }
                    for (;;)
                    {
                      parama = new bz(paramcc, false, paramInt, "", false, parama1.jrh(), localb.iaa, localb.iab, localb.title, localb.nRI, localb.url, false, false);
                      localc.aeNA.setTag(parama);
                      localc.aeNA.setOnClickListener(i(parama1));
                      j = 1;
                      i = 0;
                      break;
                      localc.aeNg.setVisibility(8);
                      break label5768;
                      localc.aeNf.setImageBitmap(parama);
                    }
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.aeNg.setVisibility(0);
                      label5993:
                      localc.plr.setVisibility(0);
                      localc.aeNl.setVisibility(8);
                      localc.aeNr.setVisibility(8);
                      localc.aeNm.setVisibility(4);
                      localc.plr.setMaxLines(2);
                      if (bool1)
                      {
                        parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                        if ((parama != null) && (!parama.isRecycled())) {
                          break label6184;
                        }
                        localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                      }
                    }
                    for (;;)
                    {
                      parama = new bz(paramcc, paramInt, "", parama1.jrh(), localb.iaa, localb.iab, localb.title, localb.nTq, localb.designerName, localb.designerRediretctUrl, localb.url);
                      localc.aeNA.setTag(parama);
                      localc.aeNA.setOnClickListener(j(parama1));
                      j = 1;
                      i = 0;
                      break;
                      localc.aeNg.setVisibility(8);
                      break label5993;
                      localc.aeNf.setImageBitmap(parama);
                    }
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.aeNg.setVisibility(0);
                      localc.plr.setVisibility(0);
                      localc.aeNl.setVisibility(8);
                      localc.aeNr.setVisibility(8);
                      localc.aeNm.setVisibility(4);
                      localc.plr.setMaxLines(2);
                      if (bool1)
                      {
                        if (!Util.isNullOrNil(paramcc.aJL())) {
                          break label6483;
                        }
                        r.bKe().loadImage(localb.thumburl, localc.aeNf);
                      }
                      parama = new bz();
                      parama.hTm = paramcc;
                      parama.aedO = false;
                      parama.position = paramInt;
                      parama.aeXN = false;
                      parama.title = parama1.jrh();
                      parama.iaa = localb.iaa;
                      parama.iab = localb.iab;
                      parama.acdC = localb.title;
                      if (localb.type != 26) {
                        break label6540;
                      }
                      parama.tid = localb.tid;
                      parama.nTr = localb.nTr;
                      parama.desc = localb.desc;
                      parama.iconUrl = localb.iconUrl;
                      parama.secondUrl = localb.secondUrl;
                      parama.pageType = localb.pageType;
                      localc.aeNA.setOnClickListener(k(parama1));
                      i = 1;
                    }
                    for (;;)
                    {
                      localc.aeNA.setTag(parama);
                      k = 0;
                      j = i;
                      i = k;
                      break;
                      localc.aeNg.setVisibility(8);
                      break label6224;
                      parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                      if ((parama == null) || (parama.isRecycled()))
                      {
                        localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                        break label6303;
                      }
                      localc.aeNf.setImageBitmap(parama);
                      break label6303;
                      if (localb.type == 27)
                      {
                        parama.tid = localb.tid;
                        parama.nTr = localb.nTr;
                        parama.desc = localb.desc;
                        parama.iconUrl = localb.iconUrl;
                        parama.secondUrl = localb.secondUrl;
                        parama.pageType = localb.pageType;
                        localc.aeNA.setOnClickListener(l(parama1));
                        i = 1;
                      }
                      else
                      {
                        Log.i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                        i = 0;
                      }
                    }
                    localc.aeNg.setVisibility(0);
                    localc.aeNg.aZ(localb.description);
                    localc.plr.setText(localb.nSo);
                    if ((localb.title != null) && (localb.title.length() > 0))
                    {
                      localc.aeNl.setVisibility(0);
                      localc.aeNl.setText(localb.title);
                    }
                    for (;;)
                    {
                      localc.plr.setMaxLines(4);
                      localc.aeNm.setVisibility(4);
                      localc.aeNr.setVisibility(8);
                      if (!bool1) {
                        break label7997;
                      }
                      parama = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                      if (parama == null) {
                        break label6805;
                      }
                      localc.aeNf.setImageBitmap(parama);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.aeNl.setVisibility(8);
                    }
                    localc.aeNf.setImageResource(R.k.app_attach_file_icon_webpage);
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1186;
                    localc.aeNg.setVisibility(8);
                    localc.aeNl.setVisibility(0);
                    if ((localb.title != null) && (localb.title.length() > 0)) {
                      localc.aeNl.setText(com.tencent.mm.pluginsdk.ui.span.p.d(localc.aeNl.getContext(), localb.title, (int)localc.aeNl.getTextSize()));
                    }
                    for (;;)
                    {
                      localc.plr.setMaxLines(3);
                      localc.aeNm.setVisibility(4);
                      localc.aeNr.setVisibility(8);
                      if (bool1) {
                        localc.aeNf.setVisibility(8);
                      }
                      e.c.b(parama1, localc, localb, paramcc, bool1);
                      if (!jxj()) {
                        break label7038;
                      }
                      a(localc, (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc);
                      b(localc, false);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                      localc.aeNl.setText(com.tencent.mm.pluginsdk.ui.span.p.d(localc.aeNl.getContext(), MMApplicationContext.getContext().getString(R.l.favorite_wenote), (int)localc.aeNl.getTextSize()));
                    }
                    label7038:
                    if (paramcc.getStatus() < 2) {}
                    for (bool2 = true;; bool2 = false)
                    {
                      b(localc, bool2);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break;
                    }
                    e.c.a(parama1, localc, localb, bool1);
                    if (jxj())
                    {
                      a(localc, (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class), paramcc);
                      b(localc, false);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1186;
                    }
                    if (paramcc.getStatus() < 2) {}
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
                      localc.aeNg.setVisibility(0);
                      if (!Util.isNullOrNil(localb.nSx)) {
                        if (!Util.isNullOrNil(localb.nSx))
                        {
                          localc.aeNg.setTextColor(Util.convertStringToRGB(localb.nSx, parama1.getContext().getResources().getColor(R.e.normal_text_color)));
                          localc.plr.setMaxLines(2);
                          localc.plr.setVisibility(0);
                          if (Util.isNullOrNil(localb.nSy)) {
                            break label7569;
                          }
                          localc.plr.setTextColor(Util.convertStringToRGB(localb.nSy, parama1.getContext().getResources().getColor(R.e.grey_background_text_color)));
                          localc.aeNl.setVisibility(8);
                          localc.aeNm.setVisibility(4);
                          localc.aeNr.setVisibility(8);
                          localc.aeNk.setVisibility(0);
                          localc.Aoo.setVisibility(0);
                          if (Util.isNullOrNil(localb.nSt)) {
                            break label7593;
                          }
                          localc.Aoo.setText(localb.nSt);
                        }
                      }
                    }
                    for (;;)
                    {
                      if (this.wQm)
                      {
                        parama = r.bKa().e(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                        if ((parama != null) && (!parama.isRecycled()))
                        {
                          paramString = BitmapUtil.getRoundedCornerBitmap(parama, false, parama.getWidth() / 2);
                          localc.aeNf.setImageBitmap(paramString);
                        }
                        if (!Util.isNullOrNil(localb.nSw))
                        {
                          r.bKe().a(localb.nSw, new ImageView(parama1.getContext()), new com.tencent.mm.modelimage.loader.a.c.a().bKt().bKx(), new com.tencent.mm.modelimage.loader.b.h()
                          {
                            public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
                            {
                              return null;
                            }
                            
                            public final void b(final String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
                            {
                              AppMethodBeat.i(36819);
                              if (paramAnonymousb.bitmap != null)
                              {
                                paramAnonymousString = paramAnonymousb.bitmap;
                                localc.aeNB.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                                {
                                  public final boolean onPreDraw()
                                  {
                                    AppMethodBeat.i(36818);
                                    e.e.10.this.aeOx.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                                    int j = e.e.10.this.aeOx.aeNB.getHeight();
                                    int k = e.e.10.this.aeOx.aeNB.getWidth();
                                    int i = j;
                                    if (j == 0) {
                                      i = com.tencent.mm.cd.a.br(e.e.10.this.XSz.aezO.getContext(), R.f.chatting_music_item_height);
                                    }
                                    j = k;
                                    if (k == 0) {
                                      j = com.tencent.mm.cd.a.br(e.e.10.this.XSz.aezO.getContext(), R.f.chatting_music_item_width);
                                    }
                                    BitmapDrawable localBitmapDrawable = new BitmapDrawable(BitmapUtil.createMaskImage(paramAnonymousString, R.g.chat_to_content_bg_mask, j, i));
                                    e.e.10.this.aeOx.aeNB.setBackgroundDrawable(localBitmapDrawable);
                                    AppMethodBeat.o(36818);
                                    return true;
                                  }
                                });
                              }
                              AppMethodBeat.o(36819);
                            }
                            
                            public final void c(String paramAnonymousString, View paramAnonymousView) {}
                          });
                          i = 0;
                          parama = (c.a)localObject1;
                          j = k;
                          break;
                          localc.aeNg.setTextColor(parama1.getContext().getResources().getColor(R.e.normal_text_color));
                          break label7248;
                          localc.aeNg.setTextColor(parama1.getContext().getResources().getColor(R.e.normal_text_color));
                          break label7248;
                          localc.aeNg.setVisibility(8);
                          break label7248;
                          localc.plr.setTextColor(parama1.getContext().getResources().getColor(R.e.grey_background_text_color));
                          break label7306;
                          localc.Aoo.setText(R.l.gyc);
                          continue;
                        }
                        localc.aeNB.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
                        {
                          private boolean aeOC = false;
                          
                          public final boolean onPreDraw()
                          {
                            AppMethodBeat.i(36820);
                            if (this.aeOC)
                            {
                              localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                              AppMethodBeat.o(36820);
                              return true;
                            }
                            localc.aeNB.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.aeOC = true;
                            int i = com.tencent.mm.cd.a.fromDPToPix(parama1.aezO.getContext(), 24);
                            Bitmap localBitmap = parama;
                            Object localObject;
                            if (localBitmap != null)
                            {
                              localObject = localBitmap;
                              if (!localBitmap.isRecycled()) {}
                            }
                            else
                            {
                              localObject = BitmapUtil.createColorBitmap(parama1.aezO.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), i, i);
                            }
                            int j = ((Bitmap)localObject).getHeight();
                            if (i > j) {
                              i = j;
                            }
                            for (;;)
                            {
                              localObject = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true), 0.9F), 20);
                              j = localc.aeNB.getHeight();
                              int k = localc.aeNB.getWidth();
                              i = j;
                              if (j == 0) {
                                i = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_height);
                              }
                              j = k;
                              if (k == 0) {
                                j = com.tencent.mm.cd.a.br(parama1.aezO.getContext(), R.f.chatting_music_item_width);
                              }
                              localObject = new BitmapDrawable(BitmapUtil.createMaskImage((Bitmap)localObject, R.g.chat_to_content_bg_mask, j, i));
                              localc.aeNB.setBackgroundDrawable((Drawable)localObject);
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
                    localc.aeNf.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.foI));
                    i = 0;
                    parama = (c.a)localObject1;
                    j = k;
                    break label1186;
                    if (((com.tencent.mm.message.t)localObject2).nUJ == 19)
                    {
                      e.c.a(parama1, localc, localb, bool1);
                      i = 0;
                      parama = (c.a)localObject1;
                      j = k;
                      break label1186;
                      localc.aeNf.setImageResource(R.g.icon_filled_green_umbrella);
                      localc.aeNg.setVisibility(8);
                      if ((localb.title != null) && (localb.title.length() > 0))
                      {
                        localc.aeNl.setMaxLines(3);
                        localc.aeNl.setVisibility(0);
                        localc.aeNl.setText(localb.getTitle());
                      }
                      for (;;)
                      {
                        localc.aeNr.setVisibility(8);
                        localc.aeNm.setVisibility(4);
                        i = 0;
                        parama = (c.a)localObject1;
                        j = k;
                        break;
                        localc.aeNl.setVisibility(8);
                      }
                      localc.aeNl.setVisibility(8);
                      break label1241;
                      localObject1 = r.bKa().b(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()), false);
                      if (localObject1 != null)
                      {
                        paramString = (String)localObject1;
                        if (!((Bitmap)localObject1).isRecycled()) {}
                      }
                      else
                      {
                        paramString = r.bKa().e(paramcc.aJL(), com.tencent.mm.cd.a.getDensity(parama1.getContext()));
                      }
                      if ((paramString != null) && (!paramString.isRecycled()))
                      {
                        localc.aeNf.setImageBitmap(paramString);
                        break label1341;
                      }
                      if (!Util.isNullOrNil(localb.thumburl))
                      {
                        paramString = localb.thumburl;
                        localObject1 = new com.tencent.mm.modelimage.loader.a.c.a();
                        ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).wB(R.e.chatting_item_biz_default_bg).bKu().bKs();
                        r.bKe().a(paramString, localc.aeOe, ((com.tencent.mm.modelimage.loader.a.c.a)localObject1).bKx());
                        break label1341;
                      }
                      localc.aeNf.setImageResource(R.g.fmp);
                      break label1341;
                    }
                  }
                }
                i = 0;
                parama = (c.a)localObject1;
                j = k;
                break label1186;
              }
            }
            parama = (c.a)localObject1;
            j = k;
            break label1186;
          }
          label4166:
          label6224:
          label7248:
          label8023:
          i = 1;
        }
        label1469:
        label2749:
        label7997:
        localObject2 = null;
        label1852:
        localb = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
    {
      AppMethodBeat.i(36829);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(36829);
        return false;
        AppMethodBeat.o(36829);
        return false;
        if ((paramcc != null) && (paramcc.fxR()))
        {
          paramMenuItem = k.b.Hf(paramcc.field_content);
          if (paramMenuItem != null)
          {
            if (paramMenuItem.type == 40)
            {
              com.tencent.mm.ui.base.k.a(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gHq), "", parama.aezO.getContext().getString(R.l.welcome_i_know), null);
              AppMethodBeat.o(36829);
              return false;
            }
            if ((paramMenuItem.type == 33) && (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.aezO.getContext())))
            {
              AppMethodBeat.o(36829);
              return false;
            }
          }
        }
        paramMenuItem = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
        if ((paramMenuItem != null) && (e.n(paramMenuItem) == 3)) {
          e.b.a(parama, paramcc, a(parama, paramcc), 2000, new com.tencent.mm.br.c.a()
          {
            public final void onActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
            {
              AppMethodBeat.i(254893);
              if ((paramAnonymousInt1 == 2000) && (paramAnonymousInt2 == -1))
              {
                paramAnonymousIntent = Util.listToString(paramAnonymousIntent.getStringArrayListExtra("SendMsgUsernames"), ";");
                cp localcp = cp.HcA;
                cp.a(paramcc, e.e.this.aedO, false, paramAnonymousIntent);
              }
              AppMethodBeat.o(254893);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          e.b.a(parama, paramcc, a(parama, paramcc));
        }
        paramMenuItem = paramcc.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.Hf(paramMenuItem);
        if (paramMenuItem != null) {
          switch (e.n(paramMenuItem))
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(36829);
          return false;
          com.tencent.mm.ui.chatting.ap.a(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
          continue;
          com.tencent.mm.ui.chatting.ap.d(paramcc, parama.aezO.getContext());
          continue;
          com.tencent.mm.ui.chatting.ap.b(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
          continue;
          com.tencent.mm.ui.chatting.ap.a(paramcc, parama.aezO.getContext(), a(parama, paramcc), parama.juG());
          continue;
          com.tencent.mm.ui.chatting.ap.p(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
          continue;
          com.tencent.mm.ui.chatting.ap.c(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), parama.aezO.getContext());
          continue;
          com.tencent.mm.ui.chatting.ap.c(paramcc, parama.aezO.getContext());
        }
        paramMenuItem = paramcc.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(36829);
          return false;
        }
        paramMenuItem = k.b.Hf(paramMenuItem);
        if (paramMenuItem != null) {
          switch (paramMenuItem.type)
          {
          default: 
            break;
          case 16: 
            parama = new me();
            parama.hOi.hOj = paramMenuItem.hOj;
            parama.hOi.hCz = paramcc.field_msgId;
            parama.hOi.hOk = paramcc.field_talker;
            parama.publish();
          }
        }
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255345);
      int i = ((bz)paramView.getTag()).position;
      if (paramcc.field_content == null)
      {
        AppMethodBeat.o(255345);
        return true;
      }
      paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
      if (paramContextMenuInfo == null)
      {
        AppMethodBeat.o(255345);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false);
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.m.bR(paramcc)) && (!com.tencent.mm.ui.chatting.m.bT(paramcc)) && (!com.tencent.mm.ui.chatting.m.bS(paramcc)) && ((paramContextMenuInfo.type != 19) || (paramcc.field_status != 1))) {
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!com.tencent.mm.storage.au.Hh(this.aeiK.getTalkerUserName()))) {
        params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
      }
      boolean bool1;
      switch (e.n(paramContextMenuInfo))
      {
      default: 
        bool1 = false;
      }
      for (;;)
      {
        if ((bool1) && (!this.aeiK.juH())) {
          params.add(i, 114, 0, paramView.getContext().getString(R.l.gyk));
        }
        if ((com.tencent.mm.br.c.blq("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).aqJ())) && (paramContextMenuInfo.nTP == 0)) {
          switch (e.n(paramContextMenuInfo))
          {
          }
        }
        for (;;)
        {
          localObject = new ex();
          ((ex)localObject).hFc.msgId = paramcc.field_msgId;
          ((ex)localObject).publish();
          if ((((ex)localObject).hFd.hEn) || (e.b.a(this.aeiK.aezO.getContext(), paramContextMenuInfo))) {
            params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
          }
          if (!this.aeiK.juH()) {
            params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
          }
          AppMethodBeat.o(255345);
          return true;
          bool1 = com.tencent.mm.an.g.bGR();
          break;
          bool1 = com.tencent.mm.an.g.bGL();
          break;
          boolean bool2 = com.tencent.mm.an.g.bGP();
          bool1 = bool2;
          if (Util.isImageExt(paramContextMenuInfo.nRe)) {
            break;
          }
          params.a(i, 150, this.aeiK.aezO.getMMResources().getString(R.l.gyv), R.k.icons_filled_otherapp);
          bool1 = bool2;
          break;
          bool1 = com.tencent.mm.an.g.bGI();
          break;
          bool1 = com.tencent.mm.an.g.bGH();
          break;
          bool1 = com.tencent.mm.an.g.bGN();
          break;
          bool1 = com.tencent.mm.an.g.bGJ();
          break;
          if ((paramContextMenuInfo.nSp != 5) && (paramContextMenuInfo.nSp != 6) && (paramContextMenuInfo.nSp != 2)) {
            break label870;
          }
          if (paramContextMenuInfo.nSp != 2) {
            params.clear();
          }
          params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
          AppMethodBeat.o(255345);
          return false;
          params.clear();
          params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
          AppMethodBeat.o(255345);
          return false;
          params.a(i, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
        }
        label870:
        bool1 = false;
      }
    }
    
    public final void b(View paramView, final com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
    {
      AppMethodBeat.i(255358);
      com.tencent.mm.ui.base.k.b(parama.aezO.getContext(), parama.aezO.getMMResources().getString(R.l.gzl), "", parama.aezO.getMMResources().getString(R.l.app_resend), parama.aezO.getMMResources().getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(179968);
          if (paramcc.fxR())
          {
            com.tencent.mm.pluginsdk.model.app.n.bx(paramcc);
            parama.jpK();
            AppMethodBeat.o(179968);
            return;
          }
          AppMethodBeat.o(179968);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(255358);
    }
    
    public final boolean c(View paramView, final com.tencent.mm.ui.chatting.d.a parama, final cc paramcc)
    {
      AppMethodBeat.i(36830);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      paramView.getTag();
      Object localObject = paramcc.field_content;
      if (localObject == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      localObject = k.b.Hf((String)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(36830);
        return false;
      }
      final com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject).appId, true, false);
      if ((localg != null) && (!Util.isNullOrNil(localg.field_appId))) {
        a(parama, (k.b)localObject, z.bAM(), localg, paramcc.field_msgSvrId, parama.getTalkerUserName());
      }
      int i = 0;
      switch (e.n((k.b)localObject))
      {
      default: 
        i = 1;
      }
      while ((i != 0) && (i((k.b)localObject, parama, this, paramcc)))
      {
        AppMethodBeat.o(36830);
        return true;
        bh.bCz();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
          AppMethodBeat.o(36830);
          return true;
        }
        if ((Util.isImageExt(((k.b)localObject).nRe)) && (a(paramcc.field_msgId, ((k.b)localObject).hzM, parama)))
        {
          AppMethodBeat.o(36830);
          return true;
        }
        paramView = new Intent();
        paramView.setClassName(parama.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramView.putExtra("scene", 2);
        paramView.putExtra("app_msg_id", paramcc.field_msgId);
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        parama.startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(36830);
        return true;
        if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(parama.aezO.getContext()))
        {
          AppMethodBeat.o(36830);
          return true;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(13043, new Object[] { Integer.valueOf(2), ((k.b)localObject).description, ((k.b)localObject).appId });
        boolean bool = f((k.b)localObject, parama, this, paramcc);
        AppMethodBeat.o(36830);
        return bool;
        bool = j((k.b)localObject, parama, this, paramcc);
        AppMethodBeat.o(36830);
        return bool;
        if (h((k.b)localObject, parama, this, paramcc))
        {
          AppMethodBeat.o(36830);
          return true;
          if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(parama.aezO.getContext()))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          if (g((k.b)localObject, parama, this, paramcc))
          {
            com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
            AppMethodBeat.o(36830);
            return true;
          }
          i = 1;
          continue;
          if (b((k.b)localObject, parama, this, paramcc)) {
            com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
          }
          AppMethodBeat.o(36830);
          return true;
          if ((localg != null) && (localg.aqJ()) && (a(parama, localg)))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          ((com.tencent.mm.ui.chatting.component.api.b)parama.cm(com.tencent.mm.ui.chatting.component.api.b.class)).a(paramcc, new com.tencent.mm.pluginsdk.model.app.ap()
          {
            public final void onLaunchApp(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
            {
              AppMethodBeat.i(255312);
              if (localg != null)
              {
                if (paramAnonymousBoolean1)
                {
                  e.e.a(parama, this.svq, z.bAM(), localg, paramcc.field_msgSvrId, 3, parama.getTalkerUserName());
                  AppMethodBeat.o(255312);
                  return;
                }
                e.e.a(parama, this.svq, z.bAM(), localg, paramcc.field_msgSvrId, 7, parama.getTalkerUserName());
              }
              AppMethodBeat.o(255312);
            }
          });
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(((k.b)localObject).nRB))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_Product_xml", ((k.b)localObject).nRB);
          paramView.putExtra("key_ProductUI_getProductInfoScene", 1);
          if (paramcc.field_imgPath == null) {
            paramView.putExtra("key_ProductUI_chatting_msgId", paramcc.field_msgId);
          }
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "scanner", ".ui.ProductUI", paramView);
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(((k.b)localObject).nRE))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_TV_xml", ((k.b)localObject).nRE);
          paramView.putExtra("key_TV_getProductInfoScene", 1);
          if (paramcc.field_imgPath == null) {
            paramView.putExtra("key_TVInfoUI_chatting_msgId", paramcc.field_msgId);
          }
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "shake", ".ui.TVInfoUI", paramView);
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(((k.b)localObject).nRH))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_product_info", ((k.b)localObject).nRH);
          paramView.putExtra("key_product_scene", 1);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "product", ".ui.MallProductUI", paramView);
          AppMethodBeat.o(36830);
          return true;
          if (Util.isNullOrNil(((k.b)localObject).hOj))
          {
            AppMethodBeat.o(36830);
            return false;
          }
          paramView = new Intent();
          paramView.setFlags(65536);
          paramView.putExtra("key_card_app_msg", ((k.b)localObject).hOj);
          paramView.putExtra("key_from_scene", ((k.b)localObject).nSp);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "card", ".ui.CardDetailUI", paramView);
          AppMethodBeat.o(36830);
          return true;
          bool = a(parama, paramcc, a(parama, paramcc), this);
          AppMethodBeat.o(36830);
          return bool;
          e.a((k.b)localObject, parama, paramcc);
          AppMethodBeat.o(36830);
          return true;
          paramView = new Intent();
          paramView.putExtra("key_biz_uin", ((k.b)localObject).nSr);
          paramView.putExtra("key_order_id", ((k.b)localObject).nSs);
          if ((paramcc.field_talker != null) && (!paramcc.field_talker.equals("")) && (com.tencent.mm.storage.au.bwE(paramcc.field_talker))) {
            paramView.putExtra("key_chatroom_name", paramcc.field_talker);
          }
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "card", ".ui.CardGiftAcceptUI", paramView);
          AppMethodBeat.o(36830);
          return true;
          if (e.a((k.b)localObject, parama))
          {
            AppMethodBeat.o(36830);
            return true;
          }
          i = 1;
          continue;
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(parama.aezO.getContext(), ((k.b)localObject).username, z.bAM(), ((com.tencent.mm.message.a.c)((k.b)localObject).aK(com.tencent.mm.message.a.c.class)).nVG, paramcc.getCreateTime());
          AppMethodBeat.o(36830);
          return true;
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(parama.aezO.getContext(), parama.getTalkerUserName(), z.bAM(), paramcc.getCreateTime(), paramcc.field_msgSvrId, paramcc.field_content, paramcc.field_imgPath, Boolean.TRUE);
          AppMethodBeat.o(36830);
          return true;
        }
      }
      AppMethodBeat.o(36830);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 49) || (paramInt == 335544369) || (paramInt == 402653233) || (paramInt == 369098801) || (paramInt == 738197553) || (paramInt == 905969713));
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e
 * JD-Core Version:    0.7.0.1
 */