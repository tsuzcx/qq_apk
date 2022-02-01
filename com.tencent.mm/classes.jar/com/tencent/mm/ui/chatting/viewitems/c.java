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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.i.b;
import com.tencent.mm.al.j;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.df.a;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.re.a;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.f;
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
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Future;

public abstract class c
{
  private static boolean Kkr = false;
  private static long Kks = 0L;
  public boolean JSi;
  protected t.e KuA;
  private Future KuB = null;
  private final long KuC = 10800000L;
  private c Kuq;
  private a.f Kur;
  private d Kus;
  private boolean Kut = false;
  protected t.b Kuu;
  protected t.d Kuv;
  protected t.c Kuw;
  protected t.p Kux;
  protected t.h Kuy;
  protected t.k Kuz;
  protected boolean oZq;
  
  public static void A(ImageView paramImageView, String paramString)
  {
    if (bu.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231342);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString);
  }
  
  private t.e a(com.tencent.mm.ui.chatting.e.a parama, final t.n paramn)
  {
    if (this.KuA == null) {
      this.KuA = new t.e(parama)
      {
        public final void a(View paramAnonymousView, com.tencent.mm.ui.chatting.e.a paramAnonymousa, bv paramAnonymousbv)
        {
          AppMethodBeat.i(187667);
          paramn.a(paramAnonymousa, paramAnonymousbv);
          AppMethodBeat.o(187667);
        }
      };
    }
    return this.KuA;
  }
  
  public static String a(bv parambv, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (parambv == null) {
      return str2;
    }
    if (parambv.field_isSend == 1) {
      return v.aAC();
    }
    if (paramBoolean1) {
      str1 = bl.BM(parambv.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!bu.isNullOrNil(str1)) {
        break;
      }
      return parambv.field_talker;
      if (paramBoolean2) {
        str1 = parambv.field_bizChatUserId;
      }
    }
  }
  
  public static void a(bv parambv, EmojiInfo paramEmojiInfo)
  {
    df localdf = new df();
    localdf.dpe.dpf = paramEmojiInfo;
    paramEmojiInfo = localdf.dpe.dpf;
    if (parambv != null) {}
    for (parambv = parambv.field_talker;; parambv = null)
    {
      paramEmojiInfo.talker = parambv;
      localdf.dpe.scene = 0;
      com.tencent.mm.sdk.b.a.IvT.l(localdf);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, bv parambv, k.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aNb(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.fJC()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.dFY = "message";
      locala.dGI = paramString;
      locala.dGJ = d(parama, parambv);
      locala.Fwt = paramb.type;
      locala.scene = i;
      locala.Fwu = paramb.mediaTagName;
      locala.dCd = paramLong;
      locala.Fwv = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGy());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aNb(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.dFY = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.Kkd.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, ImageView paramImageView, String paramString)
  {
    if ((bu.lX("wx485a97c844086dc9", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690438);
      ((WeImageView)paramImageView).setIconColor(parama.Kkd.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((bu.lX("wxaf060266bfa9a35c", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690670);
      ((WeImageView)paramImageView).setIconColor(parama.Kkd.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setIconColor(parama.Kkd.getContext().getResources().getColor(2131101053));
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.Kkd.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.Kkd.getMMResources(), 2131233479));
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.Kkd.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.Kkd.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.Kkd.getMMResources(), 2131233479));
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    re localre;
    re.a locala;
    if (parama.fJC())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label253;
        }
        if ((paramg == null) || (!com.tencent.mm.pluginsdk.model.app.q.s(parama.Kkd.getContext(), paramg.field_packageName))) {
          break label246;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label259;
      }
      i = 4;
      localre = new re();
      localre.dGN.context = parama.Kkd.getContext();
      localre.dGN.scene = j;
      localre.dGN.dwb = paramb.appId;
      locala = localre.dGN;
      if (paramg != null) {
        break label273;
      }
    }
    label259:
    label273:
    for (parama = null;; parama = paramg.field_packageName)
    {
      locala.packageName = parama;
      localre.dGN.msgType = paramb.type;
      localre.dGN.dzZ = paramString1;
      localre.dGN.dGO = i;
      localre.dGN.mediaTagName = paramb.mediaTagName;
      localre.dGN.dCd = paramLong;
      localre.dGN.dGP = "";
      localre.dGN.dlj = paramString2;
      parama = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (parama != null) {
        localre.dGN.dGQ = parama.dGQ;
      }
      com.tencent.mm.sdk.b.a.IvT.l(localre);
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
  
  private void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, bv parambv)
  {
    if (this.Kut) {}
    do
    {
      return;
      this.Kut = true;
    } while (((parama1.Kkd instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (x.Ai(parama1.getTalkerUserName())));
    if ((parambv != null) && (!bu.isNullOrNil(parambv.fmv))) {
      this.Kuu = new t.a(parama1);
    }
    for (;;)
    {
      parama.KuH.setOnClickListener(this.Kuu);
      parama.KuH.setOnLongClickListener(this.Kuv);
      return;
      this.Kuu = new t.b(parama1);
      this.Kuv = new t.d(parama1);
    }
  }
  
  protected static void a(a parama, CharSequence paramCharSequence)
  {
    if ((parama == null) || (parama.yUp == null)) {
      return;
    }
    if (paramCharSequence == null)
    {
      parama.yUp.setVisibility(8);
      return;
    }
    parama.yUp.setText(paramCharSequence);
    parama.yUp.setVisibility(0);
  }
  
  protected static void a(a parama, boolean paramBoolean)
  {
    c localc = parama.KuO;
    if (localc != null) {
      localc.a(parama, paramBoolean, false);
    }
    while (parama.xvJ == null) {
      return;
    }
    if (paramBoolean)
    {
      parama.xvJ.setVisibility(0);
      return;
    }
    parama.xvJ.setVisibility(8);
  }
  
  public static void a(com.tencent.mm.ui.widget.b.a parama, com.tencent.mm.ui.chatting.e.a parama1, int paramInt1, int paramInt2, int paramInt3)
  {
    long l2 = System.currentTimeMillis() - parama.startTime;
    long l1 = l2;
    if (l2 > 60000L) {
      l1 = 60000L;
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(20416, new Object[] { parama1.getTalkerUserName(), Integer.valueOf(aXZ(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(aeR(paramInt2)), Integer.valueOf(aeP(paramInt1)), Integer.valueOf(aeQ(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    ae.i("MicroMsg.ChattingItem", "longClick menu report kvReport logID:%s, chatName:%s, chatType:%s, timeInterval:%s, itemType:%s, btnloc:%s, locSqe:%s, logVersion:%s, msgType:%s ", new Object[] { Integer.valueOf(20416), parama1.getTalkerUserName(), Integer.valueOf(aXZ(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(aeR(paramInt2)), Integer.valueOf(aeP(paramInt1)), Integer.valueOf(aeQ(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3) });
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cZq();
    if ((!com.tencent.mm.pluginsdk.model.app.h.a(parama.Kkd.getContext(), paramg)) && (localb != null))
    {
      if (!bu.isNullOrNil(paramg.eJi))
      {
        boolean bool = com.tencent.mm.pluginsdk.model.app.r.bQ(parama.Kkd.getContext(), paramg.eJi);
        ae.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramg.eJi, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.fJC()) {}
      for (int i = 2;; i = 1)
      {
        id localid = new id();
        localid.dvK.actionCode = 2;
        localid.dvK.scene = i;
        localid.dvK.appId = paramg.field_appId;
        localid.dvK.context = parama.Kkd.getContext();
        com.tencent.mm.sdk.b.a.IvT.l(localid);
        parama.Kkd.getContext();
        localb.aj(paramg.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  private static int aXZ(String paramString)
  {
    if (x.wb(paramString)) {
      return 2;
    }
    if (x.Ao(paramString)) {
      return 3;
    }
    return 1;
  }
  
  protected static boolean aYa(String paramString)
  {
    return ((!x.AA(paramString)) && (!x.AQ(paramString)) && (!x.Ao(paramString)) && (!x.Ba(paramString))) || (x.wb(paramString));
  }
  
  private static int aeP(int paramInt)
  {
    if (paramInt == -1) {
      return 0;
    }
    return (int)Math.ceil((paramInt + 1) / 5.0F) + 10;
  }
  
  private static int aeQ(int paramInt)
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
  
  private static int aeR(int paramInt)
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
  
  private static int aeS(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      ae.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      return -1;
    }
    return 2131234176;
  }
  
  protected static void b(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, bv parambv)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cZq();
    if (localb != null) {
      if (!parama.fJC()) {
        break label94;
      }
    }
    label94:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, parambv);
      int j = 0;
      com.tencent.mm.pluginsdk.ui.tools.c localc = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (localc != null) {
        j = localc.dGQ;
      }
      parama.Kkd.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, parambv.field_msgSvrId, parama.getTalkerUserName(), j);
      return;
    }
  }
  
  protected static boolean b(bv parambv, com.tencent.mm.ui.chatting.e.a parama)
  {
    long l1 = parambv.field_createTime;
    long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNB, 120000L);
    if (parambv.cVH())
    {
      k.b localb = k.b.zb(parambv.field_content);
      if ((localb != null) && (localb.type == 6))
      {
        ae.i("MicroMsg.ChattingItem", "File revoke time is ：%s", new Object[] { Long.valueOf(l2) });
        if (ch.aDb() - l1 > l2) {
          i = 1;
        }
      }
    }
    while (i != 0)
    {
      ae.i("MicroMsg.ChattingItem", "isRevokeExpire, msg talker: %s, svr id: %s.", new Object[] { parambv.field_talker, Long.valueOf(parambv.field_msgSvrId) });
      return false;
      i = 0;
      continue;
      if (ch.aDb() - l1 > 120000L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((parama != null) && (parama.getTalkerUserName().equals(parama.fJy())) && (parambv.field_status == 2)) {
      return false;
    }
    int i = com.tencent.mm.n.g.acL().getInt("ShowRevokeMsgEntry", 1);
    ae.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    return 1 == i;
  }
  
  protected static boolean b(com.tencent.mm.ui.chatting.d.b.k paramk, long paramLong)
  {
    return (paramLong > 0L) && (paramk.fGA() == paramLong);
  }
  
  protected static String c(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    parambv = parambv.field_talker;
    parama = (com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if ((parama.fGJ()) && (parama.fGH() != null)) {
      return parama.fGH().field_bizChatServId;
    }
    return parambv;
  }
  
  protected static void c(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGz());
  }
  
  public static String d(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (x.wb(str)) {
      parama = bl.BM(parambv.field_content);
    }
    return parama;
  }
  
  protected static boolean fD(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.h.fD(paramString);
  }
  
  protected static boolean fLB()
  {
    String str = com.tencent.mm.n.g.acL().getValue("ShowSendOK");
    if (bu.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = bu.aSB(str)) {
      return true;
    }
    return false;
  }
  
  private t.c g(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Kuw == null) {
      this.Kuw = new t.c(parama);
    }
    return this.Kuw;
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
      ae.printErrStackTrace("MicroMsg.ChattingItem", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static int kt(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.ef(paramContext);
    if (f == com.tencent.mm.cb.a.id(paramContext)) {
      return com.tencent.mm.cb.a.ay(paramContext, 2131166039);
    }
    if (f == com.tencent.mm.cb.a.jdMethod_if(paramContext)) {
      return com.tencent.mm.cb.a.ay(paramContext, 2131166032);
    }
    if (f == com.tencent.mm.cb.a.ig(paramContext)) {
      return com.tencent.mm.cb.a.ay(paramContext, 2131166040);
    }
    if (f == com.tencent.mm.cb.a.ih(paramContext)) {
      return com.tencent.mm.cb.a.ay(paramContext, 2131166021);
    }
    if ((f == com.tencent.mm.cb.a.ii(paramContext)) || (f == com.tencent.mm.cb.a.ij(paramContext)) || (f == com.tencent.mm.cb.a.ik(paramContext))) {
      return com.tencent.mm.cb.a.ay(paramContext, 2131166022);
    }
    return com.tencent.mm.cb.a.ay(paramContext, 2131166038);
  }
  
  public static int ku(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.ef(paramContext);
    if ((f != com.tencent.mm.cb.a.id(paramContext)) && (f != com.tencent.mm.cb.a.jdMethod_if(paramContext)))
    {
      if (f == com.tencent.mm.cb.a.ig(paramContext)) {
        return com.tencent.mm.cb.a.ay(paramContext, 2131166020);
      }
      if (f == com.tencent.mm.cb.a.ih(paramContext)) {
        return com.tencent.mm.cb.a.ay(paramContext, 2131166018);
      }
      if ((f == com.tencent.mm.cb.a.ii(paramContext)) || (f == com.tencent.mm.cb.a.ij(paramContext)) || (f == com.tencent.mm.cb.a.ik(paramContext))) {
        return com.tencent.mm.cb.a.ay(paramContext, 2131166022);
      }
    }
    return com.tencent.mm.cb.a.ay(paramContext, 2131166019);
  }
  
  public static void t(Intent paramIntent, String paramString)
  {
    if ((x.Ag(paramString)) || (x.Ah(paramString))) {
      paramIntent.putExtra(e.m.JpI, true);
    }
  }
  
  public static void z(ImageView paramImageView, String paramString)
  {
    if (bu.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231875);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.c(paramImageView, paramString);
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final a.f a(c paramc)
  {
    if (this.Kur == null) {
      this.Kur = new e(paramc);
    }
    return this.Kur;
  }
  
  protected final void a(int paramInt, a parama, bv parambv, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.e.a parama1, t.n paramn)
  {
    a(paramInt, parama, parambv, paramString, true, paramBoolean, parama1, paramn);
  }
  
  protected final void a(int paramInt, a parama, bv parambv, String paramString, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.ui.chatting.e.a parama1, t.n paramn)
  {
    if (parambv.field_isSend == 1)
    {
      parama.KuL.setTag(new bk(parambv, paramBoolean2, paramInt, paramString, '\000'));
      parama.KuL.setOnClickListener(a(parama1, paramn));
      paramInt = aeS(parambv.field_status);
      if (paramInt != -1)
      {
        parama.KuL.setImageResource(paramInt);
        parama.KuL.setVisibility(0);
        parama.KuL.setContentDescription(com.tencent.mm.sdk.platformtools.ak.getContext().getString(2131761358));
        a(parama, false, paramBoolean1);
      }
    }
    else
    {
      return;
    }
    parama.KuL.setVisibility(8);
  }
  
  protected final void a(final com.tencent.mm.ui.chatting.e.a parama, final bv parambv, final int paramInt, boolean paramBoolean1, final String paramString1, boolean paramBoolean2, final String paramString2)
  {
    final int i;
    final String str1;
    label23:
    final String str2;
    final long l;
    if (parama.fJB())
    {
      i = 2;
      if (!parama.fJB()) {
        break label136;
      }
      str1 = parama.getTalkerUserName();
      parama = b(parama, parambv);
      parambv = parambv.field_msgSvrId;
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
      com.tencent.e.h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187665);
          String str = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramString1);
          am.a(paramInt, paramString2, j, 1, str, str2, parambv, parama, i, str1, l, paramString1.length());
          AppMethodBeat.o(187665);
        }
      });
      return;
      i = 1;
      break;
      str1 = "0";
      break label23;
    }
    label151:
    am.a(paramInt, paramString2, j, 0, "", str2, parambv, parama, i, str1, l, paramString1.length());
  }
  
  protected final void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, bv parambv)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ae.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (az.isMobile(parama.Kkd.getContext()))
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
      paramString1.putExtra("pre_username", b(parama, parambv));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambv != null) {
        paramString1.putExtra("preUsername", b(parama, parambv));
      }
      paramString1.putExtra("preChatName", parama.getTalkerUserName());
      paramString1.putExtra("preChatTYPE", com.tencent.mm.model.y.aH(b(parama, parambv), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
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
  
  public final void a(a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, bv parambv)
  {
    long l1 = Kks;
    long l2 = System.currentTimeMillis();
    Kks = l2;
    if (l1 + 30000L < l2)
    {
      bc.aCg();
      Kkr = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.oZq = Kkr;
    String str;
    if (fLy())
    {
      str = b(parama1, parambv);
      a(parama, parama1, parambv, str);
      a(parama, parama1, str, parambv);
    }
    for (;;)
    {
      if (parama.xvJ != null)
      {
        parama.xvJ.setTag(2131307296, null);
        if (this.KuB != null) {
          this.KuB.cancel(true);
        }
        parama.xvJ.setVisibility(8);
        parama.xvJ.setTag(2131307295, Long.valueOf(parambv.field_createTime));
      }
      a(parama, paramInt, parama1, parambv, str);
      if ((parama != null) && (parama.uan != null)) {
        parama.uan.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(187664);
            if ((parama1.Kkm) && (c.this.c(parama1) != null)) {
              c.this.c(parama1).closeContextMenu();
            }
            AppMethodBeat.o(187664);
          }
        });
      }
      if ((parama1.Cqh != null) && (parama1.Cqh.fug()))
      {
        parama = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGG();
        if ((parama != null) && (parama.Ks()))
        {
          int i = ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
          l1 = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).TJ();
          com.tencent.mm.al.l.a(parama1.Cqh, parambv, paramInt, i, l1);
        }
      }
      return;
      str = null;
    }
  }
  
  public abstract void a(a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString);
  
  protected void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    if ((paramString == null) || (parama.yUp == null) || (parambv == null)) {
      return;
    }
    String str;
    if ((parambv.field_isSend == 0) && (!bu.isNullOrNil(parambv.fmv)))
    {
      com.tencent.mm.al.h localh = ag.aGo().Ey(parambv.fmv);
      int i = 1;
      if ((localh != null) && (!bu.isNullOrNil(localh.field_openId)) && (!bu.isNullOrNil(localh.field_nickname)))
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
          ag.aGq().a(new b(parama1, parambv.fmv));
          ag.aGq().k(parama1.getTalkerUserName(), parambv.fmv, parambv.fmB);
          paramString = str;
        }
      }
    }
    for (;;)
    {
      a(parama, paramString);
      return;
      ae.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
      str = null;
      break;
      if ((b(parama1)) && (((f)parama1.bh(f.class)).fHb()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK())
        {
          parambv = ((f)parama1.bh(f.class)).aXB(parambv.field_bizChatUserId);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), parambv, parama.yUp.getTextSize());
        }
        else
        {
          parambv = ((f)parama1.bh(f.class)).aXB(paramString);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), parambv, parama.yUp.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, String paramString, bv parambv)
  {
    Object localObject1 = null;
    if (parama.KuH == null) {
      return;
    }
    if ((x.AZ(paramString)) && (!paramString.equals(x.hIe[0])))
    {
      parama.KuH.setVisibility(8);
      return;
    }
    Object localObject2;
    if ((parambv != null) && (!bu.isNullOrNil(parambv.fmv)))
    {
      localObject2 = new com.tencent.mm.aj.b();
      ((com.tencent.mm.aj.b)localObject2).hOR = false;
      ((com.tencent.mm.aj.b)localObject2).hOS = com.tencent.mm.pluginsdk.ui.a.oeP;
      if (parama1.fJC()) {
        localObject1 = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject1 = new bk(paramString, (String)localObject1);
      ((bk)localObject1).KDS = parambv.fmv;
      ((bk)localObject1).hJJ = parambv.fmB;
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.KuH, parambv.fmv, 2131231203, (com.tencent.mm.aj.b)localObject2);
      if (com.tencent.mm.al.h.H(parambv)) {
        ag.aGq().aGa();
      }
      label155:
      parama.KuH.setVisibility(0);
      parama.KuH.setTag(localObject1);
      parama.KuH.setTagUsername(paramString);
      parama.KuH.setTagTalker(parama1.getTalkerUserName());
      if (x.zU(parama1.getTalkerUserName()))
      {
        parama.KuH.setTagScene(2);
        a(parama, parama1, parambv);
        parama.KuH.setOnDoubleClickListener(g(parama1));
        com.tencent.mm.ui.chatting.r.dY(parama.KuH);
        parama.KuH.setContentDescription(w.zP(paramString) + parama1.Kkd.getContext().getString(2131756087));
        if (parama.KuI == null) {
          break;
        }
        if ((parambv == null) || (parambv.eNd == null) || (!parambv.eNd.contains("watch_msg_source_type"))) {
          break label618;
        }
        parama1 = (String)bx.M(parambv.eNd, "msgsource").get(".msgsource.watch_msg_source_type");
      }
      try
      {
        i = Integer.valueOf(parama1).intValue();
        if ((i > 0) && (i <= 4))
        {
          parama.KuI.setVisibility(0);
          return;
          localObject1 = null;
          continue;
          if ((parambv != null) && (((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ()))
          {
            localObject1 = new bk(parambv.field_bizChatUserId, null);
            localObject2 = (com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class);
            com.tencent.mm.av.q.aJb().a(((com.tencent.mm.ui.chatting.d.b.d)localObject2).EU(parambv.field_bizChatUserId), parama.KuH, ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGB());
            break label155;
          }
          if ((parambv != null) && (parambv.field_isSend == 0) && (parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) && (!bu.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.a)parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fJx())))
          {
            localObject1 = new bk(paramString, null);
            com.tencent.mm.av.q.aJb().a(((com.tencent.mm.ui.chatting.d.b.a)parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class)).fJx(), parama.KuH, ((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGB());
            break label155;
          }
          if (parama1.fJC()) {
            localObject1 = parama1.getTalkerUserName();
          }
          localObject1 = new bk(paramString, (String)localObject1);
          z(parama.KuH, paramString);
          break label155;
          parama.KuH.setTagScene(1);
        }
      }
      catch (Exception parama1)
      {
        for (;;)
        {
          int i = 0;
        }
        parama.KuI.setVisibility(8);
        return;
      }
    }
    label618:
    parama.KuI.setVisibility(8);
  }
  
  protected final void a(final a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (parama.xvJ == null) {
      return;
    }
    ae.d("MicroMsg.ChattingItem", "showUploadingPB %s %s %s", new Object[] { parama, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        parama.xvJ.setVisibility(0);
        parama.xvJ.setTag(2131307296, Boolean.TRUE);
        return;
      }
      Object localObject = parama.xvJ.getTag(2131307295);
      if ((localObject != null) && (((Long)localObject).longValue() < ch.aDb() - 1000L))
      {
        parama.xvJ.setVisibility(0);
        parama.xvJ.setTag(2131307296, Boolean.TRUE);
        ae.d("MicroMsg.ChattingItem", "showUploadingPB not init %s", new Object[] { parama });
        return;
      }
      localObject = parama.xvJ.getTag(2131307296);
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        parama.xvJ.setVisibility(0);
        ae.d("MicroMsg.ChattingItem", "showUploadingPB had delay visible %s", new Object[] { parama });
        return;
      }
      this.KuB = com.tencent.e.h.MqF.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187668);
          parama.xvJ.setVisibility(0);
          parama.xvJ.setTag(2131307296, Boolean.TRUE);
          ae.d("MicroMsg.ChattingItem", "showUploadingPB delay visible %s", new Object[] { parama });
          AppMethodBeat.o(187668);
        }
      }, 1000L);
      return;
    }
    parama.xvJ.setTag(2131307296, Boolean.FALSE);
    if (this.KuB != null) {
      this.KuB.cancel(true);
    }
    parama.xvJ.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.widget.b.a parama, final com.tencent.mm.ui.chatting.e.a parama1)
  {
    parama.LwO = new com.tencent.mm.ui.widget.b.a.a()
    {
      public final View a(Context paramAnonymousContext, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187666);
        int i = paramAnonymousMenuItem.getItemId();
        if ((i == 137) || (i == 4))
        {
          paramAnonymousMenuItem = View.inflate(paramAnonymousContext, 2131496484, null);
          ((TextView)paramAnonymousMenuItem.findViewById(2131305902)).setText(parama1.Kkd.getMMResources().getString(2131762922));
          MMAnimateView localMMAnimateView = (MMAnimateView)paramAnonymousMenuItem.findViewById(2131300874);
          if (al.isDarkMode()) {}
          for (paramAnonymousContext = "assets:///fireWork_dark.gif";; paramAnonymousContext = "assets:///fireWork_light.gif")
          {
            localMMAnimateView.g(o.bb(paramAnonymousContext, 0, -1), "");
            paramAnonymousContext = (com.tencent.mm.plugin.gif.d)localMMAnimateView.getDrawable();
            if (paramAnonymousContext != null) {
              paramAnonymousContext.uLQ = 2;
            }
            AppMethodBeat.o(187666);
            return paramAnonymousMenuItem;
          }
        }
        AppMethodBeat.o(187666);
        return null;
      }
    };
  }
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv);
  
  protected boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bk parambk)
  {
    return false;
  }
  
  public abstract boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv);
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, bv parambv)
  {
    if (bu.isNullOrNil(paramb.hET)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.JRG, parambv, paramb.hFa, paramb.hEZ);
    String str = parambv.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.hET);
    localIntent.putExtra("KThumUrl", paramb.hEY);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.hEZ);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.hFa);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.fJC())
    {
      i = com.tencent.mm.ui.chatting.a.b.JRP.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", b(parama, parambv));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", parambv.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.dIA);
      if (parama.fJC()) {
        localIntent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.r.zC(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + parambv.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.hEU);
      localIntent.putExtra("StremWebUrl", paramb.hEX);
      localIntent.putExtra("StreamWording", paramb.hEW);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxf, 0) != 0) {
        break label370;
      }
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ae.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.JRO.value;
      break;
      label370:
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public String b(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    Object localObject;
    if (fLz()) {
      localObject = parama.fJy();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.fJC())
    {
      parama = bl.BM(parambv.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label76;
      }
    }
    for (;;)
    {
      return parama;
      if (parambv != null) {
        parama = parambv.field_bizChatUserId;
      } else {
        label76:
        parama = str;
      }
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.Kuy == null) {
      this.Kuy = new t.h(parama);
    }
    paramView.setOnClickListener(this.Kuy);
  }
  
  protected final void b(a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean, true);
  }
  
  public abstract boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv);
  
  protected boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (fLz()) {
      return false;
    }
    return (parama.fJC()) || (((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ());
  }
  
  public abstract boolean br(int paramInt, boolean paramBoolean);
  
  protected final c c(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Kuq == null) {
      this.Kuq = new c(parama);
    }
    return this.Kuq;
  }
  
  protected final d d(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Kus == null)
    {
      if (!(parama.Kkd instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.Kkd;
    }
    label47:
    for (this.Kus = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.cXJ, this);; this.Kus = new d(parama, this)) {
      return this.Kus;
    }
  }
  
  protected final t.b e(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Kuu == null) {
      this.Kuu = new t.b(parama);
    }
    return this.Kuu;
  }
  
  protected final t.d f(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Kuv == null) {
      this.Kuv = new t.d(parama);
    }
    return this.Kuv;
  }
  
  boolean fLA()
  {
    return true;
  }
  
  protected boolean fLC()
  {
    return true;
  }
  
  protected boolean fLy()
  {
    return true;
  }
  
  public abstract boolean fLz();
  
  protected final t.p h(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Kux == null) {
      this.Kux = new t.p(parama);
    }
    return this.Kux;
  }
  
  protected final t.k i(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.Kuz == null) {
      this.Kuz = new t.k(parama);
    }
    return this.Kuz;
  }
  
  public static class a
  {
    public ChattingAvatarImageView KuH;
    public ViewStub KuI;
    public View KuJ;
    public View KuK;
    public ImageView KuL;
    public ImageView KuM;
    public String KuN;
    public c KuO;
    public TextView fVV;
    public View hcH;
    public CheckBox iFD;
    public View olI;
    public View uan;
    public ProgressBar xvJ;
    public TextView yUp;
    
    public static void aI(View paramView, int paramInt)
    {
      AppMethodBeat.i(36734);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(paramInt / com.tencent.mm.cc.a.flw()));
        paramView.setLayoutParams(localLayoutParams);
        paramView.requestLayout();
      }
      AppMethodBeat.o(36734);
    }
    
    public final void gs(View paramView)
    {
      AppMethodBeat.i(36732);
      this.uan = paramView;
      this.fVV = ((TextView)paramView.findViewById(2131298178));
      this.KuH = ((ChattingAvatarImageView)paramView.findViewById(2131298056));
      this.KuJ = paramView.findViewById(2131298104);
      this.KuK = paramView.findViewById(2131308258);
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.olI = paramView.findViewById(2131298069);
      this.KuL = ((ImageView)paramView.findViewById(2131298174));
      this.KuM = ((ImageView)paramView.findViewById(2131308255));
      this.KuI = null;
      AppMethodBeat.o(36732);
    }
    
    public final void yu(boolean paramBoolean)
    {
      AppMethodBeat.i(36733);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        if ((this.iFD != null) && (this.iFD.getVisibility() != i)) {
          this.iFD.setVisibility(i);
        }
        if ((this.hcH != null) && (this.hcH.getVisibility() != i)) {
          this.hcH.setVisibility(i);
        }
        AppMethodBeat.o(36733);
        return;
      }
    }
  }
  
  static final class b
    implements i.b
  {
    private String Efy;
    com.tencent.mm.ui.chatting.e.a cXJ;
    
    protected b(com.tencent.mm.ui.chatting.e.a parama, String paramString)
    {
      this.Efy = paramString;
      this.cXJ = parama;
    }
    
    public final String aGb()
    {
      return this.Efy;
    }
    
    public final void e(LinkedList<ehf> paramLinkedList)
    {
      int k = 0;
      AppMethodBeat.i(36736);
      ag.aGq().b(this);
      ae.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
      int i;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        ae.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.Efy });
        if (this.cXJ != null)
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
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36735);
                c.b.this.cXJ.bPl();
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
        ehf localehf = (ehf)paramLinkedList.get(j);
        if ((localehf != null) && (!bu.isNullOrNil(localehf.IkU)) && (localehf.IkU.equals(this.Efy)))
        {
          ae.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
          if (!bu.isNullOrNil(localehf.Nickname))
          {
            ae.i("MicroMsg.ChattingItem", "needCallback: true");
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
    com.tencent.mm.ui.chatting.e.a JWz;
    private com.tencent.mm.ui.widget.b.a JZs;
    private n.c KuQ;
    private a KuR;
    private View KuS;
    private int KuT;
    private int KuU;
    Object KuV;
    a.f Kur;
    private PopupWindow.OnDismissListener afw;
    private int gqW;
    private int oef;
    private int oeg;
    
    public c(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36741);
      this.KuT = -1;
      this.gqW = -1;
      this.KuU = -1;
      this.afw = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(36739);
          if (((c.c.this.KuV instanceof Boolean)) && (((Boolean)c.c.this.KuV).booleanValue()) && (com.tencent.mm.ui.a.a.a.fCh().fCg()) && (c.c.c(c.c.this) != null)) {
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
      this.JWz = parama;
      this.KuQ = new n.c()
      {
        public final void a(com.tencent.mm.ui.base.l paramAnonymousl, View paramAnonymousView)
        {
          int i = 1;
          AppMethodBeat.i(187669);
          Object localObject = (bk)paramAnonymousView.getTag();
          if (localObject == null)
          {
            AppMethodBeat.o(187669);
            return;
          }
          int j = ((bk)localObject).position;
          if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).oOD)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            localObject = ((bk)localObject).dCi;
            if (localObject == null)
            {
              ae.e("MicroMsg.ChattingItem", "msg is null!");
              AppMethodBeat.o(187669);
              return;
            }
            if (((bv)localObject).cVH())
            {
              c.c.a(c.c.this, 49);
              boolean bool2 = c.this.a(paramAnonymousl, paramAnonymousView, (bv)localObject);
              if ((an.aUp(c.c.b(c.c.this).getTalkerUserName())) || (an.aUn(c.c.b(c.c.this).getTalkerUserName())))
              {
                ae.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                paramAnonymousl.removeItem(116);
              }
              if (!bool2) {
                break label1116;
              }
              if (((((bv)localObject).isText()) || (((bv)localObject).fvR()) || (((bv)localObject).fvJ())) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())) {
                paramAnonymousl.a(j, 137, c.c.b(c.c.this).Kkd.getMMResources().getString(2131762922), 2131690474);
              }
              if ((!bn.z((bv)localObject)) && (!bn.B((bv)localObject)) && (c.this.fLA())) {
                c.c.a(c.c.this, paramAnonymousl, (bv)localObject, j, bool1);
              }
              if ((!bn.z((bv)localObject)) && (!bn.B((bv)localObject)) && (c.c.a(c.c.this, (bv)localObject))) {
                c.c.a(c.c.this, paramAnonymousl, (bv)localObject, j);
              }
              if ((((bv)localObject).ftg()) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()))
              {
                paramAnonymousl.a(j, 137, c.c.b(c.c.this).Kkd.getMMResources().getString(2131762922), 2131690474);
                paramAnonymousView = new m();
                m localm = paramAnonymousView.gO("").gP(String.valueOf(((ei)localObject).field_msgSvrId));
                localm.dTv = 1;
                localm.dRj = 1;
                localm.dTw = 67;
                if (!x.wb(((ei)localObject).field_talker)) {
                  break label1038;
                }
                paramAnonymousView.gQ(bl.BM(((ei)localObject).field_content));
                paramAnonymousView.gR(((ei)localObject).field_talker);
                paramAnonymousView.dTz = 2;
                paramAnonymousView.gS("");
                paramAnonymousView.aLH();
                am.a(paramAnonymousView);
              }
              paramAnonymousView = com.tencent.mm.util.c.LDf;
              if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("total", "copyMsgInfo")) != 1) {
                break label1083;
              }
              label494:
              if (i != 0)
              {
                paramAnonymousView = new StringBuffer();
                paramAnonymousView.append("MsgId: " + ((ei)localObject).field_msgId + "\n");
                paramAnonymousView.append("MsgSvrId: " + ((ei)localObject).field_msgSvrId + "\n");
                paramAnonymousView.append("MsgIsSender: " + ((ei)localObject).field_isSend + "\n");
                paramAnonymousView.append("MsgTalker: " + ((ei)localObject).field_talker + "\n");
                paramAnonymousView.append("MsgFlag: " + Integer.toBinaryString(((ei)localObject).field_flag) + "\n");
                paramAnonymousView.append("MsgType: " + Integer.toHexString(((bv)localObject).getType()) + "\n");
                paramAnonymousView.append("MsgContent: " + ((ei)localObject).field_content + "\n");
                paramAnonymousView = paramAnonymousView.toString();
                ((ClipboardManager)com.tencent.mm.sdk.platformtools.ak.getContext().getSystemService("clipboard")).setText(paramAnonymousView);
                com.tencent.mm.ui.base.h.cm(c.c.b(c.c.this).Kkd.getContext(), c.c.b(c.c.this).Kkd.getContext().getString(2131755702));
              }
              if (an.aUx(((ei)localObject).field_talker))
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
              if (!c.c.b(c.c.this).fJD()) {
                break label1088;
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
              if (((!an.aUx(((ei)localObject).field_talker)) && (!bn.z((bv)localObject)) && (!bn.A((bv)localObject)) && (c.this.fLC()) && (c.c.b(c.c.this).fJD())) || (c.c.b(c.c.this).Cqh.fug())) {
                c.c.c(c.c.this, paramAnonymousl, j);
              }
              AppMethodBeat.o(187669);
              return;
              c.c.a(c.c.this, ((bv)localObject).getType());
              break;
              label1038:
              if (((ei)localObject).field_isSend == 1) {
                paramAnonymousView.gQ(v.aAC());
              }
              for (;;)
              {
                paramAnonymousView.gR("");
                paramAnonymousView.dTz = 1;
                break;
                paramAnonymousView.gQ(((ei)localObject).field_talker);
              }
              label1083:
              i = 0;
              break label494;
              label1088:
              if (paramAnonymousl.findItem(100) != null)
              {
                paramAnonymousl.removeItem(100);
                c.c.a(c.c.this, paramAnonymousl, j);
              }
            }
            label1116:
            if (((bv)localObject).ftg())
            {
              bc.aCg();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ((com.tencent.mm.ui.chatting.d.b.ak)c.c.b(c.c.this).bh(com.tencent.mm.ui.chatting.d.b.ak.class)).a(paramAnonymousl, j, (bv)localObject);
              }
            }
            for (;;)
            {
              if (((ei)localObject).field_status == 5)
              {
                paramAnonymousl.a(j, 103, c.c.b(c.c.this).Kkd.getMMResources().getString(2131757232), 2131690467);
                com.tencent.mm.av.h.c(com.tencent.mm.av.q.aIX().L((bv)localObject));
              }
              if (paramAnonymousl.findItem(123) != null) {
                paramAnonymousl.removeItem(100);
              }
              if ((!bn.z((bv)localObject)) && (!bn.B((bv)localObject)) && (c.this.fLA())) {
                c.c.a(c.c.this, paramAnonymousl, (bv)localObject, j, bool1);
              }
              if ((!bn.z((bv)localObject)) && (!bn.B((bv)localObject)) && (c.c.a(c.c.this, (bv)localObject))) {
                c.c.a(c.c.this, paramAnonymousl, (bv)localObject, j);
              }
              if ((an.aUx(((ei)localObject).field_talker)) && (paramAnonymousl.findItem(123) != null)) {
                paramAnonymousl.removeItem(123);
              }
              AppMethodBeat.o(187669);
              return;
              if (((bv)localObject).fvA()) {
                paramAnonymousl.a(j, 100, c.c.b(c.c.this).Kkd.getMMResources().getString(2131757221), 2131690384);
              }
            }
          }
        }
      };
      this.KuR = new a();
      AppMethodBeat.o(36741);
    }
    
    private void gt(View paramView)
    {
      AppMethodBeat.i(187671);
      Object localObject = (bk)paramView.getTag();
      if (localObject == null)
      {
        ae.w("MicroMsg.ChattingItem", "open menu but tag is null");
        AppMethodBeat.o(187671);
        return;
      }
      this.KuR.KuY = ((bk)localObject);
      if (this.JZs != null)
      {
        this.JZs.fFi();
        this.JZs = null;
      }
      this.JZs = new com.tencent.mm.ui.widget.b.a(this.JWz.Kkd.getContext());
      this.JZs.LwJ = true;
      this.KuV = paramView.getTag(2131305626);
      if (((this.KuV instanceof Boolean)) && (((Boolean)this.KuV).booleanValue()))
      {
        if (!com.tencent.mm.ui.a.a.a.fCh().fCg()) {
          break label447;
        }
        this.JZs.LwP = true;
      }
      for (this.JZs.LwM = true;; this.JZs.LwM = false)
      {
        this.JZs.LwQ = true;
        this.JZs.LhV = this.afw;
        if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).oOD) && (this.Kur != null)) {
          this.Kur.dismiss();
        }
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        localObject = ((bk)localObject).dCi;
        if ((((bv)localObject).isText()) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()))
        {
          String str1 = bl.b(this.JWz.fJB(), ((ei)localObject).field_content, ((ei)localObject).field_isSend);
          boolean bool = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.box.d.class)).checkIfHasHotWord(str1);
          if ((bool) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch())) {
            c.this.a(this.JZs, this.JWz);
          }
          String str2 = "34_" + ch.aDc();
          c.this.a(this.JWz, (bv)localObject, 1, bool, str1, false, str2);
        }
        int i = arrayOfInt[0];
        int j = (int)(paramView.getWidth() / 2.0F);
        int k = arrayOfInt[1];
        this.JZs.a(paramView, this.KuQ, this.KuR, i + j, k);
        if (this.JWz != null)
        {
          this.JWz.setFocused(false);
          this.JWz.yi(false);
          this.JWz.Kkk = false;
        }
        AppMethodBeat.o(187671);
        return;
        label447:
        this.JZs.LwP = false;
      }
    }
    
    final void closeContextMenu()
    {
      AppMethodBeat.i(187672);
      if ((this.JZs != null) && (this.JZs.fFi())) {
        this.JZs = null;
      }
      AppMethodBeat.o(187672);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(36742);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      if ((paramView.getTag(2131306044) instanceof int[]))
      {
        paramView.getTag(2131306044);
        gt(paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(36742);
        return true;
        if (((this.oef == 0) && (this.oeg == 0)) || (!this.KuS.equals(paramView))) {
          paramView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(36738);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              localb.bd(paramAnonymousMotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
              c.c.b(c.c.this, (int)paramAnonymousMotionEvent.getRawX());
              c.c.c(c.c.this, (int)paramAnonymousMotionEvent.getRawY());
              c.c.a(c.c.this, paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(36738);
              return false;
            }
          });
        } else {
          gt(paramView);
        }
      }
    }
    
    final void openContextMenu(View paramView)
    {
      AppMethodBeat.i(187670);
      gt(paramView);
      AppMethodBeat.o(187670);
    }
    
    final class a
      implements n.e
    {
      public bk KuY;
      
      a() {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(36740);
        if (this.KuY == null)
        {
          ae.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
          AppMethodBeat.o(36740);
          return;
        }
        if (((c.this instanceof ax.a)) || ((c.this instanceof ax.b))) {
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.KuY);
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
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.KuY.dCi);
        }
      }
    }
  }
  
  public static class d
    extends t.e
  {
    private c KuO;
    
    public d(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.KuO = paramc;
    }
    
    public void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(36747);
      paramView.getTag();
      this.KuO.b(paramView, parama, parambv);
      AppMethodBeat.o(36747);
    }
  }
  
  static final class e
    extends a.f
  {
    c.c Kuq;
    
    e(c.c paramc)
    {
      this.Kuq = paramc;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(36749);
      this.Kuq.closeContextMenu();
      AppMethodBeat.o(36749);
    }
    
    public final void fLD()
    {
      AppMethodBeat.i(179940);
      c.c localc = this.Kuq;
      if (localc.JWz != null) {
        localc.JWz.yi(true);
      }
      AppMethodBeat.o(179940);
    }
    
    public final void fLE()
    {
      AppMethodBeat.i(179941);
      c.c localc = this.Kuq;
      if (localc.JWz != null) {
        localc.JWz.yi(false);
      }
      AppMethodBeat.o(179941);
    }
    
    public final void fLF()
    {
      AppMethodBeat.i(179942);
      c.c localc = this.Kuq;
      if (localc.JWz != null) {
        localc.JWz.setFocused(false);
      }
      AppMethodBeat.o(179942);
    }
    
    public final void gu(View paramView)
    {
      AppMethodBeat.i(36748);
      this.Kuq.openContextMenu(paramView);
      AppMethodBeat.o(36748);
    }
    
    public final void gv(View paramView)
    {
      AppMethodBeat.i(36750);
      this.Kuq.onLongClick(paramView);
      AppMethodBeat.o(36750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */