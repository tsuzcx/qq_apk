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
import android.text.ClipboardManager;
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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.i.b;
import com.tencent.mm.am.j;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.de.a;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.rd.a;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.protocal.protobuf.efo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.s.a;
import com.tencent.mm.ui.chatting.s.b;
import com.tencent.mm.ui.chatting.s.c;
import com.tencent.mm.ui.chatting.s.d;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.h;
import com.tencent.mm.ui.chatting.s.k;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.chatting.s.p;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Future;

public abstract class c
{
  private static boolean JPf = false;
  private static long JPg = 0L;
  private c JXX;
  private a.f JXY;
  private d JXZ;
  private boolean JYa = false;
  protected s.b JYb;
  protected s.d JYc;
  protected s.c JYd;
  protected s.p JYe;
  protected s.h JYf;
  protected s.k JYg;
  protected s.e JYh;
  private Future JYi = null;
  private final long JYj = 10800000L;
  public boolean Jxs;
  protected boolean oSO;
  
  public static void A(ImageView paramImageView, String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231342);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString);
  }
  
  private s.e a(com.tencent.mm.ui.chatting.e.a parama, final s.n paramn)
  {
    if (this.JYh == null) {
      this.JYh = new s.e(parama)
      {
        public final void a(View paramAnonymousView, com.tencent.mm.ui.chatting.e.a paramAnonymousa, bu paramAnonymousbu)
        {
          AppMethodBeat.i(194274);
          paramn.a(paramAnonymousa, paramAnonymousbu);
          AppMethodBeat.o(194274);
        }
      };
    }
    return this.JYh;
  }
  
  public static String a(bu parambu, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (parambu == null) {
      return str2;
    }
    if (parambu.field_isSend == 1) {
      return u.aAm();
    }
    if (paramBoolean1) {
      str1 = bj.Bk(parambu.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!bt.isNullOrNil(str1)) {
        break;
      }
      return parambu.field_talker;
      if (paramBoolean2) {
        str1 = parambu.field_bizChatUserId;
      }
    }
  }
  
  public static void a(bu parambu, EmojiInfo paramEmojiInfo)
  {
    de localde = new de();
    localde.dnZ.doa = paramEmojiInfo;
    paramEmojiInfo = localde.dnZ.doa;
    if (parambu != null) {}
    for (parambu = parambu.field_talker;; parambu = null)
    {
      paramEmojiInfo.talker = parambu;
      localde.dnZ.scene = 0;
      com.tencent.mm.sdk.b.a.IbL.l(localde);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, bu parambu, k.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aLF(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.fFv()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.dET = "message";
      locala.dFD = paramString;
      locala.dFE = d(parama, parambu);
      locala.FdV = paramb.type;
      locala.scene = i;
      locala.FdW = paramb.mediaTagName;
      locala.dAY = paramLong;
      locala.FdX = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCw());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aLF(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.dET = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.JOR.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, ImageView paramImageView, String paramString)
  {
    if ((bt.lQ("wx485a97c844086dc9", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690438);
      ((WeImageView)paramImageView).setIconColor(parama.JOR.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((bt.lQ("wxaf060266bfa9a35c", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690670);
      ((WeImageView)paramImageView).setIconColor(parama.JOR.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setIconColor(parama.JOR.getContext().getResources().getColor(2131101053));
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cc.a.getDensity(parama.JOR.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.JOR.getMMResources(), 2131233479));
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.JOR.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cc.a.getDensity(parama.JOR.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.JOR.getMMResources(), 2131233479));
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    rd localrd;
    rd.a locala;
    if (parama.fFv())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label253;
        }
        if ((paramg == null) || (!com.tencent.mm.pluginsdk.model.app.q.s(parama.JOR.getContext(), paramg.field_packageName))) {
          break label246;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label259;
      }
      i = 4;
      localrd = new rd();
      localrd.dFI.context = parama.JOR.getContext();
      localrd.dFI.scene = j;
      localrd.dFI.duW = paramb.appId;
      locala = localrd.dFI;
      if (paramg != null) {
        break label273;
      }
    }
    label259:
    label273:
    for (parama = null;; parama = paramg.field_packageName)
    {
      locala.packageName = parama;
      localrd.dFI.msgType = paramb.type;
      localrd.dFI.dyU = paramString1;
      localrd.dFI.dFJ = i;
      localrd.dFI.mediaTagName = paramb.mediaTagName;
      localrd.dFI.dAY = paramLong;
      localrd.dFI.dFK = "";
      localrd.dFI.dkh = paramString2;
      parama = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (parama != null) {
        localrd.dFI.dFL = parama.dFL;
      }
      com.tencent.mm.sdk.b.a.IbL.l(localrd);
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
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, String paramString2)
  {
    a(parama, paramb, paramString1, paramg, paramLong, -1, paramString2);
  }
  
  private void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, bu parambu)
  {
    if (this.JYa) {}
    do
    {
      return;
      this.JYa = true;
    } while (((parama1.JOR instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (w.zy(parama1.getTalkerUserName())));
    if ((parambu != null) && (!bt.isNullOrNil(parambu.fky))) {
      this.JYb = new s.a(parama1);
    }
    for (;;)
    {
      parama.JYo.setOnClickListener(this.JYb);
      parama.JYo.setOnLongClickListener(this.JYc);
      return;
      this.JYb = new s.b(parama1);
      this.JYc = new s.d(parama1);
    }
  }
  
  protected static void a(a parama, CharSequence paramCharSequence)
  {
    if ((parama == null) || (parama.yEk == null)) {
      return;
    }
    if (paramCharSequence == null)
    {
      parama.yEk.setVisibility(8);
      return;
    }
    parama.yEk.setText(paramCharSequence);
    parama.yEk.setVisibility(0);
  }
  
  protected static void a(a parama, boolean paramBoolean)
  {
    c localc = parama.JYv;
    if (localc != null) {
      localc.a(parama, paramBoolean, false);
    }
    while (parama.xfR == null) {
      return;
    }
    if (paramBoolean)
    {
      parama.xfR.setVisibility(0);
      return;
    }
    parama.xfR.setVisibility(8);
  }
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, com.tencent.mm.ui.chatting.e.a parama1, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = System.currentTimeMillis() - parama.startTime;
    long l1 = l2;
    if (l2 > 60000L) {
      l1 = 60000L;
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(20416, new Object[] { parama1.getTalkerUserName(), Integer.valueOf(aWx(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(aei(paramInt2)), Integer.valueOf(aeg(paramInt1)), Integer.valueOf(aeh(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    ad.i("MicroMsg.ChattingItem", "longClick menu report kvReport logID:%s, chatName:%s, chatType:%s, timeInterval:%s, itemType:%s, btnloc:%s, locSqe:%s, logVersion:%s, msgType:%s ", new Object[] { Integer.valueOf(20416), parama1.getTalkerUserName(), Integer.valueOf(aWx(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(aei(paramInt2)), Integer.valueOf(aeg(paramInt1)), Integer.valueOf(aeh(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3) });
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cWM();
    if ((!com.tencent.mm.pluginsdk.model.app.h.a(parama.JOR.getContext(), paramg)) && (localb != null))
    {
      if (!bt.isNullOrNil(paramg.eHz))
      {
        boolean bool = r.bP(parama.JOR.getContext(), paramg.eHz);
        ad.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramg.eHz, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.fFv()) {}
      for (int i = 2;; i = 1)
      {
        ic localic = new ic();
        localic.duF.actionCode = 2;
        localic.duF.scene = i;
        localic.duF.appId = paramg.field_appId;
        localic.duF.context = parama.JOR.getContext();
        com.tencent.mm.sdk.b.a.IbL.l(localic);
        parama.JOR.getContext();
        localb.aj(paramg.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  private static int aWx(String paramString)
  {
    if (w.vF(paramString)) {
      return 2;
    }
    if (w.zE(paramString)) {
      return 3;
    }
    return 1;
  }
  
  protected static boolean aWy(String paramString)
  {
    return ((!w.zQ(paramString)) && (!w.Ag(paramString)) && (!w.zE(paramString)) && (!w.Aq(paramString))) || (w.vF(paramString));
  }
  
  private static int aeg(int paramInt)
  {
    if (paramInt == -1) {
      return 0;
    }
    return (int)Math.ceil((paramInt + 1) / 5.0F) + 10;
  }
  
  private static int aeh(int paramInt)
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
  
  private static int aei(int paramInt)
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
  
  private static int aej(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ad.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      return -1;
    }
    return 2131234176;
  }
  
  protected static void b(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, bu parambu)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cWM();
    if (localb != null) {
      if (!parama.fFv()) {
        break label94;
      }
    }
    label94:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, parambu);
      int j = 0;
      com.tencent.mm.pluginsdk.ui.tools.c localc = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (localc != null) {
        j = localc.dFL;
      }
      parama.JOR.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, parambu.field_msgSvrId, parama.getTalkerUserName(), j);
      return;
    }
  }
  
  protected static boolean b(bu parambu, com.tencent.mm.ui.chatting.e.a parama)
  {
    long l1 = parambu.field_createTime;
    long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFV, 120000L);
    if (parambu.cTc())
    {
      k.b localb = k.b.yr(parambu.field_content);
      if ((localb != null) && (localb.type == 6))
      {
        ad.i("MicroMsg.ChattingItem", "File revoke time is ：%s", new Object[] { Long.valueOf(l2) });
        if (cf.aCL() - l1 > l2) {
          i = 1;
        }
      }
    }
    while (i != 0)
    {
      ad.i("MicroMsg.ChattingItem", "isRevokeExpire, msg talker: %s, svr id: %s.", new Object[] { parambu.field_talker, Long.valueOf(parambu.field_msgSvrId) });
      return false;
      i = 0;
      continue;
      if (cf.aCL() - l1 > 120000L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((parama != null) && (parama.getTalkerUserName().equals(parama.fFr())) && (parambu.field_status == 2)) {
      return false;
    }
    int i = com.tencent.mm.n.g.acA().getInt("ShowRevokeMsgEntry", 1);
    ad.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    return 1 == i;
  }
  
  protected static boolean b(com.tencent.mm.ui.chatting.d.b.k paramk, long paramLong)
  {
    return (paramLong > 0L) && (paramk.fCy() == paramLong);
  }
  
  protected static String c(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    parambu = parambu.field_talker;
    parama = (com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if ((parama.fCH()) && (parama.fCF() != null)) {
      return parama.fCF().field_bizChatServId;
    }
    return parambu;
  }
  
  protected static void c(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCx());
  }
  
  public static String d(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (w.vF(str)) {
      parama = bj.Bk(parambu.field_content);
    }
    return parama;
  }
  
  protected static boolean fHj()
  {
    String str = com.tencent.mm.n.g.acA().getValue("ShowSendOK");
    if (bt.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = bt.aRe(str)) {
      return true;
    }
    return false;
  }
  
  protected static boolean fx(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.h.fx(paramString);
  }
  
  private s.c g(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.JYd == null) {
      this.JYd = new s.c(parama);
    }
    return this.JYd;
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.m(paramString, true, false);
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
      ad.printErrStackTrace("MicroMsg.ChattingItem", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static int km(Context paramContext)
  {
    float f = com.tencent.mm.cc.a.eb(paramContext);
    if (f == com.tencent.mm.cc.a.hY(paramContext)) {
      return com.tencent.mm.cc.a.ay(paramContext, 2131166039);
    }
    if (f == com.tencent.mm.cc.a.ia(paramContext)) {
      return com.tencent.mm.cc.a.ay(paramContext, 2131166032);
    }
    if (f == com.tencent.mm.cc.a.ib(paramContext)) {
      return com.tencent.mm.cc.a.ay(paramContext, 2131166040);
    }
    if (f == com.tencent.mm.cc.a.ic(paramContext)) {
      return com.tencent.mm.cc.a.ay(paramContext, 2131166021);
    }
    if ((f == com.tencent.mm.cc.a.id(paramContext)) || (f == com.tencent.mm.cc.a.ie(paramContext)) || (f == com.tencent.mm.cc.a.jdMethod_if(paramContext))) {
      return com.tencent.mm.cc.a.ay(paramContext, 2131166022);
    }
    return com.tencent.mm.cc.a.ay(paramContext, 2131166038);
  }
  
  public static int kn(Context paramContext)
  {
    float f = com.tencent.mm.cc.a.eb(paramContext);
    if ((f != com.tencent.mm.cc.a.hY(paramContext)) && (f != com.tencent.mm.cc.a.ia(paramContext)))
    {
      if (f == com.tencent.mm.cc.a.ib(paramContext)) {
        return com.tencent.mm.cc.a.ay(paramContext, 2131166020);
      }
      if (f == com.tencent.mm.cc.a.ic(paramContext)) {
        return com.tencent.mm.cc.a.ay(paramContext, 2131166018);
      }
      if ((f == com.tencent.mm.cc.a.id(paramContext)) || (f == com.tencent.mm.cc.a.ie(paramContext)) || (f == com.tencent.mm.cc.a.jdMethod_if(paramContext))) {
        return com.tencent.mm.cc.a.ay(paramContext, 2131166022);
      }
    }
    return com.tencent.mm.cc.a.ay(paramContext, 2131166019);
  }
  
  public static void t(Intent paramIntent, String paramString)
  {
    if ((w.zw(paramString)) || (w.zx(paramString))) {
      paramIntent.putExtra(e.m.IVa, true);
    }
  }
  
  public static void z(ImageView paramImageView, String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231875);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.c(paramImageView, paramString);
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final a.f a(c paramc)
  {
    if (this.JXY == null) {
      this.JXY = new e(paramc);
    }
    return this.JXY;
  }
  
  protected final void a(int paramInt, a parama, bu parambu, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.e.a parama1, s.n paramn)
  {
    a(paramInt, parama, parambu, paramString, true, paramBoolean, parama1, paramn);
  }
  
  protected final void a(int paramInt, a parama, bu parambu, String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.ui.chatting.e.a parama1, s.n paramn)
  {
    if (parambu.field_isSend == 1)
    {
      parama.JYs.setTag(new bk(parambu, paramBoolean2, paramInt, paramString, '\000'));
      parama.JYs.setOnClickListener(a(parama1, paramn));
      paramInt = aej(parambu.field_status);
      if (paramInt != -1)
      {
        parama.JYs.setImageResource(paramInt);
        parama.JYs.setVisibility(0);
        parama.JYs.setContentDescription(com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131761358));
        a(parama, false, paramBoolean1);
      }
    }
    else
    {
      return;
    }
    parama.JYs.setVisibility(8);
  }
  
  protected final void a(final com.tencent.mm.ui.chatting.e.a parama, final bu parambu, final int paramInt, boolean paramBoolean1, final String paramString1, boolean paramBoolean2, final String paramString2)
  {
    final int i;
    final String str1;
    label23:
    final String str2;
    final long l;
    if (parama.fFu())
    {
      i = 2;
      if (!parama.fFu()) {
        break label136;
      }
      str1 = parama.getTalkerUserName();
      parama = b(parama, parambu);
      parambu = parambu.field_msgSvrId;
      str2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
      l = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
      if (!paramBoolean2) {
        break label144;
      }
    }
    label136:
    label144:
    for (final int j = 65;; j = 34)
    {
      if (!paramBoolean1) {
        break label151;
      }
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194272);
          String str = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramString1);
          com.tencent.mm.plugin.websearch.api.am.a(paramInt, paramString2, j, 1, str, str2, parambu, parama, i, str1, l, paramString1.length());
          AppMethodBeat.o(194272);
        }
      });
      return;
      i = 1;
      break;
      str1 = "0";
      break label23;
    }
    label151:
    com.tencent.mm.plugin.websearch.api.am.a(paramInt, paramString2, j, 0, "", str2, parambu, parama, i, str1, l, paramString1.length());
  }
  
  protected final void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, bu parambu)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ad.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (ay.isMobile(parama.JOR.getContext()))
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
      paramString1.putExtra("pre_username", b(parama, parambu));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambu != null) {
        paramString1.putExtra("preUsername", b(parama, parambu));
      }
      paramString1.putExtra("preChatName", parama.getTalkerUserName());
      paramString1.putExtra("preChatTYPE", x.aG(b(parama, parambu), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
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
  
  public final void a(a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bu parambu)
  {
    long l1 = JPg;
    long l2 = System.currentTimeMillis();
    JPg = l2;
    if (l1 + 30000L < l2)
    {
      ba.aBQ();
      JPf = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.oSO = JPf;
    String str;
    if (fHg())
    {
      str = b(parama1, parambu);
      a(parama, parama1, parambu, str);
      a(parama, parama1, str, parambu);
    }
    for (;;)
    {
      if (parama.xfR != null)
      {
        parama.xfR.setTag(2131307296, null);
        if (this.JYi != null) {
          this.JYi.cancel(true);
        }
        parama.xfR.setVisibility(8);
        parama.xfR.setTag(2131307295, Long.valueOf(parambu.field_createTime));
      }
      a(parama, paramInt, parama1, parambu, str);
      if ((parama != null) && (parama.tPw != null)) {
        parama.tPw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(194271);
            if ((parama1.JPa) && (c.this.c(parama1) != null)) {
              c.this.c(parama1).closeContextMenu();
            }
            AppMethodBeat.o(194271);
          }
        });
      }
      if ((parama1.BYG != null) && (parama1.BYG.fqg()))
      {
        parama = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCE();
        if ((parama != null) && (parama.Kk()))
        {
          int i = ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
          l1 = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).TD();
          com.tencent.mm.am.l.a(parama1.BYG, parambu, paramInt, i, l1);
        }
      }
      return;
      str = null;
    }
  }
  
  public abstract void a(a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString);
  
  protected void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    if ((paramString == null) || (parama.yEk == null) || (parambu == null)) {
      return;
    }
    String str;
    if ((parambu.field_isSend == 0) && (!bt.isNullOrNil(parambu.fky)))
    {
      com.tencent.mm.am.h localh = ag.aFY().DW(parambu.fky);
      int i = 1;
      if ((localh != null) && (!bt.isNullOrNil(localh.field_openId)) && (!bt.isNullOrNil(localh.field_nickname)))
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
          ag.aGa().a(new b(parama1, parambu.fky));
          ag.aGa().k(parama1.getTalkerUserName(), parambu.fky, parambu.fkE);
          paramString = str;
        }
      }
    }
    for (;;)
    {
      a(parama, paramString);
      return;
      ad.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
      str = null;
      break;
      if ((b(parama1)) && (((f)parama1.bh(f.class)).fCZ()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI())
        {
          parambu = ((f)parama1.bh(f.class)).aWa(parambu.field_bizChatUserId);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), parambu, parama.yEk.getTextSize());
        }
        else
        {
          parambu = ((f)parama1.bh(f.class)).aWa(paramString);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), parambu, parama.yEk.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, String paramString, bu parambu)
  {
    Object localObject1 = null;
    if (parama.JYo == null) {
      return;
    }
    if ((w.Ap(paramString)) && (!paramString.equals(w.hFm[0])))
    {
      parama.JYo.setVisibility(8);
      return;
    }
    Object localObject2;
    if ((parambu != null) && (!bt.isNullOrNil(parambu.fky)))
    {
      localObject2 = new com.tencent.mm.ak.b();
      ((com.tencent.mm.ak.b)localObject2).hLY = false;
      ((com.tencent.mm.ak.b)localObject2).hLZ = com.tencent.mm.pluginsdk.ui.a.nZg;
      if (parama1.fFv()) {
        localObject1 = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject1 = new bk(paramString, (String)localObject1);
      ((bk)localObject1).Khx = parambu.fky;
      ((bk)localObject1).hGR = parambu.fkE;
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.JYo, parambu.fky, 2131231203, (com.tencent.mm.ak.b)localObject2);
      if (com.tencent.mm.am.h.H(parambu)) {
        ag.aGa().aFK();
      }
      label155:
      parama.JYo.setVisibility(0);
      parama.JYo.setTag(localObject1);
      parama.JYo.setTagUsername(paramString);
      parama.JYo.setTagTalker(parama1.getTalkerUserName());
      if (w.zk(parama1.getTalkerUserName()))
      {
        parama.JYo.setTagScene(2);
        a(parama, parama1, parambu);
        parama.JYo.setOnDoubleClickListener(g(parama1));
        com.tencent.mm.ui.chatting.q.dY(parama.JYo);
        parama.JYo.setContentDescription(v.zf(paramString) + parama1.JOR.getContext().getString(2131756087));
        if (parama.JYp == null) {
          break;
        }
        if ((parambu == null) || (parambu.eLs == null) || (!parambu.eLs.contains("watch_msg_source_type"))) {
          break label618;
        }
        parama1 = (String)bw.M(parambu.eLs, "msgsource").get(".msgsource.watch_msg_source_type");
      }
      try
      {
        i = Integer.valueOf(parama1).intValue();
        if ((i > 0) && (i <= 4))
        {
          parama.JYp.setVisibility(0);
          return;
          localObject1 = null;
          continue;
          if ((parambu != null) && (((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH()))
          {
            localObject1 = new bk(parambu.field_bizChatUserId, null);
            localObject2 = (com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class);
            com.tencent.mm.aw.q.aIJ().a(((com.tencent.mm.ui.chatting.d.b.d)localObject2).Es(parambu.field_bizChatUserId), parama.JYo, ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCz());
            break label155;
          }
          if ((parambu != null) && (parambu.field_isSend == 0) && (parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) && (!bt.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.a)parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fFq())))
          {
            localObject1 = new bk(paramString, null);
            com.tencent.mm.aw.q.aIJ().a(((com.tencent.mm.ui.chatting.d.b.a)parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fFq(), parama.JYo, ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCz());
            break label155;
          }
          if (parama1.fFv()) {
            localObject1 = parama1.getTalkerUserName();
          }
          localObject1 = new bk(paramString, (String)localObject1);
          z(parama.JYo, paramString);
          break label155;
          parama.JYo.setTagScene(1);
        }
      }
      catch (Exception parama1)
      {
        for (;;)
        {
          int i = 0;
        }
        parama.JYp.setVisibility(8);
        return;
      }
    }
    label618:
    parama.JYp.setVisibility(8);
  }
  
  protected final void a(final a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (parama.xfR == null) {
      return;
    }
    ad.d("MicroMsg.ChattingItem", "showUploadingPB %s %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        parama.xfR.setVisibility(0);
        parama.xfR.setTag(2131307296, Boolean.TRUE);
        return;
      }
      Object localObject = parama.xfR.getTag(2131307295);
      if ((localObject != null) && (((Long)localObject).longValue() < cf.aCL() - 1000L))
      {
        parama.xfR.setVisibility(0);
        parama.xfR.setTag(2131307296, Boolean.TRUE);
        ad.d("MicroMsg.ChattingItem", "showUploadingPB not init %s", new Object[] { parama });
        return;
      }
      localObject = parama.xfR.getTag(2131307296);
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        parama.xfR.setVisibility(0);
        ad.d("MicroMsg.ChattingItem", "showUploadingPB had delay visible %s", new Object[] { parama });
        return;
      }
      this.JYi = com.tencent.e.h.LTJ.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194275);
          parama.xfR.setVisibility(0);
          parama.xfR.setTag(2131307296, Boolean.TRUE);
          ad.d("MicroMsg.ChattingItem", "showUploadingPB delay visible %s", new Object[] { parama });
          AppMethodBeat.o(194275);
        }
      }, 1000L);
      return;
    }
    parama.xfR.setTag(2131307296, Boolean.FALSE);
    if (this.JYi != null) {
      this.JYi.cancel(true);
    }
    parama.xfR.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.widget.b.a parama, final com.tencent.mm.ui.chatting.e.a parama1)
  {
    parama.Laq = new com.tencent.mm.ui.widget.b.a.a()
    {
      public final View a(Context paramAnonymousContext, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(194273);
        int i = paramAnonymousMenuItem.getItemId();
        if ((i == 137) || (i == 4))
        {
          paramAnonymousMenuItem = View.inflate(paramAnonymousContext, 2131496484, null);
          ((TextView)paramAnonymousMenuItem.findViewById(2131305902)).setText(parama1.JOR.getMMResources().getString(2131762922));
          MMAnimateView localMMAnimateView = (MMAnimateView)paramAnonymousMenuItem.findViewById(2131300874);
          if (al.isDarkMode()) {}
          for (paramAnonymousContext = "assets:///fireWork_dark.gif";; paramAnonymousContext = "assets:///fireWork_light.gif")
          {
            localMMAnimateView.g(com.tencent.mm.vfs.i.aY(paramAnonymousContext, 0, -1), "");
            paramAnonymousContext = (com.tencent.mm.plugin.gif.d)localMMAnimateView.getDrawable();
            if (paramAnonymousContext != null) {
              paramAnonymousContext.uAl = 2;
            }
            AppMethodBeat.o(194273);
            return paramAnonymousMenuItem;
          }
        }
        AppMethodBeat.o(194273);
        return null;
      }
    };
  }
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu);
  
  protected boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bk parambk)
  {
    return false;
  }
  
  public abstract boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu);
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, bu parambu)
  {
    if (bt.isNullOrNil(paramb.hCe)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.JwQ, parambu, paramb.hCl, paramb.hCk);
    String str = parambu.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.hCe);
    localIntent.putExtra("KThumUrl", paramb.hCj);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.hCk);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.hCl);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.fFv())
    {
      i = com.tencent.mm.ui.chatting.a.b.JwZ.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", b(parama, parambu));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", parambu.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.dHv);
      if (parama.fFv()) {
        localIntent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.q.yS(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + parambu.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.hCf);
      localIntent.putExtra("StremWebUrl", paramb.hCi);
      localIntent.putExtra("StreamWording", paramb.hCh);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qqx, 0) != 0) {
        break label370;
      }
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ad.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.JwY.value;
      break;
      label370:
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public String b(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    Object localObject;
    if (fHh()) {
      localObject = parama.fFr();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.fFv())
    {
      parama = bj.Bk(parambu.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label76;
      }
    }
    for (;;)
    {
      return parama;
      if (parambu != null) {
        parama = parambu.field_bizChatUserId;
      } else {
        label76:
        parama = str;
      }
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.JYf == null) {
      this.JYf = new s.h(parama);
    }
    paramView.setOnClickListener(this.JYf);
  }
  
  protected final void b(a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean, true);
  }
  
  public abstract boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu);
  
  protected boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (fHh()) {
      return false;
    }
    return (parama.fFv()) || (((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH());
  }
  
  public abstract boolean bi(int paramInt, boolean paramBoolean);
  
  protected final c c(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.JXX == null) {
      this.JXX = new c(parama);
    }
    return this.JXX;
  }
  
  protected final d d(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.JXZ == null)
    {
      if (!(parama.JOR instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.JOR;
    }
    label47:
    for (this.JXZ = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.cWM, this);; this.JXZ = new d(parama, this)) {
      return this.JXZ;
    }
  }
  
  protected final s.b e(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.JYb == null) {
      this.JYb = new s.b(parama);
    }
    return this.JYb;
  }
  
  protected final s.d f(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.JYc == null) {
      this.JYc = new s.d(parama);
    }
    return this.JYc;
  }
  
  protected boolean fHg()
  {
    return true;
  }
  
  public abstract boolean fHh();
  
  boolean fHi()
  {
    return true;
  }
  
  protected boolean fHk()
  {
    return true;
  }
  
  protected final s.p h(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.JYe == null) {
      this.JYe = new s.p(parama);
    }
    return this.JYe;
  }
  
  protected final s.k i(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.JYg == null) {
      this.JYg = new s.k(parama);
    }
    return this.JYg;
  }
  
  public static class a
  {
    public ChattingAvatarImageView JYo;
    public ViewStub JYp;
    public View JYq;
    public View JYr;
    public ImageView JYs;
    public ImageView JYt;
    public String JYu;
    public c JYv;
    public TextView fTP;
    public View gZU;
    public CheckBox iCK;
    public View ofK;
    public View tPw;
    public ProgressBar xfR;
    public TextView yEk;
    
    public static void aI(View paramView, int paramInt)
    {
      AppMethodBeat.i(36734);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(paramInt / com.tencent.mm.cd.a.fhE()));
        paramView.setLayoutParams(localLayoutParams);
        paramView.requestLayout();
      }
      AppMethodBeat.o(36734);
    }
    
    public final void gn(View paramView)
    {
      AppMethodBeat.i(36732);
      this.tPw = paramView;
      this.fTP = ((TextView)paramView.findViewById(2131298178));
      this.JYo = ((ChattingAvatarImageView)paramView.findViewById(2131298056));
      this.JYq = paramView.findViewById(2131298104);
      this.JYr = paramView.findViewById(2131308258);
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.ofK = paramView.findViewById(2131298069);
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.JYt = ((ImageView)paramView.findViewById(2131308255));
      this.JYp = null;
      AppMethodBeat.o(36732);
    }
    
    public final void yh(boolean paramBoolean)
    {
      AppMethodBeat.i(36733);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        if ((this.iCK != null) && (this.iCK.getVisibility() != i)) {
          this.iCK.setVisibility(i);
        }
        if ((this.gZU != null) && (this.gZU.getVisibility() != i)) {
          this.gZU.setVisibility(i);
        }
        AppMethodBeat.o(36733);
        return;
      }
    }
  }
  
  static final class b
    implements i.b
  {
    private String DNz;
    com.tencent.mm.ui.chatting.e.a cWM;
    
    protected b(com.tencent.mm.ui.chatting.e.a parama, String paramString)
    {
      this.DNz = paramString;
      this.cWM = parama;
    }
    
    public final String aFL()
    {
      return this.DNz;
    }
    
    public final void e(LinkedList<efo> paramLinkedList)
    {
      int k = 0;
      AppMethodBeat.i(36736);
      ag.aGa().b(this);
      ad.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
      int i;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        ad.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.DNz });
        if (this.cWM != null)
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
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36735);
                c.b.this.cWM.bOo();
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
        efo localefo = (efo)paramLinkedList.get(j);
        if ((localefo != null) && (!bt.isNullOrNil(localefo.HQN)) && (localefo.HQN.equals(this.DNz)))
        {
          ad.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
          if (!bt.isNullOrNil(localefo.Nickname))
          {
            ad.i("MicroMsg.ChattingItem", "needCallback: true");
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
    com.tencent.mm.ui.chatting.e.a JBI;
    private com.tencent.mm.ui.widget.b.a JEB;
    a.f JXY;
    private int JYA;
    private int JYB;
    Object JYC;
    private n.c JYx;
    private a JYy;
    private View JYz;
    private PopupWindow.OnDismissListener afw;
    private int goB;
    private int nYw;
    private int nYx;
    
    public c(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36741);
      this.JYA = -1;
      this.goB = -1;
      this.JYB = -1;
      this.afw = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(36739);
          if (((c.c.this.JYC instanceof Boolean)) && (((Boolean)c.c.this.JYC).booleanValue()) && (com.tencent.mm.ui.a.a.a.fyf().fye()) && (c.c.c(c.c.this) != null)) {
            c.c.c(c.c.this).dismiss();
          }
          c.a(c.c.d(c.c.this), c.c.b(c.c.this), c.c.e(c.c.this), c.c.f(c.c.this), c.c.g(c.c.this));
          c.c.d(c.c.this, -1);
          c.c.e(c.c.this, -1);
          c.c.a(c.c.this, -1);
          c.c.b(c.c.this).setFocused(true);
          AppMethodBeat.o(36739);
        }
      };
      this.JBI = parama;
      this.JYx = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl, View paramAnonymousView)
        {
          int i = 1;
          AppMethodBeat.i(194276);
          Object localObject = (bk)paramAnonymousView.getTag();
          if (localObject == null)
          {
            AppMethodBeat.o(194276);
            return;
          }
          int j = ((bk)localObject).position;
          if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).oIb)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            localObject = ((bk)localObject).dBd;
            if (localObject == null)
            {
              ad.e("MicroMsg.ChattingItem", "msg is null!");
              AppMethodBeat.o(194276);
              return;
            }
            if (((bu)localObject).cTc()) {
              c.c.a(c.c.this, 49);
            }
            while (com.tencent.mm.storage.am.aSV(((ei)localObject).field_talker))
            {
              c.c.a(paramAnonymousl, j, (bu)localObject, paramAnonymousView.getContext());
              AppMethodBeat.o(194276);
              return;
              c.c.a(c.c.this, ((bu)localObject).getType());
            }
            boolean bool2 = c.this.a(paramAnonymousl, paramAnonymousView, (bu)localObject);
            if ((com.tencent.mm.storage.am.aSP(c.c.b(c.c.this).getTalkerUserName())) || (com.tencent.mm.storage.am.aSN(c.c.b(c.c.this).getTalkerUserName())))
            {
              ad.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
              paramAnonymousl.removeItem(116);
            }
            if (bool2)
            {
              if ((((bu)localObject).isText()) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())) {
                paramAnonymousl.a(j, 137, c.c.b(c.c.this).JOR.getMMResources().getString(2131762922), 2131690474);
              }
              if ((!bl.z((bu)localObject)) && (!bl.B((bu)localObject)) && (c.this.fHi())) {
                c.c.a(c.c.this, paramAnonymousl, (bu)localObject, j, bool1);
              }
              if ((!bl.z((bu)localObject)) && (!bl.B((bu)localObject)) && (c.c.a(c.c.this, (bu)localObject))) {
                c.c.a(c.c.this, paramAnonymousl, (bu)localObject, j);
              }
              if ((((bu)localObject).fpi()) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()))
              {
                paramAnonymousl.a(j, 137, c.c.b(c.c.this).JOR.getMMResources().getString(2131762922), 2131690474);
                paramAnonymousView = new m();
                m localm = paramAnonymousView.gI("").gJ(String.valueOf(((ei)localObject).field_msgSvrId));
                localm.dSf = 1;
                localm.dPT = 1;
                localm.dSg = 67;
                if (w.vF(((ei)localObject).field_talker))
                {
                  paramAnonymousView.gK(bj.Bk(((ei)localObject).field_content));
                  paramAnonymousView.gL(((ei)localObject).field_talker);
                  paramAnonymousView.dSj = 2;
                  paramAnonymousView.gM("");
                  paramAnonymousView.aLk();
                  com.tencent.mm.plugin.websearch.api.am.a(paramAnonymousView);
                }
              }
              else
              {
                paramAnonymousView = com.tencent.mm.util.c.LgD;
                if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("total", "copyMsgInfo")) != 1) {
                  break label1096;
                }
                label523:
                if (i != 0)
                {
                  paramAnonymousView = new StringBuffer();
                  paramAnonymousView.append("MsgId: " + ((ei)localObject).field_msgId + "\n");
                  paramAnonymousView.append("MsgSvrId: " + ((ei)localObject).field_msgSvrId + "\n");
                  paramAnonymousView.append("MsgIsSender: " + ((ei)localObject).field_isSend + "\n");
                  paramAnonymousView.append("MsgTalker: " + ((ei)localObject).field_talker + "\n");
                  paramAnonymousView.append("MsgFlag: " + Integer.toBinaryString(((ei)localObject).field_flag) + "\n");
                  paramAnonymousView.append("MsgType: " + Integer.toHexString(((bu)localObject).getType()) + "\n");
                  paramAnonymousView.append("MsgContent: " + ((ei)localObject).field_content + "\n");
                  paramAnonymousView = paramAnonymousView.toString();
                  ((ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard")).setText(paramAnonymousView);
                  com.tencent.mm.ui.base.h.cl(c.c.b(c.c.this).JOR.getContext(), c.c.b(c.c.this).JOR.getContext().getString(2131755702));
                }
                if (com.tencent.mm.storage.am.ail(((ei)localObject).field_talker))
                {
                  if (paramAnonymousl.findItem(123) != null) {
                    paramAnonymousl.removeItem(123);
                  }
                  if (paramAnonymousl.findItem(122) != null) {
                    paramAnonymousl.removeItem(122);
                  }
                  if (paramAnonymousl.findItem(136) != null) {
                    paramAnonymousl.removeItem(136);
                  }
                  if (paramAnonymousl.findItem(134) != null) {
                    paramAnonymousl.removeItem(134);
                  }
                  if (paramAnonymousl.findItem(116) != null) {
                    paramAnonymousl.removeItem(116);
                  }
                }
                if (!c.c.b(c.c.this).fFw()) {
                  break label1101;
                }
                c.c.a(c.c.this, paramAnonymousl, j);
              }
              for (;;)
              {
                if (paramAnonymousl.findItem(123) != null)
                {
                  paramAnonymousl.removeItem(100);
                  paramAnonymousl.removeItem(123);
                  c.c.b(c.c.this, paramAnonymousl, j);
                }
                if (((!com.tencent.mm.storage.am.ail(((ei)localObject).field_talker)) && (!bl.z((bu)localObject)) && (!bl.A((bu)localObject)) && (c.this.fHk()) && (c.c.b(c.c.this).fFw())) || (c.c.b(c.c.this).BYG.fqg())) {
                  c.c.c(c.c.this, paramAnonymousl, j);
                }
                AppMethodBeat.o(194276);
                return;
                if (((ei)localObject).field_isSend == 1) {
                  paramAnonymousView.gK(u.aAm());
                }
                for (;;)
                {
                  paramAnonymousView.gL("");
                  paramAnonymousView.dSj = 1;
                  break;
                  paramAnonymousView.gK(((ei)localObject).field_talker);
                }
                label1096:
                i = 0;
                break label523;
                label1101:
                if (paramAnonymousl.findItem(100) != null)
                {
                  paramAnonymousl.removeItem(100);
                  c.c.a(c.c.this, paramAnonymousl, j);
                }
              }
            }
            if (((bu)localObject).fpi())
            {
              ba.aBQ();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ((com.tencent.mm.ui.chatting.d.b.aj)c.c.b(c.c.this).bh(com.tencent.mm.ui.chatting.d.b.aj.class)).a(paramAnonymousl, j, (bu)localObject);
              }
            }
            for (;;)
            {
              if (((ei)localObject).field_status == 5)
              {
                paramAnonymousl.a(j, 103, c.c.b(c.c.this).JOR.getMMResources().getString(2131757232), 2131690467);
                com.tencent.mm.aw.h.c(com.tencent.mm.aw.q.aIF().L((bu)localObject));
              }
              if (paramAnonymousl.findItem(123) != null) {
                paramAnonymousl.removeItem(100);
              }
              if ((!bl.z((bu)localObject)) && (!bl.B((bu)localObject)) && (c.this.fHi())) {
                c.c.a(c.c.this, paramAnonymousl, (bu)localObject, j, bool1);
              }
              if ((!bl.z((bu)localObject)) && (!bl.B((bu)localObject)) && (c.c.a(c.c.this, (bu)localObject))) {
                c.c.a(c.c.this, paramAnonymousl, (bu)localObject, j);
              }
              if ((com.tencent.mm.storage.am.ail(((ei)localObject).field_talker)) && (paramAnonymousl.findItem(123) != null)) {
                paramAnonymousl.removeItem(123);
              }
              AppMethodBeat.o(194276);
              return;
              if (((bu)localObject).frA()) {
                paramAnonymousl.a(j, 100, c.c.b(c.c.this).JOR.getMMResources().getString(2131757221), 2131690384);
              }
            }
          }
        }
      };
      this.JYy = new a();
      AppMethodBeat.o(36741);
    }
    
    private void go(View paramView)
    {
      AppMethodBeat.i(194278);
      Object localObject = (bk)paramView.getTag();
      if (localObject == null)
      {
        ad.w("MicroMsg.ChattingItem", "open menu but tag is null");
        AppMethodBeat.o(194278);
        return;
      }
      this.JYy.JYF = ((bk)localObject);
      if (this.JEB != null)
      {
        this.JEB.fBg();
        this.JEB = null;
      }
      this.JEB = new com.tencent.mm.ui.widget.b.a(this.JBI.JOR.getContext());
      this.JEB.Lal = true;
      this.JYC = paramView.getTag(2131305626);
      if (((this.JYC instanceof Boolean)) && (((Boolean)this.JYC).booleanValue())) {
        if (!com.tencent.mm.ui.a.a.a.fyf().fye()) {
          break label447;
        }
      }
      label447:
      for (this.JEB.Lar = true;; this.JEB.Lar = false)
      {
        this.JEB.Las = true;
        this.JEB.Lao = false;
        this.JEB.KLB = this.afw;
        if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).oIb) && (this.JXY != null)) {
          this.JXY.dismiss();
        }
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        localObject = ((bk)localObject).dBd;
        if ((((bu)localObject).isText()) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()))
        {
          String str1 = bj.b(this.JBI.fFu(), ((ei)localObject).field_content, ((ei)localObject).field_isSend);
          boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(str1);
          if ((bool) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch())) {
            c.this.a(this.JEB, this.JBI);
          }
          String str2 = "34_" + cf.aCM();
          c.this.a(this.JBI, (bu)localObject, 1, bool, str1, false, str2);
        }
        int i = arrayOfInt[0];
        int j = (int)(paramView.getWidth() / 2.0F);
        int k = arrayOfInt[1];
        this.JEB.a(paramView, this.JYx, this.JYy, i + j, k);
        if (this.JBI != null)
        {
          this.JBI.setFocused(false);
          this.JBI.yb(false);
          this.JBI.JOY = false;
        }
        AppMethodBeat.o(194278);
        return;
      }
    }
    
    final void closeContextMenu()
    {
      AppMethodBeat.i(194279);
      if ((this.JEB != null) && (this.JEB.fBg())) {
        this.JEB = null;
      }
      AppMethodBeat.o(194279);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(36742);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
      if ((paramView.getTag(2131306044) instanceof int[]))
      {
        paramView.getTag(2131306044);
        go(paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(36742);
        return true;
        if (((this.nYw == 0) && (this.nYx == 0)) || (!this.JYz.equals(paramView))) {
          paramView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(36738);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
              c.c.b(c.c.this, (int)paramAnonymousMotionEvent.getRawX());
              c.c.c(c.c.this, (int)paramAnonymousMotionEvent.getRawY());
              c.c.a(c.c.this, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(36738);
              return false;
            }
          });
        } else {
          go(paramView);
        }
      }
    }
    
    final void openContextMenu(View paramView)
    {
      AppMethodBeat.i(194277);
      go(paramView);
      AppMethodBeat.o(194277);
    }
    
    final class a
      implements n.e
    {
      public bk JYF;
      
      a() {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(36740);
        if (this.JYF == null)
        {
          ad.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
          AppMethodBeat.o(36740);
          return;
        }
        if (((c.this instanceof ax.a)) || ((c.this instanceof ax.b))) {
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.JYF);
        }
        for (;;)
        {
          ((ac)c.c.b(c.c.this).bh(ac.class)).a(paramMenuItem, c.this);
          c.c.e(c.c.this, paramMenuItem.getItemId());
          c.c.d(c.c.this, paramInt);
          if (c.c.c(c.c.this) != null) {
            c.c.c(c.c.this).dismiss();
          }
          AppMethodBeat.o(36740);
          return;
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.JYF.dBd);
        }
      }
    }
  }
  
  public static class d
    extends s.e
  {
    private c JYv;
    
    public d(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.JYv = paramc;
    }
    
    public void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(36747);
      paramView.getTag();
      this.JYv.b(paramView, parama, parambu);
      AppMethodBeat.o(36747);
    }
  }
  
  static final class e
    extends a.f
  {
    c.c JXX;
    
    e(c.c paramc)
    {
      this.JXX = paramc;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(36749);
      this.JXX.closeContextMenu();
      AppMethodBeat.o(36749);
    }
    
    public final void fHl()
    {
      AppMethodBeat.i(179940);
      c.c localc = this.JXX;
      if (localc.JBI != null) {
        localc.JBI.yb(true);
      }
      AppMethodBeat.o(179940);
    }
    
    public final void fHm()
    {
      AppMethodBeat.i(179941);
      c.c localc = this.JXX;
      if (localc.JBI != null) {
        localc.JBI.yb(false);
      }
      AppMethodBeat.o(179941);
    }
    
    public final void fHn()
    {
      AppMethodBeat.i(179942);
      c.c localc = this.JXX;
      if (localc.JBI != null) {
        localc.JBI.setFocused(false);
      }
      AppMethodBeat.o(179942);
    }
    
    public final void gp(View paramView)
    {
      AppMethodBeat.i(36748);
      this.JXX.openContextMenu(paramView);
      AppMethodBeat.o(36748);
    }
    
    public final void gq(View paramView)
    {
      AppMethodBeat.i(36750);
      this.JXX.onLongClick(paramView);
      AppMethodBeat.o(36750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */