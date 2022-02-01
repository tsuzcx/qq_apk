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
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.am.h.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.da.a;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qj.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.g.c.y;
import com.tencent.mm.m.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.ui.chat.l.a;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.ae;
import com.tencent.mm.ui.chatting.c.b.aa;
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
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import java.util.LinkedList;
import java.util.Map;

public abstract class c
{
  private static boolean GzV = false;
  private static long GzW = 0L;
  private c GHH;
  private a.f GHI;
  private d GHJ;
  private boolean GHK = false;
  protected s.b GHL;
  protected s.d GHM;
  protected s.c GHN;
  protected s.p GHO;
  protected s.h GHP;
  protected s.k GHQ;
  protected s.e GHR;
  private final long GHS = 120000L;
  private final long GHT = 10800000L;
  public boolean GjM;
  protected boolean nMt;
  
  public static void A(ImageView paramImageView, String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(2131231342);
      return;
    }
    com.tencent.mm.pluginsdk.ui.a.b.d(paramImageView, paramString);
  }
  
  public static String a(bl parambl, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = null;
    String str2 = null;
    if (parambl == null) {
      return str2;
    }
    if (parambl.field_isSend == 1) {
      return u.aqG();
    }
    if (paramBoolean1) {
      str1 = com.tencent.mm.model.bi.uf(parambl.field_content);
    }
    for (;;)
    {
      str2 = str1;
      if (!bt.isNullOrNil(str1)) {
        break;
      }
      return parambl.field_talker;
      if (paramBoolean2) {
        str1 = parambl.field_bizChatUserId;
      }
    }
  }
  
  public static void a(bl parambl, EmojiInfo paramEmojiInfo)
  {
    da localda = new da();
    localda.dfi.dfj = paramEmojiInfo;
    paramEmojiInfo = localda.dfi.dfj;
    if (parambl != null) {}
    for (parambl = parambl.field_talker;; parambl = null)
    {
      paramEmojiInfo.talker = parambl;
      localda.dfi.scene = 0;
      com.tencent.mm.sdk.b.a.ESL.l(localda);
      return;
    }
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, bl parambl, k.b paramb, String paramString, long paramLong)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aAN(paramb.appId))
    {
      paramView.setTag(new l.b());
      return;
    }
    if (parama.eZb()) {}
    for (int i = 2;; i = 1)
    {
      l.a locala = new l.a();
      locala.appId = paramb.appId;
      locala.dvh = "message";
      locala.dvP = paramString;
      locala.dvQ = d(parama, parambl);
      locala.Cgv = paramb.type;
      locala.scene = i;
      locala.Cgw = paramb.mediaTagName;
      locala.drA = paramLong;
      locala.Cgx = parama.getTalkerUserName();
      a(parama, paramView, locala);
      return;
    }
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWr());
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, String paramString)
  {
    if (!com.tencent.mm.pluginsdk.model.app.h.aAN(paramString))
    {
      paramView.setTag(new l.b());
      return;
    }
    l.b localb = new l.b();
    localb.appId = paramString;
    localb.dvh = "message";
    a(parama, paramView, localb);
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.GzJ.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramImageView.setImageDrawable(paramBitmap);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, ImageView paramImageView, String paramString)
  {
    if ((bt.kU("wx485a97c844086dc9", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690438);
      ((WeImageView)paramImageView).setIconColor(parama.GzJ.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((bt.kU("wxaf060266bfa9a35c", paramString)) && ((paramImageView instanceof WeImageView)))
    {
      paramImageView.setImageResource(2131690670);
      ((WeImageView)paramImageView).setIconColor(parama.GzJ.getContext().getResources().getColor(2131099734));
      return;
    }
    if ((paramImageView instanceof WeImageView)) {
      ((WeImageView)paramImageView).setIconColor(parama.GzJ.getContext().getResources().getColor(2131101053));
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cd.a.getDensity(parama.GzJ.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramImageView, paramString);
      return;
    }
    a(parama, paramImageView, BitmapFactory.decodeResource(parama.GzJ.getMMResources(), 2131233479));
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, Bitmap paramBitmap)
  {
    paramBitmap = new BitmapDrawable(paramBitmap);
    int i = (int)parama.GzJ.getMMResources().getDimension(2131165576);
    paramBitmap.setBounds(0, 0, i, i);
    paramTextView.setCompoundDrawables(paramBitmap, null, null, null);
  }
  
  protected static void a(com.tencent.mm.ui.chatting.d.a parama, TextView paramTextView, String paramString)
  {
    paramString = com.tencent.mm.pluginsdk.model.app.h.c(paramString, 2, com.tencent.mm.cd.a.getDensity(parama.GzJ.getContext()));
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      a(parama, paramTextView, paramString);
      return;
    }
    a(parama, paramTextView, BitmapFactory.decodeResource(parama.GzJ.getMMResources(), 2131233479));
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, int paramInt, String paramString2)
  {
    int j;
    int i;
    label53:
    label64:
    qj localqj;
    qj.a locala;
    if (parama.eZb())
    {
      j = 2;
      i = paramInt;
      if (paramInt == -1)
      {
        if (paramb.type != 7) {
          break label253;
        }
        if ((paramg == null) || (!com.tencent.mm.pluginsdk.model.app.q.t(parama.GzJ.getContext(), paramg.field_packageName))) {
          break label246;
        }
        i = 0;
      }
      if (paramb.type != 2) {
        break label259;
      }
      i = 4;
      localqj = new qj();
      localqj.dvV.context = parama.GzJ.getContext();
      localqj.dvV.scene = j;
      localqj.dvV.dlB = paramb.appId;
      locala = localqj.dvV;
      if (paramg != null) {
        break label273;
      }
    }
    label259:
    label273:
    for (parama = null;; parama = paramg.field_packageName)
    {
      locala.packageName = parama;
      localqj.dvV.msgType = paramb.type;
      localqj.dvV.dpv = paramString1;
      localqj.dvV.dvW = i;
      localqj.dvV.mediaTagName = paramb.mediaTagName;
      localqj.dvV.drA = paramLong;
      localqj.dvV.dvX = "";
      localqj.dvV.dbt = paramString2;
      parama = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (parama != null) {
        localqj.dvV.dvY = parama.dvY;
      }
      com.tencent.mm.sdk.b.a.ESL.l(localqj);
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
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, String paramString1, com.tencent.mm.pluginsdk.model.app.g paramg, long paramLong, String paramString2)
  {
    a(parama, paramb, paramString1, paramg, paramLong, -1, paramString2);
  }
  
  private void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, bl parambl)
  {
    if (this.GHK) {}
    do
    {
      return;
      this.GHK = true;
    } while (((parama1.GzJ instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (w.sz(parama1.getTalkerUserName())));
    if ((parambl != null) && (!bt.isNullOrNil(parambl.ePb))) {
      this.GHL = new s.a(parama1);
    }
    for (;;)
    {
      parama.GHW.setOnClickListener(this.GHL);
      parama.GHW.setOnLongClickListener(this.GHM);
      return;
      this.GHL = new s.b(parama1);
      this.GHM = new s.d(parama1);
    }
  }
  
  protected static void a(a parama, CharSequence paramCharSequence)
  {
    if ((parama == null) || (parama.wet == null)) {
      return;
    }
    if (paramCharSequence == null)
    {
      parama.wet.setVisibility(8);
      return;
    }
    parama.wet.setText(paramCharSequence);
    parama.wet.setVisibility(0);
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.c.b.i parami, long paramLong)
  {
    return (paramLong > 0L) && (parami.eWt() == paramLong);
  }
  
  protected static boolean a(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cBi();
    if ((!com.tencent.mm.pluginsdk.model.app.h.a(parama.GzJ.getContext(), paramg)) && (localb != null))
    {
      if (!bt.isNullOrNil(paramg.eom))
      {
        boolean bool = r.bK(parama.GzJ.getContext(), paramg.eom);
        ad.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { paramg.eom, Boolean.valueOf(bool) });
        if (bool) {
          return true;
        }
      }
      if (parama.eZb()) {}
      for (int i = 2;; i = 1)
      {
        ho localho = new ho();
        localho.dlk.actionCode = 2;
        localho.dlk.scene = i;
        localho.dlk.appId = paramg.field_appId;
        localho.dlk.context = parama.GzJ.getContext();
        com.tencent.mm.sdk.b.a.ESL.l(localho);
        parama.GzJ.getContext();
        localb.ag(paramg.field_appId, i, i);
        return true;
      }
    }
    return false;
  }
  
  protected static boolean aKZ(String paramString)
  {
    return ((!w.sQ(paramString)) && (!w.tg(paramString)) && (!w.sE(paramString)) && (!w.tp(paramString))) || (w.pF(paramString));
  }
  
  protected static void b(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, bl parambl)
  {
    com.tencent.mm.plugin.game.api.b localb = com.tencent.mm.plugin.game.api.b.a.cBi();
    if (localb != null) {
      if (!parama.eZb()) {
        break label94;
      }
    }
    label94:
    for (int i = 2;; i = 1)
    {
      String str = d(parama, parambl);
      int j = 0;
      com.tencent.mm.pluginsdk.ui.tools.c localc = (com.tencent.mm.pluginsdk.ui.tools.c)paramb.ao(com.tencent.mm.pluginsdk.ui.tools.c.class);
      if (localc != null) {
        j = localc.dvY;
      }
      parama.GzJ.getContext();
      localb.a(paramb.appId, str, paramb.type, i, paramb.mediaTagName, parambl.field_msgSvrId, parama.getTalkerUserName(), j);
      return;
    }
  }
  
  protected static boolean b(bl parambl, com.tencent.mm.ui.chatting.d.a parama)
  {
    long l1 = parambl.field_createTime;
    long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pwl, 120000L);
    if (parambl.cxB())
    {
      k.b localb = k.b.rx(parambl.field_content);
      if ((localb != null) && (localb.type == 6))
      {
        ad.i("MicroMsg.ChattingItem", "File revoke time is ：%s", new Object[] { Long.valueOf(l2) });
        if (ce.asR() - l1 > l2) {
          i = 1;
        }
      }
    }
    while (i != 0)
    {
      ad.i("MicroMsg.ChattingItem", "isRevokeExpire, msg talker: %s, svr id: %s.", new Object[] { parambl.field_talker, Long.valueOf(parambl.field_msgSvrId) });
      return false;
      i = 0;
      continue;
      if (ce.asR() - l1 > 120000L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((parama != null) && (parama.getTalkerUserName().equals(parama.eYX())) && (parambl.field_status == 2)) {
      return false;
    }
    int i = com.tencent.mm.m.g.Zd().getInt("ShowRevokeMsgEntry", 1);
    ad.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", new Object[] { Integer.valueOf(i) });
    return 1 == i;
  }
  
  protected static String c(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    parambl = parambl.field_talker;
    parama = (com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class);
    if ((parama.eWC()) && (parama.eWA() != null)) {
      return parama.eWA().field_bizChatServId;
    }
    return parambl;
  }
  
  protected static void c(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    paramView.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.i)parama.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWs());
  }
  
  public static String d(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    String str = parama.getTalkerUserName();
    parama = str;
    if (w.pF(str)) {
      parama = com.tencent.mm.model.bi.uf(parambl.field_content);
    }
    return parama;
  }
  
  protected static boolean eM(String paramString)
  {
    return com.tencent.mm.pluginsdk.model.app.h.eM(paramString);
  }
  
  protected static boolean faG()
  {
    String str = com.tencent.mm.m.g.Zd().getValue("ShowSendOK");
    if (bt.isNullOrNil(str)) {}
    for (int i = 0; 1 == i; i = bt.aGh(str)) {
      return true;
    }
    return false;
  }
  
  private s.c g(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.GHN == null) {
      this.GHN = new s.c(parama);
    }
    return this.GHN;
  }
  
  protected static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.j(paramString, true, false);
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
  
  public static int jP(Context paramContext)
  {
    float f = com.tencent.mm.cd.a.dT(paramContext);
    if (f == com.tencent.mm.cd.a.hE(paramContext)) {
      return com.tencent.mm.cd.a.ap(paramContext, 2131166039);
    }
    if (f == com.tencent.mm.cd.a.hG(paramContext)) {
      return com.tencent.mm.cd.a.ap(paramContext, 2131166032);
    }
    if (f == com.tencent.mm.cd.a.hH(paramContext)) {
      return com.tencent.mm.cd.a.ap(paramContext, 2131166040);
    }
    if (f == com.tencent.mm.cd.a.hI(paramContext)) {
      return com.tencent.mm.cd.a.ap(paramContext, 2131166021);
    }
    if ((f == com.tencent.mm.cd.a.hJ(paramContext)) || (f == com.tencent.mm.cd.a.hK(paramContext)) || (f == com.tencent.mm.cd.a.hL(paramContext))) {
      return com.tencent.mm.cd.a.ap(paramContext, 2131166022);
    }
    return com.tencent.mm.cd.a.ap(paramContext, 2131166038);
  }
  
  public static int jQ(Context paramContext)
  {
    float f = com.tencent.mm.cd.a.dT(paramContext);
    if ((f != com.tencent.mm.cd.a.hE(paramContext)) && (f != com.tencent.mm.cd.a.hG(paramContext)))
    {
      if (f == com.tencent.mm.cd.a.hH(paramContext)) {
        return com.tencent.mm.cd.a.ap(paramContext, 2131166020);
      }
      if (f == com.tencent.mm.cd.a.hI(paramContext)) {
        return com.tencent.mm.cd.a.ap(paramContext, 2131166018);
      }
      if ((f == com.tencent.mm.cd.a.hJ(paramContext)) || (f == com.tencent.mm.cd.a.hK(paramContext)) || (f == com.tencent.mm.cd.a.hL(paramContext))) {
        return com.tencent.mm.cd.a.ap(paramContext, 2131166022);
      }
    }
    return com.tencent.mm.cd.a.ap(paramContext, 2131166019);
  }
  
  public static void t(Intent paramIntent, String paramString)
  {
    if ((w.sx(paramString)) || (w.sy(paramString))) {
      paramIntent.putExtra(e.m.FIC, true);
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
    if (this.GHI == null) {
      this.GHI = new e(paramc);
    }
    return this.GHI;
  }
  
  protected final void a(int paramInt, a parama, bl parambl, String paramString, boolean paramBoolean, com.tencent.mm.ui.chatting.d.a parama1, final s.n paramn)
  {
    if (parambl.field_isSend == 1)
    {
      parama.GHZ.setTag(new bi(parambl, paramBoolean, paramInt, paramString, '\000'));
      paramString = parama.GHZ;
      if (this.GHR == null) {
        this.GHR = new s.e(parama1)
        {
          public final void a(View paramAnonymousView, com.tencent.mm.ui.chatting.d.a paramAnonymousa, bl paramAnonymousbl)
          {
            AppMethodBeat.i(36730);
            paramn.a(paramAnonymousa, paramAnonymousbl);
            AppMethodBeat.o(36730);
          }
        };
      }
      paramString.setOnClickListener(this.GHR);
      switch (parambl.field_status)
      {
      default: 
        ad.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
        paramInt = -1;
      }
    }
    while (paramInt != -1)
    {
      parama.GHZ.setImageResource(2131234176);
      parama.GHZ.setVisibility(0);
      parama.GHZ.setContentDescription(aj.getContext().getString(2131761358));
      if (parama.uPp != null) {
        parama.uPp.setVisibility(8);
      }
      return;
      paramInt = -1;
      continue;
      paramInt = 2131234176;
    }
    parama.GHZ.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean, long paramLong1, long paramLong2, bl parambl)
  {
    if (((paramString1 == null) || (paramString1.length() == 0)) && ((paramString2 == null) || (paramString2.length() == 0)))
    {
      ad.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
      return;
    }
    String str;
    if (ay.isMobile(parama.GzJ.getContext()))
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
      paramString1.putExtra("pre_username", b(parama, parambl));
      paramString1.putExtra("prePublishId", "msg_" + Long.toString(paramLong2));
      if (parambl != null) {
        paramString1.putExtra("preUsername", b(parama, parambl));
      }
      paramString1.putExtra("preChatName", parama.getTalkerUserName());
      paramString1.putExtra("preChatTYPE", x.aw(b(parama, parambl), parama.getTalkerUserName()));
      paramString1.putExtra("preMsgIndex", 0);
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
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
  
  public final void a(a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl)
  {
    long l1 = GzW;
    long l2 = System.currentTimeMillis();
    GzW = l2;
    if (l1 + 30000L < l2)
    {
      az.arV();
      GzV = com.tencent.mm.model.c.isSDCardAvailable();
    }
    this.nMt = GzV;
    String str = null;
    if (faD())
    {
      str = b(parama1, parambl);
      a(parama, parama1, parambl, str);
      a(parama, parama1, str, parambl);
    }
    a(parama, paramInt, parama1, parambl, str);
    if ((parama1.zgX != null) && (parama1.zgX.eKB()))
    {
      parama = ((com.tencent.mm.ui.chatting.c.b.d)parama1.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWz();
      if ((parama != null) && (parama.Jb()))
      {
        int i = ((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).getCount();
        l1 = ((com.tencent.mm.ui.chatting.c.b.d)parama1.be(com.tencent.mm.ui.chatting.c.b.d.class)).QU();
        com.tencent.mm.am.k.a(parama1.zgX, parambl, paramInt, i, l1);
      }
    }
  }
  
  public abstract void a(a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString);
  
  protected void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    if ((paramString == null) || (parama.wet == null) || (parambl == null)) {
      return;
    }
    String str;
    if ((parambl.field_isSend == 0) && (!bt.isNullOrNil(parambl.ePb)))
    {
      com.tencent.mm.am.g localg = com.tencent.mm.am.af.awd().wR(parambl.ePb);
      int i = 1;
      if ((localg != null) && (!bt.isNullOrNil(localg.field_openId)) && (!bt.isNullOrNil(localg.field_nickname)))
      {
        str = localg.field_nickname;
        i = 0;
        if (i == 0)
        {
          paramString = str;
          if (!com.tencent.mm.am.i.a(localg)) {}
        }
        else
        {
          com.tencent.mm.am.af.awf().a(new b(parama1, parambl.ePb));
          com.tencent.mm.am.af.awf().k(parama1.getTalkerUserName(), parambl.ePb, parambl.ePh);
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
      if ((b(parama1)) && (((com.tencent.mm.ui.chatting.c.b.f)parama1.be(com.tencent.mm.ui.chatting.c.b.f.class)).eWU()))
      {
        if (((com.tencent.mm.ui.chatting.c.b.d)parama1.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD())
        {
          parambl = ((com.tencent.mm.ui.chatting.c.b.f)parama1.be(com.tencent.mm.ui.chatting.c.b.f.class)).aKG(parambl.field_bizChatUserId);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.GzJ.getContext(), parambl, parama.wet.getTextSize());
        }
        else
        {
          parambl = ((com.tencent.mm.ui.chatting.c.b.f)parama1.be(com.tencent.mm.ui.chatting.c.b.f.class)).aKG(paramString);
          paramString = com.tencent.mm.pluginsdk.ui.span.k.b(parama1.GzJ.getContext(), parambl, parama.wet.getTextSize());
        }
      }
      else {
        paramString = null;
      }
    }
  }
  
  protected final void a(a parama, com.tencent.mm.ui.chatting.d.a parama1, String paramString, bl parambl)
  {
    Object localObject1 = null;
    if (parama.GHW == null) {
      return;
    }
    if ((w.to(paramString)) && (!paramString.equals(w.gMw[0])))
    {
      parama.GHW.setVisibility(8);
      return;
    }
    Object localObject2;
    if ((parambl != null) && (!bt.isNullOrNil(parambl.ePb)))
    {
      localObject2 = new com.tencent.mm.ak.b();
      ((com.tencent.mm.ak.b)localObject2).gTh = false;
      ((com.tencent.mm.ak.b)localObject2).gTi = com.tencent.mm.pluginsdk.ui.a.mVi;
      if (parama1.eZb()) {
        localObject1 = parama1.getTalkerUserName();
      }
    }
    for (;;)
    {
      localObject1 = new bi(paramString, (String)localObject1);
      ((bi)localObject1).GQT = parambl.ePb;
      ((bi)localObject1).gNZ = parambl.ePh;
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.GHW, parambl.ePb, 2131231203, (com.tencent.mm.ak.b)localObject2);
      if (com.tencent.mm.am.g.F(parambl)) {
        com.tencent.mm.am.af.awf().avP();
      }
      label155:
      parama.GHW.setVisibility(0);
      parama.GHW.setTag(localObject1);
      a(parama, parama1, parambl);
      if (!faE()) {
        ((ae)parama1.be(ae.class)).a(parama.GHW);
      }
      parama.GHW.setOnDoubleClickListener(g(parama1));
      com.tencent.mm.ui.chatting.q.dP(parama.GHW);
      parama.GHW.setContentDescription(v.sh(paramString) + parama1.GzJ.getContext().getString(2131756087));
      parama.GHW.eE(paramString, 5);
      if (parama.GHX == null) {
        break;
      }
      if ((parambl != null) && (parambl.esh != null) && (parambl.esh.contains("watch_msg_source_type")))
      {
        parama1 = (String)bw.K(parambl.esh, "msgsource").get(".msgsource.watch_msg_source_type");
        try
        {
          i = Integer.valueOf(parama1).intValue();
          if ((i > 0) && (i <= 4))
          {
            parama.GHX.setVisibility(0);
            return;
            localObject1 = null;
            continue;
            if ((parambl != null) && (((com.tencent.mm.ui.chatting.c.b.d)parama1.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC()))
            {
              localObject1 = new bi(parambl.field_bizChatUserId, null);
              localObject2 = (com.tencent.mm.ui.chatting.c.b.d)parama1.be(com.tencent.mm.ui.chatting.c.b.d.class);
              o.ayJ().a(((com.tencent.mm.ui.chatting.c.b.d)localObject2).xn(parambl.field_bizChatUserId), parama.GHW, ((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWu());
              break label155;
            }
            if ((parambl != null) && (parambl.field_isSend == 0) && (parama1.be(com.tencent.mm.ui.chatting.c.b.a.class) != null) && (!bt.isNullOrNil(((com.tencent.mm.ui.chatting.c.b.a)parama1.be(com.tencent.mm.ui.chatting.c.b.a.class)).eYV())))
            {
              localObject1 = new bi(paramString, null);
              o.ayJ().a(((com.tencent.mm.ui.chatting.c.b.a)parama1.be(com.tencent.mm.ui.chatting.c.b.a.class)).eYV(), parama.GHW, ((com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWu());
              break label155;
            }
            if (parama1.eZb()) {
              localObject1 = parama1.getTalkerUserName();
            }
            localObject1 = new bi(paramString, (String)localObject1);
            z(parama.GHW, paramString);
          }
        }
        catch (Exception parama1)
        {
          for (;;)
          {
            int i = 0;
          }
          parama.GHX.setVisibility(8);
          return;
        }
      }
    }
    parama.GHX.setVisibility(8);
  }
  
  public abstract boolean a(ContextMenu paramContextMenu, View paramView, bl parambl);
  
  public abstract boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl);
  
  protected boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, bl parambl)
  {
    if (bt.isNullOrNil(paramb.gJv)) {
      return false;
    }
    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.Gjk, parambl, paramb.gJC, paramb.gJB);
    String str = parambl.field_imgPath;
    Intent localIntent = new Intent();
    localIntent.putExtra("KFromTimeLine", false);
    localIntent.putExtra("KStremVideoUrl", paramb.gJv);
    localIntent.putExtra("KThumUrl", paramb.gJA);
    localIntent.putExtra("KThumbPath", str);
    localIntent.putExtra("KSta_StremVideoAduxInfo", paramb.gJB);
    localIntent.putExtra("KSta_StremVideoPublishId", paramb.gJC);
    localIntent.putExtra("KSta_SourceType", 2);
    int i;
    if (parama.eZb())
    {
      i = com.tencent.mm.ui.chatting.a.b.Gjt.value;
      localIntent.putExtra("KSta_Scene", i);
      localIntent.putExtra("KSta_FromUserName", b(parama, parambl));
      localIntent.putExtra("KSta_ChatName", parama.getTalkerUserName());
      localIntent.putExtra("KSta_MsgId", parambl.field_msgSvrId);
      localIntent.putExtra("KSta_SnsStatExtStr", paramb.dxG);
      if (parama.eZb()) {
        localIntent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.q.rY(parama.getTalkerUserName()));
      }
      localIntent.putExtra("KMediaId", "fakeid_" + parambl.field_msgId);
      localIntent.putExtra("KMediaVideoTime", paramb.gJw);
      localIntent.putExtra("StremWebUrl", paramb.gJz);
      localIntent.putExtra("StreamWording", paramb.gJy);
      localIntent.putExtra("KMediaTitle", paramb.title);
      if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pjp, 0) != 0) {
        break label370;
      }
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", localIntent);
      ad.i("MicroMsg.ChattingItem", "use new stream video play UI");
    }
    for (;;)
    {
      return true;
      i = com.tencent.mm.ui.chatting.a.b.Gjs.value;
      break;
      label370:
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "sns", ".ui.VideoAdPlayerUI", localIntent);
    }
  }
  
  public abstract boolean aX(int paramInt, boolean paramBoolean);
  
  public String b(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    Object localObject;
    if (faE()) {
      localObject = parama.eYX();
    }
    String str;
    do
    {
      return localObject;
      str = parama.getTalkerUserName();
      localObject = str;
    } while (!b(parama));
    if (parama.eZb())
    {
      parama = com.tencent.mm.model.bi.uf(parambl.field_content);
      if ((str == null) || (parama == null) || (parama.length() <= 0)) {
        break label76;
      }
    }
    for (;;)
    {
      return parama;
      if (parambl != null) {
        parama = parambl.field_bizChatUserId;
      } else {
        label76:
        parama = str;
      }
    }
  }
  
  protected final void b(com.tencent.mm.ui.chatting.d.a parama, View paramView, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (this.GHP == null) {
      this.GHP = new s.h(parama);
    }
    paramView.setOnClickListener(this.GHP);
  }
  
  public abstract boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl);
  
  protected boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (faE()) {
      return false;
    }
    return (parama.eZb()) || (((com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC());
  }
  
  protected final c c(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.GHH == null) {
      this.GHH = new c(parama);
    }
    return this.GHH;
  }
  
  protected final d d(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.GHJ == null)
    {
      if (!(parama.GzJ instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
        break label47;
      }
      parama = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)parama.GzJ;
    }
    label47:
    for (this.GHJ = new AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3(parama, parama.cOd, this);; this.GHJ = new d(parama, this)) {
      return this.GHJ;
    }
  }
  
  protected final s.b e(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.GHL == null) {
      this.GHL = new s.b(parama);
    }
    return this.GHL;
  }
  
  protected final s.d f(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.GHM == null) {
      this.GHM = new s.d(parama);
    }
    return this.GHM;
  }
  
  protected boolean faD()
  {
    return true;
  }
  
  public abstract boolean faE();
  
  boolean faF()
  {
    return true;
  }
  
  protected boolean faH()
  {
    return true;
  }
  
  protected final s.p h(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.GHO == null) {
      this.GHO = new s.p(parama);
    }
    return this.GHO;
  }
  
  protected final s.k i(com.tencent.mm.ui.chatting.d.a parama)
  {
    if (this.GHQ == null) {
      this.GHQ = new s.k(parama);
    }
    return this.GHQ;
  }
  
  public static class a
  {
    public AvatarImageView GHW;
    public ViewStub GHX;
    public View GHY;
    public ImageView GHZ;
    public String GIa;
    public c GIb;
    public TextView fwS;
    public CheckBox hIS;
    public View lRB;
    public View naN;
    public View rLd;
    public ProgressBar uPp;
    public TextView wet;
    
    public static void aE(View paramView, int paramInt)
    {
      AppMethodBeat.i(36734);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(paramInt / com.tencent.mm.ce.a.eCR()));
        paramView.setLayoutParams(localLayoutParams);
        paramView.requestLayout();
      }
      AppMethodBeat.o(36734);
    }
    
    public final void fK(View paramView)
    {
      AppMethodBeat.i(36732);
      this.rLd = paramView;
      this.fwS = ((TextView)paramView.findViewById(2131298178));
      this.GHW = ((AvatarImageView)paramView.findViewById(2131298056));
      this.GHY = paramView.findViewById(2131298104);
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.naN = paramView.findViewById(2131298069);
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.GHX = null;
      AppMethodBeat.o(36732);
    }
    
    public final void setChattingBG(boolean paramBoolean)
    {
      AppMethodBeat.i(36731);
      if (this.GHW != null) {
        this.GHW.setChattingBG(paramBoolean);
      }
      AppMethodBeat.o(36731);
    }
    
    public final void wp(boolean paramBoolean)
    {
      AppMethodBeat.i(36733);
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        if ((this.hIS != null) && (this.hIS.getVisibility() != i)) {
          this.hIS.setVisibility(i);
        }
        if ((this.lRB != null) && (this.lRB.getVisibility() != i)) {
          this.lRB.setVisibility(i);
        }
        AppMethodBeat.o(36733);
        return;
      }
    }
  }
  
  static final class b
    implements h.b
  {
    private String ASg;
    com.tencent.mm.ui.chatting.d.a cOd;
    
    protected b(com.tencent.mm.ui.chatting.d.a parama, String paramString)
    {
      this.ASg = paramString;
      this.cOd = parama;
    }
    
    public final String avQ()
    {
      return this.ASg;
    }
    
    public final void e(LinkedList<dtt> paramLinkedList)
    {
      int k = 0;
      AppMethodBeat.i(36736);
      com.tencent.mm.am.af.awf().b(this);
      ad.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
      int i;
      if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
      {
        ad.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.ASg });
        if (this.cOd != null)
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
                c.b.this.cOd.bCM();
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
        dtt localdtt = (dtt)paramLinkedList.get(j);
        if ((localdtt != null) && (!bt.isNullOrNil(localdtt.EIs)) && (localdtt.EIs.equals(this.ASg)))
        {
          ad.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
          if (!bt.isNullOrNil(localdtt.Nickname))
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
    a.f GHI;
    private View.OnCreateContextMenuListener GId;
    private a GIe;
    private View GIf;
    Object GIg;
    com.tencent.mm.ui.chatting.d.a Gob;
    com.tencent.mm.ui.widget.b.a GqT;
    private PopupWindow.OnDismissListener acL;
    private int mUE;
    private int mUF;
    
    public c(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(36741);
      this.acL = new PopupWindow.OnDismissListener()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(36739);
          if (((c.c.this.GIg instanceof Boolean)) && (((Boolean)c.c.this.GIg).booleanValue()) && (com.tencent.mm.ui.a.a.a.eSf().eSe()) && (c.c.c(c.c.this) != null)) {
            c.c.c(c.c.this).dismiss();
          }
          c.c.b(c.c.this).setFocused(true);
          AppMethodBeat.o(36739);
        }
      };
      this.Gob = parama;
      this.GId = new View.OnCreateContextMenuListener()
      {
        public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(36737);
          paramAnonymousContextMenuInfo = (bi)paramAnonymousView.getTag();
          if (paramAnonymousContextMenuInfo == null)
          {
            AppMethodBeat.o(36737);
            return;
          }
          int i = paramAnonymousContextMenuInfo.position;
          paramAnonymousContextMenuInfo = paramAnonymousContextMenuInfo.drF;
          if (paramAnonymousContextMenuInfo == null)
          {
            ad.e("MicroMsg.ChattingItem", "msg is null!");
            AppMethodBeat.o(36737);
            return;
          }
          boolean bool = c.this.a(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
          if ((com.tencent.mm.storage.af.aHG(c.c.b(c.c.this).getTalkerUserName())) || (com.tencent.mm.storage.af.aHE(c.c.b(c.c.this).getTalkerUserName())))
          {
            ad.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
            paramAnonymousContextMenu.removeItem(116);
          }
          if (bool)
          {
            if (c.c.b(c.c.this).eZc()) {
              paramAnonymousContextMenu.add(i, 100, 0, paramAnonymousView.getContext().getString(2131757221));
            }
            if (((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.y(paramAnonymousContextMenuInfo)) && (c.this.faH()) && (c.c.b(c.c.this).eZc())) || (c.c.b(c.c.this).zgX.eKB())) {
              paramAnonymousContextMenu.add(i, 122, 0, c.c.b(c.c.this).GzJ.getMMResources().getString(2131757225));
            }
            if (paramAnonymousContextMenu.findItem(123) != null) {
              paramAnonymousContextMenu.removeItem(100);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.this.faF())) {
              c.c.a(c.c.this, paramAnonymousContextMenu, paramAnonymousContextMenuInfo, i);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.c.a(c.c.this, paramAnonymousContextMenuInfo))) {
              c.c.a(c.c.this, paramAnonymousContextMenu, i);
            }
            AppMethodBeat.o(36737);
            return;
          }
          if (paramAnonymousContextMenuInfo.eJO())
          {
            az.arV();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
              ((com.tencent.mm.ui.chatting.c.b.af)c.c.b(c.c.this).be(com.tencent.mm.ui.chatting.c.b.af.class)).a(paramAnonymousContextMenu, i, paramAnonymousContextMenuInfo);
            }
          }
          for (;;)
          {
            if (paramAnonymousContextMenuInfo.field_status == 5)
            {
              paramAnonymousContextMenu.add(i, 103, 0, c.c.b(c.c.this).GzJ.getMMResources().getString(2131757232));
              com.tencent.mm.aw.f.c(o.ayF().I(paramAnonymousContextMenuInfo));
            }
            if (paramAnonymousContextMenu.findItem(123) != null) {
              paramAnonymousContextMenu.removeItem(100);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.this.faF())) {
              c.c.a(c.c.this, paramAnonymousContextMenu, paramAnonymousContextMenuInfo, i);
            }
            if ((!bk.x(paramAnonymousContextMenuInfo)) && (!bk.z(paramAnonymousContextMenuInfo)) && (c.c.a(c.c.this, paramAnonymousContextMenuInfo))) {
              c.c.a(c.c.this, paramAnonymousContextMenu, i);
            }
            AppMethodBeat.o(36737);
            return;
            if (paramAnonymousContextMenuInfo.eLT()) {
              paramAnonymousContextMenu.add(i, 100, 0, c.c.b(c.c.this).GzJ.getMMResources().getString(2131757221));
            }
          }
        }
      };
      this.GIe = new a();
      AppMethodBeat.o(36741);
    }
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(36742);
      if ((paramView.getTag(2131306044) instanceof int[]))
      {
        int[] arrayOfInt = (int[])paramView.getTag(2131306044);
        u(paramView, arrayOfInt[0], arrayOfInt[1]);
      }
      for (;;)
      {
        AppMethodBeat.o(36742);
        return true;
        if (((this.mUE == 0) && (this.mUF == 0)) || (!this.GIf.equals(paramView))) {
          paramView.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(36738);
              c.c.a(c.c.this, (int)paramAnonymousMotionEvent.getRawX());
              c.c.b(c.c.this, (int)paramAnonymousMotionEvent.getRawY());
              c.c.a(c.c.this, paramAnonymousView);
              AppMethodBeat.o(36738);
              return false;
            }
          });
        } else {
          u(paramView, this.mUE, this.mUF);
        }
      }
    }
    
    final void u(View paramView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(36743);
      bi localbi = (bi)paramView.getTag();
      if (localbi == null)
      {
        ad.w("MicroMsg.ChattingItem", "open menu but tag is null");
        AppMethodBeat.o(36743);
        return;
      }
      this.GIe.GIj = localbi;
      if (this.GqT != null)
      {
        this.GqT.eVf();
        this.GqT = null;
      }
      this.GqT = new com.tencent.mm.ui.widget.b.a(this.Gob.GzJ.getContext());
      this.GIg = paramView.getTag(2131305626);
      if (((this.GIg instanceof Boolean)) && (((Boolean)this.GIg).booleanValue())) {
        if (!com.tencent.mm.ui.a.a.a.eSf().eSe()) {
          break label246;
        }
      }
      label246:
      for (this.GqT.HIy = true;; this.GqT.HIy = false)
      {
        this.GqT.HIz = true;
        this.GqT.Hua = this.acL;
        if (((localbi instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localbi).nBH) && (this.GHI != null)) {
          this.GHI.dismiss();
        }
        this.GqT.a(paramView, this.GId, this.GIe, paramInt1, paramInt2);
        if (this.Gob != null)
        {
          this.Gob.setFocused(false);
          this.Gob.wl(false);
          this.Gob.GzP = false;
        }
        AppMethodBeat.o(36743);
        return;
      }
    }
    
    final class a
      implements n.d
    {
      public bi GIj;
      
      a() {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(36740);
        if (this.GIj == null)
        {
          ad.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
          AppMethodBeat.o(36740);
          return;
        }
        if (((c.this instanceof av.a)) || ((c.this instanceof av.b))) {
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.GIj);
        }
        for (;;)
        {
          ((aa)c.c.b(c.c.this).be(aa.class)).a(paramMenuItem, c.this);
          if (c.c.c(c.c.this) != null) {
            c.c.c(c.c.this).dismiss();
          }
          AppMethodBeat.o(36740);
          return;
          c.this.a(paramMenuItem, c.c.b(c.c.this), this.GIj.drF);
        }
      }
    }
  }
  
  public static class d
    extends s.e
  {
    private c GIb;
    
    public d(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.GIb = paramc;
    }
    
    public void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(36747);
      paramView.getTag();
      this.GIb.b(paramView, parama, parambl);
      AppMethodBeat.o(36747);
    }
  }
  
  static final class e
    extends a.f
  {
    c.c GHH;
    
    e(c.c paramc)
    {
      this.GHH = paramc;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(36749);
      c.c localc = this.GHH;
      if ((localc.GqT != null) && (localc.GqT.eVf())) {
        localc.GqT = null;
      }
      AppMethodBeat.o(36749);
    }
    
    public final void fL(View paramView)
    {
      AppMethodBeat.i(36748);
      this.GHH.u(paramView, 0, 0);
      AppMethodBeat.o(36748);
    }
    
    public final void fM(View paramView)
    {
      AppMethodBeat.i(36750);
      this.GHH.onLongClick(paramView);
      AppMethodBeat.o(36750);
    }
    
    public final void faI()
    {
      AppMethodBeat.i(179940);
      c.c localc = this.GHH;
      if (localc.Gob != null) {
        localc.Gob.wl(true);
      }
      AppMethodBeat.o(179940);
    }
    
    public final void faJ()
    {
      AppMethodBeat.i(179941);
      c.c localc = this.GHH;
      if (localc.Gob != null) {
        localc.Gob.wl(false);
      }
      AppMethodBeat.o(179941);
    }
    
    public final void faK()
    {
      AppMethodBeat.i(179942);
      c.c localc = this.GHH;
      if (localc.Gob != null) {
        localc.Gob.setFocused(false);
      }
      AppMethodBeat.o(179942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c
 * JD-Core Version:    0.7.0.1
 */