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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.i.b;
import com.tencent.mm.ao.j;
import com.tencent.mm.f.a.dn;
import com.tencent.mm.f.a.dn.a;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.f.a.sy.a;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.f.c.et;
import com.tencent.mm.f.c.y;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.box.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.protocal.protobuf.fmr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.a;
import com.tencent.mm.ui.chatting.t.b;
import com.tencent.mm.ui.chatting.t.c;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.h;
import com.tencent.mm.ui.chatting.t.k;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.chatting.t.p;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Future;

public abstract class c
{
  private static long DlT = 0L;
  private static boolean WQJ = false;
  public boolean Wwx;
  private c Xci;
  private a.f Xcj;
  private d Xck;
  private boolean Xcl = false;
  protected t.b Xcm;
  protected t.d Xcn;
  protected t.c Xco;
  protected t.p Xcp;
  protected t.h Xcq;
  protected t.k Xcr;
  protected t.e Xcs;
  private Future Xct = null;
  private final long Xcu = 10800000L;
  protected boolean tMW;
  
  public static void F(ImageView paramImageView, String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(R.g.default_avatar);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.c(paramImageView, paramString);
  }
  
  public static void G(ImageView paramImageView, String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(R.g.brand_default_head);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString);
  }
  
  public static void a(ca paramca, EmojiInfo paramEmojiInfo)
  {
    dn localdn = new dn();
    localdn.fzd.fze = paramEmojiInfo;
    paramEmojiInfo = localdn.fzd.fze;
    if (paramca != null) {}
    for (paramca = paramca.field_talker;; paramca = null)
    {
      paramEmojiInfo.talker = paramca;
      localdn.fzd.scene = 0;
      EventCenter.instance.publish(localdn);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, ca paramca, k.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.bpU(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.hRi()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.from = "message";
      locala.pkgName = paramString;
      locala.fSj = d(parama, paramca);
      locala.Roa = paramb.type;
      locala.scene = i;
      locala.Rob = paramb.mediaTagName;
      locala.fNu = paramLong;
      locala.Roc = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((k)parama.bC(k.class)).hNQ());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.bpU(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.from = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.WQv.getMMResources().getDimension(R.f.SmallestTextSize);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, ImageView paramImageView, String paramString)
  {
    if ((Util.isEqual("wx485a97c844086dc9", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(R.k.icons_filled_music);
      ((WeImageView)paramImageView).setIconColor(parama.WQv.getContext().getResources().getColor(R.e.FG_1));
      return;
    }
    if ((Util.isEqual("wxaf060266bfa9a35c", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(R.k.icons_outlined_tv);
      ((WeImageView)paramImageView).setIconColor(parama.WQv.getContext().getResources().getColor(R.e.FG_1));
      return;
    }
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setIconColor(parama.WQv.getContext().getResources().getColor(R.e.transparent));
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.ci.a.getDensity(parama.WQv.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.WQv.getMMResources(), R.g.nosdcard_watermark_icon));
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.WQv.getMMResources().getDimension(R.f.SmallestTextSize);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.ci.a.getDensity(parama.WQv.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.WQv.getMMResources(), R.g.nosdcard_watermark_icon));
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, String paramString1, g paramg, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    sy localsy;
    sy.a locala;
    if (parama.hRi())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label253;
        }
        if ((paramg == null) || (!com.tencent.mm.pluginsdk.model.app.q.u(parama.WQv.getContext(), paramg.field_packageName))) {
          break label246;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label259;
      }
      i = 4;
      localsy = new sy();
      localsy.fSn.context = parama.WQv.getContext();
      localsy.fSn.scene = j;
      localsy.fSn.appid = paramb.appId;
      locala = localsy.fSn;
      if (paramg != null) {
        break label273;
      }
    }
    label259:
    label273:
    for (parama = null;; parama = paramg.field_packageName)
    {
      locala.packageName = parama;
      localsy.fSn.msgType = paramb.type;
      localsy.fSn.fLi = paramString1;
      localsy.fSn.fSo = i;
      localsy.fSn.mediaTagName = paramb.mediaTagName;
      localsy.fSn.fNu = paramLong;
      localsy.fSn.fSp = "";
      localsy.fSn.fvd = paramString2;
      parama = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ar(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (parama != null) {
        localsy.fSn.fSq = parama.fSq;
      }
      EventCenter.instance.publish(localsy);
      return;
      j = 1;
      break;
      label246:
      i = 6;
      break label53;
      label253:
      i = 3;
      break label53;
      if (paramb.type != 5) {
        break label64;
      }
      i = 1;
      break label64;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, String paramString1, g paramg, long paramLong, String paramString2)
  {
    a(parama, paramb, paramString1, paramg, paramLong, -1, paramString2);
  }
  
  private void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    if (this.Xcl) {}
    do
    {
      return;
      this.Xcl = true;
    } while (((parama1.WQv instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (ab.Qg(parama1.getTalkerUserName())));
    if ((paramca != null) && (!Util.isNullOrNil(paramca.ilp))) {
      this.Xcm = new t.a(parama1);
    }
    for (;;)
    {
      parama.avatarIV.setOnClickListener(this.Xcm);
      parama.avatarIV.setOnLongClickListener(this.Xcn);
      return;
      this.Xcm = new t.b(parama1);
      this.Xcn = new t.d(parama1);
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
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, com.tencent.mm.ui.chatting.e.a parama1, int paramInt1, int paramInt2, int paramInt3)
  {
    a(parama, parama1, paramInt1, paramInt2, paramInt3, 0);
  }
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, com.tencent.mm.ui.chatting.e.a parama1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l2 = System.currentTimeMillis() - parama.startTime;
    long l1 = l2;
    if (l2 > 60000L) {
      l1 = 60000L;
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(20416, new Object[] { parama1.getTalkerUserName(), Integer.valueOf(bzD(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(awG(paramInt2)), Integer.valueOf(awE(paramInt1)), Integer.valueOf(awF(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(0) });
    Log.i("MicroMsg.ChattingItem", "longClick menu report kvReport logID:%s, chatName:%s, chatType:%s, timeInterval:%s, itemType:%s, btnloc:%s, locSqe:%s, logVersion:%s, msgType:%s, subMsgType:%s, busiType:%s ", new Object[] { Integer.valueOf(20416), parama1.getTalkerUserName(), Integer.valueOf(bzD(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(awG(paramInt2)), Integer.valueOf(awE(paramInt1)), Integer.valueOf(awF(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(0) });
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.e.a parama, g paramg)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.evu();
    if ((!com.tencent.mm.pluginsdk.model.app.h.a(parama.WQv.getContext(), paramg)) && (localb != null))
    {
      if (!Util.isNullOrNil(paramg.hrJ))
      {
        boolean bool = com.tencent.mm.pluginsdk.model.app.r.cw(parama.WQv.getContext(), paramg.hrJ);
        Log.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramg.hrJ, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.hRi()) {}
      for (int i = 2;; i = 1)
      {
        ji localji = new ji();
        localji.fGD.actionCode = 2;
        localji.fGD.scene = i;
        localji.fGD.appId = paramg.field_appId;
        localji.fGD.context = parama.WQv.getContext();
        EventCenter.instance.publish(localji);
        parama.WQv.getContext();
        localb.ao(paramg.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  private static int awE(int paramInt)
  {
    if (paramInt == -1) {
      return 0;
    }
    return (int)Math.ceil((paramInt + 1) / 5.0F) + 10;
  }
  
  private static int awF(int paramInt)
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
  
  private static int awG(int paramInt)
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
  
  private static int awH(int paramInt)
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
  
  public static String b(ca paramca, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (paramca == null) {
      return str2;
    }
    if (paramca.field_isSend == 1) {
      return z.bcZ();
    }
    if (paramBoolean1) {
      str1 = bq.RL(paramca.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!Util.isNullOrNil(str1)) {
        break;
      }
      return paramca.field_talker;
      if (paramBoolean2) {
        str1 = paramca.field_bizChatUserId;
      }
    }
  }
  
  protected static String b(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    paramca = paramca.field_talker;
    parama = (com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class);
    if ((parama.hOe()) && (parama.hOc() != null)) {
      return parama.hOc().field_bizChatServId;
    }
    return paramca;
  }
  
  protected static void b(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, ca paramca)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.evu();
    if (localb != null) {
      if (!parama.hRi()) {
        break label94;
      }
    }
    label94:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, paramca);
      int j = 0;
      com.tencent.mm.pluginsdk.ui.tools.c localc = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ar(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (localc != null) {
        j = localc.fSq;
      }
      parama.WQv.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, paramca.field_msgSvrId, parama.getTalkerUserName(), j);
      return;
    }
  }
  
  protected static boolean b(ca paramca, com.tencent.mm.ui.chatting.e.a parama)
  {
    long l1 = paramca.field_createTime;
    long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vUY, 120000L);
    long l3 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVa, 120000L);
    if (paramca.erk())
    {
      k.b localb = k.b.OQ(paramca.field_content);
      if ((localb != null) && (localb.type == 6))
      {
        Log.i("MicroMsg.ChattingItem", "File revoke time is ：%s", new Object[] { Long.valueOf(l2) });
        if (cm.bfD() - l1 > l2) {
          i = 1;
        }
      }
    }
    while (i != 0)
    {
      Log.i("MicroMsg.ChattingItem", "isRevokeExpire, msg talker: %s, svr id: %s.", new Object[] { paramca.field_talker, Long.valueOf(paramca.field_msgSvrId) });
      return false;
      i = 0;
      continue;
      if (paramca.getType() == 419430449)
      {
        if (cm.bfD() - l1 > l3) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else if (cm.bfD() - l1 > 120000L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((parama != null) && (parama.getTalkerUserName().equals(parama.getSelfUserName())) && (paramca.field_status == 2)) {
      return false;
    }
    int i = com.tencent.mm.n.h.axc().getInt("ShowRevokeMsgEntry", 1);
    Log.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    if (paramca.getType() == 419430449)
    {
      l1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vVb, 0);
      return (i == 1) && (l1 == 1L);
    }
    return 1 == i;
  }
  
  protected static boolean b(k paramk, long paramLong)
  {
    return (paramLong > 0L) && (paramk.hNS() == paramLong);
  }
  
  private static int bzD(String paramString)
  {
    if (ab.Lj(paramString)) {
      return 2;
    }
    if (ab.Qm(paramString)) {
      return 3;
    }
    return 1;
  }
  
  protected static boolean bzE(String paramString)
  {
    return ((!ab.Qy(paramString)) && (!ab.QO(paramString)) && (!ab.Qm(paramString)) && (!ab.QY(paramString))) || (ab.Lj(paramString));
  }
  
  protected static void c(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((k)parama.bC(k.class)).hNR());
  }
  
  public static void c(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    if ((parama != null) && (paramca != null)) {
      com.tencent.mm.ao.l.c(paramca, ((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).amU());
    }
  }
  
  public static String d(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (ab.Lj(str)) {
      parama = bq.RL(paramca.field_content);
    }
    return parama;
  }
  
  private t.c g(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Xco == null) {
      this.Xco = new t.c(parama);
    }
    return this.Xco;
  }
  
  protected static boolean gZ(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.h.gZ(paramString);
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.o(paramString, true, false);
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
  
  protected static boolean hTG()
  {
    String str = com.tencent.mm.n.h.axc().getValue("ShowSendOK");
    if (Util.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = Util.safeParseInt(str)) {
      return true;
    }
    return false;
  }
  
  public static int li(Context paramContext)
  {
    float f = com.tencent.mm.ci.a.ez(paramContext);
    if (f == com.tencent.mm.ci.a.ka(paramContext)) {
      return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_small_item_width);
    }
    if (f == com.tencent.mm.ci.a.kc(paramContext)) {
      return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_large_item_width);
    }
    if (f == com.tencent.mm.ci.a.kd(paramContext)) {
      return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_super_item_width);
    }
    if (f == com.tencent.mm.ci.a.ke(paramContext)) {
      return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_huge_item_width);
    }
    if ((f == com.tencent.mm.ci.a.kf(paramContext)) || (f == com.tencent.mm.ci.a.kg(paramContext)) || (f == com.tencent.mm.ci.a.kh(paramContext))) {
      return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_huger_item_width);
    }
    return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_normal_item_width);
  }
  
  public static int lj(Context paramContext)
  {
    float f = com.tencent.mm.ci.a.ez(paramContext);
    if ((f != com.tencent.mm.ci.a.ka(paramContext)) && (f != com.tencent.mm.ci.a.kc(paramContext)))
    {
      if (f == com.tencent.mm.ci.a.kd(paramContext)) {
        return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_custom_super_item_width);
      }
      if (f == com.tencent.mm.ci.a.ke(paramContext)) {
        return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_custom_huge_item_width);
      }
      if ((f == com.tencent.mm.ci.a.kf(paramContext)) || (f == com.tencent.mm.ci.a.kg(paramContext)) || (f == com.tencent.mm.ci.a.kh(paramContext))) {
        return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_huger_item_width);
      }
    }
    return com.tencent.mm.ci.a.aZ(paramContext, R.f.chatting_custom_item_width);
  }
  
  public static void q(Intent paramIntent, String paramString)
  {
    if ((ab.Qc(paramString)) || (ab.Qd(paramString)) || (ab.Qe(paramString))) {
      paramIntent.putExtra(f.r.VSX, true);
    }
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final t.e a(com.tencent.mm.ui.chatting.e.a parama, final t.n paramn)
  {
    if (this.Xcs == null) {
      this.Xcs = new t.e(parama)
      {
        public final void a(View paramAnonymousView, com.tencent.mm.ui.chatting.e.a paramAnonymousa, ca paramAnonymousca)
        {
          AppMethodBeat.i(291358);
          paramn.b(paramAnonymousView, paramAnonymousa, paramAnonymousca);
          AppMethodBeat.o(291358);
        }
      };
    }
    return this.Xcs;
  }
  
  protected final a.f a(c paramc)
  {
    if (this.Xcj == null) {
      this.Xcj = new e(paramc);
    }
    return this.Xcj;
  }
  
  public String a(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    Object localObject;
    if (hTD()) {
      localObject = parama.getSelfUserName();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.hRi())
    {
      parama = bq.RL(paramca.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label76;
      }
    }
    for (;;)
    {
      return parama;
      if (paramca != null) {
        parama = paramca.field_bizChatUserId;
      } else {
        label76:
        parama = str;
      }
    }
  }
  
  protected final void a(int paramInt, a parama, ca paramca, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.e.a parama1, t.n paramn)
  {
    a(paramInt, parama, paramca, paramString, true, paramBoolean, parama1, paramn);
  }
  
  protected final void a(int paramInt, a parama, ca paramca, String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.ui.chatting.e.a parama1, t.n paramn)
  {
    if (paramca.field_isSend == 1)
    {
      parama.stateIV.setTag(new by(paramca, paramBoolean2, paramInt, paramString, '\000'));
      parama.stateIV.setOnClickListener(a(parama1, paramn));
      paramInt = awH(paramca.field_status);
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
  
  protected final void a(final com.tencent.mm.ui.chatting.e.a parama, final ca paramca, final int paramInt1, boolean paramBoolean1, final String paramString1, boolean paramBoolean2, final String paramString2, int paramInt2)
  {
    final int i;
    final String str1;
    label23:
    final String str2;
    final long l;
    if (parama.hRh())
    {
      i = 2;
      if (!parama.hRh()) {
        break label138;
      }
      str1 = parama.getTalkerUserName();
      parama = a(parama, paramca);
      paramca = paramca.field_msgSvrId;
      str2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
      l = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
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
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278391);
          d.a locala = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramString1);
          com.tencent.mm.plugin.websearch.api.ar.a(paramInt1, paramString2, j, 1, locala.snT, str2, paramca, i, str1, l, paramString1.length(), this.XaW, locala.snR, locala.snU, locala.snS);
          AppMethodBeat.o(278391);
        }
      });
      return;
      i = 1;
      break;
      str1 = "0";
      break label23;
    }
    label153:
    com.tencent.mm.plugin.websearch.api.ar.a(paramInt1, paramString2, j, 0, "", str2, paramca, i, str1, l, paramString1.length(), paramInt2, "", "", -1);
  }
  
  protected final void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, ca paramca)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (NetStatusUtil.isMobile(parama.WQv.getContext()))
    {
      str = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.length() > 0) {
          break label310;
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
      paramString1.putExtra("pre_username", a(parama, paramca));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (paramca != null) {
        paramString1.putExtra("preUsername", a(parama, paramca));
      }
      paramString1.putExtra("preChatName", parama.getTalkerUserName());
      paramString1.putExtra("preChatTYPE", ac.aN(a(parama, paramca), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
      return;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 0) {}
      }
      else
      {
        label310:
        str = paramString2;
      }
    }
  }
  
  public final void a(a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    long l1 = DlT;
    long l2 = System.currentTimeMillis();
    DlT = l2;
    if (l1 + 30000L < l2)
    {
      bh.beI();
      WQJ = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.tMW = WQJ;
    String str;
    if (hTE())
    {
      str = a(parama1, paramca);
      a(parama, parama1, paramca, str);
      a(parama, parama1, str, paramca);
    }
    for (;;)
    {
      if (parama.uploadingPB != null)
      {
        parama.uploadingPB.setTag(R.h.dyJ, null);
        if (this.Xct != null) {
          this.Xct.cancel(true);
        }
        parama.uploadingPB.setVisibility(8);
        parama.uploadingPB.setTag(R.h.dyI, Long.valueOf(paramca.field_createTime));
      }
      a(parama, paramInt, parama1, paramca, str);
      if ((parama != null) && (parama.convertView != null)) {
        parama.convertView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(286669);
            if ((parama1.WQE) && (c.this.c(parama1) != null)) {
              c.this.c(parama1).hTI();
            }
            AppMethodBeat.o(286669);
          }
        });
      }
      if ((parama1.NKq != null) && (parama1.NKq.hxX()))
      {
        parama = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOb();
        if ((parama != null) && (parama.YU()))
        {
          int i = ((k)parama1.bC(k.class)).getCount();
          l1 = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bC(com.tencent.mm.ui.chatting.d.b.d.class)).amU();
          com.tencent.mm.ao.l.a(parama1.NKq, paramca, paramInt, i, l1);
        }
      }
      return;
      str = null;
    }
  }
  
  public abstract void a(a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString);
  
  protected void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    if ((paramString == null) || (parama.userTV == null) || (paramca == null)) {
      return;
    }
    String str;
    if ((paramca.field_isSend == 0) && (!Util.isNullOrNil(paramca.ilp)))
    {
      com.tencent.mm.ao.h localh = af.bju().UI(paramca.ilp);
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
          af.bjw().a(new b(parama1, paramca.ilp));
          af.bjw().j(parama1.getTalkerUserName(), paramca.ilp, paramca.ilv);
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
      if ((b(parama1)) && (((com.tencent.mm.ui.chatting.d.b.f)parama1.bC(com.tencent.mm.ui.chatting.d.b.f.class)).hOx()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.d)parama1.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf())
        {
          paramca = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bC(com.tencent.mm.ui.chatting.d.b.f.class)).bzg(paramca.field_bizChatUserId);
          paramString = com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), paramca, parama.userTV.getTextSize());
        }
        else
        {
          paramca = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bC(com.tencent.mm.ui.chatting.d.b.f.class)).bzg(paramString);
          parama1 = com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), paramca, parama.userTV.getTextSize());
          paramString = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).attachTextStatusSpanSync(parama.userTV, paramString, parama1, com.tencent.mm.plugin.textstatus.a.a.b.MzB, parama.userTV.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, String paramString, ca paramca)
  {
    if (parama.avatarIV == null) {
      return;
    }
    if ((ab.QX(paramString)) && (!paramString.equals(ab.lsO[0])))
    {
      parama.avatarIV.setVisibility(8);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramca != null) && (!Util.isNullOrNil(paramca.ilp)))
    {
      localObject2 = new com.tencent.mm.am.c();
      ((com.tencent.mm.am.c)localObject2).lAd = false;
      ((com.tencent.mm.am.c)localObject2).lAe = com.tencent.mm.pluginsdk.ui.a.syM;
      if (parama1.hRi()) {
        localObject1 = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject1 = new by(paramString, (String)localObject1);
      ((by)localObject1).XmL = paramca.ilp;
      ((by)localObject1).luu = paramca.ilv;
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.avatarIV, paramca.ilp, R.g.biz_kf_default_avatar, (com.tencent.mm.am.c)localObject2);
      if (com.tencent.mm.ao.h.X(paramca)) {
        af.bjw().bji();
      }
      label152:
      parama.avatarIV.setVisibility(0);
      parama.avatarIV.setTag(localObject1);
      parama.avatarIV.setTagUsername(paramString);
      parama.avatarIV.setTagTalker(parama1.getTalkerUserName());
      if (ab.PP(parama1.getTalkerUserName()))
      {
        parama.avatarIV.setTagScene(2);
        a(parama, parama1, paramca);
        parama.avatarIV.setOnDoubleClickListener(g(parama1));
        if (com.tencent.mm.ui.chatting.r.isEnable()) {
          com.tencent.mm.ui.chatting.r.eo(parama.avatarIV);
        }
        parama.avatarIV.setContentDescription(aa.PJ(paramString) + parama1.WQv.getContext().getString(R.l.avatar_desc));
        if (parama.sendFromWatchVS == null) {
          break;
        }
        if ((paramca == null) || (paramca.hxy == null) || (!paramca.hxy.contains("watch_msg_source_type"))) {
          break label628;
        }
        parama1 = (String)XmlParser.parseXml(paramca.hxy, "msgsource", null).get(".msgsource.watch_msg_source_type");
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
          if ((paramca != null) && (((com.tencent.mm.ui.chatting.d.b.d)parama1.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()))
          {
            localObject1 = new by(paramca.field_bizChatUserId, null);
            localObject2 = (com.tencent.mm.ui.chatting.d.b.d)parama1.bC(com.tencent.mm.ui.chatting.d.b.d.class);
            com.tencent.mm.ay.q.bml().a(((com.tencent.mm.ui.chatting.d.b.d)localObject2).Ve(paramca.field_bizChatUserId), parama.avatarIV, ((k)parama1.bC(k.class)).hNT());
            break label152;
          }
          if ((paramca != null) && (paramca.field_isSend == 0) && (parama1.bC(com.tencent.mm.ui.chatting.d.b.a.class) != null) && (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.a)parama1.bC(com.tencent.mm.ui.chatting.d.b.a.class)).hRe())))
          {
            localObject1 = new by(paramString, null);
            com.tencent.mm.ay.q.bml().a(((com.tencent.mm.ui.chatting.d.b.a)parama1.bC(com.tencent.mm.ui.chatting.d.b.a.class)).hRe(), parama.avatarIV, ((k)parama1.bC(k.class)).hNT());
            break label152;
          }
          if (parama1.hRi()) {}
          for (localObject1 = parama1.getTalkerUserName();; localObject1 = null)
          {
            localObject1 = new by(paramString, (String)localObject1);
            F(parama.avatarIV, paramString);
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
        parama.uploadingPB.setTag(R.h.dyJ, Boolean.TRUE);
        return;
      }
      Object localObject = parama.uploadingPB.getTag(R.h.dyI);
      if ((localObject != null) && (((Long)localObject).longValue() < cm.bfD() - 1000L))
      {
        parama.uploadingPB.setVisibility(0);
        parama.uploadingPB.setTag(R.h.dyJ, Boolean.TRUE);
        Log.d("MicroMsg.ChattingItem", "showUploadingPB not init %s", new Object[] { parama });
        return;
      }
      localObject = parama.uploadingPB.getTag(R.h.dyJ);
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        parama.uploadingPB.setVisibility(0);
        Log.d("MicroMsg.ChattingItem", "showUploadingPB had delay visible %s", new Object[] { parama });
        return;
      }
      this.Xct = com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268209);
          parama.uploadingPB.setVisibility(0);
          parama.uploadingPB.setTag(R.h.dyJ, Boolean.TRUE);
          Log.d("MicroMsg.ChattingItem", "showUploadingPB delay visible %s", new Object[] { parama });
          AppMethodBeat.o(268209);
        }
      }, 1000L);
      return;
    }
    parama.uploadingPB.setTag(R.h.dyJ, Boolean.FALSE);
    if (this.Xct != null) {
      this.Xct.cancel(true);
    }
    parama.uploadingPB.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.widget.b.a parama, final com.tencent.mm.ui.chatting.e.a parama1, final String paramString)
  {
    parama.Yrp = new com.tencent.mm.ui.widget.b.a.a()
    {
      public final View a(Context paramAnonymousContext, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(286009);
        int i = paramAnonymousMenuItem.getItemId();
        if ((i == 137) || (i == 4))
        {
          paramAnonymousMenuItem = View.inflate(paramAnonymousContext, R.i.ejS, null);
          ((TextView)paramAnonymousMenuItem.findViewById(R.h.title)).setText(parama1.WQv.getMMResources().getString(R.l.ewe));
          paramAnonymousContext = (TextView)paramAnonymousMenuItem.findViewById(R.h.hotword_tv);
          Object localObject = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(paramString);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramAnonymousContext.setVisibility(8);
            localObject = (MMAnimateView)paramAnonymousMenuItem.findViewById(R.h.icon);
            if (!com.tencent.mm.ui.ar.isDarkMode()) {
              break label179;
            }
          }
          label179:
          for (paramAnonymousContext = "assets:///fireWork_dark.gif";; paramAnonymousContext = "assets:///fireWork_light.gif")
          {
            ((MMAnimateView)localObject).g(u.aY(paramAnonymousContext, 0, -1), "");
            paramAnonymousContext = (com.tencent.mm.plugin.gif.d)((MMAnimateView)localObject).getDrawable();
            if (paramAnonymousContext != null) {
              paramAnonymousContext.Dnr = 2;
            }
            AppMethodBeat.o(286009);
            return paramAnonymousMenuItem;
            paramAnonymousContext.setVisibility(0);
            paramAnonymousContext.setText((CharSequence)localObject);
            break;
          }
        }
        AppMethodBeat.o(286009);
        return null;
      }
    };
  }
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca);
  
  protected boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, by paramby)
  {
    return false;
  }
  
  public abstract boolean a(o paramo, View paramView, ca paramca);
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, ca paramca)
  {
    if (Util.isNullOrNil(paramb.lor)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.WvV, paramca, paramb.loy, paramb.lox);
    String str = paramca.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.lor);
    localIntent.putExtra("KThumUrl", paramb.low);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.lox);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.loy);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.hRi())
    {
      i = com.tencent.mm.ui.chatting.a.b.Wwe.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", a(parama, paramca));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", paramca.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.fUk);
      if (parama.hRi()) {
        localIntent.putExtra("KSta_ChatroomMembercount", v.Pu(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + paramca.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.los);
      localIntent.putExtra("StremWebUrl", paramb.lov);
      localIntent.putExtra("StreamWording", paramb.lou);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vuU, 0) <= 0) {
        break label370;
      }
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      Log.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.Wwd.value;
      break;
      label370:
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.Xcq == null) {
      this.Xcq = new t.h(parama);
    }
    paramView.setOnClickListener(this.Xcq);
  }
  
  protected final void b(a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean, true);
  }
  
  protected boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (hTD()) {
      return false;
    }
    return (parama.hRi()) || (((com.tencent.mm.ui.chatting.d.b.d)parama.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe());
  }
  
  public abstract boolean bZ(int paramInt, boolean paramBoolean);
  
  protected final c c(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Xci == null) {
      this.Xci = new c(parama);
    }
    return this.Xci;
  }
  
  public abstract boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca);
  
  protected final d d(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Xck == null)
    {
      if (!(parama.WQv instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.WQv;
    }
    label47:
    for (this.Xck = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.fgR, this);; this.Xck = new d(parama, this)) {
      return this.Xck;
    }
  }
  
  protected final t.b e(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Xcm == null) {
      this.Xcm = new t.b(parama);
    }
    return this.Xcm;
  }
  
  protected final t.d f(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Xcn == null) {
      this.Xcn = new t.d(parama);
    }
    return this.Xcn;
  }
  
  protected final t.p h(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Xcp == null) {
      this.Xcp = new t.p(parama);
    }
    return this.Xcp;
  }
  
  public abstract boolean hTD();
  
  protected boolean hTE()
  {
    return true;
  }
  
  boolean hTF()
  {
    return true;
  }
  
  protected boolean hTH()
  {
    return true;
  }
  
  protected final t.k i(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Xcr == null) {
      this.Xcr = new t.k(parama);
    }
    return this.Xcr;
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
      this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
      this.avatarIV = ((ChattingAvatarImageView)paramView.findViewById(R.h.chatting_avatar_iv));
      this.historyMsgTip = paramView.findViewById(R.h.dxM);
      this.noMoreMsgTip = paramView.findViewById(R.h.dyR);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.colorMaskView = ((ImageView)paramView.findViewById(R.h.dxa));
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
        localLayoutParams.width = ((int)(paramInt / com.tencent.mm.cj.a.hrd()));
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
      AppMethodBeat.i(249194);
      if (this.colorMaskView != null)
      {
        if (paramBoolean)
        {
          this.colorMaskView.setVisibility(0);
          AppMethodBeat.o(249194);
          return;
        }
        this.colorMaskView.setVisibility(8);
      }
      AppMethodBeat.o(249194);
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
    private String POu;
    com.tencent.mm.ui.chatting.e.a fgR;
    
    protected b(com.tencent.mm.ui.chatting.e.a parama, String paramString)
    {
      this.POu = paramString;
      this.fgR = parama;
    }
    
    public final String bjj()
    {
      return this.POu;
    }
    
    public final void e(LinkedList<fmr> paramLinkedList)
    {
      int k = 0;
      AppMethodBeat.i(36736);
      af.bjw().b(this);
      Log.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
      int i;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        Log.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.POu });
        if (this.fgR != null)
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
                c.b.this.fgR.cAe();
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
        fmr localfmr = (fmr)paramLinkedList.get(j);
        if ((localfmr != null) && (!Util.isNullOrNil(localfmr.ULp)) && (localfmr.ULp.equals(this.POu)))
        {
          Log.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
          if (!Util.isNullOrNil(localfmr.Nickname))
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
  
  public final class c
    implements View.OnLongClickListener
  {
    private com.tencent.mm.ui.widget.b.a AYp;
    com.tencent.mm.ui.chatting.e.a WBq;
    private b XcA;
    private View XcB;
    private int XcC;
    private int XcD;
    Object XcE;
    a.f Xcj;
    private q.e Xcz;
    private int jNq;
    private PopupWindow.OnDismissListener lT;
    private int syc;
    private int syd;
    
    public c(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36741);
      this.XcC = -1;
      this.jNq = -1;
      this.XcD = -1;
      this.lT = new a();
      this.WBq = parama;
      this.Xcz = new q.e()
      {
        public final void a(o paramAnonymouso, View paramAnonymousView)
        {
          AppMethodBeat.i(205099);
          Object localObject = (by)paramAnonymousView.getTag();
          if (localObject == null)
          {
            AppMethodBeat.o(205099);
            return;
          }
          int i = ((by)localObject).position;
          if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).viewType)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            localObject = ((by)localObject).fNz;
            if (localObject == null)
            {
              Log.e("MicroMsg.ChattingItem", "msg is null!");
              AppMethodBeat.o(205099);
              return;
            }
            if (((ca)localObject).erk())
            {
              c.c.a(c.c.this, 49);
              boolean bool2 = c.this.a(paramAnonymouso, paramAnonymousView, (ca)localObject);
              if ((as.bvJ(c.c.b(c.c.this).getTalkerUserName())) || (as.bvH(c.c.b(c.c.this).getTalkerUserName())))
              {
                Log.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                paramAnonymouso.removeItem(116);
              }
              if (!bool2) {
                break label842;
              }
              if (((((ca)localObject).hwH()) || (((ca)localObject).hzN()) || (((ca)localObject).hzE())) && (!bs.G((ca)localObject)) && (!bs.M((ca)localObject))) {
                paramAnonymouso.a(i, 137, c.c.b(c.c.this).WQv.getMMResources().getString(R.l.ewe), R.k.icons_filled_search_logo);
              }
              if ((!bs.D((ca)localObject)) && (!bs.M((ca)localObject)) && (c.this.hTF())) {
                c.c.a(c.c.this, paramAnonymouso, (ca)localObject, i, bool1);
              }
              if ((!bs.D((ca)localObject)) && (!bs.M((ca)localObject)) && (c.c.a(c.c.this, (ca)localObject))) {
                c.c.a(c.c.this, paramAnonymouso, (ca)localObject, i);
              }
              if ((((ca)localObject).hwG()) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (!bs.G((ca)localObject)) && (!bs.M((ca)localObject)))
              {
                paramAnonymouso.a(i, 137, c.c.b(c.c.this).WQv.getMMResources().getString(R.l.ewe), R.k.icons_filled_search_logo);
                paramAnonymousView = new ah();
                ah localah = paramAnonymousView.iX("").iY(String.valueOf(((et)localObject).field_msgSvrId));
                localah.giu = 1;
                localah.geN = 1;
                localah.ggl = 67;
                paramAnonymousView.iZ("");
                paramAnonymousView.ja("");
                if (!ab.Lj(((et)localObject).field_talker)) {
                  break label807;
                }
                paramAnonymousView.gix = 2;
                label462:
                paramAnonymousView.jb("");
                paramAnonymousView.giA = System.currentTimeMillis();
                paramAnonymousView.bpa();
                com.tencent.mm.plugin.websearch.api.ar.a(paramAnonymousView);
              }
              paramAnonymousView = com.tencent.mm.util.i.YyX;
              if (com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.YxG, 0) == 1) {
                paramAnonymouso.a(i, 138, c.c.b(c.c.this).WQv.getMMResources().getString(R.l.evL), R.k.icons_filled_copy);
              }
              if (as.bvS(((et)localObject).field_talker))
              {
                if (paramAnonymouso.findItem(123) != null) {
                  paramAnonymouso.removeItem(123);
                }
                if (paramAnonymouso.findItem(122) != null) {
                  paramAnonymouso.removeItem(122);
                }
                if (paramAnonymouso.findItem(136) != null) {
                  paramAnonymouso.removeItem(136);
                }
                if (paramAnonymouso.findItem(134) != null) {
                  paramAnonymouso.removeItem(134);
                }
                if (paramAnonymouso.findItem(116) != null) {
                  paramAnonymouso.removeItem(116);
                }
                if (paramAnonymouso.findItem(137) != null) {
                  paramAnonymouso.removeItem(137);
                }
                if (paramAnonymouso.findItem(135) != null) {
                  paramAnonymouso.removeItem(135);
                }
              }
              if (!c.c.b(c.c.this).hRj()) {
                break label815;
              }
              c.c.a(c.c.this, paramAnonymouso, i);
            }
            for (;;)
            {
              if (paramAnonymouso.findItem(123) != null)
              {
                paramAnonymouso.removeItem(100);
                paramAnonymouso.removeItem(123);
                c.c.b(c.c.this, paramAnonymouso, i);
              }
              if (((!as.bvS(((et)localObject).field_talker)) && (!bs.D((ca)localObject)) && (!bs.L((ca)localObject)) && (c.this.hTH()) && (c.c.b(c.c.this).hRj())) || (c.c.b(c.c.this).NKq.hxX())) {
                c.c.c(c.c.this, paramAnonymouso, i);
              }
              AppMethodBeat.o(205099);
              return;
              c.c.a(c.c.this, ((ca)localObject).getType());
              break;
              label807:
              paramAnonymousView.gix = 1;
              break label462;
              label815:
              if (paramAnonymouso.findItem(100) != null)
              {
                paramAnonymouso.removeItem(100);
                c.c.a(c.c.this, paramAnonymouso, i);
              }
            }
            label842:
            if (((ca)localObject).hwG())
            {
              bh.beI();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ((ao)c.c.b(c.c.this).bC(ao.class)).a(paramAnonymouso, i, (ca)localObject);
              }
            }
            for (;;)
            {
              if (((et)localObject).field_status == 5)
              {
                paramAnonymouso.a(i, 103, c.c.b(c.c.this).WQv.getMMResources().getString(R.l.evY), R.k.icons_filled_refresh);
                com.tencent.mm.ay.h.c(com.tencent.mm.ay.q.bmh().aa((ca)localObject));
              }
              if (paramAnonymouso.findItem(123) != null) {
                paramAnonymouso.removeItem(100);
              }
              if ((!bs.D((ca)localObject)) && (!bs.M((ca)localObject)) && (c.this.hTF())) {
                c.c.a(c.c.this, paramAnonymouso, (ca)localObject, i, bool1);
              }
              if ((!bs.D((ca)localObject)) && (!bs.M((ca)localObject)) && (c.c.a(c.c.this, (ca)localObject))) {
                c.c.a(c.c.this, paramAnonymouso, (ca)localObject, i);
              }
              if ((as.bvS(((et)localObject).field_talker)) && (paramAnonymouso.findItem(123) != null)) {
                paramAnonymouso.removeItem(123);
              }
              AppMethodBeat.o(205099);
              return;
              if (((ca)localObject).hzu()) {
                paramAnonymouso.a(i, 100, c.c.b(c.c.this).WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
              }
            }
          }
        }
      };
      this.XcA = new b();
      AppMethodBeat.o(36741);
    }
    
    private void hV(View paramView)
    {
      AppMethodBeat.i(285970);
      Object localObject = (by)paramView.getTag();
      if (localObject == null)
      {
        Log.w("MicroMsg.ChattingItem", "open menu but tag is null");
        AppMethodBeat.o(285970);
        return;
      }
      this.XcA.XcH = ((by)localObject);
      if (this.AYp != null)
      {
        this.AYp.cFD();
        this.AYp = null;
      }
      this.AYp = new com.tencent.mm.ui.widget.b.a(this.WBq.WQv.getContext());
      this.AYp.Yri = true;
      this.XcE = paramView.getTag(R.h.dVZ);
      int[] arrayOfInt;
      ca localca;
      if (((this.XcE instanceof Boolean)) && (((Boolean)this.XcE).booleanValue()))
      {
        if (com.tencent.mm.ui.a.a.a.hJg().hJd())
        {
          this.AYp.Yrq = true;
          this.AYp.Yrl = true;
          this.AYp.Yrr = true;
        }
      }
      else
      {
        if ((this.lT instanceof a)) {
          ((a)this.lT).XcH = ((by)localObject);
        }
        this.AYp.XVa = this.lT;
        if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).viewType) && (this.Xcj != null)) {
          this.Xcj.dismiss();
        }
        arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        localca = ((by)localObject).fNz;
        if ((!localca.hzN()) && (!localca.hzE()) && (!localca.hwH())) {
          break label494;
        }
        if (!ab.Lj(localca.field_talker)) {
          break label360;
        }
        localObject = bq.RJ(localca.field_content);
        label291:
        if ((!localca.hzE()) && (!localca.hzN())) {
          break label370;
        }
        localObject = k.b.OQ((String)localObject);
        if (localObject == null) {
          break label579;
        }
        localObject = ((k.b)localObject).title;
      }
      for (;;)
      {
        if (Util.isNullOrNil((String)localObject))
        {
          AppMethodBeat.o(285970);
          return;
          this.AYp.Yrq = false;
          this.AYp.Yrl = false;
          break;
          label360:
          localObject = localca.field_content;
          break label291;
          label370:
          continue;
        }
        String str1 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject);
        if (!Util.isNullOrNil(str1)) {
          c.this.a(this.AYp, this.WBq, str1);
        }
        if (Util.isNullOrNil(str1)) {
          this.AYp.Yrp = null;
        }
        String str2 = "34_" + cm.bfE();
        c localc = c.this;
        com.tencent.mm.ui.chatting.e.a locala = this.WBq;
        if (!Util.isNullOrNil(str1)) {}
        for (boolean bool = true;; bool = false)
        {
          localc.a(locala, localca, 1, bool, (String)localObject, false, str2, 1);
          label494:
          int i = arrayOfInt[0];
          int j = (int)(paramView.getWidth() / 2.0F);
          int k = arrayOfInt[1];
          this.AYp.a(paramView, this.Xcz, this.XcA, i + j, k);
          if (this.WBq != null)
          {
            this.WBq.Y(false);
            this.WBq.Gs(false);
            this.WBq.WQC = false;
          }
          AppMethodBeat.o(285970);
          return;
        }
        label579:
        localObject = "";
      }
    }
    
    final void hTI()
    {
      AppMethodBeat.i(285971);
      if ((this.AYp != null) && (this.AYp.cFD())) {
        this.AYp = null;
      }
      AppMethodBeat.o(285971);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(36742);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      if ((paramView.getTag(R.h.touch_loc) instanceof int[]))
      {
        paramView.getTag(R.h.touch_loc);
        hV(paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(36742);
        return true;
        if (((this.syc == 0) && (this.syd == 0)) || (!this.XcB.equals(paramView))) {
          paramView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(36738);
              c.c.b(c.c.this, (int)paramAnonymousMotionEvent.getRawX());
              c.c.c(c.c.this, (int)paramAnonymousMotionEvent.getRawY());
              c.c.a(c.c.this, paramAnonymousView);
              AppMethodBeat.o(36738);
              return false;
            }
          });
        } else {
          hV(paramView);
        }
      }
    }
    
    final void openContextMenu(View paramView)
    {
      AppMethodBeat.i(285969);
      hV(paramView);
      AppMethodBeat.o(285969);
    }
    
    final class a
      implements PopupWindow.OnDismissListener
    {
      public by XcH;
      
      a() {}
      
      public final void onDismiss()
      {
        AppMethodBeat.i(286741);
        if (((c.c.this.XcE instanceof Boolean)) && (((Boolean)c.c.this.XcE).booleanValue()) && (com.tencent.mm.ui.a.a.a.hJg().hJd()) && (c.c.c(c.c.this) != null)) {
          c.c.c(c.c.this).dismiss();
        }
        k.b localb;
        int i;
        if ((this.XcH != null) && (this.XcH.fNz != null) && (this.XcH.fNz.erk()))
        {
          localb = k.b.aG(this.XcH.fNz.field_content, this.XcH.fNz.field_reserved);
          if (localb == null) {
            i = 0;
          }
        }
        for (;;)
        {
          c.a(c.c.d(c.c.this), c.c.b(c.c.this), c.c.e(c.c.this), c.c.f(c.c.this), c.c.g(c.c.this), i);
          c.c.d(c.c.this, -1);
          c.c.e(c.c.this, -1);
          c.c.a(c.c.this, -1);
          c.c.b(c.c.this).Y(true);
          AppMethodBeat.o(286741);
          return;
          i = localb.type;
          continue;
          i = 0;
        }
      }
    }
    
    final class b
      implements q.g
    {
      public by XcH;
      
      b() {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(36740);
        if (this.XcH == null)
        {
          Log.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
          AppMethodBeat.o(36740);
          return;
        }
        if (((c.this instanceof bi.a)) || ((c.this instanceof bi.b))) {
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.XcH);
        }
        for (;;)
        {
          ((ae)c.c.b(c.c.this).bC(ae.class)).a(paramMenuItem, c.this);
          c.c.e(c.c.this, paramMenuItem.getItemId());
          c.c.d(c.c.this, paramInt);
          if (c.c.c(c.c.this) != null) {
            c.c.c(c.c.this).dismiss();
          }
          AppMethodBeat.o(36740);
          return;
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.XcH.fNz);
        }
      }
    }
  }
  
  public static class d
    extends t.e
  {
    private c chattingItem;
    
    public d(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.chattingItem = paramc;
    }
    
    public void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(36747);
      this.chattingItem.c(paramView, parama, paramca);
      AppMethodBeat.o(36747);
    }
  }
  
  static final class e
    extends a.f
  {
    c.c Xci;
    
    e(c.c paramc)
    {
      this.Xci = paramc;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(36749);
      this.Xci.hTI();
      AppMethodBeat.o(36749);
    }
    
    public final void eD(View paramView)
    {
      AppMethodBeat.i(36750);
      this.Xci.onLongClick(paramView);
      AppMethodBeat.o(36750);
    }
    
    public final void hTJ()
    {
      AppMethodBeat.i(179940);
      c.c localc = this.Xci;
      if (localc.WBq != null) {
        localc.WBq.Gs(true);
      }
      AppMethodBeat.o(179940);
    }
    
    public final void hTK()
    {
      AppMethodBeat.i(179941);
      c.c localc = this.Xci;
      if (localc.WBq != null) {
        localc.WBq.Gs(false);
      }
      AppMethodBeat.o(179941);
    }
    
    public final void hTL()
    {
      AppMethodBeat.i(179942);
      c.c localc = this.Xci;
      if (localc.WBq != null) {
        localc.WBq.Y(false);
      }
      AppMethodBeat.o(179942);
    }
    
    public final void hW(View paramView)
    {
      AppMethodBeat.i(36748);
      this.Xci.openContextMenu(paramView);
      AppMethodBeat.o(36748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */