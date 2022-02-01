package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.v;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.findersdk.a.br;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class am$j
  extends c
{
  private static int Nwi;
  private static int aeSp;
  private static int aeSq;
  private static int vGe;
  private static int vGf = 0;
  private static int vGg;
  private static int vGh = 0;
  private static int vGj;
  private boolean aeSr = false;
  private int aeSs = 0;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private long vMW = 0L;
  private boolean vMX = false;
  
  static
  {
    vGg = 0;
  }
  
  private static String a(cc paramcc, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(37167);
    if (paramContext == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
      AppMethodBeat.o(37167);
      return null;
    }
    if (paramcc == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
      AppMethodBeat.o(37167);
      return null;
    }
    paramcc = com.tencent.mm.message.m.a(paramContext, paramInt, paramcc.field_content, paramcc.field_talker, paramcc.field_msgId);
    AppMethodBeat.o(37167);
    return paramcc;
  }
  
  private static void a(View paramView, am.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(37159);
    if (paramBoolean)
    {
      if (paramb.vJU == null) {
        paramb.eF(paramView);
      }
      if (paramb.vJU != null)
      {
        paramb.vJU.setVisibility(0);
        AppMethodBeat.o(37159);
      }
    }
    else if (paramb.vJU != null)
    {
      paramb.vJU.setVisibility(8);
    }
    AppMethodBeat.o(37159);
  }
  
  private void a(ImageView paramImageView, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(37158);
    e.g localg = new e.g();
    localg.msgId = paramcc.field_msgId;
    localg.aeOM = paramInt;
    localg.xml = paramcc.field_content;
    paramImageView.setTag(localg);
    paramImageView.setOnClickListener(((com.tencent.mm.ui.chatting.component.api.m)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqw());
    AppMethodBeat.o(37158);
  }
  
  private void a(v paramv, View paramView)
  {
    AppMethodBeat.i(37168);
    com.tencent.mm.ui.chatting.u.a(paramv, paramView, this.aeiK.getTalkerUserName());
    AppMethodBeat.o(37168);
  }
  
  private void a(final v paramv, View paramView, final long paramLong1, long paramLong2, final int paramInt)
  {
    AppMethodBeat.i(37169);
    if (5 == paramv.type) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169876);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          localObject = SemiXml.decode(paramv.nVi);
          if (localObject != null)
          {
            if (paramInt == 0) {}
            for (paramAnonymousView = "";; paramAnonymousView = paramInt)
            {
              paramAnonymousView = ".msg.appmsg.mmreader.category.item".concat(String.valueOf(paramAnonymousView));
              String str = ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(27, 2, 25, null);
              if (!((br)com.tencent.mm.kernel.h.ax(br.class)).a(am.j.a(am.j.this).aezO.getContext(), paramAnonymousView, (Map)localObject, str)) {
                break;
              }
              Log.i("MicroMsg.ChattingItemBizFrom", "biz enter finder logic");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(169876);
              return;
            }
          }
          int i = am.j.a(am.j.this).aezO.getIntExtra("KOpenArticleSceneFromScene", 10000);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("biz_video_scene", 0);
          paramAnonymousView.putInt(f.b.adwc, i);
          paramAnonymousView.putInt("geta8key_scene", 7);
          paramAnonymousView.putString("geta8key_username", am.j.a(am.j.this).getTalkerUserName());
          com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b.a(am.j.a(am.j.this).aezO.getContext(), paramLong1, this.oHz, paramInt, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169876);
        }
      });
    }
    AppMethodBeat.o(37169);
  }
  
  private void a(v paramv, cc paramcc, int paramInt, com.tencent.mm.message.u paramu, View paramView)
  {
    AppMethodBeat.i(37153);
    String str = ((com.tencent.mm.ui.chatting.component.api.e)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.e.class)).bAJ(paramv.url);
    if (!TextUtils.isEmpty(str))
    {
      Log.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { str });
      paramu = new bz(paramcc, false, paramInt, paramv.url, false, this.aeiK.jrh(), paramu.iaa, paramu.iab, paramv.title, str, null, false, false);
      paramView.setOnClickListener(i(this.aeiK));
    }
    for (;;)
    {
      paramu.WMB = paramcc.field_msgSvrId;
      paramu.WMC = 0;
      paramu.aeXU = paramv.type;
      paramu.aeXV = paramv.title;
      paramu.thumbUrl = com.tencent.mm.message.m.a(paramv);
      paramView.setTag(paramu);
      if (com.tencent.mm.message.m.Hh(paramv.nUR)) {
        a(paramv, paramView);
      }
      a(paramv, paramView, paramcc.field_msgId, paramcc.field_msgSvrId, 0);
      paramView.setOnLongClickListener(c(this.aeiK));
      paramView.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
      AppMethodBeat.o(37153);
      return;
      paramu = new bz(paramcc, false, paramInt, paramv.url, false, this.aeiK.jrh(), paramu.iaa, paramu.iab, paramv.title);
      a(paramu, paramv, paramcc);
      paramView.setOnClickListener(h(this.aeiK));
    }
  }
  
  private static void a(am.c paramc, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(37160);
    boolean bool1;
    if (paramInt1 == 5)
    {
      bool1 = true;
      a(paramc.vMH, paramc.aeSf, bool1);
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
        a(paramc.vMH, paramc.aeSg, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 7) {
          break label203;
        }
        bool1 = true;
        a(paramc.vMH, paramc.aeSh, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 6) {
          break label209;
        }
        bool1 = true;
        label104:
        a(paramc.vMH, paramc.aeSi, bool1);
        if (bool1) {
          i = 1;
        }
        if (paramInt1 != 10) {
          break label215;
        }
        bool1 = true;
        a(paramc.vMH, paramc.aeSj, bool1);
        if (!bool1) {
          break label227;
        }
      }
      for (paramInt1 = 1;; paramInt1 = i)
      {
        LinearLayout localLinearLayout = paramc.vMH;
        paramc = paramc.aeSe;
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
  
  private void a(am.c paramc, final am.a parama, v paramv, cc paramcc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(37157);
    if (parama.vMq != null) {
      parama.vMq.setVisibility(8);
    }
    if (paramv.type == 5)
    {
      parama.vMs.setVisibility(0);
      parama.vMs.setImageResource(R.g.biz_time_line_item_video_play_selector);
      parama.vMs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169877);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          parama.vJU.performClick();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169877);
        }
      });
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 26);
      if (paramv.type != 7) {
        break label489;
      }
      paramInt = com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 32);
    }
    for (;;)
    {
      bq(parama.vMs, paramInt);
      AppMethodBeat.o(37157);
      return;
      if (paramv.type == 6)
      {
        parama.vMs.setVisibility(0);
        if (paramBoolean) {
          if ((paramcc.field_msgId + "_" + paramInt + "_msg").equals(paramc.playingMsgId)) {
            parama.vMs.setImageResource(R.g.chatting_item_biz_music_pause_selector);
          }
        }
        for (;;)
        {
          a(parama.vMs, paramcc, paramInt);
          break;
          parama.vMs.setImageResource(R.g.chatting_item_biz_music_play_selector);
          continue;
          if ((paramcc.field_msgId + "_" + paramInt + "_msg").equals(paramc.playingMsgId)) {
            parama.vMs.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
          } else {
            parama.vMs.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
          }
        }
      }
      if (paramv.type == 7)
      {
        parama.vMs.setVisibility(8);
        if (parama.vMq != null) {
          parama.vMq.setVisibility(0);
        }
        Drawable localDrawable = parama.vMr.getDrawable();
        if (((localDrawable instanceof AnimationDrawable)) && (((AnimationDrawable)localDrawable).isRunning())) {
          ((AnimationDrawable)localDrawable).stop();
        }
        if ((paramcc.field_msgId + "_" + paramInt + "_msg").equals(paramc.playingMsgId))
        {
          parama.vMr.setImageResource(R.g.biz_time_line_item_voice_playing_selector);
          if ((parama.vMr.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)parama.vMr.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(parama.vMr, paramcc, paramInt);
          break;
          parama.vMr.setImageResource(R.g.biz_time_line_item_voice_play_selector);
        }
      }
      parama.vMs.setVisibility(8);
      break;
      label489:
      if (paramv.type == 5) {
        paramInt = com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 24);
      }
    }
  }
  
  private void a(bz parambz, v paramv, cc paramcc)
  {
    AppMethodBeat.i(37162);
    Bundle localBundle = new Bundle();
    int i;
    switch (ac.aX(a(this.aeiK, paramcc), this.aeiK.getTalkerUserName()))
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
      localBundle.putString("share_report_pre_msg_desc", paramv.nUO);
      localBundle.putString("share_report_pre_msg_icon_url", com.tencent.mm.message.m.a(paramv));
      localBundle.putString("share_report_pre_msg_appid", "");
      localBundle.putInt("share_report_from_scene", i);
      if (i == 5) {
        localBundle.putString("share_report_biz_username", this.aeiK.getTalkerUserName());
      }
      parambz.aeXS = localBundle;
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
    paramString = com.tencent.mm.api.b.U(paramString, 3);
    com.tencent.mm.modelimage.loader.a locala = r.bKe();
    com.tencent.mm.modelimage.loader.a.c.a locala1 = new com.tencent.mm.modelimage.loader.a.c.a();
    locala1.oKE = R.e.chatting_item_biz_default_bg;
    locala1.oKp = true;
    locala1 = locala1.eG(paramInt1, paramInt2);
    locala1.oKe = new n(2);
    locala1.oKN = new com.tencent.mm.pluginsdk.ui.applet.e(2);
    locala1.fullPath = y.bpF(paramString);
    locala.a(paramString, paramImageView, locala1.bKx(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, 0, 0, parama));
    AppMethodBeat.o(37163);
  }
  
  private void a(String paramString, ImageView paramImageView, boolean paramBoolean, int paramInt, m.a parama)
  {
    AppMethodBeat.i(37164);
    paramString = com.tencent.mm.api.b.U(paramString, 3);
    int i;
    boolean bool;
    label28:
    int j;
    label37:
    float f1;
    if (paramBoolean)
    {
      i = R.g.fmC;
      if (!paramBoolean) {
        break label248;
      }
      bool = false;
      if (!paramBoolean) {
        break label254;
      }
      j = R.g.fmF;
      f1 = this.aeiK.aezO.getContext().getResources().getDimensionPixelSize(R.f.chatting_item_corners_size);
      if (!((com.tencent.mm.ui.chatting.component.api.m)this.aeiK.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqo()) {
        break label262;
      }
    }
    label262:
    for (int k = 72;; k = 32)
    {
      Object localObject = com.tencent.mm.plugin.bizui.a.a.vtB;
      int m = com.tencent.mm.plugin.bizui.a.a.fK(paramImageView.getContext());
      float f2 = com.tencent.mm.cd.a.getDensity(paramImageView.getContext());
      k = m - (int)(k * f2);
      localObject = r.bKe();
      com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
      locala.oKE = j;
      locala.oKp = true;
      locala.oKG = String.valueOf(i);
      locala = locala.eG(k, paramInt);
      locala.oKe = new n(2);
      locala.oKN = new com.tencent.mm.pluginsdk.ui.applet.e(2);
      locala.fullPath = y.bpF(paramString);
      ((com.tencent.mm.modelimage.loader.a)localObject).a(paramString, paramImageView, locala.bKx(), null, new com.tencent.mm.pluginsdk.ui.applet.m(2, k, paramInt, true, bool, f1, parama));
      AppMethodBeat.o(37164);
      return;
      i = R.g.fmB;
      break;
      label248:
      bool = true;
      break label28;
      label254:
      j = R.g.fmE;
      break label37;
    }
  }
  
  private static void ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(255581);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(255581);
  }
  
  private static void ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(37156);
    Object localObject;
    if ((paramView.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).rightMargin = paramInt;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(37156);
      return;
    }
    if ((paramView.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(37156);
  }
  
  private static void bq(View paramView, int paramInt)
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
  
  private void i(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37165);
    if (this.vMX)
    {
      if (!this.vMX)
      {
        Log.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
        AppMethodBeat.o(37165);
        return;
      }
      com.tencent.mm.ui.chatting.u.a(this.aeSs, parama.aezO.getContext(), paramcc.field_content, paramcc.field_talker, paramcc.field_msgId, paramcc.field_msgSvrId);
      AppMethodBeat.o(37165);
      return;
    }
    String str = a(paramcc, parama.aezO.getContext(), this.aeSs);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(37165);
      return;
    }
    Intent localIntent = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
    localIntent.putExtra("Retr_Msg_content", str);
    localIntent.putExtra("Retr_Msg_Type", 2);
    localIntent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.aeSs);
    localIntent.putExtra("Retr_Msg_Id", paramcc.field_msgId);
    localIntent.putExtra("Retr_MsgFromScene", 1);
    str = paramcc.field_talker;
    Object localObject = ad.Jo(paramcc.field_msgSvrId);
    localIntent.putExtra("reportSessionId", (String)localObject);
    localObject = ad.bCb().M((String)localObject, true);
    ((ad.b)localObject).q("prePublishId", "msg_" + paramcc.field_msgSvrId);
    ((ad.b)localObject).q("preUsername", str);
    ((ad.b)localObject).q("preChatName", str);
    ((ad.b)localObject).q("preMsgIndex", Integer.valueOf(this.aeSs));
    ((ad.b)localObject).q("sendAppMsgScene", Integer.valueOf(1));
    paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramcc.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramcc.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom", "doRestransmit", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37165);
  }
  
  private static void no(Context paramContext)
  {
    AppMethodBeat.i(37151);
    int i;
    int j;
    if (vGh == 0)
    {
      vGh = paramContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
      vGg = paramContext.getResources().getDimensionPixelSize(R.f.MiddlePadding);
      vGf = paramContext.getResources().getDimensionPixelSize(R.f.LargePadding);
      vGe = paramContext.getResources().getDimensionPixelSize(R.f.chatting_item_biz_sub_item_pic_size);
      vGj = paramContext.getResources().getDimensionPixelSize(R.f.chatting_item_biz_line_big_padding);
      com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
      i = com.tencent.mm.plugin.bizui.a.a.fK(paramContext);
      j = com.tencent.mm.cd.a.mt(paramContext);
      if (i >= j) {
        break label145;
      }
    }
    for (;;)
    {
      i -= (int)(com.tencent.mm.cd.a.getDensity(paramContext) * 32.0F);
      Nwi = (int)(i / 2.35D);
      aeSp = (int)(i / 1.777778F);
      aeSq = (int)(i / 1.777778F);
      AppMethodBeat.o(37151);
      return;
      label145:
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
      localObject = new ap(paramLayoutInflater, R.i.gfk);
      paramView = new am.c();
      paramView.timeTV = ((TextView)((View)localObject).findViewById(R.h.fAm));
      paramView.historyMsgTip = ((View)localObject).findViewById(R.h.fyu);
      paramView.vMH = ((LinearLayout)((View)localObject).findViewById(R.h.fxA));
      paramView.checkBox = ((CheckBox)((View)localObject).findViewById(R.h.fxt));
      paramView.maskView = ((View)localObject).findViewById(R.h.fzn);
      paramView.aeNs = ((TextView)((View)localObject).findViewById(R.h.fwD));
      ((View)localObject).setTag(paramView);
    }
    no(paramLayoutInflater.getContext());
    AppMethodBeat.o(37150);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, final String paramString)
  {
    AppMethodBeat.i(37152);
    this.aeiK = parama1;
    no(parama1.aezO.getContext());
    final am.c localc = (am.c)parama;
    parama = localc.vMK.iterator();
    if (parama.hasNext())
    {
      paramString = (am.a)parama.next();
      if (localc.vMK.indexOf(paramString) != localc.vMK.size() - 1) {
        as.bj(paramString.vJU, 1);
      }
      for (;;)
      {
        localc.vMH.removeView(paramString.vJU);
        break;
        as.bj(paramString.vJU, 2);
      }
    }
    localc.vMK.clear();
    com.tencent.mm.message.u localu = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
    parama = localu.kLg;
    if ((parama == null) || (parama.length() == 0)) {
      localc.aeNs.setVisibility(8);
    }
    LinkedList localLinkedList;
    final int j;
    for (;;)
    {
      localLinkedList = localu.nUC;
      j = localLinkedList.size();
      if (j != 0) {
        break;
      }
      localc.vMH.setVisibility(8);
      a(localc, -1, 0);
      AppMethodBeat.o(37152);
      return;
      localc.aeNs.setVisibility(0);
      b(parama1, localc.aeNs, bz.bBE(parama));
    }
    localc.vMH.setVisibility(0);
    a(localc, ((v)localLinkedList.get(0)).type, j);
    Object localObject1 = parama1.aezO.getActivityLayoutInflater();
    final int i = localc.vMK.size() + 2;
    while (i < j)
    {
      paramString = as.aBU(1);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(R.i.gfl, null);
      }
      localc.lL(parama);
      i += 1;
    }
    if (j > 1)
    {
      paramString = as.aBU(2);
      parama = paramString;
      if (paramString == null) {
        parama = ((LayoutInflater)localObject1).inflate(R.i.gfm, null);
      }
      localc.lL(parama);
    }
    for (this.aeSr = true;; this.aeSr = false)
    {
      i = 0;
      while (i < localc.vMK.size())
      {
        ((am.a)localc.vMK.get(i)).vJU.setVisibility(8);
        i += 1;
      }
    }
    paramString = (v)localLinkedList.get(0);
    c(paramString);
    label571:
    final boolean bool;
    label641:
    label704:
    label760:
    label763:
    Object localObject2;
    int k;
    label873:
    label884:
    Object localObject3;
    if (paramString.type == 5)
    {
      parama = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.vQH;
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.I(paramString.url, 5, "");
      ac(localc.aeSf.vJg, aeSp);
      ac(localc.aeSf.vIX, aeSp);
      if (Util.isNullOrNil(paramString.title))
      {
        localc.aeSf.vIW.setVisibility(8);
        if (j != 1) {
          break label1541;
        }
        localc.aeSf.vIX.setBackgroundResource(R.g.fns);
        parama = com.tencent.mm.message.m.uD(paramString.nUQ);
        if (TextUtils.isEmpty(parama)) {
          break label1558;
        }
        localc.aeSf.timeTv.setVisibility(0);
        localc.aeSf.timeTv.setText(parama);
        localc.aeSf.timeTv.setTextColor(this.aeiK.aezO.getContext().getResources().getColor(R.e.light_grey_text_color));
        a(paramString, paramcc, paramInt, localu, localc.aeSf.vJU);
        localc.aeSf.vIM.setVisibility(8);
        parama = paramString.nUM;
        localObject1 = localc.aeSf.vIK;
        paramcc.getType();
        if (j <= 1) {
          break label1574;
        }
        bool = true;
        a(parama, (ImageView)localObject1, bool, aeSp, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37143);
            localc.aeSf.vIM.setVisibility(0);
            localc.aeSf.vIW.setTextColor(am.j.a(am.j.this).aezO.getContext().getResources().getColor(R.e.white_text_color));
            localc.aeSf.timeTv.setTextColor(am.j.a(am.j.this).aezO.getContext().getResources().getColor(R.e.white_text_color));
            ImageView localImageView = localc.aeSf.vIM;
            if (j > 1) {}
            for (int i = R.g.biz_time_line_title_gradient_mask;; i = R.g.biz_time_line_title_gradient_mask_round)
            {
              localImageView.setBackgroundResource(i);
              AppMethodBeat.o(37143);
              return;
            }
          }
          
          public final void onStart() {}
        });
        if (com.tencent.mm.cd.a.getScaleSize(this.aeiK.aezO.getContext()) <= 1.125F) {
          break label1580;
        }
        localc.aeSf.vIW.setMaxLines(1);
        i = 1;
        if (i >= j) {
          break label4641;
        }
        localObject1 = (v)localLinkedList.get(i);
        c((v)localObject1);
        localObject2 = (am.a)localc.vMK.get(i - 1);
        k = paramString.type;
        if ((i != 1) || ((k != 5) && (k != 8) && (k != 0))) {
          break label3961;
        }
        if ((k != 0) || (!Util.isNullOrNil(((v)localLinkedList.get(0)).nUM))) {
          break label3948;
        }
        ((am.a)localObject2).plj.setVisibility(0);
        ad(((am.a)localObject2).plj, vGf);
        if (i != 1) {
          break label4128;
        }
        if (i != j - 1) {
          break label4109;
        }
        ((am.a)localObject2).yBS.setPadding(0, vGf, 0, vGf);
        label915:
        a(localc, (am.a)localObject2, (v)localObject1, paramcc, i, false);
        ((am.a)localObject2).vIW.setTextColor(parama1.aezO.getMMResources().getColor(R.e.normal_text_color));
        if (!Util.isNullOrNil(((v)localObject1).title)) {
          break label4217;
        }
        localObject3 = com.tencent.mm.plugin.brandservice.model.b.vBC;
        k = ((v)localObject1).type;
        parama = this.aeiK.aezO.getContext();
        switch (k)
        {
        case 6: 
        default: 
          parama = parama.getResources().getString(R.l.gwT);
          label1027:
          ((com.tencent.mm.plugin.brandservice.model.b)localObject3).a(parama, ((am.a)localObject2).vIW, (v)localObject1, 3);
          label1041:
          if ((((v)localObject1).nUP == 0) || (((v)localObject1).nUP == 1))
          {
            ((am.a)localObject2).vMp.setVisibility(0);
            ((am.a)localObject2).vIW.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_0));
            if (((v)localObject1).type == 7)
            {
              ((am.a)localObject2).vIK.setVisibility(8);
              label1111:
              if ((Util.isNullOrNil(((v)localObject1).nUO)) || (((v)localObject1).type != 3)) {
                break label4532;
              }
              ((am.a)localObject2).vMo.setText(((v)localObject1).nUO);
              ((am.a)localObject2).vMo.setVisibility(0);
              ((am.a)localObject2).vJU.setVisibility(0);
              parama = ((com.tencent.mm.ui.chatting.component.api.e)parama1.cm(com.tencent.mm.ui.chatting.component.api.e.class)).bAJ(((v)localObject1).url);
              if (TextUtils.isEmpty(parama)) {
                break label4545;
              }
              Log.d("MicroMsg.ChattingItemBizFrom", "productId:%s", new Object[] { parama });
              parama = new bz(paramcc, false, paramInt, ((v)localObject1).url, this.aeSr, parama1.jrh(), localu.iaa, localu.iab, ((v)localObject1).title, parama, null, false, true);
              ((am.a)localObject2).vJU.setOnClickListener(i(parama1));
              label1261:
              parama.WMB = paramcc.field_msgSvrId;
              parama.WMC = i;
              parama.aeXU = ((v)localObject1).type;
              parama.aeXV = ((v)localObject1).title;
              parama.thumbUrl = com.tencent.mm.message.m.a((v)localObject1);
              ((am.a)localObject2).vJU.setTag(parama);
              if (com.tencent.mm.message.m.Hh(((v)localObject1).nUR)) {
                a((v)localObject1, ((am.a)localObject2).vJU);
              }
              a((v)localObject1, ((am.a)localObject2).vJU, paramcc.field_msgId, paramcc.field_msgSvrId, i);
              ((am.a)localObject2).vJU.setOnLongClickListener(c(parama1));
              ((am.a)localObject2).vJU.setOnTouchListener(((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
              if (((v)localObject1).type != 8) {
                break label4618;
              }
              ((am.a)localObject2).vNo.setImageResource(R.k.biz_time_line_pic_icon);
              ((am.a)localObject2).vNo.setVisibility(0);
              if (((v)localObject1).nVc <= 1) {
                break label4605;
              }
              ((am.a)localObject2).aeSd.setVisibility(0);
              ((am.a)localObject2).aeSd.setText(String.valueOf(((v)localObject1).nVc));
            }
          }
          label1153:
          break;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label763;
      localc.aeSf.vIW.aZ(paramString.title);
      localc.aeSf.vIW.getPaint().setFakeBoldText(true);
      localc.aeSf.vIW.setVisibility(0);
      localc.aeSf.vIW.setTextColor(this.aeiK.aezO.getContext().getResources().getColor(R.e.light_grey_text_color));
      break;
      label1541:
      localc.aeSf.vIX.setBackgroundResource(R.g.fnt);
      break label571;
      label1558:
      localc.aeSf.timeTv.setVisibility(8);
      break label641;
      label1574:
      bool = false;
      break label704;
      label1580:
      localc.aeSf.vIW.setMaxLines(2);
      break label760;
      if (paramString.type == 8)
      {
        ac(localc.aeSg.vJg, aeSq);
        ac(localc.aeSg.vIX, aeSq);
        if ((j > 1) || (!Util.isNullOrNil(paramString.nUO)))
        {
          bool = true;
          label1653:
          if (bool) {
            break label1918;
          }
          localc.aeSg.vIX.setBackgroundResource(R.g.fns);
          label1672:
          if (paramString.nVc <= 1) {
            break label1935;
          }
          localc.aeSg.aeSd.setVisibility(0);
          localc.aeSg.aeSd.setText(String.valueOf(paramString.nVc));
          label1712:
          if (paramString.nVc <= 1) {
            break label1951;
          }
          parama = String.format(MMApplicationContext.getContext().getResources().getString(R.l.gXc), new Object[] { String.valueOf(paramString.nVc), paramString.nUO });
          label1760:
          localc.aeSg.vJg.setContentDescription(parama);
          if ((Util.isNullOrNil(paramString.nUO)) || (j != 1)) {
            break label1988;
          }
          localc.aeSg.aeSl.setVisibility(0);
          localc.aeSg.aeSk.aZ(paramString.nUO);
          localc.aeSg.aeSl.setBackgroundResource(R.g.fmD);
        }
        for (;;)
        {
          localc.aeSg.vIM.setVisibility(8);
          parama = paramString.nUM;
          localObject1 = localc.aeSg.vIK;
          paramcc.getType();
          a(parama, (ImageView)localObject1, bool, aeSq, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37145);
              localc.aeSg.vIM.setVisibility(0);
              localc.aeSg.dpM.setImageResource(R.k.biz_time_line_pic_icon);
              ImageView localImageView = localc.aeSg.vIM;
              if (bool) {}
              for (int i = R.g.biz_time_line_title_gradient_mask;; i = R.g.biz_time_line_title_gradient_mask_round)
              {
                localImageView.setBackgroundResource(i);
                AppMethodBeat.o(37145);
                return;
              }
            }
            
            public final void onStart() {}
          });
          a(paramString, paramcc, paramInt, localu, localc.aeSg.vJU);
          break;
          bool = false;
          break label1653;
          label1918:
          localc.aeSg.vIX.setBackgroundResource(R.g.fnt);
          break label1672;
          label1935:
          localc.aeSg.aeSd.setVisibility(8);
          break label1712;
          label1951:
          parama = String.format(MMApplicationContext.getContext().getResources().getString(R.l.gXd), new Object[] { localc.aeSg.aeSk.jPy() });
          break label1760;
          label1988:
          localc.aeSg.aeSl.setVisibility(8);
        }
      }
      if (paramString.type == 7)
      {
        if (Util.isNullOrNil(paramString.title))
        {
          localc.aeSh.mll.setVisibility(8);
          label2038:
          if (j <= 1) {
            break label2285;
          }
          localc.aeSh.vJU.setBackgroundResource(R.g.chatting_item_multi_top);
          label2058:
          parama = com.tencent.mm.message.m.uD(paramString.nUQ);
          if (TextUtils.isEmpty(parama)) {
            break label2302;
          }
          localc.aeSh.vLJ.setVisibility(0);
          localc.aeSh.vLJ.setText(parama);
          label2098:
          parama = localc.aeSh.vMs.getDrawable();
          if (((parama instanceof AnimationDrawable)) && (((AnimationDrawable)parama).isRunning())) {
            ((AnimationDrawable)parama).stop();
          }
          if (!(paramcc.field_msgId + "_0_msg").equals(localc.playingMsgId)) {
            break label2317;
          }
          localc.aeSh.vMs.setImageResource(R.g.biz_time_line_item_voice_playing_selector);
          if ((localc.aeSh.vMs.getDrawable() instanceof AnimationDrawable)) {
            ((AnimationDrawable)localc.aeSh.vMs.getDrawable()).start();
          }
        }
        for (;;)
        {
          a(localc.aeSh.vMs, paramcc, 0);
          a(paramString, paramcc, paramInt, localu, localc.aeSh.vJU);
          break;
          localc.aeSh.mll.setVisibility(0);
          localc.aeSh.mll.setText(paramString.title);
          break label2038;
          label2285:
          localc.aeSh.vJU.setBackgroundResource(R.g.white_corner_bg_selector);
          break label2058;
          label2302:
          localc.aeSh.vLJ.setVisibility(4);
          break label2098;
          label2317:
          localc.aeSh.vMs.setImageResource(R.g.biz_time_line_item_voice_play_selector);
        }
      }
      if (paramString.type == 6)
      {
        localObject1 = (v)localLinkedList.get(0);
        if (Util.isNullOrNil(((v)localObject1).title))
        {
          localc.aeSi.mll.setVisibility(8);
          label2381:
          if (j <= 1) {
            break label2653;
          }
          localc.aeSi.vJU.setBackgroundResource(R.g.chatting_item_multi_top);
          label2401:
          if (TextUtils.isEmpty(((v)localObject1).nVa)) {
            break label2670;
          }
          localc.aeSi.vNi.setVisibility(0);
          localc.aeSi.vNi.setText(((v)localObject1).nVa);
          label2440:
          if (((v)localObject1).nVb != 2) {
            break label2686;
          }
          localc.aeSi.vNj.setImageResource(R.k.chatting_item_biz_kugou_music_watermark);
          label2463:
          a(localc.aeSi.vMs, paramcc, 0);
          a((v)localObject1, paramcc, paramInt, localu, localc.aeSi.vJU);
          if (!(paramcc.field_msgId + "_0_msg").equals(localc.playingMsgId)) {
            break label2703;
          }
          localc.aeSi.vMs.setImageResource(R.k.chatting_item_biz_music_pause_loading_icon);
        }
        for (;;)
        {
          localc.aeSi.vIM.setVisibility(8);
          parama = new WeakReference(localc);
          localObject1 = ((v)localObject1).nUM;
          localObject2 = localc.aeSi.vIK;
          paramcc.getType();
          i = vGe;
          a((String)localObject1, (ImageView)localObject2, i, i, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37144);
              am.c localc = (am.c)parama.get();
              if (localc == null)
              {
                AppMethodBeat.o(37144);
                return;
              }
              localc.aeSi.vIM.setVisibility(0);
              if ((paramcc.field_msgId + "_0_msg").equals(localc.playingMsgId))
              {
                localc.aeSi.vMs.setImageResource(R.g.chatting_item_biz_music_pause_selector);
                AppMethodBeat.o(37144);
                return;
              }
              localc.aeSi.vMs.setImageResource(R.g.chatting_item_biz_music_play_selector);
              AppMethodBeat.o(37144);
            }
            
            public final void onStart() {}
          });
          break;
          localc.aeSi.mll.setVisibility(0);
          localc.aeSi.mll.setText(((v)localObject1).title);
          break label2381;
          label2653:
          localc.aeSi.vJU.setBackgroundResource(R.g.white_corner_bg_selector);
          break label2401;
          label2670:
          localc.aeSi.vNi.setVisibility(8);
          break label2440;
          label2686:
          localc.aeSi.vNj.setImageResource(R.k.chatting_item_biz_qq_music_watermark);
          break label2463;
          label2703:
          localc.aeSi.vMs.setImageResource(R.k.chatting_item_biz_music_play_loading_icon);
        }
      }
      if (paramString.type == 10)
      {
        if (Util.isNullOrNil(paramString.title))
        {
          localc.aeSj.vIW.setVisibility(8);
          if (j <= 1) {
            break label3229;
          }
          localc.aeSj.vJU.setBackgroundResource(R.g.chatting_item_multi_top);
        }
        for (;;)
        {
          a(paramString, paramcc, paramInt, localu, localc.aeSj.vJU);
          break;
          localc.aeSj.vIW.setOnTouchListener(new l(localc.aeSj.vIW, new com.tencent.mm.pluginsdk.ui.span.s(this.aeiK.aezO.getContext())));
          localc.aeSj.vIW.setVisibility(0);
          localc.aeSj.vIW.aZ(p.j(this.aeiK.aezO.getContext(), paramString.title, (int)localc.aeSj.vIW.getTextSize()));
          parama = com.tencent.mm.plugin.bizui.a.a.vtB;
          i = com.tencent.mm.plugin.bizui.a.a.fK(this.aeiK.aezO.getContext());
          k = (int)(com.tencent.mm.cd.a.getDensity(this.aeiK.aezO.getContext()) * 80.0F);
          parama = localc.aeSj.vIW.pE(i - k, 2147483647);
          if (parama != null) {}
          for (i = parama.jQH();; i = 0)
          {
            parama = (LinearLayout.LayoutParams)localc.aeSj.vIW.getLayoutParams();
            localObject1 = (LinearLayout.LayoutParams)localc.aeSj.aeSo.getLayoutParams();
            if (i > 3) {
              break label3065;
            }
            localc.aeSj.aeSn.setVisibility(8);
            ((LinearLayout.LayoutParams)localObject1).gravity = 16;
            localc.aeSj.aeSo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = 0;
            parama.gravity = 17;
            localc.aeSj.vIW.setLayoutParams(parama);
            break;
          }
          label3065:
          if (paramString.nVf == 1)
          {
            i = 1;
            localc.aeSj.aeSn.setVisibility(0);
            ((LinearLayout.LayoutParams)localObject1).gravity = 48;
            localc.aeSj.aeSo.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            parama.topMargin = com.tencent.mm.cd.a.fromDPToPix(this.aeiK.aezO.getContext(), 38);
            parama.gravity = 8388627;
            if (i == 0) {
              break label3200;
            }
            localc.aeSj.vIW.setMaxLines(2147483647);
            localc.aeSj.aeSn.setText(R.l.biz_time_line_item_text_collapse);
          }
          for (;;)
          {
            label3077:
            localc.aeSj.aeSn.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37146);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if (paramString.nVf == 1)
                {
                  localc.aeSj.vIW.setMaxLines(3);
                  localc.aeSj.aeSn.setText(R.l.biz_time_line_item_text_expand);
                }
                for (paramString.nVf = 0;; paramString.nVf = 1)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemBiz$ChattingItemBizFrom$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(37146);
                  return;
                  localc.aeSj.vIW.setMaxLines(2147483647);
                  localc.aeSj.aeSn.setText(R.l.biz_time_line_item_text_collapse);
                }
              }
            });
            break;
            i = 0;
            break label3077;
            label3200:
            localc.aeSj.vIW.setMaxLines(3);
            localc.aeSj.aeSn.setText(R.l.biz_time_line_item_text_expand);
          }
          label3229:
          localc.aeSj.vJU.setBackgroundResource(R.g.white_corner_bg_selector);
        }
      }
      parama = localc.aeSe.vIW;
      if (j > 1)
      {
        i = 8;
        label3265:
        parama.setVisibility(i);
        parama = localc.aeSe.aeSm;
        if ((j <= 1) && (!Util.isNullOrNil(paramString.nUO))) {
          break label3665;
        }
        i = 8;
        label3301:
        parama.setVisibility(i);
        parama = localc.aeSe.Nwt;
        if (j <= 1) {
          break label3671;
        }
      }
      label3665:
      label3671:
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.aeSe.Nwu.setVisibility(8);
        if (j != 1) {
          break label3678;
        }
        localc.aeSe.vIX.setBackgroundResource(R.g.fns);
        localc.aeSe.Nwq.setVisibility(0);
        ac(localc.aeSe.vJg, Nwi);
        ac(localc.aeSe.vIX, Nwi);
        if (Util.isNullOrNil(paramString.nUM)) {
          break label3790;
        }
        localc.aeSe.vJg.setVisibility(0);
        parama = paramString.nUM;
        localObject1 = localc.aeSe.vIK;
        paramcc.getType();
        a(parama, (ImageView)localObject1, true, Nwi, new m.a()
        {
          public final void onFinish()
          {
            AppMethodBeat.i(37142);
            if (j > 1)
            {
              localc.aeSe.Nwt.setTextColor(am.j.a(am.j.this).aezO.getContext().getResources().getColor(R.e.white_text_color));
              localc.aeSe.Nwt.setBackgroundResource(R.g.biz_msg_cover_gradient_mask);
            }
            localc.aeSe.Nwu.setVisibility(0);
            AppMethodBeat.o(37142);
          }
          
          public final void onStart() {}
        });
        localc.aeSe.Nwq.setBackgroundResource(R.g.chatting_item_multbg_bottom_normal);
        parama = localc.aeSe.Nwq;
        i = vGf;
        k = vGg;
        int m = vGf;
        parama.setPadding(i, k, m, m);
        localc.aeSe.vIX.setVisibility(0);
        localc.aeSe.aeSm.setMaxLines(30);
        localc.aeSe.aeSm.setText(paramString.nUO);
        com.tencent.mm.plugin.brandservice.model.b.vBC.a(paramString.title, localc.aeSe.vIW, paramString, 2);
        com.tencent.mm.plugin.brandservice.model.b.vBC.a(paramString.title, localc.aeSe.Nwt, paramString, 21);
        if ((paramString.nUP != 0) && (paramString.nUP != 1)) {
          localc.aeSe.Nwt.setVisibility(4);
        }
        a(paramString, paramcc, paramInt, localu, localc.aeSe.vJU);
        break;
        i = 0;
        break label3265;
        i = 0;
        break label3301;
      }
      label3678:
      parama = localc.aeSe.Nwq;
      if (Util.isNullOrNil(paramString.nUM)) {}
      for (i = 0;; i = 8)
      {
        parama.setVisibility(i);
        localc.aeSe.vIX.setBackgroundResource(R.g.fnt);
        localc.aeSe.Nwt.setTextColor(this.aeiK.aezO.getContext().getResources().getColor(R.e.light_grey_text_color));
        localc.aeSe.Nwt.setBackgroundResource(R.g.mm_trans);
        localc.aeSe.Nwt.getPaint().setFakeBoldText(true);
        break;
      }
      label3790:
      localc.aeSe.aeSm.setMaxLines(100);
      localc.aeSe.vJg.setVisibility(8);
      localc.aeSe.vIW.setVisibility(0);
      parama = localc.aeSe.aeSm;
      if (Util.isNullOrNil(paramString.nUO))
      {
        i = 8;
        label3852:
        parama.setVisibility(i);
        if (j != 1) {
          break label3931;
        }
        localc.aeSe.Nwq.setBackgroundResource(R.g.white_corner_bg_selector);
      }
      for (;;)
      {
        parama = localc.aeSe.Nwq;
        i = vGf;
        k = vGf;
        parama.setPadding(i, i, k, k);
        localc.aeSe.vIX.setVisibility(8);
        break;
        i = 0;
        break label3852;
        label3931:
        localc.aeSe.Nwq.setBackgroundResource(R.g.chatting_item_multi_top);
      }
      label3948:
      ((am.a)localObject2).plj.setVisibility(8);
      break label884;
      label3961:
      ((am.a)localObject2).plj.setVisibility(0);
      if (i <= 1) {
        break label873;
      }
      parama = (v)localLinkedList.get(i - 1);
      localObject3 = (v)localLinkedList.get(i);
      if (((parama.type != 7) && (parama.type != 5) && (parama.type != 6) && (Util.isNullOrNil(parama.nUM))) || ((((v)localObject3).type != 7) && (((v)localObject3).type != 5) && (((v)localObject3).type != 6) && (Util.isNullOrNil(((v)localObject3).nUM))))
      {
        ad(((am.a)localObject2).plj, vGf);
        break label884;
      }
      ad(((am.a)localObject2).plj, vGj);
      break label884;
      label4109:
      ((am.a)localObject2).yBS.setPadding(0, vGf, 0, vGh);
      break label915;
      label4128:
      if (i == j - 1)
      {
        ((am.a)localObject2).yBS.setPadding(0, vGh, 0, vGf);
        break label915;
      }
      ((am.a)localObject2).yBS.setPadding(0, vGh, 0, vGh);
      break label915;
      parama = parama.getResources().getString(R.l.gxc);
      break label1027;
      parama = parama.getResources().getString(R.l.gxd);
      break label1027;
      parama = parama.getResources().getString(R.l.gwU);
      break label1027;
      label4217:
      com.tencent.mm.plugin.brandservice.model.b.vBC.a(((v)localObject1).title, ((am.a)localObject2).vIW, (v)localObject1, 3);
      break label1041;
      Object localObject4;
      Object localObject5;
      if (!Util.isNullOrNil(((v)localObject1).nUM))
      {
        ((am.a)localObject2).vIK.setVisibility(0);
        localObject3 = new WeakReference(localc);
        localObject4 = new WeakReference(localObject2);
        if (Util.isNullOrNil(((v)localObject1).nVd)) {}
        for (parama = ((v)localObject1).nUM;; parama = ((v)localObject1).nVd)
        {
          localObject5 = ((am.a)localObject2).vIK;
          paramcc.getType();
          k = vGe;
          a(parama, (ImageView)localObject5, k, k, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(37141);
              if ((this.aeSt.get() != null) && (this.aeSu.get() != null)) {
                am.j.a(am.j.this, (am.c)this.aeSt.get(), (am.a)this.aeSu.get(), this.vsS, paramcc, i);
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
        ((am.a)localObject2).vIK.setVisibility(0);
        parama = R.g.chatting_item_biz_play_icon_bg;
        localObject3 = ((am.a)localObject2).vIK;
        k = vGe;
        localObject4 = r.bKe();
        localObject5 = new com.tencent.mm.modelimage.loader.a.c.a();
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).oKn = true;
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).oKB = R.e.chatting_item_biz_default_bg;
        localObject5 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).eG(k, k);
        ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).oKs = 4;
        ((com.tencent.mm.modelimage.loader.a)localObject4).a(parama, (ImageView)localObject3, ((com.tencent.mm.modelimage.loader.a.c.a)localObject5).bKx(), null, new com.tencent.mm.pluginsdk.ui.applet.m());
        break label1111;
      }
      ((am.a)localObject2).vMp.setVisibility(8);
      break label1111;
      ((am.a)localObject2).vMp.setVisibility(8);
      ((am.a)localObject2).vIW.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_2));
      break label1111;
      label4532:
      ((am.a)localObject2).vMo.setVisibility(8);
      break label1153;
      label4545:
      parama = new bz(paramcc, false, paramInt, ((v)localObject1).url, this.aeSr, parama1.jrh(), localu.iaa, localu.iab);
      a(parama, (v)localObject1, paramcc);
      ((am.a)localObject2).vJU.setOnClickListener(h(parama1));
      break label1261;
      label4605:
      ((am.a)localObject2).aeSd.setVisibility(8);
      continue;
      label4618:
      ((am.a)localObject2).vNo.setVisibility(8);
      ((am.a)localObject2).aeSd.setVisibility(8);
    }
    label4641:
    if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(2))
    {
      paramInt = 0;
      while (paramInt < localLinkedList.size())
      {
        parama = (v)localLinkedList.get(paramInt);
        if (!TextUtils.isEmpty(parama.url))
        {
          ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(parama.url, parama.type, 0, new Object[0]);
          if ((parama.nQp == 1) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbx())) {
            ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dA(parama.url, parama.type);
          }
          ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).a(parama.url, 0, null, parama.title, parama.nUO, null, 2);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(37152);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37166);
    this.vMW = Util.nowSecond();
    for (;;)
    {
      int i;
      try
      {
        i = Integer.parseInt((String)SemiXml.decode(paramcc.field_content).get(".msg.appmsg.mmreader.category.item.itemshowtype"));
        switch (paramMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(37166);
          return false;
        }
      }
      catch (Exception paramMenuItem)
      {
        AppMethodBeat.o(37166);
        return false;
      }
      paramMenuItem = bt.X(paramcc);
      Map localMap;
      if (Util.isNullOrNil(paramMenuItem))
      {
        if (i == 5)
        {
          localMap = SemiXml.decode(paramcc.field_content);
          if (localMap != null)
          {
            if (this.aeSs == 0) {}
            for (paramMenuItem = "";; paramMenuItem = this.aeSs)
            {
              paramMenuItem = ".msg.appmsg.mmreader.category.item".concat(String.valueOf(paramMenuItem));
              if (((br)com.tencent.mm.kernel.h.ax(br.class)).a((AppCompatActivity)parama.aezO.getContext(), paramMenuItem, localMap)) {
                break;
              }
              Log.i("MicroMsg.ChattingItemBizFrom", "biz enter origin logic");
              i(parama, paramcc);
              break;
            }
          }
          i(parama, paramcc);
        }
        else
        {
          i(parama, paramcc);
        }
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        k.a(parama.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new am.j.9(this, paramMenuItem, parama), new am.j.10(this, parama, paramcc, paramMenuItem));
        continue;
        paramMenuItem = a(paramcc, parama.aezO.getContext(), 0);
        if (!Util.isNullOrNil(paramMenuItem))
        {
          com.tencent.mm.ui.chatting.ap.c(paramcc, paramMenuItem, parama.aezO.getContext());
          continue;
          if (i == 5)
          {
            localMap = SemiXml.decode(paramcc.field_content);
            if (localMap != null)
            {
              if (this.aeSs == 0) {}
              for (paramMenuItem = "";; paramMenuItem = this.aeSs)
              {
                paramMenuItem = ".msg.appmsg.mmreader.category.item".concat(String.valueOf(paramMenuItem));
                if (!((br)com.tencent.mm.kernel.h.ax(br.class)).b((AppCompatActivity)parama.aezO.getContext(), paramMenuItem, localMap)) {
                  break label452;
                }
                Log.i("MicroMsg.ChattingItemBizFrom", "finder enter fav success!");
                break;
              }
            }
            Log.i("MicroMsg.ChattingItemBizFrom", "finder:values null");
          }
          label452:
          com.tencent.mm.ui.chatting.u.a(this.vMW, this.aeSs, parama.aezO.getContext(), parama.aezO, null, paramcc);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255691);
    paramContextMenuInfo = (bz)paramView.getTag();
    if (paramContextMenuInfo == null)
    {
      AppMethodBeat.o(255691);
      return false;
    }
    this.aeSs = paramContextMenuInfo.WMC;
    int i = paramContextMenuInfo.position;
    paramContextMenuInfo = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
    if (paramContextMenuInfo == null)
    {
      Log.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
      AppMethodBeat.o(255691);
      return false;
    }
    this.vMX = false;
    if ((this.aeSs >= 0) && (this.aeSs < paramContextMenuInfo.nUC.size()) && (com.tencent.mm.message.m.Hh(((v)paramContextMenuInfo.nUC.get(this.aeSs)).nUR))) {
      this.vMX = true;
    }
    if ((!this.aeiK.juH()) && (!com.tencent.mm.ui.chatting.m.bX(paramcc))) {
      params.a(i, 111, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if ((com.tencent.mm.br.c.blq("favorite")) && (!this.vMX)) {
      params.a(i, 126, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
    }
    params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255691);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 285212721;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.j
 * JD-Core Version:    0.7.0.1
 */