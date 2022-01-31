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
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cu.a;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.or.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.x;
import com.tencent.mm.ui.chatting.s.a;
import com.tencent.mm.ui.chatting.s.b;
import com.tencent.mm.ui.chatting.s.c;
import com.tencent.mm.ui.chatting.s.d;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.h;
import com.tencent.mm.ui.chatting.s.k;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.chatting.s.p;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import java.util.Map;

public abstract class c
{
  private static long zKL = 0L;
  private static boolean zRk = false;
  protected boolean kFs;
  private c.c zRl;
  private a.f zRm;
  private c.d zRn;
  private boolean zRo = false;
  protected s.b zRp;
  protected s.d zRq;
  protected s.c zRr;
  protected s.p zRs;
  protected s.h zRt;
  protected s.k zRu;
  protected s.e zRv;
  private final long zRw = 120000L;
  public boolean zvB;
  
  public static String a(bi parambi, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (parambi == null) {
      return str2;
    }
    if (parambi.field_isSend == 1) {
      return r.Zn();
    }
    if (paramBoolean1) {
      str1 = bf.pu(parambi.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!bo.isNullOrNil(str1)) {
        break;
      }
      return parambi.field_talker;
      if (paramBoolean2) {
        str1 = parambi.field_bizChatUserId;
      }
    }
  }
  
  public static void a(bi parambi, EmojiInfo paramEmojiInfo)
  {
    cu localcu = new cu();
    localcu.cql.cqm = paramEmojiInfo;
    paramEmojiInfo = localcu.cql.cqm;
    if (parambi != null) {}
    for (parambi = parambi.field_talker;; parambi = null)
    {
      paramEmojiInfo.talker = parambi;
      localcu.cql.scene = 0;
      com.tencent.mm.sdk.b.a.ymk.l(localcu);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, bi parambi, j.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.g.alp(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.dJG()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.cEG = "message";
      locala.bYA = paramString;
      locala.cFh = d(parama, parambi);
      locala.vYV = paramb.type;
      locala.scene = i;
      locala.vYW = paramb.mediaTagName;
      locala.cFn = paramLong;
      locala.vYX = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.h)parama.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHk());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.g.alp(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.cEG = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.zJz.getMMResources().getDimension(2131427862);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.zJz.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.zJz.getMMResources(), 2130839824));
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.zJz.getMMResources().getDimension(2131427862);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.zJz.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.zJz.getMMResources(), 2130839824));
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, j.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.f paramf, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    or localor;
    or.a locala;
    if (parama.dJG())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label226;
        }
        if ((paramf == null) || (!p.u(parama.zJz.getContext(), paramf.field_packageName))) {
          break label219;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label232;
      }
      i = 4;
      localor = new or();
      localor.cFl.context = parama.zJz.getContext();
      localor.cFl.scene = j;
      localor.cFl.cwc = paramb.appId;
      locala = localor.cFl;
      if (paramf != null) {
        break label246;
      }
    }
    label219:
    label226:
    label232:
    label246:
    for (parama = null;; parama = paramf.field_packageName)
    {
      locala.packageName = parama;
      localor.cFl.msgType = paramb.type;
      localor.cFl.czp = paramString1;
      localor.cFl.cFm = i;
      localor.cFl.mediaTagName = paramb.mediaTagName;
      localor.cFl.cFn = paramLong;
      localor.cFl.cFo = "";
      localor.cFl.cmF = paramString2;
      com.tencent.mm.sdk.b.a.ymk.l(localor);
      return;
      j = 1;
      break;
      i = 6;
      break label53;
      i = 3;
      break label53;
      if (paramb.type != 5) {
        break label64;
      }
      i = 1;
      break label64;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, j.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.f paramf, long paramLong, String paramString2)
  {
    a(parama, paramb, paramString1, paramf, paramLong, -1, paramString2);
  }
  
  private void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, bi parambi)
  {
    if (this.zRo) {}
    do
    {
      return;
      this.zRo = true;
    } while ((parama1.zJz instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI));
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dGZ))) {
      this.zRp = new s.a(parama1);
    }
    for (;;)
    {
      parama.zRz.setOnClickListener(this.zRp);
      parama.zRz.setOnLongClickListener(this.zRq);
      return;
      this.zRp = new s.b(parama1);
      this.zRq = new s.d(parama1);
    }
  }
  
  protected static void a(c.a parama, CharSequence paramCharSequence)
  {
    if ((parama == null) || (parama.qFY == null)) {
      return;
    }
    if (paramCharSequence == null)
    {
      parama.qFY.setVisibility(8);
      return;
    }
    parama.qFY.setText(paramCharSequence);
    parama.qFY.setVisibility(0);
  }
  
  protected static boolean a(bi parambi, com.tencent.mm.ui.chatting.d.a parama)
  {
    long l = parambi.field_createTime;
    int i;
    if (cb.abq() - l > 120000L)
    {
      i = 1;
      if (i == 0) {
        break label30;
      }
    }
    label30:
    do
    {
      do
      {
        return false;
        i = 0;
        break;
      } while ((parama != null) && (parama.getTalkerUserName().equals(parama.dJD())) && (parambi.field_status == 2));
      i = com.tencent.mm.m.g.Nq().getInt("ShowRevokeMsgEntry", 1);
      ab.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    } while (1 != i);
    return true;
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.c.b.h paramh, long paramLong)
  {
    return (paramLong > 0L) && (paramh.dHm() == paramLong);
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.pluginsdk.model.app.f paramf)
  {
    b localb = b.a.bEX();
    if ((!com.tencent.mm.pluginsdk.model.app.g.a(parama.zJz.getContext(), paramf)) && (localb != null))
    {
      if (!bo.isNullOrNil(paramf.djP))
      {
        boolean bool = com.tencent.mm.pluginsdk.model.app.q.bw(parama.zJz.getContext(), paramf.djP);
        ab.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramf.djP, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.dJG()) {}
      for (int i = 2;; i = 1)
      {
        gu localgu = new gu();
        localgu.cvL.actionCode = 2;
        localgu.cvL.scene = i;
        localgu.cvL.appId = paramf.field_appId;
        localgu.cvL.context = parama.zJz.getContext();
        com.tencent.mm.sdk.b.a.ymk.l(localgu);
        parama.zJz.getContext();
        localb.ag(paramf.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  protected static boolean auk(String paramString)
  {
    return ((!com.tencent.mm.model.t.og(paramString)) && (!com.tencent.mm.model.t.ow(paramString)) && (!com.tencent.mm.model.t.nU(paramString)) && (!com.tencent.mm.model.t.oE(paramString))) || (com.tencent.mm.model.t.lA(paramString));
  }
  
  protected static void b(com.tencent.mm.ui.chatting.d.a parama, j.b paramb, bi parambi)
  {
    b localb = b.a.bEX();
    if (localb != null) {
      if (!parama.dJG()) {
        break label65;
      }
    }
    label65:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, parambi);
      parama.zJz.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, parambi.field_msgSvrId, parama.getTalkerUserName());
      return;
    }
  }
  
  protected static String c(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    parambi = parambi.field_talker;
    parama = (com.tencent.mm.ui.chatting.c.b.d)parama.ay(com.tencent.mm.ui.chatting.c.b.d.class);
    if ((parama.dHv()) && (parama.dHt() != null)) {
      return parama.dHt().field_bizChatServId;
    }
    return parambi;
  }
  
  protected static void c(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.h)parama.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHl());
  }
  
  public static String d(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (com.tencent.mm.model.t.lA(str)) {
      parama = bf.pu(parambi.field_content);
    }
    return parama;
  }
  
  protected static boolean dF(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.g.dF(paramString);
  }
  
  protected static boolean dLr()
  {
    String str = com.tencent.mm.m.g.Nq().getValue("ShowSendOK");
    if (bo.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = bo.apV(str)) {
      return true;
    }
    return false;
  }
  
  private s.c g(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.zRr == null) {
      this.zRr = new s.c(parama);
    }
    return this.zRr;
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, true);
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
      ab.printErrStackTrace("MicroMsg.ChattingItem", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static int in(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.dr(paramContext);
    if (f == com.tencent.mm.cb.a.gf(paramContext)) {
      return com.tencent.mm.cb.a.ap(paramContext, 2131428228);
    }
    if (f == com.tencent.mm.cb.a.gh(paramContext)) {
      return com.tencent.mm.cb.a.ap(paramContext, 2131428221);
    }
    if (f == com.tencent.mm.cb.a.gi(paramContext)) {
      return com.tencent.mm.cb.a.ap(paramContext, 2131428229);
    }
    if (f == com.tencent.mm.cb.a.gj(paramContext)) {
      return com.tencent.mm.cb.a.ap(paramContext, 2131428211);
    }
    if ((f == com.tencent.mm.cb.a.gk(paramContext)) || (f == com.tencent.mm.cb.a.gl(paramContext)) || (f == com.tencent.mm.cb.a.gm(paramContext))) {
      return com.tencent.mm.cb.a.ap(paramContext, 2131428212);
    }
    return com.tencent.mm.cb.a.ap(paramContext, 2131428227);
  }
  
  public static int io(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.dr(paramContext);
    if ((f != com.tencent.mm.cb.a.gf(paramContext)) && (f != com.tencent.mm.cb.a.gh(paramContext)))
    {
      if (f == com.tencent.mm.cb.a.gi(paramContext)) {
        return com.tencent.mm.cb.a.ap(paramContext, 2131428210);
      }
      if (f == com.tencent.mm.cb.a.gj(paramContext)) {
        return com.tencent.mm.cb.a.ap(paramContext, 2131428208);
      }
      if ((f == com.tencent.mm.cb.a.gk(paramContext)) || (f == com.tencent.mm.cb.a.gl(paramContext)) || (f == com.tencent.mm.cb.a.gm(paramContext))) {
        return com.tencent.mm.cb.a.ap(paramContext, 2131428212);
      }
    }
    return com.tencent.mm.cb.a.ap(paramContext, 2131428209);
  }
  
  public static void w(ImageView paramImageView, String paramString)
  {
    if (bo.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2130838493);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.c(paramImageView, paramString);
  }
  
  public static void x(ImageView paramImageView, String paramString)
  {
    if (bo.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2130838028);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.s(paramImageView, paramString);
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final a.f a(c.c paramc)
  {
    if (this.zRm == null) {
      this.zRm = new c.e(paramc);
    }
    return this.zRm;
  }
  
  protected final void a(int paramInt, c.a parama, bi parambi, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.d.a parama1, s.n paramn)
  {
    if (parambi.field_isSend == 1)
    {
      parama.zRC.setTag(new az(parambi, paramBoolean, paramInt, paramString, '\000'));
      paramString = parama.zRC;
      if (this.zRv == null) {
        this.zRv = new c.1(this, parama1, paramn);
      }
      paramString.setOnClickListener(this.zRv);
      switch (parambi.field_status)
      {
      default: 
        ab.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
        paramInt = -1;
      }
    }
    while (paramInt != -1)
    {
      parama.zRC.setImageResource(2130840452);
      parama.zRC.setVisibility(0);
      parama.zRC.setContentDescription(ah.getContext().getString(2131301639));
      if (parama.pNd != null) {
        parama.pNd.setVisibility(8);
      }
      return;
      paramInt = -1;
      continue;
      paramInt = 2130840452;
    }
    parama.zRC.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, bi parambi)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ab.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (at.isMobile(parama.zJz.getContext()))
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
      paramString1.putExtra("pre_username", b(parama, parambi));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambi != null) {
        paramString1.putExtra("preUsername", b(parama, parambi));
      }
      paramString1.putExtra("preChatName", parama.getTalkerUserName());
      paramString1.putExtra("preChatTYPE", u.ah(b(parama, parambi), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
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
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi)
  {
    long l1 = zKL;
    long l2 = System.currentTimeMillis();
    zKL = l2;
    if (l1 + 30000L < l2)
    {
      aw.aaz();
      zRk = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.kFs = zRk;
    String str = null;
    if (dLo())
    {
      str = b(parama1, parambi);
      a(parama, parama1, parambi, str);
      a(parama, parama1, str, parambi);
    }
    a(parama, paramInt, parama1, parambi, str);
  }
  
  public abstract void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString);
  
  protected void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    if ((paramString == null) || (parama.qFY == null) || (parambi == null)) {
      return;
    }
    String str;
    if ((parambi.field_isSend == 0) && (!bo.isNullOrNil(parambi.dGZ)))
    {
      com.tencent.mm.aj.g localg = z.afh().sb(parambi.dGZ);
      int i = 1;
      if ((localg != null) && (!bo.isNullOrNil(localg.field_openId)) && (!bo.isNullOrNil(localg.field_nickname)))
      {
        str = localg.field_nickname;
        i = 0;
        if (i == 0)
        {
          paramString = str;
          if (!i.a(localg)) {}
        }
        else
        {
          z.afj().a(new c.b(parama1, parambi.dGZ));
          z.afj().aC(parama1.getTalkerUserName(), parambi.dGZ);
          paramString = str;
        }
      }
    }
    for (;;)
    {
      a(parama, paramString);
      return;
      ab.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
      str = null;
      break;
      if ((b(parama1)) && (((com.tencent.mm.ui.chatting.c.b.f)parama1.ay(com.tencent.mm.ui.chatting.c.b.f.class)).dHN()))
      {
        if (((com.tencent.mm.ui.chatting.c.b.d)parama1.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw())
        {
          parambi = ((com.tencent.mm.ui.chatting.c.b.f)parama1.ay(com.tencent.mm.ui.chatting.c.b.f.class)).atS(parambi.field_bizChatUserId);
          paramString = j.b(parama1.zJz.getContext(), parambi, parama.qFY.getTextSize());
        }
        else
        {
          parambi = ((com.tencent.mm.ui.chatting.c.b.f)parama1.ay(com.tencent.mm.ui.chatting.c.b.f.class)).atS(paramString);
          paramString = j.b(parama1.zJz.getContext(), parambi, parama.qFY.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, String paramString, bi parambi)
  {
    Object localObject = null;
    if (parama.zRz == null) {
      return;
    }
    if ((com.tencent.mm.model.t.oD(paramString)) && (!paramString.equals(com.tencent.mm.model.t.fll[0])))
    {
      parama.zRz.setVisibility(8);
      return;
    }
    if ((parambi != null) && (!bo.isNullOrNil(parambi.dGZ))) {
      if (parama1.dJG()) {
        localObject = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject = new az(paramString, (String)localObject);
      ((az)localObject).zYJ = parambi.dGZ;
      com.tencent.mm.pluginsdk.ui.a.b.f(parama.zRz, parambi.dGZ, 2130837924);
      label106:
      parama.zRz.setVisibility(0);
      parama.zRz.setTag(localObject);
      a(parama, parama1, parambi);
      if (!dLp())
      {
        ((x)parama1.ay(x.class)).a(parama.zRz);
        parama.zRz.setOnDoubleClickListener(g(parama1));
      }
      com.tencent.mm.ui.chatting.q.eP(parama.zRz);
      parama.zRz.setContentDescription(s.nE(paramString) + parama1.zJz.getContext().getString(2131297217));
      parama.zRz.dw(paramString, 5);
      if (parama.zRA == null) {
        break;
      }
      if ((parambi != null) && (parambi.dns != null) && (parambi.dns.contains("watch_msg_source_type")))
      {
        parama1 = (String)br.F(parambi.dns, "msgsource").get(".msgsource.watch_msg_source_type");
        try
        {
          i = Integer.valueOf(parama1).intValue();
          if ((i > 0) && (i <= 4))
          {
            parama.zRA.setVisibility(0);
            return;
            localObject = null;
            continue;
            if ((parambi != null) && (((com.tencent.mm.ui.chatting.c.b.d)parama1.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv()))
            {
              localObject = new az(parambi.field_bizChatUserId, null);
              com.tencent.mm.ui.chatting.c.b.d locald = (com.tencent.mm.ui.chatting.c.b.d)parama1.ay(com.tencent.mm.ui.chatting.c.b.d.class);
              o.ahG().a(locald.sp(parambi.field_bizChatUserId), parama.zRz, ((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHn());
              break label106;
            }
            if ((parambi != null) && (parambi.field_isSend == 0) && (parama1.ay(com.tencent.mm.ui.chatting.c.b.a.class) != null) && (!bo.isNullOrNil(((com.tencent.mm.ui.chatting.c.b.a)parama1.ay(com.tencent.mm.ui.chatting.c.b.a.class)).dJA())))
            {
              localObject = new az(paramString, null);
              o.ahG().a(((com.tencent.mm.ui.chatting.c.b.a)parama1.ay(com.tencent.mm.ui.chatting.c.b.a.class)).dJA(), parama.zRz, ((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHn());
              break label106;
            }
            if (parama1.dJG()) {
              localObject = parama1.getTalkerUserName();
            }
            localObject = new az(paramString, (String)localObject);
            w(parama.zRz, paramString);
          }
        }
        catch (Exception parama1)
        {
          for (;;)
          {
            int i = 0;
          }
          parama.zRA.setVisibility(8);
          return;
        }
      }
    }
    parama.zRA.setVisibility(8);
  }
  
  public abstract boolean a(ContextMenu paramContextMenu, View paramView, bi parambi);
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi);
  
  public final boolean a(com.tencent.mm.ui.chatting.d.a parama, j.b paramb, bi parambi)
  {
    if (bo.isNullOrNil(paramb.fiO)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.zuZ, parambi, paramb.fiV, paramb.fiU);
    String str = parambi.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.fiO);
    localIntent.putExtra("KThumUrl", paramb.fiT);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.fiU);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.fiV);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.dJG())
    {
      i = com.tencent.mm.ui.chatting.a.b.zvi.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", b(parama, parambi));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", parambi.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.cGU);
      if (parama.dJG()) {
        localIntent.putExtra("KSta_ChatroomMembercount", n.nv(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + parambi.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.fiP);
      localIntent.putExtra("StremWebUrl", paramb.fiS);
      localIntent.putExtra("StreamWording", paramb.fiR);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRW, 0) <= 0) {
        break label370;
      }
      com.tencent.mm.bq.d.b(parama.zJz.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ab.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.zvh.value;
      break;
      label370:
      com.tencent.mm.bq.d.b(parama.zJz.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public abstract boolean aK(int paramInt, boolean paramBoolean);
  
  public String b(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    Object localObject;
    if (dLp()) {
      localObject = parama.dJD();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.dJG())
    {
      parama = bf.pu(parambi.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label76;
      }
    }
    for (;;)
    {
      return parama;
      if (parambi != null) {
        parama = parambi.field_bizChatUserId;
      } else {
        label76:
        parama = str;
      }
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.zRt == null) {
      this.zRt = new s.h(parama);
    }
    paramView.setOnClickListener(this.zRt);
  }
  
  public abstract boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi);
  
  protected boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (dLp()) {
      return false;
    }
    return (parama.dJG()) || (((com.tencent.mm.ui.chatting.c.b.d)parama.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv());
  }
  
  protected final c.c c(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.zRl == null) {
      this.zRl = new c.c(this, parama);
    }
    return this.zRl;
  }
  
  protected final c.d d(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.zRn == null)
    {
      if (!(parama.zJz instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.zJz;
    }
    label47:
    for (this.zRn = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.caz, this);; this.zRn = new c.d(parama, this)) {
      return this.zRn;
    }
  }
  
  protected boolean dLo()
  {
    return true;
  }
  
  abstract boolean dLp();
  
  boolean dLq()
  {
    return true;
  }
  
  protected boolean dLs()
  {
    return true;
  }
  
  protected final s.b e(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.zRp == null) {
      this.zRp = new s.b(parama);
    }
    return this.zRp;
  }
  
  protected final s.d f(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.zRq == null) {
      this.zRq = new s.d(parama);
    }
    return this.zRq;
  }
  
  protected final s.p h(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.zRs == null) {
      this.zRs = new s.p(parama);
    }
    return this.zRs;
  }
  
  protected final s.k i(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.zRu == null) {
      this.zRu = new s.k(parama);
    }
    return this.zRu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */