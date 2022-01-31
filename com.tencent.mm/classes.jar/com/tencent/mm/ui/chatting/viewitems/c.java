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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.i;
import com.tencent.mm.ai.z;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cr;
import com.tencent.mm.h.a.cr.a;
import com.tencent.mm.h.a.gq;
import com.tencent.mm.h.a.nr;
import com.tencent.mm.h.a.nr.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.6;
import com.tencent.mm.ui.chatting.t.a;
import com.tencent.mm.ui.chatting.t.b;
import com.tencent.mm.ui.chatting.t.c;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.chatting.t.g;
import com.tencent.mm.ui.chatting.t.j;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.chatting.t.o;
import java.util.Map;

public abstract class c
{
  private static boolean vAL = false;
  private static long vuK = 0L;
  protected boolean khG;
  private c.c vAM;
  private c.d vAN;
  private boolean vAO = false;
  protected t.b vAP;
  protected t.c vAQ;
  protected t.o vAR;
  protected t.g vAS;
  protected t.j vAT;
  protected t.d vAU;
  private final long vAV = 120000L;
  public boolean vgB;
  
  public static String a(bi parambi, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (parambi == null) {
      return str2;
    }
    if (parambi.field_isSend == 1) {
      return com.tencent.mm.model.q.Gj();
    }
    if (paramBoolean1) {
      str1 = bd.iI(parambi.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!bk.bl(str1)) {
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
    cr localcr = new cr();
    localcr.bIQ.bIR = paramEmojiInfo;
    paramEmojiInfo = localcr.bIQ.bIR;
    if (parambi != null) {}
    for (parambi = parambi.field_talker;; parambi = null)
    {
      paramEmojiInfo.talker = parambi;
      localcr.bIQ.scene = 0;
      com.tencent.mm.sdk.b.a.udP.m(localcr);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.c.a parama, View paramView, bi parambi, g.a parama1, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.g.VR(parama1.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.cFE()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = parama1.appId;
      locala.bWQ = "message";
      locala.bwQ = paramString;
      locala.bXl = d(parama, parambi);
      locala.sgD = parama1.type;
      locala.scene = i;
      locala.sgE = parama1.mediaTagName;
      locala.bXr = paramLong;
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.c.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g)parama.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDw());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.c.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.g.VR(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.bWQ = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.c.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.vtz.getMMResources().getDimension(R.f.SmallestTextSize);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.c.a parama, ImageView paramImageView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.vtz.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.vtz.getMMResources(), R.g.nosdcard_watermark_icon));
  }
  
  private static void a(com.tencent.mm.ui.chatting.c.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.vtz.getMMResources().getDimension(R.f.SmallestTextSize);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.c.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.g.b(paramString, 2, com.tencent.mm.cb.a.getDensity(parama.vtz.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.vtz.getMMResources(), R.g.nosdcard_watermark_icon));
  }
  
  protected static void a(com.tencent.mm.ui.chatting.c.a parama, g.a parama1, bi parambi, f paramf)
  {
    com.tencent.mm.plugin.game.a.a locala = com.tencent.mm.plugin.game.a.a.a.aYi();
    int i;
    Activity localActivity;
    String str;
    if (locala != null)
    {
      if (!parama.cFE()) {
        break label71;
      }
      i = 2;
      parambi = d(parama, parambi);
      localActivity = parama.vtz.getContext();
      str = parama1.appId;
      if (paramf != null) {
        break label77;
      }
    }
    label71:
    label77:
    for (parama = null;; parama = paramf.field_packageName)
    {
      locala.a(localActivity, str, parama, parambi, parama1.type, parama1.mediaTagName, i);
      return;
      i = 1;
      break;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.c.a parama, g.a parama1, String paramString, f paramf, long paramLong)
  {
    a(parama, parama1, paramString, paramf, paramLong, -1);
  }
  
  public static void a(com.tencent.mm.ui.chatting.c.a parama, g.a parama1, String paramString, f paramf, long paramLong, int paramInt)
  {
    int j;
    int i;
    label53:
    label64:
    nr localnr;
    nr.a locala;
    if (parama.cFE())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (parama1.type != 7) {
          break label216;
        }
        if ((paramf == null) || (!p.o(parama.vtz.getContext(), paramf.field_packageName))) {
          break label209;
        }
        i = 0;
      }
      if (parama1.type != 2) {
        break label222;
      }
      i = 4;
      localnr = new nr();
      localnr.bXp.context = parama.vtz.getContext();
      localnr.bXp.scene = j;
      localnr.bXp.bOL = parama1.appId;
      locala = localnr.bXp;
      if (paramf != null) {
        break label236;
      }
    }
    label209:
    label216:
    label222:
    label236:
    for (parama = null;; parama = paramf.field_packageName)
    {
      locala.packageName = parama;
      localnr.bXp.msgType = parama1.type;
      localnr.bXp.bRO = paramString;
      localnr.bXp.bXq = i;
      localnr.bXp.mediaTagName = parama1.mediaTagName;
      localnr.bXp.bXr = paramLong;
      localnr.bXp.bXs = "";
      com.tencent.mm.sdk.b.a.udP.m(localnr);
      return;
      j = 1;
      break;
      i = 6;
      break label53;
      i = 3;
      break label53;
      if (parama1.type != 5) {
        break label64;
      }
      i = 1;
      break label64;
    }
  }
  
  protected static void a(c.a parama, CharSequence paramCharSequence)
  {
    if ((parama == null) || (parama.nSa == null)) {
      return;
    }
    if (paramCharSequence == null)
    {
      parama.nSa.setVisibility(8);
      return;
    }
    parama.nSa.setText(paramCharSequence);
    parama.nSa.setVisibility(0);
  }
  
  protected static boolean a(bi parambi, com.tencent.mm.ui.chatting.c.a parama)
  {
    long l = parambi.field_createTime;
    int i;
    if (bz.It() - l > 120000L)
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
      } while ((parama != null) && (parama.getTalkerUserName().equals(parama.cFB())) && (parambi.field_status == 2));
      i = com.tencent.mm.m.g.AA().getInt("ShowRevokeMsgEntry", 1);
      y.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    } while (1 != i);
    return true;
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.b.b.g paramg, long paramLong)
  {
    return (paramLong > 0L) && (paramg.cDy() == paramLong);
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.c.a parama, f paramf)
  {
    com.tencent.mm.plugin.game.a.a locala = com.tencent.mm.plugin.game.a.a.a.aYi();
    if ((!com.tencent.mm.pluginsdk.model.app.g.a(parama.vtz.getContext(), paramf)) && (locala != null))
    {
      if (!bk.bl(paramf.cvE))
      {
        boolean bool = com.tencent.mm.pluginsdk.model.app.q.bk(parama.vtz.getContext(), paramf.cvE);
        y.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramf.cvE, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.cFE()) {}
      for (int i = 2;; i = 1)
      {
        gq localgq = new gq();
        localgq.bOu.actionCode = 2;
        localgq.bOu.scene = i;
        localgq.bOu.appId = paramf.field_appId;
        localgq.bOu.context = parama.vtz.getContext();
        com.tencent.mm.sdk.b.a.udP.m(localgq);
        parama.vtz.getContext();
        locala.S(paramf.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  protected static boolean adG(String paramString)
  {
    return ((!s.hx(paramString)) && (!s.hN(paramString)) && (!s.hl(paramString)) && (!s.hV(paramString))) || (s.fn(paramString));
  }
  
  protected static void b(com.tencent.mm.ui.chatting.c.a parama, g.a parama1, bi parambi)
  {
    com.tencent.mm.plugin.game.a.a locala = com.tencent.mm.plugin.game.a.a.a.aYi();
    if (locala != null) {
      if (!parama.cFE()) {
        break label61;
      }
    }
    label61:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, parambi);
      parama.vtz.getContext();
      locala.a(parama1.appId, str, parama1.type, i, parama1.mediaTagName, parambi.field_msgSvrId);
      return;
    }
  }
  
  protected static String c(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    parambi = parambi.field_talker;
    parama = (com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class);
    if ((parama.cDG()) && (parama.cDE() != null)) {
      return parama.cDE().field_bizChatServId;
    }
    return parambi;
  }
  
  protected static void c(com.tencent.mm.ui.chatting.c.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.b.b.g)parama.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDx());
  }
  
  protected static boolean cHc()
  {
    String str = com.tencent.mm.m.g.AA().getValue("ShowSendOK");
    if (bk.bl(str)) {}
    for (int i = 0; 1 == i; i = bk.ZR(str)) {
      return true;
    }
    return false;
  }
  
  protected static boolean ct(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.g.ct(paramString);
  }
  
  public static String d(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (s.fn(str)) {
      parama = bd.iI(parambi.field_content);
    }
    return parama;
  }
  
  public static int gS(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.cJ(paramContext);
    if (f == 0.875F) {
      return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_small_item_width);
    }
    if (f == 1.125F) {
      return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_large_item_width);
    }
    if (f == 1.25F) {
      return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_super_item_width);
    }
    if (f == 1.375F) {
      return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_huge_item_width);
    }
    if ((f == 1.625F) || (f == 1.875F) || (f == 2.025F)) {
      return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_huger_item_width);
    }
    return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_normal_item_width);
  }
  
  public static int gT(Context paramContext)
  {
    float f = com.tencent.mm.cb.a.cJ(paramContext);
    if ((f != 0.875F) && (f != 1.125F))
    {
      if (f == 1.25F) {
        return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_custom_super_item_width);
      }
      if (f == 1.375F) {
        return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_custom_huge_item_width);
      }
      if ((f == 1.625F) || (f == 1.875F) || (f == 2.025F)) {
        return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_huger_item_width);
      }
    }
    return com.tencent.mm.cb.a.ab(paramContext, R.f.chatting_custom_item_width);
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.by(paramString, true);
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
      y.printErrStackTrace("MicroMsg.ChattingItem", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static void r(ImageView paramImageView, String paramString)
  {
    if (bk.bl(paramString))
    {
      paramImageView.setImageResource(R.g.default_avatar);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.a(paramImageView, paramString);
  }
  
  public static void s(ImageView paramImageView, String paramString)
  {
    if (bk.bl(paramString))
    {
      paramImageView.setImageResource(R.g.brand_default_head);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.n(paramImageView, paramString);
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, View paramView);
  
  protected final void a(int paramInt, c.a parama, bi parambi, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.c.a parama1, t.m paramm)
  {
    if (parambi.field_isSend == 1)
    {
      parama.vBa.setTag(new aw(parambi, paramBoolean, paramInt, paramString, '\000'));
      paramString = parama.vBa;
      if (this.vAU == null) {
        this.vAU = new c.1(this, parama1, paramm);
      }
      paramString.setOnClickListener(this.vAU);
      switch (parambi.field_status)
      {
      default: 
        y.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
        paramInt = -1;
      }
    }
    while (paramInt != -1)
    {
      parama.vBa.setImageResource(paramInt);
      parama.vBa.setVisibility(0);
      parama.vBa.setContentDescription(ae.getContext().getString(R.l.msg_fail_resend));
      if (parama.nhQ != null) {
        parama.nhQ.setVisibility(8);
      }
      return;
      paramInt = -1;
      continue;
      paramInt = R.g.state_failed;
    }
    parama.vBa.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.chatting.c.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, bi parambi)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      y.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (aq.isMobile(parama.vtz.getContext()))
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
      paramString1.putExtra("preChatTYPE", t.R(b(parama, parambi), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
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
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi)
  {
    long l1 = vuK;
    long l2 = System.currentTimeMillis();
    vuK = l2;
    if (l1 + 30000L < l2)
    {
      au.Hx();
      vAL = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.khG = vAL;
    String str = null;
    if (cHb())
    {
      str = b(parama1, parambi);
      a(parama, parama1, parambi, str);
      a(parama, parama1, str, parambi);
    }
    a(parama, paramInt, parama1, parambi, str);
  }
  
  public abstract void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString);
  
  protected void a(c.a parama, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    if ((paramString == null) || (parama.nSa == null) || (parambi == null)) {
      return;
    }
    String str;
    if ((parambi.field_isSend == 0) && (!bk.bl(parambi.cQN)))
    {
      com.tencent.mm.ai.g localg = z.Mx().lg(parambi.cQN);
      int i = 1;
      if ((localg != null) && (!bk.bl(localg.field_openId)) && (!bk.bl(localg.field_nickname)))
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
          z.Mz().a(new c.b(parama1, parambi.cQN));
          z.Mz().am(parama1.getTalkerUserName(), parambi.cQN);
          paramString = str;
        }
      }
    }
    for (;;)
    {
      a(parama, paramString);
      return;
      y.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
      str = null;
      break;
      if ((b(parama1)) && (((com.tencent.mm.ui.chatting.b.b.e)parama1.ac(com.tencent.mm.ui.chatting.b.b.e.class)).cDX()))
      {
        if (((com.tencent.mm.ui.chatting.b.b.c)parama1.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH())
        {
          parambi = ((com.tencent.mm.ui.chatting.b.b.e)parama1.ac(com.tencent.mm.ui.chatting.b.b.e.class)).adr(parambi.field_bizChatUserId);
          paramString = j.a(parama1.vtz.getContext(), parambi, parama.nSa.getTextSize());
        }
        else
        {
          parambi = ((com.tencent.mm.ui.chatting.b.b.e)parama1.ac(com.tencent.mm.ui.chatting.b.b.e.class)).adr(paramString);
          paramString = j.a(parama1.vtz.getContext(), parambi, parama.nSa.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.c.a parama1, String paramString, bi parambi)
  {
    Object localObject = null;
    if (parama.doU == null) {
      return;
    }
    if ((s.hU(paramString)) && (!paramString.equals(s.dVc[0])))
    {
      parama.doU.setVisibility(8);
      return;
    }
    if ((parambi != null) && (!bk.bl(parambi.cQN))) {
      if (parama1.cFE()) {
        localObject = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject = new aw(paramString, (String)localObject);
      ((aw)localObject).vHn = parambi.cQN;
      com.tencent.mm.pluginsdk.ui.a.b.g(parama.doU, parambi.cQN, R.g.biz_kf_default_avatar);
      label106:
      parama.doU.setVisibility(0);
      parama.doU.setTag(localObject);
      if (!this.vAO)
      {
        this.vAO = true;
        if (!(parama1.vtz instanceof AppBrandServiceChattingUI.a))
        {
          if ((parambi == null) || (bk.bl(parambi.cQN))) {
            break label459;
          }
          this.vAP = new t.a(parama1);
          parama.doU.setOnClickListener(this.vAP);
          parama.doU.setOnLongClickListener(this.vAQ);
        }
      }
      com.tencent.mm.ui.chatting.r.dG(parama.doU);
      parama.doU.setContentDescription(com.tencent.mm.model.r.gV(paramString) + parama1.vtz.getContext().getString(R.l.avatar_desc));
      if (parama.vAY == null) {
        break;
      }
      if ((parambi != null) && (parambi.czr != null) && (parambi.czr.contains("watch_msg_source_type")))
      {
        parama1 = (String)bn.s(parambi.czr, "msgsource").get(".msgsource.watch_msg_source_type");
        try
        {
          i = Integer.valueOf(parama1).intValue();
          if ((i > 0) && (i <= 4))
          {
            parama.vAY.setVisibility(0);
            return;
            localObject = null;
            continue;
            if ((parambi != null) && (((com.tencent.mm.ui.chatting.b.b.c)parama1.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG()))
            {
              localObject = new aw(parambi.field_bizChatUserId, null);
              com.tencent.mm.ui.chatting.b.b.c localc = (com.tencent.mm.ui.chatting.b.b.c)parama1.ac(com.tencent.mm.ui.chatting.b.b.c.class);
              o.ON().a(localc.lt(parambi.field_bizChatUserId), parama.doU, ((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDz());
              break label106;
            }
            if (parama1.cFE()) {
              localObject = parama1.getTalkerUserName();
            }
            localObject = new aw(paramString, (String)localObject);
            r(parama.doU, paramString);
            break label106;
            label459:
            this.vAP = new t.b(parama1);
            this.vAQ = new t.c(parama1);
          }
        }
        catch (Exception parama1)
        {
          for (;;)
          {
            int i = 0;
          }
          parama.vAY.setVisibility(8);
          return;
        }
      }
    }
    parama.vAY.setVisibility(8);
  }
  
  public abstract boolean a(ContextMenu paramContextMenu, View paramView, bi parambi);
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi);
  
  public final boolean a(com.tencent.mm.ui.chatting.c.a parama, g.a parama1, bi parambi)
  {
    if (bk.bl(parama1.dSP)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.vgc, parambi, parama1.dSW, parama1.dSV);
    String str = parambi.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("IsAd", false);
    localIntent.putExtra("KStremVideoUrl", parama1.dSP);
    localIntent.putExtra("KThumUrl", parama1.dSU);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", parama1.dSV);
    localIntent.putExtra("KSta_StremVideoPublishId", parama1.dSW);
    localIntent.putExtra("KSta_SourceType", 2);
    if (parama.cFE()) {}
    for (int i = com.tencent.mm.ui.chatting.a.b.vgl.value;; i = com.tencent.mm.ui.chatting.a.b.vgk.value)
    {
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", b(parama, parambi));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", parambi.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", parama1.bYN);
      if (parama.cFE()) {
        localIntent.putExtra("KSta_ChatroomMembercount", m.gM(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + parambi.field_msgId);
      localIntent.putExtra("KMediaVideoTime", parama1.dSQ);
      localIntent.putExtra("StremWebUrl", parama1.dST);
      localIntent.putExtra("StreamWording", parama1.dSS);
      localIntent.putExtra("KMediaTitle", parama1.title);
      d.b(parama.vtz.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
      return true;
    }
  }
  
  public abstract boolean au(int paramInt, boolean paramBoolean);
  
  public String b(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    Object localObject;
    if (bfO()) {
      localObject = parama.cFB();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.cFE())
    {
      parama = bd.iI(parambi.field_content);
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
  
  protected final void b(com.tencent.mm.ui.chatting.c.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.vAS == null) {
      this.vAS = new t.g(parama);
    }
    paramView.setOnClickListener(this.vAS);
  }
  
  public abstract boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi);
  
  protected boolean b(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (bfO()) {
      return false;
    }
    return (parama.cFE()) || (((com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG());
  }
  
  abstract boolean bfO();
  
  protected final c.c c(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (this.vAM == null) {
      this.vAM = new c.c(this, parama);
    }
    return this.vAM;
  }
  
  protected boolean cHb()
  {
    return true;
  }
  
  protected boolean cHd()
  {
    return true;
  }
  
  protected final c.d d(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (this.vAN == null)
    {
      if (!(parama.vtz instanceof AppBrandServiceChattingUI.a)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.a)parama.vtz;
    }
    label47:
    for (this.vAN = new AppBrandServiceChattingUI.a.6(parama, parama.byx, this);; this.vAN = new c.d(parama, this)) {
      return this.vAN;
    }
  }
  
  protected final t.b e(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (this.vAP == null) {
      this.vAP = new t.b(parama);
    }
    return this.vAP;
  }
  
  protected final t.c f(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (this.vAQ == null) {
      this.vAQ = new t.c(parama);
    }
    return this.vAQ;
  }
  
  protected final t.o g(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (this.vAR == null) {
      this.vAR = new t.o(parama);
    }
    return this.vAR;
  }
  
  protected final t.j h(com.tencent.mm.ui.chatting.c.a parama)
  {
    if (this.vAT == null) {
      this.vAT = new t.j(parama);
    }
    return this.vAT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */