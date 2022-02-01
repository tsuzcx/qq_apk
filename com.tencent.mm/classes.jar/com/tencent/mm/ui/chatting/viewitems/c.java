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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.j;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.di.a;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.ry.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.an;
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
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.mm.vfs.s;
import java.util.Map;
import java.util.concurrent.Future;

public abstract class c
{
  private static boolean Pwq = false;
  private static long Pwr = 0L;
  private c PGO;
  private a.f PGP;
  private d PGQ;
  private boolean PGR = false;
  protected t.b PGS;
  protected t.d PGT;
  protected t.c PGU;
  protected t.p PGV;
  protected t.h PGW;
  protected t.k PGX;
  protected t.e PGY;
  private Future PGZ = null;
  private final long PHa = 10800000L;
  public boolean Pdm;
  protected boolean qoo;
  
  public static void D(ImageView paramImageView, String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231957);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.c(paramImageView, paramString);
  }
  
  public static void E(ImageView paramImageView, String paramString)
  {
    if (Util.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231405);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString);
  }
  
  public static String a(ca paramca, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (paramca == null) {
      return str2;
    }
    if (paramca.field_isSend == 1) {
      return z.aTY();
    }
    if (paramBoolean1) {
      str1 = bp.Ks(paramca.field_content);
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
  
  public static void a(ca paramca, EmojiInfo paramEmojiInfo)
  {
    di localdi = new di();
    localdi.dGs.dGt = paramEmojiInfo;
    paramEmojiInfo = localdi.dGs.dGt;
    if (paramca != null) {}
    for (paramca = paramca.field_talker;; paramca = null)
    {
      paramEmojiInfo.talker = paramca;
      localdi.dGs.scene = 0;
      EventCenter.instance.publish(localdi);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, ca paramca, k.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.bdz(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.gRM()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.from = "message";
      locala.pkgName = paramString;
      locala.dYs = d(parama, paramca);
      locala.Kno = paramb.type;
      locala.scene = i;
      locala.Knp = paramb.mediaTagName;
      locala.dTS = paramLong;
      locala.Knq = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((k)parama.bh(k.class)).gOE());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.bdz(paramString))
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
    int i = (int)parama.Pwc.getMMResources().getDimension(2131165594);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, ImageView paramImageView, String paramString)
  {
    if ((Util.isEqual("wx485a97c844086dc9", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690616);
      ((WeImageView)paramImageView).setIconColor(parama.Pwc.getContext().getResources().getColor(2131099748));
      return;
    }
    if ((Util.isEqual("wxaf060266bfa9a35c", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690926);
      ((WeImageView)paramImageView).setIconColor(parama.Pwc.getContext().getResources().getColor(2131099748));
      return;
    }
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setIconColor(parama.Pwc.getContext().getResources().getColor(2131101287));
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.Pwc.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.Pwc.getMMResources(), 2131234282));
  }
  
  private static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.Pwc.getMMResources().getDimension(2131165594);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.e.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.Pwc.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.Pwc.getMMResources(), 2131234282));
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    ry localry;
    ry.a locala;
    if (parama.gRM())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label253;
        }
        if ((paramg == null) || (!com.tencent.mm.pluginsdk.model.app.q.s(parama.Pwc.getContext(), paramg.field_packageName))) {
          break label246;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label259;
      }
      i = 4;
      localry = new ry();
      localry.dYw.context = parama.Pwc.getContext();
      localry.dYw.scene = j;
      localry.dYw.dNI = paramb.appId;
      locala = localry.dYw;
      if (paramg != null) {
        break label273;
      }
    }
    label259:
    label273:
    for (parama = null;; parama = paramg.field_packageName)
    {
      locala.packageName = parama;
      localry.dYw.msgType = paramb.type;
      localry.dYw.dRL = paramString1;
      localry.dYw.dYx = i;
      localry.dYw.mediaTagName = paramb.mediaTagName;
      localry.dYw.dTS = paramLong;
      localry.dYw.dYy = "";
      localry.dYw.dCw = paramString2;
      parama = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.as(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (parama != null) {
        localry.dYw.dYz = parama.dYz;
      }
      EventCenter.instance.publish(localry);
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
  
  private void a(a parama, com.tencent.mm.ui.chatting.e.a parama1, ca paramca)
  {
    if (this.PGR) {}
    do
    {
      return;
      this.PGR = true;
    } while (((parama1.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (com.tencent.mm.model.ab.IN(parama1.getTalkerUserName())));
    if ((paramca != null) && (!Util.isNullOrNil(paramca.fQZ))) {
      this.PGS = new t.a(parama1);
    }
    for (;;)
    {
      parama.avatarIV.setOnClickListener(this.PGS);
      parama.avatarIV.setOnLongClickListener(this.PGT);
      return;
      this.PGS = new t.b(parama1);
      this.PGT = new t.d(parama1);
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
    long l2 = System.currentTimeMillis() - parama.startTime;
    long l1 = l2;
    if (l2 > 60000L) {
      l1 = 60000L;
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(20416, new Object[] { parama1.getTalkerUserName(), Integer.valueOf(bne(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(anC(paramInt2)), Integer.valueOf(anA(paramInt1)), Integer.valueOf(anB(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3) });
    Log.i("MicroMsg.ChattingItem", "longClick menu report kvReport logID:%s, chatName:%s, chatType:%s, timeInterval:%s, itemType:%s, btnloc:%s, locSqe:%s, logVersion:%s, msgType:%s ", new Object[] { Integer.valueOf(20416), parama1.getTalkerUserName(), Integer.valueOf(bne(parama1.getTalkerUserName())), Long.valueOf(l1), Integer.valueOf(anC(paramInt2)), Integer.valueOf(anA(paramInt1)), Integer.valueOf(anB(paramInt1)), Integer.valueOf(1), Integer.valueOf(paramInt3) });
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.e.a parama, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.dSQ();
    if ((!com.tencent.mm.pluginsdk.model.app.h.a(parama.Pwc.getContext(), paramg)) && (localb != null))
    {
      if (!Util.isNullOrNil(paramg.fmK))
      {
        boolean bool = com.tencent.mm.pluginsdk.model.app.r.ck(parama.Pwc.getContext(), paramg.fmK);
        Log.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramg.fmK, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.gRM()) {}
      for (int i = 2;; i = 1)
      {
        is localis = new is();
        localis.dNr.actionCode = 2;
        localis.dNr.scene = i;
        localis.dNr.appId = paramg.field_appId;
        localis.dNr.context = parama.Pwc.getContext();
        EventCenter.instance.publish(localis);
        parama.Pwc.getContext();
        localb.am(paramg.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  private static int anA(int paramInt)
  {
    if (paramInt == -1) {
      return 0;
    }
    return (int)Math.ceil((paramInt + 1) / 5.0F) + 10;
  }
  
  private static int anB(int paramInt)
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
  
  private static int anC(int paramInt)
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
  
  private static int anD(int paramInt)
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
    return 2131235047;
  }
  
  protected static String b(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    paramca = paramca.field_talker;
    parama = (com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class);
    if ((parama.gOP()) && (parama.gON() != null)) {
      return parama.gON().field_bizChatServId;
    }
    return paramca;
  }
  
  protected static void b(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, ca paramca)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.dSQ();
    if (localb != null) {
      if (!parama.gRM()) {
        break label94;
      }
    }
    label94:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, paramca);
      int j = 0;
      com.tencent.mm.pluginsdk.ui.tools.c localc = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.as(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (localc != null) {
        j = localc.dYz;
      }
      parama.Pwc.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, paramca.field_msgSvrId, parama.getTalkerUserName(), j);
      return;
    }
  }
  
  protected static boolean b(ca paramca, com.tencent.mm.ui.chatting.e.a parama)
  {
    long l1 = paramca.field_createTime;
    long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.skz, 120000L);
    if (paramca.dOQ())
    {
      k.b localb = k.b.HD(paramca.field_content);
      if ((localb != null) && (localb.type == 6))
      {
        Log.i("MicroMsg.ChattingItem", "File revoke time is ：%s", new Object[] { Long.valueOf(l2) });
        if (cl.aWz() - l1 > l2) {
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
      if (cl.aWz() - l1 > 120000L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((parama != null) && (parama.getTalkerUserName().equals(parama.gRI())) && (paramca.field_status == 2)) {
      return false;
    }
    int i = com.tencent.mm.n.h.aqJ().getInt("ShowRevokeMsgEntry", 1);
    Log.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    return 1 == i;
  }
  
  protected static boolean b(k paramk, long paramLong)
  {
    return (paramLong > 0L) && (paramk.gOG() == paramLong);
  }
  
  private static int bne(String paramString)
  {
    if (com.tencent.mm.model.ab.Eq(paramString)) {
      return 2;
    }
    if (com.tencent.mm.model.ab.IT(paramString)) {
      return 3;
    }
    return 1;
  }
  
  protected static boolean bnf(String paramString)
  {
    return ((!com.tencent.mm.model.ab.Jf(paramString)) && (!com.tencent.mm.model.ab.Jv(paramString)) && (!com.tencent.mm.model.ab.IT(paramString)) && (!com.tencent.mm.model.ab.JF(paramString))) || (com.tencent.mm.model.ab.Eq(paramString));
  }
  
  protected static void c(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((k)parama.bh(k.class)).gOF());
  }
  
  public static void c(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    if ((parama != null) && (paramca != null)) {
      com.tencent.mm.al.l.c(paramca, ((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).ahy());
    }
  }
  
  public static String d(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (com.tencent.mm.model.ab.Eq(str)) {
      parama = bp.Ks(paramca.field_content);
    }
    return parama;
  }
  
  private t.c g(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.PGU == null) {
      this.PGU = new t.c(parama);
    }
    return this.PGU;
  }
  
  protected static boolean gTW()
  {
    String str = com.tencent.mm.n.h.aqJ().getValue("ShowSendOK");
    if (Util.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = Util.safeParseInt(str)) {
      return true;
    }
    return false;
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
  
  protected static boolean gp(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.h.gp(paramString);
  }
  
  public static int kk(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.ez(paramContext);
    if (f == com.tencent.mm.cb.a.iW(paramContext)) {
      return com.tencent.mm.cb.a.aH(paramContext, 2131166079);
    }
    if (f == com.tencent.mm.cb.a.iY(paramContext)) {
      return com.tencent.mm.cb.a.aH(paramContext, 2131166072);
    }
    if (f == com.tencent.mm.cb.a.iZ(paramContext)) {
      return com.tencent.mm.cb.a.aH(paramContext, 2131166080);
    }
    if (f == com.tencent.mm.cb.a.ja(paramContext)) {
      return com.tencent.mm.cb.a.aH(paramContext, 2131166054);
    }
    if ((f == com.tencent.mm.cb.a.jb(paramContext)) || (f == com.tencent.mm.cb.a.jc(paramContext)) || (f == com.tencent.mm.cb.a.jd(paramContext))) {
      return com.tencent.mm.cb.a.aH(paramContext, 2131166055);
    }
    return com.tencent.mm.cb.a.aH(paramContext, 2131166078);
  }
  
  public static int kl(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.ez(paramContext);
    if ((f != com.tencent.mm.cb.a.iW(paramContext)) && (f != com.tencent.mm.cb.a.iY(paramContext)))
    {
      if (f == com.tencent.mm.cb.a.iZ(paramContext)) {
        return com.tencent.mm.cb.a.aH(paramContext, 2131166053);
      }
      if (f == com.tencent.mm.cb.a.ja(paramContext)) {
        return com.tencent.mm.cb.a.aH(paramContext, 2131166051);
      }
      if ((f == com.tencent.mm.cb.a.jb(paramContext)) || (f == com.tencent.mm.cb.a.jc(paramContext)) || (f == com.tencent.mm.cb.a.jd(paramContext))) {
        return com.tencent.mm.cb.a.aH(paramContext, 2131166055);
      }
    }
    return com.tencent.mm.cb.a.aH(paramContext, 2131166052);
  }
  
  public static void r(Intent paramIntent, String paramString)
  {
    if ((com.tencent.mm.model.ab.IK(paramString)) || (com.tencent.mm.model.ab.IL(paramString))) {
      paramIntent.putExtra(e.p.OzJ, true);
    }
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final t.e a(com.tencent.mm.ui.chatting.e.a parama, final t.n paramn)
  {
    if (this.PGY == null) {
      this.PGY = new t.e(parama)
      {
        public final void a(View paramAnonymousView, com.tencent.mm.ui.chatting.e.a paramAnonymousa, ca paramAnonymousca)
        {
          AppMethodBeat.i(233542);
          paramn.b(paramAnonymousView, paramAnonymousa, paramAnonymousca);
          AppMethodBeat.o(233542);
        }
      };
    }
    return this.PGY;
  }
  
  protected final a.f a(c paramc)
  {
    if (this.PGP == null) {
      this.PGP = new e(paramc);
    }
    return this.PGP;
  }
  
  public String a(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    Object localObject;
    if (gTT()) {
      localObject = parama.gRI();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.gRM())
    {
      parama = bp.Ks(paramca.field_content);
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
      parama.stateIV.setTag(new bq(paramca, paramBoolean2, paramInt, paramString, '\000'));
      parama.stateIV.setOnClickListener(a(parama1, paramn));
      paramInt = anD(paramca.field_status);
      if (paramInt != -1)
      {
        parama.stateIV.setImageResource(paramInt);
        parama.stateIV.setVisibility(0);
        parama.stateIV.setContentDescription(MMApplicationContext.getContext().getString(2131763186));
        a(parama, false, paramBoolean1);
      }
    }
    else
    {
      return;
    }
    parama.stateIV.setVisibility(8);
  }
  
  protected final void a(final com.tencent.mm.ui.chatting.e.a parama, final ca paramca, final int paramInt, boolean paramBoolean1, final String paramString1, boolean paramBoolean2, final String paramString2)
  {
    final int i;
    final String str1;
    label23:
    final String str2;
    final long l;
    if (parama.gRL())
    {
      i = 2;
      if (!parama.gRL()) {
        break label136;
      }
      str1 = parama.getTalkerUserName();
      parama = a(parama, paramca);
      paramca = paramca.field_msgSvrId;
      str2 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
      l = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
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
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233540);
          String str = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(paramString1);
          ar.a(paramInt, paramString2, j, 1, str, str2, paramca, i, str1, l, paramString1.length());
          AppMethodBeat.o(233540);
        }
      });
      return;
      i = 1;
      break;
      str1 = "0";
      break label23;
    }
    label151:
    ar.a(paramInt, paramString2, j, 0, "", str2, paramca, i, str1, l, paramString1.length());
  }
  
  protected final void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, ca paramca)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      Log.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (NetStatusUtil.isMobile(parama.Pwc.getContext()))
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
      paramString1.putExtra("preChatTYPE", ac.aJ(a(parama, paramca), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
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
    long l1 = Pwr;
    long l2 = System.currentTimeMillis();
    Pwr = l2;
    if (l1 + 30000L < l2)
    {
      bg.aVF();
      Pwq = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.qoo = Pwq;
    String str;
    if (gTU())
    {
      str = a(parama1, paramca);
      a(parama, parama1, paramca, str);
      a(parama, parama1, str, paramca);
    }
    for (;;)
    {
      if (parama.uploadingPB != null)
      {
        parama.uploadingPB.setTag(2131298516, null);
        if (this.PGZ != null) {
          this.PGZ.cancel(true);
        }
        parama.uploadingPB.setVisibility(8);
        parama.uploadingPB.setTag(2131298515, Long.valueOf(paramca.field_createTime));
      }
      a(parama, paramInt, parama1, paramca, str);
      if ((parama != null) && (parama.convertView != null)) {
        parama.convertView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            AppMethodBeat.i(233539);
            if ((parama1.Pwl) && (c.this.c(parama1) != null)) {
              c.this.c(parama1).closeContextMenu();
            }
            AppMethodBeat.o(233539);
          }
        });
      }
      if ((parama1.GUe != null) && (parama1.GUe.gBM()))
      {
        parama = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOM();
        if ((parama != null) && (parama.UC()))
        {
          int i = ((k)parama1.bh(k.class)).getCount();
          l1 = ((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).ahy();
          com.tencent.mm.al.l.a(parama1.GUe, paramca, paramInt, i, l1);
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
    if ((paramca.field_isSend == 0) && (!Util.isNullOrNil(paramca.fQZ)))
    {
      com.tencent.mm.al.h localh = ag.bag().Nm(paramca.fQZ);
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
          ag.bai().a(new c.b(parama1, paramca.fQZ));
          ag.bai().j(parama1.getTalkerUserName(), paramca.fQZ, paramca.fRf);
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
      if ((b(parama1)) && (((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).gPh()))
      {
        if (((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ())
        {
          paramca = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(paramca.field_bizChatUserId);
          paramString = com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), paramca, parama.userTV.getTextSize());
        }
        else
        {
          paramca = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(paramString);
          parama1 = com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), paramca, parama.userTV.getTextSize());
          paramString = ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).attachTextStatusSpanSync(paramString, parama1, com.tencent.mm.plugin.textstatus.a.a.b.FXi, parama.userTV.getTextSize());
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
    if ((com.tencent.mm.model.ab.JE(paramString)) && (!paramString.equals(com.tencent.mm.model.ab.iCO[0])))
    {
      parama.avatarIV.setVisibility(8);
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramca != null) && (!Util.isNullOrNil(paramca.fQZ)))
    {
      localObject2 = new com.tencent.mm.aj.b();
      ((com.tencent.mm.aj.b)localObject2).iJY = false;
      ((com.tencent.mm.aj.b)localObject2).iJZ = com.tencent.mm.pluginsdk.ui.a.ppN;
      if (parama1.gRM()) {
        localObject1 = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject1 = new bq(paramString, (String)localObject1);
      ((bq)localObject1).PQF = paramca.fQZ;
      ((bq)localObject1).iEt = paramca.fRf;
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.avatarIV, paramca.fQZ, (com.tencent.mm.aj.b)localObject2);
      if (com.tencent.mm.al.h.R(paramca)) {
        ag.bai().aZS();
      }
      label149:
      parama.avatarIV.setVisibility(0);
      parama.avatarIV.setTag(localObject1);
      parama.avatarIV.setTagUsername(paramString);
      parama.avatarIV.setTagTalker(parama1.getTalkerUserName());
      if (com.tencent.mm.model.ab.Ix(parama1.getTalkerUserName()))
      {
        parama.avatarIV.setTagScene(2);
        a(parama, parama1, paramca);
        parama.avatarIV.setOnDoubleClickListener(g(parama1));
        com.tencent.mm.ui.chatting.r.dQ(parama.avatarIV);
        parama.avatarIV.setContentDescription(aa.getDisplayName(paramString) + parama1.Pwc.getContext().getString(2131756221));
        if (parama.sendFromWatchVS == null) {
          break;
        }
        if ((paramca == null) || (paramca.fqK == null) || (!paramca.fqK.contains("watch_msg_source_type"))) {
          break label619;
        }
        parama1 = (String)XmlParser.parseXml(paramca.fqK, "msgsource", null).get(".msgsource.watch_msg_source_type");
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
          if ((paramca != null) && (((com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()))
          {
            localObject1 = new bq(paramca.field_bizChatUserId, null);
            localObject2 = (com.tencent.mm.ui.chatting.d.b.d)parama1.bh(com.tencent.mm.ui.chatting.d.b.d.class);
            com.tencent.mm.av.q.bcV().a(((com.tencent.mm.ui.chatting.d.b.d)localObject2).NI(paramca.field_bizChatUserId), parama.avatarIV, ((k)parama1.bh(k.class)).gOH());
            break label149;
          }
          if ((paramca != null) && (paramca.field_isSend == 0) && (parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class) != null) && (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.a)parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gRH())))
          {
            localObject1 = new bq(paramString, null);
            com.tencent.mm.av.q.bcV().a(((com.tencent.mm.ui.chatting.d.b.a)parama1.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gRH(), parama.avatarIV, ((k)parama1.bh(k.class)).gOH());
            break label149;
          }
          if (parama1.gRM()) {}
          for (localObject1 = parama1.getTalkerUserName();; localObject1 = null)
          {
            localObject1 = new bq(paramString, (String)localObject1);
            D(parama.avatarIV, paramString);
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
    label619:
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
        parama.uploadingPB.setTag(2131298516, Boolean.TRUE);
        return;
      }
      Object localObject = parama.uploadingPB.getTag(2131298515);
      if ((localObject != null) && (((Long)localObject).longValue() < cl.aWz() - 1000L))
      {
        parama.uploadingPB.setVisibility(0);
        parama.uploadingPB.setTag(2131298516, Boolean.TRUE);
        Log.d("MicroMsg.ChattingItem", "showUploadingPB not init %s", new Object[] { parama });
        return;
      }
      localObject = parama.uploadingPB.getTag(2131298516);
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        parama.uploadingPB.setVisibility(0);
        Log.d("MicroMsg.ChattingItem", "showUploadingPB had delay visible %s", new Object[] { parama });
        return;
      }
      this.PGZ = com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233543);
          parama.uploadingPB.setVisibility(0);
          parama.uploadingPB.setTag(2131298516, Boolean.TRUE);
          Log.d("MicroMsg.ChattingItem", "showUploadingPB delay visible %s", new Object[] { parama });
          AppMethodBeat.o(233543);
        }
      }, 1000L);
      return;
    }
    parama.uploadingPB.setTag(2131298516, Boolean.FALSE);
    if (this.PGZ != null) {
      this.PGZ.cancel(true);
    }
    parama.uploadingPB.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.widget.b.a parama, final com.tencent.mm.ui.chatting.e.a parama1, final String paramString)
  {
    parama.QSA = new com.tencent.mm.ui.widget.b.a.a()
    {
      public final View a(Context paramAnonymousContext, MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(233541);
        int i = paramAnonymousMenuItem.getItemId();
        if ((i == 137) || (i == 4))
        {
          paramAnonymousMenuItem = View.inflate(paramAnonymousContext, 2131495941, null);
          ((TextView)paramAnonymousMenuItem.findViewById(2131309195)).setText(parama1.Pwc.getMMResources().getString(2131757451));
          paramAnonymousContext = (TextView)paramAnonymousMenuItem.findViewById(2131302358);
          Object localObject = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(paramString);
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramAnonymousContext.setVisibility(8);
            localObject = (MMAnimateView)paramAnonymousMenuItem.findViewById(2131302468);
            if (!ao.isDarkMode()) {
              break label174;
            }
          }
          label174:
          for (paramAnonymousContext = "assets:///fireWork_dark.gif";; paramAnonymousContext = "assets:///fireWork_light.gif")
          {
            ((MMAnimateView)localObject).g(s.aW(paramAnonymousContext, 0, -1), "");
            paramAnonymousContext = (com.tencent.mm.plugin.gif.d)((MMAnimateView)localObject).getDrawable();
            if (paramAnonymousContext != null) {
              paramAnonymousContext.yek = 2;
            }
            AppMethodBeat.o(233541);
            return paramAnonymousMenuItem;
            paramAnonymousContext.setVisibility(0);
            paramAnonymousContext.setText((CharSequence)localObject);
            break;
          }
        }
        AppMethodBeat.o(233541);
        return null;
      }
    };
  }
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca);
  
  protected boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bq parambq)
  {
    return false;
  }
  
  public abstract boolean a(m paramm, View paramView, ca paramca);
  
  public final boolean a(com.tencent.mm.ui.chatting.e.a parama, k.b paramb, ca paramca)
  {
    if (Util.isNullOrNil(paramb.iyZ)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.PcK, paramca, paramb.izg, paramb.izf);
    String str = paramca.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.iyZ);
    localIntent.putExtra("KThumUrl", paramb.ize);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.izf);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.izg);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.gRM())
    {
      i = com.tencent.mm.ui.chatting.a.b.PcT.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", a(parama, paramca));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", paramca.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.ean);
      if (parama.gRM()) {
        localIntent.putExtra("KSta_ChatroomMembercount", v.Ie(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + paramca.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.iza);
      localIntent.putExtra("StremWebUrl", paramb.izd);
      localIntent.putExtra("StreamWording", paramb.izc);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rOS, 0) <= 0) {
        break label370;
      }
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      Log.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.PcS.value;
      break;
      label370:
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.e.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.PGW == null) {
      this.PGW = new t.h(parama);
    }
    paramView.setOnClickListener(this.PGW);
  }
  
  protected final void b(a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean, true);
  }
  
  protected boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (gTT()) {
      return false;
    }
    return (parama.gRM()) || (((com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP());
  }
  
  public abstract boolean bM(int paramInt, boolean paramBoolean);
  
  protected final c c(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.PGO == null) {
      this.PGO = new c(parama);
    }
    return this.PGO;
  }
  
  public abstract boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca);
  
  protected final d d(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.PGQ == null)
    {
      if (!(parama.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.Pwc;
    }
    label47:
    for (this.PGQ = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.dom, this);; this.PGQ = new d(parama, this)) {
      return this.PGQ;
    }
  }
  
  protected final t.b e(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.PGS == null) {
      this.PGS = new t.b(parama);
    }
    return this.PGS;
  }
  
  protected final t.d f(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.PGT == null) {
      this.PGT = new t.d(parama);
    }
    return this.PGT;
  }
  
  public abstract boolean gTT();
  
  protected boolean gTU()
  {
    return true;
  }
  
  boolean gTV()
  {
    return true;
  }
  
  protected boolean gTX()
  {
    return true;
  }
  
  protected final t.p h(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.PGV == null) {
      this.PGV = new t.p(parama);
    }
    return this.PGV;
  }
  
  protected final t.k i(com.tencent.mm.ui.chatting.e.a parama)
  {
    if (this.PGX == null) {
      this.PGX = new t.k(parama);
    }
    return this.PGX;
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
      this.timeTV = ((TextView)paramView.findViewById(2131298558));
      this.avatarIV = ((ChattingAvatarImageView)paramView.findViewById(2131298397));
      this.historyMsgTip = paramView.findViewById(2131298454);
      this.noMoreMsgTip = paramView.findViewById(2131298529);
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.clickArea = paramView.findViewById(2131298411);
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.colorMaskView = ((ImageView)paramView.findViewById(2131298412));
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
        localLayoutParams.width = ((int)(paramInt / com.tencent.mm.cc.a.gvi()));
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
      AppMethodBeat.i(233544);
      if (this.colorMaskView != null)
      {
        if (paramBoolean)
        {
          this.colorMaskView.setVisibility(0);
          AppMethodBeat.o(233544);
          return;
        }
        this.colorMaskView.setVisibility(8);
      }
      AppMethodBeat.o(233544);
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
  
  public final class c
    implements View.OnLongClickListener
  {
    a.f PGP;
    private o.e PHg;
    private a PHh;
    private View PHi;
    private int PHj;
    private int PHk;
    Object PHl;
    com.tencent.mm.ui.chatting.e.a PhN;
    private PopupWindow.OnDismissListener afJ;
    private int hcg;
    private int ppd;
    private int ppe;
    private com.tencent.mm.ui.widget.b.a wnj;
    
    public c(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(36741);
      this.PHj = -1;
      this.hcg = -1;
      this.PHk = -1;
      this.afJ = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(36739);
          if (((c.c.this.PHl instanceof Boolean)) && (((Boolean)c.c.this.PHl).booleanValue()) && (com.tencent.mm.ui.a.a.a.gKe().gKc()) && (c.c.c(c.c.this) != null)) {
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
      this.PhN = parama;
      this.PHg = new o.e()
      {
        public final void a(m paramAnonymousm, View paramAnonymousView)
        {
          int i = 1;
          AppMethodBeat.i(233545);
          Object localObject = (bq)paramAnonymousView.getTag();
          if (localObject == null)
          {
            AppMethodBeat.o(233545);
            return;
          }
          int j = ((bq)localObject).position;
          if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).qcr)) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            localObject = ((bq)localObject).dTX;
            if (localObject == null)
            {
              Log.e("MicroMsg.ChattingItem", "msg is null!");
              AppMethodBeat.o(233545);
              return;
            }
            if (((ca)localObject).dOQ())
            {
              c.c.a(c.c.this, 49);
              boolean bool2 = c.this.a(paramAnonymousm, paramAnonymousView, (ca)localObject);
              if ((as.bjo(c.c.b(c.c.this).getTalkerUserName())) || (as.bjm(c.c.b(c.c.this).getTalkerUserName())))
              {
                Log.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                paramAnonymousm.removeItem(116);
              }
              if (!bool2) {
                break label1117;
              }
              if (((((ca)localObject).isText()) || (((ca)localObject).gDy()) || (((ca)localObject).gDq())) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) && (!br.E((ca)localObject))) {
                paramAnonymousm.a(j, 137, c.c.b(c.c.this).Pwc.getMMResources().getString(2131757451), 2131690670);
              }
              if ((!br.B((ca)localObject)) && (!br.K((ca)localObject)) && (c.this.gTV())) {
                c.c.a(c.c.this, paramAnonymousm, (ca)localObject, j, bool1);
              }
              if ((!br.B((ca)localObject)) && (!br.K((ca)localObject)) && (c.c.a(c.c.this, (ca)localObject))) {
                c.c.a(c.c.this, paramAnonymousm, (ca)localObject, j);
              }
              if ((((ca)localObject).gAz()) && (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (!br.E((ca)localObject)))
              {
                paramAnonymousm.a(j, 137, c.c.b(c.c.this).Pwc.getMMResources().getString(2131757451), 2131690670);
                paramAnonymousView = new com.tencent.mm.g.b.a.ab();
                com.tencent.mm.g.b.a.ab localab = paramAnonymousView.ie("").jdMethod_if(String.valueOf(((eo)localObject).field_msgSvrId));
                localab.enp = 1;
                localab.eki = 1;
                localab.enq = 67;
                paramAnonymousView.ig("");
                paramAnonymousView.ih("");
                if (!com.tencent.mm.model.ab.Eq(((eo)localObject).field_talker)) {
                  break label1076;
                }
                paramAnonymousView.ent = 2;
                label465:
                paramAnonymousView.ii("");
                paramAnonymousView.enx = System.currentTimeMillis();
                paramAnonymousView.bfK();
                ar.a(paramAnonymousView);
              }
              paramAnonymousView = com.tencent.mm.util.c.QYz;
              if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("total", "copyMsgInfo")), 0) != 1) {
                break label1084;
              }
              label512:
              if (i != 0)
              {
                paramAnonymousView = new StringBuffer();
                paramAnonymousView.append("MsgId: " + ((eo)localObject).field_msgId + "\n");
                paramAnonymousView.append("MsgSvrId: " + ((eo)localObject).field_msgSvrId + "\n");
                paramAnonymousView.append("MsgIsSender: " + ((eo)localObject).field_isSend + "\n");
                paramAnonymousView.append("MsgTalker: " + ((eo)localObject).field_talker + "\n");
                paramAnonymousView.append("MsgFlag: " + Integer.toBinaryString(((eo)localObject).field_flag) + "\n");
                paramAnonymousView.append("MsgType: " + Integer.toHexString(((ca)localObject).getType()) + "\n");
                paramAnonymousView.append("MsgContent: " + ((eo)localObject).field_content + "\n");
                ClipboardHelper.setText(paramAnonymousView.toString());
                com.tencent.mm.ui.base.h.cD(c.c.b(c.c.this).Pwc.getContext(), c.c.b(c.c.this).Pwc.getContext().getString(2131755773));
              }
              if (as.bjw(((eo)localObject).field_talker))
              {
                if (paramAnonymousm.findItem(123) != null) {
                  paramAnonymousm.removeItem(123);
                }
                if (paramAnonymousm.findItem(122) != null) {
                  paramAnonymousm.removeItem(122);
                }
                if (paramAnonymousm.findItem(136) != null) {
                  paramAnonymousm.removeItem(136);
                }
                if (paramAnonymousm.findItem(134) != null) {
                  paramAnonymousm.removeItem(134);
                }
                if (paramAnonymousm.findItem(116) != null) {
                  paramAnonymousm.removeItem(116);
                }
                if (paramAnonymousm.findItem(137) != null) {
                  paramAnonymousm.removeItem(137);
                }
                if (paramAnonymousm.findItem(135) != null) {
                  paramAnonymousm.removeItem(135);
                }
              }
              if (!c.c.b(c.c.this).gRN()) {
                break label1089;
              }
              c.c.a(c.c.this, paramAnonymousm, j);
            }
            for (;;)
            {
              if (paramAnonymousm.findItem(123) != null)
              {
                paramAnonymousm.removeItem(100);
                paramAnonymousm.removeItem(123);
                c.c.b(c.c.this, paramAnonymousm, j);
              }
              if (((!as.bjw(((eo)localObject).field_talker)) && (!br.B((ca)localObject)) && (!br.J((ca)localObject)) && (c.this.gTX()) && (c.c.b(c.c.this).gRN())) || (c.c.b(c.c.this).GUe.gBM())) {
                c.c.c(c.c.this, paramAnonymousm, j);
              }
              AppMethodBeat.o(233545);
              return;
              c.c.a(c.c.this, ((ca)localObject).getType());
              break;
              label1076:
              paramAnonymousView.ent = 1;
              break label465;
              label1084:
              i = 0;
              break label512;
              label1089:
              if (paramAnonymousm.findItem(100) != null)
              {
                paramAnonymousm.removeItem(100);
                c.c.a(c.c.this, paramAnonymousm, j);
              }
            }
            label1117:
            if (((ca)localObject).gAz())
            {
              bg.aVF();
              if (com.tencent.mm.model.c.isSDCardAvailable()) {
                ((an)c.c.b(c.c.this).bh(an.class)).a(paramAnonymousm, j, (ca)localObject);
              }
            }
            for (;;)
            {
              if (((eo)localObject).field_status == 5)
              {
                paramAnonymousm.a(j, 103, c.c.b(c.c.this).Pwc.getMMResources().getString(2131757444), 2131690658);
                com.tencent.mm.av.h.c(com.tencent.mm.av.q.bcR().U((ca)localObject));
              }
              if (paramAnonymousm.findItem(123) != null) {
                paramAnonymousm.removeItem(100);
              }
              if ((!br.B((ca)localObject)) && (!br.K((ca)localObject)) && (c.this.gTV())) {
                c.c.a(c.c.this, paramAnonymousm, (ca)localObject, j, bool1);
              }
              if ((!br.B((ca)localObject)) && (!br.K((ca)localObject)) && (c.c.a(c.c.this, (ca)localObject))) {
                c.c.a(c.c.this, paramAnonymousm, (ca)localObject, j);
              }
              if ((as.bjw(((eo)localObject).field_talker)) && (paramAnonymousm.findItem(123) != null)) {
                paramAnonymousm.removeItem(123);
              }
              AppMethodBeat.o(233545);
              return;
              if (((ca)localObject).gDh()) {
                paramAnonymousm.a(j, 100, c.c.b(c.c.this).Pwc.getMMResources().getString(2131757433), 2131690529);
              }
            }
          }
        }
      };
      this.PHh = new a();
      AppMethodBeat.o(36741);
    }
    
    private void gK(View paramView)
    {
      AppMethodBeat.i(233547);
      Object localObject = (bq)paramView.getTag();
      if (localObject == null)
      {
        Log.w("MicroMsg.ChattingItem", "open menu but tag is null");
        AppMethodBeat.o(233547);
        return;
      }
      this.PHh.PHo = ((bq)localObject);
      if (this.wnj != null)
      {
        this.wnj.gNq();
        this.wnj = null;
      }
      this.wnj = new com.tencent.mm.ui.widget.b.a(this.PhN.Pwc.getContext());
      this.wnj.QSv = true;
      this.PHl = paramView.getTag(2131308867);
      int[] arrayOfInt;
      ca localca;
      if (((this.PHl instanceof Boolean)) && (((Boolean)this.PHl).booleanValue()))
      {
        if (com.tencent.mm.ui.a.a.a.gKe().gKc())
        {
          this.wnj.QSB = true;
          this.wnj.QSy = true;
          this.wnj.QSC = true;
        }
      }
      else
      {
        this.wnj.QwU = this.afJ;
        if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).qcr) && (this.PGP != null)) {
          this.PGP.dismiss();
        }
        arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        localca = ((bq)localObject).dTX;
        if (((!localca.gDy()) && (!localca.gDq()) && (!localca.isText())) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch())) {
          break label505;
        }
        if (!com.tencent.mm.model.ab.Eq(localca.field_talker)) {
          break label355;
        }
        localObject = bp.Kq(localca.field_content);
        label286:
        if ((!localca.gDq()) && (!localca.gDy())) {
          break label365;
        }
        localObject = k.b.HD((String)localObject);
        if (localObject == null) {
          break label598;
        }
        localObject = ((k.b)localObject).title;
      }
      for (;;)
      {
        if (Util.isNullOrNil((String)localObject))
        {
          AppMethodBeat.o(233547);
          return;
          this.wnj.QSB = false;
          this.wnj.QSy = false;
          break;
          label355:
          localObject = localca.field_content;
          break label286;
          label365:
          continue;
        }
        String str1;
        if (((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch())
        {
          str1 = ((com.tencent.mm.plugin.box.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord((String)localObject);
          if (!Util.isNullOrNil(str1)) {
            c.this.a(this.wnj, this.PhN, str1);
          }
        }
        for (;;)
        {
          if (Util.isNullOrNil(str1)) {
            this.wnj.QSA = null;
          }
          String str2 = "34_" + cl.aWA();
          c localc = c.this;
          com.tencent.mm.ui.chatting.e.a locala = this.PhN;
          if (!Util.isNullOrNil(str1)) {}
          for (boolean bool = true;; bool = false)
          {
            localc.a(locala, localca, 1, bool, (String)localObject, false, str2);
            label505:
            int i = arrayOfInt[0];
            int j = (int)(paramView.getWidth() / 2.0F);
            int k = arrayOfInt[1];
            this.wnj.a(paramView, this.PHg, this.PHh, i + j, k);
            if (this.PhN != null)
            {
              this.PhN.setFocused(false);
              this.PhN.BX(false);
              this.PhN.Pwj = false;
            }
            AppMethodBeat.o(233547);
            return;
          }
          str1 = "";
        }
        label598:
        localObject = "";
      }
    }
    
    final void closeContextMenu()
    {
      AppMethodBeat.i(233548);
      if ((this.wnj != null) && (this.wnj.gNq())) {
        this.wnj = null;
      }
      AppMethodBeat.o(233548);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(36742);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      if ((paramView.getTag(2131309367) instanceof int[]))
      {
        paramView.getTag(2131309367);
        gK(paramView);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(36742);
        return true;
        if (((this.ppd == 0) && (this.ppe == 0)) || (!this.PHi.equals(paramView))) {
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
          gK(paramView);
        }
      }
    }
    
    final void openContextMenu(View paramView)
    {
      AppMethodBeat.i(233546);
      gK(paramView);
      AppMethodBeat.o(233546);
    }
    
    final class a
      implements o.g
    {
      public bq PHo;
      
      a() {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(36740);
        if (this.PHo == null)
        {
          Log.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
          AppMethodBeat.o(36740);
          return;
        }
        if (((c.this instanceof bd.a)) || ((c.this instanceof bd.b))) {
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.PHo);
        }
        for (;;)
        {
          ((ae)c.c.b(c.c.this).bh(ae.class)).a(paramMenuItem, c.this);
          c.c.e(c.c.this, paramMenuItem.getItemId());
          c.c.d(c.c.this, paramInt);
          if (c.c.c(c.c.this) != null) {
            c.c.c(c.c.this).dismiss();
          }
          AppMethodBeat.o(36740);
          return;
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.PHo.dTX);
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
    c.c PGO;
    
    e(c.c paramc)
    {
      this.PGO = paramc;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(36749);
      this.PGO.closeContextMenu();
      AppMethodBeat.o(36749);
    }
    
    public final void ea(View paramView)
    {
      AppMethodBeat.i(36750);
      this.PGO.onLongClick(paramView);
      AppMethodBeat.o(36750);
    }
    
    public final void gL(View paramView)
    {
      AppMethodBeat.i(36748);
      this.PGO.openContextMenu(paramView);
      AppMethodBeat.o(36748);
    }
    
    public final void gTY()
    {
      AppMethodBeat.i(179940);
      c.c localc = this.PGO;
      if (localc.PhN != null) {
        localc.PhN.BX(true);
      }
      AppMethodBeat.o(179940);
    }
    
    public final void gTZ()
    {
      AppMethodBeat.i(179941);
      c.c localc = this.PGO;
      if (localc.PhN != null) {
        localc.PhN.BX(false);
      }
      AppMethodBeat.o(179941);
    }
    
    public final void gUa()
    {
      AppMethodBeat.i(179942);
      c.c localc = this.PGO;
      if (localc.PhN != null) {
        localc.PhN.setFocused(false);
      }
      AppMethodBeat.o(179942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */