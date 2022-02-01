package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.i.b;
import com.tencent.mm.an.j;
import com.tencent.mm.an.l;
import com.tencent.mm.autogen.a.dx;
import com.tencent.mm.autogen.a.dx.a;
import com.tencent.mm.autogen.a.kj;
import com.tencent.mm.autogen.a.un;
import com.tencent.mm.autogen.a.un.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.box.d.a;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.gjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.v.a;
import com.tencent.mm.ui.chatting.v.b;
import com.tencent.mm.ui.chatting.v.c;
import com.tencent.mm.ui.chatting.v.d;
import com.tencent.mm.ui.chatting.v.e;
import com.tencent.mm.ui.chatting.v.h;
import com.tencent.mm.ui.chatting.v.k;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.chatting.v.p;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Future;

public abstract class c
{
  private static long Jfc = 0L;
  private static boolean aeAd = false;
  private c.c aeMg;
  private a.f aeMh;
  private d aeMi;
  private boolean aeMj = false;
  protected v.b aeMk;
  protected v.d aeMl;
  protected v.c aeMm;
  protected v.p aeMn;
  protected v.h aeMo;
  protected v.k aeMp;
  protected v.e aeMq;
  private Future aeMr = null;
  private final long aeMs = 10800000L;
  public boolean aedO;
  protected boolean wQm;
  
  public static void E(ImageView paramImageView, String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(R.g.brand_default_head);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.h(paramImageView, paramString);
  }
  
  public static void a(cc paramcc, EmojiInfo paramEmojiInfo)
  {
    dx localdx = new dx();
    localdx.hDM.hDN = paramEmojiInfo;
    paramEmojiInfo = localdx.hDM.hDN;
    if (paramcc != null) {}
    for (paramcc = paramcc.field_talker;; paramcc = null)
    {
      paramEmojiInfo.talker = paramcc;
      localdx.hDM.scene = 0;
      localdx.publish();
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, cc paramcc, k.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.bpK(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.juG()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.from = "message";
      locala.pkgName = paramString;
      locala.hYg = d(parama, paramcc);
      locala.Ykr = paramb.type;
      locala.scene = i;
      locala.Yks = paramb.mediaTagName;
      locala.hTh = paramLong;
      locala.Ykt = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((m)parama.cm(m.class)).jqx());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.bpK(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.from = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramBitmap);
    int i = (int)parama.aezO.getMMResources().getDimension(R.f.SmallestTextSize);
    localBitmapDrawable.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(localBitmapDrawable);
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setImageBitmap(paramBitmap);
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, String paramString)
  {
    if (Util.isEqual("wx485a97c844086dc9", paramString))
    {
      paramImageView.setImageResource(R.k.icons_outlined_shake_gray);
      return;
    }
    if ((Util.isEqual("wxaf060266bfa9a35c", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(R.k.icons_outlined_tv);
      ((WeImageView)paramImageView).setIconColor(parama.aezO.getContext().getResources().getColor(R.e.FG_1));
      return;
    }
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setIconColor(parama.aezO.getContext().getResources().getColor(R.e.transparent));
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cd.a.getDensity(parama.aezO.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.aezO.getMMResources(), R.g.nosdcard_watermark_icon));
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.aezO.getMMResources().getDimension(R.f.SmallestTextSize);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cd.a.getDensity(parama.aezO.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.aezO.getMMResources(), R.g.nosdcard_watermark_icon));
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    un localun;
    un.a locala;
    if (parama.juG())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label250;
        }
        if ((paramg == null) || (!u.y(parama.aezO.getContext(), paramg.field_packageName))) {
          break label243;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label256;
      }
      i = 4;
      localun = new un();
      localun.hYk.context = parama.aezO.getContext();
      localun.hYk.scene = j;
      localun.hYk.appid = paramb.appId;
      locala = localun.hYk;
      if (paramg != null) {
        break label270;
      }
    }
    label256:
    label270:
    for (parama = null;; parama = paramg.field_packageName)
    {
      locala.packageName = parama;
      localun.hYk.msgType = paramb.type;
      localun.hYk.hQQ = paramString1;
      localun.hYk.hYl = i;
      localun.hYk.mediaTagName = paramb.mediaTagName;
      localun.hYk.hTh = paramLong;
      localun.hYk.hYm = "";
      localun.hYk.hzx = paramString2;
      parama = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.aK(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (parama != null) {
        localun.hYk.hYn = parama.hYn;
      }
      localun.publish();
      return;
      j = 1;
      break;
      label243:
      i = 6;
      break label53;
      label250:
      i = 3;
      break label53;
      if (paramb.type != 5) {
        break label64;
      }
      i = 1;
      break label64;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, String paramString2)
  {
    a(parama, paramb, paramString1, paramg, paramLong, -1, paramString2);
  }
  
  private void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc)
  {
    if (this.aeMj) {}
    do
    {
      return;
      this.aeMj = true;
    } while (((parama1.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (ab.IN(parama1.getTalkerUserName())));
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.kLo)))
    {
      Log.i("MicroMsg.ChattingItem", "attachAvatarClickListener: getBizKfWorker:%s", new Object[] { paramcc.kLo });
      this.aeMk = new v.a(parama1);
    }
    for (;;)
    {
      parama.avatarIV.setOnClickListener(this.aeMk);
      parama.avatarIV.setOnLongClickListener(this.aeMl);
      return;
      this.aeMk = new v.b(parama1);
      this.aeMl = new v.d(parama1);
    }
  }
  
  protected static void a(a parama, CharSequence paramCharSequence)
  {
    if ((parama == null) || (parama.userTV == null)) {
      return;
    }
    if (paramCharSequence == null)
    {
      parama.userTV.setVisibility(8);
      return;
    }
    parama.userTV.setText(paramCharSequence);
    parama.userTV.setVisibility(0);
  }
  
  protected static void a(a parama, boolean paramBoolean)
  {
    c localc = parama.chattingItem;
    if (localc != null) {
      localc.a(parama, paramBoolean, false);
    }
    while (parama.uploadingPB == null) {
      return;
    }
    if (paramBoolean)
    {
      parama.uploadingPB.setVisibility(0);
      return;
    }
    parama.uploadingPB.setVisibility(8);
  }
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, com.tencent.mm.ui.chatting.d.a parama1, int paramInt1, int paramInt2, int paramInt3)
  {
    a(parama, parama1, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, com.tencent.mm.ui.chatting.d.a parama1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l2 = System.currentTimeMillis() - parama.startTime;
    long l1 = l2;
    if (l2 > 60000L) {
      l1 = 60000L;
    }
    com.tencent.mm.plugin.report.service.h.OAn.b(20416, new Object[] { parama1.getTalkerUserName(), Integer.valueOf(bBr(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(aDo(paramInt2)), Integer.valueOf(aDm(paramInt1)), Integer.valueOf(aDn(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(0) });
    Log.i("MicroMsg.ChattingItem", "longClick menu report kvReport logID:%s, chatName:%s, chatType:%s, timeInterval:%s, itemType:%s, btnloc:%s, locSqe:%s, logVersion:%s, msgType:%s, subMsgType:%s, busiType:%s ", new Object[] { Integer.valueOf(20416), parama1.getTalkerUserName(), Integer.valueOf(bBr(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(aDo(paramInt2)), Integer.valueOf(aDm(paramInt1)), Integer.valueOf(aDn(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(0) });
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    b localb = b.a.fCn();
    if ((!com.tencent.mm.pluginsdk.model.app.h.a(parama.aezO.getContext(), paramg)) && (localb != null))
    {
      if (!Util.isNullOrNil(paramg.jOw))
      {
        boolean bool = com.tencent.mm.pluginsdk.model.app.v.cH(parama.aezO.getContext(), paramg.jOw);
        Log.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramg.jOw, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.juG()) {}
      for (int i = 2;; i = 1)
      {
        kj localkj = new kj();
        localkj.hLZ.actionCode = 2;
        localkj.hLZ.scene = i;
        localkj.hLZ.appId = paramg.field_appId;
        localkj.hLZ.context = parama.aezO.getContext();
        localkj.publish();
        parama.aezO.getContext();
        localb.av(paramg.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  private static int aDm(int paramInt)
  {
    if (paramInt == -1) {
      return 0;
    }
    return (int)Math.ceil((paramInt + 1) / 5.0F) + 10;
  }
  
  private static int aDn(int paramInt)
  {
    if (paramInt == -1) {
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      i = paramInt + 1;
      paramInt = i;
    } while (i <= 5);
    return i % 5;
  }
  
  private static int aDo(int paramInt)
  {
    if (paramInt == -1) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
    case 102: 
    case 112: 
    case 141: 
      return 1;
    case 2: 
    case 107: 
    case 108: 
    case 110: 
    case 111: 
    case 113: 
    case 142: 
      return 2;
    case 3: 
    case 116: 
    case 143: 
      return 3;
    case 100: 
      return 4;
    case 122: 
      return 5;
    case 136: 
      return 6;
    case 134: 
      return 7;
    case 123: 
      return 8;
    case 124: 
      return 9;
    case 130: 
      return 10;
    case 104: 
      return 11;
    case 115: 
      return 12;
    case 135: 
      return 13;
    case 128: 
      return 14;
    case 119: 
      return 15;
    case 121: 
      return 16;
    case 151: 
      return 17;
    case 1: 
      return 18;
    case 120: 
      return 19;
    case 150: 
      return 20;
    case 129: 
      return 21;
    case 4: 
    case 137: 
      return 22;
    }
    return 23;
  }
  
  private static int aDp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      return -1;
    }
    return R.g.state_failed;
  }
  
  public static String b(cc paramcc, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (paramcc == null) {
      return str2;
    }
    if (paramcc.field_isSend == 1) {
      return com.tencent.mm.model.z.bAM();
    }
    if (paramBoolean1) {
      str1 = br.JJ(paramcc.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!Util.isNullOrNil(str1)) {
        break;
      }
      return paramcc.field_talker;
      if (paramBoolean2) {
        str1 = paramcc.field_bizChatUserId;
      }
    }
  }
  
  protected static String b(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    paramcc = paramcc.field_talker;
    parama = (e)parama.cm(e.class);
    if ((parama.jqV()) && (parama.jqT() != null)) {
      return parama.jqT().field_bizChatServId;
    }
    return paramcc;
  }
  
  protected static void b(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, cc paramcc)
  {
    b localb = b.a.fCn();
    if (localb != null) {
      if (!parama.juG()) {
        break label94;
      }
    }
    label94:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, paramcc);
      int j = 0;
      com.tencent.mm.pluginsdk.ui.tools.c localc = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.aK(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (localc != null) {
        j = localc.hYn;
      }
      parama.aezO.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, paramcc.field_msgSvrId, parama.getTalkerUserName(), j);
      return;
    }
  }
  
  protected static boolean b(m paramm, long paramLong)
  {
    return (paramLong > 0L) && (paramm.jqz() == paramLong);
  }
  
  private static int bBr(String paramString)
  {
    if (au.bwE(paramString)) {
      return 2;
    }
    if (ab.IS(paramString)) {
      return 3;
    }
    return 1;
  }
  
  protected static boolean bBs(String paramString)
  {
    return ((!au.bwc(paramString)) && (!au.bws(paramString)) && (!ab.IS(paramString)) && (!ab.IW(paramString))) || (au.bwE(paramString));
  }
  
  protected static void c(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((m)parama.cm(m.class)).jqy());
  }
  
  public static void c(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    if ((parama != null) && (paramcc != null)) {
      l.c(paramcc, ((e)parama.cm(e.class)).etq());
    }
  }
  
  protected static boolean c(cc paramcc, com.tencent.mm.ui.chatting.d.a parama)
  {
    long l1 = paramcc.getCreateTime();
    long l2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znC, 120000L);
    long l3 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znE, 120000L);
    if (paramcc.fxR())
    {
      k.b localb = k.b.Hf(paramcc.field_content);
      if ((localb != null) && (localb.type == 6))
      {
        Log.i("MicroMsg.ChattingItem", "File revoke time is ：%s", new Object[] { Long.valueOf(l2) });
        if (cn.bDv() - l1 > l2) {
          i = 1;
        }
      }
    }
    while (i != 0)
    {
      Log.i("MicroMsg.ChattingItem", "isRevokeExpire, msg talker: %s, svr id: %s.", new Object[] { paramcc.field_talker, Long.valueOf(paramcc.field_msgSvrId) });
      return false;
      i = 0;
      continue;
      if (paramcc.getType() == 419430449)
      {
        if (cn.bDv() - l1 > l3) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if (cn.bDv() - l1 > 120000L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((parama != null) && (parama.getTalkerUserName().equals(parama.getSelfUserName())) && (paramcc.field_status == 2)) {
      return false;
    }
    int i = com.tencent.mm.k.i.aRC().getInt("ShowRevokeMsgEntry", 1);
    Log.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    if (paramcc.getType() == 419430449)
    {
      l1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.znF, 0);
      return (i == 1) && (l1 == 1L);
    }
    return 1 == i;
  }
  
  public static String d(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (au.bwE(str)) {
      parama = br.JJ(paramcc.field_content);
    }
    return parama;
  }
  
  private v.c g(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.aeMm == null) {
      this.aeMm = new v.c(parama);
    }
    return this.aeMm;
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.printErrStackTrace("MicroMsg.ChattingItem", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  protected static boolean iA(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.h.iA(paramString);
  }
  
  protected static boolean jxj()
  {
    String str = com.tencent.mm.k.i.aRC().getValue("ShowSendOK");
    if (Util.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = Util.safeParseInt(str)) {
      return true;
    }
    return false;
  }
  
  public static int nm(Context paramContext)
  {
    float f = com.tencent.mm.cd.a.getScaleSize(paramContext);
    if (f == com.tencent.mm.cd.a.mc(paramContext)) {
      return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_small_item_width);
    }
    if (f == com.tencent.mm.cd.a.me(paramContext)) {
      return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_large_item_width);
    }
    if (f == com.tencent.mm.cd.a.mf(paramContext)) {
      return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_super_item_width);
    }
    if (f == com.tencent.mm.cd.a.mg(paramContext)) {
      return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_huge_item_width);
    }
    if ((f == com.tencent.mm.cd.a.mh(paramContext)) || (f == com.tencent.mm.cd.a.mi(paramContext)) || (f == com.tencent.mm.cd.a.mj(paramContext))) {
      return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_huger_item_width);
    }
    return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_normal_item_width);
  }
  
  public static int nn(Context paramContext)
  {
    float f = com.tencent.mm.cd.a.getScaleSize(paramContext);
    if ((f != com.tencent.mm.cd.a.mc(paramContext)) && (f != com.tencent.mm.cd.a.me(paramContext)))
    {
      if (f == com.tencent.mm.cd.a.mf(paramContext)) {
        return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_custom_super_item_width);
      }
      if (f == com.tencent.mm.cd.a.mg(paramContext)) {
        return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_custom_huge_item_width);
      }
      if ((f == com.tencent.mm.cd.a.mh(paramContext)) || (f == com.tencent.mm.cd.a.mi(paramContext)) || (f == com.tencent.mm.cd.a.mj(paramContext))) {
        return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_huger_item_width);
      }
    }
    return com.tencent.mm.cd.a.bs(paramContext, R.f.chatting_custom_item_width);
  }
  
  public static void s(Intent paramIntent, String paramString)
  {
    if (au.bxj(paramString)) {
      paramIntent.putExtra(f.s.adxf, true);
    }
  }
  
  public static void x(ImageView paramImageView, String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(R.g.default_avatar);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.g(paramImageView, paramString);
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final v.e a(com.tencent.mm.ui.chatting.d.a parama, v.n paramn)
  {
    if (this.aeMq == null) {
      this.aeMq = new c.4(this, parama, paramn);
    }
    return this.aeMq;
  }
  
  protected final a.f a(c.c paramc)
  {
    if (this.aeMh == null) {
      this.aeMh = new e(paramc);
    }
    return this.aeMh;
  }
  
  public String a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    Object localObject;
    if (fXn()) {
      localObject = parama.getSelfUserName();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.juG())
    {
      parama = br.JJ(paramcc.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label76;
      }
    }
    for (;;)
    {
      return parama;
      if (paramcc != null) {
        parama = paramcc.field_bizChatUserId;
      } else {
        label76:
        parama = str;
      }
    }
  }
  
  protected final void a(int paramInt, a parama, cc paramcc, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.d.a parama1, v.n paramn)
  {
    a(paramInt, parama, paramcc, paramString, true, paramBoolean, parama1, paramn);
  }
  
  protected final void a(int paramInt, a parama, cc paramcc, String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.ui.chatting.d.a parama1, v.n paramn)
  {
    if (paramcc.field_isSend == 1)
    {
      parama.stateIV.setTag(new bz(paramcc, paramBoolean2, paramInt, paramString, '\000'));
      parama.stateIV.setOnClickListener(a(parama1, paramn));
      paramInt = aDp(paramcc.field_status);
      if (paramInt != -1)
      {
        parama.stateIV.setImageResource(paramInt);
        parama.stateIV.setVisibility(0);
        parama.stateIV.setContentDescription(MMApplicationContext.getContext().getString(R.l.msg_fail_resend));
        a(parama, false, paramBoolean1);
      }
    }
    else
    {
      return;
    }
    parama.stateIV.setVisibility(8);
  }
  
  protected final void a(final com.tencent.mm.ui.chatting.d.a parama, final cc paramcc, final int paramInt1, boolean paramBoolean1, final String paramString1, boolean paramBoolean2, final String paramString2, int paramInt2)
  {
    final int i;
    final String str1;
    label23:
    final String str2;
    final long l;
    if (parama.juF())
    {
      i = 2;
      if (!parama.juF()) {
        break label138;
      }
      str1 = parama.getTalkerUserName();
      parama = a(parama, paramcc);
      paramcc = paramcc.field_msgSvrId;
      str2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
      l = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
      if (!paramBoolean2) {
        break label146;
      }
    }
    label138:
    label146:
    for (final int j = 65;; j = 34)
    {
      if (!paramBoolean1) {
        break label153;
      }
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(255480);
          d.a locala = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramString1);
          as.a(paramInt1, paramString2, j, 1, locala.vzR, str2, paramcc, i, str1, l, paramString1.length(), this.aeKB, locala.vzP, locala.vzS, locala.vzQ);
          AppMethodBeat.o(255480);
        }
      });
      return;
      i = 1;
      break;
      str1 = "0";
      break label23;
    }
    label153:
    as.a(paramInt1, paramString2, j, 0, "", str2, paramcc, i, str1, l, paramString1.length(), paramInt2, "", "", -1);
  }
  
  protected final void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, cc paramcc)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (NetStatusUtil.isMobile(parama.aezO.getContext()))
    {
      str = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.length() > 0) {
          break label319;
        }
        str = paramString1;
      }
    }
    for (;;)
    {
      paramString1 = new Intent();
      paramString1.putExtra("msg_id", paramLong1);
      paramString1.putExtra("rawUrl", str);
      paramString1.putExtra("version_name", paramString3);
      paramString1.putExtra("version_code", paramInt);
      paramString1.putExtra("usePlugin", paramBoolean);
      paramString1.putExtra("geta8key_username", parama.getTalkerUserName());
      paramString1.putExtra("KPublisherId", "msg_" + Long.toString(paramLong2));
      paramString1.putExtra("KAppId", paramString4);
      paramString1.putExtra("pre_username", a(parama, paramcc));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (paramcc != null) {
        paramString1.putExtra("preUsername", a(parama, paramcc));
      }
      paramString1.putExtra("preChatName", parama.getTalkerUserName());
      paramString1.putExtra("preChatTYPE", ac.aX(a(parama, paramcc), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      paramString1.putExtra("key_enable_teen_mode_check", true);
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
      return;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 0) {}
      }
      else
      {
        label319:
        str = paramString2;
      }
    }
  }
  
  public final void a(a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, cc paramcc)
  {
    long l1 = Jfc;
    long l2 = System.currentTimeMillis();
    Jfc = l2;
    if (l1 + 30000L < l2)
    {
      bh.bCz();
      aeAd = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.wQm = aeAd;
    String str;
    if (jxh())
    {
      str = a(parama1, paramcc);
      a(parama, parama1, paramcc, str);
      a(parama, parama1, str, paramcc);
    }
    for (;;)
    {
      if (parama.uploadingPB != null)
      {
        parama.uploadingPB.setTag(R.h.fzu, null);
        if (this.aeMr != null) {
          this.aeMr.cancel(true);
        }
        parama.uploadingPB.setVisibility(8);
        parama.uploadingPB.setTag(R.h.fzs, Long.valueOf(paramcc.getCreateTime()));
      }
      a(parama, paramInt, parama1, paramcc, str);
      if ((parama != null) && (parama.convertView != null)) {
        parama.convertView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(255472);
            if ((parama1.aezX) && (c.this.c(parama1) != null)) {
              c.this.c(parama1).jxl();
            }
            AppMethodBeat.o(255472);
          }
        });
      }
      if ((parama1.Uxa != null) && (parama1.Uxa.iZC()))
      {
        parama = ((e)parama1.cm(e.class)).jqS();
        if ((parama != null) && (parama.aAM()))
        {
          int i = ((m)parama1.cm(m.class)).getCount();
          l1 = ((e)parama1.cm(e.class)).etq();
          l.a(parama1.Uxa, paramcc, paramInt, i, l1);
        }
      }
      return;
      str = null;
    }
  }
  
  public abstract void a(a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString);
  
  protected void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    if ((paramString == null) || (parama.userTV == null) || (paramcc == null)) {
      return;
    }
    String str;
    if ((paramcc.field_isSend == 0) && (!Util.isNullOrNil(paramcc.kLo)))
    {
      com.tencent.mm.an.h localh = af.bHe().MH(paramcc.kLo);
      int i = 1;
      if ((localh != null) && (!Util.isNullOrNil(localh.field_openId)) && (!Util.isNullOrNil(localh.field_nickname)))
      {
        str = localh.field_nickname;
        i = 0;
        if (i == 0)
        {
          paramString = str;
          if (!j.a(localh)) {}
        }
        else
        {
          af.bHg().a(new b(parama1, paramcc.kLo));
          af.bHg().m(parama1.getTalkerUserName(), paramcc.kLo, paramcc.kLu);
          paramString = str;
        }
      }
    }
    for (;;)
    {
      a(parama, paramString);
      return;
      Log.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
      str = null;
      break;
      if ((b(parama1)) && (((com.tencent.mm.ui.chatting.component.api.g)parama1.cm(com.tencent.mm.ui.chatting.component.api.g.class)).jrp()))
      {
        if (((e)parama1.cm(e.class)).jqW())
        {
          paramcc = ((com.tencent.mm.ui.chatting.component.api.g)parama1.cm(com.tencent.mm.ui.chatting.component.api.g.class)).bAK(paramcc.field_bizChatUserId);
          paramString = p.b(parama1.aezO.getContext(), paramcc, parama.userTV.getTextSize());
        }
        else
        {
          paramcc = ((com.tencent.mm.ui.chatting.component.api.g)parama1.cm(com.tencent.mm.ui.chatting.component.api.g.class)).bAK(paramString);
          parama1 = p.b(parama1.aezO.getContext(), paramcc, parama.userTV.getTextSize());
          paramString = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).attachTextStatusSpanSync(parama.userTV, paramString, parama1, com.tencent.mm.plugin.textstatus.a.a.b.ThF, parama.userTV.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, String paramString, cc paramcc)
  {
    if (parama.avatarIV == null) {
      return;
    }
    if ((ab.IV(paramString)) && (!paramString.equals(ab.oko[0])))
    {
      parama.avatarIV.setVisibility(8);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramcc != null) && (!Util.isNullOrNil(paramcc.kLo)))
    {
      localObject2 = new com.tencent.mm.modelavatar.c();
      ((com.tencent.mm.modelavatar.c)localObject2).orE = false;
      ((com.tencent.mm.modelavatar.c)localObject2).orF = 0.1F;
      if (parama1.juG()) {
        localObject1 = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject1 = new bz(paramString, (String)localObject1);
      ((bz)localObject1).aeXQ = paramcc.kLo;
      ((bz)localObject1).olT = paramcc.kLu;
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.avatarIV, paramcc.kLo, R.g.biz_kf_default_avatar, (com.tencent.mm.modelavatar.c)localObject2);
      if (com.tencent.mm.an.h.ac(paramcc)) {
        af.bHg().bGS();
      }
      label152:
      parama.avatarIV.setVisibility(0);
      parama.avatarIV.setTag(localObject1);
      parama.avatarIV.setTagUsername(paramString);
      parama.avatarIV.setTagTalker(parama1.getTalkerUserName());
      if (au.bwG(parama1.getTalkerUserName()))
      {
        parama.avatarIV.setTagScene(2);
        a(parama, parama1, paramcc);
        parama.avatarIV.setOnDoubleClickListener(g(parama1));
        if (t.isEnable()) {
          t.fj(parama.avatarIV);
        }
        parama.avatarIV.setContentDescription(aa.getDisplayName(paramString) + parama1.aezO.getContext().getString(R.l.avatar_desc));
        if (parama.sendFromWatchVS == null) {
          break;
        }
        if ((paramcc == null) || (paramcc.jUr == null) || (!paramcc.jUr.contains("watch_msg_source_type"))) {
          break label628;
        }
        parama1 = (String)XmlParser.parseXml(paramcc.jUr, "msgsource", null).get(".msgsource.watch_msg_source_type");
      }
      try
      {
        i = Integer.valueOf(parama1).intValue();
        if ((i > 0) && (i <= 4))
        {
          parama.sendFromWatchVS.setVisibility(0);
          return;
          localObject1 = null;
          continue;
          if ((paramcc != null) && (((e)parama1.cm(e.class)).jqV()))
          {
            localObject1 = new bz(paramcc.field_bizChatUserId, null);
            localObject2 = (e)parama1.cm(e.class);
            r.bKe().a(((e)localObject2).Nd(paramcc.field_bizChatUserId), parama.avatarIV, ((m)parama1.cm(m.class)).jqA());
            break label152;
          }
          if ((paramcc != null) && (paramcc.field_isSend == 0) && (parama1.cm(com.tencent.mm.ui.chatting.component.api.a.class) != null) && (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.component.api.a)parama1.cm(com.tencent.mm.ui.chatting.component.api.a.class)).juD())))
          {
            localObject1 = new bz(paramString, null);
            r.bKe().a(((com.tencent.mm.ui.chatting.component.api.a)parama1.cm(com.tencent.mm.ui.chatting.component.api.a.class)).juD(), parama.avatarIV, ((m)parama1.cm(m.class)).jqA());
            break label152;
          }
          if (parama1.juG()) {}
          for (localObject1 = parama1.getTalkerUserName();; localObject1 = null)
          {
            localObject1 = new bz(paramString, (String)localObject1);
            x(parama.avatarIV, paramString);
            break;
          }
          parama.avatarIV.setTagScene(1);
        }
      }
      catch (Exception parama1)
      {
        for (;;)
        {
          int i = 0;
        }
        parama.sendFromWatchVS.setVisibility(8);
        return;
      }
    }
    label628:
    parama.sendFromWatchVS.setVisibility(8);
  }
  
  protected final void a(final a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (parama.uploadingPB == null) {
      return;
    }
    Log.d("MicroMsg.ChattingItem", "showUploadingPB %s %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        parama.uploadingPB.setVisibility(0);
        parama.uploadingPB.setTag(R.h.fzu, Boolean.TRUE);
        return;
      }
      Object localObject = parama.uploadingPB.getTag(R.h.fzs);
      if ((localObject != null) && (((Long)localObject).longValue() < cn.bDv() - 1000L))
      {
        parama.uploadingPB.setVisibility(0);
        parama.uploadingPB.setTag(R.h.fzu, Boolean.TRUE);
        Log.d("MicroMsg.ChattingItem", "showUploadingPB not init %s", new Object[] { parama });
        return;
      }
      localObject = parama.uploadingPB.getTag(R.h.fzu);
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        parama.uploadingPB.setVisibility(0);
        Log.d("MicroMsg.ChattingItem", "showUploadingPB had delay visible %s", new Object[] { parama });
        return;
      }
      this.aeMr = com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(255416);
          parama.uploadingPB.setVisibility(0);
          parama.uploadingPB.setTag(R.h.fzu, Boolean.TRUE);
          Log.d("MicroMsg.ChattingItem", "showUploadingPB delay visible %s", new Object[] { parama });
          AppMethodBeat.o(255416);
        }
      }, 1000L);
      return;
    }
    parama.uploadingPB.setTag(R.h.fzu, Boolean.FALSE);
    if (this.aeMr != null) {
      this.aeMr.cancel(true);
    }
    parama.uploadingPB.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.widget.b.a parama, final com.tencent.mm.ui.chatting.d.a parama1, final String paramString)
  {
    parama.agjF = new com.tencent.mm.ui.widget.b.a.a()
    {
      public final View a(Context paramAnonymousContext, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(255474);
        int i = paramAnonymousMenuItem.getItemId();
        if ((i == 137) || (i == 4))
        {
          paramAnonymousMenuItem = View.inflate(paramAnonymousContext, R.i.gmV, null);
          ((TextView)paramAnonymousMenuItem.findViewById(R.h.title)).setText(parama1.aezO.getMMResources().getString(R.l.gyE));
          paramAnonymousContext = (TextView)paramAnonymousMenuItem.findViewById(R.h.hotword_tv);
          Object localObject = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(paramString);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramAnonymousContext.setVisibility(8);
            localObject = (MMAnimateView)paramAnonymousMenuItem.findViewById(R.h.icon);
            if (!aw.isDarkMode()) {
              break label179;
            }
          }
          label179:
          for (paramAnonymousContext = "assets:///fireWork_dark.gif";; paramAnonymousContext = "assets:///fireWork_light.gif")
          {
            ((MMAnimateView)localObject).g(y.bi(paramAnonymousContext, 0, -1), "");
            paramAnonymousContext = (com.tencent.mm.plugin.gif.d)((MMAnimateView)localObject).getDrawable();
            if (paramAnonymousContext != null) {
              paramAnonymousContext.Jhb = 2;
            }
            AppMethodBeat.o(255474);
            return paramAnonymousMenuItem;
            paramAnonymousContext.setVisibility(0);
            paramAnonymousContext.setText((CharSequence)localObject);
            break;
          }
        }
        AppMethodBeat.o(255474);
        return null;
      }
    };
  }
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc);
  
  protected boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bz parambz)
  {
    return false;
  }
  
  public abstract boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc);
  
  public final boolean a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, cc paramcc)
  {
    if (Util.isNullOrNil(paramb.nTu)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.aedm, paramcc, paramb.nTB, paramb.nTA);
    String str = paramcc.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.nTu);
    localIntent.putExtra("KThumUrl", paramb.nTz);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.nTA);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.nTB);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.juG())
    {
      i = com.tencent.mm.ui.chatting.a.b.aedv.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", a(parama, paramcc));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", paramcc.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.iah);
      if (parama.juG()) {
        localIntent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.v.getMembersCountByChatRoomName(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + paramcc.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.nTv);
      localIntent.putExtra("StremWebUrl", paramb.nTy);
      localIntent.putExtra("StreamWording", paramb.nTx);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yHP, 0) <= 0) {
        break label370;
      }
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      Log.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.aedu.value;
      break;
      label370:
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.aeMo == null) {
      this.aeMo = new v.h(parama);
    }
    paramView.setOnClickListener(this.aeMo);
  }
  
  protected final void b(a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean, true);
  }
  
  protected boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (fXn()) {
      return false;
    }
    return (parama.juG()) || (((e)parama.cm(e.class)).jqV());
  }
  
  protected final c.c c(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.aeMg == null) {
      this.aeMg = new c.c(this, parama);
    }
    return this.aeMg;
  }
  
  public abstract boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc);
  
  public abstract boolean cM(int paramInt, boolean paramBoolean);
  
  protected final d d(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.aeMi == null)
    {
      if (!(parama.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.aezO;
    }
    label47:
    for (this.aeMi = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.iNh(), this);; this.aeMi = new d(parama, this)) {
      return this.aeMi;
    }
  }
  
  protected final v.b e(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.aeMk == null) {
      this.aeMk = new v.b(parama);
    }
    return this.aeMk;
  }
  
  protected final v.d f(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.aeMl == null) {
      this.aeMl = new v.d(parama);
    }
    return this.aeMl;
  }
  
  public abstract boolean fXn();
  
  protected final v.p h(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.aeMn == null) {
      this.aeMn = new v.p(parama);
    }
    return this.aeMn;
  }
  
  protected final v.k i(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.aeMp == null) {
      this.aeMp = new v.k(parama);
    }
    return this.aeMp;
  }
  
  public boolean jxg()
  {
    return false;
  }
  
  protected boolean jxh()
  {
    return true;
  }
  
  boolean jxi()
  {
    return true;
  }
  
  protected boolean jxk()
  {
    return true;
  }
  
  public static class a
  {
    public static final int STATUS_EDIT = 1;
    public static final int STATUS_NORMAL = 0;
    public ChattingAvatarImageView avatarIV;
    public c chattingItem;
    public CheckBox checkBox;
    public View clickArea;
    public ImageView colorMaskView;
    public View convertView;
    public View historyMsgTip;
    public View maskView;
    public View noMoreMsgTip;
    public String playingMsgId;
    public ViewStub sendFromWatchVS;
    public ImageView stateIV;
    public TextView timeTV;
    public ProgressBar uploadingPB;
    public TextView userTV;
    
    public a() {}
    
    public a(c paramc, String paramString)
    {
      this.chattingItem = paramc;
      this.playingMsgId = paramString;
    }
    
    public void create(View paramView)
    {
      AppMethodBeat.i(36732);
      this.convertView = paramView;
      this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
      this.avatarIV = ((ChattingAvatarImageView)paramView.findViewById(R.h.fxl));
      this.historyMsgTip = paramView.findViewById(R.h.fyu);
      this.noMoreMsgTip = paramView.findViewById(R.h.fzC);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.colorMaskView = ((ImageView)paramView.findViewById(R.h.fxu));
      this.sendFromWatchVS = null;
      AppMethodBeat.o(36732);
    }
    
    public View getMainContainerView()
    {
      return this.clickArea;
    }
    
    public void resetChatBubbleWidth(View paramView, int paramInt)
    {
      AppMethodBeat.i(36734);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(paramInt / com.tencent.mm.ce.c.iRs()));
        paramView.setLayoutParams(localLayoutParams);
        paramView.requestLayout();
      }
      AppMethodBeat.o(36734);
    }
    
    public void setChattingItem(c paramc)
    {
      this.chattingItem = paramc;
    }
    
    public void showColorMaskView(boolean paramBoolean)
    {
      AppMethodBeat.i(255112);
      if (this.colorMaskView != null)
      {
        if (paramBoolean)
        {
          this.colorMaskView.setVisibility(0);
          AppMethodBeat.o(255112);
          return;
        }
        this.colorMaskView.setVisibility(8);
      }
      AppMethodBeat.o(255112);
    }
    
    public void showEditView(boolean paramBoolean)
    {
      AppMethodBeat.i(36733);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        if ((this.checkBox != null) && (this.checkBox.getVisibility() != i)) {
          this.checkBox.setVisibility(i);
        }
        if ((this.maskView != null) && (this.maskView.getVisibility() != i)) {
          this.maskView.setVisibility(i);
        }
        AppMethodBeat.o(36733);
        return;
      }
    }
  }
  
  static final class b
    implements i.b
  {
    private String WEH;
    com.tencent.mm.ui.chatting.d.a hlc;
    
    protected b(com.tencent.mm.ui.chatting.d.a parama, String paramString)
    {
      this.WEH = paramString;
      this.hlc = parama;
    }
    
    public final String bGT()
    {
      return this.WEH;
    }
    
    public final void e(LinkedList<gjj> paramLinkedList)
    {
      int k = 0;
      AppMethodBeat.i(36736);
      af.bHg().b(this);
      Log.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
      int i;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        Log.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.WEH });
        if (this.hlc != null)
        {
          i = k;
          if (paramLinkedList != null)
          {
            if (paramLinkedList.size() != 0) {
              break label106;
            }
            i = k;
          }
          if (i != 0) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36735);
                c.b.this.hlc.dcZ();
                AppMethodBeat.o(36735);
              }
            });
          }
        }
      }
      AppMethodBeat.o(36736);
      return;
      label106:
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= paramLinkedList.size()) {
          break;
        }
        gjj localgjj = (gjj)paramLinkedList.get(j);
        if ((localgjj != null) && (!Util.isNullOrNil(localgjj.acfC)) && (localgjj.acfC.equals(this.WEH)))
        {
          Log.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
          if (!Util.isNullOrNil(localgjj.Nickname))
          {
            Log.i("MicroMsg.ChattingItem", "needCallback: true");
            i = 1;
            break;
          }
        }
        j += 1;
      }
    }
  }
  
  public static class d
    extends v.e
  {
    private c chattingItem;
    
    public d(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.chattingItem = paramc;
    }
    
    public void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(36747);
      this.chattingItem.c(paramView, parama, paramcc);
      AppMethodBeat.o(36747);
    }
  }
  
  static final class e
    extends a.f
  {
    c.c aeMg;
    
    e(c.c paramc)
    {
      this.aeMg = paramc;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(36749);
      this.aeMg.jxl();
      AppMethodBeat.o(36749);
    }
    
    public final void ft(View paramView)
    {
      AppMethodBeat.i(36750);
      this.aeMg.onLongClick(paramView);
      AppMethodBeat.o(36750);
    }
    
    public final void jxm()
    {
      AppMethodBeat.i(179940);
      c.c localc = this.aeMg;
      if (localc.aeiK != null) {
        localc.aeiK.Mh(true);
      }
      AppMethodBeat.o(179940);
    }
    
    public final void jxn()
    {
      AppMethodBeat.i(179941);
      c.c localc = this.aeMg;
      if (localc.aeiK != null) {
        localc.aeiK.Mh(false);
      }
      AppMethodBeat.o(179941);
    }
    
    public final void jxo()
    {
      AppMethodBeat.i(179942);
      c.c localc = this.aeMg;
      if (localc.aeiK != null) {
        localc.aeiK.aE(false);
      }
      AppMethodBeat.o(179942);
    }
    
    public final void ls(View paramView)
    {
      AppMethodBeat.i(36748);
      this.aeMg.openContextMenu(paramView);
      AppMethodBeat.o(36748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */